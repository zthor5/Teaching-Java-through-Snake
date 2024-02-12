import java.util.ArrayList;
import java.util.Random;
public class GameHandler {
    
    //Fill With Code to work
    
    /**
     * BOARD
     * x --> that is a target. 
     * o --> that is the current main position.
     * . --> For Part 2..
     */
    public char mainType = 'o', follower = '.', target = 'x';
    
    
    private Coordinate[][] board;
    private int sizeOfBoard;
    private Direction startingHeading = Direction.NORTH;
    private int newlyAddedPoints = 0; //For Part 2
    
    
    
    /**
     * Constructor for objects of class GameHandler
     */
    public GameHandler(int sizeOfBoard, Coordinate startPos) {
        this.board = new Coordinate[sizeOfBoard][sizeOfBoard];
        this.sizeOfBoard = sizeOfBoard;
        board[startPos.x][startPos.y] = 
        new Coordinate(startPos.x,startPos.y,startingHeading, mainType);
        randomlyPlaceBlock();
    }//GameHandler Constructor

    /**
     * Getter for the private Cordinate[][] board
     */
    public Coordinate[][] getBoard(){
        return this.board;
    }//GetBoard
    
    /**
     * Will Clear the board of all Coordinates and restart all nessesary variable values
     */
    public void clearAndRestart(){
        //Used If the game is Failed.
        
        //For Part 2
        
    }//clearAndRestart
    
    /**
     * PART 1: Move the Main Point. It will wrap around to the other side if goes out of bounds.
     * PART 2: Set the Direction of the main point. 
     */
    public void moveUp(){
        //Move Up the Board.
        
        Coordinate temp = findCoordinatesOf(new Coordinate(mainType)).get(0);
        
        int tempX = (temp.x - 1 == -1) ? sizeOfBoard - 1 : temp.x - 1;
        
        board[temp.x][temp.y] = null;
        
        handleCollision(board[tempX][temp.y]);
        
        board[tempX][temp.y] =
        new Coordinate(tempX,temp.y, Direction.NORTH, 'o');
    }//MoveUp
    
    /**
     * PART 1: Move the Main Point. It will wrap around to the other side if goes out of bounds.
     * PART 2: Set the Direction of the main point. 
     */
    public void moveDown(){
        //Move Down the Board.
        
        Coordinate temp = findCoordinatesOf(new Coordinate(mainType)).get(0);
        board[temp.x][temp.y] = null;
        
        int tempX = (temp.x + 1 == sizeOfBoard) ? 0 : temp.x + 1;
        
        handleCollision(board[tempX][temp.y]);
        
        board[tempX][temp.y] =
        new Coordinate(tempX,temp.y, Direction.SOUTH, 'o');
    }//MoveDown
    
    /**
     * PART 1: Move the Main Point. It will wrap around to the other side if goes out of bounds.
     * PART 2: Set the Direction of the main point. 
     */
    public void moveRight(){
        //Move Right the Board.
        
        Coordinate temp = findCoordinatesOf(new Coordinate(mainType)).get(0);
        board[temp.x][temp.y] = null;
        
        int tempY = (temp.y + 1 == sizeOfBoard) ? 0 : temp.y + 1;
        
        handleCollision(board[temp.x][tempY]);
        
        board[temp.x][tempY] =
        new Coordinate(temp.x,tempY, Direction.EAST, 'o');
    }//MoveRight
    
    /**
     * PART 1: Move the Main Point. It will wrap around to the other side if goes out of bounds.
     * PART 2: Set the Direction of the main point. 
     */
    public void moveLeft(){
        //Move Left the Board.
        
        Coordinate temp = findCoordinatesOf(new Coordinate(mainType)).get(0);
        board[temp.x][temp.y] = null;
        
        int tempY = (temp.y - 1 == -1) ? sizeOfBoard - 1 : temp.y - 1;
        
        handleCollision(board[temp.x][tempY]);
        
        board[temp.x][tempY] =
        new Coordinate(temp.x,tempY, Direction.WEST, 'o');
    }//MoveLeft
    
    /**
     * Will Place a Target type coordinate on the board but not on top of the mainType (or follower type, To be used in Part 2)
     */
    public void randomlyPlaceBlock(){
        //Spawns a block somewhere on the game board
        
        Random rand = new Random();
        
        boolean isNotFreeSlot = true;
        while (isNotFreeSlot){
            int xCoord = rand.nextInt((sizeOfBoard));
            int yCoord = rand.nextInt((sizeOfBoard));
            if(board[xCoord][yCoord] == null) {
                board[xCoord][yCoord] = new Coordinate(target);
                isNotFreeSlot = false;
            }//If
        }//While Loop
    }//randomlyPlaceBlock
    
    /**
     * Will go through and move every Coordinate in the 2D array in the currently set Direction.
     */
    public void updateLocations() {
        //FOR PART 2
        
        //Update the point(s) around the board
        
        
    }//Update Location
    
    /**
     * Will search through 2d array Board and look for a matching type as passed.
     * If find a matching coordinate type, will use ArrayList to .add(that coordinate)
     */
    public ArrayList<Coordinate> findCoordinatesOf(Coordinate searchItem) {
        ArrayList<Coordinate> listOfSearched = new ArrayList<Coordinate>();
        
        for (int row = 0; row < board[0].length; row++){
            for(int col = 0; col < board[0].length; col++){
                if (board[row][col] == null) {}
                else if(board[row][col].equals(searchItem))
                    listOfSearched.add(board[row][col]);
            }//For Each Inner
        }//For Each
        
        return listOfSearched;
    }//findCoordinatesOf
    
    /**
     * Designed to see and handle if the main position is about to hit a target.
     */
    public void handleCollision(Coordinate possibleCollision) {
       //If there is a collision with a Target, make sure to increase newlyAddedPoints and call: randomlyPlaceBlock();
       if(possibleCollision == null) {} //Handles if slot is empty.
       else if (possibleCollision.type == target){
           System.out.println('\u000C' + "Current Points: " + ++newlyAddedPoints);
           randomlyPlaceBlock();
        }//else If
        //If Collision with a Follower, Restart Game. Part 2
       else if (possibleCollision.type == follower) clearAndRestart();
    }//handleCollision
    
    /**
     * This is called in DisplayBoard and passes the newest movement of the slot.
     * @return Coordinate[][] the updated board
     */
    public Coordinate[][] updateMovement(Direction direction){
        switch (direction) {
            case NORTH:
                moveUp();
                break;
                
            case SOUTH:
                moveDown();
                break;
                
            case EAST:
                moveRight();
                break;
                
            case WEST:
                moveLeft();
                break;
        }//Switch
        return board;
    }//updateMovement
    
    
}//GameHandler Class
