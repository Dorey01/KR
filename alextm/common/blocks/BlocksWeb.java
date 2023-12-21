package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlocksWeb extends Block {
  private String texture;
  
  public BlocksWeb(String name, String texture) {
    super(Material.field_151569_G);
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149713_g(0);
    GameRegistry.registerBlock(this, name);
  }
  
  public boolean func_149662_c() {
    return false;
  }
  
  public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
    return null;
  }
  
  public int func_149645_b() {
    return 1;
  }
  
  public boolean func_149686_d() {
    return false;
  }
  
  protected boolean func_149700_E() {
    return true;
  }
  
  public void onImpact(World world, int x, int y, int z, Entity entity) {
    entity.func_70110_aj();
    entity.func_70097_a(DamageSource.field_76376_m, 1.0F);
  }
}
