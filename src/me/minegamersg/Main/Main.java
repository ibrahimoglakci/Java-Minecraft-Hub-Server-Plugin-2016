package me.minegamersg.Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.minegamersg.api.BanManager;
//import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.NMS;
import me.minegamersg.api.PlayerInfos;
import me.minegamersg.commands.BanMuteKick;
import me.minegamersg.commands.Build;
import me.minegamersg.commands.ChatColorCommand;
import me.minegamersg.commands.Disguise;
import me.minegamersg.commands.FlyandGamemodes;
import me.minegamersg.commands.RankCommands;
import me.minegamersg.commands.SGList;
import me.minegamersg.commands.ServerCommand;
import me.minegamersg.commands.Sidebar;
import me.minegamersg.commands.Stats;
import me.minegamersg.listener.BlockBreakListener;
import me.minegamersg.listener.BlockPlaceListener;
import me.minegamersg.listener.ChatListener;
import me.minegamersg.listener.DamageListener;
import me.minegamersg.listener.ExplodeListener;
import me.minegamersg.listener.InventoryClickListener;
import me.minegamersg.listener.ItemDropListener;
import me.minegamersg.listener.ItemPickUpListener;
import me.minegamersg.listener.JoinListener;
import me.minegamersg.listener.LoginListener;
import me.minegamersg.listener.MotdListener;
import me.minegamersg.listener.QuitListener;
import me.minegamersg.listener.TabCompleteEvent;

public class Main extends JavaPlugin{
	
	public static BanManager banManager;
	public static PlayerInfos playerInfos;
	
	public ArrayList<Player> Players = new ArrayList<>();
	public String serverMotd;
	public Logger log = Logger.getLogger("Minecraft");
	public boolean canChange = false;

	
	
	public static Main minegamersg;

	public static NMS nmsclass;
	
