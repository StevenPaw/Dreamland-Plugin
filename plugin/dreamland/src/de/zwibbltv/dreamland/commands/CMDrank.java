package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.zwibbltv.dreamland.main.ItemBuilder;
import de.zwibbltv.dreamland.main.Main;

public class CMDrank implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.*") || p.hasPermission("dreamland.rank")) {
				
				if(args.length == 2) {					
					Player target = Bukkit.getPlayer(args[0]);					
						if (target != null) {								
							p.performCommand("pex user " + target.getName() + " group set " + args[1]);
							if (target.hasPermission("dreamland.*") || target.hasPermission("dreamland.build.self") || target.hasPermission("dreamland.build.*")) {
								if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(target)) {
									
									ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("�6Menu").build();
									ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("�6Buy VIP").build();
									ItemStack gold_spade = new ItemBuilder(Material.GOLD_SPADE).setDisplayName("�6Builder").build();
									
									target.getPlayer().getInventory().clear();
									target.getPlayer().getEquipment().clear();							
									target.getPlayer().getInventory().setItem(0, carrot);
									target.getPlayer().getInventory().setItem(7, gold_spade);
									target.getPlayer().getInventory().setItem(8, golden_carrot);
								}
							}
							else if (!target.hasPermission("dreamland.*") && !target.hasPermission("dreamland.build.self") && !target.hasPermission("dreamland.build.*")) {
								if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(target)) {
									
									ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("�6Menu").build();
									ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("�6Buy VIP").build();
									
									target.getPlayer().getInventory().clear();
									target.getPlayer().getEquipment().clear();							
									target.getPlayer().getInventory().setItem(0, carrot);
									target.getPlayer().getInventory().setItem(8, golden_carrot);
								}
							}
						}		
				} if (args.length == 1) {
					Player target = Bukkit.getPlayer(sender.getName());
					if (target != null) {								
						p.performCommand("pex user " + sender.getName() + " group set " + args[0]);
					}
									
				} if (args.length == 0) {
					p.performCommand("pex groups list");
				}
				
			} else {
				p.sendMessage(Main.getNoPerms());
			}		
		} 
		if(sender instanceof ConsoleCommandSender){
			ConsoleCommandSender con = Bukkit.getServer().getConsoleSender();
			if(args.length == 2) {
				
				Player target = Bukkit.getPlayer(args[0]);	
					if (target != null) {							
						con.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + target.getName() + " group set " + args[1]);	
						if (target.hasPermission("dreamland.*") || target.hasPermission("dreamland.build.self") || target.hasPermission("dreamland.build.*")) {
							if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(target)) {
								
								ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("�6Menu").build();
								ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("�6Buy VIP").build();
								ItemStack gold_spade = new ItemBuilder(Material.GOLD_SPADE).setDisplayName("�6Builder").build();
								
								target.getPlayer().getInventory().clear();
								target.getPlayer().getEquipment().clear();							
								target.getPlayer().getInventory().setItem(0, carrot);
								target.getPlayer().getInventory().setItem(7, gold_spade);
								target.getPlayer().getInventory().setItem(8, golden_carrot);
							}
						}
						else if (!target.hasPermission("dreamland.*") && !target.hasPermission("dreamland.build.self") && !target.hasPermission("dreamland.build.*")) {
							if (!de.zwibbltv.dreamland.commands.CMDbuild.buildallowed.contains(target)) {
								
								ItemStack carrot = new ItemBuilder(Material.CARROT_ITEM).setDisplayName("�6Menu").build();
								ItemStack golden_carrot = new ItemBuilder(Material.GOLDEN_CARROT).setDisplayName("�6Buy VIP").build();
								
								target.getPlayer().getInventory().clear();
								target.getPlayer().getEquipment().clear();							
								target.getPlayer().getInventory().setItem(0, carrot);
								target.getPlayer().getInventory().setItem(8, golden_carrot);
							}
						}
					}											
			} if (args.length == 0) {
				con.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex groups list");
			}
		}
		return false;
	}
}
