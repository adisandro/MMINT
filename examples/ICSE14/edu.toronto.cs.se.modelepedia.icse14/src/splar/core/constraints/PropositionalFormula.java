package splar.core.constraints;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import splar.core.util.hypergraphs.Hyperedge;
import splar.core.util.hypergraphs.Hypergraph;
import splar.core.util.hypergraphs.Vertex;

public class PropositionalFormula {

	protected String name;
	protected ArrayList<BooleanVariable> variables;
	protected String formula;
	protected PFParser parser;

    protected HashMap<String,PropositionalFormulaState> states;

	public PropositionalFormula(String name, String formula) throws Exception {
		this.name = name;
		this.formula = formula;
		variables = new ArrayList <BooleanVariable>();
		states = new HashMap<String,PropositionalFormulaState>();
		parser = new PFParser(this);
		parser.parse();
	}
	
	public void appendToFormula(String formulaPart) {
		formula += formulaPart;
	}
	
	public void appendToVariables(BooleanVariable var) {
		assert !variables.contains(var);
		variables.add(var);
	}
	
/*	public boolean containsVariable(BooleanVariable variable) {
		return variables.contains(variable);
	}
	
	public boolean isInstantiated(BooleanVariable variable) {
		BooleanVariable var = getVariable(variable.getName());
		if ( var != null ) {
			return var.isInstantiated();
		}
		return false;		
	}		
	*/
	
