package alextm.client;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public abstract class ArmorRenderObjBase extends ModelBiped {
  public int color = -1;
  
  public abstract void pre();
  
  public abstract void post();
  
  public abstract void partHead();
  
  public abstract void partBody();
  
  public abstract void partRightArm();
  
  public abstract void partLeftArm();
  
  public abstract void partRightLeg();
  
  public abstract void partLeftLeg();
  
  public void func_78088_a(Entity entity, float x, float y, float z, float yaw, float pitch, float parTicks) {
    super.func_78088_a(entity, x, y, z, yaw, pitch, parTicks);
    GL11.glPushMatrix();
    if (entity instanceof net.minecraft.entity.monster.EntityZombie || entity instanceof EntitySkeleton || entity instanceof net.minecraft.entity.monster.EntityGiantZombie) {
      float f1 = MathHelper.func_76126_a(this.field_78095_p * 3.1415927F);
      float f7 = MathHelper.func_76126_a((1.0F - (1.0F - this.field_78095_p) * (1.0F - this.field_78095_p)) * 3.1415927F);
      this.field_78112_f.field_78808_h = 0.0F;
      this.field_78112_f.field_78796_g = -(0.1F - f1 * 0.6F);
      this.field_78112_f.field_78795_f = -1.5707964F;
      ModelRenderer bipedRightArm = this.field_78112_f;
      bipedRightArm.field_78795_f -= f1 * 1.2F - f7 * 0.4F;
      ModelRenderer bipedRightArm2 = this.field_78112_f;
      bipedRightArm2.field_78808_h += MathHelper.func_76134_b(z * 0.09F) * 0.05F + 0.05F;
      ModelRenderer bipedRightArm3 = this.field_78112_f;
      bipedRightArm3.field_78795_f += MathHelper.func_76126_a(z * 0.067F) * 0.05F;
      this.field_78113_g.field_78808_h = 0.0F;
      this.field_78113_g.field_78796_g = 0.1F - f1 * 0.6F;
      this.field_78113_g.field_78795_f = -1.5707964F;
      ModelRenderer bipedLeftArm = this.field_78113_g;
      bipedLeftArm.field_78795_f -= f1 * 1.2F - f7 * 0.4F;
      ModelRenderer bipedLeftArm2 = this.field_78113_g;
      bipedLeftArm2.field_78808_h -= MathHelper.func_76134_b(z * 0.09F) * 0.05F + 0.05F;
      ModelRenderer bipedLeftArm3 = this.field_78113_g;
      bipedLeftArm3.field_78795_f -= MathHelper.func_76126_a(z * 0.067F) * 0.05F;
      if (entity instanceof EntitySkeleton && ((EntitySkeleton)entity).func_82202_m() == 1) {
        GL11.glScalef(1.2F, 1.2F, 1.2F);
      } else if (entity instanceof net.minecraft.entity.monster.EntityGiantZombie) {
        GL11.glScalef(6.0F, 6.0F, 6.0F);
      } 
    } 
    if (this.color != -1) {
      float red = (this.color >> 16 & 0xFF) / 255.0F;
      float blue = (this.color >> 8 & 0xFF) / 255.0F;
      float green = (this.color & 0xFF) / 255.0F;
      GL11.glColor3f(red, blue, green);
    } 
    pre();
    float f6 = 2.0F;
    GL11.glPushMatrix();
    if (this.field_78091_s) {
      GL11.glScalef(0.75F, 0.75F, 0.75F);
      GL11.glTranslatef(0.0F, 16.0F * parTicks, 0.0F);
    } 
    GL11.glTranslatef(this.field_78116_c.field_78800_c * parTicks, this.field_78116_c.field_78797_d * parTicks, this.field_78116_c.field_78798_e * parTicks);
    GL11.glRotatef(this.field_78116_c.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(this.field_78116_c.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(this.field_78116_c.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    partHead();
    GL11.glPopMatrix();
    if (this.field_78091_s) {
      GL11.glPushMatrix();
      GL11.glScalef(0.5F, 0.5F, 0.5F);
      GL11.glTranslatef(0.0F, 24.0F * parTicks, 0.0F);
    } 
    GL11.glPushMatrix();
    GL11.glTranslatef(this.field_78115_e.field_78800_c * parTicks, this.field_78115_e.field_78797_d * parTicks, this.field_78115_e.field_78798_e * parTicks);
    GL11.glRotatef(this.field_78115_e.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(this.field_78115_e.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(this.field_78115_e.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    partBody();
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.field_78112_f.field_78800_c * parTicks, this.field_78112_f.field_78797_d * parTicks, this.field_78112_f.field_78798_e * parTicks);
    GL11.glRotatef(this.field_78112_f.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(this.field_78112_f.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(this.field_78112_f.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    partRightArm();
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.field_78113_g.field_78800_c * parTicks, this.field_78113_g.field_78797_d * parTicks, this.field_78113_g.field_78798_e * parTicks);
    GL11.glRotatef(this.field_78113_g.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(this.field_78113_g.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(this.field_78113_g.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    partLeftArm();
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.field_78123_h.field_78800_c * parTicks, this.field_78123_h.field_78797_d * parTicks, this.field_78123_h.field_78798_e * parTicks);
    GL11.glRotatef(this.field_78123_h.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(this.field_78123_h.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(this.field_78123_h.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    partRightLeg();
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.field_78124_i.field_78800_c * parTicks, this.field_78124_i.field_78797_d * parTicks, this.field_78124_i.field_78798_e * parTicks);
    GL11.glRotatef(this.field_78124_i.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F);
    GL11.glRotatef(this.field_78124_i.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F);
    GL11.glRotatef(this.field_78124_i.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    partLeftLeg();
    GL11.glPopMatrix();
    if (this.field_78091_s)
      GL11.glPopMatrix(); 
    post();
    GL11.glColor3f(1.0F, 1.0F, 1.0F);
    GL11.glPopMatrix();
  }
}
