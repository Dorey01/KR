package alextm.client.model;

import alextm.client.handler.ResourceHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelVoxelArmor extends ModelBiped {
  public ModelRenderOBJ head;
  
  public ModelRenderOBJ body;
  
  public ModelRenderOBJ rightArm;
  
  public ModelRenderOBJ leftArm;
  
  public ModelRenderOBJ belt;
  
  public ModelRenderOBJ rightLeg;
  
  public ModelRenderOBJ leftLeg;
  
  public ModelRenderOBJ rightBoot;
  
  public ModelRenderOBJ leftBoot;
  
  public ModelVoxelArmor(float f, int armorType, String tag, int scale) {
    super(f, 0.0F, 128, 128);
    (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0F, 0.0F, 0.0F);
    this.field_78116_c.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    (this.field_78115_e = new ModelRenderer((ModelBase)this, 16, 16)).func_78793_a(0.0F, 0.0F, 0.0F);
    this.field_78115_e.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
    (this.field_78113_g = new ModelRenderer((ModelBase)this, 40, 16)).func_78793_a(5.0F, 2.0F, 0.0F);
    this.field_78113_g.func_78790_a(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
    (this.field_78112_f = new ModelRenderer((ModelBase)this, 40, 16)).func_78793_a(-5.0F, 2.0F, 0.0F);
    this.field_78112_f.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
    (this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16)).func_78793_a(2.0F, 12.0F, 0.0F);
    this.field_78124_i.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16)).func_78793_a(-2.0F, 12.0F, 0.0F);
    this.field_78123_h.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
    String path = "model/armor/" + tag + "_x" + scale + "/";
    this.head = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "Head.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.body = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "Body.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.rightArm = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "RightArm.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.leftArm = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "LeftArm.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.belt = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "Belt.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.rightLeg = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "RightLeg.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.leftLeg = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "LeftLeg.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.rightBoot = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "RightBoot.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.leftBoot = new ModelRenderOBJ((ModelBase)this, ResourceHandler.getResource(path + "LeftBoot.obj"), ResourceHandler.getResource(path + "texturemap.png"));
    this.field_78116_c.field_78804_l.clear();
    this.field_78114_d.field_78804_l.clear();
    this.field_78115_e.field_78804_l.clear();
    this.field_78112_f.field_78804_l.clear();
    this.field_78113_g.field_78804_l.clear();
    this.field_78124_i.field_78804_l.clear();
    this.field_78123_h.field_78804_l.clear();
    this.head.field_82908_p = 2.775F;
    this.body.field_82908_p = 2.58F;
    this.field_78112_f.field_82908_p = -0.001F;
    this.field_78113_g.field_82908_p = -0.001F;
    this.rightArm.field_82906_o = 0.57F;
    this.rightArm.field_82908_p = 2.455F;
    this.leftArm.field_82906_o = -0.57F;
    this.leftArm.field_82908_p = 2.455F;
    this.belt.field_82908_p = 2.2F;
    this.field_78123_h.field_82908_p = -0.009F;
    this.field_78124_i.field_82908_p = -0.009F;
    this.rightLeg.field_82906_o = 0.267F;
    this.rightLeg.field_82908_p = 1.28F;
    this.leftLeg.field_82906_o = -0.267F;
    this.leftLeg.field_82908_p = 1.28F;
    this.rightBoot.field_82906_o = 0.267F;
    this.rightBoot.field_82908_p = 0.82F;
    this.leftBoot.field_82906_o = -0.267F;
    this.leftBoot.field_82908_p = 0.82F;
    this.head.scale = 0.063F / scale;
    this.body.scale = 0.063F / scale;
    this.rightArm.scale = 0.063F / scale;
    this.leftArm.scale = 0.063F / scale;
    this.belt.scale = 0.063F / scale;
    this.leftLeg.scale = 0.065F / scale;
    this.rightLeg.scale = 0.065F / scale;
    this.leftBoot.scale = 0.065F / scale;
    this.rightBoot.scale = 0.065F / scale;
    if (armorType == 0)
      this.field_78116_c.func_78792_a(this.head); 
    if (armorType == 1) {
      this.field_78115_e.func_78792_a(this.body);
      this.field_78113_g.func_78792_a(this.leftArm);
      this.field_78112_f.func_78792_a(this.rightArm);
    } 
    if (armorType == 2) {
      this.field_78124_i.func_78792_a(this.leftLeg);
      this.field_78123_h.func_78792_a(this.rightLeg);
      this.field_78115_e.func_78792_a(this.belt);
    } 
    if (armorType == 3) {
      this.field_78124_i.func_78792_a(this.leftBoot);
      this.field_78123_h.func_78792_a(this.rightBoot);
    } 
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    if (entity == null) {
      this.field_78117_n = false;
      this.field_78093_q = false;
      this.field_78091_s = false;
      this.field_78118_o = false;
      this.field_78112_f.field_78795_f = 0.0F;
      this.field_78112_f.field_78796_g = 0.0F;
      this.field_78112_f.field_78808_h = 0.0F;
      this.field_78113_g.field_78795_f = 0.0F;
      this.field_78113_g.field_78796_g = 0.0F;
      this.field_78113_g.field_78808_h = 0.0F;
      this.field_78115_e.field_78795_f = 0.0F;
      this.field_78115_e.field_78796_g = 0.0F;
      this.field_78115_e.field_78808_h = 0.0F;
      this.field_78116_c.field_78795_f = 0.0F;
      this.field_78116_c.field_78796_g = 0.0F;
      this.field_78116_c.field_78808_h = 0.0F;
      this.field_78124_i.field_78795_f = 0.0F;
      this.field_78124_i.field_78796_g = 0.0F;
      this.field_78124_i.field_78808_h = 0.0F;
      this.field_78123_h.field_78795_f = 0.0F;
      this.field_78123_h.field_78796_g = 0.0F;
      func_78087_a(this.field_78123_h.field_78808_h = 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, null);
    } else {
      super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
    } 
    GL11.glPushMatrix();
    OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0F, 240.0F);
    this.field_78116_c.func_78785_a(0.063F);
    this.field_78115_e.func_78785_a(0.063F);
    this.field_78112_f.func_78785_a(0.063F);
    this.field_78113_g.func_78785_a(0.063F);
    this.field_78123_h.func_78785_a(0.063F);
    this.field_78124_i.func_78785_a(0.063F);
    GL11.glPopMatrix();
  }
  
  public void func_78087_a(float f1, float f2, float f3, float f4, float f5, float f6, Entity entity) {
    this.field_78116_c.field_78797_d = 0.0F;
    this.field_78114_d.field_78797_d = 0.0F;
    this.field_78115_e.field_78795_f = 0.0F;
    this.field_78112_f.field_78808_h = 0.0F;
    this.field_78113_g.field_78808_h = 0.0F;
    this.field_78112_f.field_78798_e = 0.0F;
    this.field_78113_g.field_78798_e = 0.0F;
    this.field_78112_f.field_78796_g = 0.0F;
    this.field_78113_g.field_78796_g = 0.0F;
    this.field_78123_h.field_78796_g = 0.0F;
    this.field_78124_i.field_78796_g = 0.0F;
    this.field_78123_h.field_78798_e = 0.1F;
    this.field_78124_i.field_78798_e = 0.1F;
    this.field_78123_h.field_78797_d = 12.0F;
    this.field_78124_i.field_78797_d = 12.0F;
    this.leftLeg.field_78798_e = 0.0F;
    this.rightLeg.field_78798_e = 0.0F;
  }
}
