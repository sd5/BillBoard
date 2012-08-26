package me.sd5.billboard;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import me.sd5.billboard.commands.BaseCommand;
import me.sd5.billboard.commands.CommandClear;
import me.sd5.billboard.commands.CommandList;
import me.sd5.billboard.commands.CommandNew;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author sd5
 * 
 * The main class of this project.
 *
 */
public class BBMain extends JavaPlugin {

	public static List<BaseCommand> commands;
	public static String chatName = ChatColor.RED + "[" + ChatColor.YELLOW + "Billboard" + ChatColor.RED + "] " + ChatColor.BLUE;
	public static BBMain p;
	
	@Override
	public void onEnable() {
	
		p = this;
		
		//Load config from hard disk.
		Config.load();
		
		//Register commands.
		commands = new ArrayList<BaseCommand>();
		commands.add(new CommandClear());
		commands.add(new CommandList());
		commands.add(new CommandNew());
		
		//Connect to database.
		MySQLManager.connect();
		
		if(MySQLManager.isConnected()) {
			BillBoard.load();
		} else {
			Bukkit.getLogger().log(Level.SEVERE, "Disabling plugin!");
			Bukkit.getPluginManager().disablePlugin(this);
		}
		
	}
	
	@Override
	public void onDisable() {
		
		//Disconnect from database.
		MySQLManager.disconnect();
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			for(BaseCommand c : commands) {
				if(c.getAliases().contains(args[0])) {
					c.execute((Player) sender, BBUtil.getCommandArguments(args));
				}
			}
			
		} else {
			sender.sendMessage(ChatColor.RED + "This command command can only be executed by players!");
		}
		
		return true;
		
	}
	
}
