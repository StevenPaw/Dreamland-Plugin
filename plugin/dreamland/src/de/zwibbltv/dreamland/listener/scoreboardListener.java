package de.zwibbltv.dreamland.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;

import net.milkbowl.vault.economy.Economy;

public class scoreboardListener implements Listener {

    Scoreboard board;
    int player;
    double money;
    Economy eco = de.zwibbltv.dreamland.main.Main.economy;
          

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        for(Player p : Bukkit.getOnlinePlayers()) {
        	de.zwibbltv.dreamland.main.updateScoreboard.update(p);
        	de.zwibbltv.dreamland.utils.Tablist.setScoreboard();
        }
    }

    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent e) {
        for(Player p : Bukkit.getOnlinePlayers()) {
        	de.zwibbltv.dreamland.main.updateScoreboard.update(p);
        }
     }      
}
          