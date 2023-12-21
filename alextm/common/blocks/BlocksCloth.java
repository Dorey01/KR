package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.IBlockAccess;

public class BlocksCloth extends BlockLadder {
  public BlocksCloth(String name, String texture) {
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149711_c(1.0F);
    GameRegistry.registerBlock((Block)this, name);
  }
  
  public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity) {
    return false;
  }
}
