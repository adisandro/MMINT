package splar.core.heuristics;

import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureModel;

public abstract class FTTraversalHeuristic extends VariableOrderingHeuristic {
	
	protected FeatureModel featureModel;
	
	public FTTraversalHeuristic(String name, FeatureModel featureModel) {
		super(name);
		this.featureModel = featureModel;
	}
	
	public FeatureModel getFeatureModel() {
		return featureModel;
	}

	public void setParameter(String name, Object value) {
		if ( name.compareToIgnoreCase("feature_model") == 0 ) {
			if ( value != null && (value instanceof FeatureModel ) ) {
				featureModel = (FeatureModel)value;
			}
		}
		super.setParameter(name, value);
	}

}
