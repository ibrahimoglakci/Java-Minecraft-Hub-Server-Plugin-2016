package me.minegamersg.api;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.bukkit.ChatColor;


public class GetServerMotd {
	
	
	public static String getMOTD(String ip, int port) {
		try {
		Socket sock = new Socket();
		sock.setSoTimeout(100);
		sock.connect(new InetSocketAddress(ip, port), 100);
		 
		DataOutputStream out = new DataOutputStream(sock.getOutputStream());
		DataInputStream in = new DataInputStream(sock.getInputStream());
		 
		out.write(0xFE);
		 
		int b;
		StringBuffer str = new StringBuffer();
		while ((b = in .read()) != -1) {
		if (b != 0 && b > 16 && b != 255 && b != 23 && b != 24) {
		str.append((char) b);
		}
		}
		 
		String[] data = str.toString().split(String.valueOf(ChatColor.COLOR_CHAR));
		String serverMotd = data[0];
		 
		sock.close();
		 
		System.out.println(String.format(serverMotd));
		return String.format(serverMotd);
		 
		 
		} catch (ConnectException e) {
		return"ConnectException";
		} catch (UnknownHostException e) {
		return"UnknownHostException";
		} catch (IOException e) {
		return "IOException";
		}
		 
		}

}
