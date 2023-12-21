package alextm.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiImage extends GuiScreen {
  public static void bindTexture(String texture) {
    ResourceLocation rl = new ResourceLocation(texture);
    (Minecraft.func_71410_x()).field_71446_o.func_110577_a(rl);
  }
  
  public static void bindTexture(String mod, String texture) {
    ResourceLocation rl = new ResourceLocation(mod, texture);
    (Minecraft.func_71410_x()).field_71446_o.func_110577_a(rl);
  }
  
  public static void drawString(String text, int x, int y, int color, boolean mid, boolean shadow) {
    int offset = fontRenderer.func_78256_a(text);
    if (mid) {
      fontRenderer.func_85187_a(text, x - offset / 2, y - 1, color, shadow);
    } else {
      fontRenderer.func_85187_a(text, x, y, color, shadow);
    } 
  }
  
  public static void drawImage(int x, int y, int x_image, int y_image, int w_image, int h_image, float scale) {
    float var1 = x + (w_image - w_image * scale) / 2.0F;
    float var2 = y + (h_image - h_image * scale) / 2.0F;
    GL11.glPushMatrix();
    GL11.glEnable(3042);
    GL11.glTranslatef(var1, var2, 0.0F);
    GL11.glScalef(scale, scale, 1.0F);
    GuiI.func_73729_b(0, 0, x_image, y_image, w_image, h_image);
    GL11.glDisable(3042);
    GL11.glPopMatrix();
  }
  
  private static FontRenderer fontRenderer = (Minecraft.func_71410_x()).field_71466_p;
  
  static Map boundTextures = new HashMap<>();
  
  private static Gui GuiI = (Gui)new GuiImage();
}
