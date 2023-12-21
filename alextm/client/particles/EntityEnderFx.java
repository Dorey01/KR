package alextm.client.particles;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class EntityEnderFx extends EntityPortalFX {
  public EntityEnderFx(EntityPlayer player, double x, double y, double z, double x1, double y1, double z1, float[] color1, float[] color2) {
    super(player.field_70170_p, x, y, z, x1, y1, z1);
    this.move = true;
    this.startX = 0.0F;
    this.startY = 0.0F;
    this.startZ = 0.0F;
    this.player = player;
    if (this.field_70146_Z.nextInt(10) != 1) {
      this.field_70552_h = color1[0];
      this.field_70553_i = color1[1];
      this.field_70551_j = color1[2];
    } else {
      this.field_70552_h = color2[0];
      this.field_70553_i = color2[1];
      this.field_70551_j = color2[2];
    } 
    if (player.func_70681_au().nextInt(3) == 1) {
      this.move = false;
      this.startX = (float)player.field_70165_t;
      this.startY = (float)player.field_70163_u;
      this.startZ = (float)player.field_70161_v;
    } 
    Random rand = new Random();
    switch (rand.nextInt(2)) {
      case 0:
        this.field_94054_b = 0;
        this.field_94055_c = 0;
        break;
      case 1:
        this.field_94054_b = 1;
        this.field_94055_c = 0;
        break;
    } 
  }
  
  public void func_70539_a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
    if (this.move) {
      this.startX = (float)(this.player.field_70169_q + (this.player.field_70165_t - this.player.field_70169_q) * par2);
      this.startY = (float)(this.player.field_70167_r + (this.player.field_70163_u - this.player.field_70167_r) * par2);
      this.startZ = (float)(this.player.field_70166_s + (this.player.field_70161_v - this.player.field_70166_s) * par2);
    } 
    Tessellator tessellator = Tessellator.field_78398_a;
    tessellator.func_78381_a();
    float scale = (this.field_70546_d + par2) / this.field_70547_e;
    scale = 1.0F - scale;
    scale *= scale;
    scale = 1.0F - scale;
    this.field_70544_f = 0.7F * scale;
    (Minecraft.func_71410_x()).field_71446_o.func_110577_a(particles);
    double x1 = (this.field_94054_b / 2.0F);
    double y1 = this.field_94055_c;
    double x2 = x1 + 0.5D;
    double y2 = y1 + 1.0D;
    float f4 = 0.1F * this.field_70544_f;
    float f5 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * par2 - EntityFX.field_70556_an + this.startX);
    float f6 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * par2 - EntityFX.field_70554_ao + this.startY);
    float f7 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * par2 - EntityFX.field_70555_ap + this.startZ);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    tessellator.func_78382_b();
    tessellator.func_78380_c(240);
    par1Tessellator.func_78386_a(1.0F, 1.0F, 1.0F);
    par1Tessellator.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 1.0F);
    par1Tessellator.func_78374_a((f5 - par3 * f4 - par6 * f4), (f6 - par4 * f4), (f7 - par5 * f4 - par7 * f4), x1, y1);
    par1Tessellator.func_78374_a((f5 - par3 * f4 + par6 * f4), (f6 + par4 * f4), (f7 - par5 * f4 + par7 * f4), x1, y2);
    par1Tessellator.func_78374_a((f5 + par3 * f4 + par6 * f4), (f6 + par4 * f4), (f7 + par5 * f4 + par7 * f4), x2, y2);
    par1Tessellator.func_78374_a((f5 + par3 * f4 - par6 * f4), (f6 - par4 * f4), (f7 + par5 * f4 - par7 * f4), x2, y1);
    tessellator.func_78381_a();
    bindDefaultParticles();
    tessellator.func_78382_b();
  }
  
  public static void bindDefaultParticles() {
    if (defaultParticles == null)
      try {
        defaultParticles = (ResourceLocation)ReflectionHelper.getPrivateValue(EffectRenderer.class, null, new String[] { "particleTextures", "b", "field_110737_b" });
      } catch (Exception var1) {
        var1.printStackTrace();
      }  
    if (defaultParticles != null)
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(defaultParticles); 
  }
  
  private static ResourceLocation particles = new ResourceLocation("alextm:textures/particles/devil.png");
  
  private boolean move;
  
  private float startX;
  
  private float startY;
  
  private float startZ;
  
  private EntityPlayer player;
  
  private static ResourceLocation defaultParticles;
}
