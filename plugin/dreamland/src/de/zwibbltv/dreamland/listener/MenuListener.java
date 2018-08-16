package de.zwibbltv.dreamland.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
//import org.bukkit.inventory.meta.LeatherArmorMeta;

import de.zwibbltv.dreamland.main.ItemBuilder;
import de.zwibbltv.dreamland.utils.Achievements;
//import de.zwibbltv.dreamland.utils.CarController;
import de.zwibbltv.dreamland.utils.PlayerConfig;
//import de.zwibbltv.dreamland.utils.Shop;

public class MenuListener implements Listener {


	static List<String> catList = new ArrayList<String>();

	// actions
	@EventHandler
	public void onMenuClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		try {

			//CarsMenu
			//				if(e.getClickedInventory().getTitle().equals("Cars"))
			//					CarController.useCar(e);

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aLocations")) {
				openMenuLocations(p);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aAttraktions")) {
				openMenuAttractions(p);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6Warps")) {
				openMenuWarps(p); 				
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6Achievements (" + getAchievementsPercentage(p) + "%)")) {
				openMenuAchievements(p,p);
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�cBack")) {
				if(PlayerConfig.getCurrentInventory(p) == "AchievementsCat"){
					openMenuAchievements(p,p);
				} else if(PlayerConfig.getCurrentInventory(p) == "WarpsLocations" || PlayerConfig.getCurrentInventory(p) == "WarpsAttractions") {
					openMenuWarps(p);
				} else
					openMenuMain(p);
			}

