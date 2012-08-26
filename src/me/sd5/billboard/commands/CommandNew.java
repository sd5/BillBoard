package me.sd5.billboard.commands;

import java.util.Arrays;
import java.util.List;

import me.sd5.billboard.Advertising;
import me.sd5.billboard.BBMain;
import me.sd5.billboard.BBUtil;
import me.sd5.billboard.BillBoard;
import me.sd5.billboard.Config;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CommandNew extends BaseCommand {

	/**
	 * Creates a new command.
	 */
	public CommandNew() {
		
		super("new", Arrays.asList(new String[] {"add", "create"}), new Permission("billboard.new"));
		
	}

	/**
	 * Writes a new advertising to the billboard.
	 */
	@Override
	public void execute(Player player, List<String> args) {
		
		Advertising advertising = new Advertising(player.getName(), BBUtil.listToString(args));
		if(BillBoard.add(advertising)) {
			player.sendMessage(BBMain.chatName + "Pinned advertisement on billboard!");
			player.sendMessage(ChatColor.GREEN + "You have " + ChatColor.RED + BillBoard.get(player.getName()).size() + ChatColor.GREEN + " advertisements on the billboard now.");
		} else {
			player.sendMessage(BBMain.chatName + "Couldn't add advertisement to billboard.");
			player.sendMessage(ChatColor.GREEN + "You can't pin more than " + ChatColor.RED + Config.maxPlayerAdvertising + ChatColor.GREEN + " advertisements on the billboard.");
		}
		
	}

}
