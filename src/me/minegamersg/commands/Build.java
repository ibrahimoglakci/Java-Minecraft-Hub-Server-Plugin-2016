package me.minegamersg.commands;

import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;

public class Build implements CommandExecutor{
	
	public static boolean buildmode;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("build")) {
			if(p.hasPermission("asd.asd")) {
				if(args.length == 0){
					p.sendMessage(MessageAPI.getServerPrefix() + " §cUsage: /build <on:off>");
				}else {
					if(args[0].equalsIgnoreCase("on")) {
						if(buildmode != true){
							buildmode = true;
							try {
								if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §bYou have enabled §eBuild §bmode§8.");
									p.sendMessage(MessageAPI.getServerPrefix() + " §cBlocks in Survival Games will not save§8.");
									p.sendMessage(MessageAPI.getServerPrefix() + " §cPlease get an admin if you wish to do this§8.");
									p.sendMessage(MessageAPI.getServerPrefix() + " §bUse §e/build off §bto leave this mode§8.");
								}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §bSen §eÝnþa §bmodunu §baktifleþtirdin§8.");
									p.sendMessage(MessageAPI.getServerPrefix() + " §cSurvival Games'deki bloklar kaydedilmeyecek§8.");
									p.sendMessage(MessageAPI.getServerPrefix() + " §cEðer yapamýyorsanýz bir yöneticiye baþvurun§8.");
									p.sendMessage(MessageAPI.getServerPrefix() + " §e/build off §byazarak Ýnþa modunu kapatabilirsiniz§8.");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
						}else if(buildmode == true){
							try {
								if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §cAlready enabled §eBuild §cmode this server§8.");
								}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §cZaten §eÝnþa §cmodu sunucuda aktif§8.");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					if(args[0].equalsIgnoreCase("off")) {
						if(buildmode != false){
							buildmode = false;
							try {
								if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §bYou have disabled §eBuild §bmode§8.");
								}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §bSen §eÝnþa §bmodunu devre dýþý býraktýn§8.");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}else if(buildmode == false){
							try {
								if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §cAlready disabled §eBuild §cmode this server§8.");
								}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
									p.sendMessage(MessageAPI.getServerPrefix() + " §cZaten §eÝnþa §cmodu sunucuda kapalý§8.");
								}
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
				}
			}else {
				p.sendMessage(MessageAPI.getNoPermMessage(p));
			}
		} 
		return false;
	}

}
