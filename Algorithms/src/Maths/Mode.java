package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 * @author Bharat
 *
 */

/**
 * 
 * the mode of aray numbers is the most frequently occuring number in the array
 * or the most frequently occuring number if there are multiple numbers with same frequency
 *
 */
public class Mode {
	public static void mian(String[] args)
	{
		assert Arrays.equals(mode (new int[] {1,2,3,45}), new int[] {1,2,3,4,5}); 
	}
	
	/**
	 *  Finf the mode of array of integers
	 *  
	 *  @param number os array opf inetegers
	 *  @return mode of the array
	 */
	
	public static int[] mode(int[] numbers)
	{
		if(numbers.length == 0) return null;
		
		HashMap<Integer, Integer> count = new HashMap<>();
		
		for(int num : numbers)
		{
			if(count.containsKey(num))
			{
				count.put(num, count.get(num) + 1);
			}
			else
			{
				count.put(num, 1);
			}
		}
		
		int max = Collections.max(count.values());
		ArrayList<Integer> modes = new ArrayList<>();
		
		for(int num : count.keySet())
		{
			if(count.get(num) == max)
			{
				modes.add(num);
			}
		}
		return modes.stream().mapToInt(n -> n).toArray();
	}

}
