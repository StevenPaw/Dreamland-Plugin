package de.zwibbltv.dreamland.main;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import de.zwibbltv.dreamland.commands.CMDachievements;
import de.zwibbltv.dreamland.commands.CMDaudio;
import de.zwibbltv.dreamland.commands.CMDballoons;
import de.zwibbltv.dreamland.commands.CMDbuild;
import de.zwibbltv.dreamland.commands.CMDfirework;
import de.zwibbltv.dreamland.commands.CMDgamemode;
import de.zwibbltv.dreamland.commands.CMDlift;
import de.zwibbltv.dreamland.commands.CMDmenu;
import de.zwibbltv.dreamland.commands.CMDmute;
import de.zwibbltv.dreamland.commands.CMDrank;
import de.zwibbltv.dreamland.commands.CMDremovewarp;
import de.zwibbltv.dreamland.commands.CMDsetwarp;
import de.zwibbltv.dreamland.commands.CMDvillager;
import de.zwibbltv.dreamland.commands.CMDwarp;
import de.zwibbltv.dreamland.listener.BalloonEvents;
import de.zwibbltv.dreamland.listener.BalloonListener;
import de.zwibbltv.dreamland.listener.JoinListener;
import de.zwibbltv.dreamland.listener.MenuListener;
import de.zwibbltv.dreamland.listener.PlayerListener;
import de.zwibbltv.dreamland.listener.ShopListener;
import de.zwibbltv.dreamland.listener.scoreboardListener;
import de.zwibbltv.dreamland.nms.Reflection;
import de.zwibbltv.dreamland.utils.Achievements;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import de.zwibbltv.dreamland.utils.PlayerLocationLockedManager;
import de.zwibbltv.dreamland.utils.WarpManager;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
    
	
	private static Main plugin;
		
	public static Main getInstance() {
		return instance;
	}	

	public static void setInstance(Main instance) {
		Main.instance = instance;
	}
	private static Main instance;
	public String version;
	public static Economy economy = null;
	public String prefix = "§e[Dreamland] ";
	int ScoreboardCoolDown = 0;
	
	@Override
	public void onEnable() {
				
		instance = this;
        this.version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		
		saveDefaultConfig();
		Main.file = new File("plugins/Dreamland", "config.yml");
		Main.cfg = YamlConfiguration.loadConfiguration(Main.file);
		try {
			PlayerConfig.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setInstance(this);
		plugin = this;
		this.setupEconomy();
		
		
		//Goldbrunnen in Calico
		Bukkit.getScheduler().runTaskTimer(this, new Runnable() {

			@Override
			public void run() {
				Location loc = new Location(Bukkit.getWorld(getName()), -852, 20, 770);
	    		
	    		ItemStack random = null;
	    		
	    		Random r = new Random();
	    		int zufall = r.nextInt(6);
	    		switch(zufall) {
	    		case 0:
	    			int zufall0 = r.nextInt(3);
		    		switch(zufall0) {
		    		case 0:
		    			random = new ItemStack(Material.GOLD_NUGGET);
		    			break;
		    		case 1:
		    			random = new ItemStack(Material.GOLD_NUGGET, 2);
		    			break;
		    		case 2:
		    			random = new ItemStack(Material.GOLD_NUGGET, 3);
		    			break;
		    		}
		    		break;
	    		case 1:
	    			int zufall1 = r.nextInt(3);
		    		switch(zufall1) {
		    		case 0:
		    			random = new ItemStack(Material.GOLD_NUGGET);
		    			break;
		    		case 1:
		    			random = new ItemStack(Material.GOLD_NUGGET, 2);
		    			break;
		    		case 2:
		    			random = new ItemStack(Material.GOLD_NUGGET, 3);
		    			break;
		    		}
		    		break;
	    		case 2:
	    			int zufall2 = r.nextInt(3);
		    		switch(zufall2) {
		    		case 0:
		    			random = new ItemStack(Material.GOLD_NUGGET);
		    			break;
		    		case 1:
		    			random = new ItemStack(Material.GOLD_NUGGET, 2);
		    			break;
		    		case 2:
		    			random = new ItemStack(Material.GOLD_NUGGET, 3);
		    			break;
		    		}
		    		break;
	    		case 3:
	    			int zufall3 = r.nextInt(3);
		    		switch(zufall3) {
		    		case 0:
		    			random = new ItemStack(Material.GOLD_INGOT);
		    			break;
		    		case 1:
		    			random = new ItemStack(Material.GOLD_INGOT, 2);
		    			break;
		    		case 2:
		    			random = new ItemStack(Material.GOLD_INGOT, 3);
		    			break;
		    		}
		    		break;
	    		case 4:
	    			int zufall4 = r.nextInt(3);
		    		switch(zufall4) {
		    		case 0:
		    			random = new ItemStack(Material.GOLD_INGOT);
		    			break;
		    		case 1:
		    			random = new ItemStack(Material.GOLD_INGOT, 2);
		    			break;
		    		case 2:
		    			random = new ItemStack(Material.GOLD_INGOT, 3);
		    			break;
		    		}
		    		break;
	    		case 5:
	    			random = new ItemStack(Material.GOLD_BLOCK);		    					    		
		    		break;
	    			
	    		}
	    		
	    		
	    		loc.getWorld().dropItemNaturally(loc, random);
				
				
			}
		}, 20*5, 20*5);
		
		
		Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
			
			
			@SuppressWarnings("deprecation")
			@Override
		    public void run() {
					    	
		    	for(Player p : Bukkit.getOnlinePlayers()) {
		    		economy.depositPlayer(p, 0.01);
		    		
		    		Calendar c = Calendar.getInstance();
					
					if(c.getTime().getHours() <= 4) {
						PlayerConfig.giveAchievement(p.getPlayer(), Achievements.DREAMLANDBYNIGHT);
					}
		    				    		
		    		if(ScoreboardCoolDown>= 20) {
			    		de.zwibbltv.dreamland.main.updateScoreboard.update(p);
			    	}		    		
		        }
		    	ScoreboardCoolDown++;
		    }
		}, 20, 20);
		
	Bukkit.getConsoleSender().sendMessage(prefix + "§a§lenabled!");
	
		getCommand("mute").setExecutor(new CMDmute());
		getCommand("gm").setExecutor(new CMDgamemode());
		getCommand("build").setExecutor(new CMDbuild());
		getCommand("menu").setExecutor(new CMDmenu());
		getCommand("rank").setExecutor(new CMDrank());
		getCommand("audio").setExecutor(new CMDaudio());
		getCommand("ach").setExecutor(new CMDachievements());
		getCommand("firework").setExecutor(new CMDfirework());
		getCommand("villager").setExecutor(new CMDvillager());
		getCommand("lift").setExecutor(new CMDlift());
		
		setInstance(this);
		this.getCommand("setwarp").setExecutor(new CMDsetwarp());
		this.getCommand("warp").setExecutor(new CMDwarp());
		this.getCommand("removewarp").setExecutor(new CMDremovewarp());
		
		this.getCommand("balloons").setExecutor(new CMDballoons());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new CMDmute(), this);
		pm.registerEvents(new scoreboardListener(), this);
		pm.registerEvents(new MenuListener(), this);
		pm.registerEvents(new ShopListener(), this);
		pm.registerEvents(new PlayerListener(), this);
		pm.registerEvents(new BalloonListener(), this);
		pm.registerEvents(new BalloonEvents(), this);
		
				
		if(setupEconomy()) {
			Bukkit.getConsoleSender().sendMessage(prefix + "§aConnected with Vault!");
		} else {
			Bukkit.getConsoleSender().sendMessage(prefix + "§cCan't connect with Vault!");
		}
	}
	
	public WarpManager getWarpManager() {
		return new WarpManager();
	}
	
	public PlayerLocationLockedManager getplocManager() {
		return new PlayerLocationLockedManager();
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(prefix + "§c§ldisabled!");
		
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
		
	 private boolean setupEconomy()
	    {
	        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }
	 
	public static File file;
	public static FileConfiguration cfg;
	
	@SuppressWarnings("unused")
	private void registerEntities(){
        try{
            Reflection.getClass(Reflection.PackageType.BFB, "Registry").newInstance();
        }catch (IllegalAccessException |InstantiationException e){
            e.printStackTrace();
        }
    }
}
