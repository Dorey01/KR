package alextm.handler;

import alextm.ModConfig;
import alextm.SkyHard;
import alextm.utils.Utils;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import java.util.HashMap;
import lain.mods.cos.CosmeticArmorReworked;
import lain.mods.cos.inventory.InventoryCosArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class InventorySaveHandler {
  protected HashMap<String, InventoryPlayer> playerKeepsMap = new HashMap<>();
  
  protected HashMap<String, ItemStack[]> playerCosmeticInventory = (HashMap)new HashMap<>();
  
  protected HashMap<String, ItemStack[]> playerBaublesInventory = (HashMap)new HashMap<>();
  
  protected HashMap<String, Integer> playerExpMap = new HashMap<>();
  
  @SubscribeEvent(priority = EventPriority.LOWEST)
  public void livingDies(LivingDeathEvent event) throws Exception {
    if (event.entityLiving instanceof EntityPlayer && !event.entityLiving.field_70170_p.func_82736_K().func_82766_b("keepInventory")) {
      EntityPlayer player = (EntityPlayer)event.entityLiving;
      if (Utils.hasPermission(player, ModConfig.KeepInventory)) {
        InventoryPlayer keepInventory = new InventoryPlayer((EntityPlayer)null);
        int i;
        for (i = 0; i < player.field_71071_by.field_70460_b.length; i++) {
          keepInventory.field_70460_b[i] = ItemStack.func_77944_b(player.field_71071_by.field_70460_b[i]);
          player.field_71071_by.field_70460_b[i] = null;
        } 
        for (i = 0; i < player.field_71071_by.field_70462_a.length; i++) {
          keepInventory.field_70462_a[i] = ItemStack.func_77944_b(player.field_71071_by.field_70462_a[i]);
          player.field_71071_by.field_70462_a[i] = null;
        } 
        this.playerKeepsMap.put(player.func_70005_c_(), keepInventory);
        if (SkyHard.CosmeticArmor) {
          InventoryCosArmor CosmeticSlots = CosmeticArmorReworked.invMan.getCosArmorInventory(player.func_110124_au());
          int l = CosmeticSlots.func_70302_i_();
          ItemStack[] stacks = new ItemStack[l];
          for (int j = 0; j < l; j++) {
            stacks[j] = ItemStack.func_77944_b(CosmeticSlots.getInventory()[j]);
            CosmeticSlots.func_70299_a(j, (ItemStack)null);
          } 
          this.playerCosmeticInventory.put(player.func_70005_c_(), stacks);
        } 
        if (SkyHard.Baubles) {
          InventoryBaubles BaublesSlots = PlayerHandler.getPlayerBaubles(player);
          int l = BaublesSlots.func_70302_i_();
          ItemStack[] stacks = new ItemStack[l];
          for (int j = 0; j < l; j++) {
            stacks[j] = ItemStack.func_77944_b(BaublesSlots.stackList[j]);
            BaublesSlots.func_70299_a(j, (ItemStack)null);
          } 
          this.playerBaublesInventory.put(player.func_70005_c_(), stacks);
        } 
      } 
      if (Utils.hasPermission(player, ModConfig.ExpSave)) {
        this.playerExpMap.put(player.func_70005_c_(), Integer.valueOf(player.field_71067_cb));
        player.func_71023_q((int)-player.field_71106_cc);
        player.func_82242_a(-player.field_71068_ca);
      } 
    } 
    if (this.playerKeepsMap.size() > 1 || this.playerCosmeticInventory.size() > 1 || this.playerBaublesInventory.size() > 1 || this.playerExpMap.size() > 1)
      FMLLog.warning("[SkyHard] Mod is keeping track of a lot of dead player inventories. Has there been an apocalypse?", new Object[0]); 
  }
  
  @SubscribeEvent
  public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) throws Exception {
    EntityPlayer player = event.player;
    if (this.playerKeepsMap.containsKey(player.func_70005_c_())) {
      FMLLog.info("[SkyHard] Player %s respawned and recieved items held in storage", new Object[] { player.func_70005_c_() });
      InventoryPlayer keepInventory = this.playerKeepsMap.get(player.func_70005_c_());
      int i;
      for (i = 0; i < player.field_71071_by.field_70460_b.length; i++) {
        if (keepInventory.field_70460_b[i] != null)
          player.field_71071_by.field_70460_b[i] = keepInventory.field_70460_b[i]; 
      } 
      for (i = 0; i < player.field_71071_by.field_70462_a.length; i++) {
        if (keepInventory.field_70462_a[i] != null)
          player.field_71071_by.field_70462_a[i] = keepInventory.field_70462_a[i]; 
      } 
      this.playerKeepsMap.remove(player.func_70005_c_());
      player.func_146105_b((IChatComponent)new ChatComponentText(ModConfig.SaveInvMessage));
    } 
    if (this.playerExpMap.containsKey(player.func_70005_c_())) {
      player.func_71023_q(((Integer)this.playerExpMap.get(player.func_70005_c_())).intValue());
      this.playerExpMap.remove(player.func_70005_c_());
      player.func_146105_b((IChatComponent)new ChatComponentText(ModConfig.SaveExpMessage));
    } 
    if (SkyHard.CosmeticArmor && this.playerCosmeticInventory.containsKey(player.func_70005_c_())) {
      InventoryCosArmor CosmeticSlots = CosmeticArmorReworked.invMan.getCosArmorInventory(player.func_110124_au());
      ItemStack[] list = this.playerCosmeticInventory.get(player.func_70005_c_());
      for (int j = 0; j < list.length; j++)
        CosmeticSlots.func_70299_a(j, list[j]); 
      this.playerCosmeticInventory.remove(player.func_70005_c_());
    } 
    if (SkyHard.Baubles && this.playerBaublesInventory.containsKey(player.func_70005_c_())) {
      InventoryBaubles BaublesSlots = PlayerHandler.getPlayerBaubles(player);
      ItemStack[] list = this.playerBaublesInventory.get(player.func_70005_c_());
      for (int j = 0; j < list.length; j++)
        BaublesSlots.func_70299_a(j, list[j]); 
      this.playerBaublesInventory.remove(player.func_70005_c_());
    } 
  }
}
