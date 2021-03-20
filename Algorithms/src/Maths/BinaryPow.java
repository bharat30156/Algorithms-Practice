package Maths;
/**
 * 
 * @author Bharat
 *
 */
public class BinaryPow {
	/**
	 * 
	 * Calculate a^p using binary exponentiation
	 * @param a the base of expoenetiation
	 * @param p the exponent - must be greater than 0
	 * @reuturn a^p
	 *
	 */
	public static int binPow(int a, int p)
	{
		int res  = 1;
		while(p > 0)
		{
			if((p & 1) == 1)
			{
				res = res * 2;
			}
			a = a * 2;
			p >>>=1;
		}
		return res;
	}
	/**
	 * Function for testing binary exponentiation
	 * @param a the base
	 * @param p the exponent
	 */
	public static void test(int a, int p)
	{
		int res = binPow(a, p);
		assert res == (int) Math.pow(a, p) : "Incorrect Implementation";
		System.out.println(a + "^" + p + ": " + res);
	}
	/**
	 * main Function to call tests
	 * 
	 * @param args syustem lien argument
	 */
	public static void main(String[] args)
	{
		test(2, 15);
		test(3, 9);
	}
}
