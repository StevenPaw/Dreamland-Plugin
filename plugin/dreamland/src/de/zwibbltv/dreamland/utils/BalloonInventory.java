package de.zwibbltv.dreamland.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.zwibbltv.dreamland.main.Main;

import java.util.*;

public class BalloonInventory {

	public static Map<Player, BalloonInventory> epicInventoryMap = new HashMap<>();
	private Inventory inventory;
	private Player player;

	public BalloonInventory(Player player){
		this.player = player;
		this.inventory = Bukkit.createInventory(null, 45, "Balloons");
		epicInventoryMap.put(this.player, this);
	}

	private void create(){
		for(Heads heads : Heads.values()){
			if(this.player.hasPermission(heads.getPermission())){
				this.setItem(heads.getItem(), heads.getSlot(), heads.getName(), Collections.singletonList(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms"))));
			}else {
				this.setItem(heads.getItem(), heads.getSlot(), heads.getName(), Collections.singletonList(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms"))));
			}

		}
		if(Balloons.BalloonsMap.containsKey(this.player))
			this.setItem(new ItemStack(Material.BARRIER),40, "Remove your balloon", null);
	}

	public void onClick(InventoryClickEvent event){
		ItemStack item = event.getCurrentItem();
		if(item.getType() != Material.BARRIER){
			if(item.getItemMeta().getLore().get(0).equalsIgnoreCase("You have this balloon")){
				if(Balloons.BalloonsMap.containsKey(this.player)){
					Balloons.BalloonsMap.get(this.player).setItem(item);
				} else{
					new Balloons(this.player, item).spawn();
				}
			}else{
				this.player.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
			}
			this.player.closeInventory();
		}else{
			if(Balloons.BalloonsMap.containsKey(this.player)){
				Balloons.BalloonsMap.get(this.player).remove();
				this.player.closeInventory();
			}

		}
		event.setCancelled(true);
	}

	private void setItem(ItemStack item, int slot, String name, List<String> lore) {
		ItemMeta im = item.getItemMeta();
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,
				ItemFlag.HIDE_DESTROYS,
				ItemFlag.HIDE_ENCHANTS,
				ItemFlag.HIDE_PLACED_ON,
				ItemFlag.HIDE_POTION_EFFECTS,
				ItemFlag.HIDE_UNBREAKABLE);
		if (name != null) {
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		}
		if (lore != null) {
			List<String> converted = new ArrayList<>();
			for (String string : lore) {
				converted.add(ChatColor.translateAlternateColorCodes('&', string));
			}
			im.setLore(converted);
		}
		item.setItemMeta(im);
		this.inventory.setItem(slot, item);
	}

	public void openInv(){
		this.player.openInventory(this.inventory);
		this.create();
	}

	public void closeInv(){
		epicInventoryMap.remove(this.player, this);
	}

	public Inventory getInventory() {
		return this.inventory;
	}
}

