package splar.plugins.reasoners.bdd.javabdd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.BDDFactory.ReorderMethod;
import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.GroupedFeature;
import splar.core.fm.SolitaireFeature;
import splar.core.fm.reasoning.FMReasoningException;
import splar.core.heuristics.VariableOrderingHeuristic;

public class FTReasoningWithBDD extends ReasoningWithBDD {

	public final static String BEST_VARIABLE_ORDER = "Best-Variable-Order"; // Best Variable Order - very costly
	public final static String WORST_VARIABLE_ORDER = "Worst-Variable-Order"; // Worst Variable Order - very costly
	
	protected FeatureModel featureModel;
	private BDDGenerationStatistics bddStats;
	private String searchType;
	
	public FTReasoningWithBDD(FeatureModel featureModel, VariableOrderingHeuristic voHeuristic, int nodeNum, int cacheSize, long maxBuildingtime, String orderingFormulasStrategy) {
		this(featureModel, voHeuristic, nodeNum, cacheSize, maxBuildingtime, BDDFactory.REORDER_NONE, orderingFormulasStrategy);
	}
	
	public FTReasoningWithBDD(FeatureModel featureModel, VariableOrderingHeuristic voHeuristic, int nodeNum, int cacheSize, long maxBuildingtime, ReorderMethod reorderMethod, String orderingFormulasStrategy) {
		super(voHeuristic, nodeNum, cacheSize, maxBuildingtime, reorderMethod, orderingFormulasStrategy);
		this.featureModel = featureModel;
		this.searchType = null;
		bddFactory.setVarNum(getFeatureModel().countNodes());
	}
	
	public FTReasoningWithBDD(FeatureModel featureModel, int nodeNum, int cacheSize, String searchType, long maxBuildingtime, String orderingFormulasStrategy) {
		this(featureModel, nodeNum, cacheSize, searchType, maxBuildingtime, BDDFactory.REORDER_NONE, orderingFormulasStrategy);
	}
	
	public FTReasoningWithBDD(FeatureModel featureModel, int nodeNum, int cacheSize, String searchType, long maxBuildingtime, ReorderMethod reorderMethod, String orderingFormulasStrategy) {
		super(null, nodeNum, cacheSize, maxBuildingtime, reorderMethod, orderingFormulasStrategy);
		this.featureModel = featureModel;
		this.searchType = searchType;
	}
	
	public void init() throws Exception {
		super.init();
		long start = System.currentTimeMillis();
		setInitialBDDState(start - ((long)getHeuristicRunningTime()+bddBuildingTime));		
		bddBuildingTime += (System.currentTimeMillis() - start);
	}
	
	protected void setInitialBDDState(long start) throws Exception {
		variables = initVars(theOriginalBDD.getFactory().varNum());		
	}
		
	public void saveState(String stateID) {
		super.saveState(stateID);
		featureModel.saveState(stateID);
	}
	
	public void restoreState(String stateID) {
		super.restoreState(stateID);	
		featureModel.restoreState(stateID);
	}
	
	public void discardState(String stateID) {
		super.discardState(stateID);
		featureModel.discardState(stateID);
	}
		
	protected BDD createBDD(BDDFactory bddFactory, String orderingFormulasStrategy) throws Exception {
		
		if ( reorderMethod != BDDFactory.REORDER_NONE ) {
			super.initBDDReorder(getFeatureModel().countNodes());
		}
		
		BDD bdd = null;
		
		long start = System.currentTimeMillis();
		// create BDD based on Statistics (eg., best order, worst order)
		if ( searchType != null ) {
			if ( searchType == BEST_VARIABLE_ORDER || searchType == WORST_VARIABLE_ORDER) {
				bdd = createBDDBasedOnStatistics(searchType);
				this.heuristicRunningTime = 0;
			}
		}
		// create BDD based on FEATURE TREE TRAVERSAL HEURISTICS
		else if ( variableOrderingHeuristic != null ){
//			bddFactory.setVarNum(countFMNodes);
			varIndex2NameMap = variableOrderingHeuristic.run(toCNF());
			varName2IndexMap = VariableOrderingHeuristic.variableOrderingAsHashMap(varIndex2NameMap);
			bdd = createBDDStructure(start - (long)getHeuristicRunningTime(), orderingFormulasStrategy);
		}
		
		// root node is always true
		bdd.andWith(bddFactory.ithVar(varName2IndexMap.get(featureModel.getRoot().getID())));

		this.bddBuildingTime = System.currentTimeMillis() - start;
		
//		theOriginalBDD = bdd; 		
//		theWorkingBDD = theOriginalBDD;		
		return bdd;
	}
	
