package me.minegamersg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MotdListener implements Listener{
	
	
	@EventHandler
	public void setMotd(ServerListPingEvent e) {
		e.setMotd("§7[§eXemeGamer§7] §b§lOpen Beta \n §6Join us on discord§8: §3discord.gg/xemegamer");
		
	}

}
