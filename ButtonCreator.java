import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
public class ButtonCreator extends JButton{
    public static void createButton(int width, int height, int xCoordinate, int yCoordinate, Color color, String text){
        Font font = new Font("Arial", Font.BOLD, 40);
        JButton makeAButton = new JButton();
        makeAButton.setFont(font);
        makeAButton.setBackground(Color.BLACK);
        makeAButton.setForeground(color);
		makeAButton.setBounds(width, height, xCoordinate, yCoordinate);
        makeAButton.setFocusPainted(false);
        makeAButton.setBorderPainted(false);
        makeAButton.setVisible(true);
        makeAButton.setText(text);
    }
}