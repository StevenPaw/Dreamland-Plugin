package de.zwibbltv.dreamland.utils;

public enum Achievements {
	
	FIRSTJOIN("FirstJoin","You joined our Server!",20),
	FIRSTCHAT("FirstChat","You chatted the first time!",10),
	FIRSTMOVE("FirstMove","You moved for the first time!",10),
	RUNAKM("Run a KM","You ran a Kilometer in one session!",10);
	
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
