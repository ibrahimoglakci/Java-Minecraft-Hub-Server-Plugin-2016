package me.minegamersg.api;

import java.sql.SQLException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;

public class ItemManager {
	
	public static void setHubItems(Player p) {
		
		p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
		
		ItemStack compass = new ItemStack(Material.COMPASS);
	    ItemMeta cMeta = compass.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				cMeta.setDisplayName("§b§lQuick Teleport §8- §7Right click to teleport!");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				cMeta.setDisplayName("§b§lHýzlý Iþýnlanma §8- §7Sað týkla ve ýþýnlan!");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	    compass.setItemMeta(cMeta);

	    ItemStack watch = new ItemStack(Material.WATCH);
	    ItemMeta wMeta = watch.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				wMeta.setDisplayName("§d§lShow/Hide Players §8- §7Right click to show/hide player!");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				wMeta.setDisplayName("§d§l Oyuncularý Göster/Gizle §8- §7Sað týkla ve oyuncularý göster/gizle!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    watch.setItemMeta(wMeta);
	    
	    ItemStack minecrat = new ItemStack(Material.MINECART);
	    ItemMeta mMeta = minecrat.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				mMeta.setDisplayName("§1§lToggle Speed §8- §7Right click to change your walking speed!");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				mMeta.setDisplayName("§1§lHareket Hýzý §8- §7Sað týkla ve hareket hýzýný deðiþtir!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    minecrat.setItemMeta(mMeta);
	    
	    ItemStack language = new ItemStack(Material.REDSTONE_COMPARATOR);
	    ItemMeta languagem = language.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				languagem.setDisplayName("§c§lLanguage §8- §7Right click to change your language!");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				languagem.setDisplayName("§c§lDil §8- §7Sað týkla ve dilini deðiþtir!");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	    language.setItemMeta(languagem);
	    
	    ItemStack emerald = new ItemStack(Material.EMERALD);
	    ItemMeta eMeta = emerald.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				eMeta.setDisplayName("§a§lWebStore §8- §7Right click to go to the web store!");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				eMeta.setDisplayName("§a§lWeb Maðazasý §8- §7Sað týkla ve web maðazasýna git!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    emerald.setItemMeta(eMeta);
	    
	    
		ItemStack gold = new ItemStack(Material.GOLD_INGOT);
	    ItemMeta gMeta = gold.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				gMeta.setDisplayName("§e§lXemeGamer Tokens Shop §8- §7Right click to open the shop!");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				gMeta.setDisplayName("§e§lXemeGamer Jeton Maðazasý §8- §7Sað týkla ve maðazayý aç!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    gold.setItemMeta(gMeta);
	    
	    ItemStack star = new ItemStack(Material.NETHER_STAR);
	    ItemMeta sMeta = star.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				sMeta.setDisplayName("§c§lLobby Selector §8- §7Right click to switch lobbies!");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				sMeta.setDisplayName("§c§lLobi Seçici §8- §7Sað týkla ve lobi deðiþtir!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    star.setItemMeta(sMeta); 
	    
	    p.getInventory().clear();
	    
	    p.getInventory().setItem(0, compass);
	    p.getInventory().setItem(1, watch);
	    p.getInventory().setItem(2, minecrat);
	    p.getInventory().setItem(4, language);
	    p.getInventory().setItem(6, emerald);
	    p.getInventory().setItem(7, gold);
	    p.getInventory().setItem(8, star);
	    
	}

}
