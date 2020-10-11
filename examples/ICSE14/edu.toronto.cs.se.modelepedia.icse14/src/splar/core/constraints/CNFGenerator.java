package splar.core.constraints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CNFGenerator {

	private Map<String,byte[]> clausesMap = null;
	private int varIndex;

	public CNFGenerator() {
		clausesMap = new HashMap<String, byte[]>();
		varIndex = -1;
	}
	
	public List<CNFClause> generateCNFInstance(List<BooleanVariableInterface> variables, List<CNFClause> clauses, float clauseDensity, int arity) {

		clausesMap.clear();
		// store intial clauses in the clauses map
		if ( clauses != null ) {
			for( CNFClause clause : clauses ) {
				storeClause(clause, arity);
			}
		}
		
		varIndex = -1;
		List<CNFClause> createdClauses = new LinkedList<CNFClause>();
		// number of clauses to create is clause density times number of variables
		int numClausesToCreate = (int)(clauseDensity * variables.size())- (clauses  == null ? 0 : clauses.size());
//		System.out.println("Needs to create " + numClausesToCreate + " clauses");
//		System.out.println("Created clauses -------------------------");
		for( int i = 0 ; i < numClausesToCreate ; i++ ) {
			CNFClause createdClause = createNewClause(variables, arity);
			if ( storeClause(createdClause, arity) ) {
				createdClauses.add(createdClause);
			}
		}
		
		return createdClauses;  
	}	

	// Pick three distinct variables randomly
	private List<BooleanVariableInterface> pickVariables(List<BooleanVariableInterface> variables, int arity) {
		List<BooleanVariableInterface> pickedVars = new ArrayList<BooleanVariableInterface>(arity);
		Random randomGen = new Random();
		int numVars = variables.size();
		for( int i = 0 ; i < arity ; i++ ) {
			BooleanVariableInterface var = null;
			do {
				var = variables.get(Math.abs(randomGen.nextInt())%numVars);
			} while ( pickedVars.contains(var) );
			pickedVars.add(var);
		}
		return pickedVars;		
	}
	
//	private List<BooleanVariableInterface> pickVariables(List<BooleanVariableInterface> variables, int arity) {
//		List<BooleanVariableInterface> pickedVars = new ArrayList<BooleanVariableInterface>(arity);
//		if ( varIndex == -1 ) {
//			Collections.shuffle(variables);
//			varIndex++;
//		}
//		int oldVarIndex = varIndex;
//		for( int i = 0 ; i < arity ; i++ ) {
//			System.out.println(variables.get(varIndex).getID());
//			pickedVars.add(variables.get(varIndex));
//			varIndex = (varIndex+1)%variables.size();
//		}
//		if ( varIndex < oldVarIndex ) {
//			Collections.shuffle(variables);
//		}
//		return pickedVars;		
//	}
	
//	public static List<BooleanVariableInterface> _pickVariables(List<BooleanVariableInterface> variables, int arity) {
//
//		Collections.shuffle(variables);
//		
//		List<BooleanVariableInterface> uncheckedVars = new LinkedList<BooleanVariableInterface>();
//		for( BooleanVariableInterface var : variables ) {
//			if ( varsMap.get(var.getID()) == null ) {
//				uncheckedVars.add( var );
//			}
//			if ( uncheckedVars.size() == arity ) break;
//		}
//		int j = 0;
//		for( int i = uncheckedVars.size() ; i < arity ; ) {
//			if ( !uncheckedVars.contains(variables.get(j)) ) {
//				uncheckedVars.add(variables.get(j));
//				i++;
//			}
//			j++;
//		}
//		if ( uncheckedVars.size() == 0 ) {
//			uncheckedVars = variables;
//		}
//		assert uncheckedVars.size() >= arity;
//		
//		List<BooleanVariableInterface> pickedVars = new LinkedList<BooleanVariableInterface>();
//		for( int i = 0 ; i < arity ; i++ ) {
//			pickedVars.add(uncheckedVars.get(i));
//			varsMap.put(uncheckedVars.get(i).getID(), true);
//		}
//		
//		return pickedVars;
//	}
	
	private CNFClause createNewClause(List<BooleanVariableInterface> variables, int arity ) {		
		CNFClause newClause = null;
		
		List<BooleanVariableInterface> pickedVariables = pickVariables(variables, arity);
		
		byte existingClauses[] = null;
		int pos = -1;
		int maxLoop = Math.max(1000,pickedVariables.size());
		do {
			newClause = new CNFClause();
			for( int i = 0 ; i < arity ; i++) {
				newClause.addLiteral(new CNFLiteral(pickedVariables.get(i), new Random().nextBoolean()));
			}
			String key = getClauseKey(newClause);
			pos = getClausePos(newClause);
			existingClauses = clausesMap.get(key);
		}
		while( existingClauses != null && existingClauses[pos] != 0 && (maxLoop--) > 0);	
		return newClause;
	}
	
	private boolean storeClause(CNFClause clause, int arity) {
		
		assert clause.getLiterals().size() == arity;
		
		// find clause key and
		// find clause position in possible clauses with same variables
		String key = getClauseKey(clause);
		int pos = getClausePos(clause);

		byte existingClauses[] = clausesMap.get(key);
		if ( existingClauses == null ) {
			existingClauses = new byte[(int)Math.pow(2, arity)];
			clausesMap.put(key, existingClauses);
		}
		
		// if clause has not been created yet, creates it and returns true
		if ( existingClauses[pos] == 0 ) {
			existingClauses[pos] = 1;
//			System.out.println("Clause: " + clause + " stored at position " + pos);
			return true;
		}
		
		// clause already exists
		return false;
	}
	
	private String getClauseKey(CNFClause clause) {
		String key = "";
		List<CNFLiteral> literals = clause.getLiterals();
		Collections.sort(literals, new CNFLiteralComparator());
		for( CNFLiteral literal : literals ){
			key += literal.getVariable().getID() + "-";
		}
		return key;
	}	
	
	private int getClausePos(CNFClause clause) {
		int pos = 0;
		int power = 1;
		List<CNFLiteral> literals = clause.getLiterals();
		Collections.sort(literals, new CNFLiteralComparator());
		for( CNFLiteral literal : literals ){
			pos += (literal.isPositive() ? 0 : 1) * power; 
			power *= 2;
		}
		return pos;
	}

	public String getStats(Set<CNFClause> clauses) {
		return getStats(new LinkedList<CNFClause>(clauses));
	}
	
	public String getStats(List<CNFClause> clauses) {
		
		Set<CNFLiteral> literals = new LinkedHashSet<CNFLiteral>();
		Set<BooleanVariableInterface> variables = new LinkedHashSet<BooleanVariableInterface>();
		
		int arities[] = {0,0,0,0};
		for( CNFClause clause : clauses ) {
			literals.addAll(clause.getLiterals());
			variables.addAll(clause.getVariables());
			int index = clause.getLiterals().size()-1;			
			arities[index < 4 ? index : arities.length-1]++;
			
		}
		
		String stats = ""; 
		
		stats += "\r\n  Total Variables: " + variables.size();
		stats += "\r\n  Total Literals.: " + literals.size();
		stats += "\r\n  Total Clauses..: " + clauses.size();
		stats += "\r\n  Clause density.: " + (1f*clauses.size())/variables.size();
//		stats += "\r\n  Clause arity...: ";
//		stats += "\r\n  - 1 ..........: " + arities[0] + " (" + (1.0*arities[0])/clauses.size()*100 + "%)";
//		stats += "\r\n  - 2 ..........: " + arities[1] + " (" + (1.0*arities[1])/clauses.size()*100 + "%)";;
//		stats += "\r\n  - 3 ..........: " + arities[2] + " (" + (1.0*arities[2])/clauses.size()*100 + "%)";;
//		stats += "\r\n  - > 3 ........: " + arities[3] + " (" + (1.0*arities[3])/clauses.size()*100 + "%)";;
		
		
		return stats;
	}	
}







