package de.zwibbltv.dreamland.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public class BoatEverwoods {

	static World w = Bukkit.getWorld("dreamland"); //setzt die Welt fest
	static ArrayList <Location> boatloc = new ArrayList<Location>();
	static ArrayList <Location> spawnloc = new ArrayList<Location>();
	static int Radius = 2;

	//ERSTELLT ALLE KOORDINATEN UND SO FÜR DIE BOOTE
	public static void InstantiateBoat() {

		boatloc.add(new Location(w,-776,16,794)); //setzt die Boot-koordinaten fest
		spawnloc.add(new Location(w,-780,16,792));
		boatloc.add(new Location(w,-737,16,684));
		spawnloc.add(new Location(w,-734,16,684));

	}

	public static void runBoatThings() {
		for(Location loc : boatloc) {
			if (!TestForBoat(loc)) {
				spawnBoat(loc);
			}
		}
	}

	public static Boolean TestForBoat(Location loc) {

		Boolean isBoat = false;
		List<Entity> nearbyEntities = (List<Entity>)loc.getWorld().getNearbyEntities(loc, Radius,Radius,Radius);
		for(Entity e : nearbyEntities){
			if(e instanceof Boat)
				isBoat = true;
		}

		return isBoat;

	}

	public static void spawnBoat(Location loc) {
		w.spawnEntity(loc, EntityType.BOAT);
	}

	public static ArrayList <Location> BoatLocationsList() {
		return boatloc;
	}
	public static ArrayList <Location> SpawnLocationsList() {
		return spawnloc;
	}
}