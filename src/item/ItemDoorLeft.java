package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemDoorLeft extends Item{

    public ItemDoorLeft() {
        name = "Door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/items/door-left.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
