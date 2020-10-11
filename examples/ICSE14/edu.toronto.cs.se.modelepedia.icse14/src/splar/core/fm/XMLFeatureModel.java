package splar.core.fm;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.constraints.CNFClause;
import splar.core.constraints.PropositionalFormula;
import splar.core.constraints.parsing.CNFClauseParseException;
import splar.core.constraints.parsing.CNFClauseParser;


public class XMLFeatureModel extends FeatureModel {

	public static final int USE_VARIABLE_NAME_AS_ID = 10;
	public static final int SET_ID_AUTOMATICALLY = 20;
	
	private String fileName;
	private int idCounter;
	private int idCreationStrategy;

	public XMLFeatureModel(String fileName) {
		this(fileName, SET_ID_AUTOMATICALLY);
	}
	
	public XMLFeatureModel(String fileName, int idCreationStrategy) {
		super();
		this.fileName = fileName;
		this.idCreationStrategy = idCreationStrategy;
	}
	
	public int getIDCreationStrategy() {
		return idCreationStrategy;
	}
	
	@Override
	protected FeatureTreeNode createNodes() throws FeatureModelException {
		
		FeatureTreeNode rootNode = null;
		
		idCounter = 0;
		// if model is already loaded just return the feature model root node 
		if ( getRoot() != null ) {
			rootNode = getRoot();
		}
		// otherwise, load it from the XML feature model file
		else {			
			//	get the factory
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			try {
				//Using factory get an instance of document builder
				DocumentBuilder db = dbf.newDocumentBuilder();
				
				//parse using builder to get DOM representation of the XML file
				Document doc = db.parse(fileName);
				
				//	get the root element
				Element rootEle = doc.getDocumentElement();
				String featureModelName = rootEle.getAttribute("name");
				
				if ( featureModelName == null || featureModelName.equals("") ) {
					throw new FeatureModelException("Missing mandatory feature model name.");
				}
				
				setName(featureModelName);
				
				// parse metadata, if section exists
				NodeList metalist = rootEle.getElementsByTagName("meta");
				if ( metalist.getLength() > 0 ) {
//					System.out.println("metadata section found!");
					Element metaElement = (Element)metalist.item(0);
					readMetaData(metaElement);
				}
//				else {
//					System.out.println("No metadata section found!");
//				}

				// parse feature tree
				NodeList list = rootEle.getElementsByTagName("feature_tree");
				Element featureTreeEle = (Element)list.item(0);
				rootNode = parseFeatureTree(featureTreeEle.getTextContent());
				
				// parse constraints
				list = rootEle.getElementsByTagName("constraints");
				Element constraintsEle = (Element)list.item(0);
				String constraintsText = constraintsEle.getTextContent();
				parseConstraints(constraintsText);				
			}
			catch(FeatureModelException e) {
				throw e;
			}
			catch(ParserConfigurationException pce) {
				throw new FeatureModelException("XML error parsing SXFM file: " + pce.getMessage(), pce);
			}
			catch(SAXException se) {
				throw new FeatureModelException("XML SAX error parsing SXFM file: " + se.getMessage() , se);
			}
			catch(IOException ioe) {
				throw new FeatureModelException("Error reading SXFM file: " + ioe.getMessage(), ioe);
			}
		}
		return rootNode;
	}

	protected void readMetaData(Element metaElement) {
//		System.out.println(metaElement.getNodeName());
		NodeList nodeList = metaElement.getElementsByTagName("data");
		for( int i = 0 ; i < nodeList.getLength() ; i++ ) {
			Element element = (Element)nodeList.item(i);
			String name = element.getAttribute("name");
			String value = element.getTextContent();
//			System.out.println(">> " + name + ": " + value);
			addMetaData(name, value);
		}
	}
	
