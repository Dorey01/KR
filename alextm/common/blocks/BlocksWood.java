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

public class BlocksWood extends Block {
  private int count;
  
  @SideOnly(Side.CLIENT)
  private IIcon[] icon;
  
  public BlocksWood(String name, String texture, int count) {
    super(Material.field_151575_d);
    func_149663_c(name);
    func_149658_d(texture);
    func_149647_a(SkyHard.SkyHard);
    func_149672_a(field_149766_f);
    func_149711_c(3.0F);
    func_149752_b(10.0F);
    setHarvestLevel("axe", 1);
    this.count = count;
    GameRegistry.registerBlock(this, ItemBlockMetadata.class, name);
  }
  
  public int func_149692_a(int meta) {
    return meta;
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149666_a(Item item, CreativeTabs tab, List<ItemStack> subItems) {
    for (int n = 0; n < this.count; n++)
      subItems.add(new ItemStack(this, 1, n)); 
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_149691_a(int side, int meta) {
    return this.icon[meta];
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149651_a(IIconRegister icon) {
    this.icon = new IIcon[this.count];
    for (int i = 0; i < this.count; i++)
      this.icon[i] = icon.func_94245_a(func_149641_N() + "_" + i); 
  }
}
