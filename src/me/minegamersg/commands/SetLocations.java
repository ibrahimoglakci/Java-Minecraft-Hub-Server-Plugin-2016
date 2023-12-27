package me.minegamersg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.LocationManager;
import me.minegamersg.api.MessageAPI;

public class SetLocations implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setloc")) {
			if(p.hasPermission("Sg.SetLocation")) {
				if(args.length == 0) {
					p.sendMessage(MessageAPI.getServerPrefix() + " §cUsage: /setloc <MapName> <lobby> <lobby = (null)>");
				}else if(args.length == 1) {
					p.sendMessage(MessageAPI.getServerPrefix() + " §cUsage: /setloc <MapName> <lobby> <lobby = (null)>");
				}else if(args.length == 2) {
					p.sendMessage(MessageAPI.getServerPrefix() + " §cUsage: /setloc <MapName> <lobby> <lobby = (null)>");
					
				}else if(args.length == 3) {
					LocationManager.addLocation(p, args[0], args[1], args[2]);
					p.sendMessage(MessageAPI.getServerPrefix() + " §aSuccesfully added locations to map. \n " + MessageAPI.getServerPrefix() + "§7Map Name§8: §c" + args[0]+ "§8.");
				}
			}
		}
		return false;
	}
	
	

}
