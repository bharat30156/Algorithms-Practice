package SortAlgorithms;

public class HeapSort extends Sort {
	public HeapSort(int[] arr)
	{
		super(arr);
	}
	
	/**
	 * 5 Heap SORT
	 * a 2-part- algorithm builds a heap from the available data, then
	 * removes the root of the heap and places it in a Sorted Sub array. 
	 */
	
	public void Sort()
	{
		int end = this.size - 1;
		buildHeap();
		
		while(end > 0)
		{
			swap(end, 0);
			end--;
			siftDown(0, end);
		}
	}
	
	//build heap in an array so that the largest value is at the root
	void buildHeap()
	{
		int start = getParentIndex(this.size - 1);
		
		while(start >= 0)
		{
			siftDown(start, this.size-1);
			start--;
		}
	}
	
	void siftDown(int start, int end)
	{
		int root = start;
		int swap;
		int child;
		while(getLeftChildIndex(root) <= end)
		{
			child = getLeftChildIndex(root);
			swap = root;
			if(this.numbers[swap] < this.numbers[child])
			{
				swap = child;
			}
			if(child + 1 <= end && this.numbers[swap] < this.numbers[child + 1])
			{
				swap = child + 1;
			}
			if(swap == root)
			{
				return;
			}
			else
			{
				swap(root, swap);
				root = swap;
			}
		}
	}
	
	int getLeftChildIndex(int parentIndex)
	{
		return 2 * parentIndex + 1;
	}
	
	int getParentIndex(int childIndex)
	{
		//ensures odd left child is used 
		if(childIndex % 2 == 0)
		{
			childIndex--;
		}
		return childIndex / 2;
	}

}
