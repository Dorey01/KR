package alextm.client;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ArmorRenderDarkness extends ArmorRenderObjBase {
  public ArmorRenderDarkness(int armorType) {
    this.partType = armorType;
  }
  
  public void pre() {
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 771);
  }
  
  public void post() {
    GL11.glDisable(3042);
  }
  
  public void partHead() {
    if (this.partType == 0) {
      GL11.glTranslatef(-0.37F, -0.7F, 0.4F);
      GL11.glScalef(0.625F, 0.625F, 0.625F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      head.renderAll();
    } 
  }
  
  public void partBody() {
    if (this.partType == 1) {
      GL11.glTranslatef(-0.75F, -1.4F, 0.25F);
      GL11.glScalef(0.625F, 0.625F, 0.625F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      chest.renderAll();
    } 
  }
  
  public void partLeftArm() {
    if (this.partType == 1) {
      GL11.glTranslatef(-0.135F, -1.965F, 0.25F);
      GL11.glScalef(0.655F, 0.625F, 0.625F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      armLeft.renderAll();
    } 
  }
  
  public void partRightArm() {
    if (this.partType == 1) {
      GL11.glTranslatef(-0.45F, -1.965F, 0.25F);
      GL11.glScalef(0.645F, 0.625F, 0.625F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      armRight.renderAll();
    } 
  }
  
  public void partRightLeg() {
    if (this.partType == 2) {
      GL11.glPushMatrix();
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glTranslatef(-0.325F, -1.925F, 0.2F);
      GL11.glScalef(0.635F, 0.625F, 0.625F);
      stanciRight.renderAll();
      GL11.glPopMatrix();
    } 
    if (this.partType == 3) {
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glTranslatef(-0.15F, -2.05F, 0.3F);
      GL11.glScalef(0.625F, 0.625F, 0.625F);
      bootsLeft.renderAll();
    } 
  }
  
  public void partLeftLeg() {
    if (this.partType == 2) {
      GL11.glPushMatrix();
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glTranslatef(-0.125F, -1.925F, 0.2F);
      GL11.glScalef(0.625F, 0.625F, 0.625F);
      stanciLeft.renderAll();
      GL11.glPopMatrix();
    } 
    if (this.partType == 3) {
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glTranslatef(-0.155F, -2.05F, 0.3F);
      GL11.glScalef(0.625F, 0.625F, 0.625F);
      bootsRight.renderAll();
    } 
  }
  
  public static final IModelCustom bootsLeft = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/darkness/bootLeft.obj"));
  
  public static final IModelCustom bootsRight = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/darkness/bootRight.obj"));
  
  public static final IModelCustom stanciLeft = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/darkness/stanciLeft.obj"));
  
  public static final IModelCustom stanciRight = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/darkness/stanciRight.obj"));
  
  public static final IModelCustom armRight = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/darkness/chestRight.obj"));
  
  public static final IModelCustom armLeft = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/darkness/chestLeft.obj"));
  
  public static final IModelCustom head = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/darkness/helm.obj"));
  
  public static final IModelCustom chest = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/darkness/chest.obj"));
  
  public static final ResourceLocation texture = new ResourceLocation("alextm:textures/armor/DarknessArmorTex.png");
  
  private final int partType;
}
