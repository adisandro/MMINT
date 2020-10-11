package splar.apps.generator;

import java.io.File;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import org.sat4j.specs.ContradictionException;


import splar.core.constraints.CNFGenerator;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelStatistics;
import splar.core.fm.randomization.Random3CNFFeatureModel;
import splar.plugins.reasoners.sat.sat4j.FMReasoningWithSAT;


public class FMGeneratorEngine{

	private List<FMGeneratorEngineListener> listeners;
	
	CNFGenerator cnfGenerator;
	
	String collectionName = "undefinedCollectionName";
	int modelSize = 100;
	int ECR = 0;
	int ECRRange = 2;  // accept ECRs of ECR +/- ECRRange, e.g., [20-2, 20+2] 
	int ECR_comp = 0;  // when ECR of models is consistently lower/higher than ECR, use ECR_comp to adjust 
	int startIndex = 1;
	int endIndex = 10; 	
	int genSAT = 1;  // -1: UNSAT, 1: SAT, 0: doesn't matter
	// percentage of variables to be considered for generating 3-CNF clauses
	int percVar3cnf = 100;
	// percentage of the 2-CNF clauses to be extended to 3-CNF
	int percForm3cnf = 100;  
	// clause density for 3-CNF clauses
	float clauseDensity = 3f;  // 0 if you don't mind, hard SAT instances between 3.42 and 4.506 
	String modelPath = "";
	
	int percentageOptional = 25;
	int percentageMandatory = 25;
	int percentageExclusiveOR = 25;
	int percentageInclusiveOR = 25;	
	
	int minBranchingFactor = 1;
	int maxBranchingFactor = 6;
	
	int maxGroupSize = 5;
	
	boolean canceled = false;
	
	DecimalFormat format2 = new DecimalFormat("0.0");
	DecimalFormat format3 = new DecimalFormat("0.00");
	
	public FMGeneratorEngine() {
		listeners = new LinkedList<FMGeneratorEngineListener>();
	}
	
	public void addListener(FMGeneratorEngineListener listener) {
		listeners.add(listener);
	}
	
	public void fireEvent(String event, String modelName, String message) {
		for( FMGeneratorEngineListener listener : listeners ) {
			if ( event.equalsIgnoreCase("modelGenerationStarted") ) {
				listener.modelGenerationStarted();
			}
			else if ( event.equalsIgnoreCase("modelGenerationEnded") ) {
				listener.modelGenerationEnded();				
			}
			else if ( event.equalsIgnoreCase("generatingModel") ) {
				listener.generatingModel(modelName);				
			}
			else if ( event.equalsIgnoreCase("doneGeneratingModel") ) {
				listener.doneGeneratingModel(modelName);				
			}
			else if ( event.equalsIgnoreCase("modelAccepted") ) {
				listener.modelAccepted(modelName);				
			}
			else if ( event.equalsIgnoreCase("modelRejected") ) {
				listener.modelRejected(modelName, message);				
			}
			else if ( event.equalsIgnoreCase("modelIsUnsat") ) {
				listener.modelIsUnsat(modelName);
			}
			else if ( event.equalsIgnoreCase("modelIsSat") ) {
				listener.modelIsSat(modelName);
			}
			else if ( event.equalsIgnoreCase("errorDuringGeneration") ) {
				listener.errorDuringGeneration(modelName, message);
			}
			else if ( event.equalsIgnoreCase("generationCanceled") ) {
				listener.generationCanceled();
			}
		}
	}
	
