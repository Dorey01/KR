package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.world.World;

public class BlocksTorch extends BlockTorch {
  public BlocksTorch(String name, String texture) {
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149713_g(255);
    func_149715_a(1.0F);
    func_149711_c(1.0F);
    GameRegistry.registerBlock((Block)this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149674_a(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
    int l = p_149734_1_.func_72805_g(p_149734_2_, p_149734_3_, p_149734_4_);
    double d0 = (p_149734_2_ + 0.5F);
    double d2 = (p_149734_3_ + 0.7F);
    double d3 = (p_149734_4_ + 0.5F);
    double d4 = 0.2199999988079071D;
    double d5 = 0.27000001072883606D;
    if (l == 1) {
      p_149734_1_.func_72869_a("smoke", d0 - 0.27000001072883606D, d2 + 0.2199999988079071D, d3, 0.0D, 0.0D, 0.0D);
    } else if (l == 2) {
      p_149734_1_.func_72869_a("smoke", d0 + 0.27000001072883606D, d2 + 0.2199999988079071D, d3, 0.0D, 0.0D, 0.0D);
    } else if (l == 3) {
      p_149734_1_.func_72869_a("smoke", d0, d2 + 0.2199999988079071D, d3 - 0.27000001072883606D, 0.0D, 0.0D, 0.0D);
    } else if (l == 4) {
      p_149734_1_.func_72869_a("smoke", d0, d2 + 0.2199999988079071D, d3 + 0.27000001072883606D, 0.0D, 0.0D, 0.0D);
    } else {
      p_149734_1_.func_72869_a("smoke", d0, d2, d3, 0.0D, 0.0D, 0.0D);
    } 
  }
}
