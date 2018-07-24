package de.zwibbltv.dreamland.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import de.zwibbltv.dreamland.utils.PlayerConfig;

public class CMDdlreload implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length == 0) {
			if (sender instanceof Player) {				
				Player p = (Player) sender;
				if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.reload")) {
				    p.sendMessage(Main.prefix + "§cReload stared");
				    try {
						PlayerConfig.save();
					} catch (IOException e) {
						e.printStackTrace();
					}
				    Main.reload();
				    p.sendMessage(Main.prefix + "§aReloaded");
				    
				}			
			}						
		}


		return false;
	}

}
