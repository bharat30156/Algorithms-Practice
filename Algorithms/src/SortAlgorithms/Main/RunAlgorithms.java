package SortAlgorithms.Main;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import SortAlgorithms.*;

/**
 * 
 * @author Bharat30156
 *
 */

public class RunAlgorithms {
	
	static Sort sortingAlg = null;
	static int selectAlg = 14;
	static int linesInFile = 100000;
	static int[] numbers;
	static String fileName = Integer.toString(linesInFile) + "Random.txt";
	static String inputFileAddress = "E:\\Algorithms materials\\Random.txt";
	static String outputFileAddress = "E:\\Algorithms materials\\output text file.txt";
	static String statsFileAddress = "E:\\Algorithms materials\\stats.txt";
	
	public static void main (String[] args)
	{
		
		populateArray();
		System.out.println("text file read");
		selectAlgorithm();
		System.out.println("algorithm selected");
		
		long startTime = System.currentTimeMillis();
		sortingAlg.sort();
		long timeTaken = System.currentTimeMillis() - startTime;
		System.out.println("this algorithm took " + timeTaken + " milliseconds to sort "
						+ linesInFile + " numbers");
		numbers = sortingAlg.getNumbers();
		
		saveStats(selectAlg, timeTaken);
		storeSortedNumbers();
		
		System.exit(0);
	}
	
	public static void populatedArrayFromFile()
	{
		//populate numbers Array
		numbers = new int[linesInFile];
		
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(inputFileAddress));
			String s;
			for(int i = 0; i < linesInFile; i++)
			{
				s = reader.readLine();
				numbers[i] = Integer.parseInt(s);
			}
			reader.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void populateArray() {
	
		numbers = new int[] {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17};
	}
	
	public static void storeSortedNumbers() {
		try {
			//store numbers array in text file
			FileWriter writer = new FileWriter(outputFileAddress);
			for(int i = 0; i < linesInFile; i++) {
				writer.write(numbers[i] + System.getProperty("line.separator"));
			}
			System.out.println("sorting complete");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void selectAlgorithm() { 
		switch (selectAlg) {
		case 1:
			sortingAlg = new InsertionSort(numbers);//implemented
			break;
		case 2:
			sortingAlg = new RecursiveInsertionSort(numbers);//implemented
			break;
		case 3:
			sortingAlg = new SelectionSort(numbers);//implemented
			break;
		case 4:
			sortingAlg = new MergeSort(numbers);//implemented
			break;
		case 5:
			sortingAlg = new HeapSort(numbers);//implemented
			break;
		case 6:
			sortingAlg = new QuickSort(numbers);//implemented 
			break;
		case 7:
			sortingAlg = new BubbleSort(numbers);//implemented
			break;
		case 8:
			sortingAlg = new ShellSort(numbers);//implemented (basic)
			break;
		case 9:
			sortingAlg = new CocktailSort(numbers);//implemented
			break;
		case 10:
			sortingAlg = new CombSort(numbers);//implemented
			break;
		case 11:
			sortingAlg = new CountingSort(numbers);//implemented
			break;
		case 12:
			sortingAlg = new BucketSort(numbers);//implemented
			break;
		case 13:
			sortingAlg = new RadixSort(numbers);//implemented
			break;
		case 14:
			sortingAlg = new TimSort(numbers);//
			break;
		case 15:
			sortingAlg = new TreeSort(numbers);//
			break;
		case 16:
			sortingAlg = new SmoothSort(numbers);//
			break;
		case 17: 
			sortingAlg = new CycleSort(numbers);//
			break;
		case 18:
			sortingAlg = new BitonicSort(numbers);//
			break;
		}
	}
	
	public static void saveStats(int algId, long timeTaken) { 
		try {
			FileWriter statsWriter = new FileWriter(statsFileAddress, true);
			String output = Integer.toString(algId) + " " + Long.toString(timeTaken) + " " + linesInFile  + " " + System.getProperty("line.separator");;
			
			statsWriter.write(output);
			statsWriter.close();
		} catch (IOException e) {
			System.out.println("error writing stats");
			e.printStackTrace();
		}
	}
	
}