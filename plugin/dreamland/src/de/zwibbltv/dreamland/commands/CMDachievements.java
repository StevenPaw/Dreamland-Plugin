package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import de.zwibbltv.dreamland.utils.Achievements;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import net.md_5.bungee.api.ChatColor;

public class CMDachievements implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("ach")) {			
			Player p = (Player) sender;
			if (args.length == 3) {
			if (sender instanceof Player) {	
				if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.ach")) {
					
					Player target = Bukkit.getPlayer(args[1]);
					
					if(args[0].equalsIgnoreCase("give")) {
						if (target != null) {
//							PlayerConfig.set(target.getName() + ".achivements." + Achievements.getName(args[2]), true);
							try{
								PlayerConfig.giveAchievement(target.getPlayer(), Achievements.valueOf(args[2]));
							}catch (IllegalArgumentException error) {
								p.sendMessage("§c That Achievement couldn't be added. Is it spelled correct?");
							}
						}						
					}
					
					if(args[0].equalsIgnoreCase("take")) {
						if (target != null) {	
							
							
							
						}
					}					
					
					} else
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
				}
			} else {
				p.sendMessage("§c Please use: §5/ach <give/take> <name> <ach>");
			}
		}
		
		return false;
	}

}
