package de.zwibbltv.dreamland.commands;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.zwibbltv.dreamland.main.Main;


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
				if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.build.self") || p.hasPermission("dreamland.build.*")) {
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

					}
					else if (args.length == 1) {
						if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.build.other") || p.hasPermission("dreamland.build.*")) {
							Player target = Bukkit.getPlayer(args[0]);
							if (target != null) {
								if (buildallowed.contains(target)) {
									buildallowed.remove(target);
									target.setGameMode(GameMode.ADVENTURE);
									target.sendMessage("§cYou are no builder any longer! §7(By: §6" + p.getName() + "§7)");
									p.sendMessage("§6" + target.getName() + "§a is no builder any longer!");
									target.getInventory().setContents(inventorySave.get(target));
									inventorySave.remove(target);

								} else {
									buildallowed.add(target);
									inventorySave.put(target, target.getInventory().getContents());
									target.setGameMode(GameMode.CREATIVE);
									target.sendMessage("§aYou are now a builder! §7(By: §6" + p.getName() + "§7)");
									p.sendMessage("§6" + target.getName() + "§a is now a builder!");
								}
							} else 
								p.sendMessage("§6" + args[0] + "§c isn't online!");
						}
					}
				} else
					p.sendMessage(Main.getNoPerms());
			}
		}
		return true;
	}
}