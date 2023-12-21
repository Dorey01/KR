package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;

public class FencesStone extends BlockFence {
  public FencesStone(String name, String texture) {
    super(texture, Material.field_151573_f);
    func_149663_c(name);
    func_149647_a(SkyHard.SkyHard);
    func_149672_a(field_149769_e);
    func_149711_c(3.0F);
    setHarvestLevel("pickaxe", 1);
    GameRegistry.registerBlock((Block)this, name);
  }
}
