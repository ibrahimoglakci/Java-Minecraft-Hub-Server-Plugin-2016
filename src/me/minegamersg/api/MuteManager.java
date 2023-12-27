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

import me.minegamersg.Enum.TimeUnit;
import me.minegamersg.Main.Main;
import me.minegamersg.mysql.MySQL;

public class MuteManager {
	
	public static void mute(UUID uuid, long endInSeconds, String reason) throws SQLException{
        if(isMuted(uuid)) return;
 
        long endToMillis = endInSeconds * 1000;
        long end = endToMillis + System.currentTimeMillis();
        File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		Statement statement;
	       
		statement = mysql.getConnection().createStatement();
        if(endInSeconds == -1){
            end = -1;
        }
        ResultSet rs = statement.executeQuery("SELECT * FROM `xemegamer_mutelist` WHERE `player_uuid`='"+ uuid + "';");
        if(!rs.next()) {
        	statement.executeUpdate("INSERT INTO `xemegamer_mutelist` (player_uuid, end, reason) VALUES ('" + uuid + "', '" + end + "', '" + reason + "');");
        }
 
       /* try {
            PreparedStatement sts = mysql.getConnection().prepareStatement("INSERT INTO xemegamer_mutelist (player_uuid, end, reason) VALUES (?, ?, ?)");
            sts.setString(1, uuid.toString());
            sts.setLong(2, end);
            sts.setString(3, reason);
            sts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 */

    }
 
    public static void unMute(UUID uuid){
        if(!isMuted(uuid)) return;
 
        File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
		
        try {
            PreparedStatement sts = mysql.getConnection().prepareStatement("DELETE FROM xemegamer_mutelist WHERE player_uuid=?");
            sts.setString(1, uuid.toString());
            sts.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static boolean isMuted(UUID uuid){
    	File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
        try {
            PreparedStatement sts = mysql.getConnection().prepareStatement("SELECT * FROM xemegamer_mutelist WHERE player_uuid=?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
 
    public static void checkDuration(UUID uuid){
        if(!isMuted(uuid)) return;
 
        if(getEnd(uuid) == -1) return;
 
        if(getEnd(uuid) < System.currentTimeMillis()){
            unMute(uuid);
        }
    }
 
    public static long getEnd(UUID uuid){
        if(!isMuted(uuid)) return 0;
        
        File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
      
		try {
            PreparedStatement sts = mysql.getConnection().prepareStatement("SELECT * FROM xemegamer_mutelist WHERE player_uuid=?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()){
                return rs.getLong("end");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
 
    public static String getTimeLeft(UUID uuid){
        if(!isMuted(uuid)) return MessageAPI.getServerPrefix() + "§cPlayer is not Muted!";
 
        if(getEnd(uuid) == -1){
            return "§cPermanent";
        }
 
        long tempsRestant = (getEnd(uuid) - System.currentTimeMillis()) / 1000;
        int mois = 0;
        int jours = 0;
        int heures = 0;
        int minutes = 0;
        int secondes = 0;
 
        while(tempsRestant >= TimeUnit.MOIS.getToSecond()){
            mois++;
            tempsRestant -= TimeUnit.MOIS.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.JOUR.getToSecond()){
            jours++;
            tempsRestant -= TimeUnit.JOUR.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.HEURE.getToSecond()){
            heures++;
            tempsRestant -= TimeUnit.HEURE.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.MINUTE.getToSecond()){
            minutes++;
            tempsRestant -= TimeUnit.MINUTE.getToSecond();
        }
 
        while(tempsRestant >= TimeUnit.SECONDE.getToSecond()){
            secondes++;
            tempsRestant -= TimeUnit.SECONDE.getToSecond();
        }
 
        // 1 Mois, 1 Jour(s), 12 Heure(s), 32 Minute(s), 12 Seconde(s)
        if(mois > 0) {
        	return  "§8[§c" + mois + "§8]§c " + " " + TimeUnit.MOIS.getName();
        }
        if(mois == 0 && jours >0) {
        	
        	return  "§8[§c" + jours + "§8]§c " + " " + TimeUnit.JOUR.getName();
        }
        if(mois == 0 && jours == 0 && heures > 0) {
        	
        	return "§8[§c" + heures + "§8]§c " + " " + TimeUnit.HEURE.getName();
        	
        }
        if(mois == 0 && jours == 0 && heures == 0 && minutes >0) {
        	return "§8[§c" + minutes + "§8] §c" + " " + TimeUnit.MINUTE.getName();
        }
        if(mois == 0 && jours == 0 && heures == 0 && minutes == 0 && secondes > 0) {
        	return "§8[§c" + secondes + "§8] §c" + " " + TimeUnit.SECONDE.getName();
        }
        return "§8[§c" + mois + "§8]§c " + TimeUnit.MOIS.getName() + ", " + "§8[§c" + jours + "§8]§c " + " " + TimeUnit.JOUR.getName() + ", " + "§8[§c" + heures + "§8]§c " + " " + TimeUnit.HEURE.getName() + ", " + "§8[§c" + minutes + "§8] §c" + " " + TimeUnit.MINUTE.getName() + ", " + "§8[§c" + secondes + "§8] §c" + " " + TimeUnit.SECONDE.getName();
    }
 
    public static String getReason(UUID uuid){
        if(!isMuted(uuid)) return MessageAPI.getServerPrefix() + "§cPlayer is not Muted!";
 
        File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
				 
		MySQL mysql = new MySQL(Main.getSGAPI(), mysqlData.getString("MySQL.HostName"), mysqlData.getString("MySQL.Port"), mysqlData.getString("MySQL.Database"), mysqlData.getString("MySQL.UserName"), mysqlData.getString("MySQL.Password"));
		mysql.openConnection();
        
        try {
            PreparedStatement sts = mysql.getConnection().prepareStatement("SELECT * FROM xemegamer_mutelist WHERE player_uuid=?");
            sts.setString(1, uuid.toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()){
                return rs.getString("reason");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return MessageAPI.getServerPrefix() + "§cPlayer is not Muted!";
    }

}
