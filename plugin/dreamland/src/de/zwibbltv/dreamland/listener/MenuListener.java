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
		
		Player p = e.getPlayer();
		e.getPlayer().getInventory().clear();
		e.getPlayer().getEquipment().clear();
		
		ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("§6Menu").build();
		ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("§6Buy VIP").build();
		
		if(p.hasPermission("dreamland.build.*") || p.hasPermission("dreamland.build.self") || p.hasPermission("dreamland.build.other")) {
		ItemStack cobblestone = new ItemBuilder(Material.GOLD_SPADE).setDisplayName("§6Builder").build();
		e.getPlayer().getInventory().setItem(7, cobblestone);
		}

		e.getPlayer().getInventory().setItem(0, carrot);
		e.getPlayer().getInventory().setItem(8, golden_carrot);

	}

	// Menu-Menu
	@EventHandler
	public void onOpenMainmenu(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			try {
				if (e.getMaterial().equals(Material.CARROT_ITEM)) {
					openMenuMain(p);
				}
				else {
					de.zwibbltv.dreamland.attractions.ToI.test(p);
				}
			} catch (Exception ex) {

			}
		}
	}


	// actions
	@EventHandler
	public void onMenuClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAreas")) {
					openMenuAreas(p);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAttraktions")) {
					openMenuAttractions(p);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Warps")) {
					openMenuWarps(p);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpawn")) {
					p.performCommand("warp Spawn");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}					
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGreifenheim")) {
					p.performCommand("warp Greifenheim");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCalico")) {
					p.performCommand("warp Calico");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLagoon")) {
					p.performCommand("warp Lagoon");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")) {
					openMenuMain(p);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFlying Pegasus")) {
					p.performCommand("warp Flying_Pegasus");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTower of Izran")) {
					p.performCommand("warp Tower_of_Izran");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aWestern race")) {
					p.performCommand("warp Western_race");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aExplorers Cave")) {
					p.performCommand("warp Explorers_Cave");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	

			} catch (Exception ex) {

			
		}
		if (e.getInventory().getName().equalsIgnoreCase("§cMenu")) {
			try {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Achievements")) {
					p.performCommand("aach list");
				}
			} catch (Exception ex) {

			}
		}
	}
	
	// VIP-Menu
		@EventHandler
		public void onPlayerInteract2(PlayerInteractEvent e) {
			Player p = e.getPlayer();

			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK
					|| e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				
					if (e.getMaterial().equals(Material.GOLDEN_CARROT)) {
						p.performCommand("buy");
					} 				
			}
		}
		
		// VIP-Menu
				@EventHandler
				public void onPlayerInteract3(PlayerInteractEvent e) {
					Player p = e.getPlayer();

					if(p.hasPermission("dreamland.build.*") || p.hasPermission("dreamland.build.self") || p.hasPermission("dreamland.build.other")) {
					if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK
							|| e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
						
							if (e.getMaterial().equals(Material.GOLD_SPADE)) {
								p.performCommand("build");
								e.setCancelled(true);
							} 	
						}
					}
				}
		
		//Open Menu
		//Open Main Menu
		public static void openMenuMain(Player p)
		{
			Inventory inv = Bukkit.createInventory(null, 9 * 1, "§cMenu");

			ItemStack warps = new ItemStack(Material.COMPASS);
			ItemMeta warpsmeta = warps.getItemMeta();
			warpsmeta.setDisplayName("§6Warps");
			warps.setItemMeta(warpsmeta);

			ItemStack aach = new ItemStack(Material.BOOKSHELF);
			ItemMeta aachmeta = aach.getItemMeta();
			aachmeta.setDisplayName("§6Achievements");
			aach.setItemMeta(aachmeta);

			inv.setItem(0, warps);
			inv.setItem(8, aach);

			p.openInventory(inv);
		}
		
		//Open Warps Menu
		public void openMenuWarps(Player p) {
			Inventory inv = Bukkit.createInventory(null, 9 * 1, "§0Warps");

			ItemStack attraktions = new ItemStack(Material.MINECART);
			ItemMeta attraktionsmeta = attraktions.getItemMeta();
			attraktionsmeta.setDisplayName("§aAttraktions");
			attraktions.setItemMeta(attraktionsmeta);

			ItemStack areas = new ItemStack(Material.COMPASS);
			ItemMeta areasmeta = areas.getItemMeta();
			areasmeta.setDisplayName("§aAreas");
			areas.setItemMeta(areasmeta);

			inv.setItem(3, attraktions);
			inv.setItem(5, areas);

			p.openInventory(inv);
		}
		
		//Open Attractions Menu
		public void openMenuAttractions(Player p) {
			Inventory inv = Bukkit.createInventory(null, 9 * 1, "§0Attraktion-Warps");

			ItemStack ExplorersCave = new ItemStack(Material.COBBLESTONE);
			ItemMeta ExplorersCavemeta = ExplorersCave.getItemMeta();
			ExplorersCavemeta.setDisplayName("§aExplorers Cave");
			ExplorersCave.setItemMeta(ExplorersCavemeta);
			ExplorersCave.setDurability((short) 22);
			
			ItemStack flyingpegasus = new ItemStack(Material.ELYTRA);
			ItemMeta flyingpegasusmeta = flyingpegasus.getItemMeta();
			flyingpegasusmeta.setDisplayName("§aFlying Pegasus");
			flyingpegasus.setItemMeta(flyingpegasusmeta);
			
			ItemStack Westernrace = new ItemStack(Material.DIAMOND_BARDING);
			ItemMeta Westernracemeta = Westernrace.getItemMeta();
			Westernracemeta.setDisplayName("§aWestern race");
			Westernrace.setItemMeta(Westernracemeta);
			
			ItemStack ToI = new ItemStack(Material.DIAMOND_SWORD);
			ItemMeta ToImeta = ToI.getItemMeta();
			ToImeta.setDisplayName("§aTower of Izran");
			ToI.setItemMeta(ToImeta);
			ToI.setDurability((short) 22);
			
			ItemStack back = new ItemStack(Material.WOOL, 1, (short)14);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§cBack");
			back.setItemMeta(backmeta);

			inv.setItem(0, ExplorersCave);
			inv.setItem(2, flyingpegasus);
			inv.setItem(4, Westernrace);
			inv.setItem(6, ToI);
			inv.setItem(8, back);

			p.openInventory(inv);
		}

		//Open Areas Menu
		public void openMenuAreas(Player p) {
			Inventory inv = Bukkit.createInventory(null, 9 * 1, "§0Area-Warps");

			ItemStack spawn = new ItemStack(Material.COMPASS);
			ItemMeta spawnmeta = spawn.getItemMeta();
			spawnmeta.setDisplayName("§aSpawn");
			spawn.setItemMeta(spawnmeta);
			
			ItemStack Greifenheim = new ItemStack(Material.SMOOTH_BRICK);
			ItemMeta Greifenheimmeta = Greifenheim.getItemMeta();
			Greifenheimmeta.setDisplayName("§aGreifenheim");
			Greifenheim.setItemMeta(Greifenheimmeta);
			
			ItemStack Calico = new ItemStack(Material.WOOD, 1, (short)1);
			ItemMeta Calicometa = Calico.getItemMeta();
			Calicometa.setDisplayName("§aCalico");
			Calico.setItemMeta(Calicometa);
			
			ItemStack Lagoon = new ItemStack(Material.QUARTZ_BLOCK, 1, (short)2);
			ItemMeta Lagoonmeta = Lagoon.getItemMeta();
			Lagoonmeta.setDisplayName("§aLagoon");
			Lagoon.setItemMeta(Lagoonmeta);
			
			ItemStack back = new ItemStack(Material.WOOL, 1, (short)14);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§cBack");
			back.setItemMeta(backmeta);

			inv.setItem(0, spawn);
			inv.setItem(3, Greifenheim);
			inv.setItem(4, Calico);
			inv.setItem(5, Lagoon);
			inv.setItem(8, back);

			p.openInventory(inv);
		}
}
