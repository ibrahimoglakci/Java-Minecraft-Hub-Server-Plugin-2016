package me.minegamersg.commands;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;

public class HistoryCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Player target = (Player) Bukkit.getPlayer(args[0]);
		if(cmd.getName().equalsIgnoreCase("history")) {
			try {
				if(!(MySQLAPI.getRank(p).equalsIgnoreCase("moderator")) || !(MySQLAPI.getRank(p).equalsIgnoreCase("ADMIN")) || !(MySQLAPI.getRank(p).equalsIgnoreCase("OWNER")) || !(MySQLAPI.getRank(p).equalsIgnoreCase("DEV")) || !(MySQLAPI.getRank(p).equalsIgnoreCase("LEADDEV"))) {
					p.sendMessage(MessageAPI.getNoPermMessage(p));
				}else {
					//TODO Show target history's..
					p.sendMessage(MessageAPI.getServerPrefix() + " " + target.getDisplayName() + "§7's §9Historys.");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}

}
