import java.awt.Color;

import javax.swing.JFrame;

import java.awt.event.*;

import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.ImageIcon;

import java.awt.Image;
/** 
	 * @author Denis Shevchenko
	 */

public class StartMenu{
	
	private boolean gameGoing = false;
	
	private boolean timer = true;
    
/**
	 * Getter method for gameGoing
     *
	 */
	public boolean getGameGoing() {
	    return gameGoing;
	}
	/**
	 * Setter method for gameGoing
     @param setter to set gameGoing to false
	 */
	public void setGameGoing(boolean setter) {
	    gameGoing = setter;
	}
	/**
	 * Getter method for timer
	 */
	public boolean getTimer() {
	    return timer;
	}
	
    /**
	 * Initializes the start menu.
	 * Creates all the buttons 
	 */
    
    public void run(){
	    //START OF CREATING THE FRAME
        JFrame frame = new JFrame("T R O M");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(500, 500);
        
        frame.getContentPane().setBackground(Color.BLACK); //END OF CREATING THE FRAME
		//START OF CREATING "START" BUTTON 
		JButton start = new JButton();
		
		start.setBounds(175, 50, 100, 50);
		
		start.setVisible(true);
		
		start.setText("START");
        
        start.setBackground(Color.WHITE); //END OF THE CREATING "START" BUTTON
        //START OF CREATING "SETTINGS" BUTTON
        JButton settings = new JButton();
        
        settings.setBounds(175, 125, 100, 50);
        
        settings.setText("Settings");
        
        settings.setBackground(Color.WHITE);
        
        settings.setVisible(true); //END OF CREATING "SETTINGS" BUTTON
		//START OF CREATING "CREDITS" BUTTON
		JButton credits = new JButton();
        
        credits.setBounds(175, 200, 100, 50);
        
        credits.setText("Credits");
        
        credits.setBackground(Color.WHITE);
        
        credits.setVisible(true);//END OF CREATING "CREDITS" BUTTON
        //START OF CREATING "EXIT" BUTTON
		JButton exit = new JButton();
        
        exit.setBounds(175, 275, 100, 50);
        
        exit.setText("EXIT");
        
        exit.setBackground(Color.WHITE);
        
        exit.setVisible(true); //END OF CREATING "EXIT" BUTTON
		//SETTING UP BACKGROND GIF
		JLabel img = new JLabel(new ImageIcon("i.gif"));
		
		img.setLocation(0,0);
		//ADDING ALL THE CREATED COMPONENTS TO THE FRAME AND SETTING IT VISIBLE
		frame.add(start);
		
		frame.add(settings);
		
		frame.add(exit);
        
        frame.add(credits);
        
        frame.add(img);
		
		frame.setVisible(true);
		// ADDING ACTION TO "START" BUTTON WHICH SETS gameGoing TO TRUE AND TIMER TO FALSE
        start.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("START clicked");
        gameGoing = true;
		timer = false;
		frame.dispose();
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
        //ADDING ACTION TO "EXIT" BUTTON WHICH SETS gameGoing TO FALSE AND TIMER TO FALSE
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
