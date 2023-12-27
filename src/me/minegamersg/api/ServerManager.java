package me.minegamersg.api;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.minegamersg.Main.Main;

public class ServerManager {
	
	
	public static void connectSGServer(Player p, String server) { 
		 Bukkit.getMessenger().registerOutgoingPluginChannel(Main.getSGAPI(), "BungeeCord");
		 
		 ByteArrayOutputStream b = new ByteArrayOutputStream();
		 DataOutputStream out = new DataOutputStream(b);
		  
		 if(server != null) {
			 try {
				 
			 out.writeUTF("Connect");
			 out.writeUTF(server);
			 p.sendMessage("§8[§3Xeme§8] §fConnecting to §6" + server + "§7(SurvivalGames)");
			 } catch (IOException ex) {
				 ex.printStackTrace();
			 }
			 p.sendPluginMessage(Main.getSGAPI(), "BungeeCord", b.toByteArray());
		 }else {
			 
			Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §c§lServer is not founded!");
			 
		 }
	}

}
