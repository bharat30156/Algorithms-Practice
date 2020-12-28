package SortAlgorithms;


/**
 * 
 * INSERTION SORT
 * Takes each item of a list and compares it to all the items below it in 
 * the list leaving the item in the position when the items beneath it has a lower value
 *
 * O(n^2) 
 */
public class InsertionSort extends Sort {
	public InsertionSort(int[] arr)
	{
		super(arr);
	}
	
	public void sort()
	{
		//iterate through array
		for(int i = 1; i < this.size; i++)
		{
			//iterate backwards through subset of the array in question
			for(int j = i; j > 0; j--)
			{
				//swap numbers if the one to the left is higher than the one to the right
				if(this.numbers[j] < this.numbers[j - 1])
				{
					swap(j, j-1);
				}
			}
		}
		
		/**this is the version on wikipedia. for some reason it seems slightly faster.
		  (non oo version, copied from god class version)
		int j;
		int temp;
		
		for(int i = 1; i < numbers.length; i++) {
			j = i;
			while((j > 0) && (numbers[j-1] > numbers[j])) {
				temp = numbers[j];
				numbers[j] = numbers[j-1];
				numbers[j-1] = temp;
				j--;
			}
		}
		return numbers;*/	
	}
	
	//selective sort implementation
	public void sort(int lo, int hi)
	{
		for(int i = lo + 1; i < hi; i++)
		{
			for(int j = i; j > lo; j--)
			{
				if(this.numbers[j] < this.numbers[j - 1])
				{
					swap(j, j - 1);
				}
			}
		}
	}

}
