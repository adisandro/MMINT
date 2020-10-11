package splar.core.heuristics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;


public class FORCEVariableOrderingHeuristic extends VariableOrderingHeuristic {
	
	private final boolean DEBUG = false;
	 
	private static final int maxSpanReductionAttempts = 2;
	private BooleanVariableInterface initialVariableOrdering[];
	private int numReruns;    
	
	public FORCEVariableOrderingHeuristic(String name, int numReRuns) {
		this(name,null,numReRuns);
	}
	
	public FORCEVariableOrderingHeuristic(String name, BooleanVariableInterface initialVariableOrdering[], int numReRuns) {
		super(name);
		this.initialVariableOrdering = initialVariableOrdering;
		this.numReruns = numReRuns;
	}

	public void setParameter(String name, Object value) {
		if ( name.compareToIgnoreCase("variable_ordering_list") == 0 ) {
			if ( value != null && (value instanceof String ) ) {
				String voList = (String)value;
				initialVariableOrdering = VariableOrderingHeuristic.variableOrderingAsBooleanVariableArray(voList);
			}
		}
		else if (name.compareToIgnoreCase("num_reruns") == 0 ) {
			numReruns = Integer.parseInt((String)parameters.get("num_reruns"));
		}
		super.setParameter(name, value);
	}

	private BooleanVariableInterface[] getInitialVariableOrdering(CNFFormula cnf) {
		
		// if an initial variable ordering has been specified, returns it
		if ( initialVariableOrdering != null ) {
			return initialVariableOrdering;
		}
		
		// else, generates a random variable ordering
		List<BooleanVariableInterface> scrambledVariables = new ArrayList<BooleanVariableInterface>();
		scrambledVariables.addAll(cnf.getVariables());
		if ( DEBUG ) System.out.println("FORCE: Shuffling...");
		java.util.Collections.shuffle(scrambledVariables);
		return scrambledVariables.toArray(new BooleanVariableInterface[0]);
	}
	
	// algorithm based on paper: "FORCE: A Fast and Easy-To-Implement Variable-Ordering Heuristic"
	// By Fadi Aloul, Igor Markov, Karem Sakallah
	// ACM GLSVLSI 2003, April 28-29, 2003
	public String[] runHeuristic(CNFFormula cnf) {
	
		String varOrder[] = null;
		int runsMinSpan = Integer.MAX_VALUE;
		
		int numLoops = (initialVariableOrdering != null) ? 1 : numReruns;
		
		if (DEBUG) System.out.println("num loops: " + numLoops);
		
		for( int runIndex = 1 ; runIndex <= numLoops ; runIndex++ ) {

			if ( numLoops > 1 ) {
				System.out.println(">> FORCE: run #" + runIndex);
			}
			
			int countUnsuccessfulSpanReductions = 0;
			BooleanVariableInterface outputVariableOrdering[] = null;
			                                   
			// set initial variable ordering
			BooleanVariableInterface variables[] = getInitialVariableOrdering(cnf);
			Set<CNFClause> clauses = cnf.getClauses();
			
			Map<String,Integer> variableMap = VariableOrderingHeuristic.variableOrderingAsHashMap(variables);
			variableMap = VariableOrderingHeuristic.variableOrderingAsHashMap(variables);

			int countVars = variables.length;
			int countClauses = clauses.size();
			
			outputVariableOrdering = new BooleanVariableInterface[countVars];
			System.arraycopy(variables,0,outputVariableOrdering,0,countVars);
			
			int span = cnf.calculateClauseSpan(variableMap);
			int minSpan = span;
			
			if ( DEBUG ) System.out.println("Span: " + span);
			int countSteps = 0;
			
			// repeat limit times or until total span stops decreasing
			while( countUnsuccessfulSpanReductions < maxSpanReductionAttempts ) {
				
				// compute center of gravity of each clause
				double COG[] = new double[countClauses];
				int i = 0;
				for( CNFClause clause : clauses ) {
					double orderSum = 0;
					for( BooleanVariableInterface var : clause.getVariables() ) {
						try {
							orderSum += variableMap.get(var.getID()).intValue();
						}
						catch( Exception e ) {
							System.out.println("Var not found: " + var.getID());
							e.printStackTrace();
						}
					}
					COG[i++] = orderSum / clause.countVariables();
				}
				
				// for each vertex compute tentative new location of v based on centers of gravity of clauses
				for( BooleanVariableInterface var : variables ) {
					double sumCOG = 0; 
					int countVarClauses = 0;
					int clauseIndex = 0;
					for( CNFClause clause : clauses ) {
						if ( clause.getVariables().contains(var) ) {
							sumCOG += COG[clauseIndex];
							countVarClauses++; 
						}
						clauseIndex++;
					}				
					double varCOG = new Double(sumCOG / countVarClauses);
					var.attachData(varCOG);
				}
				
				// sort tentative vertex locations and assign integer indices to the variables
				Comparator<BooleanVariableInterface> comparator = new Comparator<BooleanVariableInterface>() {
					public int compare(BooleanVariableInterface var1, BooleanVariableInterface var2) {
						Double var1Score = (Double)var1.getAttachedData();
						Double var2Score = (Double)var2.getAttachedData();
						if ( var1Score.doubleValue() > var2Score.doubleValue() ) {
							return 1;
						}
						else if ( var1Score.doubleValue() < var2Score.doubleValue() ) {
							return -1;
						}
						return 0;
					}
					
					public boolean equals(Comparator<BooleanVariableInterface> comparator) {
						if ( comparator == null ) {
							return false;
						}
						return (comparator == this);
					}
				};
	
				java.util.Arrays.sort(variables, comparator);
				
				// variable to index mapping updated with new variable locations
				variableMap = VariableOrderingHeuristic.variableOrderingAsHashMap(variables);
				span = cnf.calculateClauseSpan(variableMap);
				
				countSteps++;
				if ( span < minSpan ) {
					minSpan = span;
//					outputVariableOrdering = new BooleanVariableInterface[countVars];
					System.arraycopy(variables,0,outputVariableOrdering,0,countVars);
					countUnsuccessfulSpanReductions = 0;
					if ( DEBUG ) System.out.println(countSteps + ": REDUCTION" + (runIndex+1) + "(" + countUnsuccessfulSpanReductions + ") Span: " + span);
				}
				else {
					countUnsuccessfulSpanReductions++;
					if ( DEBUG ) System.out.println(countSteps + ": NO REDUCTION " + (runIndex+1) + "(" + countUnsuccessfulSpanReductions + ") Span: " + span);
				}
			}		
			
			if ( minSpan < runsMinSpan ) {
				if ( outputVariableOrdering != null ) {
					varOrder = VariableOrderingHeuristic.variableOrderingAsStringVariableArray(outputVariableOrdering);
				}
				runsMinSpan = minSpan;
			}
		}
		
		return varOrder;
	}	
}

