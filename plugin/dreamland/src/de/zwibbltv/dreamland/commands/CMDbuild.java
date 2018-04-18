package de.zwibbltv.dreamland.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.zwibbltv.dreamland.main.ItemBuilder;
import de.zwibbltv.dreamland.main.Main;


public class CMDbuild implements CommandExecutor {
	public static ArrayList<Player> buildallowed = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("build")) {
			if (args.length == 0) {
			if (sender instanceof Player) {				
				Player p = (Player) sender;
				if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.build.self") || p.hasPermission("dreamland.build.*")) {
						if (buildallowed.contains(p)) {
							buildallowed.remove(p);
							p.setGameMode(GameMode.ADVENTURE);
							p.sendMessage("�cYou are no builder any longer!");
							
							ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("�6Menu").build();
							ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("�6Buy VIP").build();
							ItemStack gold_spade = new ItemBuilder(Material.GOLD_SPADE).setDisplayName("�6Builder").build();
							
							p.getPlayer().getInventory().clear();
							p.getPlayer().getEquipment().clear();							
							p.getPlayer().getInventory().setItem(0, carrot);
							p.getPlayer().getInventory().setItem(7, gold_spade);
							p.getPlayer().getInventory().setItem(8, golden_carrot);

						} else {
							buildallowed.add(p);
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage("�aYou are now a builder!");
							p.getPlayer().getInventory().clear();
							p.getPlayer().getEquipment().clear();
						}					
					} else
						p.sendMessage(Main.getNoPerms());
				} else
					sender.sendMessage("�cYou can't build! �6Use /build <name>");
			}			
			if (args.length == 1) {
				if (sender instanceof Player) {			
				Player p = (Player) sender;
					if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.build.other") || p.hasPermission("dreamland.build.*")) {
						Player target = Bukkit.getPlayer(args[0]);
						if (target != null) {
							if (buildallowed.contains(target)) {
								buildallowed.remove(target);
								target.setGameMode(GameMode.ADVENTURE);
								target.sendMessage("�cYou are no builder any longer! �7(By: �6" + p.getName() + "�7)");
								p.sendMessage("�6" + target.getName() + "�a is no builder any longer!");
							
								ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("�6Menu").build();
								ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("�6Buy VIP").build();
								if(target.hasPermission("dreamland.build.*") || target.hasPermission("dreamland.build.self") || target.hasPermission("dreamland.build.other")) {
									ItemStack gold_spade = new ItemBuilder(Material.GOLD_SPADE).setDisplayName("�6Builder").build();
									target.getPlayer().getInventory().setItem(7, gold_spade);
									}

								target.getPlayer().getInventory().clear();
								target.getPlayer().getEquipment().clear();
								target.getPlayer().getInventory().setItem(0, carrot);
								target.getPlayer().getInventory().setItem(8, golden_carrot);
								
							} else {
								buildallowed.add(target);
								target.setGameMode(GameMode.CREATIVE);
								target.sendMessage("�aYou are now a builder! �7(By: �6" + p.getName() + "�7)");
								p.sendMessage("�6" + target.getName() + "�a is now a builder!");

								target.getPlayer().getInventory().clear();
								target.getPlayer().getEquipment().clear();
							}
						} else 
							p.sendMessage("�6" + args[0] + "�c isn't online!");
					} else
						p.sendMessage(Main.getNoPerms());
				}else {
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null) {
						if (buildallowed.contains(target)) {
							buildallowed.remove(target);
							target.setGameMode(GameMode.ADVENTURE);
							target.sendMessage("�cYou are no builder any longer! �7(By: �6" + "Admins" + "�7)");
							sender.sendMessage("�6" + target.getName() + "�a is no builder any longer!");
							
							ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("�6Menu").build();
							ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("�6Buy VIP").build();
							if(target.hasPermission("dreamland.build.*") || target.hasPermission("dreamland.build.self") || target.hasPermission("dreamland.build.other")) {
								ItemStack gold_spade = new ItemBuilder(Material.GOLD_SPADE).setDisplayName("�6Builder").build();
								target.getPlayer().getInventory().setItem(7, gold_spade);
								}

							target.getPlayer().getInventory().clear();
							target.getPlayer().getEquipment().clear();
							target.getPlayer().getInventory().setItem(0, carrot);
							target.getPlayer().getInventory().setItem(8, golden_carrot);

						} else {
							buildallowed.add(target);
							target.setGameMode(GameMode.CREATIVE);
							target.sendMessage("�aYou are now a builder! �7(By: �6" + "Admins" + "�7)");
							sender.sendMessage("�6" + target.getName() + "�a is now a builder!");

							target.getPlayer().getInventory().clear();
							target.getPlayer().getEquipment().clear();
						}
					} else 
						sender.sendMessage("�6" + args[0] + "�c isn't online!");
				}
			}
			
		}
		return true;
	}
}