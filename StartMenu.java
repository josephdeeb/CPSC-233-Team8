package logic;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import graphics.ButtonCreator;
import graphics.Window;

import java.awt.event.*;

public class StartMenu{
	
	private boolean gameGoing = false;
	private boolean timer = true;
	private Settings settings;
	
	public StartMenu(Settings initSettings) {
	    settings = initSettings;
	}
	
    /**
     * Getter for the gameGoing boolean
     */
	public boolean getGameGoing() {
	    return gameGoing;
	}
	
    /** 
     * Setter for the boolean gameGoing
     *
     *@param gameBool sets the gameGoing boolean
     */
    public void setGameGoing(boolean gameBool){
        gameGoing = gameBool;
    }
   
    /**
    * Getter for timer
    */
    public boolean getTimer() {
	    return timer;
	}
	
    /**
     * Run method which runs the Start Menu
     *
     * @param w Sets the width of the frame
     * @param h Sets the height of the frame
     * @param name Sets the name of the frame
     */
    public void run(int w,int h, String name){
	    
        // Initialize JFrame
        Window frame = new Window(w, h, name);
        
        // Create Buttons
	    ButtonCreator start = new ButtonCreator(350, 250, 200, 100, Color.CYAN, "Play");
        ButtonCreator instructionsButton = new ButtonCreator(200, 375, 500, 100, Color.YELLOW, "Instructions");
        ButtonCreator credits = new ButtonCreator(300, 500, 300, 100, Color.MAGENTA, "Credits");
        ButtonCreator exit = new ButtonCreator(350, 625, 200, 100, Color.RED, "Exit");
        
		// Create JPanel and JLabel to add logo
		JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        JLabel img = new JLabel(new ImageIcon("assets/TROM.png"));
        panel.add(img);
        Dimension size = img.getMaximumSize();
        img.setBounds(170, 60, size.width, size.height);
       
        // Adding all of the buttons to the JFrame
		frame.add(start);
        frame.add(instructionsButton);
		frame.add(exit);
        frame.add(credits);
        frame.add(img);
        frame.setVisible(true);
		
        // Adds action listener and switches game going and timer booleans to start the game
        start.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("Start Clicked");
        settings.run(w, h, name);
        frame.dispose();
        }
});
       
       // Adds action listener and opens the instuctions menu
        instructionsButton.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("Instructions Clicked");
       frame.dispose();
       Window frame = new Window(w, h, name);
        ButtonCreator back = new ButtonCreator(350, 625, 200, 100, Color.RED, "Back");
        
        // Create JPanel and JLabel to add logo
		JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        JLabel img = new JLabel(new ImageIcon("assets/INSTRUCTIONS.png"));
        panel.add(img);
        Dimension size = img.getMaximumSize();
        img.setBounds(170, 60, size.width, size.height);
        
        JPanel namesPanel = new JPanel();
        JLabel textLabel = new JLabel("<html><br><br><br>Player 1- Up-&#8593; Left-&#8592; Down-&#8595 Right-&#8594<br><br>Player 2- Up-W Left-A Down-S Right-D<br><br>Player 3- Up-U Left-H Down-J Right-K </html>");
        textLabel.setFont(new Font("Serif", Font.ITALIC, 30));
        textLabel.setForeground(Color.WHITE);
        namesPanel.setBackground(Color.BLACK);
        namesPanel.add(textLabel);
        namesPanel.setSize(600,600);
        namesPanel.setLocation(100,200);
        namesPanel.setVisible(true);
        textLabel.setVisible(true);
        
        frame.add(namesPanel);
        frame.add(back);
        frame.add(img);
        frame.setVisible(true);
        
         // Adds action listener for the back button
        back.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e) {
		frame.dispose();
        run(w, h, name);
        }
});
       
 
        }
});

        // Adds the action listener for the instructions button
        credits.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        
        // Frame is created and text placed to show credits
        System.out.println("Credits Clicked");
        frame.dispose();
        Window creditsFrame = new Window(w,h,name);
        JPanel namesPanel = new JPanel();
        JLabel textLabel = new JLabel("<html>This game was created by:<br><br> Denis Shevchenko<br><br> Joseph Besenski<br><br>Jason Lyster<br><br>Daniel Sohn<br><br> Kevin Vo </html>");
        textLabel.setFont(new Font("Serif", Font.ITALIC, 30));
        textLabel.setForeground(Color.WHITE);
        namesPanel.add(textLabel);
        creditsFrame.setSize(900,900);
        creditsFrame.getContentPane().setBackground(Color.BLACK);
        namesPanel.setBackground(Color.BLACK);
        creditsFrame.setLayout(null);
        namesPanel.setSize(400,600);
        namesPanel.setLocation(100,100);
        creditsFrame.add(namesPanel);
        creditsFrame.setVisible(true);
        namesPanel.setVisible(true);
        textLabel.setVisible(true);
        
        ButtonCreator exitCredits = new ButtonCreator(350, 625, 200, 100, Color.RED, "Back");
        creditsFrame.add(exitCredits);
        
        // Adds action listener for the exit credits button
        exitCredits.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("Exit Credits Clicked");
		creditsFrame.dispose();
        run(w, h, name);
        }
});
 
        }
            
        }
);
        
        // Adds action listener to exit the game when exit is clicked
        exit.addActionListener( new ActionListener(){
    
           public void actionPerformed(ActionEvent e){
        System.out.println("Exit Menu Clicked");
		timer = false;
		gameGoing = false;
        settings.setTimer(false);
		frame.dispose();
        }
});

    }
	  
}