package splar.samples;

import java.util.HashMap;
import java.util.Map;


import splar.core.fm.FeatureModel;
import splar.core.fm.XMLFeatureModel;
import splar.plugins.reasoners.sat.sat4j.FMReasoningWithSAT;



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
 * This class illustrates how to use a SAT reasoner to reason on a feature model
 */
public class SATReasoningExample {

	public static void main(String args[]) {
		new SATReasoningExample().run();
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

			// SAT reasoner construction parameters
			// - "MiniSAT" - name of the SAT4J solver used
			// - Timeout parameter
			int SATtimeout = 60000;  	// 1 minute is given to the SAT solver to check the consistency of the feature model  
			
			FMReasoningWithSAT reasoner = new FMReasoningWithSAT("MiniSAT", featureModel, SATtimeout);

			// Initialize the reasoner
			reasoner.init();
			
			// Use the reasoner			
						
			// Check if feature model is consistent, i.e., has at least one valid configuration
			System.out.println("Feature model is " + (reasoner.isConsistent() ? "" : " NOT ") + "consistent!");
			
			// Compute dead, common, and valid domains, i.e., for each feature check whether the feature can be 
			// only true, only false, or (true or false)
			
			Map<String,String> stats = new HashMap<String,String>();
			Map<String,Boolean[]> domainTable = reasoner.allValidDomains(stats);			
			
			System.out.println("Domains ---------------------");
			int countCommon = 0, countDead = 0;
			for( String featureId : domainTable.keySet() ) {				
				System.out.print( "- " + featureId + ": [");
				Boolean domain[] = domainTable.get(featureId);
				for( Boolean value : domain ) {
					System.out.print(value + " ");
				}
				System.out.print("]");				
				if ( domain.length == 1 && domain[0] == true ) {
					System.out.print(" (common)");
					countCommon++;
				}
				else if ( domain.length == 1 && domain[0] == false ) {
					System.out.print(" (dead)");
					countDead++;
				}
				System.out.println();
			}

			System.out.println("Stats ---------------------");
			System.out.println("- Total Common Features.: " + countCommon);
			System.out.println("- Total Dead Features...: " + countDead);
			System.out.println("- Running Time..........: " + stats.get("processing-time"));
			System.out.println("- Number of SAT Checks..: " + stats.get("sat-checks"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
