package StringsAlgorithm;

public class Pangram {
	/**
	 * Driver Code
	 */
	public static void main(String[] args)
	{
		assert isPanagram("The quick brown fox jump over the lazy dog");
		assert isPanagram("The quick brown fox jumps over the azy dog");
	}
	
	/**
	 * check if string is a panagram string is or not 
	 * 
	 * @param s string to check
	 * @return {@code true} if given String is panagram otherwise {@code false}
	 */
	
	public static boolean isPanagram(String s)
	{
		boolean[] marked = new boolean[26];
		char[] values = s.toCharArray();
		for(char value : values)
		{
			if(Character.isLetter(value))
			{
				int index = Character.isUpperCase(value) ? value - 'A' : value - 'a';
				marked[index] = true;
			}
		}
		for(boolean b : marked)
		{
			if(!b)
			{
				return false;
			}
		}
		return true;
	}

}
