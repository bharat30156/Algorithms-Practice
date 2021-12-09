package DataStructuresQueues;

import java.util.ArrayList;

/**
 * 
 * @author Bharat
 *
 */

/**
 * 
 * Thius class implements a genereicArrayListQueue
 * 
 * A genericarrayListQueue data structure functions the same as any specific-typed
 * queue. The GenericArrayListQueue holds elements of types to-be-specified at runtime.
 * The elements thata re added first are the first to be removed (FIFO). new elements are added to the back/rear
 * of the queue.
 *
 */
public class GenericArrayListQueue<T> {
	/**
	 * the generic ArrayList for the queue T is the generic element 
	 */
	ArrayList<T> _queue = new ArrayList<>();
	
	/**
	 * checks if the queuue has element (not empty)
	 * 
	 * @return true if teh queue has element. False otherwise 
	 */
	private boolean hasElements()
	{
		return !_queue.isEmpty();
	}
	
	/**
	 * checks what's at the front of the queue
	 * 
	 * @return if queue is not empty, element at the front of the 
	 */
	public T peek()
	{
		T result = null;
		if(this.hasElements())
		{
			result = _queue.get(0);
		}
		return result;
	}
	
	/**
	 * insert an element of type T to the queue
	 * 
	 * @param element of type T to be added 
	 * @return true if the element was added succesfully
	 */
	public boolean add(T element)
	{
		return _queue.add(element);
	}
	
	/**
	 * retrive what's at the front of the queue
	 * 
	 * @return if queue is not empty, element retrived , Otherwise null
	 */
	public T pull()
	{
		T result = null;
		if(this.hasElements())
		{
			result = _queue.remove(0);
		}
		return result;
	}
	
	/**
	 * Main method 
	 * @param args command line argument 
	 */
	public static void main(String... args)
	{
		GenericArrayListQueue<Integer> queue = new GenericArrayListQueue<>();
		System.out.println("Running... ");
		assert queue.peek() == null;
        assert queue.pull() == null;
        assert queue.add(1);
        assert queue.peek() == 1;
        assert queue.add(2);
        assert queue.peek() == 1;
        assert queue.pull() == 1;
        assert queue.peek() == 2;
        assert queue.pull() == 2;
        assert queue.peek() == null;
        assert queue.pull() == null;
        System.out.println("Finished.");
		
	}

}
