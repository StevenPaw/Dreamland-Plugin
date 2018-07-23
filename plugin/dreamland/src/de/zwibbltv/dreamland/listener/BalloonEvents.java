package de.zwibbltv.dreamland.listener;

import de.zwibbltv.dreamland.utils.Balloons;
import de.zwibbltv.dreamland.utils.BalloonInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BalloonEvents implements Listener{
//    @EventHandler
//    public void onQuit(PlayerQuitEvent event){
//        Player player = event.getPlayer();
//        if(Balloons.BalloonsMap.containsKey(player))
//            Balloons.BalloonsMap.get(player).remove();
//    }
//
//    @EventHandler
//    public void onClick(InventoryClickEvent event){
//        if (event.getInventory() == null) return;
//        if (event.getCurrentItem() == null) return;
//        if (!(event.getWhoClicked() instanceof Player)) return;
//        Player player = (Player) event.getWhoClicked();
//        if(!BalloonInventory.epicInventoryMap.containsKey(player)) return;
//        if(!event.getInventory().getName().equals(BalloonInventory.epicInventoryMap.get(player).getInventory().getName())) return;
//        if (event.getCurrentItem().getType() == Material.AIR) return;
//
//        BalloonInventory.epicInventoryMap.get(player).onClick(event);
//    }
}