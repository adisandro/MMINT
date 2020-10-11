package splar.core.fm.clustering;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFLiteral;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.heuristics.FORCEVariableOrderingHeuristic;
import splar.core.heuristics.FTPreOrderTraversalHeuristic;
import splar.core.util.hypergraphs.Hyperedge;
import splar.core.util.hypergraphs.Hypergraph;
import splar.core.util.hypergraphs.Vertex;



/*
 * For each node N and its child nodes A, B, C, D, E, F, G, and clauses (A,D), (A,F), (B,G)
 *  
 * >> Creates clusters for N based on the their dependencies as in the extra constraints
 *     1. (A,D,F)
 *     2. (B,G)
 *     3. (C)
 *     4. (E) 
 * (*) Note that variables not in the clauses form a cluster each
 *  
 */

public class FeatureModelClustersManager {
	
	private FeatureModel featureModel;
	private Map<FeatureTreeNode,List<NodeCluster>> clusters;
	
	public FeatureModelClustersManager( FeatureModel featureModel ) {
		this.featureModel = featureModel;		
		clusters = new LinkedHashMap<FeatureTreeNode,List<NodeCluster>>();
	}
	
	public FeatureModel getFeatureModel() {
		return featureModel;
	}
	
	public List<NodeCluster> getNodeClusters(FeatureTreeNode node) {
		return clusters.get(node);
	}

	public boolean clustersReady() {
		return clusters.size() > 0;
	}
	
	public void createClusters() {
		Map<FeatureTreeNode,Hypergraph> clustersHypergraphs = createHypergraphsForNodesInEC();
		createClustersForAllNodes(clustersHypergraphs);
	}
	
	private Map<FeatureTreeNode,Hypergraph> createHypergraphsForNodesInEC() {
		
		Map<FeatureTreeNode,Hypergraph> nodesClusters = new LinkedHashMap<FeatureTreeNode,Hypergraph>();
		
		// Traverse EC CNF clauses and create clusters (hypergraphs) for related nodes (lowest common anscestors) 
		for( PropositionalFormula pf : featureModel.getConstraints() ) {
			for( CNFClause cnfClause : pf.toCNFClauses() ) {
				CNFClause clusterClause = new CNFClause();
				FeatureTreeNode node = createClusterClause(cnfClause, clusterClause);

				// create a Hypergraph for each node
				// - the hyperedges represent the clusters
				// - hyperedges also store the original CNF clause from EC
				// - and the clause connecting the 'node's child nodes
				// - feature groups have a single cluster including all its grouped nodes
				Hypergraph hyperGraph = nodesClusters.get(node);
				if ( hyperGraph == null ) {
					hyperGraph = new ClusterHypergraph();
					Hyperedge hyperedge = null;
					nodesClusters.put(node, hyperGraph);
					for( int i = 0 ; i < node.getChildCount() ; i++ ) {
						FeatureTreeNode childNode = (FeatureTreeNode)node.getChildAt(i);
						Vertex vertex = new Vertex(childNode.getID());
						hyperGraph.addVertex(vertex);
						// feature groups have a single cluster with all grouped nodes
						if ( node instanceof FeatureGroup ) {
							if ( hyperedge == null ) {
								hyperedge = new Hyperedge();
								hyperGraph.addHyperEdge(hyperedge);
							}
						}
						else {
							hyperedge = new Hyperedge();
							hyperGraph.addHyperEdge(hyperedge);
						}
						hyperedge.addVertex(vertex);
					}
				}
				
				// merge hypergraph edges based on 'clusterClause'
				if ( clusterClause.countVariables() > 1 ) {
					Hypergraph clauseHyperGraph = new ClusterHypergraph();
					Hyperedge  clauseHyperEdge = new Hyperedge();
					for( CNFLiteral literal : clusterClause.getLiterals() ) {
						Vertex vertex= hyperGraph.getVertexByName(literal.getVariable().getID());
						clauseHyperGraph.addVertex(vertex);
						clauseHyperEdge.addVertex(vertex);
					}
					
					List<CNFClause> ECClauses = (List<CNFClause>)clauseHyperEdge.getProperty("EC_clauses");
					List<CNFClause> clusterClauses = (List<CNFClause>)clauseHyperEdge.getProperty("cluster_clauses");
					if ( ECClauses == null ) {
						ECClauses = new ArrayList<CNFClause>();
						clauseHyperEdge.setProperty("EC_clauses", ECClauses);
					}
					if ( clusterClauses  == null ) {
						clusterClauses  = new ArrayList<CNFClause>();
						clauseHyperEdge.setProperty("cluster_clauses", clusterClauses);
					}					
					ECClauses.add( cnfClause );
					clusterClauses.add( clusterClause );					
					clauseHyperGraph.addHyperEdge(clauseHyperEdge);
					hyperGraph.merge(clauseHyperGraph);
				}
			}
		}	
		
		return nodesClusters;
		
	}
	
	public NodeCluster[] sortClusterAscendingOrder(FeatureTreeNode clusterNodeRoot) {		
		List<NodeCluster> nodeClusters = clusters.get(clusterNodeRoot);
		NodeCluster sortedClusters[] = null;
		if ( nodeClusters != null ) {
			sortedClusters = nodeClusters.toArray(new NodeCluster[0]);
			Comparator<NodeCluster> c = new Comparator<NodeCluster>() {
				public int compare(NodeCluster cluster1, NodeCluster cluster2) {
					int size1 = cluster1.size();
					int size2 = cluster2.size();
					return ( size1 > size2 ? 1 : ((size1 < size2) ? -1 : 0) );
				}
			};
			java.util.Arrays.sort(sortedClusters, c);
		}
		return sortedClusters;
	}
		
