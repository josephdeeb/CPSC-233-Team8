import java.util.Scanner;

import java.awt.Color;

import javax.swing.JFrame;

import java.awt.event.*;

import javax.swing.JButton;

import javax.swing.JLabel;

import javax.swing.ImageIcon;

import java.awt.Image;

import javax.imageio.ImageIO;

public class StartMenu{
	public static boolean gameGoing = false;

    public static void run(){
	   
        JFrame frame = new JFrame("T R O M");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(500, 500);
        
        frame.getContentPane().setBackground(Color.BLACK);
		
		JButton start = new JButton();
		
		start.setBounds(175, 50, 100, 50);
		
		start.setVisible(true);
		
		start.setText("START");
        
        start.setBackground(Color.WHITE);
        
        JButton settings = new JButton();
        
        settings.setBounds(175, 125, 100, 50);
        
        settings.setText("Settings");
        
        settings.setBackground(Color.WHITE);
        
        settings.setVisible(true);
        
        frame.add(start);
        
        frame.add(settings);
		
		JLabel img = new JLabel(new ImageIcon("C:\\Users\\Denis\\Desktop\\i.gif"));
		
		JButton credits = new JButton();
        
        credits.setBounds(175, 200, 100, 50);
        
        credits.setText("Credits");
        
        credits.setBackground(Color.WHITE);
        
        credits.setVisible(true);
        
        frame.add(credits);
		
		JButton exit = new JButton();
        
        exit.setBounds(175, 275, 100, 50);
        
        exit.setText("EXIT");
        
        exit.setBackground(Color.WHITE);
        
        exit.setVisible(true);
		
		frame.add(exit);
        
        frame.add(credits);
		
		img.setLocation(0,0);
        
        frame.add(img);
		
		frame.setVisible(true);
		
        start.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("START clicked");
        gameGoing = true;
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

        exit.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e){
        System.out.println("EXIT clicked");
        frame.dispose();
		gameGoing = false;
		startPlaying(gameGoing, frame);
        }
});

    }
	public static boolean startPlaying(boolean gameGoing, JFrame frame){
	frame.dispose();
	return gameGoing;
	
		}     
}
