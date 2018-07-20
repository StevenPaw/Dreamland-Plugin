package de.zwibbltv.dreamland.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

public class BoatEverwoods {

	public static void spawnBoat() {

		World w = Bukkit.getWorld("dreamland");

		Location loc = new Location(w, -682, 22.0, 660.0);


		Double d;
		d = loc.distance(loc);
		if(d >= 3) {

//			loc.getWorld().spawnEntity(loc, EntityType.BOAT);
		}
	}
}