			if(PlayerConfig.getCurrentInventory(p) == "WarpsAttractions") {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aFlying Pegasus")) {
					p.performCommand("warp flying_pegasus");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	

				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aTower of Izran")) {
					p.performCommand("warp tower_of_izran");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	

				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aWestern race")) {
					p.performCommand("warp western_race");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	

				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aExplorers Cave")) {
					p.performCommand("warp explorers_cave");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}	
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aSpawn")) {
					p.performCommand("warp spawn");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}					
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aGreifenheim")) {
					p.performCommand("warp greifenheim");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aCalico")) {
					p.performCommand("warp calico");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aLagoon")) {
					p.performCommand("warp lagoon");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aHaunted Mansion")) {
					p.performCommand("warp haunted_mansion");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}

				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aChinatown")) {
					p.performCommand("warp chinatown");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aInformation-Center")) {
					p.performCommand("warp information-center");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
			}




			if(PlayerConfig.getCurrentInventory(p) == "WarpsLocations") {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aCastle")) {
					p.performCommand("warp castle");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aFantasa")) {
					p.performCommand("warp fantasa");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aEverwoods")) {
					p.performCommand("warp everwoods");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aEPCOT")) {
					p.performCommand("warp epcot");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aTaruba")) {
					p.performCommand("warp taruba");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aForbidden Woods")) {
					p.performCommand("warp forbidden_woods");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aLil' Hill")) {
					p.performCommand("warp lil_hill");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�aLil' Coaster")) {
					p.performCommand("warp lil_coaster");
					p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 1);
					p.closeInventory();
				}
			}

			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�6Audio")) {
				p.performCommand("audio");
				p.closeInventory();
			}	

			if (PlayerConfig.getCurrentInventory(p) == "Achievements") {
				for(int s = 0; s < catList.size(); s++) {
					if(catList.get(s) == e.getCurrentItem().getItemMeta().getDisplayName()) {
						openAchCategory(p, p, e.getCurrentItem().getItemMeta().getDisplayName());
					}
				}
			}
			for(Player player : Bukkit.getOnlinePlayers()) {
				if (PlayerConfig.getCurrentInventory(p) == "AchievementsOther " + player.getName()) {
					for(int s = 0; s < catList.size(); s++) {
						if(catList.get(s) == e.getCurrentItem().getItemMeta().getDisplayName()) {
							openAchCategory(player, p, e.getCurrentItem().getItemMeta().getDisplayName());
						}
					}
				}
			}

		} catch (Exception ex) {			
		}
	}


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

	static public void resetInventory(Player p)
	{
		if(PlayerConfig.getBuilder(p) == false){
			p.getInventory().clear();
			p.getEquipment().clear();

			ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("�6Menu").build();
			ItemStack chest = new ItemBuilder(Material.CHEST).setDisplayName("�6Inventory").build();
			p.getInventory().setItem(0, carrot);
			p.getInventory().setItem(8, chest);

			if(p.hasPermission("dreamland.build.*") || p.hasPermission("dreamland.build.self") || p.hasPermission("dreamland.build.other")) {
				ItemStack gold_spade = new ItemBuilder(Material.GOLD_SPADE).setDisplayName("�6Builder").build();
				p.getInventory().setItem(1, gold_spade);
			}

			if(!p.hasPermission("dreamland.VIP")) {
				ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("�6Buy VIP").build();
				p.getInventory().setItem(7, golden_carrot);
			}
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
				if (e.getMaterial().equals(Material.CHEST)) {
					if(e.getItem().getItemMeta().getDisplayName().equals("�6Inventory")) {
						de.zwibbltv.dreamland.listener.InventoryListener.openInvMain(p);
					}
				}
				else {
					de.zwibbltv.dreamland.attractions.ToI.test(p);
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
		Inventory inv = Bukkit.createInventory(null, 9 * 1, "�cMenu");

		ItemStack warps = new ItemStack(Material.COMPASS);
		ItemMeta warpsmeta = warps.getItemMeta();
		warpsmeta.setDisplayName("�6Warps");
		warps.setItemMeta(warpsmeta);

		ItemStack aach = new ItemStack(Material.PRISMARINE_CRYSTALS);
		ItemMeta aachmeta = aach.getItemMeta();
		aachmeta.setDisplayName("�6Achievements (" + getAchievementsPercentage(p) + "%)");
		aach.setItemMeta(aachmeta);

		ItemStack audio = new ItemStack(Material.PRISMARINE_SHARD);
		ItemMeta audiometa = audio.getItemMeta();
		audiometa.setDisplayName("�6Audio");
		audio.setItemMeta(audiometa);

		inv.setItem(0, warps);
		inv.setItem(7, audio);
		inv.setItem(8, aach);

		p.openInventory(inv);
	}

	//Open Warps Menu
	public void openMenuWarps(Player p) {

		Inventory inv = Bukkit.createInventory(null, 9 * 1, "�0Warps");

		ItemStack attraktions = new ItemStack(Material.MINECART);
		ItemMeta attraktionsmeta = attraktions.getItemMeta();
		attraktionsmeta.setDisplayName("�aAttraktions");
		attraktions.setItemMeta(attraktionsmeta);

		ItemStack locations = new ItemStack(Material.COMPASS);
		ItemMeta locationsmeta = locations.getItemMeta();
		locationsmeta.setDisplayName("�aLocations");
		locations.setItemMeta(locationsmeta);

		ItemStack back = new ItemStack(Material.CLAY_BRICK);
		ItemMeta backmeta = back.getItemMeta();
		backmeta.setDisplayName("�cBack");
		back.setItemMeta(backmeta);

		inv.setItem(3, attraktions);
		inv.setItem(5, locations);
		inv.setItem(8, back);

		try {
			PlayerConfig.setCurrentInventory(p, "Warps");
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.openInventory(inv);
	}

	//Open Attractions Menu
	public void openMenuAttractions(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9 * 2, "�0Attraktion-Warps");

		ItemStack ExplorersCave = new ItemStack(Material.COBBLESTONE);
		ItemMeta ExplorersCavemeta = ExplorersCave.getItemMeta();
		ExplorersCavemeta.setDisplayName("�aExplorers Cave");
		ExplorersCave.setItemMeta(ExplorersCavemeta);
		ExplorersCave.setDurability((short) 22);

		ItemStack flyingpegasus = new ItemStack(Material.ELYTRA);
		ItemMeta flyingpegasusmeta = flyingpegasus.getItemMeta();
		flyingpegasusmeta.setDisplayName("�aFlying Pegasus");
		flyingpegasus.setItemMeta(flyingpegasusmeta);

		ItemStack Westernrace = new ItemStack(Material.DIAMOND_BARDING);
		ItemMeta Westernracemeta = Westernrace.getItemMeta();
		Westernracemeta.setDisplayName("�aWestern race");
		Westernrace.setItemMeta(Westernracemeta);

		ItemStack ToI = new ItemStack(Material.DIAMOND_SWORD, 1, (short) 22);
		ItemMeta ToImeta = ToI.getItemMeta();
		ToImeta.setDisplayName("�aTower of Izran");
		ToI.setItemMeta(ToImeta);

		ItemStack haunted_mansion = new ItemStack(Material.SKULL_ITEM);
		ItemMeta haunted_mansionmeta = haunted_mansion.getItemMeta();
		haunted_mansionmeta.setDisplayName("�aHaunted Mansion");
		haunted_mansion.setItemMeta(haunted_mansionmeta);

		ItemStack back = new ItemStack(Material.CLAY_BRICK);
		ItemMeta backmeta = back.getItemMeta();
		backmeta.setDisplayName("�cBack");
		back.setItemMeta(backmeta);

		ItemStack taruba = new ItemStack(Material.DIAMOND_SWORD, 1, (short) 25);
		ItemMeta tarubameta = taruba.getItemMeta();
		tarubameta.setDisplayName("�aTaruba");
		taruba.setItemMeta(tarubameta);

		ItemStack forbidden_woods = new ItemStack(Material.DIAMOND_SWORD, 1, (short) 2);
		ItemMeta forbidden_woodsmeta = forbidden_woods.getItemMeta();
		forbidden_woodsmeta.setDisplayName("�aForbidden Woods");
		forbidden_woods.setItemMeta(forbidden_woodsmeta);

		ItemStack lil_coaster = new ItemStack(Material.BARRIER);
		ItemMeta lil_coastermeta = lil_coaster.getItemMeta();
		lil_coastermeta.setDisplayName("�aLil' Coaster");
		lil_coaster.setItemMeta(lil_coastermeta);

		inv.setItem(0, ExplorersCave);
		inv.setItem(1, flyingpegasus);
		inv.setItem(2, Westernrace);
		inv.setItem(3, ToI);
		inv.setItem(4, haunted_mansion);
		inv.setItem(5, forbidden_woods);
		inv.setItem(8, back);

		if (PlayerConfig.getBuilder(p) == true) {
			inv.setItem(6, taruba);
			inv.setItem(7, lil_coaster);
		}

		try {
			PlayerConfig.setCurrentInventory(p, "WarpsAttractions");
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.openInventory(inv);
	}

	//Open Location Menu
	public void openMenuLocations(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9 * 2, "�0Location-Warps");

		ItemStack spawn = new ItemStack(Material.COMPASS);
		ItemMeta spawnmeta = spawn.getItemMeta();
		spawnmeta.setDisplayName("�aSpawn");
		spawn.setItemMeta(spawnmeta);

		ItemStack Greifenheim = new ItemStack(Material.COBBLESTONE);
		ItemMeta Greifenheimmeta = Greifenheim.getItemMeta();
		Greifenheimmeta.setDisplayName("�aGreifenheim");
		Greifenheim.setItemMeta(Greifenheimmeta);

		ItemStack Calico = new ItemStack(Material.WOOD, 1, (short) 1);
		ItemMeta Calicometa = Calico.getItemMeta();
		Calicometa.setDisplayName("�aCalico");
		Calico.setItemMeta(Calicometa);

		ItemStack Lagoon = new ItemStack(Material.QUARTZ_BLOCK, 1, (short) 2);
		ItemMeta Lagoonmeta = Lagoon.getItemMeta();
		Lagoonmeta.setDisplayName("�aLagoon");
		Lagoon.setItemMeta(Lagoonmeta);

		ItemStack back = new ItemStack(Material.CLAY_BRICK);
		ItemMeta backmeta = back.getItemMeta();
		backmeta.setDisplayName("�cBack");
		back.setItemMeta(backmeta);

		ItemStack chinatown = new ItemStack(Material.BOWL);
		ItemMeta chinatownmeta = chinatown.getItemMeta();
		chinatownmeta.setDisplayName("�aChinatown");
		chinatown.setItemMeta(chinatownmeta);

		ItemStack info = new ItemStack(Material.STICK);
		ItemMeta infometa = info.getItemMeta();
		infometa.setDisplayName("�aInformation-Center");
		info.setItemMeta(infometa);

		ItemStack castle = new ItemStack(Material.DIAMOND_HOE, 1, (short) 12);
		ItemMeta castlemeta = castle.getItemMeta();
		castlemeta.setDisplayName("�aCastle");
		castle.setItemMeta(castlemeta);

		ItemStack fantasa = new ItemStack(Material.SMOOTH_BRICK);
		ItemMeta fantasameta = fantasa.getItemMeta();
		fantasameta.setDisplayName("�aFantasa");
		fantasa.setItemMeta(fantasameta);

		ItemStack everwoods = new ItemStack(Material.LOG_2);
		ItemMeta everwoodsmeta = everwoods.getItemMeta();
		everwoodsmeta.setDisplayName("�aEverwoods");
		everwoods.setItemMeta(everwoodsmeta);

		ItemStack epcot = new ItemStack(Material.RED_ROSE);
		ItemMeta epcotmeta = epcot.getItemMeta();
		epcotmeta.setDisplayName("�aEPCOT");
		epcot.setItemMeta(epcotmeta);

		ItemStack lilhill = new ItemStack(Material.STONE);
		ItemMeta lilhillmeta = lilhill.getItemMeta();
		lilhillmeta.setDisplayName("�aLil' Hill");
		lilhill.setItemMeta(lilhillmeta);

		inv.setItem(0, spawn);
		inv.setItem(2, Greifenheim);
		inv.setItem(3, Calico);
		inv.setItem(4, Lagoon);
		inv.setItem(5, chinatown);
		inv.setItem(6, info);
		inv.setItem(11, castle);
		inv.setItem(12, fantasa);
		inv.setItem(17, back);

		if (PlayerConfig.getBuilder(p) == true) {
			inv.setItem(13, everwoods);
			inv.setItem(14, epcot);
			inv.setItem(15, lilhill);
		}

		try {
			PlayerConfig.setCurrentInventory(p, "WarpsLocations");
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.openInventory(inv);
	}

	//Opening Achievementcateg:
	public static void openMenuAchievements(Player p, Player receiver) {

		//CREATING COLORVARIABLE AND CLEARING CATLIST
		Integer Pos = 0;
		catList.clear();
		String inv_ach_percent = getAchievementsPercentage(p).toString();
		Inventory inv_ach = Bukkit.createInventory(null, 9 * 2, "�0Achievements (" + inv_ach_percent + "%)");

		//CHECKING EACH ACHIEVEMENT FOR NEW CATEGORIES
		for(Achievements ach : Achievements.values()) {

			boolean isnew = true;

			for(Integer i = 0; i < catList.size(); i++) {
				if(ach.getCategory() == catList.get(i)) {
					isnew = false;
				}
			}

			if(isnew == true) {
				int Color = 0;

				if(getCategoryPercentage(p, ach.getCategory()) == 0)
					Color = 6;
				else if (getCategoryPercentage(p, ach.getCategory()) == 100)
					Color = 5;
				else
					Color = 4;


				ItemStack achItem = new ItemStack(Material.STAINED_CLAY, 1, (short) (double)Color);
				ItemMeta achMeta = achItem.getItemMeta();

				if(getCategoryPercentage(p, ach.getCategory()) == 0) {
					Color = 6;
					List<String> lore = new ArrayList<String>();
					lore.add("�4" + getCategoryPercentage(p,ach.getCategory()) + "% completed");
					achMeta.setLore(lore);
				}
				else if (getCategoryPercentage(p, ach.getCategory()) == 100) {
					Color = 5;
					List<String> lore = new ArrayList<String>();
					lore.add("�a" + getCategoryPercentage(p,ach.getCategory()) + "% completed");
					achMeta.setLore(lore);
				} else {
					Color = 4;
					List<String> lore = new ArrayList<String>();
					lore.add("�e" + getCategoryPercentage(p,ach.getCategory()) + "% completed");
					achMeta.setLore(lore);
				}

				achMeta.setDisplayName(ach.getCategory());
				achItem.setItemMeta(achMeta);
				inv_ach.setItem(Pos, achItem);
				catList.add(ach.getCategory());
				Pos = Pos + 1;
			} else {
			}
		}

		if(p == receiver) {
			ItemStack back = new ItemStack(Material.CLAY_BRICK);
			ItemMeta backmeta = back.getItemMeta();
			backmeta.setDisplayName("�cBack");
			back.setItemMeta(backmeta);
			inv_ach.setItem(9 * 2 - 1, back);
		}

		inv_ach_percent = getAchievementsPercentage(p).toString();
		receiver.openInventory(inv_ach);
		try {
			PlayerConfig.setCurrentInventory(p, "Achievements");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Achievementcategory �ffnen:
	public static void openAchCategory(Player p, Player receiver, String cat) {

		//DECIDING THE INVENTORY SIZE
		//----from here---
		int invSize = 1;
		int AchNumber = 0;
		for(Achievements achn : Achievements.values()) {
			if(achn.getCategory() == cat) //Counting the Achievements in that Category
				AchNumber += 1;
		}
		boolean passt = false;
		while(passt == false) {
			if(9*invSize > AchNumber) {
				passt = true;
			} else {
				invSize += 1;
			}
		}
		//---to here---

		Inventory inv = Bukkit.createInventory(null, 9 * invSize, "�0Achievements: " + cat + " (" + getCategoryPercentage(p, cat) + "%)");

		int i = 0; //to decide place in Inventory
		for(Achievements ach : Achievements.values()) {
			if(ach.getCategory() == cat) {
				if(PlayerConfig.hasAchivement(p, ach))
				{
					ItemStack achItem = new ItemStack(Material.STAINED_CLAY, 1, (short) 5);
					ItemMeta achMeta = achItem.getItemMeta();
					achMeta.setDisplayName("�a"+ ach.getName());
					List<String> lore = new ArrayList<String>();
					lore.add(ach.getText());
					achMeta.setLore(lore);
					achItem.setItemMeta(achMeta);
					inv.setItem(i, achItem);
				} else {
					ItemStack achItem = new ItemStack(Material.STAINED_CLAY, 1, (short) 14);
					ItemMeta achMeta = achItem.getItemMeta();
					if(ach.getVisibility()) {
						achMeta.setDisplayName("�c"+ ach.getName());
						List<String> lore = new ArrayList<String>();
						lore.add(ach.getTask());
						achMeta.setLore(lore);
					} else {
						achMeta.setDisplayName("�c�k" + ach.getName());
						List<String> lore = new ArrayList<String>();
						lore.add(ach.getTask());
						achMeta.setLore(lore);
					}
					achItem.setItemMeta(achMeta);
					inv.setItem(i, achItem);
				}
				i = i + 1;

				//Adding the Back-Button in last place
				ItemStack back = new ItemStack(Material.CLAY_BRICK);
				ItemMeta backmeta = back.getItemMeta();
				backmeta.setDisplayName("�cBack");
				back.setItemMeta(backmeta);
				inv.setItem(9 * invSize - 1, back);
			}
		}
		receiver.openInventory(inv);
		try {
			PlayerConfig.setCurrentInventory(receiver, "AchievementsCat");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Prozentsatz der Achievements errechnen:
	public static Integer getAchievementsPercentage(Player p) {

		int NumberOfAch = 0;
		int NumberCompleted = 0;

		for(Achievements ach : Achievements.values()) {
			NumberOfAch += 1;
			if(PlayerConfig.hasAchivement(p, ach))
			{
				NumberCompleted += 1;
			}
		}
		int percent = (int)((NumberCompleted * 100.0f) / NumberOfAch);

		return percent;
	}

	//Prozentsatz einer Kategorie errechnen:
	public static Integer getCategoryPercentage(Player p, String cat) {

		int NumberOfAch = 0;
		int NumberCompleted = 0;

		for(Achievements ach : Achievements.values()) {
			if(ach.getCategory() == cat) {
				NumberOfAch += 1;
				if(PlayerConfig.hasAchivement(p, ach))
				{
					NumberCompleted += 1;
				}
			}
		}
		int percent = (int)((NumberCompleted * 100.0f) / NumberOfAch);

		return percent;
	}

}
