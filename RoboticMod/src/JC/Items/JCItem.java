package JC.Items;

import JC.Robotic;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import java.util.ArrayList;

/**
 * MinecraftDev
 * JCItem
 *
 * @author Zurrox
 * @license Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License (http://creativecommons.org/licenses/by-nc-nd/3.0/)
 */
public class JCItem extends Item {
    public static ArrayList<JCItem> items = new ArrayList<JCItem>();
    private String name;

    public JCItem(int id, String name) {
        super(id);
        setCreativeTab(Robotic.tab);
        setUnlocalizedName(name.replace(' ', '_'));
        this.name = name;
    }

    @Override
    public void registerIcons(IconRegister reg) {
        String[] str = name.split(" ");

        this.itemIcon = reg.registerIcon("roboticmod:blocks/" + str[0] + str != null ? str[1] : "");
        ;
    }

    public String getName() {
        return name;
    }
}
