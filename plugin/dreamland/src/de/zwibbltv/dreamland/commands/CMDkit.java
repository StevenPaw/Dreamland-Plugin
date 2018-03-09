package de.zwibbltv.dreamland.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.zwibbltv.dreamland.main.Main;

public class CMDkit implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("kit")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("dreamland.kit") || p.hasPermission("dreamland.*")) {
						if(args.length == 0) {
							
							Inventory inv = Bukkit.createInventory(null, 9*1, "§cDein Kit");
							
							ItemStack i = new ItemStack(Material.GOLDEN_APPLE);
							i.setAmount(4);
							ItemMeta im = i.getItemMeta();
							im.setDisplayName("§a§lsuperapple");
							i.setItemMeta(im);
							
							inv.setItem(4, i);
							p.openInventory(inv);
							
					} else 
						p.sendMessage("§cPlease use /kit");						
				} else 
					p.sendMessage(Main.getNoPerms());						
			}
		}
		return false;
	}
	

}