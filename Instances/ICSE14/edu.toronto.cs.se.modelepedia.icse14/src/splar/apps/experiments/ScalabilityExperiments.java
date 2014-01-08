package splar.apps.experiments;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.BDDFactory.ReorderMethod;
import splar.core.constraints.CNFFormula;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureModelStatistics;
import splar.core.fm.XMLFeatureModel;
import splar.core.heuristics.FORCEVariableOrderingHeuristic;
import splar.core.heuristics.FTPreOrderSortedECTraversalHeuristic;
import splar.core.heuristics.FTPreOrderTraversalHeuristic;
import splar.core.heuristics.VariableOrderingHeuristic;
import splar.core.heuristics.VariableOrderingHeuristicsManager;
import splar.plugins.reasoners.bdd.javabdd.FMReasoningWithBDD;
import splar.plugins.reasoners.bdd.javabdd.ReasoningWithBDD;

public class ScalabilityExperiments {


	public static void main(String args[]) {
		ScalabilityExperiments exp = new ScalabilityExperiments();
		String parms[] = args;
		if ( parms.length < 1 ) {
			parms= new String[1];
			parms[0] = "memory-overflow";
		}
		exp.init(parms);
	}

	String resultsOutputPath = "c:\\users\\marcilio\\eclipse\\4watreason\\experiments\\thesis\\analysis\\";
	String resultsOutputFileName = "scalability_results.txt";
	String restoreFilePath = "c:\\users\\marcilio\\eclipse\\4watreason\\experiments\\thesis\\scalability\\";
	String restoreFileName = "_restore.txt";
	String collectionPath = "c:\\users\\marcilio\\eclipse\\4watreason\\experiments\\thesis\\scalability\\files\\";
	CollectionData collections[] = createCollections();
	String heuristics[] = {"Pre-CL-MinSpan"};//, "Pre-CL-Size", "Pre"};

	boolean simplifyModels = true;
	
	int modelStartIndex = 4;
	
	long bddTimeout = 60 * 60000;
	int bddNodeNum = 5000000;
	int bddCacheSize = 1000000;
	double bddNodeTableIncreaseFactor = 0.20;  
	double bddMinimumGCFactor = 0.20;
	ReorderMethod reorderMethod = BDDFactory.REORDER_NONE;  

	int collectionCurIndex = 0;
	int heuristicCurIndex = 0; 
	int modelCurIndex = modelStartIndex;
	

	private CollectionData[] createCollections() {
		CollectionData[] collections = new CollectionData[1];
//		collections[0] = new CollectionData("FM-1000-SAT-20", 10);
//		collections[1] = new CollectionData("FM-1500-SAT-20", 10);
//		collections[0] = new CollectionData("FM-2000-SAT-20", 10);
		collections[0] = new CollectionData("FM-2500-SAT-20", 4);
//		collections[4] = new CollectionData("FM-3000-SAT-20", 10);
//		collections[5] = new CollectionData("FM-3500-SAT-20", 10);
//		collections[6] = new CollectionData("FM-4000-SAT-20", 10);
		return collections;
	}

