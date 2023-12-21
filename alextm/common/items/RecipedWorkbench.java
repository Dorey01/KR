package alextm.common.items;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class RecipedWorkbench implements IRecipe {
  public int recipeWidth;
  
  public int recipeHeight;
  
  public final ItemStack[] recipeItems;
  
  private ItemStack recipeOutput;
  
  private boolean field_92101_f;
  
  public RecipedWorkbench(int w, int h, ItemStack[] stacks, ItemStack result) {
    this.recipeWidth = w;
    this.recipeHeight = h;
    this.recipeItems = stacks;
    this.recipeOutput = result;
  }
  
  public ItemStack func_77571_b() {
    return this.recipeOutput;
  }
  
  public boolean func_77569_a(InventoryCrafting inv, World world) {
    for (int i = 0; i < this.recipeItems.length; i++) {
      ItemStack itemstack1 = this.recipeItems[i];
      ItemStack itemstack2 = inv.func_70301_a(i);
      if (itemstack1 != null || itemstack2 != null) {
        if (itemstack1 == null || itemstack2 == null)
          return false; 
        if (!itemstack1.func_77973_b().equals(itemstack2.func_77973_b()))
          return false; 
        if (itemstack1.func_77960_j() != 32767 && itemstack1.func_77960_j() != itemstack2.func_77960_j())
          return false; 
      } 
    } 
    return true;
  }
  
  public ItemStack func_77572_b(InventoryCrafting inv) {
    ItemStack itemstack = func_77571_b().func_77946_l();
    if (this.field_92101_f)
      for (int i = 0; i < inv.func_70302_i_(); i++) {
        ItemStack itemstack2 = inv.func_70301_a(i);
        if (itemstack2 != null && itemstack2.func_77942_o())
          itemstack.func_77982_d((NBTTagCompound)itemstack2.field_77990_d.func_74737_b()); 
      }  
    return itemstack;
  }
  
  public int func_77570_a() {
    return this.recipeItems.length;
  }
  
  public RecipedWorkbench func_92100_c() {
    this.field_92101_f = true;
    return this;
  }
}
