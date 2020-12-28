package SortAlgorithms;

import java.util.ArrayList;

public class CountingSort extends Sort {
	ArrayList<Integer> uniqueElement = new ArrayList<Integer>();
	
	public CountingSort(int[] arr)
	{
		super(arr);
		this.uniqueElement = getUniqueElements();
		this.uniqueElement.sort(null);
		
	}
	
	public void sort()
	{
		int[] output = new int[this.size];
		int[] count = new int[this.uniqueElement.size()];
		
		//count the occurrence of each number
		for(int i = 0; i < this.size; i++)
		{
			count[getUniqueElementAt(i)]++;
		}
		
		//create cumulative count array
		for(int i = 1; i < count.length; i++)
		{
			count[i] += count[i - 1];
		}
		
		//shift the numbers up one space(not big or clever, look into fixing this)
		for(int i =  count.length - 1; i > 0; i--)
		{
			count[i] = count[i - 1];
		}
		
		count[0] = 0;
		for(int i = 0; i < this.size; i++)
	{
		output[count[getUniqueElementAt(i)]] = this.numbers[i];
		count[getUniqueElementAt(i)]++;
	}
		for(int i = 0; i < this.size; i++)
		{
			//System.out.println(output[i]);
			this.numbers[i] = output[i];
		}
	}
	
	//radix sort method this could be considered a bucket sort
	public void sortByRadix(int place, int radix)
	{
		int[] out = new int[this.size];
		int count[] = new int[radix];
		for(int i = 0; i<this.size; i++) {
			int digit = getDigit(this.numbers[i], place, radix);
			count[digit]++;
		}
		for(int i=1; i<count.length; i++) {
			count[i]+=count[i-1];
		}
		for(int i=this.size-1;i>=0; i--) {
			int digit = getDigit(this.numbers[i], place, radix);
			out[count[digit]-1] = this.numbers[i];
			count[digit]--;
		}
		this.numbers = out;
	}
	
	private ArrayList<Integer> getUniqueElements()
	{
		//returns unique element of array
		ArrayList<Integer> rtn = new ArrayList<Integer>();
		for(int i = 0; i < this.size; i++)
		{
			if(!rtn.contains(this.numbers[i]))
			{
				rtn.add(this.numbers[i]);
			}
		}
		return rtn;
	}
	
	private int getUniqueElementAt(int index)
	{
		return uniqueElement.indexOf(this.numbers[index]);
	}
	
	private static int getDigit(int value,int digitPlace, int radix)
	{
		return (value/digitPlace) % radix;
	}

}
