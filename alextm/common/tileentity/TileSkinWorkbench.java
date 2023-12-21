package alextm.common.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileSkinWorkbench extends TileEntity implements IInventory {
  public ItemStack[] inventory = new ItemStack[3];
  
  private String SkinWorkbenchName = "SkinWorkbench";
  
  public Packet func_145844_m() {
    NBTTagCompound compound = new NBTTagCompound();
    func_145841_b(compound);
    return (Packet)new S35PacketUpdateTileEntity(this.field_145851_c, this.field_145848_d, this.field_145849_e, this.field_145847_g, compound);
  }
  
  @SideOnly(Side.CLIENT)
  public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
    super.onDataPacket(net, pkt);
    func_145839_a(pkt.func_148857_g());
  }
  
  public int func_70302_i_() {
    return this.inventory.length;
  }
  
  public ItemStack func_70301_a(int slot) {
    return this.inventory[slot];
  }
  
  public ItemStack func_70298_a(int slot, int count) {
    if (this.inventory[slot] != null) {
      ItemStack stack;
      if ((this.inventory[slot]).field_77994_a <= count) {
        stack = this.inventory[slot];
        this.inventory[slot] = null;
      } else {
        stack = this.inventory[slot].func_77979_a(count);
        if ((this.inventory[slot]).field_77994_a == 0)
          this.inventory[slot] = null; 
      } 
      func_70296_d();
      return stack;
    } 
    return null;
  }
  
  public ItemStack func_70304_b(int slot) {
    if (this.inventory[slot] != null) {
      ItemStack itemstack = this.inventory[slot];
      this.inventory[slot] = null;
      return itemstack;
    } 
    return null;
  }
  
  public void func_70299_a(int slot, ItemStack stack) {
    this.inventory[slot] = stack;
    if (stack != null && stack.field_77994_a > func_70297_j_())
      stack.field_77994_a = func_70297_j_(); 
    func_70296_d();
  }
  
  public String func_145825_b() {
    return null;
  }
  
  public boolean func_145818_k_() {
    return false;
  }
  
  public void func_145839_a(NBTTagCompound compound) {
    super.func_145839_a(compound);
    NBTTagList tagList = compound.func_150295_c("Items", 10);
    this.inventory = new ItemStack[func_70302_i_()];
    for (int i = 0; i < tagList.func_74745_c(); i++) {
      NBTTagCompound slot = tagList.func_150305_b(i);
      int pos = slot.func_74771_c("Slot");
      if (pos < this.inventory.length)
        this.inventory[pos] = ItemStack.func_77949_a(slot); 
    } 
  }
  
  public void func_145841_b(NBTTagCompound compound) {
    super.func_145841_b(compound);
    NBTTagList nbttaglist = new NBTTagList();
    for (int i = 0; i < this.inventory.length; i++) {
      if (this.inventory[i] != null) {
        NBTTagCompound slot = new NBTTagCompound();
        slot.func_74774_a("Slot", (byte)i);
        this.inventory[i].func_77955_b(slot);
        nbttaglist.func_74742_a((NBTBase)slot);
      } 
    } 
    compound.func_74782_a("Items", (NBTBase)nbttaglist);
  }
  
  public int func_70297_j_() {
    return 1;
  }
  
  public boolean func_70300_a(EntityPlayer player) {
    return (this.field_145850_b.func_147438_o(this.field_145851_c, this.field_145848_d, this.field_145849_e) == this);
  }
  
  public void func_70295_k_() {}
  
  public void func_70305_f() {}
  
  public boolean func_94041_b(int index, ItemStack stack) {
    return false;
  }
  
  public boolean canUpdate() {
    return true;
  }
}
