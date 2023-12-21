package alextm.client.renderer;

import alextm.common.tileentity.TileEntityPicFrame;
import alextm.proxy.ClientProxy;
import com.creativemd.creativecore.client.block.BlockRenderHelper;
import com.creativemd.creativecore.common.utils.CubeObject;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

public class PicBlockRenderer implements ISimpleBlockRenderingHandler {
  public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
    ArrayList<CubeObject> cubes = new ArrayList<>();
    cubes.add(new CubeObject(0.0D, 0.0D, 0.0D, 0.05D, 1.0D, 1.0D, Blocks.field_150344_f));
    BlockRenderHelper.renderInventoryCubes(renderer, cubes, block, metadata);
  }
  
  public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
    ArrayList<CubeObject> cubes = new ArrayList<>();
    cubes.add(new CubeObject(0.0D, 0.0D, 0.0D, 0.05D, 1.0D, 1.0D, Blocks.field_150344_f));
    TileEntity te = world.func_147438_o(x, y, z);
    if (te instanceof TileEntityPicFrame && ((TileEntityPicFrame)te).visibleFrame)
      BlockRenderHelper.renderCubes(world, cubes, x, y, z, block, renderer, ForgeDirection.getOrientation(world.func_72805_g(x, y, z))); 
    return true;
  }
  
  public boolean shouldRender3DInInventory(int modelId) {
    return true;
  }
  
  public int getRenderId() {
    return ClientProxy.modelID;
  }
}
