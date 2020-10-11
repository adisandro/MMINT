package splar.core.fm.configuration;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;


public class ConfigurationStep {

	private String stepId;
	private Set<FeatureTreeNode> decisions;  // -a: a=false, +a: a=true
	private Set<FeatureTreeNode> propagations; 
	private Map<String,String> attributes;
	
	public ConfigurationStep(String stepId) {
		this.stepId = stepId;
		propagations = new LinkedHashSet<FeatureTreeNode>();
		decisions = new LinkedHashSet<FeatureTreeNode>();
		attributes = new HashMap<String,String>();
	}
	
	public int hashCode() {
		return stepId.hashCode();
	}
	
	public boolean equals(Object step) {
		if( this == step ) {
			return true;
		}
		if( (step == null) || (step.getClass() != this.getClass())) {
			return false;
		}
		return stepId.equals(((ConfigurationStep)step).stepId);
	}
		
	public String toString() {
		String toString = "["+stepId+": ";
		for( FeatureTreeNode featureNode : decisions ) {
			toString += "*"+featureNode.getName() + "=" + featureNode.getValue() + ",";
		}
		toString += "(";
		for( FeatureTreeNode featureNode : propagations ) {
			toString += featureNode.getName() + "=" + featureNode.getValue() + ",";
		}
		toString += ")]";
		return toString;
	}
	
	public String getId() {
		return stepId;
	}
	
	public int countDecisions() {
		return countManualDecisions() + countPropagations();
	}
	
	public int countManualDecisions() {
		return decisions.size();
	}
	
	public int countPropagations() {
		return propagations.size();
	}
	
	public void addManualDecisionFeature(FeatureTreeNode decidedFeature) {
		decisions.add(decidedFeature);
	}
	
	public void addPropagatedFeature(FeatureTreeNode propagatedFeature) {
		propagations.add(propagatedFeature);
	}
	
	public Set<FeatureTreeNode> getPropagations() {
		return propagations;
	}
	
	public Set<FeatureTreeNode> getDecisions() {
		return decisions;
	}

	public boolean removeManualDecision(FeatureTreeNode featureNode) {
		return decisions.remove(featureNode);
	}
	
	public boolean removePropagatedDecision(FeatureTreeNode featureNode) {
		return propagations.remove(featureNode);
	}
	
	public void addAttribute(String name, String value) {
		attributes.put(name, value);
	}
	
	public String getAttribute(String name) {
		return attributes.get(name);
	}
	
	public Map<String,String> getAttributesMap() {
		return attributes;
	}
	
	public static void computeStepAttributes(ConfigurationStep step, List<ConfigurationStep> stepsList, FeatureModel model) {
		// cummulative decisions
		int previousStepCountCummulativeDecisions = 0;
		if( !stepsList.isEmpty() ) {
			ConfigurationStep previousStep = stepsList.get(stepsList.size()-1);
			previousStepCountCummulativeDecisions = Integer.valueOf(previousStep.getAttribute("step_countCummulativeDecisions"));
		}
		int curStepCountCummulativeDecisions = step.countDecisions() + previousStepCountCummulativeDecisions;
		step.addAttribute("step_countCummulativeDecisions", String.valueOf(curStepCountCummulativeDecisions));
    	DecimalFormat format = new DecimalFormat("#0.0");
		step.addAttribute("step_percentageCummulativeDecisions", format.format((curStepCountCummulativeDecisions*100f)/model.countFeatures()));
	}
}












