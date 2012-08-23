package me.sd5.billboard;

import java.util.ArrayList;
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
	
	/**
	 * Converts the arguments array of the
	 * onCommand() to a list without the
	 * command argument.
	 * @param args:
	 *   The array.
	 * @return:
	 *   The list.
	 */
	public static List<String> getCommandArguments(String[] args) {
		
		List<String> arguments = new ArrayList<String>();
		
		for(String s : args) {
			arguments.add(s);
		}
		arguments.remove(0);
		
		return arguments;
		
	}
	
}
