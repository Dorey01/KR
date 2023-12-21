package alextm.client.gui.container;

import alextm.ModConfig;
import alextm.common.tileentity.TileEntityPicFrame;
import com.creativemd.creativecore.common.container.SubContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class SubContainerPicOPF extends SubContainer {
  public TileEntityPicFrame frame;
  
  public SubContainerPicOPF(TileEntityPicFrame frame, EntityPlayer player, boolean animation) {
    super(player);
    this.frame = frame;
  }
  
  public void createControls() {}
  
  public void onGuiPacket(int controlID, NBTTagCompound nbt, EntityPlayer player) {
    if (controlID == 0) {
      this.frame.url = nbt.func_74779_i("url");
      float x = nbt.func_74760_g("x");
      float y = nbt.func_74760_g("y");
      float x2 = Math.min(ModConfig.OnlinePictureMaxSize, Math.abs(x));
      float y2 = Math.min(ModConfig.OnlinePictureMaxSize, Math.abs(y));
      this.frame.sizeX = (x < 0.0F) ? -x2 : x2;
      this.frame.sizeY = (y < 0.0F) ? -y2 : y2;
      this.frame.renderDistance = nbt.func_74762_e("render");
      this.frame.posX = nbt.func_74771_c("posX");
      this.frame.posY = nbt.func_74771_c("posY");
      this.frame.rotation = nbt.func_74771_c("rotation");
      this.frame.visibleFrame = nbt.func_74767_n("visibleFrame");
      this.frame.anim = nbt.func_74767_n("anim");
      this.frame.flippedX = nbt.func_74767_n("flippedX");
      this.frame.flippedY = nbt.func_74767_n("flippedY");
      this.frame.updateBlock();
    } 
  }
}
