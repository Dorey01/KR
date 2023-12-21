package alextm.common.items;

import alextm.SkyHard;
import alextm.client.model.ModelVoxelArmor;
import alextm.core.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemVoxelArmor extends ItemArmor {
  @SideOnly(Side.CLIENT)
  private IIcon helmIcon;
  
  @SideOnly(Side.CLIENT)
  private IIcon chestIcon;
  
  @SideOnly(Side.CLIENT)
  private IIcon leggsIcon;
  
  @SideOnly(Side.CLIENT)
  private IIcon bootsIcon;
  
  @SideOnly(Side.CLIENT)
  public ModelBiped model;
  
  private String tag;
  
  private int size;
  
  private int tooltips;
  
  public ItemVoxelArmor(ItemArmor.ArmorMaterial material, int armorType, String name, String tag, int size, int tooltips) {
    super(material, 0, armorType);
    func_77655_b(name);
    func_77637_a(SkyHard.SkyHard);
    GameRegistry.registerItem((Item)this, name);
    this.tag = tag;
    this.size = size;
    this.tooltips = tooltips;
  }
  
  @SideOnly(Side.CLIENT)
  public void func_77624_a(ItemStack itemStack, EntityPlayer player, List<String> list, boolean isAdv) {
    for (int i = 1; i <= this.tooltips; i++)
      list.add(SkyHard.resource("armor.tooltip." + this.tag + "_" + i)); 
  }
  
  @SideOnly(Side.CLIENT)
  public void func_94581_a(IIconRegister iconRegister) {
    this.chestIcon = iconRegister.func_94245_a("alextm:draconic_chestplate");
    this.leggsIcon = iconRegister.func_94245_a("alextm:draconic_leggings");
    this.bootsIcon = iconRegister.func_94245_a("alextm:draconic_boots");
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
    return (stack.func_77973_b() == ModItems.Tron_head_yellow) ? this.helmIcon : this.bootsIcon;
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_77650_f(ItemStack stack) {
    return (stack.func_77973_b() == ModItems.Tron_head_yellow) ? this.helmIcon : this.bootsIcon;
  }
  
  @SideOnly(Side.CLIENT)
  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
    return "alextm:model/armor/tron_yellow_x2/tronSkin.png";
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
    if (this.model == null) {
      this.model = new ModelVoxelArmor(1.1F, this.field_77881_a, this.tag, this.size);
      this.model.field_78116_c.field_78806_j = (this.field_77881_a == 0);
      this.model.field_78114_d.field_78806_j = (this.field_77881_a == 0);
      this.model.field_78115_e.field_78806_j = (this.field_77881_a == 1 || this.field_77881_a == 2);
      this.model.field_78113_g.field_78806_j = (this.field_77881_a == 1);
      this.model.field_78112_f.field_78806_j = (this.field_77881_a == 1);
      this.model.field_78124_i.field_78806_j = (this.field_77881_a == 2 || this.field_77881_a == 3);
      this.model.field_78123_h.field_78806_j = (this.field_77881_a == 2 || this.field_77881_a == 3);
    } 
    if (entityLiving == null)
      return this.model; 
    this.model.field_78117_n = entityLiving.func_70093_af();
    this.model.field_78093_q = entityLiving.func_70115_ae();
    this.model.field_78091_s = entityLiving.func_70631_g_();
    this.model.field_78118_o = false;
    this.model.field_78120_m = (entityLiving.func_70694_bm() != null) ? 1 : 0;
    if (entityLiving instanceof EntityPlayer && ((EntityPlayer)entityLiving).func_71057_bx() > 0) {
      EnumAction enumaction = ((EntityPlayer)entityLiving).func_71011_bu().func_77975_n();
      if (enumaction == EnumAction.block) {
        this.model.field_78120_m = 3;
      } else if (enumaction == EnumAction.bow) {
        this.model.field_78118_o = true;
      } 
    } 
    return this.model;
  }
}
