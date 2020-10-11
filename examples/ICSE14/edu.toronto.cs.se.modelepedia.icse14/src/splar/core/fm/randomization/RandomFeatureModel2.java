package splar.core.fm.randomization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import splar.core.constraints.BooleanVariable;
import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFGenerator;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.GroupedFeature;
import splar.core.fm.RootNode;
import splar.core.fm.SolitaireFeature;
import splar.core.fm.TreeNodeRendererFactory;


public class RandomFeatureModel2 extends FeatureModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 637877082231222395L;
	private int numberOfFeaturesToCreate;   // total number of features in the feature model not counting feature group nodes
	private int maxChildrenPerNode;  		// max number of children for a given node (opt, mand, and group count as one) 
	private int minChildrenPerNode;    		// min number of children for a given node (opt, mand, and group count as one)
	private int mandatoryOdds;      		// odds for mandatory features
	private int optionalOdds;      	 		// odds for optional features
	private int group1NOdds;      			// odds for [1,*] groups
	private int group11Odds;          		// odds for [1,1] groups
	private int maxGroupCardinality;       	// max number of grouped features in a group
	private int balanceFactor;				// [0%-100%] indicate the % of nodes that will NOT have children
	
	private static CNFGenerator cnfGenerator;
	
	public RandomFeatureModel2(String name,int numberOfFeaturesToCreate, int mandatoryOdds, int optionalOdds, int group1NOdds, int group11Odds, int minChildrenPerNode, int maxChildrenPerNode, int maxGroupCardinality, int balanceFactor) {
		super();
		setName(name);
		// feature tree parameters
		this.numberOfFeaturesToCreate = numberOfFeaturesToCreate-1;
		this.maxChildrenPerNode = maxChildrenPerNode;
		this.minChildrenPerNode = minChildrenPerNode;
		this.mandatoryOdds = (2 + (maxGroupCardinality - 2)/2) * mandatoryOdds;
		this.optionalOdds =  (2 + (maxGroupCardinality - 2)/2) * optionalOdds;
//		this.mandatoryOdds = mandatoryOdds;
//		this.optionalOdds = optionalOdds;
		this.group1NOdds = group1NOdds;
		this.group11Odds = group11Odds;
		this.maxGroupCardinality = maxGroupCardinality;
		this.balanceFactor = balanceFactor;
		cnfGenerator = new CNFGenerator();
	}

	@Override
	protected FeatureTreeNode createNodes() throws FeatureModelException {				
		
		ArrayList<FeatureTreeNode> fmNodes = new ArrayList<FeatureTreeNode>();
		
		String featureName = "R";
		
		RootNode root = new RootNode( featureName, featureName, TreeNodeRendererFactory.createRootRenderer());
		root.attachData(new Integer(numberOfFeaturesToCreate-1));
		fmNodes.add(root);				
		FeatureTreeNode parentNode = null;
		
		int countCreatedFeatures = 0;
		while ( countCreatedFeatures < numberOfFeaturesToCreate ) {
			
			parentNode = fmNodes.get(0);
			fmNodes.remove(0);
			
			int numberOfDescendants = ((Integer)parentNode.getAttachedData()).intValue(); 							
			int numberOfChildNodesToCreate = Math.min(numberOfDescendants, (Math.abs(new Random().nextInt())%(maxChildrenPerNode-minChildrenPerNode+1))+minChildrenPerNode);
			
			// root node always has the maximum allowed number of children
			if ( parentNode.getParent() == null ) {
				numberOfChildNodesToCreate = maxChildrenPerNode;
			}
			else if ( isRoot((FeatureTreeNode)parentNode.getParent()) ) {
				numberOfChildNodesToCreate = maxChildrenPerNode;
			}
			
			if ( numberOfChildNodesToCreate > 0 ) {
				
				List<FeatureTreeNode> createdNodes = new ArrayList<FeatureTreeNode>();
				
				int i = 0;
				while ( (createdNodes.size() < numberOfChildNodesToCreate) && (countCreatedFeatures < numberOfFeaturesToCreate) ) {

					int availableNodes = numberOfFeaturesToCreate-countCreatedFeatures;
					String childFeatureName = parentNode.getID().substring(1) + "_" + (i+1);
					FeatureTreeNode randomNode = createRandomNode(childFeatureName, randonlyChooseNodeTypeToCreate(availableNodes), availableNodes);
					parentNode.add(randomNode);
					
					if ( randomNode instanceof FeatureGroup ) {
						FeatureGroup groupRandomNode = (FeatureGroup)randomNode;
						int countGroupedNodes = groupRandomNode.getChildCount();
						for( int j = 0 ; j < countGroupedNodes ; j++ ) {
							FeatureTreeNode groupedNode = (FeatureTreeNode)groupRandomNode.getChildAt(j); 
							fmNodes.add(groupedNode);
						}
						countCreatedFeatures += (countGroupedNodes);
					}
					else {
						fmNodes.add(randomNode);
						countCreatedFeatures++;
					}							
					createdNodes.add(randomNode);
					i++;
				}
				
				// assign the number of descendants to create to each child node according to the balance factor
				distributeChildrenNodes(createdNodes, numberOfDescendants-createdNodes.size());
				
				for( FeatureTreeNode createdNode : createdNodes ){
					if ( createdNode instanceof FeatureGroup ) {
						int d = ((Integer)createdNode.getAttachedData()).intValue()/createdNode.getChildCount();
						for( int j = 0 ; j < createdNode.getChildCount() ; j++ ) {
							FeatureTreeNode groupedNode = (FeatureTreeNode) createdNode.getChildAt(j);
							groupedNode.attachData(new Integer(d));
						}
					}
				}
				
			}
		}
		
		return root;
	}

	private void distributeChildrenNodes(List<FeatureTreeNode> nodes, int numberOfDescendants) {
		
		int numChildren = nodes.size();
		
		if ( numberOfDescendants <= 0 ) {
			for( FeatureTreeNode node : nodes ) {
				node.attachData(new Integer(0));
			}
		}
		else if ( numChildren == 1 ) {
			nodes.get(0).attachData(new Integer(numberOfDescendants));
		}
		else if ( numberOfDescendants < numChildren ){ 
			for( int i = 0 ; i < numChildren ; i++ ) {
				nodes.get(i).attachData( (i <= numberOfDescendants) ? new Integer(1) : new Integer(0) );
			}
		}
		else {
			
			int children[] = new int[numChildren];
			int fixedNumDescendants = Math.round(numberOfDescendants * (1-(balanceFactor/100.0f)));
			int variableNumDescendants =  numberOfDescendants - fixedNumDescendants;

			if ( variableNumDescendants > 0 ) {
				// distribute variable number of descendants among children 
				float total = 0;
				// generate random distribution
//				System.out.println("------------------");
				for( int i = 0 ; i < numChildren ;i++ ) {
					int range = 2*(i+1);//(int)(Math.pow(10,i+1));
//					System.out.println("Range: " + range);
					children[i] = range;//Math.abs(new Random().nextInt())%range;
					total += children[i];
				}
				// distribute according to random values
				for( int i = 0 ; i < numChildren ;i++ ) {
					float x = (children[i]/total) * variableNumDescendants;
//					System.out.println("xx:  " + x);
					children[i] = Math.round(x);
				}
			}
			else {
				for( int i = 0 ; i < numChildren ;i++ ) {
					children[i] = 0;
				}				
			}
			
			// distribute fixed num descendants among children
			int childIndex = 0;
			for( int i = 0 ; i < fixedNumDescendants ; i++ ) {
				children[childIndex]++;
				childIndex = (childIndex+1)%numChildren;
			}
//			System.out.println("**>> : " + numberOfDescendants);
			// attach integers to nodes
			for( int i = 0 ; i < numChildren ;i++ ) {
//				System.out.println(">> : " + children[i]);
				FeatureTreeNode node = nodes.get(i);
				node.attachData(new Integer(children[i]));
			}
		}
	}
		
	private String randonlyChooseNodeTypeToCreate(int availableNodes) {
		
		if ( availableNodes >= 2 ) {
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
		int randomIndex = Math.abs(new Random().nextInt()) % (mandatoryOdds+optionalOdds);
		if ( randomIndex < mandatoryOdds ) {
			return "mandatory";
		}
		return "optional";
	}

	private FeatureTreeNode createRandomNode(String childFeatureName, String nodeType, int numAvailableNodes) {

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
			int groupSize = Math.min((Math.abs(new Random().nextInt())%(maxGroupCardinality))+1, numAvailableNodes);
			if (groupSize <= 1) groupSize=2;
			int lower = 1;
			int upper = -1;
			String groupName = "_Gi_" + childFeatureName;
			node = new FeatureGroup( groupName, groupName, lower,upper,TreeNodeRendererFactory.createFeatureGroupRenderer() );
			// create grouped feature nodes
			for( int i = 0 ; i < groupSize ; i++ ) {
				featureName = "g" + childFeatureName + "_" + (i+1);
		        node.add( new GroupedFeature( featureName, featureName, TreeNodeRendererFactory.createGroupedRenderer() ));		        
			}
		}
		else if ( nodeType.compareToIgnoreCase("group11") == 0 ) {
			// number of grouped features
			int groupSize = Math.min((Math.abs(new Random().nextInt())%(maxGroupCardinality))+1, numAvailableNodes);
			if (groupSize <= 1) groupSize=2;
			int lower = 1;
			int upper = 1;
			String groupName = "_Ge_" + childFeatureName;
			node = new FeatureGroup( groupName, groupName, lower,upper,TreeNodeRendererFactory.createFeatureGroupRenderer() );
			// create grouped feature nodes
			for( int i = 0 ; i < groupSize ; i++ ) {
				featureName = "g" + childFeatureName + "_" + (i+1);
		        node.add( new GroupedFeature( featureName, featureName, TreeNodeRendererFactory.createGroupedRenderer() ));		        
			}
		}
		
		return node;
	}

	// returns the number of levels for which constraints were created for
