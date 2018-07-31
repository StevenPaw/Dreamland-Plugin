package de.zwibbltv.dreamland.utils;

import java.io.IOException;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CarController {
	public static void useCar(InventoryClickEvent e) {
		String Cartype = e.getCurrentItem().getItemMeta().getDisplayName();
		Integer damage = 0;
		//		Integer speed = 0;
		Player p = (Player)e.getWhoClicked();
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
		ArmorStand Car = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
		ItemStack is = new ItemStack(Material.DIAMOND_HOE);
		is.setDurability(damage.shortValue());
		Car.setHelmet(is);
		Car.setVisible(false);
		p.addPassenger(Car);
	}

	public static void unuseCar(Player p) {
		List <Entity> e = p.getPassengers();
		for(int i = 0; i < e.size(); i++) {
			p.removePassenger(e.get(i));
		}
	}
}
