package de.zwibbltv.dreamland.listener;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.zwibbltv.dreamland.utils.Achievements;
import de.zwibbltv.dreamland.utils.PlayerConfig;
import net.minecraft.server.v1_12_R1.ChatComponentText;
import net.minecraft.server.v1_12_R1.IChatBaseComponent;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_12_R1.PlayerConnection;

public class JoinListener implements Listener {


	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		de.zwibbltv.dreamland.listener.MenuListener.resetInventory(p.getPlayer());
		if(PlayerConfig.getBuilder(p) == true) {
			p.setGameMode(GameMode.CREATIVE);
		}
		e.setJoinMessage("§6>> §a" + p.getName() + " §6>>");
		p.sendMessage("§aWelcome to the Dreamland Themepark Server!");
		sendTitle(p, "Welcome to Dreamland!", "Have a lot of fun!", 1, 80, 10);		//sendTitle(Spieler, Titel, Untertitel, FadeIn, Stay, FadeOut);
		p.setGameMode(GameMode.ADVENTURE); //Gamemode setzen
		p.performCommand("audio"); //Audiolink generieren
		if(!p.hasPermission("dreamland.*") && !p.hasPermission("dreamland.join")) {
			p.performCommand("warp spawn");
		}
		de.zwibbltv.dreamland.main.updateScoreboard.update(p);

		//reset runtime
		try {
			PlayerConfig.Runtime(p, 0);
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

	public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
		CraftPlayer craftplayer = (CraftPlayer) player;
		PlayerConnection connection = craftplayer.getHandle().playerConnection;
		IChatBaseComponent titleJSON = new ChatComponentText(ChatColor.GOLD + title);
		IChatBaseComponent subtitleJSON = new ChatComponentText(ChatColor.GOLD + subtitle);
		PacketPlayOutTitle timer = new PacketPlayOutTitle(fadeIn, stay, fadeOut);
		connection.sendPacket(timer);
		PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleJSON);
		PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, subtitleJSON);
		connection.sendPacket(titlePacket);
		connection.sendPacket(subtitlePacket);
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e)	{
		Player p = e.getPlayer();
    	de.zwibbltv.dreamland.main.updateScoreboard.update(p);
		try {
			PlayerConfig.Resourcepackactive(p, false);
		} catch (IOException error) {
			error.printStackTrace();
		}
		e.setQuitMessage("§7<< §4" + p.getName() + " §7<<");	
		if(!p.hasPermission("dreamland.build.*") ) {
			try {
				PlayerConfig.setBuilder(p, false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@EventHandler
	public void onPlayerFirstJoin(PlayerJoinEvent e) 
	{
		Player p = e.getPlayer();
		if(!p.hasPlayedBefore()) 
		{
			p.performCommand("warp spawn");
			Bukkit.broadcastMessage("");
			Bukkit.broadcastMessage("§aPlease all welcome §6" + p.getName() + "§a! Enjoy your visit at §6Dreamland Themepark§a!");
			Bukkit.broadcastMessage("");
			p.sendMessage("Use /audio to get the full Audio experience in the park");
			PlayerConfig.giveAchievement(p.getPlayer(), Achievements.FIRSTJOIN);

			//reset runtime
			try {
				PlayerConfig.Runtime(p, 0);
			} catch (IOException error) {
				error.printStackTrace();
			}

		}
	}

}
