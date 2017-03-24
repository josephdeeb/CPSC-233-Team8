
import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;

import graphics.Cell;
import graphics.Map;
import other.Driver;
import other.Settings;
import other.StartMenu;

import java.lang.Thread;
import java.util.Random;

public class Main {

    private static final int DEFAULT_WINDOW_WIDTH = 900;
    private static final int DEFAULT_WINDOW_HEIGHT = 900;
    private static final int DEFAULT_PLAYERS = 1;
    private static final String DEFAULT_WINDOW_NAME = "T R O M";
    private static Driver[] drivers;
    private static StartMenu startMenu = new StartMenu();
    private static Settings settings = new Settings();
    private static Map map;

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
        return map.getCell(x, y);
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
        
        map = new Map(w, h, name);
        
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
                else {
                	dead++;
                }
            }
            if (dead == (players - 1)) {
                settings.setGameGoing(false);
                for (int i = 0; i < players; i++) {
                	System.out.println("Player "+ (i+1) + " FINAL SCORE: " + drivers[i].getScore());
                }
            }
            map.repaintGame();
            stop(settings.getDifficulty());
        }
        map.gameOver();
        
    }
    // This method uses code copied from http://stackoverflow.com/questions/24104313/how-to-delay-in-java by Ann Ragg
    private static void stop(int milliseconds) {
        
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void powerUp() {
        int randomX = new Random().nextInt(50);
        int randomY = new Random().nextInt(50);
        getCell(randomX, randomY).colorUpdate(Color.BLUE);
        
    }
    
    /**
     * Sets the gameGoing loop to false.
     */
    public static void stopGame() {
        settings.setGameGoing(false);
    }
}
