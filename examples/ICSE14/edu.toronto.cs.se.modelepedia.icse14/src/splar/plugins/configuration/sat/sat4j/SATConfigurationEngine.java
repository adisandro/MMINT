package splar.plugins.configuration.sat.sat4j;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.sat4j.core.VecInt;
import org.sat4j.minisat.core.Solver;
import org.sat4j.specs.ContradictionException;


import splar.core.fm.FTTraversalNodeSelector;
import splar.core.fm.FTTraversals;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.configuration.ConfigurationEngine;
import splar.core.fm.configuration.ConfigurationEngineException;
import splar.core.fm.configuration.ConfigurationStep;
import splar.plugins.reasoners.sat.sat4j.FMReasoningWithSAT;
import splar.plugins.reasoners.sat.sat4j.StaticVariableOrderSAT;


public class SATConfigurationEngine extends ConfigurationEngine {

	protected FMReasoningWithSAT reasoner;		// SAT solver
	
	public SATConfigurationEngine(String featureModelURL) throws ConfigurationEngineException {

		super(featureModelURL);
		
		reasoner = null;
		
		// enforces that model is satisfiable
		try {
    		// model must be satisfiable otherwise raise exception
 	       	FMReasoningWithSAT tempReasoner = new FMReasoningWithSAT("MiniSAT", model, 60000);
 	       	tempReasoner.init();
	       	if ( !tempReasoner.isConsistent() ) {
	       		throw new ConfigurationEngineException("Model is inconsistent and thus cannot be configured ");
	       	}
		} 
		catch (ContradictionException contExc) {
			throw new ConfigurationEngineException("Model is inconsistent and thus cannot be configured ");
		}
		catch (Exception e) {
			throw new ConfigurationEngineException("Problems loading model. Location might be wrong or model does not follow SXFM specification");
		}
		
	}
	
	void addClauseToSolver(FMReasoningWithSAT reasoner, String decisionVar, int decisionValue ) throws Exception {
		// Add user decision as a clause to the SAT problem 
		Solver satSolver = (Solver)reasoner.getSolver();
		int varIndex = reasoner.getVariableIndex(decisionVar); 
		VecInt vectInt = new VecInt(1);
		vectInt.push(decisionValue == 1 ? varIndex : -varIndex);
		satSolver.addClause(vectInt);
	}	
		
	/******************************************************************************************************
	 * RESET
	 *******************************************************************************************************/
	protected synchronized ConfigurationStep resetConfiguration() throws ConfigurationEngineException {		
		ConfigurationStep newConfStep = null;		
		try {						
			reasoner = createSATReasoner(model);
			createConfigurationStep(model.getRoot().getID(), 1, "propagated");
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems reseting configuration", e);
		}
		return getLastStep();
	}
	
	/******************************************************************************************************
	 * UNDO
	 *******************************************************************************************************/
	public  List<ConfigurationStep> undo(int undoStep) throws ConfigurationEngineException {
		try {			
			List<ConfigurationStep> undoneSteps = super.undo(undoStep);
			reasoner = createSATReasoner(model);
			return undoneSteps;
		}
		catch (ConfigurationEngineException e1) {
			throw e1;
		}
		catch (Exception e2) {
			throw new ConfigurationEngineException("Problems undoing configuration step " + undoStep, e2);
		}
	}
	
	/******************************************************************************************************
	 * CREATE SAT REASONER
	 *******************************************************************************************************/
	protected FMReasoningWithSAT createSATReasoner(FeatureModel model) throws Exception {
		FMReasoningWithSAT satReasoner = new FMReasoningWithSAT("MiniSAT", model, 60000);
		satReasoner.init();
		return satReasoner;
	}
	
