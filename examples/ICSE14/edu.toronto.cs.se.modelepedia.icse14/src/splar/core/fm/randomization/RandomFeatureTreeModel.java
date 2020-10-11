package splar.core.fm.randomization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.GroupedFeature;
import splar.core.fm.RootNode;
import splar.core.fm.SolitaireFeature;
import splar.core.fm.TreeNodeRendererFactory;


public class RandomFeatureTreeModel extends FeatureModel {

	private int numberOfFeatures;   // total number of features in the feature model not counting feature group nodes
	private int childFeaturesOdds;  // max number of children for a given node (opt, mand, and group count as one) 
	private int minChildFeature;    // min number of children for a given node (opt, mand, and group count as one)
	private int solitaireOdds;      // odds for solitaire features
	private int groupOdds;          // odds for feature groups
	private int minGroupCard;       // min number of grouped features in a group
	private int maxGroupCard;       // max number of grouped features in a group
	
	public RandomFeatureTreeModel(int numberOfFeatures, int solitaireOdds, int groupOdds, int minChildFeature, int minGroupCard, int maxGroupCard) {
		super();
		
		// feature tree parameters
		this.numberOfFeatures = numberOfFeatures;
		this.childFeaturesOdds = solitaireOdds + groupOdds;
		this.minChildFeature = minChildFeature;
		this.solitaireOdds = solitaireOdds;
		this.groupOdds = groupOdds;
		this.minGroupCard = minGroupCard;
		this.maxGroupCard = maxGroupCard;
	}

	protected FeatureTreeNode createNodes() throws FeatureModelException {				
		
		int countFeatures = 1;
		Vector<FeatureTreeNode> fmNodes = new Vector<FeatureTreeNode>();
		
		String featureName = "R";
		countFeatures++;
		
		RootNode root = new RootNode( featureName, featureName, TreeNodeRendererFactory.createRootRenderer());
		fmNodes.add(root);				
		FeatureTreeNode parentNode = null;
		
		while ( countFeatures <= numberOfFeatures ) {
			
			parentNode = fmNodes.firstElement();
			fmNodes.removeElement(parentNode);
									
			int numberOfChildNodesToCreate = Math.min(numberOfFeatures-countFeatures+1, (Math.abs(new Random().nextInt())%(childFeaturesOdds-minChildFeature+1))+minChildFeature);
			
			// prevents an early end of the recursion when all nodes happen to have no children 
			if ( numberOfChildNodesToCreate == 0 ) {
				if ( fmNodes.size() == 0 ) {
					numberOfChildNodesToCreate = 1;
				}
			}
			
			if ( numberOfChildNodesToCreate > 0 ) {			
				for( int i = 0 ; i < numberOfChildNodesToCreate && countFeatures <= numberOfFeatures ; i++ ) {
					String childFeatureName = parentNode.getID().substring(1) + (i+1);
					FeatureTreeNode randomNode = createRandomNode(childFeatureName,solitaireOdds, groupOdds, minGroupCard, maxGroupCard);
					parentNode.add(randomNode);
					if ( randomNode instanceof FeatureGroup ) {
						FeatureGroup groupRandomNode = (FeatureGroup)randomNode;
						int countGroupedNodes = groupRandomNode.getChildCount();
						for( int j = 0 ; j < countGroupedNodes ; j++ ) {
							fmNodes.add((FeatureTreeNode)groupRandomNode.getChildAt(j));
						}
						countFeatures += (countGroupedNodes);
					}
					else {
						fmNodes.add(randomNode);
						countFeatures++;
					}							
				}
			}
		}
		
		return root;
	}

	private FeatureTreeNode createRandomNode(String childFeatureName, int solitaireOdds, int groupOdds, int minGroupCard, int maxGroupCard) {

		int solitaireOrGroupRandom = (new Random().nextInt()%childFeaturesOdds)+1;
		
		FeatureTreeNode node = null;
		String featureName = "";
		
		// should create a solitaire feature (optional/mandatory)?
		if ( solitaireOrGroupRandom <= solitaireOdds ) {
			featureName = "S" + childFeatureName;
			// 50% odds for mandatory and optional features
//			int solitaireOptorMandRandom = (new Random().nextInt()%2);
			// should create an optional feature?
//			if ( solitaireOptorMandRandom == 0 ) {
		        node = new SolitaireFeature( true, featureName, featureName, TreeNodeRendererFactory.createOptionalRenderer());
//			}
//			 should create a mandatory feature?
//			else  {
//		        node = new SolitaireFeature( true, featureName, featureName, TreeNodeRendererFactory.createMandatoryRenderer());
//			}						
		}
		// should create a feature group?
		else {
			// number of grouped features
			int groupSize = (Math.abs(new Random().nextInt())%(maxGroupCard-minGroupCard+1))+minGroupCard;
			// 50% odds for [1..*] and [1] group cardinality
			int groupTypeOdds = (new Random().nextInt()%2);
			// [1..*] or [1] cardinality
			int lower = 1;
			int upper = 1;
			if ( groupTypeOdds == 0 ) {  // [1..*] = [1,-1]
				upper = -1;
			}
			
			String groupName = "_G" + childFeatureName;;
			// create group parent node
			node = new FeatureGroup( groupName, groupName, lower,upper,TreeNodeRendererFactory.createFeatureGroupRenderer() );

			// create grouped feature nodes
			for( int i = 0 ; i < groupSize ; i++ ) {
				featureName = "g" + childFeatureName + (i+1);
		        node.add( new GroupedFeature( featureName, featureName, TreeNodeRendererFactory.createGroupedRenderer() ));		        
			}
		}
		
		return node;
	}

