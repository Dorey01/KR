package alextm.common.items;

import alextm.SkyHard;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ThaumFull extends Item {
  public ThaumFull(String name, String texture, int j) {
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    func_77656_e(800);
    this.canRepair = false;
    this.field_77777_bU = j;
    GameRegistry.registerItem(this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_77624_a(ItemStack itemStack, EntityPlayer player, List<String> list, boolean isAdv) {
    list.add(SkyHard.resource("FullThaum.tooltip_1"));
    list.add(SkyHard.resource("FullThaum.tooltip_2"));
    list.add(SkyHard.resource("FullThaum.tooltip_3"));
    list.add(SkyHard.resource("FullThaum.tooltip_4"));
  }
  
  public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
    if (!world.field_72995_K) {
      MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
      String command = "tc research $nick all".replace("$nick", player.func_70005_c_());
      server.func_71187_D().func_71556_a((ICommandSender)server, command);
      stack.func_77979_a(1);
      if (stack.field_77994_a <= 0)
        player.field_71071_by.func_70299_a(player.field_71071_by.field_70461_c, (ItemStack)null); 
    } 
    return stack;
  }
}
