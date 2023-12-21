package alextm;

import alextm.common.items.CraftingManager;
import alextm.core.ModBlocks;
import alextm.core.ModCases;
import alextm.core.ModItems;
import alextm.core.ModItemsImport;
import alextm.core.ModTileEntity;
import alextm.handler.EventHandlerConfig;
import alextm.handler.GuiHandler;
import alextm.network.NetworkHandler;
import alextm.proxy.CommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "SkyHard", name = "SkyHard", version = "1.2")
public class SkyHard {
  public static final String ID = "SkyHard";
  
  public static final String NAME = "SkyHard";
  
  public static final String VERSION = "1.2";
  
  public static String ConfigDirectory;
  
  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    ModConfig.registerConfig(ConfigDirectory = event.getModConfigurationDirectory().getAbsolutePath() + "/SkyHard/");
    proxy.preInit(event);
    ModBlocks.registerBlocks();
    ModItems.registerItems();
    ModTileEntity.registerTileEntity();
    ModCases.registerBoxes();
  }
  
  @EventHandler
  public void Init(FMLInitializationEvent event) {
    proxy.Init(event);
    proxy.registerRenderers();
    proxy.registerNEIStuff();
    MinecraftForge.EVENT_BUS.register(new EventHandlerConfig());
    FMLCommonHandler.instance().bus().register(new EventHandlerConfig());
    NetworkHandler.init("SkyHard");
    NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
  }
  
  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    proxy.postInit(event);
    CraftingManager.registerSunRecipes(ConfigDirectory);
    ModItemsImport.importItems();
    if (Loader.isModLoaded("cosmeticarmorreworked"))
      CosmeticArmor = true; 
    if (Loader.isModLoaded("Baubles"))
      Baubles = true; 
  }
  
  @EventHandler
  public void serverStarting(FMLServerStartingEvent event) {
    proxy.serverStarting(event);
  }
  
  public static String resource(String id) {
    return StatCollector.func_74838_a(id);
  }
  
  public static boolean CosmeticArmor = false;
  
  public static boolean Baubles = false;
  
  public static int streakTime = 100;
  
  public static int sprintTrail = 1;
  
  @Instance("SkyHard")
  public static SkyHard instance;
  
  @SidedProxy(clientSide = "alextm.proxy.ClientProxy", serverSide = "alextm.proxy.CommonProxy")
  public static CommonProxy proxy;
  
  public static final CreativeTabs SkyHard = new CreativeTabs("SkyHard") {
      public Item func_78016_d() {
        return ModItems.DelWarp;
      }
    };
}
