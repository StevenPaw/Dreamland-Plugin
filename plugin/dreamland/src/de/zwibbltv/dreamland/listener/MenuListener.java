package de.zwibbltv.dreamland.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
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

public class MenuListener implements Listener {

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

	// Menu-Menu
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			try {
				if (e.getMaterial().equals(Material.CARROT_ITEM)) {
					Inventory inv = Bukkit.createInventory(null, 9 * 1, "§cMenu");

					ItemStack warps = new ItemStack(Material.COMPASS);
					ItemMeta warpsmeta = warps.getItemMeta();
					warpsmeta.setDisplayName("§6Warps");
					warps.setItemMeta(warpsmeta);

					ItemStack aach = new ItemStack(Material.BOOKSHELF);
					ItemMeta aachmeta = aach.getItemMeta();
					aachmeta.setDisplayName("§6Achivements");
					aach.setItemMeta(aachmeta);

					inv.setItem(0, warps);
					inv.setItem(8, aach);

					p.openInventory(inv);
				}
			} catch (Exception ex) {

			}
		}
	}

	// Warpteiler-Menu
	@EventHandler
	public void on(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getName().equalsIgnoreCase("§cMenu")) {
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Warps")) {
					Inventory inv = Bukkit.createInventory(null, 9 * 1, "§0Warps");

					ItemStack attraktions = new ItemStack(Material.COMPASS);
					ItemMeta attraktionsmeta = attraktions.getItemMeta();
					attraktionsmeta.setDisplayName("§aAttraktions");
					attraktions.setItemMeta(attraktionsmeta);

					ItemStack areas = new ItemStack(Material.MINECART);
					ItemMeta areasmeta = areas.getItemMeta();
					areasmeta.setDisplayName("§aAreas");
					areas.setItemMeta(areasmeta);

					inv.setItem(3, attraktions);
					inv.setItem(5, areas);

					p.openInventory(inv);
				}

			} catch (Exception ex) {

			}
		}
	}

	// Attraktion-Menu
	@EventHandler
	public void on1(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getName().equalsIgnoreCase("§0Warps")) {
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAttraktions")) {
					Inventory inv = Bukkit.createInventory(null, 9 * 1, "§0Attraktion-Warps");

					ItemStack spawn = new ItemStack(Material.DIAMOND_HOE);
					ItemMeta spawnmeta = spawn.getItemMeta();
					spawnmeta.setDisplayName("§c§lcoming soon");
					spawn.setItemMeta(spawnmeta);
					spawn.setDurability((short) 47);

					inv.setItem(4, spawn);

					p.openInventory(inv);
				}
			} catch (Exception ex) {

			}
		}

	}

	// Areas-Menu
	@EventHandler
	public void on2(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getName().equalsIgnoreCase("§0Warps")) {
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAreas")) {
					Inventory inv = Bukkit.createInventory(null, 9 * 1, "§0Area-Warps");

					ItemStack spawn = new ItemStack(Material.COMPASS);
					ItemMeta spawnmeta = spawn.getItemMeta();
					spawnmeta.setDisplayName("§aGreifenheim");
					spawn.setItemMeta(spawnmeta);

					inv.setItem(4, spawn);

					p.openInventory(inv);
				}
			} catch (Exception ex) {

			}
		}

	}

	// actions
	@EventHandler
	public void on100(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getName().equalsIgnoreCase("§0Area-Warps")) {
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGreifenheim")) {
					p.performCommand("warp Greifenheim");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}

			} catch (Exception ex) {

			}
		}
		if (e.getInventory().getName().equalsIgnoreCase("§cMenu")) {
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Achivements")) {
					p.performCommand("aach list");
				}
			} catch (Exception ex) {

			}
		}
	}
}
