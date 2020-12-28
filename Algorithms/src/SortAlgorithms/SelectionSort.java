package SortAlgorithms;

public class SelectionSort extends Sort {
	public SelectionSort(int[] arr)
	{
		super(arr);
	}
	
	public void sort()
	{
		for(int j = 0; j < this.size - 1; j++)
		{
			int iMin = j;
			for(int i = j + 1; i < this.size; i++)
			{
				if(this.numbers[i] < this.numbers[iMin])
				{
					iMin = i;
				}
			}
			if(iMin != j)
			{
				swap(j, iMin);
			}
		}
	}

}
