package splar.core.fm;

import java.util.LinkedList;
import java.util.List;

public class FTTraversals {

	public static List<FeatureTreeNode> dfs(FeatureTreeNode node, FTTraversalNodeSelector selector) {
		List<FeatureTreeNode> nodes = new LinkedList<FeatureTreeNode>();
		dfs(node, nodes, selector);
		return nodes;
	}

	public static List<FeatureTreeNode> bfs(FeatureTreeNode node, FTTraversalNodeSelector selector) {
		List<FeatureTreeNode> nodes = new LinkedList<FeatureTreeNode>();
		bfs(node, nodes, selector);
		return nodes;
	}

	private static void dfs( FeatureTreeNode node, List<FeatureTreeNode> nodes, FTTraversalNodeSelector selector) {
		if ( node != null ) {
			if ( selector != null ) {
				if ( selector.select(node)) {
					nodes.add(node);
				}
			}
		}
		int count = node.getChildCount();
		for( int i = 0 ; i < count ; i++ ) {
			dfs((FeatureTreeNode)node.getChildAt(i), nodes, selector);
		}
	}	
	
	private static void bfs( FeatureTreeNode node, List<FeatureTreeNode> nodes, FTTraversalNodeSelector selector) {
		LinkedList<FeatureTreeNode> toProcess = new LinkedList<FeatureTreeNode>();
		if ( node != null ) {
			toProcess.add(node);
		}
		while( !toProcess.isEmpty() ) {
			FeatureTreeNode curNode = toProcess.pollFirst();
			if ( selector.select(curNode)) {
				nodes.add(curNode);
			}
			int count = curNode.getChildCount();
			for( int i = 0 ; i < count ; i++ ) {
				toProcess.add((FeatureTreeNode)curNode.getChildAt(i));
			}
		}
	}		
}
