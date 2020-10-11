package splar.plugins.reasoners.bdd.javabdd;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.OperationNotSupportedException;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.JFactory;
import net.sf.javabdd.BDDFactory.ReorderMethod;
import splar.core.constraints.Assignment;
import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.reasoning.FMReasoningException;
import splar.core.fm.reasoning.FMReasoningInterface;
import splar.core.heuristics.VariableOrderingHeuristic;

public abstract class ReasoningWithBDD extends FMReasoningInterface {

	protected BDDFactory bddFactory;
	protected BDD theOriginalBDD;
	protected BDD theWorkingBDD;
	protected int nodeNum;
	protected int cacheSize;
	protected ReorderMethod reorderMethod;
	protected VariableOrderingHeuristic variableOrderingHeuristic;
	
	protected long maxBuildingTime;  // in milliseconds	
	protected long heuristicRunningTime;
	protected long bddBuildingTime;
	
	// allows multiples BDD states to be saved and recovered
	protected Map<String,ReasoningWithBDDState> states;
	
	protected int[] variables = null;
	protected boolean newAssignmentsMade = false;
	
	protected String orderingFormulasStrategy; 
	
	public ReasoningWithBDD(VariableOrderingHeuristic voHeuristic, int nodeNum, int cacheSize, long maxBuildingTime, ReorderMethod reorderMethod, String orderingFormulasStrategy) {
		super();
		this.variableOrderingHeuristic = voHeuristic;
		this.nodeNum = nodeNum;
		this.cacheSize = cacheSize;
		this.reorderMethod = reorderMethod;
		states = new LinkedHashMap<String,ReasoningWithBDDState>();
		this.maxBuildingTime = maxBuildingTime;
		this.heuristicRunningTime = -1;
		this.bddBuildingTime = -1;
		this.orderingFormulasStrategy = orderingFormulasStrategy;
		bddFactory = JFactory.init(nodeNum,cacheSize);
	}
	
	public ReasoningWithBDD(VariableOrderingHeuristic voHeuristic, int nodeNum, int cacheSize, long maxBuildingTime, ReorderMethod reorderMethod) {
		this(voHeuristic, nodeNum, cacheSize, maxBuildingTime, reorderMethod, "undefined");
	}
	
	protected void initBDDReorder(int countNodes) {		
		if ( reorderMethod != BDDFactory.REORDER_NONE ) {
			bddFactory.enableReorder();
			bddFactory.autoReorder(reorderMethod);
			// define each level of the BDD as an eligible SIFTING block
			if ( reorderMethod == BDDFactory.REORDER_SIFT || 
				 reorderMethod == BDDFactory.REORDER_SIFTITE || 
				 reorderMethod == BDDFactory.REORDER_RANDOM ){
				for( int i = 0 ; i < countNodes ; i++ ) {
					bddFactory.addVarBlock(bddFactory.ithVar(i), false);
				}
			}
		}
	}
	
	public void init() throws Exception {
		clearStates();
		theOriginalBDD = createBDD(bddFactory, orderingFormulasStrategy);
		theWorkingBDD = theOriginalBDD.id();
		if ( variables == null ) {
			variables = initVars(theOriginalBDD.getFactory().varNum());
		}
	}
	
	public void init(String stateFilePath, String stateFileName) throws Exception {
		long start = System.currentTimeMillis();
		// clear states
		clearStates();
		// load the BDD
		theOriginalBDD = bddFactory.load(stateFilePath + stateFileName + ".bdd");
		theWorkingBDD = theOriginalBDD.id();
		// load the Map: BDD nodes <-> variable names 
		LineNumberReader reader = new LineNumberReader(new FileReader(stateFilePath + stateFileName + ".keys"));
		int lineNum = 0;
		String line = reader.readLine();
		// Variable -> Index Map
		varName2IndexMap = new HashMap<String, Integer>();
		while( line != null ) {
			varName2IndexMap.put(line, lineNum++);
			line = reader.readLine();
		}
		reader.close();
		// Index -> Variable Map
		varIndex2NameMap = new String[varName2IndexMap.size()];
		for( String varName : varName2IndexMap.keySet() ) {
			varIndex2NameMap[varName2IndexMap.get(varName)] = varName;
		}		
		variables = initVars(theOriginalBDD.getFactory().varNum());
		bddBuildingTime = System.currentTimeMillis() - start;
	}
	
