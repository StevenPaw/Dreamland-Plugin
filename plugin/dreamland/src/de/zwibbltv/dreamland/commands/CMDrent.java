package de.zwibbltv.dreamland.commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import net.md_5.bungee.api.ChatColor;

public class CMDrent implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("rent")) {
			Bukkit.broadcastMessage("1");
			if (args.length == 2) {
				Bukkit.broadcastMessage("2");
				if (sender instanceof Player) {
					Bukkit.broadcastMessage("3");
					Player p = Bukkit.getPlayer(args[1]);
					if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.rent")) {
						try {
							PlayerConfig.setRentedHotel(p, Integer.parseInt(args[2]));
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
				} 
			} else
				sender.sendMessage("§cYou can't rent! §6Use /rent <RoomID> <name>");
		}

		return true;
	}
}
