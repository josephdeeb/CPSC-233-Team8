import javax.swing.JFrame;
import java.awt.event.*;

public class Window extends JFrame {

    public Window(int width, int height, String name) {

        // Calls initialize function
        initialize(width, height, name);

        // Uses the key listener and key events to move the object on the grid
        this.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                // PLAYER 1
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    try {
                        Main.getDriver(0).setDirection("right");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}

                }

                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    try {
                        Main.getDriver(0).setDirection("left");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    try {
                        Main.getDriver(0).setDirection("down");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    try {
                        Main.getDriver(0).setDirection("up");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }
                
                // PLAYER 2
                else if (e.getKeyCode() == KeyEvent.VK_D) {
                    try {
                        Main.getDriver(1).setDirection("right");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}

                }

                else if (e.getKeyCode() == KeyEvent.VK_A) {
                    try {
                        Main.getDriver(1).setDirection("left");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (e.getKeyCode() == KeyEvent.VK_S) {
                    try {
                        Main.getDriver(1).setDirection("down");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (e.getKeyCode() == KeyEvent.VK_W) {
                    try {
                        Main.getDriver(1).setDirection("up");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }
                
                // PLAYER 3
                else if (e.getKeyCode() == KeyEvent.VK_K) {
                    try {
                        Main.getDriver(2).setDirection("right");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}

                }

                else if (e.getKeyCode() == KeyEvent.VK_H) {
                    try {
                        Main.getDriver(2).setDirection("left");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (e.getKeyCode() == KeyEvent.VK_J) {
                    try {
                        Main.getDriver(2).setDirection("down");
                    }
                    catch(ArrayIndexOutOfBoundsException exception) {}
                }

                else if (e.getKeyCode() == KeyEvent.VK_U) {
                    try {
                        Main.getDriver(2).setDirection("up");
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

    private void initialize(int width, int height, String name) {

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