	public void onDisable() {

	}
	
	
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
		Build.buildmode = false;
		minegamersg = this;
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		Bukkit.getConsoleSender().sendMessage("§7[§eXemeGamer§7] §ais Activated");
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
		if(!f.exists()) {
        	mysqlData.set("MySQL.HostName", "localhost");
        	mysqlData.set("MySQL.Port", "3306");
        	mysqlData.set("MySQL.Database", "xemegamer");
        	mysqlData.set("MySQL.UserName", "root");
        	mysqlData.set("MySQL.Password", "");
        }
        try {
        	mysqlData.save(f);
        }catch(IOException ex) {
        	ex.printStackTrace();
        }
        getConfig().options().copyDefaults(true);
		if(!getConfig().isSet("Server-Name-Number")) {
			getConfig().set("Server-Name-Number", 27);
		}
		saveConfig();
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			File pdata = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "Players Profile");
			File pf = new File(pdata, File.separator + all.getName() + ".yml");
			FileConfiguration pprofil = YamlConfiguration.loadConfiguration(pf);
			if(!pf.exists()) {
				pprofil.set("Sidebar", "2015");
			}
			all.getWorld().setWeatherDuration(1000);
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					
					BanManager.checkDuration(all.getUniqueId());
				}
				
			}, 20L);
		}
		
		/*/for(Player all : Bukkit.getOnlinePlayers()) {
			all.showPlayer(all);
			PlayerManager.preparePlayer(all);
			all.setGameMode(GameMode.ADVENTURE);
			all.getActivePotionEffects().clear();
			all.removePotionEffect(PotionEffectType.INVISIBILITY);
			File datas = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "SurvivalGames Maps");
			File ff = new File(datas, File.separator + "Lobby.yml");
			FileConfiguration locationDataa = YamlConfiguration.loadConfiguration(ff);
			all.teleport(new Location(Bukkit.getWorld("Lobby"), locationDataa.getDouble("Lobby.X"), locationDataa.getDouble("Lobby.Y"), locationDataa.getDouble("Lobby.Z")));
			try {
				MySQLAPI.setSGDefaultStats(all);
				MySQLAPI.setChestStatsOptions(all);
				MySQLAPI.setGamesWinOptions(all);
				MySQLAPI.setPluginOption();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}/*/
		/*/try {
			MySQLAPI.setPluginOption();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}/*/
		//try {
			//if(MySQLAPI.getPluginOptions().equalsIgnoreCase("true")) {
			//------------------------ Register Events ----------------------//
			
				PluginManager pm = (PluginManager) Bukkit.getPluginManager();
				pm.registerEvents(new JoinListener(), this);
				pm.registerEvents(new QuitListener(), this);
				pm.registerEvents(new ChatListener(), this);
				pm.registerEvents(new BlockBreakListener(), this);
				pm.registerEvents(new BlockPlaceListener(), this);
				pm.registerEvents(new ExplodeListener(), this);
				pm.registerEvents(new DamageListener(), this);
				pm.registerEvents(new MotdListener(), this);
				pm.registerEvents(new InventoryClickListener(), this);
				pm.registerEvents(new ItemDropListener(), this);
				pm.registerEvents(new ItemPickUpListener(), this);
				pm.registerEvents(new LoginListener(), this);
				pm.registerEvents(new TabCompleteEvent(), this);
				/*/pm.registerEvents(new LoginListener(), this);
				
				pm.registerEvents(new JoinListener(), this);
				pm.registerEvents(new ChatListener(), this);
				pm.registerEvents(new MotdListener(), this);
				pm.registerEvents(new DeathListener(), this);
				//pm.registerEvents(new ChunkLoadListener(), this);
				pm.registerEvents(new RespawnListener(), this);
				pm.registerEvents(new DamageListener(), this);
				pm.registerEvents(new BlockBreakListener(), this);
				pm.registerEvents(new BlockPlaceListener(), this);
				pm.registerEvents(new PlayerInteractListener(), this);
				pm.registerEvents(new QuitListener(), this);
				pm.registerEvents(new BoatDamageListener(), this);
				pm.registerEvents(new ExplodeListener(), this);
				pm.registerEvents(new ItemDropListener(), this);
				pm.registerEvents(new ItemPickUpListener(), this);
				pm.registerEvents(new FoodChangeListener(), this);/*/
				
			//------------------------ Register Events -----------------------//
			//****************************************************************
			//****************************************************************
			//****************************************************************
			//****************************************************************
			//****************************************************************
			//------------------------ Command Executor ----------------------//
			
			
				getCommand("list").setExecutor(new SGList());
				getCommand("stats").setExecutor(new Stats());
				getCommand("build").setExecutor(new Build());
				getCommand("disguise").setExecutor(new Disguise());
				getCommand("sidebar").setExecutor(new Sidebar());
				getCommand("rank").setExecutor(new RankCommands());
				getCommand("fly").setExecutor(new FlyandGamemodes());
				getCommand("chatcolor").setExecutor(new ChatColorCommand());
				getCommand("ban").setExecutor(new BanMuteKick());
				getCommand("mute").setExecutor(new BanMuteKick());
				getCommand("unmute").setExecutor(new BanMuteKick());
				getCommand("unban").setExecutor(new BanMuteKick());
				getCommand("kick").setExecutor(new BanMuteKick());
				getCommand("server").setExecutor(new ServerCommand());
				//getCommand("pets").setExecutor(new PetsCommand());
			//------------------------ Command Executor ----------------------//
			//****************************************************************
			//****************************************************************
							
				
			//------------------------ Start Game ----------------------//
			//}else if(MySQLAPI.getPluginOptions().equalsIgnoreCase("false")) {
				//Bukkit.getServer().shutdown();
			//}
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	
	
	
	

	
	Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
      public void run()
      {
    	  /*try {
				if(MySQLAPI.getPluginOptions().equalsIgnoreCase("false")) {
					Bukkit.getServer().shutdown();
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}*/
    	 
      }
    }, 0L, 100L);
	}


	
	

	
	public static Main getSGAPI() {
		
		return minegamersg;
	}

}
