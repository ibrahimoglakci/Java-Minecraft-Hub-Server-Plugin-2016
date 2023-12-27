package me.minegamersg.api;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.minegamersg.Main.Main;
import me.minegamersg.mysql.MySQL;

public class MySQLAPI {
	
	
	
	public static String getCurrentState(String server) throws SQLException {
		String cc ="Lobby";
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `servers` WHERE `servername`='" + server + "';");
		if(rs.next()) {
			cc = rs.getString("CurrentState");
		}
		
		return cc;
		
	}
	
	
	public static int getWatchingPlayers(String server) throws SQLException {
		int cc =0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `servers` WHERE `servername`='" + server + "';");
		if(rs.next()) {
			cc = rs.getInt("Watching");
		}
		
		return cc;
		
	}
	
	
	public static int getPlayingPlayers(String server) throws SQLException {
		int cc =0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `servers` WHERE `servername`='" + server + "';");
		if(rs.next()) {
			cc = rs.getInt("Playing");
		}
		
		return cc;
		
	}
	

	public static void updateLanguage(Player p, String language) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			statement.executeUpdate("UPDATE `playerdata` set `Language`= '" + language + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	

	public static String getLanguage(Player p) throws SQLException {
		String cc ="English";
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			cc = rs.getString("Language");
		}
		
		return cc;
		
	}
	
	
	
