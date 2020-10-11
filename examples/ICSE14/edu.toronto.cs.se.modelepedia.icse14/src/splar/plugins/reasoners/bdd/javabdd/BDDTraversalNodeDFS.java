
package splar.plugins.reasoners.bdd.javabdd;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import net.sf.javabdd.BDD;

/*
 * Each BDD node is visited ONCE in Depth-First Search
 * 
 */
public class BDDTraversalNodeDFS extends BDDTraversal {
			
	// store low node IDs as keys in a tree of high node IDs
	protected Set<Integer> visitedNodes = null;
	
	public BDDTraversalNodeDFS() {
		super();
		visitedNodes = new TreeSet<Integer>();
	}
	
	public void dfs(BDD bdd) {		
		super.dfs(bdd);
		visitedNodes.clear();
	}
	
	public boolean searchStopped() {
		return super.searchStopped();
	}

	public boolean canVisitNode(BDD bddNode, boolean polarity) {
		
		BDD nextNode = polarity ? bddNode.high() : bddNode.low();
		
		if ( nextNode.isZero() || nextNode.isOne() ) {
			return true;
		}
				
		if ( !visitedNodes.contains(nextNode.hashCode()) ) {
			visitedNodes.add(nextNode.hashCode());
			return true;
		}
		
		return false; 
	}
	
	public boolean visitLowNodeFirst(BDD bddNode) {
		return 	true;
	}
	
	public void onZeroTerminalFound(Set<String> path, byte solution[]) {
		super.onZeroTerminalFound(path, solution);
	}

	public void onOneTerminalFound(Set<String> path, byte[] solution) {
		super.onOneTerminalFound(path, solution);
	}
	
}

//public boolean canVisitNode(BDD bddNode, boolean polarity) {
//	
//	BDD nextNode = polarity ? bddNode.high() : bddNode.low();
//	
//	if ( nextNode.isZero() || nextNode.isOne() ) {
//		return true;
//	}
//
////	System.out.println("can visit: " + nextNode.var());
//
//	boolean canVisit = false;
//	
//	BDD lowBDD = nextNode.low();
//	BDD highBDD = nextNode.high();
//	
//	int nodeVar = nextNode.var();
//	int nodeLowVar = (lowBDD.isZero() ? 0 : lowBDD.isOne() ? 1 : lowBDD.var());
//	int nodeHighVar = (highBDD.isZero() ? 0 : highBDD.isOne() ? 1 : highBDD.var());
//	
//	lowBDD.free();
//	highBDD.free();
//	
//	Map<Integer,Map<Integer,Object>> lowTree = variables[nodeVar];
//	
//	if ( lowTree == null ) {
//		lowTree = new TreeMap<Integer,Map<Integer,Object>>();
//		variables[nodeVar] = lowTree;
//	}
//	
//	Map<Integer,Object> highTree = lowTree.get(nodeLowVar);
//	if ( highTree == null ) {
//		highTree = new TreeMap<Integer, Object>();
////		highTree.put(nodeHighVar, null);
//		lowTree.put(nodeLowVar, highTree);
//	}		
//
//	if ( !highTree.containsKey(nodeHighVar) ) {
//		canVisit = true;
//		highTree.put(nodeHighVar, null);
//	}
//			
//	return canVisit; 
//}
