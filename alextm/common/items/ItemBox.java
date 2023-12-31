package alextm.common.items;

import alextm.SkyHard;
import net.minecraft.item.ItemStack;

public class ItemBox {
  private ItemStack item;
  
  private int rarity;
  
  private int color;
  
  public ItemBox(ItemStack item, int rarity) {
    this.color = -1;
    this.item = item;
    this.rarity = rarity;
  }
  
  public ItemBox(ItemStack item, int rarity, int color) {
    this.color = -1;
    this.item = item;
    this.rarity = rarity;
    this.color = color;
  }
  
  public ItemStack getItemStack() {
    return this.item;
  }
  
  public String getText() {
    String text = SkyHard.resource("rarity.common");
    switch (this.rarity) {
      case 1:
        text = SkyHard.resource("rarity.uncommon");
        break;
      case 2:
        text = SkyHard.resource("rarity.rare");
        break;
      case 3:
        text = SkyHard.resource("rarity.epic");
        break;
      case 4:
        text = SkyHard.resource("rarity.legendary");
        break;
      case 5:
        text = SkyHard.resource("rarity.immortal");
        break;
    } 
    return text;
  }
  
  public int getTextColor() {
    int color = 0;
    switch ((this.color != -1) ? this.color : this.rarity) {
      case 0:
        color = 9539985;
        break;
      case 1:
        color = 3211008;
        break;
      case 2:
        color = 65520;
        break;
      case 3:
        color = 13369599;
        break;
      case 4:
        color = 16776960;
        break;
      case 5:
        color = 16711680;
        break;
    } 
    return color;
  }
  
  public int[] getRenderColor() {
    int[] Color = new int[2];
    switch ((this.color != -1) ? this.color : this.rarity) {
      case 0:
        Color[0] = 16777215;
        break;
      case 1:
        Color[0] = 16776960;
        Color[1] = 25600;
        break;
      case 2:
        Color[0] = 65535;
        Color[1] = 255;
        break;
      case 3:
        Color[0] = 16711935;
        Color[1] = 9109759;
        break;
      case 4:
        Color[0] = 16776960;
        Color[1] = 16711680;
        break;
      case 5:
        Color[0] = 16752640;
        Color[1] = 16711680;
        break;
    } 
    return Color;
  }
}
