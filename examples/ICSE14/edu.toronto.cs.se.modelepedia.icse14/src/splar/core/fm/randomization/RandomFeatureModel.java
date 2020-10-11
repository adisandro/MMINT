package splar.core.fm.randomization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.GroupedFeature;
import splar.core.fm.RootNode;
import splar.core.fm.SolitaireFeature;
import splar.core.fm.TreeNodeRendererFactory;


public class RandomFeatureModel extends FeatureModel {

	private int numberOfFeaturesToCreate;   // total number of features in the feature model not counting feature group nodes
	private int maxChildrenPerNode;  		// max number of children for a given node (opt, mand, and group count as one) 
	private int minChildrenPerNode;    		// min number of children for a given node (opt, mand, and group count as one)
	private int mandatoryOdds;      		// odds for mandatory features
	private int optionalOdds;      	 		// odds for optional features
	private int group1NOdds;      			// odds for [1,*] groups
	private int group11Odds;          		// odds for [1,1] groups
	private int maxGroupCardinality;       	// max number of grouped features in a group
	private int balanceFactor;				// [0%-100%] indicate the % of nodes that will NOT have children
	
	public RandomFeatureModel(String name,int numberOfFeaturesToCreate, int mandatoryOdds, int optionalOdds, int group1NOdds, int group11Odds, int minChildrenPerNode, int maxChildrenPerNode, int maxGroupCardinality, int balanceFactor) {
		super();
		setName(name);
		// feature tree parameters
		this.numberOfFeaturesToCreate = numberOfFeaturesToCreate;
		this.maxChildrenPerNode = maxChildrenPerNode;
		this.minChildrenPerNode = minChildrenPerNode;
		this.mandatoryOdds = mandatoryOdds;
		this.optionalOdds = optionalOdds;
		this.group1NOdds = group1NOdds;
		this.group11Odds = group11Odds;
		this.maxGroupCardinality = maxGroupCardinality;
		this.balanceFactor = balanceFactor;
	}

	protected FeatureTreeNode createNodes() throws FeatureModelException {				
	
		int countFeatures = 1;
		Vector<FeatureTreeNode> fmNodes = new Vector<FeatureTreeNode>();
		
		String featureName = "R";
		countFeatures++;
		
		RootNode root = new RootNode( featureName, featureName, TreeNodeRendererFactory.createRootRenderer());
		fmNodes.add(root);				
		FeatureTreeNode parentNode = null;
		
		while ( countFeatures <= numberOfFeaturesToCreate ) {
			
			parentNode = fmNodes.firstElement();
			fmNodes.removeElement(parentNode);
									
			int numberOfChildNodesToCreate = Math.min(numberOfFeaturesToCreate-countFeatures+1, (Math.abs(new Random().nextInt())%(maxChildrenPerNode-minChildrenPerNode+1))+minChildrenPerNode);
			
			// root node always has the maximum allowed number of children
			if ( parentNode.getParent() == null ) {
				numberOfChildNodesToCreate = maxChildrenPerNode;
			}
			else if ( isRoot((FeatureTreeNode)parentNode.getParent()) ) {
				numberOfChildNodesToCreate = maxChildrenPerNode;
			}
			
			// prevents an early end of the recursion when all nodes happen to have no children 
			if ( numberOfChildNodesToCreate == 0 ) {
				if ( fmNodes.size() == 0 ) {
					numberOfChildNodesToCreate = 1;
				}
			}
			
			if ( numberOfChildNodesToCreate > 0 ) {			
				for( int i = 0 ; i < numberOfChildNodesToCreate && countFeatures <= numberOfFeaturesToCreate ; i++ ) {
					String childFeatureName = parentNode.getID().substring(1) + (i+1);
					FeatureTreeNode randomNode = createRandomNode(childFeatureName, randonlyChooseNodeTypeToCreate());
					parentNode.add(randomNode);
					if ( randomNode instanceof FeatureGroup ) {
						FeatureGroup groupRandomNode = (FeatureGroup)randomNode;
						int countGroupedNodes = groupRandomNode.getChildCount();
						if ( Math.abs(new Random().nextInt()) % 100 > balanceFactor  || fmNodes.size() == 0 ) {
							for( int j = 0 ; j < countGroupedNodes ; j++ ) {
								fmNodes.add((FeatureTreeNode)groupRandomNode.getChildAt(j));
							}
						}
						countFeatures += (countGroupedNodes);
					}
					else {
						if ( Math.abs(new Random().nextInt()) % 100 > balanceFactor  || fmNodes.size() == 0 ) {
							fmNodes.add(randomNode);
						}
						countFeatures++;
					}							
				}
			}
		}
	
		return root;
	}

		
	private String randonlyChooseNodeTypeToCreate() {
		int randomIndex = Math.abs(new Random().nextInt()) % (mandatoryOdds+optionalOdds+group1NOdds+group11Odds);
		if ( randomIndex < mandatoryOdds ) {
			return "mandatory";
		}
		else if ( randomIndex < (mandatoryOdds+optionalOdds)) {
			return "optional";
		}
		else if ( randomIndex < (mandatoryOdds+optionalOdds+group1NOdds)) {
			return "group1N";
		}
		return "group11";
	}

