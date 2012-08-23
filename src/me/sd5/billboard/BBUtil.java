package me.sd5.billboard;

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
	public static String arrayToString(Object[] array) {
		
		String text = null;
		
		for(Object o : array) {
			text += o.toString();
			text += " ";
		}
		
		return text;
		
	}
	
}
