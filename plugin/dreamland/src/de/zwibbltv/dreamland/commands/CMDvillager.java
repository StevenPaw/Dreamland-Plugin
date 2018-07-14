package de.zwibbltv.dreamland.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.zwibbltv.dreamland.main.Main;
import net.md_5.bungee.api.ChatColor;

public class CMDvillager implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if (p.hasPermission("dreamland.*") || p.hasPermission("dreamland.villager")) {
			if(args.length == 0) {
				p.sendMessage("§cPlease use: §6/villager <name>");
			}
			if(args.length == 1) {				
				
				Location loc = p.getLocation();				
				Villager v = loc.getWorld().spawn(loc, Villager.class);
				v.setCustomName(args[0]);
				v.setCustomNameVisible(false);
				v.setSilent(true);
				v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300000, 300000, false, false));
				v.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300000, 300000 ,false, false));
				v.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300000, 300000, false, false));
				p.sendMessage("§aVillager created: §6" + args[0]);
								
				} 
		} else 
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
			
		} else 
			sender.sendMessage("§cYou are no Player!");
		
		
		return false;
	}
}
