package logic;

public class Run {
    public static boolean running = true;

    public static void main(String[] args) {
        Main main = null;
        while (running) {
            main = new Main();
            running = main.start();
            if(main.getSettings().startMenu.getGameGoing()==false){
                running = false;
            }
        }

    }

}
