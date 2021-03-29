package Maths;

/**
 * 
 * @author Bharat
 *
 */
public class PerfectCube {
	public static void main(String[] args)
	{
		assert !isPerfectCube(-1);
		assert isPerfectCube(0);
		assert isPerfectCube(4);
	}
	
	/**
	 * check if the number is perfec t cube or not
	 * 
	 * @param number number to check 
	 * @return {@code true} if {@code number} is perfect cube, otherwise {@code false}
	 */
	public static boolean isPerfectCube(int number)
	{
		int a = (int) Math.pow(number, 1.0/3);
		return a * a * a == number;
	}

}
