package de.zwibbltv.dreamland.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.zwibbltv.dreamland.utils.PlayerConfig;
import net.milkbowl.vault.economy.Economy;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class updateScoreboard {

	static Scoreboard board;
    static int player;
    static double money;
    static Economy eco = de.zwibbltv.dreamland.main.Main.economy;
    
    static Scoreboard sb;
    
    public static void update(Player p) {
				
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§6Dreamland");
        
        if(eco != null ) {
            money = (int)eco.getBalance(p);        	
        }
        player = Bukkit.getServer().getOnlinePlayers().size();
        
        Team Owner = board.registerNewTeam("Owner");
        Team Admin = board.registerNewTeam("Admin");
        Team Builder = board.registerNewTeam("Builder");
        Team VIP = board.registerNewTeam("VIP");
        Team Member = board.registerNewTeam("Member");
        Team Guest = board.registerNewTeam("Guest");
        
        Owner.setPrefix("§2Owner §6|§r ");
        Admin.setPrefix("§9Admin §6|§r ");
        Builder.setPrefix("§5Builder §6|§r ");
        VIP.setPrefix("§eVIP §6|§r ");
        Member.setPrefix("§3Member §6|§r ");
        Guest.setPrefix("§7Guest §6|§7 ");                     
                
        for (Player i : Bukkit.getOnlinePlayers()) {
        	if(PermissionsEx.getUser(i).inGroup("Owner")) {
            	board.getTeam("Owner").addEntry(i.getName());
            	}
            	else if(PermissionsEx.getUser(i).inGroup("Admin")) {
            		board.getTeam("Admin").addEntry(i.getName());
            	} 
            	else if(PermissionsEx.getUser(i).inGroup("Builder")) {
            		board.getTeam("Builder").addEntry(i.getName());
                }
            	else if(PermissionsEx.getUser(i).inGroup("VIP")) {
            		board.getTeam("VIP").addEntry(i.getName());
                }
            	else if(PermissionsEx.getUser(i).inGroup("Member")) {
            		board.getTeam("Member").addEntry(i.getName());
            	}
            	else if(PermissionsEx.getUser(i).inGroup("Guest")) {
            		board.getTeam("Guest").addEntry(i.getName());
            	}
        }
        	
        if(PermissionsEx.getUser(p).inGroup("Owner")) {
        		obj.getScore("§2Owner").setScore(0);
        	}
        	else if(PermissionsEx.getUser(p).inGroup("Admin")) {
        		obj.getScore("§9Admin").setScore(0);
        	} 
        	else if(PermissionsEx.getUser(p).inGroup("Builder")) {
            	obj.getScore("§5Builder").setScore(0);
            }
        	else if(PermissionsEx.getUser(p).inGroup("VIP")) {
            	obj.getScore("§eVIP").setScore(0);
            }
        	else if(PermissionsEx.getUser(p).inGroup("Member")) {
        		obj.getScore("§3Member").setScore(0);
        	}
        	else if(PermissionsEx.getUser(p).inGroup("Guest")) {
        		obj.getScore("§7Guest").setScore(0);
        	}
        	               	        	
        if (PlayerConfig.getBuilder(p) == true) {
        	obj.getScore("§6>>§4BUILDMODE§6<<").setScore(-1);
        }

        obj.getScore(" ").setScore(8);
        obj.getScore("§aMoney:").setScore(7);
        obj.getScore("§b" + money).setScore(6);
        obj.getScore("  ").setScore(5);
        obj.getScore("§aOnline:").setScore(4);
        obj.getScore("§b" + player).setScore(3);
        obj.getScore(" ").setScore(2);
        obj.getScore("§aRank:").setScore(1);
        
       p.setScoreboard(board);
		
	}
	
}
