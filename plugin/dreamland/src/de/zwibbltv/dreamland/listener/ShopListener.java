package de.zwibbltv.dreamland.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.milkbowl.vault.economy.Economy;

public class ShopListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		if(e.getRightClicked().getType() == EntityType.VILLAGER) {
			Villager v = (Villager) e.getRightClicked();
			e.setCancelled(true);
			
			if(v.getCustomName().equalsIgnoreCase("Shop")) {
				
				ItemStack i = new ItemStack(Material.STONE);
				ItemMeta im = i.getItemMeta();
				im.setDisplayName("Geile Steine!");
				ArrayList<String> lore = new ArrayList<>();
				lore.add("Price: 10");
				im.setLore(lore);
				i.setItemMeta(im);
				
				Inventory inv = Bukkit.createInventory(null, 18, "Shop");
				inv.setItem(0, i);
				e.getPlayer().openInventory(inv);
			} 
		}
		
		
	}

	@EventHandler
	public void onINVclick(InventoryClickEvent e) {

	    Economy eco = de.zwibbltv.dreamland.main.Main.economy;
		
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getName().equalsIgnoreCase("Shop")) {
					
		if(e.getCurrentItem().getType() == Material.STONE) {
			if(eco.getBalance(p) >= 10.0) {
				
				p.getInventory().addItem(new ItemStack(Material.STONE, 1));
				eco.withdrawPlayer(p, 10.0);
				p.closeInventory();
				p.sendMessage("§aYou bought 1 Stone. WOW!!");
				de.zwibbltv.dreamland.main.updateScoreboard.update(p);
				
			} else
				p.sendMessage("§cYou do not have enough money!");
				p.closeInventory();
			}
		}
	}
}
