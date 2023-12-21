package alextm.client.opf;

public class OrdinaryTexture extends PictureTexture {
  private final int textureID;
  
  public OrdinaryTexture(ProcessedImageData image) {
    super(image.getWidth(), image.getHeight(), false);
    this.textureID = image.uploadFrame(0);
  }
  
  public void tick() {}
  
  public int getTextureID() {
    return this.textureID;
  }
}
