package de.zwibbltv.dreamland.commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.zwibbltv.dreamland.utils.CarController;
import de.zwibbltv.dreamland.utils.CarTypes;
import de.zwibbltv.dreamland.utils.PlayerConfig;

public class CMDCar implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("car")) {

			if (args.length == 0) {
				if (sender instanceof Player) {
					Player p = ((Player) sender).getPlayer();
					if(PlayerConfig.getCar(p).equals(null) || PlayerConfig.getCar(p).equals(0)) {
						//DECIDING THE INVENTORY SIZE
						//----from here---
						int invSize = 1;
						int CarNumber = 0;
						for(int i = 0; i < CarTypes.values().length; i++) {
							CarNumber += 1;
						}
						boolean passt = false;
						while(passt == false) {
							if(9*invSize > CarNumber) {
								passt = true;
							} else {
								invSize += 1;
							}
						}
						//---to here---
						Inventory inv = Bukkit.createInventory(null, 9 * invSize, "Cars");

						int i = 0; //to decide place in Inventory
						for(CarTypes car : CarTypes.values()) {
							ItemStack carItem = new ItemStack(Material.DIAMOND_SWORD);
							ItemMeta carMeta = carItem.getItemMeta();
							carMeta.setDisplayName(car.getName());
							carItem.setItemMeta(carMeta);
							carItem.setDurability((short)car.getDamageNumber());
							inv.setItem(i, carItem);
							i = i + 1;
						}
						p.openInventory(inv);
						try {
							PlayerConfig.setCurrentInventory(p, "Car");
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						CarController.unuseCar(p);
					}
				}
			}
		}
		return true;
	}
}
