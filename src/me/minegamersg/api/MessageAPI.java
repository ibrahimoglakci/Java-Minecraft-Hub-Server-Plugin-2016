package me.minegamersg.api;

import java.sql.SQLException;

import org.bukkit.entity.Player;

public class MessageAPI {

	
	static String prefix = "§8[§3Xeme§8]";
	
			
			
	public static String getServerPrefix() {
		
		return prefix;
	}
	
	public static String clearPlayerChat() {
		String clearChat = "";
		for (int x = 0; x < 150; x++){
			clearChat = "\n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n \n";
		}
		return clearChat;
	}
	
	public static String getNoPermMessage(Player p) {
		String nopermmessage = "";
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
				nopermmessage = getServerPrefix() + " §4You dont've permission this command.";
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				nopermmessage = getServerPrefix() + "  §4Bu iþlem için yeterli yetkin yok.";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nopermmessage;
	}
	
	public static String getbuyDonatorMessage(Player p) {
		String buydonator = "";
		try {
			if(MySQLAPI.getLanguage(p).equalsIgnoreCase("English")) {
			
				buydonator = getServerPrefix() + " §4Upgrade to §6Gold§8/§3Diamond§8/§bPlatinum §4on\n §8[§9shop.xemegamer.net§8]§4 for more ability!";
				
			}else if(MySQLAPI.getLanguage(p).equalsIgnoreCase("Turkish")) {
				buydonator = getServerPrefix() + " §4Daha fazla yetenek ve komutlar için §6Gold§8/§3Diamond§8/§bPlatinum §4yetkilerini\n §8[§9shop.xemegamer.net§8]§4 sayfasýndan satýn alabilirsiniz!";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buydonator;
	}

	
	public static void setColouredName(Player player) {
		if(player.getName().length() == 3) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 4) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 5) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 6) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 7) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 8) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 9) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 10) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 11) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 12) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 13) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 14) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 15) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
		else if(player.getName().length() == 16) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String sixteenth = words[15];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth + "§e§l" + sixteenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}else if(player.getName().length() == 17) {
			String[] words = player.getName().split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String sixteenth = words[15];
			String seventeenth = words[16];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth + "§e§l" + sixteenth + "§a§l" + seventeenth;
			player.setDisplayName(nick);
			player.setPlayerListName(nick);
		}
	}
	
	
	
	
	
	
	public static String setColouredString(String message) {
		if(message.length() == 3) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third;
			message = nick;;
		}
		else if(message.length() == 4) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth;
			message = nick;
			
		}
		else if(message.length() == 5) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth;
			message = nick;
			
		}
		else if(message.length() == 6) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth;
			message = nick;
			
		}
		else if(message.length() == 7) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh;
			message = nick;
			
		}
		else if(message.length() == 8) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth;
			message = nick;
			
		}
		else if(message.length() == 9) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth;
			message = nick;
			
		}
		else if(message.length() == 10) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth;
			message = nick;
			
		}
		else if(message.length() == 11) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh;
			message = nick;
			
		}
		else if(message.length() == 12) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth;
			message = nick;
			
		}
		else if(message.length() == 13) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth;
			message = nick;
			
		}
		else if(message.length() == 14) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth;
			message = nick;
			
		}
		else if(message.length() == 15) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth;
			message = nick;
			
		}
		else if(message.length() == 16) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String sixteenth = words[15];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth + "§e§l" + sixteenth;
			message = nick;
			
		}else if(message.length() == 17) {
			String[] words = message.split("");
			String first = words[0];
			String second = words[1];
			String third = words[2];
			String fourth = words[3];
			String fifth = words[4];
			String sixth = words[5];
			String seventh = words[6];
			String eightth = words[7];
			String nineth = words[8];
			String tenth = words[9];
			String eleventh = words[10];
			String twelfth = words[11];
			String thirteenth = words[12];
			String fourteenth = words[13];
			String fifteenth = words[14];
			String sixteenth = words[15];
			String seventeenth = words[16];
			String nick = "§4§l" + first + "§c§l" + second + "§6§l" + third + "§e§l" + fourth + "§a§l" + fifth + "§2§l" + sixth + "§b§l" + seventh + "§3§l" + eightth + "§9§l" + nineth + "§1§l" + tenth + "§5§l" + eleventh + "§d§l" + twelfth + "§4§l" + thirteenth + "§c§l" + fourteenth + "§6§l" + fifteenth + "§e§l" + sixteenth + "§a§l" + seventeenth;
			message = nick;
			
		}
		
		return message;
	}



	
}
