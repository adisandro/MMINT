package splar.plugins.reasoners.sat.sat4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.sat4j.core.LiteralsUtils;
import org.sat4j.core.VecInt;
import org.sat4j.minisat.core.Solver;
import org.sat4j.specs.ISolver;
import org.sat4j.specs.IVecInt;

import splar.core.fm.FTTraversalNodeSelector;
import splar.core.fm.FTTraversals;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.SolitaireFeature;


public class FTReasoningWithSAT extends ReasoningWithSAT {

	protected FeatureModel featureModel;
	
	public FTReasoningWithSAT(String solverName, FeatureModel featureModel, int timeout) {
		super(solverName, timeout);
		this.featureModel = featureModel;
	}

	public FeatureModel getFeatureModel() {
		return featureModel;
	}
	
	protected void updateVariableMappings() {
		varIndex2NameMap = new String[featureModel.countNodes()];
		for ( FeatureTreeNode node : featureModel.getNodes() ) {
			if ( !(node instanceof FeatureGroup) ) {
				String varName = node.getID();
				Integer index = (Integer)node.getAttachedData();
				varName2IndexMap.put(varName, index);
				//System.out.println(varName + " = " + index);
				varIndex2NameMap[index-1] = varName;
			}
		}
	}

	protected void addSolverClauses(ISolver solver) throws Exception {
		// release all data attached to feature model nodes
		featureModel.resetNodesAttachedData();
		
		solver.newVar(featureModel.countNodes());

		// count features (variables)
		int countFeatures= 1;
		
		// root is always TRUE
		IVecInt vectInt = new VecInt(1);
		vectInt.push(countFeatures);
		solver.addClause(vectInt);
		//System.out.println(vectInt);
		
		FeatureTreeNode rootNode = featureModel.getRoot();
		rootNode.attachData(new Integer(countFeatures));
				
		Vector<FeatureTreeNode> nodes = new Vector<FeatureTreeNode>();
		nodes.add(rootNode);
		
		// Perform a Breadht First Traversal of the feature tree 
		while ( nodes.size() > 0 ) {

			// consumes first node 
			FeatureTreeNode curNode = nodes.firstElement();
			nodes.remove(curNode);
			
			if ( curNode != null ) {
				int parentVarID = 0;
				int count = curNode.getChildCount();
				if ( count > 0 ) {
					for( int i = 0 ; i < count ; i++ ) {
						FeatureTreeNode childNode = ((FeatureTreeNode)curNode.getChildAt(i));
						int childVarID = 0;
						// It's a solitaire feature
						if ( childNode instanceof SolitaireFeature ) {
							parentVarID = (Integer)curNode.getAttachedData();
							childVarID = ++countFeatures;
							childNode.attachData(childVarID);
							nodes.add(childNode);
							
							SolitaireFeature solitaireNode = (SolitaireFeature)childNode;
							// if node is optional relation is "child implies parent"
							vectInt = new VecInt(2);
							vectInt.push(parentVarID);
							vectInt.push(-childVarID);
							solver.addClause(vectInt);
							//System.out.println(vectInt);
							// if mandatory, "parent also implies child"
							if ( !solitaireNode.isOptional() ) {
								vectInt = new VecInt(2);
								vectInt.push(-parentVarID);
								vectInt.push(childVarID);
								solver.addClause(vectInt);
								//System.out.println(vectInt);
							}
						}
						// It's a feature group						
						else if ( childNode instanceof FeatureGroup ) {		
							FeatureGroup fgNode = (FeatureGroup)childNode;
							parentVarID = (Integer)((FeatureTreeNode)fgNode.getParent()).getAttachedData();
							int countGroupedNodes = fgNode.getChildCount();

							// (not P or g1 or g2 or ... or gn)
							vectInt = new VecInt(countGroupedNodes+1);
							vectInt.push(-parentVarID);						
														
							// (not g1 or P) (not g2 or P) ... (not gn or P)
							IVecInt vectIntGrpOR;
							
							for( int j = 0 ; j < countGroupedNodes ; j++ ) {
								FeatureTreeNode groupedNode = (FeatureTreeNode)fgNode.getChildAt(j);
								childVarID = ++countFeatures;
								groupedNode.attachData(childVarID);
								nodes.add(groupedNode);
								vectInt.push(childVarID);
								vectIntGrpOR = new VecInt(2);
								vectIntGrpOR.push(parentVarID);
								vectIntGrpOR.push(-childVarID);
								solver.addClause(vectIntGrpOR);
								//System.out.println(vectIntGrpOR);

								
							}
							solver.addClause(vectInt);
							//System.out.println(vectInt);
							
							// if it's an exclusive-OR group
							// (not g1 or not g2) (not g1 or not g3) (not g2 or not g3)
							int min = fgNode.getMin();
							int max = fgNode.getMax();
							max = (max == -1 ? countGroupedNodes : max);
							if ( min == 1 && max == 1 ) {
								List<List<Integer>> combinations = new ArrayList<List<Integer>>();
								computeCombinations(combinations, countGroupedNodes, 2);		
								IVecInt vectIntGrpXOR;
								for( List<Integer> combination : combinations ) {
									vectIntGrpXOR = new VecInt(2);
									for( Integer index : combination ) {
										vectIntGrpXOR.push(-(countFeatures-countGroupedNodes+1+index));
									}
									solver.addClause(vectIntGrpXOR);
									//System.out.println(vectIntGrpXOR);
								}
							}
							// Implemented on May 6, 2009
							// min > 1 || max < countGroupedNodes
							else if ( min > 1 || max < countGroupedNodes ) {
								// step 1: from 1 to MIN-1
								// step 2: from MAX+1 to countGroupedNodes
								int startIndex = 0;
								int endIndex = min-1;
								List<List<Integer>> combinations = new ArrayList<List<Integer>>();
								while( true ) {
//									System.out.println("startIndex=" + startIndex +"  endIndex=" + endIndex);
									for( int idx = startIndex ; idx < endIndex ; idx++ ) {
										computeCombinations(combinations, countGroupedNodes, idx+1);		
										IVecInt vectIntGrp;
//										System.out.println("combination size: " + combinations.size());
										for( List<Integer> combination : combinations ) {
											vectIntGrp = new VecInt(countGroupedNodes);
											// add negated variables
//											System.out.print(">> ");
											for( Integer index : combination ) {
//												System.out.print(-(countFeatures-countGroupedNodes+1+index) + ",");
												vectIntGrp.push(-(countFeatures-countGroupedNodes+1+index));
											}
											// add positive variables
											for( int posIndex = 0 ; posIndex < countGroupedNodes ; posIndex++ ) {
												if (!combination.contains(posIndex)) {
//													System.out.print(countFeatures-countGroupedNodes+1+posIndex + ",");
													vectIntGrp.push(countFeatures-countGroupedNodes+1+posIndex);
												}
											}				
//											System.out.println("");
											solver.addClause(vectIntGrp);
											//System.out.println(vectIntGrpXOR);
										}									
									}
									if ( endIndex == countGroupedNodes ) break;
									startIndex = max;
									endIndex = countGroupedNodes;
								}																
							}
							// else (Inclusive-OR grouped) <- addressed by default
						}
						else {
							//System.out.println("Error: Other type of node!");
						}
					}					
				}
			}
		}
		
		updateVariableMappings();
		
		
		// add unit clauses for instantiated variables
		for( FeatureTreeNode node : featureModel.getInstantiatedNodes() ) {
//			System.out.println(node + ":" + node.getValue());
			if ( !(node instanceof FeatureGroup)) {
				IVecInt vInt = new VecInt(1);
				int index = getVariableIndex(node.getID());
				vInt.push(node.getValue()==1 ? index : -index);
				solver.addClause(vInt);
//				System.out.println("Adding unit clause for " + node.getID());
			}
		}
	}
	
