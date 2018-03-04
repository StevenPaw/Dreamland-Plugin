package de.zwibbltv.dreamland.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import net.milkbowl.vault.economy.Economy;

public class scoreboardListener implements Listener {

    Scoreboard board;
    int player;
    double money;
    Economy eco;
          

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            defineScoreboard(p, 0);
        }
    }

    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent e) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            defineScoreboard(p, -1);
        }
     }
    

    public void defineScoreboard(Player p, int playerCalc) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("§6Dreamland");

        if(eco != null ) {
            money = eco.getBalance(p);
        	
        }
        player = Bukkit.getServer().getOnlinePlayers().size() + playerCalc;
        int rank = 0;

        Score eight = obj.getScore(" ");
        Score seven = obj.getScore("§aMoney:");
        Score six = obj.getScore("§b" + money + " §6dlm");
        Score five = obj.getScore("  ");
        Score four = obj.getScore("§aOnline:");
        Score three = obj.getScore("§b" + player);
        Score two = obj.getScore(" ");
        Score one = obj.getScore("§aRank:");
        Score zero = obj.getScore("§b" + rank);

        eight.setScore(8);
        seven.setScore(7);
        six.setScore(6);
        five.setScore(5);
        four.setScore(4);
        three.setScore(3);
        two.setScore(2);
        one.setScore(1);
        zero.setScore(0);

       p.setScoreboard(board);
    }

    }