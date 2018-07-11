package de.zwibbltv.dreamland.utils;

import org.bukkit.Color;
import org.bukkit.Material;

public enum Shop {
	COWBOYJACKETBROWN("Calico-Shop", 0, "Cowboy Jacket Brown", Material.LEATHER_CHESTPLATE, 10, 0, 0, 0),
	COWBOYJACKETBLACK("Calico-Shop", 1, "Cowboy Jacket Black", Material.LEATHER_CHESTPLATE, 10, 0, 0, 0);

	
	String shopname;
	int slot;
	String name;
	Material material;
	int money;
	int R;
	int G;
	int B;

	private Shop(String shopname,int slot, String name, Material material, int money, int R, int G, int B) {
		this.shopname = shopname;
		this.slot = slot;
		this.name = name;
		this.material = material;
		this.money = money;
		this.R = R;
		this.G = G;
		this.B = B;
	}
	
	public String getShopName() {
		return shopname;
	}
	
	public int getSlot() {
		return slot;
	}
	
	public String getName() {
		return name;
	}
	
	public Material getMaterial() {
		return material;
	}	
	
	public int getMoney() {
		return money;
	}	
	
	public Color getColor() {
		return Color.fromRGB(R, G, B);
	}
}
