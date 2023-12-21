package alextm.handler;

import alextm.common.items.CraftingManager;
import alextm.network.NetworkHandler;
import alextm.network.UpdateConfig;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class EventHandlerConfig {
  @SubscribeEvent
  public void playerLoginEvent(PlayerEvent.PlayerLoggedInEvent event) {
    EntityPlayer player = event.player;
    World world = player.field_70170_p;
    if (!world.field_72995_K) {
      Side var10000 = FMLCommonHandler.instance().getSide();
      FMLCommonHandler.instance().getSide();
      if (var10000 == Side.SERVER)
        NetworkHandler.network.sendTo(new UpdateConfig(CraftingManager.WorkbenchCrafts), (EntityPlayerMP)player); 
    } 
  }
}
