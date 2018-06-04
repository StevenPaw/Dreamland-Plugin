package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDlift implements CommandExecutor{
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			boolean up = false;
			int height = 0;
			if(p.hasPermission("dreamland.firework") || p.hasPermission("Dreamland.*")) {
				if(args.length == 3) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target instanceof Player) {
						if(args[1] == "up") {
							up = true;
						} else if (args[1] == "down") {
							up = false;
						}else {
							p.sendMessage("Please use /lift <player> <up/down> <height>");
						}
						height = Integer.parseInt(args[2]);
						if(height >= 1 && height <= 100) {
							if(up) {
								for(int i = 0; i<=height; i+= 1)
								{
									target.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 1, p.getLocation().getZ()));
								}
							}
							if(!up) {
								for(int i = 0; i<=height; i++)
								{
									target.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() - 1, p.getLocation().getZ()));
								}
							}
						}
					}
					else
						p.sendMessage("nope! thats no player");
				}
			}
			p.sendMessage("Please use /lift <player> <up/down> <height>");
		}
		return false;
	}
}
	
