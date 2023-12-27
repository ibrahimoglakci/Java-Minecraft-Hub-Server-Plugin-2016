package me.minegamersg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.RankAPI;

public class RankCommands implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("rank")) {
				if(args.length == 2){			
					RankAPI.setRank(Bukkit.getPlayer(args[0]), args[1].toUpperCase());			
				}else if(args.length == 0 || args.length == 1) {
					p.sendMessage(MessageAPI.getServerPrefix() + " §c/rank [<player>] [<regular/gold/diamond/platinum/yt/moderator/builder/dev/leaddev/admin/owner>]");
				}
			
			}
		
		return false;
	}

}
