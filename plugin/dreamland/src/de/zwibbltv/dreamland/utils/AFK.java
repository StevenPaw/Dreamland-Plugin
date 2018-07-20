package de.zwibbltv.dreamland.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class AFK {
	public static Map<String, Location> locations = new HashMap<String, Location>();
	public static Map<String, Integer> standTime = new HashMap<String, Integer>();
	public static Map<String, Boolean> isAFK = new HashMap<String, Boolean>();
	public static Integer AFKTimer = 120; //SETS THE TIME BEFORE A PLAYER GETS AFK


	public static void CheckLocations()
	{
		for(Player player : Bukkit.getOnlinePlayers()){
			if(locations.containsKey(player.getName())){
				if(locations.get(player.getName()).equals(player.getLocation())) {
					//WENN DIE LOCATION GLEICH IST		
					if (standTime.containsKey(player.getName())) {
						if(isAFK.containsKey(player.getName())) {
							if(isAFK.get(player.getName()).equals(false)) {
								if(standTime.get(player.getName()) == AFKTimer)
								{
									//Wird ausgeführt nach AFKTimer sekunden
									isAFK.put(player.getName(), true);
									AFKTitle(player);
								}
								else
								{
									Integer old = standTime.get(player.getName());
									standTime.put(player.getName(), old + 1);
								}
							}
						}
						else {
							isAFK.put(player.getName(), false);
						}
					}
					else {
						standTime.put(player.getName(), 0);
					}

				}else{
					//WENN DIE LOCATION ANDERS IST
					locations.put(player.getName(), player.getLocation());
					standTime.put(player.getName(), 0);
					if(isAFK.get(player.getName()).equals(true)) {
						DEAFKTitle(player);
					}
					isAFK.put(player.getName(), false);
				}
			}else{
				locations.put(player.getName(), player.getLocation());
			}
		}
	}

	public static void AFKTitle(Player player) {
		
		Random r = new Random();
		Integer TitleID = 0;
		List<String> Titles = new ArrayList<String>();
		List<String> SubTitles = new ArrayList<String>();
		
		Titles.add("Where are you?");
		SubTitles.add("hm...");
		Titles.add("We're missing you...");
		SubTitles.add("Please come back...");
		Titles.add("Chirp Chirp");
		SubTitles.add("The sound of your movements");
		Titles.add("The Sound of Silence");
		SubTitles.add("Pretty quiet");
		Titles.add("Eating Donuts?");
		SubTitles.add("Is it better than playing?");
		Titles.add("Need a break?");
		SubTitles.add("We understand this");
		Titles.add("So lonely here...");
		SubTitles.add("it gets pretty boring");
		Titles.add("Need a drink?");
		SubTitles.add("Or maybe food?");
		Titles.add("Someones missing");
		SubTitles.add("is it you?");
		Titles.add("Are you bored?");
		SubTitles.add("Or was the themepark boring?");
		Titles.add("1,2,3,4");
		SubTitles.add("You are on a tour");
		
		TitleID = r.nextInt(Titles.size());
		

		de.zwibbltv.dreamland.listener.JoinListener.sendTitle(player, Titles.get(TitleID), SubTitles.get(TitleID), 2, 99999, 10);
	}

	public static void DEAFKTitle(Player player) {
		de.zwibbltv.dreamland.listener.JoinListener.sendTitle(player, "There you are!", "Welcome back!", 2, 40, 2);
	}
}
