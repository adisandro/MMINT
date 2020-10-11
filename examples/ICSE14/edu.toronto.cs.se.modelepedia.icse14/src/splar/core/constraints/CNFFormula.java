package splar.core.constraints;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CNFFormula {

	private Set<CNFClause> clauses;
	
	public CNFFormula() {
		clauses = new LinkedHashSet<CNFClause>();
	}
	
	public void addClause(CNFClause clause) {
		clauses.add(clause);
	}
	
	public void addClauses(Collection<CNFClause> clauses) {
		this.clauses.addAll(clauses);
	}
	
	public Set<CNFClause> getClauses() {
		return clauses;
	}
	
	public double getClauseDensity() {
		if ( getVariables().size() == 0 ) {
			return 0;
		}
		return (1.0*clauses.size())/getVariables().size();
	}
	
	public int countClauses() {
		return clauses.size();
	}
	
	public Set<CNFLiteral> getLiterals() {
		Set<CNFLiteral> set = new HashSet<CNFLiteral>();
		for( Iterator<CNFClause> it = clauses.iterator() ; it.hasNext() ; ) {
			for( Iterator<CNFLiteral> it2 = it.next().getLiterals().iterator() ; it2.hasNext() ; ) {
				set.add(it2.next());
			}
		}
		return set;
	}
	
	public int countLiterals() {
		return getLiterals().size();
	}
	
	public Set<BooleanVariableInterface> getVariables() {
		Set<BooleanVariableInterface> set = new HashSet<BooleanVariableInterface>();
		for( Iterator<CNFClause> it = clauses.iterator() ; it.hasNext() ; ) {
			for( Iterator<CNFLiteral> it2 = it.next().getLiterals().iterator() ; it2.hasNext() ; ) {
				set.add(it2.next().getVariable());
			}
		}
		return set;
	}
	
	public int countVariables() {
		return getVariables().size();
	}

	public int calculateClauseSpan(Map<String,Integer> variable2indexMap) {
		int span = 0;		
		for( Iterator<CNFClause> it = clauses.iterator() ; it.hasNext() ; ) {
			span += it.next().calculateSpan(variable2indexMap);
		}
		return span;
	}
	
	public String toString() {
		StringBuffer toString = new StringBuffer(100);
		for( Iterator<CNFClause> it = clauses.iterator() ; it.hasNext() ; ) {
			toString.append(it.next());
		}
		return toString.toString();
	}
	
}
