package me.sd5.billboard;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.sd5.billboard.Config;

/**
 * 
 * @author sd5
 * 
 * Represents an advertising
 * created by a player with
 * the command "/ad create"
 *
 */
public class Advertising {

	private String player;
	private String date;
	private String message;
	
	/**
	 * Creates a new advertising.
	 * @param player:
	 *   The player who created the advertising.
	 * @param date:
	 *   The date when the advertising was created.
	 *   Date format is configurable in config.
	 * @param message:
	 *   The message of the advertising.
	 */
	public Advertising(String player, String date, String message) {
		
		this.player = player;
		this.date = date;
		this.message = message;
		
	}
	
	/**
	 * Creates a new advertising.
	 * The current date is used.
	 * @param player:
	 *   The player who created the advertising.
	 * @param message:
	 *   The message of the advertising.
	 */
	public Advertising(String player, String message) {
		
		this.player = player;
		this.date = (new SimpleDateFormat(Config.dateFormat).format(new Date()));
		this.message = message;
		
	}
	
}
