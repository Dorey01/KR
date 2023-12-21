package alextm.client.model.skins;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ModelMolot extends ModelBase {
  public ModelRenderer shape1;
  
  public ModelRenderer shape2;
  
  public ModelRenderer shape3;
  
  public ModelRenderer shape5;
  
  public ModelRenderer shape7;
  
  public ModelRenderer shape7_1;
  
  public ModelRenderer shape12;
  
  public ModelRenderer shape12_1;
  
  public ModelRenderer shape17;
  
  public ModelRenderer shape18;
  
  public ModelRenderer shape5_1;
  
  public ModelRenderer shape3_1;
  
  public ModelRenderer shape12_2;
  
  public ModelRenderer shape12_3;
  
  public ModelRenderer shape7_2;
  
  public ModelRenderer shape7_3;
  
  public ModelRenderer shape5_2;
  
  public ModelRenderer shape5_3;
  
  public ModelMolot() {
    this.field_78090_t = 64;
    this.field_78089_u = 32;
    (this.shape5_2 = new ModelRenderer(this, 20, 6)).func_78793_a(-7.7F, 1.1F, -3.5F);
    this.shape5_2.func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 7, 0.0F);
    setRotateAngle(this.shape5_2, 0.0F, 0.0F, 0.7853982F);
    (this.shape1 = new ModelRenderer(this, 0, 9)).func_78793_a(-1.0F, 0.0F, -1.0F);
    this.shape1.func_78790_a(0.0F, 0.0F, 0.0F, 2, 21, 2, 0.0F);
    (this.shape3 = new ModelRenderer(this, 40, 0)).func_78793_a(4.0F, 1.0F, -4.0F);
    this.shape3.func_78790_a(0.0F, 0.0F, 0.0F, 4, 8, 8, 0.0F);
    (this.shape7 = new ModelRenderer(this, 9, 22)).func_78793_a(5.5F, 0.5F, -2.5F);
    this.shape7.func_78790_a(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
    (this.shape3_1 = new ModelRenderer(this, 40, 0)).func_78793_a(-8.0F, 1.0F, -4.0F);
    this.shape3_1.func_78790_a(0.0F, 0.0F, 0.0F, 4, 8, 8, 0.0F);
    (this.shape12_1 = new ModelRenderer(this, 0, 0)).func_78793_a(5.5F, 6.5F, -4.5F);
    this.shape12_1.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 9, 0.0F);
    (this.shape7_3 = new ModelRenderer(this, 9, 22)).func_78793_a(-6.5F, 0.5F, -2.5F);
    this.shape7_3.func_78790_a(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
    (this.shape5_3 = new ModelRenderer(this, 20, 6)).func_78793_a(-7.7F, 4.6F, -3.5F);
    this.shape5_3.func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 7, 0.0F);
    setRotateAngle(this.shape5_3, 0.0F, 0.0F, 0.7853982F);
    (this.shape18 = new ModelRenderer(this, 13, 0)).func_78793_a(-1.5F, 21.0F, -1.5F);
    this.shape18.func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
    (this.shape12_2 = new ModelRenderer(this, 0, 0)).func_78793_a(-6.5F, 6.5F, -4.5F);
    this.shape12_2.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 9, 0.0F);
    (this.shape7_2 = new ModelRenderer(this, 9, 22)).func_78793_a(5.5F, 0.5F, 1.5F);
    this.shape7_2.func_78790_a(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
    (this.shape17 = new ModelRenderer(this, 15, 17)).func_78793_a(-0.5F, 4.5F, -3.5F);
    this.shape17.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 7, 0.0F);
    (this.shape12_3 = new ModelRenderer(this, 0, 0)).func_78793_a(-6.5F, 2.5F, -4.5F);
    this.shape12_3.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 9, 0.0F);
    (this.shape2 = new ModelRenderer(this, 28, 20)).func_78793_a(-6.0F, 2.0F, -3.0F);
    this.shape2.func_78790_a(0.0F, 0.0F, 0.0F, 12, 6, 6, 0.0F);
    (this.shape7_1 = new ModelRenderer(this, 9, 22)).func_78793_a(-6.5F, 0.5F, 1.5F);
    this.shape7_1.func_78790_a(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
    (this.shape5 = new ModelRenderer(this, 20, 6)).func_78793_a(7.7F, 4.6F, -3.5F);
    this.shape5.func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 7, 0.0F);
    setRotateAngle(this.shape5, 0.0F, 0.0F, 0.7853982F);
    (this.shape12 = new ModelRenderer(this, 0, 0)).func_78793_a(5.5F, 2.5F, -4.5F);
    this.shape12.func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 9, 0.0F);
    (this.shape5_1 = new ModelRenderer(this, 20, 6)).func_78793_a(7.7F, 1.1F, -3.5F);
    this.shape5_1.func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 7, 0.0F);
    setRotateAngle(this.shape5_1, 0.0F, 0.0F, 0.7853982F);
  }
  
  public void render(float f5) {
    this.shape5_2.func_78785_a(f5);
    this.shape1.func_78785_a(f5);
    this.shape3.func_78785_a(f5);
    this.shape3_1.func_78785_a(f5);
    this.shape5_3.func_78785_a(f5);
    this.shape18.func_78785_a(f5);
    this.shape2.func_78785_a(f5);
    this.shape5.func_78785_a(f5);
    this.shape5_1.func_78785_a(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
    modelRenderer.field_78795_f = x;
    modelRenderer.field_78796_g = y;
    modelRenderer.field_78808_h = z;
  }
}
