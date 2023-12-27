package me.minegamersg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropListener implements Listener{
	
	@EventHandler
	public void onItemDropEvent(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	

}
