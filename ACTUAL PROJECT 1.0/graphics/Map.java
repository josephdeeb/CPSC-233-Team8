package graphics;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JPanel;

import other.Main;

public class Map {
    
    /**
     * Sets the name of our game that'll appear at the top window
     */
    public static final String DEFAULT_WINDOW_NAME = "T R O M";
    
    /**
     * The width of all of the windows
     */
    public static final int DEFAULT_WINDOW_WIDTH = 900;
    
    /**
     * The height of all of the windows
     */
    public static final int DEFAULT_WINDOW_HEIGHT = 900;
    
    /**
     * The number of cells in the window
     */
    private Cell[][] labels = new Cell[50][50];
    
    /**
     * Creates a window instance
     */
    private Window window;
    
    /**
     * Creates a JPanel called game
     */
    private JPanel game;
    
    /**
     * Creates a main instance
     */
    private Main main;
    
    /**
     *Constructor with one argument that calls constructor with four arguments
     *
     *@param initMain Main object to initalize graphical game with
     */
    public Map(Main initMain) {
        this(initMain, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME);
    }
    
    /**
     *Constructor with two argument that calls constructor with four arguments
     *
     *@param initMain Main object to initialize graphical game with
     *@param n Name of game "TROM"
     */
    public Map(Main initMain, String n) {
        this(initMain, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, n);
    }
    
    /**
     *Constructor with four arguments that will initialize the game
     *
     *@param initMain Main object of game
     *@param width Width of window
     *@param height Height of window
     *@param n Name of game "TROM"
     */
    public Map(Main initMain, int width, int height, String n) {
        main = initMain;
        initialize(width, height, n);
    }
    
    /**
     *Creates the window and the cells
     *
     *@param width Width of window
     *@param height Height of window
     *@param name Name of game "TROM"
     */
    private void initialize(int w, int h, String name) {
        window = new Window(w, h, name, main);
        game = new JPanel(new GridLayout(50, 50));
        
        int x = 0;
        int y = 0;
        while (y < 50) {
            x = 0;
            while (x < 50) {
                labels[x][y] = new Cell();
                game.add(labels[x][y]);
                x++;
            }
            y++;
        }
        
        game.setVisible(true);
        window.getContentPane().add(game);
        window.setVisible(true);
    }
    
    /**
     *Redraws game GUI
     */
    public void repaintGame() {
        game.repaint();
    }
    
    /**
     *Draws the GAME OVER box
     */
    public void gameOver() {
        drawBox(11,15);
        game(13, 17);
        over(13, 25);
    }
    
    /**
     * Disposes of the current window
     */
    public void disposeWindow(){
        Window.dispose();
    }
    
    /**
     * Returns a cell from the main cell array.
     * 
     * @param x X Coordinate of the wanted cell
     * @param y Y Coordinate of the wanted cell
     * @return Cell at (x,y) entry of labels array.
     */
    public Cell getCell(int x, int y) {
        return labels[x][y];
    }
    
    /**
     * Draws a line
     * 
     * @param xInit X coordinate start of the line (inclusive)
     * @param xFinal X coordinate end of the line (inclusive)
     * @param yInit Y coordinate start of the line (inclusive)
     * @param yFinal Y coordinate end of the line (inclusive)
     * @param color Color of the line
     */
    private void drawLine(int xInit, int xFinal, int yInit, int yFinal, Color color) {
        for (int y = yInit; y <= yFinal; y++) {
            for (int x = xInit; x <= xFinal; x++) {
                labels[x][y].colorUpdate(color);
            }
        }
    }
    
    /**
     *method to draw a box, namely the GAME OVER box
     *
     *@param x intial x coordinate
     *@param y initial y coordinate
     */
    private void drawBox(int x, int y){
        //starting x: 11 starting y: 15
        for(int a=y; a<34; a++){
            drawLine(x, x+26, a, a, Color.WHITE);
        }
    }
    
    /**
     * Prints 'GAME' starting at the given x y coordinates
     * 
     * @param x The starting x coordinate
     * @param y The starting y coordinate
     */
    private void game(int x, int y) {
        
        // G
        drawLine(x+1, x+3, y, y, Color.BLACK);
        drawLine(x, x, y+1, y+5, Color.BLACK);
        drawLine(x+1, x+4, y+6, y+6, Color.BLACK);
        drawLine(x+4, x+4, y+3, y+5, Color.BLACK);
        drawLine(x+2, x+4, y+3, y+3, Color.BLACK);
        labels[x+4][y+1].colorUpdate(Color.BLACK);
        // A
        drawLine(x+6, x+6, y+1, y+6, Color.BLACK);
        drawLine(x+10, x+10, y+1, y+6, Color.BLACK);
        drawLine(x+7, x+9, y, y, Color.BLACK);
        drawLine(x+7, x+9, y+3, y+3, Color.BLACK);
        // M
        drawLine(x+12, x+12, y, y+6, Color.BLACK);
        drawLine(x+16, x+16, y, y+6, Color.BLACK);
        drawLine(x+14, x+14, y+1, y+3, Color.BLACK);
        labels[x+13][y].colorUpdate(Color.BLACK);
        labels[x+15][y].colorUpdate(Color.BLACK);
        // E
        drawLine(x+18, x+18, y, y+6, Color.BLACK);
        drawLine(x+18, x+22, y, y, Color.BLACK);
        drawLine(x+18, x+21, y+3, y+3, Color.BLACK);
        drawLine(x+18, x+22, y+6, y+6, Color.BLACK);
    }
    
    /**
     * Prints 'OVER' starting at the given x y coordinates
     * 
     * @param x The starting x coordinate
     * @param y The starting y coordinate
     */
    private void over(int x, int y) {
        // O
        drawLine(x+1, x+3, y, y, Color.BLACK);
        drawLine(x, x, y+1, y+5, Color.BLACK);
        drawLine(x+1, x+3, y+6, y+6, Color.BLACK);
        drawLine(x+4, x+4, y+1, y+5, Color.BLACK);
        // V
        drawLine(x+6, x+6, y, y+4, Color.BLACK);
        drawLine(x+10, x+10, y, y+4, Color.BLACK);
        labels[x+7][y+5].colorUpdate(Color.BLACK);
        labels[x+8][y+6].colorUpdate(Color.BLACK);
        labels[x+9][y+5].colorUpdate(Color.BLACK);
        // E
        drawLine(x+12, x+12, y, y+6, Color.BLACK);
        drawLine(x+12, x+16, y, y, Color.BLACK);
        drawLine(x+12, x+15, y+3, y+3, Color.BLACK);
        drawLine(x+12, x+16, y+6, y+6, Color.BLACK);
        // R
        drawLine(x+18, x+18, y, y+6, Color.BLACK);
        drawLine(x+18, x+21, y, y, Color.BLACK);
        drawLine(x+18, x+21, y+3, y+3, Color.BLACK);
        drawLine(x+22, x+22, y+1, y+2, Color.BLACK);
        labels[x+20][y+4].colorUpdate(Color.BLACK);
        labels[x+21][y+5].colorUpdate(Color.BLACK);
        labels[x+22][y+6].colorUpdate(Color.BLACK);
    }
    
}
