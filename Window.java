package graphics;

import javax.swing.JFrame;

import logic.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class Window extends JFrame implements KeyListener {
    
    private Main main;
    
    public Window(int width, int height, String name) {
        this(width, height, name, null);
    }

    /**
     * Creates a window and adds a key listener for keyboard events.
     *
     * @param width Width of the window
     * @param height Height of the window
     * @param name Name of the window
     */
    public Window(int width, int height, String name, Main initMain) {
        
        main = initMain;
        
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
                main.getDriver(0).setDirection("right");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            try {
                main.getDriver(0).setDirection("left");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            try {
                main.getDriver(0).setDirection("down");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_UP) {
            try {
                main.getDriver(0).setDirection("up");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }
                
                
        // PLAYER 2
        else if (event.getKeyCode() == KeyEvent.VK_D) {
            try {
                main.getDriver(1).setDirection("right");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_A) {
            try {
                main.getDriver(1).setDirection("left");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_S) {
            try {
                main.getDriver(1).setDirection("down");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_W) {
            try {
                main.getDriver(1).setDirection("up");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }
                
                
        // PLAYER 3
        else if (event.getKeyCode() == KeyEvent.VK_K) {
            try {
                main.getDriver(2).setDirection("right");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_H) {
            try {
                main.getDriver(2).setDirection("left");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_J) {
            try {
                main.getDriver(2).setDirection("down");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_U) {
            try {
                main.getDriver(2).setDirection("up");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }
        
        
        // PLAYER 4
        else if (event.getKeyCode() == KeyEvent.VK_NUMPAD6) {
            try {
                main.getDriver(3).setDirection("right");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_NUMPAD4) {
            try {
                main.getDriver(3).setDirection("left");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_NUMPAD5) {
            try {
                main.getDriver(3).setDirection("down");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }

        else if (event.getKeyCode() == KeyEvent.VK_NUMPAD8) {
            try {
                main.getDriver(3).setDirection("up");
            }
            catch(ArrayIndexOutOfBoundsException exception) {}
        }
        
    }

    // Required for syntax but has no use in this game.
    public void keyReleased(KeyEvent event) {}
    public void keyTyped(KeyEvent event) {}

    
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

        // Sets window characteristics
        setSize(width, height);
        getContentPane().setBackground(Color.BLACK);
        setVisible(false);
        setName(name);
        setTitle(name);

    }

}