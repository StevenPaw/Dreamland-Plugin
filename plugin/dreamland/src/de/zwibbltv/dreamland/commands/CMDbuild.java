package de.zwibbltv.dreamland.commands;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.main.Main;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import net.md_5.bungee.api.ChatColor;


public class CMDbuild implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("build")) {
			if (args.length == 0) {
			if (sender instanceof Player) {				
				Player p = (Player) sender;
				if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.build.self") || p.hasPermission("dreamland.build.*")) {
						if (PlayerConfig.getBuilder(p) == true) {
							try {
								PlayerConfig.setBuilder(p, false);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.setGameMode(GameMode.ADVENTURE);
							p.sendMessage("§cYou are no builder any longer!");
							de.zwibbltv.dreamland.listener.MenuListener.resetInventory(p);
							de.zwibbltv.dreamland.main.updateScoreboard.update(p);

						} 
						else if(PlayerConfig.getBuilder(p) == false || PlayerConfig.getBuilder(p) == null){
							try {
								PlayerConfig.setBuilder(p, true);
							} catch (IOException e) {
								e.printStackTrace();
							}
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage("§aYou are now a builder!");
							p.getPlayer().getInventory().clear();
							p.getPlayer().getEquipment().clear();
							de.zwibbltv.dreamland.main.updateScoreboard.update(p);
						}					
					} else
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
				} else
					sender.sendMessage("§cYou can't build! §6Use /build <name>");
			}			
			if (args.length == 1) {
				if (sender instanceof Player) {			
				Player p = (Player) sender;
					if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.build.other") || p.hasPermission("dreamland.build.*")) {
						Player target = Bukkit.getPlayer(args[0]);
						if (target != null) {
							if (PlayerConfig.getBuilder(target) == true) {
								try {
									PlayerConfig.setBuilder(target, false);
								} catch (IOException e) {
									e.printStackTrace();
								}
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage("§cYou are no builder any longer! §7(By: §6" + p.getName() + "§7)");
								p.sendMessage("§6" + target.getName() + "§a is no builder any longer!");
								de.zwibbltv.dreamland.listener.MenuListener.resetInventory(target);
								de.zwibbltv.dreamland.main.updateScoreboard.update(p);
								
							} 
							else if(PlayerConfig.getBuilder(target) == false  || PlayerConfig.getBuilder(target) == null){
								try {
									PlayerConfig.setBuilder(target, true);
								} catch (IOException e) {
									e.printStackTrace();
								}
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage("§aYou are now a builder! §7(By: §6" + p.getName() + "§7)");
								p.sendMessage("§6" + target.getName() + "§a is now a builder!");

								target.getPlayer().getInventory().clear();
								target.getPlayer().getEquipment().clear();
								de.zwibbltv.dreamland.main.updateScoreboard.update(p);
							}
						} else 
							p.sendMessage("§6" + args[0] + "§c isn't online!");
					} else
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
				}else {
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null) {
						if (PlayerConfig.getBuilder(target) == true) {
							try {
								PlayerConfig.setBuilder(target, false);
							} catch (IOException e) {
								e.printStackTrace();
							}
							target.setGameMode(GameMode.ADVENTURE);
							target.sendMessage("§cYou are no builder any longer! §7(By: §6" + "Admins" + "§7)");
							sender.sendMessage("§6" + target.getName() + "§a is no builder any longer!");
							de.zwibbltv.dreamland.listener.MenuListener.resetInventory(target);
							de.zwibbltv.dreamland.main.updateScoreboard.update(target);

						} 
						else if(PlayerConfig.getBuilder(target) == false || PlayerConfig.getBuilder(target) == null){
							try {
								PlayerConfig.setBuilder(target, true);
							} catch (IOException e) {
								e.printStackTrace();
							}
							target.setGameMode(GameMode.CREATIVE);
							target.sendMessage("§aYou are now a builder! §7(By: §6" + "Admins" + "§7)");
							sender.sendMessage("§6" + target.getName() + "§a is now a builder!");

							target.getPlayer().getInventory().clear();
							target.getPlayer().getEquipment().clear();
							de.zwibbltv.dreamland.main.updateScoreboard.update(target);
						}
					} else 
						sender.sendMessage("§6" + args[0] + "§c isn't online!");
				}
			}
			
		}
		return true;
	}
}