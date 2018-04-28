package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import net.md_5.bungee.api.ChatColor;

public class CMDaudio implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.audio") || p.hasPermission("Dreamland.*")) {
				if(args.length == 0) {
					
					p.performCommand("jukebox");
					
				} else
					p.sendMessage("§cPlease use /audio");
				
			} else
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
		} 
		
		return false;
	}

}
