package de.zwibbltv.dreamland.main;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack item;
	private ItemMeta itemMeta;
	
	public ItemBuilder(Material material) {
		item = new ItemStack(material);
		itemMeta = item.getItemMeta();
	}
	
	public ItemBuilder(Material material, short subID) {
		item = new ItemStack(material, 1, subID);
		itemMeta = item.getItemMeta();
	}

	public ItemBuilder setDisplayName(String name) {
		itemMeta.setDisplayName(name);
		return this;
	}
	
	public ItemStack build() {
		item.setItemMeta(itemMeta);
		return item;
	}
	
}
