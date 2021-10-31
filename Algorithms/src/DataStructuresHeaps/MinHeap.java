package DataStructuresHeaps;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Bharat
 *
 *Heap tree where a node's key is higher than or equal to its parent's and lower than or equal to its children 
 */

public class MinHeap {
	private final List<HeapElement> minHeap;
	
	public MinHeap(List<HeapElement> listElements)
	{
		minHeap = new ArrayList<>();
		for(HeapElement heapElement : listElements)
		{
			if(heapElement != null) insertElement(heapElement);
			else System.out.println("Null element. Not added to heap");
		}
		if(minHeap.size() == 0) System.out.println("No element has been added, empty heap");
	}
	
	//get the element at a given index. the key for the list is equal to index value - 1
	public HeapElement getElement(int elementIndex)
	{
		if((elementIndex <= 0) || (elementIndex > minHeap.size()))
			throw new IndexOutOfBoundsException("Index out of heap range");
		return minHeap.get(elementIndex - 1);
	}
	
	// Get the key of the element at a given index 
	private double getElementKey(int elementIndex)
	{
		return minHeap.get(elementIndex - 1).getKey();
	}
	
	//swaps two elements in the heap
	private void swap(int index1, int index2)
	{
		HeapElement temporaryElement = minHeap.get(index1 - 1);
		minHeap.set(index1 - 1, minHeap.get(index2 - 1));
		minHeap.set(index2 - 1, temporaryElement);
	}
	
	// toogle an element upt ot its right as long as its key is lower than its parents 
	private void toogleUp(int elementIndex)
	{
		double key = minHeap.get(elementIndex - 1).getKey();
		while(getElementKey((int) Math.floor(elementIndex/2.0)) > key)
		{
			swap(elementIndex, (int)Math.floor(elementIndex/2.0));
			elementIndex = (int)Math.floor(elementIndex/2.0);
		}
	}
	
	//toggle an element up to its right place as long as its key is higher 
	//than any of its children 
	private void toggleDown(int elementIndex)
	{
		double key = minHeap.get(elementIndex - 1).getKey();
		boolean wrongOrder = 
				(key > getElementKey(elementIndex * 2))
				|| (key > getElementKey(Math.min(elementIndex * 2, minHeap.size())));
		while((2 * elementIndex <= minHeap.size()) && wrongOrder)
		{
			//cjheck whether it shall swap the element with its left chiuld or its right one if any 
			if((2 * elementIndex < minHeap.size())
				&& (getElementKey(elementIndex * 2 + 1) < getElementKey(elementIndex * 2)))
				{
					swap(elementIndex, 2 * elementIndex + 1);
					elementIndex = 2 * elementIndex + 1;
				}
			else
			{
				swap(elementIndex, 2 * elementIndex);
				elementIndex = 2 * elementIndex;
			}
			wrongOrder = 
					(key > getElementKey(elementIndex * 2))
					|| (key > getElementKey(Math.min(elementIndex * 2, minHeap.size())));
		}			
	}
	
	private HeapElement exractMin()
	{
		HeapElement result = minHeap.get(0);
		deleteElement(0);
		return result;
	}
	
	public void insertElement(HeapElement element)
	{
		minHeap.add(element);
		toogleUp(minHeap.size());
	}
	
	public void deleteElement(int elementIndex)
	{
		if(minHeap.isEmpty())
			try {
				throw new EmptyHeapException("Attempt to delete an element from an empty Heap");
			} catch (EmptyHeapException e) {
				e.printStackTrace();
			}
		if((elementIndex > minHeap.size()) || (elementIndex <= 0))
			throw new IndexOutOfBoundsException("Index out of heap range");
		//the last element in Heap replaces the one to be deleted 
		minHeap.set(elementIndex - 1, getElement(minHeap.size()));
		minHeap.remove(minHeap.size());
		
		//shall the new element be moved up
		if(getElementKey(elementIndex) < getElementKey((int) Math.floor(elementIndex / 2.0)))
			toogleUp(elementIndex);
		//.. or down 
		else if((2 * elementIndex <= minHeap.size())
			&& (getElementKey(elementIndex) > getElementKey(elementIndex * 2))
			||((2 * elementIndex < minHeap.size())
					&&(getElementKey(elementIndex) > getElementKey(elementIndex * 2))))
			toggleDown(elementIndex);
	}
	
	public HeapElement getElement() throws EmptyHeapException
	{
		try
		{
			return exractMin();
		}
		catch(Exception e)
		{
			throw new EmptyHeapException("heap is empty. error retrieving element");
		}
	}
}
