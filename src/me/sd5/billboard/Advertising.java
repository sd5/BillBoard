package me.sd5.billboard;

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
	
}
