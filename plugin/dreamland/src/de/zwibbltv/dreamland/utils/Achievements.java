package de.zwibbltv.dreamland.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public enum Achievements {
	
	FIRSTJOIN("FirstJoin","You joined our Server!",20, true,"join the server","Dreamland"),
	FIRSTCHAT("FirstChat","You chatted the first time!",10, true,"chat the first time","Dreamland"),
	FIRSTMOVE("FirstMove","You moved for the first time!",10, true,"move!","Dreamland"),
	RUNAKM("Run a KM","You ran a Kilometer in one session!",10, false,"???","Dreamland"),
	MAINSTREETPARCOUR("MainStreetParcour","You run through the MainStreet Parcour!",10, true,"Find the parcour on MainStreet","MainStreet"),
	CALICO("Calico", "You went to Calico!", 10, true,"Enter Calico","Calico"),
	CALICOTOILET("Calicotoilet", "You went to the toilet in Calico!", 10, true,"Go to the toilet in Calico","Calico"),
	CALICORESTAURANT("Calicorestaurant", "You went to the restaurant in Calico!",10, true,"Go to the restaurant in Calico","Calico"),
	CALICOBANK("Calicobank", "You went to the Bank in Calico!",10, true,"Go to the bank in Calico","Calico"),
	CALICOSAFE("Calicosafe", "You found a way into the safe in Calico!", 20, false,"???","Calico");
	
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
		//CALICO
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
			//Calico Toilet
			d = ploc.distance(new Location(w, -858.5, 21.0, 699.5));
			if(d <= 2) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICOTOILET);
				}
			//Calico Restaurant
			d = ploc.distance(new Location(w, -855.5, 21.0, 704.5));
			if(d <= 1) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICORESTAURANT);
				}
			//Calico Bank
			d = ploc.distance(new Location(w, -888.5, 21.0, 731.5));
			if(d <= 1) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICOBANK);
				}
			//Calico Safe
			d = ploc.distance(new Location(w, -889.5, 23.0, 726.5));
			if(d <= 1) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICOSAFE);
				}
			
	}
	
	String name;
	String text;
	int money;
	boolean visibility;
	String task;
	String category;
	
	private Achievements(String name,String text,int money, boolean visibility, String task, String category) {
		this.name = name;
		this.text = text;
		this.money = money;
		this.visibility = visibility;
		this.task = task;
		this.category = category;
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
	
	public boolean getVisibility() {
		return visibility;
	}
	
	public String getTask() {
		return task;
	}
	
	public String getCategory() {
		return category;
	}

}
