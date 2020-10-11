package splar.core.heuristics;

import java.util.List;
import java.util.Set;
import java.util.Stack;

import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;


public class FTPreOrderTraversalHeuristic extends FTTraversalHeuristic {

	public FTPreOrderTraversalHeuristic(String name, FeatureModel featureModel) {
		super(name, featureModel);
	}
	
	public String[] runHeuristic(CNFFormula cnf) {		
		String varOrder[] = new String[cnf.getVariables().size()];		
		Set<BooleanVariableInterface> cnfVariables = cnf.getVariables();
		Stack<FeatureTreeNode> nodes = new Stack<FeatureTreeNode>();
		nodes.push(getFeatureModel().getRoot());
		int curIndex = 0;		
		while ( nodes.size() > 0 ) {
			FeatureTreeNode curNode = nodes.pop();
			if ( curNode != null ) {		
				if ( !(curNode instanceof FeatureGroup) ) {
					if ( cnfVariables.contains(curNode) ) {
						varOrder[curIndex++] = curNode.getID();						
					}
				}
				FeatureTreeNode childNodes[] = orderChildNodes(curNode);
				for( int i = childNodes.length-1 ; i >= 0 ; i-- ) {
					nodes.push(childNodes[i]);						
				}
			}
		}
		return varOrder;
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
