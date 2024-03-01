package main;

import item.ItemDoorLeft;
import item.ItemDoorRight;
import item.ItemDoorUp;
import item.ItemSheet;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setItem(){
        gp.items[0] = new ItemSheet();
        gp.items[0].worldX = gp.tileSize * 28;
        gp.items[0].worldY = gp.tileSize * 175;

        gp.items[1] = new ItemSheet();
        gp.items[1].worldX = gp.tileSize * 28;
        gp.items[1].worldY = gp.tileSize * 155;

        gp.items[2] = new ItemDoorLeft();
        gp.items[2].worldX = gp.tileSize * 24;
        gp.items[2].worldY = gp.tileSize * 174;

        gp.items[3] = new ItemDoorRight();
        gp.items[3].worldX = gp.tileSize * 27;
        gp.items[3].worldY = gp.tileSize * 174;

        gp.items[4] = new ItemDoorLeft();
        gp.items[4].worldX = gp.tileSize * 24;
        gp.items[4].worldY = gp.tileSize * 167;

        gp.items[5] = new ItemDoorRight();
        gp.items[5].worldX = gp.tileSize * 27;
        gp.items[5].worldY = gp.tileSize * 167;

        gp.items[6] = new ItemDoorLeft();
        gp.items[6].worldX = gp.tileSize * 24;
        gp.items[6].worldY = gp.tileSize * 160;

        gp.items[7] = new ItemDoorRight();
        gp.items[7].worldX = gp.tileSize * 27;
        gp.items[7].worldY = gp.tileSize * 160;

        gp.items[8] = new ItemDoorUp();
        gp.items[8].worldX = gp.tileSize * 25;
        gp.items[8].worldY = gp.tileSize * 157;

        gp.items[9] = new ItemDoorUp();
        gp.items[9].worldX = gp.tileSize * 26;
        gp.items[9].worldY = gp.tileSize * 157;





    }


}
