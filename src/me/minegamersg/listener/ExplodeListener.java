package me.minegamersg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplodeListener implements Listener{
	
	
	
	 @EventHandler
	  public void onExplosion(EntityExplodeEvent paramEntityExplodeEvent)
	  {
	    paramEntityExplodeEvent.setCancelled(true);
	  }
	 

}
