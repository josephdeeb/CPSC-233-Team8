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
    
    public static void initialize(int x, int y, Color color) {
        
        xCoordinate = x;
        yCoordinate = y;
        playerColor = color;
    }
    
    public static void start() {
        
        Main.labels[xCoordinate][yCoordinate].colorUpdate(playerColor);
    }
    public static void move() {
        
        int newX = 0, newY = 0;
        int oldX = xCoordinate, oldY = yCoordinate;
        String reversed = reverseDirection(oldDirection);
        
        
        if (direction.equals(reversed)) {
            
            direction = oldDirection;
        }

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
                System.out.println("ERROR: NO DIRECTION IN DRIVER");
                break;
            }
        
        Color nextColor = Color.YELLOW;
        
        try {
            
            nextColor = Main.labels[newX][newY].getColor();
        }
        catch (Exception IndexOutOfBounds) {}
        finally {}
        
        if (nextColor.equals(Color.BLACK)) {
            xCoordinate = newX;
            yCoordinate = newY;
            oldDirection = direction;
            Main.labels[xCoordinate][yCoordinate].colorUpdate(playerColor);
        }
        else {
            
            // stops the main game loop
            // for multiple players, should make only the current driver stop
            Main.stopGame();
        }
    }
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
