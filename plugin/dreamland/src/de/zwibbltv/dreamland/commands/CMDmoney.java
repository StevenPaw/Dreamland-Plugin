package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import net.md_5.bungee.api.ChatColor;

public class CMDmoney implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.*") || p.hasPermission("dreamland.money")) {
				
				if(args.length == 2) {					
					Player target = Bukkit.getPlayer(args[0]);					
						if (target != null) {								
							p.performCommand("minewallet admin addmoney pocket " + target.getName() + " " + args[1]);
							de.zwibbltv.dreamland.main.updateScoreboard.update(p);
							
						}		
				} if (args.length == 1) {
					Player target = Bukkit.getPlayer(sender.getName());
					if (target != null) {								
						p.performCommand("minewallet admin addmoney pocket " + target.getName() + " " + args[0]);
						de.zwibbltv.dreamland.main.updateScoreboard.update(p);
					}
									
				} if (args.length == 0) {
					p.sendMessage("§aUse: §6/eco <name> <money>");
				}
				
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
			}		
		} 
		if(sender instanceof ConsoleCommandSender){
			ConsoleCommandSender con = Bukkit.getServer().getConsoleSender();
			if(args.length == 2) {
				
				Player target = Bukkit.getPlayer(args[0]);	
					if (target != null) {							
						con.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "minewallet admin addmoney pocket " + target.getName() + " " + args[1]);	
					
					}											
			} if (args.length == 0) {
				con.getServer().broadcastMessage("/eco <name> <money>");
			}
		}
		return false;
	}

}
