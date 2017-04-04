package other;

import javax.swing.*;
import java.awt.*;
import java.io.*;

import graphics.Cell;
import graphics.Map;
import graphics.Window;
import graphics.ButtonCreator;

import java.lang.Thread;
import java.util.Random;

public class Main {

    public static final int DEFAULT_WINDOW_WIDTH = 900;
    public static final int DEFAULT_WINDOW_HEIGHT = 900;
    public static final int DEFAULT_PLAYERS = 1;
    public static final String DEFAULT_WINDOW_NAME = "T R O M";
    private Driver[] drivers;
    private StartMenu startMenu = new StartMenu();
    private Settings settings = new Settings();
    private Map map;

    /**
     * Main program function
     * 
     * @param args
     */
    public void start() {
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
	private void finished(){
		System.out.println("Game is finished");
	}
	
	/**
	 * Returns a driver from the main drivers array.
	 * 
	 * @param num Index number of wanted driver
	 * @return Driver from drivers[] array
	 */
	public Driver getDriver(int num) {
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
    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }
	
    public void restartGame(Color winner) {
        Window window = new Window(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME);
        window.setLayout(null);
        
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Tron.ttf"));
            font = font.deriveFont(Font.PLAIN, 50);
        } catch (FontFormatException | IOException error) {
            font = new Font("Arial", Font.BOLD, 40);
        }
        
        JPanel panel = new JPanel();
        JLabel text = new JLabel("Play Again");
        text.setFont(font);
        text.setForeground(winner);
        panel.setBackground(Color.BLACK);
        panel.add(text);
        panel.setSize(400,80);
        panel.setLocation(250,300);
        panel.setVisible(true);
        text.setVisible(true);
        window.add(panel);
        ButtonCreator yes = new ButtonCreator(200,400, 150, 100, winner, "Yes");
        ButtonCreator no = new ButtonCreator(550,400, 150, 100, winner, "No");
        window.add(no);
        window.add(yes);
        window.setVisible(true);
    }
    
	/**
	 * Initializes and runs game
	 * 
	 * @param w Width of the window
	 * @param h Height of the window
	 * @param name Name of the window
	 * @param players Amount of players
	 */
    private void initializeGame(int w, int h, String name, int players) {
        
        if (players > 4)
            players = 4;
        else if (players < 1)
            players = 1;
        
        drivers = new Driver[players];
        for (int i = 0; i < players; i++) {
            if (i == 0) {
                drivers[i] = Driver.YELLOW;
                drivers[i].setMain(this);
            }
            else if (i == 1) {
                drivers[i] = Driver.RED;
            drivers[i].setMain(this);
            }
            else if (i == 2) {
                drivers[i] = Driver.CYAN;
                drivers[i].setMain(this);
            }
            else if (i == 3) {
                drivers[i] = Driver.MAGENTA;
                drivers[i].setMain(this);
            }
        }
        
        map = new Map(this, w, h, name);
        
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
            if (dead >= (players - 1)) {
                settings.setGameGoing(false);
                for (int i = 0; i < players; i++) {
                	System.out.println("Player "+ (i+1) + " FINAL SCORE: " + drivers[i].getScore());
                }
            }
            map.repaintGame();
            stop(settings.getDifficulty());
        }
        map.gameOver();
        String fileName = "scores.txt";
        PrintWriter out = null;
        try {
            File file = new File(fileName);
            if (!file.exists())
                file.createNewFile();
            out = new PrintWriter(new FileOutputStream(file));
            for (int i=0;i < players;i++) {
                out.write("PLAYER " + (i+1) + " SCORE: " + drivers[i].getScore());
                out.println();
            }
        }
        catch (IOException e) {
            System.out.println("ERROR: No scores.txt found");
        }
        out.close();
        stop(1000);
        System.out.println("huh");
        restartGame(Color.RED);
        
        
    }
    // This method uses code copied from http://stackoverflow.com/questions/24104313/how-to-delay-in-java by Ann Ragg
    private void stop(int milliseconds) {
        
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void powerUp() {
        int randomX = new Random().nextInt(50);
        int randomY = new Random().nextInt(50);
        getCell(randomX, randomY).colorUpdate(Color.BLUE);
        
    }
    
    /**
     * Sets the gameGoing loop to false.
     */
    public void stopGame() {
        settings.setGameGoing(false);
    }
}
