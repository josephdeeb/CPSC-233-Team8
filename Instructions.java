import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class Instructions {
    
    public static void run(int w,int h, String name) {
        
        Window frame = new Window(w, h, name);
        
        ButtonCreator back = new ButtonCreator(350, 625, 200, 100, Color.RED, "Back");
        
        
        // Create JPanel and JLabel to add logo
		JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        JLabel img = new JLabel(new ImageIcon("INSTRUCTIONS.png"));
        panel.add(img);
        Dimension size = img.getMaximumSize();
        img.setBounds(170, 60, size.width, size.height);
        
        JPanel namesPanel = new JPanel();
        JLabel textLabel = new JLabel("<html><br><br><br>Player 1- Up-&#8593; Left-&#8592; Down-&#8595 Right-&#8594<br><br>Player 2- Up-W Left-A Down-S Right-D<br><br>Player 3- Up-U Left-H Down-J Right-K </html>");
        textLabel.setFont(new Font("Serif", Font.ITALIC, 30));
        textLabel.setForeground(Color.WHITE);
        namesPanel.setBackground(Color.BLACK);
        namesPanel.add(textLabel);
        namesPanel.setSize(600,600);
        namesPanel.setLocation(100,200);
        namesPanel.setVisible(true);
        textLabel.setVisible(true);
        
        frame.add(namesPanel);
        frame.add(back);
        frame.add(img);
        frame.setVisible(true);
        
         // Adds action listener for the back button
        back.addActionListener( new ActionListener(){
    
            public void actionPerformed(ActionEvent e) {
		frame.dispose();
        StartMenu.run(w, h, name);
        }
});

    }
    
}