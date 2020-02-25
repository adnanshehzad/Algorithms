package lab11_undirected;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;



public class BreadthFirstSearch extends AbstractGraphSearch {
	protected HashMap visitedVertices = new HashMap();
	HashMap<Vertex,LinkedList<Vertex>> adjacencyList;
	Graph graph;
	Queue<Vertex> queue;
	Vertex current;

	List<Vertex> vertices = null;
	Iterator<Vertex> iterator = null;
	protected int numVertices;

	public BreadthFirstSearch(Graph graph){
		queue = new LinkedList<Vertex>();
		this.graph=graph;
		vertices =graph.vertices;
		iterator = vertices.iterator();
		numVertices = vertices.size();
		//this is a copy, so we can modify it - O(n+m) to acquire this
		adjacencyList = graph.getAdjacencyList();
	}
	protected void resetVisitedVertices() {
		visitedVertices.clear();
	}

	protected void resetVertexIterator() {
		iterator = vertices.iterator();
	}

	@Override
	protected void handleInitialVertex(){
		Vertex v = nextUnvisited();
		handleInitialVertex(v);
	}
	//Gives option to set starting vertex
	protected void handleInitialVertex(Vertex v) {
		if(v != null){
			setHasBeenVisited(v);
			processVertex(v);
			makeVertexCurrent(v);
		}
	}

	protected void makeVertexCurrent(Vertex v) {
		current = v;
	}

	@Override
	protected void singleComponentLoop(){
		while(current != null){
			Vertex nextAdj = null;
			while((nextAdj = nextUnvisitedAdjacent(current)) != null) {
				setHasBeenVisited(nextAdj);
				processEdge(new Edge(nextAdj,current));
				processVertex(nextAdj);
				queue.add(nextAdj);

			}
			current = queue.poll();
		}
	}

	@Override
	protected boolean someVertexUnvisited(){
		return visitedVertices.size() < numVertices;
	}

	@Override
	protected void additionalProcessing() {
		//by default do nothing
	}


	protected void processEdge(Edge e) {
		//override for needed functionality
	}
	protected void processVertex(Vertex w){

		//should be overridden; by default, do nothing
	}
	public boolean hasBeenVisited(Vertex v) {
		return visitedVertices.containsKey(v);
	}
	public void setHasBeenVisited(Vertex v) {
		visitedVertices.put(v,v);
	}
	public Vertex nextUnvisited() {
		while(iterator.hasNext()){
			Vertex next = iterator.next();
			if(!visitedVertices.containsKey(next)){
				return next;

			}
		}
		return null;
	}
	public Vertex nextUnvisitedAdjacent(Vertex v) {
		List<Vertex> listOfAdjacent = adjacencyList.get(v);
		Iterator<Vertex> it = listOfAdjacent.iterator();
		Vertex retVert = null;
		//this loop will execute only once for each vertex v
		//since whenever a vertex is encountered, it is removed after processing
		while(it.hasNext()) {
			Vertex u = it.next();
			if(visitedVertices.containsKey(u)) {
				it.remove();
			}
			if(!visitedVertices.containsKey(u)) {
				retVert = u;
				it.remove();
				return retVert;
			}
		}
		//unvisited adjacent vertex not found
		return retVert;  //returning null
	}

}
