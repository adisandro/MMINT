package splar.core.constraints;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Assignment {

	private List<BooleanVariableInterface> assignment;
	
	public Assignment() {	
		assignment = new Vector<BooleanVariableInterface>();
	}
	
	public int getVariableValue(String varName) {
		for( Iterator<BooleanVariableInterface> it = assignment.iterator() ; it.hasNext() ; ) {
			BooleanVariableInterface va = it.next();
			if ( varName.compareToIgnoreCase(va.getID()) == 0 ) {
				return va.getValue();
			}
		}  
		return -1;
	}
	
	public void add(BooleanVariableInterface var) {
		assignment.add(var);
	}
	
	public void addAll(Assignment sourceAssignment) {
		assignment.addAll(sourceAssignment.assignment);
	}
	
	public void remove(BooleanVariableInterface var) {
		assignment.remove(var);
	}
	
	public List<BooleanVariableInterface> getTuples() {
		return assignment;
	}
	
	public int size() {
		return assignment.size();
	}
	
	public void clear() {
		assignment.clear();
	}
	
	public Object clone() {
		Assignment clone = new Assignment();
		for( Iterator<BooleanVariableInterface> it = assignment.iterator() ; it.hasNext() ; ) {
			clone.add(it.next());
		}  
		return clone;
	}
	
	public String toString() {
		StringBuffer toStr = new StringBuffer(100);  
		toStr.append("(");
		for( Iterator<BooleanVariableInterface> it = assignment.iterator() ; it.hasNext() ; ) {
			BooleanVariableInterface va = it.next();
			toStr.append(va.toString());
			if ( it.hasNext() ) {
				toStr.append(",");
			}
		}  
		toStr.append(")");
		return toStr.toString();		
	}
	
	
}
