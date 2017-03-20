import java.awt.*;
import javax.swing.*;
public class ButtonCreator extends JButton{
    public ButtonCreator(int width, int height, int xCoordinate, int yCoordinate, Color color, String text){
        Font font = new Font("Arial", Font.BOLD, 40);
        setFont(font);
        setBackground(Color.BLACK);
        setForeground(color);
		setBounds(width, height, xCoordinate, yCoordinate);
        setFocusPainted(false);
        setBorderPainted(false);
        setVisible(true);
        setText(text);
    }
}
