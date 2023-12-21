package alextm.client.model;

import alextm.client.handler.ResourceHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelRenderOBJ extends ModelRenderer {
  private IModelCustom model;
  
  private ResourceLocation texture;
  
  private int displayList;
  
  private boolean compiled;
  
  public float scale;
  
  public ModelRenderOBJ(ModelBase baseModel, ResourceLocation customModel, ResourceLocation texture) {
    super(baseModel);
    this.compiled = false;
    this.scale = 0.0F;
    try {
      this.model = AdvancedModelLoader.loadModel(customModel);
    } catch (Exception var5) {
      this.model = AdvancedModelLoader.loadModel(ResourceHandler.getResource("model/armor/null.obj"));
    } 
    this.texture = texture;
  }
  
  public void func_78785_a(float scale) {
    if (!this.field_78807_k && this.field_78806_j) {
      if (!this.compiled)
        compileDisplayList(scale); 
      GL11.glTranslatef(this.field_82906_o, this.field_82908_p, this.field_82907_q);
      if (this.field_78795_f == 0.0F && this.field_78796_g == 0.0F && this.field_78808_h == 0.0F) {
        if (this.field_78800_c == 0.0F && this.field_78797_d == 0.0F && this.field_78798_e == 0.0F) {
          GL11.glCallList(this.displayList);
        } else {
          GL11.glTranslatef(this.field_78800_c * scale, this.field_78797_d * scale, this.field_78798_e * scale);
          GL11.glCallList(this.displayList);
          GL11.glTranslatef(-this.field_78800_c * scale, -this.field_78797_d * scale, -this.field_78798_e * scale);
        } 
      } else {
        GL11.glPushMatrix();
        GL11.glTranslatef(this.field_78800_c * scale, this.field_78797_d * scale, this.field_78798_e * scale);
        if (this.field_78808_h != 0.0F)
          GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F); 
        if (this.field_78796_g != 0.0F)
          GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F); 
        if (this.field_78795_f != 0.0F)
          GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F); 
        GL11.glCallList(this.displayList);
        GL11.glPopMatrix();
      } 
      GL11.glTranslatef(-this.field_82906_o, -this.field_82908_p, -this.field_82907_q);
    } 
  }
  
  private void compileDisplayList(float scale) {
    if (this.scale == 0.0F)
      this.scale = scale; 
    scale = this.scale;
    GL11.glNewList(this.displayList = GLAllocation.func_74526_a(1), 4864);
    GL11.glPushMatrix();
    ResourceHandler.bindTexture(this.texture);
    GL11.glScalef(scale, scale, scale);
    GL11.glRotatef(180.0F, -1.0F, 0.0F, 1.0F);
    this.model.renderAll();
    GL11.glPopMatrix();
    GL11.glEndList();
    this.compiled = true;
  }
  
  public void func_78791_b(float scale) {
    if (!this.field_78807_k && this.field_78806_j) {
      if (!this.compiled)
        compileDisplayList(scale); 
      GL11.glPushMatrix();
      GL11.glTranslatef(this.field_78800_c * scale, this.field_78797_d * scale, this.field_78798_e * scale);
      if (this.field_78796_g != 0.0F)
        GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F); 
      if (this.field_78795_f != 0.0F)
        GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F); 
      if (this.field_78808_h != 0.0F)
        GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F); 
      GL11.glCallList(this.displayList);
      GL11.glPopMatrix();
    } 
  }
  
  public void func_78794_c(float scale) {
    if (!this.field_78807_k && this.field_78806_j)
      if (this.field_78795_f == 0.0F && this.field_78796_g == 0.0F && this.field_78808_h == 0.0F) {
        if (this.field_78800_c != 0.0F || this.field_78797_d != 0.0F || this.field_78798_e != 0.0F)
          GL11.glTranslatef(this.field_78800_c * scale, this.field_78797_d * scale, this.field_78798_e * scale); 
      } else {
        GL11.glTranslatef(this.field_78800_c * scale, this.field_78797_d * scale, this.field_78798_e * scale);
        if (this.field_78808_h != 0.0F)
          GL11.glRotatef(this.field_78808_h * 57.295776F, 0.0F, 0.0F, 1.0F); 
        if (this.field_78796_g != 0.0F)
          GL11.glRotatef(this.field_78796_g * 57.295776F, 0.0F, 1.0F, 0.0F); 
        if (this.field_78795_f != 0.0F)
          GL11.glRotatef(this.field_78795_f * 57.295776F, 1.0F, 0.0F, 0.0F); 
      }  
  }
}
