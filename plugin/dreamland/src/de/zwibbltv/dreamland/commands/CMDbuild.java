package de.zwibbltv.dreamland.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class CMDbuild implements CommandExecutor {
	public static ArrayList<Player> buildallowed = new ArrayList<Player>();
	
	private HashMap<Player, ItemStack[]> inventorySave = new HashMap<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("build")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("§cYou are no player, you can't build!");
			} else {
				Player p = (Player) sender;
				if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.build")) {
					if (args.length == 0) {
						if (buildallowed.contains(p)) {
							buildallowed.remove(p);
							p.setGameMode(GameMode.ADVENTURE);
							p.sendMessage("§cYou are no builder any longer!");
							p.getInventory().setContents(inventorySave.get(p));
							inventorySave.remove(p);

						} else {
							buildallowed.add(p);
							inventorySave.put(p, p.getInventory().getContents());
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage("§aYou are now a builder!");
						}

					} else {
						p.sendMessage("§cYou may not use this command");
					}
				}
			}
		}
		return true;
	}
}