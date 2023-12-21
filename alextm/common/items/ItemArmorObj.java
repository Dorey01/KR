package alextm.common.items;

import alextm.SkyHard;
import alextm.client.ArmorRenderDaedra;
import alextm.client.ArmorRenderObjBase;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemArmorObj extends ItemArmor {
  public ItemArmorObj(String name, String textureName, ItemArmor.ArmorMaterial armorMaterial, int partArmor) {
    super(armorMaterial, 0, partArmor);
    func_77655_b(name);
    func_111206_d(textureName);
    func_77637_a(SkyHard.SkyHard);
    GameRegistry.registerItem((Item)this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack is, int armorSlot) {
    ModelBiped armorModel = new ArmorRenderDaedra(armorSlot);
    if (is.func_77973_b() instanceof ItemArmorObj) {
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
}
