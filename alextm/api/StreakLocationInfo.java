package alextm.api;

import net.minecraft.entity.player.EntityPlayer;

public class StreakLocationInfo {
  public double posX;
  
  public double posY;
  
  public double posZ;
  
  public float renderYawOffset;
  
  public float rotationYawHead;
  
  public float rotationPitch;
  
  public float limbSwing;
  
  public float limbSwingAmount;
  
  public boolean isSprinting;
  
  public long lastTick;
  
  public float height;
  
  public double startU;
  
  public StreakLocationInfo(EntityPlayer player) {
    update(player);
  }
  
  public void update(EntityPlayer player) {
    this.posX = player.field_70165_t;
    this.posY = player.field_70121_D.field_72338_b;
    this.posZ = player.field_70161_v;
    this.renderYawOffset = player.field_70761_aq;
    this.rotationYawHead = player.field_70759_as;
    this.rotationPitch = player.field_70125_A;
    this.limbSwing = player.field_70754_ba;
    this.limbSwingAmount = player.field_70721_aZ;
    this.isSprinting = player.func_70051_ag();
    this.lastTick = player.field_70170_p.func_72820_D();
    this.height = player.field_70131_O;
  }
  
  public boolean hasSameCoords(StreakLocationInfo info) {
    return (info.posX == this.posX && info.posY == this.posY && info.posZ == this.posZ && info.height == this.height);
  }
}
