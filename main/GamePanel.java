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

    Thread gameThread; 


    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black); // bg colour
        this.setDoubleBuffered(true); // better rendering performance

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

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g); // used whenever paintComponent is used.

        Graphics2D g2 = (Graphics2D) g; // A CAST?!?!? (I failed OOP)
                                        // Graphics2D has some functions we'll need later :)

        g2.setColor(Color.white); // Our object

        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose(); // Memory saving technique
    }
}   