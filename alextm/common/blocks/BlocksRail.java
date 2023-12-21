package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;

public class BlocksRail extends BlockRail {
  public BlocksRail(String name, String texture) {
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149711_c(1.0F);
    GameRegistry.registerBlock((Block)this, name);
  }
}
