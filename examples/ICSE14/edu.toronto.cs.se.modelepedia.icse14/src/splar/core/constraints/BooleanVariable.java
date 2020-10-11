package splar.core.constraints;

import splar.core.fm.FeatureTreeNode;

public class BooleanVariable implements BooleanVariableInterface {
	
	private String name;
	private int value;
	private boolean isImmutable;
	private BooleanVariableInterface propagationVar = null;
	private boolean state; // true-positive, false-negative
	
	public BooleanVariable( String name ) {
		this.name = name;
		value = -1;
		isImmutable = false;
	}

	public BooleanVariable( String name, int value ) {
		this.name = name;
		this.value = value;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean isPositive() {
		return state;
	}
	
	public void setImmutable(boolean immutable) {
		isImmutable = immutable;
	}
	
	public boolean isImmutable() {
		return isImmutable;
	}
	
	
	public String getID() {
		return name;
	}

	public void assignValue(int value, BooleanVariableInterface propagationVar) {
		if ( !isImmutable ) {			
			this.value = value;
			this.propagationVar = propagationVar;
		}
	}
	
	public boolean isPropagation() {
		return (propagationVar != null);
	}
	
	public BooleanVariableInterface getPropagationVariable() {
		return propagationVar;
	}
	
	
	public void assignValue(int value){
		if ( !isImmutable ) {			
			this.value = value;
			propagationVar = null;			
		}
	}
	
	public int getValue() {
		return value;
	}
		
	public boolean isInstantiated() {
		return value != -1;
	}
	
	public void resetValue() {
		if ( !isImmutable ) {
			value = -1;
		}
	}

	private Object attachedData;
	public void attachData(Object object) {
		attachedData= object;
	}
	
	public Object getAttachedData() {
		return attachedData;
	}

	public void resetAttachedData() {
		attachedData = null;
	}
	
	public int hashCode() {
		return getID().hashCode();
	}
	
	public boolean equals(Object var) {
		if ( var == null )
			return false;
//		if ( var instanceof FeatureTreeNode ) {
//			return name.equals(((FeatureTreeNode)var).getID());
//		}
		return getID().equals(((BooleanVariableInterface)var).getID());
	}
	
	public String toString() {
		return name + ": " + value;
	}
}
