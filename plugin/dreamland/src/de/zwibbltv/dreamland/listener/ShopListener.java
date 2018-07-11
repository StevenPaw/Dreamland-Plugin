package de.zwibbltv.dreamland.listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import de.zwibbltv.dreamland.utils.PlayerConfig;
import de.zwibbltv.dreamland.utils.Shop;
import net.milkbowl.vault.economy.Economy;

public class ShopListener implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		if(e.getRightClicked().getType() == EntityType.VILLAGER) {
			Villager v = (Villager) e.getRightClicked();
			e.setCancelled(true);
			
			for(Shop shop : Shop.values()) {
				int b = shop.getSlot();
			if(v.getCustomName().equalsIgnoreCase(shop.getShopName())) {
								
				ItemStack i = new ItemStack(shop.getMaterial());
				ItemMeta im = i.getItemMeta();
				im.setDisplayName(shop.getName());
				if(shop.getColor().getBlue() != 20) {
					LeatherArmorMeta meta1 = (LeatherArmorMeta)im;
					meta1.setColor(shop.getColor());
					i.setItemMeta(meta1);
				}
				ArrayList<String> lore = new ArrayList<>();
				lore.add("§6Price: " + shop.getMoney());
				if(PlayerConfig.hasItemInv(e.getPlayer(), shop)) {
					lore.add(">>§cBOUGHT");
				}
				im.setLore(lore);
				i.setItemMeta(im);
				
				Inventory inv = Bukkit.createInventory(null, 18, shop.getShopName());
				inv.setItem(b, i);
				e.getPlayer().openInventory(inv);
			} 
		}
	}
		
		
	}

	@EventHandler
	public void onINVclick(InventoryClickEvent e) {

	    Economy eco = de.zwibbltv.dreamland.main.Main.economy;
		
		Player p = (Player) e.getWhoClicked();
		
		for(Shop shop : Shop.values()) {
		if(e.getInventory().getName().equalsIgnoreCase(shop.getShopName())) {
					
		if(e.getCurrentItem().getType() == shop.getMaterial()) {
			if(eco.getBalance(p) >= shop.getMoney()) {
				if(!PlayerConfig.hasItemInv(p, shop)) {
					PlayerConfig.giveItemInv(p.getPlayer(), shop);
					p.getInventory().addItem(new ItemStack(shop.getMaterial(), 1));
					eco.withdrawPlayer(p, shop.getMoney());
					p.closeInventory();
					p.sendMessage("§aYou bought: §6" + shop.getName());
					de.zwibbltv.dreamland.main.updateScoreboard.update(p);
				} else 
					p.sendMessage("§cYou already own this Item!");	
				
			} else
				p.sendMessage("§cYou do not have enough money!");
				p.closeInventory();
				}
		e.setCancelled(true);
			}
		}
	}
}
