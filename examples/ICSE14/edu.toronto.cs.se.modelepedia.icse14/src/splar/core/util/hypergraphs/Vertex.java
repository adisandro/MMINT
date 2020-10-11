package splar.core.util.hypergraphs;

public class Vertex {
	
	private String name;

	public Vertex( String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Object vertex) {
		if (vertex != null) {
			if ( vertex instanceof Vertex ) {
				Vertex v = (Vertex)vertex; 
				return name.compareToIgnoreCase(v.getName()) == 0;
			}
		}
		return false;
	}
	
}
