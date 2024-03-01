package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemDoorLO extends Item{

    public ItemDoorLO()  {
        name = "DoorOpen";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/items/opened-left.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
