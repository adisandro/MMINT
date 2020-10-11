package splar.core.fm.configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.XMLFeatureModel;


public abstract class ConfigurationEngine {

	protected FeatureModel model;
	protected List<ConfigurationStep> steps;

	public ConfigurationEngine(String featureModelURL) throws ConfigurationEngineException {
		this.steps = new LinkedList<ConfigurationStep>();
		this.model = loadFeatureModelFromURL(featureModelURL);
	}
	
	public ConfigurationEngine(FeatureModel model) throws ConfigurationEngineException {
		this.steps = new LinkedList<ConfigurationStep>();
		this.model = model;
	}

	protected FeatureModel loadFeatureModelFromURL(String featureModelURL) throws ConfigurationEngineException {
		FeatureModel model = null;
    	try {
    		model = new XMLFeatureModel(featureModelURL, XMLFeatureModel.SET_ID_AUTOMATICALLY);
    		model.loadModel();				    		
		} catch (Exception e) {
			throw new ConfigurationEngineException("Problems loading model. Please check if model follows SXFM specification");
		}
		model.saveState("initial_state");
		return model;
	}
	
	public synchronized List<ConfigurationStep> getSteps() {
		return steps;
	}

	public synchronized FeatureModel getModel() {
		return model;
	}
	
	public String toString() {
		String toString = "Model: " + model.getName() + "\r\n";
		for( ConfigurationStep step : steps ) {
			toString += "  Step " + step.toString() + "\r\n";
		}
		return toString;
	}
	
	/******************************************************************************************************	 * 
	 * Returns last configuration step (most recent) from the list of steps
	 *******************************************************************************************************/
	public synchronized ConfigurationStep getLastStep() {
		return steps.get(steps.size()-1);
	}
	
	/******************************************************************************************************
	 * ISDONE
	 *******************************************************************************************************/
	public synchronized boolean isDone() {
		return model.getUninstantiatedNodes().size() == 0;
	}	
	
	/******************************************************************************************************
	 * RESET
	 *******************************************************************************************************/
	public synchronized ConfigurationStep reset() throws ConfigurationEngineException {
		try {			
			steps.clear();			
			model.restoreState("initial_state", false);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems reseting configuration", e);
		}
		return resetConfiguration();
	}
	
	/******************************************************************************************************
	 * RESET CONFIGURATION
	 *******************************************************************************************************/
	protected abstract ConfigurationStep resetConfiguration() throws ConfigurationEngineException;

	/******************************************************************************************************
	 * UNDO - 1
	 *******************************************************************************************************/
	public ConfigurationStep undoLastStep() throws ConfigurationEngineException {
		List<ConfigurationStep> undoneSteps = this.undo(steps.size());
		return undoneSteps.get(0);
	}
	
	/******************************************************************************************************
	 * UNDO - 2
	 *******************************************************************************************************/
	public  List<ConfigurationStep> undo(ConfigurationStep step) throws ConfigurationEngineException {
		return undo(steps.indexOf(step)+1);
	}
	
	/******************************************************************************************************
	 * UNDO - 3
	 *******************************************************************************************************/
	public  List<ConfigurationStep> undo(int undoStep) throws ConfigurationEngineException {
		List<ConfigurationStep> undoneSteps = new LinkedList<ConfigurationStep>();
		try {			
			if ( undoStep > 1 && undoStep <= steps.size() ) {
				while( steps.size() >= undoStep ) {
					ConfigurationStep undoStepObj = steps.get(undoStep-1);
					undoneSteps.add(undoStepObj);
					steps.remove(undoStep-1);
				}
			}
			else {
				throw new ConfigurationEngineException("Cannot undo specified configuration step");
			}
			
    		// restore feature model state to a previous state (at undo step)
			model.restoreState("state_step" + undoStep, true);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems undoing configuration step", e);
		}
		return undoneSteps;		
	}
	
	/******************************************************************************************************
	 * COMPUTE VALID DOMAINS
	 *******************************************************************************************************/
	protected abstract Map<String,Boolean[]> computeValidDomains() throws ConfigurationEngineException;
	
	/******************************************************************************************************
	 * GET VARIABLE NAME
	 *******************************************************************************************************/
	protected abstract String getVariableName(int varIndex);
	
	/******************************************************************************************************
	 * GET VARIABLE INDEX
	 *******************************************************************************************************/
	protected abstract int getVariableIndex(String varName);
	