	public void init(String args[]) {

		if ( restoreState(args[0]) ) {
			logLastFailure(collectionCurIndex);
			modelCurIndex++; // skip the failing model
		}
		
		initializeHeuristics(null);		
		
		for( int collectionIndex = collectionCurIndex ; collectionIndex < collections.length ; collectionIndex++ ) {
			for( int heuristicIndex = heuristicCurIndex ; heuristicIndex < heuristics.length ; heuristicIndex++ ) {
				for( int modelIndex = modelCurIndex ; modelIndex <= collections[collectionIndex].size ; modelIndex++ ) {

					String modelName = getModelToProcess(collectionIndex, modelIndex);
					String heurName = heuristics[heuristicIndex];
					System.out.println("-------------------------------------------------------" );
					System.out.println("Processing: [" + modelName + ", " + heurName + "]" );

					saveState(collectionIndex, heuristicIndex, modelIndex);

					TestData data = new TestData();
					data.heuristic = heurName;
					data.modelName = modelName;
					
//					if ( Math.abs(new Random().nextInt())% 5 == 0 ) {
//						System.exit(-1);
//					}
					
					FeatureModel fm = new XMLFeatureModel(collectionPath+modelName+".xml", XMLFeatureModel.SET_ID_AUTOMATICALLY);					
					try {
						fm.loadModel();
					} catch (FeatureModelException e) {
						e.printStackTrace();
					}
					FeatureModelStatistics stats = new FeatureModelStatistics(fm);
					stats.update();
					data.fmSize = stats.countFeatures();
					data.fmMan = stats.countMandatory();
					data.fmOpt = stats.countOptional();
					data.fmGrp1 = stats.countGrouped11();
					data.fmGrpn = stats.countGrouped1n();
					data.ecClauses = stats.countExtraConstraintCNFClauses();
					data.ECR = ((stats.countConstraintVars()*1.0)/data.fmSize);					
					data.simplified = 0;
					if ( simplifyModels ) {
						fm.shrink();
						stats.update();
						data.simplified = 1;
					}
					data.fmSizeSimp = stats.countFeatures();
			 		data.ECRSimp = ((1.0*stats.countConstraintVars())/data.fmSizeSimp);										

					VariableOrderingHeuristic heurObject = VariableOrderingHeuristicsManager.createHeuristicsManager().getHeuristic(heurName);
					heurObject.setParameter("feature_model", fm);
					heurObject.setParameter("start_node", "output");
					CNFFormula cnf = fm.FM2CNF();
					System.out.println(">> Running heuristic...");
					heurObject.run(cnf);
					data.heurTime = heurObject.getRunningTime();
					System.out.println(">> done! (" + data.heurTime +"ms)");

					
					ReasoningWithBDD reasoning = new FMReasoningWithBDD(fm, heurObject, bddNodeNum, bddCacheSize, bddTimeout, reorderMethod, "pre-order");
					try {
						System.out.println(">> Building BDD...");
						reasoning.init(); 
						data.timeout = 0;
						System.out.println(">> done! (" + reasoning.getBDD().nodeCount() + " BDD nodes - " + reasoning.getBDDBuildingTime() +"ms)");
					}
					catch (Exception e) {
						System.out.println(">>> Timeout: > " +bddTimeout);
						data.timeout = 1;
						System.out.println(">> done! (timed out!)");
					}					
					
					data.bddTime = reasoning.getBDDBuildingTime();
					data.bddSize = reasoning.getBDD().nodeCount();
					data.sifting = 0;
					data.span = cnf.calculateClauseSpan(VariableOrderingHeuristic.variableOrderingAsHashMap(heurObject.getVariableOrdering()));
					
					long tempTime = System.nanoTime();
					reasoning.getBDD().satCount();					
					data.timeToCountBDDSolutions = ((System.nanoTime()-tempTime)/1000000.0);
					
					
					logData(data, collectionIndex);
					
				}
				saveState(collectionIndex, heuristicIndex, collections[collectionIndex].size+1);
				modelCurIndex = modelStartIndex;
				if ( heuristicIndex < heuristics.length-1 ) {
					startNewHeuristicInLog(collectionIndex);
				}
			}
			heuristicCurIndex = 0;
		}
	
	}
	
    private void initializeHeuristics(FeatureModel featureModel) {
		new FTPreOrderTraversalHeuristic("Pre", featureModel);
//    	new Fujita88DFSCircuitTraversalHeuristic("Fuj-88", null, "output");
		new FTPreOrderSortedECTraversalHeuristic("Pre-CL-MinSpan", featureModel, FTPreOrderSortedECTraversalHeuristic.FORCE_SORT);		
		new FTPreOrderSortedECTraversalHeuristic("Pre-CL-Size", featureModel, FTPreOrderSortedECTraversalHeuristic.SIZE_SORT);
		new FORCEVariableOrderingHeuristic("FORCE", null, 1);		
//		new FORCEVariableOrderingHeuristic("Pre-CLS-FORCE", null, 1);
//		new FORCEVariableOrderingHeuristic("Pre-CLM-FORCE", null, 1);		
    }
	
	
	private String getModelToProcess(int collectionIndex, int modelIndex) {
		return collections[collectionIndex].name + "-" + modelIndex;
	}
	
	private String getOutputFileName(int collectionIndex) {
		return collections[collectionIndex].name + "-" + resultsOutputFileName;
	}
	
	private void startNewHeuristicInLog(int collectionIndex) {
		try {
			System.out.println("SPACES --------------");
			java.io.File file = new File(resultsOutputPath + getOutputFileName(collectionIndex));
			FileWriter writer = new FileWriter(file,true);
			writer.write("--\r\n--\r\n");			
			writer.close();
		}
		catch( IOException e2) {
			e2.printStackTrace();
		}				
		
	}
	
