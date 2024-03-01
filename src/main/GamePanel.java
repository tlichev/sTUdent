package main;

import entity.Player;
import item.Item;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //    SCREEN SETTINGS
    public int originalTileSize = 16;
    public int scale = 4;
    public int tileSize = originalTileSize * scale;

    public int maxScreenCol = 24;
    public int maxScreenRow = 12;

    public int screenWidth = tileSize * maxScreenCol;
    public int screenHeight = tileSize * maxScreenRow;


//    WORLD SETTINGS

    public final int maxWorldCol = 53;
    public final int maxWorldRow = 190;
    public final int worldWidth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;

    //    FPS
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public Item items[] = new Item[10];

//    Set player's default position
//    int playerX = 100;
//
//    int playerY = 100;
//
//    int playerSpeed = 4;



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.blue);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setItem();
    }




    public void startGameThread(){
        gameThread = new Thread(this );
        gameThread.start();
    }



    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) /drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS" + drawCount);
                drawCount = 0;
                timer = 0;

            }



        }
    }

    public void update(){
        player.update();

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
//        TILE part
        tileM.draw(g2);

//        Item part
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                items[i].draw(g2,this);
            }
            
        }


//        Player part
        player.draw(g2);



        g2.dispose();

    }
}