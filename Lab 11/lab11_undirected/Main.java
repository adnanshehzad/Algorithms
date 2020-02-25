package lab11_undirected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.sun.beans.editors.ShortEditor;

public class Main {

	public static void main(String[] args) {
		List<Edge> l = new ArrayList<Edge>();
		l.add(new Edge("A","B"));
		l.add(new Edge("B","C"));
		l.add(new Edge("A","C"));
		l.add(new Edge("C","D"));
		l.add(new Edge("F","E"));

		Graph g = new Graph(l);
		String s = g.toString();
		System.out.println("The main graph:\n "+s);
		System.out.println("Are B and C adjacent? "+g.areAdjacent(new Vertex("B"),new Vertex("C")));
		System.out.println("Are A and C adjacent? "+g.areAdjacent(new Vertex("A"),new Vertex("C")));
		System.out.println("The spanning tree/forest:");
		Graph t = g.getSpanningTree();
		System.out.println(t);
		
		System.out.println("Is the graph connected?");
		System.out.println(g.isConnected());

		System.out.println("Does the graph have cycle?");
		System.out.println(g.containsCycle());
		
		System.out.println("Is there a path?");
		System.out.println(g.hasPathBetween(new Vertex("A"),new Vertex("F")));
		System.out.println(g.hasPathBetween(new Vertex("A"),new Vertex("D")));
		
		//Note: Shortest Path Alg assumes G is connected
		List<Edge> list = new ArrayList<Edge>();
		list.add(new Edge("A","B"));
		list.add(new Edge("B","C"));
		list.add(new Edge("A","C"));
		list.add(new Edge("C","D"));

		Graph cg = new Graph(list);
		Vertex start = new Vertex("A");
		Vertex end = new Vertex("D");
		System.out.println("Shortest Path/Shortest Path Length:");
		System.out.println(g.shortestPathLength(start, end));
	}
}
