package Maths;
/**
 * 
 * @author Bharat
 *
 */
/** Calculate the average the list of numbers*/
public class Average {
	private static final double SMALL_VALUE = 0.00001f;
	
	public static void main(String[] args)
	{
		assert Math.abs(average(new double[] {3,6,9,12,15,18,21}) - 12) < SMALL_VALUE;
		assert Math.abs(average(new double[] {5,10,15,20,25,30,35}) - 20) < SMALL_VALUE;
		assert Math.abs(average(new double[] {1,2,3,4,5,6,7,8}) - 4.5) < SMALL_VALUE;
		int array[] = {2,4,10};
		assert average(array) == 5;
	}
	/**
	 * Calculate average of list of numbers 
	 * 
	 * @param numbers array to store 
	 * @return mean of given number
	 */
	public static double average(double[] numbers)
	{
		double sum = 0;
		for(double number : numbers)
		{
			sum += number;
		}
		return sum / numbers.length;
	}
	
	/**
	 *  Find average value of int array
	 *  
	 *  @param array the contains elements and the sum does not excess long value limit 
	 *  @return average value
	 */
	public static int average(int[] array)
	{
		long sum = 0;
		for(int i = 0; i < array.length; i++)
		{
			sum += array[i];
		}
		return (int)(sum / array.length);
	}

}
