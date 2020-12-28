package SortAlgorithms;

public class Sort {
	
	int[] numbers;
	int size;
	int max;
	int min;
	
	public Sort(int[] arr)
	{
		numbers = arr;
		size = arr.length;
		max = getMaxVal();
		min = getMinVal();
	}
	
	public void sort()
	{
		return;
	}
	
	public void sort(int lo, int hi)
	{
		return;
	}
	
	public int[] getNumbers()
	{
		return this.numbers;
	}
	
	void swap(int index1, int index2)
	{
		int temp = this.numbers[index1];
		this.numbers[index1] = this.numbers[index2];
		this.numbers[index2] = temp;
	}
	
	int getNumberAt(int index)
	{
		return this.numbers[index];
	}
	
	void copySectionFrom(Sort s, int lo, int hi)
	{
		for(int i = lo; i < hi; i++)
		{
			this.numbers[i] = s.getNumberAt(i);
		}
	}
	
	int getMaxVal()
	{
		int max = 0;
		for(int i = 0; i< this.size; i++)
		{
			if(this.numbers[i] > max) 
				max = this.numbers[i];
		}
		return max;
	}
	
	int getMinVal()
	{
		int min = this.max;
		for(int i = 0; i < this.size; i++)
		{
			if(this.numbers[i] < min)
				min = this.numbers[i];
		}
		return min;
	}
}
