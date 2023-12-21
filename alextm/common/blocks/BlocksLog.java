package alextm.common.blocks;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlocksLog extends BlockLog {
  private int count;
  
  @SideOnly(Side.CLIENT)
  private IIcon[] icon;
  
  @SideOnly(Side.CLIENT)
  private IIcon[] iconTop;
  
  public BlocksLog(String name, String texture, int count) {
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149711_c(3.0F);
    setHarvestLevel("axe", 1);
    this.count = count;
    GameRegistry.registerBlock((Block)this, ItemBlockMetadata.class, name);
  }
  
  public int func_149692_a(int meta) {
    return meta;
  }
  
  @SideOnly(Side.CLIENT)
  protected IIcon func_150163_b(int par1) {
    return this.icon[par1];
  }
  
  @SideOnly(Side.CLIENT)
  protected IIcon func_150161_d(int par1) {
    return this.iconTop[par1];
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
  
  @SideOnly(Side.CLIENT)
  public void func_149666_a(Item item, CreativeTabs tab, List<ItemStack> subItems) {
    for (int n = 0; n < this.count; n++)
      subItems.add(new ItemStack((Block)this, 1, n)); 
  }
}
