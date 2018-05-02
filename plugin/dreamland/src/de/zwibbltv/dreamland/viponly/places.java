package de.zwibbltv.dreamland.viponly;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import net.md_5.bungee.api.ChatColor;

public class places {
	
	public static  List<Location> fLoc;
	public static  List<Location> tLoc;
	public static World w = Bukkit.getServer().getWorld("dreamland");
	public static int fpCount; //forbiddenplacesCount
	
	public static void loadplaces() {
				
		fLoc = new ArrayList<Location>();
		tLoc = new ArrayList<Location>();
		
		//Mainstreet B�hne Links
		fLoc.add(new Location(w, -867, 16.0, 645.0));
		tLoc.add(new Location(w, -870, 16.0, 645.50, -90, 0));
		//Mainstreet B�hne Rechts
		fLoc.add(new Location(w, -880, 16.0, 656.0));
		tLoc.add(new Location(w, -880.5, 16.0, 653.50, 0, 0));
		//Mainstreet B�hne Turm
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
	
		de.zwibbltv.dreamland.utils.Achievements.locations(p);
		
		//Staff-Bereiche
				if (!p.hasPermission("dreamland.*") && !p.hasPermission("dreamland.Staff")) {
					if (PlayerConfig.getBuilder(p) == false) {
						Location ploc = p.getLocation();
						Double d;
						
						d = ploc.distance(new Location(w, -682, 22.0, 660.0));
						if(d <= 1.5) {
							Location location = new Location(w, -682, 21.0, 661.50, -178, -3);
							p.teleport(location);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("Staff")));
						}
					}
				}
		
	//VIP-Bereiche
		if (!p.hasPermission("dreamland.*") && !p.hasPermission("dreamland.VIP")) {
			if (PlayerConfig.getBuilder(p) == false) {
				Location ploc = p.getLocation();
				Double d;
				
				d = ploc.distance(new Location(w, -867, 16.0, 645.0));
				if(d <= 1.5) {
					Location location = new Location(w, -870, 16.0, 645.50, -90, 0);
					p.teleport(location);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
				}	
				//Mainstreet B�hne Rechts
				d = ploc.distance(new Location(w, -880, 16.0, 656.0));
				if(d <= 1) {
					Location location = new Location(w, -880.5, 16.0, 653.50, 0, 0);
					p.teleport(location);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
				}
				//Mainstreet B�hne Turm
				d = ploc.distance(new Location(w, -875.5, 18.0, 639.5));
				if(d <= 1.5) {
					Location location = new Location(w, -878, 18.0, 639.50, -90, 0);
					p.teleport(location);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
				}
				//Westernrace Controlroom
				d = ploc.distance(new Location(w, -826.5, 21.0, 715.5));
				if(d <= 1.5) {
					Location location = new Location(w, -826.5, 21.0, 712.50, 0, 0);
					p.teleport(location);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
				}		
				//Club33
				d = ploc.distance(new Location(w, -786.5, 22.0, 619.5));
				if(d <= 1.5) {
					Location location = new Location(w, -783, 22.0, 620, 90, 0);
					p.teleport(location);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
				}		
				//Haunted_Mansion
				d = ploc.distance(new Location(w, -710.5, 23.0, 584.5));
				if(d <= 1.5) {
					Location location = new Location(w, -710.5, 23.0, 586.5, 180, 0);
					p.teleport(location);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
				}		
				//VIP-Launch am Spawn
				d = ploc.distance(new Location(w, -969.5, 23.0, 660.5));
				if(d <= 1.5) {
					Location location = new Location(w, -969.5, 23.0, 658.5, 0, 0);
					p.teleport(location);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
				}		
				//Calico-Palesade
				d = ploc.distance(new Location(w, -886.5, 21.0, 706.5));
				if(d <= 1.5) {
					Location location = new Location(w, -886.5, 20.0, 703.5, 0, 0);
					p.teleport(location);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
				}		
			}
		}	
	}
}
