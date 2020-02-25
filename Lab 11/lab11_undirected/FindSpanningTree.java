package lab11_undirected;

import java.util.*;

//This class finds spanning tree/forest for a graph
public class FindSpanningTree extends BreadthFirstSearch {
	private ArrayList<Edge> tree = new ArrayList<Edge>();
	public FindSpanningTree(Graph graph) {
		super(graph);
	}
	protected void processEdge(Edge e) {
			tree.add(e);
	}

	public Graph computeSpanningTree() {
		start();
		return new Graph(tree);
	}



}
