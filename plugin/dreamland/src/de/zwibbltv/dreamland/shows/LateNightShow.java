package de.zwibbltv.dreamland.shows;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LateNightShow {

	public static void StartShow() {
		for (Player p : Bukkit.getOnlinePlayers())
		{
			Location ploc = p.getLocation();
			Double d = ploc.distance(new Location(Bukkit.getWorld("dreamland"),-453,21,634));
			if(d <= 40) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "jukebox show add " + p.getName() + "@LateNightShow");
			}
		}
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "jukebox music @LateNightShow https://www.dropbox.com/s/7ycortnript3fxu/AJR%20-%20Weak.mp3?dl=1");
		de.zwibbltv.dreamland.shows.ShowController.LateNightShowRuns = true;
		Bukkit.broadcastMessage("BETA: Show \"LateNightShow\" starts now");
	}

	public static void runShow(Integer time) {
		if(time == 0) {

		} else if (time == 10) {
			Bukkit.broadcastMessage("Explosion");
		} else if (time == 30) {
			Bukkit.broadcastMessage("WOW");
		} else if (time == 120) {
			Bukkit.broadcastMessage("Haha");
		}  else if (time == 198) {
			Bukkit.broadcastMessage("ENDE");
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "jukebox stop @LateNightShow");
		}
		
	}


}
