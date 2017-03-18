import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import java.lang.Thread;
import java.util.Random;

public class Main {

    private static final int DEFAULT_WINDOW_WIDTH = 900;
    private static final int DEFAULT_WINDOW_HEIGHT = 900;
    private static final int DEFAULT_PLAYERS = 1;
    private static final String DEFAULT_WINDOW_NAME = "T R O M";
    private static Cell[][] labels = new Cell[50][50];
    private static Driver[] drivers;
    private static StartMenu startMenu = new StartMenu();
    private static Settings settings = new Settings();

    /**
     * Main program function
     * 
     * @param args
     */
    public static void main(String[] args) {
		startMenu.run(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME);
		while (settings.getTimer()) {
			stop(100);

        }
        
        if (settings.getGameGoing()){
			initializeGame(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME, settings.getPlayers());
		}
		else{
			finished();
			
        }
    }
    
    /**
     * Prints "Game is finished".
     */
	private static void finished(){
		System.out.println("Game is finished");
	}
	
	/**
	 * Returns a driver from the main drivers array.
	 * 
	 * @param num Index number of wanted driver
	 * @return Driver from drivers[] array
	 */
	public static Driver getDriver(int num) {
	    try {
	        return drivers[num];
	    }
	    catch (ArrayIndexOutOfBoundsException ex) {
	        return drivers[0];
	    }
	    finally {}
	}
	
	/**
	 * Returns a cell from the main cell array.
	 * 
	 * @param x X Coordinate of the wanted cell
	 * @param y Y Coordinate of the wanted cell
	 * @return Cell at (x,y) entry of labels array.
	 */
	public static Cell getCell(int x, int y) {
	    return labels[x][y];
	}
	
	/**
	 * Initializes and runs game
	 * 
	 * @param w Width of the window
	 * @param h Height of the window
	 * @param name Name of the window
	 * @param players Amount of players
	 */
    private static void initializeGame(int w, int h, String name, int players) {
        
        if (players > 4)
            players = 4;
        else if (players < 1)
            players = 1;
        drivers = new Driver[players];
        for (int i = 0; i < players; i++) {
            if (i == 0)
                drivers[i] = new Driver(5, 5, Color.YELLOW, "down");
            else if (i == 1)
                drivers[i] = new Driver(44, 5, Color.RED, "left");
            else if (i == 2)
                drivers[i] = new Driver(44, 44, Color.CYAN, "up");
            else if (i == 3)
                drivers[i] = new Driver(5, 44, Color.MAGENTA, "right");
        }

        Window window = new Window(w, h, name);

        JPanel game = new JPanel(new GridLayout(50, 50));

        // Loop that assigns cells to 2d array entries
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
        
        if (settings.getBoost() == true) {
            powerUp();
        }
        
        int dead = 0;
        
        // Main game loop
        while (settings.getGameGoing()) {
            dead = 0;
            for (int i = 0; i < players; i++) {
                if (drivers[i].getAlive() == true) {
                    drivers[i].move();
                }
                else
                    dead++;
            }
            if (dead == (players - 1))
                settings.setGameGoing(false);
            game.repaint();
            stop(settings.getDifficulty());
        }
		drawBox(11,15);
        game(13, 17);
        over(13, 25);
        
    }
    // This method uses code copied from http://stackoverflow.com/questions/24104313/how-to-delay-in-java by Ann Ragg
    private static void stop(int milliseconds) {
        
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
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
    private static void drawLine(int xInit, int xFinal, int yInit, int yFinal, Color color) {
        for (int y = yInit; y <= yFinal; y++) {
            for (int x = xInit; x <= xFinal; x++) {
                labels[x][y].colorUpdate(color);
            }
        }
    }
	
    // P.S this ain't needed, draw line works for boxes if you specify the right coordinates
	private static void drawBox(int x, int y){
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
    private static void game(int x, int y) {
        
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
    private static void over(int x, int y) {
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
    
    public static void powerUp() {
        int randomX = new Random().nextInt(50);
        int randomY = new Random().nextInt(50);
        labels[randomX][randomY].colorUpdate(Color.BLUE);
        
    }
    
    /**
     * Sets the gameGoing loop to false.
     */
    public static void stopGame() {
        settings.setGameGoing(false);
    }
}
