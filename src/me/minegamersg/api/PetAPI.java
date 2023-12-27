package me.minegamersg.api;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftLivingEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_7_R4.EntityInsentient;

public class PetAPI {
	
	public static Player owner;
	public static LivingEntity pet;
	
	
	public static void spawnPets(Player p, EntityType type, String petname) {
	
		owner = p;
		pet = (LivingEntity) p.getWorld().spawnEntity(p.getLocation(), type);
		pet.setCustomName(petname);
		pet.setCustomNameVisible(true);
		tick();
		
	}
	
	public static void tick(){ 
		
		double dist = pet.getLocation().distanceSquared(owner.getLocation());
		if(dist > 10) {
			if(dist > 510) {
				pet.teleport(owner);
			}
			walkTO(owner.getLocation().clone().add(1, 0, 0), 1.5);
		}
	}
	
	public static void walkTO(Location targetlocation, double speed) {
		EntityInsentient c = (EntityInsentient) ((CraftLivingEntity)pet).getHandle();
		c.getNavigation().a(targetlocation.getX(), targetlocation.getY(), targetlocation.getZ(), speed);
	}
	
}