	public void restoreFromFile(String stateFilePath, String stateFileName) throws Exception {
		init(stateFilePath, stateFileName);
	}
	
	public void saveToFile(String stateFilePath, String stateFileName) throws Exception {
		// Save BDD
		bddFactory.save(stateFilePath + stateFileName + ".bdd", theOriginalBDD);
		// Save the Mapping
		PrintWriter writer = new  PrintWriter(new FileOutputStream(stateFilePath + stateFileName + ".keys"));
		for( int i = 0 ; i < varIndex2NameMap.length ; i++ ) {
			writer.println(varIndex2NameMap[i]);
		}
		writer.close();		
	}
	
	public void clearStates() {
		for( ReasoningWithBDDState state : states.values() ) {
			state.discard();
		}
		states.clear();
	}
	
	public void end() {
	}
	
	public double getHeuristicRunningTime() {
		return variableOrderingHeuristic.getRunningTime();
	}
	
	public long getBDDBuildingTime() {
		return bddBuildingTime;
	}
	
	public void restrict(String variableID, boolean value) {
		BDD varBDD = value ? bddFactory.ithVar(getVariableIndex(variableID)).id() : bddFactory.nithVar(getVariableIndex(variableID)).id(); 
		theWorkingBDD.restrictWith(varBDD);
	}
		
	protected int[] initVars(int numVars) {
		int vars[] = new int[numVars];
		for( int i = 0 ; i < numVars ; i++ ) {
			vars[i] = -1;
		}
		return vars;
	}
			
	protected abstract BDD createBDD(BDDFactory bddFactory, String orderingFormulasStrategy) throws Exception;	
	
	public void saveState(String stateID) {
		ReasoningWithBDDState state = new ReasoningWithBDDState(this);
		state.save();
		states.put(stateID, state);
	}
	
	public void restoreState(String stateID) {
		ReasoningWithBDDState state = states.get(stateID);
		state.restore();
		states.remove(stateID);
	}

	public void discardState(String stateID) {
		ReasoningWithBDDState state = states.get(stateID);
		state.discard();
		states.remove(stateID);
	}	
	
	public BDD getBDD() {
		return theWorkingBDD;
	}
	
	public BDDFactory getBDDFactory() {
		return bddFactory;
	}
	
	/****************************************************************************************************************
	 *  REASONING OPERATIONS
	 ****************************************************************************************************************/
	@Override
	public boolean isConsistent() throws OperationNotSupportedException {
		return !theWorkingBDD.isZero();
	}
	
	@Override
	public double countValidConfigurations() throws OperationNotSupportedException {
		return theWorkingBDD.satCount();
	}
	
	@Override
	public Iterator<Assignment> iterateOverValidConfigurations() throws OperationNotSupportedException {
		return new BDDSolutionsIterator<Assignment>(theWorkingBDD,varIndex2NameMap);
	}

}

class ReasoningWithBDDState {
	
	private ReasoningWithBDD rBDD;
	protected int savedVariables[];
	protected BDD savedBDD;
	protected boolean savednewAssignmentsMade = false;
	
	public ReasoningWithBDDState(ReasoningWithBDD rBDD) {
		this.rBDD = rBDD;
	}
	
	public void save() {
		savedBDD = rBDD.getBDD().id();
		savedVariables = new int[rBDD.variables.length];
		System.arraycopy(rBDD.variables, 0, savedVariables, 0, rBDD.variables.length);
		savednewAssignmentsMade = rBDD.newAssignmentsMade;
	}
	
	public void restore() {
		rBDD.theWorkingBDD.free();
		rBDD.theWorkingBDD = savedBDD;
		System.arraycopy(savedVariables, 0, rBDD.variables, 0, savedVariables.length);
		rBDD.newAssignmentsMade = savednewAssignmentsMade;
	}
	
	public void discard() {
		savedBDD.free();
		savedVariables = null;
		rBDD = null;		
	}

}
