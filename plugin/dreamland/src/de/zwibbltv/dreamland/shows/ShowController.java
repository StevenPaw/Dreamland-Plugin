package de.zwibbltv.dreamland.shows;

import org.bukkit.Bukkit;

public class ShowController {

	public static Boolean LateNightShowRuns = false;
	static Integer LateNightShowTime = 0;
	
	public static void TestForTime() {
		//Time = 0 - morgens
		//Time = 13000 - Nachts
		//Time = 24000 - Sonnenaufgang
		Integer Time = (int) Bukkit.getWorld("dreamland").getTime();
		if(Time >= 13000 && Time <= 13020) {
			Bukkit.broadcastMessage("§4The Late Night Show Starts soon behind Castle!");
		}
		if(Time >= 14000 && Time <= 14020) {
			LateNightShow.StartShow();
		}
	}
	
	public void StartShow(String show) {
		if (show == "LateNightShow") {
			LateNightShowRuns = true;
		}
	}
	
	public static void PlayShow() {
		TestForTime();
		if(LateNightShowRuns) {
			LateNightShow.runShow(LateNightShowTime);
			LateNightShowTime += 1;
		}
	}
	
	public void setLateNightShowTime(Integer t) {
		LateNightShowTime = t;
	}
}
