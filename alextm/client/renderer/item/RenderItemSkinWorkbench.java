package alextm.client.renderer.item;

import alextm.client.renderer.tileentity.RenderSkinWorkbench;
import alextm.common.tileentity.TileSkinWorkbench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderItemSkinWorkbench implements IItemRenderer {
  private RenderSkinWorkbench render = new RenderSkinWorkbench();
  
  private TileSkinWorkbench tile = new TileSkinWorkbench();
  
  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
    return true;
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
    return true;
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
    GL11.glPushMatrix();
    this.render.func_147500_a(this.tile, 0.0D, 0.0D, 0.0D, 0.0F);
    GL11.glPopMatrix();
  }
}
