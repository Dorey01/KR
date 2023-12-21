package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlocksFire extends Block {
  public BlocksFire(String name, String texture) {
    super(Material.field_151576_e);
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149715_a(1.0F);
    func_149713_g(255);
    func_149675_a(true);
    GameRegistry.registerBlock(this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public int func_149645_b() {
    return 1;
  }
  
  @SideOnly(Side.CLIENT)
  public boolean func_149662_c() {
    return false;
  }
  
  public boolean func_149686_d() {
    return false;
  }
  
  public AxisAlignedBB func_149668_a(World par1World, int par2, int par3, int par4) {
    return null;
  }
  
  public void func_149670_a(World world, int x, int y, int z, Entity entity) {
    if (entity instanceof net.minecraft.entity.player.EntityPlayer)
      entity.func_70097_a(DamageSource.field_76376_m, 50000.0F); 
  }
  
  public int func_149738_a(World world) {
    return 30;
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149734_b(World world, int x, int y, int z, Random rand) {
    float f = x + rand.nextFloat();
    float f2 = y + rand.nextFloat();
    float f3 = z + rand.nextFloat();
    world.func_72869_a("largesmoke", f, f2, f3, 0.0D, 0.0D, 0.0D);
  }
}
