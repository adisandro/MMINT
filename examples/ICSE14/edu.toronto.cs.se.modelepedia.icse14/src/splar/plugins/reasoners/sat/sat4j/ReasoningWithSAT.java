package splar.plugins.reasoners.sat.sat4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import org.sat4j.core.LiteralsUtils;
import org.sat4j.minisat.SolverFactory;
import org.sat4j.minisat.core.IOrder;
import org.sat4j.minisat.core.Solver;
import org.sat4j.specs.IConstr;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.TimeoutException;
import org.sat4j.tools.ModelIterator;

import splar.core.fm.reasoning.FMReasoningException;
import splar.core.fm.reasoning.FMReasoningInterface;


public abstract class ReasoningWithSAT extends FMReasoningInterface {

	protected ISolver satSolver;
	protected String solverName;
	protected int timeout;
	 
	public ReasoningWithSAT(String solverName, int timeout) {
		super();
		this.solverName = solverName;
		this.timeout = timeout;
	}
	
	public ISolver getSolver() {
		return satSolver;
	}
	
	@Override
	public String getVariableName(int index) {
		return super.getVariableName(index-1);
	}
	
	public void setVariableOrder(String order[]) {
		((Solver)satSolver).setOrder(new StaticVariableOrderSAT(order, false, varName2IndexMap, varIndex2NameMap));
	}
	
	public void setVariableOrderObject(IOrder order) {
		((Solver)satSolver).setOrder(order);
	}
	protected abstract void addSolverClauses(ISolver solver) throws Exception;

	/****************************************************************************************************************
	 *  INIT/END
	 ****************************************************************************************************************/
	/*
	 * initializes the reasoner 
	 */
	protected List<IConstr> constrList = null; 
	public void init() throws Exception {
		satSolver = SolverFactory.instance().createSolverByName(solverName);
		satSolver.setTimeout(timeout);
//		System.out.println("Solver created: " + solverName);
		addSolverClauses(satSolver);
	}
	
	/*
	 * finalizes the reasoner 
	 */
	public void end() {		
	}
		   
	/****************************************************************************************************************
	 *  REASONING OPERATIONS
	 ****************************************************************************************************************/

	/****************************************************************************************************************
	 * Checks if feature model is consistent
	 ****************************************************************************************************************/
	@Override
	public boolean isConsistent() throws FMReasoningException {
		try {
			return satSolver.isSatisfiable();
		}
		catch (TimeoutException e) {
			throw new FMReasoningException(e);
		}
	}	
	
	/****************************************************************************************************************
	 *  Count feature model valid configurations
	 ****************************************************************************************************************/
	// Important: Performance of this operation is very poor as expected for a SAT solver, use a BDD instead
	@Override
	public double countValidConfigurations() throws FMReasoningException {
		if ( isConsistent() ) {
			ISolver solver = new ModelIterator(satSolver);
			double countSat = 0;
			long start = System.nanoTime();
			try {
				while (solver.isSatisfiable()) {
					solver.model();
					countSat++;				
					if ( (System.nanoTime()-start)/1E6 > timeout ) return -1;
				 }
			} catch (Exception e) {
				throw new FMReasoningException(e);
			}
			return countSat;
		}
		throw new FMReasoningException("Operation does not apply to inconsistent feature models");
	}

	/****************************************************************************************************************
	 *  Checks if feature can only assume a false value (deselected)
	 ****************************************************************************************************************/
	@Override
	public boolean isDeadFeature(String featureId) throws FMReasoningException {
		try {
			if ( isConsistent() ) {
				if ( ((Solver)satSolver).assume(LiteralsUtils.posLit(getVariableIndex(featureId))) ) {
					return !isConsistent();
				}
				return true; 
			}
			else {
				throw new FMReasoningException("Operation does not apply to inconsistent feature models");
			}
			
		} catch (Exception e) {
			throw new FMReasoningException(e);
		}
	}
	
	/****************************************************************************************************************
	 *  Checks if feature can only assume a true value (selected)
	 ****************************************************************************************************************/
	@Override
	public boolean isCoreFeature(String featureId) throws FMReasoningException {
		try {
			if ( isConsistent() ) {
				if ( ((Solver)satSolver).assume(LiteralsUtils.negLit(getVariableIndex(featureId))) ) {
					return !isConsistent();
				}
				return true; 
			}
			else {
				throw new FMReasoningException("Operation does not apply to inconsistent feature models");
			}
		} catch (Exception e) {
			throw new FMReasoningException(e);
		}
	}
	
