package DataStructures.Graphs;

import java.util.Scanner;

public class FloydWarshall {
	private int DistanceMatrix[][];
	private int numberofvertices; // number of vertices in the graph
	public static final int INFINITY = 999;
	
	public FloydWarshall(int numberofvertices)
	{
		DistanceMatrix =
				new int [numberofvertices + 1][numberofvertices + 1]; // stores the value of distance from all possible path from the source 
		// vertex to destination vertex 
		// The matrix is initalized with 0's by default 
		this.numberofvertices = numberofvertices;
	}
	
	public void floydwarshall(int AdjacencyMatrix[][]) // calculates all the disatnce from source to destionation vertex 
	{
		for(int source = 1; source <= numberofvertices; source++)
		{
			for(int destination = 1; destination <= numberofvertices; destination++)
			{
				DistanceMatrix[source][destination] = AdjacencyMatrix[source][destination];
			}
		}
		for(int intermediate = 1; intermediate <= numberofvertices; intermediate++)
		{
			for(int source = 1; source <= numberofvertices; source++)
			{
				for(int destination = 1; destination <= numberofvertices; destination++)
				{
					if(DistanceMatrix[source][intermediate] + DistanceMatrix[intermediate][destination] < DistanceMatrix[source][destination])
					{
						// if the new distance is calculated is less than the earlier shortest 
						// calculated distance it get replaced as new shortest distance 
						DistanceMatrix[source][destination] = DistanceMatrix[source][intermediate] + DistanceMatrix[intermediate][destination];
					}
				}
			}
		}
		for(int source = 2; source <= numberofvertices; source++) System.out.println("\t" + source);
		System.out.println();
		for(int source = 1; source <= numberofvertices; source++)
		{
			System.out.println(source + "\t");
			for(int destination = 1; destination <= numberofvertices; destination++)
			{
				System.out.println(DistanceMatrix[source][destination] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String... arg)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of vertices ");
		int numberOfVertices = scan.nextInt();
		int[][] adjacencyMatrix = new int[numberOfVertices + 1][numberOfVertices + 1];
		System.out.println("Enter the weighted Matrix for the Graph ");
		for(int source = 1; source <= numberOfVertices; source++)
		{
			for(int destination = 1; destination <= numberOfVertices; destination++)
			{
				adjacencyMatrix[source][destination] = scan.nextInt();
				if(source == destination)
				{
					adjacencyMatrix[source][destination] = 0;
					continue;
				}
				if(adjacencyMatrix[source][destination] == 0)
				{
					adjacencyMatrix[source][destination] = INFINITY;
				}
			}
		}
		System.out.println("The transitive closure of the graph ");
		FloydWarshall floydwarshall = new FloydWarshall(numberOfVertices);
		floydwarshall.floydwarshall(adjacencyMatrix);
		scan.close();
	}
	
}
