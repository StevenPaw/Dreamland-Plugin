package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import net.md_5.bungee.api.ChatColor;

public class CMDbroadcastmessage implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.*") || p.hasPermission("dreamland.broadcastmessage")) {
				if(args.length == 0){
					p.sendMessage("§cUse §6/bcm <message>");
				}else if(args.length >= 1){
					String message = "";
					for (String part : args) {
						if (message != "") message += " ";
						message += part;
					}
					Bukkit.getServer().broadcastMessage(" ");
					Bukkit.getServer().broadcastMessage(" ");
					Bukkit.getServer().broadcastMessage(Main.prefix +"§b" + message);
					Bukkit.getServer().broadcastMessage(" ");
					Bukkit.getServer().broadcastMessage(" ");

				}
			} else 
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));

		}
		if(sender instanceof ConsoleCommandSender) {
			ConsoleCommandSender con = Bukkit.getServer().getConsoleSender();
			if(args.length == 0){
				con.sendMessage("§cUse §6/bcm <message>");
			}else if(args.length >= 1){
				String message = "";
				for (String part : args) {
					if (message != "") message += " ";
					message += part;
				}
				Bukkit.getServer().broadcastMessage(" ");
				Bukkit.getServer().broadcastMessage(" ");
				Bukkit.getServer().broadcastMessage(Main.prefix +"§b" + message);
				Bukkit.getServer().broadcastMessage(" ");
				Bukkit.getServer().broadcastMessage(" ");
			}
		}

		return false;
	}

}
