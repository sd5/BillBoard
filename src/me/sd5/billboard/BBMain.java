package me.sd5.billboard;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author sd5
 * 
 * The main class of this project.
 *
 */
public class BBMain extends JavaPlugin {

	public static BBMain p;
	
	@Override
	public void onEnable() {
	
		p = this;
		
		//Load config from hard disk.
		Config.load();
		
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
	
}
