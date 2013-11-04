package JC;

import JC.Blocks.JCBlock;
import JC.Items.JCItem;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.MinecraftForge;

import java.util.Iterator;

/**
 * MinecraftDev
 * Registry
 *
 * @author Zurrox
 * @license Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License (http://creativecommons.org/licenses/by-nc-nd/3.0/)
 */
public class Registry {
    public static void blocks() {
        Iterator itr = JCBlock.blocks.iterator();

        while(itr.hasNext()) {
            JCBlock bl = (JCBlock) itr.next();
            GameRegistry.registerBlock(bl, bl.getUnlocalizedName().substring(4));
            LanguageRegistry.addName(bl, bl.getName());
            if(bl.getHarvestTool() != null) {
                MinecraftForge.setBlockHarvestLevel(bl, bl.getHarvestTool(), bl.getHarvestLevel());
            }

        }
    }

    public static void items() {
        Iterator itr = JCItem.items.iterator();

        while(itr.hasNext()) {
            JCItem it = (JCItem) itr.next();
            GameRegistry.registerItem(it, it.getUnlocalizedName().substring(4));
            LanguageRegistry.addName(it, it.getName());
        }
    }
}