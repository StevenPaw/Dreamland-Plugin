package de.zwibbltv.dreamland.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.zwibbltv.dreamland.utils.BalloonInventory;

public class CMDballoons implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
            new BalloonInventory((Player)sender).openInv();
            return true;
        }else{
            this.sendBalloon();
            return true;
        }
	}
	
	private void sendBalloon(){
        System.out.print(",,,,,,,,,,,,,,HHHHHH,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,HHHHHHHHHHH,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,HHHHHHHHHHHHHHH,,,,,,,,,,,,,,,");
        System.out.print(",,,,HHH,,,HHHHHHHHHHHH,,,,,,,,,,,,,,");
        System.out.print(",,,HH,,,,HHHHHHHHHHHHHH,,,,,,,,,,,,,");
        System.out.print(",HH,,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,");
        System.out.print(",HH,,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,");
        System.out.print("HHH,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,,");
        System.out.print("HHH,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,,");
        System.out.print("HHH,,,HHHHHHHHHHHHHHHHH,,,,,,,,,,,,,");
        System.out.print(",HHHHHHHHHHHHHHHHHHHHH,,,,,,,,,,,,,,");
        System.out.print(",,HHHHHHHHHHHHHHHHHHHH,,,,,,,,,,,,,,");
        System.out.print(",,,HHHHHHHHHHHHHHHHHH,,,,,,,,,,,,,,,");
        System.out.print(",,,,,HHHHHHHHHHHHHHHH,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,HHHHHHHHHHHHH,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,HHHHHHHHH,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,,,,,,,,,,,,,,H,,,,,,,,,,,,,,");
        System.out.print(",,,,,,,,Balloons by Dreamland,,,,,,,");
    }
}
