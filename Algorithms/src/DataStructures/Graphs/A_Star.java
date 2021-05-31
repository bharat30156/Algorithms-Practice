package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author Bharat
 *
 */
/** Time complexity is O(E)_ where E is the Number of edges**/ 
public class A_Star {
	
	private static class Graph
	{
		//Graps Structures can be changed Only applying changes to This Class
		private ArrayList<Edge>[] graph;
	
		//Intialize ArrayList in The constructor
		public Graph(int size)
		{
			this.graph = new ArrayList[size];
			for(int i = 0; i < size; i++)
			{
				this.graph[i] = new ArrayList<>();
			}
		}
		
		private ArrayList<Edge> getNeighbours(int from)
		{
			return this.graph[from];
		}
		
		// Graph is bidirectional // for just one direction remove second instruction of this second 
		public void addEdge(Edge edge)
		{
			this.graph[edge.getFrame()].add(new Edge(edge.getFrame(), edge.getTo(), edge.getWeight()));
			this.graph[edge.getTo()].add(new Edge(edge.getTo(), edge.getFrame(), edge.getWeight()));
		}
	}
	
	private static class Edge
	{
		private int from;
		private int to;
		private int weight;
		
		public Edge(int from, int to, int weight)
		{
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int getFrame()
		{
			return from;
		}
		
		public int getTo()
		{
			return to;
		}
		
		public int getWeight()
		{
			return weight;
		}
	}
	
	//Class to iterate the during the algorithm excecution and also used to return the solution 
	private static class PathAndDistance
	{
		private int distance; // distance travelled so far
		private ArrayList<Integer> Path; // list of visited node in this path
		private int estimate; // heuristic value associated to last node of the path (current node)
		
		public PathAndDistance(int distance, ArrayList<Integer> path, int estimated)
		{
			this.distance = distance;
			this.Path = path;
			this.estimate = estimate;
		}
		
		public int getDistance()
		{
			return distance;
		}
		
		public ArrayList<Integer> getPath()
		{
			return Path;
		}
		
		public int getEstimate()
		{
			return estimate;
		}
		
		public void printSolution()
		{
			if(this.Path != null)
			
				System.out.println(
						"Optimal Path : " + this.Path.toString() + ", distance : " + this.distance);
				else System.out.println("There is no path available to connect ");	
		}
	}
		
		public static void initializeGraph(Graph graph, ArrayList<Integer> data)
		{
			for(int i = 0; i < data.size(); i+= 4)
			{
				graph.addEdge(new Edge(data.get(i), data.get(i + 1), data.get(i + 2)));
			}
		}
		
		public static void main(String[] args)
		{
			int[] heuristic = {366, 0, 160, 242, 161, 178, 77, 151, 226, 244, 241, 234, 380, 98, 193, 253, 329, 80, 199, 374};
			
			Graph graph = new Graph(20);
			ArrayList<Integer> graphData = 
					new ArrayList<>(
							Arrays.asList(
									0, 19, 75, null, 0, 15, 140, null, 0, 16, 118, null, 19, 12, 71, null, 12, 15, 151,
					                null, 16, 9, 111, null, 9, 10, 70, null, 10, 3, 75, null, 3, 2, 120, null, 2, 14,
					                146, null, 2, 13, 138, null, 2, 6, 115, null, 15, 14, 80, null, 15, 5, 99, null, 14,
					                13, 97, null, 5, 1, 211, null, 13, 1, 101, null, 6, 1, 160, null, 1, 17, 85, null,
					                17, 7, 98, null, 7, 4, 86, null, 17, 18, 142, null, 18, 8, 92, null, 8, 11, 87));
			initializeGraph(graph, graphData);
			PathAndDistance solution = aStar(3, 1, graph, heuristic);
			solution.printSolution();
		}
		
		public static PathAndDistance aStar(int from, int to, Graph graph, int[] heuristsic)
		{
			// nodes rae priotrised by the less value of the current distance ofb their paths, and the 
			// estiamted value 
			// given by the heuristic function to reah the destinatin point from the current point 
			PriorityQueue<PathAndDistance> queue = 
				new PriorityQueue<>(Comparator.comparingInt(a -> (a.getDistance() + a.getEstimate())));
			
			//dummy data to start the algorithm form the beginig point 
			queue.add(new PathAndDistance(0, new ArrayList<>(Arrays.asList(from)), 0));
			
			boolean solutionFound = false;
			PathAndDistance currentData = new PathAndDistance(-1, null, -1);
			while(!queue.isEmpty() && !solutionFound)
			{
				currentData = queue.poll(); // first in the queue best node so keep exploring 
				int currentPosition = 
						currentData.getPath().get(currentData.getPath().size() - 1); // current node
				if(currentPosition == to) solutionFound = true;
				else
					for(Edge edge : graph.getNeighbours(currentPosition))
						if(!currentData.getPath().contains(edge.getTo()))
						{
							ArrayList<Integer> updatedPath = new ArrayList<>(currentData.getPath());
							updatedPath.add(edge.getTo()); // Add the new node to the path update the distance,
							// and the heuristic value function assciatted to that path 
							queue.add(
									new PathAndDistance(
											currentData.getDistance() + edge.getWeight(),
											updatedPath,
											heuristsic[edge.getTo()]));
						}
			}
			return (solutionFound) ? currentData : new PathAndDistance(-1, null, -1);
			
			
		}
		
	
	
	

}

