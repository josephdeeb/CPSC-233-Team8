import javax.swing.JLabel;

import javax.swing.BorderFactory;

import java.awt.Color;

public class Cell extends JLabel {
    
    public Cell() {
        
        // Sets text to blank
        setText("");
        // Sets background color of cell to black
        setBackground(Color.BLACK);
        // Sets border color to yellow
        setBorder(BorderFactory.createLineBorder(Color.red));
        // Makes the cell opaque (shows color)
        setOpaque(true);
    }
}
