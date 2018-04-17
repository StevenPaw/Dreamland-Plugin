package de.zwibbltv.dreamland.listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import net.md_5.bungee.api.ChatColor;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Block block = event.getClickedBlock();
		List<Material> forbidden = new ArrayList<Material>();
		if(!p.hasPermission("dreamland.useBlocks")) {
			forbidden.add(Material.WOODEN_DOOR);
			forbidden.add(Material.ACACIA_DOOR);
			forbidden.add(Material.BIRCH_DOOR);
			forbidden.add(Material.DARK_OAK_DOOR);
			forbidden.add(Material.JUNGLE_DOOR);
			forbidden.add(Material.SPRUCE_DOOR);
			forbidden.add(Material.TRAP_DOOR);
			forbidden.add(Material.ACACIA_FENCE_GATE);
			forbidden.add(Material.BIRCH_FENCE_GATE);
			forbidden.add(Material.FENCE_GATE);
			forbidden.add(Material.ENCHANTMENT_TABLE);
			forbidden.add(Material.JUNGLE_FENCE_GATE);
			forbidden.add(Material.SPRUCE_FENCE_GATE);
			forbidden.add(Material.NOTE_BLOCK);
			forbidden.add(Material.ANVIL);
			forbidden.add(Material.BEACON);
			forbidden.add(Material.WORKBENCH);
			forbidden.add(Material.ENDER_CHEST);
			forbidden.add(Material.TRAPPED_CHEST);
			forbidden.add(Material.DROPPER);
			forbidden.add(Material.DISPENSER);
			forbidden.add(Material.CHEST);
			forbidden.add(Material.BREWING_STAND);
			forbidden.add(Material.FURNACE);
			forbidden.add(Material.IRON_DOOR);
			for (Material f: forbidden)
			{
			
				if(block.getType() == f) {
					p.sendMessage(ChatColor.GRAY + "No!");
					event.setCancelled(true);
				}
			}
		}
	}
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent event)
    {
		if(
			!event.isCancelled()
			&& event.getRightClicked() instanceof ItemFrame
			&& !((ItemFrame)event.getRightClicked()).getItem().getType().equals(Material.AIR) //we dont need to prevent put items into the empty item frame (thats out of scope of this plugin)
			&& !event.getPlayer().hasPermission("dreamland.rotateItemFrames") //player with this permission can rotate the item frames
			&& !event.getPlayer().hasPermission("dreamland.*") //or players with this permission can rotate the item frames
		)
		{
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void onHangingBreakByEntity(HangingBreakByEntityEvent event) {
		if (event.getRemover() instanceof Player) {
			Player p = (Player)event.getRemover();
			if (!p.hasPermission("dreamland.rotateItemFrames") && !p.hasPermission("dreamland.*")){
				if (!event.isCancelled()) {
					event.setCancelled(true);
				}
			}
        }
    }
	
	@EventHandler
	public void onHungerDepletion(FoodLevelChangeEvent event) {
		if (!event.isCancelled()) {
			if (event.getEntity() instanceof Player) {
				Player player = (Player)event.getEntity();
				player.setFoodLevel(20);
				event.setCancelled(true);
			}
		}
	}
}
