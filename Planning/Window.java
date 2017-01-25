import javax.swing.JFrame;


public class Window extends JFrame {
    public Window(int w, int h, String n) {
        // Calls initialize function
        initialize(w, h, n);
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
        // Sets window title
		setTitle(getName());
    }
}
