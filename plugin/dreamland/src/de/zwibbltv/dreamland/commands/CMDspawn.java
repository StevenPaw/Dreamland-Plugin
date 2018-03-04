package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.spawn") || p.hasPermission("dreamland.*")) {
				if(args.length == 0) {
					
					FileConfiguration cfg = Main.getPlugin().getConfig();
					World world = Bukkit.getWorld(cfg.getString("Spawn.World"));
					double x = cfg.getDouble("Spawn.X");
					double y = cfg.getDouble("Spawn.Y");
					double z = cfg.getDouble("Spawn.Z");
					float yaw = (float) cfg.getDouble("Spawn.Yaw");
					float pitch = (float) cfg.getDouble("Spawn.Pitch");
					
					Location loc = new Location(world, x, y, z, yaw, pitch);
					p.teleport(loc);
					p.sendMessage("§aYou are now at the spawn");
					
				} else
					p.sendMessage("§cPlease use /spawn");
			} else
				p.sendMessage("§cYou may not use this command");
		}
		
		return false;
	}

}
