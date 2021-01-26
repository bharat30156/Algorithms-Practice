package StringsAlgorithm;

/**
 * 
 * @author Bharat
 * 
 * Alphabetical order is a system whereby character Strings are placed in order based on the 
 * position of the character in the conventional ordering of an alphabet.
 *
 */

class Alphabetical {
	public static void main (String[] args)
	{
		assert !isAlphabetical("123abc");
	    assert isAlphabetical("aBC");
	    assert isAlphabetical("abc");
	    assert !isAlphabetical("xyzabc");
	    assert isAlphabetical("abcxyz");
	}
	
	/**
	 * Check if String is alphabetical order or not 
	 * 
	 * @param s a String
	 * @return {@code true} if given String is aplhabetical order otherwise {@code false}
	 * 
	 */
	
	public static boolean isAlphabetical(String s)
	{
		s = s.toLowerCase();
		for(int i = 0; i < s.length() - 1; i++)
		{
			if(!Character.isLetter(s.charAt(i)) || !(s.charAt(i) <= s.charAt(i + 1)))
			{
				return false;
			}
		}
		return true;
	}

}
