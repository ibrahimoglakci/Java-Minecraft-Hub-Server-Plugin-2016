package me.minegamersg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class DamageListener implements Listener{
	
	@EventHandler
	public void acikma(FoodLevelChangeEvent e) {
		
			e.setCancelled(true);
		
		
		
	}

	
	@EventHandler
	public void onDamageEvent(EntityDamageEvent e) {
	
		 e.setCancelled(true);
		 
	if(e.getCause().equals(DamageCause.VOID)) {
		e.setCancelled(true);
		e.getEntity().teleport(e.getEntity().getWorld().getSpawnLocation());
	}
	}
	
	
	@EventHandler
	public void onPlayerHurt(EntityDamageByEntityEvent e) {
	    e.setCancelled(true);

	    
	}

}
