package alextm.core;

import alextm.common.blocks.BlockPicFrame;
import alextm.common.blocks.BlockSkinWorkbench;
import alextm.common.blocks.BlockWorkbench;
import alextm.common.blocks.BlocksCloth;
import alextm.common.blocks.BlocksIron;
import net.minecraft.block.Block;

public class ModBlocks {
  public static void registerBlocks() {
    SkinWorkbench = (Block)new BlockSkinWorkbench("SkinWorkbench");
    Workbench = new BlockWorkbench("table", "alextm:work");
    anime = (new BlocksCloth("anime", "alextm:anime/anime")).func_149715_a(1.0F);
    anime1 = (new BlocksCloth("anime1", "alextm:anime/anime1")).func_149715_a(1.0F);
    anime2 = (new BlocksCloth("anime2", "alextm:anime/anime2")).func_149715_a(1.0F);
    anime3 = (new BlocksCloth("anime3", "alextm:anime/anime3")).func_149715_a(1.0F);
    anime4 = (new BlocksCloth("anime4", "alextm:anime/anime4")).func_149715_a(1.0F);
    anime5 = (new BlocksCloth("anime5", "alextm:anime/anime5")).func_149715_a(1.0F);
    anime6 = (new BlocksCloth("anime6", "alextm:anime/anime6")).func_149715_a(1.0F);
    anime7 = (new BlocksCloth("anime7", "alextm:anime/anime7")).func_149715_a(1.0F);
    XpTier = (new BlocksIron("XpTier", "alextm:XPtier/XPtier", 5)).func_149715_a(1.0F);
    SpeedTigel = new BlocksIron("SpeedTigel", "alextm:SpeedTigel/SpeedTigel", 3);
  }
  
  public static Block frame = (Block)new BlockPicFrame("opFrame", false);
  
  public static Block SkinWorkbench;
  
  public static Block Workbench;
  
  public static Block frameAnim = (Block)new BlockPicFrame("opFrameAnim", true);
  
  public static Block anime;
  
  public static Block anime1;
  
  public static Block anime2;
  
  public static Block anime3;
  
  public static Block anime4;
  
  public static Block anime5;
  
  public static Block anime6;
  
  public static Block anime7;
  
  public static Block XpTier;
  
  public static Block SpeedTigel;
}
