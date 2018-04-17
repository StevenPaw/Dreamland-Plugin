package de.zwibbltv.dreamland.viponly;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class places {
	
	public static void locations(Player p) {		
		
		//mainstreet B�hne links
		if (!p.hasPermission("dreamland.*") || !p.hasPermission("dreamland.VIP")) {
			if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(p)) {
				World w = p.getWorld();
				Location ploc = p.getLocation();
				Double d = ploc.distance(new Location(w, -867, 16.0, 645.0));
				if(d <= 2) {
					Location location = new Location(w, -870, 16.0, 645.50, -90, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}			
			}
		}	
		
		//Mainstreet B�hne Rechts
		if (!p.hasPermission("dreamland.*") || !p.hasPermission("dreamland.VIP")) {
			if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(p)) {
				World w = p.getWorld();
				Location ploc = p.getLocation();
				Double d = ploc.distance(new Location(w, -880, 16.0, 656.0));
				if(d <= 2) {
					Location location = new Location(w, -880.5, 16.0, 653.50, 0, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}			
			}
		}	
		
		//Mainstreet B�hne Turm
		if (!p.hasPermission("dreamland.*") || !p.hasPermission("dreamland.VIP")) {
			if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(p)) {
				World w = p.getWorld();
				Location ploc = p.getLocation();
				Double d = ploc.distance(new Location(w, -875.5, 18.0, 639.5));
				if(d <= 1.5) {
					Location location = new Location(w, -878, 18.0, 639.50, -90, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}			
			}
		}	
		
		//western race control
		if (!p.hasPermission("dreamland.*") || !p.hasPermission("dreamland.VIP")) {
			if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(p)) {
				World w = p.getWorld();
				Location ploc = p.getLocation();
				Double d = ploc.distance(new Location(w, -826.5, 21.0, 715.5));
				if(d <= 2) {
					Location location = new Location(w, -826.5, 21.0, 712.50, 0, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}			
			}
		}
		
		//Club33
		if (!p.hasPermission("dreamland.*") || !p.hasPermission("dreamland.VIP")) {
			if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(p)) {
				World w = p.getWorld();
				Location ploc = p.getLocation();
				Double d = ploc.distance(new Location(w, -786.5, 22.0, 619.5));
				if(d <= 2) {
					Location location = new Location(w, -783, 22.0, 620, 90, 0);
					p.teleport(location);
					p.sendMessage(Main.getVIP());
				}			
			}
		}	
	}
}
