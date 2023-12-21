package alextm.common.items;

import alextm.SkyHard;
import alextm.core.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MythicalSword extends ItemSword {
  public MythicalSword(String name, String texture) {
    super(ModItems.MYTHICAL);
    func_77655_b(name);
    func_111206_d(texture);
    func_77637_a(SkyHard.SkyHard);
    func_77656_e(100000);
    GameRegistry.registerItem((Item)this, name);
  }
  
  public void func_77663_a(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
    super.func_77663_a(stack, world, entity, par4, par5);
    if (entity instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)entity;
      ItemStack equipped = player.func_71045_bC();
      if (equipped == stack) {
        player.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 2, 5, true));
        player.func_70690_d(new PotionEffect(Potion.field_76439_r.field_76415_H, 2, 2, true));
        player.func_70690_d(new PotionEffect(Potion.field_76424_c.field_76415_H, 2, 5, true));
        player.func_70690_d(new PotionEffect(Potion.field_76430_j.field_76415_H, 2, 5, true));
      } 
    } 
  }
}
