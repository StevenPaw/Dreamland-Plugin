package de.zwibbltv.dreamland.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import de.zwibbltv.dreamland.commands.CMDbuild;
import de.zwibbltv.dreamland.commands.CMDgamemode;
import de.zwibbltv.dreamland.commands.CMDheal;
import de.zwibbltv.dreamland.commands.CMDkit;
import de.zwibbltv.dreamland.commands.CMDmute;
import de.zwibbltv.dreamland.commands.CMDsetspawn;
import de.zwibbltv.dreamland.commands.CMDspawn;
import de.zwibbltv.dreamland.listener.JoinListener;
import de.zwibbltv.dreamland.listener.MenuListener;
import de.zwibbltv.dreamland.listener.scoreboardListener;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {
	
	private static Main plugin;
	public static Economy economy = null;
	
	public String prefix = "§e[Dreamland] ";
	
	@Override
	public void onEnable() {		
		plugin = this;
		this.setupEconomy();
		
	Bukkit.getConsoleSender().sendMessage(prefix + "§a§lerfolgreich gestartet!");
	
		getCommand("heal").setExecutor(new CMDheal());
		getCommand("kit").setExecutor(new CMDkit());
		getCommand("setspawn").setExecutor(new CMDsetspawn());
		getCommand("spawn").setExecutor(new CMDspawn());
		getCommand("mute").setExecutor(new CMDmute());
		getCommand("gm").setExecutor(new CMDgamemode());
		getCommand("build").setExecutor(new CMDbuild());
		
		PluginManager pm = Bukkit.getPluginManager();	
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new CMDmute(), this);
		pm.registerEvents(new scoreboardListener(), this);
		pm.registerEvents(new MenuListener(), this);
		
		if(setupEconomy()) {
			Bukkit.getConsoleSender().sendMessage(prefix + "§aerfolgreich mit Vault verbunden!");
		} else {
			Bukkit.getConsoleSender().sendMessage(prefix + "§ckonnte nicht mit Vault verbunden werden!");
		}
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(prefix + "§c§lerfolgreich gestoppt!");
		
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
