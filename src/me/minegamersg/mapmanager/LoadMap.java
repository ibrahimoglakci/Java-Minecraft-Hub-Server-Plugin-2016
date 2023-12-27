package me.minegamersg.mapmanager;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class LoadMap {
	
	
	
	
	public static void loadWorld(World world) {
		
		if(!Bukkit.getWorlds().contains(world)) {
			Bukkit.getWorlds().add(world);
			Bukkit.broadcastMessage("§f[MapController] §aLoading Worlds §8(§6" + world.getName() + "§8) §a...");
		}
		
	}

}
