package de.zwibbltv.dreamland.listener;

import java.util.ArrayList;
import java.util.List;

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
		List<String> shopList = new ArrayList<String>();
		if(e.getRightClicked().getType() == EntityType.VILLAGER) {
			Villager v = (Villager) e.getRightClicked();
			e.setCancelled(true);

			//CHECKEN NACH DEN SHOPS

			for(Shop shop : Shop.values()) {

				boolean isnew = true;
				for(Integer i = 0; i < shopList.size(); i++) {
					if(shop.getShopName() == shopList.get(i))
					{
						isnew = false;
					}
				}
				if(isnew == true)
				{
					shopList.add(shop.getShopName());
				}
			}

			//INVENTARGRÖßE BERECHNEN
			Integer invCount = 0;
			Integer invSize = 0;
			for(Integer i = 0; i < shopList.size(); i++)
			{
				if(v.getCustomName().equalsIgnoreCase(shopList.get(i)))
				{
					for(Shop shop : Shop.values())
					{
						if (shop.getShopName() == shopList.get(i))
						{
							if(shop.getSlot() >= invCount)
								invCount = shop.getSlot();
						}
						boolean passt = false;
						while(passt == false) {
							if(9*invSize > invCount) {
								passt = true;
							} else {
								invSize += 1;
							}
						}
					}
				}
			}


			//SHOPINVENTAR ERSTELLEN
			for(Integer i = 0; i < shopList.size(); i++)
			{
				if(v.getCustomName().equalsIgnoreCase(shopList.get(i)))
				{
					Inventory inv = Bukkit.createInventory(null, 9 * invSize, shopList.get(i));
					for(Shop shop : Shop.values())
					{
						if (shop.getShopName() == shopList.get(i))
						{
							ItemStack shopIS = new ItemStack(shop.getMaterial());
							ItemMeta im = shopIS.getItemMeta();
							im.setDisplayName(shop.getName());
							if(shop.getColor().getBlue() != 20) {
								LeatherArmorMeta meta1 = (LeatherArmorMeta)im;
								meta1.setColor(shop.getColor());
								shopIS.setItemMeta(meta1);
							}
							ArrayList<String> lore = new ArrayList<>();
							lore.add("§6Price: " + shop.getMoney());
							if(PlayerConfig.hasItemInv(e.getPlayer(), shop)) {
								lore.add(">>§cBOUGHT");
							}
							im.setLore(lore);
							shopIS.setItemMeta(im);


							inv.setItem(shop.getSlot(), shopIS);
						}
					}
					e.getPlayer().openInventory(inv);
				}
			}

		}

		//			for(Shop shop : Shop.values()) {
		//				if(v.getCustomName().equalsIgnoreCase(shop.getShopName())) {
		//
		//					Bukkit.broadcastMessage("Momentaner Check:" + shop.getName());
		//					ItemStack i = new ItemStack(shop.getMaterial());
		//					ItemMeta im = i.getItemMeta();
		//					im.setDisplayName(shop.getName());
		//					if(shop.getColor().getBlue() != 20) {
		//						LeatherArmorMeta meta1 = (LeatherArmorMeta)im;
		//						meta1.setColor(shop.getColor());
		//						i.setItemMeta(meta1);
		//					}
		//					ArrayList<String> lore = new ArrayList<>();
		//					lore.add("§6Price: " + shop.getMoney());
		//					if(PlayerConfig.hasItemInv(e.getPlayer(), shop)) {
		//						lore.add(">>§cBOUGHT");
		//					}
		//					im.setLore(lore);
		//					i.setItemMeta(im);
		//
		//					
		//					inv.setItem(shop.getSlot(), i);
		//				} 
		//			}
		//			e.getPlayer().openInventory(inv);
		//		}


	}

	@EventHandler
	public void onINVclick(InventoryClickEvent e) {

		Economy eco = de.zwibbltv.dreamland.main.Main.economy;

		Player p = (Player) e.getWhoClicked();

		for(Shop shop : Shop.values()) {
			if(e.getInventory().getName().equalsIgnoreCase(shop.getShopName())) {

				if(e.getCurrentItem().getItemMeta().getDisplayName() == shop.getName()) {
					if(eco.getBalance(p) >= shop.getMoney()) {
						if(!PlayerConfig.hasItemInv(p, shop)) {
							PlayerConfig.giveItemInv(p.getPlayer(), shop);
							ItemStack BoughtItem = new ItemStack(shop.getMaterial(), 1);
							ItemMeta im = BoughtItem.getItemMeta();
							im.setDisplayName(shop.getName());
							if(shop.getColor().getBlue() != 20)
							{
								LeatherArmorMeta meta1 = (LeatherArmorMeta)im;
								meta1.setColor(shop.getColor());
								BoughtItem.setItemMeta(meta1);
							}
							BoughtItem.setItemMeta(im);
							p.getInventory().addItem(BoughtItem);
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
