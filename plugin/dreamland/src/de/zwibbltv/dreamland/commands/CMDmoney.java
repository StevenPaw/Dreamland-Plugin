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
				if(args.length == 3) {	
					if(args[0].equalsIgnoreCase("add")) {
						Player target = Bukkit.getPlayer(args[1]);					
						if (target != null) {								
							p.performCommand("minewallet admin addmoney pocket " + target.getName() + " " + args[2]);
							de.zwibbltv.dreamland.main.updateScoreboard.update(p);
						}		
					} if(args[0].equalsIgnoreCase("set")) {
						Player target = Bukkit.getPlayer(args[1]);					
						if (target != null) {								
							p.performCommand("minewallet admin setmoney pocket " + target.getName() + " " + args[2]);
							de.zwibbltv.dreamland.main.updateScoreboard.update(p);
						}
					}
				} if (args.length <= 2) {
					p.sendMessage("§aUse: §6/eco <add/set> <name> <money>");
				}

			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
			}		
		} 
		
		if(sender instanceof ConsoleCommandSender) {
			ConsoleCommandSender con = Bukkit.getServer().getConsoleSender();				
				if(args.length == 3) {	
					if(args[0].equalsIgnoreCase("add")) {
						Player target = Bukkit.getPlayer(args[1]);					
						if (target != null) {							
							con.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "minewallet admin addmoney pocket " + target.getName() + " " + args[2]);
							de.zwibbltv.dreamland.main.updateScoreboard.update(target);
						}		
					} if(args[0].equalsIgnoreCase("set")) {
						Player target = Bukkit.getPlayer(args[1]);					
						if (target != null) {								
							con.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "minewallet admin setmoney pocket " + target.getName() + " " + args[2]);
							de.zwibbltv.dreamland.main.updateScoreboard.update(target);
						}
					}
				} if (args.length <= 2) {
					Bukkit.getConsoleSender().sendMessage("§aUse: §6/eco <add/set> <name> <money>");
				}
		} 
		//			if(sender instanceof ConsoleCommandSender){
		//				ConsoleCommandSender con = Bukkit.getServer().getConsoleSender();
		//				if(args.length == 3) {
		//					
		//					Player target = Bukkit.getPlayer(args[1]);	
		//						if (target != null) {							
		//							con.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "minewallet admin addmoney pocket " + target.getName() + " " + args[1]);	
		//						
		//						}											
		//				} if (args.length == 0) {
		//					con.getServer().broadcastMessage("/eco <add/set> <name> <money>");
		//				}
		//			}
	return false;
}

}
