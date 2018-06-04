package de.zwibbltv.dreamland.listener;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.zwibbltv.dreamland.main.Main;

public class BalloonListener implements Listener {
	
	@EventHandler
	public void LeashEvent (PlayerLeashEntityEvent e) {
		
		if(e.getEntity() instanceof Sheep) {
			Player p = e.getPlayer();
			final Sheep s = (Sheep) e.getEntity();
			s.setLeashHolder(p);
			new BukkitRunnable() {
				@SuppressWarnings("deprecation")
				public void run() {
					if((!s.isDead()) && (s.isLeashed())) {
						Vector vec = s.getVelocity();
						s.setVelocity(new Vector(vec.getX(), 0.3D, vec.getZ()));
						s.setFallDistance(0);
						if (s.getLocation().getY() > 300.0D) {
							s.setLeashHolder(null);
						}
					} else if ((s.isDead() || (s.getLocation().getY() > 300.0D))) {
						cancel();
						if (!(s.isDead())) {
							Location loc = s.getLocation();
							loc.getWorld().createExplosion(loc, 2.0F);
							loc.getWorld().playEffect(loc, Effect.SLIME, 10);
						}
					} else {
						Vector vec = s.getVelocity();
						s.setVelocity(new Vector(vec.getX(), 0.2D, vec.getZ()));
						s.setFallDistance(0);
					}
				}
			}.runTaskTimer(Main.getInstance(), 2L, 2L);
		}
		
	}

}
