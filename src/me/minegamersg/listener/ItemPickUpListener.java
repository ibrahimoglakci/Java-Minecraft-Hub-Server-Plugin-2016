package me.minegamersg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemPickUpListener implements Listener{
	
	@EventHandler
	public void onItemPickUpEvent(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}

}
