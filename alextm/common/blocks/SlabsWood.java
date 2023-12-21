package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

public class SlabsWood extends BlockSlab {
  public SlabsWood(String name, String texture) {
    super(false, Material.field_151575_d);
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149711_c(3.0F);
    setHarvestLevel("axe", 1);
    func_149713_g(0);
    GameRegistry.registerBlock((Block)this, name);
  }
  
  public String func_150002_b(int p_150002_1_) {
    return null;
  }
}
