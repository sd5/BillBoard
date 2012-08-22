package me.sd5.billboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import org.bukkit.Bukkit;

/**
 * 
 * @author sd5
 * 
 * This class manages the MySQL database.
 * It can save and load the billboard to
 * the database.
 *
 */
public class MySQLManager {

	private static Connection connection;
	
	public static void connect() {
		
		try {
			String url = "jdbc:mysql://" + Config.mySqlHost + ":" + Config.mySqlPort + "/" + Config.mySqlDatabase;
			connection = DriverManager.getConnection(url, Config.mySqlUsername, Config.mySqlPassword);
		} catch(SQLException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not connect to database!");
			Bukkit.getLogger().log(Level.SEVERE, "Check database settings in config!");
		}
		
	}
	
}
