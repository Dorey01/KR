package alextm.core;

import alextm.common.items.Aspects;
import alextm.common.items.DelWarp;
import alextm.common.items.EndPortal;
import alextm.common.items.EnderBag;
import alextm.common.items.ItemCase;
import alextm.common.items.ItemDaedraArmor;
import alextm.common.items.ItemDarknessArmor;
import alextm.common.items.ItemMeowmere;
import alextm.common.items.ItemReedSt;
import alextm.common.items.ItemSkin;
import alextm.common.items.ItemVoxelArmor;
import alextm.common.items.Items;
import alextm.common.items.MythicalSword;
import alextm.common.items.PermWarps;
import alextm.common.items.PhantomSword;
import alextm.common.items.ThaumFull;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public abstract class ModItems {
  public static void registerItems() {
    magicproz = new Items("magicproz", "alextm:magicproz", 64);
    magicproz1 = new Items("magicproz1", "alextm:magicproz1", 64);
    magicprozPress = new Items("magicprozPress", "alextm:magicprozPress", 1);
    terraproz = new Items("terraproz", "alextm:terraproz", 64);
    terraproz1 = new Items("terraproz1", "alextm:terraproz1", 64);
    terraprozPress = new Items("terraprozPress", "alextm:terraprozPress", 1);
    EndPortal = new EndPortal("EndPortal", "alextm:EndPortal", 1);
    EnderBag = new EnderBag("EnderBag", "alextm:EnderBag", 1);
    amuletbox = new Items("amuletbox", "alextm:amuletbox", 1);
    mechbox = new Items("mechbox", "alextm:mechbox", 1);
    runebox = new Items("runebox", "alextm:runebox", 1);
    swordbox = new Items("swordbox", "alextm:swordbox", 1);
    PlateIhor = new Items("PlateIhor", "alextm:PlateIhor", 64);
    ManaQuartz = new Items("ManaQuartz", "alextm:ManaQuartz", 64);
    BloodQuartz = new Items("BloodQuartz", "alextm:BloodQuartz", 64);
    ShardRune = new Items("ShardRune", "alextm:ShardRune", 64);
    ElectroSkullSkeleton = new Items("ElectroSkullSkeleton", "alextm:ElectroSkullSkeleton", 64);
    ElectroSkullCreeper = new Items("ElectroSkullCreeper", "alextm:ElectroSkullCreeper", 64);
    DryOil = new Items("DryOil", "alextm:DryOil", 64);
    primordial_pearl_mote = new Items("primordial_pearl_mote", "alextm:primordial_pearl_mote", 64);
    primordial_pearl_nodule = new Items("primordial_pearl_nodule", "alextm:primordial_pearl_nodule", 64);
    Crescent_rose_skin = (Item)new ItemSkin("Crescent_rose_skin");
    Tenjiry_skin = (Item)new ItemSkin("Tenjiry_skin");
    Shinju_skin = (Item)new ItemSkin("Shinju_skin");
    ShikamaDodji_skin = (Item)new ItemSkin("ShikamaDodji_skin");
    VampireKiss_skin = (Item)new ItemSkin("VampireKiss_skin");
    Vis_molot_skin = (Item)new ItemSkin("Vis_molot_skin");
    Sun_molot_skin = (Item)new ItemSkin("Sun_molot_skin");
    Ice_molot_skin = (Item)new ItemSkin("Ice_molot_skin");
    Live_molot_skin = (Item)new ItemSkin("Live_molot_skin");
    Dark_molot_skin = (Item)new ItemSkin("Dark_molot_skin");
    Moon_light_skin = (Item)new ItemSkin("Moon_light_skin");
    AllSkins[1] = new ItemStack(Crescent_rose_skin);
    AllSkins[2] = new ItemStack(Tenjiry_skin);
    AllSkins[3] = new ItemStack(Shinju_skin);
    AllSkins[4] = new ItemStack(ShikamaDodji_skin);
    AllSkins[5] = new ItemStack(VampireKiss_skin);
    AllSkins[6] = new ItemStack(Vis_molot_skin);
    AllSkins[7] = new ItemStack(Sun_molot_skin);
    AllSkins[8] = new ItemStack(Ice_molot_skin);
    AllSkins[9] = new ItemStack(Live_molot_skin);
    AllSkins[10] = new ItemStack(Dark_molot_skin);
    AllSkins[11] = new ItemStack(Moon_light_skin);
    Meowmere = (Item)new ItemMeowmere("Meowmere", "alextm:meowmere");
    DaedraAkt = new ItemCase("ChestDaedra", "alextm:DaedraAkt", ModCases.DaedraHeart, true, "daedra", 10);
    DarknessAkt = new ItemCase("DarknessAkt", "alextm:DarknessAkt", ModCases.DarkStone, true, "dark", 10);
    DaedraHead = new ItemDaedraArmor("Head", "", ItemArmor.ArmorMaterial.DIAMOND, 0);
    DaedraChest = new ItemDaedraArmor("Chest", "", ItemArmor.ArmorMaterial.DIAMOND, 1);
    DaedraStanci = new ItemDaedraArmor("Stanci", "", ItemArmor.ArmorMaterial.DIAMOND, 2);
    DaedraBoots = new ItemDaedraArmor("Boots", "", ItemArmor.ArmorMaterial.DIAMOND, 3);
    DarknessHead = new ItemDarknessArmor("DarknessHead", "", ItemArmor.ArmorMaterial.DIAMOND, 0);
    DarknessChest = new ItemDarknessArmor("DarknessChest", "", ItemArmor.ArmorMaterial.DIAMOND, 1);
    DarknessLegs = new ItemDarknessArmor("DarknessLegs", "", ItemArmor.ArmorMaterial.DIAMOND, 2);
    DarknessBoots = new ItemDarknessArmor("DarknessBoots", "", ItemArmor.ArmorMaterial.DIAMOND, 3);
    Vis_dust = new Items("Vis_dust", "alextm:dust_blaze_1", 64);
    Fire_dust = new Items("Fire_dust", "alextm:dust_blaze_2", 64);
    Sky_dust = new Items("Sky_dust", "alextm:dust_blaze_3", 64);
    Live_dust = new Items("Live_dust", "alextm:dust_blaze_4", 64);
    Dark_dust = new Items("Dark_dust", "alextm:dust_blaze_5", 64);
    PermWarps = new PermWarps("PermWarps", "alextm:PermWarps", 64);
    FullThaum = new ThaumFull("FullThaum", "alextm:thaumfull", 1);
    Aspects = new Aspects("Aspects", "alextm:aspects", 64);
    DelWarp = new DelWarp("DelWarp", "alextm:DelWarp", 1);
    PhantomSword = (Item)new PhantomSword("PhantomSword", "alextm:sword/Phantom");
    MythicalSword = (Item)new MythicalSword("MythicalSword", "alextm:sword/Mythical");
    WyvernTablet = new Items("WyvernTablet", "alextm:wyverntablet", 64);
    VisPlate = new Items("VisPlate", "alextm:vis_plate", 64);
    SunPlate = new Items("SunPlate", "alextm:sun_plate", 64);
    LivePlate = new Items("LivePlate", "alextm:live_plate", 64);
    IcePlate = new Items("IcePlate", "alextm:ice_plate", 64);
    DarkPlate = new Items("DarkPlate", "alextm:dark_plate", 64);
    Tron_disk1 = new ItemCase("Tron_disk1", "alextm:tron_disk1", ModCases.Tron_disk1, true, "tron_yellow", 11);
    Tron_disk2 = new ItemCase("Tron_disk2", "alextm:tron_disk2", ModCases.Tron_disk2, true, "tron_blue", 11);
    Tron_disk3 = new ItemCase("Tron_disk3", "alextm:tron_disk3", ModCases.Tron_disk3, true, "tron_red", 11);
    Tron_disk4 = new ItemCase("Tron_disk4", "alextm:tron_disk4", ModCases.Tron_disk4, true, "tron_green", 11);
    Tron_disk5 = new ItemCase("Tron_disk5", "alextm:tron_disk5", ModCases.Tron_disk5, true, "tron_purple", 11);
    Pure_crystal = new ItemCase("Pure_crystal", "alextm:pure_crystal", ModCases.Pure_crystal, true, "crystal", 10);
    Devil_stone = new ItemCase("Devil_stone", "alextm:devil_stone", ModCases.Devil_stone, true, "devil", 10);
    Creeper_dust = new ItemCase("Creeper_dust", "alextm:creeper_dust", ModCases.Creeper_dust, true, "creep", 10);
    Fairy_wing = new ItemCase("Fairy_wing", "alextm:fairy_wing", ModCases.Fairy_wing, true, "fairy", 10);
    Tron_head_yellow = new ItemVoxelArmor(DW_ARMOR, 0, "Tron_head_yellow", "tron_yellow", 2, 5);
    Tron_chest_yellow = new ItemVoxelArmor(DW_ARMOR, 1, "Tron_chest_yellow", "tron_yellow", 2, 5);
    Tron_leggs_yellow = new ItemVoxelArmor(DW_ARMOR, 2, "Tron_leggs_yellow", "tron_yellow", 2, 5);
    Tron_boots_yellow = new ItemVoxelArmor(DW_ARMOR, 3, "Tron_boots_yellow", "tron_yellow", 2, 5);
    Tron_head_blue = new ItemVoxelArmor(DW_ARMOR, 0, "Tron_head_blue", "tron_blue", 2, 5);
    Tron_chest_blue = new ItemVoxelArmor(DW_ARMOR, 1, "Tron_chest_blue", "tron_blue", 2, 5);
    Tron_leggs_blue = new ItemVoxelArmor(DW_ARMOR, 2, "Tron_leggs_blue", "tron_blue", 2, 5);
    Tron_boots_blue = new ItemVoxelArmor(DW_ARMOR, 3, "Tron_boots_blue", "tron_blue", 2, 5);
    Tron_head_red = new ItemVoxelArmor(DW_ARMOR, 0, "Tron_head_red", "tron_red", 2, 5);
    Tron_chest_red = new ItemVoxelArmor(DW_ARMOR, 1, "Tron_chest_red", "tron_red", 2, 5);
    Tron_leggs_red = new ItemVoxelArmor(DW_ARMOR, 2, "Tron_leggs_red", "tron_red", 2, 5);
    Tron_boots_red = new ItemVoxelArmor(DW_ARMOR, 3, "Tron_boots_red", "tron_red", 2, 5);
    Tron_head_green = new ItemVoxelArmor(DW_ARMOR, 0, "Tron_head_green", "tron_green", 2, 5);
    Tron_chest_green = new ItemVoxelArmor(DW_ARMOR, 1, "Tron_chest_green", "tron_green", 2, 5);
    Tron_leggs_green = new ItemVoxelArmor(DW_ARMOR, 2, "Tron_leggs_green", "tron_green", 2, 5);
    Tron_boots_green = new ItemVoxelArmor(DW_ARMOR, 3, "Tron_boots_green", "tron_green", 2, 5);
    Tron_head_purple = new ItemVoxelArmor(DW_ARMOR, 0, "Tron_head_purple", "tron_purple", 2, 5);
    Tron_chest_purple = new ItemVoxelArmor(DW_ARMOR, 1, "Tron_chest_purple", "tron_purple", 2, 5);
    Tron_leggs_purple = new ItemVoxelArmor(DW_ARMOR, 2, "Tron_leggs_purple", "tron_purple", 2, 5);
    Tron_boots_purple = new ItemVoxelArmor(DW_ARMOR, 3, "Tron_boots_purple", "tron_purple", 2, 5);
    CrystalArmorHead = new ItemVoxelArmor(DW_ARMOR, 0, "CrystalArmorHead", "crystal", 2, 4);
    CrystalArmorChest = new ItemVoxelArmor(DW_ARMOR, 1, "CrystalArmorChest", "crystal", 2, 4);
    CrystalArmorLegs = new ItemVoxelArmor(DW_ARMOR, 2, "CrystalArmorLegs", "crystal", 2, 4);
    CrystalArmorBoots = new ItemVoxelArmor(DW_ARMOR, 3, "CrystalArmorBoots", "crystal", 2, 4);
    DevilArmorHead = new ItemVoxelArmor(DW_ARMOR, 0, "DevilArmorHead", "devil", 2, 4);
    DevilArmorChest = new ItemVoxelArmor(DW_ARMOR, 1, "DevilArmorChest", "devil", 2, 4);
    DevilArmorLegs = new ItemVoxelArmor(DW_ARMOR, 2, "DevilArmorLegs", "devil", 2, 4);
    DevilArmorBoots = new ItemVoxelArmor(DW_ARMOR, 3, "DevilArmorBoots", "devil", 2, 4);
    CreepArmorHead = new ItemVoxelArmor(DW_ARMOR, 0, "CreepArmorHead", "creep", 2, 4);
    CreepArmorChest = new ItemVoxelArmor(DW_ARMOR, 1, "CreepArmorChest", "creep", 2, 4);
    CreepArmorLegs = new ItemVoxelArmor(DW_ARMOR, 2, "CreepArmorLegs", "creep", 2, 4);
    CreepArmorBoots = new ItemVoxelArmor(DW_ARMOR, 3, "CreepArmorBoots", "creep", 2, 4);
    FairyArmorHead = new ItemVoxelArmor(DW_ARMOR, 0, "FairyArmorHead", "fairy", 2, 4);
    FairyArmorChest = new ItemVoxelArmor(DW_ARMOR, 1, "FairyArmorChest", "fairy", 2, 4);
    FairyArmorLegs = new ItemVoxelArmor(DW_ARMOR, 2, "FairyArmorLegs", "fairy", 2, 4);
    FairyArmorBoots = new ItemVoxelArmor(DW_ARMOR, 3, "FairyArmorBoots", "fairy", 2, 4);
  }
  
  public static final Item.ToolMaterial MYTHICAL = EnumHelper.addToolMaterial("MYTHICAL", 0, 10000, 0.0F, 75.0F, 50);
  
  public static final Item.ToolMaterial PHANTOM = EnumHelper.addToolMaterial("PHANTOM", 0, 10000, 0.0F, 44.0F, 50);
  
  public static ItemArmor.ArmorMaterial DW_ARMOR = EnumHelper.addArmorMaterial("STMIND_ARMOR", -1, new int[] { 3, 8, 6, 3 }, 30);
  
  public static Item Vis_dust;
  
  public static Item Fire_dust;
  
  public static Item Sky_dust;
  
  public static Item Live_dust;
  
  public static Item Dark_dust;
  
  public static Item FullThaum;
  
  public static Item MythicalSword;
  
  public static Item PhantomSword;
  
  public static Item WyvernTablet;
  
  public static ItemDaedraArmor DaedraHead;
  
  public static ItemDaedraArmor DaedraChest;
  
  public static ItemDaedraArmor DaedraStanci;
  
  public static ItemDaedraArmor DaedraBoots;
  
  public static ItemDarknessArmor DarknessHead;
  
  public static ItemDarknessArmor DarknessChest;
  
  public static ItemDarknessArmor DarknessLegs;
  
  public static ItemDarknessArmor DarknessBoots;
  
  public static Item DaedraAkt;
  
  public static Item DarknessAkt;
  
  public static Item Aspects;
  
  public static Item DelWarp;
  
  public static Item PermWarps;
  
  public static Item IcePlate;
  
  public static Item DarkPlate;
  
  public static Item LivePlate;
  
  public static Item VisPlate;
  
  public static Item SunPlate;
  
  public static Item UrlPaint;
  
  public static Item UrlPaintAnim;
  
  public static Item Rainbow;
  
  public static Item Meowmere;
  
  public static Item Smoke;
  
  public static Item Tron_disk1;
  
  public static Item Tron_disk2;
  
  public static Item Tron_disk3;
  
  public static Item Tron_disk4;
  
  public static Item Tron_disk5;
  
  public static Item Pure_crystal;
  
  public static Item Devil_stone;
  
  public static Item Creeper_dust;
  
  public static Item Fairy_wing;
  
  public static ItemArmor Tron_head_yellow;
  
  public static ItemArmor Tron_chest_yellow;
  
  public static ItemArmor Tron_leggs_yellow;
  
  public static ItemArmor Tron_boots_yellow;
  
  public static ItemArmor Tron_head_blue;
  
  public static ItemArmor Tron_chest_blue;
  
  public static ItemArmor Tron_leggs_blue;
  
  public static ItemArmor Tron_boots_blue;
  
  public static ItemArmor Tron_head_red;
  
  public static ItemArmor Tron_chest_red;
  
  public static ItemArmor Tron_leggs_red;
  
  public static ItemArmor Tron_boots_red;
  
  public static ItemArmor Tron_head_green;
  
  public static ItemArmor Tron_chest_green;
  
  public static ItemArmor Tron_leggs_green;
  
  public static ItemArmor Tron_boots_green;
  
  public static ItemArmor Tron_head_purple;
  
  public static ItemArmor Tron_chest_purple;
  
  public static ItemArmor Tron_leggs_purple;
  
  public static ItemArmor Tron_boots_purple;
  
  public static ItemArmor CrystalArmorHead;
  
  public static ItemArmor CrystalArmorChest;
  
  public static ItemArmor CrystalArmorLegs;
  
  public static ItemArmor CrystalArmorBoots;
  
  public static ItemArmor DevilArmorHead;
  
  public static ItemArmor DevilArmorChest;
  
  public static ItemArmor DevilArmorLegs;
  
  public static ItemArmor DevilArmorBoots;
  
  public static ItemArmor CreepArmorHead;
  
  public static ItemArmor CreepArmorChest;
  
  public static ItemArmor CreepArmorLegs;
  
  public static ItemArmor CreepArmorBoots;
  
  public static ItemArmor FairyArmorHead;
  
  public static ItemArmor FairyArmorChest;
  
  public static ItemArmor FairyArmorLegs;
  
  public static ItemArmor FairyArmorBoots;
  
  public static ItemStack[] AllSkins = new ItemStack[12];
  
  public static Item Crescent_rose_skin;
  
  public static Item Tenjiry_skin;
  
  public static Item Shinju_skin;
  
  public static Item ShikamaDodji_skin;
  
  public static Item VampireKiss_skin;
  
  public static Item Moon_light_skin;
  
  public static Item Vis_molot_skin;
  
  public static Item Sun_molot_skin;
  
  public static Item Ice_molot_skin;
  
  public static Item Live_molot_skin;
  
  public static Item Dark_molot_skin;
  
  public static Item EnderBag;
  
  public static Item amuletbox;
  
  public static Item mechbox;
  
  public static Item runebox;
  
  public static Item swordbox;
  
  public static Item ElectroSkullSkeleton;
  
  public static Item ElectroSkullCreeper;
  
  public static Item PlateIhor;
  
  public static Item ShardRune;
  
  public static Item ManaQuartz;
  
  public static Item BloodQuartz;
  
  public static Item DryOil;
  
  public static Item primordial_pearl_mote;
  
  public static Item primordial_pearl_nodule;
  
  public static Item EndPortal;
  
  public static Item magicproz;
  
  public static Item magicproz1;
  
  public static Item magicprozPress;
  
  public static Item terraproz;
  
  public static Item terraproz1;
  
  public static Item terraprozPress;
  
  public abstract void onUpdate(ItemStack paramItemStack, World paramWorld, Entity paramEntity, int paramInt, boolean paramBoolean);
  
  public abstract void addInformation(ItemStack paramItemStack, EntityPlayer paramEntityPlayer, List paramList, boolean paramBoolean);
  
  static {
    UrlPaint = (Item)new ItemReedSt(ModBlocks.frame, "UrlPaint", "alextm:url_paint");
    UrlPaintAnim = (Item)new ItemReedSt(ModBlocks.frameAnim, "UrlPaintAnim", "alextm:url_paint_anim");
  }
}
