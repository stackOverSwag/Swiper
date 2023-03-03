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
    publiv void run() { // Game Loop!


    }

}   