package me.minegamersg.api;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;

public class TabAPI {
	
	 public static void sendTablist(Player p){
	        CraftPlayer craftplayer = (CraftPlayer) p;
	        PlayerConnection connection = craftplayer.getHandle().playerConnection;
	        IChatBaseComponent header = ChatSerializer.a("{\"text\": \"§6mc.nerd-lounge.de §d/daten\"}");
	        IChatBaseComponent footer = ChatSerializer.a("{\"text\": \"§6Homepage: nerd-lounge.de\n §eTeamSpeak3: ts3 " + "\n\n§aSpieler §eNerd §6VIP §7NerdDesMonats\n§8Elite §3Supporter §bArchitekt §5Moderator\n§9Admin §4Besitzer\"}");
	        PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();

	        try {
	            Field headerField = packet.getClass().getDeclaredField("a");
	            headerField.setAccessible(true);
	            headerField.set(packet, header);
	            headerField.setAccessible(!headerField.isAccessible());
	       
	            Field footerField = packet.getClass().getDeclaredField("b");
	            footerField.setAccessible(true);
	            footerField.set(packet, footer);
	            footerField.setAccessible(!footerField.isAccessible());
	        } catch (Exception exc) {
	            exc.printStackTrace();
	        }
	        connection.sendPacket(packet);
	    }

}
