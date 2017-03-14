import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
public class Window extends JFrame implements KeyListener {

    /**
     * Creates a window and adds a key listener for keyboard events.
     *
     * @param width Width of the window
     * @param height Height of the window
     * @param name Name of the window
     */
    public Window(int width, int height, String name) {

        // Calls initialize function
        initialize(width, height, name);

        // Uses the key listener and key events to move the object on the grid
        this.addKeyListener(this);
        
    }
    
    /**
     * Determines the effects of the key event.
     *
     * @param event An event from a key press
     */
    public void keyPressed(KeyEvent event) {
                
        // PLAYER 1
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            try {
                Main.getDriver(0).setDirection("right");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            try {
                Main.getDriver(0).setDirection("left");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            try {
                Main.getDriver(0).setDirection("down");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_UP) {
            try {
                Main.getDriver(0).setDirection("up");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }
                
                
        // PLAYER 2
        else if (event.getKeyCode() == KeyEvent.VK_D) {
            try {
                Main.getDriver(1).setDirection("right");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_A) {
            try {
                Main.getDriver(1).setDirection("left");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_S) {
            try {
                Main.getDriver(1).setDirection("down");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_W) {
            try {
                Main.getDriver(1).setDirection("up");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }
                
                
        // PLAYER 3
        else if (event.getKeyCode() == KeyEvent.VK_K) {
            try {
                Main.getDriver(2).setDirection("right");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_H) {
            try {
                Main.getDriver(2).setDirection("left");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_J) {
            try {
                Main.getDriver(2).setDirection("down");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_U) {
            try {
                Main.getDriver(2).setDirection("up");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }
        
    }

    // Required for syntax but has no use in this game.
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    
    /**
     * Initializes and displays the window.
     *
     * @param width Width of the window
     * @param height Height of the window
     * @param name Name of the window
     */
    private void initialize(int width, int height, String name) {

        // Makes it so that the X button, when pressed, exits the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets window size to the specified width and height
        setSize(width, height);

        // Makes frame visible
        getContentPane().setBackground(Color.BLACK);
        setVisible(false);

        // Sets window name
        setName(name);
        setTitle(name);

    }

}

