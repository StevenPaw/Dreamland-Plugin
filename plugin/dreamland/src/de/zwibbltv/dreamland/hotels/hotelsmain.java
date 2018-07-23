package de.zwibbltv.dreamland.hotels;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.utils.PlayerConfig;

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
	
	public static void setInRoom(Player p, Integer i) {
		try {
			PlayerConfig.setInHotel(p, i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setRentedRoom(Player p, Integer i) {
		try {
			PlayerConfig.setRentedHotel(p, i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
