package SortAlgorithms;

public class RecursiveInsertionSort extends Sort {
	public RecursiveInsertionSort(int[] arr)
	{
		super(arr);
	}
	
	public void sort()
	{
		recursiveSort(this.size - 1);
	}
	
	public void recursiveSort(int length)
	{
		if(length > 0)
		{
			int x = this.numbers[length];
			int i = length -1;
			
			recursiveSort(length - 1);
			while(i >= 0 && this.numbers[i] > x)
			{
				this.numbers[i + 1] = this.numbers[i];
				i--;
			}
			this.numbers[i + 1] = x;
		}
	}

}
