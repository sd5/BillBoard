package me.sd5.billboard.commands;

import java.util.Arrays;

import me.sd5.billboard.Advertising;
import me.sd5.billboard.BBUtil;
import me.sd5.billboard.BillBoard;

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
	public void execute(Player player, String[] args) {
		
		Advertising advertising = new Advertising(player.getName(), BBUtil.arrayToString(args));
		BillBoard.add(advertising);
		
	}

}