	/******************************************************************************************************
	 * AUTO COMPLETE
	 *******************************************************************************************************/
	public synchronized ConfigurationStep autoComplete(boolean valueOrder) throws ConfigurationEngineException {
		ConfigurationStep newConfStep = null;
		try {
			
			int curConfStep = steps.size()+1;	
			
			// save feature model state prior to performing the configuration step
			model.saveState("state_step" + curConfStep);
					
			String satVarOrder[] = new String[model.countFeatures()];//featureModel.countFeatures()];					
			FTTraversalNodeSelector selector = new FTTraversalNodeSelector() {
				public boolean select(FeatureTreeNode node) {
					if ( node instanceof FeatureGroup )
						return false;
					return true;
				}
			};					
			int index=0;				
			for( FeatureTreeNode node : FTTraversals.dfs(model.getRoot(), selector)) {
				satVarOrder[index++] = node.getID();
			}
			StaticVariableOrderSAT satOrderObj = new StaticVariableOrderSAT(satVarOrder, valueOrder, reasoner.getVarName2IndexMap(), reasoner.getVarIndex2NameMap());
			reasoner.setVariableOrderObject(satOrderObj);
			
			Solver satSolver = (Solver)reasoner.getSolver();
			
			if( satSolver.isSatisfiable() ) {
				long time = System.currentTimeMillis();
				int[] solution = satSolver.model();
				time = System.currentTimeMillis() - time;

				// Create new configuration step
				newConfStep = new ConfigurationStep(""+curConfStep);
//				newConfStep.setDecisionFeature(null);

				for( int value : solution ) {
					String featureId = reasoner.getVariableName(Math.abs(value));							
					FeatureTreeNode completedFeature = model.getNodeByID(featureId);
					if ( !completedFeature.isInstantiated() ) {
						// assign value to feature
						model.assignValue(completedFeature, value > 0 ? 1 : 0);
						// add feature properties
						completedFeature.setProperty("decisionStep", ""+curConfStep);
						completedFeature.setProperty("decisionType", "auto-completion");
						newConfStep.addPropagatedFeature(completedFeature);
					}
				}											
				
				// Add stats data to step					
				newConfStep.addAttribute("step_Stat", "1");
				newConfStep.addAttribute("step_runTime", ""+time);
				ConfigurationStep.computeStepAttributes(newConfStep, steps, model);
				
				steps.add(newConfStep);
			}
			else {
				throw new ConfigurationEngineException("Problems autocompleting configuration: isSatisfiable()");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems autocompleting configuration", e);
		}
		return newConfStep;
	}	
	
	/******************************************************************************************************
	 * Utility method: Create a configuration step for a given <feature,decision> pair
	 * Returns the valid domains table for the created configuration step
	 *******************************************************************************************************/
	@Override
	protected Map<String,Boolean[]> createConfigurationStep( String featureId, int featureValue, String decisionType ) throws Exception {
		Map<String,Boolean[]> domainTable = null;
		try {			
	    	addClauseToSolver(reasoner, featureId, featureValue); 		    	
			domainTable = super.createConfigurationStep(featureId, featureValue, decisionType);
			// Add stats data to step					
			ConfigurationStep newConfStep = getLastStep();
			newConfStep.addAttribute("step_Stat", satStats.get("sat-checks"));
			newConfStep.addAttribute("step_runTime", satStats.get("processing-time"));
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		return domainTable;
	}
	
	/******************************************************************************************************
	 * COMPUTE VALID DOMAINS
	 *******************************************************************************************************/
	Map<String,String> satStats = null;
	protected Map<String,Boolean[]> computeValidDomains() throws ConfigurationEngineException{
		try {
			if ( satStats == null ) {
				satStats = new HashMap<String,String>();
			}
			else {
				satStats.clear();
			}
			return reasoner.allValidDomains(satStats);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems computing valid domains for SAT: " + e.getMessage());
		}
	}
	
	/******************************************************************************************************
	 * GET VARIABLE NAME
	 *******************************************************************************************************/
	protected String getVariableName(int varIndex) {
		return reasoner.getVariableName(varIndex+1);		
	}
	
	/******************************************************************************************************
	 * GET VARIABLE INDEX
	 *******************************************************************************************************/
	protected int getVariableIndex(String varName) {
		return reasoner.getVariableIndex(varName);
	}
	
	/******************************************************************************************************
	 * DETECT CONFLICTS
	 *******************************************************************************************************/
	public synchronized List<FeatureTreeNode> detectConflicts(String featureId) throws ConfigurationEngineException {
		// only features manually decided are considered
		List<FeatureTreeNode> conflictingFeatures = new LinkedList<FeatureTreeNode>();
		try {
			
			model.saveState("detect_conflicts");
						
			// identify data about feature that will be toggled
			FeatureTreeNode toggleFeatureNode = model.getNodeByID(featureId);
			
			if ( !toggleFeatureNode.isInstantiated() ) {
				throw new ConfigurationEngineException("Cannot toggle the value of an uninstantiated feature");
			}
			
			if ( toggleFeatureNode.isImmutable() ) {
				throw new ConfigurationEngineException("Cannot toggle the value of an immutable feature");
			}
			
			int toggleFeatureOriginalValue = toggleFeatureNode.getValue();
			int toggleFeatureStep = Integer.valueOf((String)toggleFeatureNode.getProperty("decisionStep"));

 	       	// creates list of relevant decisions starting with the toggle feature and followed by other manual decisions 
 	       	Map<String,Integer> newDecisionSequence = new LinkedHashMap<String,Integer>();
 	       	newDecisionSequence.put(toggleFeatureNode.getID(), 1-toggleFeatureOriginalValue);
// 	       	relevantDecisions.add(toggleFeatureNode);
 	       	
 	       	// add manual decisions to list of relevant decisions (decisions that should be kept)
 	       	// and remove respective configuration steps
 	       	for( int i = toggleFeatureStep-1 ; i < steps.size() ; i++ ) { 	       		
 	       		for( FeatureTreeNode manualDecision : steps.get(i).getDecisions() ) { 	       			
	 	       		if ( !manualDecision.equals(toggleFeatureNode) ) { 
	 	    	       	newDecisionSequence.put(manualDecision.getID(), manualDecision.getValue());
//	 	    	       relevantDecisions.add(manualDecision);
	 	       		}
 	       		}
 	       	}			
			
			// restore model to state immediately before toggle feature original decision
 	       	// and creates SAT solver
			model.restoreState("state_step" + toggleFeatureStep, false);

			FMReasoningWithSAT tempReasoner = createSATReasoner(model);
 	       				
 	       	// check features that conflict with new decision sequence
 	       	int index = 0;
 	       	String [] newDecisionSequenceArray = newDecisionSequence.keySet().toArray(new String[0]);
 	       	for( String decisionNodeId : newDecisionSequenceArray ) {

 	       		int decisionNodeValue = newDecisionSequence.get(decisionNodeId);
 	       		
 	       		// skip previously-detected conflicting nodes (-1)
 	       		if ( decisionNodeValue != -1 ) {
 	       			
	 	       		// new decision
					addClauseToSolver(tempReasoner, decisionNodeId, newDecisionSequence.get(decisionNodeId));
		       	
					// Compute valid domains
		   			Map<String,String> satStats = new HashMap<String,String>();
					Map<String,Boolean[]> domainTable = tempReasoner.allValidDomains(satStats);
					
					// try to find conflicts
					for( int i = index+1 ; i < newDecisionSequenceArray.length ; i++ ) {
						
						String varName = newDecisionSequenceArray[i];
						int varValue = newDecisionSequence.get(varName);
						
						Boolean domain[] = domainTable.get(varName);

						// node can only be true (or false) which conflicts with its current value
						if ( (domain.length == 1 && domain[0] == true  && varValue == 0) || 
							 (domain.length == 1 && domain[0] == false && varValue == 1) ) {
							// eliminate node from further processing
							newDecisionSequence.put(varName, -1);  // eliminate node from further processing
							// add inverse of node value as clause to the to SAT solver
							addClauseToSolver(tempReasoner, varName, 1-varValue);
							// add node to conflict list
							conflictingFeatures.add(model.getNodeByID(varName));
						}
						// node can only be true (or false) which coincides with its current value 
						else if ( (domain.length == 1 && domain[0] == true  && varValue == 1) || 
								  (domain.length == 1 && domain[0] == false && varValue == 0) ) {
							// eliminate node from further processing
							newDecisionSequence.put(varName, -1);  
							// add node value as clause to the to SAT solver
							addClauseToSolver(tempReasoner, varName, varValue);
						}
						
						
//						// node can only be true (or false) which conflicts with its current value
//						if ( (entry[0] == FTReasoningWithSAT.YES && entry[1] == FTReasoningWithSAT.NO && varValue == 1) || 
//							 (entry[0] == FTReasoningWithSAT.NO && entry[1] == FTReasoningWithSAT.YES && varValue == 0)	) {
//							// eliminate node from further processing
//							newDecisionSequence.put(varName, -1);  // eliminate node from further processing
//							// add inverse of node value as clause to the to SAT solver
//							addClauseToSolver(tempReasoner, varName, 1-varValue);
//							// add node to conflict list
//							conflictingFeatures.add(model.getNodeByID(varName));
//						}
//						// node can only be true (or false) which coincides with its current value 
//						else if ( (entry[0] == FTReasoningWithSAT.YES && entry[1] == FTReasoningWithSAT.NO && varValue == 0) || 
//								  (entry[0] == FTReasoningWithSAT.NO && entry[1] == FTReasoningWithSAT.YES && varValue == 1)) {
//							// eliminate node from further processing
//							newDecisionSequence.put(varName, -1);  
//							// add node value as clause to the to SAT solver
//							addClauseToSolver(tempReasoner, varName, varValue);
//						}
					}
 	       		}
 	       		index++;
 	       	}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems configuring model: " + e.getMessage());
		}
		finally {
 	       	model.restoreState("detect_conflicts", true);
		}
		return conflictingFeatures;
	}
	
	
	/******************************************************************************************************
	 * TOGGLE DECISION
	 *******************************************************************************************************/
	public synchronized List<ConfigurationStep> toggleDecision(String featureId) throws ConfigurationEngineException {
		// only features manually decided are considered
		List<ConfigurationStep> newConfSteps = new LinkedList<ConfigurationStep>();
		try {
			
			model.saveState("toggle_decision");
						
			// identify data about feature that will be toggled
			FeatureTreeNode toggleFeatureNode = model.getNodeByID(featureId);
			
			if ( !toggleFeatureNode.isInstantiated() ) {
				throw new ConfigurationEngineException("Cannot toggle the value of an uninstantiated feature");
			}
			
			if ( toggleFeatureNode.isImmutable() ) {
				throw new ConfigurationEngineException("Cannot toggle the value of an immutable feature");
			}
			
			int toggleFeatureOriginalValue = toggleFeatureNode.getValue();
			int toggleFeatureStep = Integer.valueOf((String)toggleFeatureNode.getProperty("decisionStep"));

 	       	// creates list of relevant decisions starting with the toggle feature and followed by other manual decisions 
 	       	Map<String,Integer> newDecisionSequence = new LinkedHashMap<String,Integer>();
 	       	newDecisionSequence.put(toggleFeatureNode.getID(), 1-toggleFeatureOriginalValue);
 	       	
 	       	// add manual decisions to list of relevant decisions (decisions that should be kept)
 	       	// and remove respective configuration steps
 	       	int initialStep = toggleFeatureStep-1;
 	       	while( steps.size() > initialStep ) { 	       		
 	       		for( FeatureTreeNode manualDecision : steps.get(initialStep).getDecisions() ) { 	       			
	 	       		if ( !manualDecision.equals(toggleFeatureNode) ) { 
	 	    	       	newDecisionSequence.put(manualDecision.getID(), manualDecision.getValue());
	 	       		}
 	       		}
 	       		// remove step from steps list
 	       		steps.remove(initialStep);
 	       	}						 	       	
						
			// restore model to state immediately before toggle feature's original decision
 	       	// and creates SAT solver to reflect that state
			model.restoreState("state_step" + toggleFeatureStep, false);
			reasoner = createSATReasoner(model);
 	       				
 	       	// applies sequence of relevant decisions and creates new configuration steps
 	       	int index = 0;
 	       	String [] newDecisionSequenceArray = newDecisionSequence.keySet().toArray(new String[0]);
 	       	for( String decisionNodeId : newDecisionSequenceArray ) {

 	       		int decisionNodeValue = newDecisionSequence.get(decisionNodeId);
 	       		
 	       		// skip previously-detected conflicting nodes (-1)
 	       		if ( decisionNodeValue != -1 ) {
 	       			
 	       			Map<String,Boolean[]> domainTable = createConfigurationStep(decisionNodeId, decisionNodeValue, "manual");
 	       			ConfigurationStep newConfStep = getLastStep();
 	       			newConfSteps.add(newConfStep);
 	       								
					// try to find conflicts
					for( int i = index+1 ; i < newDecisionSequenceArray.length ; i++ ) {
						
						String varName = newDecisionSequenceArray[i];
						int varValue = newDecisionSequence.get(varName);
						
						Boolean domain[] = domainTable.get(varName);
						
						// new and old values for this node CONFLICTS - remove node from being processed
						if ( (domain.length == 1 && domain[0] == true  && varValue == 0) || 
							 (domain.length == 1 && domain[0] == false && varValue == 1)	) {
							// eliminate node from further processing
							newDecisionSequence.put(varName, -1);  // eliminate node from further processing
						}
						// new and old values for this node are the SAME - add node to configuration step as decision 
						else if ( (domain.length == 1 && domain[0] == true  && varValue == 1) || 
								  (domain.length == 1 && domain[0] == false && varValue == 0)) {
							
							// eliminate node from further processing
							newDecisionSequence.put(varName, -1);
							
							// found out that a given propagation is actually a manual feature of a future step
							// add propagated feature as a manual decision in the step
							FeatureTreeNode propagatedFeature = model.getNodeByID(varName);					
							newConfStep.removePropagatedDecision(propagatedFeature);
							propagatedFeature.setProperty("decisionType", "manual");
							newConfStep.addManualDecisionFeature(propagatedFeature);					
						}
						else {
							System.out.println(">> " + varName);
						}
					}
 	       		}
 	       		index++;
 	       	}
		}
		catch (Exception e) {
			model.restoreState("toggle_decision", true);
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems toggling feature value: " + e.getMessage());
		}
		return newConfSteps;
	}
}
