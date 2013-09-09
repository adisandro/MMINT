package splar.plugins.reasoners.bdd.javabdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import splar.core.constraints.Assignment;
import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;

import net.sf.javabdd.BDD;

public class BDDSolutionsIterator2<T> implements Iterator<T> {

//	private BDD.BDDIterator bit;
	private Iterator bit;
	private String[] index2varMap;
	private List<Assignment> assignments; 
	private Assignment assignmentDC;   // variable dontcares (-1) are skipped  
	int j = 0;
	
	public BDDSolutionsIterator2(BDD bdd, String[] index2varMap) {
//		this.bit = bdd.allsat();
		this.bit = new BDD.BDDIterator(bdd,bdd.support());
		this.index2varMap = index2varMap;
		this.assignments = new ArrayList<Assignment>(); 
		assignmentDC = new Assignment();
	}
		
	public boolean hasNext() {
		if ( assignments.size() == 0 && !bit.hasNext() ){
			return false;
		}
		if (assignments.size() == 0) {
			BDD sol = (BDD)bit.next();
			System.out.println(sol);
			assignments.clear();
			assignments.add(new Assignment());
		}
		return true;
	}

	public T next() {	
		Assignment next = null;
		if (hasNext()) {
			next = assignments.get(0);
			assignments.remove(0);
		}
		return (T)next;
	}

	public void remove() {
		
	}
}
