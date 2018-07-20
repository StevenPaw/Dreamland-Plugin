package de.zwibbltv.dreamland.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class BoatEverwoods {
	
	public static void spawnBoat(Entity e) {

		World w = Bukkit.getWorld("dreamland");
		if(e.getVehicle() instanceof Boat){
			Boat b = (Boat)e.getVehicle();

			Location loc = b.getLocation();
		Double d;
		d = loc.distance(new Location(w, -682, 22.0, 660.0));
		if(d >= 3) {
		
		loc.getWorld().spawnEntity(loc, EntityType.BOAT);
		}
		}
	}

}