	private FeatureTreeNode createRandomNode(String childFeatureName, String nodeType) {

		FeatureTreeNode node = null;
		String featureName = "";
		
		// should create a solitaire feature (optional/mandatory)?
		if ( nodeType.compareToIgnoreCase("optional") == 0 ) {
			featureName = "o" + childFeatureName;
	        node = new SolitaireFeature( true, featureName, featureName, TreeNodeRendererFactory.createOptionalRenderer());
		}
		else if ( nodeType.compareToIgnoreCase("mandatory") == 0 ) {
			featureName = "m" + childFeatureName;
	        node = new SolitaireFeature( false, featureName, featureName, TreeNodeRendererFactory.createOptionalRenderer());
		}
		// should create a feature group?
		else if ( nodeType.compareToIgnoreCase("group1N") == 0 ) {
			// number of grouped features
			int groupSize = (Math.abs(new Random().nextInt())%(maxGroupCardinality))+1;
			if (groupSize <= 1) groupSize=2;
			int lower = 1;
			int upper = -1;
			String groupName = "_Gi_" + childFeatureName;
			node = new FeatureGroup( groupName, groupName, lower,upper,TreeNodeRendererFactory.createFeatureGroupRenderer() );
			// create grouped feature nodes
			for( int i = 0 ; i < groupSize ; i++ ) {
				featureName = "g" + childFeatureName + (i+1);
		        node.add( new GroupedFeature( featureName, featureName, TreeNodeRendererFactory.createGroupedRenderer() ));		        
			}
		}
		else if ( nodeType.compareToIgnoreCase("group11") == 0 ) {
			// number of grouped features
			int groupSize = (Math.abs(new Random().nextInt())%(maxGroupCardinality))+1;
			if (groupSize <= 1) groupSize=2;
			int lower = 1;
			int upper = 1;
			String groupName = "_Ge_" + childFeatureName;
			node = new FeatureGroup( groupName, groupName, lower,upper,TreeNodeRendererFactory.createFeatureGroupRenderer() );
			// create grouped feature nodes
			for( int i = 0 ; i < groupSize ; i++ ) {
				featureName = "g" + childFeatureName + (i+1);
		        node.add( new GroupedFeature( featureName, featureName, TreeNodeRendererFactory.createGroupedRenderer() ));		        
			}
		}
		
		return node;
	}

	// returns the number of levels for which constraints were created for
	public int createExtraConstraints(int numVars, int numConstraints, int maxArity, int [][] modularityParameters) {
		return RandomFeatureModel.createExtraConstraints(this, numVars, numConstraints, maxArity, modularityParameters);
	}
	
