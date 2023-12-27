package me.minegamersg.listener;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MuteManager;
import me.minegamersg.api.MySQLAPI;

public class ChatListener implements Listener{
	

	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) throws SQLException {
		Player p = e.getPlayer();
		e.setCancelled(true);
		MuteManager.checkDuration(p.getUniqueId());
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(MuteManager.isMuted(p.getUniqueId())) {
				p.sendMessage(MessageAPI.getServerPrefix() + " §7You have been muted by server§8. §7TimeLeft§8: " + MuteManager.getTimeLeft(p.getUniqueId()) + " §7Reason§8: §c" + MuteManager.getReason(p.getUniqueId()) + "§8.");
			}else {
				all.sendMessage(p.getDisplayName() + "§8:§" + MySQLAPI.getChatColor(p) + " " + e.getMessage());	
				
			}
			
		}

	}
}
