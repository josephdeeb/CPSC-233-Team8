package other;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import graphics.ButtonCreator;
import graphics.Window;



/** 
 * This class creates a JFrame that displays the start
 * menu and allows the user to start the game, go to settings
 * see the credits or just exit the game.
 */
public class StartMenu{
	
    /**
     * Whether or not game is running
     */
	private boolean gameGoing = false;
	
    /**
     * Timer for the thread
     */
	private boolean timer = true;
    
    /**
     * Create a settings instance
     */
	private Settings settings;
	
    /**
     * Constructor that initializes the settings menu
     *
     * @param initSettings changing our settings menu
     */
	public StartMenu(Settings initSettings) {
	    settings = initSettings;
	}
	 
    /**
     * Getter method for gamegoing
     *
     * @return returns state of gameGoing
     */
	public boolean getGameGoing() {
	    return gameGoing;
	}
	
    /**
     * Getter for timer
     *
     * @return returns state of timer
     */
    public boolean getTimer() {
	    return timer;
	}
	
    /**
     * Run class which creates every button and performs
     * action intended for each button. Also generates the
     * logo that is displayed at the top of the frame.
     *
     * @param w width of window to create
     * @param h height of window to create
     * @name name of our window (TROM)
     */
    public void run(int w,int h, String name){
	    
        Window frame = new Window(w, h, name);
		System.out.println("STARTMENU");
        
        // Create Inital Buttons
	    ButtonCreator start = new ButtonCreator(350, 250, 200, 100, Color.CYAN, "Play");
        ButtonCreator instructions = new ButtonCreator(200, 375, 500, 100, Color.YELLOW, "Instructions");
        ButtonCreator credits = new ButtonCreator(300, 500, 300, 100, Color.MAGENTA, "Credits");
        ButtonCreator exit = new ButtonCreator(350, 625, 200, 100, Color.RED, "Exit");
        
		// Create JPanel and JLabel to add logo
		JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        JLabel img = new JLabel(new ImageIcon("TROM.png"));
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
		
        // start button action listener
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
                exitCredits.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.out.println("EXITCREDITS clicked");
                        creditsFrame.dispose();
                        run(w, h, name);
                    }
                });
            }
        });

        exit.addActionListener( new ActionListener(){
           public void actionPerformed(ActionEvent e){
                System.out.println("EXIT clicked");
                timer = false;
                gameGoing = false;
                frame.dispose();
            }
        });

    }
	  
}
