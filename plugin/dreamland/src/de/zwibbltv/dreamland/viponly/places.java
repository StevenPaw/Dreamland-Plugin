package de.zwibbltv.dreamland.viponly;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class places {
	
	public static  List<Location> fLoc;
	public static  List<Location> tLoc;
	public static World w = Bukkit.getServer().getWorld("dreamland");
	public static int fpCount; //forbiddenplacesCount
	
	public static void loadplaces() {
				
		fLoc = new ArrayList<Location>();
		tLoc = new ArrayList<Location>();
		
		//Mainstreet Bühne Links
		fLoc.add(new Location(w, -867, 16.0, 645.0));
		tLoc.add(new Location(w, -870, 16.0, 645.50, -90, 0));
		//Mainstreet Bühne Rechts
		fLoc.add(new Location(w, -880, 16.0, 656.0));
		tLoc.add(new Location(w, -880.5, 16.0, 653.50, 0, 0));
		//Mainstreet Bühne Turm
		fLoc.add(new Location(w, -875.5, 18.0, 639.5));
		tLoc.add(new Location(w, -878, 18.0, 639.50, -90, 0));
		//Westernrace Controlroom
		fLoc.add(new Location(w, -826.5, 21.0, 715.5));
		tLoc.add(new Location(w, -826.5, 21.0, 712.50, 0, 0));
		//Club33
		fLoc.add(new Location(w, -786.5, 22.0, 619.5));
		tLoc.add(new Location(w, -783, 22.0, 620, 90, 0));
		
		int b = fLoc.size();
		
		System.out.println("[Dreamland] {VIP} Es wurden " + b + " verbotene Orte geladen");
		
	}
	
	public static void locations(Player p) {		
		if (!p.hasPermission("dreamland.*") && !p.hasPermission("dreamland.VIP")) {
			if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(p)) {
				Location ploc = p.getLocation();
				Double d;
				
				d = ploc.distance(new Location(w, -867, 16.0, 645.0));
				if(d <= 2) {
					Location location = new Location(w, -870, 16.0, 645.50, -90, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}	
				//Mainstreet Bühne Rechts
				d = ploc.distance(new Location(w, -880, 16.0, 656.0));
				if(d <= 1) {
					Location location = new Location(w, -880.5, 16.0, 653.50, 0, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}
				//Mainstreet Bühne Turm
				d = ploc.distance(new Location(w, -875.5, 18.0, 639.5));
				if(d <= 1.5) {
					Location location = new Location(w, -878, 18.0, 639.50, -90, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}
				//Westernrace Controlroom
				d = ploc.distance(new Location(w, -826.5, 21.0, 715.5));
				if(d <= 2) {
					Location location = new Location(w, -826.5, 21.0, 712.50, 0, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}		
				//Club33
				d = ploc.distance(new Location(w, -786.5, 22.0, 619.5));
				if(d <= 2) {
					Location location = new Location(w, -783, 22.0, 620, 90, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}		
				//Haunted_Mansion
				d = ploc.distance(new Location(w, -710.5, 23.0, 584.5));
				if(d <= 1.5) {
					Location location = new Location(w, -710.5, 23.0, 586.5, 180, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}		
				//VIP-Launch am Spawn
				d = ploc.distance(new Location(w, -969.5, 23.0, 660.5));
				if(d <= 1.5) {
					Location location = new Location(w, -969.5, 23.0, 658.5, 0, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}		
			}
		}	
	}
}
