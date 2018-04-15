package de.zwibbltv.dreamland.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class PlayerLocationLockedManager {
	
	private File f = new File(Main.getInstance().getDataFolder(), "ploc.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	private void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createploc(Player p, String plocName) {
		Location playerLoc = p.getLocation();
		if(!(isplocExists(plocName))) {
			cfg.set(plocName, playerLoc);
			save();
			p.sendMessage("§aThe ploc §6" + plocName + "§a has been created");
		} else
			p.sendMessage("§cThe ploc §6" + plocName + "§c already exist!");
		
	}
	public void removeploc(String plocName) {
		cfg.set(plocName, null);
		save();
	}
	
	public boolean isplocExists(String plocName) {
		return cfg.contains(plocName);
	}
	
	public Location getplocLocation(String plocName) {
		return (Location) cfg.get(plocName);
	}
	
}
