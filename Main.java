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

    // MAKE LESS STUFF STATIC

    private static final int DEFAULT_WINDOW_WIDTH = 500;
    private static final int DEFAULT_WINDOW_HEIGHT = 500;
    private static final int DEFAULT_PLAYERS = 1;
    private static final String DEFAULT_WINDOW_NAME = "T R O M";
    private static Cell[][] labels = new Cell[50][50];
    private static Driver[] drivers;
    private static StartMenu startMenu = new StartMenu();

    public static void main(String[] args) {
		startMenu.run();
		while (startMenu.getTimer()) {
			stop(100);

        }
        
        if (startMenu.getGameGoing()){
			initializeGame(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT, DEFAULT_WINDOW_NAME, 4);
		}
		else{
			finished();
			
        }
    }
    
	private static void finished(){
		System.out.println("Game is finished");
	}
	
	public static Driver getDriver(int num) {
	    return drivers[num];
	}
	
	public static Cell getCell(int x, int y) {
	    return labels[x][y];
	}
	
	// initializes and runs game
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
        int dead = 0;
        // main game loop
        System.out.println("P1" + "\t\t| " + "P2" + "\t\t\t| " + "P3" + "\t\t\t| " + "P4");
        while (startMenu.getGameGoing()) {
            dead = 0;
            for (int i = 0; i < players; i++) {
                if (drivers[i].getAlive() == true) {
                    drivers[i].move();
                }
                else
                    dead++;
            }
            System.out.println("(" + drivers[0].getXCoordinate() + ", " + drivers[0].getYCoordinate() + ")" + "\t\t| " +
            "(" + drivers[1].getXCoordinate() + ", " + drivers[1].getYCoordinate() + ")" + "\t\t| " +
            "(" + drivers[2].getXCoordinate() + ", " + drivers[2].getYCoordinate() + ")" + "\t\t| " +
            "(" + drivers[3].getXCoordinate() + ", " + drivers[3].getYCoordinate() + ")");
            if (dead == (players - 1))
                startMenu.setGameGoing(false);
            game.repaint();
            stop(75);
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
		for(int a=y;a<34;a++){
			drawLine(x,x+26,a,a, Color.WHITE);
		}
	}
    
	// Prints GAME in the center
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
    
    // Prints OVER in the center
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
    
    public static void stopGame() {
        startMenu.setGameGoing(false);
    }
}
