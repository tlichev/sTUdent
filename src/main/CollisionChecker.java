package main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.worldX+ entity.solidPlayerArea.x;
        int entityRightWorldX = entity.worldX+ entity.solidPlayerArea.x + entity.solidPlayerArea.width;
        int entityTopWorldY = entity.worldY+ entity.solidPlayerArea.y ;
        int entityBottomWorldY = entity.worldY+ entity.solidPlayerArea.y + entity.solidPlayerArea.height;


        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/ gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed)/ gp.tileSize;

                tileNum1 = gp.tileM.mapTileMatrix[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileMatrix[entityRightCol][entityTopRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionON = true;

                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed)/ gp.tileSize;

                tileNum1 = gp.tileM.mapTileMatrix[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileMatrix[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionON = true;

                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed)/ gp.tileSize;

                tileNum1 = gp.tileM.mapTileMatrix[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileMatrix[entityLeftCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionON = true;

                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX - entity.speed)/ gp.tileSize;

                tileNum1 = gp.tileM.mapTileMatrix[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileMatrix[entityRightCol][entityBottomRow];

                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    entity.collisionON = true;

                }
                break;
        }
    }


    public int checkItem(Entity entity, boolean player){
        int index = Integer.MAX_VALUE;

        for (int i = 0; i < gp.items.length; i++) {
            if (gp.items[i] != null) {
//                GET ENTITY'S SOLID AREA POSITION
                entity.solidPlayerArea.x = entity.worldX + entity.solidAreaDefaultX;
                entity.solidPlayerArea.y = entity.worldY + entity.solidAreaDefaultY;

//                GET ITEMS SOLID AREA POSSITION
                gp.items[i].solidArea.x = gp.items[i].worldX + gp.items[i].solidArea.x;
                gp.items[i].solidArea.y = gp.items[i].worldY + gp.items[i].solidArea.y;

                switch (entity.direction){
                    case "up":
                        entity.solidPlayerArea.y -= entity.speed;
                        if (entity.solidPlayerArea.intersects(gp.items[i].solidArea)) {
                            if (gp.items[i].collision == true) {
                                entity.collisionON = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                            System.out.println("up ");
                        }
                        break;
                    case "down":
                        entity.solidPlayerArea.y += entity.speed;
                        if (entity.solidPlayerArea.intersects(gp.items[i].solidArea)) {
                            if (gp.items[i].collision == true) {
                                entity.collisionON = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                            System.out.println("down ");
                        }
                        break;
                    case "left":
                        entity.solidPlayerArea.x -= entity.speed;
                        if (entity.solidPlayerArea.intersects(gp.items[i].solidArea)) {
                            if (gp.items[i].collision == true) {
                                entity.collisionON = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                            System.out.println("left ");
                        }
                        break;
                    case "right":
                        entity.solidPlayerArea.x += entity.speed;
                        if (entity.solidPlayerArea.intersects(gp.items[i].solidArea)) {
                            if (gp.items[i].collision == true) {
                                entity.collisionON = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                            System.out.println("right ");
                        }

                        break;
                }

            }
            entity.solidPlayerArea.x = entity.solidAreaDefaultX;
            entity.solidPlayerArea.y = entity.solidAreaDefaultY;

            gp.items[i].solidArea.x = gp.items[i].solidAreaDefaultX;
            gp.items[i].solidArea.y = gp.items[i].solidAreaDefaultY;

        }
        return index;
    }
}
