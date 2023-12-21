package alextm.core;

import alextm.common.tileentity.TileEntityPicFrame;
import alextm.common.tileentity.TileSkinWorkbench;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntity {
  public static void registerTileEntity() {
    GameRegistry.registerTileEntity(TileEntityPicFrame.class, "TileEntityOPFrame");
    GameRegistry.registerTileEntity(TileSkinWorkbench.class, "TileSkinWorkbench");
  }
}
