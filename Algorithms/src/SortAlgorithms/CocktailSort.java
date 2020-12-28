package SortAlgorithms;

public class CocktailSort extends Sort {
	public CocktailSort(int[] arr)
	{
		super(arr);
	}
	
	public void Sort()
	{
		int lo = 0;
		int hi = this.size - 1;
		
		//bidirectionalShake(lo, hi); hard to implement
		directionalShakes(lo, hi);
	}
	
	void directionalShakes(int lo, int hi)
	{
		while(lo <= hi)
		{
			shakeUp(lo, hi);
			hi--;
			shakeDown(lo, hi);
			lo++;
		}
	}
	
	void shakeUp(int lo, int hi)
	{
		for(int i = lo; i < hi; i++)
		{
			if(this.numbers[i] > this.numbers[i + 1])
			{
				swap(i, i + 1);
			}
		}
	}
	
	void shakeDown(int lo, int hi)
	{
		for(int i = hi + 1; i > lo; i--)
		{
			if(this.numbers[i] < this.numbers[i - 1])
			{
				swap(i, i - 1);
			}
		}
	}

}
