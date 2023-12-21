package alextm.common.commands;

import alextm.SkyHard;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class CommandGetSerial extends CommandBase {
  public String func_71517_b() {
    return "stmindinfo";
  }
  
  public String func_71518_a(ICommandSender commandSender) {
    return "/stmindinfo";
  }
  
  public void func_71515_b(ICommandSender commandSender, String[] args) {
    EntityPlayerMP player = func_71521_c(commandSender);
    if (args.length == 1) {
      EntityPlayerMP targetPlayer = func_82359_c(commandSender, args[0]);
      if (targetPlayer == null) {
        player.func_145747_a((IChatComponent)new ChatComponentText(SkyHard.resource("stmind.chat.prefix") + "Player not found."));
        return;
      } 
      player.func_145747_a((IChatComponent)new ChatComponentText(SkyHard.resource("stmind.chat.prefix") + "Ok."));
    } else {
      player.func_145747_a((IChatComponent)new ChatComponentText(SkyHard.resource("stmind.chat.prefix") + "Args not one."));
    } 
  }
  
  public boolean func_71519_b(ICommandSender commandSender) {
    return true;
  }
}
