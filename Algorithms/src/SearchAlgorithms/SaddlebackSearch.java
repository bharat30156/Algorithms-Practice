package SearchAlgorithms;

import java.util.*;

/**
 * 
 * program to perform SaddleBack Search Given a sorted 2D array(elements are sorted across every row
 * and column, assuming ascending order) of size n*m we can search given element in O(n + m)
 * 
 *  
 * <p>we start from bottom left corner if the current element is greater that the given element then 
 * we move up else we move right sample input: 5 5 -> Dimensions -10 -5 -3 4 9 -6 -2 0 5 10 -4 
 * -1 1 6 12 2 3 7 8 13 100 120 130 140 150 140 ->element to be searched output: 4 3 // first value is row,
 * second one is column
 * 
 * @author Bharat
 *
 */

public class SaddlebackSearch {
	/**
	 * This method performs saddle Back Search 
	 * 
	 * @param arr The **Sorted** array in which we will search the element
	 * @param row the current row
	 * @param col the current column
	 * @param key the element that we want to search for
	 * @return The Index(row and column) of the element if found Else -1 and 1
	 */
	
	private static int[] find(int arr[][], int row, int col, int key)
	{
		//array to store the answer row and column 
		int ans[] = {-1, -1};
		if(row < 0 || col >= arr[row].length)
		{
			return ans;
		}
		if(arr[row][col] == key)
		{
			ans[0] = row;
			ans[1] = col;
			return ans;
		}
		
		//if the current element i greater than the given element then we move up
		else if (arr[row][col] > key)
		{
			return find(arr, row - 1, col, key);
		}
		//else we move right 
		return find(arr, row, col + 1, key);
	}
	
	/**
	 * Main Method 
	 * 
	 * @param args command line argument
	 * 
	 */
	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int arr[][];
		int i, j, rows = sc.nextInt(), col = sc.nextInt();
		arr = new int[rows][col];
		for(i = 0; i < rows; i++)
		{
			for(j = 0; j < col; j++)
			{
				arr[i][j] = sc.nextInt();
			}
		}
		int ele =  sc.nextInt();
		//we start from bottom left corner
		int ans[] = find(arr, rows -1, 0, ele);
		System.out.println(ans[0] + " " + ans[1]);
		sc.close();
	}
	

}
