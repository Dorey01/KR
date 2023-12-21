package alextm.api;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Meowmere_prog extends EntityThrowable {
  public Meowmere_prog(World par1World) {
    super(par1World);
  }
  
  public Meowmere_prog(World par1World, EntityLivingBase par2EntityLivingBase) {
    super(par1World, par2EntityLivingBase);
  }
  
  public Meowmere_prog(World par1World, double par2, double par4, double par6) {
    super(par1World, par2, par4, par6);
  }
  
  protected void func_70184_a(MovingObjectPosition par1MovingObjectPosition) {
    if (!this.field_70170_p.field_72995_K) {
      Random rand = new Random();
      for (int i = 0; i <= rand.nextInt(1) + 2; i++) {
        ItemStack firework = randomFirework();
        this.field_70170_p.func_72838_d((Entity)new EntityFireworkRocket(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, firework));
      } 
    } 
    func_70106_y();
  }
  
  public static ItemStack randomFirework() {
    Random rand = new Random();
    Firework firework = new Firework();
    switch (rand.nextInt(3)) {
      case 0:
        firework.setFlicker();
        break;
      case 1:
        firework.setTrail();
        break;
    } 
    int type = rand.nextInt(5);
    if (type != 3) {
      firework.setType(type);
    } else {
      firework.setType(1);
    } 
    for (int i = 0; i <= rand.nextInt(6); i++) {
      Color randomColor = getRandomColor();
      firework.addColor(randomColor.getRed(), randomColor.getGreen(), randomColor.getBlue());
    } 
    return firework.getStack();
  }
  
  public static Color getRandomColor() {
    return new Color(Color.HSBtoRGB(rand.nextFloat() * 360.0F, rand.nextFloat() * 0.15F + 0.8F, 0.85F));
  }
  
  private static Random rand = new Random();
  
  public enum FireworkType {
    BALL("BALL", 0, "BALL", 0),
    LARGE_BALL("LARGE_BALL", 1, "LARGE_BALL", 1),
    STAR("STAR", 2, "STAR", 2),
    CREEPER("CREEPER", 3, "CREEPER", 3),
    BURST("BURST", 4, "BURST", 4);
    
    private static final FireworkType[] $VALUES = new FireworkType[] { BALL, LARGE_BALL, STAR, CREEPER, BURST };
    
    private static final FireworkType[] $VALUES$ = new FireworkType[] { BALL, LARGE_BALL, STAR, CREEPER, BURST };
    
    static {
    
    }
  }
  
  public static class Firework {
    int flight = 0;
    
    boolean flicker = false;
    
    boolean trail = false;
    
    ArrayList<Integer> colors = new ArrayList<>();
    
    Meowmere_prog.FireworkType type = Meowmere_prog.FireworkType.BALL;
    
    public Firework setFlight(int duration) {
      if (duration >= 0 && duration <= 3)
        this.flight = duration; 
      return this;
    }
    
    public void setFlicker() {
      this.flicker = true;
    }
    
    public void setTrail() {
      this.trail = true;
    }
    
    public Firework setType(Meowmere_prog.FireworkType type) {
      this.type = type;
      return this;
    }
    
    public void setType(int type) {
      if (type >= 0 && type <= 4)
        this.type = Meowmere_prog.FireworkType.values()[type]; 
    }
    
    public void addColor(int red, int green, int blue) {
      this.colors.add(Integer.valueOf((red << 16) + (green << 8) + blue));
    }
    
    private NBTTagCompound getTags() {
      NBTTagCompound explosionTag = new NBTTagCompound();
      explosionTag.func_74757_a("Flicker", this.flicker);
      explosionTag.func_74757_a("Trail", this.trail);
      explosionTag.func_74774_a("Type", (byte)this.type.ordinal());
      int[] intArray = new int[this.colors.size()];
      for (int i = 0; i < this.colors.size(); i++)
        intArray[i] = ((Integer)this.colors.get(i)).intValue(); 
      explosionTag.func_74783_a("Colors", intArray);
      return explosionTag;
    }
    
    public ItemStack getStack() {
      NBTTagCompound tags = new NBTTagCompound();
      NBTTagCompound fireworksTag = new NBTTagCompound();
      NBTTagList explosionsList = new NBTTagList();
      explosionsList.func_74742_a((NBTBase)getTags());
      fireworksTag.func_74774_a("Flight", (byte)-10);
      fireworksTag.func_74782_a("Explosions", (NBTBase)explosionsList);
      tags.func_74782_a("Fireworks", (NBTBase)fireworksTag);
      ItemStack stack = new ItemStack(Items.field_151152_bP);
      stack.func_77982_d(tags);
      return stack;
    }
  }
}
