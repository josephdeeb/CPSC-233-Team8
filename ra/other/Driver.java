package other;
import java.awt.Color;
import java.util.Random;

public enum Driver {
    YELLOW(5, 5, Color.YELLOW, "down"), RED(44, 5, Color.RED, "left"), CYAN(44, 44, Color.CYAN, "up"), MAGENTA(5, 44, Color.MAGENTA, "right");
    
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private String DEFAULT_DIRECTION = "down";
    private boolean alive = true;
    private String direction = "down";
    private String oldDirection = "";
    private Color playerColor = Color.YELLOW;
    private int score = 0;
    private Main main;
    
/*    /**
     * Initializes player one
     *
     * @param x - X Coordinate of the wanted cell
     * @param y - Y Coordinate of the wanted cell
     * @param color - Color of the player
    private Driver(int x, int y, Color color, Main initMain) {
        this(x, y, color, initMain, DEFAULT_DIRECTION);
    } 
    
*/
    
    /** 
     * Initializes any extra players past player one
     *
     * @param x - X Coordinate of the wanted cell
     * @param y - Y Coordinate of the wanted cell
     * @param color - Color of the player
     * @param initDirection - Initial Direction of the other players
     */
     private Driver(int x, int y, Color color, String initDirection) {
        xCoordinate = x;
        yCoordinate = y;
        playerColor = color;
        direction = initDirection;
    }
    
    public void setMain(Main initMain) {
        main = initMain;
    }
     
    /**
     * Starts the game by adding player color to cells
     */
    public void start() {
        
        main.getCell(xCoordinate, yCoordinate).colorUpdate(playerColor);
    }
    
    /**
     * Getter for the X Coordinate
     */
    public int getXCoordinate() {
        return xCoordinate;
    }
    
    /**
     * Getter for the Y Coordinate
     */
    public int getYCoordinate() {
        return yCoordinate;
    }
    
    /**
     * Changes the X and Y coordinates based on which direction
     * the player chooses to move
     */
    public void move() {
        
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
        
        /**
         * Tries to see if the next cell is available to move into
         */
        try {
            nextColor = main.getCell(newX, newY).getColor();
        }
        catch (Exception IndexOutOfBounds) {}
        finally {}
        
        /** 
         * If the next cell is available to move into then the cell is updated
         * to show player movement
         */
       
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
       
        if (nextColor.equals(Color.BLACK)) {
            xCoordinate = newX;
            yCoordinate = newY;
            oldDirection = direction;
            score = score + 1;
            main.getCell(xCoordinate, yCoordinate).colorUpdate(playerColor);
        }
        
        // This is for the power up. Power up should last 5 seconds but this
        // is nowhere near complete yet
        /**
        else if(nextColor.equals(Color.BLUE)) {
            long t= System.currentTimeMillis();
            long end = t+4000;
            while(System.currentTimeMillis() < end) {
                xCoordinate = newX;     
                yCoordinate = newY;
                oldDirection = direction;
                Main.getCell(xCoordinate, yCoordinate).colorUpdate(playerColor);
                playerColor = randomColor;
       
        }
               
        }
        */      
       
       else {
            
            alive = false;
        }
    }
    
    /**
     * Getter for if the player is alive
     */
     public boolean getAlive() {
        return alive;
    }
     
    /**
     * Getter for player score
     */
     public int getScore() {
    	 return score;
     }
    
    /** 
     * Setter for the direction
     *
     * @param setter- Sets the direction
     */
    public void setDirection(String setter) {
        if ((setter == "up") || (setter == "down") || (setter == "left") || (setter == "right"))
            direction = setter;
    }
    
    /**
     * Getter for the direction
     */
    public String getDirection() {
        return direction;
    }
    
    /** 
     * Makes sure that the player cannot move in the opposite direction
     *
     * @param dir - Current direction of the player
     */
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