	private void prepare() {
		if ( collectionName.trim().isEmpty() ) {
			collectionName = "undefinedCollectionName";
		}
//		modelName = collectionName + "-FM-3CNF-"+modelSize+"-" + ECR;
		canceled = false;
		cnfGenerator = new CNFGenerator();
	}
	
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;		
	}
	
	public void setCollectionPath(String path) {
		this.modelPath = path;
		if ( !path.endsWith("\\")) {
			this.modelPath += "\\";
		}
	}
	
	public void setCollectionSize(int size) {
		this.startIndex = 1;
		this.endIndex = size;
	}
	
	public void setFeatureModelSize(int size) {
		this.modelSize = size;
	}
	
	public void setMandatoryPercentage(int percentage) {
		percentageMandatory = percentage;
	}

	public void setOptionalPercentage(int percentage) {
		percentageOptional = percentage;
	}

	public void setExclusiveORPercentage(int percentage) {
		percentageExclusiveOR = percentage;
	}

	public void setInclusiveORPercentage(int percentage) {
		percentageInclusiveOR = percentage;
	}

	public void setMinimumBranchingFactor(int minBranchingFactor) {
		this.minBranchingFactor =  minBranchingFactor;
	}

	public void setMaximumBranchingFactor(int maxBranchingFactor) {
		this.maxBranchingFactor =  maxBranchingFactor;
	}

	public void setMaximumGroupSize(int maxGroupSize) {
		this.maxGroupSize =  maxGroupSize;
	}

	public void setCTCR(int CTCR) {
		this.ECR = CTCR;
	}
	
	public void setCTCRTolerance(int CTCRTolerance) {
		this.ECRRange = CTCRTolerance;
	}

	public void setClauseDensity(float clauseDensity) {
		this.clauseDensity = clauseDensity;
	}

	public void setModelConsistency(int consistency) {
		this.genSAT = consistency;
	}
	
	public void cancel() {
		canceled = true;
	}
	
	public void run() {
		
		fireEvent("modelGenerationStarted", "", "");

		prepare();
		
		FeatureModel fm = null;
		FeatureModelStatistics stats = null;
		for( int index = startIndex ; index <= endIndex && !canceled; ) {

//			System.out.println("------------------------------------------------");
//			System.out.println("Generating model: " + modelName + "-" + index + " ...");
			
			String modelIndex = "#"+index;
			
			try {
				fireEvent("generatingModel", modelIndex, "");
				fm = generateFeatureModel(index, modelSize, ECR/100.0, clauseDensity);				
				fireEvent("doneGeneratingModel", modelIndex, "");
			}
			catch( Exception e ) {
//				System.out.println("Oops, exception, trying again :-)");
//				e.printStackTrace();
				fireEvent("errorDuringGeneration", modelIndex, e.getMessage());
				continue;   
			}
			
			stats = new FeatureModelStatistics(fm);
			stats.update();
						
			try {
				boolean modelIsSAT = false;
				try {
					modelIsSAT = isSAT(fm);	
				}
				catch(ContradictionException ce) {
					modelIsSAT = false;
				}

				String modelName = getModelName(modelIsSAT, index);
				
				// must be UNSAT
				if ( genSAT == -1 ) {
					if (modelIsSAT) {
						fireEvent("modelRejected", modelIndex, "Model is CONSISTENT");
						fireEvent("modelIsSat", modelIndex, "");
						continue;
					}
					fireEvent("modelIsUnsat", modelIndex, "");
				}			
				// must be SAT
				else if ( genSAT == 1 ) {
					if (!modelIsSAT) {
						fireEvent("modelRejected", modelIndex, "Model is INCONSISTENT");
						fireEvent("modelIsUnsat", modelIndex, "");
						continue;
					}
					fireEvent("modelIsSat", modelIndex, "");
				}
				
				fm.setName(modelName);
				saveFeatureModel(fm, stats, modelPath + modelName + ".xml");
//				System.out.println("done! [ECR=" + stats.getECRepresentativeness() + "]");
				
				fireEvent("modelAccepted", modelName, "");
				fireEvent("doneGeneratingModel", modelName, "");
				
				index++;
			}
			catch (Exception e) {
				fireEvent("errorDuringGeneration", modelIndex, e.getMessage());
			}
			
		}

		if ( canceled ) {
			fireEvent("generationCanceled", "", "");
		}
		else {
			fireEvent("modelGenerationEnded", "", "");
		}
		
	}
	
	private String getModelName(boolean isSAT, int index) {
		return collectionName + "-3CNF-FM-" + modelSize + "-" + (int)((ECR/100.0)*modelSize) + "-" + format3.format(clauseDensity) + "-" + (isSAT ? "SAT-" : "UNSAT-") + index;
	}
	
	public boolean isSAT(FeatureModel fm) throws Exception {
//		System.out.println("Checking satisfiability...");
		FMReasoningWithSAT r = new FMReasoningWithSAT("MiniSAT",fm, 60000);
		long start = System.nanoTime();
		r.init();	
//		System.out.println("Time: " + ((System.nanoTime()-start)/1E6));
		return r.isConsistent();
	}	
	
	private void saveFeatureModel(FeatureModel fm, FeatureModelStatistics stats, String location) {
		
		File file = new File(location);
				
		PrintStream stream = null;
		PrintStream standartOut = System.out;
		try {
			stream = new PrintStream(location);
			System.setOut(stream);
			fm.dumpXML();
			System.out.println("<!--");
			stats.dump();
			System.out.println("*************************************************************");
			System.out.println("CROSS-TREE CONSTRAINTS (Random 3-CNF Formula)");
			System.out.println("  CTC Representativeness (CTCR): " + format2.format(stats.getECRepresentativeness()*100) + "%");
			System.out.println("  Number of 3-CNF clauses......: " + stats.countConstraints());
			System.out.println("  CTC clause density specified.: " + format3.format(clauseDensity));
			System.out.println("*************************************************************");
			System.out.println("-->");
			System.setOut(standartOut);
			stream.flush();
			stream.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public FeatureModel generateFeatureModel(int index, int fmSize, double ECR, double density) throws Exception {
		Random3CNFFeatureModel fm = 
			new Random3CNFFeatureModel( "", 
					modelSize, 
					percentageMandatory, 
					percentageOptional, 
					percentageInclusiveOR, 
					percentageExclusiveOR, 
					minBranchingFactor, 
					maxBranchingFactor, 
					maxGroupSize, 0
			);
		fm.loadModel();			
		fm.createCrossTreeConstraintsAsRandom3CNFFormula((int)(ECR * fmSize), clauseDensity);			
		return fm;
	}
	
}



//fm = new RandomFeatureModel2( modelName+"-"+index, modelSize, 
//percentageMandatory, percentageOptional, percentageInclusiveOR, percentageExclusiveOR, 
//minBranchingFactor, maxBranchingFactor, maxGroupSize, 0);
//fm.loadModel();
//if ( ECR > 0 ) {
//int ecVar = (int)(modelSize * ((ECR+ECR_comp)/100.0));
////				RandomFeatureModel2.createExtraConstraints(fm, ecVar, ecVar/2, 2, new int[][] {{1,20,100,80},{20,20,100,100},{40,30,90,100},{60,30,90,100}});
//RandomFeatureModel2.createExtraConstraints(fm, ecVar, ecVar, 2, new int[][] {{1,30,100,90},{10,40,90,90},{30,30,90,90}}, percVar3cnf, percForm3cnf);
////				RandomFeatureModel2.createExtraConstraints(fm, ecVar, ecVar, 2, new int[][] {{1,50,100,100},{10,50,100,100}}, percVar3cnf, percForm3cnf);				
//if ( percForm3cnf > 0 ) {
//RandomFeatureModel2.expand3CNFClauses(fm, clauseDensity, "C-3CNF-");
//}
//}


//RandomFeatureModel2.createExtraConstraints(fm, ecVar, ecVar/2, 2, new int[][] {{1,50,100,90},{30,50,100,100}});				
