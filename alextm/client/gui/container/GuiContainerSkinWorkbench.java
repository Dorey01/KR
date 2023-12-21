package alextm.client.gui.container;

import alextm.SkyHard;
import alextm.common.container.ContainerSkinWorkbench;
import alextm.common.tileentity.TileSkinWorkbench;
import alextm.core.ModItems;
import alextm.network.NetworkHandler;
import alextm.network.PacketSkinWorkbench;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiContainerSkinWorkbench extends GuiContainer {
  public GuiContainerSkinWorkbench(InventoryPlayer inventory, TileSkinWorkbench tile) {
    super(new ContainerSkinWorkbench(inventory, tile));
    this.xSizeImage = 176;
    this.ySizeImage = 172;
    this.scrollPos = 0;
    this.selectSkin = -1;
    this.customName = SkyHard.resource("tile.SkinWorkbench.name");
    this.open = SkyHard.resource("skin_workbench.open");
    this.choose = SkyHard.resource("skin_workbench.choose");
    this.standart = SkyHard.resource("skin_workbench.standart");
    this.color1 = SkyHard.resource("skin_workbench.color1");
    this.color2 = SkyHard.resource("skin_workbench.color2");
    this.color3 = SkyHard.resource("skin_workbench.color3");
    this.color4 = SkyHard.resource("skin_workbench.color4");
    this.tile = tile;
  }
  
  public void func_73866_w_() {
    super.func_73866_w_();
    ModItems.AllSkins[0] = new ItemStack(ModItems.Meowmere);
    this.scrollPos = 0;
    int x = (this.field_146294_l - this.xSizeImage) / 2;
    int y = (this.field_146295_m - this.ySizeImage) / 2;
    this.field_146292_n.clear();
    this.field_146292_n.add(this.addButton = new GuiCustomButton(0, x + 7, y + 54, 0, 194, 62, 12, this.open));
    this.field_146292_n.add(this.selectButton = new GuiCustomButton(1, x + 7, y + 70, 0, 194, 62, 12, this.choose));
    this.field_146292_n.add(new GuiCustomButton(2, x + 75, y + 8, 0, 172, 86, 11, ""));
    this.field_146292_n.add(new GuiCustomButton(3, x + 75, y + 19, 0, 172, 86, 11, ""));
    this.field_146292_n.add(new GuiCustomButton(4, x + 75, y + 30, 0, 172, 86, 11, ""));
    this.field_146292_n.add(new GuiCustomButton(5, x + 75, y + 41, 0, 172, 86, 11, ""));
    this.field_146292_n.add(new GuiCustomButton(6, x + 75, y + 52, 0, 172, 86, 11, ""));
    this.field_146292_n.add(new GuiCustomButton(7, x + 75, y + 63, 0, 172, 86, 11, ""));
    this.field_146292_n.add(new GuiCustomButton(8, x + 75, y + 74, 0, 172, 86, 11, ""));
  }
  
  public void func_73876_c() {
    super.func_73876_c();
    ItemStack itemSlot0 = this.field_147002_h.func_75139_a(0).func_75211_c();
    ItemStack itemSlot2 = this.field_147002_h.func_75139_a(1).func_75211_c();
    if (itemSlot0 != null) {
      int[] copyFrom = itemSlot0.func_77978_p().func_74759_k("allSkins");
      if (!checkArray(copyFrom, 0)) {
        ItemStack result = new ItemStack(ModItems.Meowmere);
        result.func_77982_d((NBTTagCompound)itemSlot0.func_77978_p().func_74737_b());
        if (openSkin(result, result))
          NetworkHandler.network.sendToServer(new PacketSkinWorkbench(0, this.tile.field_145851_c, this.tile.field_145848_d, this.tile.field_145849_e, 0, "")); 
      } 
    } 
    if (itemSlot0 != null && itemSlot2 != null) {
      if (itemSlot0.func_77973_b() == ModItems.Meowmere && isSkinItem(itemSlot2)) {
        this.addButton.field_146124_l = true;
        this.addButton.field_146126_j = this.color1 + this.open;
      } else {
        this.addButton.field_146124_l = false;
        this.addButton.field_146126_j = this.color2 + this.open;
      } 
    } else {
      this.addButton.field_146124_l = false;
      this.addButton.field_146126_j = this.color2 + this.open;
    } 
    if (itemSlot0 != null) {
      int Skin = itemSlot0.func_77978_p().func_74762_e("Skin");
      if (this.selectSkin != -1 && this.selectSkin != Skin) {
        this.selectButton.field_146124_l = true;
        this.selectButton.field_146126_j = this.color1 + this.choose;
      } else {
        this.selectButton.field_146124_l = false;
        this.selectButton.field_146126_j = this.color2 + this.choose;
      } 
    } else {
      this.selectButton.field_146124_l = false;
      this.selectButton.field_146126_j = this.color2 + this.choose;
    } 
  }
  
  public boolean checkArray(int[] array, int n) {
    for (int value : array) {
      if (value == n)
        return true; 
    } 
    return false;
  }
  
  public void func_146274_d() {
    super.func_146274_d();
    int i = Mouse.getEventDWheel();
    int x = (this.field_146294_l - this.xSizeImage) / 2;
    int y = (this.field_146295_m - this.ySizeImage) / 2;
    int xMouse = Mouse.getEventX() * this.field_146294_l / this.field_146297_k.field_71443_c;
    int yMouse = this.field_146295_m - Mouse.getEventY() * this.field_146295_m / this.field_146297_k.field_71440_d - 1;
    boolean flag = (xMouse >= x + 75 && yMouse >= y + 8 && xMouse < x + 75 + 86 && yMouse < y + 85);
    if (flag && i != 0) {
      if (i > 0) {
        i = -1;
      } else {
        i = 1;
      } 
      this.scrollPos += i;
      if (this.scrollPos < 0)
        this.scrollPos = 0; 
      if (this.scrollPos > ModItems.AllSkins.length - 7)
        this.scrollPos = ModItems.AllSkins.length - 7; 
    } 
  }
  
  protected void drawListBox() {
    int x = (this.field_146294_l - this.xSizeImage) / 2;
    int y = (this.field_146295_m - this.ySizeImage) / 2;
    ItemStack itemSlot0 = this.field_147002_h.func_75139_a(0).func_75211_c();
    int[] copyFrom = itemSlot0.func_77978_p().func_74759_k("allSkins");
    if (ModItems.AllSkins.length > 7) {
      for (int i = 0; i < 7; i++) {
        String str;
        GuiButton buttonSkin = this.field_146292_n.get(2 + i);
        if (i + this.scrollPos == 0) {
          str = this.color1 + this.standart;
        } else {
          str = ModItems.AllSkins[i + this.scrollPos].func_82833_r();
        } 
        if (!checkArray(copyFrom, i + this.scrollPos)) {
          if (str.contains(this.color4))
            str = str.substring(2); 
          buttonSkin.field_146126_j = this.color3 + str;
        } else {
          buttonSkin.field_146126_j = str;
        } 
        buttonSkin.field_146125_m = true;
      } 
      this.field_146297_k.func_110434_K().func_110577_a(guiSkinWorkbench);
      GL11.glPushMatrix();
      func_73729_b(x + 162, y + 7 + 59 * this.scrollPos / (ModItems.AllSkins.length - 7), 0, 218, 6, 19);
      GL11.glPopMatrix();
    } 
  }
  
  protected void clearListBox() {
    for (int i = 0; i < 7; i++) {
      GuiButton buttonSkin = this.field_146292_n.get(2 + i);
      buttonSkin.field_146125_m = false;
    } 
  }
  
  protected boolean isSkinItem(ItemStack stack) {
    for (int i = 0; i < ModItems.AllSkins.length; i++) {
      String str1 = ModItems.AllSkins[i].func_77977_a();
      String str2 = stack.func_77977_a();
      if (str1.equals(str2))
        return true; 
    } 
    return false;
  }
  
  protected void func_146284_a(GuiButton button) {
    if (button.field_146127_k == 0) {
      ItemStack itemSlot0 = this.field_147002_h.func_75139_a(0).func_75211_c();
      ItemStack result = this.field_147002_h.func_75139_a(1).func_75211_c();
      ItemStack result2 = new ItemStack(ModItems.Meowmere);
      result2.func_77982_d((NBTTagCompound)itemSlot0.func_77978_p().func_74737_b());
      if (openSkin(result2, result))
        NetworkHandler.network.sendToServer(new PacketSkinWorkbench(1, this.tile.field_145851_c, this.tile.field_145848_d, this.tile.field_145849_e, -1, "")); 
    } else if (button.field_146127_k == 1) {
      ItemStack itemSlot0 = this.field_147002_h.func_75139_a(0).func_75211_c();
      ItemStack result = new ItemStack(ModItems.Meowmere);
      result.func_77982_d((NBTTagCompound)itemSlot0.func_77978_p().func_74737_b());
      setSkin(result, this.selectSkin);
      this.field_147002_h.func_75139_a(0).func_75215_d(result);
      String name = ModItems.AllSkins[this.selectSkin].func_82833_r();
      result.func_151001_c(name);
      NetworkHandler.network.sendToServer(new PacketSkinWorkbench(2, this.tile.field_145851_c, this.tile.field_145848_d, this.tile.field_145849_e, this.selectSkin, name));
    } else if (button.field_146127_k >= 2 && button.field_146127_k <= 8) {
      ItemStack itemSlot0 = this.field_147002_h.func_75139_a(0).func_75211_c();
      int[] copyFrom = itemSlot0.func_77978_p().func_74759_k("allSkins");
      int sel = button.field_146127_k - 2 + this.scrollPos;
      if (checkArray(copyFrom, sel)) {
        this.selectSkin = sel;
      } else {
        this.selectSkin = -1;
      } 
    } 
  }
  
  public static void setSkin(ItemStack itemstack, int skinID) {
    if (!itemstack.func_77942_o())
      itemstack.func_77982_d(new NBTTagCompound()); 
    itemstack.func_77978_p().func_74768_a("Skin", skinID);
  }
  
  public static boolean openSkin(ItemStack itemstack, ItemStack skin) {
    if (!itemstack.func_77942_o())
      itemstack.func_77982_d(new NBTTagCompound()); 
    int[] copyFrom = itemstack.func_77978_p().func_74759_k("allSkins");
    int[] copyTo = new int[copyFrom.length + 1];
    int skinID;
    for (skinID = 0; skinID < copyFrom.length; skinID++)
      copyTo[skinID] = copyFrom[skinID]; 
    skinID = -1;
    for (int i = 0; i < ModItems.AllSkins.length; i++) {
      String str1 = ModItems.AllSkins[i].func_77977_a();
      String str2 = skin.func_77977_a();
      if (str1.equals(str2)) {
        skinID = i;
        break;
      } 
    } 
    boolean haveSkin = false;
    for (int value : copyFrom) {
      if (value == skinID) {
        haveSkin = true;
        break;
      } 
    } 
    if (!haveSkin) {
      copyTo[copyTo.length - 1] = skinID;
      itemstack.func_77978_p().func_74783_a("allSkins", copyTo);
      return true;
    } 
    return false;
  }
  
  protected void func_146979_b(int x, int y) {
    this.field_146289_q.func_78276_b(this.customName, this.field_146999_f / 2 - this.field_146289_q.func_78256_a(this.customName) / 2, -13, 4210752);
    if (this.selectSkin == -1) {
      this.field_146297_k.func_110434_K().func_110577_a(guiSkinWorkbench);
      func_73729_b(37, 13, 86, 172, 22, 22);
    } else {
      GL11.glPushMatrix();
      float scale = 2.0F;
      GL11.glTranslatef(32.0F, 8.0F, 0.0F);
      GL11.glScalef(2.0F, 2.0F, 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ItemStack renderItem = ModItems.AllSkins[this.selectSkin];
      (new RenderItem()).func_82406_b(this.field_146289_q, Minecraft.func_71410_x().func_110434_K(), renderItem, 0, 0);
      GL11.glPopMatrix();
    } 
  }
  
  protected void func_146976_a(float partialTick, int mouseX, int mouseY) {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.field_146297_k.func_110434_K().func_110577_a(guiSkinWorkbench);
    int x = (this.field_146294_l - this.xSizeImage) / 2;
    int y = (this.field_146295_m - this.ySizeImage) / 2;
    func_73729_b(x, y, 0, 0, this.xSizeImage, this.ySizeImage);
    ItemStack itemSlot0 = this.field_147002_h.func_75139_a(0).func_75211_c();
    if (itemSlot0 != null) {
      drawListBox();
    } else {
      clearListBox();
      this.selectSkin = -1;
    } 
  }
  
  private static final ResourceLocation guiSkinWorkbench = new ResourceLocation("alextm:textures/gui/skin_workbench.png");
  
  private TileSkinWorkbench tile;
  
  private GuiButton addButton;
  
  private GuiButton selectButton;
  
  private int xSizeImage;
  
  private int ySizeImage;
  
  private int scrollPos;
  
  private int selectSkin;
  
  private String customName;
  
  private String open;
  
  private String choose;
  
  private String standart;
  
  private String color1;
  
  private String color2;
  
  private String color3;
  
  private String color4;
  
  @SideOnly(Side.CLIENT)
  public class GuiCustomButton extends GuiButton {
    private int xImage;
    
    private int yImage;
    
    public GuiCustomButton(int buttonID, int xPos, int yPos, int xImage, int yImage, int wImage, int hImage, String buttonText) {
      super(buttonID, xPos, yPos, wImage, hImage, buttonText);
      this.xImage = xImage;
      this.yImage = yImage;
    }
    
    public void func_146112_a(Minecraft mc, int x, int y) {
      if (this.field_146125_m) {
        mc.func_110434_K().func_110577_a(GuiContainerSkinWorkbench.guiSkinWorkbench);
        boolean flag = (x >= this.field_146128_h && y >= this.field_146129_i && x < this.field_146128_h + this.field_146120_f && y < this.field_146129_i + this.field_146121_g);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        int offset = 0;
        if (flag && this.field_146124_l)
          offset = this.field_146121_g; 
        func_73729_b(this.field_146128_h, this.field_146129_i, this.xImage, this.yImage + offset, this.field_146120_f, this.field_146121_g);
        func_73732_a(GuiContainerSkinWorkbench.this.field_146289_q, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, 14737632);
      } 
    }
  }
}
