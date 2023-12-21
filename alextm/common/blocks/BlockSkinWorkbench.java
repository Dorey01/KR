package alextm.common.blocks;

import alextm.SkyHard;
import alextm.common.tileentity.TileSkinWorkbench;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSkinWorkbench extends BlockContainer implements ITileEntityProvider {
  private final Random random;
  
  public BlockSkinWorkbench(String name) {
    super(Material.field_151573_f);
    this.random = new Random();
    func_149663_c(name);
    func_149647_a(SkyHard.SkyHard);
    func_149672_a(Block.field_149777_j);
    func_149711_c(3.0F);
    setHarvestLevel("pickaxe", 1);
    GameRegistry.registerBlock((Block)this, name);
  }
  
  public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    if (!world.field_72995_K)
      player.openGui(SkyHard.instance, 3, world, x, y, z); 
    return true;
  }
  
  public TileEntity func_149915_a(World world, int meta) {
    return new TileSkinWorkbench();
  }
  
  public boolean func_149662_c() {
    return false;
  }
  
  public boolean func_149721_r() {
    return false;
  }
  
  @SideOnly(Side.CLIENT)
  public boolean func_149686_d() {
    return false;
  }
  
  public int func_149645_b() {
    return -1;
  }
  
  @SideOnly(Side.CLIENT)
  public boolean func_149646_a(IBlockAccess blockAccess, int x, int y, int z, int side) {
    return true;
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149651_a(IIconRegister icon) {
    this.field_149761_L = icon.func_94245_a("alextm:stone/stone_0");
  }
  
  public void func_149749_a(World world, int x, int y, int z, Block block, int par1) {
    TileSkinWorkbench tile = (TileSkinWorkbench)world.func_147438_o(x, y, z);
    if (tile != null) {
      for (int i1 = 0; i1 < tile.func_70302_i_(); i1++) {
        ItemStack itemstack = tile.func_70301_a(i1);
        if (itemstack != null) {
          float f = this.random.nextFloat() * 0.8F + 0.1F;
          float f2 = this.random.nextFloat() * 0.8F + 0.1F;
          float f3 = this.random.nextFloat() * 0.8F + 0.1F;
          while (itemstack.field_77994_a > 0) {
            int j1 = this.random.nextInt(21) + 10;
            if (j1 > itemstack.field_77994_a)
              j1 = itemstack.field_77994_a; 
            ItemStack itemStack = itemstack;
            itemStack.field_77994_a -= j1;
            EntityItem entityitem = new EntityItem(world, (x + f), (y + f2), (z + f3), new ItemStack(itemstack.func_77973_b(), j1, itemstack.func_77960_j()));
            if (itemstack.func_77942_o())
              entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b()); 
            float f4 = 0.05F;
            entityitem.field_70159_w = ((float)this.random.nextGaussian() * 0.05F);
            entityitem.field_70181_x = ((float)this.random.nextGaussian() * 0.05F + 0.2F);
            entityitem.field_70179_y = ((float)this.random.nextGaussian() * 0.05F);
            world.func_72838_d((Entity)entityitem);
          } 
        } 
      } 
      world.func_147453_f(x, y, z, block);
    } 
    super.func_149749_a(world, x, y, z, block, par1);
  }
}
