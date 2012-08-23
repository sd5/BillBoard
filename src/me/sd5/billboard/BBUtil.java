package me.sd5.billboard;

import java.util.List;

/**
 * 
 * @author sd5
 * 
 * This class contains some
 * useful methods.
 *
 */
public class BBUtil {

	/**
	 * Converts an array to a String.
	 * @param array:
	 *   The array.
	 * @return:
	 *   The String.
	 */
	public static String listToString(List<String> list) {
		
		String text = null;
		
		for(String s : list) {
			text += s;
			text += " ";
		}
		
		return text;
		
	}
	
}
