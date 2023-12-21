package alextm.client.renderer.tileentity;

import alextm.client.model.skins.ModelSkinWorkbench;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSkinWorkbench extends TileEntitySpecialRenderer {
  public void renderCore(TileEntity te, double x, double y, double z, float partialTicks) {
    int size1 = 64;
    this.ticker++;
    if (this.ticker > 161)
      this.ticker = 1; 
    float f1 = ActiveRenderInfo.field_74588_d;
    float f2 = ActiveRenderInfo.field_74589_e;
    float f3 = ActiveRenderInfo.field_74586_f;
    float f4 = ActiveRenderInfo.field_74587_g;
    float f5 = ActiveRenderInfo.field_74596_h;
    float scaleCore = 0.35F;
    float posX = (float)x + 0.5F;
    float posY = (float)y + 0.5F;
    float posZ = (float)z + 0.5F;
    Tessellator tessellator = Tessellator.field_78398_a;
    new Color(12648447);
    (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(sunNode);
    long nt = System.nanoTime();
    int i = (int)(((nt / 40000000L) + x) % 32.0D);
    float size2 = 512.0F;
    float float_sizeMinus0_01 = 63.99F;
    float x2 = ((i % 8 * 64) + 0.0F) / 512.0F;
    float x3 = ((i % 8 * 64) + 63.99F) / 512.0F;
    float x4 = ((i / 8 * 64) + 0.0F) / 512.0F;
    float x5 = ((i / 8 * 64) + 63.99F) / 512.0F;
    tessellator.func_78382_b();
    tessellator.func_78380_c(220);
    tessellator.func_78374_a((posX - f1 * 0.35F - f4 * 0.35F), (posY - f2 * 0.35F), (posZ - f3 * 0.35F - f5 * 0.35F), x3, x5);
    tessellator.func_78374_a((posX - f1 * 0.35F + f4 * 0.35F), (posY + f2 * 0.35F), (posZ - f3 * 0.35F + f5 * 0.35F), x3, x4);
    tessellator.func_78374_a((posX + f1 * 0.35F + f4 * 0.35F), (posY + f2 * 0.35F), (posZ + f3 * 0.35F + f5 * 0.35F), x2, x4);
    tessellator.func_78374_a((posX + f1 * 0.35F - f4 * 0.35F), (posY - f2 * 0.35F), (posZ + f3 * 0.35F - f5 * 0.35F), x2, x5);
    tessellator.func_78381_a();
  }
  
  public void func_147500_a(TileEntity entity, double x, double y, double z, float partialTick) {
    GL11.glPushMatrix();
    GL11.glTranslated(x, y, z);
    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
    GL11.glTranslatef(-0.5F, -1.5F, 0.5F);
    (Minecraft.func_71410_x()).field_71446_o.func_110577_a(modelTexture);
    GL11.glDisable(2896);
    OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
    model.renderModel(0.0625F);
    GL11.glEnable(2896);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glDisable(2896);
    OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
    GL11.glEnable(3042);
    GL11.glDepthMask(false);
    renderCore(entity, x, y, z, partialTick);
    GL11.glDepthMask(true);
    GL11.glDisable(3042);
    GL11.glEnable(2896);
    GL11.glPopMatrix();
  }
  
  private static final ResourceLocation modelTexture = new ResourceLocation("alextm:model/skins/skin_workbench.png");
  
  private static final ResourceLocation sunNode = new ResourceLocation("alextm:model/sun_node.png");
  
  public static final ResourceLocation nodetex = new ResourceLocation("alextm:model/nodes.png");
  
  private static ModelSkinWorkbench model = new ModelSkinWorkbench();
  
  private static Map textureSizeCache = new HashMap<>();
  
  public int ticker;
}
