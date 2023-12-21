package alextm.client.handler;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class ResourceHandler {
  public static void bindTexture(ResourceLocation texture) {
    (Minecraft.func_71410_x()).field_71446_o.func_110577_a(texture);
  }
  
  public static ResourceLocation getResource(String rs) {
    if (!cachedResources.containsKey(rs))
      cachedResources.put(rs, new ResourceLocation("alextm:" + rs)); 
    return cachedResources.get(rs);
  }
  
  public static void bindResource(String rs) {
    bindTexture(getResource(rs));
  }
  
  private static Map<String, ResourceLocation> cachedResources = new HashMap<>();
}
