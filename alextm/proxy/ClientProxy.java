package alextm.proxy;

import alextm.api.ItemRender;
import alextm.api.Meowmere_prog;
import alextm.client.model.skins.ModelMolot;
import alextm.client.model.skins.ModelShikamaDodji;
import alextm.client.model.skins.ModelShinju;
import alextm.client.model.skins.ModelSkythe;
import alextm.client.model.skins.ModelTenjiry;
import alextm.client.model.skins.ModelVampireKiss;
import alextm.client.renderer.BarrierBlockRendere;
import alextm.client.renderer.PicBlockRenderer;
import alextm.client.renderer.item.RenderArmor;
import alextm.client.renderer.item.RenderDarkMolot;
import alextm.client.renderer.item.RenderIceMolot;
import alextm.client.renderer.item.RenderItemSkinWorkbench;
import alextm.client.renderer.item.RenderLiveMolot;
import alextm.client.renderer.item.RenderMeowmere;
import alextm.client.renderer.item.RenderMoonLight;
import alextm.client.renderer.item.RenderScythe;
import alextm.client.renderer.item.RenderShikamaDodji;
import alextm.client.renderer.item.RenderShinju;
import alextm.client.renderer.item.RenderSunMolot;
import alextm.client.renderer.item.RenderTenjiry;
import alextm.client.renderer.item.RenderVampireKiss;
import alextm.client.renderer.item.RenderVisMolot;
import alextm.client.renderer.player.ArmorRenderer;
import alextm.client.renderer.tileentity.PicTileRenderer;
import alextm.client.renderer.tileentity.RenderSkinWorkbench;
import alextm.common.tileentity.TileEntityPicFrame;
import alextm.common.tileentity.TileSkinWorkbench;
import alextm.core.ModBlocks;
import alextm.core.ModItems;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Optional.Method;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
  public static int modelID;
  
  public static int modelID2;
  
  @Method(modid = "NotEnoughItems")
  public void registerNEIStuff() {}
  
  public void preInit(FMLPreInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(new ArmorRenderer());
  }
  
  public void postInit(FMLPostInitializationEvent event) {}
  
  public void registerRenderers() {
    RenderingRegistry.registerBlockHandler(modelID = RenderingRegistry.getNextAvailableRenderId(), new PicBlockRenderer());
    ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPicFrame.class, new PicTileRenderer());
    RenderingRegistry.registerBlockHandler(modelID2 = RenderingRegistry.getNextAvailableRenderId(), new BarrierBlockRendere());
    RenderMeowmere RenderMeowmere = new RenderMeowmere();
    GameRegistry.registerItem(RenderMeowmere, "RenderMeowmere");
    RenderingRegistry.registerEntityRenderingHandler(Meowmere_prog.class, (Render)new RenderSnowball(RenderMeowmere));
    MinecraftForgeClient.registerItemRenderer(ModItems.Smoke, new ItemRender());
    ClientRegistry.bindTileEntitySpecialRenderer(TileSkinWorkbench.class, new RenderSkinWorkbench());
    MinecraftForgeClient.registerItemRenderer(Item.func_150898_a(ModBlocks.SkinWorkbench), new RenderItemSkinWorkbench());
    MinecraftForgeClient.registerItemRenderer(ModItems.Crescent_rose_skin, new RenderScythe(new ModelSkythe(), new ResourceLocation("alextm:model/skins/crescent_rose.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.Tenjiry_skin, new RenderTenjiry(new ModelTenjiry(), new ResourceLocation("alextm:model/skins/tenjiry.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.Shinju_skin, new RenderShinju(new ModelShinju(), new ResourceLocation("alextm:model/skins/shinju.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.ShikamaDodji_skin, new RenderShikamaDodji(new ModelShikamaDodji(), new ResourceLocation("alextm:model/skins/shikama_dodji.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.VampireKiss_skin, new RenderVampireKiss(new ModelVampireKiss(), new ResourceLocation("alextm:model/skins/vampire_kiss.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.Vis_molot_skin, new RenderVisMolot(new ModelMolot(), new ResourceLocation("alextm:model/skins/vis_molot.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.Sun_molot_skin, new RenderSunMolot(new ModelMolot(), new ResourceLocation("alextm:model/skins/sun_molot.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.Ice_molot_skin, new RenderIceMolot(new ModelMolot(), new ResourceLocation("alextm:model/skins/ice_molot.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.Live_molot_skin, new RenderLiveMolot(new ModelMolot(), new ResourceLocation("alextm:model/skins/live_molot.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.Dark_molot_skin, new RenderDarkMolot(new ModelMolot(), new ResourceLocation("alextm:model/skins/dark_molot.png")));
    MinecraftForgeClient.registerItemRenderer(ModItems.Moon_light_skin, new RenderMoonLight(new ModelVampireKiss(), new ResourceLocation("alextm:model/skins/moon_light.png")));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_head_yellow, new RenderArmor(ModItems.Tron_head_yellow));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_chest_yellow, new RenderArmor(ModItems.Tron_chest_yellow));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_leggs_yellow, new RenderArmor(ModItems.Tron_leggs_yellow));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_boots_yellow, new RenderArmor(ModItems.Tron_boots_yellow));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_head_blue, new RenderArmor(ModItems.Tron_head_blue));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_chest_blue, new RenderArmor(ModItems.Tron_chest_blue));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_leggs_blue, new RenderArmor(ModItems.Tron_leggs_blue));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_boots_blue, new RenderArmor(ModItems.Tron_boots_blue));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_head_red, new RenderArmor(ModItems.Tron_head_red));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_chest_red, new RenderArmor(ModItems.Tron_chest_red));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_leggs_red, new RenderArmor(ModItems.Tron_leggs_red));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_boots_red, new RenderArmor(ModItems.Tron_boots_red));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_head_green, new RenderArmor(ModItems.Tron_head_green));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_chest_green, new RenderArmor(ModItems.Tron_chest_green));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_leggs_green, new RenderArmor(ModItems.Tron_leggs_green));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_boots_green, new RenderArmor(ModItems.Tron_boots_green));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_head_purple, new RenderArmor(ModItems.Tron_head_purple));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_chest_purple, new RenderArmor(ModItems.Tron_chest_purple));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_leggs_purple, new RenderArmor(ModItems.Tron_leggs_purple));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.Tron_boots_purple, new RenderArmor(ModItems.Tron_boots_purple));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.CrystalArmorHead, new RenderArmor(ModItems.CrystalArmorHead));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.CrystalArmorChest, new RenderArmor(ModItems.CrystalArmorChest));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.CrystalArmorLegs, new RenderArmor(ModItems.CrystalArmorLegs));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.CrystalArmorBoots, new RenderArmor(ModItems.CrystalArmorBoots));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.DevilArmorHead, new RenderArmor(ModItems.DevilArmorHead));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.DevilArmorChest, new RenderArmor(ModItems.DevilArmorChest));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.DevilArmorLegs, new RenderArmor(ModItems.DevilArmorLegs));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.DevilArmorBoots, new RenderArmor(ModItems.DevilArmorBoots));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.CreepArmorHead, new RenderArmor(ModItems.CreepArmorHead));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.CreepArmorChest, new RenderArmor(ModItems.CreepArmorChest));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.CreepArmorLegs, new RenderArmor(ModItems.CreepArmorLegs));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.CreepArmorBoots, new RenderArmor(ModItems.CreepArmorBoots));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.FairyArmorHead, new RenderArmor(ModItems.FairyArmorHead));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.FairyArmorChest, new RenderArmor(ModItems.FairyArmorChest));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.FairyArmorLegs, new RenderArmor(ModItems.FairyArmorLegs));
    MinecraftForgeClient.registerItemRenderer((Item)ModItems.FairyArmorBoots, new RenderArmor(ModItems.FairyArmorBoots));
  }
  
  public static String myName = Minecraft.func_71410_x().func_110432_I().func_111285_a();
}
