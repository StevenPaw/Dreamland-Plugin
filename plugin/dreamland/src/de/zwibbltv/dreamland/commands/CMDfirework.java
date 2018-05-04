package de.zwibbltv.dreamland.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import de.zwibbltv.dreamland.main.Main;
import net.md_5.bungee.api.ChatColor;

public class CMDfirework implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("dreamland.firework") || p.hasPermission("Dreamland.*")) {
				if(args.length == 2) {
					Player target = Bukkit.getPlayer(args[0]);					
					if (target != null) {
						int Count = Integer.parseInt(args[1]);
						if (Count >= 1 && Count <=100) {
							for (int i = 1; i <= Count; i++) {
					            Firework fw = (Firework) target.getWorld().spawnEntity(target.getLocation(), EntityType.FIREWORK);
					            FireworkMeta fwm = fw.getFireworkMeta();
					            Random r = new Random();   
					            int rt = r.nextInt(4) + 1;
					            Type type = Type.BALL;       
					            if (rt == 1) type = Type.BALL;
					            if (rt == 2) type = Type.BALL_LARGE;
					            if (rt == 3) type = Type.BURST;
					            if (rt == 4) type = Type.CREEPER;
					            if (rt == 5) type = Type.STAR;
					            int r1i = r.nextInt(17) + 1;
					            int r2i = r.nextInt(17) + 1;
					            Color c1 = getColor(r1i);
					            Color c2 = getColor(r2i);
					            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
					            fwm.addEffect(effect);
					            fwm.setPower(0);
					            fw.setFireworkMeta(fwm);
							}
						}
						else
							p.sendMessage("Please use numbers between 1 and 100");
					}
				}
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);					
					if (target != null) {
						//Spawn the Firework, get the FireworkMeta.
			            Firework fw = (Firework) target.getWorld().spawnEntity(target.getLocation(), EntityType.FIREWORK);
			            FireworkMeta fwm = fw.getFireworkMeta();
			           
			            //Our random generator
			            Random r = new Random();   
			 
			            //Get the type
			            int rt = r.nextInt(4) + 1;
			            Type type = Type.BALL;       
			            if (rt == 1) type = Type.BALL;
			            if (rt == 2) type = Type.BALL_LARGE;
			            if (rt == 3) type = Type.BURST;
			            if (rt == 4) type = Type.CREEPER;
			            if (rt == 5) type = Type.STAR;
			           
			            //Get our random colours   
			            int r1i = r.nextInt(17) + 1;
			            int r2i = r.nextInt(17) + 1;
			            Color c1 = getColor(r1i);
			            Color c2 = getColor(r2i);
			           
			            //Create our effect with this
			            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
			           
			            //Then apply the effect to the meta
			            fwm.addEffect(effect);
			            fwm.setPower(0);
			           
			            //Then apply this to our rocket
			            fw.setFireworkMeta(fwm);
					}
				} else if(args.length == 0) {
						//Spawn the Firework, get the FireworkMeta.
			            Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
			            FireworkMeta fwm = fw.getFireworkMeta();
			            Random r = new Random();  //Random Generator
			            int rt = r.nextInt(4) + 1;
			            Type type = Type.BALL;       
			            if (rt == 1) type = Type.BALL;
			            if (rt == 2) type = Type.BALL_LARGE;
			            if (rt == 3) type = Type.BURST;
			            if (rt == 4) type = Type.CREEPER;
			            if (rt == 5) type = Type.STAR;
			            int r1i = r.nextInt(17) + 1;
			            int r2i = r.nextInt(17) + 1;
			            Color c1 = getColor(r1i);
			            Color c2 = getColor(r2i);
			            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
			            fwm.addEffect(effect);
			            fwm.setPower(0);
			            fw.setFireworkMeta(fwm);
					
				} else
					p.sendMessage("§cPlease use /firework <name>");
				
			} else
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.cfg.getString("noPerms")));
		} else {
		Player target = Bukkit.getPlayer(args[0]);
		if (target != null) {
			
			//Spawn the Firework, get the FireworkMeta.
            Firework fw = (Firework) target.getWorld().spawnEntity(target.getLocation(), EntityType.FIREWORK);
            FireworkMeta fwm = fw.getFireworkMeta();
           
            //Our random generator
            Random r = new Random();   
 
            //Get the type
            int rt = r.nextInt(4) + 1;
            Type type = Type.BALL;       
            if (rt == 1) type = Type.BALL;
            if (rt == 2) type = Type.BALL_LARGE;
            if (rt == 3) type = Type.BURST;
            if (rt == 4) type = Type.CREEPER;
            if (rt == 5) type = Type.STAR;
           
            //Get our random colours   
            int r1i = r.nextInt(17) + 1;
            int r2i = r.nextInt(17) + 1;
            Color c1 = getColor(r1i);
            Color c2 = getColor(r2i);
           
            //Create our effect with this
            FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
           
            //Then apply the effect to the meta
            fwm.addEffect(effect);
            fwm.setPower(0);
           
            //Then apply this to our rocket
            fw.setFireworkMeta(fwm);
			
			
			}
		}
		
		return false;
	}
	
	
	private Color getColor(int i) {
		Color c = null;
		if(i==1){
		c=Color.AQUA;
		}
		if(i==2){
		c=Color.BLACK;
		}
		if(i==3){
		c=Color.BLUE;
		}
		if(i==4){
		c=Color.FUCHSIA;
		}
		if(i==5){
		c=Color.GRAY;
		}
		if(i==6){
		c=Color.GREEN;
		}
		if(i==7){
		c=Color.LIME;
		}
		if(i==8){
		c=Color.MAROON;
		}
		if(i==9){
		c=Color.NAVY;
		}
		if(i==10){
		c=Color.OLIVE;
		}
		if(i==11){
		c=Color.ORANGE;
		}
		if(i==12){
		c=Color.PURPLE;
		}
		if(i==13){
		c=Color.RED;
		}
		if(i==14){
		c=Color.SILVER;
		}
		if(i==15){
		c=Color.TEAL;
		}
		if(i==16){
		c=Color.WHITE;
		}
		if(i==17){
		c=Color.YELLOW;
		}
		 
		return c;
		}
		 

	
}
