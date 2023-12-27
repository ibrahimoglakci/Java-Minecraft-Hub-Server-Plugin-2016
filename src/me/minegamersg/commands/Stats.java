package me.minegamersg.commands;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
//import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.MySQLAPI;

public class Stats implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("stats")) {
			if(args.length == 0) {
				try {
					if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
						p.sendMessage(MessageAPI.getServerPrefix() + " §r" + p.getDisplayName() + "§f's Records");
						p.sendMessage(MessageAPI.getServerPrefix() + " §fRank§8: §9§l" + MySQLAPI.getRank(p).toUpperCase());
						p.sendMessage(MessageAPI.getServerPrefix() + " §fPoints§8: §e" + MySQLAPI.getBounty(p));
						p.sendMessage(MessageAPI.getServerPrefix() + " §fGames (Won/Total)§8: §e" + MySQLAPI.getGamesWon(p) + "§8/§e" + MySQLAPI.getGamesTotal(p));
						p.sendMessage(MessageAPI.getServerPrefix() + " §fKills§8/§fDeaths§8: §e" + MySQLAPI.getKills(p) + "§8/§e" + MySQLAPI.getDeaths(p));
						p.sendMessage(MessageAPI.getServerPrefix() + " §fChests (Tier1/Tier2/All)§8: §e" + MySQLAPI.getTier1ChestOpen(p) + "§8/§e" + MySQLAPI.getTier2ChestOpen(p) + "§8/§e" + MySQLAPI.getAllChestOpen(p));
					}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
						p.sendMessage(MessageAPI.getServerPrefix() + " §r" + p.getDisplayName() + "§f'nýn Kayýtlarý");
						p.sendMessage(MessageAPI.getServerPrefix() + " §fYetki§8: §9§l" + MySQLAPI.getRank(p).toUpperCase());
						p.sendMessage(MessageAPI.getServerPrefix() + " §fPuan§8: §e" + MySQLAPI.getBounty(p));
						p.sendMessage(MessageAPI.getServerPrefix() + " §fOyun (Kazanma/Toplam)§8: §e" + MySQLAPI.getGamesWon(p) + "§8/§e" + MySQLAPI.getGamesTotal(p));
						p.sendMessage(MessageAPI.getServerPrefix() + " §fÖldürme§8/§fÖlüm§8: §e" + MySQLAPI.getKills(p) + "§8/§e" + MySQLAPI.getDeaths(p));
						p.sendMessage(MessageAPI.getServerPrefix() + " §fSandýklar (Tier1/Tier2/Hepsi)§8: §e" + MySQLAPI.getTier1ChestOpen(p) + "§8/§e" + MySQLAPI.getTier2ChestOpen(p) + "§8/§e" + MySQLAPI.getAllChestOpen(p));
					}
				
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}else if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						
						try {
							if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §r" + target.getDisplayName() + "§f's Records");
								p.sendMessage(MessageAPI.getServerPrefix() + " §fRank§8: §9§l" + MySQLAPI.getRank(target).toUpperCase());
								p.sendMessage(MessageAPI.getServerPrefix() + " §fPoints§8: §e" + MySQLAPI.getBounty(target));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fGames (Won/Total)§8: §e" + MySQLAPI.getGamesWon(target) + "§8/§e" + MySQLAPI.getGamesTotal(target));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fKills§8/§fDeaths§8: §e" + MySQLAPI.getKills(target) + "§8/§e" + MySQLAPI.getDeaths(target));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fChests (Tier1/Tier2/All)§8: §e" + MySQLAPI.getTier1ChestOpen(target) + "§8/§e" + MySQLAPI.getTier2ChestOpen(p) + "§8/§e" + MySQLAPI.getAllChestOpen(target));
							}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §r" + target.getDisplayName() + "§f'nýn Kayýtlarý");
								p.sendMessage(MessageAPI.getServerPrefix() + " §fYetki§8: §9§l" + MySQLAPI.getRank(target).toUpperCase());
								p.sendMessage(MessageAPI.getServerPrefix() + " §fPuan§8: §e" + MySQLAPI.getBounty(target));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fOyun (Kazanma/Toplam)§8: §e" + MySQLAPI.getGamesWon(target) + "§8/§e" + MySQLAPI.getGamesTotal(target));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fÖldürme§8/§fÖlüm§8: §e" + MySQLAPI.getKills(target) + "§8/§e" + MySQLAPI.getDeaths(target));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fSandýklar (Tier1/Tier2/Hepsi)§8: §e" + MySQLAPI.getTier1ChestOpen(target) + "§8/§e" + MySQLAPI.getTier2ChestOpen(target) + "§8/§e" + MySQLAPI.getAllChestOpen(target));
							}
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						
					}else {
						try {
							
							if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §r" + Bukkit.getPlayer(target.getName()).getDisplayName() + "§f's Records");
								p.sendMessage(MessageAPI.getServerPrefix() + " §fRank§8: §9§l" + MySQLAPI.getRank(Bukkit.getPlayer(target.getName())).toUpperCase());
								p.sendMessage(MessageAPI.getServerPrefix() + " §fPoints§8: §e" + MySQLAPI.getBounty(Bukkit.getPlayer(target.getName())));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fGames (Won/Total)§8: §e" + MySQLAPI.getGamesWon(Bukkit.getPlayer(target.getName())) + "§8/§e" + MySQLAPI.getGamesTotal(Bukkit.getPlayer(target.getName())));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fKills§8/§fDeaths§8: §e" + MySQLAPI.getKills(Bukkit.getPlayer(target.getName())) + "§8/§e" + MySQLAPI.getDeaths(Bukkit.getPlayer(target.getName())));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fChests (Tier1/Tier2/All)§8: §e" + MySQLAPI.getTier1ChestOpen(Bukkit.getPlayer(target.getName())) + "§8/§e" + MySQLAPI.getTier2ChestOpen(Bukkit.getPlayer(target.getName())) + "§8/§e" + MySQLAPI.getAllChestOpen(Bukkit.getPlayer(target.getName())));
							}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §r" + Bukkit.getPlayer(target.getName()).getDisplayName() + "§f'nýn Kayýtlarý");
								p.sendMessage(MessageAPI.getServerPrefix() + " §fYetki§8: §9§l" + MySQLAPI.getRank(Bukkit.getPlayer(target.getName())).toUpperCase());
								p.sendMessage(MessageAPI.getServerPrefix() + " §fPuan§8: §e" + MySQLAPI.getBounty(Bukkit.getPlayer(target.getName())));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fOyun (Kazanma/Toplam)§8: §e" + MySQLAPI.getGamesWon(Bukkit.getPlayer(target.getName())) + "§8/§e" + MySQLAPI.getGamesTotal(Bukkit.getPlayer(target.getName())));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fÖldürme§8/§fÖlüm§8: §e" + MySQLAPI.getKills(Bukkit.getPlayer(target.getName())) + "§8/§e" + MySQLAPI.getDeaths(Bukkit.getPlayer(target.getName())));
								p.sendMessage(MessageAPI.getServerPrefix() + " §fSandýklar (Tier1/Tier2/Hepsi)§8: §e" + MySQLAPI.getTier1ChestOpen(Bukkit.getPlayer(target.getName())) + "§8/§e" + MySQLAPI.getTier2ChestOpen(Bukkit.getPlayer(target.getName())) + "§8/§e" + MySQLAPI.getAllChestOpen(Bukkit.getPlayer(target.getName())));
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}else {
					p.sendMessage(MessageAPI.getServerPrefix() + " §cPlayer is not found!");
				}
				
			}
		}
		return false;
	}
	
	
	

}
