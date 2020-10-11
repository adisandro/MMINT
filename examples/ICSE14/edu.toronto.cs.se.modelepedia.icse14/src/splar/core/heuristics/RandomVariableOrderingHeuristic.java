package splar.core.heuristics;

import java.util.ArrayList;
import java.util.List;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFFormula;


public class RandomVariableOrderingHeuristic extends VariableOrderingHeuristic {
	
	public RandomVariableOrderingHeuristic(String name) {
		super(name);
	}
	
	// generates a random variable ordering
	// useful for benchmark purposes
	public String[] runHeuristic(CNFFormula cnf) {
	
		List<BooleanVariableInterface> variables = new ArrayList<BooleanVariableInterface>();
		variables.addAll(cnf.getVariables());
		java.util.Collections.shuffle(variables);
		String varOrder[] = new String[variables.size()];
		int i = 0;
		for( BooleanVariableInterface var : variables ) {
			varOrder[i++] = var.getID(); 
		}
		return varOrder;
	}	
}

