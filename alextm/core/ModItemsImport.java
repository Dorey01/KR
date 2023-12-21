package alextm.core;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItemsImport {
  public static Item QuantumHelm;
  
  public static Item QuantumChest;
  
  public static Item QuantumLegs;
  
  public static Item QuantumBoots;
  
  public static void importItems() {
    QuantumHelm = GameRegistry.findItem("IC2", "itemArmorQuantumHelmet");
    QuantumChest = GameRegistry.findItem("IC2", "itemArmorQuantumChestplate");
    QuantumLegs = GameRegistry.findItem("IC2", "itemArmorQuantumLegs");
    QuantumBoots = GameRegistry.findItem("IC2", "itemArmorQuantumBoots");
  }
  
  public static ItemStack getForgeItem(String forgeName) {
    if (forgeName.toLowerCase().equals("null"))
      return null; 
    String[] entryData = forgeName.split(":");
    if (entryData.length < 2) {
      System.out.println("Invalid filter entry %s");
    } else {
      Block block = GameRegistry.findBlock(entryData[0], entryData[1]);
      Item item = GameRegistry.findItem(entryData[0], entryData[1]);
      int meta = 0;
      if (entryData.length > 2)
        meta = entryData[2].equals("*") ? 32767 : Integer.parseInt(entryData[2]); 
      if (block != null)
        return new ItemStack(block, 1, meta); 
      if (item != null)
        return new ItemStack(item, 1, meta); 
    } 
    return new ItemStack(Blocks.field_150357_h, 1);
  }
}
