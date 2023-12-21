package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlocksGrassBlocks extends Block {
  private int count;
  
  @SideOnly(Side.CLIENT)
  private IIcon[] icon;
  
  @SideOnly(Side.CLIENT)
  private IIcon[] iconTop;
  
  public BlocksGrassBlocks(String name, String texture, int count) {
    super(Material.field_151577_b);
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149672_a(field_149779_h);
    func_149711_c(3.0F);
    this.count = count;
    setHarvestLevel("axe", 1);
    GameRegistry.registerBlock(this, ItemBlockMetadata.class, name);
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_149691_a(int side, int meta) {
    return (side == 1) ? this.iconTop[meta] : this.icon[meta];
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149651_a(IIconRegister par1IconRegister) {
    this.icon = new IIcon[this.count];
    this.iconTop = new IIcon[this.count];
    for (int i = 0; i < this.count; i++) {
      this.icon[i] = par1IconRegister.func_94245_a(func_149641_N() + "_" + i);
      this.iconTop[i] = par1IconRegister.func_94245_a(func_149641_N() + "_top_" + i);
    } 
  }
  
  public int func_149692_a(int meta) {
    return meta;
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149666_a(Item item, CreativeTabs tab, List<ItemStack> subItems) {
    for (int n = 0; n < this.count; n++)
      subItems.add(new ItemStack(this, 1, n)); 
  }
}
