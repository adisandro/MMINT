package splar.core.fm.clustering;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.heuristics.FORCEVariableOrderingHeuristic;



public class NodeCluster {

	private FeatureTreeNode root;
	private FeatureModel featureModel;
	private List<FeatureTreeNode> nodes;
	private int size = -1;
	private List<CNFClause> ecClauses; 
	private List<CNFClause> clusterClauses; 
	
	public NodeCluster(FeatureModel featureModel, FeatureTreeNode root) {
		this.root = root;
		this.featureModel = featureModel;
		this.nodes = new ArrayList<FeatureTreeNode>();
		this.ecClauses = null;
		this.clusterClauses = null;
	}
	
	public List<FeatureTreeNode> getNodes() {
		return nodes;
	}
	
	public FeatureTreeNode getRoot() {
		return root;
	}
	
	public void addNode(FeatureTreeNode node) {
		nodes.add(node);
	}
	
	public void addECClauses(List<CNFClause> ecClauses) {
		this.ecClauses = ecClauses;
	}
	
	public void addClusterClauses(List<CNFClause> clusterClauses) {
		this.clusterClauses = clusterClauses;
	}
	
	public List<CNFClause> getECClauses() {
		return ecClauses;
	}
	
	public List<CNFClause> getClusterClauses() {
		return clusterClauses;
	}
	
	// count number of nodes for each cluster-node subtree
	public int countNodes() {
		return nodes.size();
	}
	
	public int size() {
		if ( size == -1 ) {
			for( FeatureTreeNode node : nodes ) {
				size += featureModel.countNodes(node);
			}
		}
		return size;
	}

	// cluster nodes are sorted in ASCENDING order of the size of their subtrees 
	public FeatureTreeNode[] sortedNodes() {
		
		FeatureTreeNode[] sortedNodes = new FeatureTreeNode[nodes.size()];
		int index = 0;
		for( FeatureTreeNode node : nodes ) {
			sortedNodes[index++] = node;
		}

		if ( sortedNodes.length > 1 ) {
			Comparator<FeatureTreeNode> c = new Comparator<FeatureTreeNode>() {
				public int compare(FeatureTreeNode node1, FeatureTreeNode node2) {
					int size1 = featureModel.countNodes(node1);
					int size2 = featureModel.countNodes(node2);
					return ( size1 > size2 ? 1 : ((size1 < size2) ? -1 : 0) );
				}
			};
			java.util.Arrays.sort(sortedNodes, c);
		}			
		
		return sortedNodes;
	}
	
	
	// sort nodes based on FORCE heuristic
	public FeatureTreeNode[] sortedNodesbyFORCE() {
		
		FORCEVariableOrderingHeuristic force = new FORCEVariableOrderingHeuristic("",1);
		CNFFormula cnf = new CNFFormula();

		cnf.addClauses(clusterClauses);
		String vo[] = force.run(cnf);
		FeatureTreeNode voNodes[] = new FeatureTreeNode[vo.length];
		int index = 0;
		for( String nodeID : vo ) {
			voNodes[index++] = featureModel.getNodeByID(nodeID);
		}		
		
		return voNodes;
	}
	
	public void dump() {
		System.out.println("\nCluster: " + root.getID());
		System.out.print("  Nodes: ");
		for( FeatureTreeNode node : nodes ) {
			System.out.print( node.getID() + ", ");
		}
		if ( clusterClauses != null ) {
			System.out.print("\n  Cluster clauses: ");
			for( CNFClause clause: clusterClauses) {
				System.out.print( clause + ", ");
			}
		}
		if ( ecClauses != null ) {
			System.out.print("\n  EC clauses: ");
			for( CNFClause clause: ecClauses) {
				System.out.print( clause + ", ");
			}
		}
	}
}
