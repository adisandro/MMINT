package splar.core.heuristics;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFLiteral;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.util.hypergraphs.Hyperedge;
import splar.core.util.hypergraphs.Hypergraph;
import splar.core.util.hypergraphs.Vertex;


public class FTPreOrderSortedECTraversalHeuristic extends FTPreOrderTraversalHeuristic {

	public static final int SIZE_SORT = 10;
	public static final int FORCE_SORT = 20;
	private int sortType = SIZE_SORT;
	
	public FTPreOrderSortedECTraversalHeuristic(String name, FeatureModel featureModel, int sortType) {
		super(name, featureModel);
		this.sortType = sortType; 
	}
	
	protected FeatureTreeNode[] orderChildNodes(FeatureTreeNode node) {
		
		List<FeatureTreeNode> orderedNodes = new ArrayList<FeatureTreeNode>();
		
		List<CNFClause> clauses = (List<CNFClause>)node.getAttachedData();
		
		 // Step 1: Creates clusters based on their clause dependencies 
		 // Step 2: Sorts clusters (ascending-order) based on the size of the subtrees rooted by their nodes, say:		
		NodeClusterManager clusterManager = new NodeClusterManager(featureModel);
		NodeCluster clusters[] = clusterManager.processCluster(node, clauses);
		
		node.setProperty("clusters", clusters);
		
		// Step 3: Sort cluster nodes based on their size; single-node clusters are not considered for obvious reasons, say:
		for( NodeCluster cluster : clusters ) {
			FeatureTreeNode nodes[] = null;
			if ( sortType == SIZE_SORT || cluster.countNodes() <= 2) {
				nodes = cluster.sortedNodes();
			}
			else if ( sortType == FORCE_SORT ){
				nodes = cluster.sortedNodesbyFORCE(clauses);
			}
			for( FeatureTreeNode sortedNode : nodes ) {
				orderedNodes.add(sortedNode);
			}
		}
		// Step 4: Return the nodes order			
		return orderedNodes.toArray(new FeatureTreeNode[0]);
	}	
	
	protected void runPreProcessing(CNFFormula cnf) {
		featureModel.resetNodesAttachedData();
		// attach to some nodes their correspondent CNF clauses
		for( PropositionalFormula pf : featureModel.getConstraints() ) {
			for( CNFClause cnfClause : pf.toCNFClauses() ) {
				CNFClause createdClause = new CNFClause();
				FeatureTreeNode node = createClause(cnfClause, createdClause);
				if ( createdClause.countVariables() > 1 ) {
					List<CNFClause> nodeAttachedList = (List<CNFClause>)node.getAttachedData();
					if ( nodeAttachedList == null ) {
						nodeAttachedList = new Vector<CNFClause>();
						node.attachData(nodeAttachedList);
					}
					nodeAttachedList.add(createdClause);
				}
			}
		}		
	}
	
	protected FeatureTreeNode createClause(CNFClause clause, CNFClause returnClause) {
		// for each variable in "clause" creates a list with its ancestors
		List<List<FeatureTreeNode>> ancestorsList = new Vector<List<FeatureTreeNode>>();
		for( BooleanVariableInterface var : clause.getVariables() ) {
			List<FeatureTreeNode> ancestors = new ArrayList<FeatureTreeNode>();
			FeatureTreeNode node = featureModel.getNodeByID(var.getID());
			if ( node != null ) {
				ancestors.add(0,node);
				FeatureTreeNode ancestorNode = (FeatureTreeNode)node.getParent();
//				ancestorNode = ( ancestorNode instanceof FeatureGroup )? (FeatureTreeNode)ancestorNode.getParent() : ancestorNode;
				while( ancestorNode != null ) {
					ancestors.add(0,ancestorNode);
					ancestorNode = (FeatureTreeNode)ancestorNode.getParent();
//					ancestorNode = ( ancestorNode instanceof FeatureGroup )? (FeatureTreeNode)ancestorNode.getParent() : ancestorNode;
				}
				ancestorsList.add(ancestors);
			}			
		}

		// find the list with the lowest number of variables
		int minSize = Integer.MAX_VALUE;
		for( List<FeatureTreeNode> list  : ancestorsList) {
			int listSize = list.size();
			if ( listSize < minSize ) {
				minSize = listSize;
			}
		}

		// find the lowest-level common ancestor and its corresponding children that are 
		// roots on the subtrees containing the variables in 'clause'
		FeatureTreeNode commonAncestor = null;
		boolean finalCommonAncestorFound = false;
		int index = 0;
		while(  index < minSize && !finalCommonAncestorFound ) {
			FeatureTreeNode ancestorNode = null;
			for( List<FeatureTreeNode> ancestors : ancestorsList ) {
				FeatureTreeNode tempNode = ancestors.get(index);
				if ( ancestorNode == null ) {
					ancestorNode = tempNode;
				}
				else if ( tempNode != ancestorNode ) {
					finalCommonAncestorFound = true;
				}
			}
			if ( !finalCommonAncestorFound ) {
				commonAncestor = ancestorNode;
			}
			index++;			
		}

		Set<BooleanVariableInterface> variables = new LinkedHashSet<BooleanVariableInterface>();
		for( List<FeatureTreeNode> ancestors : ancestorsList ) {
			if ( ancestors.size() >= index ) {
				variables.add(new BooleanVariable(ancestors.get(index-1).getID()));
			}
		}
		
		if ( variables.size() > 1 ) {
			for( BooleanVariableInterface var : variables ) {
				returnClause.addLiteral(new CNFLiteral(var,true));
			}
		}
		return commonAncestor;
	}	
}

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

class NodeClusterManager {
	
	private FeatureModel featureModel;
	
