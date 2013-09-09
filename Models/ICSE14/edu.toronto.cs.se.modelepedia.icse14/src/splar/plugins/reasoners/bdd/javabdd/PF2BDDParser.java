package splar.plugins.reasoners.bdd.javabdd;

import java.util.ArrayList;
import java.util.Map;

import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;

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

public class PF2BDDParser {

	private long maxParsingTimeAllowed;
	private long parsingTime;
	
	private int index = 0;
	private static final int AND = 1;
	private static final int OR = 2;
	private static final int IMP = 3;
	private static final int BIIMP = 4;
	
	private static String letters = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String digits = "0123456789";
	private static String others = "_";
	private String all = letters + digits + others;
	
	private BDDFactory bddFactory;
	protected Map<String,Integer> variable2indexMap;
	protected ArrayList<BooleanVariableInterface> variables;
	
	public PF2BDDParser(BDDFactory bddFactory, Map<String,Integer> variable2indexMap, long maxParsingTimeAllowed) {
		this.bddFactory = bddFactory;
		this.variable2indexMap = variable2indexMap;
		variables = new ArrayList<BooleanVariableInterface>();
		this.maxParsingTimeAllowed = maxParsingTimeAllowed;
		this.parsingTime = -1;
	}
	
	public long getPFParsingTime() {
		return parsingTime;
	}

	public BDD parse(String formula) throws Exception {
		index = 0;
		long start = System.currentTimeMillis();
		BDD bdd = F(formula.trim(), start);
		parsingTime = System.currentTimeMillis() - start;
		return bdd;
	}
	
	private String currentChar(String formula) {
		return formula.substring(index,index+1);
	}
	
	private BDD F(String formula, long start) throws Exception {
		BDD bdd = bddFactory.one();
		BDD tempBDD1, tempBDD2; 		
		
		long elapsedTime = (System.currentTimeMillis() - start);		
		if ( elapsedTime > maxParsingTimeAllowed ) {
			throw new BDDExceededBuildingTimeException("PF2BDDParser: Maximum time allowed for BDD construction exceeded: " + maxParsingTimeAllowed + " ms", "");
		}
		
		// end of the formula
		if (!EOF(formula)) {
			// operator !
			if (currentChar(formula).equals("~")) {
				incrementIndex(formula);
				skipBlanks(formula);
				if ( isLetter(currentChar(formula)) ){
					int varIndex = extractVar(formula, false);
					if ( varIndex == -1 ) {
						throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
					}
					tempBDD1 = bddFactory.ithVar(varIndex);
				}
				else {
					tempBDD1 = F(formula, start);
				}
				tempBDD1 = tempBDD1.not();
				skipBlanks(formula);
				if (!EOF(formula)) {
					if (isLetter(currentChar(formula)) || currentChar(formula).equals("&") || currentChar(formula).equals("|") || 
							currentChar(formula).equals("-") ||currentChar(formula).equals("<")) {
						int op = operator(formula);
						skipBlanks(formula);
						tempBDD2 = F(formula, start);
						bdd.andWith(applyBDDOp(tempBDD1, tempBDD2, op, start));
					}
					else {
						bdd.andWith(tempBDD1);
					}
				}
				else {
					bdd.andWith(tempBDD1);
				}
			}
			// parenthesis "("
			else if (currentChar(formula).equals("(")) {
				incrementIndex(formula);
				skipBlanks(formula);
				tempBDD1 = F(formula, start);
				if (!currentChar(formula).equals(")")){
					throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
				}
				incrementIndex(formula);
				if (!EOF(formula)) {
					skipBlanks(formula);
					if (isLetter(currentChar(formula))||currentChar(formula).equals("&") || currentChar(formula).equals("|") || 
							currentChar(formula).equals("-") ||currentChar(formula).equals("<")) {
						int op = operator(formula);
						skipBlanks(formula);
						tempBDD2 = F(formula, start);
						bdd.andWith(applyBDDOp(tempBDD1, tempBDD2, op, start));
					}
					else if (!currentChar(formula).equals(")")) {
						throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
					}
					else {
						bdd.andWith(tempBDD1);
					}
				}
				else {
					bdd.andWith(tempBDD1);
				}
			}
			// variable name
			else { 
				int varIndex = extractVar(formula, true);
				if ( varIndex == -1 ) {
					throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
				}
				tempBDD1 = bddFactory.ithVar(varIndex);
				skipBlanks(formula);
				if ( !EOF(formula) && !currentChar(formula).startsWith(")")) {
					int op = operator(formula);
					skipBlanks(formula);
					tempBDD2 = F(formula, start);
					bdd.andWith(applyBDDOp(tempBDD1, tempBDD2, op, start));
				}
				else {
					bdd.andWith(tempBDD1);
				}
			}
		}
		return bdd;
	}

