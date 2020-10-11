package splar.core.fm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import splar.core.constraints.Assignment;
import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFLiteral;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.clustering.FTCluster;



public abstract class FeatureModel extends DefaultTreeModel implements FeatureModelListener {

	private String name = "";
	private Map<String,String> metadata;
    private FeatureTreeNode root = null;	        
    protected Map<String,FeatureTreeNode> nodesMap = new LinkedHashMap<String,FeatureTreeNode>();
    private Map<String,PropositionalFormula> constraints = null;
    protected List<FeatureTreeNode> lastPropagatedNodes = null;
    private int countNodes = 0;
    private List<FeatureModelListener> listeners;
    
    private HashMap<String,FeatureModelState> states;
//	protected HashMap<FeatureTreeNode,Long> instantiatedNodes = null;
	
	public FeatureModel() {
		super(null, true);
		metadata = new LinkedHashMap<String, String>();
		constraints = new LinkedHashMap<String,PropositionalFormula>();
		states = new HashMap<String,FeatureModelState>();
		lastPropagatedNodes = new Vector<FeatureTreeNode>();
		listeners = new ArrayList<FeatureModelListener>();
	} 

	public void addMetaData(String name, String value) {
		metadata.put(name, value);
	}
	
	public String getMetaData(String name) {
		String value = metadata.get(name);
		return value==null ? "" : value;
	}
	
	public Set<String> getMetaDataKeys() {
		return metadata.keySet();
	}
	
	// event handler for feature model "on instantiating feature" events
	public void onInstantiatingFeature(FeatureTreeNode node, boolean value) {
	}
	
	public void resetInstantiatedNodesCounter() {
	}
	
	public Set<FeatureTreeNode> getUninstantiatedNodes() {
		Set<FeatureTreeNode> nodes = new HashSet<FeatureTreeNode>();
		for( FeatureTreeNode node : getNodes() ) {
			if (!(node instanceof FeatureGroup)) {
				if ( !node.isInstantiated() ) {
					nodes.add(node);
				}
			}
		}
		return nodes;
	}
	
	public Set<FeatureTreeNode> getInstantiatedNodes() {
		Set<FeatureTreeNode> nodes = new HashSet<FeatureTreeNode>();
		for( FeatureTreeNode node : getNodes() ) {
			if (!(node instanceof FeatureGroup)) {
				if ( node.isInstantiated() ) {
					nodes.add(node);
				}
			}
		}
		return nodes;
	}
		
	public void addListener(FeatureModelListener listener) {
		listeners.add(listener);
	}
	