	/******************************************************************************************************
	 * Utility method: Create a configuration step for a given <feature,decision> pair
	 * Returns the valid domains table for the configuration step just created
	 *******************************************************************************************************/
	protected Map<String,Boolean[]> createConfigurationStep( String featureId, int featureValue, String decisionType ) throws Exception {

		ConfigurationStep newConfStep = null;
		Map<String,Boolean[]> domainTable = null;
		
		int curConfStep = steps.size()+1;
		
		try {
			
			// save feature model state prior to performing the configuration step
    		model.saveState("state_step" + curConfStep);
    		
    		FeatureTreeNode currentDecidedFeature = model.getNodeByID(featureId);
    		if ( currentDecidedFeature == null ) {
    			throw new ConfigurationEngineException("Feature Id not found in the feature model: " + featureId);
    		}
    		if ( currentDecidedFeature.isInstantiated() && currentDecidedFeature.getValue() != featureValue ) {
    			throw new ConfigurationEngineException("Feature configuration value conflicts with current assignment");
    		}
			
	    	currentDecidedFeature.assignValue(featureValue);
			currentDecidedFeature.setProperty("decisionStep", "" + curConfStep);			
			currentDecidedFeature.setProperty("decisionType", decisionType);

//	    	addClauseToSolver(reasoner, currentDecidedFeature.getID(), featureValue);	    	
//	    	addClauseToSolver(reasoner, featureId, featureValue);
	    	
			// Compute valid domains
			domainTable = computeValidDomains();
			
			// Create new configuration step
			newConfStep = new ConfigurationStep(""+curConfStep);
			
			newConfStep.addManualDecisionFeature(currentDecidedFeature);
							    			
			int index = 0;
			for( String featureIdentifier : domainTable.keySet() ) {
				FeatureTreeNode featureNode = model.getNodeByID(featureIdentifier);
				// If feature has been instantiated at this step 
				if ( !featureNode.isInstantiated() ) {
					Boolean[] domain = domainTable.get(featureIdentifier);
					// If feature has a single possible value (either true or false)
					if ( domain.length == 1 ) {
						model.assignValue(featureNode, (domain[0] ? 1 : 0));			
	    				featureNode.setProperty("decisionStep", "" + curConfStep);
						featureNode.setProperty("decisionType", "propagated");
	    				newConfStep.addPropagatedFeature(featureNode);
					}
				}
				index++;
			}

			// Update feature models by instantiating variables (features)
//			int index = 0;
//			for( byte[] entry : domainTable ) {
//				FeatureTreeNode featureNode = model.getNodeByID(getVariableName(index));
//				// If feature has been instantiated at this step 
//				if ( !featureNode.isInstantiated() ) {
//					// If feature has a single possible value (either true or false)
//					if ( (entry[0] == FTReasoningWithSAT.YES && entry[1] == FTReasoningWithSAT.NO) 
//						 ||	(entry[1] == FTReasoningWithSAT.YES && entry[0] == FTReasoningWithSAT.NO) ) {
//						model.assignValue(featureNode, entry[0] == FTReasoningWithSAT.YES ? 0 : 1);			
//	    				featureNode.setProperty("decisionStep", "" + curConfStep);
//						featureNode.setProperty("decisionType", "propagated");
//	    				newConfStep.addPropagatedFeature(featureNode);
//					}
//				}
//				index++;
//			}

			// Compute step attributes
			ConfigurationStep.computeStepAttributes(newConfStep, steps, model);
			
			// add step to list of steps
			steps.add(newConfStep);
			
		} catch (Exception e) {
			model.restoreState("state_step" + curConfStep);
			throw e;
			// TODO: handle exception
		}		
		
		return domainTable;
		
	}
		
	/******************************************************************************************************
	 * AUTO COMPLETE
	 *******************************************************************************************************/
	public  abstract ConfigurationStep autoComplete(boolean valueOrder) throws ConfigurationEngineException;
	
	/******************************************************************************************************
	 * CONFIGURE
	 *******************************************************************************************************/
	public synchronized ConfigurationStep configure(String featureId, int decision) throws ConfigurationEngineException {
		try {    	
    		createConfigurationStep(featureId, decision, "manual");    		
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems configuring model: ", e);
		}
		return getLastStep();
	}

	/******************************************************************************************************
	 * DETECT CONFLICTS
	 *******************************************************************************************************/
	public abstract List<FeatureTreeNode> detectConflicts(String featureId) throws ConfigurationEngineException;
	
	/******************************************************************************************************
	 * TOGGLE DECISION
	 *******************************************************************************************************/
	public abstract List<ConfigurationStep> toggleDecision(String featureId) throws ConfigurationEngineException;
}

