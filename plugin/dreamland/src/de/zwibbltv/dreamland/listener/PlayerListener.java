package de.zwibbltv.dreamland.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.md_5.bungee.api.ChatColor;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Block block = event.getClickedBlock();;
		
		
		if(block.getType() == Material.WOODEN_DOOR
				|| block.getType() == Material.ACACIA_DOOR
				|| block.getType() == Material.BIRCH_DOOR
				|| block.getType() == Material.DARK_OAK_DOOR
				|| block.getType() == Material.JUNGLE_DOOR
				|| block.getType() == Material.SPRUCE_DOOR
				|| block.getType() == Material.TRAP_DOOR
				|| block.getType() == Material.WOOD_DOOR
				|| block.getType() == Material.IRON_DOOR) 
		{
			if(!p.hasPermission("dreamland.openDoors")) {
				p.sendMessage(ChatColor.RED + "No! Don't try that!");
				event.setCancelled(true);
			}
		}
						
	}
	
}
