package graphics;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;


public class ButtonCreator extends JButton{
	
    public ButtonCreator(int xCoordinate, int yCoordinate, int width, int height, Color color, String text){
        Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("bin/Tron.ttf"));
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
