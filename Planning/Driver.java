import java.awt.Color;


public class Driver {
    
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private static String DEFAULT_DIRECTION = "down";
    private boolean alive = true;
    private String direction = "down";
    private String oldDirection = "";
    private Color playerColor = Color.YELLOW;
    
    public Driver(int x, int y, Color color) {
        this(x, y, color, DEFAULT_DIRECTION);
    }
    
    public Driver(int x, int y, Color color, String initDirection) {
        xCoordinate = x;
        yCoordinate = y;
        playerColor = color;
        direction = initDirection;
    }
    
    
    private void start() {
        
        Main.labels[xCoordinate][yCoordinate].colorUpdate(playerColor);
    }
    private void move() {
        
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
            alive = false;
        }
    }
    public boolean getAlive() {
        return alive;
    }
    
    private static String reverseDirection(String dir) {
        String reversed = "";
        
        if (dir.equals("up"))
            reversed = "down";
        else if (dir.equals("down"))
            reversed = "up";
        else if (dir.equals("right"))
            reversed = "left";
        else if (dir.equals("left"))
            reversed = "right";
        return reversed;
    }
}
