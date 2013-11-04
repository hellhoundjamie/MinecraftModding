package JC.Blocks;

import JC.Robotic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;

/**
 * MinecraftDev
 * JCBlock
 *
 * @author Zurrox
 * @license Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License (http://creativecommons.org/licenses/by-nc-nd/3.0/)
 */
public class JCBlock extends Block {
    //TODO: Allowing textures to be added
    public static ArrayList<JCBlock> blocks = new ArrayList<JCBlock>();
    private String name, harvest;
    private int harvestLevel = 0;

    public JCBlock(int id, Material mat, String name) {
        super(id, mat);
        setCreativeTab(Robotic.tab);
        this.name = name;
        setUnlocalizedName(name.replace(' ', '_'));
        blocks.add(this);

        //setTextureName("roboticmod:" + name);
    }


    public JCBlock(int id, Material mat, String name, String harvestTool, int harvestLevel) {
        this(id, mat, name);

        setHarvestTool(harvestTool);
        setHarvestLevel(harvestLevel);
    }

    public void setHarvestTool(String type) {
        if(type.equals("shovel") || type.equals("pickaxe")) harvest = type;
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