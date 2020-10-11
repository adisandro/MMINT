package splar.core.fm.randomization;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFGenerator;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureTreeNode;

public class Random3CNFFeatureModel extends RandomFeatureModel2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8424917116428155893L;
	private CNFGenerator cnfGenerator = null; 
	
	public Random3CNFFeatureModel(String name,int numberOfFeaturesToCreate, int mandatoryOdds, int optionalOdds, int group1NOdds, int group11Odds, int minChildrenPerNode, int maxChildrenPerNode, int maxGroupCardinality, int balanceFactor) {
		super(name, numberOfFeaturesToCreate, mandatoryOdds, optionalOdds, group1NOdds, group11Odds, minChildrenPerNode, maxChildrenPerNode, maxGroupCardinality, balanceFactor );
		cnfGenerator = new CNFGenerator();
	}
	
	public void createCrossTreeConstraintsAsRandom3CNFFormula(int numVars, float clauseDensity) {

		// Creates a 3-CNF feature model, i.e., a FT + 3-CNF CTC
		// Creates a CNF formula based on distinct random feature model variables
		List<BooleanVariableInterface> vars  = new LinkedList<BooleanVariableInterface>();
		for( FeatureTreeNode var : this.getNodes() ) {
			if ( !(var instanceof FeatureGroup ) && !this.isRoot(var) ){
				vars.add(var);
			}
		}
		Collections.shuffle(vars);
		int size = vars.size()-numVars;
		for( int j = 1 ; j <= size ; j++ ) {
			vars.remove(vars.size()-1);
		}
		
		List<CNFClause> clauses = cnfGenerator.generateCNFInstance(vars, null, clauseDensity, 3);
	
		// Add clauses to feature model
		int clauseCounter = 1;
		for( CNFClause clause : clauses ) {
			try {
				this.addConstraint(new PropositionalFormula("Clause3CNF_"+(clauseCounter++),clause.toPropositionalFormula()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void dumpMetaData() {
		System.out.println("<meta>");
		System.out.println("<data name=\"description\">This is a 3-CNF Feature Model generated automatically</data>");
		System.out.println("<data name=\"creator\">SPLOT Feature Model Generator</data>");
		System.out.println("<data name=\"email\"></data>");
		System.out.println("<data name=\"date\">" + new Date() + "</data>");
		System.out.println("<data name=\"department\">SPLOT Project</data>");
		System.out.println("<data name=\"organization\">University of Waterloo</data>");
		System.out.println("<data name=\"address\"></data>");
		System.out.println("<data name=\"phone\"></data>");
		System.out.println("<data name=\"website\">http://www.splot-research.org/</data>");
		System.out.println("<data name=\"reference\">http://www.splot-research.org/</data>");
		System.out.println("</meta>");
	}


	
}
