import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.BorderFactory;

public class Main {
    
    public static final int DEFAULT_WINDOW_WIDTH = 500;
    public static final int DEFAULT_WINDOW_HEIGHT = 500;
    public static final int DEFAULT_CElL_WIDTH = 10;
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
        // Makes the game JPanel visible
        game.setVisible(true);
        // Adds the game JPanel to the main window
        window.getContentPane().add(game);
        // Makes the window visible
        window.setVisible(true);
    }
}
