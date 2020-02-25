package lab11_undirected;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	Graph spanningTree;
	LinkedList<Vertex> vertices = new LinkedList<Vertex>();
	LinkedList<Edge> edges = new LinkedList<Edge>();
	HashMap<Vertex,LinkedList<Vertex>> adjList = new HashMap<Vertex,LinkedList<Vertex>>();
	/* new public methods */

	public Graph(List<Edge> inputEdges) {
		HashMap<Vertex,Vertex> dupverts = new HashMap<Vertex,Vertex>();

		for(Edge e: inputEdges) {
			//assume no dup edges
			edges.add(e);
			Vertex v1 = e.u;
			Vertex v2 = e.v;
			if(!dupverts.containsKey(v1)){
				dupverts.put(v1,v1);
				vertices.add(v1);

			}
			if(!dupverts.containsKey(v2)){
				dupverts.put(v2,v2);
				vertices.add(v2);

			}
			LinkedList<Vertex> l = adjList.get(v1);
			if(l == null) {
				l = new LinkedList<Vertex>();
			}
			l.add(v2);
			adjList.put(v1,l);

			LinkedList<Vertex> l2 = adjList.get(v2);
			if(l2 == null) {
				l2 = new LinkedList<Vertex>();
			}
			l2.add(v1);
			adjList.put(v2,l2);

		}
	}

	public Graph getSpanningTree() {
		if(spanningTree == null){
			FindSpanningTree fst = new FindSpanningTree(this);
			spanningTree = fst.computeSpanningTree();
		}
		return spanningTree;
	}

	public List<Edge> edges() {
		return edges;
	}

	//TO-DO
	public boolean isConnected() {
		return false;
	}
	//TO-DO
	public boolean hasPathBetween(Vertex u, Vertex v) {
		return false;
	}
	//TO-DO
	public boolean containsCycle() {
		return false;
	}
	//TO-DO
    int shortestPathLength(Vertex u, Vertex v) {
    	return -1;
    }

	/**
	 * Important to return only a copy of the adjacency list. Running time for making
	 * this copy: For each vertex v, the number of adjacent vertices to v that need to
	 * be copied into a new list (matched with v in the copy of the map) is deg v. Also, each
	 * vertex is processed (cloned and the clone is added to its list); processing is O(1) Therefore,
	 * it is the sum over v in V of 1 + deg(v), which is O(n+m).
	 */
	public HashMap<Vertex,LinkedList<Vertex>> getAdjacencyList() {
		HashMap<Vertex,LinkedList<Vertex>> copy = new HashMap<Vertex,LinkedList<Vertex>>();
		for(Vertex v : adjList.keySet()) {
			//LinkedList<Vertex> original = adjList.get(v);
			copy.put(v, getListOfAdjacentVerts(v));

		}
		return copy;

	}

	/**
	 * Returns a copy of the list of adjacent vertices
	 */
	public LinkedList<Vertex> getListOfAdjacentVerts(Vertex v) {
		List<Vertex> theList = adjList.get(v);
		LinkedList<Vertex> copy = new LinkedList<Vertex>();
		if (theList != null) {
			for(Vertex vert : theList) {
				copy.add(vert.clone());
			}
		}
		return copy;
	}

	public boolean areAdjacent(Vertex v, Vertex w) {
		LinkedList<Vertex> l = adjList.get(v);
		if(l == null) return false;
		return l.contains(w);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder("Vertices: \n"+" ");
		for(Vertex v : vertices) {
			sb.append(v+" ");
		}
		sb.append("\nEdges:\n"+" ");
		sb = appendEdgesToString(this,sb);
		return sb.toString();
	}
	private StringBuilder appendEdgesToString(Graph g, StringBuilder sb) {
		HashMap<String,String> dups = new HashMap<String,String>();
		List<Vertex> verts = g.vertices;

		for(Vertex v: verts){
			LinkedList<Vertex> l  = g.adjList.get(v);

			for(Vertex w : l){
				String edge = v.toString()+"-"+w.toString();
				String edgeRev = reverse(edge);
				if(!dups.containsKey(edge) && !dups.containsKey(edgeRev)){
					sb.append(edge+" ");
					dups.put(edge,edge);
				}
			}
		}
		return sb;
	}
	private String reverse(String edge) {
		String[] vals = edge.split("-");
		return vals[1]+"-"+vals[0];
	}

	public boolean isTree(){
		if (isConnected() && !containsCycle())
			return true;
		else
			return false;

	}
}
