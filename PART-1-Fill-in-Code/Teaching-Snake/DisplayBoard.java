/*  NO CODE MODIFICATION */ 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.sound.sampled.*;
import java.util.*;
public class DisplayBoard /* implements ActionListener */ {
    private int speedOfMovement;
    private JPanel mainPanel;
    private GameHandler gameLogic;
    private int gapSpacing = 5;
    public char mainType = 'o', follower = '.', target = 'x'; //MAKE SURE MATCHES GAME HANDLER.
    
    private Color currentPosColor = Color.black, followerColor = Color.gray,
    targetColor = Color.red, emptyColor = Color.white, backgroundColor = Color.lightGray;
    
    private int timeBetweenUpdates = 1; //Seconds
    private JLabel[][] guiBoard;
    private boolean isRunning = false;
    private Direction currentDirection; //For Part 2
    
    public DisplayBoard(int sizeOfBoard, Coordinate starting){
        gameLogic = new GameHandler(sizeOfBoard, starting);
        guiBoard = new JLabel[sizeOfBoard][sizeOfBoard];
        
        if(this.mainType != gameLogic.mainType
        || this.mainType != gameLogic.mainType
        || this.mainType != gameLogic.mainType) {
            System.out.println("ERRORS WILL OCCUR! BOARDS DEFINITIONS OF WHAT IS MAIN / FOLLOWER / TARGET");
            System.out.println("DO NOT MATCH IN DISPLAY BOARD AND GAME HANDLER CLASSES!! PLEASE CHANGE BACK!");
        }//If Statement
    }//DisplayBoard Constructor
    
    public void runGameBoard(){
        
        
        mainPanel.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch(keyCode) { 
                    case KeyEvent.VK_UP:
                        updateBoardAndConvert(Direction.NORTH); 
                        break;
                    case KeyEvent.VK_DOWN:
                        updateBoardAndConvert(Direction.SOUTH);  
                        break;
                    case KeyEvent.VK_LEFT:
                        updateBoardAndConvert(Direction.WEST);
                        break;
                    case KeyEvent.VK_RIGHT :
                        updateBoardAndConvert(Direction.EAST);
                        break;
                 }//Switch
                
            }//KeyPressed
        });
        
    }//runGameBoard
    
    public JPanel createContentPane(int size){
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(size,size,gapSpacing,gapSpacing));
        mainPanel.setVisible(true);
        mainPanel.setFocusable(true);
        mainPanel.requestFocusInWindow();
        mainPanel.setBackground(backgroundColor);
        
        for (int row = 0; row < guiBoard[0].length; row++){
            for(int col = 0; col < guiBoard[0].length; col++){
                guiBoard[row][col] = createJLabelSlot();
                mainPanel.add(guiBoard[row][col]);
            }//For Each Inner
        }//For Each
        
        
        
        return mainPanel;
    }//createContentPane
    
    public JLabel createJLabelSlot(){
        JLabel temp = new JLabel ();
        temp.setOpaque(true);
        temp.setBackground(emptyColor);
        
        return temp;
    }//CreateSlot
    
    public void updateBoardAndConvert(Direction direction){
        Coordinate[][] newLogicBoard = gameLogic.updateMovement(direction);
        
        for (int row = 0; row < guiBoard[0].length; row++){
            for(int col = 0; col < guiBoard[0].length; col++){
                if (newLogicBoard[row][col] == null)
                    guiBoard[row][col].setBackground(emptyColor);
                else if (newLogicBoard[row][col].type == mainType)
                    guiBoard[row][col].setBackground(currentPosColor);
                else if(newLogicBoard[row][col].type == follower)
                    guiBoard[row][col].setBackground(followerColor);
                else if(newLogicBoard[row][col].type == target)
                    guiBoard[row][col].setBackground(targetColor);
            }//For Each Inner
        }//For Each
        
    }//updateBoard
    
    
} //DisplayBoard Class