	private void dispatchOnInstantiatingFeatureEvent(FeatureTreeNode node, boolean value) {
		for( FeatureModelListener listener : listeners ) {
			listener.onInstantiatingFeature(node, value);
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	private FeatureTreeNode subTreeRootNode= null;
	public FeatureModel getFeatureModelSubTree(FeatureTreeNode node) {
		subTreeRootNode = node;
		return new FeatureModel() {
			protected FeatureTreeNode createNodes() throws FeatureModelException {
		    	return new SolitaireFeature(true, subTreeRootNode.getID(), subTreeRootNode.getName(), null);
		    }
		    
			protected void saveNodes() {				
			}
			
		};
	}
	
	// safely remove all mandatory features from feature model
	public void shrink() {
		shrink(getRoot(),getRoot());
	}
	
	// safely remove all mandatory features from feature model from the subtree rooted by node
	public void shrink(FeatureTreeNode node, FeatureTreeNode startNode) {
		int countChild = node.getChildCount();
		FeatureTreeNode childNodes[] = new FeatureTreeNode[countChild];
		for( int i = 0 ; i < countChild ; i++ ) {
			childNodes[countChild-i-1] = (FeatureTreeNode)node.getChildAt(i);			
		}
		if ( isMandatory(node) ) {
			FeatureTreeNode parent = (FeatureTreeNode )node.getParent();
			
			// remove node from parent
			parent.remove(node);
			
			// point parent to node children
			for( FeatureTreeNode childNode : childNodes ) {
				parent.add(childNode);			
			}
			 
			// update constraints: use parent's ID instead
			for( PropositionalFormula formula : getConstraints() ) {
				formula.replaceVariable(node.getID(), parent.getID());
			}
			nodesMap.remove(node.getID());
		}
		// recursive call
		for( FeatureTreeNode childNode : childNodes ) {
			shrink(childNode, startNode);			
		}
		
		if ( node == startNode ) {
			countNodes(startNode);
			lastPropagatedNodes = new Vector<FeatureTreeNode>();
			states.clear();
		}
	}
	
	public List<FeatureTreeNode> getNodesAtLevel(int level) {
		int curLevel = 0;
		FeatureTreeNode rootNode = getRoot();
		ArrayList<FeatureTreeNode> nodes = new ArrayList<FeatureTreeNode>();
		nodes.add(rootNode);
		int levelCounter = 1;
		int nextLevelCounter = 0;
		while ( nodes.size() > 0 && curLevel < level) {
			FeatureTreeNode curNode = nodes.get(0);
			if ( curLevel < level ) {
				nodes.remove(0);
				int count = curNode.getChildCount();
				for( int i = 0 ; i < count ; i++ ) {
					FeatureTreeNode childNode = (FeatureTreeNode)curNode.getChildAt(i);
//					if ( !(childNode instanceof FeatureGroup) ) {
						childNode.attachData(new Integer(curLevel+1));
						nodes.add(childNode);
//					}
					nextLevelCounter++;
				}
			}
			if ( --levelCounter == 0 ) {
				levelCounter = nextLevelCounter; 
				nextLevelCounter = 0;
				curLevel++;
			}
		}
		return nodes;
	}

	public void getSubtreeNodes(FeatureTreeNode subtreeRootNode, List<FeatureTreeNode> nodes) {
		if ( subtreeRootNode != null ) {
			int count = subtreeRootNode.getChildCount();
			for( int i = 0 ; i < count ; i++ ) {
				FeatureTreeNode childNode = (FeatureTreeNode)subtreeRootNode.getChildAt(i);
				if ( !(childNode instanceof FeatureGroup ) ) {
					nodes.add(childNode);
				}
				getSubtreeNodes(childNode, nodes);
			}
		}
	}
	
	
	public int getNodeLevel(String nodeID) {
		FeatureTreeNode node = getNodeByID(nodeID);
		if ( node != null ) {
			int level = 0;
			TreeNode parent = node;
			do {
				parent = parent.getParent();
//				parent = (parent instanceof FeatureGroup) ? parent.getParent() : parent;
				if ( parent != null ) {
					level++;
				}
			} while( parent != null);
			return level;
		}
		return -1;
	}
	
	public void resetNodesAttachedData() {
		Collection<FeatureTreeNode> allNodes = new Vector<FeatureTreeNode>();
		getAllNodes(getRoot(), allNodes);
		for( FeatureTreeNode node : allNodes ) {
			node.resetAttachedData();
		}		
	}	
	
	public Assignment getInstantiatedVariables() {
		Assignment a = new Assignment();
		for( Iterator<FeatureTreeNode> it = getNodes().iterator() ; it.hasNext() ; ) {
			FeatureTreeNode node = it.next();
			if ( node.isInstantiated() ) {
				if ( !(node instanceof FeatureGroup) ) {
					a.add(node);
				}
			}
		}				
		return a;
	}	
	
	public PropositionalFormula getConstraintsAsPropositionalFormula() {
		StringBuffer combinedFormulas = new StringBuffer(100);
		for( Iterator<PropositionalFormula> it = constraints.values().iterator() ; it.hasNext(); ) {
			combinedFormulas.append("("+it.next().getFormula()+")");
			if ( it.hasNext()) {
				combinedFormulas.append(" AND ");
			}				
		}
		PropositionalFormula pf = null;
		try {
			pf = new PropositionalFormula("", combinedFormulas.toString());
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return pf;
	}
	
	public void saveState(String stateID) {
		FeatureModelState state = new FeatureModelState(stateID, this);
		state.save();
		states.put(stateID, state);
	}
	
	public void restoreState(String stateID) {
		restoreState(stateID, true);
	}
	
	public void restoreState(String stateID, boolean discardState) {		
		FeatureModelState state = states.get(stateID);
		if ( state != null ) {
			state.restore();
			if ( discardState) {
				discardState(stateID);
			}
		}
	}
	
	public void discardState(String stateID) {
		FeatureModelState state = states.get(stateID);
		state.discard();
		states.remove(stateID);
	}

	public boolean isExtraConstraintVariable(FeatureTreeNode node) {
		return getConstraintsVariablesSet().contains(node);
	}
	
	/*public boolean isInstantiated() {
		return (instantiatedNodesList.size() != 0); 
	}*/
	
	public void setValue(String featureID, int value) throws FeatureValueAssignmentException {
		assignValue(nodesMap.get(featureID), value);
	}
	
	public void assignValue(FeatureTreeNode node, int value) throws FeatureValueAssignmentException {
		if ( node != null ) {
			if ( !node.isImmutable() ) {
				if ( value == FeatureTreeNode.UNKNOWN || node.getValue() == FeatureTreeNode.UNKNOWN ) {
					node.assignValue(value);
					if (value != FeatureTreeNode.UNKNOWN ) { 
						dispatchOnInstantiatingFeatureEvent(node, (value==0 ? false : true));
					}
				}
				else if ( node.getValue() != value ) {
					String nodeName = node.getName();
					if ( node instanceof FeatureGroup ) {
						nodeName = "Feature group of node " + ((FeatureTreeNode)node.getParent()).getName();
					}
					throw new FeatureValueAssignmentException("FT assignment conflict: " + nodeName + "(current="+node.getValue()+","+"new="+value+")");
				}
			}
			else {
				if ( node.getValue() != value ) {
					String nodeName = node.getName();
					if ( node instanceof FeatureGroup ) {
						nodeName = "Feature group of node " + ((FeatureTreeNode)node.getParent()).getName();
					}
					throw new FeatureValueAssignmentException("FT assignment conflict: " + nodeName + " is IMMUTABLE (current="+node.getValue()+","+"new="+value+")");				
				}
			}
		}
	}
	
	public void assignValue(FeatureTreeNode node, int value, BooleanVariableInterface propagationVar) throws FeatureValueAssignmentException { 
		if ( node != null ) {
			if ( !node.isImmutable() ) {
				node.assignValue(value, propagationVar);
				if (value != FeatureTreeNode.UNKNOWN ) { 
					dispatchOnInstantiatingFeatureEvent(node, (value==0 ? false : true));
				}
			}
		}
	}

	public int getValue(String featureID) {
		FeatureTreeNode node = nodesMap.get(featureID);
		if ( node != null ) {
			return node.getValue();
		}
		return -2;
	}
/*
	public void resetValues() {
		for( Iterator<FeatureTreeNode> it =  instantiatedNodesList.iterator() ; it.hasNext() ; ) {
			FeatureTreeNode node = it.next();
			try {
				node.assignValue(FeatureTreeNode.UNKNOWN);
			}
			catch( Exception e ) {
				e.printStackTrace();
			}
			it.remove();
		}
	}
	*/
	
	public List<FeatureTreeNode> getLastPropagatedNodes() {
		return lastPropagatedNodes;
	}
		
	public static int countGroupedNodes(FeatureGroup featureGroupNode, int valueToCount, Collection<FeatureTreeNode> unassignedGroupedNodes ) {
		int countNodes = 0;				
		int groupedNodesCount = featureGroupNode.getChildCount();			
		for( int i = 0 ; i < groupedNodesCount ; i++ ) {
			FeatureTreeNode curGroupedNode = (FeatureTreeNode)featureGroupNode.getChildAt(i);
			int nodeValue = curGroupedNode.getValue();
			if ( nodeValue == valueToCount ) {
				countNodes++;
			}
			else if ( nodeValue == FeatureTreeNode.UNKNOWN ) {
				unassignedGroupedNodes.add(curGroupedNode);
			}
		}
		return countNodes;
	}

	public void loadModel() throws FeatureModelException {
		root = createNodes();
//		resetInstantiatedNodesCounter();
//		try {
//			propTrueDown(root,null,true);
//		}
//		catch( FeatureValueAssignmentException e ) {
//			e.printStackTrace();
//		}
		countNodes(root);
	}
	
	public void saveModel() {
		saveNodes();
	}
	
	public int countNodes() {
		countNodes = countNodes(getRoot());
		return countNodes;
	}
	
	// count features based on their instantiation state
	public int countFeatures(boolean instantiated) {
		int counter = 0;
		for( FeatureTreeNode node : getNodes() ) {
			if (!( node instanceof FeatureGroup )) {
				if ( node.isInstantiated() == instantiated ) {
					counter++;
				}
			}			
		}
		return counter;
	}	
	
	public int countFeatures() {
		int counter = 0;
		for( FeatureTreeNode node : getNodes() ) {
			if ( !(node instanceof FeatureGroup) ) {
				counter++;
			}
		}
		return counter;
	}
	
	public double getAverageDepth() {
		int sumDepths = 0;
		Collection<FeatureTreeNode> leaves = getLeaves();
		for( FeatureTreeNode node : leaves ) {
			if ( node.getChildCount() == 0 ) {
				sumDepths += depth(node);
			}
		}
		return (1.0*sumDepths)/leaves.size();
	}
	
	public double getDepthStandardDeviation() {
		double squareSum = 0;
		Collection<FeatureTreeNode> leaves = getLeaves();
		for( FeatureTreeNode node : leaves ) {
			if ( node.getChildCount() == 0 ) {
				int d = depth(node);
				squareSum += (d*d);
			}
		}
		double avgDepth = getAverageDepth();
		return Math.sqrt((squareSum/leaves.size())-(avgDepth*avgDepth));
	}
	
	// the closest to zero the better the balance of the tree branches
	public double getDepthDeviationCoeficient() {
		double squareSum = 0;
		Collection<FeatureTreeNode> leaves = getLeaves();
		for( FeatureTreeNode node : leaves ) {
			if ( node.getChildCount() == 0 ) {
				int d = depth(node);
				squareSum += (d*d);
			}
		}
		double avgDepth = getAverageDepth();
		return Math.sqrt(((squareSum/leaves.size())-(avgDepth*avgDepth)))/avgDepth;
	}
	
	// different from getNodeLevel(node) - here groups are not accounted while there they are
	public int depth(FeatureTreeNode node) {
		int depth = -1;		
		if ( node != null ) {
			depth = 0;
			FeatureTreeNode parent = node;
			parent = (FeatureTreeNode)parent.getParent();
			parent = (parent != null && parent instanceof FeatureGroup) ? (FeatureTreeNode)parent.getParent() : parent; 
			while ( parent != null ) {
				depth++;
				parent = (FeatureTreeNode)parent.getParent();
				parent = (parent != null && parent instanceof FeatureGroup) ? (FeatureTreeNode)parent.getParent() : parent; 
			}
		}		
		return depth;
	}
	
	public int getLevel(FeatureTreeNode node) {
		
		if (node == getRoot()) {
			return 0;
		}
		int level = 0;

		FeatureTreeNode parent = node;
		
		do {
			level++;
			parent = (FeatureTreeNode)(parent.getParent());
			parent = (FeatureTreeNode)((parent instanceof FeatureGroup) ? parent.getParent() : parent );
		}
		while( parent != getRoot() );
		
		return level;
	}
	
	public int depthFeatures() {
		return depth(getRoot(),0, false);
	}
	
	public int depth() {
		return depth(getRoot(),0, true);
	}
	
	private int depth(FeatureTreeNode node, int depth, boolean countGroups) {
		
		if ( node == null ) {
			return depth;
		}
		int count = node.getChildCount();
		
		if ( count == 0 ) 
			return depth;
		
		int maxDepth = depth;
		
		for( int i = 0 ; i < count ; i++ ) {
			int d = 0;
			if ( countGroups || (!countGroups && !(node instanceof FeatureGroup))) {
				d = depth((FeatureTreeNode)node.getChildAt(i), depth+1, countGroups);
			}
			else {
				d = depth((FeatureTreeNode)node.getChildAt(i), depth, countGroups);
			}
			maxDepth = Math.max(d, maxDepth);
		}
		return maxDepth;
	}
	
	public void removeAllConstraints() {
		constraints.clear();
	}
	
	public void addConstraint(PropositionalFormula constraint) {
		constraints.put(constraint.getName(),constraint);
	}
	
	public PropositionalFormula getConstraintByName(String name) {
		return constraints.get(name);
	}
	
	public Collection<PropositionalFormula> getConstraints() {
		return constraints.values();
	}
	
	public int countConstraints() {
		return constraints.size();
	}
	
	public int countConstraintsVariables() {
		return getConstraintsVariablesSet().size();
	}
	
	public Set<BooleanVariableInterface> getConstraintsVariablesSet() {
		Set<BooleanVariableInterface> variables = new LinkedHashSet<BooleanVariableInterface>();
		if ( constraints != null ) {
			for(Iterator<PropositionalFormula> it = constraints.values().iterator() ; it.hasNext() ; ) {
				PropositionalFormula c = it.next();
				for(Iterator<BooleanVariable> it2 = c.getVariables().iterator() ; it2.hasNext() ; ) {
					BooleanVariableInterface var = it2.next();
					variables.add(var);
				}
			}
		}
		return variables;
	}
		
	public Collection<FeatureTreeNode> getNodes() {
		return nodesMap.values();
	}

	public List<FeatureTreeNode> getNodes(FeatureTreeNode node) {
		List<FeatureTreeNode> nodeList = new ArrayList<FeatureTreeNode>();
		getNodes(nodeList,node);
		return nodeList;		
	}
	
	private void getNodes(List<FeatureTreeNode> nodeList, FeatureTreeNode node) {		
		if ( node != null ) {
			nodeList.add(node);
			int count = node.getChildCount();
			for( int i = 0 ; i < count; i++ ) {
				getNodes(nodeList, (FeatureTreeNode)node.getChildAt(i));
			}
		}
	}

	public int countNodes(FeatureTreeNode node) {
		countNodes = 0;
		if ( node != null ) {
			if ( !(node instanceof FeatureGroup) ) {
				countNodes++;
			}
			nodesMap.put(node.getID(), node);
			int count = node.getChildCount();
			for( int i = 0 ; i < count ; i++ ) {
				countNodes += countNodes((FeatureTreeNode)node.getChildAt(i));
			}
		}
		return countNodes;
	}

	public Collection<FeatureTreeNode> getLeaves() {
		Collection<FeatureTreeNode> leaves = new ArrayList<FeatureTreeNode>();
		for( FeatureTreeNode node : getNodes() ) {
			if ( node.getChildCount() == 0 ) {
				leaves.add(node);
			}
		}
		return leaves;
	}
	
		
	public FeatureTreeNode getNodeByID(String nodeName) {
		return nodesMap.get(nodeName);
	}
		
	public FeatureTreeNode getRoot() {
		return root;
	}
	
	public boolean isRoot(FeatureTreeNode node) {
		return node.equals(getRoot());
	}
	
	/* Descendants of a node - short name convenience method */
	public Collection<FeatureTreeNode> DES(FeatureTreeNode node) {
		return descendants(node);
	}

	/* Ancestors of a node - short name convenience method */
	public Collection<FeatureTreeNode> ANC(FeatureTreeNode node) {
		return ancestors(node);
	}
	
	/* Siblings of a grouped node - short name convenience method */
	public Collection<FeatureTreeNode> GSI(FeatureTreeNode node) {
		return groupSiblingNodes(node);
	}

	public boolean isMandatory( FeatureTreeNode node ) {
		if ( node != null ) {
			if ( (node instanceof SolitaireFeature) ) {
				SolitaireFeature auxNode = ((SolitaireFeature)node);
				return !auxNode.isOptional();
			}
		}
		return false;
	}	
	
	public boolean isOptional( FeatureTreeNode node ) {
		if ( node != null ) {
			if ( (node instanceof SolitaireFeature) ) {
				SolitaireFeature auxNode = ((SolitaireFeature)node);
				return auxNode.isOptional();
			}
		}
		return false;
	}
	
	/*
	 * A MandatoryTypeOfNode is one that when FALSIFIED has implications 
	 * on its ancestors 
	 */	
	public boolean isMandatoryTypeOfNode( FeatureTreeNode node ) {
		// Check if node is mandatory  
		try {
			boolean isMandatoryTypeOfNode = false;
			if ( node != null ) {
				if ( (node instanceof SolitaireFeature) ) {
					SolitaireFeature auxNode = ((SolitaireFeature)node);
					isMandatoryTypeOfNode = !auxNode.isOptional();
				}
				// or is a grouped node with min group cardinality > 0
				else if ( node instanceof GroupedFeature ){
					GroupedFeature auxNode = (GroupedFeature)node;
					isMandatoryTypeOfNode = (((FeatureGroup)auxNode.getParent()).getMin() > 0);
				}
			}
			return isMandatoryTypeOfNode;
		}
		catch( Exception e ) {
			System.out.println("A grouped feature's parent must be a FeatureGroup. Please check node '" + node + "' and its parent.");
		}
		return false;
	}

	private boolean isQualifiedNode( FeatureTreeNode node, FeatureTreeNode baseNode ) {
		// if  baseNode is a grouped node "node" must be different from all grouped sibling nodes 
/*		if ( baseNode instanceof GroupedFeature ) {
			FeatureGroup group =(FeatureGroup) baseNode.getParent();
			int childCount = group.getChildCount();			
			for( int i = 0 ; i < childCount ; i++ ) {
				FeatureTreeNode childNode = (FeatureTreeNode)group.getChildAt(i);
				if ( node == childNode ) {
					return false;
				}
			}					
		}	
*/
		return node != baseNode;
	}
	
	public Collection<FeatureTreeNode> descendants(Collection<FeatureTreeNode> nodes) {
		Collection<FeatureTreeNode> descendantNodes = new Vector<FeatureTreeNode>();
		if ( nodes != null ) {
			for( Iterator<FeatureTreeNode> it = nodes.iterator(); it.hasNext() ;) {
				Collection<FeatureTreeNode> result = descendants(it.next());
				if ( result != null ) {
					descendantNodes.addAll(result);
				}
			}
		}
		return descendantNodes;
	}

	/**
	 * Descendants of a given node 
	 * @param node node for which descendants are to be identified 
	 * @return list of the descendants of the node indicated
	 */
	public Collection<FeatureTreeNode> descendants(FeatureTreeNode node) {
		Collection<FeatureTreeNode> descNodes = new Vector<FeatureTreeNode>();
		descendants(node,descNodes);
		descNodes.remove(node);
		return descNodes;
	}
	
	/**
	 * Descendants of a given node 
	 * @param node node for which descendants are to be identified 
	 * @param list that stores the descendants of the node indicated
	 */
	private void descendants(FeatureTreeNode node, Collection<FeatureTreeNode> descNodes) {
		if ( node != null ) {
			if ( !(node instanceof FeatureGroup) ) {
				descNodes.add(node);
			}
			int count = node.getChildCount();
			if ( count > 0 ) {
				for( int i = 0 ; i < count ; i++ ) {
					FeatureTreeNode childNode = (FeatureTreeNode)node.getChildAt(i);
					descendants(childNode, descNodes);
				}
			}
		}
	}
	
	public Collection<FeatureTreeNode> ancestors(Collection<FeatureTreeNode> nodes) {
		Collection<FeatureTreeNode> ancestorNodes = new Vector<FeatureTreeNode>();
		if ( nodes != null ) {
			for( Iterator<FeatureTreeNode> it = nodes.iterator(); it.hasNext() ;) {
				Collection<FeatureTreeNode> result = ancestors(it.next());
				if ( result != null ) {
					ancestorNodes.addAll(result);
				}
			}
		}
		return ancestorNodes;
	}
	
	/**
	 * Ancestors of a given node 
	 * @param node node for which ancestors are to be identified 
	 * @return list of the ancestors of the node indicated
	 */
	public Collection<FeatureTreeNode> ancestors(FeatureTreeNode node) {
		Collection<FeatureTreeNode> ancNodes = new Vector<FeatureTreeNode>();
		ancestors(node,ancNodes);
		ancNodes.remove(node);
		return ancNodes;
	}
	
	/**
	 * Ancestors of a given node 
	 * @param node node for which ancestors are to be identified 
	 * @param list that stores the ancestors of the node indicated
	 */
	private void ancestors(FeatureTreeNode node, Collection<FeatureTreeNode> ancNodes) {
		if ( node != null ) {
			if ( node != getRoot() ) {
				if ( !(node instanceof FeatureGroup) ) {
					ancNodes.add(node);
				}
				FeatureTreeNode parent = (FeatureTreeNode)node.getParent();
				if ( parent != null ) {
					ancestors(parent, ancNodes);
				}
			}
		}
	}
	
	public Collection<FeatureTreeNode> groupSiblingNodes(Collection<FeatureTreeNode> nodes) {
		Collection<FeatureTreeNode> gsnNodes = new Vector<FeatureTreeNode>();
		if ( nodes != null ) {
			for( Iterator<FeatureTreeNode> it = nodes.iterator(); it.hasNext() ;) {
				Collection<FeatureTreeNode> result = groupSiblingNodes(it.next());
				if ( result != null ) {
					gsnNodes.addAll(result);
				}
			}
		}
		return gsnNodes;
	}

	/**
	 * Returns the siblings nodes of a grouped node  
	 * @param node the grouped node for which the siblings are to be identified 
	 * @return the siblings of the grouped node
	 */
	public Collection<FeatureTreeNode> groupSiblingNodes(FeatureTreeNode node) {
		Collection<FeatureTreeNode> gNodes = new Vector<FeatureTreeNode>();
		if ( node instanceof GroupedFeature ) {
			FeatureGroup parent = (FeatureGroup)node.getParent();
			for( int i = 0 ; i < parent.getChildCount() ; i++ ) {
				FeatureTreeNode chNode = (FeatureTreeNode)parent.getChildAt(i);
				if ( chNode != node ) {
					gNodes.add(chNode);
				}
			}
		}
		return gNodes;
		
	}
		
	public Iterator<FeatureTreeNode> nodesIterator() {
		Collection<FeatureTreeNode> allNodes = new Vector<FeatureTreeNode>();
		getAllNodes(getRoot(), allNodes);
		return allNodes.iterator();
	}
	
	private void getAllNodes(FeatureTreeNode node, Collection<FeatureTreeNode> allNodes) {
		if ( node != null ) {
			allNodes.add(node);
			int count = node.getChildCount();
			if ( count > 0 ) {
				for( int i = 0 ; i < count ; i++ ) {
					getAllNodes((FeatureTreeNode)node.getChildAt(i), allNodes);
				}
			}
		}
	}
	
	public CNFFormula EC2CNF() {
		if ( countConstraints() == 0 )
			return null;
		CNFFormula cnf = new CNFFormula();
		for( PropositionalFormula pf : getConstraints() ) {
			cnf.addClauses(pf.toCNFClauses());
		}
		return cnf;
	}

	public CNFFormula FT2CNF() {
		CNFFormula cnf = new CNFFormula();
		Vector<FeatureTreeNode> nodes = new Vector<FeatureTreeNode>();
		nodes.add(getRoot());
		CNFClause rootClause = new CNFClause();
		rootClause.addLiteral(new CNFLiteral(new BooleanVariable(getRoot().getID()),true));
		cnf.addClause(rootClause);
		while ( nodes.size() > 0 ) {
			FeatureTreeNode node = nodes.firstElement();
			nodes.remove(node);
			if ( node != null ) {		
				FeatureTreeNode parent = (FeatureTreeNode)node.getParent();
				if ( node instanceof FeatureGroup ) {
					parent = (FeatureTreeNode)node.getParent();
					int min = ((FeatureGroup)node).getMin(); 
					int max = ((FeatureGroup)node).getMax();					
					int childCount = node.getChildCount();
					CNFClause clause1 = new CNFClause();
					FeatureTreeNode groupedNodes[] = new FeatureTreeNode[childCount];
					clause1.addLiteral(new CNFLiteral(new BooleanVariable(parent.getID()),false));
					for( int i = 0 ; i < childCount ; i++ ) {
						FeatureTreeNode groupedNode = (FeatureTreeNode)node.getChildAt(i);
						groupedNodes[i] = groupedNode;
						clause1.addLiteral(new CNFLiteral(new BooleanVariable(groupedNode.getID()),true));
						CNFClause clause2 = new CNFClause();
						clause2.addLiteral(new CNFLiteral(new BooleanVariable(groupedNode.getID()),false));
						clause2.addLiteral(new CNFLiteral(new BooleanVariable(parent.getID()),true));
						cnf.addClause(clause2);
					}
					cnf.addClause(clause1);

					// if it is a [1,1] group, add additional clauses
					if ( min == 1 && max == 1 ) {
						addExclusiveOrGroupClauses(cnf, groupedNodes, null, 0, 0, 2);
					}
					
					// add grouped nodes' child nodes to the recursion list
					for( int i = 0 ; i < node.getChildCount(); i++ ) {
						FeatureTreeNode groupedNode = (FeatureTreeNode)node.getChildAt(i);
						for( int j = 0 ; j < groupedNode.getChildCount() ; j++ ) {
							nodes.add((FeatureTreeNode)groupedNode.getChildAt(j));						
						}
					}
				}				
				else {
					if ( parent != null ) {
						// if the node and its parent are not assigned, create the CNF clause to represent them
						CNFClause clause = new CNFClause();					
						clause.addLiteral(new CNFLiteral(new BooleanVariable(node.getID()),false));
						clause.addLiteral(new CNFLiteral(new BooleanVariable(parent.getID()),true));
						cnf.addClause(clause);
						if ( !((SolitaireFeature)node).isOptional() ) {
							clause = new CNFClause();					
							clause.addLiteral(new CNFLiteral(new BooleanVariable(parent.getID()),false));
							clause.addLiteral(new CNFLiteral(new BooleanVariable(node.getID()),true));
							cnf.addClause(clause);
						}
					}
					// add child nodes to the recursion list
					for( int i = 0 ; i < node.getChildCount(); i++ ) {
						nodes.add((FeatureTreeNode)node.getChildAt(i));						
					}
				}
			}
		}
		return cnf;
	}

	public CNFFormula FT2CNFSkipAssignedVariables() {
		CNFFormula cnf = new CNFFormula();
		Vector<FeatureTreeNode> nodes = new Vector<FeatureTreeNode>();
		nodes.add(getRoot());
		while ( nodes.size() > 0 ) {
			FeatureTreeNode node = nodes.firstElement();
			nodes.remove(node);
			if ( node != null ) {		
				FeatureTreeNode parent = (FeatureTreeNode)node.getParent();
				if ( node instanceof FeatureGroup ) {
					parent = (FeatureTreeNode)node.getParent();
					int min = ((FeatureGroup)node).getMin(); 
					int max = ((FeatureGroup)node).getMax();					
					Vector<FeatureTreeNode> unassignedGroupedNodes = new Vector<FeatureTreeNode>();
					// count unassigned grouped nodes
					for( int i = 0 ; i < node.getChildCount(); i++ ) {
						FeatureTreeNode groupedNode = (FeatureTreeNode)node.getChildAt(i);
						if ( !groupedNode.isInstantiated() ) {
							unassignedGroupedNodes.add(groupedNode);
						}
					}
					// at least one grouped node is unassigned
					if ( unassignedGroupedNodes.size() > 0 ) {
						CNFClause clause1 = new CNFClause();
						if ( !parent.isInstantiated() ) {
							clause1.addLiteral(new CNFLiteral(new BooleanVariable(parent.getID()),false));
						}
						for( Iterator<FeatureTreeNode> it = unassignedGroupedNodes.iterator() ; it.hasNext() ; ) {
							FeatureTreeNode groupedNode = (FeatureTreeNode)it.next();
							clause1.addLiteral(new CNFLiteral(new BooleanVariable(groupedNode.getID()),true));
							// if parent is true, no CNF clause needed to indicate (parent -> one of the children)
							// if parent is false, recursion never reaches this point
							// if parent is not instantiated, creates one clause for each grouped node
							if ( !parent.isInstantiated() ) {
								CNFClause clause2 = new CNFClause();
								clause2.addLiteral(new CNFLiteral(new BooleanVariable(groupedNode.getID()),false));
								clause2.addLiteral(new CNFLiteral(new BooleanVariable(parent.getID()),true));
								cnf.addClause(clause2);
							}
						}
						cnf.addClause(clause1);

						// if it is a [1,1] group, add additional clauses
						if ( min == 1 && max == 1 ) {
							addExclusiveOrGroupClauses(cnf, unassignedGroupedNodes.toArray(new FeatureTreeNode[0]), null, 0, 0, 2);
						}
					}
					
					// continue the recursion for SELECTED (true) or uninstantiated grouped nodes  
					for( int i = 0 ; i < node.getChildCount(); i++ ) {
						FeatureTreeNode groupedNode = (FeatureTreeNode)node.getChildAt(i);
						if ( groupedNode.getValue() == FeatureTreeNode.SELECTED || !groupedNode.isInstantiated() ) {
							for( int j = 0 ; j < groupedNode.getChildCount() ; j++ ) {
								nodes.add((FeatureTreeNode)groupedNode.getChildAt(j));						
							}
						}
					}
				}				
				else {
					// if node is solitaire feature
					if (node instanceof SolitaireFeature ) {
						// if the node and its parent are not assigned, create the CNF clause to represent them
						if ( !node.isInstantiated() && !parent.isInstantiated() ) {
							CNFClause clause = new CNFClause();					
							clause.addLiteral(new CNFLiteral(new BooleanVariable(node.getID()),false));
							clause.addLiteral(new CNFLiteral(new BooleanVariable(parent.getID()),true));
							cnf.addClause(clause);
							// if its mandatory, set the clause factor to two
							if ( !((SolitaireFeature)node).isOptional() ) {
								clause = new CNFClause();					
								clause.addLiteral(new CNFLiteral(new BooleanVariable(parent.getID()),false));
								clause.addLiteral(new CNFLiteral(new BooleanVariable(node.getID()),true));
								cnf.addClause(clause);
							}
						}
					}
					
					// if node is SOLITAIRE or ROOT NODE
					// stops the recursion if node is false since all sub-tree is false
					// otherwise, add child nodes to the recursion list
					if ( !node.isInstantiated() || node.getValue() == FeatureTreeNode.SELECTED ) {
						for( int i = 0 ; i < node.getChildCount(); i++ ) {
							nodes.add((FeatureTreeNode)node.getChildAt(i));						
						}
					}
				}
				// else if root node skip it				
			}
		}
		return cnf;
	}

	private void addExclusiveOrGroupClauses(CNFFormula cnf, FeatureTreeNode group[], int index[], int level, int start, int p) {
		if ( index == null  ) {
			index = new int[p];
			for( int i = 0 ; i < index.length ; i++ ) 
				index[i] = -1;
		}
		if ( level == p ) {
			CNFClause clause = new CNFClause();
			for( int i = 0 ; i < index.length ; i++ ) {
				clause.addLiteral(new CNFLiteral(group[index[i]],false));
			}
			cnf.addClause(clause);
		}
		else {
			for( int i = start ; i < group.length ; i++ ) {
				index[level] = i;
				addExclusiveOrGroupClauses(cnf,group, index, level+1, i+1, p);
	
			}
		}
	}

	public CNFFormula FM2CNF() {
		CNFFormula cnf = new CNFFormula();
		cnf.addClauses(FT2CNF().getClauses());
		if ( countConstraints() > 0 ) {
			cnf.addClauses(EC2CNF().getClauses());
		}
		return cnf;
	}

	
	public Map<String,FTCluster> generateFTClusterDependencyView() {

		Map<String,FTCluster> view = new LinkedHashMap<String,FTCluster>();
		
		// FT root is always the main cluster
		FeatureTreeNode ftRootNode = getRoot();
		FTCluster ftRootCluster = new FTCluster(ftRootNode);
		view.put(ftRootNode.getID(), ftRootCluster );

		Set<FeatureTreeNode> flatNodesSet = new HashSet<FeatureTreeNode>();
		for( FeatureTreeNode child : ftRootCluster.getChildren() ) {
			flatNodesSet.add(child);
		}
		
		// traverse EC clauses and build new clusters
		for( PropositionalFormula pf : getConstraints() ) {
			for( CNFClause cnfClause : pf.toCNFClauses() ) {
				List<FeatureTreeNode> identifiedNodes = new ArrayList<FeatureTreeNode>();
				FeatureTreeNode clusterRootNode = identifyViewNodes(cnfClause, identifiedNodes);
				if ( identifiedNodes.size() > 1 ) {
					FTCluster cluster = view.get(clusterRootNode.getID());
					if ( cluster == null ) {
						cluster = new FTCluster(clusterRootNode);
						view.put(clusterRootNode.getID(), cluster);
					}
					cluster.addRelation(identifiedNodes, cnfClause.getVariables());					
					for( FeatureTreeNode child : cluster.getChildren() ) {
						flatNodesSet.add(child);
					}
				}
			}
		}		
		
		// identify clusters' ancestor-descendant relationships
		for( String clusterName : view.keySet() ) {
			FTCluster cluster = view.get(clusterName);
			FeatureTreeNode ancestor = findNearestAncestorOnList(cluster.getRoot(), flatNodesSet);
			if ( ancestor != null ) {
				cluster.setAncestor(ancestor);
			}
		}
		return view;
	}

	private static FeatureTreeNode findNearestAncestorOnList(FeatureTreeNode node, Set<FeatureTreeNode> list) {
		if ( node != null ) {
			FeatureTreeNode ancestor = node;
			do {
				if ( list.contains(ancestor)) {
					return (FeatureTreeNode)ancestor;
				}
				ancestor = (FeatureTreeNode)ancestor.getParent();
			} while( ancestor != null);
		}
		return null;
	}

	public FeatureTreeNode lowestCommonAncestor(List<FeatureTreeNode> nodes) {
		List<List<FeatureTreeNode>> ancestorsList = new Vector<List<FeatureTreeNode>>();
		for( FeatureTreeNode node : nodes) {
			List<FeatureTreeNode> ancestors = new ArrayList<FeatureTreeNode>();
			if ( node != null ) {
				ancestors.add(0,node);
				FeatureTreeNode ancestorNode = (FeatureTreeNode)node.getParent();
				while( ancestorNode != null ) {
					ancestors.add(0,ancestorNode);
					ancestorNode = (FeatureTreeNode)ancestorNode.getParent();
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

		// find the lowest common ancestor and its corresponding children that are 
		// root nodes of the subtrees of the variables in 'clause'
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

		Set<FeatureTreeNode> variables = new LinkedHashSet<FeatureTreeNode>();
		for( List<FeatureTreeNode> ancestors : ancestorsList ) {
			if ( ancestors.size() >= index ) {
				variables.add(ancestors.get(index-1));
			}
		}
		nodes.addAll(variables);
		return commonAncestor;
	}	
	
	public boolean isAncestor(FeatureTreeNode possibleAncestor, FeatureTreeNode node) {
		FeatureTreeNode curNode = node;
		while( curNode != null ) {
			if ( curNode == possibleAncestor ) {
				return true;
			}
			curNode = (FeatureTreeNode)curNode.getParent();
		}
		return false;
	}
	
	private FeatureTreeNode identifyViewNodes(CNFClause clause, List<FeatureTreeNode> nodes) {
		// for each variable in "clause" creates a list with its ancestors
		List<List<FeatureTreeNode>> ancestorsList = new Vector<List<FeatureTreeNode>>();
		for( BooleanVariableInterface var : clause.getVariables() ) {
			List<FeatureTreeNode> ancestors = new ArrayList<FeatureTreeNode>();
			FeatureTreeNode node = getNodeByID(var.getID());
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

		// find the lowest common ancestor and its corresponding children that are 
		// root nodes of the subtrees of the variables in 'clause'
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

		Set<FeatureTreeNode> variables = new LinkedHashSet<FeatureTreeNode>();
		for( List<FeatureTreeNode> ancestors : ancestorsList ) {
			if ( ancestors.size() >= index ) {
				variables.add(ancestors.get(index-1));
			}
		}
		nodes.addAll(variables);
		return commonAncestor;
	}	

	public void dumpValues() {
		dump((FeatureTreeNode)getRoot(), 0, 3, true);
		dumpConstraints();
	}
	
	public void dump() {
		dump((FeatureTreeNode)getRoot(), 0, 3, false);
		dumpConstraints();
	}
	
	public void dumpConstraints() {
		for( Iterator<PropositionalFormula> it = getConstraints().iterator() ; it.hasNext() ; ) {
			PropositionalFormula c = it.next();
			System.out.println(c);
		}
	}
	
	public void dumpConstraintsXML() {
		for( Iterator<PropositionalFormula> it = getConstraints().iterator() ; it.hasNext() ; ) {
			PropositionalFormula c = it.next();
			System.out.println(c.getName() + ":" + c.toString());
		}
	}
	
	public void dump(FeatureTreeNode node, int level, int space, boolean values) {
		if ( node != null ) {
			for( int i=1 ; i <=level*space ; i++ ) {
				System.out.print(" ");
			}
			String value = values ? " = "+node.getValue() : ""; 
			System.out.println(node + value);
			int count = node.getChildCount();
			if ( count > 0 ) {
				for( int i = 0 ; i < count ; i++ ) {
					dump((FeatureTreeNode)node.getChildAt(i), level+1, space, values);
				}
			}
		}
	}

	public void dumpMetaData() {
		System.out.println("<meta>");
		for( String name : metadata.keySet() ) {
			System.out.println("<data name=\"" + name + "\">" + metadata.get(name) + "</data>");
		}
		System.out.println("</meta>");
	}
	
	public void dumpXML() {
		System.out.println("<feature_model name=\"" + getName() +"\">");
		dumpMetaData();
		System.out.println("<feature_tree>");
		dumpTabs(getRoot(), 0);
		System.out.println("</feature_tree>");
		System.out.println("<constraints>");
		dumpConstraintsXML();
		System.out.println("</constraints>");
		System.out.println("</feature_model>");
	}	

	public void dumpTabs(FeatureTreeNode node, int level) {
		if ( node != null ) {
			for( int i=1 ; i <=level; i++ ) {
				System.out.print("\t");
			}
			System.out.println(node);
			int count = node.getChildCount();
			if ( count > 0 ) {
				for( int i = 0 ; i < count ; i++ ) {
					dumpTabs((FeatureTreeNode)node.getChildAt(i), level+1);
				}
			}
		}
	}
	
	// Create feature model nodes 
    protected abstract FeatureTreeNode createNodes() throws FeatureModelException;
    
    // Save the feature model in permanent storage
	protected abstract void saveNodes();
		
}


