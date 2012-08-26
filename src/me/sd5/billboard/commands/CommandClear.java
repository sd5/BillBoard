package me.sd5.billboard.commands;

import java.util.Arrays;
import java.util.List;

import me.sd5.billboard.BillBoard;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CommandClear extends BaseCommand {

	/**
	 * Creates a new command.
	 */
	public CommandClear() {
		
		super("clear", Arrays.asList(new String[] {"reset"}), new Permission("billboard.clear"));
		
	}

	/**
	 * Clears the billboard.
	 */
	@Override
	public void execute(Player player, List<String> args) {
		
		int size = BillBoard.size();
		if(BillBoard.clear()) {
			player.sendMessage(ChatColor.RED + "[" + ChatColor.YELLOW + "Billboard" + ChatColor.RED + "] " + ChatColor.BLUE + "Cleared billboard!");
			player.sendMessage(ChatColor.GREEN + "Removed " + ChatColor.RED + size + ChatColor.GREEN + " advertisements.");
		} else {
			player.sendMessage(ChatColor.RED + "[" + ChatColor.YELLOW + "Billboard" + ChatColor.RED + "] " + ChatColor.BLUE + "Billboard is already empty!");
		}
		
	}

}
