package Maths;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * @author Bharat
 *
 */
public class FindMin {
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		int size = rand.nextInt(100) + 1;
		int[] array = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			array[i] = rand.nextInt() % 100;
		}
		
		assert Arrays.stream(array).min().getAsInt() == findMin(array);
	}
	
	/**
	 * Find minimum numbers of array of numbers 
	 * 
	 * @param array the array contains elements
	 * @return min value
	 */
	
	public static int findMin(int[] array)
	{
		int min = array[0];
		for(int i = 0; i < array.length; i++)
		{
			if(array[i] < min)
			{
				min = array[i];
			}
		}
		return min;
	}

}
