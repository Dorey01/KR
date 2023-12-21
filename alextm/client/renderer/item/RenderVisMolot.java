package alextm.client.renderer.item;

import alextm.client.handler.ClientRenderHandler;
import alextm.client.model.skins.ModelMolot;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderVisMolot implements IItemRenderer {
  private static ModelMolot model;
  
  private static ResourceLocation texture;
  
  public RenderVisMolot(ModelMolot model, ResourceLocation texture) {
    RenderVisMolot.model = model;
    RenderVisMolot.texture = texture;
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
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(-40.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.0F, -0.7F, 0.0F);
      model.render(0.0625F);
      setDragonEffect();
    } else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
      GL11.glPushMatrix();
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-135.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.7F, -0.7F, 0.0F);
      model.render(0.0625F);
      GL11.glPopMatrix();
    } else {
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(-135.0F, 0.0F, 0.0F, 1.0F);
      GL11.glTranslatef(-0.7F, -0.7F, 0.0F);
      model.render(0.0625F);
      setDragonEffect();
    } 
  }
  
  public static void setDragonEffect() {
    Random random = new Random(123141L);
    Tessellator tessellator = Tessellator.field_78398_a;
    GL11.glPushMatrix();
    int time = (int)((Minecraft.func_71410_x()).field_71441_e.func_72820_D() % 20L);
    if (oldTime != time) {
      oldTime = time;
      ticks++;
    } 
    float f1 = (ticks + ClientRenderHandler.partialTicks) / 300.0F;
    float f2 = 0.0F;
    if (f1 > 0.6F)
      f2 = (f1 - 0.6F) / 0.2F; 
    GL11.glDisable(2896);
    OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
    GL11.glDisable(3553);
    GL11.glShadeModel(7425);
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 1);
    GL11.glDisable(3008);
    GL11.glEnable(2884);
    GL11.glTranslatef(0.0F, 0.3F, 0.0F);
    GL11.glScalef(0.05F, 0.05F, 0.05F);
    for (int i = 0; i < 20; i++) {
      GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F + f1 * 90.0F, 0.0F, 0.0F, 1.0F);
      tessellator.func_78371_b(6);
      float f3 = random.nextFloat() * 20.0F + 5.0F + 10.0F;
      float f4 = random.nextFloat() * 2.0F + 1.0F + 2.0F;
      tessellator.func_78384_a(16711935, 255);
      tessellator.func_78377_a(0.0D, 0.0D, 0.0D);
      tessellator.func_78384_a(9109759, 0);
      tessellator.func_78377_a(-0.866D * f4, f3, (-0.5F * f4));
      tessellator.func_78377_a(0.866D * f4, f3, (-0.5F * f4));
      tessellator.func_78377_a(0.0D, f3, (1.0F * f4));
      tessellator.func_78377_a(-0.866D * f4, f3, (-0.5F * f4));
      tessellator.func_78381_a();
    } 
    GL11.glDisable(2884);
    GL11.glDisable(3042);
    GL11.glShadeModel(7424);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    GL11.glEnable(3553);
    GL11.glEnable(3008);
    GL11.glEnable(2896);
    GL11.glPopMatrix();
  }
  
  private static int ticks = 0;
  
  private static int oldTime = 0;
  
  private static int meta;
}
