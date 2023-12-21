package alextm.client.cache;

import alextm.client.opf.DownloadThread;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.client.Minecraft;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class TextureCache {
  private File cacheDirectory = new File((Minecraft.func_71410_x()).field_71412_D, "opframe_cache");
  
  private File index = new File(this.cacheDirectory, "index");
  
  private Map<String, CacheEntry> entries = new HashMap<>();
  
  public TextureCache() {
    if (!this.cacheDirectory.exists())
      this.cacheDirectory.mkdirs(); 
    loadIndex();
  }
  
  public void save(String url, String etag, long time, long expireTime, byte[] data) {
    CacheEntry entry = new CacheEntry(url, etag, time, expireTime);
    boolean saved = false;
    OutputStream out = null;
    try {
      out = new FileOutputStream(entry.getFile());
      out.write(data);
      saved = true;
    } catch (IOException e) {
      DownloadThread.LOGGER.error("Failed to save cache entry {}", new Object[] { e, url });
    } finally {
      IOUtils.closeQuietly(out);
    } 
    if (saved) {
      this.entries.put(url, entry);
      saveIndex();
    } 
  }
  
  public CacheEntry getEntry(String url) {
    return this.entries.get(url);
  }
  
  private void loadIndex() {
    if (this.index.exists()) {
      Map<String, CacheEntry> previousEntries = this.entries;
      this.entries = new HashMap<>();
      DataInputStream in = null;
      try {
        in = new DataInputStream(new GZIPInputStream(new FileInputStream(this.index)));
        for (int length = in.readInt(), i = 0; i < length; i++) {
          String url = in.readUTF();
          String etag = in.readUTF();
          long time = in.readLong();
          long expireTime = in.readLong();
          CacheEntry entry = new CacheEntry(url, (etag.length() > 0) ? etag : null, time, expireTime);
          this.entries.put(entry.getUrl(), entry);
        } 
      } catch (IOException e) {
        DownloadThread.LOGGER.error("Failed to load cache index", e);
        this.entries = previousEntries;
      } finally {
        IOUtils.closeQuietly(in);
      } 
    } 
  }
  
  private void saveIndex() {
    DataOutputStream out = null;
    try {
      out = new DataOutputStream(new GZIPOutputStream(new FileOutputStream(this.index)));
      out.writeInt(this.entries.size());
      for (Map.Entry<String, CacheEntry> mapEntry : this.entries.entrySet()) {
        CacheEntry entry = mapEntry.getValue();
        out.writeUTF(entry.getUrl());
        out.writeUTF((entry.getEtag() == null) ? "" : entry.getEtag());
        out.writeLong(entry.getTime());
        out.writeLong(entry.getExpireTime());
      } 
    } catch (IOException e) {
      DownloadThread.LOGGER.error("Failed to save cache index", e);
    } finally {
      IOUtils.closeQuietly(out);
    } 
  }
  
  public void deleteEntry(String url) {
    this.entries.remove(url);
    File file = getFile(url);
    if (file.exists())
      file.delete(); 
  }
  
  private static File getFile(String url) {
    return new File(DownloadThread.TEXTURE_CACHE.cacheDirectory, Base64.encodeBase64String(url.getBytes()));
  }
  
  public static class CacheEntry {
    private String url;
    
    private String etag;
    
    private long time;
    
    private long expireTime;
    
    public CacheEntry(String url, String etag, long time, long expireTime) {
      this.url = url;
      this.etag = etag;
      this.time = time;
      this.expireTime = expireTime;
    }
    
    public void setEtag(String etag) {
      this.etag = etag;
    }
    
    public void setTime(long time) {
      this.time = time;
    }
    
    public void setExpireTime(long expireTime) {
      this.expireTime = expireTime;
    }
    
    public String getUrl() {
      return this.url;
    }
    
    public String getEtag() {
      return this.etag;
    }
    
    public long getTime() {
      return this.time;
    }
    
    public long getExpireTime() {
      return this.expireTime;
    }
    
    public File getFile() {
      return TextureCache.getFile(this.url);
    }
  }
}
