package logic;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

import graphics.Cell;
import graphics.Map;
import graphics.Window;
import graphics.ButtonCreator;

import java.lang.Thread;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static final int DEFAULT_WINDOW_WIDTH = 900;
    public static final int DEFAULT_WINDOW_HEIGHT = 900;
    public static final int DEFAULT_PLAYERS = 1;
    public static final String DEFAULT_WINDOW_NAME = "T R O M";
    private Driver[] drivers;
    private Settings settings;
    private Map map;
    private int players = 1;
    
    public Main() {
        settings = new Settings(this);
    }
    
    public Main(Settings initSettings) {
        settings = initSettings;
    }
    /**
     * Main program function
     * 
     * @param args
     */
    public boolean start() {
        settings.startMenu.run(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME);
        while (settings.getTimer()) {
            stop(100);

        }
        
        if (settings.getGameGoing()){
            players = settings.getPlayers();
            return initializeGame(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME, settings.getPlayers());
        }
        return true;
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
	
    /**
     * Gives player the option to restart the game after the game is over
     *
     * @param winner Color of the winner to set text to that color
     * @param playerNum Number of the winner to say who won that game
     */
    public boolean restartGame(Color winner, int playerNum) {
       
        Window window = new Window(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME);
        window.setLayout(null);
        
        Font font;
        Font winnerFont;
        
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Tron.ttf"));
            font = font.deriveFont(Font.PLAIN, 50);
            winnerFont = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Tron.ttf"));
            winnerFont = font.deriveFont(Font.PLAIN, 65);
        } catch (FontFormatException | IOException error) {
            font = new Font("Arial", Font.BOLD, 40);
            winnerFont = new Font("Arial", Font.BOLD, 40);
        }
        
        // Creates the play again text
        JPanel panel = new JPanel();
        JLabel text = new JLabel("Play Again");
        text.setFont(font);
        panel.setBackground(Color.BLACK);
        panel.add(text);
        panel.setSize(400,80);
        panel.setLocation(250,350);
        panel.setVisible(true);
        window.add(panel);
        JLabel winnerText;
        
        // Determines who won or if the game was a tie
        JPanel panel2 = new JPanel();
        if (playerNum == 0) {
             winnerText = new JLabel("TIE");
             winnerText.setForeground(Color.WHITE);
             text.setForeground(Color.WHITE);
        }
        else {
            winnerText = new JLabel("Player " + playerNum + " Wins");
            winnerText.setForeground(winner);
            text.setForeground(winner);
        }
        
        panel2.setBackground(Color.BLACK);
        panel2.add(winnerText);
        panel2.setSize(600,80);
        panel2.setLocation(160,200);
        panel2.setVisible(true);
        winnerText.setFont(winnerFont);
        text.setVisible(true);
        winnerText.setVisible(true);
        window.add(panel2);
 
        ButtonCreator yes = new ButtonCreator(200, 450, 150, 100, winner, "Yes");
        ButtonCreator no = new ButtonCreator(550, 450, 150, 100, winner, "No");
        
        if (playerNum == 0) {
            yes.setForeground(Color.WHITE);
            no.setForeground(Color.WHITE);
        }
        
        window.add(no);
        window.add(yes);
        window.setVisible(true);
        
        CountDownLatch wait2 = new CountDownLatch(1);
        BooleanRestart restart = new BooleanRestart();
        
        // Adds action listener for the yes button
        yes.addActionListener( new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
        window.dispose();
        restart.setReturned(true);
        wait2.countDown();
    }
    
});

         // Adds action listener for the no button
        no.addActionListener( new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
        window.dispose();
        restart.setReturned(false);
        wait2.countDown();
    }
            
            
    
});
        try {
        wait2.await();
        } catch (InterruptedException e) {
            System.out.println("Caught");
        }
        System.out.println("Returned");
        System.out.println(restart.returned);
        getSettings().startMenu.setGameGoing(true);
        return restart.returned;
    }
    
	/**
	 * Initializes and runs game
	 * 
	 * @param w Width of the window
	 * @param h Height of the window
	 * @param name Name of the window
	 * @param players Amount of players
	 */
    private boolean initializeGame(int w, int h, String name, int players) {
        
        if (players > 4)
            players = 4;
        else if (players < 1)
            players = 1;
        
        drivers = new Driver[players];
        for (int i = 0; i < players; i++) {
            if (i == 0) {
                drivers[i] = new Driver(5, 5, Color.YELLOW, "down");
                drivers[i].setMain(this);
            }
            else if (i == 1) {
                drivers[i] = new Driver(44, 5, Color.RED, "left");
            drivers[i].setMain(this);
            }
            else if (i == 2) {
                drivers[i] = new Driver(44, 44, Color.CYAN, "up");
                drivers[i].setMain(this);
            }
            else if (i == 3) {
                drivers[i] = new Driver(5, 44, Color.MAGENTA, "right");
                drivers[i].setMain(this);
            }
        }
        
        map = new Map(this, w, h, name);
        
        if (settings.getBoost() == true) {
            powerUp();
        }
        
        int dead = 0;
        int winnerNumber = 0;
        Color winnerColor = Color.RED;
       
        // Main game loop
        int delay = 0;
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
            if (delay == 0) {
                delay = 1;
                stop(2000);
            }
            
            // Prints the final scores to the console and ends the game
            if (dead >= (players - 1)) {
                settings.setGameGoing(false);
                for (int i = 0; i < players; i++) {
                	System.out.println("Player "+ (i+1) + " FINAL SCORE: " + drivers[i].getScore());
                    if (drivers[i].getAlive()) {
                        winnerNumber = i+1;
                        winnerColor = drivers[i].getPlayerColor();
                    }
                }
            }
            map.repaintGame();
            stop(settings.getDifficulty());
        }
       
       // Prints the high scores to a text file
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
        
        // Catches the IOException if the file is not found
        catch (IOException e) {
            System.out.println("ERROR: No scores.txt found");
        }
        
        out.close();
        stop(1000);
        map.disposeWindow();
        return restartGame(winnerColor, winnerNumber);
        
        
    }
    // This method uses code copied from http://stackoverflow.com/questions/24104313/how-to-delay-in-java by Ann Ragg
    private void stop(int milliseconds) {
        
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Spawns the power up to a random cell
     */
    public void powerUp() {
        Color hotPink = new Color(255, 0, 255);
        int randomX = new Random().nextInt(50);
        int randomY = new Random().nextInt(50);
        getCell(randomX, randomY).colorUpdate(hotPink);
        
    }
    
    /**
     * Sets the gameGoing loop to false.
     */
    public void stopGame() {
        settings.setGameGoing(false);
    }
    
    /**
     * Getter for settings
     */
    public Settings getSettings(){
        return settings;
    }

}