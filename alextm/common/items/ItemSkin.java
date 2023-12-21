package alextm.common.items;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemSkin extends ItemSword {
  public ItemSkin(String name) {
    super(Item.ToolMaterial.WOOD);
    func_77655_b(name);
    func_77656_e(-1);
    func_77637_a(SkyHard.SkyHard);
    GameRegistry.registerItem((Item)this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_77624_a(ItemStack itemStack, EntityPlayer player, List<String> list, boolean isAdv) {
    list.add(SkyHard.resource("dw.skin.tooltip_1"));
    list.add(SkyHard.resource("dw.skin.tooltip_2"));
    list.add(SkyHard.resource("dw.skin.tooltip_3"));
    list.add(SkyHard.resource("dw.skin.tooltip_4"));
  }
}
