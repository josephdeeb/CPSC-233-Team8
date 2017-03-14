import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class Settings{
    private static boolean boosts = false;
    private static int numOfPlayers = 2;
    int difficulty = 100;
    public static void run(int w,int h,String name){
        Window frame = new Window(w, h, name);
        
        JPanel panelForBoosts = new JPanel();
        panelForBoosts.setBounds(350, 100, 200, 50);
        panelForBoosts.setBackground(Color.BLACK);
        
        JCheckBox boostsCheckbox = new JCheckBox("<html>Check off this Box if you'd like<br>to play with boosts</html>");
        boostsCheckbox.setBackground(Color.BLACK);
        boostsCheckbox.setForeground(Color.WHITE);
        
        panelForBoosts.add(boostsCheckbox);
        
        frame.add(panelForBoosts);
        
        JTextField players = new JTextField("Current number of players is2. Type in the number of players you want. Remember, this game is 1-4 players");
        
        players.setBounds(200,200, 200, 200);
        
        frame.add(players);
        
        players.setVisible(true);
        
        panelForBoosts.setVisible(true);
        
        boostsCheckbox.setVisible(true);
        
        frame.setVisible(true);
        
        boostsCheckbox.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            boosts = true;
        
        } else {
            boosts = false;
        };
    }
});
             
    }
}