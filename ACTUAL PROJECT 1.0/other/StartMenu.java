package other;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import graphics.ButtonCreator;
import graphics.Window;

import java.awt.event.*;

/** 
 * This class creates a JFrame that displays the start
 * menu and allows the user to start the game, go to settings
 * see the credits or just exit the game.
 */
public class StartMenu{
	
	private boolean gameGoing = false;
	
	private boolean timer = true;
	private Settings settings;
	
	public StartMenu(Settings initSettings) {
	    settings = initSettings;
	}
	
	public boolean getGameGoing() {
	    return gameGoing;
	}
	
    public void setGameGoing(boolean newe){
        gameGoing = newe;
    }
    /**
    * Getter for timer
    */
    public boolean getTimer() {
	    return timer;
	}
	
    /**
     * Run class which creates every button and performs
     * action intended for each button. Also generates the
     * logo that is displayed at the top of the frame.
     */
    public void run(int w,int h, String name){
	    
        // Initialize JFrame
        Window frame = new Window(w, h, name);
		System.out.println("STARTMENU");
        
        // Create Buttons
	    ButtonCreator start = new ButtonCreator(350, 250, 200, 100, Color.CYAN, "Play");
        ButtonCreator instructions = new ButtonCreator(200, 375, 500, 100, Color.YELLOW, "Instructions");
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
        frame.add(instructions);
		frame.add(exit);
        frame.add(credits);
        frame.add(img);
        frame.setVisible(true);
		
        // Adds action listen and switches game going and timer booleans to start the game
        start.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("START clicked");
        settings.run(w, h, name);
        frame.dispose();
        }
});

        credits.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("credits clicked");
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
        System.out.println("EXITCREDITS clicked");
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
        System.out.println("EXIT clicked");
		timer = false;
		gameGoing = false;
        settings.setTimer(false);
		frame.dispose();
        }
});

    }
	  
}

