package de.zwibbltv.dreamland.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import de.zwibbltv.dreamland.commands.CMDachievements;
import de.zwibbltv.dreamland.commands.CMDaudio;
import de.zwibbltv.dreamland.commands.CMDbuild;
import de.zwibbltv.dreamland.commands.CMDfirework;
import de.zwibbltv.dreamland.commands.CMDgamemode;
import de.zwibbltv.dreamland.commands.CMDmenu;
import de.zwibbltv.dreamland.commands.CMDmute;
import de.zwibbltv.dreamland.commands.CMDrank;
import de.zwibbltv.dreamland.commands.CMDremovewarp;
import de.zwibbltv.dreamland.commands.CMDsetwarp;
import de.zwibbltv.dreamland.commands.CMDwarp;
import de.zwibbltv.dreamland.listener.JoinListener;
import de.zwibbltv.dreamland.listener.MenuListener;
import de.zwibbltv.dreamland.listener.PlayerListener;
import de.zwibbltv.dreamland.listener.scoreboardListener;
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
	
	public static Economy economy = null;
	
	public String prefix = "§e[Dreamland] ";
	
	int ScoreboardCoolDown = 0;
	
		
	@Override
	public void onEnable() {
		
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
		
		Bukkit.getScheduler().runTaskTimer(this, new Runnable() {

			@Override
		    public void run() {
		    	
		    	for(Player p : Bukkit.getOnlinePlayers()) {
		    		economy.depositPlayer(p, 0.01);
		    		
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
		
		setInstance(this);
		this.getCommand("setwarp").setExecutor(new CMDsetwarp());
		this.getCommand("warp").setExecutor(new CMDwarp());
		this.getCommand("removewarp").setExecutor(new CMDremovewarp());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new CMDmute(), this);
		pm.registerEvents(new scoreboardListener(), this);
		pm.registerEvents(new MenuListener(), this);
		pm.registerEvents(new PlayerListener(), this);
		
				
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
	
}
