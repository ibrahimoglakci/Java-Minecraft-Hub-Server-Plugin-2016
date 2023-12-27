package me.minegamersg.api;

import java.sql.SQLException;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.minegamersg.Main.Main;


public class PlayerManager {
	
	
	@SuppressWarnings("deprecation")
	public static void preparePlayer(Player paramPlayer)
	  {
		
	    paramPlayer.setFireTicks(0);
	    paramPlayer.setFoodLevel(20);
	    paramPlayer.setHealth(20);
	    paramPlayer.getInventory().clear();
	    paramPlayer.setGameMode(GameMode.ADVENTURE);
	    ItemStack air = new ItemStack(Material.AIR);
	    paramPlayer.getInventory().setHelmet(air);
	    paramPlayer.getInventory().setChestplate(air);
	    paramPlayer.getInventory().setLeggings(air);
	    paramPlayer.getInventory().setBoots(air);
	    paramPlayer.removePotionEffect(PotionEffectType.INVISIBILITY);
	    for (PotionEffect localPotionEffect : paramPlayer.getActivePotionEffects()) {
	      paramPlayer.removePotionEffect(localPotionEffect.getType());
	    }
	    paramPlayer.setLevel(Integer.valueOf(Main.getSGAPI().getConfig().getInt("Server-Name-Number")));
	    
		
	 

		try {
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("regular")) {
				paramPlayer.setDisplayName("§2" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§2" + paramPlayer.getName());
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("gold")) {
				paramPlayer.setDisplayName("§6" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§6" + paramPlayer.getName());
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("diamond")) {
				paramPlayer.setDisplayName("§3" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§3" + paramPlayer.getName());
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("platinum")) {
				paramPlayer.setDisplayName("§b" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§b" + paramPlayer.getName());
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("yt")) {
				paramPlayer.setDisplayName("§5" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§5" + paramPlayer.getName());
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("moderator")) {
				paramPlayer.setDisplayName("§c" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§c" + paramPlayer.getName());
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("builder")) {
				paramPlayer.setDisplayName("§d" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§d" + paramPlayer.getName());
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("dev")) {
				paramPlayer.setDisplayName(MessageAPI.setColouredString(paramPlayer.getName()));
				paramPlayer.setDisplayName(MessageAPI.setColouredString(paramPlayer.getName()));
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("leaddev")) {
				paramPlayer.setDisplayName(MessageAPI.setColouredString(paramPlayer.getName()));
				paramPlayer.setDisplayName(MessageAPI.setColouredString(paramPlayer.getName()));
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("admin")) {
				paramPlayer.setDisplayName("§4" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§4" + paramPlayer.getName());
			}
			if(MySQLAPI.getRank(paramPlayer).equalsIgnoreCase("Owner")) {
				paramPlayer.setDisplayName("§4§l" + paramPlayer.getName());
				paramPlayer.setPlayerListName("§4§l" + paramPlayer.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }

}
