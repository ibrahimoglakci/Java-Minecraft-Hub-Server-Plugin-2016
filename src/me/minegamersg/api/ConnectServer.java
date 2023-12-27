package me.minegamersg.api;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.minegamersg.Main.Main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;

public class ConnectServer {
	
	
	public static void connectServer(Player p, String server) { 
		 
		 ByteArrayDataOutput out = ByteStreams.newDataOutput();
	        out.writeUTF("Connect");
	        out.writeUTF(server);
	       p.sendPluginMessage((Plugin) Main.getSGAPI(), "BungeeCord", out.toByteArray());
	}
	
	public static int onliePlayerServer(String server) { 
		
		ServerInfo target = ProxyServer.getInstance().getServerInfo(server);
		int onlinep = target.getPlayers().size();
		
		return onlinep;
	}

}
