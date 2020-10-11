package splar.core.util.hypergraphs;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

public class Hypergraph {

	private Set<Vertex> vertices;
	private Collection<Hyperedge> hyperEdges;
	
	public Hypergraph() {
		vertices = new LinkedHashSet<Vertex>();
		hyperEdges = new Vector<Hyperedge>();
	}
	
	public Set<Vertex> getVertices() {
		return vertices;
	}
	
	public Collection<Hyperedge> getHyperedges() {
		return hyperEdges;
	}
	
	public Vertex getVertexByName(String name) {
		for( Vertex v : vertices ) {
			if ( v.getName().equals(name) ) {
				return v;
			}
		}
		return null;
	}
	
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
	}
	
	public void addVertices(Set<Vertex> vertices) {
		this.vertices.addAll(vertices);
	}
	
	public void addHyperEdge(Hyperedge hyperedge) {
		hyperEdges.add(hyperedge);
	}
	
	public void getHyperEdgesThatContainsVertex( Vertex vertex, Collection<Hyperedge> hyperEdgesSet ) {
		for( Iterator<Hyperedge> it = hyperEdges.iterator(); it.hasNext() ; ) {
			Hyperedge curHyperEdge = it.next();
			if ( curHyperEdge.containsVertex(vertex) ) { 
				if ( !hyperEdgesSet.contains(curHyperEdge) ) {
					hyperEdgesSet.add(curHyperEdge);
				}
			}
		}
	}
	
	/*
	 * Set Union operation on hyperedges
	 */
	public Hyperedge mergeHyperedges(Collection<Hyperedge> hyperEdgesSet ) {
		if ( hyperEdgesSet.size() > 0 ) {
			Hyperedge mergedHyperedgesSet = new Hyperedge();
			for( Iterator<Hyperedge> it = hyperEdgesSet.iterator(); it.hasNext() ; ) {
				Hyperedge curHyperEdge = it.next();
				mergedHyperedgesSet.addAllHyperedgeVertices(curHyperEdge);
				hyperEdges.remove(curHyperEdge);
			}
			hyperEdges.add(mergedHyperedgesSet);
			return mergedHyperedgesSet;
		}
		return null;
	}
	
	/*
	 * Merge hypergraphs H1 into hypergraph H2   
	 * The final H2 hypergraph will contain:
	 * vertices = H2 + H1 vertices (unique set)
	 * hyperedges = H1 hyperedges are used to combine H2 hyperedges in larger sets
	 *   E.g. H1 hyperedges: {a,b,c} 
	 *        H2 hyperedges: {a,c}, {c,d,e}, {b,f}
	 *        merged H2 hyperedges {a,b,c,d,e,f}  
	 */
	public void merge( Hypergraph inputGraph ) {
		
		// add all vertices from inputGraph into the hypergraph
		for( Iterator<Vertex> it = inputGraph.vertices.iterator(); it.hasNext() ; ) {
			Vertex vertex = it.next();
			addVertex(vertex);
		}
		
		// merge inputGraph's hyperedges with the this hypergraph's hyperedges
		for( Iterator<Hyperedge> it = inputGraph.hyperEdges.iterator(); it.hasNext() ; ) {
			Hyperedge hyperEdge = it.next();
			// traverse each hyperEdge of the inputGraph individually
			Vector<Hyperedge> selectedHyperEdges = new Vector<Hyperedge>();
			for( Iterator<Vertex> it2 = hyperEdge.getVertices().iterator(); it2.hasNext() ; ) {
				// for each vertex, check the hyperedges that contains a reference to it
				Vertex vertex = it2.next();
				getHyperEdgesThatContainsVertex(vertex, selectedHyperEdges );
			}
			selectedHyperEdges.add(hyperEdge);
			mergeHyperedges(selectedHyperEdges);
		}
		
	}
	
	public Hypergraph projection(Hypergraph projectedHypergraph) {
		
		// TH - target hypergraph
		// PH - projected hypergraph
		// RH - resultant hypergraph
		
		Hypergraph resultantHypergraph = new Hypergraph();
		
		// Each TH hyperedge will become a vertex on RH
		for( Iterator<Hyperedge> it = hyperEdges.iterator(); it.hasNext() ; ) {
			Hyperedge hyperEdge = it.next();
			resultantHypergraph.addVertex(hyperEdge);
		}

		// traverse PH hyperedges 
		for( Iterator<Hyperedge> it = projectedHypergraph.getHyperedges().iterator(); it.hasNext() ; ) {
			Hyperedge hyperEdge = it.next();
			Hyperedge newHyperEdge = new Hyperedge();
			// checks which TH hyperedges contains each PH hyperedge vertex  
			for( Iterator<Vertex> it2 = hyperEdge.getVertices().iterator(); it2.hasNext() ; ) {
				Vertex vertex = it2.next();				
				Hyperedge selectedHyperEdge = findHyperedgeContainingVertex(vertex, this.hyperEdges);
				// add TH hyperedge (RH vertex) containing the PH vertex to the RH hyperedge set 
				if ( selectedHyperEdge != null ) {
					newHyperEdge.addVertex(selectedHyperEdge);
				}
			}
			// minimum of two vertices to make a hyperedge on RH
			//if ( newHyperEdge.getVertices().size() > 1 ) {			
				resultantHypergraph.addHyperEdge(newHyperEdge);
			//}
		}
		
		return resultantHypergraph;
	}

	/*
	 * Returns the first cluster object that contains a given vertex
	 */
	private Hyperedge findHyperedgeContainingVertex(Vertex vertex, Collection<Hyperedge> hyperedges) {
		for( Iterator<Hyperedge> it = hyperedges.iterator(); it.hasNext() ; ) {
			Hyperedge hyperEdge = it.next();
			if ( hyperEdge.containsVertex(vertex) ) {
				return hyperEdge;
			}
		}		
		return null;
	}
	
	
	public String hyperEdgesToString(Collection<Hyperedge> hyperEdges) {
		StringBuffer toString = new StringBuffer(100);
		toString.append("Hyperedges:\r\n");
		for( Iterator<Hyperedge> it = hyperEdges.iterator(); it.hasNext() ; ) {
			Hyperedge hyperEdge = it.next();
			toString.append("=> ");
			toString.append(hyperEdge);
			toString.append("\r\n");
		}
		return toString.toString();
	}
	
	public String toString() {
		
		StringBuffer toString = new StringBuffer(100);
		toString.append("Vertices: {");
		for( Iterator<Vertex> it = vertices.iterator(); it.hasNext() ; ) {
			Vertex vertex = it.next();
			toString.append(vertex);
			if ( it.hasNext() ) {
				toString.append(",");
			}
		}
		toString.append("}\r\n");
		toString.append(hyperEdgesToString(hyperEdges));
		
		return toString.toString();
	}
	
}
