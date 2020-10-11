package splar.core.constraints.parsing;


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

public class PFParser {

	private int index = 0;
	private static final int AND = 1;
	private static final int OR = 2;
	private static final int IMP = 3;
	private static final int BIIMP = 4;
	
	private static String letters = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String digits = "0123456789";
	private static String others = "_";
	private String all = letters + digits + others;
		
	public PFParser() {
		
	}
	
//	public BDD parse(String formula) throws Exception {
//		index = 0;
//		F(formula.trim());
//	}
//	
//	private String currentChar(String formula) {
//		return formula.substring(index,index+1);
//	}
//	
//	private PropositionalFormulaParseTree F(String formula, long start) throws Exception {
//		
//		// end of the formula
//		if (!EOF(formula)) {
//			// operator !
//			if (currentChar(formula).equals("~")) {
//				incrementIndex(formula);
//				skipBlanks(formula);
//				if ( isLetter(currentChar(formula)) ){
//					int varIndex = extractVar(formula, false);
//					if ( varIndex == -1 ) {
//						throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//					}
//				}
//				skipBlanks(formula);
//				if (!EOF(formula)) {
//					if (isLetter(currentChar(formula)) || currentChar(formula).equals("&") || currentChar(formula).equals("|") || 
//							currentChar(formula).equals("-") ||currentChar(formula).equals("<")) {
//						int op = operator(formula);
//						skipBlanks(formula);
//					}
//					else {
//					}
//				}
//				else {
//				}
//			}
//			// parenthesis "("
//			else if (currentChar(formula).equals("(")) {
//				incrementIndex(formula);
//				skipBlanks(formula);
//				F(formula, start);
//				if (!currentChar(formula).equals(")")){
//					throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//				}
//				incrementIndex(formula);
//				if (!EOF(formula)) {
//					skipBlanks(formula);
//					if (isLetter(currentChar(formula))||currentChar(formula).equals("&") || currentChar(formula).equals("|") || 
//							currentChar(formula).equals("-") ||currentChar(formula).equals("<")) {
//						int op = operator(formula);
//						skipBlanks(formula);
//					}
//					else if (!currentChar(formula).equals(")")) {
//						throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//					}
//				}
//			}
//			// variable name
//			else { 
//				int varIndex = extractVar(formula, true);
//				if ( varIndex == -1 ) {
//					throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//				}
//				skipBlanks(formula);
//				if ( !EOF(formula) && !currentChar(formula).startsWith(")")) {
//					int op = operator(formula);
//					skipBlanks(formula);
//				}
//			}
//		}
//	}
//	
//	private int operator(String formula) throws Exception {
//		int op = -1;
//		if ( isLetter(currentChar(formula))) {
//			String opStr = extractOperator(formula);
//			if ( opStr.compareToIgnoreCase("and") == 0 ) {
//				op = AND;
//			}
//			else if ( opStr.compareToIgnoreCase("or") == 0 ) {
//				op = OR;
//			}
//			else if ( opStr.compareToIgnoreCase("imp") == 0 ) {
//				op = IMP;
//			}
//			else if ( opStr.compareToIgnoreCase("biimp") == 0 ) {
//				op = BIIMP;
//			}
//			else {				
//				throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//			}
//		}
//		else if ( currentChar(formula).startsWith("|")) {
//			incrementIndex(formula);
//			op = OR;
//		}
//		else if (currentChar(formula).startsWith("&")) {
//			incrementIndex(formula);
//			op = AND;
//		}
//		else if (currentChar(formula).startsWith("-")) {
//			incrementIndex(formula);
//			if (!currentChar(formula).startsWith(">")) {
//				throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//			}
//			incrementIndex(formula);
//			op = IMP;
//		}
//		else if (currentChar(formula).startsWith("<")) {
//			incrementIndex(formula);
//			if (!currentChar(formula).startsWith("-")) {
//				throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//			}
//			incrementIndex(formula);
//			if (!currentChar(formula).startsWith(">")) {
//				throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//			}
//			incrementIndex(formula);
//			op = BIIMP;
//		}
//		else {
//			throw new Exception("Error on formula: " + formula + " at index (" + index + ")");
//		}
//		return op;
//	}
//	
//	private String extractOperator(String formula) {
//		StringBuffer opName = new StringBuffer();
//		if ( isLetter(currentChar(formula)) ) {
//			opName.append(currentChar(formula));
//			incrementIndex(formula);
//			while( !EOF(formula) && isValidChar(currentChar(formula))) {
//				opName.append(currentChar(formula));
//				incrementIndex(formula);
//			}			
//		}
//		return opName.toString();
//	}
//
//	private int extractVar(String formula, boolean varState) {
//		StringBuffer varName = new StringBuffer();
//		if ( isLetter(currentChar(formula)) ) {
//			varName.append(currentChar(formula));
//			incrementIndex(formula);
//			while( !EOF(formula) && isValidChar(currentChar(formula))) {
//				varName.append(currentChar(formula));
//				incrementIndex(formula);
//			}			
//			return index;
//		}
//		return -1;
//	}
//	
//	private boolean EOF(String formula) {
//		if ( index >= formula.length() ) {
//			return true;
//		}
//		return false;
//	}
//	
//	private boolean isLetter(String str) {
//		if (letters.indexOf(str)!= -1) {
//			return true;
//		}
//		return false;
//	}
//	
//	private boolean isValidChar(String str) {
//		if (all.indexOf(str) != -1) {
//			return true;
//		}
//		return false;
//	}
//	
//	
//	private void skipBlanks(String formula) {
//		if (!EOF(formula)) { 
//			while (currentChar(formula).startsWith(" ")) {
//				incrementIndex(formula);
//			}
//		}
//	}
//	
//	private void incrementIndex(String formula) {
//		index++;
//	}
	
}
