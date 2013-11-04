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
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

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
    public static CreativeTabs tab = new CreativeTabs("Robotic");

    @Instance(value = BaseStrings.MODID)
    public static Robotic instance;

    @SidedProxy(clientSide = "JC.Proxies.ClientProxy", serverSide = "JC.Proxies.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        JCBlock block = new JCBlock(500, Material.ground, "Stone");

        Registry.blocks();
        Registry.items();

        LanguageRegistry.instance().addStringLocalization("itemGroup.Robotic", "Robotic Tab");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }
}