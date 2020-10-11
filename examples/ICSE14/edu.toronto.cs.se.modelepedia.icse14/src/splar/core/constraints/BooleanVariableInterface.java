package splar.core.constraints;

public interface BooleanVariableInterface {	
	public String getID();
	public void assignValue(int value);
	public void assignValue(int value, BooleanVariableInterface propagationVar);
	public boolean isPropagation();
	public BooleanVariableInterface getPropagationVariable();
	public int getValue();
	public boolean isInstantiated();
	public void resetValue();
	public void setImmutable(boolean immutable);
	public boolean isImmutable();
	public void attachData(Object object);
	public Object getAttachedData();
	public void resetAttachedData();	
}
