package alextm.client.renderer.item;

import alextm.client.model.skins.ModelSkythe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

@SideOnly(Side.CLIENT)
public class RenderDragonStuff {
  public static void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, int skinID, Object... data) {
    switch (skinID) {
      case 1:
        RenderScythe.renderSkin(type, item, data);
        break;
      case 2:
        RenderTenjiry.renderSkin(type, item, data);
        break;
      case 3:
        RenderShinju.renderSkin(type, item, data);
        break;
      case 4:
        RenderShikamaDodji.renderSkin(type, item, data);
        break;
      case 5:
        RenderVampireKiss.renderSkin(type, item, data);
        break;
      case 6:
        RenderVisMolot.renderSkin(type, item, data);
        break;
      case 7:
        RenderSunMolot.renderSkin(type, item, data);
        break;
      case 8:
        RenderIceMolot.renderSkin(type, item, data);
        break;
      case 9:
        RenderLiveMolot.renderSkin(type, item, data);
        break;
      case 10:
        RenderDarkMolot.renderSkin(type, item, data);
        break;
      case 11:
        RenderMoonLight.renderSkin(type, item, data);
        break;
    } 
  }
  
  private static ModelSkythe scytheModel = new ModelSkythe();
  
  private static ResourceLocation textureScythe = new ResourceLocation("alextm:model/skins/crescent_rose.png");
}
