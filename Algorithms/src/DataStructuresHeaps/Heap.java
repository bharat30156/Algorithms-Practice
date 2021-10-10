package DataStructuresHeaps;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * Interface common to heap data Structure <br>
 * 
 * <p> heaps are tree like data structures that allow storing element in a specific way. Each node 
 * corresponds to an element and has one parent node (Except for the root) and at most two children
 * nodes. Every element contains a key, and those keys indicate how tree shall be built. For insatnce 
 * for a min-heap the key of node shall be greater than or equal to its parent and lower than or equal to its childrens (the opposite rule applies to max-heap)  
 *
 */
public interface Heap {
	/**
	 * @return the top element in the heap, the one with lowest key for min heap or with the higest heap 
	 * key for max-heap 
	 * @throws EmptyHeadException if heap is empty
	 */
	
	HeapElement getElement() throws EmptyHeapException;
	
	/**
	 * Inserts an element in the heap. Adds it to then end and toggle it until it finds its right 
	 * position
	 * 
	 * @param elemnt an instance of the HeapElemnt class
	 */
	
	void insertElement(HeapElement);
	
	/**
	 * Delete an elemnet in the heap 
	 * 
	 * @param elementIndex int contaning the position in the heap of the lement to be deleted 
	 */
	void deleteElement(int elementIndex);
}
