package me.minegamersg.api;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class LocationManager {
	
	
	public static void addLocation(Player p, String map, String typeloc, String locnumber) {
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "Maps");
		File f = new File(data, File.separator + map + ".yml");
		FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
		
		if(typeloc.equalsIgnoreCase("lobby")) {
			if(locnumber.equalsIgnoreCase("null")) {
				if(!f.exists()) {
					locationData.set("Lobby.X", p.getLocation().getX());
					locationData.set("Lobby.Y", p.getLocation().getY());
					locationData.set("Lobby.Z", p.getLocation().getZ());
				}else {
					locationData.set("Lobby.X", p.getLocation().getX());
					locationData.set("Lobby.Y", p.getLocation().getY());
					locationData.set("Lobby.Z", p.getLocation().getZ());
					
				}
				try {
					locationData.save(f);
				}catch(IOException ex) {
					ex.printStackTrace();
				}
				p.sendMessage(MessageAPI.getServerPrefix() + " §aLobby Location has been set from §6" + map + " §aMap!");
				
			}
		}
		else {
			p.sendMessage(MessageAPI.getServerPrefix() + " §cUnknown spawn type !");
		}	
	}

}
