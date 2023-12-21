package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.util.IIcon;

public class StairsWood extends BlockStairs {
  private int texture_meta;
  
  private Block block_t;
  
  public StairsWood(String name, Block block, int meta) {
    super(block, 0);
    func_149663_c(name);
    func_149647_a(SkyHard.SkyHard);
    func_149711_c(3.0F);
    setHarvestLevel("axe", 1);
    func_149672_a(field_149766_f);
    func_149713_g(0);
    GameRegistry.registerBlock((Block)this, name);
    this.texture_meta = meta;
    this.block_t = block;
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_149691_a(int side, int meta) {
    return this.block_t.func_149691_a(1, this.texture_meta);
  }
}
