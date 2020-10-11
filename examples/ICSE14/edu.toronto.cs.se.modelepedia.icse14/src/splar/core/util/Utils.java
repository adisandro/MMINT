package splar.core.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sf.javabdd.BDD;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import splar.core.constraints.BooleanVariableInterface;
import splar.core.fm.FeatureGroup;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureTreeNode;
import splar.core.fm.clustering.FTCluster;
import splar.core.heuristics.VariableOrderingHeuristic;

public class Utils {
	
	public static String generateBDDFile(String path, String variables[], BDD bdd, String fileName, FeatureModel fm, Map<String,String> parameters) {
		PrintStream savedOut = System.out;
		
		try {
			// convert nodes labels from numbers to names in the BDD dot file
			ByteArrayOutputStream outByte = new ByteArrayOutputStream();
			PrintStream out1 = new PrintStream(outByte);			
			System.setOut(out1);
			bdd.printDot();
			BufferedReader reader = new BufferedReader(new StringReader(outByte.toString()));
	
			// create output file
			FileWriter writer = new FileWriter(path+fileName+".dot");
	
			// skip header and unuseful data
			String line = reader.readLine();			
			for( int i = 0 ; i < 3 ; i++ ) {
				writer.write(line);
				line = reader.readLine();
			}
			
			writer.write("\tlabelloc=\"t\";");

			writer.write("\tlabel=\"Feature Model: " + fm.getName() + " (" + parameters.get("heuristic_name") + ")" +
					"\\n" +
					" (BDD size: " + parameters.get("bdd_size") +
					", BDD paths: " + parameters.get("bdd_paths") +
					", Span: " + parameters.get("clause_span") +
					")\";");

			String newLine = "";
			while( line != null ) {
				newLine = adjustDotFileLines(variables, line);
				writer.write(newLine);
				line = reader.readLine();
			}
			writer.close();
			out1.close();			
			System.setOut(savedOut);
			
			try {
				// generates BDD JPG file from dot file
				Process p = Runtime.getRuntime().exec("dot -Tjpg " + path+fileName+".dot -o "+path+fileName+".jpg");
				p.waitFor();
				return path+fileName+".jpg";
			}
			catch(InterruptedException ie) {				
			}
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String adjustDotFileLines(String variables[], String line){
		
		String newLine = null;
		try {
			if ( line.indexOf("label=") != -1 ) {
				int index1 = line.indexOf("\"");
				int index2 = line.indexOf("]");
				if( index1 != -1 && index2 != -1 ) {
					String label = line.substring(index1+1, index2-1);
					int varID = Integer.valueOf(label).intValue();
					String strVarID = variables[varID];
					if ( strVarID != null ) {
						newLine = line.substring(0,index1) + "\"" + strVarID + "\"];";
					}
				}
			}
		}
		catch( Exception e ) {
		}
		return (newLine == null ? line : newLine);
	}
	
	public static JPanel generateImageVisualizationPanel(String path, int width, int height, int scaling) {
		JPanel panel = new JPanel(new BorderLayout());
		try {
			Image image = ImageIO.read(new File(path));
	        // Read from an input stream
	        InputStream is = new BufferedInputStream(new FileInputStream(path));
	        image = ImageIO.read(is);
						
			ImageIcon icon = new ImageIcon(path);
	//		icon.setImage(icon.getImage().getScaledInstance(width, height, scaling));
			icon.setImage(image);
			JLabel label = new JLabel(icon);				
			panel.setBackground(Color.white);
			panel.add(label, BorderLayout.CENTER );
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		return panel;
	}

	public static String generateFTDependencyViewDotFile(String path, String fileName, FeatureModel fm, Map<String,FTCluster> view, String heuristicName, String variableOrder[]) {
		try {
	
			System.out.println("Generating file: " + path+fileName+".dot");
			Map<String,Integer> mapVarOrder = null;
			if ( variableOrder != null ) {
				mapVarOrder = VariableOrderingHeuristic.variableOrderingAsHashMap(variableOrder);;
			}
			// create output file
			PrintWriter writer = new PrintWriter(new FileWriter(path+fileName+".dot"));
	
			// skip header and unuseful data
			writer.println("graph G {\n");
			writer.println("\t compound=true;");
			if ( variableOrder != null ) {
				writer.println("\tlabelloc=\"t\";");
				int span = fm.FM2CNF().calculateClauseSpan(mapVarOrder);
				writer.println("\tlabel=\"Feature Model: " + fm.getName() + "\\n" + heuristicName + "\\n" + "Total Clause Span: " + span +"\";");
			}
			else {
				writer.println("\tlabelloc=\"t\";");
				writer.println("\tlabel=\"Feature Model: " + fm.getName() + "\";");
			}
			
			List<String> clusterDep = new Vector<String>();
			for( String clusterRoot: view.keySet() ) {
				
				// root
				writer.println("\tsubgraph cluster_" + clusterRoot + " {");
				writer.println("\t\tlabel=\"" + clusterRoot +":["+(fm.getNodeLevel(clusterRoot)+1)+"]\";");
				writer.println("\t\tnode [style=\"setlinewidth(1)\",filled];");
				writer.println("\t\tcolor=black;");
				
				FTCluster cluster = view.get(clusterRoot);
//				FeatureTreeNode ancestor = cluster.getAncestor();
//				if ( ancestor != null ) {
////					clusterDep.add("\tcluster_" + clusterRoot + " -- " + cluster.getAncestor().getID());
//				}
				
				if ( variableOrder != null ) {
					String relativeVariableOrder[] = calculateRelativeVariableOrder(cluster, variableOrder);
					int i = 1;
					for( String childID : relativeVariableOrder ) {
						String varRelOrderStr = String.valueOf(i++) + ":";
						writer.println("\t\t"+childID + " [label=\"" + varRelOrderStr + childID + "(" + (fm.countNodes(fm.getNodeByID(childID))-1) + ")\"]" );
					}
				}
				else {
					for( FeatureTreeNode child : cluster.getChildren() ) {
						String childID = child.getID();
						writer.println("\t\t"+childID + " [label=\"" + childID + "(" + (fm.countNodes(fm.getNodeByID(childID))-1) + ")\"]" );
					}
				}

				// children relations
				for( int i = 0 ; i < cluster.getClusterNodesRelations().size() ; i++ ) {
					List<FeatureTreeNode> dependency = cluster.getClusterNodesRelations().get(i);
					List<BooleanVariableInterface> clauseDependency = cluster.getClauseNodesRelations().get(i);
					String depStr = "\t\t";
					int varsDistance = 0;
					for( int j = 0 ;  j < dependency.size() ; j++ ) {
						FeatureTreeNode node = dependency.get(j);
						BooleanVariableInterface clauseVar = clauseDependency.get(j);
						depStr += node.getID();
						if ( j < (dependency.size()-1) ) {
							depStr += " -- ";
						}			
						if ( variableOrder != null ) {
							varsDistance = Math.abs( varsDistance - mapVarOrder.get(clauseVar.getID()).intValue()); 
						}
					}
					String absOrderStr = "";
					if ( variableOrder != null ) {
						absOrderStr = ""+varsDistance;
					}
					writer.println(depStr + " [label=\""+ absOrderStr + "\",color=\"blue\"]");
				}
//				for( List<FeatureTreeNode> dependency : cluster.getClusterNodesRelations() ) {
//					String depStr = "\t\t";
//					for( Iterator<FeatureTreeNode> it = dependency.iterator() ; it.hasNext() ;  ) {
//						FeatureTreeNode node = it.next();
//						depStr += node.getID();
//						if ( it.hasNext() ) {
//							depStr += " -- ";
//						}						
//					}
//					String absOrderStr = "";
//					if ( variableOrder != null ) {
//						
//					}
//					writer.println(depStr + " ["+ absOrderStr + "color=\"blue\"]");
//				}
				
				writer.println("\t}");
			}
			
			for( String line : clusterDep ) {
				writer.println(line);
			}
			
			writer.println("}");
			writer.close();
			
			try {
				// generates BDD JPG file from dot file
				System.out.println("running: dot -Tjpg " + path+fileName+".dot -o "+path+fileName+".jpg");  
				Process p = Runtime.getRuntime().exec("dot -Tjpg " + path+fileName+".dot -o "+path+fileName+".jpg");
				p.waitFor();
				return path+fileName+".jpg";
			}
			catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}	
	
	private static String[] calculateRelativeVariableOrder(FTCluster cluster, String variableOrder[]) {
		
		String relativeVariableOrder[] = new String[cluster.getChildren().size()];
		try {
			List<FeatureTreeNode> children = new ArrayList<FeatureTreeNode>();
			children.addAll(cluster.getChildren());
			int index = 0;
			for( String varName : variableOrder ) {			
				for( int i = 0 ; i < children.size() ; i++ ) {
					FeatureTreeNode childNode = children.get(i);
					if ( childNode instanceof FeatureGroup ) {
						for( int j = 0 ; j < childNode.getChildCount() ; j++ ) {
							FeatureTreeNode groupedNode = (FeatureTreeNode)childNode.getChildAt(j);
							if ( varName.compareTo(groupedNode.getID()) == 0) {
								relativeVariableOrder[index++] = childNode.getID();
								children.remove(i);
								break;
							}						
						}
					}
					else {
						if ( varName.compareTo(childNode.getID()) == 0) {
							relativeVariableOrder[index++] = varName;
							children.remove(i);
							break;
						}					
					}
				}
			}
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		return relativeVariableOrder;
	}
}
