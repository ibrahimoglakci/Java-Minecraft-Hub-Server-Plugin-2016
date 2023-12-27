package me.minegamersg.listener;

import java.sql.SQLException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.minegamersg.api.MySQLAPI;
import me.minegamersg.commands.Build;

public class BlockPlaceListener implements Listener{
	
	
	@EventHandler
	public void blockBreakListener(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(Build.buildmode == true){
			try {
				if(MySQLAPI.getRank(p).equalsIgnoreCase("builder") || MySQLAPI.getRank(p).equalsIgnoreCase("owner") || MySQLAPI.getRank(p).equalsIgnoreCase("leaddev")) {
						e.setCancelled(false);
						
				
				}else {
					e.setCancelled(true);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(Build.buildmode == false) {
			e.setCancelled(true);
		}
		
	}

}
