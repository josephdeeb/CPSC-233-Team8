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

        driver.start();
        while (gameGoing == true) {
            
            driver.move();
            game.repaint();
            stop(100);
        }
        game(13, 17);
        over(13, 25);
        
    }
    // This method uses code copied from http://stackoverflow.com/questions/24104313/how-to-delay-in-java by Ann Ragg
    public static void stop(int milliseconds) {
        
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static void drawLine(int xInit, int xFinal, int yInit, int yFinal, Color color) {
        for (int y = yInit; y <= yFinal; y++) {
            for (int x = xInit; x <= xFinal; x++) {
                labels[x][y].colorUpdate(color);
            }
        }
    }
    
    public static void game(int x, int y) {
        
        // G
        drawLine(x+1, x+3, y, y, Color.YELLOW);
        drawLine(x, x, y+1, y+5, Color.YELLOW);
        drawLine(x+1, x+4, y+6, y+6, Color.YELLOW);
        drawLine(x+4, x+4, y+3, y+5, Color.YELLOW);
        drawLine(x+2, x+4, y+3, y+3, Color.YELLOW);
        labels[x+4][y+1].colorUpdate(Color.YELLOW);
        // A
        drawLine(x+6, x+6, y+1, y+6, Color.YELLOW);
        drawLine(x+10, x+10, y+1, y+6, Color.YELLOW);
        drawLine(x+7, x+9, y, y, Color.YELLOW);
        drawLine(x+7, x+9, y+3, y+3, Color.YELLOW);
        // M
        drawLine(x+12, x+12, y, y+6, Color.YELLOW);
        drawLine(x+16, x+16, y, y+6, Color.YELLOW);
        drawLine(x+14, x+14, y+1, y+3, Color.YELLOW);
        labels[x+13][y].colorUpdate(Color.YELLOW);
        labels[x+15][y].colorUpdate(Color.YELLOW);
        // E
        drawLine(x+18, x+18, y, y+6, Color.YELLOW);
        drawLine(x+18, x+22, y, y, Color.YELLOW);
        drawLine(x+18, x+21, y+3, y+3, Color.YELLOW);
        drawLine(x+18, x+22, y+6, y+6, Color.YELLOW);
    }
    
    public static void over(int x, int y) {
        // O
        drawLine(x+1, x+3, y, y, Color.YELLOW);
        drawLine(x, x, y+1, y+5, Color.YELLOW);
        drawLine(x+1, x+3, y+6, y+6, Color.YELLOW);
        drawLine(x+4, x+4, y+1, y+5, Color.YELLOW);
        // V
        drawLine(x+6, x+6, y, y+4, Color.YELLOW);
        drawLine(x+10, x+10, y, y+4, Color.YELLOW);
        labels[x+7][y+5].colorUpdate(Color.YELLOW);
        labels[x+8][y+6].colorUpdate(Color.YELLOW);
        labels[x+9][y+5].colorUpdate(Color.YELLOW);
        // E
        drawLine(x+12, x+12, y, y+6, Color.YELLOW);
        drawLine(x+12, x+16, y, y, Color.YELLOW);
        drawLine(x+12, x+15, y+3, y+3, Color.YELLOW);
        drawLine(x+12, x+16, y+6, y+6, Color.YELLOW);
        // R
        drawLine(x+18, x+18, y, y+6, Color.YELLOW);
        drawLine(x+18, x+21, y, y, Color.YELLOW);
        drawLine(x+18, x+21, y+3, y+3, Color.YELLOW);
        drawLine(x+22, x+22, y+1, y+2, Color.YELLOW);
        labels[x+20][y+4].colorUpdate(Color.YELLOW);
        labels[x+21][y+5].colorUpdate(Color.YELLOW);
        labels[x+22][y+6].colorUpdate(Color.YELLOW);
    }
    
    public static void stopGame() {
        gameGoing = false;
    }
}
