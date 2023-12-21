package alextm.common.items;

import alextm.SkyHard;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class Items extends Item {
  public Items(String name, String texture, int j) {
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    func_77656_e(800);
    this.canRepair = false;
    this.field_77777_bU = j;
    GameRegistry.registerItem(this, name);
  }
}