	public static int createExtraConstraints(FeatureModel fm, int numVars, int numConstraints, int maxArity, int [][] modularityParameters) {
		
		int levelsToConsider = modularityParameters.length;
		int depth = fm.depth()-1; // last level are the leaves, ie, cannot be considered as no children nodes are available 
		levelsToConsider = ( levelsToConsider > depth ) ? depth : levelsToConsider;
		
		// discover levels to be worked out based on percentages passed as parameters
		for( int i = 0 ; i < levelsToConsider; i++ ) {
			modularityParameters[i][0] = Math.round(modularityParameters[i][0]/100f * (depth)); 
			modularityParameters[i][1] = Math.round(modularityParameters[i][1]/100f * numVars);
		}
		
		fm.resetNodesAttachedData();
		// generates constraints for each level
		int countLevelsWithContraints = 0;
		for( int i = levelsToConsider-1 ; i >= 0 ; i-- ) {
			// at least two variables to consider level
			if ( modularityParameters[i][1] >= 2 ) {
				int numConstraintsLevel = Math.round((numConstraints * modularityParameters[i][1]) / numVars);
				_LevelConstraintGenerator constraintGenerator = new _LevelConstraintGenerator(fm, modularityParameters[i][0], modularityParameters[i][1], numConstraintsLevel, maxArity, modularityParameters[i][2]);
				List<PropositionalFormula> levelFormulas = constraintGenerator.createExtraConstraints();
				countLevelsWithContraints = (levelFormulas.size() > 0) ? countLevelsWithContraints + 1 : countLevelsWithContraints;
				for( PropositionalFormula formula : levelFormulas) {
					fm.addConstraint(formula);
				}
			}
		}
		return countLevelsWithContraints;
	}
	
	public void saveNodes() {}
		
}

class _LevelConstraintGenerator {

	private FeatureModel fm;
	private int level;
	private int numVars;
	private int numConstraints;
	private int maxArity;
	private int percentage;
	
	public _LevelConstraintGenerator(FeatureModel fm, int level, int numVars, int numConstraints, int maxArity, int percentage) {
		this.fm = fm;
		this.level = level;
		this.numVars = numVars;
		this.numConstraints = numConstraints;
		this.maxArity = maxArity;
		this.percentage = percentage;
	}
	
	public int getNumberOfVariables() {
		return numVars;
	}
	
	public List<PropositionalFormula> createExtraConstraints() {
		
		List<PropositionalFormula> formulas = new ArrayList<PropositionalFormula>(); 
		
		// select clusters to add constraints based on the percentage specified  
		List<FeatureTreeNode> selectedClusters = selectClusters(fm.getNodesAtLevel(level), percentage);
		
		int numClusters = selectedClusters.size();
		if ( numClusters > 0 ) {
			
			// makes number of variables/constraints proportional to each cluster size
			// minimum is 2 vars/1 constraint per cluster
			
			int clustersTotalSize = 0;
			for( FeatureTreeNode cluster : selectedClusters ) {
				clustersTotalSize += fm.countNodes(cluster);
			}

			// for each selected cluster, select features for constraints
			for( FeatureTreeNode cluster : selectedClusters ) {
				float percVarsConst = fm.countNodes(cluster)/(1f*clustersTotalSize);
				int numVarsCluster = Math.round(percVarsConst*numVars);
				int numConstraintsCluster = numVarsCluster/3; //Math.round(percVarsConst*numConstraints);
				if ( numVarsCluster < 2 || numConstraintsCluster < 1) {
					numVarsCluster = 2;
					numConstraintsCluster = 1;
				}
//				System.out.println("Cluster: " + cluster.getID());
//				System.out.println("********** vars: " + numVarsCluster);
//				System.out.println("********** const: " + numConstraintsCluster);
				formulas.addAll(createClusterConstraints(cluster, numVarsCluster, numConstraintsCluster));
			}
		}

		return formulas;
	}
	