	protected void parseConstraints(String constraints) throws FeatureModelException {
		
		CNFClauseParser cnfClauseParser = new CNFClauseParser();
		
		Scanner scanner = new Scanner(constraints);
		String line = "";		
		while ( scanner.hasNextLine() ) {
			line = scanner.nextLine().trim();
			if ( line.trim().length() > 0 ) {
				int index1 = line.indexOf(":");
				if ( index1 != -1 ) {
					String constraintName = line.substring(0,index1).trim();
					String constraintFormula = line.substring(index1+1).trim();
					try {						
						CNFClause cnfClause = cnfClauseParser.parse(constraintFormula);
						for( BooleanVariableInterface var : cnfClause.getVariables() ) {
							if ( getNodeByID(var.getID()) == null ) {
								throw new FeatureModelException("Error parsing extra constraint labelled '" + constraintName + "' (variable id '" + var.getID() + "' used in the formula is not defined in the feature tree).");
							}
						}
						addConstraint(new PropositionalFormula(constraintName, cnfClause.toString2()));
					}
					catch(CNFClauseParseException e1) {
						throw new FeatureModelException("Error parsing extra constraint labelled '" + constraintName + "' (" + e1.getMessage() + "').", e1); 
					}
					catch(FeatureModelException e2) {
						throw e2; 
					}
					catch(Exception e3) {
						throw new FeatureModelException("Error parsing extra constraint labelled '" + constraintName + "' (Line: " + line + "').", e3); 
					}
				}
			}
		}
	}
	
	protected FeatureTreeNode parseFeatureTree( String featureTree ) throws IOException, FeatureModelException {
		FeatureTreeNode rootNode = null;
		Stack<FeatureTreeNode> nodeStack = new Stack<FeatureTreeNode>();
		
		//System.out.println(featureTree);
		LineNumberReader reader = new LineNumberReader(new StringReader(featureTree));		
		String line = skipBlanks(reader);
		
		List<FeatureTreeNode> processedNodes = new ArrayList<FeatureTreeNode>();
		
		try {
			while( line != null ) {
				FeatureTreeNode node = parseNode(line);

				while ( processedNodes.contains(node) ) {
					node.setID("_"+node.getID());
				}

				processedNodes.add(node);
				
				int level = countTabs(line);
				//	System.out.println(line);
				//System.out.println("Tabs: " + level);

				// root node goes to the Stack
				if ( rootNode == null && level == 0 ) {
					rootNode = node;
					nodeStack.push(node);
				}
				else {
					int curLevel = nodeStack.size()-1;
					// child node found
					if ( level > curLevel ) {
						FeatureTreeNode parent = nodeStack.peek();
						parent.add(node);
						nodeStack.push(node);
						// TODO: check if group cardinality is within boundaries
					}
					else if ( level == curLevel ) {
						nodeStack.pop();
						FeatureTreeNode parent = nodeStack.peek();
						parent.add(node);
						nodeStack.push(node);
					}
					// another branch found
					else {
						int countPops = curLevel - level +1;
						for( int i = 0 ; i < countPops ; i++ ) {
							nodeStack.pop();
						}
						FeatureTreeNode parent = nodeStack.peek();
						parent.add(node);
						nodeStack.push(node);
					}
				}
				
				nodesMap.put(node.getID(), node);
				
				line = skipBlanks(reader);		
			}
		}
		catch( FeatureModelException e1 ) {
			throw e1;
		}
		catch( Exception e2 ) {
			throw new FeatureModelException("Error parsing Feature Tree on line '" + line.trim() + "': " + e2.toString());
		}
		
		return rootNode;
	}
	
	private int countTabs(String line) {
		int count = 0;
		int index = line.indexOf('\t');
		while ( index != -1 ) {
			count++;
			index = line.indexOf('\t', index+1);
		}
		return count;
	}
	
