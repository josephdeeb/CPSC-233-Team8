import javax.swing.JLabel;

import javax.swing.BorderFactory;

import java.awt.Color;

public class Cell extends JLabel {

    public Color currentColor = null;

    public Cell() {

        // Sets text to blank
        setText("");

        // Sets background color of cell to black
        colorUpdate(Color.BLACK);

        // Sets border color to yellow
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Makes the cell opaque (shows color)
        setOpaque(true);
    }

    public void colorUpdate(Color color) {

        setBackground(color);
        currentColor = color;
    }

    public Color getColor() {

        return currentColor;
    }
}
