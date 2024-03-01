package item;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ItemDoorUp extends Item {
    public ItemDoorUp() {
        name = "Door";
        try{

            image = ImageIO.read(getClass().getResourceAsStream("/res/items/door-up.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
