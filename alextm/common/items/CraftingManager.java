package alextm.common.items;

import alextm.SkyHard;
import alextm.core.ModItemsImport;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

public class CraftingManager {
  public static void setDefault(String[] MirrorCrafts) {
    recipes.clear();
    WorkbenchCrafts = MirrorCrafts;
    ConvertRecipes();
  }
  
  public static void registerSunRecipes(String configDir) {
    registerSunRecipes(configDir, null);
  }
  
  public static void registerSunRecipes(String configDir, EntityPlayerMP player) {
    Side var10000 = FMLCommonHandler.instance().getSide();
    FMLCommonHandler.instance().getSide();
    if (var10000 == Side.SERVER) {
      Configuration config = new Configuration(new File(configDir + configName));
      try {
        config.load();
        recipes.clear();
        String[] WorkbenchCraftsDefault = { "minecraft:bedrock; 1 = minecraft:bedrock:0" };
        WorkbenchCrafts = config.getStringList("WorkbenchCrafts", "WorkbenchCrafts", WorkbenchCraftsDefault, "Крафты для Мифического верстака");
        ConvertRecipes();
        if (player != null)
          player.func_145747_a((IChatComponent)new ChatComponentText(SkyHard.resource("stming.chat.prefix") + configName + " пїЅaуспешно перезагружен.")); 
      } catch (Exception var10001) {
        if (player == null) {
          System.out.println("[SkyHard] Ошибка загрузки конфига: " + configName + ". Выставлены значения по умолчанию.");
        } else {
          player.func_145747_a((IChatComponent)new ChatComponentText(SkyHard.resource("stming.chat.prefix") + "Ошибка загрузки конфига: пїЅc" + configName + "пїЅa. Выставлены значения по умолчанию."));
        } 
      } finally {
        config.save();
      } 
    } 
  }
  
  private static void ConvertRecipes() {
    for (String workbenchCraft : WorkbenchCrafts) {
      ItemStack result, stacks[] = new ItemStack[recipeWidth * recipeHeight];
      String line = workbenchCraft.replaceAll("\\s+", "");
      String[] entryData = line.split("=");
      String[] entryDataResult = entryData[0].split(";");
      if (entryDataResult.length > 1) {
        result = ModItemsImport.getForgeItem(entryDataResult[0]);
        if (result != null)
          result.field_77994_a = Integer.parseInt(entryDataResult[1]); 
      } else {
        result = ModItemsImport.getForgeItem(entryDataResult[0]);
      } 
      String[] entryDataStacks = entryData[1].split(",");
      for (int j = 0; j < entryDataStacks.length; j++)
        stacks[j] = ModItemsImport.getForgeItem(entryDataStacks[j]); 
      recipes.add(new RecipedWorkbench(recipeWidth, recipeHeight, stacks, result));
    } 
  }
  
  public static ItemStack findMatchingRecipe(InventoryCrafting inv, World world) {
    int i = 0;
    int j;
    for (j = 0; j < inv.func_70302_i_(); j++) {
      ItemStack itemstack2 = inv.func_70301_a(j);
      if (itemstack2 != null)
        i++; 
    } 
    for (j = 0; j < recipes.size(); j++) {
      IRecipe irecipe = recipes.get(j);
      if (irecipe.func_77569_a(inv, world))
        return irecipe.func_77572_b(inv); 
    } 
    return null;
  }
  
  public static List<IRecipe> getRecipeList() {
    return recipes;
  }
  
  private static String configName = "SkyHard_Crafts.cfg";
  
  private static List<IRecipe> recipes = new ArrayList<>();
  
  public static String[] WorkbenchCrafts;
  
  private static int recipeWidth = 5;
  
  private static int recipeHeight = 5;
}