	public static void updateChatColor(Player p, String cc) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			statement.executeUpdate("UPDATE `playerdata` set `Chatcolor`= '" + cc + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static String getChatColor(Player p) throws SQLException {
		String cc ="f";
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			cc = rs.getString("ChatColor");
		}
		
		return cc;
		
	}
	
	
	public static void updateSidebar(Player p, String sidebar) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			statement.executeUpdate("UPDATE `playerdata` set `Sidebar`= '" + sidebar + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static String getSidebar(Player p) throws SQLException {
		String sidebar ="2015";
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			sidebar = rs.getString("Sidebar");
		}
		
		return sidebar;
		
	}
	
	
	public static void updateRank(Player p, String rank) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			statement.executeUpdate("UPDATE `playerdata` set `Rank`= '" + rank + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static UUID getUUID(Player p) {
		UUID uuid = p.getUniqueId();
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		
		try {
			Statement statement;
		       
			statement = mysql.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
			if(rs.next()) {
				uuid = UUID.fromString(rs.getString("uuid"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return uuid;
		
	}

	public static String getRank(Player p) throws SQLException {
		String rank ="regular";
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			rank = rs.getString("Rank");
		}
		
		return rank;
		
	}
	
	
	public static void setDefaultPlayerData(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(!rs.next()) { 
			statement.executeUpdate("INSERT INTO `playerdata` (uuid, playername, Rank, Sidebar, ChatColor, Language) VALUES ('" + p.getUniqueId() +"', '" + p.getName() + "', 'regular', '2015', 'f', 'English');");
		}
	}
	
	public static Integer getKills(Player p) throws SQLException {
		int kills = 0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			kills = rs.getInt("Kills");
		}
		
		return kills;
		
	}
	
	public static Integer getGamesWon(Player p) throws SQLException {
		int gamewin = 0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_GameOptions` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			gamewin = rs.getInt("Game_Win");
		}
		
		return gamewin;
		
	}
	
	public static Integer getGamesTotal(Player p) throws SQLException {
		int gametotal = 0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_GameOptions` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			gametotal = rs.getInt("Game_Played_Total");
		}
		
		return gametotal;
		
	}
	
	public static void addGamesWon(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_GameOptions` WHERE `UUID`='"+ p.getUniqueId() + "';");
		int addgamewin = rs.getInt("Game_Win") + 1;
		if(rs.next()) {
			statement.executeUpdate("UPDATE `XemeGamer_Stats_ChestStats` set `Game_Win`= '" + addgamewin + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static void addGamesTotal(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_GameOptions` WHERE `UUID`='"+ p.getUniqueId() + "';");
		int addgametotal = rs.getInt("Game_Played_Total") + 1;
		if(rs.next()) {
			statement.executeUpdate("UPDATE `XemeGamer_Stats_ChestStats` set `Game_Played_Total`= '" + addgametotal + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static void setGamesWinOptions(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_GameOptions` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(!rs.next()) { 
			statement.executeUpdate("INSERT INTO `XemeGamer_Stats_GameOptions` (UUID, UserName, Game_Win, Game_Played_Total) VALUES ('" + p.getUniqueId() +"', '" + p.getName() + "', '0', '0');");
		}
	}
	
	public static String getPluginOptions() throws SQLException {
		String pluginoptions = "true";
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Plugin_Options`;");
		if(rs.next()) {
			pluginoptions = rs.getString("Plugin_Enable");
		}
		
		return pluginoptions;
		
	}
	
	public static void setPluginOption() throws SQLException {
		
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Plugin_Options`;");
		if(!rs.next()) {
			statement.executeUpdate("INSERT INTO `XemeGamer_Plugin_Options` (Plugin_Enable) VALUES ('true');");
		}else {
			return;
		}
		
		
		
	}
	
	
	public static Integer getTier1ChestOpen(Player p) throws SQLException {
		int open_tier1_chest = 0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_ChestStats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			open_tier1_chest = rs.getInt("Open_Tier1_Chest");
		}
		
		return open_tier1_chest;
		
	}
	
	public static Integer getTier2ChestOpen(Player p) throws SQLException {
		int open_tier2_chest = 0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_ChestStats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			open_tier2_chest = rs.getInt("Open_Tier2_Chest");
		}
		
		return open_tier2_chest;
		
	}
	public static Integer getAllChestOpen(Player p) throws SQLException {
		int open_all_chest = 0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_ChestStats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			open_all_chest = rs.getInt("Open_All_Chest");
		}
		
		return open_all_chest;
		
	}
	
	public static void addTier1OpenChest(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_ChestStats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		int addopentier1chest = rs.getInt("Open_Tier1_Chest") + 1;
		if(rs.next()) {
			statement.executeUpdate("UPDATE `XemeGamer_Stats_ChestStats` set `Open_Tier1_Chest`= '" + addopentier1chest + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static void addTier2OpenChest(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_ChestStats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		int addopentier2chest = rs.getInt("Open_Tier2_Chest") + 1;
		if(rs.next()) {
			statement.executeUpdate("UPDATE `XemeGamer_Stats_ChestStats` set `Open_Tier2_Chest`= '" + addopentier2chest + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static void addAllOpenChest(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_ChestStats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		int addopenallchest = getTier1ChestOpen(p) + getTier2ChestOpen(p) + 1;
		if(rs.next()) {
			statement.executeUpdate("UPDATE `XemeGamer_Stats_ChestStats` set `Open_All_Chest`= '" + addopenallchest + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static void setChestStatsOptions(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats_ChestStats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(!rs.next()) { 
			statement.executeUpdate("INSERT INTO `XemeGamer_Stats_ChestStats` (UUID, UserName, Open_Tier1_Chest, Open_Tier2_Chest, Open_All_Chest) VALUES ('" + p.getUniqueId() +"', '" + p.getName() + "', '0', '0', '0');");
		}
	}
	
	
	public static Integer getDeaths(Player p) throws SQLException {
		int deaths = 0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			deaths = rs.getInt("Deaths");
		}
		
		return deaths;
		
	}
	
	public static Integer getBounty(Player p) throws SQLException {
		int bounty = 0;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			bounty = rs.getInt("Bounty");
		}
		
		return bounty;
		
	}
	
	
	public static void addKills(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		int addkills = rs.getInt("Kills") + 1;
		if(rs.next()) {
			statement.executeUpdate("UPDATE `XemeGamer_Stats` set `Kills`= '" + addkills + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static void addDeaths(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		int adddeaths = rs.getInt("Deaths") + 1;
		if(rs.next()) {
			statement.executeUpdate("UPDATE `XemeGamer_Stats` set `Deaths`= '" + adddeaths + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static void addBounty(Player p, int bounty) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(rs.next()) {
			int addbounty = rs.getInt("Bounty") + bounty;
			statement.executeUpdate("UPDATE `XemeGamer_Stats` set `Bounty`= '" + addbounty + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	public static void removeBounty(Player p, int bounty) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
	
		if(rs.next()) {
			int removebounty = rs.getInt("Bounty") - bounty;
			statement.executeUpdate("UPDATE `XemeGamer_Stats` set `Bounty`= '" + removebounty + "' where `UUID`='"+ p.getUniqueId() + "';");
		}
	}
	
	
	public static void setSGDefaultStats(Player p) throws SQLException {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
		statement = mysql.getConnection().createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM `XemeGamer_Stats` WHERE `UUID`='"+ p.getUniqueId() + "';");
		if(!rs.next()) {
			statement.executeUpdate("INSERT INTO `XemeGamer_Stats` (UUID, UserName, Kills, Deaths, Bounty) VALUES ('" + p.getUniqueId() +"', '" + p.getName() + "', '0', '0', '100');");
		}
	}

}

