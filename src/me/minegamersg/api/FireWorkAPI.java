package me.minegamersg.api;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireWorkAPI {
	
	public static void spawnFireworks(Player paramPlayer, Location paramLocation)
	  {
	    Firework localFirework = (Firework)paramPlayer.getWorld().spawnEntity(paramLocation, EntityType.FIREWORK);
	    FireworkMeta localFireworkMeta = localFirework.getFireworkMeta();
	    
	    Random localRandom = new Random();
	    
	    int i = localRandom.nextInt(4) + 1;
	    FireworkEffect.Type localType = FireworkEffect.Type.BALL;
	    if (i == 1) {
	      localType = FireworkEffect.Type.BALL;
	    }
	    if (i == 2) {
	      localType = FireworkEffect.Type.BALL_LARGE;
	    }
	    if (i == 3) {
	      localType = FireworkEffect.Type.BURST;
	    }
	    if (i == 4) {
	      localType = FireworkEffect.Type.CREEPER;
	    }
	    if (i == 5) {
	      localType = FireworkEffect.Type.STAR;
	    }
	    int j = localRandom.nextInt(17) + 1;
	    int k = localRandom.nextInt(17) + 1;
	    Color localColor1 = getColor(j);
	    Color localColor2 = getColor(k);
	    
	    FireworkEffect localFireworkEffect = FireworkEffect.builder().flicker(localRandom.nextBoolean()).withColor(localColor1).withFade(localColor2).with(localType).trail(localRandom.nextBoolean()).build();
	    
	    localFireworkMeta.addEffect(localFireworkEffect);
	    
	    int m = localRandom.nextInt(2) + 1;
	    localFireworkMeta.setPower(m);
	    
	    localFirework.setFireworkMeta(localFireworkMeta);
	  }
	
	static private Color getColor(int paramInt)
	  {
	    Color localColor = null;
	    if (paramInt == 1) {
	      localColor = Color.AQUA;
	    }
	    if (paramInt == 2) {
	      localColor = Color.BLACK;
	    }
	    if (paramInt == 3) {
	      localColor = Color.BLUE;
	    }
	    if (paramInt == 4) {
	      localColor = Color.FUCHSIA;
	    }
	    if (paramInt == 5) {
	      localColor = Color.GRAY;
	    }
	    if (paramInt == 6) {
	      localColor = Color.GREEN;
	    }
	    if (paramInt == 7) {
	      localColor = Color.LIME;
	    }
	    if (paramInt == 8) {
	      localColor = Color.MAROON;
	    }
	    if (paramInt == 9) {
	      localColor = Color.NAVY;
	    }
	    if (paramInt == 10) {
	      localColor = Color.OLIVE;
	    }
	    if (paramInt == 11) {
	      localColor = Color.ORANGE;
	    }
	    if (paramInt == 12) {
	      localColor = Color.PURPLE;
	    }
	    if (paramInt == 13) {
	      localColor = Color.RED;
	    }
	    if (paramInt == 14) {
	      localColor = Color.SILVER;
	    }
	    if (paramInt == 15) {
	      localColor = Color.TEAL;
	    }
	    if (paramInt == 16) {
	      localColor = Color.WHITE;
	    }
	    if (paramInt == 17) {
	      localColor = Color.YELLOW;
	    }
	    return localColor;
	  }

}
