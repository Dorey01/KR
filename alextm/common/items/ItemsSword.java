package alextm.common.items;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ItemsSword extends ItemSword {
  public ItemsSword(String name, String texture) {
    super(Item.ToolMaterial.EMERALD);
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    func_77656_e(1000);
    GameRegistry.registerItem((Item)this, name);
  }
}
