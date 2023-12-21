package alextm.common.commands;

import alextm.ModConfig;
import alextm.SkyHard;
import alextm.common.items.CraftingManager;
import alextm.network.NetworkHandler;
import alextm.network.UpdateConfig;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class CommandHandler extends CommandBase {
  public String func_71517_b() {
    return "stmind";
  }
  
  public String func_71518_a(ICommandSender commandSender) {
    return "/stmind";
  }
  
  public void func_71515_b(ICommandSender commandSender, String[] args) {
    EntityPlayerMP player = func_71521_c(commandSender);
    if (args.length == 1 && args[0].toLowerCase().equals("reload")) {
      Side var10000 = FMLCommonHandler.instance().getSide();
      FMLCommonHandler.instance().getSide();
      if (var10000 != Side.SERVER)
        return; 
      ModConfig.registerConfig(SkyHard.ConfigDirectory, player);
      CraftingManager.registerSunRecipes(SkyHard.ConfigDirectory, player);
      List players = (MinecraftServer.func_71276_C().func_71203_ab()).field_72404_b;
      for (Object o : players)
        NetworkHandler.network.sendTo(new UpdateConfig(CraftingManager.WorkbenchCrafts), (EntityPlayerMP)o); 
    } else if (args.length == 1 && args[0].toLowerCase().equals("help")) {
      player.func_145747_a((IChatComponent)new ChatComponentText(SkyHard.resource("stming.chat.prefix") + "пїЅb/stmind reload пїЅa- Перезагрузка конфигов."));
    } else {
      player.func_145747_a((IChatComponent)new ChatComponentText(SkyHard.resource("stming.chat.prefix") + "пїЅaНеверная команда. Помощь: пїЅb/stmind help"));
    } 
  }
  
  public boolean func_71519_b(ICommandSender commandSender) {
    return true;
  }
}
