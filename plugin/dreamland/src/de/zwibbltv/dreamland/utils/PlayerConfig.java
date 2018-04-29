package de.zwibbltv.dreamland.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerConfig {
	
	public static File PlayerConfigFile = new File("plugins/Dreamland", "player.yml");
	public static FileConfiguration PlayerConfig = YamlConfiguration.loadConfiguration(PlayerConfigFile);
	
	public static void save() throws IOException {
		PlayerConfig.save(PlayerConfigFile);
	}

	
	public static void setMute(Player p, Boolean muted) throws IOException{
		PlayerConfig.set(p.getName()+ ".muted", muted);
		save();
	}
	public static Boolean getMute(Player p) {
		return PlayerConfig.getBoolean(p.getName()+ ".muted");
	}
	
	
	public static void setBuilder(Player p, Boolean builder) throws IOException{
		PlayerConfig.set(p.getName()+ ".builder", builder);
		save();
	}	
	public static Boolean getBuilder(Player p) {
		return PlayerConfig.getBoolean(p.getName()+ ".builder");
	}
	
}