	public static List<List<Integer>> computeCombinations(List<List<Integer>> combinations, int n, int p) {
		combinations.clear();
		groupCombination(combinations, null, 0, 0, n, p);
		return combinations;
	}
	
	public static void groupCombination(List<List<Integer>> combinations, ArrayList<Integer> index, int level, int start, int n, int p) {
		if ( level == 0 && index == null ) {
			index = new ArrayList<Integer>(p);
		}
		if ( level == p ) {
			List<Integer> theIndex = new ArrayList<Integer>();
			theIndex.addAll(index);
			combinations.add(theIndex);
		}
		else {
//			if ( (n-start+3) >= p ) {
				for( int i = start ; i < n ; i++ ) {
					index.add(level, i);
					groupCombination(combinations, index, level+1, i+1, n, p);
					index.remove(level);
				}
//			}
		}
	}
	
	/*
	 * Parameter 1: testValues
	 * -----------
	 * testValues: indicates which truth values should be tested for variables: 1=true, 0=false
	 *   For dead features: testValues={1}, for common features: testValues={0}, for valid domains: testValues={1,0}
	 *   Eg. Tests with {1} find all features that can be true, hence, the dead features are those that CANNOT be true
	 * 
	 * Parameter 2: optimizations: indicate which optimizations should be used in the algorithm
	 * -----------
	 *   1) Update all variable domains whenever a variable is inspected
	 *   2) Add unit clause to formula for unsatisfiability cases 
	 *   3) If feature is dead its descendants are dead (for future: if f can only be true (common), all ancestors are true)
	 *   4) Indicates the "SAT variable order" as well as the value order for each variable  
	 *       - move tested/completed variables to the end of the order
	 *       - priority to non-tested values for each variable
	 *   Dependencies: 
	 *   - optimization 5 only applies when optimization 1 is ON
	 *   - optimization 4 improves quality of optimization 3: (parent processed prior to children improves discovery of dead features) 
	 * 
	 * Parameter 3: statistics map
	 * -----------
	 */
	
