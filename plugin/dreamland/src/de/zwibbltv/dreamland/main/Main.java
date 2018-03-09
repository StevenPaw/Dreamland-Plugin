package de.zwibbltv.dreamland.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import de.zwibbltv.dreamland.commands.CMDbuild;
import de.zwibbltv.dreamland.commands.CMDgamemode;
import de.zwibbltv.dreamland.commands.CMDheal;
import de.zwibbltv.dreamland.commands.CMDkit;
import de.zwibbltv.dreamland.commands.CMDmute;
import de.zwibbltv.dreamland.commands.CMDremovewarp;
import de.zwibbltv.dreamland.commands.CMDsetspawn;
import de.zwibbltv.dreamland.commands.CMDsetwarp;
import de.zwibbltv.dreamland.commands.CMDspawn;
import de.zwibbltv.dreamland.commands.CMDwarp;
import de.zwibbltv.dreamland.listener.JoinListener;
import de.zwibbltv.dreamland.listener.MenuListener;
import de.zwibbltv.dreamland.listener.scoreboardListener;
import de.zwibbltv.dreamland.utils.WarpManager;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	private static Main plugin;

	public static String getNoPerms() {
		return noPerms;
	}
	
	public static Main getInstance() {
		return instance;
	}

	public static void setInstance(Main instance) {
		Main.instance = instance;
	}
	private static String noPerms = "�cYou may not use this command";
	private static Main instance;
	
	public static Economy economy = null;
	
	public String prefix = "�e[Dreamland] ";
	
	@Override
	public void onEnable() {
		setInstance(this);
		
		plugin = this;
		this.setupEconomy();
		
		Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
		    @Override
		    public void run() {
		    	
		    	for(Player p : Bukkit.getOnlinePlayers()) {
		    		de.zwibbltv.dreamland.main.updateScoreboard.update(p);
		        }
		        
		    }
		}, 20l, 20l);
		
	Bukkit.getConsoleSender().sendMessage(prefix + "�a�lerfolgreich gestartet!");
	
		getCommand("heal").setExecutor(new CMDheal());
		getCommand("kit").setExecutor(new CMDkit());
		getCommand("setspawn").setExecutor(new CMDsetspawn());
		getCommand("spawn").setExecutor(new CMDspawn());
		getCommand("mute").setExecutor(new CMDmute());
		getCommand("gm").setExecutor(new CMDgamemode());
		getCommand("build").setExecutor(new CMDbuild());
		
		setInstance(this);
		this.getCommand("setwarp").setExecutor(new CMDsetwarp());
		this.getCommand("warp").setExecutor(new CMDwarp());
		this.getCommand("removewarp").setExecutor(new CMDremovewarp());
		
		PluginManager pm = Bukkit.getPluginManager();	
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new CMDmute(), this);
		pm.registerEvents(new scoreboardListener(), this);
		pm.registerEvents(new MenuListener(), this);
		
				
		if(setupEconomy()) {
			Bukkit.getConsoleSender().sendMessage(prefix + "�aerfolgreich mit Vault verbunden!");
		} else {
			Bukkit.getConsoleSender().sendMessage(prefix + "�ckonnte nicht mit Vault verbunden werden!");
		}
	}
	
	public WarpManager getWarpManager() {
		return new WarpManager();
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(prefix + "�c�lerfolgreich gestoppt!");
		
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
	 
}
