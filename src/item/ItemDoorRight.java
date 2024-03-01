package item;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemDoorRight extends Item {
    public ItemDoorRight() {
        name = "Door";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/res/items/door-right.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
