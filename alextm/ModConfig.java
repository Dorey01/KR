package alextm;

import java.io.File;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.config.Configuration;

public class ModConfig {
  public static void registerConfig(String configDir) {
    registerConfig(configDir, null);
  }
  
  public static void registerConfig(String configDir, EntityPlayerMP player) {
    String configName = "SkyHard.cfg";
    Configuration config = new Configuration(new File(configDir + "SkyHard.cfg"));
    try {
      config.load();
      OreGenerator = config.getBoolean("OreGenerator", "General", OreGenerator, CommentOreGenerator);
      OnlinePictureMaxSize = config.getFloat("OnlinePictureMaxSize", "General", OnlinePictureMaxSize, 0.0F, 32.0F, CommentOnlinePicture);
      ArmorStatus = config.getBoolean("ArmorStatus", "ArmorStatus", ArmorStatus, CommentArmorStatus);
      HpAndHungerBar = config.getBoolean("HpAndHungerBar", "ArmorStatus", HpAndHungerBar, CommentArmorStatus2);
      ArmorStatusMaxDistance = config.getInt("ArmorStatusMaxDistance", "ArmorStatus", ArmorStatusMaxDistance, 1, 128, CommentArmorStatus3);
      KeepInventory = config.getString("keepInventory", "Antidrop", KeepInventory, CommentSaveInv);
      ExpSave = config.getString("ExpSave", "Antidrop", ExpSave, CommentSaveExp);
      if (player != null)
        player.func_145747_a((IChatComponent)new ChatComponentText(ReloadGood.replace("%configName%", "SkyHard.cfg"))); 
    } catch (Exception exception) {
      if (player == null) {
        System.out.println(ReloadBad.replace("%configName%", "SkyHard.cfg"));
      } else {
        player.func_145747_a((IChatComponent)new ChatComponentText(ReloadBadPlayer.replace("%configName%", "SkyHard.cfg")));
      } 
    } finally {
      config.save();
    } 
  }
  
  public static float OnlinePictureMaxSize = 32.0F;
  
  public static boolean ArmorStatus = true;
  
  public static boolean HpAndHungerBar = true;
  
  public static boolean OreGenerator = true;
  
  public static int ArmorStatusMaxDistance = 24;
  
  public static String KeepInventory = "strangermind.invsave";
  
  public static String ExpSave = "strangermind.expsave";
  
  public static String SaveInvMessage = SkyHard.resource("saveinvmessage");
  
  public static String SaveExpMessage = SkyHard.resource("saveexpmessage");
  
  public static String CommentOnlinePicture = SkyHard.resource("comment_op");
  
  public static String CommentArmorStatus = SkyHard.resource("comment_as");
  
  public static String CommentArmorStatus2 = SkyHard.resource("comment_as2");
  
  public static String CommentArmorStatus3 = SkyHard.resource("comment_as3");
  
  public static String CommentSaveInv = SkyHard.resource("comment_si");
  
  public static String CommentSaveExp = SkyHard.resource("comment_se");
  
  public static String ReloadGood = SkyHard.resource("reloadgood");
  
  public static String ReloadBad = SkyHard.resource("reloadbad");
  
  public static String ReloadBadPlayer = SkyHard.resource("reloadbadplayer");
  
  public static String CommentOreGenerator = SkyHard.resource("oregenerator");
}
