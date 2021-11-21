package DataStructuresQueues;

/**
 * 
 * @author Bharat
 *
 */
// This program implements the concept of circularQueue in java 
public class CircularQueue {
	public static void main(String... args)
	{
		 circularQueue cq = new circularQueue(5);
	        System.out.println(cq.isEmpty());
	        System.out.println(cq.isFull());
	        cq.enQueue(1);
	        cq.enQueue(2);
	        cq.enQueue(3);
	        cq.enQueue(4);
	        cq.enQueue(5);

	        System.out.println(cq.dequeue());
	        System.out.println(cq.dequeue());
	        System.out.println(cq.dequeue());
	        System.out.println(cq.dequeue());
	        System.out.println(cq.dequeue());
	        System.out.println(cq.isFull());
	        System.out.println(cq.isEmpty());
	        cq.enQueue(6);
	        cq.enQueue(7);
	        cq.enQueue(8);
	        System.out.println(cq.peek());
	        System.out.println(cq.peek());
	        cq.deleteQueue();
	}
}

class circularQueue
{
	int[] arr;
	int topOfQueue;
	int begningOfQueue;
	int size;
	
	public circularQueue(int size)
	{
		arr = new int[size];
		topOfQueue = -1;
		begningOfQueue = -1;
		this.size = size;
	}
	
	public boolean isEmpty()
	{
		if(begningOfQueue == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isFull()
	{
		if(topOfQueue + 1 == begningOfQueue)
		{
			return true;
		}
		else if (topOfQueue == size - 1 && begningOfQueue == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void enQueue(int value)
	{
		if(isFull())
		{
			System.out.println("the queue is full");
		}
		else if(isEmpty())
		{
			begningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println(value + " has been succesfully inserted");
		}
		else
		{
			if(topOfQueue + 1 == size)
			{
				topOfQueue = 0;
			}
			else
			{
				topOfQueue++;
			}
			arr[topOfQueue] = value;
			System.out.println(value +" has been succesfully inserted");
		}
	}
	
	public int dequeue() 
	{
		if(isEmpty())
		{
			System.out.println("The queue is empty");
			return -1;
		}
		else
		{
			int res = arr[begningOfQueue];
			arr[begningOfQueue] = Integer.MIN_VALUE;
			if(begningOfQueue == topOfQueue)
			{
				begningOfQueue = topOfQueue = -1;
			}
			else if(begningOfQueue + 1 == size)
			{
				begningOfQueue = 0;
			}
			else
			{
				begningOfQueue++;
			}
			return res;
		}
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("the queue is Empty");
			return -1;
		}
		else 
		{
			return arr[begningOfQueue];
		}
	}
	
	public void deleteQueue()
	{
		arr = null;
		
		System.out.println("the queue is deleted");
	}
}
