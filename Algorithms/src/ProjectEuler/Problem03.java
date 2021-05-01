package ProjectEuler;
/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * The prme factor of 13195 are 5, 7, 13 and 29
 * 
 * <p> what is the largest prme factor of the number 6008514775143 ?
 *
 */

public class Problem03 {
	
	/**
	 * checks idf anumber is prime or not 
	 * 
	 * @param n the number 
	 * @return {@code true} f {@code n} is prime
	 */
	public static boolean isPrime(int n)
	{
		if(n == 2)
			return true;
		if(n < 2 || n % 2 == 0)
			return false;
		for(int i = 3, limit = (int) Math.sqrt(n); i <= limit; i += 2)
		{
			if(n % i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Calculate all the prime factors of a numbners and return the largest 
	 * 
	 * @param n the integer
	 * @return the maximum prme factor of the given Number
	 */
	static long maxPrimeFactor(long n)
	{
		for(int i = 2; i < n / 2; i++)
		{
			if(isPrime(i))
				while(n % i == 0)
				{
					n /= i;
				}
		}
		return n;
	}
	
	public static void main(String[] args)
	{
		int [][] testNumber = {
				{87,29},
				{10,5},
				{21,7},
				{657,73},
				{777,37},
		};
		
		for(int [] num : testNumber)
		{
			assert Problem03.maxPrimeFactor(num[0]) == num[1];
		}
		assert Problem03.maxPrimeFactor(600851475143L) == 6857;
	}

}
