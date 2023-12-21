package alextm.core;

import alextm.common.items.ItemBox;
import java.util.ArrayList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModCases {
  public static void registerBoxes() {
    Tron_disk1.add(new ItemBox(new ItemStack((Item)ModItems.Tron_head_yellow), 5, 4));
    Tron_disk1.add(new ItemBox(new ItemStack((Item)ModItems.Tron_chest_yellow), 5, 4));
    Tron_disk1.add(new ItemBox(new ItemStack((Item)ModItems.Tron_leggs_yellow), 5, 4));
    Tron_disk1.add(new ItemBox(new ItemStack((Item)ModItems.Tron_boots_yellow), 5, 4));
    Tron_disk2.add(new ItemBox(new ItemStack((Item)ModItems.Tron_head_blue), 5, 2));
    Tron_disk2.add(new ItemBox(new ItemStack((Item)ModItems.Tron_chest_blue), 5, 2));
    Tron_disk2.add(new ItemBox(new ItemStack((Item)ModItems.Tron_leggs_blue), 5, 2));
    Tron_disk2.add(new ItemBox(new ItemStack((Item)ModItems.Tron_boots_blue), 5, 2));
    Tron_disk3.add(new ItemBox(new ItemStack((Item)ModItems.Tron_head_red), 5, 5));
    Tron_disk3.add(new ItemBox(new ItemStack((Item)ModItems.Tron_chest_red), 5, 5));
    Tron_disk3.add(new ItemBox(new ItemStack((Item)ModItems.Tron_leggs_red), 5, 5));
    Tron_disk3.add(new ItemBox(new ItemStack((Item)ModItems.Tron_boots_red), 5, 5));
    Tron_disk4.add(new ItemBox(new ItemStack((Item)ModItems.Tron_head_green), 5, 1));
    Tron_disk4.add(new ItemBox(new ItemStack((Item)ModItems.Tron_chest_green), 5, 1));
    Tron_disk4.add(new ItemBox(new ItemStack((Item)ModItems.Tron_leggs_green), 5, 1));
    Tron_disk4.add(new ItemBox(new ItemStack((Item)ModItems.Tron_boots_green), 5, 1));
    Tron_disk5.add(new ItemBox(new ItemStack((Item)ModItems.Tron_head_purple), 5, 3));
    Tron_disk5.add(new ItemBox(new ItemStack((Item)ModItems.Tron_chest_purple), 5, 3));
    Tron_disk5.add(new ItemBox(new ItemStack((Item)ModItems.Tron_leggs_purple), 5, 3));
    Tron_disk5.add(new ItemBox(new ItemStack((Item)ModItems.Tron_boots_purple), 5, 3));
    Pure_crystal.add(new ItemBox(new ItemStack((Item)ModItems.CrystalArmorHead), 5, 2));
    Pure_crystal.add(new ItemBox(new ItemStack((Item)ModItems.CrystalArmorChest), 5, 2));
    Pure_crystal.add(new ItemBox(new ItemStack((Item)ModItems.CrystalArmorLegs), 5, 2));
    Pure_crystal.add(new ItemBox(new ItemStack((Item)ModItems.CrystalArmorBoots), 5, 2));
    Devil_stone.add(new ItemBox(new ItemStack((Item)ModItems.DevilArmorHead), 5, 5));
    Devil_stone.add(new ItemBox(new ItemStack((Item)ModItems.DevilArmorChest), 5, 5));
    Devil_stone.add(new ItemBox(new ItemStack((Item)ModItems.DevilArmorLegs), 5, 5));
    Devil_stone.add(new ItemBox(new ItemStack((Item)ModItems.DevilArmorBoots), 5, 5));
    Creeper_dust.add(new ItemBox(new ItemStack((Item)ModItems.CreepArmorHead), 5, 1));
    Creeper_dust.add(new ItemBox(new ItemStack((Item)ModItems.CreepArmorChest), 5, 1));
    Creeper_dust.add(new ItemBox(new ItemStack((Item)ModItems.CreepArmorLegs), 5, 1));
    Creeper_dust.add(new ItemBox(new ItemStack((Item)ModItems.CreepArmorBoots), 5, 1));
    Fairy_wing.add(new ItemBox(new ItemStack((Item)ModItems.FairyArmorHead), 5, 3));
    Fairy_wing.add(new ItemBox(new ItemStack((Item)ModItems.FairyArmorChest), 5, 3));
    Fairy_wing.add(new ItemBox(new ItemStack((Item)ModItems.FairyArmorLegs), 5, 3));
    Fairy_wing.add(new ItemBox(new ItemStack((Item)ModItems.FairyArmorBoots), 5, 3));
  }
  
  public static ArrayList<ItemBox> Pure_crystal = new ArrayList<>();
  
  public static ArrayList<ItemBox> Fairy_wing = new ArrayList<>();
  
  public static ArrayList<ItemBox> DaedraHeart = new ArrayList<>();
  
  public static ArrayList<ItemBox> DarkStone = new ArrayList<>();
  
  public static ArrayList<ItemBox> Tron_disk1 = new ArrayList<>();
  
  public static ArrayList<ItemBox> Tron_disk2 = new ArrayList<>();
  
  public static ArrayList<ItemBox> Tron_disk3 = new ArrayList<>();
  
  public static ArrayList<ItemBox> Tron_disk4 = new ArrayList<>();
  
  public static ArrayList<ItemBox> Tron_disk5 = new ArrayList<>();
  
  public static ArrayList<ItemBox> Devil_stone = new ArrayList<>();
  
  public static ArrayList<ItemBox> Creeper_dust = new ArrayList<>();
}
