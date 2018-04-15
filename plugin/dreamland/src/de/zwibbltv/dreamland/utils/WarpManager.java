package de.zwibbltv.dreamland.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class WarpManager {

	public File f = new File(Main.getInstance().getDataFolder(), "warps.yml");
	public FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	private void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createWarp(Player p, String warpName) {
		Location playerLoc = p.getLocation();
		if(!(isWarpExists(warpName))) {
			cfg.set(warpName, playerLoc);
			save();
			p.sendMessage("§aThe warp §6" + warpName + "§a has been created");
		} else
			p.sendMessage("§cThe warp §6" + warpName + "§c already exist!");
		
	}
	public void removeWarp(String warpName) {
		cfg.set(warpName, null);
		save();
	}
	
	public boolean isWarpExists(String warpName) {
		return cfg.contains(warpName);
	}
	
	public Location getWarpLocation(String warpName) {
		return (Location) cfg.get(warpName);
	}
	
	public void teleportToWarp(Player p, String warpName) {
		p.teleport(getWarpLocation(warpName));
	}
	
}
