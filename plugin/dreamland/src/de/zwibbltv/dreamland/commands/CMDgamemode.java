package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import net.md_5.bungee.api.ChatColor;

public class CMDgamemode implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("dreamland.gamemode.*") || p.hasPermission("dreamland.*")
					|| p.hasPermission("dreamland.gamemode.self")) {
				if (args.length == 1) {

					if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage("§aYou are now in §6survival §amode!");

					} else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage("§aYou are now in §6creative §amode!");

					} else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage("§aYou are now in §6adventure §amode!");

					} else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec")) {
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage("§aYou are now in §6spectator §amode!");

					}
				}
			} else
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
			
			if (p.hasPermission("dreamland.gamemode.*") || p.hasPermission("dreamland.*")
					|| p.hasPermission("dreamland.gamemode.others")) {
				if (args.length == 2) {
					Player target = Bukkit.getPlayer(args[1]);
					if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("s")) {
						if (target != null) {
							target.setGameMode(GameMode.SURVIVAL);
							p.sendMessage("§aYou set §6" + target.getName() + " §ato §6survival §amode!");
							target.sendMessage("§6" + p.getName() + "§a set you to §6survival §amode!");
						}

					} else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("c")) {
						if (target != null) {
							target.setGameMode(GameMode.CREATIVE);
							p.sendMessage("§aYou set §6" + target.getName() + " §ato §6creative §amode!");
							target.sendMessage("§6" + p.getName() + "§a set you to §6creative §amode!");
						}

					} else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("a")) {
						if (target != null) {
							target.setGameMode(GameMode.ADVENTURE);
							p.sendMessage("§aYou set §6" + target.getName() + " §ato §6adventure §amode!");
							target.sendMessage("§6" + p.getName() + "§a set you to §6adventure §amode!");
						}

					} else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spec")) {
						if (target != null) {
							target.setGameMode(GameMode.SPECTATOR);
							p.sendMessage("§aYou set §6" + target.getName() + " §ato §6spectator §amode!");
							target.sendMessage("§6" + p.getName() + "§a set you to §6spectator §amode!");

						}
					}
				}
			} else
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
		}

		return false;
	}

}
