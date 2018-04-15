package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDwarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		if(p.hasPermission("dreamland.warp") || p.hasPermission("dreamland.*")) {
			if(args.length == 1) {
				String warpName = args[0];
				if (Main.getInstance().getWarpManager().isWarpExists(warpName)) {
					Main.getInstance().getWarpManager().teleportToWarp(p, args[0]);
					p.sendMessage("§aYou are now at the warp§6 " + warpName + "");		
				} else
					p.sendMessage("§cThe warp§6 " + warpName + "§c does not exist!");
						
			} 
				if(args.length == 0) {
					config = Main.getInstance().getDataFolder(), "warps.yml";
					String warps = "";
					for(String s : config.getConfigurationSection(Main.getInstance().getDataFolder(), "warps.yml").getKeys(false)) {
						warps = warps +" , " +s;
					}
					p.sendMessage("Warps: " + warps);
					
				
			} 
			
		} else
			p.sendMessage(Main.getNoPerms());
		
		return false;
	}

}
