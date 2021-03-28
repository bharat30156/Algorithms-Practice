package Maths;

/**
 * 
 * @author Bharat
 *
 */
public class LucasSeries {
	public static void main(String[] args)
	{
		assert lucasSeries(1) == 2 && lucasSeriesIteration(1) ==2;
		assert lucasSeries(2) == 1 && lucasSeriesIteration(2) ==1;
	}
	
	/**
	 * Calculate the nth number of lucas series (2,1,3,4,7,11,18,29,47,76,123,....)using
	 * recursion
	 * 
	 * @param n nth
	 * @return nth number of lucas series
	 */
	
	public static int lucasSeries(int n)
	{
		return n == 1 ? 2 : n == 2 ? 1 : lucasSeries(n - 1) + lucasSeries(n - 2);
	}
	
	/**
	 * Calculate the nth of lucas series(2,1,3,4,7,11,18,29,47,76,123,....) using iteration
	 * 
	 * @param n nth
	 * @return nth of lucas series
	 */
	public static int lucasSeriesIteration(int n)
	{
		int previous = 2;
		int current = 1;
		for(int i = 1; i < n; i++)
		{
			int next = previous + current;
			previous = current;
			current = next;
		}
		return previous;
	}
}
