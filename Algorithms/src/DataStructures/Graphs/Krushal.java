package DataStructures.Graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

// problems -> Connect all the edges with minimum cost.
// possible Solution -> krushal algorithm (KA) , KA finds the minimum-spanning-tree which means the 
// group of edges with the minimum sum of their weights that connect the whole graph 
// the graph needs to be conncted, because is there are nodes impossible to reach, there are no 
// edge taht could connect every node in the graph 
// KA is greedy Algorithm, because edges are analysed based opn their weights that is why a 
// priority Queue is used to take first those less weighted 
// This implementation below has gone changes compared to conventional one, but they are explained 

public class Krushal {
	
	// complexity : O(E log V) times, where E is the number of edges in the 
	// graph and V is number of verticies
	
	private static class Edge {
	    private int from;
	    private int to;
	    private int weight;

	    public Edge(int from, int to, int weight) {
	      this.from = from;
	      this.to = to;
	      this.weight = weight;
	    }
	  }

	  private static void addEdge(HashSet<Edge>[] graph, int from, int to, int weight) {
	    graph[from].add(new Edge(from, to, weight));
	  }

	  public static void main(String[] args) {
	    HashSet<Edge>[] graph = new HashSet[7];
	    for (int i = 0; i < graph.length; i++) {
	      graph[i] = new HashSet<>();
	    }
	    addEdge(graph, 0, 1, 2);
	    addEdge(graph, 0, 2, 3);
	    addEdge(graph, 0, 3, 3);
	    addEdge(graph, 1, 2, 4);
	    addEdge(graph, 2, 3, 5);
	    addEdge(graph, 1, 4, 3);
	    addEdge(graph, 2, 4, 1);
	    addEdge(graph, 3, 5, 7);
	    addEdge(graph, 4, 5, 8);
	    addEdge(graph, 5, 6, 9);

	    System.out.println("Initial Graph: ");
	    for (int i = 0; i < graph.length; i++) {
	      for (Edge edge : graph[i]) {
	        System.out.println(i + " <-- weight " + edge.weight + " --> " + edge.to);
	      }
	    }

	    Krushal k = new Krushal();
	    HashSet<Edge>[] solGraph = k.kruskal(graph);

	    System.out.println("\nMinimal Graph: ");
	    for (int i = 0; i < solGraph.length; i++) {
	      for (Edge edge : solGraph[i]) {
	        System.out.println(i + " <-- weight " + edge.weight + " --> " + edge.to);
	      }
	    }
	  }

	  public HashSet<Edge>[] kruskal(HashSet<Edge>[] graph) {
	    int nodes = graph.length;
	    int[] captain = new int[nodes];
	    // captain of i, stores the set with all the connected nodes to i
	    HashSet<Integer>[] connectedGroups = new HashSet[nodes];
	    HashSet<Edge>[] minGraph = new HashSet[nodes];
	    PriorityQueue<Edge> edges = new PriorityQueue<>((Comparator.comparingInt(edge -> edge.weight)));
	    for (int i = 0; i < nodes; i++) {
	      minGraph[i] = new HashSet<>();
	      connectedGroups[i] = new HashSet<>();
	      connectedGroups[i].add(i);
	      captain[i] = i;
	      edges.addAll(graph[i]);
	    }
	    int connectedElements = 0;
	    // as soon as two sets merge all the elements, the algorithm must stop
	    while (connectedElements != nodes && !edges.isEmpty()) {
	      Edge edge = edges.poll();
	      // This if avoids cycles
	      if (!connectedGroups[captain[edge.from]].contains(edge.to)
	          && !connectedGroups[captain[edge.to]].contains(edge.from)) {
	        // merge sets of the captains of each point connected by the edge
	        connectedGroups[captain[edge.from]].addAll(connectedGroups[captain[edge.to]]);
	        // update captains of the elements merged
	        connectedGroups[captain[edge.from]].forEach(i -> captain[i] = captain[edge.from]);
	        // add Edge to minimal graph
	        addEdge(minGraph, edge.from, edge.to, edge.weight);
	        // count how many elements have been merged
	        connectedElements = connectedGroups[captain[edge.from]].size();
	      }
	    }
	    return minGraph;
	  }
	}