package splar.core.constraints;

public class CNFLiteral {
	private BooleanVariableInterface variable;
	private boolean state;
	
	public CNFLiteral(BooleanVariableInterface variable, boolean state) {
		this.variable = variable;
		this.state = state;
	}
	
	public BooleanVariableInterface getVariable() {
		return variable;
	}
	
	public boolean isPositive() {
		return state;
	}
	
	public int hashCode() {
		String hashStr = (isPositive() ? "+" : "-") + variable;   
		return hashStr.hashCode();
	}
	
	public boolean equals(Object o) {
		CNFLiteral literal = (CNFLiteral)o;
		return literal.variable.equals(variable) && (literal.isPositive() == isPositive());
	}
	
	public String toString() {
		String toString = "";
		if ( !state ) {
			toString += "~";
		}
		toString += variable.getID();
		return toString;
	}	

	public String toString2() {
		if ( !state ) {
			return "(~" + variable.getID() + ")";
		}
		return variable.getID();
	}	
}
