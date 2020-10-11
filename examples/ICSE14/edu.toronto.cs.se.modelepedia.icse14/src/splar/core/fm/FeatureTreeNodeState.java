package splar.core.fm;

import java.util.HashMap;
import java.util.Map;

public class FeatureTreeNodeState {
	
	private String stateID;
	protected FeatureTreeNode featureNode;
	protected int value;
	protected boolean isImmutable;
	protected Map<String,Object> properties;
	
	public String getStateID() {
		return stateID;
	}
	
	public FeatureTreeNodeState( String stateID, FeatureTreeNode featureNode ) {
		this.stateID = stateID;
		this.featureNode = featureNode;
	}
	
	public void save() {
		value = featureNode.getValue();
		isImmutable = featureNode.isImmutable();
		properties = new HashMap<String, Object>(featureNode.properties);
	}
	
	public void restore() {
		featureNode.assignValue(value);
		featureNode.setImmutable(isImmutable);
		featureNode.properties.clear();
		featureNode.properties.putAll(properties);
	}
	
	public int savedValue() {
		return value;
	}
	
	public void discard() {
	}
}
