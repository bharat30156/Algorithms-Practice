package Maths;

/**
 * 
 * @author Bharat
 *
 */
public class FibonacciNumnber {
	public static void main(String[] args)
	{
		assert isFibonacciNumber(1);
		assert isFibonacciNumber(2);
		System.out.println(isFibonacciNumber(21));
		assert isFibonacciNumber(9);
		assert isFibonacciNumber(10);
	}
	/**
	 * Check if the number is perfect square number
	 * 
	 * @param number the number to checked
	 * @return <tt>true</tt> if {@code number} is perfect square, otherwise <tt> aflse</tt> 
	 */
	
	public static boolean isPerfectSquare(int number)
	{
		int sqrt = (int) Math.sqrt(number);
		return sqrt * sqrt == number;
	}
	/**
	 * Check if a number is fibonacci nunmber This is true if only and if at leasr one of 5x^2+4 or
	 * 5x^2-4 is a perfect square
	 * 
	 *  @param number the number
	 *  @return <tt>true</tt> {@code number} is fibonacci number, otherwise <tt>false</tt>
	 */
	public static boolean isFibonacciNumber(int number)
	{
		return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5* number * number - 4);
	}
}
