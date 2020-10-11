package splar.core.fm.reasoning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import splar.core.constraints.Assignment;
import splar.core.fm.FeatureModel;


public abstract class FMReasoningInterface {

	public static final byte UNKNOWN = 1;
	public static final byte YES = 2;
	public static final byte NO = 3;
	
	protected Map<String,Integer> varName2IndexMap;
	protected String[] varIndex2NameMap;
		
	public FMReasoningInterface() {
		varName2IndexMap = new HashMap<String, Integer>();
		varIndex2NameMap = null;
	}
	
	public Map<String,Integer> getVarName2IndexMap() {
		return varName2IndexMap;
	}
	
	public String[] getVarIndex2NameMap() {
		return varIndex2NameMap;
	}
	
	public Integer getVariableIndex(String varName) {
		return varName2IndexMap.get(varName);
	}
	
	public String getVariableName(int index) {
		return varIndex2NameMap[index];
	}

	/****************************************************************************************************************
	 *  REASONING OPERATIONS
	 ****************************************************************************************************************/
	
	/****************************************************************************************************************
	 * Checks if feature model is consistent  
	 ****************************************************************************************************************/
	public boolean isConsistent() throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 * Count feature model valid configurations  
	 ****************************************************************************************************************/
	public double countValidConfigurations() throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 * Iterates over feature model valid configurations  
	 ****************************************************************************************************************/
	public Iterator<Assignment> iterateOverValidConfigurations() throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 * Checks if feature can only assume a false value (deselected)  
	 ****************************************************************************************************************/
	public boolean isDeadFeature(String featureId) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 *  Checks if feature can only assume a true value (selected)
	 ****************************************************************************************************************/
	public boolean isCoreFeature(String featureId) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 * Checks if feature can assume either boolean values (deselected/selected)  
	 ****************************************************************************************************************/ 
	public boolean isFreeFeature(String featureId) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 * Compute valid domain for a given feature  
	 ****************************************************************************************************************/
	public Boolean[] validDomain(String featureId) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}

	/****************************************************************************************************************
	 * Returns all dead features 
	 ****************************************************************************************************************/
	public List<String> allDeadFeatures(Map<String,String> stats) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 * Returns all core features  
	 ****************************************************************************************************************/
	public List<String> allCoreFeatures(Map<String,String> stats) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 * Returns all free features 
	 ****************************************************************************************************************/
	public List<String> allFreeFeatures(Map<String,String> stats) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/****************************************************************************************************************
	 * Compute valid domains for all features 
	 ****************************************************************************************************************/
	public Map<String,Boolean[]> allValidDomains(Map<String,String> stats) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}

	/****************************************************************************************************************
	 * Check if configuration is valid  
	 ****************************************************************************************************************/
	public boolean isValidConfiguration(Assignment assignment) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}

	/****************************************************************************************************************
	 * Checks if two feature models are equivalent  
	 ****************************************************************************************************************/
	public boolean isEquivalent(FeatureModel featureModel) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}

	/****************************************************************************************************************
	 * Checks if current feature model is a specialization of the feature model passed as parameter  
	 ****************************************************************************************************************/
	public boolean isSpecialization(FeatureModel featureModel) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}

	/****************************************************************************************************************
	 *  Checks if current feature model is an extension of the feature model passed as parameter
	 ****************************************************************************************************************/
	public boolean isExtension(FeatureModel featureModel) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
	/*
 	 public abstract double variability();
	 public abstract double commonality(List<BooleanVariableInterface>);	 
	 */
		
	// initialization and finalization
	public abstract void init() throws Exception;
	public abstract void end();

	// state support
	public void saveState(String stateID) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}

	public void restoreState(String stateID) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}

	public void discardState(String stateID) throws OperationNotSupportedException, FMReasoningException {
		throw new OperationNotSupportedException("Reasoning Operation Not Supported");
	}
	
}
	
