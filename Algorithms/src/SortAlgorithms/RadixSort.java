package SortAlgorithms;

public class RadixSort extends Sort {
	public RadixSort(int[] arr)
	{
		super(arr);
	}
	
	public void sort()
	{
		CountingSort s;
		final int RADIX = 10;
		
		for(int exp = 1; this.max/exp>0; exp*=RADIX)
		{
			s = new CountingSort(this.numbers);
			s.sortByRadix(exp, RADIX);
			this.numbers = s.getNumbers();
		}
	}

}
