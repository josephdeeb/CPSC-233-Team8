package other;

public class Run {
    
    /**
     * whether or not main is being run
     */
    public static boolean running = true;

    /**
     * Main method that constantly creates a new main while the user wants it, until the exit game is pressed
     */
    public static void main(String[] args) {
        Main main = null;
        while (running) {
            main = new Main();
            running = main.start();
        }
    }
}
