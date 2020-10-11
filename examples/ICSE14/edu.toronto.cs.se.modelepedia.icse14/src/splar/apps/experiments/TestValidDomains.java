
/*
 * Marcilio Mendonca, January 2009
 * 
 * Program originally create to test the "valid domains algorithm" (operation computeValidDomains()) 
 * that computes valid domains and detect dead and common features on feature models 
 * using a SAT solver (SAT4J)
 * 
 * Results to be submitted to academic conferences: SPLC'09 and GPCE'09
 * 
 */

package splar.apps.experiments;

import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFGenerator;
import splar.core.constraints.PropositionalFormula;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.FeatureModelStatistics;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.XMLFeatureModel;
import splar.core.fm.randomization.RandomFeatureModel2;
import splar.core.fm.reasoning.FMReasoningInterface;
import splar.plugins.reasoners.sat.sat4j.FMReasoningWithSAT;



// fm size, fm ecr, fm num clauses, clause density, variable order, value order, 
// parent-child, num checks, dead check time, sat check time, num dead features  


public class TestValidDomains {

	public static void main(String args[]) {
		TestValidDomains o = new TestValidDomains();
		o.checkValidDomains();
	}

	public void checkValidDomains() { 

		FeatureModel fm = null;

		boolean generateModels = true;  // <=============
		boolean saveLogs = false;
		boolean checkValidDomain = false;
		
		boolean satisfiabilityState = false;  // <==== true: must be satisfiable, false: must be UNsatisfiable
		
		int fmSize = 1000; 
		float ecr = 0.2f;
		float density = 1f;
		int numberModels = 10;
		int firstModel = 1;      //  <========
		
		
		/*
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
		 * Defaults:
		 * - DFS for ordering processing and SAT variables
		 *   Variable order for processing variables (we call it "algorithm variable order" not to confuse with "SAT variable order")
		 *   - parent features prior to their children: good for unsat cases -> improves optimization 3 
		 *   
		 * Opt. 1,2 -> Proposed by Mikolas Janota (paper: "Do SAT solvers make good configurators", ASPL'08)
		 * Opt. 3-5 -> Proposed by Marcilio Mendonca 
		 */
//		boolean optimizations[] = new boolean[] {true,true,true,true};     // MIKOLAS + MARCILIO OPTIMIZATIONS 1-5
//		boolean optimizations[] = new boolean[] {true,true,false,false};  // MIKOLAS OPTIMIZATIONS 1-2
		boolean optimizations[] = new boolean[] {true,true,false,false};  // NO OPTIMIZATION 
		int checkType[] = {0,1};   // {0}-common features, {1}- dead features, {0,1}-valid domains 
//		String logPath = "c:\\users\\marcilio\\eclipse\\4watreason\\experiments\\valid-domains\\analysis\\valid-domains-logs.txt"; 
//		String modelsPath = "c:\\users\\marcilio\\eclipse\\4watreason\\experiments\\valid-domains\\models\\";
		
		String logPath = "c:\\users\\marcilio\\eclipse\\SPLOT\\webcontent\\genmodels\\temp\\valid-domains-logs.txt"; 
		String modelsPath = "c:\\users\\marcilio\\eclipse\\SPLOT\\webcontent\\genmodels\\";
		
		FMReasoningWithSAT ri = null;
		
		for( int modelIndex = firstModel ; modelIndex <= numberModels ; modelIndex++ ) {
		
			String fmName = "unsat-3-sat-fm"+ "-" + fmSize + "-" + (int)(ecr*100) + "-" + modelIndex;
			String fileName = fmName + ".xml";

			
			if ( generateModels) {
				try {
					do {
						System.out.println("Trying to generate a " +  (satisfiabilityState ? "SATISFIABLE" : "UNSATISFIABLE") + " model ...");
						fm = gen3SATFeatureModel(fmSize, ecr, density);
						ri = new FMReasoningWithSAT("MiniSAT", fm, 60000);
						ri.init();
					} while ( ri.isConsistent() != satisfiabilityState );
				}
				catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			else {
				fm = new XMLFeatureModel(modelsPath + fileName, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
				try {
					fm.loadModel();
				} catch (FeatureModelException e) {
					e.printStackTrace();
				}
			}
			
			fm.setName(fmName);			
			
			FeatureModelStatistics stats = new FeatureModelStatistics(fm);
			stats.update();
			
			if ( checkValidDomain ) {
			
				System.out.println("********** Processing Model " + modelIndex + " **********");
		
				try {
					
					
					VDData data = new VDData();
	
					ri = new FMReasoningWithSAT("MiniSAT", fm, 60000);
					ri.init();
	
					Map<String,String> riStats = new HashMap<String,String>();
					
					data.optimizations = optimizations;
					data.checkType = checkType.length == 2 ? "Domain" : (checkType[0]==1 ? "Dead" : "Common") ;
									
					byte [][] domainTable = ri.computeValidDomains(checkType, data.optimizations, riStats);
					
					data.numSATChecks = riStats.get("sat-checks");
					data.processingTime = riStats.get("processing-time");
					data.opt3ElimVars = riStats.get("opt3-eliminated-vars");
					
					int index = 0;
					data.numCommon = 0;
					data.numDead = 0;
					for( byte[] entry : domainTable ) {
						if ( entry[0] == FMReasoningInterface.NO ) {
	//						System.out.println("COMMON ===> " + ri.getVariableName(index+1));
							data.numCommon++;
						}
						else if ( entry[1] == FMReasoningInterface.NO ) {
	//						System.out.println("DEAD ===> " + ri.getVariableName(index+1));
							data.numDead++;
						}
						index++;
					}
					
						
					data.fmSize = fm.countFeatures();
					data.modelName = fm.getName();
					data.ecr = ecr;
					data.clauseDensity = stats.getECClauseDensity();
					data.numClauses = fm.countConstraints();
									
					System.out.println("#SAT checks: " + data.numSATChecks);
					System.out.println("Time........: " + data.processingTime);
					System.out.println("#Dead/Common..: " + data.numDead + "/" + data.numCommon +"\r\n");
					
					if ( saveLogs ) {
						saveData(logPath, data);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			
			if ( generateModels ) {
				saveFeatureModel(fm, stats, modelsPath + fileName);
			}
			
		}
	}
	
	public FeatureModel gen3SATFeatureModel(int fmSize, float ecr, float density) {
		
		FeatureModel fm = new RandomFeatureModel2("fm", fmSize, 25, 25, 25, 25, 1, 6, 6, 0);
		try {
			fm.loadModel();
		} catch (FeatureModelException e) {
			e.printStackTrace();
		}
		
		int ecVar = (int)(fmSize * ecr);
		
		// Creates a CNF formula based on ecVar distinct random feature model variables
		List<BooleanVariableInterface> ecVars  = new LinkedList<BooleanVariableInterface>();
		for( FeatureTreeNode var : fm.getNodes() ) {
			if ( !(var instanceof FeatureGroup ) && !fm.isRoot(var) ){
				ecVars.add(var);
			}
		} 
		Collections.shuffle(ecVars);
		int size = ecVars.size()-ecVar;
		for( int i = 1 ; i <= size ; i++ ) {
			ecVars.remove(ecVars.size()-1);
		}
		CNFGenerator cnfGenerator = new CNFGenerator();
		List<CNFClause> clauses = cnfGenerator.generateCNFInstance(ecVars, null, density, 3);
		
		// Add clauses to feature model
		int clauseCounter = 1;
		for( CNFClause clause : clauses ) {
			try {
				fm.addConstraint(new PropositionalFormula("ec_"+(clauseCounter++),clause.toPropositionalFormula()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return fm;
	}
	
	boolean saveHeader = true;
	public void saveData(String fileName, VDData data) {
		try {
			FileWriter writer = new FileWriter(fileName, true);
			if ( saveHeader ) {
				writer.write(data.header() + "\r\n");
			}
			writer.write(data.toString() + "\r\n");
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		saveHeader = false;
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
}

//fm size, fm ecr, fm num clauses, clause density, variable order, value order, 
//parent-child, num checks, dead check time, sat check time, num dead features  

class VDData {
	public int fmSize;
	public String modelName;
	public float ecr;
	public int numClauses;
	public double clauseDensity;
	public boolean optimizations[];
	public boolean optValueOrder;
	public boolean optParentChildDead;
	public String numSATChecks;
	public String processingTime;
	public String checkType;
	public int numDead;
	public int numCommon;
	public String opt3ElimVars;
	
	public VDData() {
		fmSize = 0;
		modelName = "";
		ecr = 0;
		numClauses = 0;
		clauseDensity = 0;
		optimizations = new boolean[4];
		optValueOrder = false;
		optParentChildDead = false;
		numSATChecks = "";
		processingTime = "";		
		numDead = 0;
		numCommon = 0;
		opt3ElimVars = "";
	}
	
	public String header() {
		return "check,model,#fm,ecr,#clauses,cl density,opt1,opt2,opt3,opt4,#checks,time,#dead,#common,#opt3elimvars";
	}
	
	public String toString() {
		String toString = "";
		toString += 
				checkType + "," +
				modelName + "," +
				fmSize + "," +
				ecr + "," +
				numClauses + "," +
				clauseDensity + "," +
				optimizations[0] + "," +
				optimizations[1] + "," +
				optimizations[2] + "," +
				optimizations[3] + "," +
				numSATChecks + "," +
				processingTime + "," +
				numDead + "," +
				numCommon + "," +
				opt3ElimVars;
		return toString;
	}
}

