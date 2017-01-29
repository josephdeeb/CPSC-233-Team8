import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.BorderFactory;

import java.lang.Thread;

import java.util.Random;

public class Main {
    
	public static int x = 0;
    public static int y = 0;
	
    public static final int DEFAULT_WINDOW_WIDTH = 1000;
    public static final int DEFAULT_WINDOW_HEIGHT = 1000;
    public static final int DEFAULT_CELL_WIDTH = 20;
    public static final int DEFAULT_CELL_HEIGHT = 10;
    public static final String DEFAULT_WINDOW_NAME = "T R O M";
    public static Cell[][] labels = new Cell[50][50];
    
    public static void main(String[] args) {

        initializeGame(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME);
    }
    
    public static void initializeGame(int w, int h, String name) {
        
		// JFrame window
        Window window = new Window(w,h,name);
        
		// JPanel where the game takes place
        JPanel game = new JPanel(new GridLayout(50,50));
        
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
		
		// Randomly places the character on one half of the board for use in actual game
		int randomNumberX = new Random().nextInt(25);
		int randomNumberY = new Random().nextInt(25);
		
		labels[randomNumberX][randomNumberY].setBackground(Color.YELLOW);
		
		x = randomNumberX;
		y = randomNumberY;
		
		// Makes the game JPanel visible
        game.setVisible(true);
        
		// Adds the game JPanel to the main window
        window.getContentPane().add(game);
        
		// Makes the window visible
        window.setVisible(true);

	}
	// Create a method that changes the colour of the updated square after user chooses to move
	public static void drawUpdate(int i, int j) {
		labels[x][y].setBackground(Color.BLACK);
		labels[i][j].setBackground(Color.YELLOW);
		x=i;
		y=j;
	
	}
		
}
		
		

		

	

	

