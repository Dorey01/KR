package alextm.network;

import alextm.common.items.CraftingManager;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class UpdateConfig implements IMessage {
  private String[] MirrorCrafts;
  
  public UpdateConfig() {}
  
  public UpdateConfig(String[] MirrorCrafts) {
    this.MirrorCrafts = MirrorCrafts;
  }
  
  public void fromBytes(ByteBuf buf) {
    try {
      int count = buf.readInt();
      this.MirrorCrafts = new String[count];
      for (int i = 0; i < count; i++)
        this.MirrorCrafts[i] = ByteBufUtils.readUTF8String(buf); 
    } catch (IndexOutOfBoundsException var4) {
      System.out.println(var4);
    } 
  }
  
  public void toBytes(ByteBuf buf) {
    buf.writeInt(this.MirrorCrafts.length);
    for (String mirrorCraft : this.MirrorCrafts)
      ByteBufUtils.writeUTF8String(buf, mirrorCraft); 
  }
  
  public static class Handler implements IMessageHandler<UpdateConfig, IMessage> {
    public IMessage onMessage(UpdateConfig message, MessageContext ctx) {
      if (message != null)
        CraftingManager.setDefault(message.MirrorCrafts); 
      return null;
    }
  }
}
