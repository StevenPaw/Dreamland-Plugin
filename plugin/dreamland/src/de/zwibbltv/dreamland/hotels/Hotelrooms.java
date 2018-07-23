package de.zwibbltv.dreamland.hotels;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.util.BlockVector;

public enum Hotelrooms {
	
	//RAUMID ( PREIS, "NAME", new location(bukkit.getworld("dreamland"),STARTKOORDINATEN),new blockvector(GRÖßE DES ZIMMERS))
	ROOM001(1, 35, "Simple Bed", new Location(Bukkit.getWorld("dreamland"),-465,21,582),new BlockVector(2,2,7), new Location(Bukkit.getWorld("dreamland"),-464,21,590),new Location(Bukkit.getWorld("dreamland"),-461,21,595)),
	ROOM002(2, 35, "Simple Bed", new Location(Bukkit.getWorld("dreamland"),-458,21,584),new BlockVector(3,2,5), new Location(Bukkit.getWorld("dreamland"),-464,21,590),new Location(Bukkit.getWorld("dreamland"),-461,21,595)),
	ROOM003(3, 35, "Simple Bed", new Location(Bukkit.getWorld("dreamland"),-452,21,581),new BlockVector(2,6,5), new Location(Bukkit.getWorld("dreamland"),-464,21,590),new Location(Bukkit.getWorld("dreamland"),-461,21,595));

	int number;
	int price;
	String name;
	Location loc;
	BlockVector size;
	Location door;
	Location spawn;

	private Hotelrooms(int number, int price, String name, Location loc, BlockVector size, Location door, Location spawn) {
		this.number = number;
		this.price = price;
		this.name = name;
		this.loc = loc;
		this.size = size;
		this.door = door;
		this.spawn = spawn;
	}
	
	public static Location getLocation(Hotelrooms room) {
		return room.loc;
	}
	public static BlockVector getSize(Hotelrooms room) {
		return room.size;
	}
	public static int getNumber(Hotelrooms room) {
		return room.number;
	}
	public static Location getDoor(Hotelrooms room) {
		return room.door;
	}
	public static Location getSpawn(Hotelrooms room) {
		return room.spawn;
	}
	
	public static Boolean isinRoom(Hotelrooms room, Location loc) {
		Boolean isinRoom = false;
		
		if (loc.getBlockX() >= getLocation(room).getBlockX() && loc.getBlockX() <= getLocation(room).getBlockX() + getSize(room).getBlockX()) {
			if (loc.getBlockY() >= getLocation(room).getBlockY() && loc.getBlockY() <= getLocation(room).getBlockY() + getSize(room).getBlockY()) {
				if (loc.getBlockZ() >= getLocation(room).getBlockZ() && loc.getBlockZ() <= getLocation(room).getBlockZ() + getSize(room).getBlockZ()) {
					isinRoom = true;
				}
			}
		}
		
		return isinRoom;
	}
	public static Boolean isDoor(Hotelrooms room, Location loc) {
		Boolean isDoor = false;
		
		if (loc.getBlockX() == getDoor(room).getBlockX()) {
			if (loc.getBlockY() == getDoor(room).getBlockY() || loc.getBlockY() == getDoor(room).getBlockY() + 1) {
				if (loc.getBlockZ() == getDoor(room).getBlockZ()) {
					isDoor = true;
				}
			}
		}
		
		return isDoor;
	}
}
