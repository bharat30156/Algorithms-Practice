package DataStructuresQueues;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * This implements queues by using the class queue
 * 
 * A queue data Structure functions the same as a real world queue. The elements 
 * that are added first are the first to be removed. new elemenbts are added to the back of the queue 
 */
class Queue {
	
	/**
	 * Default initial capcity
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * Max size of the queue
	 */
	private int maxSize;
	
	/**
	 * The array representing the queue
	 */
	private int[] queueArray;
	
	/**
	 * Front of the queue
	 */
	private int front;
	
	/**
	 * Rear of the same
	 */
	private int rear;
	
	/**
	 * How many items are in the queue
	 */
	private int nItems;
	
	/**
	 * init with DEFAULT_CAPACITY
	 */
	public Queue()
	{
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Constructor
	 * 
	 * @param size Size of the new Queue
	 */
	public Queue(int size)
	{
		maxSize = size;
		queueArray = new int[size];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	/**
	 * Inserts an elements at the rear of teh queue
	 * 
	 * @param x elements to be added
	 * @return True if the element was added successfully
	 */
	public boolean insert(int x)
	{
		if(isFull())
		{
			return false;
		}
		// if the back of the queue is the end of the aray wrap around to the front 
		rear = (rear + 1) % maxSize;
		queueArray[rear] = x;
		nItems++;
		return true;
	}
	
	/**
	 * remove an element form the fornt of the queue
	 * 
	 * @return the new front of the queue
	 */
	public int remove()
	{
		if(isEmpty())
		{
			return -1;
		}
		int temp = queueArray[front];
		front = (front + 1) % maxSize;
		nItems--;
		return temp;
	}
	
	/**
	 * checks what's at the front of the queue
	 * 
	 * @return elements at the fornt of the queue
	 */
	public int peekFront()
	{
		return queueArray[front];
	}
	
	/**
	 * checks what's at the rear of teh queue
	 * 
	 * @return element at the rear of the queue
	 */
	public int peekRear()
	{
		return queueArray[rear];
	}
	
	/**
	 * Returns true if teh queue is empty 
	 * 
	 * @return true if the queue is empty
	 */
	public boolean isEmpty()
	{
		return nItems == 0;
	}
	
	/**
	 * Return true if the queue is Full 
	 * 
	 * @return true if the queue is Full 
	 */
	public boolean isFull()
	{
		return nItems == maxSize;
	}
	
	/**
	 * Returns the number of elements in the queue
	 * 
	 * @return number of elements in the queue
	 */
	public int getSize()
	{
		return nItems;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = front;; i = ++i % maxSize)
		{
			sb.append(queueArray[i]).append(", ");
			if(i == rear)
			{
				break;
			}
		}
		sb.replace(sb.length() - 2, sb.length(), "]");
		return sb.toString();
	}
}