//public class CNFGenerator {
//
//	private static Map<String,byte[]> clausesMap = new HashMap<String, byte[]>();
//	
//	public static List<CNFClause> generate3CNFInstance(List<BooleanVariableInterface> variables, List<CNFClause> clauses, float clauseDensity) {
//		List<CNFClause> createdClauses = new LinkedList<CNFClause>();
//
////		System.out.println("Existing clauses -------------------------");
//		
//		// store intial clauses in the clauses map
//		if ( clauses != null ) {
//			for( CNFClause clause : clauses ) {
//				storeClause(clause);
//			}
//		}
//		
//		// number of clauses to create is clause density times number of variables
//		int numClausesToCreate = (int)(clauseDensity * variables.size())- (clauses  == null ? 0 : clauses.size());
////		System.out.println("Needs to create " + numClausesToCreate + " clauses");
////		System.out.println("Created clauses -------------------------");
//		for( int i = 0 ; i < numClausesToCreate ; i++ ) {
//			CNFClause createdClause = createNewTernaryClause(variables);
//			if ( storeClause(createdClause) ) {
//				createdClauses.add(createdClause);
//			}
//		}
//		
//		return createdClauses;  
//	}	
//	
//	public static CNFClause createNewTernaryClause(List<BooleanVariableInterface> variables ) {		
//		CNFClause newClause = null;
//		Collections.shuffle(variables);
//		byte existingClauses[] = null;
//		int pos = -1;
//		int maxLoop = Math.max(1000,variables.size());
//		do {
//			newClause = new CNFClause();
//			for( int i = 0 ; i < 3 ; i++) {
//				newClause.addLiteral(new CNFLiteral(variables.get(i), new Random().nextBoolean()));
//			}
//			String key = getClauseKey(newClause);
//			pos = getClausePos(newClause);
//			existingClauses = clausesMap.get(key);
//		}
//		while( existingClauses != null && existingClauses[pos] != 0 && (maxLoop--) > 0);	
//		return newClause;
//	}
//	
//	public static boolean storeClause(CNFClause clause) {
//		
//		assert clause.getLiterals().size() == 3;
//		
//		// find clause key and
//		// find clause position in possible clauses with same variables
//		String key = getClauseKey(clause);
//		int pos = getClausePos(clause);
//
//		byte existingClauses[] = clausesMap.get(key);
//		if ( existingClauses == null ) {
//			existingClauses = new byte[8];
//			clausesMap.put(key, existingClauses);
//		}
//		
//		// if clause has not been created yet, creates it and returns true
//		if ( existingClauses[pos] == 0 ) {
//			existingClauses[pos] = 1;
////			System.out.println("Clause: " + clause + " stored at position " + pos);
//			return true;
//		}
//		
//		// clause already exists
//		return false;
//	}
//	
//	public static String getClauseKey(CNFClause clause) {
//		String key = "";
//		List<CNFLiteral> literals = clause.getLiterals();
//		Collections.sort(literals, new CNFLiteralComparator());
//		for( CNFLiteral literal : literals ){
//			key += literal.getVariable().getID() + "-";
//		}
//		return key;
//	}	
//	
//	public static int getClausePos(CNFClause clause) {
//		int pos = 0;
//		int power = 1;
//		List<CNFLiteral> literals = clause.getLiterals();
//		Collections.sort(literals, new CNFLiteralComparator());
//		for( CNFLiteral literal : literals ){
//			pos += (literal.isPositive() ? 0 : 1) * power; 
//			power *= 2;
//		}
//		return pos;
//	}
//	
//	public static String getStats(Set<CNFClause> clauses) {
//		
//		Set<CNFLiteral> literals = new LinkedHashSet<CNFLiteral>();
//		Set<BooleanVariableInterface> variables = new LinkedHashSet<BooleanVariableInterface>();
//		
//		int arities[] = new int[4];
//		for( CNFClause clause : clauses ) {
//			literals.addAll(clause.getLiterals());
//			variables.addAll(clause.getVariables());
//			int index = clause.getLiterals().size()-1;			
//			arities[index < 4 ? index : arities.length-1]++;
//			
//		}
//		
//		String stats = ""; 
//		
//		stats += "\r\n  Total Variables: " + variables.size();
//		stats += "\r\n  Total Literals.: " + literals.size();
//		stats += "\r\n  Total Clauses..: " + clauses.size();
//		stats += "\r\n  Clause density.: " + (1f*clauses.size())/variables.size();
//		stats += "\r\n  Clause arity...: ";
//		stats += "\r\n  - 1 ..........: " + arities[0] + " (" + (1.0*arities[0])/clauses.size()*100 + "%)";
//		stats += "\r\n  - 2 ..........: " + arities[1] + " (" + (1.0*arities[1])/clauses.size()*100 + "%)";;
//		stats += "\r\n  - 3 ..........: " + arities[2] + " (" + (1.0*arities[2])/clauses.size()*100 + "%)";;
//		stats += "\r\n  - > 3 ........: " + arities[3] + " (" + (1.0*arities[3])/clauses.size()*100 + "%)";;
//		
//		
//		return stats;
//	}	
//}
//
//
//
//
//
//
//
