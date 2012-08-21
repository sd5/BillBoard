package me.sd5.billboard;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * 
 * @author sd5
 * 
 * The config contains all
 * changeable settings.
 * Loads/Saves from/to
 * the config file on the hard disk.
 *
 */
public class Config {

	private static FileConfiguration config;
	private static File configFile;
	
	public static int maxBillboardLength;
	public static String dateFormat;
	
	/**
	 * Loads the config from the hard disk.
	 */
	public static void load() {
		
		if(configFile == null) {
			configFile = new File(BBMain.p.getDataFolder(), "config.yml");
			if(! (configFile.exists())) {
				Bukkit.getLogger().log(Level.INFO, "Config doesn't exist. Creating new one with default values.");
			}
		}
		config = YamlConfiguration.loadConfiguration(configFile);
		
		//Look for defaults in the jar.
		InputStream is = BBMain.p.getResource("config.yml");
		if(is != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(is);
			config.setDefaults(defaultConfig);
			config.options().copyDefaults(true);
		}
		
		save();
		
		//Load values from config.
		ConfigurationSection settings = config.getConfigurationSection("settings");
		maxBillboardLength = settings.getInt("max-billboard-length");
		dateFormat = settings.getString("date-format");
		
	}
	
	/**
	 * Saves the config to the hard disk.
	 */
	public static void save() {
		
		if(config == null || configFile == null) {
			return;
		}
		
		try {
			config.save(configFile);
		} catch(IOException e) {
			Bukkit.getLogger().log(Level.SEVERE, "Could not save config to " + configFile, e);
		}
		
	}
	
}
