package de.zwibbltv.dreamland.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("§6>> §a" + p.getName() + " §6>>");
		p.sendMessage("§aWelcome to the Dreamland Themepark Server!");
		p.sendTitle("§6Welcome to Dreamland!", "§eHave a lot of fun!");
		p.setGameMode(GameMode.ADVENTURE);
		p.sendMessage("Sending Resourcepack");
		p.setResourcePack("https://www.dropbox.com/s/n069utc6ixux4iw/Dreamland17-04.zip?dl=1");
		p.sendMessage("Resourcepack loaded woohoo!");
		if(!p.hasPermission("dreamland.*") || !p.hasPermission("dreamland.join")) {
			p.performCommand("warp Spawn");
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§7<< §4" + p.getName() + " §7<<");	
		
	}
	
	@EventHandler
	public void onPlayerFirstJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore()) {
			p.performCommand("warp Spawn");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("§aPlease Welcome all §6" + p.getName() + "§a! Enjoy your visit at §6Dreamland Themepark§a!");
			Bukkit.broadcastMessage("");
		}
	}
	
}
