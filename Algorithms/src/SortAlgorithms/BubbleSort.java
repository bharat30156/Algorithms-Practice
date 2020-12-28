package SortAlgorithms;

public class BubbleSort extends Sort{
	
	public BubbleSort(int[] arr)
	{
		super(arr);
	}
	
/**
 * Compares Pairs of numbers in an array, swapping them if the
 * one on the left is larger that the one on the right.
 * inefficient, but very simple
 */
	public void sort()
	{
		int flag = this.size - 1;
		int flagUpdate = 0;
		
		while(flag > 1)
		{
			flagUpdate = 0;
			for(int i = 0; i < flag; i++ ) 
			{
				if(numbers[i] > numbers[i + 1])
				{
					swap(i, i+1);
					flagUpdate = i + 1;
				}
			}
			flag = flagUpdate;
		}
	}

}
