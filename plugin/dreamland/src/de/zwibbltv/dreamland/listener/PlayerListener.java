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
				|| block.getType() == Material.ACACIA_FENCE_GATE
				|| block.getType() == Material.BIRCH_FENCE_GATE
				|| block.getType() == Material.FENCE_GATE
				|| block.getType() == Material.ENCHANTMENT_TABLE
				|| block.getType() == Material.JUNGLE_FENCE_GATE
				|| block.getType() == Material.SPRUCE_FENCE_GATE
				|| block.getType() == Material.NOTE_BLOCK
				|| block.getType() == Material.ANVIL
				|| block.getType() == Material.BEACON
				|| block.getType() == Material.ANVIL
				|| block.getType() == Material.WORKBENCH
				|| block.getType() == Material.ENDER_CHEST
				|| block.getType() == Material.TRAPPED_CHEST
				|| block.getType() == Material.DROPPER
				|| block.getType() == Material.DISPENSER
				|| block.getType() == Material.CHEST
				|| block.getType() == Material.BREWING_STAND
				|| block.getType() == Material.FURNACE
				|| block.getType() == Material.IRON_DOOR) 
		{
			if(!p.hasPermission("dreamland.useBlocks")) {
				p.sendMessage(ChatColor.GRAY + "No!");
				event.setCancelled(true);
			}
		}
						
	}
	
}
