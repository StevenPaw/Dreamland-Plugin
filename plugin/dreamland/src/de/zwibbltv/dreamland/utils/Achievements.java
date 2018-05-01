package de.zwibbltv.dreamland.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public enum Achievements {
	
	FIRSTJOIN("FirstJoin","You joined our Server!",20),
	FIRSTCHAT("FirstChat","You chatted the first time!",10),
	FIRSTMOVE("FirstMove","You moved for the first time!",10),
	MAINSTREETPARCOUR("MainStreetParcour","You run through the MainStreet Parcour",10),
	CALICO("Calico", "You went to Calico", 10);
	
	public static void locations(Player p) {	
		
				Location ploc = p.getLocation();
				Double d;
				World w = Bukkit.getServer().getWorld("dreamland");
				
			//Mainstreetparcour
			d = ploc.distance(new Location(w, -779.5, 25.0, 660.5));
			if(d <= 1) {
				Location location = new Location(w, -809, 22.0, 636, 1, -25);
				p.teleport(location);
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETPARCOUR);
				}
			//Calico Eingang 1.1
			d = ploc.distance(new Location(w, -881.5, 20.0, 692.5));
			if(d <= 3) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICO);
				}
			//Calico Eingang 1.2
			d = ploc.distance(new Location(w, -884.5, 20.0, 692.5));
			if(d <= 3) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICO);
				}
			//Calico Eingang 2.1
			d = ploc.distance(new Location(w, -895.5, 20.0, 757.5));
			if(d <= 3) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICO);
				}
			//Calico Eingang 2.2
			d = ploc.distance(new Location(w, -895.5, 20.0, 760.5));
			if(d <= 3) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICO);
				}
			
	}
	
	String name;
	String text;
	int money;
	
	private Achievements(String name,String text,int money) {
		this.name = name;
		this.text = text;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	
	public String getText() {
		return text;
	}
	
	public int getMoney() {
		return money;
	}

}
