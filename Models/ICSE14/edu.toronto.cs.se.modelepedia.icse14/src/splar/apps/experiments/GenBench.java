package splar.apps.experiments;

/*************************************************************************************************
 * This program can be used:
 *   1- to generate collections of (un)satisfiable random feature models 
 *   2- to run scalability tests for BDD variable ordering herusticis 
 *      for very large feature models (e.g. 1000, 2000, 5000 features) 
 *************************************************************************************************/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelStatistics;
import splar.core.fm.XMLFeatureModel;
import splar.core.fm.randomization.RandomFeatureModel2;
import splar.core.heuristics.FORCEVariableOrderingHeuristic;
import splar.core.heuristics.FTPreOrderSortedECTraversalHeuristic;
import splar.core.heuristics.FTPreOrderTraversalHeuristic;
import splar.core.heuristics.VariableOrderingHeuristic;
import splar.plugins.reasoners.bdd.javabdd.FMReasoningWithBDD;
import splar.plugins.reasoners.bdd.javabdd.ReasoningWithBDD;





public class GenBench {

	public static void main(String args[]) {
		new GenBench(args);
	}
	
	// args[0] = heuristic name 
	// args[1] = number of features
	// args[2] = ECR
	// args[3] = number of files to process
	public GenBench(String args[]) {
		if( args.length < 4 ) {
			System.out.println("PARAMETERS");
			System.out.println("  args[0] = heuristic name (e.g Pre-CL-MinSpan or Pre-CL-Size or pre-order)"); 
			System.out.println("  args[1] = number of features");
			System.out.println("  args[2] = ECR [0-100]");
			System.out.println("  args[3] = number of files to process");
			System.out.println("  args[4] = Suffix to use on model names");
			System.out.println("---------------------------------------------------");
		}
		else {
			try {
				init(args);
	//			shrinkOnly();
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
//	String mainPath = "c:\\users\\marcilio\\eclipse\\4watreason\\experiments\\thesis\\";//bench-SAT";
	String mainPath = "c:\\users\\marcilio\\eclipse\\4watreason\\experiments\\thesis\\";//bench-SAT";
	
	int nodeNum = 5000000;
	int cacheSize = 1000000;
	double BDDTableIncreaseFactor = 0.2;
	double BDDGCFactor = 0.20;
	
	// Specified as command line parameters
	String heuristicName;			// heuristic
	int nf;  					 	// total features
	double ECR;						// ECR
	int numberOfFilesToGenerate; 	// total files for the experiment
	String modelNameSuffix = "";
	
	// Calculated values
	int nf_add; // adittional features in case of shrink is ON
	int vc;     // features in extra constraints	
	String collection;
	String collectionSet;
	String logFile;
	String tempFile;
	
	// Manual parameters
	int startFromIndexInCollection = 1;  
	int timeout = 3600000;   
	String outputPath;
	boolean shrink = false;
	
    // true: check satisfiability/unsatisfiability, false: don't care (false is useful for very large FMs)
	boolean checkSatistiability = true; 
	
	// if TRUE only generates SATISFIABLE feature models; otherwise only generates UNSATISFIABLE model
	// IMPORTANT: only applies when checkSatisfiability is TRUE
	boolean skipUnsatisfiableFeatureModels = true;    
	
	boolean skipSatisfiableFeatureModels = !skipUnsatisfiableFeatureModels;
	int runIndex = 1; // always 1
	
	private void updateCounterFile(int runIndex, int fileIndex) {
		java.io.File file = new File(mainPath + "\\" + tempFile);
		try {
			System.out.println(">> generating/updating file " + file.getName() + "...");
			System.out.println(">> runIndex=" + runIndex + ", fileIndex=" + fileIndex );
			DataOutputStream stream = new DataOutputStream(new FileOutputStream(file));
			stream.writeInt(runIndex); // current runIndex
			stream.writeInt(fileIndex); // file index
			stream.close();
		}
		catch( FileNotFoundException ex1) {
			ex1.printStackTrace();
		}
		catch( IOException ex2) { 
			ex2.printStackTrace();
		}
	}
	
	private void readCounterFile() {
		java.io.File file = new File(mainPath + "\\" + tempFile);
		try {
			System.out.println(">> reading file " + file.getName() + "...");			
			DataInputStream stream = new DataInputStream(new FileInputStream(file));
			runIndex = stream.readInt() + 1;
			startFromIndexInCollection = stream.readInt() + 1;
			System.out.println(">> runIndex=" + runIndex + ", fileIndex=" + startFromIndexInCollection );
			stream.close();
		}
		catch( FileNotFoundException e1) {
			System.out.println("File does not exist!");			
			updateCounterFile(1, 19);
		}
		catch( IOException e2) {
			e2.printStackTrace();
		}
	}
	
	private void printInputParameters() {
		System.out.println("---------------------------------------------------");
		System.out.println(">> INPUT PARAMETERS");
		System.out.println("   - Heuristic............: "+ heuristicName);
		System.out.println("   - Features.............: " + (nf+nf_add));
		System.out.println("   - ECR..................: " + ((int)(ECR*100)) + "%");
		System.out.println("   - BDD table............: " + nodeNum + " nodes");
		System.out.println("   - Table increase factor: " + (BDDTableIncreaseFactor*100) + "%");
		System.out.println("   - Files in experiment..: " + numberOfFilesToGenerate);
		System.out.println("   - Log file.............: " + logFile);
		System.out.println("   - Temp file............: " + tempFile);
		System.out.println("---------------------------------------------------");
	}
	
	// args[0] = heuristic name 
	// args[1] = number of features
	// args[2] = ECR
	// args[3] = number of files to process
	private void captureCommandLineParameters(String args[]) {
		heuristicName = args[0];								// heuristic
		nf = Integer.valueOf(args[1]);  						// total features
		ECR = Integer.valueOf(args[2])/100.0;						// ECR
		numberOfFilesToGenerate = Integer.valueOf(args[3]); 	// total files for the experiment
		modelNameSuffix = args[4];
		nf_add = (int)(nf * 0.33); // adittional features in case of shrink is ON
		if ( !shrink ) {
			nf_add = 0;
		}
		vc = 0;
		if ( ECR != 0 ) {
			vc = (int)((ECR+0.05)*(nf+nf_add));  // features in extra constraints
		}
		collection = "FM"+nf;
		String sat = "SAT";
		if ( skipSatisfiableFeatureModels ) {
			sat = "UNSAT";
		}
		if ( skipUnsatisfiableFeatureModels ) {
			sat = "SAT";
		}
		collectionSet = sat + "_" + modelNameSuffix + "C";
		logFile = "GenBench-Stats-"+heuristicName+"-"+nf;
		tempFile = "GenBench-Temp-"+heuristicName+"-"+nf+"-"+collectionSet+".txt";
//		outputPath = "\\" + collection;
		outputPath = "\\scalability";
	}
	
	private VariableOrderingHeuristic getHeuristic(String name, FeatureModel fm) {
		VariableOrderingHeuristic heuristic = null;
		if ( heuristicName.compareToIgnoreCase("Pre-CL-MinSpan") == 0 ) {
			heuristic = new FTPreOrderSortedECTraversalHeuristic("Pre-CL-MinSpan",fm, FTPreOrderSortedECTraversalHeuristic.FORCE_SORT);						
		}
		else if ( heuristicName.compareToIgnoreCase("Pre-CL-Size") == 0 ) {
			heuristic = new FTPreOrderSortedECTraversalHeuristic("Pre-CL-Size",fm, FTPreOrderSortedECTraversalHeuristic.SIZE_SORT);
		}
		else if ( heuristicName.compareToIgnoreCase("FORCE-Pre-CL-MinSpan") == 0 ) {
			VariableOrderingHeuristic tempHeuristic = new FTPreOrderSortedECTraversalHeuristic("Pre-CL-MinSpan",fm, FTPreOrderSortedECTraversalHeuristic.FORCE_SORT);
			String order[] = tempHeuristic.run(fm.FM2CNF());			
			heuristic = new FORCEVariableOrderingHeuristic("FORCE-Pre-CL-MinSpan",VariableOrderingHeuristic.variableOrderingAsBooleanVariableArray(order),1);
		}
		else if ( heuristicName.compareToIgnoreCase("FORCE-Pre-CL-Size") == 0 ) {
			VariableOrderingHeuristic tempHeuristic =  new FTPreOrderSortedECTraversalHeuristic("Pre-CL-Size",fm, FTPreOrderSortedECTraversalHeuristic.SIZE_SORT);
			String order[] = tempHeuristic.run(fm.FM2CNF());
			System.out.println(order);
			heuristic = new FORCEVariableOrderingHeuristic("FORCE-Pre-CL-Size",VariableOrderingHeuristic.variableOrderingAsBooleanVariableArray(order),1);
		}
		else if ( heuristicName.compareToIgnoreCase("FORCE") == 0 ) {
			heuristic = new FORCEVariableOrderingHeuristic("FORCE",1);
		}
//		else if ( heuristicName.compareToIgnoreCase("Fuj-DFS") == 0 ) {
//			BooleanCircuit circuit = new BooleanCircuit();
//			heuristic = new Fujita88DFSCircuitTraversalHeuristic("Fuj-DFS",circuit.FM2Circuit(fm), "output");
//		}
		else if ( heuristicName.compareToIgnoreCase("Pre-Order") == 0 ) {
			heuristic = new FTPreOrderTraversalHeuristic("Pre-Order",fm);
		}
		return heuristic;
	}
	
	public void init(String args[]) throws Exception {
		
		captureCommandLineParameters(args);
		
		readCounterFile();
		
		System.out.println(">> generating feature models...");
		boolean genFile = false;
		
		String logFilePath= mainPath + outputPath + "\\logs\\" + logFile + "-" + collectionSet + "-" + runIndex + ".txt";
		PrintStream logStream = new PrintStream(logFilePath);
		System.out.println(">> Output file: " + logFile + "-" + collectionSet + "-" + runIndex + ".txt");
		
		for( int i = startFromIndexInCollection ; i <= numberOfFilesToGenerate ; ) {			
			try {
				
				printInputParameters();
				updateCounterFile(runIndex, i);
				
//				if ( Math.abs(new Random().nextInt())%2 == 0 ) {
//					System.exit(0);
//				}
//				else {
//					i++;
//					continue;
//				}
				
				FeatureModel fm = null;
				FeatureModelStatistics stats = null;
				
				boolean newFileCreated = true;
								
				String inputFileLocation = mainPath + outputPath + "\\files\\"+collection+collectionSet+"-"+i+".xml";
				File file = new File(inputFileLocation);
				
				if ( !file.exists() ) {
					System.out.println("Creating test file: " + file.getName());
					fm = new RandomFeatureModel2(collection+collectionSet+"-"+i, nf+nf_add, 25, 35, 20, 20, 1, 6, 6, 0);
			//		fm = new XMLFeatureModel("c:\\users\\marcilio\\eclipse\\4watreason\\fm_samples\\fmr_fm.xml");
					fm.loadModel();
									
					// {1,33,100,80} 
					// 1 - level indicator in percentage
					// 33 - percentage of varibles allocated for this level
					// 100 - percentage of cluster root nodes at this level to be considered
					// 80 - percentage of cluster nodes to be considered in the cluster
					
					if ( vc > 0 ) {
//						RandomFeatureModel2.createExtraConstraints(fm, vc, vc/2, 2, new int[][] {{1,60,100,100},{10,40,90,100}});//,{20,20,80,90}});//,{30,5,100,100}});
						try {
							RandomFeatureModel2.createExtraConstraints(fm, vc, vc/2, 2, new int[][] {{1,20,100,70},{20,20,80,80},{40,30,80,80},{60,30,80,80}});
						}
						catch( Exception e ) {
							e.printStackTrace();
							continue;   
						}
					}
					
					if ( shrink ) {
//								System.out.println(">> shrinking " + collection+collectionSet+"-"+i + " ...");
						fm.shrink();
					}
				}
				else {
					System.out.println("Reusing existing test file: " + file.getName());
					newFileCreated = false;
					fm = new XMLFeatureModel(inputFileLocation);
					fm.loadModel();
				}
				
				double realECR = 100*(fm.countConstraintsVariables()/(1f*fm.countNodes()));
				
				if ( Math.abs(realECR-(100*ECR)) > 3 ) {
					System.out.println("Real ECR: " + realECR + "   Desired ECR: " + (100*ECR));
					System.out.println("ECR too different from the one specified, trying again...");
					continue;
				}
								
				System.out.println("---------------------------------------------------");
				System.out.println(">> RESULTS (run=" + runIndex + "/file=" + i +")");
				System.out.println("ECR......:  " + realECR);

				if ( !file.exists() ) { //&& heuristicName.compareToIgnoreCase("Pre-CL-MinSpan") != 0 ) {
					
					if ( checkSatistiability ) {
						System.out.println(">>>> Checking feature model satisfiability...");
						if ( !isFMSatisfiable( fm )) {
							if ( skipUnsatisfiableFeatureModels ) {
								System.out.println(">>>> UNSatisfiable!! (SKIPPED)");
								continue;
							}
							else {
								System.out.println(">>>> UNSatisfiable!! (PROCESSING)");
								genFile = true;
							}
						}
						else {
							if (skipSatisfiableFeatureModels) {
								System.out.println(">>>> Satisfiable!! (SKIPPED)");
								continue;
							}
							else {
								System.out.println(">>>> Satisfiable!! (PROCESSING)");
								genFile = true;
							}
						}
					}
					else {
						genFile = true;
					}
				}
				
				stats = new FeatureModelStatistics(fm);
				stats.update();
								
				ReasoningWithBDD r = null;
				VariableOrderingHeuristic heuristic = getHeuristic(heuristicName,fm );
				try {
					if ( checkSatistiability ) {
						System.out.println(">> Building BDD with heuristic " + heuristicName + "...");
						genFile = false;
						r = new FMReasoningWithBDD(fm, heuristic, nodeNum, cacheSize, timeout, "pre-order");
						r.getBDDFactory().setIncreaseFactor(BDDTableIncreaseFactor);
						r.getBDDFactory().setMinFreeNodes(BDDGCFactor);
						r.init();
						if ( r.getBDD().nodeCount() > 0 ) {
							genFile = true;
						}
						else if ( !skipUnsatisfiableFeatureModels ){
							genFile = true;
						}
					}
					else {
						genFile = true;
					}
				}
				catch(Exception e) {
					e.printStackTrace();
					throw e;
				}
					
				if ( genFile ) {

					if ( newFileCreated ) { // then save it on disk 					
						saveFeatureModel(fm, stats, inputFileLocation);
					}
					
					if ( r != null ) {
						System.out.println("Heur Time: " + r.getHeuristicRunningTime() + " ms");
						System.out.println("BDD Time.: " + r.getBDDBuildingTime() + " ms");
						System.out.println("BDD......: " + r.getBDD().nodeCount());
					}
					
					// Heuristic name
					logStream.print(heuristic.getName()+",");					
					// FM Size
					logStream.print(fm.countNodes()+",");
					// ECR
					logStream.print(realECR+",");
					if ( r != null ) {
						// Heur time
						logStream.print(r.getHeuristicRunningTime()+",");
						// BDD time
						logStream.print(r.getBDDBuildingTime()+",");
						// BDD size
						logStream.print(r.getBDD().nodeCount()+",");
						// BDD table size
						logStream.print(r.getBDDFactory().getNodeTableSize()+",");
					}
					logStream.print("\r\n");
					logStream.flush();
					
				}
				else {
					System.out.println(">> BDD has size 0, sorry!");
				}
			}
			catch( FileNotFoundException exc ) {
				exc.printStackTrace();
			}
			
			if ( genFile ) {
				i++;
			}
		}
		
		logStream.close();
		
		System.out.println("done!");
	}
	
	private void saveFeatureModel(FeatureModel fm, FeatureModelStatistics stats, String location) {
			PrintStream stream = null;
			PrintStream standartOut = System.out;
			try {
				stream = new PrintStream(location);
				System.setOut(stream);
				fm.dumpXML();
				System.out.println("<!--");
				stats.dump();
				System.out.println("-->");
				System.setOut(standartOut);
				stream.flush();
				stream.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	private boolean isFMSatisfiable(FeatureModel fm) {
		ReasoningWithBDD r = null;
		try {
			VariableOrderingHeuristic heuristic = getHeuristic("Pre-CL-MinSpan",fm );
			r = new FMReasoningWithBDD(fm, heuristic, nodeNum, cacheSize, timeout, "pre-order");
			r.getBDDFactory().setIncreaseFactor(BDDTableIncreaseFactor);
			r.getBDDFactory().setMinFreeNodes(BDDGCFactor);
			r.init();
			if ( r.getBDD().nodeCount() > 0 ) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;		
	}
	
	public void shrinkOnly() {
		int countFeatures = 0;
		int countECvars = 0;
		for( int i = startFromIndexInCollection ; i <= numberOfFilesToGenerate ; i++ ) {			
			try {
				System.out.println("Shrinking file: " + collection+collectionSet+"-"+i + ".xml to " +  collection+collectionSet+"-"+i+"_shrunk.xml");
				FeatureModel fm = new XMLFeatureModel(mainPath + outputPath + "\\"+"\\"+collection+collectionSet+"-"+i+".xml");
				fm.loadModel();
				fm.shrink();
				countFeatures += fm.countNodes();
				countECvars += fm.countConstraintsVariables();
				FeatureModelStatistics stats = new FeatureModelStatistics(fm);
				stats.update();
				PrintStream standartOut = System.out;
				PrintStream stream = new PrintStream(mainPath + outputPath + "\\"+"\\"+collection+collectionSet+"-"+i+"_shrunk.xml");
				System.setOut(stream);
				fm.dumpXML();
				System.out.println("<!--");
				stats.dump();
				System.out.println("-->");
				System.setOut(standartOut);
				stream.flush();
				stream.close();
				System.out.println("done! ");
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}		
		System.out.println("ECR: " + (countECvars/(1f*countFeatures)));
	}
}
