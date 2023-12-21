package alextm.common.tileentity;

import alextm.client.opf.DownloadThread;
import alextm.client.opf.PictureTexture;
import alextm.client.renderer.tileentity.PicTileRenderer;
import com.creativemd.creativecore.common.tileentity.TileEntityCreative;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityPicFrame extends TileEntityCreative {
  @SideOnly(Side.CLIENT)
  public DownloadThread downloader;
  
  @SideOnly(Side.CLIENT)
  public PictureTexture texture;
  
  @SideOnly(Side.CLIENT)
  public boolean failed;
  
  public int renderDistance = 64;
  
  public String url = "";
  
  public float sizeX = 1.0F;
  
  public float sizeY = 1.0F;
  
  public boolean flippedX;
  
  public boolean flippedY;
  
  public float rotationX;
  
  public float rotationY;
  
  public byte rotation = 0;
  
  public byte posX = 0;
  
  public byte posY = 0;
  
  public boolean visibleFrame = true;
  
  public boolean anim = true;
  
  public float transparency = 1.0F;
  
  public float brightness = 1.0F;
  
  public TileEntityPicFrame() {
    if (FMLCommonHandler.instance().getSide().isClient())
      initClient(); 
  }
  
  @SideOnly(Side.CLIENT)
  public void initClient() {
    this.texture = null;
    this.failed = false;
  }
  
  @SideOnly(Side.CLIENT)
  public boolean shouldLoadTexture() {
    return (!isTextureLoaded() && !this.failed);
  }
  
  @SideOnly(Side.CLIENT)
  public void loadTexture() {
    if (shouldLoadTexture()) {
      if (this.downloader == null && DownloadThread.activeDownloads < 5) {
        PictureTexture loadedTexture = DownloadThread.loadedImages.get(this.url);
        if (loadedTexture == null) {
          synchronized (DownloadThread.LOCK) {
            if (!DownloadThread.loadingImages.contains(this.url)) {
              this.downloader = new DownloadThread(this.url);
              return;
            } 
          } 
        } else {
          this.texture = loadedTexture;
          PicTileRenderer pr = new PicTileRenderer();
          pr.func_147500_a((TileEntity)this, 0.0D, 0.0D, 0.0D, 0.0F);
        } 
      } 
      if (this.downloader != null && this.downloader.hasFinished()) {
        if (this.downloader.hasFailed()) {
          this.failed = true;
        } else {
          this.texture = DownloadThread.loadImage(this.downloader);
          PicTileRenderer pr2 = new PicTileRenderer();
          pr2.func_147500_a((TileEntity)this, 0.0D, 0.0D, 0.0D, 0.0F);
        } 
        this.downloader = null;
      } 
    } 
  }
  
  @SideOnly(Side.CLIENT)
  public boolean isTextureLoaded() {
    return (this.texture != null);
  }
  
  @SideOnly(Side.CLIENT)
  public double func_145833_n() {
    return Math.pow(this.renderDistance, 2.0D);
  }
  
  public AxisAlignedBB getBoundingBox() {
    loadTexture();
    if (this.texture != null)
      this.texture.tick(); 
    return INFINITE_EXTENT_AABB;
  }
  
  @SideOnly(Side.CLIENT)
  public AxisAlignedBB getRenderBoundingBox() {
    return getBoundingBox();
  }
  
  public void func_145841_b(NBTTagCompound nbt) {
    super.func_145841_b(nbt);
    nbt.func_74778_a("url", this.url);
    nbt.func_74776_a("sizeX", this.sizeX);
    nbt.func_74776_a("sizeY", this.sizeY);
    nbt.func_74768_a("render", this.renderDistance);
    nbt.func_74774_a("offsetX", this.posX);
    nbt.func_74774_a("offsetY", this.posY);
    nbt.func_74774_a("rotation", this.rotation);
    nbt.func_74757_a("visibleFrame", this.visibleFrame);
    nbt.func_74757_a("flippedX", this.flippedX);
    nbt.func_74757_a("flippedY", this.flippedY);
    nbt.func_74776_a("rotX", this.rotationX);
    nbt.func_74776_a("rotY", this.rotationY);
    nbt.func_74776_a("transparency", this.transparency);
    nbt.func_74776_a("brightness", this.brightness);
  }
  
  public void func_145839_a(NBTTagCompound nbt) {
    super.func_145839_a(nbt);
    this.url = nbt.func_74779_i("url");
    this.sizeX = nbt.func_74760_g("sizeX");
    this.sizeY = nbt.func_74760_g("sizeY");
    this.renderDistance = nbt.func_74762_e("render");
    this.posX = nbt.func_74771_c("offsetX");
    this.posY = nbt.func_74771_c("offsetY");
    this.rotation = nbt.func_74771_c("rotation");
    this.visibleFrame = nbt.func_74767_n("visibleFrame");
    this.flippedX = nbt.func_74767_n("flippedX");
    this.flippedY = nbt.func_74767_n("flippedY");
    this.rotationX = nbt.func_74760_g("rotX");
    this.rotationY = nbt.func_74760_g("rotY");
    if (nbt.func_74764_b("transparency")) {
      this.transparency = nbt.func_74760_g("transparency");
    } else {
      this.transparency = 1.0F;
    } 
    if (nbt.func_74764_b("brightness")) {
      this.brightness = nbt.func_74760_g("brightness");
    } else {
      this.brightness = 1.0F;
    } 
  }
  
  public void getDescriptionNBT(NBTTagCompound nbt) {
    super.getDescriptionNBT(nbt);
    nbt.func_74778_a("url", this.url);
    nbt.func_74776_a("sizeX", this.sizeX);
    nbt.func_74776_a("sizeY", this.sizeY);
    nbt.func_74768_a("render", this.renderDistance);
    nbt.func_74774_a("offsetX", this.posX);
    nbt.func_74774_a("offsetY", this.posY);
    nbt.func_74774_a("rotation", this.rotation);
    nbt.func_74757_a("visibleFrame", this.visibleFrame);
    nbt.func_74757_a("anim", this.anim);
    nbt.func_74757_a("flippedX", this.flippedX);
    nbt.func_74757_a("flippedY", this.flippedY);
    nbt.func_74776_a("rotX", this.rotationX);
    nbt.func_74776_a("rotY", this.rotationY);
    nbt.func_74776_a("transparency", this.transparency);
    nbt.func_74776_a("brightness", this.brightness);
  }
  
  @SideOnly(Side.CLIENT)
  public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
    super.onDataPacket(net, pkt);
    this.url = pkt.func_148857_g().func_74779_i("url");
    this.sizeX = pkt.func_148857_g().func_74760_g("sizeX");
    this.sizeY = pkt.func_148857_g().func_74760_g("sizeY");
    this.renderDistance = pkt.func_148857_g().func_74762_e("render");
    this.posX = pkt.func_148857_g().func_74771_c("offsetX");
    this.posY = pkt.func_148857_g().func_74771_c("offsetY");
    this.rotation = pkt.func_148857_g().func_74771_c("rotation");
    this.visibleFrame = pkt.func_148857_g().func_74767_n("visibleFrame");
    this.anim = pkt.func_148857_g().func_74767_n("anim");
    this.flippedX = pkt.func_148857_g().func_74767_n("flippedX");
    this.flippedY = pkt.func_148857_g().func_74767_n("flippedY");
    this.failed = false;
    loadTexture();
  }
}
