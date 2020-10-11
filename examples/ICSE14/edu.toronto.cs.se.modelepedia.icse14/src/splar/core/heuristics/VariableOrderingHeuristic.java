package splar.core.heuristics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFFormula;



public abstract class VariableOrderingHeuristic {

	protected String name;
	protected Map<String,Object> parameters;
	protected String lastVo[];
	protected double lastRunningTime;
	
	public VariableOrderingHeuristic(String name) {
		this.name = name;
		parameters = new LinkedHashMap<String,Object>();
		lastVo = null;
		lastRunningTime = -1;
		
		registerToHeuristicManager();
	}
	
	protected void registerToHeuristicManager() {
		VariableOrderingHeuristicsManager.createHeuristicsManager().registerHeuristic(name, this);
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getVariableOrdering() {
		return lastVo;
	}
	
	public double getRunningTime() {
		return lastRunningTime;
	}
	
	public void setParameter(String name, Object value) {
		parameters.put(name,value);
	}
	
	public void clearParameters() {
		parameters.clear();
	}
	
	public static Map<String,Integer> variableOrderingAsHashMap(String [] vo) {
		Map<String,Integer> map = new LinkedHashMap<String, Integer>();
		for( int i = 0 ; i < vo.length ; i++ ) {
			map.put(vo[i], new Integer(i));
		}		
		return map;
	}
	
	public static String variableOrderingAsCommaSepString(String [] vo) {
		String voStr = "";
		for( int i = 0 ; i < vo.length ; i++ ) {
			voStr += vo[i];
			if ( i < (vo.length-1) ) {
				voStr += ",";
			}
		}		
		return voStr;
	}
	
	public static Map<String,Integer> variableOrderingAsHashMap(BooleanVariableInterface[] vo) {
		Map<String,Integer> map = new LinkedHashMap<String, Integer>();
		for( int i = 0 ; i < vo.length ; i++ ) {
			map.put(vo[i].getID(), new Integer(i));
		}			
		return map;
	}
	
	public static BooleanVariableInterface[] variableOrderingAsBooleanVariableArray(String vo[]) {
		Vector<BooleanVariableInterface> varOrderList = new Vector<BooleanVariableInterface>();
		if ( vo != null ) {
			for (int i=0; i < vo.length; i++) {
				varOrderList.add(new BooleanVariable(vo[i]));
			}
		}
		return varOrderList.toArray(new BooleanVariableInterface[0]);
	}
	
	public static BooleanVariableInterface[] variableOrderingAsBooleanVariableArray(String commaSepString) {
		Vector<BooleanVariableInterface> varOrderList = new Vector<BooleanVariableInterface>();
		String[] result = commaSepString.split(",");
		for (int i=0; i < result.length; i++) {
			varOrderList.add(new BooleanVariable(result[i].trim()));
		}
		return varOrderList.toArray(new BooleanVariableInterface[0]);
	}
	
	public static String[] variableOrderingAsStringVariableArray(BooleanVariableInterface vo[]) {
		String varOrder[] = null;
		int countVars = vo.length;
		if ( vo != null ) {
			varOrder = new String[countVars];
			for( int i = 0 ; i < countVars ; i++ ) {
				varOrder[i] = vo[i].getID();
			}
		}
		return varOrder;
	}	
	
	public String[] run(CNFFormula cnf) {
		long start = System.nanoTime();
		runPreProcessing(cnf);
		lastVo = runHeuristic(cnf);
		runPostProcessing(cnf);
		lastRunningTime = (System.nanoTime() - start)/1E6;
		return lastVo;
	}
	
	protected void runPreProcessing(CNFFormula cnf) {		
	}

	protected void runPostProcessing(CNFFormula cnf) {		
	}
	
	protected abstract String[] runHeuristic(CNFFormula cnf);
	
}
