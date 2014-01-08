package splar.plugins.configuration.bdd.javabdd.catalog;

import java.util.HashSet;
import java.util.Set;

public class ProductComponent {
	
	private String id;
	private String name;
	private Set<String> types = null;

	public ProductComponent(String id, String name) {
		this.id = id;
		this.name = name;
		types = new HashSet<String>();
	}
	
	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}	
	
	public Set<String> getTypes() {
		return types;
	}
	
	public void addComponentType(String typeID) {
		types.add(typeID);
	}
	
	public String toString() {
		String toString = "Component: " + name + " [id=" + id + "]\r\n";
		toString += "   Types:\r\n";
		for( String type : types ) {
			toString += "   - " + type + "\r\n";
		}
		return toString;
	}		
}
