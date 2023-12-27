package me.minegamersg.commands;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.ServerManager;

public class ServerCommand implements CommandExecutor{
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("server")) {
			if(args.length == 0 ) {
				p.sendMessage(MessageAPI.getServerPrefix() + " §c/server <game> <id>");
			}else if (args.length == 1) {
				if(args[0].equalsIgnoreCase("sg")) {
					ArrayList<String> servers = new ArrayList<>();
					servers.add("SG-1453");
					servers.add("SG-1299");
					 Random randserver = new Random();
					 int choice1 = randserver.nextInt(servers.size());
					 String selectserver = (String)servers.get(choice1);
					 ServerManager.connectSGServer(p, selectserver);
				}
			}else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("sg")) {
					if(args[1].equalsIgnoreCase("1453") || args[1].equalsIgnoreCase("1299")) {
						ServerManager.connectSGServer(p, "SG-" + args[1]);
					}else {
						p.sendMessage(MessageAPI.getServerPrefix() + " §fThe game '" + args[0] + "was not recognized!");
					}
				}
			}
		}
		
		return false;
	}

}
