package me.minegamersg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

public class TabCompleteEvent implements Listener{
	
	
	
	@EventHandler
	public void onTabComlateEvent(PlayerChatTabCompleteEvent e) {
		
		
		if(e.getChatMessage().startsWith("/")) {
			e.getTabCompletions().clear();
		}
	}
	
	
	
	
	
	
}
