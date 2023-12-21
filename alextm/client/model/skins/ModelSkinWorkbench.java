package alextm.client.model.skins;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelSkinWorkbench extends ModelBase {
  public ModelRenderer shape5;
  
  public ModelRenderer shape2;
  
  public ModelRenderer shape1;
  
  public ModelRenderer shape7;
  
  public ModelRenderer shape6;
  
  public ModelRenderer shape10;
  
  public ModelRenderer shape4;
  
  public ModelRenderer shape3;
  
  public ModelRenderer shape8;
  
  public ModelRenderer shape11;
  
  public ModelRenderer shape12;
  
  public ModelRenderer shape9;
  
  public ModelRenderer shape24;
  
  public ModelRenderer shape23;
  
  public ModelRenderer shape22;
  
  public ModelRenderer shape14;
  
  public ModelRenderer shape13;
  
  public ModelRenderer shape15;
  
  public ModelRenderer shape16;
  
  public ModelRenderer shape21;
  
  public ModelRenderer shape20;
  
  public ModelRenderer shape19;
  
  public ModelRenderer shape18;
  
  public ModelRenderer shape17;
  
  public ModelSkinWorkbench() {
    this.field_78090_t = 64;
    this.field_78089_u = 32;
    (this.shape4 = new ModelRenderer(this, 48, 0)).func_78793_a(-2.0F, 22.0F, -8.0F);
    this.shape4.func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
    (this.shape14 = new ModelRenderer(this, 0, 9)).func_78793_a(5.72F, 18.0F, 5.58F);
    this.shape14.func_78790_a(-1.5F, -2.5F, -1.0F, 3, 5, 2, 0.0F);
    setRotateAngle(this.shape14, 0.3926991F, 3.9269907F, 0.0F);
    (this.shape1 = new ModelRenderer(this, 48, 0)).func_78793_a(4.0F, 22.0F, -2.0F);
    this.shape1.func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
    (this.shape5 = new ModelRenderer(this, 30, 0)).func_78793_a(7.4F, 22.0F, -1.5F);
    this.shape5.func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 8, 0.0F);
    setRotateAngle(this.shape5, 0.0F, 3.9269907F, 0.0F);
    (this.shape9 = new ModelRenderer(this, 0, 0)).func_78793_a(4.54F, 21.0F, -4.39F);
    this.shape9.func_78790_a(-2.0F, -2.5F, -1.0F, 4, 5, 2, 0.0F);
    setRotateAngle(this.shape9, 0.7853982F, -0.7853982F, 0.0F);
    (this.shape12 = new ModelRenderer(this, 0, 0)).func_78793_a(-4.39F, 21.0F, -4.49F);
    this.shape12.func_78790_a(-2.0F, -2.5F, -1.0F, 4, 5, 2, 0.0F);
    setRotateAngle(this.shape12, 0.7853982F, 0.7853982F, 0.0F);
    (this.shape6 = new ModelRenderer(this, 30, 0)).func_78793_a(1.67F, 22.0F, 7.37F);
    this.shape6.func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 8, 0.0F);
    setRotateAngle(this.shape6, 0.0F, 2.3561945F, 0.0F);
    (this.shape13 = new ModelRenderer(this, 0, 9)).func_78793_a(5.7F, 18.0F, -5.56F);
    this.shape13.func_78790_a(-1.5F, -2.5F, -1.0F, 3, 5, 2, 0.0F);
    setRotateAngle(this.shape13, 0.3926991F, -0.7853982F, 0.0F);
    (this.shape17 = new ModelRenderer(this, 0, 18)).func_78793_a(5.6F, 14.2F, -5.46F);
    this.shape17.func_78790_a(-1.0F, -2.5F, -1.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.shape17, -0.3926991F, -0.7853982F, 0.0F);
    (this.shape7 = new ModelRenderer(this, 30, 0)).func_78793_a(-7.34F, 22.0F, 1.62F);
    this.shape7.func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 8, 0.0F);
    setRotateAngle(this.shape7, 0.0F, 0.7853982F, 0.0F);
    (this.shape10 = new ModelRenderer(this, 0, 0)).func_78793_a(4.61F, 21.0F, 4.51F);
    this.shape10.func_78790_a(-2.0F, -2.5F, -1.0F, 4, 5, 2, 0.0F);
    setRotateAngle(this.shape10, 0.7853982F, 3.9269907F, 0.0F);
    (this.shape2 = new ModelRenderer(this, 48, 0)).func_78793_a(-2.0F, 22.0F, 4.0F);
    this.shape2.func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
    (this.shape11 = new ModelRenderer(this, 0, 0)).func_78793_a(-4.39F, 21.0F, 4.51F);
    this.shape11.func_78790_a(-2.0F, -2.5F, -1.0F, 4, 5, 2, 0.0F);
    setRotateAngle(this.shape11, 0.7853982F, 2.3561945F, 0.0F);
    (this.shape16 = new ModelRenderer(this, 0, 9)).func_78793_a(-5.4F, 18.0F, -5.52F);
    this.shape16.func_78790_a(-1.5F, -2.5F, -1.0F, 3, 5, 2, 0.0F);
    setRotateAngle(this.shape16, 0.3926991F, 0.7853982F, 0.0F);
    (this.shape21 = new ModelRenderer(this, 0, 27)).func_78793_a(5.6F, 12.6F, -5.46F);
    this.shape21.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
    setRotateAngle(this.shape21, -0.3926991F, -0.7853982F, 0.0F);
    (this.shape8 = new ModelRenderer(this, 30, 0)).func_78793_a(-4.4F, 22.0F, 1.14F);
    this.shape8.func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 8, 0.0F);
    setRotateAngle(this.shape8, 0.0F, 2.3561945F, 0.0F);
    (this.shape22 = new ModelRenderer(this, 0, 27)).func_78793_a(5.67F, 12.6F, 5.54F);
    this.shape22.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
    setRotateAngle(this.shape22, -0.3926991F, 3.9269907F, 0.0F);
    (this.shape20 = new ModelRenderer(this, 0, 18)).func_78793_a(-5.3F, 14.2F, -5.42F);
    this.shape20.func_78790_a(-1.0F, -2.5F, -1.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.shape20, -0.3926991F, 0.7853982F, 0.0F);
    (this.shape24 = new ModelRenderer(this, 0, 27)).func_78793_a(-5.3F, 12.6F, -5.42F);
    this.shape24.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
    setRotateAngle(this.shape24, -0.3926991F, 0.7853982F, 0.0F);
    (this.shape23 = new ModelRenderer(this, 0, 27)).func_78793_a(-5.44F, 12.6F, 5.57F);
    this.shape23.func_78790_a(-0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F);
    setRotateAngle(this.shape23, -0.3926991F, 2.3561945F, 0.0F);
    (this.shape15 = new ModelRenderer(this, 0, 9)).func_78793_a(-5.54F, 18.0F, 5.67F);
    this.shape15.func_78790_a(-1.5F, -2.5F, -1.0F, 3, 5, 2, 0.0F);
    setRotateAngle(this.shape15, 0.3926991F, 2.3561945F, 0.0F);
    (this.shape3 = new ModelRenderer(this, 48, 0)).func_78793_a(-8.0F, 22.0F, -2.0F);
    this.shape3.func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F);
    (this.shape18 = new ModelRenderer(this, 0, 18)).func_78793_a(5.67F, 14.2F, 5.54F);
    this.shape18.func_78790_a(-1.0F, -2.5F, -1.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.shape18, -0.3926991F, 3.9269907F, 0.0F);
    (this.shape19 = new ModelRenderer(this, 0, 18)).func_78793_a(-5.44F, 14.2F, 5.57F);
    this.shape19.func_78790_a(-1.0F, -2.5F, -1.0F, 2, 5, 2, 0.0F);
    setRotateAngle(this.shape19, -0.3926991F, 2.3561945F, 0.0F);
  }
  
  public void renderModel(float f5) {
    this.shape4.func_78785_a(f5);
    this.shape14.func_78785_a(f5);
    this.shape1.func_78785_a(f5);
    this.shape5.func_78785_a(f5);
    this.shape9.func_78785_a(f5);
    this.shape12.func_78785_a(f5);
    this.shape6.func_78785_a(f5);
    this.shape13.func_78785_a(f5);
    this.shape17.func_78785_a(f5);
    this.shape7.func_78785_a(f5);
    this.shape10.func_78785_a(f5);
    this.shape2.func_78785_a(f5);
    this.shape11.func_78785_a(f5);
    this.shape16.func_78785_a(f5);
    this.shape21.func_78785_a(f5);
    this.shape8.func_78785_a(f5);
    this.shape22.func_78785_a(f5);
    this.shape20.func_78785_a(f5);
    this.shape24.func_78785_a(f5);
    this.shape23.func_78785_a(f5);
    this.shape15.func_78785_a(f5);
    this.shape3.func_78785_a(f5);
    this.shape18.func_78785_a(f5);
    this.shape19.func_78785_a(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.field_78795_f = x;
    modelRenderer.field_78796_g = y;
    modelRenderer.field_78808_h = z;
  }
  
  public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
  }
}
