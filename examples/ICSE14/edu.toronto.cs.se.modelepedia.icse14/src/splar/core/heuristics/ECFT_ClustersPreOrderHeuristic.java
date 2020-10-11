package splar.core.heuristics;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.clustering.FeatureModelClustersManager;
import splar.core.fm.clustering.NodeCluster;



// First: Extra constraint variables visited in natural order (first to last)
// Second: Feature tree variables visited in pre-order
public class ECFT_ClustersPreOrderHeuristic extends FTTraversalHeuristic {

	public ECFT_ClustersPreOrderHeuristic(String name, FeatureModel featureModel) {
		super(name, featureModel);
	}
	
	public String[] runHeuristic(CNFFormula cnf) {		

		Set<String> variables = new LinkedHashSet<String>();		
		// Extra constraint variables
		FeatureModelClustersManager clusterManager = new FeatureModelClustersManager(featureModel);		
		clusterManager.createClusters();			
		for( FeatureTreeNode node : featureModel.getNodes() ) {
			List<NodeCluster> clusters = clusterManager.getNodeClusters(node);
			if ( clusters != null ) {
				for( NodeCluster cluster : clusters ) {
					if ( cluster.getECClauses() != null ) {
						for( CNFClause clause : cluster.getECClauses() ) {
							for( BooleanVariableInterface var : clause.getVariables() ) {
								if ( !variables.contains(var.getID()) ) {
									variables.add(var.getID());
								}
							}
						}
					}
				}
			}
		}				
		// Feature tree variables
		Set<BooleanVariableInterface> cnfVariables = cnf.getVariables();
		Stack<FeatureTreeNode> nodes = new Stack<FeatureTreeNode>();
		nodes.push(getFeatureModel().getRoot());
		while ( nodes.size() > 0 ) {
			FeatureTreeNode curNode = nodes.pop();
			if ( curNode != null ) {		
				if ( !(curNode instanceof FeatureGroup) ) {
					if ( cnfVariables.contains(curNode) && !variables.contains(curNode.getID())) {
						variables.add(curNode.getID());						
					}
				}
				FeatureTreeNode childNodes[] = orderChildNodes(curNode);
				for( int i = childNodes.length-1 ; i >= 0 ; i-- ) {
					nodes.push(childNodes[i]);						
				}
			}
		}
		return variables.toArray(new String[0]);
	}	
	
//	protected void runPreProcessing(CNFFormula cnf) {		
//	}
//
//	protected void runPostProcessing(CNFFormula cnf) {		
//	}

	protected FeatureTreeNode[] orderChildNodes(FeatureTreeNode node) {
		int count = node.getChildCount();
		FeatureTreeNode nodes[] = new FeatureTreeNode[count];
		for( int i = 0 ; i < count ; i++ ) {
			nodes[i] = ((FeatureTreeNode)node.getChildAt(i));									
		}
		return nodes;
	}
}
