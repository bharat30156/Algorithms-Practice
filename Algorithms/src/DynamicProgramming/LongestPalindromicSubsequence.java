package DynamicProgramming;

public class LongestPalindromicSubsequence {
	public static void main(String[] args)
	{
		String a = "BBABCBCAB";
		String b = "BABCBAS";
		
		String aLPS = LPS(a);
		String bLPS = LPS(b);
		
		System.out.println(a + " => " + aLPS);
		System.out.println(b + " => " + bLPS);
	}
	
	public static String LPS(String original) throws IllegalArgumentException
	{
		StringBuilder reverse = new StringBuilder(original);
		
		reverse = reverse.reverse();
		return recursiveLPS(original, reverse.toString());
	}
	
	private static String recursiveLPS(String original, String reverse)
	{
		String bestResult = "";
		
		// no more chars, then return empty
		if(original.length() == 0 || reverse.length() == 0)
		{
			bestResult = "";
		}
		else
		{
			// if the last chars match then more remove it from both String and recur
			if(original.charAt(original.length() - 1) == reverse.charAt(reverse.length() - 1))
			{
				String bestSubResult = 
						recursiveLPS(
								original.substring(0, original.length() - 1),
								reverse.substring(0, reverse.length() - 1));
				
				bestResult =  reverse.charAt(reverse.length() - 1) + bestSubResult;
			}
			else
			{
				// otherwise (1) ignore the last chracter of reverse and recur on original and update 
				// reverse again 
				//(2) ignore the last character of orginal and recur on the updated original and reverse
				//again
				//then select the best result from these two subproblems 
				
				String bestSubResult1 = recursiveLPS(original.substring(0, original.length() - 1), reverse);
				String bestSubResult2 = recursiveLPS(original.substring(0, original.length() - 1), reverse);
				if(bestSubResult1.length() > bestSubResult2.length())
				{
					bestResult =  bestSubResult1;
				}
				else
				{
					bestResult = bestSubResult2;
				}
			}
		}
		return bestResult;
	}
	
}
