package DataStructures.Graphs;

import java.util.ArrayList;

class AjacencyListGraph<E extends Comparable<E>>
{
	ArrayList<Vertex> verticies;
	
	public AjacencyListGraph()
	{
		verticies = new ArrayList<>();
	}
	
	private class Vertex
	{
		E data;
		ArrayList<Vertex> adjacentVerticies;
		
		public Vertex(E data)
		{
			adjacentVerticies = new ArrayList();
			this.data = data;
		}
		
		public boolean addAdjacentVeretx(Vertex to)
		{
			for(Vertex v : adjacentVerticies)
			{
				if(v.data.compareTo(to.data) == 0)
				{
					return false; // the edge already exists
				}
			}
			return adjacentVerticies.add(to); // this will return true
		}
		
		public boolean removeAdjacentVertex(E to)
		{
			// use indexes here so it is possible to 
			// remove easily without implementing 
			// equals methid that ArrayList.remove(Object o) uses
			for(int i = 0; i < adjacentVerticies.size(); i++)
			{
				if(adjacentVerticies.get(i).data.compareTo(to) == 0)
				{
					adjacentVerticies.remove(i);
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 *  this method an edge form the graph between two specified veticies 
	 *  
	 *  @param from the dtaa of the vertex the edge is from 
	 *  @param to the data of the vertex the edge is going to 
	 *  @return return false if the edge doesn't exists return true of the edge exist and removed  
	 */
	public boolean removeEdge(E from, E to)
	{
		Vertex fromV = null;
		for(Vertex v :verticies)
		{
			if(from.compareTo(v.data) == 0)
			{
				fromV = v;
				break;
			}
		}
		if(fromV == null) return false;
		return fromV.removeAdjacentVertex(to);
	}
	
	/**
	 * this method adds an edge to the graph between two specified verticies 
	 * 
	 * @param form the data of the veretx the edge is from 
	 * @param to the data of the veretex the dge is going to 
	 * @return returns true if the edge did not exists, return false if it already did 
	 */
	
	public boolean addEdge(E from, E to)
	{
		Vertex fromV = null, toV = null;
		for(Vertex v : verticies)
		{
			if(from.compareTo(v.data) == 0)
			{
				fromV = v;
			}
			else if(to.compareTo(v.data) == 0)
			{
				toV = v;
			}
			if(fromV != null && toV != null) break;
		}
		if(fromV == null)
		{
			fromV = new Vertex(from);
			verticies.add(fromV);
		}
		if(toV == null)
		{
			toV = new Vertex(to);
			verticies.add(toV);
		}
		return fromV.addAdjacentVeretx(toV);
	}
	
	/**
	 *  this gives of verticies ion the graph and their adjacencies
	 *  
	 *  @return return a string describing this graph
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(Vertex v : verticies)
		{
			sb.append("Vertex: ");
			sb.append(v.data);
			sb.append("\n");
			sb.append("Adjacent verticies : ");
			for(Vertex v2 : v.adjacentVerticies)
			{
				sb.append(v2.data);
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}

	public class Graphs 
	{
		public static void main(String... args)
		{
			AjacencyListGraph<Integer> graph = new AjacencyListGraph<>();
			assert graph.addEdge(1, 2);
			assert graph.addEdge(1, 5);
			assert graph.addEdge(2, 5);
			assert !graph.addEdge(1, 2);
			assert graph.addEdge(2, 3);
			assert graph.addEdge(3, 4);
			assert graph.addEdge(4, 1);
			assert !graph.addEdge(2, 3);
			System.out.println(graph);
		}
	}
