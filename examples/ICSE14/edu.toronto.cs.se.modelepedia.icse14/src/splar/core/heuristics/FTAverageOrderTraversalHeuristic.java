package splar.core.heuristics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;


public class FTAverageOrderTraversalHeuristic extends FTTraversalHeuristic {

	public FTAverageOrderTraversalHeuristic(String name, FeatureModel featureModel) {
		super(name, featureModel);
	}
	
	protected String[] runHeuristic(CNFFormula cnf) {
		
//		runPreProcessing(cnf);
		
		List<String> variableOrder = recursiveRun(featureModel.getRoot());
		
		// remove feature groups
		for( Iterator<String> it = variableOrder.iterator() ; it.hasNext() ; ) {
			String nodeID = it.next();
			if ( nodeID.startsWith("*") ) {
				it.remove();
			}
		}
		
//		runPostProcessing(cnf);
		
		return variableOrder.toArray(new String[0]);
	}	
	
	protected List<String> recursiveRun(FeatureTreeNode node) {
		
		int childCount = node.getChildCount();
		
		List<String> nodeList = new ArrayList<String>();

		if ( childCount == 0 ) {
			nodeList.add(node.getID());
			return nodeList;
		}
		
		// for each child node recursively call recursiveRun
		Map<String,List<String>> nodeChildrenMap = new LinkedHashMap<String,List<String>>();
		for( int i = 0 ; i < node.getChildCount() ; i++ ) {
			FeatureTreeNode childNode = (FeatureTreeNode)node.getChildAt(i);
//			if ( childNode instanceof FeatureGroup ) {
//				for( int j = 0 ; j < childNode.getChildCount() ; j++ ) {
//					FeatureTreeNode groupedNode = (FeatureTreeNode)childNode.getChildAt(j);
//					List<String> childList = recursiveRun(groupedNode);
//					// add each child node list to the map
//					nodeChildrenMap.put(groupedNode.getID(), childList);
//				}				
//			}
//			else {
				List<String> childList = recursiveRun(childNode);
				// add each child node list to the map
				String nodeID = childNode.getID();
				if ( childNode instanceof FeatureGroup ) {
					nodeID = "*" + nodeID;
				}
				nodeChildrenMap.put(nodeID, childList);
//			}
		}
		
		childCount = nodeChildrenMap.size();
		
		// if node has two or less children add their children list to the node list
		if ( childCount <= 2 ) {
			for( List<String> childNodeList : nodeChildrenMap.values() ) {
				nodeList.addAll(childNodeList);
			}
		}
		// if node has more than two children add child nodes to node list according to their (children) weight
		else {
		
			// order child nodes based on their weights
			List<String> childNodesBalancedList = balanceWeights(nodeChildrenMap);
	
			// merge child node lists into one (nodeList) according to their weights order
			for( String childNodeName : childNodesBalancedList ) {
				nodeList.addAll(nodeChildrenMap.get(childNodeName));
			}			
		}

		// IF NOT FEATURE GROUP...
		// insert 'node' into the child nodes list 
		// the position of 'node' is the average of the sum of child nodes positions
		int childNodePosSum = 0;
		for( String childNodeName : nodeChildrenMap.keySet() ) {
			childNodePosSum += nodeList.indexOf(childNodeName);
		}
		
		int nodePos = Math.round(childNodePosSum/(1.0f*childCount));
		String nodeID = node.getID();
		if ( node instanceof FeatureGroup ) {
			nodeID = "*" + nodeID;
		}
		nodeList.add(nodePos,nodeID);
		
		return nodeList;
	}
	
	public List<String> balanceWeights(Map<String,List<String>> weightsMap) {
		
		Set<Entry<String,List<String>>> weights = weightsMap.entrySet();
		
		// sort entries in non-descending order according to their weights
		Comparator<Object> c = new Comparator<Object>() {
			public int compare(Object entry1, Object entry2) {
				
				Entry<String,List<String>> nEntry1 = (Entry<String,List<String>>)entry1;  
				Entry<String,List<String>> nEntry2 = (Entry<String,List<String>>)entry2;  
				
				if ( nEntry1.getValue().size() > nEntry2.getValue().size() ) {
					return 1;
				}
				if ( nEntry1.getValue().size() < nEntry2.getValue().size() ) {
					return -1;
				}
				return 0;
			}
		};
		
		Object entries[] = weights.toArray();		
		java.util.Arrays.sort(entries,c);

		// split the the entries in two groups of balanced weights		
		List<String> leftList = new ArrayList<String>();
		List<String> rightList = new ArrayList<String>();
		
		List<Entry<String,List<String>>> entriesList = new ArrayList<Entry<String,List<String>>>();		
		for( Object entry : entries ) {
			entriesList.add((Entry<String,List<String>>)entry);
		}

		int sumLeft = 0;
		int sumRight = 0;
		while( entriesList.size() > 0 ) {
			// get maximum weight from list and add to right list
			Entry<String,List<String>> maxEntry = entriesList.get(entriesList.size()-1);
			entriesList.remove(entriesList.size()-1);
			rightList.add(maxEntry.getKey());
			
			sumRight += maxEntry.getValue().size();
			
			// search a combination of values that approximates the max weight
			int curWeight = 0;
			int index = entriesList.size()-1;
			while( entriesList.size() > 0 && curWeight < maxEntry.getValue().size() ) {
				Entry<String,List<String>> curEntry = entriesList.get(index);
				curWeight += curEntry.getValue().size();
				sumLeft += curEntry.getValue().size();
				entriesList.remove(index);
				leftList.add(curEntry.getKey());
				index--;
			}			
		}

//		System.out.print("\nLEFT: (" + sumLeft +") - ");
//		for( String key : leftList ) {
//			System.out.print(key + ",");
//		}
//		
//		System.out.print("\nRIGHT: (" + sumRight +") - ");
//		for( String key : rightList ) {
//			System.out.print(key + ",");
//		}
		
		leftList.addAll(rightList);
		
		return leftList;
	}	
}
