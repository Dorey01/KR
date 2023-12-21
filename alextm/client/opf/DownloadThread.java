package alextm.client.opf;

import alextm.SkyHard;
import alextm.api.GifDecoder;
import alextm.client.cache.TextureCache;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SideOnly(Side.CLIENT)
public class DownloadThread extends Thread {
  public DownloadThread(String url) {
    this.url = url;
    synchronized (LOCK) {
      loadingImages.add(url);
      activeDownloads++;
    } 
    setName("OPF Download \"" + url + "\"");
    setDaemon(true);
    start();
  }
  
  public boolean hasFinished() {
    return this.complete;
  }
  
  public boolean hasFailed() {
    return (hasFinished() && this.error != null);
  }
  
  public String getError() {
    return this.error;
  }
  
  public void run() {
    Exception exception = null;
    try {
      byte[] data = load(this.url);
      String type = readType(data);
      ByteArrayInputStream in = null;
      try {
        in = new ByteArrayInputStream(data);
        if (type.equalsIgnoreCase("gif")) {
          GifDecoder gif = new GifDecoder();
          int status = gif.read(in);
          if (status == 0) {
            this.processedImage = new ProcessedImageData(gif);
          } else {
            LOGGER.error("Failed to read gif: {}", new Object[] { Integer.valueOf(status) });
          } 
        } else {
          try {
            BufferedImage image = ImageIO.read(in);
            if (image != null)
              this.processedImage = new ProcessedImageData(image); 
          } catch (IOException e1) {
            exception = e1;
            LOGGER.error("Failed to parse BufferedImage from stream", e1);
          } 
        } 
      } finally {
        IOUtils.closeQuietly(in);
      } 
    } catch (Exception e2) {
      exception = e2;
      LOGGER.error("An exception occurred while loading OPFrame image", e2);
    } 
    if (this.processedImage == null) {
      if (exception == null)
        this.error = "download.exception.gif"; 
      if (exception != null)
        if (exception.getMessage().startsWith("Server returned HTTP response code: 403")) {
          this.error = "download.exception.forbidden";
        } else if (exception.getMessage().startsWith("Server returned HTTP response code: 404")) {
          this.error = "download.exception.notfound";
        } else {
          this.error = "download.exception.invalid";
        }  
      TEXTURE_CACHE.deleteEntry(this.url);
    } 
    this.complete = true;
    synchronized (LOCK) {
      loadingImages.remove(this.url);
      activeDownloads--;
    } 
  }
  
  public static byte[] load(String url) throws IOException {
    TextureCache.CacheEntry entry = TEXTURE_CACHE.getEntry(url);
    long requestTime = System.currentTimeMillis();
    URLConnection connection = (new URL(url)).openConnection();
    connection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
    int responseCode = -1;
    if (connection instanceof HttpURLConnection) {
      HttpURLConnection httpConnection = (HttpURLConnection)connection;
      if (entry != null)
        if (entry.getEtag() != null) {
          httpConnection.setRequestProperty("If-None-Match", entry.getEtag());
        } else if (entry.getTime() != -1L) {
          httpConnection.setRequestProperty("If-Modified-Since", FORMAT.format(new Date(entry.getTime())));
        }  
      responseCode = httpConnection.getResponseCode();
    } 
    InputStream in = null;
    try {
      long lastModifiedTimestamp;
      in = connection.getInputStream();
      String etag = connection.getHeaderField("ETag");
      long expireTimestamp = -1L;
      String maxAge = connection.getHeaderField("max-age");
      if (maxAge != null && !maxAge.isEmpty())
        try {
          expireTimestamp = requestTime + Long.parseLong(maxAge) * 1000L;
        } catch (NumberFormatException e) {
          e.printStackTrace();
        }  
      String expires = connection.getHeaderField("Expires");
      if (expires != null && !expires.isEmpty())
        try {
          expireTimestamp = FORMAT.parse(expires).getTime();
        } catch (ParseException e2) {
          e2.printStackTrace();
        }  
      String lastModified = connection.getHeaderField("Last-Modified");
      if (lastModified != null && !lastModified.isEmpty()) {
        try {
          lastModifiedTimestamp = FORMAT.parse(lastModified).getTime();
        } catch (ParseException e3) {
          lastModifiedTimestamp = requestTime;
        } 
      } else {
        lastModifiedTimestamp = requestTime;
      } 
      if (entry != null) {
        if (etag != null && !etag.isEmpty())
          entry.setEtag(etag); 
        entry.setTime(lastModifiedTimestamp);
        if (responseCode == 304) {
          File file = entry.getFile();
          if (file.exists())
            return IOUtils.toByteArray(new FileInputStream(file)); 
        } 
      } 
      byte[] data = IOUtils.toByteArray(in);
      TEXTURE_CACHE.save(url, etag, lastModifiedTimestamp, expireTimestamp, data);
      return data;
    } finally {
      IOUtils.closeQuietly(in);
    } 
  }
  
  private static String readType(byte[] input) throws IOException {
    InputStream in = null;
    try {
      in = new ByteArrayInputStream(input);
      return readType(in);
    } finally {
      IOUtils.closeQuietly(in);
    } 
  }
  
  private static String readType(InputStream input) throws IOException {
    ImageInputStream stream = ImageIO.createImageInputStream(input);
    Iterator<ImageReader> iter = ImageIO.getImageReaders(stream);
    if (!iter.hasNext())
      return ""; 
    ImageReader reader = iter.next();
    if (reader.getFormatName().equalsIgnoreCase("gif"))
      return "gif"; 
    ImageReadParam param = reader.getDefaultReadParam();
    reader.setInput(stream, true, true);
    try {
      reader.read(0, param);
    } catch (IOException e) {
      LOGGER.error("Failed to parse input format", e);
    } finally {
      reader.dispose();
      IOUtils.closeQuietly(stream);
    } 
    input.reset();
    return reader.getFormatName();
  }
  
  public static PictureTexture loadImage(DownloadThread thread) {
    PictureTexture texture = null;
    if (!thread.hasFailed())
      if (thread.processedImage.isAnimated()) {
        texture = new AnimatedPictureTexture(thread.processedImage);
      } else {
        texture = new OrdinaryTexture(thread.processedImage);
      }  
    if (texture != null)
      synchronized (LOCK) {
        loadedImages.put(thread.url, texture);
      }  
    return texture;
  }
  
  public static final Logger LOGGER = LogManager.getLogger(SkyHard.class);
  
  public static final TextureCache TEXTURE_CACHE = new TextureCache();
  
  public static final DateFormat FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
  
  public static final Object LOCK = new Object();
  
  public static final int MAXIMUM_ACTIVE_DOWNLOADS = 5;
  
  public static int activeDownloads = 0;
  
  public static HashMap<String, PictureTexture> loadedImages = new HashMap<>();
  
  public static Set<String> loadingImages = new HashSet<>();
  
  private String url;
  
  private ProcessedImageData processedImage;
  
  private String error;
  
  private boolean complete;
}
