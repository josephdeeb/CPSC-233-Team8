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
        Font font = new Font("Arial", Font.BOLD, 40);
		
        // Create start button
	    JButton start = new JButton();
        start.setFont(font);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.CYAN);
		start.setBounds(300, 260, 300, 100);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.setVisible(true);
        start.setText("Play Game");
         
        // Create instructions button
        JButton instructions = new JButton();
        instructions.setFont(font);
        instructions.setBackground(Color.BLACK);
        instructions.setForeground(Color.YELLOW);
		instructions.setBounds(300, 390, 300, 100);
        instructions.setFocusPainted(false);
        instructions.setBorderPainted(false);
        instructions.setVisible(true);
		instructions.setText("Instructions");
        
        // Create credits button
        JButton credits = new JButton();
        credits.setFont(font);
        credits.setBackground(Color.BLACK);
        credits.setForeground(Color.MAGENTA);
		credits.setBounds(350, 520, 200, 100);
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
		exit.setBounds(350, 650, 200, 100);
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
        Settings.run(w, h, name);
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
        JButton exitCredits = new JButton();
        
        // Creates Exit Button within the credits
        exitCredits.setFont(font);
        exitCredits.setBackground(Color.BLACK);
        exitCredits.setForeground(Color.RED);
		exitCredits.setBounds(350, 695, 200, 100);
        exitCredits.setFocusPainted(false);
        exitCredits.setBorderPainted(false);
        exitCredits.setVisible(true);
        exitCredits.setText("Back");
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
		frame.dispose();
        }
});

    }
	  
}

