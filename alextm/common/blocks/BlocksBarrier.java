package alextm.common.blocks;

import alextm.SkyHard;
import alextm.proxy.ClientProxy;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlocksBarrier extends Block {
  @SideOnly(Side.CLIENT)
  public IIcon icon1;
  
  @SideOnly(Side.CLIENT)
  public IIcon icon2;
  
  public BlocksBarrier(String name) {
    super(Material.field_151592_s);
    func_149663_c(name);
    func_149658_d("alextm:barrier/barrier");
    func_149647_a(SkyHard.SkyHard);
    func_149672_a(Block.field_149778_k);
    func_149722_s();
    func_149649_H();
    func_149752_b(6000000.0F);
    GameRegistry.registerBlock(this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public String func_149702_O() {
    return "alextm:barrier_icon";
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149651_a(IIconRegister par1IconRegister) {
    this.icon1 = par1IconRegister.func_94245_a("alextm:barrier/barrier");
    this.icon2 = par1IconRegister.func_94245_a("alextm:barrier/barrier2");
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149734_b(World world, int x, int y, int z, Random rand) {}
  
  @SideOnly(Side.CLIENT)
  public int func_149645_b() {
    return ClientProxy.modelID2;
  }
  
  public boolean func_149662_c() {
    return false;
  }
}
