package alextm.handler;

import alextm.client.gui.GuiTrophyBox;
import alextm.client.gui.container.GuiContainerSkinWorkbench;
import alextm.client.gui.container.GuiContainerWorkbench;
import alextm.common.container.ContainerSkinWorkbench;
import alextm.common.container.ContainerWorkbench;
import alextm.common.tileentity.TileSkinWorkbench;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
  public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    switch (ID) {
      case 3:
        return new ContainerSkinWorkbench(player.field_71071_by, (TileSkinWorkbench)world.func_147438_o(x, y, z));
      case 4:
        return new ContainerWorkbench(player.field_71071_by, world, x, y, z);
    } 
    return null;
  }
  
  public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    switch (ID) {
      case 1:
        return new GuiTrophyBox();
      case 3:
        return new GuiContainerSkinWorkbench(player.field_71071_by, (TileSkinWorkbench)world.func_147438_o(x, y, z));
      case 4:
        return new GuiContainerWorkbench(player.field_71071_by, world, x, y, z);
    } 
    return null;
  }
}
