package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDheal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args.length == 0) {
					if(p.hasPermission("dreamland.heal.self") || p.hasPermission("dreamland.heal.*") || p.hasPermission("dreamland.*")) {			
						p.setHealth(20);
						p.setFoodLevel(20);
						p.sendMessage("§aYou has been healed!");
					} else 
						p.sendMessage(Main.getNoPerms());
						
					} else if (args.length == 1) {						
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) { 
							if(p.hasPermission("dreamland.heal.others") || p.hasPermission("dreamland.heal.*") || p.hasPermission("dreamland.*")) {	
								target.setHealth(20);
								target.setFoodLevel(20);
								target.sendMessage("§aYou has been healed by §6" + p.getName() + "§a!");
								p.sendMessage("§aYou healed §6" + target.getName() + "§a!");	
							} else 
								p.sendMessage(Main.getNoPerms());		
								
						} else 
							p.sendMessage("§6" + args[0] + "§c is not online!");
						
					} else  
						p.sendMessage("§cPlease use §6/heal <Player>");					
			}
		
		return false;
	}
}
