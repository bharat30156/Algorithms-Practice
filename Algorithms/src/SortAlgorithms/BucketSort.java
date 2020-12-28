package SortAlgorithms;

import java.util.ArrayList;

/**
 * 
 * BUCKET SORT
 * This method is excepted to be slower but far more memory-efficient as well as being more stable.
 * Also it is more to read and maintain therefore it's used more in production environment 
 *
 */
public class BucketSort extends Sort {
	
	/**
	 * To Do
	 * arrayList implementation
	 * verify if individual ArrayList need to be initialized in 2d list
	 * or if  they exist automatically
	 */
	
	public BucketSort(int[] arr)
	{
		super(arr);
	}
	
	public void Sort()
	{
		bucketSortArrayListImplementation();
	}
	
	void bucketSortArrayListImplementation()
	{
		ArrayList<Integer> rtn = new ArrayList<>();
		int bucketSize = (int) Math.sqrt(this.size) + 1;
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
		
		//To Do verify if following section is necessary
		for(int i = 0; i < buckets.size(); i++)
		{
			buckets.add(new ArrayList<Integer>());
		}
		
		//fill the buckets with associated numbers
		for(int i = 0; i < this.size; i++)
		{
			buckets.get(this.numbers[i] / bucketSize).add(this.numbers[i]);
		}
		
		//Sort bucket
		for(int i = 0; i < buckets.size(); i++)
		{
			buckets.get(i).sort(null);
			for(int j = 0; j < buckets.get(i).size(); j++)
			{
				rtn.add(buckets.get(i).get(j));
			}
		}
		//return values
		
		for(int i = 0; i < this.size; i++)
		{
			this.numbers[i] = rtn.get(i);
		}
		
		
	}

}
