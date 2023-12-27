package me.minegamersg.api;

import java.io.File;
import java.sql.PreparedStatement;
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
 
public class PlayerInfos {
 
    /**
     * Actualiser/créer les informations du joueur
     * @param player
     */
    public void update(Player player){
    	File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
        try {
            PreparedStatement sts = mysql.getConnection().prepareStatement("SELECT player_name FROM player_infos WHERE player_uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
 
            if(rs.next()){
                PreparedStatement update = mysql.getConnection().prepareStatement("UPDATE player_infos SET player_name=? WHERE player_uuid=?");
                update.setString(1, player.getName());
                update.setString(2, player.getUniqueId().toString());
                update.executeUpdate();
                update.close();
 
                System.out.println("Update : " + player.getName() + " , " + player.getUniqueId().toString()); // Facultatif
            } else {
                PreparedStatement insert = mysql.getConnection().prepareStatement("INSERT INTO player_infos (player_uuid, player_name) VALUES (?, ?)");
                insert.setString(1, player.getUniqueId().toString());
                insert.setString(2, player.getName());
                insert.executeUpdate();
                insert.close();
 
                System.out.println("Insertion : " + player.getName() + " , " + player.getUniqueId().toString()); // Facultatif
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Vérifie si le joueur a des informations dans la table
     * @param playerName
     * @return true/false
     */
    public boolean exist(String playerName){
    	String uuid = Bukkit.getPlayer(playerName).getUniqueId().toString();
    	File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		
        try {
        	statement = mysql.getConnection().createStatement();
        	ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ uuid + "';");   
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
 
    /**
     * Récupérer lUUID dun joueur avec son pseudo
     * @param playerName
     * @return UUID
     */
    @SuppressWarnings("deprecation")
	public UUID getUUID(String playerName){
    	UUID uuid = Bukkit.getOfflinePlayer(playerName).getUniqueId();
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		
		try {
			Statement statement;
		       
			statement = mysql.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM `playerdata` WHERE `uuid`='"+ uuid + "';");
			if(rs.next()) {
				uuid = UUID.fromString(rs.getString("uuid"));
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return uuid;
    }
 
}