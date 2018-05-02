package de.zwibbltv.dreamland.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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

import de.zwibbltv.dreamland.main.ItemBuilder;
import de.zwibbltv.dreamland.utils.Achievements;
import de.zwibbltv.dreamland.utils.PlayerConfig;

public class MenuListener implements Listener {
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (PlayerConfig.getBuilder(p) == false) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onIMove(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (PlayerConfig.getBuilder(p) == false) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		if(PlayerConfig.getBuilder(p) == false){
			
		e.getPlayer().getInventory().clear();
		e.getPlayer().getEquipment().clear();
		
		ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("§6Menu").build();
		ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("§6Buy VIP").build();
		
		if(p.hasPermission("dreamland.build.*") || p.hasPermission("dreamland.build.self") || p.hasPermission("dreamland.build.other")) {
		ItemStack gold_spade = new ItemBuilder(Material.GOLD_SPADE).setDisplayName("§6Builder").build();
		e.getPlayer().getInventory().setItem(7, gold_spade);
		}

		e.getPlayer().getInventory().setItem(0, carrot);
		e.getPlayer().getInventory().setItem(8, golden_carrot);

		}
		if(PlayerConfig.getBuilder(p) == true) {
			p.setGameMode(GameMode.CREATIVE);
		}
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
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Achievements")) {
					openMenuAchievements(p);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpawn")) {
					p.performCommand("warp spawn");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}					
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGreifenheim")) {
					p.performCommand("warp greifenheim");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCalico")) {
					p.performCommand("warp calico");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLagoon")) {
					p.performCommand("warp lagoon");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")) {
					openMenuMain(p);
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFlying Pegasus")) {
					p.performCommand("warp flying_pegasus");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTower of Izran")) {
					p.performCommand("warp tower_of_izran");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aWestern race")) {
					p.performCommand("warp western_race");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aExplorers Cave")) {
					p.performCommand("warp explorers_cave");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Audio")) {
					p.performCommand("audio");
					p.closeInventory();
				}	
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHaunted Mansion")) {
					p.performCommand("warp haunted_mansion");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aChinatown")) {
					p.performCommand("warp chinatown");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}

			} catch (Exception ex) {			
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
		
		// Build-Menu
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
			
			ItemStack audio = new ItemStack(Material.PRISMARINE_SHARD);
			ItemMeta audiometa = audio.getItemMeta();
			audiometa.setDisplayName("§6Audio");
			audio.setItemMeta(audiometa);

			inv.setItem(0, warps);
			inv.setItem(7, audio);
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
			Inventory inv = Bukkit.createInventory(null, 9 * 2, "§0Attraktion-Warps");

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
			
			ItemStack back = new ItemStack(Material.CLAY_BRICK);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§cBack");
			back.setItemMeta(backmeta);
			
			ItemStack haunted_mansion = new ItemStack(Material.SKULL_ITEM);
			ItemMeta haunted_mansionmeta = haunted_mansion.getItemMeta();
			haunted_mansionmeta.setDisplayName("§aHaunted Mansion");
			haunted_mansion.setItemMeta(haunted_mansionmeta);

			inv.setItem(0, ExplorersCave);
			inv.setItem(2, flyingpegasus);
			inv.setItem(4, Westernrace);
			inv.setItem(6, ToI);
			inv.setItem(8, haunted_mansion);
			inv.setItem(17, back);

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
			
			ItemStack back = new ItemStack(Material.CLAY_BRICK);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("§cBack");
			back.setItemMeta(backmeta);
			
			ItemStack chinatown = new ItemStack(Material.BOWL);
			ItemMeta chinatownmeta = chinatown.getItemMeta();
			chinatownmeta.setDisplayName("§aChinatown");
			chinatown.setItemMeta(chinatownmeta);

			inv.setItem(0, spawn);
			inv.setItem(3, Greifenheim);
			inv.setItem(4, Calico);
			inv.setItem(5, Lagoon);
			inv.setItem(6, chinatown);
			inv.setItem(8, back);

			p.openInventory(inv);
		}
		
		public void openMenuAchievements(Player p) {
			Inventory inv = Bukkit.createInventory(null, 9 * 3, "§0Achievements");
			
			int i = 0;
			for (Achievements ach : Achievements.values()) {
				if(PlayerConfig.hasAchivement(p, ach))
				{
					ItemStack achItem = new ItemStack(Material.WOOL, 1, (short) 5);
					ItemMeta achMeta = achItem.getItemMeta();
					achMeta.setDisplayName("§a"+ ach.getName());
					List<String> lore = new ArrayList<String>();
					lore.add(ach.getText());
					achMeta.setLore(lore);
					achItem.setItemMeta(achMeta);
					inv.setItem(i, achItem);
				} else {
					ItemStack achItem = new ItemStack(Material.WOOL, 1, (short) 14);
					ItemMeta achMeta = achItem.getItemMeta();
					if(ach.getVisibility()) {
						achMeta.setDisplayName("§c"+ ach.getName());
						List<String> lore = new ArrayList<String>();
						lore.add(ach.getTask());
						achMeta.setLore(lore);
					} else {
						achMeta.setDisplayName("§c§k" + ach.getName());
						List<String> lore = new ArrayList<String>();
						lore.add(ach.getTask());
						achMeta.setLore(lore);
					}
					achItem.setItemMeta(achMeta);
					inv.setItem(i, achItem);
				}
				i = i + 1;
			}
//			
//			if(PlayerConfig.hasAchivement(p, Achievements.CALICOSAFE)) {
//			ItemStack Calicosafe = new ItemStack(Material.WOOL, 1, (short) 5);
//			ItemMeta Calicosafemeta = Calicosafe.getItemMeta();
//			Calicosafemeta.setDisplayName("§a"+ Achievements.CALICOSAFE);
//			Calicosafe.setItemMeta(Calicosafemeta);
//			inv.setItem(3, Calicosafe);
//			}
//
//			if(!PlayerConfig.hasAchivement(p, Achievements.CALICOSAFE)) {
//			ItemStack Calicosafe = new ItemStack(Material.WOOL, 1, (short) 14);
//			ItemMeta Calicosafemeta = Calicosafe.getItemMeta();
//			Calicosafemeta.setDisplayName("§c"+Achievements.CALICOSAFE);
//			Calicosafe.setItemMeta(Calicosafemeta);
//			inv.setItem(1, Calicosafe);
//			}
			p.openInventory(inv);
		}
}
