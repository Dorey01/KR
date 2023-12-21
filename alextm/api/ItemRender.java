package alextm.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRender implements IItemRenderer {
  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
    return (type == IItemRenderer.ItemRenderType.EQUIPPED || type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
  }
  
  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
    return false;
  }
  
  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack par2ItemStack, Object... data) {
    if (par2ItemStack.func_77973_b() instanceof ItemRenderInterface) {
      EntityLivingBase par1EntityLiving = (EntityLivingBase)data[1];
      GL11.glTranslatef(0.9375F, 0.0625F, 0.0F);
      GL11.glRotatef(-315.0F, 0.0F, 0.0F, 1.0F);
      ((ItemRenderInterface)par2ItemStack.func_77973_b()).renderSpecial();
      GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(-0.09375F, 0.0625F, 0.0F);
      renderItem3d(par1EntityLiving, par2ItemStack);
    } 
  }
  
  public void renderItem3d(EntityLivingBase par1EntityLiving, ItemStack par2ItemStack) {
    Minecraft mc = Minecraft.func_71410_x();
    TextureManager texturemanager = mc.func_110434_K();
    byte par3 = 0;
    texturemanager.func_110577_a(texturemanager.func_130087_a(par2ItemStack.func_94608_d()));
    Tessellator tessellator = Tessellator.field_78398_a;
    IIcon icon = par1EntityLiving.func_70620_b(par2ItemStack, 0);
    if (icon != null) {
      float f = icon.func_94209_e();
      float f2 = icon.func_94212_f();
      float f3 = icon.func_94206_g();
      float f4 = icon.func_94210_h();
      float f5 = 0.0F;
      float f6 = 0.3F;
      GL11.glEnable(32826);
      GL11.glTranslatef(-0.0F, -0.3F, 0.0F);
      float f7 = 1.5F;
      GL11.glScalef(1.5F, 1.5F, 1.5F);
      GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
      ItemRenderer.func_78439_a(tessellator, f2, f3, f, f4, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
      if (par2ItemStack.hasEffect(0)) {
        GL11.glDepthFunc(514);
        GL11.glDisable(2896);
        texturemanager.func_110577_a(enchant);
        GL11.glEnable(3042);
        GL11.glBlendFunc(768, 1);
        float f8 = 0.76F;
        GL11.glColor4f(0.38F, 0.19F, 0.608F, 1.0F);
        GL11.glMatrixMode(5890);
        GL11.glPushMatrix();
        float f9 = 0.125F;
        GL11.glScalef(0.125F, 0.125F, 0.125F);
        float f10 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
        GL11.glTranslatef(f10, 0.0F, 0.0F);
        GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
        ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(0.125F, 0.125F, 0.125F);
        f10 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
        GL11.glTranslatef(-f10, 0.0F, 0.0F);
        GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
        ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
        GL11.glPopMatrix();
        GL11.glMatrixMode(5888);
        GL11.glDisable(3042);
        GL11.glEnable(2896);
        GL11.glDepthFunc(515);
      } 
      GL11.glDisable(32826);
    } 
  }
  
  private static final ResourceLocation enchant = new ResourceLocation("textures/misc/enchanted_item_glint.png");
}
