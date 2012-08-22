package me.sd5.billboard;

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
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
