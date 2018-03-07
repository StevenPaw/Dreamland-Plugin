package de.zwibbltv.dreamland.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.zwibbltv.dreamland.commands.CMDbuild;
import de.zwibbltv.dreamland.main.ItemBuilder;

public class MenuListener implements Listener{
	
	

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (!CMDbuild.buildallowed.contains(p)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onIMove(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (!CMDbuild.buildallowed.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("§6Menu").build();
		
		e.getPlayer().getInventory().clear();
		e.getPlayer().getInventory().setItem(0, carrot);

	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			try {
				if (e.getMaterial().equals(Material.CARROT_ITEM)) {
					Inventory inv = Bukkit.createInventory(null, 9 * 1, "§cMenu");

					ItemStack spawn = new ItemStack(Material.COMPASS);
					ItemMeta spawnmeta = spawn.getItemMeta();
					spawnmeta.setDisplayName("§a§lSpawn");
					spawn.setItemMeta(spawnmeta);

					inv.setItem(0, spawn);

					p.openInventory(inv);
				}
			} catch (Exception ex) {

			}
		}
	}
	
	@EventHandler
	public void on(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getInventory().getName().equalsIgnoreCase("§cMenu")) {
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpawn")) {
					p.performCommand("spawn");
					p.closeInventory();
				}
			} catch (Exception ex) {
				
			}
		}
		
	}
}