	public void replaceVariable( String oldName, String newName ) {
//		for( Iterator<BooleanVariable> it = variables.iterator() ; it.hasNext() ; ) {
//			String varName = it.next().getID();
//			if ( varName.compareToIgnoreCase(oldName) == 0) {
//				it.remove();
//				variables.add(new BooleanVariable(newName));
//				break;
//			}
//		}
		variables = new ArrayList <BooleanVariable>();
		try {
			Map<String,String> replacements = new HashMap<String, String>();
			replacements.put(oldName, newName);
			formula = new PFParser(this).replace(replacements);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Assignment getInstantiatedVariables() {
		Assignment a = new Assignment();
		for( Iterator<BooleanVariable> it = variables.iterator() ; it.hasNext() ; ) {
			BooleanVariable var = it.next();
			if ( var.isInstantiated() ) {
				a.add(var);
			}
		}				
		return a;
	}	

	public String getName() {
		return name;
	}
	
	public String getType() {
		return "undefined-type";
	}
	
	public String getVariableListAsString() {
		return ""+variables;
	}
	
	public Collection<BooleanVariable> getVariables() {
		return variables;
	}
	
	protected void addVariable(BooleanVariable var) {
		if ( !variables.contains(var) ) {
			var.assignValue(-1);
			variables.add(var);
		}
	}
	
	public BooleanVariable getVariable(String name) {
		return variables.get(getIndex(name));
	}

	protected void removeVariable(BooleanVariable var) {
		variables.remove(variables.get(getIndex(getName())));
	}

	public String toString() {
		return toCNFClauses().toArray(new CNFClause[0])[0].toString();
//		String toString = name + ": ";
//		formula = "";
//		for( CNFClause clause : toCNFClauses() ) {
//			formula += clause.toString();
//		}		
//		toString += formula;		
//		return toString;
		
//		StringBuffer toString = new StringBuffer(200);
//		toString.append(getName());
//		toString.append(": <");
//		for( Iterator<BooleanVariable> it = variables.iterator() ; it.hasNext() ; ) {
//			BooleanVariable bi = it.next();
//			toString.append(bi.getID());
//			toString.append(":");
//			toString.append(bi.getValue());
//			if ( it.hasNext() ) {
//				toString.append(",");
//			}
//		}
//		toString.append(">");
//		return toString.toString();		
	}
	
	public int getIndex(String varName) {
		int length = variables.size();
		for( int i = 0 ; i < length ; i++ ) {
			BooleanVariable vi = variables.get(i);
			if ( vi.getID().equals(varName) )
				return i;
		}
		return -1;
	}
	
	public void saveState(String stateID) {
		if ( !states.containsKey(stateID) ) {
			PropositionalFormulaState state = new PropositionalFormulaState(this);
			state.save();
			states.put(stateID, state);
		}
	}
	
	public void restoreState(String stateID) {
		PropositionalFormulaState state = states.get(stateID);
		state.restore();
		states.remove(stateID);
	}
	
	public void discardState(String stateID) {
		states.remove(stateID);
	}
	
	public void assignValue(String varName, int value) {
		BooleanVariable var = variables.get(getIndex(varName));
		if ( var != null ) {
			var.assignValue(value);		
		}
	}
	
	public int countVars() {
		return variables.size();
	}
	
	public String getFormula() {
		return formula;
	}	
	
	/*
	 * Generic function that builds a hypergraph where 
	 * - vertices = constraint variables
	 * - hyperedges = single hyperedge linking all vertices (constraint variables) 
	 */
	public Hypergraph buildHyperGraph() {
		
		Hypergraph hGraph = new Hypergraph();
		
		// a single hyperedge connects all varibles
		Hyperedge hyperEdge = new Hyperedge();
		
		// Constraint variables become hypergraph vertices
		for( Iterator<BooleanVariable> it = variables.iterator(); it.hasNext() ; ) {
			String varName = it.next().getID();
			Vertex vertex = new Vertex(varName);
			hGraph.addVertex(vertex);
			hyperEdge.addVertex(vertex);
		}
		
		// add hyperedge to the hypergraph
		hGraph.addHyperEdge(hyperEdge);
				
		return hGraph;
	}
	
	/* To be fixed: the method only works if the propositional formula is already in CNF :) - sorry */
	public Collection<CNFClause> toCNFClauses() {
		Collection<CNFClause> clauses = new Vector<CNFClause>();
		CNFClause clause = new CNFClause();
		for( Iterator<BooleanVariable> it = variables.iterator(); it.hasNext() ; ) {
			BooleanVariable variable = it.next();
			clause.addLiteral(new CNFLiteral(variable, variable.isPositive()));
		}
		clauses.add(clause);
		return clauses;
	}
	
}

/*
 *      Propositional Formulas Grammar
 *      ------------------------------
 * 		F  ::= p | ~F | F op F | (F)
 * 		op ::= | | & | -> | <-> | OR | AND | IMP | BIIMP  (case INsensitive) 
 * 		p  ::= variable (letter + letter|digit|_)
 * 
 *  Remarks: 
 *  Operator "~" should only precede variables (never formulas) 
 * 
 */

class PFParser {

	protected int index = 0;
	
	private static final int AND = 1;
	private static final int OR = 2;
	private static final int IMP = 3;
	private static final int BIIMP = 4;
	
	protected static String letters = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	protected static String digits = "0123456789";
	protected static String others = "_";
	protected String all = letters + digits + others;
	protected PropositionalFormula pformula;
	protected String parsedFormula = "";
	protected Map<String,String> replacements;
	
	public PFParser(PropositionalFormula pformula) {
		this.pformula = pformula;
		replacements = null;
	}
	
	public String replace(Map<String,String> replacements) throws Exception {
		parsedFormula = "";
		this.replacements = replacements;
		parse();
		return parsedFormula;
	}
	
	public void parse() throws Exception {
		parsedFormula = "";
		parse(pformula.getFormula());
	}
	
	protected void parse(String formula) throws Exception {
		index = 0;
		F(formula.trim());
	}
	
	protected String currentChar(String formula) {
		return formula.substring(index,index+1);
	}
	
	protected void F(String formula) throws Exception {
		// end of the formula
		if (!EOF(formula)) {
			// operator !
			if (currentChar(formula).equals("~")) {
				parsedFormula += "~";
				incrementIndex(formula);
				skipBlanks(formula);
				if ( isLetter(currentChar(formula)) ){
					parsedFormula += extractVar(formula, false);
				}
				skipBlanks(formula);
				parsedFormula += " ";
				if (!EOF(formula)) {
					if (isLetter(currentChar(formula)) || currentChar(formula).equals("&") || currentChar(formula).equals("|") || 
							currentChar(formula).equals("-") ||currentChar(formula).equals("<")) {
						parsedFormula += operator(formula);
						skipBlanks(formula);
						parsedFormula += " ";
					}
				}
			}
			// parenthesis "("
			else if (currentChar(formula).equals("(")) {
				parsedFormula += "(";
				incrementIndex(formula);
				skipBlanks(formula);
				parsedFormula += " ";
				F(formula);
				if (!currentChar(formula).equals(")")){
					throw new Exception("Error on formula " + pformula.getFormula() +" at index (" + index + ")");
				}
				parsedFormula += ")";				
				incrementIndex(formula);
				if (!EOF(formula)) {
					skipBlanks(formula);
					parsedFormula += " ";
					if (isLetter(currentChar(formula))||currentChar(formula).equals("&") || currentChar(formula).equals("|") || 
							currentChar(formula).equals("-") ||currentChar(formula).equals("<")) {
						parsedFormula += operator(formula);
						skipBlanks(formula);
						parsedFormula += " ";
						F(formula);
					}
					else if (!currentChar(formula).equals(")")) {
						throw new Exception("Error at index (" + index + ")");
					}
				}
			}
			// variable name
			else { 
				parsedFormula += extractVar(formula, true);
				skipBlanks(formula);
				parsedFormula += " ";
				if ( !EOF(formula) && !currentChar(formula).startsWith(")")) {
					parsedFormula += operator(formula);
					skipBlanks(formula);
					parsedFormula += " ";
					F(formula);
				}
			}
		}
	}

	protected String operator(String formula) throws Exception {
		int op = -1;
		String opStr = "<error>";
		if ( isLetter(currentChar(formula))) {
			opStr = extractOperator(formula);
			if ( opStr.compareToIgnoreCase("and") == 0 ) {
				op = AND;
			}
			else if ( opStr.compareToIgnoreCase("or") == 0 ) {
				op = OR;
			}
			else if ( opStr.compareToIgnoreCase("imp") == 0 ) {
				op = IMP;
			}
			else if ( opStr.compareToIgnoreCase("biimp") == 0 ) {
				op = BIIMP;
			}
			else {
				throw new Exception("Error at index (" + index + ")");
			}
		}
		else if ( currentChar(formula).startsWith("|")) {
			incrementIndex(formula);
			op = OR;
		}
		else if (currentChar(formula).startsWith("&")) {
			incrementIndex(formula);
			op = AND;
		}
		else if (currentChar(formula).startsWith("-")) {
			incrementIndex(formula);
			if (!currentChar(formula).startsWith(">")) {
				throw new Exception("Error at index (" + index + ")");
			}
			incrementIndex(formula);
			op = IMP;
		}
		else if (currentChar(formula).startsWith("<")) {
			incrementIndex(formula);
			if (!currentChar(formula).startsWith("-")) {
				throw new Exception("Error at index (" + index + ")");
			}
			incrementIndex(formula);
			if (!currentChar(formula).startsWith(">")) {
				throw new Exception("Error at index (" + index + ")");
			}
			incrementIndex(formula);
			op = BIIMP;
		}
		if ( op == -1 )
			throw new Exception("Error at index (" + index + "): Invalid operator!");
		return opStr;
	}
	
	private String extractOperator(String formula) {
		StringBuffer opName = new StringBuffer();
		if ( isLetter(currentChar(formula)) ) {
			opName.append(currentChar(formula));
			incrementIndex(formula);
			while( !EOF(formula) && isValidChar(currentChar(formula))) {
				opName.append(currentChar(formula));
				incrementIndex(formula);
			}			
		}
		return opName.toString();
	}
	
	protected String extractVar(String formula, boolean varState) {
		String varName = "";
		if ( isLetter(currentChar(formula)) ) {
			varName += currentChar(formula);
			incrementIndex(formula);
			while( !EOF(formula) && isValidChar(currentChar(formula))) {
				varName += currentChar(formula);
				incrementIndex(formula);
			}		
			if ( replacements != null ) {
				String newVarName = replacements.get(varName);
				if ( newVarName != null ) {
					varName = newVarName;
				}
			}
			// pformula already prevents the inclusion of duplicates
			BooleanVariable variable = new BooleanVariable(varName);
			variable.setState(varState);
			pformula.addVariable(variable);
		}
		return varName;		
	}
	
	protected boolean EOF(String formula) {
		if ( index >= formula.length() ) {
			return true;
		}
		return false;
	}
	
	protected boolean isLetter(String str) {
		if (letters.indexOf(str)!= -1) {
			return true;
		}
		return false;
	}
	
	protected boolean isValidChar(String str) {
		if (all.indexOf(str) != -1) {
			return true;
		}
		return false;
	}
	
	
	protected void skipBlanks(String formula) {
		if (!EOF(formula)) { 
			while (currentChar(formula).startsWith(" ")) {
				incrementIndex(formula);
			}
		}
	}
	
	protected void incrementIndex(String formula) {
		index++;
	}
}

class PropositionalFormulaState {
	
	protected int savedVariables[];
    private PropositionalFormula formula;

    public PropositionalFormulaState(PropositionalFormula formula) {
		this.formula = formula;
	}
	
	public void save() {
		int size = formula.variables.size();
		savedVariables = new int[size];
		for( int i = 0 ; i < size ; i++ ) {
			BooleanVariable bi = formula.variables.get(i);			
			savedVariables[i] = bi.getValue();
		}		
	}
	
	public void restore() {
		for( int i = 0 ; i < savedVariables.length; i++ ) {
			BooleanVariable bi = formula.variables.get(i);
			bi.assignValue(savedVariables[i]);
		}		
	}
	
}

