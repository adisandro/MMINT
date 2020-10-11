package splar.core.fm;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

class FeatureModelState {
	
	private String stateID;
	private FeatureModel featureModel;
	
    private List<FeatureTreeNode> lastPropagatedNodes = null;

	
	public FeatureModelState(String stateID, FeatureModel featureModel) {
		this.stateID = stateID;
		this.featureModel = featureModel;		
	}
	
	public String getStateID() {
		return stateID;
	} 
	
	public void save() {
		lastPropagatedNodes = new Vector<FeatureTreeNode>();
		lastPropagatedNodes.addAll(featureModel.lastPropagatedNodes);
		for( FeatureTreeNode featureNode : featureModel.getNodes() ) {
			featureNode.saveState(stateID);
		}
	}
	
	public void restore() {
		for( FeatureTreeNode featureNode : featureModel.getNodes() ) {
			featureNode.restoreState(stateID, false);
		}
		
		featureModel.lastPropagatedNodes.clear();
		featureModel.lastPropagatedNodes.addAll(this.lastPropagatedNodes);
	}
	
	public void discard() {
		for( FeatureTreeNode featureNode : featureModel.getNodes() ) {
			featureNode.discardState(stateID);
		}
	}
}

