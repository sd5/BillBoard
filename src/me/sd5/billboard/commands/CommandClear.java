package me.sd5.billboard.commands;

import java.util.Arrays;
import java.util.List;

import me.sd5.billboard.BillBoard;

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
		
		BillBoard.clear();
		
	}

}
