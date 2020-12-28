package SortAlgorithms;

public class QuickSort extends Sort {
	
	/**
	 * QUICK Sort
	 * Sometimes called partition-exchange sort
	 * divide a large array into smaller sub-arrays the lower elements and
	 * the higher elements then recursively sorts the sun-arrays
	 */
	
	public QuickSort(int[] arr)
	{
		super(arr);
	}
	
	public void sort()
	{
		//select partition scheme
		//lomutoSort(0, this.size-1);
		hoareSort(0, this.size - 1);
	}
	
	/**
	 * quickSort using lomuto partition scheme, using the last element in 
	 * the partition as the pivot. Commonly used as  simple educational
	 * variant of a quickSort. degrades to O(N^2) if array is already Sorted
	 */
	void lomutoSort(int lo, int hi)
	{
		int p;
		//limit recursion depth
		if(lo < hi)
		{
			//sets divisor
			p= lomutoPartition(lo, hi);
			lomutoSort(lo, p-1);
			lomutoSort(p+1, hi);
		}
	}
	
	int lomutoPartition(int lo, int hi)
	{
		int pivot = this.numbers[hi];
		int i = lo;
		//for every value in range , swap the numbers if they are less than pivot
		for(int j = lo; j< hi; j++)
		{
			if(this.numbers[j] < pivot)
			{
				swap(i, j);
				i++;
			}
		}
		swap(i, hi);
		return i;
	}
	
	/**
	 * quickSort using Haore partition scheme using the first element in the 
	 * partition as the pivot
	 */
	
	void hoareSort(int lo, int hi)
	{
		int p;
		if(lo < hi)
		{
			p = hoarePartition(lo, hi);
			hoareSort(lo, p);
			hoareSort(p + 1, hi);
		}
	}
	
	int hoarePartition(int lo, int hi)
	{
		int pivot = this.numbers[lo];
		int i = lo - 1;
		int j = hi + 1;
		
		//an infinite loop in a sorting algorithm
		while(true)
		{
			//search for a point where i and j meet under pivot
			do {i++;} while (this.numbers[i] < pivot);
			do {j--;} while (this.numbers[j] > pivot);
			
			if(i >= j)
			{
				return j;
			}
			swap(i, j);
		}
	}

}
