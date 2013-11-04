package JC.Blocks;

import JC.Robotic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import java.util.ArrayList;

/**
 * MinecraftDev
 * JCBlock
 *
 * @author Zurrox
 * @license Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License (http://creativecommons.org/licenses/by-nc-nd/3.0/)
 */
public class JCBlock extends Block {
    public static ArrayList<JCBlock> blocks = new ArrayList<JCBlock>();
    private String name, harvest;
    private int harvestLevel = 0;

    public JCBlock(int id, Material mat, String name) {
        super(id, mat);
        setCreativeTab(Robotic.roboticBlocks);
        this.name = name;
        setUnlocalizedName(name.replace(' ', '_'));
        blocks.add(this);
    }

    public JCBlock(int id, Material mat, String name, String harvestTool, int harvestLevel) {
        this(id, mat, name);

        setHarvestTool(harvestTool);
        setHarvestLevel(harvestLevel);
    }

    @Override
    public void registerIcons(IconRegister reg) {
        String[] str = name.split(" ");

        if(str.length > 1) blockIcon = reg.registerIcon("robotic:" + str[0].toLowerCase() + str[1]);
        else blockIcon = reg.registerIcon("robotic:" + str[0].toLowerCase());
    }

    public void setHarvestTool(String type) {
        if(type.equals("shovel") || type.equals("pickaxe") || type.equals("axe")) harvest = type;
        else harvest = null;
    }

    public void setHarvestLevel(int level) {
        if(level > 0) harvestLevel = level;
        else harvest = null;
    }

    public String getName() {
        return name;
    }

    public String getHarvestTool() {
        return harvest;
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }
}