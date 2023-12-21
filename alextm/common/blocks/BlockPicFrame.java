package alextm.common.blocks;

import alextm.client.gui.SubGuiPicOPF;
import alextm.client.gui.container.SubContainerPicOPF;
import alextm.common.tileentity.TileEntityPicFrame;
import alextm.core.ModItems;
import alextm.proxy.ClientProxy;
import com.creativemd.creativecore.common.container.SubContainer;
import com.creativemd.creativecore.common.gui.IGuiCreator;
import com.creativemd.creativecore.common.gui.SubGui;
import com.creativemd.creativecore.common.utils.CubeObject;
import com.creativemd.creativecore.core.CreativeCore;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPicFrame extends BlockContainer implements IGuiCreator {
  private boolean animation;
  
  public BlockPicFrame(String name, boolean animation) {
    super(Material.field_151575_d);
    func_149663_c(name);
    GameRegistry.registerBlock((Block)this, name);
    this.animation = animation;
  }
  
  public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
    return this.animation ? ModItems.UrlPaintAnim : ModItems.UrlPaint;
  }
  
  @SideOnly(Side.CLIENT)
  public Item func_149694_d(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
    return this.animation ? ModItems.UrlPaintAnim : ModItems.UrlPaint;
  }
  
  public AxisAlignedBB func_149668_a(World world, int x, int y, int z) {
    CubeObject cube = new CubeObject(0.0D, 0.0D, 0.0D, 0.05D, 1.0D, 1.0D);
    ForgeDirection direction = ForgeDirection.getOrientation(world.func_72805_g(x, y, z));
    return CubeObject.rotateCube(cube, direction).getAxis().func_72325_c(x, y, z);
  }
  
  @SideOnly(Side.CLIENT)
  public AxisAlignedBB func_149633_g(World world, int x, int y, int z) {
    TileEntity te = world.func_147438_o(x, y, z);
    if (te instanceof TileEntityPicFrame)
      return ((TileEntityPicFrame)te).getBoundingBox(); 
    ForgeDirection direction = ForgeDirection.getOrientation(world.func_72805_g(x, y, z));
    CubeObject cube = new CubeObject(0.0D, 0.0D, 0.0D, 0.05D, 1.0D, 1.0D);
    return CubeObject.rotateCube(cube, direction).getAxis().func_72325_c(x, y, z);
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_149691_a(int side, int meta) {
    return Blocks.field_150344_f.func_149691_a(side, meta);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_149651_a(IIconRegister registry) {}
  
  @SideOnly(Side.CLIENT)
  public boolean func_149686_d() {
    return false;
  }
  
  public boolean func_149727_a(World world, int x, int y, int z, EntityPlayer player, int side, float offX, float offY, float offZ) {
    if (!world.field_72995_K)
      ((EntityPlayerMP)player).openGui(CreativeCore.instance, 0, world, x, y, z); 
    return true;
  }
  
  public int func_149660_a(World world, int x, int y, int z, int side, float offX, float offY, float offZ, int meta) {
    return side;
  }
  
  public boolean func_149662_c() {
    return false;
  }
  
  @SideOnly(Side.CLIENT)
  public int func_149645_b() {
    return ClientProxy.modelID;
  }
  
  public boolean func_149721_r() {
    return false;
  }
  
  public TileEntity func_149915_a(World world, int meta) {
    return (TileEntity)new TileEntityPicFrame();
  }
  
  @SideOnly(Side.CLIENT)
  public SubGui getGui(EntityPlayer player, ItemStack stack, World world, int x, int y, int z) {
    TileEntity te = world.func_147438_o(x, y, z);
    return (te instanceof TileEntityPicFrame) ? new SubGuiPicOPF((TileEntityPicFrame)te, this.animation) : null;
  }
  
  public SubContainer getContainer(EntityPlayer player, ItemStack stack, World world, int x, int y, int z) {
    TileEntity te = world.func_147438_o(x, y, z);
    return (te instanceof TileEntityPicFrame) ? new SubContainerPicOPF((TileEntityPicFrame)te, player, this.animation) : null;
  }
}
