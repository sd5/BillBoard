package me.sd5.billboard.commands;

import java.util.Collections;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

/**
 * 
 * @author sd5
 * 
 * This class represents a command.
 * It can be extended by other commands.
 * A command consists of it's name,
 * the aliases, a permission and the
 * code which is executed when the command
 * is called.
 *
 */
public abstract class BaseCommand {

	private String name;
	private List<String> aliases;
	private Permission permission;
	
	/**
	 * Creates a new command.
	 * @param name:
	 *   The name of the command (shown in help).
	 * @param aliases:
	 *   The aliases of the command (includes the name).
	 * @param permission:
	 *   The permission needed to perform the command.
	 */
	public BaseCommand(String name, List<String> aliases, Permission permission) {
		
		this.name = name;
		this.aliases = aliases;
		this.aliases.add(0, name);
		this.permission = permission;
		
	}
	
	/**
	 * The action that happens when a command is called.
	 * This method must be overwritten by the commands.
	 */
	public abstract void execute(Player player, String[] args);
	
	/**
	 * Returns the name of the command.
	 * @return:
	 *   The name of the command.
	 */
	public String getName() {
		
		return name;
		
	}
	
	/**
	 * Returns the aliases of the command.
	 * @return:
	 *   A unmodifiable List containing the
	 *   name and the aliases of the command.
	 */
	public List<String> getAliases() {
		
		return Collections.unmodifiableList(aliases);
		
	}
	
	/**
	 * Returns the permission needed to perform
	 * the command.
	 * @return:
	 *   The permission.
	 */
	public Permission getPermission() {
		
		return permission;
		
	}
	
}
