package splar.plugins.configuration.bdd.javabdd;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.javabdd.BDD;
import net.sf.javabdd.BDDFactory;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.configuration.ConfigurationEngine;
import splar.core.fm.configuration.ConfigurationEngineException;
import splar.core.fm.configuration.ConfigurationStep;
import splar.core.heuristics.FTPreOrderTraversalHeuristic;
import splar.core.heuristics.VariableOrderingHeuristic;
import splar.core.heuristics.VariableOrderingHeuristicsManager;
import splar.plugins.configuration.bdd.javabdd.catalog.Product;
import splar.plugins.configuration.bdd.javabdd.catalog.ProductCatalog;
import splar.plugins.configuration.bdd.javabdd.catalog.ProductComponent;
import splar.plugins.reasoners.bdd.javabdd.FMReasoningWithBDD;
import au.com.bytecode.opencsv.CSVReader;

public class BDDConfigurationEngine extends ConfigurationEngine {

	protected ProductCatalog productCatalog = null;
	protected FMReasoningWithBDD reasoner = null;
	protected int bddNodeNum, bddCacheSize;
	protected String loadFromFilePath = null;
	protected String loadFromFileFileName = null;
	
	/******************************************************************************************************
	 * CONSTRUCTOR
	 *******************************************************************************************************/
	public BDDConfigurationEngine(String featureModelURL, String loadFromFilePath, String loadFromFileFileName)
			throws ConfigurationEngineException {
		super(featureModelURL);
		initParameters();
		this.loadFromFilePath = loadFromFilePath;
		this.loadFromFileFileName = loadFromFileFileName;
	}	
	/******************************************************************************************************
	 * CONSTRUCTOR
	 *******************************************************************************************************/
	public BDDConfigurationEngine(String featureModelURL)
			throws ConfigurationEngineException {
		super(featureModelURL);
		initParameters();
	}

	/******************************************************************************************************
	 * CONSTRUCTOR
	 *******************************************************************************************************/
	public BDDConfigurationEngine(String featureModelURL, int bddNodeNum, int bddCacheSize) 
			throws ConfigurationEngineException {
		super(featureModelURL);
		this.bddNodeNum = bddNodeNum;
		this.bddCacheSize = bddCacheSize;
	}

	/******************************************************************************************************
	 * CONSTRUCTOR
	 *******************************************************************************************************/
	public BDDConfigurationEngine(FeatureModel model)
			throws ConfigurationEngineException {
		super(model);
		initParameters();
	}

	protected void initParameters() {
		bddNodeNum = model.countFeatures() * 100;
		bddCacheSize = bddNodeNum;
	}
	
	/******************************************************************************************************
	 * RETURNS PRODUCT CATALOG
	 *******************************************************************************************************/
	public ProductCatalog getCatalog() {
		return productCatalog;
	}
	
	/******************************************************************************************************
	 * Restricts the Feature Model's by adding new constraints so that only products 
	 * in the specified PRODUCT CATALOG can be derived
	 *******************************************************************************************************/
	public void addProductCatalog(String csvCatalogFilePath) throws ConfigurationEngineException {

		try {
			FeatureModel featureModel = getModel();
			productCatalog = new ProductCatalog(featureModel);
	
			CSVReader reader = new CSVReader(new FileReader(csvCatalogFilePath));
	
			// How header is interpreted
	    	//   0 = product id
	    	//   1 = product name
	    	//   starts with $ = product attribute
	    	//   starts with ( = ignore 
	    	//   anything else = feature
	
		    String [] header = reader.readNext();
		    		    // check if header matches catalog's components
		    for( int i = 2 ; i < header.length ; i++ ) {
		    	if ( !header[i].startsWith("(") && !header[i].startsWith("$")) {
			    	if ( !productCatalog.containsComponent(header[i].trim())) {
			    		throw new ConfigurationEngineException("Error: Feature model '" + featureModel.getName() + "' does not contain component: '" + header[i] + "' referenced by a product in file '" + csvCatalogFilePath + "'");
			    	}
		    	}
		    }
		    
		    String [] nextLine = reader.readNext();
		    while ( nextLine != null) {
		    	Product product = new Product(productCatalog, createProductId(nextLine[0].trim()), nextLine[1].trim());
		    	for( int i = 2 ; i < nextLine.length ; i++ ) {
		    		// it's an attribute...
			    	if ( header[i].startsWith("$") ) {
			    		product.addAttribute(header[i].substring(1).trim(), nextLine[i].trim());
			    	}
			    	// it's a feature
			    	else if ( !header[i].startsWith("(") ) {
			    		String componentType = nextLine[i].trim();
			    		if ( componentType.length() > 0 ) {
			    			product.addComponent(header[i], genID(header[i].trim(),componentType));
			    		}
			    		else {
			    			product.addComponent(header[i].trim(), "");
			    		}
			    	}
		    	}
	    		productCatalog.addProduct(product);
		    	nextLine = reader.readNext();
		    }			
			reader.close();
		} catch (IOException e2) {
			throw new ConfigurationEngineException("Error reading CSV file for creating BDD configuration engine", e2);
		} catch (Exception e3) {
			throw new ConfigurationEngineException("Error creating BDD configuration engine.", e3);
		}
	}
	
