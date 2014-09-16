package splar.samples;

import splar.core.fm.FeatureModel;
import splar.core.fm.XMLFeatureModel;
import splar.core.heuristics.FTPreOrderSortedECTraversalHeuristic;
import splar.core.heuristics.VariableOrderingHeuristic;
import splar.core.heuristics.VariableOrderingHeuristicsManager;
import splar.plugins.reasoners.bdd.javabdd.FMReasoningWithBDD;
import splar.plugins.reasoners.bdd.javabdd.ReasoningWithBDD;


/**
 * SPLAR library - Feature Model Reasoning and Configuration API
 * SPLOT portal - Software Product Lines Online Tools (www.splot-research.org)
 * 
 * ***************************************************************************
 *  
 * @author Marcilio Mendonca
 * University of Waterloo, Canada
 * July, 2009
 *
 * This class illustrates how to use a BDD reasoner to reason on a feature model
 */
public class BDDReasoningExample {

	public static void main(String args[]) {
		new BDDReasoningExample().run();
	}
	
	public void run() {

		try {
			
			// Feature model path
			String featureModelPath = "c:\\users\\marcilio\\eclipse\\fmrlib\\resources\\fm_samples\\simple_bike_fm.xml";
			
			// Create feature model object from an XML file (SXFM format - see www.splot-research.org for details)	
			// If an identifier is not provided for a feature use the feature name as id
			FeatureModel featureModel = new XMLFeatureModel(featureModelPath, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
			// load feature model from 			
			featureModel.loadModel();			

			// create BDD variable order heuristic
			new FTPreOrderSortedECTraversalHeuristic("Pre-CL-MinSpan", featureModel, FTPreOrderSortedECTraversalHeuristic.FORCE_SORT);		
			VariableOrderingHeuristic heuristic = VariableOrderingHeuristicsManager.createHeuristicsManager().getHeuristic("Pre-CL-MinSpan");

			// BDD construction parameters
			// - Tuning this parameters can be tricky at times and may require playing a bit
			// - For the purpose of this example let's assume "large enough" values 
			int bddNodeNum = 10000;  	// sets the initial size of the BDD table  
			int bddCacheSize = 10000;  // sets the size of the BDD cache table
			
			// Creates the BDD reasoner
			ReasoningWithBDD reasoner = new FMReasoningWithBDD(featureModel, heuristic, 50000, 50000, 60000, "pre-order");
			
			// Initialize the reasoner (BDD is created at this moment)
			reasoner.init();
			
			// Use the reasoner			
			System.out.println("BDD has " + reasoner.getBDD().nodeCount() + " nodes and was built in " + reasoner.getBDDBuildingTime() + " ms");
			
			// Check if feature model is consistent, i.e., has at least one valid configuration
			System.out.println("Feature model is " + (reasoner.isConsistent()? "" : " NOT ") + "consistent!");
			
			// Count feature model solutions			
			System.out.println("Feature model has " + reasoner.countValidConfigurations() + " possible configurations");
			
			// Important:
			// - My research focused on heuristics to reduce the size of BDDs as much as possible 
			//  (e.g. I proposed the "Pre-CL-MinSpan" heuristic above) 
			//   Therefore, there are plenty of opportunities for improving the performance of many BDD reasoning operations provided
			//   I actually know the algorithms but need time to code them
			//   For now, use the BDD to check consistency of models and to count valid configurations
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