//	public int createExtraConstraints(int numVars, int numConstraints, int maxArity, int [][] modularityParameters) {
//		return RandomFeatureModel.createExtraConstraints(this, numVars, numConstraints, maxArity, modularityParameters);
//	}

	// expand the current number of 3-cnf clauses to reach the specified clause density
	// never shrinks the number of clauses though
	public static int expand3CNFClauses(FeatureModel fm, float clauseDensity, String prefix) {
		CNFFormula cnf = fm.EC2CNF();
		List<BooleanVariableInterface> vars = new LinkedList<BooleanVariableInterface>(cnf.getVariables());
		List<CNFClause> clauses = new LinkedList<CNFClause>(cnf.getClauses());
		List<CNFClause> allClauses = cnfGenerator.generateCNFInstance(vars, clauses , clauseDensity, 3);
		int i = 0;
		for( CNFClause clause : allClauses ) {
			try {
				fm.addConstraint(new PropositionalFormula(prefix + (i++), clause.toPropositionalFormula()));
			}
			catch( Exception e ) {
				e.printStackTrace();
			}
		}
		return allClauses.size();
	}
	
	public static int createExtraConstraints(FeatureModel fm, int numVars, int numConstraints, int maxArity, int [][] modularityParameters) {
		return createExtraConstraints(fm, numVars, numConstraints, maxArity, modularityParameters, 100, 100);
	}
	
	public static int createExtraConstraints(FeatureModel fm, int numVars, int numConstraints, int maxArity, int [][] modularityParameters, int percVar3cnf, int percForm3cnf) {
		
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
		List<PropositionalFormula> createdFormulas = new LinkedList<PropositionalFormula>();
		for( int i = levelsToConsider-1 ; i >= 0 ; i-- ) {
			// at least two variables to consider level
			if ( modularityParameters[i][1] >= 2 ) {
				int numConstraintsLevel = (numConstraints * Math.round(modularityParameters[i][1]/100f))/numVars;
				LevelConstraintGenerator constraintGenerator = new LevelConstraintGenerator(fm, modularityParameters[i][0], modularityParameters[i][1], numConstraintsLevel, maxArity, modularityParameters[i][2], modularityParameters[i][3]);
				List<PropositionalFormula> levelFormulas = constraintGenerator.createExtraConstraints();
				countLevelsWithContraints = (levelFormulas.size() > 0) ? countLevelsWithContraints + 1 : countLevelsWithContraints;
				createdFormulas.addAll( levelFormulas );
			}
		}
		
//		System.out.println("> Before: ------------------------------");
//		for( PropositionalFormula formula : createdFormulas ) {
//			System.out.println("> " + formula.getFormula());
//		}
		
		enrichFormulas(createdFormulas, percVar3cnf, percForm3cnf);
		
//		System.out.println("> AFTER: ------------------------------");
//		for( PropositionalFormula formula : createdFormulas ) {
//			System.out.println("> " + formula.getFormula());
//		}

		for( PropositionalFormula formula : createdFormulas) {
			fm.addConstraint(formula);
		}
		
		return countLevelsWithContraints;
	}
	
	public void saveNodes() {}
	
	private static void enrichFormulas(List<PropositionalFormula> fmConstraints, int percVars, int percFormulas) {
		
		// first, eliminate some formulas based on percFormulas
		List<PropositionalFormula> pickedFormulas = new LinkedList<PropositionalFormula>();
		pickedFormulas.addAll(fmConstraints);
		Collections.shuffle(pickedFormulas);
		int formulasToEliminate = (int)((1-(percFormulas/100.0))*pickedFormulas.size());
		for( int i = 0 ; i < formulasToEliminate ; i++ ) {
			pickedFormulas.remove(0);
		}
		
		// now, eliminate some variables based on percVars
		List<BooleanVariable> pickedVariables = new LinkedList<BooleanVariable>();
		for( PropositionalFormula constraint : fmConstraints ) {
			for( BooleanVariable var : constraint.getVariables() ) {
				if ( !pickedVariables.contains(var) ) {
					pickedVariables.add(var);
				}
			}
		}
		Collections.shuffle(pickedVariables);
		int variablesToEliminate = (int)((1-(percVars/100.0))*pickedVariables.size());
		for( int i = 0 ; i < variablesToEliminate ; i++ ) {
			pickedVariables.remove(0);
		}				
		
		// then, add a new variable to each of the picked formulas
		int varIndex = 0;
		for( PropositionalFormula pickedFormula : pickedFormulas ) {			
			BooleanVariable pickedVariable = pickedVariables.get(varIndex);
			int breakcounter = 0;
			while( pickedFormula.getVariables().contains(pickedVariable) ) {
				varIndex = (varIndex+1)%pickedVariables.size();
				pickedVariable = pickedVariables.get(varIndex);
				if ( ++breakcounter == pickedVariables.size() ) break;
			}
			if ( breakcounter < pickedVariables.size() ) {
				addNewVariableToFormula(pickedFormula, pickedVariable);
			}
			varIndex = (varIndex+1)%pickedVariables.size();
		}
	}	
	
	private static void addNewVariableToFormula( PropositionalFormula pickedFormula, BooleanVariable pickedVariable) {
//		System.out.println("> Before: " + pickedFormula.getFormula());
		String literal = (new Random().nextBoolean()) ? "~" + pickedVariable.getID() : pickedVariable.getID();
		pickedFormula.appendToFormula(" OR " + literal);
		pickedFormula.appendToVariables(pickedVariable);
//		System.out.println("---> After: " + pickedFormula.getFormula());
	}
}