	public static Vector<PropositionalFormula> createExtraConstraints(FeatureModel fm, int numVars, int numConstraints, int minVarsLeft, int maxVarsLeft, int minVarsRight, int maxVarsRight) {
		Vector<PropositionalFormula> pfs = new Vector<PropositionalFormula>();
		
		if ( fm != null ) {
			if ( numConstraints > 0 && numVars > 1) {
				ArrayList<BooleanVariableInterface> vars = chooseVariablesForConstraints(fm, numVars);
				
				int varIndex = 0;
				for( int i = 0 ; i < numConstraints ; i++ ) {
					
					String constraint = "";
					int leftVarsToPick = (new Random().nextInt()%(maxVarsLeft-minVarsLeft+1))+minVarsLeft;
					int RightVarsToPick = (new Random().nextInt()%(maxVarsRight-minVarsLeft+1))+minVarsRight;
					
					int leftOp = new Random().nextInt()%2;    // 0 = OR, 1 = AND
					int RightOp = new Random().nextInt()%2;   
					
					String v;
					int form;
					
					constraint += "(";
					for( int j = 0 ; j < leftVarsToPick-1 ; j++ ) {
						v = vars.get(varIndex).getID();
						form = new Random().nextInt()%2;    // 0 = positive, 1 = negative
						if ( form == 0 ) {
							constraint += "" + v; 
						}
						else {
							constraint += "~" + v; 
						}
						if (leftOp == 0) {
							constraint += " OR "; 
						}
						else {
//							constraint += " AND ";
							constraint += " OR ";  // enforce CNF
						}
						varIndex = (varIndex < (numVars-1) ? varIndex+1 : 0);
						if ( varIndex == 0 ) scrumbleVars(vars);
					}
					v = vars.get(varIndex).getID();
					form = new Random().nextInt()%2;    // 0 = positive, 1 = negative
					if ( form == 0 ) {
						constraint += "" + v; 
					}
					else {
						constraint += "~" + v; 
					}
//					constraint += ") IMP (";					
					constraint += ") OR ("; // enforce CNF
					
					varIndex = (varIndex < (numVars-1) ? varIndex+1 : 0);
					if ( varIndex == 0 ) scrumbleVars(vars);
					for( int j = 0 ; j < RightVarsToPick-1 ; j++ ) {
						v = vars.get(varIndex).getID();
						form = new Random().nextInt()%2;    // 0 = positive, 1 = negative
						if ( form == 0 ) {
							constraint += "" + v; 
						}
						else {
							constraint += "~" + v; 
						}
						if (RightOp == 0) {
							constraint += " OR "; 
						}
						else {
//							constraint += " AND ";   // enforce CNF
							constraint += " OR ";
						}
						varIndex = (varIndex < (numVars-1) ? varIndex+1 : 0);
						if ( varIndex == 0 ) scrumbleVars(vars);
					}
					v = vars.get(varIndex).getID();
					form = new Random().nextInt()%2;    // 0 = positive, 1 = negative
					if ( form == 0 ) {
						constraint += "" + v; 
					}
					else {
						constraint += "~" + v; 
					}
					constraint += ")";
					varIndex = (varIndex < (numVars-1) ? varIndex+1 : 0);
					if ( varIndex == 0 ) scrumbleVars(vars);
					try {
						pfs.add(new PropositionalFormula("C"+(i+1),constraint));
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
						
		}
		
		return pfs;		
	}
	
	private static void scrumbleVars(ArrayList<BooleanVariableInterface> vars) {
		int numVars = vars.size();
		for( int i = 0 ; i < numVars ; i++ ) {
			int index = Math.abs(new Random().nextInt()%numVars);
			BooleanVariableInterface temp = vars.get(index);
			vars.set(index, vars.get(i));
			vars.set(i, temp);
		}
//		System.out.println("scrambled ==>");
//		for( int i = 0 ; i < numVars ; i++ ) {
//			System.out.print(vars.get(i).getName()+",");
//		}
//		System.out.println("");
	}
	
	private static ArrayList<BooleanVariableInterface> chooseVariablesForConstraints(FeatureModel fm, int numVars) {
		ArrayList<BooleanVariableInterface> vars = new ArrayList<BooleanVariableInterface>(numVars);
		Collection<FeatureTreeNode> nodes = fm.getNodes();
		int numNodes = nodes.size();
		int varsGen = 0;
		
		while( varsGen < numVars ) {
			int random = Math.abs(new Random().nextInt()%numNodes);
			Iterator<FeatureTreeNode> it = nodes.iterator();
			for( int i = 0 ; i < (random-1) ; i++ ) {
				it.next();
			}
			FeatureTreeNode node = it.next();
			if ( !(node instanceof FeatureGroup) && !(node instanceof RootNode) ) {
				if ( !vars.contains(node) ) {
					vars.add(node);
					varsGen++;
				}
			}
		}
//		System.out.println("choosen ==>");
//		for( int i = 0 ; i < vars.size() ; i++ ) {
//			System.out.print(vars.get(i).getName()+",");
//		}
//		System.out.println("");
		return vars;
	}
	
	public void saveNodes() {}
}

