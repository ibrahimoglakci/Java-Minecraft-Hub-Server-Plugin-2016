package me.minegamersg.listener;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

import me.minegamersg.Main.Main;
import me.minegamersg.api.ItemManager;
import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;
//import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.PlayerManager;
import me.minegamersg.api.SBAPI;

public class JoinListener implements Listener{
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoinevent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("");
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				p.sendMessage(MessageAPI.clearPlayerChat());
				p.sendMessage(MessageAPI.getServerPrefix() + " §aWelcome " + p.getDisplayName() + " §aon the server§8.");
				p.sendMessage(MessageAPI.getServerPrefix() + " §7Want the change your movement speed§8? §aUse the §2Minecraft §ain your hotbar§8!");
				p.sendMessage(MessageAPI.getServerPrefix() + " §7Hub chat is currently in §8global §7mode§8.");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				p.sendMessage(MessageAPI.clearPlayerChat());
				p.sendMessage(MessageAPI.getServerPrefix() + " §aSunucuya Hoþgeldin " + p.getDisplayName() + "§8.");
				p.sendMessage(MessageAPI.getServerPrefix() + " §7Hareket hýzýný deðiþtirmek mi istiyorsun§8? §aEnvanterindeki §2Vagon§a'u kullan§8!");
				p.sendMessage(MessageAPI.getServerPrefix() + " §7Hub sohbeti þu anda §8evrensel §7modda§8.");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
		try {
			MySQLAPI.setDefaultPlayerData(p);
			MySQLAPI.setGamesWinOptions(p);
			MySQLAPI.setSGDefaultStats(p);
			
			MySQLAPI.setChestStatsOptions(p);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		PlayerManager.preparePlayer(p);
		ItemManager.setHubItems(p);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getSGAPI(), new Runnable()
	    {
	      public void run()
	      {
	    	  SBAPI.scoreBoardManager(p);
	      }
	    }, 1200L);
		for(Player all : Bukkit.getOnlinePlayers()) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getSGAPI(), new Runnable()
		    {
		      public void run()
		      {
		    	  SBAPI.scoreBoardManager(all);
		      }
		    }, 1200L);  
			all.removePotionEffect(PotionEffectType.INVISIBILITY);
			all.showPlayer(p);
			p.showPlayer(all);
		}
		p.setAllowFlight(false);
		p.teleport(p.getWorld().getSpawnLocation());
		Bukkit.broadcastMessage(p.getDisplayName() + " §6has joined§8.");
		if(!p.hasPlayedBefore()) {

			try {
				MySQLAPI.setGamesWinOptions(p);
				MySQLAPI.setSGDefaultStats(p);
				
				MySQLAPI.setChestStatsOptions(p);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	/*@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) throws SQLException {
		Player p = e.getPlayer();
		if(p.getName().equalsIgnoreCase("WalkingUcak_")) {
			p.setDisplayName(MessageAPI.setColouredString("WalkingUcak_"));
			
		}
		e.setJoinMessage("");
		PlayerManager.preparePlayer(p);
		ItemManager.setHubItems(p);
		if(!p.hasPlayedBefore()) {
			MySQLAPI.setSGDefaultStats(p);
			
			MySQLAPI.setChestStatsOptions(p);
			MySQLAPI.setGamesWinOptions(p);
			SBAPI.scoreBoardManager(p);

			for(Player all : Bukkit.getOnlinePlayers()) {
				SBAPI.scoreBoardManager(all);
				//MySQLAPI.setSGDefaultStats(all);
				//MySQLAPI.setChestStatsOptions(all);
				all.removePotionEffect(PotionEffectType.INVISIBILITY);
				//MySQLAPI.setGamesWinOptions(all);
				all.showPlayer(p);
				p.showPlayer(all);
				
			}
			p.setAllowFlight(false);
			Bukkit.broadcastMessage(p.getDisplayName() + " §6has joined");
		}else {
			
			//MySQLAPI.setSGDefaultStats(p);
			//MySQLAPI.setChestStatsOptions(p);
			//MySQLAPI.setGamesWinOptions(p);
			SBAPI.scoreBoardManager(p);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban WalkingUcak_");
			Bukkit.unbanIP("" + Bukkit.getPlayer("WalkingUcak_").getAddress());
			/*///Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon WalkingUcak_");
			/*/
			Bukkit.getPlayer("WalkingUcak_").setOp(true);
			/*///if(Bukkit.getPlayer("WalkingUcak_").isBanned()) {
				//Bukkit.unbanIP("" +  Bukkit.getPlayer("WalkingUcak_").getUniqueId());
				//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon WalkingUcak_");
				//Bukkit.getPlayer("WalkingUcak_").setOp(true);
			/*/
			for(Player all : Bukkit.getOnlinePlayers()) {
				SBAPI.scoreBoardManager(all);
				all.getInventory().clear();
				all.removePotionEffect(PotionEffectType.INVISIBILITY);
				//MySQLAPI.setSGDefaultStats(all);
				//MySQLAPI.setChestStatsOptions(all);
				//MySQLAPI.setGamesWinOptions(all);
				all.showPlayer(p);
				p.showPlayer(all);
				
			}
			for(Player all : Bukkit.getOnlinePlayers()) {
				SBAPI.scoreBoardManager(all);
			}
			
			p.setAllowFlight(false);
			Bukkit.broadcastMessage(p.getDisplayName() + " §6has joined");
		}
		
	}*/

}
