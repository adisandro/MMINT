package splar.plugins.reasoners.bdd.javabdd;

import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFLiteral;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.SolitaireFeature;
import splar.core.fm.clustering.FeatureModelClustersManager;
import splar.core.fm.clustering.NodeCluster;
import splar.core.heuristics.VariableOrderingHeuristic;
import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.BDDFactory.ReorderMethod;

public class FMReasoningWithBDD extends FTReasoningWithBDD {

	public FMReasoningWithBDD(FeatureModel featureModel, VariableOrderingHeuristic voHeuristic, int nodeNum, int cacheSize, long maxBuildingtime, String orderingFormulasStrategy) {
		this(featureModel, voHeuristic, nodeNum, cacheSize, maxBuildingtime, BDDFactory.REORDER_NONE, orderingFormulasStrategy);		
	}

	public FMReasoningWithBDD(FeatureModel featureModel, VariableOrderingHeuristic voHeuristic, int nodeNum, int cacheSize, long maxBuildingtime, ReorderMethod reorderMethod, String orderingFormulasStrategy) {
		super(featureModel, voHeuristic, nodeNum, cacheSize, maxBuildingtime, reorderMethod, orderingFormulasStrategy);
	}

	protected BDD createBDDStructure(long startTime, String orderingFormulasStrategy) throws BDDExceededBuildingTimeException {
		BDD bdd = null;
		if ( orderingFormulasStrategy.compareToIgnoreCase("pre-order-cluster") == 0 ) {			
//			System.out.println("Using strategy: " + orderingFormulasStrategy);
			FeatureModelClustersManager clustersManager = new FeatureModelClustersManager(featureModel);
			clustersManager.createClusters();			
			bdd = preOrderClusterFormulaOrdering(clustersManager,featureModel.getRoot(), startTime);
		}
		else {
//			System.out.println(">>>>>  Generating BDD for Feature Tree...");
			long start = System.nanoTime();		
			bdd = super.createBDDStructure(startTime, orderingFormulasStrategy);
			long end = System.nanoTime();
//			System.out.println(">>>>>  Done Generating BDD for Feature Tree: " + ((end-start)/1E6) + " ms");
			
//			System.out.println(">>>>>  Generating BDD for Extra Constraints......");
			start = System.nanoTime();
			for( PropositionalFormula pf : featureModel.getConstraints() ) {
				String formula = pf.getFormula();
				if ( formula != null ) {
					if ( formula.trim().length() > 0 ) {
						long maxParsingTime = (startTime+maxBuildingTime) - (System.currentTimeMillis());
						PF2BDDParser parser = new PF2BDDParser(bddFactory, varName2IndexMap, maxParsingTime);
						try {
							BDD tempBDD = parser.parse(formula);
							if ( tempBDD != null ) {
								bdd.andWith(tempBDD);
							}
						} 
						catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}
			end = System.nanoTime();
//			System.out.println(">>>>>  Done Generating BDD for Extra Constraints: " + ((end-start)/1E6) + " ms");
		}		
		return bdd;
	}
	
	protected BDD preOrderClusterFormulaOrdering(FeatureModelClustersManager clustersManager, FeatureTreeNode curNode, long startTime) throws BDDExceededBuildingTimeException {
		
		BDD bdd = bddFactory.one();		
		BDD parentNodeBDD = bddFactory.ithVar(varName2IndexMap.get(curNode.getID()));
		
		int count = curNode.getChildCount();
		if ( count > 0 ) {
			BDD childBDD = null;
			for( int i = 0 ; i < count ; i++ ) {
				FeatureTreeNode childNode = ((FeatureTreeNode)curNode.getChildAt(i));						
				// It's a solitaire feature
				if ( childNode instanceof SolitaireFeature ) {						
					SolitaireFeature solitaireNode = (SolitaireFeature)childNode;
					childBDD = bddFactory.ithVar(varName2IndexMap.get(childNode.getID()));
					// if node is optional relation is "child implies parent"
					if ( solitaireNode.isOptional() ) {
						bdd.andWith(childBDD.imp(parentNodeBDD.id()));
					}
					// if node is mandatory relation is "child iff parent"
					else {
						bdd.andWith(childBDD.biimp(parentNodeBDD.id()));
					}
					// recursive call
					BDD subtreeBDD = preOrderClusterFormulaOrdering(clustersManager, childNode, startTime);
					bdd.andWith(subtreeBDD);
					
				}
				// It's a feature group						
				else if ( childNode instanceof FeatureGroup ) {
					FeatureGroup fGroup = (FeatureGroup)childNode;
					BDD fgBDD = createFeatureGroupBDDStructure(parentNodeBDD.id(),fGroup, null, bddFactory, startTime);
					bdd.andWith(fgBDD);
					// recursive call
					for( int j = 0 ; j < fGroup.getChildCount() ; j++ ) {
						FeatureTreeNode groupedNode = (FeatureTreeNode)fGroup.getChildAt(j);
						// recursive call
						BDD subtreeBDD = preOrderClusterFormulaOrdering(clustersManager, groupedNode, startTime);
						bdd.andWith(subtreeBDD);
					}
				}
				else {
					System.out.println("Error: Other type of node!");
				}
			}
		}

		// generate BDD for cluster EC constraints
		for( NodeCluster cluster : clustersManager.sortClusterAscendingOrder(curNode) ) {
			if ( cluster.getECClauses() != null ) {
				long start = System.nanoTime();
				System.out.println(">>>>>  Generating BDD for Extra Constraint relations..." + curNode.getID());
				for( CNFClause clause : cluster.getECClauses() ) {							
					BDD clauseBDD = bddFactory.zero();
					for( CNFLiteral literal : clause.getLiterals() ) {
						if ( literal.isPositive() ) {
							clauseBDD.orWith(bddFactory.ithVar(varName2IndexMap.get(literal.getVariable().getID())));
						}
						else {
							clauseBDD.orWith(bddFactory.nithVar(varName2IndexMap.get(literal.getVariable().getID())));
						}
					}
					bdd.andWith(clauseBDD);
				}
				long end = System.nanoTime();
				System.out.println(">>>>>  Done Generating BDD for Extra Constraint relations..." + curNode.getID() + " (" + ((end-start)/1E6) + "ms)");
			}
		}					
		
		
		return bdd;
	}
	
	protected CNFFormula toCNF() {
		return featureModel.FM2CNF();		
	}	
}
