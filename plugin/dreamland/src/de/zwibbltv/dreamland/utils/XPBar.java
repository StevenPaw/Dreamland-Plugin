package de.zwibbltv.dreamland.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class XPBar {

	public static void CalculateXPLevel() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			Integer Level = 0;
			Integer XP = 0;
//			Integer AchievementsCount = 0;
//			Integer AchievementsPercentage;
//			for(Achievements ach : Achievements.values()) {
//				if(PlayerConfig.hasAchivement(p, ach)) {
//					AchievementsCount = AchievementsCount + 1;
//				}
//			}
//			AchievementsPercentage = de.zwibbltv.dreamland.listener.MenuListener.getAchievementsPercentage(p);
//			
//			XP = AchievementsCount / (Achievements.values().length) / 100;
//			Level = Achievements.values().length - AchievementsCount;
//			
			Level = de.zwibbltv.dreamland.listener.MenuListener.getAchievementsPercentage(p);
			setXPLevel(p,Level,XP);
		}
	}
	
	public static void setXPLevel(Player p, Integer lvl, Integer xp) {
		p.setLevel(lvl);
		p.setExp(xp);
	}
}
