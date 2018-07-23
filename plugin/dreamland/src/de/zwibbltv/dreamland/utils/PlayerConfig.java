package de.zwibbltv.dreamland.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
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
	
	public static void setAFK(Player p, Boolean muted) throws IOException{
		PlayerConfig.set(p.getName()+ ".AFK", muted);
		save();
	}
	public static Boolean getAFK(Player p) {
		return PlayerConfig.getBoolean(p.getName()+ ".AFK");
	}	
	
	public static void setBuilder(Player p, Boolean builder) throws IOException{
		PlayerConfig.set(p.getName()+ ".builder", builder);
		save();
	}	
	public static Boolean getBuilder(Player p) {
		return PlayerConfig.getBoolean(p.getName()+ ".builder");
	}
	
	//Hotel---
	public static void setInHotel(Player p, Integer inHotel) throws IOException{
		PlayerConfig.set(p.getName()+ ".inhotel", inHotel);
		save();
	}	
	public static Integer getInHotel(Player p) {
		return PlayerConfig.getInt(p.getName()+ ".inhotel");
	}
	
	public static void setRentedHotel(Player p, Integer inHotel) throws IOException{
		PlayerConfig.set(p.getName()+ ".rentedhotel", inHotel);
		save();
	}	
	public static Integer getRentedHotel(Player p) {
		return PlayerConfig.getInt(p.getName()+ ".rentedhotel");
	}
	
	//Resourcepack---
	public static void Resourcepackactive(Player p, Boolean active) throws IOException{
		PlayerConfig.set(p.getName()+ ".resourcepack", active);
		save();
	}	
	public static Boolean getResourcepack(Player p) {
		return PlayerConfig.getBoolean(p.getName()+ ".resourcepack");
	}
	
	//Current Inventory
	public static void CurrentInventory(Player p, String curInv) throws IOException{
		PlayerConfig.set(p.getName()+ ".curInv", curInv);
		save();
	}	
	public static String getCurrentInventory(Player p) {
		return PlayerConfig.getString(p.getName()+ ".curInv");
	}
	public static void setCurrentInventory(Player p, String curInv) throws IOException{
		PlayerConfig.set(p.getName()+ ".curInv", curInv);
		save();
	}	
	
	//Runtime
	public static void Runtime(Player p, int time) throws IOException{
		PlayerConfig.set(p.getName()+ ".runtime", time);
		save();
	}	
	public static int getRuntime(Player p) {
		return PlayerConfig.getInt(p.getName()+ ".runtime");
	}
	
	//Achievements---
	public static boolean hasAchivement(Player p, Achievements achievement) {
		if (PlayerConfig.get(p.getName() + ".achivements." + achievement.getName()) != null )
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("deprecation")
	public static void giveAchievement(Player p, Achievements achievement) {
		if(!hasAchivement(p, achievement)) {
			PlayerConfig.set(p.getName() + ".achivements." + achievement.getName(), true);
			p.sendMessage("");
			p.sendMessage("§a--------{§6"+achievement.getName()+"§a}--------");
			p.sendMessage("");
			p.sendMessage("§aYou've got the achievement §6" + achievement.getName() + "§a!");
			p.sendMessage("§a-> §6" + achievement.getText());
			p.sendMessage("");
			p.sendMessage("§a--------{§6"+achievement.getName()+"§a}--------");
			p.sendMessage("");
			Main.economy.depositPlayer(p.getName(), achievement.getMoney());
			p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
			
			 Location location = p.getLocation();
			 for (double i = 0; i <= Math.PI; i += Math.PI / 10) {
				   double radius = Math.sin(i);
				   double y = Math.cos(i);
				   for (double a = 0; a < Math.PI * 2; a+= Math.PI / 10) {
				      double x = Math.cos(a) * radius;
				      double z = Math.sin(a) * radius;
				      location.add(x, y +1, z);
		            location.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, location, 1);
		            location.subtract(x,y +1,z);
		        }	
			 }
					
			try {
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
		
	public static void takeAchievement(Player p, Achievements achievement) {
		if(hasAchivement(p, achievement)) {
			PlayerConfig.set(p.getName() + ".achivements." + achievement.getName(), null);
			p.sendMessage("§aYou lost the achievement §6" + achievement.getName() + "§a!");
			try {
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public static void giveItemInv(Player p, Shop shop) {
		if(!hasItemInv(p, shop)) {
			PlayerConfig.set(p.getName() + ".inventory." + shop.getName(), true);
		}		
	}
	
	public static boolean hasItemInv(Player p, Shop shop) {
		if (PlayerConfig.get(p.getName() + ".inventory." + shop.getName()) != null )
			return true;
		else
			return false;
	}
}

