package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDsetwarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		if (p.hasPermission("dreamland.setwarp") || p.hasPermission("dreamland.*")) {
			if (args.length == 1) {
				Main.getInstance().getWarpManager().createWarp(p, args[0]);
			} else
				p.sendMessage("§cPlease use /setwarp <Name>");
		} else
			p.sendMessage(Main.getNoPerms());

	return false;
}

}
