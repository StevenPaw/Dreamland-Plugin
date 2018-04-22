package de.zwibbltv.dreamland.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import de.zwibbltv.dreamland.commands.CMDbuild;
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
        
        if(CMDbuild.buildallowed.contains(p) == false) {
        	if(PermissionsEx.getUser(p).inGroup("Owner")) {
        		Score rank = obj.getScore("§2Owner");
        		rank.setScore(0);
        	}
        	else if(PermissionsEx.getUser(p).inGroup("Admin")) {
        		Score rank = obj.getScore("§9Admin");
        		rank.setScore(0);
        	} 
        	else if(PermissionsEx.getUser(p).inGroup("Builder")) {
            	Score rank = obj.getScore("§5Builder");
            	rank.setScore(0);
            }
        	else if(PermissionsEx.getUser(p).inGroup("VIP")) {
            	Score rank = obj.getScore("§eVIP");
            	rank.setScore(0);
            }
        	else if(PermissionsEx.getUser(p).inGroup("Member")) {
        		Score rank = obj.getScore("§3Member");
        		rank.setScore(0);
        	}
        	else if(PermissionsEx.getUser(p).inGroup("Guest")) {
        		Score rank = obj.getScore("§7Guest");
        		rank.setScore(0);
        	}
        	               	
        	
        } else if (CMDbuild.buildallowed.contains(p) == true) {
        	Score rank = obj.getScore("§4BUILDER");
    		rank.setScore(0);
        }

        Score eight = obj.getScore(" ");
        Score seven = obj.getScore("§aMoney:");
        Score six = obj.getScore("§b" + money);
        Score five = obj.getScore("  ");
        Score four = obj.getScore("§aOnline:");
        Score three = obj.getScore("§b" + player);
        Score two = obj.getScore(" ");
        Score one = obj.getScore("§aRank:");

        eight.setScore(8);
        seven.setScore(7);
        six.setScore(6);
        five.setScore(5);
        four.setScore(4);
        three.setScore(3);
        two.setScore(2);
        one.setScore(1);

       p.setScoreboard(board);
		
	}
	
}
