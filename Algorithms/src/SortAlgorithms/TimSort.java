package SortAlgorithms;

public class TimSort extends Sort {
	
	private static final int MIN_MERGE = 32;
	private static final int MIN_GALLOP = 7;
	private static Sort s;
	private int[] tempArr;
	
	public TimSort(int[] arr)
	{
		super(arr);
		this.tempArr = new int[this.size];
	}
	
	public void Sort()
	{
		recursiveTimSort(0, this.size - 1);
	}
	
	private void recursiveTimSort(int lo, int hi)
	{
		//Sort Smaller Values
		if(hi-lo < MIN_MERGE)
		{
			s = new InsertionSort(this.numbers);
			s.sort(lo, hi);
			copySectionFrom(s, lo, hi);
		}
		
		int minRunLen = getEndOfRun(lo, hi) - lo;
		recursiveTimSort(lo, lo+minRunLen);
		recursiveTimSort(hi-minRunLen + 1, hi);
		merge(lo, lo + minRunLen, hi);
	}
	
	private void merge(int lo, int mid, int hi)
	{
		for(int i = lo; i <= hi; i++)
		{
			this.tempArr[i] = this.numbers[i];
		}
		
		int i = lo;
		int j = mid + 1;
		int k = lo;
		while(i <= mid && j <= hi)
		{
			if(this.tempArr[i] <= this.tempArr[j])
			{
				this.numbers[k] = this.tempArr[i];
				i++;
			}
			else
			{
				this.numbers[k] = this.tempArr[j];
				j++;
			}
			k++;
		}
		while(i <= mid)
		{
			this.numbers[k] = this.tempArr[i];
			k++;
			i++;
		}
	}
	
	//return the final index of the run
	private int getEndOfRun(int lo, int hi)
	{
		for(int i = lo; i < hi - 1; i++)
		{
			if(this.numbers[i] < this.numbers[i + 1])
			{
				return i;
			}
		}
		return hi;
	}
}
