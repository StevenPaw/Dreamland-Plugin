package de.zwibbltv.dreamland.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDsetspawn implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.setspawn") || p.hasPermission("dreamland.*")) {
				if(args.length == 0) {
					
					FileConfiguration cfg = Main.getPlugin().getConfig();
					Location loc = p.getLocation();
					
					cfg.set("Spawn.World", loc.getWorld().getName());
					cfg.set("Spawn.X", loc.getX());
					cfg.set("Spawn.Y", loc.getY());
					cfg.set("Spawn.Z", loc.getZ());
					cfg.set("Spawn.Yaw", loc.getYaw());
					cfg.set("Spawn.Pitch", loc.getPitch());
					Main.getPlugin().saveConfig();
					
					p.sendMessage("§aThe spawn has been set!");
					
				} else
					p.sendMessage("§cPlease use /setspawn");
			} else
				p.sendMessage("§cYou may not use this command");
			
		}
		
		return false;
	}
	

}
