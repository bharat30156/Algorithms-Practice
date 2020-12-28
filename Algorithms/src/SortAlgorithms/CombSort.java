package SortAlgorithms;

public class CombSort extends Sort {
	public CombSort(int[] arr)
	{
		super(arr);
	}
	
	public void sort()
	{
		boolean sorted = false;
		int swapGap = this.size - 1;
		double shrink = 1.3;
		
		while(!sorted)
		{
			//set the variable size of the swap gap
			swapGap = (int) (swapGap/shrink);
			if(swapGap < 1)
			{
				sorted = true;
			}
			
			for( int i = 0; i + swapGap < this.size; i++)
			{
				if(numbers[i] > numbers[i + swapGap])
				{
					swap(i, i + swapGap);
				}
			}
		}
	}

}