	public NodeClusterManager( FeatureModel featureModel ) {
		this.featureModel = featureModel;		
	}
	
	public NodeCluster[] processCluster(FeatureTreeNode node, List<CNFClause> clauses) {
		List<NodeCluster> nodeCluster = new ArrayList<NodeCluster>();
		
		 // STEP 1: Creates clusters based on their clause dependencies
		 // *********************************************************************
		
		// clauses mean dependency among subtrees... cluster have to be created and sorted
		if ( clauses != null ) {
			Hypergraph hyperGraph = new Hypergraph();
			
			// child nodes form the hypergraph vertices, each child node is also a single hyperedge
			for( int i = 0 ; i < node.getChildCount() ; i++ ) {
				FeatureTreeNode childNode = (FeatureTreeNode)node.getChildAt(i);
				Vertex vertex = new Vertex(childNode.getID());
				hyperGraph.addVertex(vertex);
				Hyperedge hyperedge = new Hyperedge();
				hyperedge.addVertex(vertex);
				hyperGraph.addHyperEdge(hyperedge);
			}
			
			// each clause becomes a hypergraph with a single hyperedge, ie, the clause itself
			// each hypergraph is then merged into the main hypergraph
			for( CNFClause clause : clauses ) {
				Hypergraph clauseHyperGraph = new Hypergraph();
				Hyperedge  clauseHyperEdge = new Hyperedge();
				for( CNFLiteral literal : clause.getLiterals() ) {
					Vertex vertex= hyperGraph.getVertexByName(literal.getVariable().getID());
					clauseHyperGraph.addVertex(vertex);
					clauseHyperEdge.addVertex(vertex);
				}
				clauseHyperGraph.addHyperEdge(clauseHyperEdge);
				hyperGraph.merge(clauseHyperGraph);
			}
			
			// create clusters, one for each hyperedge
			for( Hyperedge hyperedge : hyperGraph.getHyperedges() ) {
				NodeCluster cluster = new NodeCluster(featureModel);
				for( Vertex vertex : hyperedge.getVertices() ) {
					cluster.addNode(vertex.getName());
				}
				nodeCluster.add(cluster);
			}
		}
		// no clauses, then it's much simpler: each node forms a single cluster 
		else {
			for( int i = 0 ; i < node.getChildCount() ; i++ ) {
				FeatureTreeNode childNode = (FeatureTreeNode)node.getChildAt(i);
				NodeCluster cluster = new NodeCluster(featureModel);
				cluster.addNode(childNode.getID());
				nodeCluster.add(cluster);
			}
		}
		
		NodeCluster sortedNodeClusters[] = new NodeCluster[nodeCluster.size()];
		for( int index = 0 ; index < nodeCluster.size() ; index++ ) {
			sortedNodeClusters[index] = nodeCluster.get(index);
		}
		
		 // Step 2: Sorts clusters (ASCENDING-order) based on the size of the subtrees rooted by their nodes, say:
		 // *********************************************************************		
		Comparator<NodeCluster> c = new Comparator<NodeCluster>() {
			public int compare(NodeCluster cluster1, NodeCluster cluster2) {
				int size1 = cluster1.size();
				int size2 = cluster2.size();
				return ( size1 > size2 ? 1 : ((size1 < size2) ? -1 : 0) );
			}
		};
		java.util.Arrays.sort(sortedNodeClusters, c);
		
		
		return sortedNodeClusters;
	}	
}

class NodeCluster {

	private FeatureModel featureModel;
	private List<FeatureTreeNode> nodes;
	private int size = -1;
	private List<CNFClause> identifiedClauses; 
	
	public NodeCluster(FeatureModel featureModel) {
		this.featureModel = featureModel;
		this.nodes = new ArrayList<FeatureTreeNode>();
		this.identifiedClauses = null;
	}
	
	public int countNodes() {
		return nodes.size();
	}
	
	public List<CNFClause> identifyClauses(List<CNFClause> clauses) {
		
		if ( identifiedClauses != null ) {
			return identifiedClauses;
		}
		
		identifiedClauses = new ArrayList<CNFClause>();
		// for each clause
		for( CNFClause clause : clauses) {
			boolean clauseFound = false;
			// for each cluster node
			for( Iterator<FeatureTreeNode> it1 = nodes.iterator() ; it1.hasNext() && !clauseFound ; ) {
				FeatureTreeNode clusterNode = it1.next();
				// for each clause variable
				for ( Iterator<BooleanVariableInterface> it2 = clause.getVariables().iterator() ; it2.hasNext() && !clauseFound; ) {
					BooleanVariableInterface clauseVar = it2.next();
					// check if clause var is part of cluster node set
					if ( clauseVar.getID().equals(clusterNode.getID())) {
						identifiedClauses.add(clause);
						clauseFound = true;
					}
				}
			}
		}	
		return identifiedClauses;
	}
	
	public void addNode(String nodeID) {
		nodes.add(featureModel.getNodeByID(nodeID));
	}
	
	// count number of nodes for each cluster-node subtree
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
	public FeatureTreeNode[] sortedNodesbyFORCE(List<CNFClause> allClauses) {
		
		FORCEVariableOrderingHeuristic force = new FORCEVariableOrderingHeuristic("",1);
		CNFFormula cnf = new CNFFormula();
		
		identifiedClauses = identifyClauses(allClauses);
		cnf.addClauses(identifiedClauses);
		String vo[] = force.run(cnf);
		FeatureTreeNode voNodes[] = new FeatureTreeNode[vo.length];
		int index = 0;
		for( String nodeID : vo ) {
			voNodes[index++] = featureModel.getNodeByID(nodeID);
		}		
		
		return voNodes;
	}
}



