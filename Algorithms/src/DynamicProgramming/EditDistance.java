package DynamicProgramming;

import java.util.Scanner;

/**
 * 
 * @author bharat
 *
 */
/**
 * 
 * A Dynamic Programming based solution for edit Distance problem in java Description of edit
 * Distance with an Example 
 *
 *<p> Edit distance is a way of quantifying how dissimilar two Strings (e.g., words) are to one 
 *another, by counting the minimum number of operation required to transform one String into the 
 *other. The Distance operations are the removal insertion, or substitution of character in the string
 *
 *<p>
 *
 *<p> The Distance between "kitten" and "sitting" is 3. minimal edit script that transforms the former into the latter is:
 *
 *<p>kitten -> sitten (substitution of "s" for "k") sitten -> sittein (substion of "i" for "e")
 *sittin -> sitting (insertion of "g" at the end).
 */
public class EditDistance {
	
	public static int minDistance(String word1, String word2)
	{
		int len1 = word1.length();
		int len2 = word2.length();
		
		//len1+1, len2+1, because finally dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
		//if second string is empty, the only option is to
		//inserts all the characters of first string into second
		for(int i =0; i <= len1; i++)
		{
			dp[i][0] = i;
		}
		/*
		 * if first string is empty the only option is to 
		 * insert all charcaters of second string into first
		 */
		for(int j = 0; j <= len2; j++)
		{
			dp[0][j] = j;
		}
		
		//iterate through, and chech last char
		for(int i = 0; i < len1; i++)
		{
			char c1 = word1.charAt(i);
			for(int j = 0; j < len2; j++)
			{
				char c2 = word2.charAt(j);
				//if last two chars equal
				if(c1 == c2)
				{
					//update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				}
				else
				{
					//if two characters are diffrent, 
					// then take the minimum of the various operations (i.e insertions,removal,substition)
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
					
					int min =  replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
		// return the final answer, after transversing through both the string
		return dp[len1][len2];
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String s1, s2;
		System.out.println("Enter the first String:");
		s1 = input.nextLine();
		System.out.println("Enter the second String:");
		s2 = input.nextLine();
		// ans stores the final edit distance between the two strings
		int ans = minDistance(s1, s2);
		System.out.println(
				"The minimum edit distance between \"" + s1 + "\" and\"" + s2 + "\" is " + ans);
		input.close();
	}
}
