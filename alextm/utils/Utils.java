package alextm.utils;

import java.lang.reflect.Method;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Utils {
  private static final Method getBukkitEntity;
  
  public static Player toBukkitEntity(EntityPlayer player) throws Exception {
    return (Player)getBukkitEntity.invoke(player, new Object[0]);
  }
  
  public static World toBukkitWorld(World world) {
    return Bukkit.getWorld(world.func_72912_H().func_76065_j());
  }
  
  public static final boolean hasPermission(EntityPlayer player, String permission) {
    try {
      return toBukkitEntity(player).hasPermission(permission);
    } catch (Exception var3) {
      return false;
    } 
  }
  
  static {
    try {
      (getBukkitEntity = Entity.class.getDeclaredMethod("getBukkitEntity", new Class[0])).setAccessible(true);
    } catch (Throwable var1) {
      throw new RuntimeException("Failed hooking CraftBukkit methods!", var1);
    } 
  }
}
