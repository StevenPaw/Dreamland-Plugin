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

import de.zwibbltv.dreamland.main.ItemBuilder;

public class MenuListener implements Listener{

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onIMove(InventoryClickEvent e) {
		e.setCancelled(true);
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
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR | e.getAction() == Action.RIGHT_CLICK_BLOCK | e.getAction() == Action.LEFT_CLICK_AIR | e.getAction() == Action.LEFT_CLICK_BLOCK) {
			if(e.getMaterial().equals(Material.CARROT_ITEM)) {
				
				Inventory inv = Bukkit.createInventory(null, 9*1, "§cMenu");
				
				ItemStack i = new ItemStack(Material.COMPASS);
				i.setAmount(1);
				ItemMeta im = i.getItemMeta();
				im.setDisplayName("§a§lSpawn");
				i.setItemMeta(im);
				
				inv.setItem(0, i);
				p.openInventory(inv);
			}
			if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSpawn")) {
				Bukkit.dispatchCommand(p, "spawn");
			}
		}
	}
}
