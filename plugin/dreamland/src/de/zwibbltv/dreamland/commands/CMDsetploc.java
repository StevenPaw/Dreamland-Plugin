package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;

public class CMDsetploc implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		if (p.hasPermission("dreamland.setploc") || p.hasPermission("dreamland.*")) {
			if (args.length == 1) {
				Main.getInstance().getplocManager().createploc(p, args[0]);
			} else
				p.sendMessage("§cPlease use /setploc <Name>");
		} else
			p.sendMessage(Main.getNoPerms());

	return false;
}

}