	public NodeCluster[] sortClusterDescendingOrder(FeatureTreeNode clusterNodeRoot) {		
		List<NodeCluster> nodeClusters = clusters.get(clusterNodeRoot);
		NodeCluster sortedClusters[] = null;
		if ( nodeClusters != null ) {
			sortedClusters = nodeClusters.toArray(new NodeCluster[0]);
			Comparator<NodeCluster> c = new Comparator<NodeCluster>() {
				public int compare(NodeCluster cluster1, NodeCluster cluster2) {
					int size1 = cluster1.size();
					int size2 = cluster2.size();
					return ( size1 > size2 ? -1 : ((size1 < size2) ? 1 : 0) );
				}
			};
			java.util.Arrays.sort(sortedClusters, c);
		}
		return sortedClusters;
	}
		
	protected FeatureTreeNode createClusterClause(CNFClause clause, CNFClause returnClause) {
		// for each variable in "clause" creates a list with its ancestors
		List<List<FeatureTreeNode>> ancestorsList = new Vector<List<FeatureTreeNode>>();
		for( BooleanVariableInterface var : clause.getVariables() ) {
			List<FeatureTreeNode> ancestors = new ArrayList<FeatureTreeNode>();
			FeatureTreeNode node = featureModel.getNodeByID(var.getID());
			if ( node != null ) {
				ancestors.add(0,node);
				FeatureTreeNode ancestorNode = (FeatureTreeNode)node.getParent();
//					ancestorNode = ( ancestorNode instanceof FeatureGroup )? (FeatureTreeNode)ancestorNode.getParent() : ancestorNode;
				while( ancestorNode != null ) {
					ancestors.add(0,ancestorNode);
					ancestorNode = (FeatureTreeNode)ancestorNode.getParent();
//						ancestorNode = ( ancestorNode instanceof FeatureGroup )? (FeatureTreeNode)ancestorNode.getParent() : ancestorNode;
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
	
	public void createClustersForAllNodes(Map<FeatureTreeNode,Hypergraph> clustersHypergraphs) {

		clusters.clear();
				
		// first, all nodes in the EC
		Set<FeatureTreeNode> nodesWithClusters = clustersHypergraphs.keySet();
		for( FeatureTreeNode node : nodesWithClusters ) {
			Hypergraph h = clustersHypergraphs.get(node);
			List<NodeCluster> nodeClusters = new ArrayList<NodeCluster>();
			// create clusters, one for each hyperedge
			for( Hyperedge hyperedge : h.getHyperedges() ) {
				NodeCluster cluster = new NodeCluster(featureModel, node);
				for( Vertex vertex : hyperedge.getVertices() ) {
					cluster.addNode(featureModel.getNodeByID(vertex.getName()));
				}
				cluster.addECClauses((List<CNFClause>)hyperedge.getProperty("EC_clauses"));
				cluster.addClusterClauses((List<CNFClause>)hyperedge.getProperty("cluster_clauses"));
				nodeClusters.add(cluster);
			}
			clusters.put(node,nodeClusters);
		}
		
		// second, all remaining nodes (not in EC)
		for( FeatureTreeNode node : featureModel.getNodes() ) {
			if ( !nodesWithClusters.contains(node) ) {
				List<NodeCluster> nodeClusters = new ArrayList<NodeCluster>();
				if ( node instanceof FeatureGroup ) {
					NodeCluster cluster = new NodeCluster(featureModel, node);
					for( int i = 0 ; i < node.getChildCount() ; i++ ) {
						FeatureTreeNode groupedNode = (FeatureTreeNode)node.getChildAt(i);
						cluster.addNode(groupedNode);
					}
					nodeClusters.add(cluster);
				}
				else {
					for( int i = 0 ; i < node.getChildCount() ; i++ ) {
						FeatureTreeNode childNode = (FeatureTreeNode)node.getChildAt(i);
						NodeCluster cluster = new NodeCluster(featureModel, node);
						cluster.addNode(childNode);
						nodeClusters.add(cluster);
					}
				}
				clusters.put(node,nodeClusters);
			}
		}
	}
	
	public void dump() {
		for( FeatureTreeNode node : clusters.keySet() ) {
			List<NodeCluster> nodeClusters = clusters.get(node);
			for( NodeCluster cluster : nodeClusters ) {
				cluster.dump();
			}
		}
	}
}

class ClusterHypergraph extends Hypergraph {
	public Hyperedge mergeHyperedges(Collection<Hyperedge> hyperEdgesSet ) {
		Collection<Hyperedge> oldHyperEdges = hyperEdgesSet;
		Hyperedge mergedHyperedge = super.mergeHyperedges(hyperEdgesSet);
		
		List<CNFClause> mergedECClauses = null; 
		List<CNFClause> mergedClusterClauses = null;
		
		for( Hyperedge hyperedge : hyperEdgesSet ) {
			List<CNFClause> ECClauses = (List<CNFClause>)hyperedge.getProperty("EC_clauses");
			if ( ECClauses != null ) {
				if ( mergedECClauses == null ) {
					mergedECClauses = ECClauses;
				}
				else {
					mergedECClauses.addAll(ECClauses);
				}
			}
			List<CNFClause> clusterClauses = (List<CNFClause>)hyperedge.getProperty("cluster_clauses");
			if ( clusterClauses != null ) {
				if ( mergedClusterClauses == null ) {
					mergedClusterClauses = clusterClauses;
				}
				else {
					mergedClusterClauses.addAll(clusterClauses);
				}
			}
		}
		
		mergedHyperedge.setProperty("EC_clauses", mergedECClauses);
		mergedHyperedge.setProperty("cluster_clauses", mergedClusterClauses);
		
		return mergedHyperedge;
	}		
}

