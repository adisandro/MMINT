package splar.core.heuristics;

import java.util.ArrayList;
import java.util.List;

import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.clustering.FeatureModelClustersManager;
import splar.core.fm.clustering.NodeCluster;


/*
 * Given a node P, its child nodes A, B, C, D, E, F, G, and clauses (A,D), (A,F), (B,G)
 *  
 * Step 1: Creates clusters based on their clause dependencies
 * ------
 *     1. (A,D,F)
 *     2. (B,G)
 *     3. (C)
 *     4. (E) 
 * (*) Note that variables not in the clauses form a cluster each
 *  
 * Step 2: Sorts clusters (ascending-order) based on the size of the subtrees rooted by their nodes, say:
 * ------ 
 *    1. (B,G)	 - 78 nodes
 *    2. (E)     - 83 nodes
 *    3. (C)     - 187 nodes
 *    4. (A,D,F) - 200 nodes
 *    
 * Step 3: Sort cluster nodes based on their size; single-node clusters are not considered for obvious reasons, say:
 * ------
 *   1. (B,G)	- 18 + 60 = 78 nodes
 *   2. (E)		- 83 nodes
 *   3. (C)     - 187 nodes
 *   4. (D,F,A) - 20 + 80 + 100 = 200 nodes 
 *   
 * Step 4: Return the nodes order
 * ------ 
 *  >> B, G, E, C, D, F, A
 */
public class FTPreOrderClustersTraversalHeuristic extends FTPreOrderTraversalHeuristic {

	public static final int SIZE_SORT = 10;
	public static final int FORCE_SORT = 20;
	private int sortType = SIZE_SORT;
	private FeatureModelClustersManager clustersManager;
	
	public FTPreOrderClustersTraversalHeuristic(String name, FeatureModelClustersManager clustersManager, int sortType) {
		super(name, clustersManager.getFeatureModel());
		this.sortType = sortType; 
		this.clustersManager = clustersManager;		
	}
	
	protected FeatureTreeNode[] orderChildNodes(FeatureTreeNode node) {
		
		List<FeatureTreeNode> orderedNodes = new ArrayList<FeatureTreeNode>();
		
		// Step 1: Creates clusters based on their clause dependencies 
		// Step 2: Sorts clusters (ascending-order) based on the total size of their subtrees		
		for( NodeCluster cluster : clustersManager.sortClusterAscendingOrder(node) ) {
			FeatureTreeNode nodes[] = null;
			// Step 3: Sort cluster subtrees based on their size; single-node clusters are not considered for obvious reasons
			if ( sortType == SIZE_SORT || cluster.countNodes() <= 2) {
				nodes = cluster.sortedNodes();
			}
			// Step 3: Sort cluster subtrees using FORCE and its dependencies
			else if ( sortType == FORCE_SORT ){
				nodes = cluster.sortedNodesbyFORCE();
			}
			for( FeatureTreeNode sortedNode : nodes ) {
				orderedNodes.add(sortedNode);
			}
		}
		// Step 4: Return the nodes order			
		return orderedNodes.toArray(new FeatureTreeNode[0]);
	}	
	
	protected void runPreProcessing(CNFFormula cnf) {
		if ( !clustersManager.clustersReady() ) {
			clustersManager.createClusters();
		}
	}
	
}