	/****************************************************************************************************************
	 *  Checks if feature can assume either boolean values (deselected/selected)
	 ****************************************************************************************************************/
	@Override
	public boolean isFreeFeature(String featureId) throws FMReasoningException {
		return !isDeadFeature(featureId) && !isCoreFeature(featureId);
	}

	/****************************************************************************************************************
	 *  Compute valid domain for a given feature
	 ****************************************************************************************************************/
	@Override
	public Boolean[] validDomain(String featureId) throws FMReasoningException {
		if ( isConsistent() ) {
			if ( isDeadFeature(featureId) ) {
				return new Boolean[] {false};
			}
			if ( isCoreFeature(featureId) ) {
				return new Boolean[] {true};
			}
			return new Boolean[] {true, false};
		}
		else {
			throw new FMReasoningException("Operation does not apply to inconsistent feature models");
		}
	}

	/****************************************************************************************************************
	 *  Returns all dead features
	 ****************************************************************************************************************/
	@Override
	public List<String> allDeadFeatures(Map<String,String> stats) throws FMReasoningException {
		if ( isConsistent() ) {
			List<String> features = new LinkedList<String>();
			boolean optimizations[] = {true,true,true,true,true};
			int domainSearch[] = {1};
			byte[][] domainTable = computeValidDomains(domainSearch, optimizations, stats);
			for( int i = 0 ; i < domainTable.length ; i++ ) {
				if ( domainTable[i][1] == NO ) {
					features.add(getVariableName(i+1));
				}
			}
			return features;
		}
		else {
			throw new FMReasoningException("Operation does not apply to inconsistent feature models");
		}
	}
	
	/****************************************************************************************************************
	 * Returns all core features  
	 ****************************************************************************************************************/
	public List<String> allCoreFeatures(Map<String,String> stats) throws OperationNotSupportedException, FMReasoningException {
		if ( isConsistent() ) {
			List<String> features = new LinkedList<String>();
			boolean optimizations[] = {true,true,true,true,true};
			int domainSearch[] = {0};
			byte[][] domainTable = computeValidDomains(domainSearch, optimizations, stats);
			for( int i = 0 ; i < domainTable.length ; i++ ) {
				if ( domainTable[i][0] == NO ) {
					features.add(getVariableName(i+1));
				}
			}
			return features;
		}
		else {
			throw new FMReasoningException("Operation does not apply to inconsistent feature models");
		}
	}
	
	/****************************************************************************************************************
	 * Returns all free features 
	 ****************************************************************************************************************/
	public List<String> allFreeFeatures(Map<String,String> stats) throws OperationNotSupportedException, FMReasoningException {
		if ( isConsistent() ) {
			List<String> features = new LinkedList<String>();
			boolean optimizations[] = {true,true,true,true,true};
			int domainSearch[] = {0,1};
			byte[][] domainTable = computeValidDomains(domainSearch, optimizations, stats);
			for( int i = 0 ; i < domainTable.length ; i++ ) {
				if ( domainTable[i][0] == YES && domainTable[i][1] == YES) {
					features.add(getVariableName(i+1));
				}
			}
			return features;
		}
		else {
			throw new FMReasoningException("Operation does not apply to inconsistent feature models");
		}
	}
	
	
	/****************************************************************************************************************
	 *  Compute valid domains for all features
	 ****************************************************************************************************************/
	@Override
	public Map<String, Boolean[]> allValidDomains(Map<String,String> stats) throws OperationNotSupportedException, FMReasoningException {
		if ( isConsistent() ) {
			Map<String,Boolean[]> allDomains = new HashMap<String, Boolean[]>();
			boolean optimizations[] = {true,true,true,true,true};
			int domainSearch[] = {1,0};
			byte[][] domainTable = computeValidDomains(domainSearch, optimizations, stats);
			for( int i = 0 ; i < domainTable.length ; i++ ) {
				List<Boolean> domain = new LinkedList<Boolean>();
				if ( domainTable[i][0] == YES ) {
					domain.add(false);
				}
				if ( domainTable[i][1] == YES ) {
					domain.add(true);
				} 
				allDomains.put(getVariableName(i+1),domain.toArray(new Boolean[0]));
			}
			return allDomains;
		}
		else {
			throw new FMReasoningException("Operation does not apply to inconsistent feature models");
		}
	}

	
	public abstract byte[][] computeValidDomains(int testValues[], boolean optimizations[], Map<String,String> stats);	
	
}
