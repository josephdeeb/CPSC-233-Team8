import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class Settings {
    
    private static boolean boostBool = true;
    private static int numOfPlayers = 2;
    private static int numOfPlayersText = 1;
    private static int difficultySpeed = 100;
    private static boolean gameGoing = false;
    private static boolean timer = true;
    private static StartMenu startMenu = new StartMenu();
    
    /** 
     * Runs the Settings menu
     *
     * @param width Sets the width of the window
     * @param height Sets the height of the window
     * @param name Sets the name of the window
     */
    public static void run(int w,int h, String name){
        
        // Creates a new window
        Window frame = new Window(w, h, name);
        
        // Initalizes new font to be used for JButtons
        Font font = new Font("Arial", Font.BOLD, 40);
        
        // Creates the number of players button
        JButton players = new JButton();
        players.setFont(font);
        players.setBackground(Color.BLACK);
        players.setForeground(Color.YELLOW);
		players.setBounds(350, 345, 200, 100);
        players.setFocusPainted(false);
        players.setBorderPainted(false);
        players.setVisible(true);
		players.setText("2 Player");
        
        // Creates the difficulty button
        JButton difficulty = new JButton();
        difficulty.setFont(font);
        difficulty.setBackground(Color.BLACK);
        difficulty.setForeground(Color.MAGENTA);
		difficulty.setBounds(300, 570, 300, 100);
        difficulty.setFocusPainted(false);
        difficulty.setBorderPainted(false);
        difficulty.setVisible(true);
		difficulty.setText("Easy");
        
        // Creates the boosts toggle button
        JButton boosts = new JButton();
        boosts.setFont(font);
        boosts.setBackground(Color.BLACK);
        boosts.setForeground(Color.GREEN);
		boosts.setBounds(300, 455, 300, 100);
        boosts.setFocusPainted(false);
        boosts.setBorderPainted(false);
        boosts.setVisible(true);
		boosts.setText("Boosts On");
        
        // Creates the back button
        JButton back = new JButton();
        back.setFont(font);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.RED);
		back.setBounds(300, 695, 300, 100);
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setVisible(true);
		back.setText("Back");
        
        // Creates the start game button
        JButton start = new JButton();
        start.setFont(font);
        start.setBackground(Color.BLACK);
        start.setForeground(Color.CYAN);
		start.setBounds(300, 235, 300, 100);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.setVisible(true);
		start.setText("Start");
        
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
            players.setText("2 Player");
            numOfPlayers = 2;
            numOfPlayersText += 1;
        }
        
        else if (numOfPlayersText == 1) {
            players.setText("3 Player");
            numOfPlayers = 3;
            numOfPlayersText += 1;
        }
        
        else if (numOfPlayersText == 2) {
            players.setText("4 Player");
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