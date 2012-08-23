package me.sd5.billboard;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sd5
 * 
 * This class represents
 * the billboard where the
 * advertisement will be
 * pinned on. Every player
 * can see the billboard
 * with "/bb show"
 *
 */
public class BillBoard {

	private static List<Advertising> board = new ArrayList<Advertising>();
	
	/**
	 * Loads the billboard from the database.
	 */
	public static void load() {
		
		board = MySQLManager.getBillboard();
		
	}
	
	/**
	 * Adds an advertising to the billboard.
	 * @param advertising:
	 *   The advertising to add.
	 */
	public static void add(Advertising advertising) {
		
		board.add(0, advertising);
		
		if(board.size() > Config.maxBillboardLength) {
			board.remove(board.size() - 1);
		}
		
		MySQLManager.saveBillboard(board);
		
	}
	
}
