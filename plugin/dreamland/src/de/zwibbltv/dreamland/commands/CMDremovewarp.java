package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import net.md_5.bungee.api.ChatColor;

public class CMDremovewarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		if (p.hasPermission("dreamland.removewarp") || p.hasPermission("dreamland.*")) {

			if (args.length == 1) {
				String warpName = args[0];
				if (Main.getInstance().getWarpManager().isWarpExists(warpName)) {
					Main.getInstance().getWarpManager().removeWarp(warpName);
					p.sendMessage("�aThe warp�6 " + warpName + "�a has been removed!");
				} else
					p.sendMessage("�cThe warp�6 " + warpName + "�c does not exist!");

			} else
				p.sendMessage("�cPlease use /removewarp <Name>");

		} else
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));

		return false;
	}

}
