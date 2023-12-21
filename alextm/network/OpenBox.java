package alextm.network;

import alextm.common.items.ItemBox;
import alextm.common.items.ItemCase;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class OpenBox implements IMessage {
  private ItemStack box;
  
  public OpenBox() {}
  
  public OpenBox(ItemCase box) {
    this.box = new ItemStack(box);
  }
  
  public void fromBytes(ByteBuf buf) {
    try {
      this.box = ByteBufUtils.readItemStack(buf);
    } catch (IndexOutOfBoundsException var3) {
      System.out.println(var3);
    } 
  }
  
  public void toBytes(ByteBuf buf) {
    ByteBufUtils.writeItemStack(buf, this.box);
  }
  
  public static class Handler implements IMessageHandler<OpenBox, IMessage> {
    public IMessage onMessage(OpenBox message, MessageContext ctx) {
      EntityPlayerMP player = (ctx.getServerHandler()).field_147369_b;
      if (message.box != null && player.field_71071_by.func_70448_g() != null && player.field_71071_by.func_70448_g().func_77973_b().equals(message.box.func_77973_b())) {
        ItemCase Case = (ItemCase)message.box.func_77973_b();
        if (!Case.isGiveAll()) {
          Random rand = new Random();
          int numb = rand.nextInt(Case.getSize());
          ItemBox itemBox = Case.getCurrentItem(numb);
          ItemStack itemStack = itemBox.getItemStack();
          itemStack.field_77994_a = 1;
          player.func_70062_b(0, itemStack);
          NetworkHandler.network.sendTo(new OpenTrophyGuiOnClient(message.box, numb), player);
        } else {
          for (int i = 0; i < Case.getSize(); i++) {
            ItemStack itemStack2 = Case.getCurrentItem(i).getItemStack();
            itemStack2.field_77994_a = 1;
            if (i == 0) {
              player.func_70062_b(0, Case.getCurrentItem(0).getItemStack());
            } else if (player.field_71071_by.func_70447_i() == -1) {
              player.field_70170_p.func_72838_d((Entity)new EntityItem(player.field_70170_p, player.field_70165_t, player.field_70163_u, player.field_70161_v, itemStack2));
            } else {
              player.field_71071_by.func_70441_a(itemStack2);
            } 
            NetworkHandler.network.sendTo(new OpenTrophyGuiOnClient(message.box, -1), player);
          } 
        } 
      } 
      return null;
    }
  }
}
