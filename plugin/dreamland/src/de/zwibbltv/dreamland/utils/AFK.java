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
	public static Integer AFKTimer = 300; //SETS THE TIME BEFORE A PLAYER GETS AFK


	public static void CheckLocations()
	{
		for(Player p : Bukkit.getOnlinePlayers()){
			if(locations.containsKey(p.getName())){
				if(locations.get(p.getName()).equals(p.getLocation())) {
					//WENN DIE LOCATION GLEICH IST		
					if (standTime.containsKey(p.getName())) {
						if(isAFK.containsKey(p.getName())) {
							if(isAFK.get(p.getName()).equals(false)) {
								if(standTime.get(p.getName()) == AFKTimer)
								{
									//Wird ausgeführt nach AFKTimer sekunden
									isAFK.put(p.getName(), true);
									AFKTitle(p);
								}
								else
								{
									Integer old = standTime.get(p.getName());
									standTime.put(p.getName(), old + 1);
								}
							}
						}
						else {
							isAFK.put(p.getName(), false);
						}
					}
					else {
						standTime.put(p.getName(), 0);
					}

				}else{
					//WENN DIE LOCATION ANDERS IST
					locations.put(p.getName(), p.getLocation());
					standTime.put(p.getName(), 0);
					if(isAFK.get(p.getName()).equals(true)) {
						DEAFKTitle(p);
					}
					isAFK.put(p.getName(), false);
				}
			}else{
				locations.put(p.getName(), p.getLocation());
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
		SubTitles.add("Or was the themepark bored?");
		Titles.add("1,2,3,4");
		SubTitles.add("You are on a tour");
		Titles.add("Don't go away!");
		SubTitles.add("There is a lot more to explore...");
		
		TitleID = r.nextInt(Titles.size());
		

		de.zwibbltv.dreamland.listener.JoinListener.sendTitle(player, Titles.get(TitleID), SubTitles.get(TitleID), 2, 99999, 10);
	}

	public static void DEAFKTitle(Player player) {
		de.zwibbltv.dreamland.listener.JoinListener.sendTitle(player, "There you are!", "Welcome back!", 2, 40, 2);
	}
}
