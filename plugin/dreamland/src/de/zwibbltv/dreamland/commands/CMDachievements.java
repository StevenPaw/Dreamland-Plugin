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
			if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 3) {
			if (sender instanceof Player) {	
				if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.ach")) {
					
					Player target = Bukkit.getPlayer(args[1]);
					
					if(args[0].equalsIgnoreCase("give")) {
						p.sendMessage("§aYou gave §6" + target.getName() + " §a the achievement §6" + Achievements.valueOf(args[2]));
						if (target != null) {
							try{
								PlayerConfig.giveAchievement(target.getPlayer(), Achievements.valueOf(args[2]));
							}catch (IllegalArgumentException error) {
								p.sendMessage("§cThat Achievement couldn't be added. Is it spelled correct?");
							}
						}						
					}
					
					if(args[0].equalsIgnoreCase("take")) {
						if (target != null) {
							p.sendMessage("§aYou took §6" + target.getName() + " §a the achievement §6" + Achievements.valueOf(args[2]));
							try{
								PlayerConfig.takeAchievement(target.getPlayer(), Achievements.valueOf(args[2]));
							}catch (IllegalArgumentException error) {
								p.sendMessage("§cThat Achievement couldn't be added. Is it spelled correct?");
							}
						}
					}		
					
					
					} else
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
				}
			} else {
				p.sendMessage("§cPlease use: §6§o/ach <give/take> <name> <ach>");
			}
		} else {
			if(args.length == 3) {
				Player target = Bukkit.getPlayer(args[1]);
				if (target != null) {
										
					if(args[0].equalsIgnoreCase("give")) {
						sender.sendMessage("§aYou gave §6" + target.getName() + " §a the achievement §6" + Achievements.valueOf(args[2]));
						if (target != null) {
							try{
								PlayerConfig.giveAchievement(target.getPlayer(), Achievements.valueOf(args[2]));
							}catch (IllegalArgumentException error) {
								sender.sendMessage("§cThat Achievement couldn't be added. Is it spelled correct?");
							}
						}						
					}
					
					if(args[0].equalsIgnoreCase("take")) {
						sender.sendMessage("§aYou took §6" + target.getName() + " §a the achievement §6" + Achievements.valueOf(args[2]));
						if (target != null) {								
							try{
								PlayerConfig.takeAchievement(target.getPlayer(), Achievements.valueOf(args[2]));
							}catch (IllegalArgumentException error) {
								sender.sendMessage("§cThat Achievement couldn't be added. Is it spelled correct?");
								}
							}
						}
					}
				}
			}
		}

		return false;
	}

}
