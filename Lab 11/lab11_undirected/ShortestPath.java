package lab11_undirected;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ShortestPath extends BreadthFirstSearch {
	private HashMap<Vertex, Integer> levelsMap = new HashMap<Vertex, Integer>();
	private HashMap<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();

	/** Assumes g is connected */
	public ShortestPath(Graph g) {
		super(g);

	}
	//TO-DO
	public int computeShortestPathLength(Vertex s, Vertex v) {
		return -1;
	}
}
