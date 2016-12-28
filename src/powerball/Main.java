package powerball;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        GUIWindow theGUI = new GUIWindow();
        theGUI.setTitle("Welcome to Powerball!");
        theGUI.pack();
        theGUI.setLocationRelativeTo(null);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
        theGUI.setResizable(false);
    }
}
