package alextm.client.gui;

import alextm.common.tileentity.TileEntityPicFrame;
import com.creativemd.creativecore.common.gui.SubGui;
import com.creativemd.creativecore.common.gui.controls.GuiButton;
import com.creativemd.creativecore.common.gui.controls.GuiCheckBox;
import com.creativemd.creativecore.common.gui.controls.GuiLabel;
import com.creativemd.creativecore.common.gui.controls.GuiStateButton;
import com.creativemd.creativecore.common.gui.controls.GuiSteppedSlider;
import com.creativemd.creativecore.common.gui.controls.GuiTextfield;
import com.creativemd.creativecore.common.gui.event.ControlClickEvent;
import com.n247s.api.eventapi.eventsystem.CustomEventSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.nbt.NBTTagCompound;

@SideOnly(Side.CLIENT)
public class SubGuiPicOPF extends SubGui {
  public TileEntityPicFrame frame;
  
  private boolean anim;
  
  public SubGuiPicOPF(TileEntityPicFrame frame, boolean animation) {
    super(200, 200);
    this.frame = frame;
    this.anim = animation;
  }
  
  public void createControls() {
    GuiTextfield url = new GuiTextfield("url", this.frame.url, 5, 5, 164, 20);
    url.maxLength = 512;
    this.controls.add(url);
    this.controls.add((new GuiTextfield("sizeX", this.frame.sizeX + "", 5, 30, 40, 20)).setFloatOnly());
    this.controls.add((new GuiTextfield("sizeY", this.frame.sizeY + "", 50, 30, 40, 20)).setFloatOnly());
    this.controls.add(new GuiButton("reX", "x->y", 95, 30, 50));
    this.controls.add(new GuiButton("reY", "y->x", 145, 30, 50));
    this.controls.add(new GuiCheckBox("flipX", "flip (x-axis)", 5, 50, this.frame.flippedX));
    this.controls.add(new GuiCheckBox("flipY", "flip (y-axis)", 80, 50, this.frame.flippedY));
    this.controls.add(new GuiStateButton("posX", this.frame.posX, 5, 70, 70, 20, new String[] { "left (x)", "center (x)", "right (x)" }));
    this.controls.add(new GuiStateButton("posY", this.frame.posY, 80, 70, 70, 20, new String[] { "left (y)", "center (y)", "right (y)" }));
    this.controls.add(new GuiStateButton("rotation", this.frame.rotation, 5, 100, 80, 20, new String[] { "rotation: 0", "rotation: 1", "rotation: 2", "rotation: 3" }));
    this.controls.add(new GuiCheckBox("visibleFrame", "visible Frame", 90, 105, this.frame.visibleFrame));
    this.controls.add(new GuiLabel("render distance (blocks):", 5, 125));
    this.controls.add(new GuiSteppedSlider("renderDistance", 5, 140, 100, 20, 5, 128, this.frame.renderDistance));
    this.controls.add(new GuiButton("Save", 120, 140, 50));
  }
  
  @CustomEventSubscribe
  public void onClicked(ControlClickEvent event) {
    if (event.source.is("reX") || event.source.is("reY")) {
      GuiTextfield sizeXField = (GuiTextfield)getControl("sizeX");
      GuiTextfield sizeYField = (GuiTextfield)getControl("sizeY");
      float x = 1.0F;
      try {
        x = Float.parseFloat(sizeXField.text);
      } catch (Exception var19) {
        x = 1.0F;
      } 
      float y = 1.0F;
      try {
        y = Float.parseFloat(sizeYField.text);
      } catch (Exception var20) {
        y = 1.0F;
      } 
      if (this.frame.texture != null)
        if (event.source.is("reX")) {
          sizeYField.text = "" + (this.frame.texture.height / this.frame.texture.width / x);
        } else {
          sizeXField.text = "" + (this.frame.texture.width / this.frame.texture.height / y);
        }  
    } 
    if (event.source.is("Save")) {
      NBTTagCompound nbt = new NBTTagCompound();
      GuiTextfield sizeYField = (GuiTextfield)getControl("url");
      GuiTextfield sizeX = (GuiTextfield)getControl("sizeX");
      GuiTextfield sizeY = (GuiTextfield)getControl("sizeY");
      GuiStateButton buttonPosX = (GuiStateButton)getControl("posX");
      GuiStateButton buttonPosY = (GuiStateButton)getControl("posY");
      GuiStateButton rotation = (GuiStateButton)getControl("rotation");
      GuiCheckBox flipX = (GuiCheckBox)getControl("flipX");
      GuiCheckBox flipY = (GuiCheckBox)getControl("flipY");
      GuiCheckBox visibleFrame = (GuiCheckBox)getControl("visibleFrame");
      GuiSteppedSlider renderDistance = (GuiSteppedSlider)getControl("renderDistance");
      nbt.func_74774_a("posX", (byte)buttonPosX.getState());
      nbt.func_74774_a("posY", (byte)buttonPosY.getState());
      nbt.func_74774_a("rotation", (byte)rotation.getState());
      nbt.func_74757_a("flippedX", flipX.value);
      nbt.func_74757_a("flippedY", flipY.value);
      nbt.func_74757_a("visibleFrame", visibleFrame.value);
      nbt.func_74757_a("anim", this.anim);
      nbt.func_74768_a("render", (int)renderDistance.value);
      nbt.func_74778_a("url", sizeYField.text);
      float x2 = 1.0F;
      float y2 = 1.0F;
      try {
        x2 = Float.parseFloat(sizeX.text);
      } catch (Exception var21) {
        x2 = 1.0F;
      } 
      try {
        y2 = Float.parseFloat(sizeY.text);
      } catch (Exception var22) {
        y2 = 1.0F;
      } 
      nbt.func_74776_a("x", x2);
      nbt.func_74776_a("y", y2);
      sendPacketToServer(0, nbt);
    } 
  }
  
  public void drawOverlay(FontRenderer fontRenderer) {}
}