	/*
	 * Defaults:
	 * - DFS for ordering processing and SAT variables
	 *   Variable order for processing variables (we call it "algorithm variable order" not to confuse with "SAT variable order")
	 *   - parent features prior to their children: good for unsat cases -> improves optimization 3 
	 */
	
	public byte[][] computeValidDomains(int testValues[], boolean optimizations[], Map<String,String> stats) {

		// Dimension 1: variable index
		// Dimension 2: variable domain (0: false, 1: true)
		byte domainTable[][] = null;
		
		// check if problem is SAT, otherwise: ERROR!
//		if( !solver.isSatisfiable() ) {
//			return null;
//		}
		
		try {
			
			// creates a table to record the possible domains for each variable in the model 
			domainTable = new byte[featureModel.countFeatures()][2];
			for( int i = 0 ; i < domainTable.length ; i++ ) {
				FeatureTreeNode node = featureModel.getNodeByID(getVariableName(i+1));
				if ( node.isInstantiated() ) {
					domainTable[i][node.getValue()] = YES;
					domainTable[i][1-node.getValue()] = NO;
				}
				else {
					domainTable[i][0] = UNKNOWN;
					domainTable[i][1] = UNKNOWN;
				}
			}
	
			int satChecks = 0;
			long processingTime = System.currentTimeMillis();			
			int varOrderIndex = 0;
			
//			List<IConstr> state = saveSolverState();
			
			// for each uninstantiated variable in the feature model (in a particular order) 
			List<FeatureTreeNode> processingVarOrder = getVariableProcessingOrder(domainTable);
			
//			System.out.print("Processing order: ");
//			for(FeatureTreeNode n : processingVarOrder) {
//				System.out.print(n.getID()+",");
//			}
//			System.out.println();
			
			int opt3NumVariablesEliminated = 0;
			for( FeatureTreeNode uninstantiatedNode : processingVarOrder ) {
				
				//**
//				dumpDomainTable(domainTable, false);
//				System.out.println("\r\n" + (varOrderIndex+1) +". Checking: " + uninstantiatedNode.getID() + "(" + getVariableIndex(uninstantiatedNode.getID()) + ")");

//				init();  // create SAT solver and add clauses from FM
				Solver solver = (Solver)getSolver();

//				solver.setDBSimplificationAllowed(true);
				
				int varIndex = getVariableIndex(uninstantiatedNode.getID());
				
				// what boolean value order should be used for the test variable?
				for( Integer value : getValueProcessingOrder(domainTable, varIndex, testValues) ) {
					
					// optimization 4 
					// set SAT value order strategy based on current state of domain table
					setVariableAndValueOrderForSAT(domainTable, varIndex, testValues, optimizations);
					
//					System.out.println("    >> " + value);
					
					try {
						solver.assume(value==1 ? LiteralsUtils.posLit(varIndex) : LiteralsUtils.negLit(varIndex));
//						solver.propagate();
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					
					satChecks++;
					boolean isSAT = solver.isSatisfiable();
					
					int[] solution = null;
					if ( isSAT ) {
						solution = satSolver.model();
					}
					
					if ( isSAT && 
							((solution[getVariableIndex(uninstantiatedNode.getID())-1]<0 && value==0) ||
							(solution[getVariableIndex(uninstantiatedNode.getID())-1]>0 && value==1)) ) {
						domainTable[varIndex-1][value] = YES;
						// optimization 1
						if ( optimizations[0] ) {							
							
//							//**
//							System.out.print("      ");
//							for( int v : solution ) {
//								System.out.print(v + ",");
//							}
//							System.out.println();
//							//**
							
							for( int j = varOrderIndex+1 ; j < processingVarOrder.size() ; j++ ) {
								int tempIndex = getVariableIndex(processingVarOrder.get(j).getID());
								
								//**
//								System.out.println("      " + processingVarOrder.get(j).getID() + "(" + (tempIndex) +") = " + solution[tempIndex-1]);
								
								domainTable[tempIndex-1][solution[tempIndex-1]<0?0:1] = YES;
								
							}
						}
					}
					else {
						domainTable[varIndex-1][value] = NO;
						domainTable[varIndex-1][1-value] = YES;
						
						// optimization 2
						if (optimizations[1]) {
							VecInt tempVecInt = new VecInt(1);
							tempVecInt.push((value==0)?varIndex:-varIndex);
							satSolver.addClause(tempVecInt);
//							//**
//							System.out.println("UNSAT: assigning value to node " + uninstantiatedNode.getID());
						}
						
						
						// optimization 3
						if ( optimizations[2] ) { 
							Collection<FeatureTreeNode> propNodes = new LinkedList<FeatureTreeNode>();
							if ( value == 1 ) {
								featureModel.getSubtreeNodes(featureModel.getNodeByID(uninstantiatedNode.getID()), (List)propNodes);
							}
//							else {
//								propNodes = featureModel.ancestors(featureModel.getNodeByID(uninstantiatedNode.getID()));
//							}
//							System.out.println("Dead feature: " + uninstantiatedNode.getID());
							for( FeatureTreeNode propNode : propNodes) {
								int propVarIndex = getVariableIndex(propNode.getID());
								if ( domainTable[propVarIndex-1][value] == UNKNOWN ) {
//									System.out.println("   opt3 dead feature: " + propNode.getID());
									domainTable[propVarIndex-1][value] = NO;
									domainTable[propVarIndex-1][1-value] = YES;
									VecInt tempVecInt = new VecInt(1);
									tempVecInt.push((value==0)?propVarIndex:-propVarIndex);
									satSolver.addClause(tempVecInt);
									opt3NumVariablesEliminated++;
								}
//								System.out.println("propagating");
							}
						}	
						break;  // do not inspect the other boolean value on UNSAT cases
					}
					
				}
				
				varOrderIndex++;
				
			}
						
			processingTime = (System.currentTimeMillis() - processingTime);
			
			stats.put("sat-checks", String.valueOf(satChecks));
			stats.put("processing-time", String.valueOf(processingTime));
			stats.put("opt3-eliminated-vars", String.valueOf(opt3NumVariablesEliminated));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return domainTable; 		
	}	
	
//	protected List<IConstr> saveSolverState() {
//		List<IConstr> constraints = new LinkedList<IConstr>();
//		Solver solver = (Solver)getSolver();
//		for( int i = 0 ; i < solver.nConstraints() ; i++ ) {
//			constraints.add(solver.getDSFactory().);
//		}
//		return constraints;
//		
//	}
//	
//	protected void restoreSolverState(List<IConstr> constraints) {
//		Solver solver = (Solver)getSolver();
//		for( IConstr constraint : constraints ) {
//			solver.addClause(constraint.);
//			
//		}
//	}
	
	public void dumpDomainTable(byte [][]table, boolean isFinal) {
		int i = 0;
		System.out.println("-----------------------");
		for( byte[] entry : table ) {
			int j = 0;
			if ( isFinal ) {
				if ( entry[0] == YES && entry[1] == YES ) {
					System.out.println("      FREE  : " + getVariableName(i+1) + ": {true, false}");				
				}
				else if ( entry[1] == NO ) {
					System.out.println(">>>>> DEAD  : " + getVariableName(i+1) + ": {false}");				
				}
				else if ( entry[0] == NO ) {
					System.out.println(">>>>> COMMON: " + getVariableName(i+1) + ": {true}");				
				}
				else {
					System.out.println("      PARTIAL  : " + getVariableName(i+1) + ": {" + (entry[0]==YES?"false, ":(entry[0]==NO?"":"?, ")) + (entry[1]==YES?"true":(entry[0]==NO?"":"?"))+ "}");
				}
			}
			else {
				System.out.print("      " + getVariableName(i+1) + ": {");
				for( byte value : entry ) {
					if ( value == YES ) {
						System.out.print((j==1)+ ",");
					}
					else if ( value == UNKNOWN ){
						System.out.print("?,");
					}
					j++;
				}
				System.out.print("}\r\n");
			}
			i++;
		}
		System.out.println("-----------------------");
	}
	
	protected List<FeatureTreeNode> getVariableProcessingOrder(final byte [][] domainTable) {

		// DFS is the default variable ordering strategy
		FTTraversalNodeSelector selector = new FTTraversalNodeSelector() {
			public boolean select(FeatureTreeNode node) {
				if ( node instanceof FeatureGroup )
					return false;
				int varIndex = getVariableIndex(node.getID())-1;
				return (domainTable[varIndex][0]) == UNKNOWN && (domainTable[varIndex][1] == UNKNOWN);
			}
		};
		
		List<FeatureTreeNode> order = FTTraversals.dfs(featureModel.getRoot(), selector);
		
//		if (!optimization4) {
//			Collections.shuffle(order);
//		}
		
		return order;
//		
//		List<FeatureTreeNode> list = new ArrayList<FeatureTreeNode>();
//		list.addAll(featureModel.getUninstantiatedNodes());
////**		Collections.shuffle(list);
	}
	
	protected List<Integer> getValueProcessingOrder(byte [][] domainTable, int varIndex, int testValues[]) {
		List<Integer> order = new ArrayList<Integer>();
		for( int value : testValues ) {
			// if value on testValues has not been tested yet, add it to the list
			if ( domainTable[varIndex-1][value] == UNKNOWN ) {
				order.add(value);
			}
		}
		return order;
	}
	
	// optimization 4
	// This is the order the SAT solver will use for variables and values for constructing the search tree
	
	private String satVarOrder[] = null;
	private StaticVariableOrderSAT satOrderObj = null;
	
	protected void setVariableAndValueOrderForSAT(byte [][] domainTable, int varIndex, int testValues[], boolean optimizations[]) {
		
		// optimization 4: value order
		// if testValues={1} -> test dead features -> 1
		// if testValues={0} -> test common features -> 0
		// if testValues={1,0} or {0,1} -> priority to values not tested yet
		if ( optimizations[3] ) {
			
			// DFS of the FT - FUTURE: move processed variables to the end of the order
			if ( satVarOrder == null ) {
				satVarOrder = new String[domainTable.length];//featureModel.countFeatures()];
				
				FTTraversalNodeSelector selector = new FTTraversalNodeSelector() {
					public boolean select(FeatureTreeNode node) {
						if ( node instanceof FeatureGroup )
							return false;
						return true;
					}
				};
				
				int index=0;				
				for( FeatureTreeNode node : FTTraversals.dfs(featureModel.getRoot(), selector)) {
					satVarOrder[index++] = node.getID();
				}
				satOrderObj = new StaticVariableOrderSAT(satVarOrder, false, varName2IndexMap, varIndex2NameMap);
			}

			int valueOrder[] = new int[satVarOrder.length];
//				System.out.print("      SAT Variable/Value Order: ");
			for( int i = 0 ; i < valueOrder.length ; i++ ) {
				valueOrder[i] = testValues.length==1 ? testValues[0] : (domainTable[getVariableIndex(satVarOrder[i])-1][0] == UNKNOWN ? 0 : 1);
//					System.out.print(varOrder[i] + ": {" + (valueOrder[i]==1) +"} ,");
			}		
//				System.out.println("");
			satOrderObj.setValueOrder(valueOrder);
			setVariableOrderObject(satOrderObj);
		}
		
	}
}






