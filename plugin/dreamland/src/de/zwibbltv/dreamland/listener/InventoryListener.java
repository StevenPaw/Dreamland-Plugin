package de.zwibbltv.dreamland.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import de.zwibbltv.dreamland.utils.PlayerConfig;
import de.zwibbltv.dreamland.utils.Shop;

public class InventoryListener implements Listener {


	static List<String> InvList = new ArrayList<String>();

	@EventHandler
	public void onMenuClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (PlayerConfig.getCurrentInventory(p) == "Inventory") {
			for(int s = 0; s < InvList.size(); s++) {
				if(InvList.get(s) == e.getCurrentItem().getItemMeta().getDisplayName()) {
					openMenuInventoryCat(p, e.getCurrentItem().getItemMeta().getDisplayName());
				}
			}
		}

		if (p.getInventory().getName().equalsIgnoreCase("§cJackets")) {
			for(Shop shop :Shop.values()) {

				ItemStack cjb = new ItemStack(shop.getMaterial());
				ItemMeta cjbmeta = cjb.getItemMeta();
				cjbmeta.setDisplayName(shop.getName());
				cjb.setItemMeta(cjbmeta);

				if(shop.getColor().getBlue() != 20) {
					LeatherArmorMeta meta1 = (LeatherArmorMeta)cjbmeta;
					meta1.setColor(shop.getColor());
					cjb.setItemMeta(meta1);

				}		
				p.getInventory().setItem(38, cjb);												
			}
		}

		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cBack")) {
			if(PlayerConfig.getCurrentInventory(p) == "InventoryCat") {
				openInvMain(p);
			} else
				de.zwibbltv.dreamland.listener.MenuListener.openMenuMain(p);				
		}			
	}

	//open Inv-menu
	public static void openInvMain(Player p) {

		Inventory inv = Bukkit.createInventory(null, 9 * 1, "§cInventory"); //ERSTELLE INVENTAR
		Integer Pos = 0;
		InvList.clear();

		for(Shop shop :Shop.values()) { //TESTE ALLE SHOPEINTRÄGE

			if(PlayerConfig.hasItemInv(p, shop)) {

				boolean isnew = true;

				for(Integer i = 0; i < InvList.size(); i++) {
					if(shop.getType() == InvList.get(i)) {
						isnew = false;
					}
				}

				if(isnew == true) {

					ItemStack shopItem = new ItemStack(shop.getMaterial());
					ItemMeta shopMeta = shopItem.getItemMeta();

					shopMeta.setDisplayName(shop.getType());
					shopItem.setItemMeta(shopMeta);
					inv.setItem(Pos, shopItem);
					InvList.add(shop.getType());
					Pos += 1;
				}
			}
		}
		p.openInventory(inv);
		try {
			PlayerConfig.setCurrentInventory(p, "Inventory");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//clothings
	public void openMenuInventoryCat(Player p,String cat) {	

		int invSize = 1;
		int ItemNumber = 0;
		for(Shop shop : Shop.values()) {
			if(shop.getType() == cat) //Counting the Achievements in that Category
				ItemNumber += 1;
		}
		boolean passt = false;
		while(passt == false) {
			if(9*invSize > ItemNumber) {
				passt = true;
			} else {
				invSize += 1;
			}
		}

		Inventory inv = Bukkit.createInventory(null, 9 * invSize, "§c" + cat);

		int pos = 0;
		for(Shop shop : Shop.values()) {
			if(PlayerConfig.hasItemInv(p, shop)) {

				if(shop.getType() == cat) { //Counting the Achievements in that Category

					ItemStack cjb = new ItemStack(shop.getMaterial());
					ItemMeta cjbmeta = cjb.getItemMeta();
					cjbmeta.setDisplayName(shop.getName());
					cjb.setItemMeta(cjbmeta);

					if(shop.getColor().getBlue() != 20) {
						LeatherArmorMeta meta1 = (LeatherArmorMeta)cjbmeta;
						meta1.setColor(shop.getColor());
						cjb.setItemMeta(meta1);
					}

					inv.setItem(pos, cjb);

					pos += 1;
				}
			}
		}

		ItemStack back = new ItemStack(Material.CLAY_BRICK);

		ItemMeta backmeta = back.getItemMeta();
		backmeta.setDisplayName("§cBack");
		back.setItemMeta(backmeta);
		inv.setItem(invSize*9-1, back);

		p.openInventory(inv);

		try {
			PlayerConfig.setCurrentInventory(p, "InventoryCat");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
