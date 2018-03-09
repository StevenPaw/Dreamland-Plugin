package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutChat;

public class CMDyt implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(cmd.getName().equalsIgnoreCase("yt")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				String json = "{text:\"Visit our website: \",extra:[{text:\"*click*\",color:orange,clickEvent:{action:open_url,value:\"www.bukkit.org\"}}]}";
				PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a(json));
				((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
				
			} else
				sender.sendMessage("§cYou are no player");
		}
		
		return false;
	}
	
	

}
