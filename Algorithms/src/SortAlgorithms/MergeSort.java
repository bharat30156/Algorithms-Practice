package SortAlgorithms;

/**
 * 
 * MERGE SORT
 * this sort recursively split the array in half until it reaches individual
 * elements the compares each element into sported sub-arrays until the entire 
 * array is sorted 
 * 
 *  Important Note : this implementation is that it works on a static array using flags, keeping memory 
 *  overhead small
 *
 */
public class MergeSort extends Sort {
	
	int[] tempArr;
	
	public MergeSort(int[] arr)
	{
		super(arr);
		tempArr = new int[size];
	}
	
	public void sort()
	{
		doMergeSort(0, this.size - 1);
	}
	
	//merege sort recursive element
	public void doMergeSort(int lowerIndex, int higherIndex)
	{
		if(lowerIndex < higherIndex)
		{
			//way of finding the middle of Something
			int middle = lowerIndex +(higherIndex - lowerIndex) / 2;
			doMergeSort(lowerIndex, middle);
			doMergeSort(middle + 1, higherIndex);
			//merge both sides of array
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}
	
	public void mergeParts(int lowerIndex, int middle, int higherIndex)
	{
		for(int i = lowerIndex; i <= higherIndex; i++)
		{
			this.tempArr[i] = this.numbers[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while(i <= middle && j <= higherIndex)
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
		while(i <= middle)
		{
			this.numbers[k] = this.tempArr[i];
			k++;
			i++;
		}
	}

}
