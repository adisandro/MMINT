package splar.apps;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;
import net.sf.javabdd.JFactory;
import splar.plugins.configuration.bdd.javabdd.BDDConfigurationEngine;
import au.com.bytecode.opencsv.CSVReader;

public class SPLOTCatalogConfigurationBackEnd {

	String productCatalogFilePath = "c:\\users\\marcilio\\eclipse\\splot-project\\webcontent\\models\\catalog\\dell_laptops_usa_fm_catalog.csv";
	int nodeNum = 100000;
	int cacheSize = 100000;

	public static void main(String args[]) {
		new SPLOTCatalogConfigurationBackEnd().generateAndSaveInteractiveConfigurationBDD();
//		new SPLOTCatalogConfigurationBackEnd().extractUniqueProductAttributes();
//		new SPLOTCatalogConfigurationBackEnd().generateCrossTreeConstraintAsCNFClauses();
	}
	
	/*
	 * Use this method to create and save (offline) a BDD for a given (feature model + catalog of products)
	 * The saved BDD is loaded by the configuration engine (online) which saves a huge time since it doesn't need to build the BDD again
	 */
	// command line: java -mx512m -cp ..\resources\lib\javabdd.jar;..\resources\lib\opencsv-1.8.jar;.\ startup.SPLOTCatalogConfigurationBackEnd
	public void generateAndSaveInteractiveConfigurationBDD() {
		try {
			String path = "c:\\users\\marcilio\\eclipse\\splot-project\\webcontent\\models\\catalog\\";
			String fileName = "dell_laptops_usa_fm";
//			String fileName = "trekbikes_fm";
//			String fileName = "simple_bike_fm";
			String featureModelPath = "file:///" + path + fileName + ".xml";
			String catalogPath = path + fileName + "_catalog.csv";
			
			BDDConfigurationEngine confEngine = new BDDConfigurationEngine(featureModelPath, 1000000, 1000000);				
			confEngine.addProductCatalog(catalogPath);
			confEngine.reset();
			
			confEngine.getReasoner().saveToFile(path, fileName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void extractUniqueProductAttributes() {
		
		try {
			
		    CSVReader reader = new CSVReader(new FileReader(productCatalogFilePath));
		    String [] header = reader.readNext();
		    boolean[] optional = new boolean[header.length];		    
		    Arrays.fill(optional, false);
		    
		    List<Set<String>> uniqueColumnValues = new ArrayList<Set<String>>(header.length);
		    for( int i = 0 ; i < header.length ; i++ ) {
		    	uniqueColumnValues.add(i, new LinkedHashSet<String>());
		    }
		    
		    String [] nextLine = reader.readNext();
		    int line = 0;
		    while ( nextLine != null) {
		    	for( int i = 0 ; i < header.length ; i++ ) {
		    		String value = nextLine[i].trim();
		    		if ( value.length() > 0 ) {
		    			uniqueColumnValues.get(i).add(value);
		    			if ( value.indexOf('(') != -1 || value.indexOf(')') != -1 ) {
		    				throw new Exception("Value contains parantheses (column: " + header[i] + " /line: " + line + " ): " + value );
		    			}
		    		}
		    		else {
		    			if (!optional[i] ) {
			    			optional[i] = true;
			    			System.out.println("Optional Feature: " + header[i] );
		    			}
		    		}
		    	}
		    	nextLine = reader.readNext();
		    	line++;
		    }			
		    
			reader.close();
			
						
		    for( int i = 0 ; i < header.length ; i++ ) {
		    	if ( i >=2 && !header[i].startsWith("$" ) ) {
			    	System.out.println(header[i] + "----------------------------------------");
			    	String uniqueValues [] = uniqueColumnValues.get(i).toArray(new String[0]);
			    	Collections.sort(Arrays.asList(uniqueValues));
			    	System.out.println("\t\t\t" + (optional[i] ? ":o " : ":m ") + header[i]);
			    	for( String value : uniqueValues ) {
			    		System.out.println("\t\t\t\t: " + value + " (" + genID(header[i],value) + ")");
			    	}
		    	}
		    }
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String genID(String header, String name) {
//		name = name.trim();
		String lex = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";		
		for( int i = 0 ; i < name.length() ; i++ ) {
			if (lex.indexOf(name.charAt(i)) == -1 ) {
				name = name.replace(name.charAt(i), '_');
			}
		}
		return ("_" + header + "_" + name).toLowerCase();
	}
		
	public List<String> toListOfIDs(String header[], String values[]) {
		List<String> ids = new ArrayList(values.length);
    	for( int i = 0 ; i < values.length ; i++ ) {
    		ids.add(i, genID(header[i], values[i]));
    	}		
		return ids;
	}
	
	public void generateCrossTreeConstraintAsCNFClauses() {
		
		try {
			
			// Each list in the catalog contains a list of string representing the features in the product
			List<List<String>> catalog = new LinkedList<List<String>>();
				
		    CSVReader reader = new CSVReader(new FileReader(productCatalogFilePath));
		    String [] header = reader.readNext();
		    String [] nextLine = reader.readNext();
		    while ( nextLine != null) {
	    		catalog.add(toListOfIDs(header, nextLine));
		    	nextLine = reader.readNext();
		    }			
		    
			reader.close();
	
			/*********************************************************************************************************
			 * compute number of variables by counting distinct catalog items 
			 *********************************************************************************************************/		
			List<String> varIndex2NameMap = new LinkedList<String>();
			Map<String,Integer> varName2IndexMap = new HashMap<String, Integer>();
			for( List<String> product : catalog ) {
				for( String item : product ) {
					if ( !varName2IndexMap.containsKey(item) ) {
						varIndex2NameMap.add(item);
						varName2IndexMap.put(item,0);
					}
				}
			}
	
			/*********************************************************************************************************
			 * defines BDD variable order 
			 *********************************************************************************************************/
			Collections.shuffle(varIndex2NameMap);
			int countVars = 0;
			for( String var : varIndex2NameMap ) {
				varName2IndexMap.put(var,countVars++);
			}				
			System.out.println("\nVARIABLES ORDER/INDEXES -------------------");
			List<String> sortedVars = new ArrayList(varIndex2NameMap);
			Collections.sort(sortedVars);
			for( String var : sortedVars) {
				System.out.println(varName2IndexMap.get(var) + ": " + var );
			}
	
			/*********************************************************************************************************
			 * builds the BDD for product catalog 
			 *********************************************************************************************************/		
			// (a or ~b) and c
			BDDFactory bddFactory = JFactory.init(nodeNum, cacheSize);		
			bddFactory.setVarNum(countVars);
			
			BDD fbdd = bddFactory.zero();
			for( List<String> product : catalog ) {
				BDD tempBDD = bddFactory.one();
				Set<String> productSet = new HashSet<String>(product);
				for( String distinctItem : varIndex2NameMap ) {
					if ( productSet.contains(distinctItem) ) {
						tempBDD.andWith(bddFactory.ithVar(varName2IndexMap.get(distinctItem)).id());
					}
					else {
						tempBDD.andWith(bddFactory.nithVar(varName2IndexMap.get(distinctItem)).id());
					}
				}
				fbdd.orWith(tempBDD);
			}
			
			/*********************************************************************************************************
			 * prints BDD dot file 
			 *********************************************************************************************************/		
			try {
	//			PrintStream savedOut = System.out;
	//			System.setOut(new PrintStream(new FileOutputStream("c:\\users\\marcilio\\temp\\bdd.dot")));			
	//			fbdd.printDot();
	//			System.setOut(savedOut);
			}
			catch (Exception e) {
			}
			
			/*********************************************************************************************************
			 * extracts CNF from negated BDD 
			 *********************************************************************************************************/		
			System.out.println("\nCNF FORMULA -------------------");
			int formulaIndex = 1;
//			for( BDD.AllSatIterator it = new BDD.AllSatIterator(fbdd.not()) ; it.hasNext() ; ) {
//				byte[] path = it.nextSat();
//				int index = 0;
//				System.out.print(formulaIndex++ + ": (");
//				for( byte value : path ) {
//					String var = varIndex2NameMap.get(index);
//					if ( value == 0 ) {
//						if ( index != 0 ) System.out.print(",");
//						System.out.print(var);
//					}
//					else if ( value == 1 ) {
//						if ( index != 0 ) System.out.print(",");
//						System.out.print("~"+var);
//					}
//					index++;
//				}
//				System.out.println(")");
//			}
			
			/*********************************************************************************************************
			 * enumerates BDD solutions that must match catalog products 
			 *********************************************************************************************************/		
			System.out.println("\nPRODUCTS FROM BDD -------------------");
			System.out.println("BDD size: " + fbdd.nodeCount());
			System.out.println("Solutions: " + fbdd.satCount());
			System.out.println("Path count: " + fbdd.not().pathCount());
			List<String> product = new LinkedList<String>();
			int countProducts = 0;
			for( BDD.AllSatIterator it = new BDD.AllSatIterator(fbdd) ; it.hasNext() ; ) {
				product.clear();
				byte[] path = it.nextSat();
				int index = 0;
				for( byte value : path ) {
					String var = varIndex2NameMap.get(index);
					if ( value == 1 ) {
						product.add(var);
					}
					index++;
				}
				
				Collections.sort(product);			
//				System.out.print("\r\n" + (++countProducts) + ": ");
//				for( String item : product ) {
//					System.out.print(item + ",");
//				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}			
}
