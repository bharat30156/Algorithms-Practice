package Maths;

import java.util.Random;

/**
 * 
 * @author Bharat
 *
 */
public class MinValue {
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		for(int i = 1; i <= 100; i++)
		{
			int a = rand.nextInt(100) - 50;
			int b = rand.nextInt(100) - 50;
			
			assert min(a,b) == Math.min(a, b);
		}
	}
	
	/**
	 * Returns the smaller of two {@code int} values. That is, the result the argument closer to the value of{@link Integer#MIN_VALUE}. if the argument 
	 * have the same value, the result is that same value
	 * 
	 * @param a an argument 
	 * @param b amother argument 
	 * @return the smaller {@code a } and {@code b}
	 */
	
	public static int min (int a, int b)
	{
		return a <= b ? a : b;
	}
}
