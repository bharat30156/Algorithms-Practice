package SearchAlgorithms;

import static java.lang.String.format;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;


/**
 * Interpolation Search algorithm implementation
 * <p> Worst-case performance O(n) Best Case Performance O(1) Average Performance O(log(log n))
 * if the elements are uniformly distributed if not O(n) worst-Case complexity O(1)
 * 
 *
 * @author Bharat
 */

class InterpolationSearch {
	
	/**
	 * @param array is Sorted
	 * @param key is a value what should be found in the arary
	 * @return an index if the array contains the key unless -1 
	 * 
	 */
	
	public int find(int array[], int key)
	{
		// find the index of two corner
		int start = 0, end = (array.length -1);
		
		//since array is sorted an element present
		//in array must be in range defined by corner
		while (start <= end && key >= array[start] && key <= array[end])
		{
			//probing the position with keeping
			//uniform distribution in mind
			int pos = start + (((end -  start) / (array[end] - array[start])) * (key -  array[start]));
			
			//condition of target found 
			if(array[pos] == key ) return pos;
			
			//if key is larger key is in upper part
			if(array[pos] < key) start = pos + 1;
			
			// if key is smaller, x is in lower part
			else end = pos -1;
		}
		
		return -1;
	}
	
	
	// Driver Code
	public static void main (String[] args)
	{
		Random r = new Random();
		
		int size = 100;
		int maxElement = 100000;
		int[] integers = IntStream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray();
		
		//the element that should be found
		Integer shouldBeFound = integers[r.nextInt(size - 1)];
		
		InterpolationSearch search = new InterpolationSearch();
		int atIndex = search.find(integers, shouldBeFound);
		
		System.out.println(
				String.format(
						"Should be found %d Found at index %d An array length %d", 
						shouldBeFound, integers[atIndex], atIndex, size));
		
		int toCheck = Arrays.binarySearch(integers, shouldBeFound);
		System.out.println(
				format(
						"Found by method at an index: %d. Is equal: %d", toCheck, toCheck == atIndex));
		
	}

}
