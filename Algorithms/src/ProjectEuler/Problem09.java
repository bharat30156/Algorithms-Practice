package ProjectEuler;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * A pythagorean triplet is a set of three natural numbers , a < b < c, for which,
 * <p> a^ 2 + b^2 = c^2 for example , 3^2 + 4^2 = 9 + 16 = 25 = 5^2
 *
 * <p> There exits exactly one pythagorean triplet fpr which a + b + c = 1000 find the product abc 
 * 
 */
public class Problem09 {
	public static void main(String[] args)
	{
		assert solution1() == 31875000;
	}
	
	private static int solution1()
	{
		for(int i = 0; i <= 300; i++)
		{
			for(int j = 0; j <= 400; j++)
			{
				int k = 1000 - i - j;
				if(i * i + j * j == k * k)
				{
					return i * j * k;
				}
			}
		}
		return -1;
	}

}
