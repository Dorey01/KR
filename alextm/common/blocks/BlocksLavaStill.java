package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlocksLavaStill extends BlockLiquid {
  @SideOnly(Side.CLIENT)
  protected IIcon[] fluidIcon;
  
  public BlocksLavaStill(String name) {
    super(Material.field_151587_i);
    func_149663_c(name);
    func_149647_a(SkyHard.SkyHard);
    func_149715_a(1.0F);
    func_149713_g(255);
    GameRegistry.registerBlock((Block)this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149651_a(IIconRegister iconRegister) {
    this.fluidIcon = new IIcon[] { iconRegister.func_94245_a("alextm:fluid/Magma_still"), iconRegister.func_94245_a("alextm:fluid/Magma_flow") };
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_149691_a(int side, int meta) {
    return (side != 0 && side != 1) ? this.fluidIcon[1] : this.fluidIcon[0];
  }
}
