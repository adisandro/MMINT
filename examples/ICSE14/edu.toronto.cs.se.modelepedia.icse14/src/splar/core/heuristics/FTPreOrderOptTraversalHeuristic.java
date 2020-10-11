package splar.core.heuristics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;


public class FTPreOrderOptTraversalHeuristic extends FTPreOrderTraversalHeuristic {

	public FTPreOrderOptTraversalHeuristic(String name, FeatureModel featureModel) {
		super(name, featureModel);
	}
	
	protected FeatureTreeNode[] orderChildNodes(FeatureTreeNode node) {

		featureModel.resetNodesAttachedData();
		
		// sort nodes in non-descending order 
		Comparator<FeatureTreeNode> c = new Comparator<FeatureTreeNode>() {
			public int compare(FeatureTreeNode node1, FeatureTreeNode node2) {

				Integer countNodes1 = (Integer)node1.getAttachedData();
				Integer countNodes2 = (Integer)node2.getAttachedData();
				
				if ( countNodes1 == null ) {
					countNodes1 = new Integer(featureModel.countNodes(node1));
					node1.attachData(countNodes1);
				}
				
				if ( countNodes2 == null ) {
					countNodes2 = new Integer(featureModel.countNodes(node2));
					node2.attachData(countNodes2);
				}
				
				if ( countNodes1 > countNodes2 ) {
					return 1;
				}
				if ( countNodes1 < countNodes2 ) {
					return -1;
				}
				return 0;
			}
		};
		
		int count = node.getChildCount();
		FeatureTreeNode nodes[] = new FeatureTreeNode[count];
		for( int i = 0 ; i < count ; i++ ) {
			nodes[i] = ((FeatureTreeNode)node.getChildAt(i));									
		}
		
		java.util.Arrays.sort(nodes, c);
		
		return nodes;
	}
}
