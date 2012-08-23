package me.sd5.billboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
	
	/**
	 * Connects to the database.
	 * The MySQL settings can be changed
	 * in the config.
	 */
	public static void connect() {
		
		try {
			String url = "jdbc:mysql://" + Config.mySqlHost + ":" + Config.mySqlPort + "/" + Config.mySqlDatabase;
			connection = DriverManager.getConnection(url, Config.mySqlUsername, Config.mySqlPassword);
		} catch(SQLException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not connect to database!");
			Bukkit.getLogger().log(Level.SEVERE, "Check database settings in config!");
		}
		
	}
	
	/**
	 * Disconnects from the database.
	 */
	public static void disconnect() {
		
		try {
			connection.close();
		} catch (SQLException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not disconnect from database!");
		}
		
	}
	
	/**
	 * Loads the billboard from the database
	 * and returns it as a List of Advertising.
	 * @return:
	 *   A List of Advertising.
	 */
	public static List<Advertising> getBillboard() {
		
		List<Advertising> billboard = new ArrayList<Advertising>();
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM " + Config.mySqlTable);
			
			while(result.next()) {
				String player = result.getString(1);
				String date = result.getString(2);
				String message = result.getString(3);
				billboard.add(new Advertising(player, date, message));
			}
		} catch(SQLException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not load billboard from database!");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return billboard;
		
	}
	
	/**
	 * Saves the billboard to the database.
	 * @param billboard:
	 *   The billboard.
	 */
	public static void saveBillboard(List<Advertising> billboard) {
		
		Statement statement = null;
		try {
			statement = connection.createStatement();
			
			String sql1 = "TRUNCATE TABLE " + Config.mySqlTable;
			statement.executeUpdate(sql1);
			
			for(Advertising a : billboard) {
				String sql2 = "INSERT INTO " + Config.mySqlTable + " (";
				sql2 += "player, date, message";
				sql2 += ") VALUES (";
				sql2 += "'" + a.getPlayer() + "', '" + a.getDate() + "', '" + a.getMessage() + "')";
				statement.executeUpdate(sql2);
			}
		} catch(SQLException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not save billboard to database!");
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
