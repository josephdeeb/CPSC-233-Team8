package graphics;

import javax.swing.JLabel;
import javax.swing.BorderFactory;

import java.awt.Color;

public class Cell extends JLabel {

    private Color currentColor = null;

    public Cell() {

        // Sets text to blank
        setText("");

        // Sets background color of cell to black
        colorUpdate(Color.BLACK);

        // Makes the cell opaque (shows color)
        setOpaque(true);
    }
    
    /**
     * Updates the color of the cell as the player moves
     *
     * @param color Passes in the color of the player
     */
    public void colorUpdate(Color color) {

        setBackground(color);
        currentColor = color;
    }

    /**
     * Getter for currentColor
     */
    public Color getColor() {

        return currentColor;
   
   }

}