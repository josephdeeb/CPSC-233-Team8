import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Color;

/*
 *@author Team 8
 */
public class Cell extends JLabel {
    /**
     *Used to set the current color
     */
    private Color currentColor = null;
    
    /**
     *Initializes the properties of the cell, which inherits properties from JLabel
     *
     *Sets the cells as black, opaque, textless cells
     */
    public Cell() {
        setText("");
        colorUpdate(Color.BLACK);
        setOpaque(true);
    }
    
    /**
     *Updates the current color to the argument given
     *
     *@param  color The new color to change the cells to
     */
    public void colorUpdate(Color color) {
        setBackground(color);
        currentColor = color;
    }

    /**
     *Getter that returns the current color
     *
     *@return the current color
     */
    public Color getColor() {
        return currentColor;
    }
}
