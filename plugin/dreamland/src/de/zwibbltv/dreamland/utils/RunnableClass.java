package de.zwibbltv.dreamland.utils;

import java.util.Calendar;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.milkbowl.vault.economy.Economy;

public class RunnableClass {
	//Extends BukkitRunnable to create a run method

	static int dropGoldTimer = 0;

	public static void run(World w, Economy eco) {
		//wird jede Sekunde ausgeführt
		de.zwibbltv.dreamland.utils.BoatEverwoods.runBoatThings();
		de.zwibbltv.dreamland.utils.AFK.CheckLocations();
		de.zwibbltv.dreamland.utils.XPBar.CalculateXPLevel();
//		de.zwibbltv.dreamland.utils.BoatEverwoods.spawnBoat();
		updateScoreboard();
		giveMoney(eco);
		TimeFinder();
//		spawnBoat(w);

		if(dropGoldTimer == 5) {
			dropGoldTimer = 0;
			dropGold(w);
		}
		else {
			dropGoldTimer = dropGoldTimer + 1;		
		}
	}

	@SuppressWarnings("deprecation")
	private static void TimeFinder() {
		for(Player p : Bukkit.getOnlinePlayers()) {

			Calendar c = Calendar.getInstance();

			if(c.getTime().getHours() <= 4) {
				PlayerConfig.giveAchievement(p.getPlayer(), Achievements.DREAMLANDBYNIGHT);
			}
		}
	}

	private static void updateScoreboard() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			de.zwibbltv.dreamland.main.updateScoreboard.update(p);
		}
	}

	private static void giveMoney(Economy eco) {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(de.zwibbltv.dreamland.utils.AFK.isAFK.containsKey(p.getName())) {
				if(de.zwibbltv.dreamland.utils.AFK.isAFK.get(p.getName()).equals(false))
				{
					eco.depositPlayer(p, 0.01);
				}
			}
			else {
				de.zwibbltv.dreamland.utils.AFK.isAFK.put(p.getName(), false);
			}
		}
	}
	
	//GOLFBRUNNEN IN CALICO	
	private static void dropGold(World w) {
		Location loc = new Location(w, -852, 20, 770);

		ItemStack random = null;

		Random r = new Random();
		int zufall = r.nextInt(6);
		switch(zufall) {
		case 0:
			int zufall0 = r.nextInt(3);
			switch(zufall0) {
			case 0:
				random = new ItemStack(Material.GOLD_NUGGET);
				break;
			case 1:
				random = new ItemStack(Material.GOLD_NUGGET, 2);
				break;
			case 2:
				random = new ItemStack(Material.GOLD_NUGGET, 3);
				break;
			}
			break;
		case 1:
			int zufall1 = r.nextInt(3);
			switch(zufall1) {
			case 0:
				random = new ItemStack(Material.GOLD_NUGGET);
				break;
			case 1:
				random = new ItemStack(Material.GOLD_NUGGET, 2);
				break;
			case 2:
				random = new ItemStack(Material.GOLD_NUGGET, 3);
				break;
			}
			break;
		case 2:
			int zufall2 = r.nextInt(3);
			switch(zufall2) {
			case 0:
				random = new ItemStack(Material.GOLD_NUGGET);
				break;
			case 1:
				random = new ItemStack(Material.GOLD_NUGGET, 2);
				break;
			case 2:
				random = new ItemStack(Material.GOLD_NUGGET, 3);
				break;
			}
			break;
		case 3:
			int zufall3 = r.nextInt(3);
			switch(zufall3) {
			case 0:
				random = new ItemStack(Material.GOLD_INGOT);
				break;
			case 1:
				random = new ItemStack(Material.GOLD_INGOT, 2);
				break;
			case 2:
				random = new ItemStack(Material.GOLD_INGOT, 3);
				break;
			}
			break;
		case 4:
			int zufall4 = r.nextInt(3);
			switch(zufall4) {
			case 0:
				random = new ItemStack(Material.GOLD_INGOT);
				break;
			case 1:
				random = new ItemStack(Material.GOLD_INGOT, 2);
				break;
			case 2:
				random = new ItemStack(Material.GOLD_INGOT, 3);
				break;
			}
			break;
		case 5:
			random = new ItemStack(Material.GOLD_BLOCK);		    					    		
			break;

		}


		loc.getWorld().dropItemNaturally(loc, random);
	}
}