	protected CNFFormula toCNF() {
		return featureModel.FT2CNF();		
	}
	
	protected BDD createBDDBasedOnStatistics(String searchType) throws Exception {
		int countFMNodes = getFeatureModel().countNodes();
		varName2IndexMap = new HashMap<String,Integer>();
		varIndex2NameMap = new String[countFMNodes];
		generateBDDStatistics();
		int searchTypeIndex = -1;
		if ( searchType.compareToIgnoreCase(BEST_VARIABLE_ORDER) == 0 ) {
			searchTypeIndex = bddStats.getBestVariableOrderIndex();
		}
		else if ( searchType.compareToIgnoreCase(WORST_VARIABLE_ORDER) == 0 ) {
			searchTypeIndex = bddStats.getWorstVariableOrderIndex();
		}
		// update the FT-BDD mapping structures
		String varOrder[] = bddStats.getVariableOrder(searchTypeIndex);		
		for( int i = 0 ; i < varOrder.length ; i++ ) {
			varName2IndexMap.put(varOrder[i], i);
			varIndex2NameMap[i] = varOrder[i];
		}
		
		return bddStats.getBDD(searchTypeIndex);
	}
		
	private void generateBDDStatistics() throws Exception {
		Vector<String> variables = new Vector<String>();
		for( Iterator<FeatureTreeNode> it = featureModel.getNodes().iterator(); it.hasNext() ; ) {
			FeatureTreeNode node = it.next();
			if ( !(node instanceof GroupedFeature)) {
				variables.add(node.getID());
			}
		}
		bddStats = null;
		String strVariables[] = variables.toArray(new String[0]);
		genBDDStats(strVariables, null, 0, System.currentTimeMillis());
	}
	
	private void genBDDStats(String theVariables[], int index[], int level, long start) throws Exception {
		
		if ( (System.currentTimeMillis() - start) > maxBuildingTime ) {
			throw new BDDExceededBuildingTimeException("FTReasoningWithBDD: Maximum time allowed for BDD construction exceeded: " + maxBuildingTime + " ms", "");
		}
		
		if ( index == null  ) {
			index = new int[theVariables.length];
			for( int i = 0 ; i < index.length ; i++ ) 
				index[i] = -1;
		}
		if ( level == theVariables.length ) {
			int expandIndex = 0;
			for( int j = 0 ; j < index.length ; j++ ) {
				FeatureTreeNode node = featureModel.getNodeByID(theVariables[index[j]]);
				if (node instanceof FeatureGroup) {
					FeatureGroup group = (FeatureGroup)node;
					int groupChildCount = group.getChildCount();
					for( int k = 0 ; k < groupChildCount; k++ ) {
						FeatureTreeNode childNode = (FeatureTreeNode)group.getChildAt(k);
						varName2IndexMap.put(childNode.getID(), expandIndex+j+k);
						varIndex2NameMap[expandIndex+j+k] = childNode.getID();
					}
					expandIndex += groupChildCount-1;
				}				
				else {
					varName2IndexMap.put(theVariables[index[j]], j+expandIndex);
					varIndex2NameMap[j+expandIndex] = theVariables[index[j]];
				}
			}
			try {
				theOriginalBDD = createBDDStructure(start, orderingFormulasStrategy);
				theWorkingBDD = theOriginalBDD;		
				setInitialBDDState(start);
				if ( bddStats == null ) {
					bddStats = new BDDGenerationStatistics(theVariables.length);
				}
				bddStats.addStats(bddFactory, theWorkingBDD, varIndex2NameMap);
			}
			catch( Exception e ) {
				e.printStackTrace();
			}
		}
		else {
			for( int i = 0 ; i < theVariables.length ; i++ ) {
				if ( index[i] == -1) {
					index[i] = level;
					genBDDStats(theVariables, index, level+1, start);
					index[i] = -1;
				}
			}
		}
	}	

