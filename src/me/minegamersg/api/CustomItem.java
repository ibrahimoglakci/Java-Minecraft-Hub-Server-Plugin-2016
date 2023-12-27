package me.minegamersg.api;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItem {

	private ItemStack item;
	
	public CustomItem(Material material, int amount, int materialtype) {
		if(amount == 0) {
			item = new ItemStack(material, 1, (short) materialtype);
		}else {
			item = new ItemStack(material, amount, (short) materialtype);
			
		}
	}
	
	public CustomItem addEnchant(Enchantment ench, int level, boolean status) {
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(ench, level, status);
		item.setItemMeta(meta);
		return this;
		
	}
	
	public CustomItem setDisplayName(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name.replace("&", "§"));
		item.setItemMeta(meta);
		return this;
	}
	
	public CustomItem setLore(String... args) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(Arrays.asList(args));
		item.setItemMeta(meta);
		
		return this;
		
	}
	
	public CustomItem infiniteDurability() {
		item.setDurability((short)-32768);
		return this;
	}
		
	public ItemStack build() {
		return item;
	}
}
