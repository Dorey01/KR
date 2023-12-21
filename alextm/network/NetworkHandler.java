package alextm.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkHandler {
  public static SimpleNetworkWrapper network;
  
  private static int nextID() {
    return ID++;
  }
  
  public static void init(String channelName) {
    (network = NetworkRegistry.INSTANCE.newSimpleChannel(channelName)).registerMessage(OpenBox.Handler.class, OpenBox.class, nextID(), Side.SERVER);
    network.registerMessage(OpenTrophyGuiOnClient.Handler.class, OpenTrophyGuiOnClient.class, nextID(), Side.CLIENT);
    network.registerMessage(UpdateConfig.Handler.class, UpdateConfig.class, nextID(), Side.CLIENT);
    network.registerMessage(PacketSkinWorkbench.Handler.class, PacketSkinWorkbench.class, nextID(), Side.SERVER);
  }
  
  private static int ID = 0;
}
