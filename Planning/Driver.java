import java.awt.Color;


public class Driver {
    
    public static int xCoordinate = 0;
    public static int yCoordinate = 0;
    public static String direction = "down";
    public static String oldDirection = "down";
    public static Color playerColor = Color.YELLOW;
    
    public Driver(int x, int y, Color color) {
        
        initialize(x, y, color);
    }
    
    // Initializes the x, y location, and color, of the driver.
    public static void initialize(int x, int y, Color color) {
        
        xCoordinate = x;
        yCoordinate = y;
        playerColor = color;
    }
    
    // Actually draws the drivers start position on the board.
    public static void start() {
        
        Main.labels[xCoordinate][yCoordinate].colorUpdate(playerColor);
    }
    
    // The movement function
    public static void move() {
        
        int newX = 0, newY = 0;
        int oldX = xCoordinate, oldY = yCoordinate;
        String reversed = reverseDirection(oldDirection);
        
        
        // If the new direction is the reverse of the current direction, ignore the input
        if (direction.equals(reversed)) {
            
            direction = oldDirection;
        }
        
        // Creates the new coordinates that the driver is moving to based on direction.
        switch (direction) {
        
        case "up":
            newY = (oldY - 1);
            newX = oldX;
            break;
        case "right":
            newX = (oldX + 1);
            newY = oldY;
            break;
        case "down":
            newY = (oldY + 1);
            newX = oldX;
            break;
        case "left":
            newX = (oldX - 1);
            newY = oldY;
            break;
        default:
            System.out.println("ERROR: NO DIRECTION IN switch (direction) IN DRIVER move()");
            break;
        }
        
        Color nextColor = playerColor;
        
        try {
            
            nextColor = Main.labels[newX][newY].getColor();
        }
        catch (Exception IndexOutOfBounds) {}
        
        if (nextColor.equals(Color.BLACK)) {
            xCoordinate = newX;
            yCoordinate = newY;
            oldDirection = direction;
            Main.labels[xCoordinate][yCoordinate].colorUpdate(playerColor);
        }
        else {
            
            // This means that the next space is not black.
            // Should destroy driver
            Main.gameGoing = false;
        }
    }
    
    // Mostly ignorable function, just takes a string as input and returns the opposite direction as the input.
    // Just used to prevent pressing backwards and dying.
    public static String reverseDirection(String dir) {
        String reversed = "";
        
        if (dir.equals("up"))
            reversed = "down";
        else if (dir.equals("down"))
            reversed = "up";
        else if (dir.equals("right"))
            reversed = "left";
        else if (dir.equals("left"))
            reversed = "right";
        else
            System.out.println("ERROR: NO VALID DIRECTION GIVEN IN reverseDirection");
        return reversed;
    }
}
