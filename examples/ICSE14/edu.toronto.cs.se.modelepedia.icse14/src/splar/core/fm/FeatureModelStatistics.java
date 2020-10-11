package splar.core.fm;

import java.util.Iterator;

import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.PropositionalFormula;


public class FeatureModelStatistics  {

	private FeatureModel fm;
	int root=0;
	int opt = 0;
	int man = 0;
	int grp11 = 0; 
	int grp1n = 0;
	int fgrp11 = 0;
	int fgrp1n = 0;
	
	public FeatureModelStatistics(FeatureModel fm) {
		this.fm = fm;
	}
	
	public FeatureModel getFeatureModel() {
		return fm;
	}
	
	public void reset() {
		root=0;
		opt = 0;
		man = 0;
		grp11 = 0;
		grp1n = 0;
		fgrp11 = 0;
		fgrp1n = 0;
	}

	public void update() {
		reset();
		for( Iterator<FeatureTreeNode> it = fm.nodesIterator(); it.hasNext() ; ) {
			FeatureTreeNode node = it.next();
			
			if ( node instanceof RootNode ) {
				root++;
			}
			else if ( node instanceof SolitaireFeature ) {
				if ( ((SolitaireFeature)node).isOptional() ) {
					opt++;					
				}
				else {
					man++;
				}
			}
			else if ( node instanceof GroupedFeature ) {
				FeatureGroup fg = (FeatureGroup)(node.getParent());
				int min = fg.getMin();
				int max = fg.getMax();
				if ( min == max && min == 1) {
					grp11++;
				}
				else if ( min == 1 && (max == -1 || max == fg.getChildCount())){
					grp1n++;
				}
			}			
			else if ( node instanceof FeatureGroup ) {
				FeatureGroup fg = (FeatureGroup)node;
				int min = fg.getMin();
				int max = fg.getMax();
				if ( min == max && min == 1) {
					fgrp11++;
				}
				else if ( min == 1 && (max == -1 || max == fg.getChildCount())){
					fgrp1n++;
				}
			}			
		}
	}

	public int countNodes() {
		return fm.countNodes();
	}
	
	public int countFeatures() {
		return 	root+opt+man+grp11+grp1n;
	}
	
	
	public int depth() {
		return fm.depth();
	}
	
	public int countMandatory() {
		return this.man;
	}
	
	public int countOptional() {
		return this.opt;
	}
	
	public int countGrouped() {
		return this.grp11 + this.grp1n;
	}
	
	public int countGrouped11() {
		return this.grp11;
	}
	
	public int countGrouped1n() {
		return this.grp1n;
	}
	
	public int countGroups11() {
		return this.fgrp11;
	}
	
	public int countGroups1N() {
		return this.fgrp1n;
	}
	
	public int countConstraints() {
		return fm.countConstraints();
	}
	
	public int countConstraintVars() {
		return fm.countConstraintsVariables();
	}
	
	public double getAverageDepth() {
		return fm.getAverageDepth();
	}
	
	public double getDepthStandardDeviation() {
		return fm.getDepthStandardDeviation();
	}
	
	public double getDepthDeviationCoeficient() {
		return fm.getDepthDeviationCoeficient();
	}

	public int countFeatureModelCNFClauses() {
		return fm.FM2CNF().countClauses();
	}
	
	public int countFeatureTreeCNFClauses() {
		return fm.FT2CNF().countClauses();
	}
	
	public int countExtraConstraintCNFClauses() {
		return fm.EC2CNF().countClauses();
	}
	
	public int[] count23NClauses() {
		int clauseSizeCounter[] = new int[3];
		java.util.Arrays.fill(clauseSizeCounter, 0);
		for( CNFClause clause : fm.FM2CNF().getClauses() ) {
			int numVars = clause.countVariables();
			if ( numVars == 2) {
				clauseSizeCounter[0]++;
			}
			else if ( numVars == 3) {
				clauseSizeCounter[1]++;
			}
			else { 
				clauseSizeCounter[2]++;
			}
		}		
		return clauseSizeCounter;		                                  
	}

	public double getECClauseDensity() {
		CNFFormula cnf = fm.EC2CNF();
		return (cnf == null) ? 0 : cnf.getClauseDensity();
	}
	
