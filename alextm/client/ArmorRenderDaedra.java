package alextm.client;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ArmorRenderDaedra extends ArmorRenderObjBase {
  public ArmorRenderDaedra(int armorType) {
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
      GL11.glTranslatef(-0.52F, -1.7F, 0.4F);
      GL11.glScalef(0.65F, 0.775F, 0.665F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      head.renderAll();
    } 
  }
  
  public void partBody() {
    if (this.partType == 1) {
      GL11.glTranslatef(0.0F, -0.85F, 0.0F);
      GL11.glScalef(0.0625F, 0.0625F, 0.0675F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      chest.renderAll();
    } 
  }
  
  public void partRightArm() {
    if (this.partType == 1) {
      GL11.glTranslatef(-0.455F, -2.0F, 0.275F);
      GL11.glScalef(0.625F, 0.625F, 0.675F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      armLeft.renderAll();
    } 
  }
  
  public void partLeftArm() {
    if (this.partType == 1) {
      GL11.glTranslatef(-0.155F, -2.0F, 0.275F);
      GL11.glScalef(0.625F, 0.625F, 0.675F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      armRight.renderAll();
    } 
  }
  
  public void partRightLeg() {
    if (this.partType == 2) {
      GL11.glPushMatrix();
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glTranslatef(-0.2F, -0.85F, 0.25F);
      GL11.glScalef(0.625F, 0.625F, 0.63F);
      stanciRight.renderAll();
      GL11.glPopMatrix();
    } 
    if (this.partType == 3) {
      GL11.glTranslatef(-0.15F, -0.95F, 0.24F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glScalef(0.625F, 0.625F, 0.625F);
      bootsLeft.renderAll();
    } 
  }
  
  public void partLeftLeg() {
    if (this.partType == 2) {
      GL11.glPushMatrix();
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glTranslatef(-0.55F, -0.85F, 0.25F);
      GL11.glScalef(0.625F, 0.625F, 0.63F);
      stanciLeft.renderAll();
      GL11.glPopMatrix();
    } 
    if (this.partType == 3) {
      GL11.glTranslatef(-0.475F, -0.95F, 0.24F);
      (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
      GL11.glScalef(0.625F, 0.625F, 0.625F);
      bootsRight.renderAll();
    } 
  }
  
  public static final IModelCustom bootsLeft = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/daedra/DaedraArmorBootsLeft.obj"));
  
  public static final IModelCustom bootsRight = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/daedra/DaedraArmorBootsRight.obj"));
  
  public static final IModelCustom stanciLeft = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/daedra/DaedraArmorStanciRight.obj"));
  
  public static final IModelCustom stanciRight = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/daedra/DaedraArmorStanciLeft.obj"));
  
  public static final IModelCustom armRight = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/daedra/DaedraArmorChestplateArmLeft.obj"));
  
  public static final IModelCustom armLeft = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/daedra/DaedraArmorChestplateArmRight.obj"));
  
  public static final IModelCustom head = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/daedra/DaedraArmoreHelmet.obj"));
  
  public static final IModelCustom chest = AdvancedModelLoader.loadModel(new ResourceLocation("alextm:model/daedra/DaedraArmorChestplateGrudBlat.obj"));
  
  public static final ResourceLocation texture = new ResourceLocation("alextm:textures/armor/DaedraArmorTex.png");
  
  private final int partType;
}
