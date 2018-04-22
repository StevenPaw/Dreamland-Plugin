package de.zwibbltv.dreamland.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Tablist {
	
	private static Scoreboard sb;
	
	public static void setScoreboard() {
		
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		
		sb.registerNewTeam("000Owner");
		sb.registerNewTeam("001Admin");
		sb.registerNewTeam("002Builder");
		sb.registerNewTeam("003VIP");
		sb.registerNewTeam("004Member");
		sb.registerNewTeam("005Guest");
		
		sb.getTeam("000Owner").setPrefix("§2Owner §6|§r ");
		sb.getTeam("001Admin").setPrefix("§9Admin §6|§r ");
		sb.getTeam("002Builder").setPrefix("§5Builder §6|§r ");
		sb.getTeam("003VIP").setPrefix("§eVIP§6 |§r ");
		sb.getTeam("004Member").setPrefix("§3Member§6 |§r ");
		sb.getTeam("005Guest").setPrefix("§7Guest§6 |§7 ");
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			setTeams(all);
		}
		
	}

	@SuppressWarnings("deprecation")
	private static void setTeams(Player p) {

		String team = "";
		
		if(PermissionsEx.getUser(p).inGroup("Owner")) {
			team = "000Owner";
		}
		else if(PermissionsEx.getUser(p).inGroup("Admin")) {
			team = "001Admin";
		}
		else if(PermissionsEx.getUser(p).inGroup("Builder")) {
			team = "002Builder";
		}
		else if(PermissionsEx.getUser(p).inGroup("VIP")) {
			team = "003VIP";
		}
		else if(PermissionsEx.getUser(p).inGroup("Member")) {
			team = "004Member";
		}
		else if(PermissionsEx.getUser(p).inGroup("Guest")) {
			team = "005Guest";
		}
		sb.getTeam(team).addPlayer(p);
		p.setScoreboard(sb);
		
	}

}
