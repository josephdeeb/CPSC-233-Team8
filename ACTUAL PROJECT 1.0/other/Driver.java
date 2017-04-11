package other;
import java.awt.Color;
import java.util.Random;

public class Driver {
    
    private int xCoordinate = 0;
    private int yCoordinate = 0;
    private int defaultXCoordinate = 0;
    private int defaultYCoordinate = 0;
    private String DEFAULT_DIRECTION = "down";
    private boolean alive = true;
    private String direction = "down";
    private String oldDirection = "";
    private Color playerColor = Color.YELLOW;
    private Color defaultColor = Color.YELLOW;
    private int score = 0;
    private Main main;
    private boolean boost = false;
    private int boostCount = 0;
    
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
     public Driver(int x, int y, Color color, String initDirection) {
        xCoordinate = x;
        defaultXCoordinate = x;
        yCoordinate = y;
        defaultYCoordinate = y;
        playerColor = color;
        defaultColor = color;
        direction = initDirection;
     }
     
    public void resetDriver() {
        xCoordinate = defaultXCoordinate;
        yCoordinate = defaultYCoordinate;
        alive = true;
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
        
        /** 
         * If the next cell is available to move into then the cell is updated
         * to show player movement
         */
       
       
       
       if (boost) {
           try {
               xCoordinate = newX;
               yCoordinate = newY;
               oldDirection = direction;
               score = score + 1;
               Random rand = new Random();
               float r = rand.nextFloat();
               float g = rand.nextFloat();
               float b = rand.nextFloat();
               Color randomColor = new Color(r, g, b);
               playerColor = randomColor;
               boostCount++;
               if (boostCount > 30) {
                   if (boostCount % 2 == 1)
                       playerColor = defaultColor;
                   if (boostCount % 2 == 0)
                       playerColor = new Color (45,45,45);
               }
               main.getCell(xCoordinate, yCoordinate).colorUpdate(playerColor);
                   
           }
           catch (Exception IndexOutOfBounds) {
               alive = false;
           }
           
       }
       else if(nextColor.equals(Color.BLUE)) {
            boost = true;
            boostCount = 0;
            xCoordinate = newX;
            yCoordinate = newY;
        }
       
       else if (nextColor.equals(Color.BLACK)) {
            xCoordinate = newX;
            yCoordinate = newY;
            oldDirection = direction;
            score = score + 1;
            main.getCell(xCoordinate, yCoordinate).colorUpdate(playerColor);
       }
       
       else {
           alive = false;
       }
        
        if (boostCount == 45) {
            boost = false;
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
     * Gets player color
     */
    public Color getPlayerColor() {
        return defaultColor;
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
