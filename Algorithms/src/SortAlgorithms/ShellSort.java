package SortAlgorithms;

public class ShellSort extends Sort {
	
	public ShellSort(int[] arr)
	{
		super(arr);
	}
	
	public void Sort()
	{
		int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1}; //tokuda's gap sequence
		//consider writing an extensible gap sequence, where:
		//each nextVal = 2.25*preVal + 1;
		int temp = 0;
		int j;
		
		for(int g: gaps)
		{
			for(int i = g; i < this.size; i++)
			{
				temp = this.numbers[i];
				for(j = i; j >= g && this.numbers[j - g] > temp; j-=g)
				{
					this.numbers[j] = this.numbers[j - g];
				}
				this.numbers[j] = temp;
			}
		}
	}
	int[] getGapSequence()
	{
		return new int[] {701, 301, 132, 57, 23, 10, 4, 1};
	}
}
