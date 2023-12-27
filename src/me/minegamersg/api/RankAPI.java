package me.minegamersg.api;

import java.sql.SQLException;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class RankAPI {
	
	public static void setRank(OfflinePlayer target, String rank) {
		if(target != null) {
			String selectrank = rank.toString().toUpperCase();
			try {
				MySQLAPI.updateRank((Player) target, selectrank);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			((Player) target).kickPlayer(MessageAPI.getServerPrefix() + "\n \n§c§lYour Rank Update to \n \n§7§l" + rank.toString().toUpperCase());
			
		}
	}

}