	protected BDD createBDDStructure(long startTime, String orderingFormulasStrategy) throws BDDExceededBuildingTimeException {
//		System.out.println("Using strategy: " + orderingFormulasStrategy);
		if ( orderingFormulasStrategy.compareToIgnoreCase("level-order") == 0 ) {
			return levelOrderFormulaOrdering(startTime);
		}
		// if strategy is "undefined" uses preorder
		return preOrderFormulaOrdering(startTime);
	}
	
	protected BDD preOrderFormulaOrdering(long startTime) throws BDDExceededBuildingTimeException {
		return preOrderFormulaOrderingRec(featureModel.getRoot(), startTime);
	}
	
	protected BDD preOrderFormulaOrderingRec(FeatureTreeNode curNode, long startTime) throws BDDExceededBuildingTimeException {
		
		BDD bdd = bddFactory.one();
		
		BDD parentNodeBDD = bddFactory.ithVar(varName2IndexMap.get(curNode.getID()));
		
		int count = curNode.getChildCount();
		if ( count > 0 ) {
			BDD childBDD = null;
			for( int i = 0 ; i < count ; i++ ) {
				FeatureTreeNode childNode = ((FeatureTreeNode)curNode.getChildAt(i));						
				// It's a solitaire feature
				if ( childNode instanceof SolitaireFeature ) {						
					SolitaireFeature solitaireNode = (SolitaireFeature)childNode;
					childBDD = bddFactory.ithVar(varName2IndexMap.get(childNode.getID()));
					// if node is optional relation is "child implies parent"
					if ( solitaireNode.isOptional() ) {
						bdd.andWith(childBDD.imp(parentNodeBDD.id()));
					}
					// if node is mandatory relation is "child iff parent"
					else {
						bdd.andWith(childBDD.biimp(parentNodeBDD.id()));
					}
					// recursive structure
					BDD subtreeBDD = preOrderFormulaOrderingRec(childNode, startTime);
					bdd.andWith(subtreeBDD);
				}
				// It's a feature group						
				else if ( childNode instanceof FeatureGroup ) {
					FeatureGroup fGroup = (FeatureGroup)childNode;
					BDD fgBDD = createFeatureGroupBDDStructure(parentNodeBDD.id(),fGroup, null, bddFactory, startTime);
					bdd.andWith(fgBDD);
					// recursive call
					for( int j = 0 ; j < fGroup.getChildCount() ; j++ ) {
						FeatureTreeNode groupedNode = (FeatureTreeNode)fGroup.getChildAt(j);
						BDD subtreeBDD = preOrderFormulaOrderingRec(groupedNode, startTime);
						bdd.andWith(subtreeBDD);
					}
				}
				else {
					System.out.println("Error: Other type of node!");
				}
			}
		}
		return bdd;
	}
	
	protected BDD levelOrderFormulaOrdering(long startTime) throws BDDExceededBuildingTimeException {
		
		BDD bdd = bddFactory.one();
		Vector<FeatureTreeNode> nodes = new Vector<FeatureTreeNode>();
		nodes.add(getFeatureModel().getRoot());

		while ( nodes.size() > 0 ) {

			if ( (System.currentTimeMillis() - startTime) > maxBuildingTime ) {
				throw new BDDExceededBuildingTimeException("PF2BDDParser: Maximum time allowed for BDD construction exceeded: " + maxBuildingTime + " ms", "");
			}
			
			// consumes first node 
			FeatureTreeNode curNode = nodes.firstElement();
			nodes.remove(curNode);
			
			if ( curNode != null ) {				
				BDD nodeBDD = null;							
				nodeBDD = bddFactory.ithVar(varName2IndexMap.get(curNode.getID()));
				int count = curNode.getChildCount();
				if ( count > 0 ) {
					BDD childBDD = null;
					for( int i = 0 ; i < count ; i++ ) {
						FeatureTreeNode childNode = ((FeatureTreeNode)curNode.getChildAt(i));						
						// It's a solitaire feature
						if ( childNode instanceof SolitaireFeature ) {
							nodes.add(childNode);
							SolitaireFeature solitaireNode = (SolitaireFeature)childNode;
							childBDD = bddFactory.ithVar(varName2IndexMap.get(childNode.getID()));
							// if node is optional relation is "child implies parent"
							if ( solitaireNode.isOptional() )
								bdd.andWith(childBDD.imp(nodeBDD.id()));
							// if node is mandatory relation is "child iff parent"
							else
								bdd.andWith(childBDD.biimp(nodeBDD.id()));
						}
						// It's a feature group						
						else if ( childNode instanceof FeatureGroup ) {							
							FeatureGroup fGroup = (FeatureGroup)childNode;
							bdd.andWith(createFeatureGroupBDDStructure(nodeBDD.id(),fGroup, nodes, bddFactory, startTime));					
						}
						else {
							System.out.println("Error: Other type of node!");
						}
					}					
				}
			}
		}
		
		//set root node to TRUE
		bdd.andWith(bddFactory.ithVar(varName2IndexMap.get(getFeatureModel().getRoot().getID())).id().or(bddFactory.zero()));
		
		return bdd;
	}
	
