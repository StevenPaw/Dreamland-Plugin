package de.zwibbltv.dreamland.shows;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class LateNightShow {

	public static ArrayList<Player> LateNightPlayer = new ArrayList<Player>();

	public static void StartShow() {
		for (Player p : Bukkit.getOnlinePlayers())
		{
			Location ploc = p.getLocation();
			Double d = ploc.distance(new Location(Bukkit.getWorld("dreamland"),-453,21,634));
			if(d <= 40) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "jukebox show add " + p.getName() + " @LateNightShow");
				LateNightPlayer.add(p);
			}
		}
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "jukebox music @LateNightShow https://www.dropbox.com/s/ftnf9nue7gg85jk/AJR%20-%20Weak.mp3?dl=1");
		de.zwibbltv.dreamland.shows.ShowController.LateNightShowRuns = true;
		Bukkit.broadcastMessage("BETA: Show \"LateNightShow\" starts now");
	}

	public static void TestForNewPlayers() {
		for (Player p : Bukkit.getOnlinePlayers())
		{
			Location ploc = p.getLocation();
			Double d = ploc.distance(new Location(Bukkit.getWorld("dreamland"),-453,21,634));
			Boolean isnew = true;
			if(d <= 60) {
				for(int i = 0; i < LateNightPlayer.size(); i++) {
					if (LateNightPlayer.get(i) == p) {
						isnew = false;
					}
				}
			} else {
				for(int i = 0; i < LateNightPlayer.size(); i++) {
					if (LateNightPlayer.get(i) == p) {
						isnew = false;
						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "jukebox show remove " + p.getName() + " @LateNightShow");
					}
				}

			}
			if (isnew == true) {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "jukebox show add " + p.getName() + " @LateNightShow");
				LateNightPlayer.add(p);
			}
		}
	}

	public static void runShow(Integer time) {
		TestForNewPlayers();
		Player p = Bukkit.getPlayer("StevenPaw");
		p.sendMessage("Time: " + time);
		if(time == 10) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
			Redstone(-418,20,654,false);
			Redstone(-416,26,669,false);
		} else if (time == 39) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 47) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 54) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 62) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 63) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 64) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 65) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 66) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 67) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 68) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 69) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 70) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 71) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 72) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,true);
		} else if (time == 73) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 74) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 75) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 76) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 77) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 78) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 79) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 80) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 81) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
			Firework(-478,30,674, 3, 2, 16, 6, true, true);
		} else if (time == 83) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
			Firework(-483,27,655, 3, 2, 16, 6, true, true);
		} else if (time == 85) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
			Firework(-478,25,662, 3, 2, 16, 6, true, true);
		} else if (time == 97) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 105) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 112) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 113) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 115) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 116) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,false);
		} else if (time == 117) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,true);
		} else if (time == 118) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,true);
		} else if (time == 119) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,true);
		} else if (time == 120) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 128) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Firework(-478,30,674, 2, 3, 16, 6, true,true);
			Firework(-478,30,674, 2, 2, 16, 6, true, true);
			Firework(-478,30,674, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,true);
		} else if (time == 129) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		} else if (time == 140) {
			Firework(-483,27,655, 2, 3, 16, 6, true,true);
			Firework(-483,27,655, 2, 2, 16, 6, true, true);
			Firework(-483,27,655, 1, 3, 16, 6, true, true);
			Firework(-478,26,662, 2, 3, 16, 6, true,true);
			Firework(-478,26,662, 2, 2, 16, 6, true, true);
			Firework(-478,26,662, 1, 3, 16, 6, true, true);
			Firework(-478,30,674, 2, 3, 16, 6, true,true);
			Firework(-478,30,674, 2, 2, 16, 6, true, true);
			Firework(-478,30,674, 1, 3, 16, 6, true, true);
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,true);
		} else if (time == 141) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
		}  else if (time == 143) {
			Firework(-473,29,680, 2, 3, 16, 6, true, true);
		}  else if (time == 145) {
			Firework(-478,30,674, 2, 3, 16, 6, true, true);
		}  else if (time == 147) {
			Firework(-486,33,664, 2, 3, 16, 6, true, true);
		}  else if (time == 149) {
			Firework(-491,33,656, 2, 3, 16, 6, true, true);
		}  else if (time == 151) {
			Firework(-499,31,644, 2, 3, 16, 6, true, true);
		}  else if (time == 153) {
			Firework(-493,31,635, 2, 3, 16, 6, true, true);
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,true);
		} else if (time == 158) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
			Firework(-473,29,680, 2, 3, 16, 6, true, true);
			Firework(-473,29,680, 2, 2, 16, 6, true, true);
			Firework(-473,29,680, 2, 1, 16, 6, true, true);
			Firework(-493,31,635, 2, 3, 16, 6, true, true);
			Firework(-493,31,635, 2, 2, 16, 6, true, true);
			Firework(-493,31,635, 2, 1, 16, 6, true, true);
		} else if (time == 166) {
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,true);
			Firework(-478,30,674, 2, 3, 16, 6, true, true);
			Firework(-478,30,674, 2, 2, 16, 6, true, true);
			Firework(-478,30,674, 2, 1, 16, 6, true, true);
			Firework(-499,31,644, 2, 3, 16, 6, true, true);
			Firework(-499,31,644, 2, 2, 16, 6, true, true);
			Firework(-499,31,644, 2, 1, 16, 6, true, true);
		}  else if (time == 170) {
			Firework(-483,27,655, 2, 3, 16, 6, true, true);
		}  else if (time == 175) {
			Light(-467,20,670,1,false);
			Light(-464,26,680,1,false);
			Light(-455,29,688,1,false);
			Light(-483,21,655,1,false);
			Light(-488,25,635,1,false);
			Firework(-486,33,664, 2, 3, 16, 6, true, true);
			Firework(-486,33,664, 2, 2, 16, 6, true, true);
			Firework(-486,33,664, 2, 1, 16, 6, true, true);
			Firework(-491,33,656, 2, 3, 16, 6, true, true);
			Firework(-491,33,656, 2, 2, 16, 6, true, true);
			Firework(-491,33,656, 2, 1, 16, 6, true, true);
		} else if (time == 180) {
			Firework(-486,33,664, 2, 3, 16, 6, true, true);
			Firework(-486,33,664, 2, 2, 16, 6, true, true);
			Firework(-486,33,664, 2, 1, 16, 6, true, true);
			Firework(-491,33,656, 2, 3, 16, 6, true, true);
			Firework(-491,33,656, 2, 2, 16, 6, true, true);
			Firework(-491,33,656, 2, 1, 16, 6, true, true);
			Firework(-478,30,674, 2, 3, 16, 6, true, true);
			Firework(-478,30,674, 2, 2, 16, 6, true, true);
			Firework(-478,30,674, 2, 1, 16, 6, true, true);
			Firework(-499,31,644, 2, 3, 16, 6, true, true);
			Firework(-499,31,644, 2, 2, 16, 6, true, true);
			Firework(-499,31,644, 2, 1, 16, 6, true, true);
			Firework(-483,27,655, 2, 3, 16, 6, true, true);
			Firework(-473,29,680, 2, 3, 16, 6, true, true);
			Firework(-473,29,680, 2, 2, 16, 6, true, true);
			Firework(-473,29,680, 2, 1, 16, 6, true, true);
			Firework(-493,31,635, 2, 3, 16, 6, true, true);
			Firework(-493,31,635, 2, 2, 16, 6, true, true);
			Firework(-493,31,635, 2, 1, 16, 6, true, true);
		} else if (time == 192) {
			Bukkit.broadcastMessage("Show \\\"LateNightShow\\\" is now finished");
			ShowController.LateNightShowRuns = false;
			ShowController.LateNightShowTime = 0;
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "jukebox stop @LateNightShow");
			Light(-467,20,670,1,true);
			Light(-464,26,680,1,true);
			Light(-455,29,688,1,true);
			Light(-483,21,655,1,true);
			Light(-488,25,635,1,true);
			Redstone(-418,20,654,true);
			Redstone(-416,26,669,true);
		}

	}

	private static void Firework(Integer X, Integer Y, Integer Z, int Art, int Height, int Color1, int Color2, Boolean Trail, Boolean Flicker) {
		Location location = new Location(Bukkit.getWorld("dreamland"),X,Y,Z);
		Firework fw = (Firework) Bukkit.getWorld("dreamland").spawnEntity(location, EntityType.FIREWORK);
		FireworkMeta fwm = fw.getFireworkMeta();
		Type type = Type.BALL;
		if (Art == 1) type = Type.BALL;
		if (Art == 2) type = Type.BALL_LARGE;
		if (Art == 3) type = Type.BURST;
		if (Art == 4) type = Type.CREEPER;
		if (Art == 5) type = Type.STAR;
		Color c1 = getColor(Color1);
		Color c2 = getColor(Color2);
		FireworkEffect effect = FireworkEffect.builder().flicker(Flicker).withColor(c1).withFade(c2).with(type).trail(Trail).build();
		fwm.addEffect(effect);
		fwm.setPower(Height);
		fw.setFireworkMeta(fwm);
	}

	private static void Light(Integer X, Integer Y, Integer Z, Integer Type, Boolean On) {
		Location location = new Location(Bukkit.getWorld("dreamland"),X,Y,Z);
		if (On) {
			if (Type == 1) {
				Bukkit.getWorld("dreamland").getBlockAt(location).setType(Material.GLOWSTONE);
			} else if (Type == 2) {
				Bukkit.getWorld("dreamland").getBlockAt(location).setType(Material.TORCH);
			}
		} else {
			Bukkit.getWorld("dreamland").getBlockAt(location).setType(Material.REDSTONE_LAMP_OFF);
		}
	}

	private static void Redstone(Integer X, Integer Y, Integer Z, Boolean On) {
		Location location = new Location(Bukkit.getWorld("dreamland"),X,Y,Z);
		if (On) {
			Bukkit.getWorld("dreamland").getBlockAt(location).setType(Material.REDSTONE_BLOCK);
		} else {
			Bukkit.getWorld("dreamland").getBlockAt(location).setType(Material.RED_GLAZED_TERRACOTTA);
		}
	}

	private static Color getColor(int i) {
		Color c = null;
		if(i==1){
			c=Color.AQUA;
		}
		if(i==2){
			c=Color.BLACK;
		}
		if(i==3){
			c=Color.BLUE;
		}
		if(i==4){
			c=Color.FUCHSIA;
		}
		if(i==5){
			c=Color.GRAY;
		}
		if(i==6){
			c=Color.GREEN;
		}
		if(i==7){
			c=Color.LIME;
		}
		if(i==8){
			c=Color.MAROON;
		}
		if(i==9){
			c=Color.NAVY;
		}
		if(i==10){
			c=Color.OLIVE;
		}
		if(i==11){
			c=Color.ORANGE;
		}
		if(i==12){
			c=Color.PURPLE;
		}
		if(i==13){
			c=Color.RED;
		}
		if(i==14){
			c=Color.SILVER;
		}
		if(i==15){
			c=Color.TEAL;
		}
		if(i==16){
			c=Color.WHITE;
		}
		if(i==17){
			c=Color.YELLOW;
		}

		return c;
	}


}
