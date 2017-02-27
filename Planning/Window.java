import javax.swing.JFrame;
import java.awt.event.*;

public class Window extends JFrame {

    public Window(int width, int height, String name) {

        // Calls initialize function
        initialize(width, height, name);

        // Uses the key listener and key events to move the object on the grid
        this.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent key) {
                // PLAYER 1
                if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
                    try {
                        Main.drivers[0].direction = "right";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}

                }

                else if (key.getKeyCode() == KeyEvent.VK_LEFT) {
                    try {
                        Main.drivers[0].direction = "left";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (key.getKeyCode() == KeyEvent.VK_DOWN) {
                    try {
                        Main.drivers[0].direction = "down";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (key.getKeyCode() == KeyEvent.VK_UP) {
                    try {
                        Main.drivers[0].direction = "up";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }
                
                // PLAYER 2
                else if (key.getKeyCode() == KeyEvent.VK_D) {
                    try {
                        Main.drivers[1].direction = "right";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}

                }

                else if (key.getKeyCode() == KeyEvent.VK_A) {
                    try {
                        Main.drivers[1].direction = "left";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (key.getKeyCode() == KeyEvent.VK_S) {
                    try {
                        Main.drivers[1].direction = "down";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (key.getKeyCode() == KeyEvent.VK_W) {
                    try {
                        Main.drivers[1].direction = "up";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }
                
                // PLAYER 3
                else if (key.getKeyCode() == KeyEvent.VK_K) {
                    try {
                        Main.drivers[2].direction = "right";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}

                }

                else if (key.getKeyCode() == KeyEvent.VK_H) {
                    try {
                        Main.drivers[2].direction = "left";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (key.getKeyCode() == KeyEvent.VK_J) {
                    try {
                        Main.drivers[2].direction = "down";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (key.getKeyCode() == KeyEvent.VK_U) {
                    try {
                        Main.drivers[2].direction = "up";
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }
            }

            // Checks which key the user hits and correspondingly moves the
            // object on the grid
            public void keyReleased(KeyEvent e) {

            }

            public void keyTyped(KeyEvent e) {
            }
        });

    }

    public void initialize(int width, int height, String name) {

        // Makes it so that, when pressed, the X button exits the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets window size to the specified width and height
        setSize(width, height);

        // Makes frame visible
        setVisible(true);

        // Sets window name
        setName(name);

    }

}
