package splar.plugins.reasoners.bdd.javabdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import splar.core.constraints.Assignment;
import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;

import net.sf.javabdd.BDD;

public class BDDSolutionsIterator<T> implements Iterator<T> {

//	private BDD.BDDIterator bit;
	private Iterator bit;
	private String[] index2varMap;
	private List<Assignment> assignments; 
	private Assignment assignmentDC;   // variable dontcares (-1) are skipped  
	int j = 0;
	
	public BDDSolutionsIterator(BDD bdd, String[] index2varMap) {
		this.bit = bdd.allsat();
//		this.bit = new BDD.BDDIterator(bdd,bdd.support());
		this.index2varMap = index2varMap;
		this.assignments = new ArrayList<Assignment>();
		assignmentDC = new Assignment();
	}
		
	public boolean hasNext() {
		if ( assignments.size() == 0 && !bit.hasNext() ){
			return false;
		}
		if (assignments.size() == 0)
			expandAssignments((byte[])bit.next());
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

	public boolean hasNextSol() {
		return bit.hasNext();
	}

	public T nextSol() {
		if ( hasNextSol() ) {
			expandAssignmentSol();
			return (T)assignmentDC;
		}	
		return null;
	}

	public void remove() {
		
	}
	
	private void expandAssignments(byte bb[]) {
		assignments.clear();
		assignments.add(new Assignment());		
		//System.out.println("");
		for( int i = 0 ; i < bb.length ; i++ ) {			
			//System.out.println(bb[i]+",");
			if ( bb[i] != -1 ) {				
				for( Iterator<Assignment> it = assignments.iterator() ; it.hasNext() ;  ) {
					Assignment as = it.next();
					BooleanVariableInterface va = new BooleanVariable(index2varMap[i],bb[i]); 
					as.add(va);
				}
			}
			else {
				List<Assignment> tempAssign = new ArrayList<Assignment>();
				for( Iterator<Assignment> it = assignments.iterator() ; it.hasNext() ;  ) {
					Assignment as1 = it.next();
					Assignment as2 = (Assignment)as1.clone();
					as1.add(new BooleanVariable(index2varMap[i],0));
					as2.add(new BooleanVariable(index2varMap[i],1));
					tempAssign.add(as2);
				}
				assignments.addAll(tempAssign);
			}
		}
		if ( assignments.get(0).size() == 0 ) {
			assignments.clear();
		}
	}
	
	private void expandAssignmentSol() {
		byte [] bb = (byte[])bit.next();
		assignmentDC.clear();
		//System.out.println("");
		for( int i = 0 ; i < bb.length ; i++ ) {			
			//System.out.println(bb[i]+",");
			if ( bb[i] != -1 ) {				
				assignmentDC.add(new BooleanVariable(index2varMap[i],bb[i]));
			}
		}
	}
	
}
