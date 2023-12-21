package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlocksOre extends Block {
  public BlocksOre(String name, String texture) {
    super(Material.field_151576_e);
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149672_a(Block.field_149769_e);
    func_149711_c(3.0F);
    setHarvestLevel("pickaxe", 3);
    GameRegistry.registerBlock(this, name);
  }
}
