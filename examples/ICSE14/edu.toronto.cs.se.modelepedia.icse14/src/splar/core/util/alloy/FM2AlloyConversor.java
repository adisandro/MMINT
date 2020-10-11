package splar.core.util.alloy;

import java.util.Iterator;
import java.util.LinkedList;

import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.SolitaireFeature;


public class FM2AlloyConversor {

	private static String header = 
		"\r\n//Header Declarations\r\n\n" +
		"sig FM {" + "\r\n" +
		"	features: set Name" + "\r\n" +
		"}" + "\r\n" +
		"sig Name {}" + "\r\n" +
		"pred optional[A,B:Name, conf:set Name] {" + "\r\n" +
		"	B in conf => A in conf" + "\r\n" +
		"}" + "\r\n" +
		"pred mandatory[A,B:Name, conf:set Name] {" + "\r\n" +
		"	A in conf <=> B in conf" + "\r\n" +
		"}" + "\r\n" +
		"pred root[A:Name, conf: set Name] {" + "\r\n" +
		"	A in conf" + "\r\n" +
		"}" + "\r\n" +
		"pred orFeature[A,B,C:Name, conf: set Name] {" + "\r\n" +
		"	A in conf <=> (B in conf) or (C in conf)" + "\r\n" +
		"}" + "\r\n" +
		"pred alternativeFeature[A,B,C:Name, conf: set Name] {" + "\r\n" +
		"	orFeature[A,B,C,conf]" + "\r\n" +
		"	B in conf => C !in conf" + "\r\n" +
		"	C in conf => B !in conf" + "\r\n" +
		"}" + "\r\n";
		
	
	public FM2AlloyConversor() {}
		
	public static String convert(FeatureModel fm, boolean includeHeader) {
		
		String alloy = "";
		
		if ( includeHeader ) {
			alloy += header;
		}
		
		// declares feature model
		alloy += 
			"\r\n\n// Feature Model Declaration\r\n\r\n" +
			"one sig " + fm.getName() + " extends FM {}\r\n";
		
		// declare features 
		alloy += "one sig ";
		for( Iterator<FeatureTreeNode> it = fm.getNodes().iterator() ; it.hasNext() ;  ) {
			FeatureTreeNode feature = it.next();
			if ( !(feature instanceof FeatureGroup) ) {
				alloy += feature.getID();
				if ( it.hasNext() ) {
					alloy += ",";
				}
			}
		}
		
		alloy += " extends Name {}\r\n";
		
		// add features to the feature model  
		alloy += "fact " +fm.getName() + "Features {\r\n" +
				 "\t" + fm.getName() + ".features = ";
		for( Iterator<FeatureTreeNode> it = fm.getNodes().iterator() ; it.hasNext() ;  ) {
			FeatureTreeNode feature = it.next();
			if ( !(feature instanceof FeatureGroup) ) {
				alloy += feature.getID();
				if ( it.hasNext() ) {
					alloy += "+";
				}
			}
		}
		alloy += "\r\n}\r\n";
		
		// add feature model semantics: constraints		
		alloy += "pred semantics" + fm.getName() + "[conf: set Name] {\r\n" +
				 "	conf in " + fm.getName() + ".features\r\n";
		
		// root node
		alloy += "	root[" + fm.getRoot().getID() + ",conf]\r\n";
		
		// feature tree constraints
		alloy += FT2Alloy(fm); 
			
		// extra constraints
		
		alloy += "}\r\n"; 

		return alloy;
	}
	
	private static String FT2Alloy(FeatureModel fm) {
		
		String output = "";
		
		LinkedList<FeatureTreeNode> features = new LinkedList<FeatureTreeNode>();
		features.add(fm.getRoot());		
		
		while( !features.isEmpty() ) {
			
			FeatureTreeNode feature = features.getFirst();
			features.removeFirst();
			
			for( int i = 0 ; i < feature.getChildCount() ; i++ ) {
				FeatureTreeNode childFeature = (FeatureTreeNode)feature.getChildAt(i);
				if ( childFeature instanceof SolitaireFeature ) {
					// optional?
					if ( ((SolitaireFeature)childFeature).isOptional() ) {
						output += "	optional[" + feature.getID() + "," + childFeature.getID() +",conf]\r\n";
					}
					// mandatory
					else {
						output += "	mandatory[" + feature.getID() + "," + childFeature.getID() +",conf]\r\n";
					}

					features.add(childFeature);
					
				}
				else if ( childFeature instanceof FeatureGroup ) {
					FeatureGroup group = (FeatureGroup)childFeature;
					FeatureTreeNode parent = (FeatureTreeNode)group.getParent(); 
					
					// [1] - exclusive-OR
					if ( group.getMax() == 1 && group.getMax() == 1 ) {
						output += "	alternativeFeature[" + parent.getID() +",";
					}
					// [1,*] - inclusive-OR
					else if ( group.getMax() == -1 || group.getMax() == group.getChildCount() ) {
						output += "	orFeature[" + parent.getID() +",";
					}
					
					int childCount = group.getChildCount() ;
					for( int j = 0 ; j < childCount ; j++ ) {
						FeatureTreeNode groupedFeature = (FeatureTreeNode)group.getChildAt(j);
						output += groupedFeature.getID();
						output += ",";
						features.add(groupedFeature);
//						for( int k = 0 ; k < groupedFeature.getChildCount() ; k++ ) {
//							features.add((FeatureTreeNode)groupedFeature.getChildAt(k));
//						}
					}
					
					output += "conf]\r\n"; 
					
				}
			}
						
		}
		
		return output;
	}
}
