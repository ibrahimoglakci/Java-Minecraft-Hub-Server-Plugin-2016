package me.minegamersg.listener;

import java.sql.SQLException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.minegamersg.api.ConnectServer;
import me.minegamersg.api.ItemManager;
import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;

public class InventoryClickListener implements Listener{
	
	
	@EventHandler
	public void onweatherChange(WeatherChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void itemClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(player.getItemInHand().getType() == Material.REDSTONE_COMPARATOR) {
			if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lLanguage §8- §7Right click to change your language!") || player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§c§lDil §8- §7Sağ tıkla ve dilini değiştir!")){
				 if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
					 event.setCancelled(true);
					 openLanguageInv(player);
				 }
			}
		}
		 if(player.getItemInHand().getType() == Material.COMPASS) {
			 if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lQuick Teleport §8- §7Right click to teleport!") || player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lHızlı Işınlanma §8- §7Sağ tıkla ve ışınlan!")){
				 if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
					 event.setCancelled(true);
					 openSelectorInv(player);
				 }
			 }
		 }
		 if(player.getItemInHand().getType() == Material.GOLD_INGOT) {
			 if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lXemeGamer Tokens Shop §8- §7Right click to open the shop!") || player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lXemeGamer Jeton Mağazası §8- §7Sağ tıkla ve mağazayı aç!")){
				 if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
					 event.setCancelled(true);
					 openShopInv(player);
				 }
			 }
		 }
		 if(player.getItemInHand().getType() == Material.MINECART) {
			 if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§1§lToggle Speed §8- §7Right click to change your walking speed!") || player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§1§lHareket Hızı §8- §7Sağ tıkla ve hareket hızını değiştir!")){
				 if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
					 event.setCancelled(true);
					 PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 9999999, 2);
					 try {
						if(MySQLAPI.getLanguage(player).equalsIgnoreCase("English")) {
							 if(!player.hasPotionEffect(PotionEffectType.SPEED)) {
								 player.addPotionEffect(speed);
								 player.sendMessage(MessageAPI.getServerPrefix() + " §fMovement speed set to speedly.");
							 }else {
								 player.removePotionEffect(PotionEffectType.SPEED);
								 player.sendMessage(MessageAPI.getServerPrefix() + " §fMovement speed set to normal.");
							 }
						 }else if(MySQLAPI.getLanguage(player).equalsIgnoreCase("Turkish")) {
							 if(!player.hasPotionEffect(PotionEffectType.SPEED)) {
								 player.addPotionEffect(speed);
								 player.sendMessage(MessageAPI.getServerPrefix() + " §fHareket hızın, hızlı olarak ayarlandı.");
							 }else {
								 player.removePotionEffect(PotionEffectType.SPEED);
								 player.sendMessage(MessageAPI.getServerPrefix() + " §fHareket hızın, normal olarak ayarlandı.");
							 }
						 }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
			 }
		 }
					
	}
	
	
	@EventHandler
	public void inventoryClick(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
	    ItemStack clicked = event.getCurrentItem();
	    Inventory inventory = event.getInventory();
	    if(clicked.getType() == Material.STAINED_GLASS_PANE) {
	    	event.setCancelled(true);
	    }
	    if (inventory.getName().equalsIgnoreCase("§bSurvival Games.")){
	    	if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§aSG 1453")) {
				event.setCancelled(true);
				ConnectServer.connectServer(player, "EU-1453");
				try {
					if(MySQLAPI.getLanguage(player).equalsIgnoreCase("English")) {
						player.sendMessage("§8[§3Xeme§8] §fConnecting you to §2EU-1453 §6(SG)§f...");
					}else if(MySQLAPI.getLanguage(player).equalsIgnoreCase("Turkish")) {
						player.sendMessage("§8[§3Xeme§8] §fBağlandığın sunucu §2EU-1453 §6(SG)§f...");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    }
	    
	    if (inventory.getName().equalsIgnoreCase("§6§lOptions §7§l» §c§lLanguage") || inventory.getName().equalsIgnoreCase("§6§lAyarlar §7§l» §c§lDil")){
	    	if(clicked.getType() == Material.BOOK) {
	    		if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lEnglish (EN)") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lİngilizce (EN)")) {
	    			event.setCancelled(true);
	    			try {
						if(MySQLAPI.getLanguage(player).equalsIgnoreCase("English")) {
							player.sendMessage(MessageAPI.getServerPrefix() + " §4Your language is already §a§lENGLISH§c!");
							player.closeInventory();
						
						}else if(MySQLAPI.getLanguage(player).equalsIgnoreCase("Turkish")) {
							MySQLAPI.updateLanguage(player, "English");
							player.sendMessage(MessageAPI.getServerPrefix() + " §7(EN) §bYour language succesfully changed to §a§lENGLISH§b!");
							player.sendMessage("\n \n" + MessageAPI.getServerPrefix() + " §7(TR) §bDilin başarıyla §a§lİNGİLİZCE §bolarak değiştirildi§b!");
							player.closeInventory();
							ItemManager.setHubItems(player);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    			
					
	    		if(clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lTurkish (TR)") || clicked.getItemMeta().getDisplayName().equalsIgnoreCase("§c§lTürkçe (TR)")) {
	    			event.setCancelled(true);
	    			event.setCancelled(true);
	    			try {
						if(MySQLAPI.getLanguage(player).equalsIgnoreCase("Turkish")) {
							player.sendMessage(MessageAPI.getServerPrefix() + " §4Senin dilin zaten §c§lTURKÇE§c!");
							player.closeInventory();
						
						}else if(MySQLAPI.getLanguage(player).equalsIgnoreCase("English")) {
							MySQLAPI.updateLanguage(player, "Turkish");
							player.sendMessage(MessageAPI.getServerPrefix() + " §7(EN) §bYour language succesfully changed to §c§lTURKISH§b!");
							player.sendMessage("\n \n" + MessageAPI.getServerPrefix() + " §7(TR) §bDilin başarıyla §c§lTURKÇE §bolarak değiştirildi§b!");
							player.closeInventory();
							ItemManager.setHubItems(player);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    	}
	    }
	    
	    if (inventory.getName().equalsIgnoreCase("§8XemeGamer Network Navigation") || inventory.getName().equalsIgnoreCase("§8XemeGamer Network Navigasyon")){
	    	if(clicked.getType() == Material.BOW) {
				event.setCancelled(true);
				openSGMenu(player);
				//ConnectServer.connectServer(player, "SG1453");
			}
	    }
	    
		if (inventory.getName().equalsIgnoreCase("§8XemeGamer Credits Shop") || inventory.getName().equalsIgnoreCase("§8XemeGamer Kredi Mağazası")){
			if(clicked.getType() == Material.SADDLE) {
				event.setCancelled(true);
				openPetsInv(player);
			}
		    if (clicked.getType() == Material.EXP_BOTTLE) {
		    	event.setCancelled(true);
		    	player.closeInventory();
		    	openEffectInv(player);
		    }
		    if (clicked.getType() == Material.REDSTONE_BLOCK) {
		    	event.setCancelled(true);
		    	player.closeInventory();
		    }
		}
		if (inventory.getName().equalsIgnoreCase("§a§lCosmetics §8» §6§lEffects") || inventory.getName().equalsIgnoreCase("§a§lKozmetik §8» §6§lEfektler")){
			if (clicked.getType() == Material.ARROW) {
				event.setCancelled(true);
				openShopInv(player);
			}
		}
		if (inventory.getName().equalsIgnoreCase("§8Pets.") || inventory.getName().equalsIgnoreCase("§8Evcil Hayvanlar.")){
			if (clicked.getType() == Material.ARROW) {
				event.setCancelled(true);
				openShopInv(player);
			}
		}
	}
	
	static String languagename = "";
	public static void openLanguageInv(Player p) {
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				languagename = "§6§lOptions §7§l» §c§lLanguage";
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				languagename= "§6§lAyarlar §7§l» §c§lDil";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Inventory languageinv = Bukkit.createInventory(null, 54, languagename);
		
		ItemStack en = new ItemStack(Material.BOOK);
		ItemMeta enm = en.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				enm.setDisplayName("§a§lEnglish (EN)");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				enm.setDisplayName("§a§lİngilizce (EN)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> enLore = new ArrayList<String>();
		enLore.add("");
		enm.setLore(enLore);
		en.setItemMeta(enm);
		languageinv.setItem(3, en);
		
		ItemStack tr = new ItemStack(Material.BOOK);
		ItemMeta trm = en.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				trm.setDisplayName("§c§lTurkish (TR)");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				trm.setDisplayName("§c§lTürkçe (TR)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> trLore = new ArrayList<String>();
		trLore.add("");
		trm.setLore(trLore);
		tr.setItemMeta(trm);
		languageinv.setItem(5, tr);
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				ItemStack encam = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encamm = encam.getItemMeta();
			    encamm.setDisplayName("§e ");
			    ArrayList<String> encamLore = new ArrayList<String>();
			    encamLore.add("");
			    encamm.setLore(encamLore);
			    encam.setItemMeta(encamm);
			    languageinv.setItem(9, encam);
			    
			    ItemStack encam2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encamm2 = encam2.getItemMeta();
			    encamm2.setDisplayName("§e ");
			    encamm2.setLore(encamLore);
			    encam2.setItemMeta(encamm2);
			    languageinv.setItem(10, encam2);
			    
			    ItemStack encam3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam3m = encam3.getItemMeta();
			    encam3m.setDisplayName("§e ");
			    encam3m.setLore(encamLore);
			    encam3.setItemMeta(encam3m);
			    languageinv.setItem(11, encam3);
			    
			    ItemStack encam4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam4m = encam4.getItemMeta();
			    encam4m.setDisplayName("§e ");
			    encam4m.setLore(encamLore);
			    encam4.setItemMeta(encam4m);
			    languageinv.setItem(18, encam4);
			    
			    ItemStack encam5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam5m = encam5.getItemMeta();
			    encam5m.setDisplayName("§e ");
			    encam5m.setLore(encamLore);
			    encam5.setItemMeta(encam5m);
			    languageinv.setItem(27, encam5);
			    
			    ItemStack encam6 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam6m = encam6.getItemMeta();
			    encam6m.setDisplayName("§e ");
			    encam6m.setLore(encamLore);
			    encam6.setItemMeta(encam6m);
			    languageinv.setItem(28, encam6);
			    
			    ItemStack encam7 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam7m = encam7.getItemMeta();
			    encam7m.setDisplayName("§e ");
			    encam7m.setLore(encamLore);
			    encam7.setItemMeta(encam7m);
			    languageinv.setItem(29, encam7);
			    
			    ItemStack encam8 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam8m = encam8.getItemMeta();
			    encam8m.setDisplayName("§e ");
			    encam8m.setLore(encamLore);
			    encam8.setItemMeta(encam8m);
			    languageinv.setItem(36, encam8);
			    
			    ItemStack encam9 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam9m = encam9.getItemMeta();
			    encam9m.setDisplayName("§e ");
			    encam9m.setLore(encamLore);
			    encam9.setItemMeta(encam9m);
			    languageinv.setItem(45, encam9);
			    
			    ItemStack encam10 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam10m = encam10.getItemMeta();
			    encam10m.setDisplayName("§e ");
			    encam10m.setLore(encamLore);
			    encam10.setItemMeta(encam10m);
			    languageinv.setItem(46, encam10);
			    
			    ItemStack encam11 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam11m = encam11.getItemMeta();
			    encam11m.setDisplayName("§e ");
			    encam11m.setLore(encamLore);
			    encam11.setItemMeta(encam11m);
			    languageinv.setItem(47, encam11);
		
			    
			    
			    ItemStack encam13 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam13m = encam13.getItemMeta();
			    encam13m.setDisplayName("§e ");
			    ArrayList<String> encam13Lore = new ArrayList<String>();
			    encam13m.setLore(encamLore);
			    encam13.setItemMeta(encam13m);
			    languageinv.setItem(13, encam13);
			    
			    ItemStack encam14 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam14m = encam14.getItemMeta();
			    encam14m.setDisplayName("§e ");
			    ArrayList<String> encam14Lore = new ArrayList<String>();
			    encam14Lore.add("");
			    encam14m.setLore(encam14Lore);
			    encam14.setItemMeta(encam14m);
			    languageinv.setItem(22, encam14);
			    
			    ItemStack encam15 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam15m = encam15.getItemMeta();
			    encam15m.setDisplayName("§e ");
			    encam15m.setLore(encam13Lore);
			    encam15.setItemMeta(encam15m);
			    languageinv.setItem(31, encam15);
			    
			    ItemStack encam16 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam16m = encam16.getItemMeta();
			    encam16m.setDisplayName("§e ");
			    encam16m.setLore(encam13Lore);
			    encam16.setItemMeta(encam16m);
			    languageinv.setItem(40, encam16);
			    
			    ItemStack encam17 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam17m = encam17.getItemMeta();
			    encam17m.setDisplayName("§e ");
			    encam17m.setLore(encam13Lore);
			    encam17.setItemMeta(encam17m);
			    languageinv.setItem(23, encam17);
			    
			    ItemStack encam18 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam18m = encam18.getItemMeta();
			    encam18m.setDisplayName("§e ");
			    encam18m.setLore(encam13Lore);
			    encam18.setItemMeta(encam18m);
			    languageinv.setItem(33, encam18);
			    
			    ItemStack encam19 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam19m = encam19.getItemMeta();
			    encam19m.setDisplayName("§e ");
			    encam19m.setLore(encam13Lore);
			    encam19.setItemMeta(encam19m);
			    languageinv.setItem(43, encam19);
			    
			    ItemStack encam20 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam20m = encam20.getItemMeta();
			    encam20m.setDisplayName("§e ");
			    encam20m.setLore(encam13Lore);
			    encam20.setItemMeta(encam20m);
			    languageinv.setItem(53, encam20);
			    
			    
			    ItemStack encam22 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam22m = encam22.getItemMeta();
			    encam22m.setDisplayName("§e ");
			    encam22m.setLore(encam13Lore);
			    encam22.setItemMeta(encam22m);
			    languageinv.setItem(35, encam22);
			    
			    ItemStack encam23 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam23m = encam23.getItemMeta();
			    encam23m.setDisplayName("§e ");
			    encam23m.setLore(encam13Lore);
			    encam23.setItemMeta(encam23m);
			    languageinv.setItem(26, encam23);
			    
			    ItemStack encam24 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam24m = encam24.getItemMeta();
			    encam24m.setDisplayName("§e ");
			    encam24m.setLore(encam13Lore);
			    encam24.setItemMeta(encam24m);
			    languageinv.setItem(17, encam24);
			    
			    ItemStack encam21 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam21m = encam21.getItemMeta();
			    encam21m.setDisplayName("§e ");
			    encam21m.setLore(encam13Lore);
			    encam21.setItemMeta(encam21m);
			    languageinv.setItem(49, encam24);
			    
			    ItemStack encam25 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta encam25m = encam25.getItemMeta();
			    encam25m.setDisplayName("§e ");
			    encam25m.setLore(encam13Lore);
			    encam25.setItemMeta(encam25m);
			    languageinv.setItem(44, encam25);
		    
			
			 //TR Yazan Camlar
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				ItemStack trcam = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 13);
			    ItemMeta trcamm = trcam.getItemMeta();
			    trcamm.setDisplayName("§e ");
			    ArrayList<String> trcamLore = new ArrayList<String>();
			    trcamLore.add("");
			    trcamm.setLore(trLore);
			    trcam.setItemMeta(trcamm);
			    languageinv.setItem(18, trcam);
 
			    languageinv.setItem(18, trcam);
			    languageinv.setItem(19, trcam);
			    languageinv.setItem(20, trcam);
			    languageinv.setItem(28, trcam);
			    languageinv.setItem(37, trcam);
			    languageinv.setItem(46, trcam);
			    languageinv.setItem(23, trcam);
			    languageinv.setItem(24, trcam);
			    languageinv.setItem(25, trcam);
			    languageinv.setItem(32, trcam);
			    languageinv.setItem(41, trcam);
			    languageinv.setItem(50, trcam);
			    languageinv.setItem(34, trcam);
			    languageinv.setItem(42, trcam);
			    languageinv.setItem(52, trcam);
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.openInventory(languageinv);
	    
	}

	
	public static void openSGMenu(Player p) {
		Inventory sg = Bukkit.createInventory(null, 54, "§bSurvival Games.");
		
		ItemStack sg1 = new ItemStack(Material.BOW);
		ItemMeta sg1m = sg1.getItemMeta();
		sg1m.setDisplayName("§aSurvival Games");
		ArrayList<String> sg1Lore = new ArrayList<String>();
		sg1Lore.add("");
		sg1m.setLore(sg1Lore);
		sg1.setItemMeta(sg1m);
		sg.setItem(3, sg1);
		
		ItemStack sg2 = new ItemStack(Material.BOW);
		ItemMeta sg2m = sg2.getItemMeta();
		sg1m.setDisplayName("§aSurvival Games");
		ArrayList<String> sg2Lore = new ArrayList<String>();
		sg2Lore.add("");
		sg2m.setLore(sg2Lore);
		sg2.setItemMeta(sg2m);
		sg.setItem(5, sg2);
		ItemStack gm = new ItemStack(Material.SKULL_ITEM,1, (byte) 3);
		ItemMeta gmm = gm.getItemMeta();
		
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				sg1m.setDisplayName("§bGame Menu");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				sg1m.setDisplayName("§bOyun Menüsü");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> gmLore = new ArrayList<String>();
		gmLore.add("");
		gmm.setLore(gmLore);
		gm.setItemMeta(gmm);
		sg.setItem(4, gm);
		
		try {
			int onlinesg1453 = MySQLAPI.getPlayingPlayers("SG-1453");
			if(MySQLAPI.getCurrentState("SG-1453").equalsIgnoreCase("Lobby")) {
				ItemStack sg1453 = new ItemStack(Material.STAINED_CLAY, onlinesg1453, (byte) 5);
				ItemMeta sg1453m = sg1453.getItemMeta();
				sg1453m.setDisplayName("§aSG 1453");
				ArrayList<String> sg1453Lore = new ArrayList<String>();
				sg1453Lore.add("§cPlayers:§f " + onlinesg1453 + "§f/24");
				sg1453Lore.add("§cStatus:§a Lobby");
				sg1453m.setLore(sg1453Lore);
				sg1453.setItemMeta(sg1453m);
				//sg1453.setAmount(onlinesg);
				sg.setItem(9, sg1453);
			}else {
				ItemStack sg1453 = new ItemStack(Material.STAINED_CLAY, onlinesg1453, (byte) 14);
				ItemMeta sg1453m = sg1453.getItemMeta();
				sg1453m.setDisplayName("§aSG 1453");
				ArrayList<String> sg1453Lore = new ArrayList<String>();
				sg1453Lore.add("§cPlayers:§f " + onlinesg1453 + "§f/24");
				sg1453Lore.add("§7Status:§c " + MySQLAPI.getCurrentState("SG-1453"));
				sg1453m.setLore(sg1453Lore);
				sg1453.setItemMeta(sg1453m);
				//sg1453.setAmount(onlinesg);
				sg.setItem(53, sg1453);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		p.openInventory(sg);
		
	}
	
	
	static String petsname = "";
	public static void openPetsInv(Player p) {
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				petsname = "§8Pets.";
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				petsname= "§8Evcil Hayvanlar.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Inventory petsinv = Bukkit.createInventory(null, 54, petsname);
		
		ItemStack back = new ItemStack(Material.ARROW);
		ItemMeta backm = back.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				backm.setDisplayName("§8Go Back");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				backm.setDisplayName("§8Geriye Dön");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> backLore = new ArrayList<String>();
		backLore.add("");
		backm.setLore(backLore);
		back.setItemMeta(backm);
		petsinv.setItem(45, back);
	    ItemStack fns = new ItemStack(Material.MONSTER_EGG, 1, (byte) 50);
	    ItemMeta fnsm = fns.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				fnsm.setDisplayName("§aBomber Creeper");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				fnsm.setDisplayName("§aBombacı Creeper");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> fnsLore = new ArrayList<String>();
	    fnsLore.add("");
	    fnsm.setLore(fnsLore);
	    fns.setItemMeta(fnsm);
	    petsinv.setItem(4, fns);
	    ItemStack apple = new ItemStack(Material.MONSTER_EGG, 1, (byte) 51);
	    ItemMeta applem = apple.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				applem.setDisplayName("§fShooter Skeleton");
			}else 	if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				applem.setDisplayName("§fOkçu İskelet");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> appleLore = new ArrayList<String>();
	    appleLore.add("");
	    applem.setLore(appleLore);
	    apple.setItemMeta(applem);
	    petsinv.setItem(20, apple);
	    ItemStack reddust = new ItemStack(Material.MONSTER_EGG, 1, (byte) 52);
	    ItemMeta reddustm = reddust.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				reddustm.setDisplayName("§cSpiderMan");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				reddustm.setDisplayName("§cÖrümcek Adam");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> reddustLore = new ArrayList<String>();
	    reddustLore.add("");
	    reddustm.setLore(reddustLore);
	    reddust.setItemMeta(reddustm);
	    petsinv.setItem(22, reddust);
	    ItemStack emerald = new ItemStack(Material.MONSTER_EGG, 1, (byte) 54);
	    ItemMeta emeraldm = emerald.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				emeraldm.setDisplayName("§2Brain Hunter");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				emeraldm.setDisplayName("§2Beyin Avcısı");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> emeraldLore = new ArrayList<String>();
	    emeraldLore.add("");
	    emeraldm.setLore(emeraldLore);
	    emerald.setItemMeta(emeraldm);
	    petsinv.setItem(24, emerald);
	    ItemStack smoke = new ItemStack(Material.MONSTER_EGG, 1, (byte) 55);
	    ItemMeta smokem = smoke.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				smokem.setDisplayName("§aSweet Slime");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				smokem.setDisplayName("§aSevimli Slime");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> smokeLore = new ArrayList<String>();
	    smokeLore.add("");
	    smokem.setLore(smokeLore);
	    smoke.setItemMeta(smokem);
	    petsinv.setItem(37, smoke);
	    ItemStack lava = new ItemStack(Material.MONSTER_EGG, 1, (byte) 65);
	    ItemMeta lavam = lava.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				lavam.setDisplayName("§0Batman");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				lavam.setDisplayName("§0Yarasa adam");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> lavaLore = new ArrayList<String>();
	    lavaLore.add("");
	    lavam.setLore(lavaLore);
	    lava.setItemMeta(lavam);
	    petsinv.setItem(39, lava);
	    ItemStack explode = new ItemStack(Material.MONSTER_EGG, 1, (byte) 90);
	    ItemMeta explodem = explode.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				explodem.setDisplayName("§dPinky Pig");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				explodem.setDisplayName("§dPembe Domuz");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> explodeLore = new ArrayList<String>();
	    explodeLore.add("");
	    explodem.setLore(explodeLore);
	    explode.setItemMeta(explodem);
	    petsinv.setItem(41, explode);
	    ItemStack firework = new ItemStack(Material.MONSTER_EGG, 1, (byte) 92);
	    ItemMeta fireworkm = firework.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				fireworkm.setDisplayName("§7Milker Cow");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				fireworkm.setDisplayName("§7Sütçü İnek");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> fireworkLore = new ArrayList<String>();
	    fireworkLore.add("");
	    fireworkm.setLore(fireworkLore);
	    firework.setItemMeta(fireworkm);
	    petsinv.setItem(43, firework);
	    ItemStack crit = new ItemStack(Material.MONSTER_EGG, 1, (byte) 95);
	    ItemMeta critm = crit.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				critm.setDisplayName("§8Smart Wolf");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				critm.setDisplayName("§8Akıllı Kurt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> critLore = new ArrayList<String>();
	    critLore.add("");
	    critm.setLore(critLore);
	    crit.setItemMeta(critm);
	    petsinv.setItem(49, crit);
	    ItemStack cloud = new ItemStack(Material.MONSTER_EGG, 1, (byte) 100);
	    ItemMeta cloudm = cloud.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				cloudm.setDisplayName("§cSpeedy Horse");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				cloudm.setDisplayName("§cKoşucu At");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> cloudLore = new ArrayList<String>();
	    cloudLore.add("");
	    cloudm.setLore(cloudLore);
	    cloud.setItemMeta(cloudm);
	    petsinv.setItem(0, cloud);
	    ItemStack music = new ItemStack(Material.MONSTER_EGG, 1, (byte) 93);
	    ItemMeta musicm = music.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				musicm.setDisplayName("§fFunky Chicken");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				musicm.setDisplayName("§fKorkak Tavuk");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> musicLore = new ArrayList<String>();
	    musicLore.add("");
	    musicm.setLore(musicLore);
	    music.setItemMeta(musicm);
	    petsinv.setItem(8, music);
	    ItemStack close = new ItemStack(Material.REDSTONE_BLOCK);
	    ItemMeta closem = close.getItemMeta();
	    try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				closem.setDisplayName("§4§lClear Pets");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				closem.setDisplayName("§4Hayvanları Temizle");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> closeLore = new ArrayList<String>();
	    closeLore.add("");
	    closem.setLore(closeLore);
	    close.setItemMeta(closem);
	    petsinv.setItem(53, close);
	    ItemStack cam = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta camm = cam.getItemMeta();
	    camm.setDisplayName("§e ");
	    ArrayList<String> camLore = new ArrayList<String>();
	    camLore.add("");
	    camm.setLore(camLore);
	    cam.setItemMeta(camm);
	    petsinv.setItem(3, cam);
	    ItemStack cam2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam2m = cam2.getItemMeta();
	    cam2m.setDisplayName("§e ");
	    ArrayList<String> cam2Lore = new ArrayList<String>();
	    cam2Lore.add("");
	    cam2m.setLore(cam2Lore);
	    cam2.setItemMeta(cam2m);
	    petsinv.setItem(5, cam2);
	    ItemStack cam3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam3m = cam3.getItemMeta();
	    camm.setDisplayName("§e ");
	    ArrayList<String> cam3Lore = new ArrayList<String>();
	    cam3Lore.add("");
	    cam3m.setLore(cam3Lore);
	    cam3.setItemMeta(cam3m);
	    petsinv.setItem(27, cam3);
	    ItemStack cam4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam4m = cam4.getItemMeta();
	    cam4m.setDisplayName("§e ");
	    ArrayList<String> cam4Lore = new ArrayList<String>();
	    cam4Lore.add("");
	    cam4m.setLore(cam4Lore);
	    cam4.setItemMeta(cam4m);
	    petsinv.setItem(28, cam4);
	    ItemStack cam5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam5m = cam5.getItemMeta();
	    cam5m.setDisplayName("§e ");
	    ArrayList<String> cam5Lore = new ArrayList<String>();
	    cam5Lore.add("");
	    cam5m.setLore(cam5Lore);
	    cam5.setItemMeta(cam5m);
	    petsinv.setItem(29, cam);
	    ItemStack cam6 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam6m = cam6.getItemMeta();
	    cam6m.setDisplayName("§e ");
	    ArrayList<String> cam6Lore = new ArrayList<String>();
	    cam6Lore.add("");
	    cam6m.setLore(cam6Lore);
	    cam6.setItemMeta(cam6m);
	    petsinv.setItem(30, cam6);
	    ItemStack cam7 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam7m = cam7.getItemMeta();
	    cam7m.setDisplayName("§e ");
	    ArrayList<String> cam7Lore = new ArrayList<String>();
	    cam7Lore.add("");
	    cam7m.setLore(cam7Lore);
	    cam7.setItemMeta(cam7m);
	    petsinv.setItem(31, cam7);	    
	    ItemStack cam8 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam8m = cam8.getItemMeta();
	    cam8m.setDisplayName("§e ");
	    ArrayList<String> cam8Lore = new ArrayList<String>();
	    cam8Lore.add("");
	    cam8m.setLore(cam8Lore);
	    cam8.setItemMeta(cam8m);
	    petsinv.setItem(32, cam8);
	    ItemStack cam9 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam9m = cam9.getItemMeta();
	    cam9m.setDisplayName("§e ");
	    ArrayList<String> cam9Lore = new ArrayList<String>();
	    cam9Lore.add("");
	    cam9m.setLore(cam9Lore);
	    cam9.setItemMeta(cam9m);
	    petsinv.setItem(33, cam9);
	    ItemStack cam10 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam10m = cam10.getItemMeta();
	    cam10m.setDisplayName("§e ");
	    ArrayList<String> cam10Lore = new ArrayList<String>();
	    cam10Lore.add("");
	    cam10m.setLore(cam10Lore);
	    cam10.setItemMeta(cam10m);
	    petsinv.setItem(34, cam10);
	    ItemStack cam11 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam11m = cam11.getItemMeta();
	    cam11m.setDisplayName("§e ");
	    ArrayList<String> cam11Lore = new ArrayList<String>();
	    cam11Lore.add("");
	    cam11m.setLore(cam11Lore);
	    cam11.setItemMeta(cam11m);
	    petsinv.setItem(35, cam11);
	    ItemStack cam12 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam12m = cam12.getItemMeta();
	    cam12m.setDisplayName("§e ");
	    ArrayList<String> cam12Lore = new ArrayList<String>();
	    cam12Lore.add("");
	    cam12m.setLore(cam12Lore);
	    cam12.setItemMeta(cam12m);
	    petsinv.setItem(46, cam12);
	    ItemStack cam13 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam13m = cam13.getItemMeta();
	    cam13m.setDisplayName("§e ");
	    ArrayList<String> cam13Lore = new ArrayList<String>();
	    cam13Lore.add("");
	    cam13m.setLore(cam13Lore);
	    cam13.setItemMeta(cam13m);
	    petsinv.setItem(47, cam13);
	    ItemStack cam14 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam14m = cam14.getItemMeta();
	    cam14m.setDisplayName("§e ");
	    ArrayList<String> cam14Lore = new ArrayList<String>();
	    cam14Lore.add("");
	    cam14m.setLore(cam14Lore);
	    cam14.setItemMeta(cam14m);
	    petsinv.setItem(48, cam14);
	    ItemStack cam15 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam15m = cam15.getItemMeta();
	    camm.setDisplayName("§e ");
	    ArrayList<String> cam15Lore = new ArrayList<String>();
	    cam15Lore.add("");
	    cam15m.setLore(cam15Lore);
	    cam15.setItemMeta(cam15m);
	    petsinv.setItem(50, cam15);
	    ItemStack cam16 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam16m = cam16.getItemMeta();
	    cam16m.setDisplayName("§e ");
	    ArrayList<String> cam16Lore = new ArrayList<String>();
	    cam16Lore.add("");
	    cam16m.setLore(cam16Lore);
	    cam16.setItemMeta(cam16m);
	    petsinv.setItem(51, cam16);
	    ItemStack cam17 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 11);
	    ItemMeta cam17m = cam.getItemMeta();
	    cam17m.setDisplayName("§e ");
	    ArrayList<String> cam17Lore = new ArrayList<String>();
	    cam17Lore.add("");
	    cam17m.setLore(cam17Lore);
	    cam17.setItemMeta(cam17m);
	    petsinv.setItem(52, cam17);
		p.openInventory(petsinv);
	}
	
	
	static String selectorname = "";

	
	@SuppressWarnings("deprecation")
	public static void openSelectorInv(Player p) {
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				selectorname = "§8XemeGamer Network Navigation";
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				selectorname = "§8XemeGamer Network Navigasyon";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Inventory selectorinv = Bukkit.createInventory(null, 54, selectorname);
		ItemStack sg = new ItemStack(Material.BOW);
		ItemMeta sgm = sg.getItemMeta();
		sgm.setDisplayName("    §6Survival Games");
		ArrayList<String> sgLore = new ArrayList<String>();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				sgLore.add("§8█ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ ");
				sgLore.add("§7 ");
				sgLore.add("§b             [Join §e" + Bukkit.getOnlinePlayers().length + " §bPlayers ]");
				sgLore.add("§a ");
				sgLore.add("§eThe premier ♥XemeSG♥ experience! ");
				sgLore.add("§e  Join 23 other tributes in ");
				sgLore.add("§e   a fight for victory!");
				sgLore.add("§7 ");
				sgLore.add("§b Left Click §7to §b§lBrowse Servers");
				sgLore.add("§7 ");
				sgLore.add("§8█ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ ");
			}else 	if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				sgLore.add("§8█ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ ");
				sgLore.add("§7 ");
				sgLore.add("§b             [Sunucudakiler §e" + Bukkit.getOnlinePlayers().length + " §bKişi ]");
				sgLore.add("§a ");
				sgLore.add("§eBirinci Sınıf ♥XemeSG♥ deneyimi! ");
				sgLore.add("§e  Diğer 23 kişi sunucuya bağlanır ");
				sgLore.add("§e  savaşıp kazamnak için!");
				sgLore.add("§7 ");
				sgLore.add("§b Sol Tıkla §7ve §b§lSunucuya göz at");
				sgLore.add("§7 ");
				sgLore.add("§8█ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sgm.setLore(sgLore);
		sg.setItemMeta(sgm);
		selectorinv.setItem(10, sg);
		p.openInventory(selectorinv);
	}
	
	static String shopname = "";
	
	
	public static void openShopInv(Player p) {
		
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				shopname = "§8XemeGamer Credits Shop";
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				shopname = "§8XemeGamer Kredi Mağazası";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Inventory shopinv = Bukkit.createInventory(null, 18, shopname);
		ItemStack tokens = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta tokensm = tokens.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				tokensm.setDisplayName("§6Your XemeGamer Credit Balance");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				tokensm.setDisplayName("§6Senin XemeGamer Kredi Bakiyen");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> tokensLore = new ArrayList<String>();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				tokensLore.add("§7You have §e1000 XemeGamer Hub Credits");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				tokensLore.add("§7Senin §e1000 §7XemeGamer Hub Kredin Var");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tokensm.setLore(tokensLore);
		tokens.setItemMeta(tokensm);
		shopinv.setItem(0, tokens);
		
		ItemStack vanity = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta vanitym = vanity.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				vanitym.setDisplayName("§bVanity Items");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				vanitym.setDisplayName("§bMakyaj Eşyaları");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> vanityLore = new ArrayList<String>();
		vanityLore.add("");
		vanitym.setLore(vanityLore);
		vanity.setItemMeta(vanitym);
		shopinv.setItem(7, vanity);
		
		ItemStack hats = new ItemStack(Material.GOLD_HELMET);
		ItemMeta hatsm = hats.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				hatsm.setDisplayName("§eHats");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				hatsm.setDisplayName("§eŞapkalar");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> hatsLore = new ArrayList<String>();
		hatsLore.add("");
		hatsm.setLore(hatsLore);
		hats.setItemMeta(hatsm);
		shopinv.setItem(8, hats);
		
		ItemStack pets = new ItemStack(Material.SADDLE);
		ItemMeta petsm = pets.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				petsm.setDisplayName("§aPets");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				petsm.setDisplayName("§aEvcil Hayvanlar");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> petsLore = new ArrayList<String>();
		petsLore.add("");
		petsm.setLore(petsLore);
		pets.setItemMeta(petsm);
		shopinv.setItem(17, pets);
		
		ItemStack effect = new ItemStack(Material.EXP_BOTTLE);
		ItemMeta effectm = effect.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				effectm.setDisplayName("§dEffects");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				effectm.setDisplayName("§dEfektler");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> effectLore = new ArrayList<String>();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				effectLore.add("§b▂▃▅▆█   §7Right Click to buy and choose your effect   §b█▆▅▃▂");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				effectLore.add("§b▂▃▅▆█   §7Sağ tıklayarak efektleri satın al ve kullanmaya başla   §b█▆▅▃▂");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		effectm.setLore(effectLore);
		effect.setItemMeta(effectm);
		shopinv.setItem(16, effect);
		
		ItemStack close = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta closem = close.getItemMeta();
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				closem.setDisplayName("§4Close Menu");
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				closem.setDisplayName("§4Menüyü Kapat");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> closeLore = new ArrayList<String>();
		closeLore.add("");
		closem.setLore(closeLore);
		close.setItemMeta(closem);
		shopinv.setItem(9, close);
		
		p.openInventory(shopinv);
	}
	
	static String efektname= "";
	
	public static void openEffectInv(Player p) {
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				efektname = "§a§lCosmetics §8» §6§lEffects";
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English"))  {
				efektname = "§a§lKozmetik §8» §6§lEfektler";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Inventory effectInventory = Bukkit.createInventory(null, 54, efektname);
			ItemStack back = new ItemStack(Material.ARROW);
			ItemMeta backm = back.getItemMeta();
			try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					backm.setDisplayName("§cBack");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					backm.setDisplayName("§cGeri Dön");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<String> backLore = new ArrayList<String>();
			backLore.add("");
			backm.setLore(backLore);
			back.setItemMeta(backm);
			effectInventory.setItem(45, back);
		    ItemStack fns = new ItemStack(Material.FLINT_AND_STEEL);
		    ItemMeta fnsm = fns.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					fnsm.setDisplayName("§c§lFlame Rings");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					fnsm.setDisplayName("§c§lAlev Halkaları");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> fnsLore = new ArrayList<String>();
		    fnsLore.add("");
		    fnsm.setLore(fnsLore);
		    fns.setItemMeta(fnsm);
		    effectInventory.setItem(4, fns);
		    ItemStack apple = new ItemStack(Material.APPLE);
		    ItemMeta applem = apple.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					applem.setDisplayName("§4§lHeart Effect");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					applem.setDisplayName("§4§lKalp Efekti");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> appleLore = new ArrayList<String>();
		    appleLore.add("");
		    applem.setLore(appleLore);
		    apple.setItemMeta(applem);
		    effectInventory.setItem(20, apple);
		    ItemStack reddust = new ItemStack(Material.REDSTONE);
		    ItemMeta reddustm = reddust.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					reddustm.setDisplayName("§cRed Dust");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					reddustm.setDisplayName("§cKırmızı Toz");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> reddustLore = new ArrayList<String>();
		    reddustLore.add("");
		    reddustm.setLore(reddustLore);
		    reddust.setItemMeta(reddustm);
		    effectInventory.setItem(22, reddust);
		    ItemStack emerald = new ItemStack(Material.EMERALD);
		    ItemMeta emeraldm = emerald.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					emeraldm.setDisplayName("§aEmerald Twirl");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					emeraldm.setDisplayName("§aZümrüt Burgu");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> emeraldLore = new ArrayList<String>();
		    emeraldLore.add("");
		    emeraldm.setLore(emeraldLore);
		    emerald.setItemMeta(emeraldm);
		    effectInventory.setItem(24, emerald);
		    ItemStack smoke = new ItemStack(Material.IRON_INGOT);
		    ItemMeta smokem = smoke.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					smokem.setDisplayName("§cSmoke");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					smokem.setDisplayName("§cSis");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> smokeLore = new ArrayList<String>();
		    smokeLore.add("");
		    smokem.setLore(smokeLore);
		    smoke.setItemMeta(smokem);
		    effectInventory.setItem(37, smoke);
		    ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
		    ItemMeta lavam = lava.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {	
					lavam.setDisplayName("§c§lLava Effect");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					lavam.setDisplayName("§c§lLav Efekti");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    ArrayList<String> lavaLore = new ArrayList<String>();
		    lavaLore.add("");
		    lavam.setLore(lavaLore);
		    lava.setItemMeta(lavam);
		    effectInventory.setItem(39, lava);
		    ItemStack explode = new ItemStack(Material.TNT);
		    ItemMeta explodem = explode.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					explodem.setDisplayName("§7§lExplode");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					explodem.setDisplayName("§7Patlama Efekti");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> explodeLore = new ArrayList<String>();
		    explodeLore.add("");
		    explodem.setLore(explodeLore);
		    explode.setItemMeta(explodem);
		    effectInventory.setItem(41, explode);
		    ItemStack firework = new ItemStack(Material.FIREWORK);
		    ItemMeta fireworkm = firework.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					fireworkm.setDisplayName("§aFireWork");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					fireworkm.setDisplayName("§aHavai Fişek");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> fireworkLore = new ArrayList<String>();
		    fireworkLore.add("");
		    fireworkm.setLore(fireworkLore);
		    firework.setItemMeta(fireworkm);
		    effectInventory.setItem(43, firework);
		    ItemStack crit = new ItemStack(Material.BOW);
		    ItemMeta critm = crit.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					critm.setDisplayName("§bCritical");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					critm.setDisplayName("§bKritik EFekti");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> critLore = new ArrayList<String>();
		    critLore.add("");
		    critm.setLore(critLore);
		    crit.setItemMeta(critm);
		    effectInventory.setItem(49, crit);
		    ItemStack cloud = new ItemStack(Material.SNOW_BLOCK);
		    ItemMeta cloudm = cloud.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					cloudm.setDisplayName("§f§lCloud");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					cloudm.setDisplayName("§f§lBulut Efekti");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> cloudLore = new ArrayList<String>();
		    cloudLore.add("");
		    cloudm.setLore(cloudLore);
		    cloud.setItemMeta(cloudm);
		    effectInventory.setItem(0, cloud);
		    ItemStack music = new ItemStack(Material.GREEN_RECORD);
		    ItemMeta musicm = music.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					musicm.setDisplayName("§5Music");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					musicm.setDisplayName("§5Müzik Efekti");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> musicLore = new ArrayList<String>();
		    musicLore.add("");
		    musicm.setLore(musicLore);
		    music.setItemMeta(musicm);
		    effectInventory.setItem(8, music);
		    ItemStack close = new ItemStack(Material.REDSTONE_BLOCK);
		    ItemMeta closem = close.getItemMeta();
		    try {
				if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
					closem.setDisplayName("§4§lClear Effects");
				}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					closem.setDisplayName("§4§lEfektleri Temizle");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    ArrayList<String> closeLore = new ArrayList<String>();
		    closeLore.add("");
		    closem.setLore(closeLore);
		    close.setItemMeta(closem);
		    effectInventory.setItem(53, close);
		    ItemStack cam = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta camm = cam.getItemMeta();
		    camm.setDisplayName("§e ");
		    ArrayList<String> camLore = new ArrayList<String>();
		    camLore.add("");
		    camm.setLore(camLore);
		    cam.setItemMeta(camm);
		    effectInventory.setItem(3, cam);
		    ItemStack cam2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam2m = cam2.getItemMeta();
		    cam2m.setDisplayName("§e ");
		    ArrayList<String> cam2Lore = new ArrayList<String>();
		    cam2Lore.add("");
		    cam2m.setLore(cam2Lore);
		    cam2.setItemMeta(cam2m);
		    effectInventory.setItem(5, cam2);
		    ItemStack cam3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam3m = cam3.getItemMeta();
		    camm.setDisplayName("§e ");
		    ArrayList<String> cam3Lore = new ArrayList<String>();
		    cam3Lore.add("");
		    cam3m.setLore(cam3Lore);
		    cam3.setItemMeta(cam3m);
		    effectInventory.setItem(27, cam3);
		    ItemStack cam4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam4m = cam4.getItemMeta();
		    cam4m.setDisplayName("§e ");
		    ArrayList<String> cam4Lore = new ArrayList<String>();
		    cam4Lore.add("");
		    cam4m.setLore(cam4Lore);
		    cam4.setItemMeta(cam4m);
		    effectInventory.setItem(28, cam4);
		    ItemStack cam5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam5m = cam5.getItemMeta();
		    cam5m.setDisplayName("§e ");
		    ArrayList<String> cam5Lore = new ArrayList<String>();
		    cam5Lore.add("");
		    cam5m.setLore(cam5Lore);
		    cam5.setItemMeta(cam5m);
		    effectInventory.setItem(29, cam);
		    ItemStack cam6 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam6m = cam6.getItemMeta();
		    cam6m.setDisplayName("§e ");
		    ArrayList<String> cam6Lore = new ArrayList<String>();
		    cam6Lore.add("");
		    cam6m.setLore(cam6Lore);
		    cam6.setItemMeta(cam6m);
		    effectInventory.setItem(30, cam6);
		    ItemStack cam7 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam7m = cam7.getItemMeta();
		    cam7m.setDisplayName("§e ");
		    ArrayList<String> cam7Lore = new ArrayList<String>();
		    cam7Lore.add("");
		    cam7m.setLore(cam7Lore);
		    cam7.setItemMeta(cam7m);
		    effectInventory.setItem(31, cam7);	    
		    ItemStack cam8 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam8m = cam8.getItemMeta();
		    cam8m.setDisplayName("§e ");
		    ArrayList<String> cam8Lore = new ArrayList<String>();
		    cam8Lore.add("");
		    cam8m.setLore(cam8Lore);
		    cam8.setItemMeta(cam8m);
		    effectInventory.setItem(32, cam8);
		    ItemStack cam9 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam9m = cam9.getItemMeta();
		    cam9m.setDisplayName("§e ");
		    ArrayList<String> cam9Lore = new ArrayList<String>();
		    cam9Lore.add("");
		    cam9m.setLore(cam9Lore);
		    cam9.setItemMeta(cam9m);
		    effectInventory.setItem(33, cam9);
		    ItemStack cam10 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam10m = cam10.getItemMeta();
		    cam10m.setDisplayName("§e ");
		    ArrayList<String> cam10Lore = new ArrayList<String>();
		    cam10Lore.add("");
		    cam10m.setLore(cam10Lore);
		    cam10.setItemMeta(cam10m);
		    effectInventory.setItem(34, cam10);
		    ItemStack cam11 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam11m = cam11.getItemMeta();
		    cam11m.setDisplayName("§e ");
		    ArrayList<String> cam11Lore = new ArrayList<String>();
		    cam11Lore.add("");
		    cam11m.setLore(cam11Lore);
		    cam11.setItemMeta(cam11m);
		    effectInventory.setItem(35, cam11);
		    ItemStack cam12 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam12m = cam12.getItemMeta();
		    cam12m.setDisplayName("§e ");
		    ArrayList<String> cam12Lore = new ArrayList<String>();
		    cam12Lore.add("");
		    cam12m.setLore(cam12Lore);
		    cam12.setItemMeta(cam12m);
		    effectInventory.setItem(46, cam12);
		    ItemStack cam13 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam13m = cam13.getItemMeta();
		    cam13m.setDisplayName("§e ");
		    ArrayList<String> cam13Lore = new ArrayList<String>();
		    cam13Lore.add("");
		    cam13m.setLore(cam13Lore);
		    cam13.setItemMeta(cam13m);
		    effectInventory.setItem(47, cam13);
		    ItemStack cam14 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam14m = cam14.getItemMeta();
		    cam14m.setDisplayName("§e ");
		    ArrayList<String> cam14Lore = new ArrayList<String>();
		    cam14Lore.add("");
		    cam14m.setLore(cam14Lore);
		    cam14.setItemMeta(cam14m);
		    effectInventory.setItem(48, cam14);
		    ItemStack cam15 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam15m = cam15.getItemMeta();
		    camm.setDisplayName("§e ");
		    ArrayList<String> cam15Lore = new ArrayList<String>();
		    cam15Lore.add("");
		    cam15m.setLore(cam15Lore);
		    cam15.setItemMeta(cam15m);
		    effectInventory.setItem(50, cam15);
		    ItemStack cam16 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam16m = cam16.getItemMeta();
		    cam16m.setDisplayName("§e ");
		    ArrayList<String> cam16Lore = new ArrayList<String>();
		    cam16Lore.add("");
		    cam16m.setLore(cam16Lore);
		    cam16.setItemMeta(cam16m);
		    effectInventory.setItem(51, cam16);
		    ItemStack cam17 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 4);
		    ItemMeta cam17m = cam.getItemMeta();
		    cam17m.setDisplayName("§e ");
		    ArrayList<String> cam17Lore = new ArrayList<String>();
		    cam17Lore.add("");
		    cam17m.setLore(cam17Lore);
		    cam17.setItemMeta(cam17m);
		    effectInventory.setItem(52, cam17);
		    p.openInventory(effectInventory);
	}
	
	

}
