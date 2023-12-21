package alextm.client.renderer.item;

import alextm.client.handler.ResourceHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderArmor implements IItemRenderer {
  private ItemArmor armor;
  
  public RenderArmor() {}
  
  public RenderArmor(ItemArmor armor) {
    this.armor = armor;
  }
  
  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
    return true;
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
    return true;
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack stack, Object... data) {
    GL11.glPushMatrix();
    GL11.glCullFace(1029);
    GL11.glEnable(2884);
    GL11.glEnable(2896);
    GL11.glEnable(16384);
    GL11.glEnable(16385);
    ResourceHandler.bindResource(this.armor.getArmorTexture(stack, (Entity)null, 0, (String)null).replace("alextm:", ""));
    if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.EQUIPPED) {
      GL11.glTranslated(0.5D, 0.5D, 0.5D);
      GL11.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
    } 
    GL11.glTranslated(0.0D, (this.armor.field_77881_a == 0) ? -0.25D : ((this.armor.field_77881_a == 1) ? 0.42D : ((this.armor.field_77881_a == 2) ? 1.05D : 1.5D)), 0.0D);
    GL11.glRotated(180.0D, -1.0D, 0.0D, 1.0D);
    this.armor.getArmorModel((EntityLivingBase)null, stack, 0).func_78088_a((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
    GL11.glDisable(2884);
    GL11.glPopMatrix();
  }
}
