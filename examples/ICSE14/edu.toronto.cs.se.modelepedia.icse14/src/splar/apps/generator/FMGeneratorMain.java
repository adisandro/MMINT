package splar.apps.generator;

import java.util.Random;

import javax.swing.JFrame;

/*------------------------------------------
 * SPLOT FEATURE MODEL GENERATOR, SEPT 2009
 * -----------------------------------------
 * This Software generates 3-CNF Feature Models 
 * See paper "SAT-Based Analysis of Feature Models is Easy" from Marcilio Mendonca et. al for details
 * 
 * Marcilio Mendonca
 * School of Computer Science
 * University of Waterloo
 * 
 * September 2009
 */

public class FMGeneratorMain implements FMGeneratorGUIListener, FMGeneratorEngineListener {

	FMGeneratorGUI gui = null;
	FMGeneratorEngine engine = null;
	
	public static void main(String args[]) {
		
		
//		double density = 5;
//		int v = 100;
//		int numbers[] = new int[v];
//		
//		for( int i = 0 ; i < (int)(v*density) ; i++ ) {
//			numbers[Math.abs(new Random().nextInt())%v]++;
//		}
//		
//		int count = 0;
//		for( int i = 0 ; i < v ; i++ ) {
//			if (numbers[i] == 0 )
//				count++;
//			System.out.println("v[" + i +"] = " + numbers[i]);
//		}
//		System.out.println("Non-assigned: " + count);
		
//		CNFGenerator gen = new CNFGenerator();		
//		List<BooleanVariableInterface> variables = new LinkedList<BooleanVariableInterface>();
//		variables.add( new BooleanVariable("a"));
//		variables.add( new BooleanVariable("b"));
//		variables.add( new BooleanVariable("c"));
//		variables.add( new BooleanVariable("d"));
//		variables.add( new BooleanVariable("e"));
//		List<CNFClause> clauses = gen.generateCNFInstance(variables, null, 0.5f, 3);
//		Set<BooleanVariableInterface> varset = new HashSet<BooleanVariableInterface>();
//		for( CNFClause clause : clauses ) {
//			System.out.println(clause);
//			for( BooleanVariableInterface clauseVar : clause.getVariables() ) {
//				varset.add(clauseVar);				
//			}
//		}		
//		System.out.println("% used vars: " + (varset.size()*100.0)/variables.size());
		
		new FMGeneratorMain().run();
	}
	
	public void run() {
		gui = new FMGeneratorGUI("SPLOT 3-CNF Feature Model Generator - Marcilio Mendonca - Sept 2009 (alfa version) - (www.splot-research.org)");
		gui.setSize(600,700);
		gui.setLocation(0,0);
		gui.setVisible(true);
		gui.addListener(this);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		engine = new FMGeneratorEngine();
		engine.addListener(this);
	}
	
	private void dumpEngineParameters() {
		gui.addMessage("Collection name......: " + gui.getCollectionName());
		gui.addMessage("Collection path......: " + gui.getCollectionPath());
		gui.addMessage("Collection size......: " + gui.getCollectionSize());
		gui.addMessage("FT size (# features).: " + gui.getFeatureTreeSize());
		gui.addMessage("FT % Mandatory.......: " + gui.getFeatureTreeMandatoryPercentage());
		gui.addMessage("FT % Optional........: " + gui.getFeatureTreeOptionalPercentage());
		gui.addMessage("FT % XOR groups......: " + gui.getFeatureTreeExclusiveORPercentage());
		gui.addMessage("FT % OR groups.......: " + gui.getFeatureTreeInclusiveORPercentage());
		gui.addMessage("FT Min Branch. Factor: " + gui.getFeatureTreeMinBranchingFactor());
		gui.addMessage("FT Max Branch. Factor: " + gui.getFeatureTreeMaxBranchingFactor());
		gui.addMessage("FT Max Group Size....: " + gui.getFeatureTreeMaxFeatureGroupSize());
		gui.addMessage("CTCR.................: " + gui.getCTCR());
//		gui.addMessage("CTCR tolerance.......:" + gui.getCTCRange());
		gui.addMessage("CTC Clause Density...:" + gui.getCTCClauseDensity());
		gui.addMessage("Consistency Option...: " + gui.getConsistentyOption());		
	}
	
	private void runGeneratorEngine() {
		engine.setCollectionName(gui.getCollectionName());
		engine.setCollectionPath(gui.getCollectionPath());
		engine.setCollectionSize(gui.getCollectionSize());
		engine.setFeatureModelSize(gui.getFeatureTreeSize());
		engine.setMandatoryPercentage(gui.getFeatureTreeMandatoryPercentage());
		engine.setOptionalPercentage(gui.getFeatureTreeOptionalPercentage());
		engine.setExclusiveORPercentage(gui.getFeatureTreeExclusiveORPercentage());
		engine.setInclusiveORPercentage(gui.getFeatureTreeInclusiveORPercentage());
		engine.setMinimumBranchingFactor(gui.getFeatureTreeMinBranchingFactor());
		engine.setMaximumBranchingFactor(gui.getFeatureTreeMaxBranchingFactor());
		engine.setMaximumGroupSize(gui.getFeatureTreeMaxFeatureGroupSize());
		engine.setCTCR(gui.getCTCR());
//		engine.setCTCRTolerance(gui.getCTCRange());
		engine.setClauseDensity(gui.getCTCClauseDensity());
		engine.setModelConsistency(gui.getConsistentyOption());		
        engine.run();
	}
	
	public void startGeneration(FMGeneratorGUIEvent event) {
		try {
			new Thread(
				    new Runnable(){
				        public void run(){
				    		gui.disableGeneration();
				    		gui.enableCancelGeneration();
				        	gui.clearMessages();
				            
				        	long startTime = System.currentTimeMillis();

				            dumpEngineParameters();
				            runGeneratorEngine();
				            
				            gui.addMessage(">> Generation Time: " + (System.currentTimeMillis()-startTime)/1000 + " seg");
				            
				    		gui.disableCancelGeneration();
				    		gui.enableGeneration();
				        }
				    }
				).start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cancelGeneration() {
		gui.disableCancelGeneration();
		engine.cancel();
		gui.enableGeneration();
	}
	
	public void generatingModel(String modelName) {
		gui.setMessage("Generating model: " + modelName);
	}
	
	public void doneGeneratingModel(String modelName) {
		
	}
	
	public void modelAccepted(String modelName) {
		gui.addMessage(">> Model generated: " + modelName);
	}
	
	public void modelRejected(String modelName, String reason) {
		gui.addMessage("Model rejected: " + modelName + " (reason = " + reason + " )");
	}
	
	public void modelGenerationStarted() {
		
	}
		
	public void modelGenerationEnded() {
		gui.setMessage("Done!");
	}
		
	public void modelIsUnsat(String modelName) {
		
	}
		
	public void modelIsSat(String modelName) {
		
	}
		
	public void errorDuringGeneration(String modelName, String errorMessage) {
		
	}
		
	public void generationCanceled() {
		gui.addMessage("Generation canceled by user");
		gui.setMessage("Generation canceled by user");
	}

}
