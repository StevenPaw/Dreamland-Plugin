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
	WATER("Into the water","You jumped into water! Are you fresher now?",10, false,"???","Dreamland"),
	RUNAKM("Run a KM","You ran a Kilometer in one session!",10, false,"???","Dreamland"),
	PLAY2HOURS("Play 2 hours","You play 2 hours on Dreamland!",20, false,"???","Dreamland"),
	GREATVIEWCASTLE("Great view from the castle","You found the button with great view in the castle!",10, false,"???","Dreamland"),
	SECRETTUNNEL("Secret tunnel","You found the secret tunnel!",10, false,"???","Dreamland"),
	DREAMLANDBYNIGHT("Dreamland by night","You played while you normaly have to sleep!",10, false,"???","Dreamland"),
	BACKSTAGEPARCOUR("Backstage Parcour","You jumped through the backstage Parcour!",10, false,"???","Dreamland"),
	BACKSTAGEPARCOURII("Backstage Parcour II","You jumped through the backstage Parcour II!",10, false,"???","Dreamland"),
	//MainStreet
	MAINSTREETCASTLERESTAURANT("Castle Restaurant","You went to the Castle Restaurant!",10, false,"Go to the Castle Restaurant","MainStreet"),
	MAINSTREETCASTLETOILET("Castle Toilet","You went to the toilets in the Castle on MainStreet",10,true,"Find the toilets in the Castle","MainStreet"),
	MAINSTREETPARCOUR("Parcour","You run through the MainStreet Parcour!",10, false,"???","MainStreet"),
	MAINSTREETWATERPLAY("Main Street Water Show","You discovered the secret Water Show!",15,false,"???","MainStreet"),
	MAINSTREETCLUB33("Club 33","You discovered Club 33!",10,true,"Find the Club 33","MainStreet"),
	MAINSTREETDOCTOR("Main Street Doctor","You've gone to the doctor!",10,true,"Are you healthy?","MainStreet"),
	MAINSTREETCHURCH("Going to church","You found the church!",10,true,"Find the church on MainStreet","MainStreet"),
	MAINSTREETFOUNTAIN("MainStreets Fountain","You activated the fountain on MainStreet!",10,true,"Activate the fountain on MainStreet","MainStreet"),
	MAINSTREETTRAINSTATION("MainStreet Trainstation","You found the Trainstation on Main Street!",10,true,"Find the Trainstation on MainStreet","MainStreet"),
	CLUB33TRAINSTATION("Club33 Trainstation","You found the Trainstation near the Club33!",10,true,"Find the Trainstation near the Club33","MainStreet"),
	MAINSTREETINFORMATION("Information-Center","You found the Information-Center",10,true,"Find the Information-Center","MainStreet"),
	MAINSTREETTOILET("Mainstreet Toilet","You went to the toilets in the information-center on MainStreet",10,true,"Find the toilets in the information-center","MainStreet"),
	MAINSTREETSHOW("Mainstreet Show","You visited the show on Mainstreet",10,true,"Visit the show on MainStreet!","MainStreet"),
	HAUNTEDMANSION("Haunted Mansion","You went to the Haunted Mansion",10,true,"Go in the Haunted Mansion","MainStreet"),
	HAUNTEDMANSIONFOUNTAIN("Haunted Fountain","You found the haunted fountain!",10,false,"???","MainStreet"),
	HAUNTEDMANSIONSECRETPAINTING("Haunted Mansion secret painting","You went to the Haunted Mansion secret Painting",10,false,"???","MainStreet"),
	LIBRARY("Dreamland Library","You went to the Library!",10,true,"Find the Library on Main Street","MainStreet"),
	DISCO("Dreamland Disco","You went to the Disco!",10,true,"Find the Disco on Main Street","MainStreet"),
	//Castle
	CASTLEFOUNTAIN("Castlefountain","You activated the fountain of the castle",10,true,"Activate the fountain of the castle","Castle"),
	CASTLE("The Castle","You went to Castle",10,true,"Go to the castle","Castle"),
	BLUEROOM("Blue room","You found the blue room in the castle",10,false,"???","Castle"),
	LOVEROOM("Loveroom","You found the Loveroom in the castle",10,false,"???","Castle"),
	CASTLEFALL("Castlefall","You jumped down in the Castle Parcour",10,false,"???","Castle"),
	CASTLEPARCOUR("Castleparcour","Complete the parcour",10,false,"???","Castle"),
	CASTLEMONKEY("Castle Monkey","Be an monkey near the castle",10,false,"???","Castle"),
	//Calico
	CALICO("Calico", "You went to Calico!", 10, true,"Enter Calico","Calico"),
	CALICOFOUNTAIN("Calicos Fountain","You activated the fountain in Calico!",10,true,"Activate the fountain in Calico","Calico"),
	CALICOTOILET("Calicotoilet", "You went to the toilet in Calico!", 10, true,"Go to the toilet in Calico","Calico"),
	CALICORESTAURANT("Calicorestaurant", "You went to the restaurant in Calico!",10, true,"Go to the restaurant in Calico","Calico"),
	CALICOTRAINSTATION("Calico Trainstation","You found the Trainstation in Calico!",10,true,"Find the Trainstation in Calico","Calico"),
	CALICOBANK("Calicobank", "You went to the Bank in Calico!",10, true,"Go to the bank in Calico","Calico"),
	CALICOSAFE("Calicosafe", "You found a way into the safe in Calico!", 20, false,"???","Calico"),
	//Chinatown
	CHINATOWN("Chinatown", "You went to Chinatown",10,true,"Enter Chinatown", "Chinatown"),
	CHINATOWNFOUNTAIN("Chinatowns Fountain","You activated the fountain in Chinatown!",10,true,"Activate the fountain in Chinatown","Chinatown"),
	CHINATOWNTRAINSTATION("Chinatown Trainstation","You found the Trainstation in Chinatown!",10,true,"Find the Trainstation in Chinatown","Chinatown"),
	CHINESELABYRINTH("ChineseLabyrinth", "You went through the labyrinth in Chinatown",10,true,"Go through the labyrinth in Chinatown", "Chinatown"),
	//Lagoon
	LAGOON("Lagoon", "You went to Lagoon",10,true,"Enter Lagoon", "Lagoon"),
	LAGOONSECRETSIGHT("Secret Lagoon sight", "You went to the secret Lagoon sight",10,false,"???", "Lagoon"),
	GRANDPLAZA("Grand Plaza", "You went to the Grand Plaza",10,true,"Enter the Grand Plaza", "Lagoon"),
	LAGOONFOUNTAIN("Lagoons Fountain","You activated the fountain in Lagoon!",10,true,"Activate the fountain in Lagoon","Lagoon"),
	LAGOONTHEATER("Lagoon Theater","You visited the Theater in Lagoon",10,true,"Visit the theater in Lagoon!","Lagoon"),
	LAGOONTOI("Tower of Izran", "You rided Tower of Izran",10,true,"Ride Tower of Izran", "Lagoon"),
	LAGOONCHIAPAS("Chiapas", "You rided Chiapas",10,true,"Ride Chiapas", "Lagoon"),
	//GREIFENHEIM
	GREIFENHEIM("Greifenheim", "You went to Greifenheim",10,true,"Enter Greifenheim", "Greifenheim"),
	GREIFENHEIMTRAINSTATION("Greifenheim Trainstation","You found the Trainstation in Greifenheim!",10,true,"Find the Trainstation in Greifenheim","Greifenheim"),
	FLYINGPEGASUS("Flying Pegasus", "You rided Flying Pegasus",10,true,"Ride Flying Pegasus", "Greifenheim"),
	EXPLORERSCAVE("Explorers Cave", "You went through the Explorers Cave",10,true,"Went through the Explorers Cave", "Greifenheim"),
	HIDDENHIDEOUT("Hidden Hideout", "You found the Hidden Hideout",10,false,"???","Greifenheim"),
	HEIDISDOOR("Heidis Door", "You looked at Heidis Door",10,false,"???","Greifenheim"),
	GREIFENHEIMDINER("Greifenheim Diner","You visited the Greifenheim Diner",10,true,"Visit the Greifenheim Diner","Greifenheim"),
	//FANTASA
	FANTASA("Fantasa", "You entered Fantasa",10,true,"Enter Fantasa","Fantasa"),
	FANTASAFOUNTAIN("Fantasas Fountain","You activated the fountain in Fantasa!",10,true,"Activate the fountain in Fantasa","Fantasa"),
	FANTASAVIEW("Fantasa View", "You've gone to a higher place",10,false,"???","Fantasa"),
	FANTASATOILETS("Toilets in Fantasa","You entered the toilets in Fantasa",10,true,"Find the toilets in Fantasa","Fantasa");
	
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
			//Secret Tunnel
			d = ploc.distance(new Location(w, -947, 10, 605));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.SECRETTUNNEL);
				}
			d = ploc.distance(new Location(w, -653, 10, 605));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.SECRETTUNNEL);
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
			//Club33 Trainstation
			d = ploc.distance(new Location(w, -772, 20.5, 620.9));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CLUB33TRAINSTATION);
				}
			//mainstreet castle restaurant
			d = ploc.distance(new Location(w, -964.5, 23.0, 622.5));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETCASTLERESTAURANT);
				}
			//mainstreet castle toilet
			d = ploc.distance(new Location(w, -964.5, 22.0, 607.5));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.MAINSTREETCASTLETOILET);
				}
			//disco
			d = ploc.distance(new Location(w, -763.5, 21.0, 652.5));
			if(d <= 2) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.DISCO);
				}
			//Backstage parcour II
			d = ploc.distance(new Location(w, -757.5, 28.0, 655.5));
			if(d <= 2) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.BACKSTAGEPARCOURII);
				}
			//castle Monkey
			d = ploc.distance(new Location(w, -622.5, 26.0, 651.5));
			if(d <= 1) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CASTLEMONKEY);
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
			//Calico Trainstation 1
			d = ploc.distance(new Location(w, -886, 20.5, 747));
			if(d <= 1.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICOTRAINSTATION);
				}
			//Calico Trainstation 2
			d = ploc.distance(new Location(w, -902, 20.5, 746.0));
			if(d <= 1.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CALICOTRAINSTATION);
				}
			
		//CHINATOWN
			//chinatown Eingang 1
			d = ploc.distance(new Location(w, -924.2, 20.0, 682.3));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CHINATOWN);
				}
			//chinatown Eingang 2
			d = ploc.distance(new Location(w, -899.7, 20.0, 758.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CHINATOWN);
				}
			//chinatown Trainstation
			d = ploc.distance(new Location(w, -931.3, 20.0, 681.3));
			if(d <= 1) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.CHINATOWNTRAINSTATION);
				}
		//LAGOON
			//Lagoon Eingang 1
			d = ploc.distance(new Location(w, -873.5, 20.0, 566.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.LAGOON);
				}
			//Lagoon Eingang 2
			d = ploc.distance(new Location(w, -887.5, 20.0, 531.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.LAGOON);
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GREIFENHEIM);
				}
			//Lagoon Eingang 3.1
			d = ploc.distance(new Location(w, -798.5, 20.0, 488.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.LAGOON);
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GRANDPLAZA);
				}
			//Lagoon Eingang 3.2
			d = ploc.distance(new Location(w, -798.5, 20.0, 492.3));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.LAGOON);
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GRANDPLAZA);
				}
			//Lagoon Grand Plaza 1
			d = ploc.distance(new Location(w, -851.5, 21.5, 519.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GRANDPLAZA);
				}
			//Lagoon Grand Plaza 2.1
			d = ploc.distance(new Location(w, -872.5, 20, 523.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GRANDPLAZA);
				}
			//Lagoon Grand Plaza 2.2
			d = ploc.distance(new Location(w, -876.5, 20, 523.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GRANDPLAZA);
				}
			//Lagoon theater
			d = ploc.distance(new Location(w, -887.3, 20, 493.5));
			if(d <= 2) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.LAGOONTHEATER);
				}
			//Lagoon secret sight
			d = ploc.distance(new Location(w, -895.5, 26, 544.3));
			if(d <= 1) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.LAGOONSECRETSIGHT);
				}
		//GREIFENHEIM
			//Greifenheim Eingang 1
			d = ploc.distance(new Location(w, -894.5, 20.0, 571.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GREIFENHEIM);
				}
			//Greifenheim Eingang 2.1
			d = ploc.distance(new Location(w, -928.5, 20.0, 583.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GREIFENHEIM);
				}
			//Greifenheim Eingang 2.2
			d = ploc.distance(new Location(w, -926.5, 20.0, 580.5));
			if(d <= 2.5) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GREIFENHEIM);
				}
			//Greifenheim Trainstation
			d = ploc.distance(new Location(w, -915.5, 23.0, 562.3));
			if(d <= 2) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GREIFENHEIMTRAINSTATION);
				}
			//Greifenheim Diner
			d = ploc.distance(new Location(w, -927, 21, 572));
			if(d <= 3) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.GREIFENHEIMDINER);
				}
			//Heidis Door
			d = ploc.distance(new Location(p.getWorld(), -951, 24, 530));
			if(d <= 2) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.HEIDISDOOR);
				}
		//FANTASA	
			//Fantasa View
			d = ploc.distance(new Location(p.getWorld(), -665,32,596));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.FANTASAVIEW);
				}
			//Fantasa Toilets
			d = ploc.distance(new Location(p.getWorld(), -657, 20, 569));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.FANTASATOILETS);
			}
			d = ploc.distance(new Location(p.getWorld(), -657, 20, 565));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.FANTASATOILETS);
			}
			//Fantasa Entrance
			d = ploc.distance(new Location(p.getWorld(), -697, 21, 588));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.FANTASA);
			}
			d = ploc.distance(new Location(p.getWorld(), -753, 21, 537));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.FANTASA);
			}
			d = ploc.distance(new Location(p.getWorld(), -658, 21, 597));
			if(d <= 1.5) {				
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.FANTASA);
								
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
