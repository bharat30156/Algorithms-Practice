package DataStructures.Graphs;

import java.util.Scanner;

class BellmanFord {
	/**
	 * Implementation of bellmanFord to detect negative cycle. Graph accepts inputs in form of edges which have 
	 * start vertex, end vertex and weights. vertex should be labelled with a anumber between 0 and total number  of veretices-1 both inclusive 
	 */
	
	int vertex, edge;
	private Edge edges[];
	private int index = 0;
	
	BellmanFord(int v, int e)
	{
		vertex = v;
		edge = e;
		edges = new Edge[e];
	}
	
	class Edge
	{
		int u, v;
		int w;
		/**
		 * @param u source vertex
		 * @param v end vertex
		 * @param c weight 
		 */
		public Edge(int a, int b, int c)
		{
			u = a;
			v = b;
			w = c;
		}
	}
	
	/**
	 * @param p[] parent array which show updates in edges
	 * @param i current vertex under consideration 	 
	 */
	void printPath(int p[], int i)
	{
		if(p[i]  == -1) //Found the path back to parent
			return;
		printPath(p, p[i]);
		System.out.println(i + " ");
	}
	
	public static void main(String[] args)
	{
		BellmanFord obj = new BellmanFord(0, 0);
		obj.go();
	}
	
	public void go() // Interactive run for understanding the class first time. Assume source vertex is 0 and shows the distance to all veterx 
	{
		Scanner sc = new Scanner(System.in);
		int i, v, e, u, ve, w, j, neg = 0;
		System.out.println("Enter no. of vertices and edges please");
		v = sc.nextInt();
		e = sc.nextInt();
		Edge arr[] = new Edge[e]; // Array of edges
		System.out.println("Input Edges ");
		for(i = 0; i < e; i++)
		{
			u = sc.nextInt();
			ve = sc.nextInt();
			w = sc.nextInt();
			arr[i] = new Edge(u, ve, w);
		}
		int dist[] = 
				new int
				[v]; // distance array for holding the finalised shortest path distance between source amd all vertices 
		int p[] = new int[v]; // Parent array for holding the path
		for(i = 0; i < v; i++) dist[i] = Integer.MAX_VALUE;
		
			dist[0] = 0;
			p[0] = -1;
			for(i = 0; i < v - 1; i++)
			{
				for(j =0; j < e; j++)
				{
					if((int) dist[arr[j].u] != Integer.MAX_VALUE
							&& dist[arr[j].v] > dist[arr[j].u] + arr[j].w)
					{
						dist[arr[j].v] = dist[arr[j].u] + arr[j].w; // Update
						p[arr[j].v] = dist[arr[j].u] + arr[j].w; // Update
						p[arr[j].v] = arr[j].u;
					}
				}
			}
			// fnal cycle for negatve checking 
			for(j = 0; j < e; j++)
				if((int) dist[arr[j].u] != Integer.MAX_VALUE && dist[arr[j].v] > dist[arr[j].u] + arr[j].w)
				{
					neg = 1;
					System.out.println("Negative cycle ");
					break;
				}
				if(neg == 0) // go ahead ad show result of computation 
				{
					System.out.println("Distance are : ");
					for(i = 0; i < v; i++) System.out.println(i + " " + dist[i]);
					System.out.println("Path followed ");
					for(i = 0; i < v; i++)
					{
						System.out.println("0 ");
						printPath(p, i);
						System.out.println();
					}
				}
				sc.close();
			}
	/**
	 * @param source starting vertex
	 * @param end ending vertex
	 * @param Edge Array of edges 
	 */
	public void show(int source, int end, Edge arr[]) // just shows of computrations, if graph is passed to it. the should be created by using addEdge( method and passed by calling getEdgeArray() method
	{
		int i, j, v = vertex, e = edge, neg = 0;
		double dist[] = 
				new double
				[v]; // Distance array for holding the finalized shortest path distance between source 
		// and all vertices 
		int p[] = new int[v]; // Parent array for holding the paths
		for(i = 0; i < v; i++) dist[i] = Integer.MAX_VALUE; // Initializing distance values 
		dist[source] = 0;
		p[source] = -1;
		for(i = 0; i < v - 1; i++)
		{
			for(j = 0; j < e; j++)
			{
				if((int) dist[arr[j].u] != Integer.MAX_VALUE
						&& dist[arr[j].v] > dist[arr[j].u] + arr[j].w)
				{
					dist[arr[j].v] = dist[arr[j].u] + arr[j].w; //Update
					p[arr[j].v] = arr[j].u;
				}
			}
		}
		// final cycle for negative checking 
		for(j = 0; j < e; j++)
		
			if((int) dist[arr[j].u] != Integer.MAX_VALUE && dist[arr[j].v] > dist[arr[j].u] + arr[j].w)
			{
				neg = 1;
				System.out.println("Negatve Cycle");
				break;
			}
			if(neg == 0)
			{
				System.out.println("distance is " + dist[end]);
				System.out.println("path followed: ");
				System.out.println(source + " ");
				printPath(p, end);
				System.out.println();
			}
		}
	/**
	 * @param x source vertex
	 * @param y end vertex
	 * @param z weight
	 */
	public void addEdge(int x, int y, int z)
	{
		edges[index++] = new Edge(x, y, z);
	}
	
	public Edge[] getEdgeArray()
	{
		return edges;
	}
		
}
			
		
	