	private List<PropositionalFormula> createClusterConstraints(FeatureTreeNode clusterNode, int numVarsCluster, int numConstraintsCluster) {

		List<PropositionalFormula> formulas = new ArrayList<PropositionalFormula>();

		List<FeatureTreeNode> nodes = new ArrayList<FeatureTreeNode>();
		for( int i = 0 ; i < clusterNode.getChildCount() ; i++ ) {
			nodes.add((FeatureTreeNode)clusterNode.getChildAt(i));
		}
		
		// initializations
		ArrayList<List<FeatureTreeNode>> pickedNodesForVariables = new ArrayList<List<FeatureTreeNode>>();
		int countNodes = nodes.size();
		for( int i = 0 ; i < countNodes; i++ ) {
			pickedNodesForVariables.add(i, new ArrayList<FeatureTreeNode>());
		}
		
		List<FeatureTreeNode> tempNodes = new ArrayList<FeatureTreeNode>();
		tempNodes.addAll(nodes);
		
		int nodeIndex = 0;
		for( int i = 0 ; i < numVarsCluster && tempNodes.size() > 0 ; i++ ) {
			FeatureTreeNode node = tempNodes.get(nodeIndex);
			if ( !selectVariableFeature(node, pickedNodesForVariables.get(nodeIndex)) ) {
				tempNodes.remove(nodeIndex);
				nodeIndex = (nodeIndex == (tempNodes.size())) ? 0 : nodeIndex;
			}
			else {
				nodeIndex =  (++nodeIndex % tempNodes.size());
			}
		}

		// Remove subtrees that have no variables selected for them (eg. when numVars is very small some subtrees may never get any features picked)
		int indexToRemove = 0;
		for( int i = 0 ; i < countNodes ; i++ ) { 
			List<FeatureTreeNode> pickedFeatures = pickedNodesForVariables.get(indexToRemove);
			if ( pickedFeatures.size() == 0 ) {
				pickedNodesForVariables.remove(indexToRemove);
				nodes.remove(indexToRemove);					
			}
			else {
				indexToRemove++;
			}
		}
		
		countNodes = nodes.size();
	
//		// remove 34% of the nodes if the number of nodes is larger than 2
//		if ( countNodes > 2 ) {
//			countNodes = Math.round(0.60f * countNodes);  
//		}
			
		if ( countNodes > 0 ) {

			// create indexes to track down variables selected for each subtree 
			int varsIndex[] = new int[countNodes];
			for( int i = 0 ; i < countNodes ; i++ ) {
				varsIndex[i] = 0;
			}
	
			// generate constraints
			Collections.shuffle(pickedNodesForVariables);
			nodeIndex = 0;
			for( int i = 0 ; i < numConstraintsCluster ; i++ ) {
				List<FeatureTreeNode> variables = new ArrayList<FeatureTreeNode>();
				int arity = 2; // + Math.abs(new Random().nextInt())%(maxArity-1);
				for( int j = 0 ; j < arity ; j++ ) {
					List<FeatureTreeNode> variablesForNode = pickedNodesForVariables.get(nodeIndex); 
					variables.add(variablesForNode.get(varsIndex[nodeIndex]));
					varsIndex[nodeIndex] = (++varsIndex[nodeIndex])%pickedNodesForVariables.get(nodeIndex).size();
					if ( varsIndex[nodeIndex] == 0) {
						Collections.shuffle(pickedNodesForVariables.get(nodeIndex));
					}
					
//					nodeIndex = (Math.abs(new Random().nextInt())%countNodes);
					
//					nodeIndex = (++nodeIndex)%countNodes;
					
					if ( Math.abs(new Random().nextInt())%2 == 0 ) {
						nodeIndex = (Math.abs(new Random().nextInt())%countNodes);
					}
					else if ( (++nodeIndex) == countNodes ) {
						nodeIndex = 0;
					}
				}
				
				String formulaStr = "";
				for( Iterator<FeatureTreeNode> it = variables.iterator() ; it.hasNext() ; ) {
					formulaStr += it.next().getID();
					if ( it.hasNext() ) {
						formulaStr += " OR ";
					}
				}
				try {
					formulas.add( new PropositionalFormula("C_"+(level+1)+"_"+clusterNode.getID()+"_"+i,formulaStr) );
				}
				catch( Exception e ) {
					System.out.println("Error: " + formulaStr);
//					e.printStackTrace();
				}
	
			}
		}
		
		return formulas;
	}
	
