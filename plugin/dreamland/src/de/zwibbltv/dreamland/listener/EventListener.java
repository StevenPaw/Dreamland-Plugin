package de.zwibbltv.dreamland.listener;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EventListener implements Listener {
	@EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event)
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
	
}
