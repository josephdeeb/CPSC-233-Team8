import javax.swing.JFrame;
import java.awt.event.*;

public class Window extends JFrame {
	
	public Window(int width, int height, String name) {
        
		// Calls initialize function
        initialize(width, height, name);
		
		// Uses the key listener and key events to move the object on the grid
		this.addKeyListener(new KeyListener(){
		public void keyPressed(KeyEvent e) {
		}

		// Checks which key the user hits and correspondingly moves the object on the grid
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()== KeyEvent.VK_RIGHT){
				Main.drawUpdate(Main.x+1, Main.y);
			}
			
			else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				Main.drawUpdate(Main.x-1, Main.y);
			}
					
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				Main.drawUpdate(Main.x, Main.y+1);
			}
					
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				Main.drawUpdate(Main.x, Main.y-1);
			}
			
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