	// returns true if a node was found and false if no node is available, ie, they have all been previously picked 
	private boolean selectVariableFeature(FeatureTreeNode subtreeRootNode, List<FeatureTreeNode> pickedNodesForVariables) {
		
		List<FeatureTreeNode> subtreeNodes = new ArrayList<FeatureTreeNode>(); 
		fm.getSubtreeNodes(subtreeRootNode, subtreeNodes);
		if( !(subtreeRootNode instanceof FeatureGroup) ) {
			subtreeNodes.add(subtreeRootNode);
		}
		
		// remove nodes that have been already picked
		for( Iterator<FeatureTreeNode> it = subtreeNodes.iterator() ; it.hasNext() ; ) {
			FeatureTreeNode node = it.next();
			if ( !(node instanceof FeatureGroup ) ) {
				Integer isSelected = (Integer)node.getAttachedData();
				if ( (isSelected != null && isSelected.intValue() == 1) || pickedNodesForVariables.contains(node)) {
					it.remove();
				}
			}
		}
		
		int countNodes = subtreeNodes.size(); 
		if ( countNodes > 0 ) {
			FeatureTreeNode nodeSelected = subtreeNodes.get(Math.abs(new Random().nextInt())%countNodes);
			nodeSelected.attachData(new Integer(1));
			pickedNodesForVariables.add(nodeSelected);
			return true;
		}
		
		return false;
	}
	
	// to be selected as a cluster a subtree must have:
	// - at least two subtreess
	// - each subtree must have at least 
	public List<FeatureTreeNode> selectClusters(List<FeatureTreeNode> nodes, int percentage) {

		int totalCandidateClusters = nodes.size();
		
		// ELIMINATION PHASE 1: Eliminate subtrees that do not qualify as clusters
		// find cluster candidate based on the number of subtrees (minimum 2) and features availability (minimum 1 per subtree)
		for( Iterator<FeatureTreeNode> it = nodes.iterator() ; it.hasNext() ; ) {
			FeatureTreeNode node = it.next();
			// at least two subtrees are necessary for a cluster to qualify
			boolean qualifies = false;
			if ( node.getChildCount() >= 2 ) {
				int countCandidateSubTrees = 0;
				for( int i = 0 ; i < node.getChildCount() ; i++ ) {
					FeatureTreeNode childNode = (FeatureTreeNode)node.getChildAt(i);
					// each subtree must have at least one available feature
					if ( countAvailableFeatures(childNode, !(node instanceof GroupedFeature)) >= 1 ) {
						countCandidateSubTrees++;
					}
				}
				qualifies = (countCandidateSubTrees >= 2);
			}
			if ( !qualifies ) {
				it.remove();
			}
		}
		
		// Shuffle candidate clusters for fairness
		java.util.Collections.shuffle(nodes);
		
		// ELIMINATION PHASE 2: Eliminate nodes based on specified percentage parameter		
		int nodesToEliminate = Math.min(nodes.size(), Math.round((1-(percentage/100f))*totalCandidateClusters));		
		for( int i = 0 ; i < nodesToEliminate ; i++ ) {
			nodes.remove(Math.abs(new Random().nextInt())%nodes.size());
		}

		// ELIMINATION PHASE 3: When number of clusters is larger in comparison to the number of variables for the cluster,
		//                      Eliminate clusters so that each remaining cluster has at least two variables
		float numClusters = nodes.size();		
		if ( (2*numClusters) > numVars) {
			int clustersToRemove = Math.round(numClusters-(numVars/2f)); 
			for( int i = 0 ; i < clustersToRemove ; i++ ) {
				nodes.remove(Math.round(Math.abs(new Random().nextInt())%nodes.size()));
			}
		}
		
		return nodes;
	}

	private int countAvailableFeatures(FeatureTreeNode node, boolean includesNodeItSelf) {
		
		List<FeatureTreeNode> nodes = new ArrayList<FeatureTreeNode>();
		fm.getSubtreeNodes(node, nodes);
		if ( includesNodeItSelf ) {
			nodes.add(node);
		}
		int countFeatures = 0;
		for( FeatureTreeNode descendantNode : nodes ) {
			if ( !(descendantNode instanceof FeatureGroup ) && descendantNode.getAttachedData() == null ) {
				countFeatures++;
			}
		}
		return countFeatures;
	}
		
