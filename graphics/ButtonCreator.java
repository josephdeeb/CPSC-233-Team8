package graphics;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class ButtonCreator extends JButton{	
	
    /**
     * Creates a button.
     *
     * @param xCoordinate Gets the x of the button
     * @param yCoordinate Gets the y of the button
     * @param width Determines how wide the button is
     * @param height Determines how high the button is
     * @param color Sets the color of the foreground of the button
     * @param text Sets the name of the button
     */
	
    public ButtonCreator(int xCoordinate, int yCoordinate, int width, int height, Color color, String text){
       
       Font font;
		
        // Try-Catch to check for the available .ttf file
        try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("assets/Tron.ttf"));
			font = font.deriveFont(Font.PLAIN, 50);
		} catch (FontFormatException | IOException error) {
			font = new Font("Arial", Font.BOLD, 40);
		}
        
        setFont(font);
        setBackground(Color.BLACK);
        setForeground(color);
        setBounds(xCoordinate, yCoordinate, width, height);
        setFocusPainted(false);
        setBorderPainted(false);
        setVisible(true);
        setText(text);
    }
    
}
