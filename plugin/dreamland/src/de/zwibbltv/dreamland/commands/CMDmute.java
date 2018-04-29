package de.zwibbltv.dreamland.commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.zwibbltv.dreamland.main.Main;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import net.md_5.bungee.api.ChatColor;

public class CMDmute implements CommandExecutor, Listener{
	
		
	@EventHandler
	public void handlePlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(PlayerConfig.getMute(p) == true) {
			p.sendMessage("§cYou can't write: §4§nYou are muted");
					e.setCancelled(true);
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.mute") || p.hasPermission("Dreamland.*")) {
				if(args.length == 1) {
					
					Player target = Bukkit.getPlayer(args[0]);
					
					
					if(target != null) {
						if(target != p) {							
					
						if(PlayerConfig.getMute(target) == false) {
							
							try {
								PlayerConfig.setMute(target, true);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							p.sendMessage("§aYou muted §c" + target.getName() + " §a!");
							target.sendMessage("§cYou are now muted! §7(By: §6" + p.getName() + "§7)");
							
						} else {
							
							try {
								PlayerConfig.setMute(target, false);
							} catch (IOException e) {
								e.printStackTrace();
							}
							target.sendMessage("§aYou are no longer muted! §7(By: §6" + p.getName() + "§7)");
							p.sendMessage("§aYou unmuted §c" + target.getName() + " §a!");
							
							}
						} else {
							p.sendMessage("§cYou can't mute yourself!");
						}
					}
					
				} else
					p.sendMessage("§cPlease use /mute <Player>");
				
			} else
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
		} 
		
		return false;
	}

}