	// Select Subtrees based on the percentage indicated
//	public List<FeatureTreeNode> selectSubtrees(List<FeatureTreeNode> nodes, int percentage, int minChildren) {
//		
//		if ( nodes.size() == 1 ) {
//			return nodes;
//		}
//		
//		java.util.Collections.shuffle(nodes);
//		
//		/*********************************/
//		int countNodes = nodes.size();
//		int nodesToEliminate = Math.round((1-(percentage/100f))*countNodes);
//		
////		System.out.println("Subtrees picked: " + (countNodes-nodesToEliminate));
//		
//		// at least two nodes must be left
////		nodesToEliminate = (nodes.size()-nodesToEliminate)<=1 ? (countNodes-2) : nodesToEliminate;		
//		for( int i = 0 ; i < nodesToEliminate ; i++ ) {
//			nodes.remove(Math.abs(new Random().nextInt())%nodes.size());
//		}
///*********************************/
//		// remove nodes with less than 2 features
//		for( Iterator<FeatureTreeNode> it = nodes.iterator() ; it.hasNext() ; ) {
//			FeatureTreeNode node = it.next();	
//			int minChildrenAllowed = minChildren;
//			if ( node instanceof FeatureGroup ) {
//				minChildrenAllowed += node.getChildCount();
//			}
////			System.out.println("Subtree size: " + fm.countNodes(node));
//			if ( (fm.countNodes(node) <= minChildrenAllowed) || ( node instanceof FeatureGroup )) {
//				it.remove();
//			}
//		}
//		
//		// select nodes based on the specified percentage
//		
//		return nodes;
//	}
}






/*
 * Produce constraints for a particular level of the Feature Tree by linking the subtrees in the level through particular selected features
 */
