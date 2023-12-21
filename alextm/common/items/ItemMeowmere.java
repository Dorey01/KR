package alextm.common.items;

import alextm.SkyHard;
import alextm.api.Meowmere_prog;
import alextm.core.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemMeowmere extends ItemSword {
  public ItemMeowmere(String name, String texture) {
    super(Item.ToolMaterial.EMERALD);
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    GameRegistry.registerItem((Item)this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_77624_a(ItemStack itemStack, EntityPlayer player, List<String> list, boolean isAdv) {
    list.add(SkyHard.resource("item_meowmere.tooltip_1"));
    list.add(SkyHard.resource("item_meowmere.tooltip_2"));
  }
  
  public ItemStack func_77659_a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
    if (!par3EntityPlayer.field_82175_bq) {
      par2World.func_72956_a((Entity)par3EntityPlayer, "mob.cat.meow", 0.5F, 1.0F / (Item.field_77697_d.nextFloat() * 0.4F + 0.8F));
      par3EntityPlayer.func_71038_i();
      if (par1ItemStack.func_96631_a(1, par3EntityPlayer.func_70681_au())) {
        par1ItemStack.field_77994_a--;
        if (par1ItemStack.field_77994_a < 1)
          par1ItemStack.field_77994_a = 0; 
        par1ItemStack.func_77964_b(0);
        par2World.func_72956_a((Entity)par3EntityPlayer, "random.break", 0.5F, 0.4F / (Item.field_77697_d.nextFloat() * 0.4F + 0.8F));
      } 
      par1ItemStack.func_77972_a(5, (EntityLivingBase)par3EntityPlayer);
      par2World.func_72838_d((Entity)new Meowmere_prog(par2World, (EntityLivingBase)par3EntityPlayer));
    } 
    return par1ItemStack;
  }
  
  public boolean func_82789_a(ItemStack toRepairItem, ItemStack repairItem) {
    return (repairItem.func_77973_b() == ModItems.Rainbow);
  }
}
