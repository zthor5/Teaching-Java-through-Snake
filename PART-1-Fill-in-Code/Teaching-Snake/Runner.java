/*  NO CODE MODIFICATION NEEDED */ 
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
public class Runner {
    public static void main (String [] args) {
        Coordinate startingPosition = new Coordinate(4,4,Direction.NORTH);
        startTheGame(10, 1000, startingPosition);
        
    }//Main Method
    
    public static void startTheGame(int sizeOfBoard, int numOfPixels, Coordinate startingPos){
        JFrame frame = new JFrame("The GameBoard of ...");
        
        DisplayBoard gameBoard = new DisplayBoard(sizeOfBoard, startingPos);
        frame.setContentPane(gameBoard.createContentPane(sizeOfBoard));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(numOfPixels,numOfPixels);
        frame.setVisible(true);
        
        
        gameBoard.runGameBoard();
        
    }//StartTheGame Method
    
    
}//Runner Class