	private BDD applyBDDOp(BDD bdd1, BDD bdd2, int op, long start) throws Exception {
		long elapsedTime = (System.currentTimeMillis() - start);		
		if ( elapsedTime > maxParsingTimeAllowed ) {
			throw new BDDExceededBuildingTimeException("PF2BDDParser: Maximum time allowed for BDD construction exceeded: " + maxParsingTimeAllowed + " ms", "");
		}
		BDD resultBDD = bddFactory.one();
		switch(op) {
			case AND:
				resultBDD.andWith(bdd1.and(bdd2));
				break;
			case OR:
				resultBDD.andWith(bdd1.or(bdd2));
				break;
			case IMP:
				resultBDD.andWith(bdd1.imp(bdd2));
				break;
			case BIIMP:
				resultBDD.andWith(bdd1.biimp(bdd2));
				break;
		}
		return resultBDD;
	}
	
	private int operator(String formula) throws Exception {
		int op = -1;
		if ( isLetter(currentChar(formula))) {
			String opStr = extractOperator(formula);
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
				throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
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
				throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
			}
			incrementIndex(formula);
			op = IMP;
		}
		else if (currentChar(formula).startsWith("<")) {
			incrementIndex(formula);
			if (!currentChar(formula).startsWith("-")) {
				throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
			}
			incrementIndex(formula);
			if (!currentChar(formula).startsWith(">")) {
				throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
			}
			incrementIndex(formula);
			op = BIIMP;
		}
		else {
			throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
		}
		return op;
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

	private int extractVar(String formula, boolean varState) {
		StringBuffer varName = new StringBuffer();
		if ( isLetter(currentChar(formula)) ) {
			varName.append(currentChar(formula));
			incrementIndex(formula);
			while( !EOF(formula) && isValidChar(currentChar(formula))) {
				varName.append(currentChar(formula));
				incrementIndex(formula);
			}			
			int index = createVarIndex(varName.toString());
			if ( index != -1 ) {
				BooleanVariable variable = new BooleanVariable(varName.toString());
				variable.setState(varState);
				variables.add(variable);
			}			
			return index;
		}
		return -1;
	}
	
	public ArrayList<BooleanVariableInterface> getVariables() {
		return variables;
	}
	
	private int createVarIndex(String varName) {
		Integer index = variable2indexMap.get(varName);
		if (index != null ){
			return index.intValue();
		}
		return -1;
		
	}

	private boolean EOF(String formula) {
		if ( index >= formula.length() ) {
			return true;
		}
		return false;
	}
	
	private boolean isLetter(String str) {
		if (letters.indexOf(str)!= -1) {
			return true;
		}
		return false;
	}
	
	private boolean isValidChar(String str) {
		if (all.indexOf(str) != -1) {
			return true;
		}
		return false;
	}
	
	
	private void skipBlanks(String formula) {
		if (!EOF(formula)) { 
			while (currentChar(formula).startsWith(" ")) {
				incrementIndex(formula);
			}
		}
	}
	
	private void incrementIndex(String formula) {
		index++;
	}
	
}
