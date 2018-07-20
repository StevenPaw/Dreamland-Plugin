package de.zwibbltv.dreamland.utils;

import org.bukkit.Color;
import org.bukkit.Material;

public enum Shop {
	COWBOYPISTOL("Calico-Shop", 4, "Cowboy Pistol", Material.BEETROOT, 10, 0, 0, 20),
	LASERGUN("Dreamland-Shop", 3, "Lasergun", Material.SPIDER_EYE, 15, 0, 0, 20),
	GAMEBOY("Dreamland-Shop", 4, "Gameboy", Material.BEETROOT_SEEDS, 45, 0, 0, 20),
	POKEBALL("Dreamland-Shop", 5, "Pokeball", Material.BEETROOT_SOUP, 25, 0, 0, 20),
	FISHBOWL("Lagoon-Shop", 4, "Fishbowl", Material.GHAST_TEAR, 25, 0, 0, 20),
	COWBOYJACKETBROWN("Calico-Shop", 3, "Cowboy Jacket Brown", Material.LEATHER_CHESTPLATE, 10, 0, 0, 20),
	COWBOYJACKETBLACK("Calico-Shop", 5, "Cowboy Jacket Black", Material.LEATHER_CHESTPLATE, 10, 0, 0, 0);

	
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
