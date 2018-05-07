package de.zwibbltv.dreamland.listener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
//import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.zwibbltv.dreamland.utils.Achievements;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import net.md_5.bungee.api.ChatColor;
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
			
			for (Material f: forbidden)
			{
				if(block.getType() == f) {
					p.sendMessage(ChatColor.GRAY + "No!");
					event.setCancelled(true);			

				}				
						
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onVClick(PlayerInteractEntityEvent e){
	if(e.getRightClicked() instanceof Villager) {
		e.setCancelled(true);
		}
	}
		
	
	//Entity Schutz
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent event) {
		
		
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
		if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BRICK) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 1));		
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
		
		if (PlayerConfig.getRuntime(p) >= 4250)
			PlayerConfig.giveAchievement(p.getPlayer(), Achievements.RUNAKM);
		
		try {
			PlayerConfig.Runtime(p, a + 1);
		} catch (IOException error) {
			error.printStackTrace();
		}		
	}
		
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
		PlayerConfig.giveAchievement(e.getPlayer(), Achievements.FIRSTCHAT);
		String prefix = PermissionsEx.getUser(e.getPlayer()).getPrefix();
        e.setFormat(prefix + " %s: %s");
    }
}
