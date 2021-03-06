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

	private int id;
	private String player;
	private String date;
	private String message;
	
	/**
	 * Creates a new advertising with a free ID.
	 * @param player:
	 *   The player who created the advertising.
	 * @param date:
	 *   The date when the advertising was created.
	 *   Date format is configurable in config.
	 * @param message:
	 *   The message of the advertising.
	 */
	public Advertising(String player, String date, String message) {
		
		this.id = BillBoard.getFreeId();
		this.player = player;
		this.date = date;
		this.message = message;
		
	}
	
	/**
	 * Creates a new advertising with a free ID.
	 * The current date is used.
	 * @param player:
	 *   The player who created the advertising.
	 * @param message:
	 *   The message of the advertising.
	 */
	public Advertising(String player, String message) {
		
		this.id = BillBoard.getFreeId();
		this.player = player;
		this.date = (new SimpleDateFormat(Config.dateFormat).format(new Date()));
		this.message = message;
		
	}
	
	/**
	 * Returns the id of the advertising.
	 * @return:
	 *   The id.
	 */
	public int getId() {
		
		return id;
		
	}
	
	/**
	 * Returns the player who created the advertising.
	 * @return:
	 *   The player.
	 */
	public String getPlayer() {
		
		return player;
		
	}
	
	/**
	 * Returns the date when the advertising was created;
	 * @return:
	 *   The date.
	 */
	public String getDate() {
		
		return date;
		
	}
	
	/**
	 * Returns the message of this advertising.
	 * @return:
	 *   The message.
	 */
	public String getMessage() {
		
		return message;
		
	}
	
}
