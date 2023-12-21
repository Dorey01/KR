package alextm.client.gui;

import alextm.common.items.ItemCase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiTrophyBox extends GuiScreen {
  private int x_mid;
  
  private int y_mid;
  
  private int oldTime = 0;
  
  private int ticks = 0;
  
  private float temp_scale = 0.1F;
  
  public static ItemStack stack;
  
  public static int index;
  
  private static ItemCase Case;
  
  private static String rarityText;
  
  private static int rarityTextColor;
  
  public void func_73866_w_() {
    this.x_mid = this.field_146294_l / 2;
    this.y_mid = this.field_146295_m / 2;
    Case = (ItemCase)stack.func_77973_b();
    int i = (index != -1) ? index : 0;
    stack = Case.getCurrentItem(i).getItemStack();
    rarityText = Case.getCurrentItem(i).getText();
    rarityTextColor = Case.getCurrentItem(i).getTextColor();
    renderColor = Case.getCurrentItem(i).getRenderColor();
  }
  
  public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
    GuiImage.bindTexture("alextm:textures/gui/gui_trophy.png");
    GuiImage.drawImage(this.x_mid - 128, this.y_mid - 128, 0, 0, 256, 256, 1.0F);
    Tessellator tessellator = Tessellator.field_78398_a;
    float f1 = (this.ticks + partialTicks) / 300.0F;
    int time = (int)((Minecraft.func_71410_x()).field_71441_e.func_72820_D() % 20L);
    if (this.oldTime != time) {
      this.oldTime = time;
      this.ticks++;
    } 
    Random random = new Random(123141L);
    GL11.glPushMatrix();
    GL11.glDisable(3553);
    GL11.glShadeModel(7425);
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 1);
    GL11.glDisable(3008);
    GL11.glEnable(2884);
    GL11.glDisable(2929);
    GL11.glTranslatef(this.x_mid, this.y_mid, 0.0F);
    GL11.glScalef(5.0F, 5.0F, 5.0F);
    for (int itemId = 0; itemId < 20; itemId++) {
      GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(random.nextFloat() * 360.0F + f1 * 90.0F, 0.0F, 0.0F, 1.0F);
      tessellator.func_78371_b(6);
      float f3 = random.nextFloat() * 20.0F + 5.0F + 10.0F;
      float f2 = random.nextFloat() * 2.0F + 1.0F + 2.0F;
      tessellator.func_78384_a(renderColor[0], 125);
      tessellator.func_78377_a(0.0D, 0.0D, 0.0D);
      tessellator.func_78384_a(renderColor[1], 0);
      tessellator.func_78377_a(-0.866D * f2, f3, (-0.5F * f2));
      tessellator.func_78377_a(0.866D * f2, f3, (-0.5F * f2));
      tessellator.func_78377_a(0.0D, f3, (1.0F * f2));
      tessellator.func_78377_a(-0.866D * f2, f3, (-0.5F * f2));
      tessellator.func_78381_a();
    } 
    GL11.glEnable(2929);
    GL11.glDisable(2884);
    GL11.glDisable(3042);
    GL11.glShadeModel(7424);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    GL11.glEnable(3553);
    GL11.glEnable(3008);
    GL11.glPopMatrix();
    if (this.temp_scale >= 8.0F) {
      int itemsSpeed = 25;
      int i = this.ticks % 25 * Case.getSize() / 25;
      if (index == -1) {
        stack = Case.getCurrentItem(i).getItemStack();
        rarityText = Case.getCurrentItem(i).getText();
        rarityTextColor = Case.getCurrentItem(i).getTextColor();
        renderColor = Case.getCurrentItem(i).getRenderColor();
      } 
      String name = stack.func_82833_r();
      GuiImage.drawString(name, this.x_mid, this.y_mid - 80, 16777215, true, true);
      GuiImage.drawString(rarityText, this.x_mid + 3, this.y_mid + 75, rarityTextColor, true, true);
    } 
    if (this.temp_scale < 8.0F)
      this.temp_scale += 0.05F * this.ticks; 
    float var12 = (this.field_146294_l - 16.0F * this.temp_scale) / 2.0F;
    float var11 = (this.field_146295_m - 16.0F * this.temp_scale) / 2.0F;
    GL11.glPushMatrix();
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    GL11.glTranslatef(var12, var11, 0.0F);
    GL11.glScalef(this.temp_scale, this.temp_scale, 1.0F);
    (new RenderItem()).func_82406_b(this.field_146289_q, Minecraft.func_71410_x().func_110434_K(), stack, 0, 0);
    GL11.glPopMatrix();
    super.func_73863_a(mouseX, mouseY, partialTicks);
  }
  
  public boolean func_73868_f() {
    return false;
  }
  
  protected void func_146284_a(GuiButton button) {}
  
  private static int[] renderColor = new int[2];
}
