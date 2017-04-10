package other;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import graphics.ButtonCreator;
import graphics.Window;

import java.awt.event.*;

public class Settings {
    
    private boolean boostBool = true;
    private int numOfPlayers = 2;
    private int numOfPlayersText = 1;
    private int difficultySpeed = 100;
    private boolean gameGoing = false;
    private boolean timer = true;
    public StartMenu startMenu;
    public Main main;
    
    public Settings(Main initMain) {
        main = initMain;
        startMenu = new StartMenu(this);
    }
    
    /** 
     * Runs the Settings menu
     *
     * @param width Sets the width of the window
     * @param height Sets the height of the window
     * @param name Sets the name of the window
     */
    public void run(int w,int h, String name){
        
        // Creates a new window
        Window frame = new Window(w, h, name);
        System.out.println("AHHHHHHHH");
        // Creates buttons
        ButtonCreator start = new ButtonCreator(300, 250, 300, 100, Color.CYAN, "Start");
        ButtonCreator players = new ButtonCreator(275, 350, 350, 100, Color.YELLOW, "2 Players");
        ButtonCreator boosts = new ButtonCreator(250, 450, 400, 100, Color.GREEN, "Boosts On");
        ButtonCreator difficulty = new ButtonCreator(230, 550, 450, 100, Color.MAGENTA, "Easy");
        ButtonCreator back = new ButtonCreator(305, 650, 300, 100, Color.RED, "Back");
        
        // Initializes the title for settings
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        JLabel img = new JLabel(new ImageIcon("SETTINGS.png"));
        panel.add(img);
        Dimension size = img.getMaximumSize();
        img.setBounds(170, 40, size.width, size.height);
        
        // Adds title, buttons and makes frame visible
        frame.add(start);
        frame.add(players);
        frame.add(img);
        frame.add(boosts);
        frame.add(back);
        frame.add(difficulty);
        frame.setVisible(true);
        
        
        // Adds action listener for the back button
        back.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
		startMenu.run(w, h, name);
        frame.dispose();
        }
});
        
        // Adds action listener for the boosts button
        boosts.addActionListener( new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
        if (boostBool == true) {
        boosts.setText("Boosts Off");  
        boostBool = false;
        }
        else {
            boosts.setText("Boosts On");
            boostBool = true;
        }
            }
});
            
        // Adds action listener for the players button
        players.addActionListener( new ActionListener() {
            
                public void actionPerformed(ActionEvent e){
        if (numOfPlayersText == 0) {
            players.setText("2 Players");
            numOfPlayers = 2;
            numOfPlayersText += 1;
        }
        
        else if (numOfPlayersText == 1) {
            players.setText("3 Players");
            numOfPlayers = 3;
            numOfPlayersText += 1;
        }
        
        else if (numOfPlayersText == 2) {
            players.setText("4 Players");
            numOfPlayers = 4;
            numOfPlayersText -= 2;
        }
                }
});
            
        // Adds action listener for the difficulty button
        difficulty.addActionListener( new ActionListener() {
           
           public void actionPerformed(ActionEvent e) {
        if (difficultySpeed == 100) {
            difficulty.setText("Intermediate");
            difficultySpeed -= 30;
            System.out.println(difficultySpeed);
        }
        
        else if (difficultySpeed == 70) {
            difficulty.setText("Expert");
            difficultySpeed -= 35;
            System.out.println(difficultySpeed);
        }
        
        else if (difficultySpeed == 35) {
            difficulty.setText("Easy");
            difficultySpeed += 65;
            System.out.println(difficultySpeed);
        }
    }

});   
            
        // Adds action listener for the start button
        start.addActionListener( new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
        gameGoing = true;
		timer = false;
		frame.dispose();
    }
    
});

    }
    
    /**
     * Getter for number of players
     */
    public int getPlayers() {
        return numOfPlayers;
    }
    
    public void setPlayers(int number) {
        if (number < 1)
            numOfPlayers = 1;
        if (number > 4)
            numOfPlayers = 4;
        else
            numOfPlayers = number;
    }
    
    /**
     * Getter for the boost boolean
    */
    public boolean getBoost() {
        return boostBool;
    }
 
    /**
     * Getter for difficulty
     */
    public int getDifficulty() {
        return difficultySpeed;
    }

	/**
     *Getter for getGameGoing
     */
    public boolean getGameGoing() {
	    return gameGoing;
    }

    /**
    * Getter for timer
    */
    public boolean getTimer() {
	    return timer;
	}
    
    /**
    * Setter method for gameGoing
    *
    * @param setter passes in setter for gameGoing
    */
	public void setGameGoing(boolean setter) {
	    gameGoing = setter;
	}
    
}