package de.zwibbltv.dreamland.attractions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class ToI {

	public static void main(String[] args) {
		
	}

	public static void test(Player p) {
		World w = p.getWorld();
		Location ploc = p.getLocation ();
		Double d = ploc.distance(new Location(w, -811, 21.0, 471.0));
		if(d <= 5) {
			p.sendMessage("ES FUNKTIONIERT NOCH NICH SO RICHTIG!");
		}
	}
		
	public static void uprise() {
		
	}
}
