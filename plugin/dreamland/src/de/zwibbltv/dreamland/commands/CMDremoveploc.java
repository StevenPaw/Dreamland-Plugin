package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDremoveploc implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		if (p.hasPermission("dreamland.removeploc") || p.hasPermission("dreamland.*")) {

			if (args.length == 1) {
				String plocName = args[0];
				if (Main.getInstance().getplocManager().isplocExists(plocName)) {
					Main.getInstance().getplocManager().removeploc(plocName);
					p.sendMessage("§aThe ploc§6 " + plocName + "§a has been removed!");
				} else
					p.sendMessage("§cThe ploc§6 " + plocName + "§c does not exist!");

			} else
				p.sendMessage("§cPlease use /removeploc <Name>");

		} else
			p.sendMessage(Main.getNoPerms());

		return false;
	}

}
