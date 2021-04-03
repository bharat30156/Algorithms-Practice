package Misc;

import java.util.Arrays;

public class RangenSortedArray {
	public static void main(String[] args)
	{
		assert Arrays.equals(sortedrange(new int[] {1,2,3,3,3,4,5},3), new int[] {2,4});
		assert Arrays.equals(sortedrange(new int[] {1,2,3,3,3,4,5},4), new int[] {5,5});
		assert Arrays.equals(sortedrange(new int[] {0,1,2},3), new int[] {-1,-1});
	}
	
	// get the 1st and last occurence index of a number 'key in a non decreasing array 'nums'
	// gives [-1, -1] in case element doesn't exits in array
	public static int[] sortedrange(int[] nums, int key)
	{
		int[] range = new int[] {-1, -1};
		
		return range;
	}
	//Recursive altered binary search ehich searches for leftmost as well as rightmost occurence of 
	// 'key'
	public static void alteredBinSearch(int[] nums, int key, int left, int right, int[] range, boolean goLeft)
	{
		if(left > right) return;
		int mid = (left + right) / 2;
		if(nums[mid] > key) alteredBinSearch(nums, key, left, mid - 1, range, goLeft);
		else if (nums[mid] < key) alteredBinSearch(nums, key, mid + 1, right, range, goLeft);
		else
		{
			if(goLeft)
			{
				if(mid == 0 || nums[mid - 1] != key) range[0] = mid;
				else alteredBinSearch(nums, key,left, mid - 1, range, goLeft);
			}
			else
			{
				if(mid == nums.length - 1 || nums[mid + 1] != key) range[1] = mid;
				else alteredBinSearch(nums, key, mid + 1, right, range, goLeft);
			}
		}
	}
	
	// Iteratve altered binary search which search for leftmost as well as rightmost occurence of
	//'key'
	public static void alteredBinSearchIter(int[] nums, int key, int left, int right, int[] range, boolean goLeft)
	{
		while (left <= right)
		{
			int mid = (left + right) / 2;
			if(nums[mid] > key ) right = mid - 1;
			else if (nums[mid] < key) left = mid + 1;
			else
			{
				if(goLeft)
				{
					if(mid == 0 || nums[mid - 1] != key)
					{
						range[0] = mid;
						return;
					}
					else right = mid - 1;
				}
				else
				{
					if(mid == nums.length - 1 || nums[mid + 1] != key)
					{
						range[1] = mid;
						return;
					}
					else left = mid + 1;
				}
			}
		}
	}
	
	public static int getCountLessThan (int[] nums, int key)
	{
		return getLessThan(nums, key, 0, nums.length - 1);
	}
	
	public static int getLessThan(int [] nums, int key, int left, int right)
	{
		int count = 0;
		while (left <= right)
		{
			int mid = (left + right) / 2;
			if(nums[mid] > key) right = mid - 1;
			else if (nums[mid] <= key)
			{
				count = mid + 1;
				left = mid + 1;
			}
		}
		return count;
	}
}
