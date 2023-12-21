package alextm.common.items;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

public class ItemReedSt extends ItemReed {
  public ItemReedSt(Block block, String name, String texture) {
    super(block);
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    GameRegistry.registerItem((Item)this, name);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_77624_a(ItemStack itemStack, EntityPlayer player, List<String> list, boolean isAdv) {
    int id = 0;
    if (func_77658_a().equals("item.UrlPaint")) {
      id = 1;
    } else if (func_77658_a().equals("item.UrlPaintAnim")) {
      id = 2;
    } 
    switch (id) {
      case 1:
        list.add(SkyHard.resource("url_paint.tooltip_1"));
        list.add(SkyHard.resource("url_paint.tooltip_2"));
        break;
      case 2:
        list.add(SkyHard.resource("url_paint_anim.tooltip_1"));
        list.add(SkyHard.resource("url_paint_anim.tooltip_2"));
        list.add(SkyHard.resource("url_paint_anim.tooltip_3"));
        break;
    } 
  }
}
