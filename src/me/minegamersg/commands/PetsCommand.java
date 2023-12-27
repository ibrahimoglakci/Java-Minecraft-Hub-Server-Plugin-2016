package me.minegamersg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.minegamersg.api.PetAPI;

public class PetsCommand implements CommandExecutor{

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)	sender;
		
		if(cmd.getName().equalsIgnoreCase("pets")) {
			PetAPI.spawnPets(p, EntityType.SHEEP, "§aSmart §7§lSheep");
		}
		
		return false;
	}

	
	

}
