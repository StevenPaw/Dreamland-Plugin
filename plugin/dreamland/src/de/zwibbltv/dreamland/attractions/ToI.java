package de.zwibbltv.dreamland.attractions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class ToI {

	public static void test(Player p) {
		World w = p.getWorld();
		Location ploc = p.getLocation ();
		Double d = ploc.distanceSquared(new Location(w, -811, 21.0, 471.0));
		if(d <= 5) {
			p.sendMessage("ES FUNKTIONIERT NOCH NICH SO RICHTIG!");
			System.out.println("Ne so geht das ja nicht...");
			sitDown(p);
		}
	}
	
	public static void sitDown(Player P) {
		
	}
		
	public static void uprise() {
		
	}
}
