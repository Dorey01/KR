package alextm.common.items;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnderBag extends Item {
  public EnderBag(String name, String texture, int j) {
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    this.canRepair = false;
    this.field_77777_bU = j;
    GameRegistry.registerItem(this, name);
  }
  
  public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
    InventoryEnderChest inventoryenderchest = player.func_71005_bN();
    player.func_71007_a((IInventory)inventoryenderchest);
    player.func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
    return stack;
  }
}
