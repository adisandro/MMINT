package splar.core.heuristics;

import java.util.LinkedHashMap;
import java.util.Map;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureModel;


public class VariableOrderingHeuristicsManager {
	
	private Map<String, VariableOrderingHeuristic> heuristics;

	public static VariableOrderingHeuristicsManager manager = null;

	public static VariableOrderingHeuristicsManager createHeuristicsManager() {
		if ( manager == null ) {
			manager = new VariableOrderingHeuristicsManager();
		}
		
		return manager;
	}
	
	private VariableOrderingHeuristicsManager() {
		heuristics = new LinkedHashMap<String, VariableOrderingHeuristic>();
	}

	public String[] run(String name, CNFFormula cnf) {
		VariableOrderingHeuristic heuristic = heuristics.get(name);
		if ( heuristic != null ) {
			return heuristic.run(cnf);
		}
		return null;
	}
	
	public void registerHeuristic(String name, VariableOrderingHeuristic heuristic) {
		heuristics.put(name, heuristic);
	}
	
	public VariableOrderingHeuristic getHeuristic(String name) {
		return heuristics.get(name);
	}
	
	public String[] getHeuristicNames() {
		String names[] = new String[heuristics.size()];
		int i = 0;
		for( VariableOrderingHeuristic heuristic : heuristics.values() ) {
			names[i++] = heuristic.getName();
		}
		return names;
	}
	
}
