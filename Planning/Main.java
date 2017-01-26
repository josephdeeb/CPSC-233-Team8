/*
 * CURRENT PROBLEMS
 * 
 * window and game cannot be referenced in the main method (possibly in other methods as well)
 * 
 */



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.BorderFactory;

import java.lang.Thread;

public class Main {
    
    public static final int DEFAULT_WINDOW_WIDTH = 500;
    public static final int DEFAULT_WINDOW_HEIGHT = 500;
    public static final int DEFAULT_CELL_WIDTH = 10;
    public static final int DEFAULT_CELL_HEIGHT = 10;
    public static final String DEFAULT_WINDOW_NAME = "T R O M";
    public static Cell[][] labels = new Cell[50][50];
    
    public static void main(String[] args) {

        initializeGame(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME);
        // You can also easily change the color
        
        stop(100);
        labels[7][25].setBackground(Color.GREEN);
        labels[7][25].setBorder(null);
        stop(100);
        labels[8][25].setBackground(Color.GREEN);
        labels[8][25].setBorder(null);
        stop(100);
        labels[9][25].setBorder(null);
        labels[9][25].setBackground(Color.GREEN);
    }
    
    public static void initializeGame(int w, int h, String name) {
        
        Window window = new Window(w,h,name);
        // JPanel where the game takes place
        JPanel game = new JPanel(new GridLayout(50,50));
        
        int x = 0;
        int y = 0;
        // Loop that assigns cells to 2d array entries
        while (y < 50) {
            x = 0;
            while (x < 50) {
                // assigns [x][y] coordinate in labels to a new Cell object
                labels[x][y] = new Cell();
                // adds the cell at [x][y] coordinates in labels to the game JPanel
                game.add(labels[x][y]);
                x++;
            }
            y++;
        }
        
        // Just here to show how easily you can change the values or image or color of a specific square
        labels[2][10].setBackground(Color.GREEN);

        game.setVisible(true);
        // Adds the game JPanel to the main window
        window.getContentPane().add(game);
        window.setVisible(true);
        
        
        // Quick test animation
        int f = 0;
        while (f < 50) {
            stop(100);
            window.repaint();
            labels[f][25].setBackground(Color.GREEN);
            labels[f][25].setBorder(null);
            f++;
        }
    }
    
    // This method uses code copied from http://stackoverflow.com/questions/24104313/how-to-delay-in-java by Ann Ragg
    public static void stop(int milliseconds) {
        
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
