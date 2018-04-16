package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDmenu implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.*") || p.hasPermission("dreamland.menu")) {
				
				de.zwibbltv.dreamland.listener.MenuListener.openMenuMain(p);
				
			} else {
				p.sendMessage(Main.getNoPerms());
			}
			
			
		} 		
		return false;
	}

}
