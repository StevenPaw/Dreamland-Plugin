package de.zwibbltv.dreamland.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.zwibbltv.dreamland.main.Main;
import de.zwibbltv.dreamland.utils.Achievements;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PlayerListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Block block = event.getClickedBlock();
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			List<Material> forbidden = new ArrayList<Material>();
			if(PlayerConfig.getBuilder(p) == false) {
				if(!p.hasPermission("dreamland.useBlocks") || !p.hasPermission("dreamland.*")) {
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
					forbidden.add(Material.HOPPER);
					forbidden.add(Material.BED);
					forbidden.add(Material.BED_BLOCK);

					for (Material f: forbidden) {
						if(block.getType() == f) {
							event.setCancelled(true);
						}				
					}
				}
			}
		}

		if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			List<Material> forbidden = new ArrayList<Material>();
			if(PlayerConfig.getBuilder(p) == false) {
				if(!p.hasPermission("dreamland.useBlocks") || !p.hasPermission("dreamland.*")) {				
					if (!p.hasPermission("dreamland.VIP")) {
						forbidden.add(Material.LEVER);
					}

					for (Material f: forbidden) {
						if(block.getType() == f) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("VIP")));
							event.setCancelled(true);
						}				
					}
				}
			}
		}
	}

	//Armorstand Schutz
	@EventHandler
	public void onPlayerArmorStandManipulateEvent(PlayerArmorStandManipulateEvent e) {
		Player p = e.getPlayer();
		if(PlayerConfig.getBuilder(p) == false) {
			if(!p.hasPermission("dreamland.useBlocks") || !p.hasPermission("dreamland.*")) {
				e.setCancelled(true);
			}
		}
	}

	//Prevent Itemframe Rotation
	@EventHandler
	public void onPlayerEntityInteract(PlayerInteractEntityEvent event)
	{
		if(
				!event.isCancelled()
				&& event.getRightClicked() instanceof ItemFrame
				&& !((ItemFrame)event.getRightClicked()).getItem().getType().equals(Material.AIR)
				&& !event.getPlayer().hasPermission("dreamland.Itemframes.rotate")
				&& !event.getPlayer().hasPermission("dreamland.*")
				&& !event.getPlayer().hasPermission("dreamland.Itemframes.*")
				)
		{
			event.setCancelled(true);
		}
	}

	//Prevent Itemframe destroy
	@EventHandler
	public void onHangingBreakByEntity(HangingBreakByEntityEvent event) 
	{
		if (event.getRemover() instanceof Player) 
		{
			Player p = (Player)event.getRemover();
			if (!p.hasPermission("dreamland.Itemframes.destroy") && !p.hasPermission("dreamland.*") && !p.hasPermission("dreamland.Itemframes.*"))
			{
				if (!event.isCancelled()) {
					event.setCancelled(true);
				}
			}
		}
	}

	//Prevent Itemframe Item removal
	@EventHandler
	public void itemFrameItemRemoval(EntityDamageEvent event) {
		if (event.getEntity() instanceof ItemFrame) {
			if (event instanceof EntityDamageByEntityEvent) {
				EntityDamageByEntityEvent edbeEvent = (EntityDamageByEntityEvent)event;
				Entity damager = edbeEvent.getDamager();
				if (damager instanceof Player)
				{
					Player p = (Player)damager;
					if (!p.hasPermission("dreamland.Itemframes.empty") && !p.hasPermission("dreamland.*") && !p.hasPermission("dreamland.Itemframes.*"))
					{
						if (!event.isCancelled()) {
							event.setCancelled(true);
						}
					}
				}
				else
				{
					if (!event.isCancelled()) {
						event.setCancelled(true);
					}
				}
			}
		}
	}

	//Prevent Hunger
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

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		PlayerConfig.giveAchievement(p, Achievements.FIRSTMOVE);
		de.zwibbltv.dreamland.viponly.places.locations(p);

		if (PlayerConfig.getBuilder(p) == false) {
			if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BRICK) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 1));	
			}
		}			
		if(p.getLocation().getBlock().getRelative(BlockFace.SELF).getType() == Material.WATER || p.getLocation().getBlock().getRelative(BlockFace.SELF).getType() == Material.STATIONARY_WATER) {
			PlayerConfig.giveAchievement(p.getPlayer(), Achievements.WATER);			
		}

		World world = Bukkit.getServer().getWorld("dreamland");
		for (Entity e : world.getEntities()) {
			if (e instanceof Villager) {
				if(e.getCustomName() != null) {
					((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300000, 300000, false, false));
					((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300000, 300000, false, false));
					((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300000, 300000, false, false));
				}
			}
		}

		if(PlayerConfig.getResourcepack(p) != true && PlayerConfig.getRuntime(p) >= 1)
		{
			p.sendMessage("Sending Resourcepack");
			p.setResourcePack("https://www.dropbox.com/s/ckul9g6yg7bi7il/Dreamland06-05-18.zip?dl=1");
			try {
				PlayerConfig.Resourcepackactive(p, true);
			} catch (IOException error) {
				error.printStackTrace();
			}
		}

		int a = PlayerConfig.getRuntime(p);

		if (p.getStatistic(Statistic.WALK_ONE_CM) >= 100000)
			PlayerConfig.giveAchievement(p.getPlayer(), Achievements.RUNAKM);

		try {
			PlayerConfig.Runtime(p, a + 1);
		} catch (IOException error) {
			error.printStackTrace();
		}			
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPickupItem(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		ItemStack item = e.getItem().getItemStack();
		Material ItemType = item.getType();
		Material ItemType2 = item.getType();
		Material ItemType3 = item.getType();
		if((ItemType == Material.GOLD_INGOT) || (ItemType2 == Material.GOLD_NUGGET ) || (ItemType3 == Material.GOLD_BLOCK)) {
			if(de.zwibbltv.dreamland.utils.AFK.isAFK.containsKey(p.getName())) {
				if(de.zwibbltv.dreamland.utils.AFK.isAFK.get(p.getName()).equals(false)) {
					int f = item.getAmount();
					for(int i = 0; i < f; i++) {

						if((ItemType == Material.GOLD_NUGGET)) {
							Main.economy.depositPlayer(p.getName(), 0.1);
						}

						if((ItemType == Material.GOLD_INGOT)) {
							Main.economy.depositPlayer(p.getName(), 0.3);
						}

						if((ItemType == Material.GOLD_BLOCK)) {
							Main.economy.depositPlayer(p.getName(), 0.5);
						}
						de.zwibbltv.dreamland.main.updateScoreboard.update(p);
					}		
					e.getItem().remove();
				}
			}else {
				de.zwibbltv.dreamland.utils.AFK.isAFK.put(p.getName(), false);
			}
			e.setCancelled(true);
		}		
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		PlayerConfig.giveAchievement(e.getPlayer(), Achievements.FIRSTCHAT);
		String prefix = PermissionsEx.getUser(e.getPlayer()).getPrefix();
		e.setFormat(prefix + " %s: %s");
	}
}
