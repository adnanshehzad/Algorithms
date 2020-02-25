package lab11_undirected;

public abstract class AbstractGraphSearch {
	public void start(){
	
		while(someVertexUnvisited()) {	
			//picks an unvisited vertex and marks it
			handleInitialVertex();		
			
			//Starting from initial vertex s, marked as visited, 
			//adds one vertex at a time to the collection of visited vertices
			//by choosing (in unspecified way) next vertex that is adjacent
			//to some visited vertex
			//GENERIC ALGORITHM:
			// - initialize VISITED collection, inserting start vertex s
			// - for each edge (v,w), 
			//      if v in VISITED and w unvisited
			//          add w to VISITED
			//THEOREM: v is in VISITED if and only if there is a path in G
			//from s to v
			singleComponentLoop();	
			
			//performs necessary processing (for subclasses) between completions 
			//of successive components
			additionalProcessing();
		}
	}
	//for the case where we want to specify start vertex
	public void start(Vertex s){
		do {
			if(!hasBeenVisited(s)) 
				handleInitialVertex(s);
			else 
				handleInitialVertex();
			
			//Starting from initial vertex s, marked as visited, 
			//adds one vertex at a time to the collection of visited vertices
			//by choosing (in unspecified way) next vertex that is adjacent
			//to some visited vertex
			//GENERIC ALGORITHM:
			// - initialize VISITED collection, inserting start vertex s
			// - for each edge (v,w), 
			//      if v in VISITED and w unvisited
			//          add w to VISITED
			//THEOREM: v is in VISITED if and only if there is a path in G
			//from s to v
			singleComponentLoop();	
			
			//performs necessary processing (for subclasses) between completions 
			//of successive components
			additionalProcessing();
		} while(someVertexUnvisited());
	}
	protected abstract boolean hasBeenVisited(Vertex v);
	protected abstract boolean someVertexUnvisited();
	protected abstract void handleInitialVertex();
	protected abstract void handleInitialVertex(Vertex start);
	protected abstract void singleComponentLoop();
	protected abstract void additionalProcessing();
}
