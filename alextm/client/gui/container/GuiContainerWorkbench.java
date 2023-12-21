package alextm.client.gui.container;

import alextm.SkyHard;
import alextm.common.container.ContainerWorkbench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiContainerWorkbench extends GuiContainer {
  private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation("alextm:textures/gui/mythical_work.png");
  
  private String customName;
  
  public void func_73866_w_() {
    super.func_73866_w_();
    this.field_146999_f = 176;
    this.field_147000_g = 184;
  }
  
  public GuiContainerWorkbench(InventoryPlayer player, World world, int x, int y, int z) {
    super(new ContainerWorkbench(player, world, x, y, z));
    this.customName = SkyHard.resource("tile.Workbench.name");
  }
  
  protected void func_146979_b(int par1, int par2) {
    this.field_146289_q.func_78276_b(this.customName, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(this.customName) / 2, -11, 4210752);
  }
  
  protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
    GL11.glPushMatrix();
    this.field_146297_k.func_110434_K().func_110577_a(craftingTableGuiTextures);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
    GL11.glPopMatrix();
  }
}
