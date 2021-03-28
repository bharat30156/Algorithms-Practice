package Maths;

import java.util.Random;

/**
 * 
 * @author Bharat
 *
 */

public class MaxValue {
	public static void main(String[] args)
	{
		Random rand = new Random();
		for(int i = 0; i <= 100; i++)
		{
			int a = rand.nextInt(100) - 50;
			int b = rand.nextInt(100) - 50;
			assert max(a,b) == Math.max(a, b);
		}
	}
	
	/**
	 *  Returns the greater of two {@code int} values. That is the result is the argument closer to the value.
	 *  If the argument have same value, the reuslt is that same value
	 *  
	 *  @param a an argument 
	 *  @param b the another argument 
	 *  @return the larger of{@code a} and {@code b}
	 */
	public static int max(int a, int b)
	{
		return a>= b ? a : b;
	}

}
