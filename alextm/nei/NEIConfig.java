package alextm.nei;

import alextm.SkyHard;
import alextm.core.ModBlocks;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Optional.Interface;
import cpw.mods.fml.common.Optional.Method;
import net.minecraft.item.ItemStack;

@Interface(iface = "codechicken.nei.api.API", modid = "NotEnoughItems")
public class NEIConfig implements IConfigureNEI {
  @Method(modid = "NotEnoughItems")
  public String getName() {
    return "SkyHard NEIIntegration";
  }
  
  @Method(modid = "NotEnoughItems")
  public String getVersion() {
    return ((Mod)SkyHard.class.<Mod>getAnnotation(Mod.class)).version();
  }
  
  @Method(modid = "NotEnoughItems")
  public void loadConfig() {
    API.registerRecipeHandler((ICraftingHandler)new NEIHandlerMirrorWorkbench());
    API.registerUsageHandler((IUsageHandler)new NEIHandlerMirrorWorkbench());
    API.hideItem(new ItemStack(ModBlocks.frame));
    API.hideItem(new ItemStack(ModBlocks.frameAnim));
    API.hideItem(new ItemStack(ModBlocks.SkinWorkbench));
    API.hideItem(new ItemStack(ModBlocks.Workbench));
  }
}
