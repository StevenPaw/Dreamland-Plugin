package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDrank implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.*") || p.hasPermission("dreamland.rank")) {
				
				if(args.length == 2) {
					
					Player target = Bukkit.getPlayer(args[0]);					
						if (target != null) {
								
							p.performCommand("pex user " + target.getName() + " group set " + args[1]);
							
						}												
									
				} else {
					p.sendMessage("§cUse: /rank <Name> <rank>");
				}
				
			} else {
				p.sendMessage(Main.getNoPerms());
			}		
		}
		return false;
	}
}
