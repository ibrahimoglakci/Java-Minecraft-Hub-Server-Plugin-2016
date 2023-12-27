package me.minegamersg.commands;

import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;

public class FlyandGamemodes implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if((sender instanceof Player)) {
				if(args.length == 0) {
					try {
						if(!(MySQLAPI.getRank(p).equalsIgnoreCase("regular"))) {
							if(p.getAllowFlight() == true) {
								p.setAllowFlight(false);
								if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §fFlight mode §cDisabled§8!");
								}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §fUçuþ modu §cKapalý§8!");
								}
								
							}else {
								p.setAllowFlight(true);
								if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §fFlight mode §aEnable§8!");
								}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §fUçuþ modu §aAçýk§8!");
								}
							}
						}else {
							p.sendMessage(MessageAPI.getNoPermMessage(p));
							p.sendMessage(MessageAPI.getbuyDonatorMessage(p));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return false;
	}
	
	

}