	private String createProductId(String productId) {
		String suffix = "abcdefghijklmnopqrsvwxyz";
		String id = productId;
		int counter = 0;
		while ( productCatalog.containsProduct(id) ) {
			id = productId + "-" + suffix.substring(counter,counter+1);
			counter++;
		}
		return id;
	}
	
	public static String genID(String header, String name) {
		String lex = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";		
		for( int i = 0 ; i < name.length() ; i++ ) {
			if (lex.indexOf(name.charAt(i)) == -1 ) {
				name = name.replace(name.charAt(i), '_');
			}
		}
		return ("_" + header + "_" + name).toLowerCase();
	}

	
	/******************************************************************************************************
	 * Returns reasoner object
	 *******************************************************************************************************/
	public FMReasoningWithBDD getReasoner() {
		return reasoner;
	}
	
	/******************************************************************************************************
	 * CREATE REASONER
	 *******************************************************************************************************/
	protected void createReasoner() throws ConfigurationEngineException {
		try {
//			new FTPreOrderSortedECTraversalHeuristic("_BDDVarOrderHeuristic1", getModel(), FTPreOrderSortedECTraversalHeuristic.SIZE_SORT);					
			new FTPreOrderTraversalHeuristic("_BDDVarOrderHeuristic2", getModel());
			VariableOrderingHeuristic heuristic = VariableOrderingHeuristicsManager.createHeuristicsManager().getHeuristic("_BDDVarOrderHeuristic2");

			// if reasoner is to be created from file - reads associated files
			if ( loadFromFilePath != null ) {
				reasoner = new FMReasoningWithBDD(getModel(), heuristic, bddNodeNum, bddCacheSize, 60000, "pre-order");
				reasoner.init(loadFromFilePath, loadFromFileFileName);
			}
			else {
				reasoner = new FMReasoningWithBDD(getModel(), heuristic, bddNodeNum, bddCacheSize, 60000, "pre-order") {
					
					protected BDD createBDD(BDDFactory bddFactory, String orderingFormulasStrategy) throws Exception {
						
						BDD bdd = super.createBDD(bddFactory, orderingFormulasStrategy);
						
						if ( productCatalog != null && productCatalog.getProducts().size() > 0 ) {
							// add product catalog constraints to BDD
							BDD catalogBDD = bddFactory.zero();
							// iterate over catalog products
							for( Product product : productCatalog.getProducts().values() ) {
								// for each product, iterate over its components
								BDD productBDD = bddFactory.one();
								for( String productComponentId : product.getComponents().keySet() ) {
									String productComponentType = product.getComponent(productComponentId);
									ProductComponent concreteComponent = productCatalog.getComponent(productComponentId);
									// for each component iterate over its types in the catalog
									for( String componentType : concreteComponent.getTypes() ) {
										// if catalog component's type differs from the product's component type 
										if ( componentType.compareToIgnoreCase(productComponentType) == 0 ) {
	//										System.out.println("YES Component:Type = " + productComponentId + ":" + componentType );
											productBDD.andWith(bddFactory.ithVar(super.getVariableIndex(componentType)));
										}
										else {
	//										System.out.println("NO Component:Type = " + productComponentId + ":" + componentType );
											productBDD.andWith(bddFactory.nithVar(super.getVariableIndex(componentType)));
										}
									}
								}
								catalogBDD.orWith(productBDD);
							}
							return bdd.andWith(catalogBDD);
						}
						else {
							return bdd;
						}
					}
				};
				reasoner.init();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems creating BDD reasoner for interactive configuration", e);
		}
	}
	
	/******************************************************************************************************
	 * GET VARIABLE INDEX
	 *******************************************************************************************************/
	@Override
	protected int getVariableIndex(String varName) {
		return reasoner.getVariableIndex(varName);
	}

	/******************************************************************************************************
	 * GET VARIABLE NAME
	 *******************************************************************************************************/
	@Override
	protected String getVariableName(int varIndex) {
		return reasoner.getVariableName(varIndex);
	}

	/******************************************************************************************************
	 * RESET CONFIGURATION
	 *******************************************************************************************************/
	@Override
	protected ConfigurationStep resetConfiguration()
			throws ConfigurationEngineException {
		try {			
			createReasoner();
			createConfigurationStep(model.getRoot().getID(), 1, "propagated");
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems reseting configuration", e);
		}
		return getLastStep();
	}

	/******************************************************************************************************
	 * Utility method: Create a configuration step for a given <feature,decision> pair
	 * Returns the valid domains table for the created configuration step
	 *******************************************************************************************************/
	@Override
	protected Map<String,Boolean[]> createConfigurationStep( String featureId, int featureValue, String decisionType ) throws Exception {
		Map<String,Boolean[]> domainTable = null;
		try {			
			long start = System.currentTimeMillis();
			String stateName = "bdd_state_" + (steps.size()+1);
//			System.out.println("saving BDD state 'bdd_state_" + (steps.size()+1) + "'");
			reasoner.saveState(stateName);
			reasoner.restrict(featureId, featureValue == 1);
			
			domainTable = super.createConfigurationStep(featureId, featureValue, decisionType);
			
			ConfigurationStep newConfStep = getLastStep();
			newConfStep.addAttribute("step_Stat", ""+reasoner.getBDD().nodeCount());
			newConfStep.addAttribute("step_runTime", "" + (System.currentTimeMillis()-start));

		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		return domainTable;
	}

	/******************************************************************************************************
	 * AUTO COMPLETE
	 *******************************************************************************************************/
	@Override
	public ConfigurationStep autoComplete(boolean valueOrder)
			throws ConfigurationEngineException {
		return null;
	}

	/******************************************************************************************************
	 * COMPUTE VALID DOMAINS
	 *******************************************************************************************************/
	@Override
	protected Map<String,Boolean[]> computeValidDomains() throws ConfigurationEngineException {
//		BDDValidDomainComputation validDomains = new BDDValidDomainComputation(reasoner);
//		Map<String,Boolean[]> domainTable = validDomains.computeValidDomains(); 
//		validDomains.debugDomainTable(true);
		try {
			return reasoner.allValidDomains(new HashMap<String, String>());
		} catch (Exception e) {
			throw new ConfigurationEngineException(e);
		}
	}

	/******************************************************************************************************
	 * DETECT CONFLICTS
	 *******************************************************************************************************/
	@Override
	public List<FeatureTreeNode> detectConflicts(String featureId)
			throws ConfigurationEngineException {
		return null;
	}

	/******************************************************************************************************
	 * TOGGLE DECISION
	 *******************************************************************************************************/
	@Override
	public List<ConfigurationStep> toggleDecision(String featureId)
			throws ConfigurationEngineException {
		// TODO Auto-generated method stub
		return null;
	}

	/******************************************************************************************************
	 * UNDO CONFIGURATION
	 *******************************************************************************************************/
	@Override
	public  List<ConfigurationStep> undo(int undoStep) throws ConfigurationEngineException {
		try {			
			if ( undoStep > 1 && undoStep <= steps.size() ) {
				for( int i = undoStep+1 ; i <= steps.size() ; i++ ) {
//					System.out.println("discarding BDD state 'bdd_state_" + i + "'");
					reasoner.discardState("bdd_state_"+i);
				}
//				System.out.println("restoring BDD state 'bdd_state_" + undoStep + "'");
				reasoner.restoreState("bdd_state_" + undoStep);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ConfigurationEngineException("Problems undoing configuration step " + undoStep, e);
		}
		return super.undo(undoStep);
	}		
}
