package entity;

import item.ItemDoorLeft;
import item.ItemDoorRight;
import item.ItemSheet;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasProtocols = 0;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2- (gp.tileSize/2);

        solidPlayerArea = new Rectangle();
        solidPlayerArea.x = 20;
        solidPlayerArea.y = 20;

        solidAreaDefaultX = solidPlayerArea.x;
        solidAreaDefaultY = solidPlayerArea.y;

        solidPlayerArea.width = 20;
        solidPlayerArea.height = 20;


        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize*26;
        worldY = gp.tileSize*177;
        speed = 4;
        direction= "up";
    }

    public void getPlayerImage(){

        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/up1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/up2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/res/player/right2.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {


            if (keyH.upPressed == true) {
                direction = "up";

            }
            else if (keyH.downPressed == true ) {
                direction = "down";

            }
            else if (keyH.leftPressed == true ) {
                direction = "left";

            }
            else if (keyH.rightPressed == true ) {
                direction = "right";

            }

//            CHECK TILE COLLISION
            collisionON = false;
            gp.cChecker.checkTile(this);
            int itemIdx = gp.cChecker.checkItem(this, true);
            pickUpItem(itemIdx);

//            IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionON == false) {
                switch (direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }


            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter =0;
            }
        }

    }

    public void pickUpItem(int index){
        if(index != Integer.MAX_VALUE){
            if (gp.items[index] instanceof ItemDoorLeft ||gp.items[index] instanceof ItemDoorRight){
                gp.items[index] = new ItemSheet();
            }else if (gp.items[index] instanceof ItemSheet){
                gp.items[index] = new ItemSheet();
                this.hasProtocols ++;


            }
    }

    }

    public void draw(Graphics2D g2){
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;

        switch (direction){
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case  "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
