import javax.swing.*;

public class Main {

    public static void main (String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.setResizable(false); // Window size constant
        window.setTitle("2D Game"); // Window title

        GamePanel gamePanel = new GamePanel(); 
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread(); // starts the game!

    }
}

// test
