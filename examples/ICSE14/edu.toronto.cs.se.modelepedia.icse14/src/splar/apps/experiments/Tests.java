package splar.apps.experiments;

import java.util.HashMap;
import java.util.List;

import org.sat4j.specs.ContradictionException;

import splar.core.fm.FeatureModel;
import splar.core.fm.XMLFeatureModel;
import splar.core.heuristics.FTPreOrderSortedECTraversalHeuristic;
import splar.core.heuristics.VariableOrderingHeuristic;
import splar.core.heuristics.VariableOrderingHeuristicsManager;
import splar.plugins.reasoners.bdd.javabdd.FMReasoningWithBDD;
import splar.plugins.reasoners.bdd.javabdd.ReasoningWithBDD;
import splar.plugins.reasoners.sat.sat4j.FMReasoningWithSAT;

public class Tests {

	public static void main(String args[]) {
		new Tests().init();
	}
	
	public void init() {
		try {
			
			FeatureModel featureModel = new XMLFeatureModel("c:\\users\\marcilio\\eclipse\\SPLAR\\resources\\apagme.xml");
			featureModel.loadModel();

//			String jsonString = "{ \"feature_model_name\" : \"\", \"feature_diagram\" : [[\"_r\",\"carro\",\"root\",\"\"],[\"_r_1\",\"motor\",\"mandatory\",\"_r\"],[\"_r_1_2\",\"[1..1]\",\"xor\",\"_r_1\"],[\"_r_1_2_3\",\"gasolina\",\"grouped\",\"_r_1_2\"],[\"_r_1_2_4\",\"alcool\",\"grouped\",\"_r_1_2\"],[\"_r_1_2_5\",\"diesel\",\"grouped\",\"_r_1_2\"],[\"_r_6\",\"air bag\",\"optional\",\"_r\"],[\"_r_7\",\"leather seats\",\"optional\",\"_r\"],[]],\"crosstree_constraints\" : {\"constraint_1\" : [\"~_r_1_2_5\",\"_r_7\"], \"constraint_2\" : [\"~_r_6\",\"~_r_7\"], \"\":[]}, \"additional_information\" : {\"fm_description\" : \"\",\"fm_author\" : \"\",\"fm_author_address\" : \"\",\"fm_author_email\" : \"\",\"fm_author_phone\" : \"\",\"fm_author_website\" : \"\",\"fm_author_organization\" : \"\",\"fm_author_department\" : \"\",\"fm_creation_date\" : \"\",\"fm_publication\" : \"\"}}";
//			FeatureModel featureModel = new JSONFeatureModel(jsonString);
//			featureModel.loadModel();
//			
//			FMReasoningWithSAT reasoner = new FMReasoningWithSAT("MiniSAT", featureModel, 60000);
// 	       	// SAT-based analysis
// 	       	boolean isConsistent = true;
// 	       	try {
//     	       	reasoner.init();
// 	 	       	isConsistent = reasoner.isConsistent();
//			} catch (ContradictionException e) {
//				isConsistent = false;
//			}
//			
// 	       	List<String> deadFeatures = reasoner.allDeadFeatures(new HashMap<String, String>());
// 	       	List<String> coreFeatures = reasoner.allCoreFeatures(new HashMap<String, String>());
// 	       	
// 	       	System.out.println(deadFeatures);
// 	       	System.out.println(coreFeatures);
 	       	
 	       	featureModel.dumpXML();			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
