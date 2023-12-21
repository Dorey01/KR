package alextm.network;

import alextm.common.tileentity.TileSkinWorkbench;
import alextm.core.ModItems;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PacketSkinWorkbench implements IMessage {
  public int buttonID;
  
  public int x;
  
  public int y;
  
  public int z;
  
  public int skinID;
  
  public String name;
  
  public PacketSkinWorkbench() {}
  
  public PacketSkinWorkbench(int buttonID, int x, int y, int z, int skinID, String name) {
    this.buttonID = buttonID;
    this.x = x;
    this.y = y;
    this.z = z;
    this.skinID = skinID;
    this.name = name;
  }
  
  public void fromBytes(ByteBuf buf) {
    NBTTagCompound nbt = ByteBufUtils.readTag(buf);
    this.buttonID = nbt.func_74762_e("buttonID");
    this.x = nbt.func_74762_e("x");
    this.y = nbt.func_74762_e("y");
    this.z = nbt.func_74762_e("z");
    this.skinID = nbt.func_74762_e("skinID");
    this.name = nbt.func_74779_i("name");
  }
  
  public void toBytes(ByteBuf buf) {
    NBTTagCompound nbt = new NBTTagCompound();
    nbt.func_74768_a("buttonID", this.buttonID);
    nbt.func_74768_a("x", this.x);
    nbt.func_74768_a("y", this.y);
    nbt.func_74768_a("z", this.z);
    nbt.func_74768_a("skinID", this.skinID);
    nbt.func_74778_a("name", this.name);
    ByteBufUtils.writeTag(buf, nbt);
  }
  
  public static class Handler implements IMessageHandler<PacketSkinWorkbench, IMessage> {
    public IMessage onMessage(PacketSkinWorkbench message, MessageContext ctx) {
      if ((ctx.getServerHandler()).field_147369_b.field_70170_p.func_147438_o(message.x, message.y, message.z) instanceof TileSkinWorkbench) {
        TileSkinWorkbench tile = (TileSkinWorkbench)(ctx.getServerHandler()).field_147369_b.field_70170_p.func_147438_o(message.x, message.y, message.z);
        ModItems.AllSkins[0] = new ItemStack(ModItems.Meowmere);
        if (message.buttonID == 0) {
          ItemStack itemSlot0 = tile.func_70301_a(0);
          if (itemSlot0 != null) {
            int[] copyFrom = itemSlot0.func_77978_p().func_74759_k("allSkins");
            if (!checkArray(copyFrom, 0)) {
              ItemStack result = new ItemStack(ModItems.Meowmere);
              result.func_77982_d((NBTTagCompound)itemSlot0.func_77978_p().func_74737_b());
              if (openSkin(result, itemSlot0))
                tile.func_70299_a(0, result); 
            } 
          } 
        } else if (message.buttonID == 1) {
          ItemStack itemSlot0 = tile.func_70301_a(0);
          ItemStack result = tile.func_70301_a(1);
          if (itemSlot0 != null && result != null) {
            ItemStack result2 = new ItemStack(ModItems.Meowmere);
            result2.func_77982_d((NBTTagCompound)itemSlot0.func_77978_p().func_74737_b());
            if (openSkin(result2, result)) {
              tile.func_70299_a(0, result2);
              tile.func_70299_a(1, null);
            } 
          } 
        } else if (message.buttonID == 2) {
          ItemStack itemSlot0 = tile.func_70301_a(0);
          if (itemSlot0 != null) {
            ItemStack result = new ItemStack(ModItems.Meowmere);
            result.func_77982_d((NBTTagCompound)itemSlot0.func_77978_p().func_74737_b());
            setSkin(result, message.skinID);
            result.func_151001_c(message.name);
            tile.func_70299_a(0, result);
          } 
        } 
      } 
      return null;
    }
    
    public boolean checkArray(int[] array, int n) {
      for (int value : array) {
        if (value == n)
          return true; 
      } 
      return false;
    }
    
    public static void setSkin(ItemStack itemstack, int skinID) {
      if (!itemstack.func_77942_o())
        itemstack.func_77982_d(new NBTTagCompound()); 
      itemstack.func_77978_p().func_74768_a("Skin", skinID);
    }
    
    public static boolean openSkin(ItemStack itemstack, ItemStack skin) {
      if (!itemstack.func_77942_o())
        itemstack.func_77982_d(new NBTTagCompound()); 
      int[] copyFrom = itemstack.func_77978_p().func_74759_k("allSkins");
      int[] copyTo = new int[copyFrom.length + 1];
      int skinID;
      for (skinID = 0; skinID < copyFrom.length; skinID++)
        copyTo[skinID] = copyFrom[skinID]; 
      skinID = -1;
      for (int i = 0; i < ModItems.AllSkins.length; i++) {
        String str1 = ModItems.AllSkins[i].func_77977_a();
        String str2 = skin.func_77977_a();
        if (str1.equals(str2)) {
          skinID = i;
          break;
        } 
      } 
      boolean haveSkin = false;
      for (int value : copyFrom) {
        if (value == skinID) {
          haveSkin = true;
          break;
        } 
      } 
      if (!haveSkin) {
        copyTo[copyTo.length - 1] = skinID;
        itemstack.func_77978_p().func_74783_a("allSkins", copyTo);
        return true;
      } 
      return false;
    }
  }
}
