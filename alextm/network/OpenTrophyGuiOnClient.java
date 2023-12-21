package alextm.network;

import alextm.SkyHard;
import alextm.client.gui.GuiTrophyBox;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.ItemStack;

public class OpenTrophyGuiOnClient implements IMessage {
  private ItemStack stack;
  
  private int index;
  
  public OpenTrophyGuiOnClient() {}
  
  public OpenTrophyGuiOnClient(ItemStack stack, int index) {
    this.stack = stack;
    this.index = index;
  }
  
  public void fromBytes(ByteBuf buf) {
    try {
      this.stack = ByteBufUtils.readItemStack(buf);
      this.index = buf.readInt();
    } catch (IndexOutOfBoundsException var3) {
      System.out.println(var3);
    } 
  }
  
  public void toBytes(ByteBuf buf) {
    ByteBufUtils.writeItemStack(buf, this.stack);
    buf.writeInt(this.index);
  }
  
  public static class Handler implements IMessageHandler<OpenTrophyGuiOnClient, IMessage> {
    public IMessage onMessage(OpenTrophyGuiOnClient message, MessageContext ctx) {
      EntityClientPlayerMP player = (Minecraft.func_71410_x()).field_71439_g;
      if (message != null) {
        GuiTrophyBox.stack = message.stack;
        GuiTrophyBox.index = message.index;
        player.openGui(SkyHard.instance, 1, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
      } 
      return null;
    }
  }
}
