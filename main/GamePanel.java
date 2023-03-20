import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3; // different screen resolutions

    final int tileSize = originalTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); // bg colour
        this.setDoubleBuffered(true); // better rendering performance
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread() {

        gameThread = new Thread(this); // this = GamePanel class
        gameThread.start(); // Automatically calls run method (see below)
    }

    @Override
    public void run() { // Game Loop!

        while(null != gameThread) {

            // 1 Update character position.
            update();

            // 2 Draw the screen with updated information.
            repaint();

        }

    }

    public void update() {

        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g); // used whenever paintComponent is used.

        Graphics2D g2 = (Graphics2D) g; // A CAST?!?!? (I failed OOP)
                                        // Graphics2D has some functions we'll need later :)

        g2.setColor(Color.white); // Our object

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose(); // Memory saving technique
    }
}   