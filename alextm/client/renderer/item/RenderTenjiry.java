package alextm.client.renderer.item;

import alextm.client.model.skins.ModelTenjiry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTenjiry implements IItemRenderer {
  private static ModelTenjiry model;
  
  private static ResourceLocation texture;
  
  public RenderTenjiry(ModelTenjiry model, ResourceLocation texture) {
    RenderTenjiry.model = model;
    RenderTenjiry.texture = texture;
  }
  
  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
    return true;
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
    return (type == IItemRenderer.ItemRenderType.INVENTORY || (type == IItemRenderer.ItemRenderType.ENTITY && helper == IItemRenderer.ItemRendererHelper.ENTITY_ROTATION));
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
    renderSkin(type, item, data);
  }
  
  public static void renderSkin(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
    if (type == IItemRenderer.ItemRenderType.INVENTORY) {
      GL11.glPushMatrix();
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glRotatef(-135.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-45.0F, 0.0F, 0.0F, 1.0F);
      GL11.glScalef(0.65F, 0.65F, 0.65F);
      GL11.glTranslatef(-0.5F, 0.5F, -0.3F);
      model.render(0.0625F);
      GL11.glPopMatrix();
    } else if (type == IItemRenderer.ItemRenderType.ENTITY) {
      GL11.glPushMatrix();
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(0.0F, -1.0F, 0.0F);
      model.render(0.0625F);
      GL11.glPopMatrix();
    } else {
      GL11.glPushMatrix();
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glRotatef(-80.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(35.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-105.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.2F, 0.2F, 0.6F);
      model.render(0.0625F);
      GL11.glPopMatrix();
    } 
  }
}
