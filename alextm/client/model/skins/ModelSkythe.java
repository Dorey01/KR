package alextm.client.model.skins;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelSkythe extends ModelBase {
  public ModelRenderer Shape1;
  
  public ModelRenderer Shape2;
  
  public ModelRenderer Shape3;
  
  public ModelRenderer Shape4;
  
  public ModelRenderer Shape5;
  
  public ModelRenderer Shape6;
  
  public ModelRenderer Shape7;
  
  public ModelRenderer Shape8;
  
  public ModelRenderer Shape9;
  
  public ModelRenderer Shape10;
  
  public ModelRenderer Shape11;
  
  public ModelRenderer Shape12;
  
  public ModelRenderer Shape13;
  
  public ModelRenderer Shape14;
  
  public ModelRenderer Shape15;
  
  public ModelRenderer Shape16;
  
  public ModelRenderer Shape17;
  
  public ModelRenderer Shape18;
  
  public ModelRenderer Shape19;
  
  public ModelRenderer Shape20;
  
  public ModelRenderer Shape21;
  
  public ModelRenderer Shape22;
  
  public ModelRenderer Shape23;
  
  public ModelRenderer Shape24;
  
  public ModelRenderer Shape25;
  
  public ModelRenderer Shape26;
  
  public ModelSkythe() {
    this.field_78089_u = 64;
    this.field_78090_t = 64;
    (this.Shape1 = new ModelRenderer(this, 53, 0)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 4, 1);
    this.Shape1.func_78793_a(0.0F, -17.0F, 0.5F);
    this.Shape1.func_78787_b(64, 64);
    this.Shape1.field_78809_i = true;
    setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
    (this.Shape2 = new ModelRenderer(this, 46, 0)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 4, 2);
    this.Shape2.func_78793_a(0.0F, 16.0F, 0.0F);
    this.Shape2.func_78787_b(64, 64);
    this.Shape2.field_78809_i = true;
    setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
    (this.Shape3 = new ModelRenderer(this, 37, 0)).func_78789_a(0.0F, 0.0F, 0.0F, 2, 11, 2);
    this.Shape3.func_78793_a(-0.5F, -7.0F, 0.0F);
    this.Shape3.func_78787_b(64, 64);
    this.Shape3.field_78809_i = true;
    setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
    (this.Shape4 = new ModelRenderer(this, 53, 6)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 1, 1);
    this.Shape4.func_78793_a(0.0F, 0.0F, 1.5F);
    this.Shape4.func_78787_b(64, 64);
    this.Shape4.field_78809_i = true;
    setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
    (this.Shape5 = new ModelRenderer(this, 47, 7)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 3, 1);
    this.Shape5.func_78793_a(0.0F, -1.0F, 2.5F);
    this.Shape5.func_78787_b(64, 64);
    this.Shape5.field_78809_i = true;
    setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
    (this.Shape6 = new ModelRenderer(this, 56, 9)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 4, 3);
    this.Shape6.func_78793_a(0.0F, -5.0F, -2.0F);
    this.Shape6.func_78787_b(64, 64);
    this.Shape6.field_78809_i = true;
    setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
    (this.Shape7 = new ModelRenderer(this, 50, 18)).func_78789_a(0.0F, 0.0F, 0.0F, 3, 3, 4);
    this.Shape7.func_78793_a(-1.0F, -19.5F, -0.9F);
    this.Shape7.func_78787_b(64, 64);
    this.Shape7.field_78809_i = true;
    setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
    (this.Shape8 = new ModelRenderer(this, 46, 12)).func_78789_a(0.0F, 0.0F, 0.0F, 2, 3, 1);
    this.Shape8.func_78793_a(-0.5F, -9.0F, -0.5F);
    this.Shape8.func_78787_b(64, 64);
    this.Shape8.field_78809_i = true;
    setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
    (this.Shape9 = new ModelRenderer(this, 30, 0)).func_78789_a(0.0F, 1.0F, 0.0F, 1, 6, 2);
    this.Shape9.func_78793_a(0.0F, -14.0F, 0.0F);
    this.Shape9.func_78787_b(64, 64);
    this.Shape9.field_78809_i = true;
    setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
    (this.Shape10 = new ModelRenderer(this, 30, 17)).func_78789_a(0.0F, 0.0F, 0.0F, 4, 3, 5);
    this.Shape10.func_78793_a(-1.5F, -20.0F, -1.0F);
    this.Shape10.func_78787_b(64, 64);
    this.Shape10.field_78809_i = true;
    setRotation(this.Shape10, -0.9294653F, 0.0F, 0.0F);
    (this.Shape11 = new ModelRenderer(this, 0, 49)).func_78789_a(1.0F, 0.0F, 0.0F, 3, 5, 10);
    this.Shape11.func_78793_a(-2.0F, -19.0F, -10.0F);
    this.Shape11.func_78787_b(64, 64);
    this.Shape11.field_78809_i = true;
    setRotation(this.Shape11, 0.2602503F, 0.0F, 0.0F);
    (this.Shape12 = new ModelRenderer(this, 0, 38)).func_78789_a(0.0F, 0.0F, 0.0F, 2, 2, 7);
    this.Shape12.func_78793_a(-0.5F, -15.0F, -16.0F);
    this.Shape12.func_78787_b(64, 64);
    this.Shape12.field_78809_i = true;
    setRotation(this.Shape12, 0.4833219F, 0.0F, 0.0F);
    (this.Shape13 = new ModelRenderer(this, 52, 27)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 2, 5);
    this.Shape13.func_78793_a(-0.01F, -4.5F, -20.5F);
    this.Shape13.func_78787_b(64, 64);
    this.Shape13.field_78809_i = true;
    setRotation(this.Shape13, 1.635854F, 0.0F, 0.0F);
    (this.Shape14 = new ModelRenderer(this, 0, 27)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 4, 5);
    this.Shape14.func_78793_a(0.0F, -21.0F, 3.0F);
    this.Shape14.func_78787_b(64, 64);
    this.Shape14.field_78809_i = true;
    setRotation(this.Shape14, -0.1858931F, 0.0F, 0.0F);
    (this.Shape15 = new ModelRenderer(this, 31, 27)).func_78789_a(0.0F, 0.0F, 0.0F, 2, 1, 6);
    this.Shape15.func_78793_a(-0.5F, -19.5F, 2.0F);
    this.Shape15.func_78787_b(64, 64);
    this.Shape15.field_78809_i = true;
    setRotation(this.Shape15, -0.185895F, 0.0F, 0.0F);
    (this.Shape16 = new ModelRenderer(this, 54, 36)).func_78789_a(0.0F, 0.0F, 0.0F, 3, 5, 2);
    this.Shape16.func_78793_a(-1.0F, -20.5F, 6.0F);
    this.Shape16.func_78787_b(64, 64);
    this.Shape16.field_78809_i = true;
    setRotation(this.Shape16, 0.2974289F, 0.0F, 0.0F);
    (this.Shape17 = new ModelRenderer(this, 58, 0)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 4, 2);
    this.Shape17.func_78793_a(-0.7F, -16.5F, 7.0F);
    this.Shape17.func_78787_b(64, 64);
    this.Shape17.field_78809_i = true;
    setRotation(this.Shape17, 0.2230717F, 0.0F, 0.0F);
    (this.Shape18 = new ModelRenderer(this, 58, 0)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 4, 2);
    this.Shape18.func_78793_a(0.7F, -16.5F, 7.0F);
    this.Shape18.func_78787_b(64, 64);
    this.Shape18.field_78809_i = true;
    setRotation(this.Shape18, 0.2230717F, 0.0F, 0.0F);
    (this.Shape19 = new ModelRenderer(this, 24, 0)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 12, 1);
    this.Shape19.func_78793_a(0.0F, 4.0F, 0.5F);
    this.Shape19.func_78787_b(64, 64);
    this.Shape19.field_78809_i = true;
    setRotation(this.Shape19, 0.0F, 0.0F, 0.0F);
    (this.Shape20 = new ModelRenderer(this, 46, 45)).func_78789_a(0.0F, 0.0F, 0.0F, 2, 2, 7);
    this.Shape20.func_78793_a(-0.5F, -13.0F, -15.0F);
    this.Shape20.func_78787_b(64, 64);
    this.Shape20.field_78809_i = true;
    setRotation(this.Shape20, 0.4833219F, 0.0F, 0.0F);
    (this.Shape21 = new ModelRenderer(this, 42, 35)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 4, 4);
    this.Shape21.func_78793_a(0.0F, -12.25F, -18.0F);
    this.Shape21.func_78787_b(64, 64);
    this.Shape21.field_78809_i = true;
    setRotation(this.Shape21, 0.8179241F, 0.0F, 0.0F);
    (this.Shape22 = new ModelRenderer(this, 52, 57)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 2, 5);
    this.Shape22.func_78793_a(0.0F, -7.3F, -20.0F);
    this.Shape22.func_78787_b(64, 64);
    this.Shape22.field_78809_i = true;
    setRotation(this.Shape22, 0.8179311F, 0.0F, 0.0F);
    (this.Shape23 = new ModelRenderer(this, 13, 0)).func_78789_a(0.0F, 0.0F, 0.0F, 3, 3, 2);
    this.Shape23.func_78793_a(-1.01F, -18.0F, -3.8F);
    this.Shape23.func_78787_b(64, 64);
    this.Shape23.field_78809_i = true;
    setRotation(this.Shape23, 0.0F, 0.0F, 0.0F);
    (this.Shape24 = new ModelRenderer(this, 0, 11)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 2, 4);
    this.Shape24.func_78793_a(0.0F, -9.4F, -20.7F);
    this.Shape24.func_78787_b(64, 64);
    this.Shape24.field_78809_i = true;
    setRotation(this.Shape24, 0.8179311F, 0.0F, 0.0F);
    (this.Shape25 = new ModelRenderer(this, 0, 0)).func_78789_a(0.0F, 0.0F, 0.0F, 2, 5, 4);
    this.Shape25.func_78793_a(-0.5F, -22.0F, -1.0F);
    this.Shape25.func_78787_b(64, 64);
    this.Shape25.field_78809_i = true;
    setRotation(this.Shape25, 0.0F, 0.0F, 0.0F);
    (this.Shape26 = new ModelRenderer(this, 24, 4)).func_78789_a(0.0F, 0.0F, 0.0F, 1, 8, 1);
    this.Shape26.func_78793_a(0.0F, -18.5F, -9.0F);
    this.Shape26.func_78787_b(64, 64);
    this.Shape26.field_78809_i = true;
    setRotation(this.Shape26, 1.896109F, 0.0F, 0.0F);
  }
  
  public void render(float f5) {
    this.Shape1.func_78785_a(f5);
    this.Shape2.func_78785_a(f5);
    this.Shape3.func_78785_a(f5);
    this.Shape4.func_78785_a(f5);
    this.Shape5.func_78785_a(f5);
    this.Shape6.func_78785_a(f5);
    this.Shape7.func_78785_a(f5);
    this.Shape8.func_78785_a(f5);
    this.Shape9.func_78785_a(f5);
    this.Shape10.func_78785_a(f5);
    this.Shape11.func_78785_a(f5);
    this.Shape12.func_78785_a(f5);
    GL11.glPushMatrix();
    GL11.glScaled(1.02D, 1.0D, 1.0D);
    this.Shape13.func_78785_a(f5);
    GL11.glPopMatrix();
    this.Shape14.func_78785_a(f5);
    this.Shape15.func_78785_a(f5);
    this.Shape16.func_78785_a(f5);
    this.Shape17.func_78785_a(f5);
    this.Shape18.func_78785_a(f5);
    this.Shape19.func_78785_a(f5);
    this.Shape20.func_78785_a(f5);
    this.Shape21.func_78785_a(f5);
    this.Shape22.func_78785_a(f5);
    GL11.glPushMatrix();
    GL11.glScaled(1.02D, 1.0D, 1.0D);
    this.Shape23.func_78785_a(f5);
    GL11.glPopMatrix();
    this.Shape24.func_78785_a(f5);
    this.Shape25.func_78785_a(f5);
    this.Shape26.func_78785_a(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.field_78795_f = x;
    model.field_78796_g = y;
    model.field_78808_h = z;
  }
}
