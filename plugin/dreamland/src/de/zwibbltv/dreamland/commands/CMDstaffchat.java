package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import net.md_5.bungee.api.ChatColor;

public class CMDstaffchat implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.*") || p.hasPermission("dreamland.staffchat")) {

				if(args.length == 0){
					p.sendMessage("§cUse §6/sc <message>");
				}else if(args.length >= 1){
					String message = "";
					for (String part : args) {
						if (message != "") message += " ";
						message += part;
					}

					for (Player all : Bukkit.getServer().getOnlinePlayers()) {
						if(all.hasPermission("dreamland.staffchat") || all.hasPermission("dreamland.*")) {
							all.sendMessage("§c[StaffChat] §r" + p.getName() + ": " + message);
						}
					}

				}

			} else
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));

		}

		return false;
	}

}
