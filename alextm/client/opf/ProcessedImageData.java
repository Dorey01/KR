package alextm.client.opf;

import alextm.api.GifDecoder;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ProcessedImageData {
  private final int width;
  
  private final int height;
  
  private final Frame[] frames;
  
  private final long[] delay;
  
  private final long duration;
  
  public ProcessedImageData(BufferedImage image) {
    this.width = image.getWidth();
    this.height = image.getHeight();
    this.frames = new Frame[] { loadFrom(image) };
    this.delay = new long[] { 0L };
    this.duration = 0L;
  }
  
  public ProcessedImageData(GifDecoder decoder) {
    Dimension frameSize = decoder.getFrameSize();
    this.width = (int)frameSize.getWidth();
    this.height = (int)frameSize.getHeight();
    this.frames = new Frame[decoder.getFrameCount()];
    this.delay = new long[decoder.getFrameCount()];
    long time = 0L;
    for (int i = 0; i < decoder.getFrameCount(); i++) {
      this.frames[i] = loadFrom(decoder.getFrame(i));
      this.delay[i] = time;
      time += decoder.getDelay(i);
    } 
    this.duration = time;
  }
  
  public int getWidth() {
    return this.width;
  }
  
  public int getHeight() {
    return this.height;
  }
  
  public long[] getDelay() {
    return this.delay;
  }
  
  public long getDuration() {
    return this.duration;
  }
  
  public boolean isAnimated() {
    return (this.frames.length > 1);
  }
  
  public int getFrameCount() {
    return this.frames.length;
  }
  
  public int uploadFrame(int index) {
    if (index >= 0 && index < this.frames.length) {
      Frame frame = this.frames[index];
      if (frame != null) {
        this.frames[index] = null;
        return uploadFrame(frame.buffer, frame.hasAlpha, this.width, this.height);
      } 
    } 
    return -1;
  }
  
  private static int uploadFrame(ByteBuffer buffer, boolean hasAlpha, int width, int height) {
    int textureID = GL11.glGenTextures();
    GL11.glBindTexture(3553, textureID);
    GL11.glTexParameteri(3553, 10242, 33071);
    GL11.glTexParameteri(3553, 10243, 33071);
    GL11.glTexParameteri(3553, 10241, 9729);
    GL11.glTexParameteri(3553, 10240, 9729);
    if (!hasAlpha)
      GL11.glPixelStorei(3317, 1); 
    GL11.glTexImage2D(3553, 0, hasAlpha ? 32856 : 32849, width, height, 0, hasAlpha ? 6408 : 6407, 5121, buffer);
    return textureID;
  }
  
  private static Frame loadFrom(BufferedImage image) {
    int width = image.getWidth();
    int height = image.getHeight();
    int[] pixels = new int[width * height];
    image.getRGB(0, 0, width, height, pixels, 0, width);
    boolean hasAlpha = false;
    if (image.getColorModel().hasAlpha())
      for (int pixel : pixels) {
        if ((pixel >> 24 & 0xFF) < 255) {
          hasAlpha = true;
          break;
        } 
      }  
    int bytesPerPixel = hasAlpha ? 4 : 3;
    ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bytesPerPixel);
    for (int pixel2 : pixels) {
      buffer.put((byte)(pixel2 >> 16 & 0xFF));
      buffer.put((byte)(pixel2 >> 8 & 0xFF));
      buffer.put((byte)(pixel2 & 0xFF));
      if (hasAlpha)
        buffer.put((byte)(pixel2 >> 24 & 0xFF)); 
    } 
    buffer.flip();
    return new Frame(buffer, hasAlpha);
  }
  
  private static class Frame {
    private final ByteBuffer buffer;
    
    private final boolean hasAlpha;
    
    public Frame(ByteBuffer buffer, boolean alpha) {
      this.buffer = buffer;
      this.hasAlpha = alpha;
    }
  }
}
