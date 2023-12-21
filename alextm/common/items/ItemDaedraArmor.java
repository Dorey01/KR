package alextm.common.items;

import alextm.SkyHard;
import alextm.client.ArmorRenderDaedra;
import alextm.client.ArmorRenderObjBase;
import alextm.core.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;

public class ItemDaedraArmor extends ItemArmor {
  public ItemDaedraArmor(String name, String textureName, ItemArmor.ArmorMaterial armorMaterial, int partArmor) {
    super(armorMaterial, 0, partArmor);
    func_77655_b(name);
    func_111206_d(textureName);
    func_77637_a(SkyHard.SkyHard);
    GameRegistry.registerItem((Item)this, name);
  }
  
  public void func_94581_a(IIconRegister p_94581_1_) {
    super.func_94581_a(p_94581_1_);
    MinecraftForgeClient.registerItemRenderer((Item)this, renderer);
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack is, int armorSlot) {
    ModelBiped armorModel = new ArmorRenderDaedra(armorSlot);
    if (is.func_77973_b() instanceof ItemDaedraArmor) {
      armorModel = fillingArmorModel(armorModel, entityLiving);
      if (func_82816_b_(is) && armorModel instanceof ArmorRenderObjBase)
        ((ArmorRenderObjBase)armorModel).color = func_82814_b(is); 
    } 
    return armorModel;
  }
  
  public static ModelBiped fillingArmorModel(ModelBiped model, EntityLivingBase entityLiving) {
    if (model != null) {
      ModelRenderer bipedHead = model.field_78116_c;
      ModelRenderer bipedHeadwear = model.field_78114_d;
      ModelRenderer bipedBody = model.field_78115_e;
      ModelRenderer bipedRightArm = model.field_78112_f;
      ModelRenderer bipedLeftArm = model.field_78113_g;
      ModelRenderer bipedRightLeg = model.field_78123_h;
      ModelRenderer bipedLeftLeg = model.field_78124_i;
      boolean showModel = false;
      bipedLeftLeg.field_78806_j = false;
      bipedRightLeg.field_78806_j = false;
      bipedLeftArm.field_78806_j = false;
      bipedRightArm.field_78806_j = false;
      bipedBody.field_78806_j = false;
      bipedHeadwear.field_78806_j = false;
      bipedHead.field_78806_j = false;
      model.field_78117_n = entityLiving.func_70093_af();
      model.field_78093_q = entityLiving.func_70115_ae();
      model.field_78091_s = entityLiving.func_70631_g_();
      ItemStack held_item = entityLiving.func_71124_b(0);
      if (held_item != null) {
        model.field_78120_m = 1;
        if (entityLiving instanceof EntityPlayer) {
          EntityPlayer player = (EntityPlayer)entityLiving;
          if (player.func_71052_bv() > 0) {
            EnumAction enumaction = held_item.func_77975_n();
            if (enumaction == EnumAction.bow) {
              model.field_78118_o = true;
            } else if (enumaction == EnumAction.block) {
              model.field_78120_m = 3;
            } 
          } 
        } 
      } else {
        model.field_78120_m = 0;
      } 
      if (entityLiving instanceof EntitySkeleton)
        model.field_78118_o = (((EntitySkeleton)entityLiving).func_82202_m() == 1); 
    } 
    return model;
  }
  
  static IItemRenderer renderer = new IItemRenderer() {
      public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return true;
      }
      
      public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return true;
      }
      
      public void renderItem(IItemRenderer.ItemRenderType type, ItemStack stack, Object... data) {
        Item item = stack.func_77973_b();
        GL11.glPushMatrix();
        (Minecraft.func_71410_x()).field_71446_o.func_110577_a(ArmorRenderDaedra.texture);
        switch (type) {
          case ENTITY:
            if (item == ModItems.DaedraHead) {
              GL11.glTranslatef(0.0F, 0.8F, 0.0F);
              GL11.glScalef(0.9F, 0.9F, 0.9F);
            } else if (item == ModItems.DaedraChest) {
              GL11.glScalef(0.09F, 0.09F, 0.09F);
            } else if (item == ModItems.DaedraStanci) {
              GL11.glTranslatef(0.0F, 1.0F, 0.0F);
            } else if (item == ModItems.DaedraBoots) {
              GL11.glTranslatef(0.0F, 1.5F, 0.0F);
            } 
            GL11.glTranslatef(0.15F, -1.5F, 0.0F);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            break;
          case INVENTORY:
            if (item == ModItems.DaedraHead) {
              GL11.glTranslatef(0.15F, -3.0F, 0.0F);
              GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
              GL11.glRotatef(75.0F, 0.0F, 1.0F, 0.0F);
            } else if (item == ModItems.DaedraChest) {
              GL11.glTranslatef(0.275F, -0.8F, 0.0F);
              GL11.glRotatef(18.0F, 0.0F, 0.0F, 1.0F);
              GL11.glRotatef(75.0F, 0.0F, 1.0F, 0.0F);
              GL11.glScalef(0.09F, 0.09F, 0.09F);
            } else if (item == ModItems.DaedraStanci) {
              GL11.glTranslatef(0.26F, -0.7F, 0.0F);
              GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
              GL11.glRotatef(-75.0F, 0.0F, 1.0F, 0.0F);
            } else if (item == ModItems.DaedraBoots) {
              GL11.glTranslatef(-0.8F, -0.7F, 0.0F);
            } 
            GL11.glScalef(0.9F, 0.9F, 0.9F);
            break;
          case EQUIPPED_FIRST_PERSON:
          case EQUIPPED:
            if (item == ModItems.DaedraHead) {
              GL11.glTranslatef(0.0F, -1.0F, -0.1F);
              GL11.glRotatef(-6.0F, 0.0F, 0.0F, 1.0F);
              GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
              GL11.glScalef(0.75F, 0.75F, 0.75F);
              break;
            } 
            if (item == ModItems.DaedraChest) {
              GL11.glTranslatef(0.5F, 0.1F, 0.5F);
              GL11.glRotatef(-89.0F, 0.0F, 1.0F, 0.0F);
              GL11.glScalef(0.075F, 0.075F, 0.075F);
              break;
            } 
            if (item == ModItems.DaedraStanci) {
              GL11.glTranslatef(0.5F, -0.3F, 0.0F);
              GL11.glRotatef(15.0F, 0.0F, 0.0F, 1.0F);
              GL11.glRotatef(-75.0F, 0.0F, 1.0F, 0.0F);
              break;
            } 
            if (item == ModItems.DaedraBoots) {
              GL11.glTranslatef(0.0F, 0.25F, 0.05F);
              GL11.glRotatef(-89.0F, 0.0F, 1.0F, 0.0F);
            } 
            break;
        } 
        if (item == ModItems.DaedraHead) {
          ArmorRenderDaedra.head.renderAll();
        } else if (item == ModItems.DaedraChest) {
          ArmorRenderDaedra.chest.renderAll();
        } else if (item == ModItems.DaedraStanci) {
          ArmorRenderDaedra.stanciLeft.renderAll();
          ArmorRenderDaedra.stanciRight.renderAll();
        } else if (item == ModItems.DaedraBoots) {
          ArmorRenderDaedra.bootsLeft.renderAll();
          ArmorRenderDaedra.bootsRight.renderAll();
        } 
        GL11.glPopMatrix();
      }
    };
}
