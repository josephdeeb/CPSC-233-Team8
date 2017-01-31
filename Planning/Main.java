import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.BorderFactory;

import java.lang.Thread;

import java.util.Random;

public class Main {

    public static int x = 0;
    public static int y = 0;

    public static final int DEFAULT_WINDOW_WIDTH = 500;
    public static final int DEFAULT_WINDOW_HEIGHT = 500;
    public static final int DEFAULT_CELL_WIDTH = 10;
    public static final int DEFAULT_CELL_HEIGHT = 10;
    public static final String DEFAULT_WINDOW_NAME = "T R O M";
    public static Cell[][] labels = new Cell[50][50];
    public static Driver driver = new Driver(5, 5, Color.YELLOW);
    public static boolean gameGoing = true;

    public static void main(String[] args) {

        initializeGame(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME);
    }

    public static void initializeGame(int w, int h, String name) {
        
        // JFrame window
        Window window = new Window(w, h, name);

        // JPanel where the game takes place
        JPanel game = new JPanel(new GridLayout(50, 50));

        // Loop that assigns cells to 2d array entries
        while (y < 50) {
            x = 0;
            while (x < 50) {

                // assigns [x][y] coordinate in labels to a new Cell object
                labels[x][y] = new Cell();

                // adds the cell at [x][y] coordinates in labels to the game
                // JPanel
                game.add(labels[x][y]);
                x++;
            }
            y++;
        }

        // Makes the game JPanel visible
        game.setVisible(true);

        // Adds the game JPanel to the main window
        window.getContentPane().add(game);

        // Makes the window visible
        window.setVisible(true);
        gameGoing = true;
        driver.start();
        while (gameGoing == true) {
            
            driver.move();
            game.repaint();
            stop(100);
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
