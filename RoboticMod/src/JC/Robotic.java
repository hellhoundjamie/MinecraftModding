package JC;

import JC.Blocks.JCBlock;
import JC.Proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * MinecraftDev
 * JC.Robotic
 *
 * @author Zurrox
 * @license Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License (http://creativecommons.org/licenses/by-nc-nd/3.0/)
 */

@Mod(modid = BaseStrings.MODID, name = BaseStrings.NAME, version = BaseStrings.VERSION)
@NetworkMod(clientSideRequired = true)
public class Robotic {
    @Instance(value = BaseStrings.MODID)
    public static Robotic instance;

    @SidedProxy(clientSide = "JC.Proxies.ClientProxy", serverSide = "JC.Proxies.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        JCBlock block = new JCBlock(500, Material.ground, "Stone");

        Registry.blocks();
        Registry.items();

        LanguageRegistry.instance().addStringLocalization("itemGroup.robBlocks", "Robotic Blocks");
        LanguageRegistry.instance().addStringLocalization("itemGroup.robItems", "Robotic Items");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }

    public static CreativeTabs roboticBlocks = new CreativeTabs("robBlocks") {
        public ItemStack getIconItemStack() {
            return new ItemStack(Block.coalBlock, 1, 0);
        }
    };

    public static CreativeTabs roboticItems = new CreativeTabs("robItems") {
        public ItemStack getIconItemStack() {
            return new ItemStack(Item.eyeOfEnder, 1, 0);
        }
    };
}