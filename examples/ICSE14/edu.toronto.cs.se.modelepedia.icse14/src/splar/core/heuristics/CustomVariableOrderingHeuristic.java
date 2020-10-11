package splar.core.heuristics;

import java.util.ArrayList;
import java.util.List;

import splar.core.constraints.CNFFormula;


public class CustomVariableOrderingHeuristic extends VariableOrderingHeuristic {
	
	private String initialVO[] = null;
	
	public CustomVariableOrderingHeuristic(String name, String initialVO[]) {
		super(name);
		this.initialVO = initialVO;
	}
		
	public String[] runHeuristic(CNFFormula cnf) {
		
		String voList = (String)parameters.get("variable_ordering_list");
		List<String> varOrderList = new ArrayList<String>();
		if ( voList != null ) {		
			String[] result = voList.split(",");
			for (int i=0; i < result.length; i++) {
				varOrderList.add(result[i].trim());
			} 
			return varOrderList.toArray(new String[0]);
	    }
		return initialVO;
	}	
}

