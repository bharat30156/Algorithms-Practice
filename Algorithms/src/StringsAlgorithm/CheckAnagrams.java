package StringsAlgorithm;

import java.util.Arrays;

/**
 * 
 * @author Bharat
 * 
 * Two Strings are anagrams if they are made of the same letters arranged differently (ignoring
 * the case)   
 *
 */

public class CheckAnagrams {
	public static void main(String[] args)
	{
		 assert isAnagrams("Silent", "Listen");
		 assert isAnagrams("This is a string", "Is this a string");
		 assert !isAnagrams("There", "Their");
	}
	
	/**
	 * check if two Strings are anagrams or not
	 * 
	 *  @param S1 the first String 
	 *  @param S2 the second String
	 *  @return {@code true} if two String are anagrams, Otherwise {@code false}
	 */
	
	public static boolean isAnagrams(String s1, String s2)
	{
		s1 = s1.toLowerCase();
		s1 = s1.toLowerCase();
		char[] values1 = s1.toCharArray();
		char[] values2 = s2.toCharArray();
		Arrays.sort(values1);
		Arrays.sort(values2);
		return new String(values1).equals(new String(values2));
	}
}
