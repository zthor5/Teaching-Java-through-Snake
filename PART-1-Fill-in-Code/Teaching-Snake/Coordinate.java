/*  NO CODE MODIFICATION */ 
public class Coordinate {
    public int x;
    public int y;
    public char type;
    public Direction orientation;
    
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
        
    }
    
    public Coordinate(int x, int y, Direction orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
    
    public Coordinate(int x, int y, Direction orientation, char type){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.type = type;
    }
    
    /**
     * Used for Searching
     */
    public Coordinate(char type){
        this.type = type;
    }
    
    public boolean equals(Coordinate comparedItem){
       return this.type == comparedItem.type;
    }
    
}//Coordinate Class
