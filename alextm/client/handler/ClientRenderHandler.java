package alextm.client.handler;

import alextm.client.particles.EntityEnderFx;
import alextm.core.ModItems;
import alextm.utils.CosmeticArmorUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;

@SideOnly(Side.CLIENT)
public class ClientRenderHandler {
  private Minecraft mc = Minecraft.func_71410_x();
  
  private List<EntityPlayer> players = new ArrayList<>();
  
  @SubscribeEvent
  public void onWorldTick(RenderWorldLastEvent event) {
    partialTicks = event.partialTicks;
    tick = (int)((Minecraft.func_71410_x()).field_71441_e.func_72820_D() % 20L);
  }
  
  @SubscribeEvent
  public void onPlayerTick(RenderPlayerEvent.Post event) {
    EntityPlayer player = event.entityPlayer;
    if (oldTick != tick) {
      oldTick = tick;
      this.players.clear();
    } else if (this.players.contains(player)) {
      return;
    } 
    this.players.add(player);
    if (RenderManager.field_78727_a.field_78735_i == 180.0F)
      return; 
    if (!CosmeticArmorUtils.isWear(player, (Item)ModItems.CrystalArmorHead, (Item)ModItems.CrystalArmorChest, (Item)ModItems.CrystalArmorLegs, (Item)ModItems.CrystalArmorBoots) || (player.func_82150_aj() && (player != this.mc.field_71439_g || this.mc.field_71474_y.field_74320_O == 0))) {
      if (CosmeticArmorUtils.isWear(player, (Item)ModItems.FairyArmorHead, (Item)ModItems.FairyArmorChest, (Item)ModItems.FairyArmorLegs, (Item)ModItems.FairyArmorBoots) && (!player.func_82150_aj() || (player == this.mc.field_71439_g && this.mc.field_71474_y.field_74320_O != 0))) {
        Random rand = new Random();
        double x = (rand.nextDouble() - 0.5D) * player.field_70130_N;
        double y = rand.nextDouble() * player.field_70131_O;
        double z = (rand.nextDouble() - 0.5D) * player.field_70130_N;
        float[] color1 = { 1.0F, 0.4F, 0.5F };
        float[] color2 = { 1.0F, 1.0F, 0.0F };
        if (player == this.mc.field_71439_g)
          y--; 
        for (int i = 0; i < 1; i++) {
          EntityEnderFx particle = new EntityEnderFx(player, x, y, z, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, color1, color2);
          this.mc.field_71452_i.func_78873_a((EntityFX)particle);
        } 
      } else if ((CosmeticArmorUtils.isWear(player, (Item)ModItems.DevilArmorHead, (Item)ModItems.DevilArmorChest, (Item)ModItems.DevilArmorLegs, (Item)ModItems.DevilArmorBoots) || CosmeticArmorUtils.isWear(player, (Item)ModItems.DarknessHead, (Item)ModItems.DarknessChest, (Item)ModItems.DarknessLegs, (Item)ModItems.DarknessBoots)) && (!player.func_82150_aj() || (player == this.mc.field_71439_g && this.mc.field_71474_y.field_74320_O != 0))) {
        Random rand = new Random();
        double x = (rand.nextDouble() - 0.5D) * player.field_70130_N;
        double y = rand.nextDouble() * player.field_70131_O;
        double z = (rand.nextDouble() - 0.5D) * player.field_70130_N;
        float[] color1 = { 0.0F, 0.0F, 0.0F };
        float[] color2 = { 0.0F, 0.0F, 0.0F };
        if (player == this.mc.field_71439_g)
          y--; 
        for (int i = 0; i < 1; i++) {
          EntityEnderFx particle = new EntityEnderFx(player, x, y, z, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, color1, color2);
          this.mc.field_71452_i.func_78873_a((EntityFX)particle);
        } 
      } else if (CosmeticArmorUtils.isWear(player, (Item)ModItems.CreepArmorHead, (Item)ModItems.CreepArmorChest, (Item)ModItems.CreepArmorLegs, (Item)ModItems.CreepArmorBoots) && (!player.func_82150_aj() || (player == this.mc.field_71439_g && this.mc.field_71474_y.field_74320_O != 0))) {
        Random rand = new Random();
        double x = (rand.nextDouble() - 0.5D) * player.field_70130_N;
        double y = rand.nextDouble() * player.field_70131_O;
        double z = (rand.nextDouble() - 0.5D) * player.field_70130_N;
        float[] color1 = { 0.0F, 0.255F, 0.0F };
        float[] color2 = { 0.0F, 0.255F, 0.0F };
        if (player == this.mc.field_71439_g)
          y--; 
        for (int i = 0; i < 1; i++) {
          EntityEnderFx particle = new EntityEnderFx(player, x, y, z, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, color1, color2);
          this.mc.field_71452_i.func_78873_a((EntityFX)particle);
        } 
      } else if (CosmeticArmorUtils.isWear(player, (Item)ModItems.DaedraHead, (Item)ModItems.DaedraChest, (Item)ModItems.DaedraStanci, (Item)ModItems.DaedraBoots) && (!player.func_82150_aj() || (player == this.mc.field_71439_g && this.mc.field_71474_y.field_74320_O != 0))) {
        Random rand = new Random();
        double x = (rand.nextDouble() - 0.5D) * player.field_70130_N;
        double y = rand.nextDouble() * player.field_70131_O;
        double z = (rand.nextDouble() - 0.5D) * player.field_70130_N;
        float[] color1 = { 0.0F, 0.2F, 0.6F };
        float[] color2 = { 0.0F, 0.2F, 0.6F };
        if (player == this.mc.field_71439_g)
          y--; 
        for (int i = 0; i < 1; i++) {
          EntityEnderFx particle = new EntityEnderFx(player, x, y, z, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, color1, color2);
          this.mc.field_71452_i.func_78873_a((EntityFX)particle);
        } 
      } 
    } else {
      Random rand = new Random();
      double x = (rand.nextDouble() - 0.5D) * player.field_70130_N;
      double y = rand.nextDouble() * player.field_70131_O;
      double z = (rand.nextDouble() - 0.5D) * player.field_70130_N;
      float[] color1 = { 1.0F, 1.0F, 1.0F };
      float[] color2 = { 1.0F, 1.0F, 1.0F };
      if (player == this.mc.field_71439_g)
        y--; 
      for (int i = 0; i < 1; i++) {
        EntityEnderFx particle = new EntityEnderFx(player, x, y, z, (rand.nextDouble() - 0.5D) * 2.0D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2.0D, color1, color2);
        this.mc.field_71452_i.func_78873_a((EntityFX)particle);
      } 
    } 
  }
  
  public static float partialTicks = 0.0F;
  
  public static int tick = 0;
  
  private static int oldTick = 0;
}