	public double getECRepresentativeness() {
		return fm.countConstraintsVariables()/(1.0*fm.countFeatures());
	}
		
	// decisions = number of times a feature has been assigned a truth value  
	public long countDecisions() {
		return fm.getInstantiatedNodes().size();
	}
	
	public int countInstantiatedNodes() {
		return fm.getInstantiatedNodes().size();
	}
	
	public int countUninstantiatedNodes() {
		return fm.countNodes()-fm.getInstantiatedNodes().size();
	}

	public String toString() {
		StringBuffer str = new StringBuffer(100);
		str.append("*************************************************************");
		str.append("\r\nFEATURE TREE STATISTICS");
		str.append("\r\n");
		str.append("  Model name.: " + fm.getName());
		str.append("\r\n");
		str.append("  tree depth.: ");
		str.append(fm.depth());
		str.append("\r\n");
//		str.append("depth (average): " + fm.getAverageDepth());
//		str.append(fm.depth());
//		str.append("\r\n");
//		str.append("depth (standard deviation): " + getDepthStandardDeviation() + " (" + (getDepthDeviationCoeficient()*100) +"%) - (gives a notion of the tree balancing)");
//		str.append("\r\n");
		str.append("  #root......: ");
		str.append(root);
		str.append("\r\n");
		str.append("  #opt.......: ");
		str.append(opt);
		str.append("\r\n");
		str.append("  #man.......: ");
		str.append(man);
		str.append("\r\n");
		str.append("  #grouped...: ");
		str.append(grp11+grp1n);
		str.append("\r\n");
		str.append("  #grouped [1,1]: ");
		str.append(grp11);
		str.append("\r\n");
		str.append("  #grouped [1,n]: ");
		str.append(grp1n);
		str.append("\r\n");
		str.append("  #fgrp [1,1]: ");
		str.append(fgrp11);
		str.append(" (exclusive-OR)\r\n");
		str.append("  #fgrp [1,N]: ");
		str.append(fgrp1n);
		str.append(" (inclusive-OR)\r\n");
		str.append("  #total features: ");
		str.append(countFeatures());
		str.append("\r\n");
		str.append("  #total nodes: ");
		str.append((root+opt+man+grp11+grp1n+fgrp11+fgrp1n));
		
		String formula = "";
		int countConstraints = 0;
		for( Iterator<PropositionalFormula> it = fm.getConstraints().iterator() ; it.hasNext() ; ) {
			PropositionalFormula pf = it.next();
			formula += "(" + pf.getFormula() + ")";
			if ( it.hasNext() ) {
				formula += " AND ";
			}
			countConstraints++;
		}  
		try {
//			PropositionalFormula pf = new PropositionalFormula("", formula);
//			str.append("\n#constraints........: " + countConstraints);
//			str.append("\n#vars in constraints: " + pf.getVariables().size());
//			int numCNFClauses = countFeatureModelCNFClauses();
//			str.append("\n#CNF clauses........: " + numCNFClauses + " (Feature Tree + Extra Constraints)");			
//			int clausesSize[] = count23NClauses();
//			str.append("\n  2-variable clauses........: " + clausesSize[0]);
//			str.append("\n  3-variable clauses........: " + clausesSize[1]);
//			str.append("\n  > 3-variable clauses......: " + clausesSize[2]);
//			str.append("\n  hardness if 2+p-SAT.......: " + clausesSize[2]/(1f*numCNFClauses) + "(<0.4: polynomial behavior, >=0.4: hard)");

			
//			str.append("\nCNF CLAUSES: Feature Tree ");
//			str.append(cnfGenerator.getStats(fm.FT2CNF().getClauses()));
//			str.append("\nCNF CLAUSES: Cross-Tree Constraints ");
//			str.append(cnfGenerator.getStats(fm.EC2CNF().getClauses()));
//			str.append("\nCNF CLAUSES: Entire Feature Model");
//			str.append(cnfGenerator.getStats(fm.FM2CNF().getClauses()));
		}
		catch( Exception e) {
			e.printStackTrace();
		}
		
		return str.toString();
	}
	
	public void dump() {	
			System.out.println(toString());	
	}
}
