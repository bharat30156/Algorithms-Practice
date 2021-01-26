package StringsAlgorithm;

/**
 * 
 * @author Bharat
 *
 */

public class CharacterSame {
	public static void main(String[] args)
	{
		assert isAllCharactersSame("");
	    assert !isAllCharactersSame("aab");
	    assert isAllCharactersSame("aaa");
	    assert isAllCharactersSame("11111");
	}
	
	/**
	 * check if all the character of a String are same 
	 * 
	 * 
	 * 
	 * @param s the String to check 
	 * @return {@code true} if all characters of a String are same, otherwise {@code false}
	 */
	
	public static boolean isAllCharactersSame(String s)
	{
		for(int i = 1, length = s.length(); i < s.length(); i++)
		{
			if(s.charAt(i) != s.charAt(0))
			{
				
				return false;
			}
		}
		
		return true;
	}
}