	protected BDD createFeatureGroupBDDStructure(BDD parentBDD, FeatureGroup node, Vector<FeatureTreeNode> nodes, BDDFactory bddFactory, long start) throws BDDExceededBuildingTimeException {
		BDD bdd = null; 
		int childCount = node.getChildCount();
		if ( childCount > 0 ) {
			int min = node.getMin();
			int max = node.getMax();
			FeatureTreeNode tempNode1 = null,tempNode2 = null;
			// cardinality: min = 1, max = *  ( X1 v X2 v .... v Xn)
			if ( (min == 1) && (max == -1) ) {
				tempNode1 = (FeatureTreeNode)node.getChildAt(0);	// changed to start with first grouped child				
				bdd = bddFactory.ithVar(varName2IndexMap.get(tempNode1.getID()));				
				for( int i = 1 ; i < childCount ; i++ ) {
					if ( (System.currentTimeMillis() - start) > maxBuildingTime ) {
						throw new BDDExceededBuildingTimeException("PF2BDDParser: Maximum time allowed for BDD construction exceeded: " + maxBuildingTime + " ms", "");
					}
					tempNode2 = (FeatureTreeNode)node.getChildAt(i);		
					// add grouped nodes to the nodes list
					if ( nodes != null ) {
						nodes.add(tempNode1);
					}
					// updates the BDD
					BDD bdd2 = bddFactory.ithVar(varName2IndexMap.get(tempNode2.getID()));								
					bdd.orWith(bdd2);
				}
				bdd.biimpWith(parentBDD);
				if ( nodes != null ) {
					nodes.add(tempNode2);
				}
			}
			// cardinality: min = max = 1  (X1 ^ !x2 ^ ... ^ !Xn) v ( x2 ^ !x1 ^ ... ^ !xn) v ... v ( xn ^ !x1 ^ .... ^ !xn-1 ) 
			else if ( (min == max) && (min == 1) ){
				bdd = bddFactory.one();
				for( int i = 0 ; i < childCount ; i++ ) {
					tempNode1 = (FeatureTreeNode)node.getChildAt(i);
					// add grouped nodes to the nodes list
					if ( nodes != null ) {
						nodes.add(tempNode1);
					}
					BDD bdd1 = bddFactory.ithVar(varName2IndexMap.get(tempNode1.getID()));
					BDD bdd2 = bddFactory.zero();
					for( int j = 0 ; j < childCount ; j++ ) {
						if ( (System.currentTimeMillis() - start) > maxBuildingTime ) {
							throw new BDDExceededBuildingTimeException("PF2BDDParser: Maximum time allowed for BDD construction exceeded: " + maxBuildingTime + " ms", "");
						}
						if ( i != j ) {
							tempNode2 = (FeatureTreeNode)node.getChildAt(j);
							bdd2.orWith(bddFactory.ithVar(varName2IndexMap.get(tempNode2.getID())).id());
						}
					}
					bdd.andWith(bdd2.not().and(parentBDD).biimp(bdd1));
				}				
			}
		}
		return bdd;
	}  

//	protected BDD createFeatureGroupBDDStructure(BDD parentBDD, FeatureGroup node, Vector<FeatureTreeNode> nodes, BDDFactory bddFactory, long start) throws BDDExceededBuildingTimeException {
//		BDD bdd = null; 
//		int childCount = node.getChildCount();
//		if ( childCount > 0 ) {
//			int min = node.getMin();
//			int max = node.getMax();
//			FeatureTreeNode tempNode1 = null,tempNode2 = null;
//			// cardinality: min = 1, max = *  ( X1 v X2 v .... v Xn)
//			if ( (min == 1) && (max == -1) ) {
//				bdd = bddFactory.zero();				
//				for( int i = 1 ; i < childCount ; i++ ) {
//					if ( (System.currentTimeMillis() - start) > maxBuildingTime ) {
//						throw new BDDExceededBuildingTimeException("PF2BDDParser: Maximum time allowed for BDD construction exceeded: " + maxBuildingTime + " ms", "");
//					}
//					tempNode1 = (FeatureTreeNode)node.getChildAt(i-1);		
//					tempNode2 = (FeatureTreeNode)node.getChildAt(i);		
//					// add grouped nodes to the nodes list
//					if ( nodes != null ) {
//						nodes.add(tempNode1);
//					}
//					// updates the BDD
//					BDD bdd1 = bddFactory.ithVar(varName2IndexMap.get(tempNode1.getID()));								
//					BDD bdd2 = bddFactory.ithVar(varName2IndexMap.get(tempNode2.getID()));								
//					bdd.orWith(bdd1.or(bdd2));
//				}
//				bdd.biimpWith(parentBDD);
//				if ( nodes != null ) {
//					nodes.add(tempNode2);
//				}
//			}
//			// cardinality: min = max = 1  (X1 ^ !x2 ^ ... ^ !Xn) v ( x2 ^ !x1 ^ ... ^ !xn) v ... v ( xn ^ !x1 ^ .... ^ !xn-1 ) 
//			else if ( (min == max) && (min == 1) ){
//				bdd = bddFactory.one();
//				for( int i = 0 ; i < childCount ; i++ ) {
//					tempNode1 = (FeatureTreeNode)node.getChildAt(i);
//					// add grouped nodes to the nodes list
//					if ( nodes != null ) {
//						nodes.add(tempNode1);
//					}
//					BDD bdd1 = bddFactory.ithVar(varName2IndexMap.get(tempNode1.getID()));
//					BDD bdd2 = bddFactory.zero();
//					for( int j = 0 ; j < childCount ; j++ ) {
//						if ( (System.currentTimeMillis() - start) > maxBuildingTime ) {
//							throw new BDDExceededBuildingTimeException("PF2BDDParser: Maximum time allowed for BDD construction exceeded: " + maxBuildingTime + " ms", "");
//						}
//						if ( i != j ) {
//							tempNode2 = (FeatureTreeNode)node.getChildAt(j);
//							bdd2.orWith(bddFactory.ithVar(varName2IndexMap.get(tempNode2.getID())).id());
//						}
//					}
//					bdd.andWith(bdd2.not().and(parentBDD).biimp(bdd1));
//				}				
//			}
//		}
//		return bdd;
//	}  

