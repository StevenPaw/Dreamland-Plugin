package de.zwibbltv.dreamland.utils;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CarController {
	public static void useCar(InventoryClickEvent e) {
		Bukkit.broadcastMessage("useCar wird ausgeführt");
		String Cartype = e.getCurrentItem().getItemMeta().getDisplayName();
		Integer damage = 0;
		//		Integer speed = 0;
		Player p = (Player)e.getWhoClicked();
		Bukkit.broadcastMessage("Geklickt hat " + p.getName());
		for(CarTypes cartype : CarTypes.values()) {
			if (cartype.getName() == Cartype) {
				damage = cartype.getDamageNumber();
				//				speed = cartype.getSpeed();
			}
		}
		try {
			PlayerConfig.setCar(p, damage);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Bukkit.broadcastMessage("Autodamage " + damage);
		ArmorStand Car = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
		ItemStack is = new ItemStack(Material.DIAMOND_SWORD);
		is.setDurability(damage.shortValue());
		Car.setHelmet(is);
		Car.setVisible(false);
		Car.setCollidable(false);
		Car.setInvulnerable(true);
		Car.addPassenger(p);
		Car.setSmall(true);
		p.closeInventory();
	}

	public static void unuseCar(Player p) {
		Entity Car = p.getVehicle();
			Car.removePassenger(p);
			Car.remove();
		try {
			PlayerConfig.setCar(p, 0);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
