package me.minegamersg.api;

import org.bukkit.entity.Player;

public abstract interface NMS
{
  public static void sendTitle(Player paramPlayer, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2) {
	// TODO Auto-generated method stub
	
}
  
  public abstract void sendToPlayer(Player paramPlayer);
  
  public abstract void leavePlayer(Player paramPlayer);
  
  public abstract boolean is18();
  
}
