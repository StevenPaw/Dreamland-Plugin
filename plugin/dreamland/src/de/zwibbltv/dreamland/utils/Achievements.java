package de.zwibbltv.dreamland.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public enum Achievements {
	//Ordered in Categories:
	//Dreamland
	FIRSTJOIN("FirstJoin","You joined our Server!",20, true,"join the server","Dreamland"),
	FIRSTCHAT("FirstChat","You chatted the first time!",10, true,"chat the first time","Dreamland"),
	FIRSTMOVE("FirstMove","You moved for the first time!",10, true,"move!","Dreamland"),
	RUNAKM("Run a KM","You ran a Kilometer in one session!",10, false,"???","Dreamland"),
	//MainStreet
	MAINSTREETPARCOUR("Parcour","You run through the MainStreet Parcour!",10, false,"???","MainStreet"),
	MAINSTREETWATERPLAY("Main Street Water Show","You discovered the secret Water Show!",15,false,"???","MainStreet"),
	MAINSTREETCLUB33("Club 33","You discovered Club 33!",10,true,"Find the Club 33","MainStreet"),
	MAINSTREETDOCTOR("Main Street Doctor","You've gone to the doctor!",10,true,"Are you healthy?","MainStreet"),
	MAINSTREETCHURCH("Going to church","You found the church!",10,true,"Find the church on MainStreet","MainStreet"),
	MAINSTREETFOUNTAIN("MainStreets Fountain","You activated the fountain on MainStreet!",10,true,"Activate the fountain on MainStreet","MainStreet"),
	MAINSTREETTRAINSTATION("MainStreet Trainstation","You found the Trainstation on Main Street!",10,true,"Find the Trainstation on MainStreet","MainStreet"),
	MAINSTREETINFORMATION("Information-Center","You found the Information-Center",10,true,"Find the Information-Center","MainStreet"),
	MAINSTREETTOILET("Mainstreet Toilet","You went to the toilets in the information-center on MainStreet",10,true,"Find the toilets in the information-center","MainStreet"),
	MAINSTREETSHOW("Mainstreet Show","You visited the show on Mainstreet",10,true,"Visit the show on MainStreet!","MainStreet"),
	HAUNTEDMANSION("Haunted Mansion","You went to the Haunted Mansion",10,true,"Go in the Haunted Mansion","MainStreet"),
	HAUNTEDMANSIONFOUNTAIN("Haunted Fountain","You found the haunted fountain in front of the Haunted Mansion!",10,false,"???","MainStreet"),
	//Calico
	CALICO("Calico", "You went to Calico!", 10, true,"Enter Calico","Calico"),
	CALICOFOUNTAIN("Calicos Fountain","You activated the fountain in Calico!",10,true,"Activate the fountain in Calico","Calico"),
	CALICOTOILET("Calicotoilet", "You went to the toilet in Calico!", 10, true,"Go to the toilet in Calico","Calico"),
	CALICORESTAURANT("Calicorestaurant", "You went to the restaurant in Calico!",10, true,"Go to the restaurant in Calico","Calico"),
	CALICOBANK("Calicobank", "You went to the Bank in Calico!",10, true,"Go to the bank in Calico","Calico"),
	CALICOSAFE("Calicosafe", "You found a way into the safe in Calico!", 20, false,"???","Calico"),
	//Chinatown
	CHINESELABYRINTH("ChineseLabyrinth", "You went through the labyrinth in chinatown",10,true,"Go through the labyrinth in chinatown", "Chinatown");
	
	
	public static void locations(Player p) {	
		
				Location ploc = p.getLocation();
				Double d;
				World w = Bukkit.getServer().getWorld("dreamland");
				
		//Mainstreet
			//Mainstreetparcour
			d = ploc.distance(new Location(w, -779.5, 25.0, 660.5));
			if(d <= 1) {
				Location location = new Location(w, -809, 22.0, 636, 1, -25);
				p.teleport(location);
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETPARCOUR);
				}
			//Club 33
			d = ploc.distance(new Location(w, -785.5, 22.0, 620));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETCLUB33);
				}
			//Doctor
			d = ploc.distance(new Location(w, -714.5, 21.0, 647));
			if(d <= 1) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETDOCTOR);
				}
			//Church
			d = ploc.distance(new Location(w, -801, 21.0, 622.5));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETCHURCH);
				}
			//Trainstation
			d = ploc.distance(new Location(w, -843.5, 20.0, 585.5));
			if(d <= 1) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETTRAINSTATION);
				}
			//Information-Center
			d = ploc.distance(new Location(w, -697, 21.0, 650));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETINFORMATION);
				}
			//Mainstreet show
			d = ploc.distance(new Location(w, -883, 18.0, 642.5));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETSHOW);
				}
			//Mainstreet toilet
			d = ploc.distance(new Location(w, -685.5, 21.0, 666.7));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETTOILET);
				}
			//Haunted Mansion
			d = ploc.distance(new Location(w, -726, 25.0, 592.5));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.HAUNTEDMANSION);
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
