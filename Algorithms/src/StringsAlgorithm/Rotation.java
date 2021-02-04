package StringsAlgorithm;

/**
 * 
 * @author Bharat
 *
 */

/**
 * 
 * Given a String , moving several characters in front of the string to the end of the String for
 * example move the two characters 'a' and 'b' in front of the string "abcdef" to the end of the 
 * string so that the original string becomes the string "cdefab"
 */
public class Rotation {
	public static void main(String[] args)
	{
		assert rotation("abcdef", 2).equals("cdefab");
		
		char[] values = "abcdef".toCharArray();
		rotation(values, 2);
		assert new String(values).equals("cdefab");
	}
	
/**
 * Move {@code n} characters in front of given String to the end of string time complexity: O(n)
 * spcae complexity: O(n)
 * 
 * @param s given String 
 * @param n the total chracters to be moved
 * @return String after rotation
 */
	
	public static String rotation (String s, int n)
	{
		return s.substring(n) + s.substring(0, n);
	}
	
	/**
	 * Move {@code n} chracters in front of given chraracters array to the end of array times 
	 * complexity: O(n) space Complexity: O(1)
	 * 
	 * @param values given chracter array
	 * @param n the values total character to be moved 
	 */
	
	public static void rotation(char[] values,int n )
	{
		reverse(values, 0, n - 1);
		reverse(values, n, values.length - 1);
		reverse(values, 0, values.length - 1);
	}
	
	/**
	 * Reverse character array
	 * 
	 * @param values character array
	 * @param fornt begin index of begin array
	 * @param to end index of given array
	 */
	
	public static void reverse(char[] values, int from, int to)
	{
		while(from < to)
		{
			char temp = values[from];
			values[from] = values[to];
			values[to] =temp;
			from++;
			to--;
		}
	}
}
