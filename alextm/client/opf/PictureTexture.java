package alextm.client.opf;

public abstract class PictureTexture {
  public final int width;
  
  public final int height;
  
  public final boolean animation;
  
  public PictureTexture(int width, int height, boolean animation) {
    this.width = width;
    this.height = height;
    this.animation = animation;
  }
  
  public abstract void tick();
  
  public abstract int getTextureID();
}
