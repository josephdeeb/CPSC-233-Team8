import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

/** 
 * This class creates a JFrame that displays the start
 * menu and allows the user to start the game, go to settings
 * see the credits or just exit the game.
 */
public class StartMenu{
	
	private boolean gameGoing = false;
	
	private boolean timer = true;

	public boolean getGameGoing() {
	    return gameGoing;
	}
	
    /**
    * Setter method for gameGoing
    *
    * @param setter passes in setter for gameGoing
    */
	public void setGameGoing(boolean setter) {
	    gameGoing = setter;
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
    public void run(){
	    
        // Initialize JFrame
        JFrame frame = new JFrame("T R O M");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(900, 900);
        
        frame.getContentPane().setBackground(Color.BLACK); 
        
		// Create start button
		
        JButton start = new JButton();
        
        Font font = new Font("Arial", Font.BOLD, 40);
        
        start.setFont(font);
        
        start.setBackground(Color.BLACK);
        
        start.setForeground(Color.CYAN);
		
        start.setBounds(350, 325, 200, 100);
        
        start.setFocusPainted(false);
        
        start.setBorderPainted(false);
		
		start.setVisible(true);
		
		start.setText("Start");
        
        // Create settings button
       
        JButton settings = new JButton();
        
        settings.setFont(font);
        
        settings.setBackground(Color.BLACK);
        
        settings.setForeground(Color.YELLOW);
		
        settings.setBounds(350, 435, 200, 100);
        
        settings.setFocusPainted(false);
        
        settings.setBorderPainted(false);
		
		settings.setVisible(true);
		
		settings.setText("Settings");
		
        // Create credits button
        
        JButton credits = new JButton();
        
        credits.setFont(font);
        
        credits.setBackground(Color.BLACK);
        
        credits.setForeground(Color.MAGENTA);
		
        credits.setBounds(350, 550, 200, 100);
        
        credits.setFocusPainted(false);
        
        credits.setBorderPainted(false);
		
		credits.setVisible(true);
		
		credits.setText("Credits");
       
        credits.setVisible(true);
        
        // Create exit button
        
        JButton exit = new JButton();
        
        exit.setFont(font);
        
        exit.setBackground(Color.BLACK);
        
        exit.setForeground(Color.RED);
		
        exit.setBounds(350, 675, 200, 100);
        
        exit.setFocusPainted(false);
        
        exit.setBorderPainted(false);
		
		exit.setVisible(true);
		
		exit.setText("Exit");
        
		// Create JPanel and JLabel to add logo
		
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        JLabel img = new JLabel(new ImageIcon("TROM.png"));
        panel.add(img);
        Dimension size = img.getMaximumSize();
        img.setBounds(170, 100, size.width, size.height);
       
       // Adding all of the buttons to the JFrame
		
        frame.add(start);
		
		frame.add(settings);
		
		frame.add(exit);
        
        frame.add(credits);
        
        frame.add(img);
		
		frame.setVisible(true);
		
        // Adds action listen and switches game going and timer booleans to start the game
        start.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("START clicked");
        gameGoing = true;
		timer = false;
		startPlaying(gameGoing, frame);
        }
});

        settings.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("SETTINGs clicked");
        }
});

        credits.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("credits clicked");
        }
});
        // Adds aciton listener to exit the game when exit is clicked
        exit.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("EXIT clicked");
		timer = false;
		gameGoing = false;
		startPlaying(gameGoing, frame);
        }
});

    }
	// Method that disposes of the title screen and calls gameGoing
	public static boolean startPlaying(boolean gameGoing, JFrame frame){
	frame.dispose();
	return gameGoing;
	
		}     
}
