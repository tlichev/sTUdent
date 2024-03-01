package item;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class ItemSheet extends Item{

    public ItemSheet() {
        name = "Sheet";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/items/sheet.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