	private FeatureTreeNode parseNode(String line) throws FeatureModelException {
		FeatureTreeNode node = null;
		int index = line.indexOf(':');
		// if it's a root, mandatory or optional feature
		if ( index != -1 ) {
			
			int findex1 = line.indexOf("(");
			int findex2 = line.indexOf(")");			
			int findex3 = line.indexOf("[");
			
			String nodeType = line.substring(index+1,index+2).trim().toUpperCase();
			
			if ( index== -1  || ( nodeType.length()>0 && !nodeType.equals("R") && !nodeType.equals("O") && !nodeType.equals("M") && !nodeType.equals("G")) ) {
				throw new FeatureModelException("Error parsing Feature Tree on line '" + line.trim() + "' (invalid node type). Valid node types are :r (root), :m (mandatory), :o (optional), :g (group), and : (grouped)");
			}
						
			String featureName = "";
			String featureID = "";
			
			// has ID
			if ( findex1 != -1 ) {
				featureID = line.substring(findex1+1, findex2);
				featureName = line.substring(index+2,findex1).trim();
				// has ID, doesn't have name: name = ID
				if ( featureName.length() == 0 ) {
					featureName = featureID;
				}
				// has ID, has name, ok.
			}
			// does not have ID, is a group
			else if ( findex3 != -1 ) {
				featureName = line.substring(index+2,findex3).trim();
				// does not have ID, doesn't have name: name = ID = automatic
				if ( featureName.length() == 0 ) {
					featureName = "_id_" + idCounter++;
					featureID = featureName.replace(' ', '_');
				}
				// does not have ID, has name: id = name or id = automatic
				else {
					if ( idCreationStrategy == USE_VARIABLE_NAME_AS_ID ) {
						featureID = featureName.replace(' ', '_');
					}
					else {
						featureID = "_id_" + idCounter++;
					}
				}
			}
			// does not have ID, is not a group
			else {
				featureName = line.substring(index+2).trim();
				// does not have ID, doesn't have name: name = ID = automatic
				if ( featureName.length() == 0 ) {
					featureName = "_id_" + idCounter++;
					featureID = featureName.replace(' ', '_');
				}
				// does not have ID, has name: id = name or id = automatic
				else {
					if ( idCreationStrategy == USE_VARIABLE_NAME_AS_ID ) {
						featureID = featureName.replace(' ', '_');
					}
					else {
						featureID = "_id_" + idCounter++;
					}
				}
			}
			
			// It's the ROOT feature (concept)
			if ( nodeType.compareToIgnoreCase("R") == 0 ) {
		        node = new RootNode( featureID, featureName, TreeNodeRendererFactory.createRootRenderer() );	            	
			}	
			// It's a MANDATORY feature
			else if ( nodeType.compareToIgnoreCase("M") == 0 ) {
		        node = new SolitaireFeature( false, featureID, featureName, TreeNodeRendererFactory.createMandatoryRenderer() );
			}
			// It's a OPTIONAL feature
			else if ( nodeType.compareToIgnoreCase("O") == 0 ) {
		        node = new SolitaireFeature( true, featureID, featureName, TreeNodeRendererFactory.createOptionalRenderer() );	            	
			}
			// It's a FEATURE GROUP
			else if ( nodeType.compareToIgnoreCase("G") == 0 ) {
				
				int index1 = line.indexOf('[', index);
				int index2 = line.indexOf(',', index1);
				int index3 = line.indexOf(']', index2 );
								
				int min = 1;
				int max = -1;
				// cardinality lower bound
				try { 
					min = Integer.parseInt(line.substring(index1+1,index2).trim());
				} 
				catch( NumberFormatException ex ) {
					throw new FeatureModelException("Error parsing Feature Tree on line '" + line.trim() + "' (invalid cardinality lower bound value). It must be a valid integer.");			
				}
				// cardinality upper bound
				try { 
					String upperBound = line.substring(index2+1,index3).trim();
					if (upperBound.equals("*")) {
						max = -1;
					}
					else {
						max = Integer.parseInt(upperBound);
					}
				} 
				catch( NumberFormatException ex ) {
					throw new FeatureModelException("Error parsing Feature Tree on line '" + line.trim() + "' (invalid cardinality upper bound value). It must be a valid integer.");			
				}
				//System.out.println("["+min+","+max+"]");

				node = new FeatureGroup( featureID, featureName, min,max,TreeNodeRendererFactory.createFeatureGroupRenderer() );
			}
			// It's assumed a GROUPED feature
			else {
		        node = new GroupedFeature( featureID, featureName, TreeNodeRendererFactory.createGroupedRenderer() );
			}
		}
		return node;
	}
	
	private String skipBlanks(LineNumberReader reader) throws IOException {
		String line = reader.readLine();
		while( line != null && line.length() == 0) {
			line = reader.readLine();
		}
		return line;
	}
	
	protected void saveNodes() {		
	}  
}
