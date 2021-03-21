package Maths;
/**
 * 
 * @author Bahrat
 *
 */
public class Combinations {
	public static void main(String[] args)
	{
		assert combinations(1, 1) == 1;
		assert combinations(10, 5) == 252;
		assert combinations(6, 3) == 20;
		assert combinations(20, 5) == 15504;
		
	}
	
	/**
	 * Calculate the factorial 
	 * 
	 * @param n the number 
	 * @param factorial of given number 
	 */
	public static long factorial(int n)
	{
		if(n < 0)
		{
			throw new IllegalArgumentException("number is negative");
		}
		return n == 0 || n == 1 ? 1 : n * factorial(n - 1);
	}
	
	/**
	 * Calculate combiations
	 * 
	 * @param n first number
	 * @param k second number 
	 * @return combination of given {@code n} and {@code k} 
	 */
	public static long combinations(int n, int k)
	{
		return factorial(n) / (factorial(k) * factorial(n  - k));
	}

}
