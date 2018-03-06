package de.zwibbltv.dreamland.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDbuild implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("build")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.build")) {
					if (args.length == 0) {
						if (Main.build.contains(p)) {
							Main.build.remove(p);
							p.sendMessage("§cYou are no builder any longer!");
							p.setGameMode(GameMode.ADVENTURE);

						} else
							Main.build.add(p);
						p.sendMessage("§aYou are now a builder!");
						p.setGameMode(GameMode.CREATIVE);

					} else
						p.sendMessage("§cPlease use /build");

				} else
					p.sendMessage("§cYou may not use this command");

			}
		}

		return true;
	}

}
