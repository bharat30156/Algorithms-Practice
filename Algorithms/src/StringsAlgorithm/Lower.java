package StringsAlgorithm;

public class Lower {
	public static void main(String[] args)
	{
		String[] string = {"ABC", "AB123", "abcABC", "abc123ABC"};
		for(String i : string)
		{
			assert toLowerCase(i).equals(i.toLowerCase());
		}
	}
	
	/**
	 * Converts all of the character in this {@code String} to lower case
	 * 
	 * @param s the string to convert
	 * @return the {@code String}, converted to lowercase
	 */
	
	public static String toLowerCase(String s)
	{
		char[] values = s.toCharArray();
		for(int i = 0; i < values.length; i++)
		{
			if(Character.isLetter(values[i]) && Character.isUpperCase(values[i]))
			{
				values[i] = Character.toLowerCase(values[i]);
			}
		}
		return new String(values);
	}
}
