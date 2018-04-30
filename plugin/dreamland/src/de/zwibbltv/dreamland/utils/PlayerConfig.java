package de.zwibbltv.dreamland.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

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
		
	public static boolean hasAchivement(Player p, Achievements achievement) {
		if (PlayerConfig.get(p.getName() + ".achivements." + achievement.getName()) != null)
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("deprecation")
	public static void giveAchievement(Player p, Achievements achievement) {
		if(!hasAchivement(p, achievement)) {
			PlayerConfig.set(p.getName() + ".Achivements." + achievement.getName(), true);
			p.sendMessage("§aYou've got the achievement §6" + achievement.getName() + "§a!");
			p.sendMessage("§a-> §6" + achievement.getText());
			Main.economy.depositPlayer(p.getName(), achievement.getMoney());
			p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
			try {
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