	private void logLastFailure(int collectionIndex) {
		try {
			java.io.File file = new File(resultsOutputPath + getOutputFileName(collectionIndex));
//			System.out.println(">> Logging failure data in " + file.getName() + "...");
			FileWriter writer = new FileWriter(file,true);
			String line = "";
			line += heuristics[heuristicCurIndex];
			line += ",";
			line += getModelToProcess(collectionCurIndex, modelCurIndex);			
			line += ",";
			line += "Memory Overflow";						
			writer.write(line+"\r\n");			
			writer.close();
			
		}
		catch( IOException e2) {
			e2.printStackTrace();
		}				
	}
	
	private void logData(TestData data, int collectionIndex) {
		try {
			java.io.File file = new File(resultsOutputPath + getOutputFileName(collectionIndex));
			System.out.println(">> Logging data in " + file.getName() + "...");
			FileWriter writer = new FileWriter(file,true);
			String line = "";
			line += data.heuristic;
			line += ",";
			line += data.modelName;
			line += ",";
			line += data.heurTime;
			line += ",";
			line += data.bddTime;
			line += ",";
			line += (data.bddTime+data.heurTime);
			line += ",";
			line += data.timeout;
			line += ",";
			line += data.fmSize;
			line += ",";
			line += data.fmSizeSimp;
			line += ",";
			line += data.simplified;
			line += ",";
			line += data.fmMan;
			line += ",";
			line += data.fmOpt;
			line += ",";
			line += data.fmGrp1;
			line += ",";
			line += data.fmGrpn;
			line += ",";
			line += data.ecClauses;
			line += ",";
			line += data.ECR;
			line += ",";
			line += data.ECRSimp;
			line += ",";
			line += data.bddTablePeek;
			line += ",";
			line += data.bddSizePeek;
			line += ",";
			line += data.sifting;
			line += ",";
			line += data.bddSize;
			line += ",";
			line += (data.bddSize/data.fmSize);
			line += ",";
			line += data.span;			
			line += ",";
			line += data.timeToCountBDDSolutions;
			writer.write(line+"\r\n");
			writer.close();
			
		}
		catch( IOException e2) {
			e2.printStackTrace();
		}				
	}
	
	// returns true if the program crashed in a previous run
	// or false if the program was manually stopped or never interrupted
	private boolean restoreState(String typeOfInterruption) {
		java.io.File file = new File(restoreFilePath + restoreFileName);
		try {				
			if ( file.exists() ) {				
//				System.out.println(">> Restoring system's state " + file.getName() + "...");			
				DataInputStream stream = new DataInputStream(new FileInputStream(file));
				collectionCurIndex = stream.readInt();
				heuristicCurIndex = stream.readInt();
				modelCurIndex = stream.readInt();
				System.out.println(">> Indexes restored: [collection=" + 
									collectionCurIndex+", heuristic=" + 
									heuristicCurIndex + 
									", model=" + modelCurIndex + 
									"]");
				stream.close();
				if ( typeOfInterruption.compareToIgnoreCase("manual-stop") == 0 ) {
					System.out.println("Type of interruption: Manual");
					return false;					
				}
				if ( modelCurIndex > collections[collectionCurIndex].size ) {
					return false;
				}
				return true;
			}
		}
		catch( FileNotFoundException e1) {
		}
		catch( IOException e2) {
			e2.printStackTrace();
		}
		return false;
	}

	
	private void saveState(int collectionIndex, int heuristicIndex, int modelIndex) {
		java.io.File file = new File(restoreFilePath + restoreFileName);
		try {				
//			System.out.println(">> Saving system's state " + file.getName() + "...");			
			DataOutputStream stream = new DataOutputStream(new FileOutputStream(file));
			stream.writeInt(collectionIndex);
			stream.writeInt(heuristicIndex);
			stream.writeInt(modelIndex);
//			System.out.println(">> Indexes saved: [collection=" + 
//								collectionIndex+", heuristic=" + 
//								heuristicIndex + 
//								", model=" + modelIndex + 
//								"]");
			stream.close();
		}
		catch( IOException e2) {
			e2.printStackTrace();
		}
	}		
	
}

class CollectionData {
	public CollectionData(String name, int size) {
		this.name = name;
		this.size = size;
	}
	public String name;
	public int size;
}

class TestData {
	public String heuristic;
	public String modelName;
	public double heurTime;
	public long bddTime;
	public long bddSize;
	public int timeout;
	public int simplified;
	public int fmSize;
	public int fmSizeSimp;
	public int fmMan;
	public int fmOpt;
	public int fmGrp1;
	public int fmGrpn;
	public int ecClauses;
	public double ECR;
	public double ECRSimp;
	public long bddTablePeek;
	public long bddSizePeek;
	public long sifting;
	public int span;
	public double timeToCountBDDSolutions;
}


















