package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockWorkbench extends Block {
  public BlockWorkbench(String name, String texture) {
    super(Material.field_151573_f);
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149672_a(Block.field_149777_j);
    func_149711_c(3.0F);
    setHarvestLevel("pickaxe", 1);
    GameRegistry.registerBlock(this, name);
  }
  
  public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par4) {
    if (!world.field_72995_K)
      player.openGui(SkyHard.instance, 4, world, x, y, z); 
    return true;
  }
}
