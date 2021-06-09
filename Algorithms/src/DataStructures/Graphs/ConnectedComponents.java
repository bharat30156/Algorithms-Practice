package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Bharat
 *
 * A class that coinnects the number of different connected coimponenets in graph 
 *  
 */

class Graph<E extends  Comparable<E>>
{
	class Node
	{
		E name;
		
		public Node(E name)
		{
			this.name = name;
		}
	}
	
	class Edge
	{
		Node startNode, endNode;
		
		public Edge(Node startNode, Node endNode)
		{
			this.startNode = startNode;
			this.endNode = endNode;
		}
	}
	
	ArrayList<Edge> edgeList;
	ArrayList<Node> nodeList;
	
	public Graph()
	{
		edgeList = new ArrayList<Edge>();
		nodeList = new ArrayList<Node>();
	}
	
	public void addEdge(E startNode, E endNode)
	{
		Node start = null, end = null;
		for(Node node : nodeList)
		{
			if(startNode.compareTo(node.name) == 0)
			{
				start = node;
			}
			else if (endNode.compareTo(node.name) == 0)
			{
				end = node;
			}
		}
		if(start ==  null)
		{
			start = new Node(startNode);
			nodeList.add(start);
		}
		if(end == null)
		{
			end = new Node(endNode);
			nodeList.add(end);
		}
		edgeList.add(new Edge(start, end));
	}
	
	/**
	 * Main method used for counting the connected components. Iterate through the array of nodes to
	 * do a depth first serach to get all nodes of the graph from actual node. These node are added to the array
	 * makedNodes and will be ignored if they are chosen in the nodelistl.
	 * 
	 *  @return the amount of unconnected Graph
	 */
	public int countGraph()
	{
		int count = 0;
		Set<Node> markedNodes = new HashSet<Node>();
		
		for(Node n : nodeList)
		{
			if(!markedNodes.contains(n))
			{
				markedNodes.add(n);
				markedNodes.addAll(depthFirstSearch(n, new ArrayList<Node>()));
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Implemenatation of depth first search
	 * 
	 * @param n the actual visting node 
	 * @param visited A list of already visisted nodes in the depth first search 
	 * @return resturn a set of visited nodes 
	 */
	public ArrayList<Node> depthFirstSearch(Node n, ArrayList<Node> visited)
	{
		visited.add(n);
		for(Edge e : edgeList)
		{
			if(e.startNode.equals(n) && !visited.contains(e.endNode))
			{
				depthFirstSearch(e.endNode, visited);
			}
		}
		return visited;
	}
}


public class ConnectedComponents {
	public static void main(String[] args)
	{
		Graph<Character> graphChars = new Graph<>();
		
		//Graph 1
		graphChars.addEdge('a', 'b');
		graphChars.addEdge('a', 'e');
		graphChars.addEdge('b', 'e');
		graphChars.addEdge('b', 'c');
		graphChars.addEdge('c', 'd');
		graphChars.addEdge('d', 'a');
		
		graphChars.addEdge('x', 'y');
		graphChars.addEdge('x', 'z');
		
		graphChars.addEdge('w', 'w');
		
		Graph<Integer> graphInts = new Graph<>();
		
		//Graph 2
		graphInts.addEdge(1, 2);
		graphInts.addEdge(2, 3);
		graphInts.addEdge(2, 4);
		graphInts.addEdge(3, 5);
		
		graphInts.addEdge(7, 8);
		graphInts.addEdge(8, 10);
		graphInts.addEdge(10, 8);
		
		System.out.println("Amount of differnt char-graph " + graphChars.countGraph());
		System.out.println("Amopunt of differnt int-graph " + graphInts.countGraph());
	}

}
