package Maths;

public class PerfectSquare {
	public static void main(String[] args)
	{
		assert !isPerfectSquare(-1);
		assert !isPerfectSquare(3);
		assert !isPerfectSquare(5);
		assert isPerfectSquare(9);
		assert isPerfectSquare(100);
		
	}
	
	/**
	 * check if number is perfect square number
	 * 
	 * @param number the number to be checked 
	 * @return <tt>true</tt> if{@code number} is perfect square, otherwise <tt> false</tt>
	 */
	public static boolean isPerfectSquare(int number)
	{
		int sqrt = (int)Math.sqrt(number);
		return sqrt * sqrt == number;
	}
}
