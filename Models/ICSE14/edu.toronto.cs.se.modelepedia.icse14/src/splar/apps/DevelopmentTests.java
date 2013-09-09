package splar.apps;

import splar.core.fm.FeatureModel;
import splar.core.fm.XMLFeatureModel;
import splar.plugins.reasoners.sat.sat4j.FMReasoningWithSAT;

public class DevelopmentTests {

	public static void main(String args[]) {
		new DevelopmentTests().run();
	}
	
	public void run() {
		try {
			FeatureModel featureModelConsistent = new XMLFeatureModel("file:///c:\\users\\marcilio\\eclipse\\splar\\resources\\tests\\test_fm_consistent.xml", XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
			featureModelConsistent.loadModel();
			
			FMReasoningWithSAT reasoner = new FMReasoningWithSAT("MiniSAT", featureModelConsistent, 60000);
			reasoner.init();			
			
			reasoner.validDomain("b2");

			for( String name : reasoner.getVarName2IndexMap().keySet() ) {
				int index = reasoner.getVariableIndex(name);
				System.out.println( index + " : " + reasoner.getVariableName(index) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