	public FeatureModel getFeatureModel() {
		return featureModel;
	}
	
	
	/****************************************************************************************************************
	 *  REASONING OPERATIONS
	 ****************************************************************************************************************/

	/****************************************************************************************************************
	 *  Compute valid domains for all features
	 ****************************************************************************************************************/

	byte[][] domainTable;
	int unknownDomains;
	boolean debug = false;
	
	@Override
	public Map<String,Boolean[]> allValidDomains(Map<String,String> stats) throws FMReasoningException {
		
		try {
		
			// Initializes domain table updating it with feature model currently assigned features
			domainTable = new byte[this.getFeatureModel().countFeatures()][2];
			unknownDomains = domainTable.length * 2;
			for( int i = 0 ; i < domainTable.length ; i++ ) {
				String varName = getVariableName(i);
				FeatureTreeNode varNode = getFeatureModel().getNodeByID(varName);
				if ( varNode != null && varNode.isInstantiated() ) {
					domainTable[i][varNode.getValue()] = YES;
					domainTable[i][1-varNode.getValue()] = NO;
					unknownDomains -= 2;
				}
				else {
					domainTable[i][0] = UNKNOWN;
					domainTable[i][1] = UNKNOWN;
				}
			}
			
			if (debug) debugDomainTable(false);
			
			BDDTraversalNodeDFS traversal = new BDDTraversalNodeDFS() {
				
				int lastLevelChecked = 0;
				int visitedNodes = 0;
				
				public boolean searchStopped() {
					return unknownDomains == 0; 
				}
	
				private String varLabel(BDD bddNode) {
					if ( bddNode.isOne() ) {
						return "1T";
					}
					if ( bddNode.isZero() ) {
						return "0T";
					}
					return ""+bddNode.var();
				}
				
				private void updateDomainTable(BDDFactory factory, int startLevel, int endLevel) {
					for( int i = startLevel ; i > endLevel ; i-- ) {
						if (debug) System.out.println("  updating [level=" + i + ",var=" + factory.level2Var(i)+ "] name=" + getVariableName(factory.level2Var(i)));
						int varIndex = factory.level2Var(i);
						if ( domainTable[varIndex][0] == UNKNOWN ) {
							domainTable[varIndex][0] = YES;
							unknownDomains--;
						}
						if ( domainTable[varIndex][1] == UNKNOWN ) {
							domainTable[varIndex][1] = YES;
							unknownDomains--;
						}
					}
				}
				
				public void onOneTerminalFound(Set<String> path, byte solution[]) {		
					updateDomainTable(getBDDFactory(), domainTable.length-1, lastLevelChecked);
					super.onOneTerminalFound(path, solution);
				}
				
				public void onVisitingNode(BDD bddNode, Set<String> path, byte solution[]) {
					
					if ( !bddNode.isZero() && !bddNode.isOne() ) {
						
						BDDFactory factory = bddNode.getFactory();
						
						if (debug) System.out.println(++visitedNodes + ": visiting- [level=" + factory.var2Level(bddNode.var())+ ",var=" + bddNode.var()+ "] " + getVariableName(bddNode.var()) + "(" + varLabel(bddNode.low()) + "," + varLabel(bddNode.high()) + ")");
						if (debug) System.out.println("      last visited level: " + lastLevelChecked);
						
						int currentVar = bddNode.var();
						updateDomainTable(bddNode.getFactory(), factory.var2Level(currentVar)-1, lastLevelChecked);
						
						BDD low = bddNode.low();
						BDD high = bddNode.high();
						
						if ( !low.isZero() && domainTable[currentVar][0] == UNKNOWN ) {
							domainTable[currentVar][0] = YES;
							unknownDomains--;
						}
						if ( !high.isZero() && domainTable[currentVar][1] == UNKNOWN) {
							domainTable[currentVar][1] = YES;
							unknownDomains--;
						}
						
						low.free();
						high.free();
						
						if ( debug) debugDomainTable(false);
					}
				}
				
				public boolean canVisitNode(BDD bddNode, boolean polarity) {
					lastLevelChecked = getBDDFactory().var2Level(bddNode.var());
					if (!super.canVisitNode(bddNode, polarity)) {
						BDD nextNode = polarity ? bddNode.high() : bddNode.low();
						updateDomainTable(getBDDFactory(), getBDDFactory().var2Level(nextNode.var())-1, lastLevelChecked);
						nextNode.free();
						return false;
					}
					return true;
				}
				
				public void onSkippedNode(BDD bddNode, boolean polarity, Set<String> path, byte[] bddPath) {
				}
			};
			
			traversal.dfs(getBDD().id());
			
			// all UNKNOWN domain table entries are set to NO
			for( int i = 0 ; i < domainTable.length ; i++ ) {
				if ( domainTable[i][0]  == UNKNOWN ) domainTable[i][0] = NO;
				if ( domainTable[i][1]  == UNKNOWN ) domainTable[i][1] = NO;
			}
			
			Map<String,Boolean[]> allDomains = new HashMap<String, Boolean[]>();
			for( int i = 0 ; i < domainTable.length ; i++ ) {
				List<Boolean> domain = new LinkedList<Boolean>();
				if ( domainTable[i][0] == YES ) {
					domain.add(false);
				}
				if ( domainTable[i][1] == YES ) {
					domain.add(true);
				}
				allDomains.put(getVariableName(i),domain.toArray(new Boolean[0]));
			}
			
			//debugDomainTable(false);
			
			return allDomains;
		}
		catch( Exception e ) {
			throw new FMReasoningException(e);
		}
	}

	public void debugDomainTable(boolean breakLine) {
		System.out.println("Unknown domains: " + unknownDomains);
		System.out.println("Domain Table ---------------------------");
		int varIndex = 0;
		for( byte varDomain[] : domainTable ) {
			System.out.print(getVariableName(varIndex++) + ":[" + (varDomain[0] == YES ? "0," : "") + (varDomain[1] == YES ? "1" : "") +"] ");
//			System.out.print(reasoner.getVarNameByIndex(varIndex++) + ":[" + varDomain[0] + "," + varDomain[1] +"] ");
			if (breakLine ) System.out.println();
		}
		System.out.println();		
	}

	
}

