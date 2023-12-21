package alextm.utils;

import alextm.SkyHard;
import lain.mods.cos.CosmeticArmorReworked;
import lain.mods.cos.inventory.InventoryCosArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CosmeticArmorUtils {
  public static boolean isWear(EntityPlayer player, Item head, Item body, Item legs, Item foots) {
    ItemStack hat = player.func_71124_b(4);
    ItemStack chest = player.func_71124_b(3);
    ItemStack leggings = player.func_71124_b(2);
    ItemStack boots = player.func_71124_b(1);
    return (((head == null || (hat != null && hat.func_77973_b().equals(head))) && (body == null || (chest != null && chest.func_77973_b().equals(body))) && (legs == null || (leggings != null && leggings.func_77973_b().equals(legs))) && (foots == null || (boots != null && boots.func_77973_b().equals(foots)))) || (SkyHard.CosmeticArmor && checkCosmetic(player, head, body, legs, foots)));
  }
  
  private static boolean checkCosmetic(EntityPlayer player, Item head, Item body, Item legs, Item foots) {
    if (player.func_110124_au() == null)
      return false; 
    InventoryCosArmor inv = CosmeticArmorReworked.invMan.getCosArmorInventoryClient(player.func_110124_au());
    if (inv != null) {
      ItemStack[] cosmeticSlots = inv.getInventory();
      ItemStack hat = cosmeticSlots[3];
      ItemStack chest = cosmeticSlots[2];
      ItemStack leggings = cosmeticSlots[1];
      ItemStack boots = cosmeticSlots[0];
      if ((head == null || (hat != null && hat.func_77973_b().equals(head))) && (body == null || (chest != null && chest.func_77973_b().equals(body))) && (legs == null || (leggings != null && leggings.func_77973_b().equals(legs))) && (foots == null || (boots != null && boots.func_77973_b().equals(foots))))
        return true; 
    } 
    return false;
  }
}
