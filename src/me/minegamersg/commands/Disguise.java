package me.minegamersg.commands;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;

public class Disguise implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		File data = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "DisguiseName");
		File f = new File(data, File.separator + "RandomName1.yml");
		FileConfiguration randomname1 = YamlConfiguration.loadConfiguration(f);
		File data2 = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "DisguiseName");
		File f2 = new File(data2, File.separator + "RandomName2.yml");
		FileConfiguration randomname2 = YamlConfiguration.loadConfiguration(f2);
		File data3 = new File(Bukkit.getPluginManager().getPlugin("XemeGamer").getDataFolder(), File.separator + "DisguiseName");
		File f3 = new File(data3, File.separator + "RandomName3.yml");
		FileConfiguration randomname3 = YamlConfiguration.loadConfiguration(f3);
		//File data4 = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "DisguiseName");
		//File f4 = new File(data4, File.separator + "RandomSkin.yml");
		//FileConfiguration randomskin = YamlConfiguration.loadConfiguration(f4);
		if(cmd.getName().equalsIgnoreCase("disguise")) {
			if(args.length == 0) {
				try {
					if(!(MySQLAPI.getRank(p).equalsIgnoreCase("regular"))) {
						
						List<String> tod1 = randomname1.getStringList("RandomName-List-1");
					    
					    Random rand = new Random();
					    int choice1 = rand.nextInt(tod1.size());
					    String name1 = (String)tod1.get(choice1);
					    List<String> tod2 = randomname2.getStringList("RandomName-List-2");
					    Random rand1 = new Random();
					    int choice2 = rand1.nextInt(tod2.size());
					    String name2 = (String)tod2.get(choice2);
					    List<String> tod3 = randomname3.getStringList("RandomName-List-3");
					    Random rand2 = new Random();
					    int choice3 = rand2.nextInt(tod3.size());
					    String name3 = (String)tod3.get(choice3);
					    String rdname = name1+name2+name3;
					  /*  List<String> skin = randomskin.getStringList("RandomSkins");
					    Random randskin = new Random();
					    int choiceskin = randskin.nextInt(skin.size());
					    String rdskin = (String)skin.get(choiceskin);
					    */
					    if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
						    p.sendMessage(MessageAPI.getServerPrefix() + " §c§lWarning! §cThis command is loged!");
							p.sendMessage(MessageAPI.getServerPrefix() + " §cStaff can see your real username !");
							p.sendMessage(MessageAPI.getServerPrefix() + " §eGenerating Random username...");
							p.sendMessage(MessageAPI.getServerPrefix() + " §eYou now appear as §2" + rdname);
							p.sendMessage(MessageAPI.getServerPrefix() + " §eTo undisguise, use §8[§e/undisguise§8]");
					    }else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
					    	p.sendMessage(MessageAPI.getServerPrefix() + " §c§lDikkat! §cBu komut dosyaya kaydedilir!");
							p.sendMessage(MessageAPI.getServerPrefix() + " §cYetkililer gerçek kullanýcý adýnýzý görebilir !");
							p.sendMessage(MessageAPI.getServerPrefix() + " §eRastgele kullanýcý adý oluþturuluyor...");
							p.sendMessage(MessageAPI.getServerPrefix() + " §eYeni kullanýcý adýnýz §2" + rdname);
							p.sendMessage(MessageAPI.getServerPrefix() + " §eEski halinize dönmek için §8[§e/undisguise§8]");
					    }
						//p.setDisplayName("§2" + rdname);
						//p.setPlayerListName("§2" + rdname);
						//p.setCustomName("§2" + rdname);
						//p.setCustomNameVisible(true);
						
					}else {
						p.sendMessage(MessageAPI.getNoPermMessage(p));
						p.sendMessage(MessageAPI.getbuyDonatorMessage(p));
					}
					
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	

}
