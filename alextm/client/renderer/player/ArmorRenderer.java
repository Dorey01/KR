package alextm.client.renderer.player;

import alextm.ModConfig;
import alextm.client.gui.GuiImage;
import alextm.core.ModItemsImport;
import alextm.proxy.ClientProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.Color;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustrum;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ArmorRenderer {
  private int backVisible = 64;
  
  private RenderBlocks renderBlocks = new RenderBlocks();
  
  private RenderItem renderItem = new RenderItem();
  
  private Minecraft mc = Minecraft.func_71410_x();
  
  @SubscribeEvent
  public void onRenderWorldLast(RenderWorldLastEvent event) {
    if (ModConfig.ArmorStatus) {
      Minecraft mc = Minecraft.func_71410_x();
      if (Minecraft.func_71382_s()) {
        EntityLivingBase cameraEntity = mc.field_71451_h;
        Vec3 renderingVector = cameraEntity.func_70666_h(event.partialTicks);
        Frustrum frustrum = new Frustrum();
        double viewX = cameraEntity.field_70142_S + (cameraEntity.field_70165_t - cameraEntity.field_70142_S) * event.partialTicks;
        double viewY = cameraEntity.field_70137_T + (cameraEntity.field_70163_u - cameraEntity.field_70137_T) * event.partialTicks;
        double viewZ = cameraEntity.field_70136_U + (cameraEntity.field_70161_v - cameraEntity.field_70136_U) * event.partialTicks;
        frustrum.func_78547_a(viewX, viewY, viewZ);
        WorldClient client = mc.field_71441_e;
        Set entities = (Set)ReflectionHelper.getPrivateValue(WorldClient.class, client, new String[] { "entityList", "field_73032_d", "J" });
        Iterator<Entity> var14 = entities.iterator();
        while (true) {
          if (!var14.hasNext())
            return; 
          Entity entity = var14.next();
          if (entity != null && 
            entity instanceof EntityPlayer && 
            entity.func_145770_h(renderingVector.field_72450_a, renderingVector.field_72448_b, renderingVector.field_72449_c) && (
            entity.field_70158_ak || frustrum.func_78546_a(entity.field_70121_D)))
            if (entity.func_70089_S() && !entity.func_70005_c_().equals(ClientProxy.myName))
              RenderArmorBar((EntityLivingBase)entity, event.partialTicks, (Entity)cameraEntity);  
        } 
      } 
    } 
  }
  
  public void RenderArmorBar(EntityLivingBase passedEntity, float partialTicks, Entity viewPoint) {
    if (passedEntity.field_70153_n == null) {
      EntityLivingBase entity;
      for (entity = passedEntity; entity.field_70154_o instanceof EntityLivingBase; entity = (EntityLivingBase)entity.field_70154_o);
      while (true) {
        float distance = passedEntity.func_70032_d(viewPoint);
        if (distance <= ModConfig.ArmorStatusMaxDistance && passedEntity.func_70685_l(viewPoint) && !entity.func_82150_aj()) {
          double x = passedEntity.field_70142_S + (passedEntity.field_70165_t - passedEntity.field_70142_S) * partialTicks;
          double y = passedEntity.field_70137_T + (passedEntity.field_70163_u - passedEntity.field_70137_T) * partialTicks;
          double z = passedEntity.field_70136_U + (passedEntity.field_70161_v - passedEntity.field_70136_U) * partialTicks;
          float scale = 0.026666673F;
          float maxHealth = entity.func_110138_aP();
          if (maxHealth > 0.0F) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)(x - RenderManager.field_78725_b), (float)(y - RenderManager.field_78726_c + (passedEntity.field_70131_O / 2.0F)), (float)(z - RenderManager.field_78723_d));
            GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
            GL11.glScalef(-0.026666673F, -0.026666673F, -1.0E-4F);
            GL11.glDisable(3008);
            if (ModConfig.HpAndHungerBar) {
              float health = Math.min(maxHealth, entity.func_110143_aJ());
              HealthBar(health, maxHealth);
              if (passedEntity instanceof EntityPlayer) {
                float offset = Math.min(20, ((EntityPlayer)passedEntity).func_71024_bL().func_75116_a());
                HungerBar(offset);
              } 
            } 
            if (passedEntity.func_70694_bm() != null) {
              BackgroundItem(40.0F, -8.0F);
              GL11.glPushMatrix();
              GL11.glDisable(2896);
              GL11.glTranslatef(40.0F, -8.0F, 0.0F);
              if (!ForgeHooksClient.renderInventoryItem(this.renderBlocks, this.mc.field_71446_o, passedEntity.func_70694_bm(), true, 0.0F, 0.0F, 0.0F))
                if (passedEntity.func_70694_bm().func_77973_b() != ModItemsImport.QuantumHelm && passedEntity.func_70694_bm().func_77973_b() != ModItemsImport.QuantumChest && passedEntity.func_70694_bm().func_77973_b() != ModItemsImport.QuantumLegs && passedEntity.func_70694_bm().func_77973_b() != ModItemsImport.QuantumBoots) {
                  this.renderItem.func_77015_a(this.mc.field_71466_p, this.mc.field_71446_o, passedEntity.func_70694_bm(), 0, 0);
                } else {
                  GL11.glDepthMask(false);
                  this.renderItem.func_77015_a(this.mc.field_71466_p, this.mc.field_71446_o, passedEntity.func_70694_bm(), 0, 0);
                  GL11.glDepthMask(true);
                }  
              renderItemDamage(this.mc.field_71466_p, this.mc.field_71446_o, passedEntity.func_70694_bm());
              GL11.glEnable(2896);
              GL11.glPopMatrix();
            } 
            for (int i = 4; i > 0; i--) {
              float offset = i * 17.0F - 34.0F;
              if (passedEntity.func_71124_b(i) != null) {
                BackgroundItem(-56.0F, -offset);
                GL11.glPushMatrix();
                GL11.glDisable(2896);
                GL11.glTranslatef(-56.0F, -offset, 0.0F);
                if (!ForgeHooksClient.renderInventoryItem(this.renderBlocks, this.mc.field_71446_o, passedEntity.func_71124_b(i), true, 0.0F, 0.0F, 0.0F))
                  if (passedEntity.func_71124_b(i).func_77973_b() != ModItemsImport.QuantumHelm && passedEntity.func_71124_b(i).func_77973_b() != ModItemsImport.QuantumChest && passedEntity.func_71124_b(i).func_77973_b() != ModItemsImport.QuantumLegs && passedEntity.func_71124_b(i).func_77973_b() != ModItemsImport.QuantumBoots) {
                    this.renderItem.func_77015_a(this.mc.field_71466_p, this.mc.field_71446_o, passedEntity.func_71124_b(i), 0, 0);
                  } else {
                    GL11.glDepthMask(false);
                    this.renderItem.func_77015_a(this.mc.field_71466_p, this.mc.field_71446_o, passedEntity.func_71124_b(i), 0, 0);
                    GL11.glDepthMask(true);
                  }  
                renderItemDamage(this.mc.field_71466_p, this.mc.field_71446_o, passedEntity.func_71124_b(i));
                GL11.glEnable(2896);
                GL11.glPopMatrix();
              } 
            } 
            GL11.glEnable(3008);
            GL11.glEnable(2896);
            GL11.glPopMatrix();
          } 
        } 
        Entity riddenBy = entity.field_70153_n;
        if (!(riddenBy instanceof EntityLivingBase))
          break; 
        entity = (EntityLivingBase)riddenBy;
      } 
    } 
  }
  
  private void BackgroundItem(float x, float y) {
    GL11.glPushMatrix();
    GL11.glTranslatef(x, y, -1.0F);
    GL11.glDisable(2896);
    GL11.glDisable(3553);
    GL11.glEnable(3042);
    GL11.glDisable(2884);
    GL11.glBlendFunc(770, 771);
    GL11.glDepthMask(false);
    Tessellator tessellator = Tessellator.field_78398_a;
    tessellator.func_78382_b();
    tessellator.func_78370_a(0, 0, 0, this.backVisible);
    tessellator.func_78377_a(0.0D, 0.0D, 0.0D);
    tessellator.func_78377_a(0.0D, 16.0D, 0.0D);
    tessellator.func_78377_a(16.0D, 16.0D, 0.0D);
    tessellator.func_78377_a(16.0D, 0.0D, 0.0D);
    tessellator.func_78381_a();
    GL11.glDepthMask(true);
    GL11.glDisable(3042);
    GL11.glEnable(3553);
    GL11.glEnable(2896);
    GL11.glEnable(2884);
    GL11.glPopMatrix();
  }
  
  private void HealthBar(float health, float maxHealth) {
    GL11.glPushMatrix();
    GL11.glTranslatef(-39.0F, -30.0F, 0.0F);
    GL11.glDisable(2896);
    GL11.glDisable(3553);
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 771);
    Tessellator tessellator = Tessellator.field_78398_a;
    tessellator.func_78382_b();
    tessellator.func_78370_a(0, 0, 0, this.backVisible);
    tessellator.func_78377_a(0.0D, 0.0D, 0.0D);
    tessellator.func_78377_a(0.0D, 29.0D, 0.0D);
    tessellator.func_78377_a(3.0D, 29.0D, 0.0D);
    tessellator.func_78377_a(3.0D, 0.0D, 0.0D);
    tessellator.func_78381_a();
    float s = Math.max(0.0F, health / maxHealth / 3.0F - 0.07F);
    Color name = Color.getHSBColor(s, 1.0F, 1.0F);
    int r = name.getRed();
    int g = name.getGreen();
    int b = name.getBlue();
    GL11.glTranslatef(0.0F, 0.0F, 1.0F);
    tessellator.func_78382_b();
    tessellator.func_78370_a(r, g, b, 255);
    tessellator.func_78377_a(1.0D, (28.0F - 27.0F * health / maxHealth), 0.0D);
    tessellator.func_78377_a(1.0D, 28.0D, 0.0D);
    tessellator.func_78377_a(2.0D, 28.0D, 0.0D);
    tessellator.func_78377_a(2.0D, (28.0F - 27.0F * health / maxHealth), 0.0D);
    tessellator.func_78381_a();
    GL11.glDisable(3042);
    GL11.glEnable(3553);
    GL11.glTranslatef(-0.1F, -3.75F, 1.0F);
    GL11.glScalef(0.35F, 0.35F, 1.0F);
    GuiImage.bindTexture("minecraft:textures/gui/icons.png");
    GuiImage.drawImage(0, 0, 16, 0, 9, 9, 1.0F);
    GL11.glTranslatef(0.0F, 0.0F, 1.0F);
    GuiImage.drawImage(0, 0, 52, 0, 9, 8, 1.0F);
    GL11.glEnable(2896);
    GL11.glPopMatrix();
  }
  
  private void HungerBar(float hunger) {
    GL11.glPushMatrix();
    GL11.glTranslatef(-39.0F, 0.0F, 0.0F);
    GL11.glDisable(2896);
    GL11.glDisable(3553);
    GL11.glEnable(3042);
    GL11.glBlendFunc(770, 771);
    Tessellator tessellator = Tessellator.field_78398_a;
    tessellator.func_78382_b();
    tessellator.func_78370_a(0, 0, 0, this.backVisible);
    tessellator.func_78377_a(0.0D, 0.0D, 0.0D);
    tessellator.func_78377_a(0.0D, 29.0D, 0.0D);
    tessellator.func_78377_a(3.0D, 29.0D, 0.0D);
    tessellator.func_78377_a(3.0D, 0.0D, 0.0D);
    tessellator.func_78381_a();
    float s = Math.max(0.0F, hunger / 20.0F / 3.0F - 0.07F);
    Color name = Color.getHSBColor(s, 1.0F, 1.0F);
    int r = name.getRed();
    int g = name.getGreen();
    int b = name.getBlue();
    GL11.glTranslatef(0.0F, 0.0F, 1.0F);
    tessellator.func_78382_b();
    tessellator.func_78370_a(r, g, b, 255);
    tessellator.func_78377_a(1.0D, 1.0D, 0.0D);
    tessellator.func_78377_a(1.0D, (28.0F * hunger / 20.0F), 0.0D);
    tessellator.func_78377_a(2.0D, (28.0F * hunger / 20.0F), 0.0D);
    tessellator.func_78377_a(2.0D, 1.0D, 0.0D);
    tessellator.func_78381_a();
    GL11.glDisable(3042);
    GL11.glEnable(3553);
    GL11.glTranslatef(-0.1F, 29.75F, 1.0F);
    GL11.glScalef(0.35F, 0.35F, 1.0F);
    GuiImage.bindTexture("minecraft:textures/gui/icons.png");
    GuiImage.drawImage(0, 0, 16, 27, 9, 9, 1.0F);
    GL11.glTranslatef(0.0F, 0.0F, 1.0F);
    GuiImage.drawImage(0, 0, 52, 27, 9, 8, 1.0F);
    GL11.glEnable(2896);
    GL11.glPopMatrix();
  }
  
  private void renderItemDamage(FontRenderer p_77021_1_, TextureManager p_77021_2_, ItemStack p_77021_3_) {
    renderItemDamage(p_77021_1_, p_77021_2_, p_77021_3_, 0, 0, null);
  }
  
  private void renderItemDamage(FontRenderer p_94148_1_, TextureManager p_94148_2_, ItemStack p_94148_3_, int p_94148_4_, int p_94148_5_, String p_94148_6_) {
    if (p_94148_3_ != null) {
      if (p_94148_3_.field_77994_a > 1 || p_94148_6_ != null) {
        String s1 = (p_94148_6_ == null) ? String.valueOf(p_94148_3_.field_77994_a) : p_94148_6_;
        GL11.glPushMatrix();
        GL11.glDisable(3042);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glTranslatef(0.0F, 0.0F, 1.0F);
        p_94148_1_.func_78261_a(s1, p_94148_4_ + 19 - 2 - p_94148_1_.func_78256_a(s1), p_94148_5_ + 6 + 3, 16777215);
        GL11.glDepthMask(true);
        GL11.glEnable(2896);
        GL11.glPopMatrix();
      } 
      if (p_94148_3_.func_77973_b().showDurabilityBar(p_94148_3_)) {
        double health = p_94148_3_.func_77973_b().getDurabilityForDisplay(p_94148_3_);
        int j1 = (int)Math.round(13.0D - health * 13.0D);
        int k = (int)Math.round(255.0D - health * 255.0D);
        GL11.glDisable(2896);
        GL11.glDisable(3553);
        GL11.glDisable(3008);
        GL11.glDisable(3042);
        Tessellator tessellator = Tessellator.field_78398_a;
        int l = 255 - k << 16 | k << 8;
        int i1 = (255 - k) / 4 << 16 | 0x3F00;
        GL11.glTranslatef(0.0F, 0.0F, 50.0F);
        renderQuad(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, 13, 2, 0);
        GL11.glTranslatef(0.0F, 0.0F, 50.0F);
        renderQuad(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, 12, 1, i1);
        GL11.glTranslatef(0.0F, 0.0F, 50.0F);
        renderQuad(tessellator, p_94148_4_ + 2, p_94148_5_ + 13, j1, 1, l);
        GL11.glEnable(3008);
        GL11.glEnable(3553);
        GL11.glEnable(2896);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      } 
    } 
  }
  
  private void renderQuad(Tessellator p_77017_1_, int p_77017_2_, int p_77017_3_, int p_77017_4_, int p_77017_5_, int p_77017_6_) {
    p_77017_1_.func_78382_b();
    p_77017_1_.func_78378_d(p_77017_6_);
    p_77017_1_.func_78377_a((p_77017_2_ + 0), (p_77017_3_ + 0), 0.0D);
    p_77017_1_.func_78377_a((p_77017_2_ + 0), (p_77017_3_ + p_77017_5_), 0.0D);
    p_77017_1_.func_78377_a((p_77017_2_ + p_77017_4_), (p_77017_3_ + p_77017_5_), 0.0D);
    p_77017_1_.func_78377_a((p_77017_2_ + p_77017_4_), (p_77017_3_ + 0), 0.0D);
    p_77017_1_.func_78381_a();
  }
}
