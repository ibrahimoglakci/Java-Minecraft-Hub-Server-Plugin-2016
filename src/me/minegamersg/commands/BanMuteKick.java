package me.minegamersg.commands;
 
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Enum.TimeUnit;
import me.minegamersg.api.BanManager;
import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MuteManager;

public class BanMuteKick implements CommandExecutor {
 
 
 
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	
        if(cmd.getName().equalsIgnoreCase("ban")) {
        	if (args.length == 1) {
        		if(args[0].equalsIgnoreCase("help")) {
        			banHelpPage(sender);
        			return true;
        		}
        	}
	    	if(args.length < 3){
	            banhelpMessage(sender);
	            return true;
	        }
	 
	        String targetName = args[0];
	 
	        UUID targetUUID = Bukkit.getPlayer(targetName).getUniqueId();
	 
	      //  if(BanManager.isBanned(targetUUID)){
	        //    sender.sendMessage("§cCe joueur est déjà banni !");
	        //}
	        Player target = (Player) Bukkit.getPlayer(targetName);
	        String reason = "";
	        if(BanManager.isBanned(targetUUID)) {
	        	sender.sendMessage(MessageAPI.getServerPrefix() + " §9" + target.getName()  +  " §cis already banned this server!");
	        	return true;
	        }
	        for(int i = 2; i < args.length; i++){
	            reason += args[i] + " ";
	        }
	 
	        if(args[1].equalsIgnoreCase("perm")){
	            try {
	            	BanManager.ban(targetUUID, -1, reason);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            sender.sendMessage(MessageAPI.getServerPrefix() + " §7You have kicked to §c" + target.getName() + " §7on this server§8. §7Time§8:§4 PERMANENT§8." + " §7Reason§8:§c " + reason + "§8.");
	            target.kickPlayer("§7You are §4banned §7from the XemeGamer Network !\n " +
	                    "\n " +
	                    "§7Your ban will expire in §4PERMANENT" +
	                    "\n" +
	                    "§7Reason§8: §8[§3Xeme§8]§c " + BanManager.getReason(target.getUniqueId()) +  
	                    "\n" + "\n" + 
	                    "§7Do you believe you were unfairly banned§8?" +
	                    "\n" + 
	                    "§2Visit §6http://dispute.xemegamer.info §2to dispute your ban§8.");
	        }
	 
	        if(!args[1].contains(":")){
	            banhelpMessage(sender);
	        }
	 
	        int duration = 0;
	        try {
	            duration = Integer.parseInt(args[1].split(":")[0]);
	        } catch(NumberFormatException e){
	            sender.sendMessage("§cThe value duration must be a number !");
	 
	        }
	 
	        if(!TimeUnit.existFromShortcut(args[1].split(":")[1])){
	            sender.sendMessage("§cThis unit of time does not exist !");
	            
	        }
	 
	        TimeUnit unit = TimeUnit.getFromShortcut(args[1].split(":")[1]);
	        long banTime = unit.getToSecond() * duration;
	 
	        try {
				BanManager.ban(targetUUID, banTime, reason);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        sender.sendMessage(MessageAPI.getServerPrefix() + " §7You have kicked to §c" + target.getName() + " §7on this server§8. §7Time§8: §8[§c" + duration + "§8]§c "+  unit.getName() + " §8." + " §7Reason§8:§c " + reason + "§8.");
	        target.kickPlayer("§7You are §4banned §7from the XemeGamer Network !\n " +
                    "\n " +
                    "§7Your ban will expire in " + "§8[§c" + duration + "§8]§c " + unit.getName() +
                    "\n" +
                    "§7Reason§8: §8[§3Xeme§8]§c " + BanManager.getReason(target.getUniqueId()) +  
                    "\n" + "\n" + 
                    "§7Do you believe you were unfairly banned§8?" +
                    "\n" + 
                    "§2Visit §6http://dispute.xemegamer.info §2to dispute your ban§8.");
        }
        
        if(cmd.getName().equalsIgnoreCase("unban")) {
        	String targetName = args[0];
       	 
	        UUID targetUUID = Bukkit.getPlayer(targetName).getUniqueId();
	        Player target = (Player) Bukkit.getPlayer(targetName);
        	if(!BanManager.isBanned(targetUUID)) {
	        	sender.sendMessage(MessageAPI.getServerPrefix() + " §9" + target.getName()  +  " §cis not banned this server!");
	        	return true;
	        }else {
	        	BanManager.unban(targetUUID);
	        }
        }
        
        if(cmd.getName().equalsIgnoreCase("unmute")) {
        	String targetName = args[0];
       	 
	        UUID targetUUID = Bukkit.getPlayer(targetName).getUniqueId();
	        Player target = (Player) Bukkit.getPlayer(targetName);
        	if(!MuteManager.isMuted(targetUUID)) {
	        	sender.sendMessage(MessageAPI.getServerPrefix() + " §9" + target.getName()  +  " §cis not muted this server!");
	        	return true;
	        }else {
	        	MuteManager.unMute(targetUUID);
	        	target.sendMessage(MessageAPI.getServerPrefix() + " §7You have unmuted by §7Server§8.");
	        }
        }
        if(cmd.getName().equalsIgnoreCase("Mute")) {
        	if (args.length == 1) {
        		if(args[0].equalsIgnoreCase("help")) {
        			muteHelpPage(sender);
        			return true;
        		}
        	}
	    	if(args.length < 3){
	            mutehelpMessage(sender);
	            return true;
	        }
	 
	        String targetName = args[0];
	 
	        UUID targetUUID = Bukkit.getPlayer(targetName).getUniqueId();
	 
	      //  if(BanManager.isBanned(targetUUID)){
	        //    sender.sendMessage("§cCe joueur est déjà banni !");
	        //}
	        Player target = (Player) Bukkit.getPlayer(targetName);
	        String reason = "";
	        if(MuteManager.isMuted(targetUUID)) {
	        	sender.sendMessage(MessageAPI.getServerPrefix() + " §9" + target.getName()  +  " §cis already muted this server!");
	        	return true;
	        }
	        for(int i = 2; i < args.length; i++){
	            reason += args[i] + " ";
	        }
	 
	        if(args[1].equalsIgnoreCase("perm")){
					try {
					    MuteManager.mute(targetUUID, -1, reason);
					    target.sendMessage(MessageAPI.getServerPrefix() + " §7You have been muted by server§8. §7TimeLeft§8:§4 PERMANENT §7Reason§8: §c" + MuteManager.getReason(target.getUniqueId()) + "§8.");
						
				         sender.sendMessage(MessageAPI.getServerPrefix() + " §7You have muted to §c" + target.getName() + " §7on this server§8. §7Time§8:§4 PERMANENT§8." + " §7Reason§8:§c " + reason + "§8.");
				      
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        }

	        if(!args[1].contains(":") && !args[1].equalsIgnoreCase("perm")){
	           banhelpMessage(sender);
	        }
	 
	        int duration = 0;
	        try {
	            duration = Integer.parseInt(args[1].split(":")[0]);
	        } catch(NumberFormatException e){
	            sender.sendMessage("§cThe value duration must be a number !");
	 
	        }
	 
	        if(!TimeUnit.existFromShortcut(args[1].split(":")[1])){
	            sender.sendMessage("§cThis unit of time does not exist !");
	         
	        }
	 
	        TimeUnit unit = TimeUnit.getFromShortcut(args[1].split(":")[1]);
	        long banTime = unit.getToSecond() * duration;
	 
	        try {
				MuteManager.mute(targetUUID, banTime, reason);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        target.sendMessage(MessageAPI.getServerPrefix() + " §7You have been muted by server§8. §7TimeLeft§8: " + MuteManager.getTimeLeft(target.getUniqueId()) + " §7Reason§8: §c" + MuteManager.getReason(target.getUniqueId()) + "§8.");
			
	        sender.sendMessage(MessageAPI.getServerPrefix() + " §7You have muted to §c" + target.getName() + " §7on this server§8. §7Time§8: §8[§c" + duration + "§8]§c "+  unit.getName() + " §8." + " §7Reason§8:§c " + reason + "§8.");
	       
        
    
        }
        if(cmd.getName().equalsIgnoreCase("kick")) {
			
 	      
	    	if(args.length < 1){
				 kickhelpMessage(sender);
				 return true;
				
	        }
	    	if(args.length == 1) {
	    		String targetName = args[0];
	 	        Player target = (Player) Bukkit.getPlayer(targetName);
				target.kickPlayer(MessageAPI.getServerPrefix() + " §7You have been §4kicked §7from the server§8.");
					
	    	}else if(args.length > 1) {
		        String reason = "";
		        
		        for(int i = 1; i < args.length; i++){
		            reason += args[i] + " ";
		        }
		        String targetName = args[0];
	 	        Player target = (Player) Bukkit.getPlayer(targetName);
		        target.kickPlayer(MessageAPI.getServerPrefix() + " §7You have been §4kicked §7from the server§8. §7Reason§8:§c " + reason);
	    	}
        }
        
		
        
       
       return false;
     
    }
    

       
        
	      
	        
    
 
	public void kickhelpMessage(CommandSender sender) {

        sender.sendMessage(MessageAPI.getServerPrefix() + " §c/kick §8[§c<playername>§8] [§c<reason>§8].");
		
	}








	public void mutehelpMessage(CommandSender sender) {
		
		sender.sendMessage(MessageAPI.getServerPrefix() + " §c/mute §8[§c<help>§8] §e-> §7Helping commands and times from Mute§8.");
        sender.sendMessage(MessageAPI.getServerPrefix() + " §c/mute §8[§c<playername>§8] §8[§c<permanent>§8] [§c<reason>§8].");
        sender.sendMessage(MessageAPI.getServerPrefix() + " §c/mute §8[§c<playername>§8] [§c<long>§8]§7:§8[§c<time>§8] [§c<reason>§8].");
    
	}


	public void muteHelpPage(CommandSender sender) {
		sender.sendMessage(MessageAPI.clearPlayerChat());
		sender.sendMessage("§8-=-=-=  §b§lXemeGamer §cModerator §7Mute Help Page §7(1/1) §8=-=-=-");
		sender.sendMessage(MessageAPI.getServerPrefix() + " §9Times Name and shortcuts§8:");
		for(TimeUnit units : TimeUnit.values()) {
			sender.sendMessage(MessageAPI.getServerPrefix() + " §5" + units.getName() + "§8: §e" + units.getShortcut() + "§8.");
		}
		sender.sendMessage(MessageAPI.getServerPrefix() + " §5Permanent§8:§e perm§8.");
		sender.sendMessage("§9§lExample§8: §6/mute §aNotch §610§c:§esec§7(seconds) §4Said Wrong words on this server§7(Reason)§8.");
	}


	public void banHelpPage(CommandSender sender) {
		sender.sendMessage(MessageAPI.clearPlayerChat());
		sender.sendMessage("§8-=-=-=  §b§lXemeGamer §cModerator §7Ban Help Page §7(1/1) §8=-=-=-");
		sender.sendMessage(MessageAPI.getServerPrefix() + " §9Times Name and shortcuts§8:");
		for(TimeUnit units : TimeUnit.values()) {
			sender.sendMessage(MessageAPI.getServerPrefix() + " §5" + units.getName() + "§8: §e" + units.getShortcut() + "§8.");
		}
		sender.sendMessage(MessageAPI.getServerPrefix() + " §5Permanent§8:§e perm§8.");
		sender.sendMessage("§9§lExample§8: §6/ban §aNotch §610§c:§esec§7(seconds) §4Hacking on this server§7(Reason)§8.");
		
	}

	public void banhelpMessage(CommandSender sender){
		sender.sendMessage(MessageAPI.getServerPrefix() + " §c/ban §8[§c<help>§8] §e-> §7Helping commands and times from Bannig§8.");
        sender.sendMessage(MessageAPI.getServerPrefix() + " §c/ban §8[§c<playername>§8] §8[§c<permanent>§8] [§c<reason>§8].");
        sender.sendMessage(MessageAPI.getServerPrefix() + " §c/ban §8[§c<playername>§8] [§c<long>§8]§7:§8[§c<time>§8] [§c<reason>§8].");
    }

	
}