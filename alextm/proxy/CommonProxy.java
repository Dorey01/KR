package alextm.proxy;

import alextm.common.commands.CommandGetSerial;
import alextm.common.commands.CommandHandler;
import alextm.handler.InventorySaveHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.command.ICommand;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
  public void preInit(FMLPreInitializationEvent event) {}
  
  public void Init(FMLInitializationEvent event) {
    Side var10000 = event.getSide();
    FMLCommonHandler.instance().getSide();
    if (var10000 == Side.SERVER) {
      MinecraftForge.EVENT_BUS.register(antidropHandler);
      FMLCommonHandler.instance().bus().register(antidropHandler);
    } 
  }
  
  public void setWispFXDistanceLimit(boolean limit) {}
  
  public void setWispFXDepthTest(boolean depth) {}
  
  public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size) {
    wispFX(world, x, y, z, r, g, b, size, 0.0F);
  }
  
  public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float gravity) {
    wispFX(world, x, y, z, r, g, b, size, gravity, 1.0F);
  }
  
  public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float gravity, float maxAgeMul) {
    wispFX(world, x, y, z, r, g, b, size, 0.0F, -gravity, 0.0F, maxAgeMul);
  }
  
  public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz) {
    wispFX(world, x, y, z, r, g, b, size, motionx, motiony, motionz, 1.0F);
  }
  
  public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul) {}
  
  public void postInit(FMLPostInitializationEvent event) {}
  
  public void registerRenderers() {}
  
  public void registerNEIStuff() {}
  
  public void serverStarting(FMLServerStartingEvent event) {
    event.registerServerCommand((ICommand)new CommandGetSerial());
    event.registerServerCommand((ICommand)new CommandHandler());
  }
  
  public static final InventorySaveHandler antidropHandler = new InventorySaveHandler();
}
