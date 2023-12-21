package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;

public class BlocksLadder extends BlockLadder {
  public BlocksLadder(String name, String texture) {
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149711_c(3.0F);
    func_149672_a(field_149774_o);
    setHarvestLevel("axe", 1);
    GameRegistry.registerBlock((Block)this, name);
  }
}
