package StringsAlgorithm;

/**
 * 
 * @author Bharat
 *
 */
public class ReverseString {
	public static void main(String[] args)
	{
		assert reverse("abc123").equals("321cba");
		
	}
	
	/**
	 * Easiest way to reverse the String str and return it 
	 * 
	 * @param Str String to be Reversed 
	 * @return reversed String 
	 */
	
	public static String reverse(String str)
	{
		return new StringBuilder(str).reverse().toString();
	}
	
	/**
	 * second way to reverse the String and return it
	 * 
	 * @param str String to be Reversed 
	 * @return reversed String
	 */
	public static String reverse2(String str)
	{
		if(str == null || str.isEmpty())
		{
			return str;
		}
		
		char[] value = str.toCharArray();
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) 
		{
			char temp = value[i];
		    value[i] = value[j];
		    value[j] = temp;
		}
		return new String(value);	}
}

