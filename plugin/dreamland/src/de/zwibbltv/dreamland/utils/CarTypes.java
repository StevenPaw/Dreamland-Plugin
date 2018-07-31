package de.zwibbltv.dreamland.utils;


public enum CarTypes {
	GOLFCART("Golf-Cart", 35, 1),
	SPEEDCAR("Formel 1", 40, 1),
	ANTIQCAR("Dreamland-Shop", 52, 2);
	
	String Name;
	Integer DamageNumber;
	Integer Speed;
	
	private CarTypes(String name, Integer damagenumber, Integer speed) {
		this.Name = name;
		this.DamageNumber = damagenumber;
		this.Speed = speed;
	}
	
	public String getName() {
		return Name;
	}
	public int getDamageNumber() {
		return DamageNumber;
	}
	public int getSpeed() {
		return Speed;
	}
}