//class _LevelConstraintGenerator {
//
//	private FeatureModel fm;
//	private int level;
//	private int numVars;
//	private int numConstraints;
//	private int maxArity;
//	private int percentage;
//	
//	public _LevelConstraintGenerator(FeatureModel fm, int level, int numVars, int numConstraints, int maxArity, int percentage) {
//		this.fm = fm;
//		this.level = level;
//		this.numVars = numVars;
//		this.numConstraints = numConstraints;
//		this.maxArity = maxArity;
//		this.percentage = percentage;
//	}
//	
//	public int getNumberOfVariables() {
//		return numVars;
//	}
//	
//	public List<PropositionalFormula> createExtraConstraints() {
//		
//		List<PropositionalFormula> formulas = new ArrayList<PropositionalFormula>(); 
//		
//		// select subtrees to add constraints based on the percentage specified  
//		List<FeatureTreeNode> selectedClusters = selectSubtrees();
//		
//		// at least two subtrees have been selected?
//		int countSubTrees = selectedClusters.size();
//		if ( countSubTrees > 1 ) {		
//			// select variables and mark them so that they wont be used at other levels
//			ArrayList<List<FeatureTreeNode>> pickedNodesForVariables = new ArrayList<List<FeatureTreeNode>>();
//			for( int i = 0 ; i < countSubTrees; i++ ) {
//				pickedNodesForVariables.add(i, new ArrayList<FeatureTreeNode>());
//			}
//			int subtreeIndex = 0;
//			int countNotPickedVariables = 0;
//			for( int i = 0 ; i < numVars ; i++ ) {
//				FeatureTreeNode subtreeRootNode = selectedClusters.get(subtreeIndex);
//				if ( !selectVariableFeature(subtreeRootNode, pickedNodesForVariables.get(subtreeIndex)) ) {
//					countNotPickedVariables++;
//				}
//				subtreeIndex =  (++subtreeIndex % countSubTrees); 
//			}
//
//			// update number of variables actually used
//			numVars -= countNotPickedVariables;
//			
//			// Remove subtrees that have no variables selected for them (eg. when numVars is very small some subtrees may never get any features picked)
//			int indexToRemove = 0;
//			for( int i = 0 ; i < countSubTrees ; i++ ) { 
//				List<FeatureTreeNode> pickedFeatures = pickedNodesForVariables.get(indexToRemove);
//				if ( pickedFeatures.size() == 0 ) {
//					pickedNodesForVariables.remove(indexToRemove);
//					selectedClusters.remove(indexToRemove);					
////					System.out.println("Removed! + " + indexToRemove);
//				}
//				else {
//					indexToRemove++;
//				}
//			}
//
//			// DEBUG
//			for( int i = 0 ; i < selectedClusters.size() ; i++ ) {
//
//				System.out.print("\n" + selectedClusters.get(i).getID() + ": ");
//				List<FeatureTreeNode> list = pickedNodesForVariables.get(i);
//				for( FeatureTreeNode node : list ) {
//					System.out.print(node.getID() + ",");
//				}
//				System.out.print("\n");
//			}
//			
//			// create indexes to track down variables selected for each subtree 
//			int varsIndex[] = new int[countSubTrees];
//			for( int i = 0 ; i < countSubTrees ; i++ ) {
//				varsIndex[i] = 0;
//			}
//
//			// generate constraints
//			subtreeIndex = 0;
//			for( int i = 0 ; i < numConstraints ; i++ ) {
//				List<FeatureTreeNode> variables = new ArrayList<FeatureTreeNode>();
//				for( int j = 0 ; j < maxArity ; j++ ) {
//					variables.add(pickedNodesForVariables.get(subtreeIndex).get(varsIndex[subtreeIndex]));
//					varsIndex[subtreeIndex] = (++varsIndex[subtreeIndex])%pickedNodesForVariables.get(subtreeIndex).size();
//					if ( varsIndex[subtreeIndex] == 0) {
//						Collections.shuffle(pickedNodesForVariables.get(subtreeIndex));
//					}
//					subtreeIndex = (++subtreeIndex)%countSubTrees;					
//				}
//				
//				String formulaStr = "";
//				for( Iterator<FeatureTreeNode> it = variables.iterator() ; it.hasNext() ; ) {
//					formulaStr += it.next().getID();
//					if ( it.hasNext() ) {
//						formulaStr += " OR ";
//					}
//				}
//				try {
//					formulas.add( new PropositionalFormula("C_"+level+"_"+i,formulaStr) );
//				}
//				catch( Exception e ) {
//					e.printStackTrace();
//				}
//
//			}
//		}
//		
//		return formulas;
//	}
//	
//	// returns true if a node was found and false if no node is available, ie, they have all been previously picked 
//	private boolean selectVariableFeature(FeatureTreeNode subtreeRootNode, List<FeatureTreeNode> pickedNodesForVariables) {
//		
//		List<FeatureTreeNode> subtreeNodes = new ArrayList<FeatureTreeNode>(); 
//		fm.getSubtreeNodes(subtreeRootNode, subtreeNodes);
//		
//		// remove nodes that have been already picked
//		for( Iterator<FeatureTreeNode> it = subtreeNodes.iterator() ; it.hasNext() ; ) {
//			FeatureTreeNode node = it.next();
//			Integer isSelected = (Integer)node.getAttachedData();
//			if ( (isSelected != null && isSelected.intValue() == 1) || pickedNodesForVariables.contains(node)) {
//				it.remove();
//			}
//		}
//		
//		int countNodes = subtreeNodes.size(); 
//		if ( countNodes > 0 ) {
//			FeatureTreeNode nodeSelected = subtreeNodes.get(Math.abs(new Random().nextInt())%countNodes);
//			nodeSelected.attachData(new Integer(1));
//			pickedNodesForVariables.add(nodeSelected);
//			return true;
//		}
//		
//		return false;
//	}
//	
//	// Select Subtrees at level "level" based on the percentage indicated
//	public List<FeatureTreeNode> selectSubtrees() {
//		
//		// candidate nodes
//		List<FeatureTreeNode> nodes = fm.getNodesAtLevel(level);
//		
//		// remove nodes without children
//		for( Iterator<FeatureTreeNode> it = nodes.iterator() ; it.hasNext() ; ) {
//			FeatureTreeNode node = it.next();
////			System.out.println("Subtree size: " + fm.countNodes(node));
//			if ( fm.countNodes(node) <= 1 ) {
//				it.remove();
//			}
//		}
//		
//		// select nodes based on the specified percentage
//		int countNodes = nodes.size();
//		int nodesToEliminate = Math.round((1-(percentage/100f))*countNodes);
//		
////		System.out.println("Subtrees picked: " + (countNodes-nodesToEliminate));
//		
//		// at least two nodes must be left
////		nodesToEliminate = (nodes.size()-nodesToEliminate)<=1 ? (countNodes-2) : nodesToEliminate;		
//		for( int i = 0 ; i < nodesToEliminate ; i++ ) {
//			nodes.remove(Math.abs(new Random().nextInt())%nodes.size());
//		}
//		
//		return nodes;
//	}
//}
//
//
//
//
//
