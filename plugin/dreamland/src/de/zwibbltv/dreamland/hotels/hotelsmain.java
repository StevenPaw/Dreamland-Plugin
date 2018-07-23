package de.zwibbltv.dreamland.hotels;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class hotelsmain {

	
	public static Integer isInRoom (Player p, Location loc) {
		Integer isin = -1;
		for(Hotelrooms room : Hotelrooms.values()) {
			if(Hotelrooms.isinRoom(room, loc)) {
				isin = Hotelrooms.getNumber(room);
			}
		}
		return isin;
	}
	public static Integer isaDoor (Player p, Location loc) {
		Integer isin = -1;
		for(Hotelrooms room : Hotelrooms.values()) {
			if(Hotelrooms.isDoor(room, loc)) {
				isin = Hotelrooms.getNumber(room);
			}
		}
		return isin;
	}
	public static Location getExit (Player p, int Num) {
		Location loc = new Location(Bukkit.getWorld("dreamland"),0,0,0);
		for(Hotelrooms room : Hotelrooms.values()) {
			if(Hotelrooms.getNumber(room) == Num) {
				loc = Hotelrooms.getSpawn(room);
			}
		}
		return loc;
	}
	
	public static Integer getRentedRoom (Player p) {
		Integer rentedRoom = -1;
		return rentedRoom;
	}
}
