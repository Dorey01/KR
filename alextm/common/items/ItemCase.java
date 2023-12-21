package alextm.common.items;

import alextm.SkyHard;
import alextm.network.NetworkHandler;
import alextm.network.OpenBox;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCase extends Item {
  private ArrayList<ItemBox> Case;
  
  private boolean giveAll;
  
  private int tooltips;
  
  private String tag;
  
  public ItemCase(String name, String texture, ArrayList<ItemBox> Case, boolean giveAll) {
    this.tooltips = 0;
    this.tag = "";
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    func_77625_d(1);
    GameRegistry.registerItem(this, name);
    this.Case = Case;
    this.giveAll = giveAll;
  }
  
  public ItemCase(String name, String texture, ArrayList<ItemBox> Case, boolean giveAll, String tag, int tooltips) {
    this.tooltips = 0;
    this.tag = "";
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    func_77625_d(1);
    GameRegistry.registerItem(this, name);
    this.Case = Case;
    this.giveAll = giveAll;
    this.tag = tag;
    this.tooltips = tooltips;
  }
  
  @SideOnly(Side.CLIENT)
  public void func_77624_a(ItemStack itemStack, EntityPlayer player, List<String> list, boolean isAdv) {
    for (int i = 1; i <= this.tooltips; i++)
      list.add(SkyHard.resource("case.tooltip." + this.tag + "_" + i)); 
  }
  
  public ItemStack func_77659_a(ItemStack stack, World world, EntityPlayer player) {
    if (world.field_72995_K) {
      NetworkHandler.network.sendToServer(new OpenBox(this));
    } else {
      player.getEntityData().func_74768_a("fireworksLeft", 10);
      player.getEntityData().func_74757_a("fireworkDelay", false);
      world.func_72956_a((Entity)player, "alextm:open_box", 0.75F, 1.0F);
    } 
    return stack;
  }
  
  public int getSize() {
    return this.Case.size();
  }
  
  public ItemBox getCurrentItem(int id) {
    return this.Case.get(id);
  }
  
  public boolean isGiveAll() {
    return this.giveAll;
  }
}
