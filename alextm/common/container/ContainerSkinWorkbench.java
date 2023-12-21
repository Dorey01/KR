package alextm.common.container;

import alextm.common.tileentity.TileSkinWorkbench;
import alextm.core.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSkinWorkbench extends Container {
  private final TileSkinWorkbench tile;
  
  public ContainerSkinWorkbench(InventoryPlayer inv, TileSkinWorkbench tile) {
    this.tile = tile;
    func_75146_a(new SkyHardSlots(tile, 0, 8, 5, 1));
    func_75146_a(new SkyHardSlots(tile, 1, 8, 27, 1));
    int i;
    for (i = 0; i < 3; i++) {
      for (int j = 0; j < 9; j++)
        func_75146_a(new Slot((IInventory)inv, j + i * 9 + 9, 8 + j * 18, 87 + i * 18)); 
    } 
    for (i = 0; i < 9; i++)
      func_75146_a(new Slot((IInventory)inv, i, 8 + i * 18, 145)); 
  }
  
  public ItemStack func_82846_b(EntityPlayer player, int slotID) {
    return null;
  }
  
  public boolean func_75145_c(EntityPlayer player) {
    return this.tile.func_70300_a(player);
  }
  
  private static class SkyHardSlots extends Slot {
    private int limit;
    
    private int index;
    
    public SkyHardSlots(IInventory inventory, int index, int posX, int posY, int limit) {
      super(inventory, index, posX, posY);
      this.limit = limit;
      this.index = index;
    }
    
    public boolean func_75214_a(ItemStack stack) {
      if (this.index == 0)
        return (stack != null && stack.func_77973_b() != null && stack.func_77973_b() == ModItems.Meowmere); 
      return (this.index != 1 || (stack != null && stack.func_77973_b() != null && isSkinItem(stack)));
    }
    
    public int func_75219_a() {
      return this.limit;
    }
    
    protected boolean isSkinItem(ItemStack stack) {
      for (int i = 0; i < ModItems.AllSkins.length; i++) {
        String str1;
        if (i == 0) {
          str1 = ModItems.Meowmere.func_77658_a();
        } else {
          str1 = ModItems.AllSkins[i].func_77977_a();
        } 
        String str2 = stack.func_77977_a();
        if (str1.equals(str2))
          return true; 
      } 
      return false;
    }
  }
}