class LevelConstraintGenerator {

	private FeatureModel fm;
	private int level;
	private int numVars;
	private int numConstraints;
	private int maxArity;
	private int clustersPercentage;
	private int clusterChildNodesPercentage;
	
	public LevelConstraintGenerator(FeatureModel fm, int level, int numVars, int numConstraints, int maxArity, int clustersPercentage, int clusterChildNodesPercentage) {
		this.fm = fm;
		this.level = level;
		this.numVars = numVars;
		this.numConstraints = numConstraints;
		this.maxArity = maxArity;
		this.clustersPercentage = clustersPercentage;
		this.clusterChildNodesPercentage = clusterChildNodesPercentage;
	}
	
	public int getNumberOfVariables() {
		return numVars;
	}
	
	public List<PropositionalFormula> createExtraConstraints() {
		
		List<PropositionalFormula> formulas = new ArrayList<PropositionalFormula>(); 
		
		// select clusters to add constraints based on the clusters percentage specified  
		List<FeatureTreeNode> selectedClusters = selectClusters(fm.getNodesAtLevel(level), clustersPercentage);
				
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
				int numConstraintsCluster = numVarsCluster/2; //Math.round(percVarsConst*numConstraints);
				if ( numVarsCluster < 2 || numConstraintsCluster < 1) {
					numVarsCluster = 2;
					numConstraintsCluster = 1;
				}
//				System.out.println("Cluster: " + cluster.getID());
//				System.out.println("********** vars: " + numVarsCluster);
//				System.out.println("********** const: " + numConstraintsCluster);
				
				formulas.addAll(createClusterConstraints(cluster, numVarsCluster, numConstraintsCluster, clusterChildNodesPercentage));
			}
		}

		return formulas;
	}
	
	private List<PropositionalFormula> createClusterConstraints(FeatureTreeNode clusterNode, int numVarsCluster, int numConstraintsCluster, int clusterChildNodesPercentage) {

		List<PropositionalFormula> formulas = new ArrayList<PropositionalFormula>();

		List<FeatureTreeNode> nodes = new ArrayList<FeatureTreeNode>();
		for( int i = 0 ; i < clusterNode.getChildCount() ; i++ ) {
			nodes.add((FeatureTreeNode)clusterNode.getChildAt(i));
		}

		// eliminate some child nodes according to cluster child nodes percentage
		int nodesToEliminate = Math.min(nodes.size(), Math.round((1-(clusterChildNodesPercentage/100f))*nodes.size()));
		for( int i = 0 ; i < nodesToEliminate ; i++ ) {
			nodes.remove(Math.abs(new Random().nextInt())%nodes.size());
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
			}
			nodeIndex =  (nodeIndex+1) % tempNodes.size();
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
	
		if ( countNodes > 0 ) {

			// generate constraints
//			Collections.shuffle(pickedNodesForVariables);
			
			List<ArrayList<List<FeatureTreeNode>>> groups = createClusterGroups(pickedNodesForVariables);
			if ( groups.size() >= 1 ) {
			
				int groupsVarIndexes[][] = new int[groups.size()][];
				for( int g = 0 ; g < groups.size() ; g++ ) {
					groupsVarIndexes[g] = new int[groups.get(g).size()];
					for( int e = 0 ; e < groups.get(g).size() ; e++ ) {
						groupsVarIndexes[g][e] = 0;
					}
				}
								
				int nodeGroupIndex[] = new int[groups.size()];
				java.util.Arrays.fill(nodeGroupIndex, 0);
				int groupIndex = 0;
				
				for( int i = 0 ; i < numConstraintsCluster ; i++ ) {
					List<FeatureTreeNode> variables = new ArrayList<FeatureTreeNode>();
					int arity = 2; // + Math.abs(new Random().nextInt())%(maxArity-1);
					
					ArrayList<List<FeatureTreeNode>> pickedGroup = groups.get(groupIndex);
					int groupSize = pickedGroup.size();
					
					for( int j = 0 ; j < arity ; j++ ) {
						List<FeatureTreeNode> variablesForNode = pickedGroup.get(nodeGroupIndex[groupIndex]); 
						variables.add(variablesForNode.get(groupsVarIndexes[groupIndex][nodeGroupIndex[groupIndex]]));
						groupsVarIndexes[groupIndex][nodeGroupIndex[groupIndex]] = (++groupsVarIndexes[groupIndex][nodeGroupIndex[groupIndex]])%pickedGroup.get(nodeGroupIndex[groupIndex]).size();
						if ( groupsVarIndexes[groupIndex][nodeGroupIndex[groupIndex]] == 0) {
							Collections.shuffle(pickedGroup.get(nodeGroupIndex[groupIndex]));
						}

						nodeGroupIndex[groupIndex] = (nodeGroupIndex[groupIndex]+1)%groupSize;
						
//						if ( Math.abs(new Random().nextInt())%3 == 0 ) {
//						}
//						else if ( (++nodeIndex) == countNodes ) {
//							nodeIndex = 0;
//						}
					}
					
					groupIndex = (groupIndex+1)%(groups.size());
					
					String formulaStr = "";
					for( Iterator<FeatureTreeNode> it = variables.iterator() ; it.hasNext() ; ) {
						String ID = it.next().getID().trim();
						if ( new Random().nextBoolean() == true ) {
							ID = "~" + ID;
						}
						formulaStr += ID; 
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
		}
		
		return formulas;
	}
	
	private List<ArrayList<List<FeatureTreeNode>>> createClusterGroups( ArrayList<List<FeatureTreeNode>> pickedNodesForVariables) {
		
		List<ArrayList<List<FeatureTreeNode>>> groups = new ArrayList<ArrayList<List<FeatureTreeNode>>>();
		
		int countNodes = pickedNodesForVariables.size();
		if ( countNodes >= 2 ) {
		
			// draw groups
			int numGroups = 1+(Math.abs(new Random().nextInt())%(countNodes/2));
			for( int i = 0 ; i < numGroups ; i++ ) {
				ArrayList<List<FeatureTreeNode>> group = new ArrayList<List<FeatureTreeNode>>();				
				groups.add(group);			
			}
			
			// fill up groups
			Collections.shuffle(pickedNodesForVariables);
			int groupIndex = 0;
			int smallerGroupSize = 2;
			for( List<FeatureTreeNode> nodeGroup : pickedNodesForVariables ) {
				
				groups.get(groupIndex).add(nodeGroup);
								
				// groups new a minimum of 2 nodes
				if ( groups.get(groupIndex).size() <= smallerGroupSize ) {
					groupIndex = (groupIndex+1)%(groups.size());
				}
				// allow groups to have different sizes
				else {
					groupIndex = Math.abs(new Random().nextInt())%numGroups;
				}
			}
			
			// DEBUG
//			System.out.print("\ntotal groups: " + pickedNodesForVariables.size());
//			for( int i = 0 ; i < numGroups ; i++ ) {
//				System.out.print("\ngroup " + i + ": ");
//				for( int j = 0 ; j < groups.get(i).size() ; j++ ) {
//					System.out.print("X ,");
//				}
//			}
		}
		
		return groups;
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
	public List<FeatureTreeNode> selectClusters(List<FeatureTreeNode> nodes, int clustersPercentage) {

//		if ( level == 1) {
//			System.out.println("");
//		}
//		
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
		int nodesToEliminate = Math.min(nodes.size(), Math.round((1-(clustersPercentage/100f))*totalCandidateClusters));		
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
	
}
