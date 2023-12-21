package alextm.common.container;

import alextm.common.items.CraftingManager;
import alextm.core.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerWorkbench extends Container {
  private int recipeWidth;
  
  private int recipeHeight;
  
  public InventoryCrafting craftMatrix;
  
  public IInventory craftResult;
  
  private World worldObj;
  
  private int posX;
  
  private int posY;
  
  private int posZ;
  
  public ContainerWorkbench(InventoryPlayer inv, World world, int x, int y, int z) {
    this.recipeWidth = 5;
    this.recipeHeight = 5;
    this.craftMatrix = new InventoryCrafting(this, this.recipeWidth, this.recipeHeight);
    this.craftResult = (IInventory)new InventoryCraftResult();
    this.worldObj = world;
    this.posX = x;
    this.posY = y;
    this.posZ = z;
    func_75146_a((Slot)new SlotCrafting(inv.field_70458_d, (IInventory)this.craftMatrix, this.craftResult, 0, 140, 45));
    int l;
    for (l = 0; l < this.recipeHeight; l++) {
      for (int i1 = 0; i1 < this.recipeWidth; i1++)
        func_75146_a(new Slot((IInventory)this.craftMatrix, i1 + l * 5, 8 + i1 * 18, 8 + l * 18)); 
    } 
    for (l = 0; l < 3; l++) {
      for (int i1 = 0; i1 < 9; i1++)
        func_75146_a(new Slot((IInventory)inv, i1 + l * 9 + 9, 8 + i1 * 18, 102 + l * 18)); 
    } 
    for (l = 0; l < 9; l++)
      func_75146_a(new Slot((IInventory)inv, l, 8 + l * 18, 160)); 
    func_75130_a((IInventory)this.craftMatrix);
  }
  
  public void func_75130_a(IInventory inv) {
    this.craftResult.func_70299_a(0, CraftingManager.findMatchingRecipe(this.craftMatrix, this.worldObj));
  }
  
  public void func_75134_a(EntityPlayer player) {
    super.func_75134_a(player);
    if (!this.worldObj.field_72995_K)
      for (int i = 0; i < this.recipeWidth * this.recipeHeight; i++) {
        ItemStack itemstack = this.craftMatrix.func_70304_b(i);
        if (itemstack != null)
          player.func_71019_a(itemstack, false); 
      }  
  }
  
  public boolean func_75145_c(EntityPlayer player) {
    return (this.worldObj.func_147439_a(this.posX, this.posY, this.posZ) == ModBlocks.Workbench && player.func_70092_e(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D) <= 64.0D);
  }
  
  public ItemStack func_82846_b(EntityPlayer player, int slotID) {
    ItemStack itemstack = null;
    Slot slot = this.field_75151_b.get(slotID);
    if (slot != null && slot.func_75216_d()) {
      ItemStack itemstack2 = slot.func_75211_c();
      itemstack = itemstack2.func_77946_l();
      if (slotID == 0) {
        if (!func_75135_a(itemstack2, 21, 57, true))
          return null; 
        slot.func_75220_a(itemstack2, itemstack);
      } else if (slotID >= 26 && slotID < 53) {
        if (!func_75135_a(itemstack2, 53, 62, false))
          return null; 
      } else if (slotID >= 53 && slotID < 62) {
        if (!func_75135_a(itemstack2, 26, 53, false))
          return null; 
      } else if (!func_75135_a(itemstack2, 26, 62, false)) {
        return null;
      } 
      if (itemstack2.field_77994_a == 0) {
        slot.func_75215_d((ItemStack)null);
      } else {
        slot.func_75218_e();
      } 
      if (itemstack2.field_77994_a == itemstack.field_77994_a)
        return null; 
      slot.func_82870_a(player, itemstack2);
    } 
    return itemstack;
  }
  
  public boolean func_94530_a(ItemStack stack, Slot slotID) {
    return (slotID.field_75224_c != this.craftResult && super.func_94530_a(stack, slotID));
  }
}
