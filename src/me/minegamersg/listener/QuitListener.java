package me.minegamersg.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.minegamersg.Main.Main;
import me.minegamersg.api.SBAPI;

public class QuitListener implements Listener{
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(p.getDisplayName() + " §6has left");
		Main.getSGAPI().Players.remove(p);
		for(Player all : Bukkit.getOnlinePlayers()) {
			SBAPI.scoreBoardManager(all);
		}
	}

}
