/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.reasoning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.ConstList;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.CommandScope;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.PrimSig;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprVar;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprConstant;
import edu.mit.csail.sdg.alloy4compiler.ast.Func;
import edu.mit.csail.sdg.alloy4compiler.ast.Expr;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import edu.mit.csail.sdg.alloy4viz.VizGUI;
import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4.Pos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;

/**
 * This class will take a MAVO model and run the RNF algorithm on it to produce
 * the RNF version of the input model. Specifically, this class will parse the
 * output of a TXL generated translation of an eCore MAVO model into memory, and
 * execute the algorithm. Commands and model elements may be added or removed
 * during the process and concretizations will be analysed during the process.
 */
public class AlloyChecker extends OperatorExecutableImpl {

	private static final String ALLOY_FILEEXTENSION = ".als";
	private static final String PROPERTY_IN_ALGORITHM = "algorithm";
	private static final String PROPERTY_IN_CONSTRAINEDNESS = "constrainedness";
	private static final String PROPERTY_IN_SCOPE = "scope";
	private static final String PROPERTY_OUT_TIME = "time";

	private String algorithm;
	private static double constrainedness;
	private static int scope;

	private static String allButOne (HashMap<String, String> map, String exception){
		Set<String> keys = map.keySet();
		String type = map.get(exception);
		String out = "";
		boolean first = true;
		for(String key: keys){
			if(map.get(key).equals(type)){
				if(!key.equals(exception)){
					if(first){
						out = key + " ";
						first = false;
					} else {
						out = out + " + " + key + " ";
					}
				}
			}
		}
		return out;
	}

	private static long makeANF(String[] args) throws Err {

		try {
			long startTime = System.nanoTime();

			int loopCounter = 0;
			System.out.println("Constrainedness: " + constrainedness);

			// The visualizer (We will initialize it to nonnull when we visualize an Alloy solution)
			VizGUI viz = null;

			// Alloy4 sends diagnostic messages and progress reports to the A4Reporter.
			// By default, the A4Reporter ignores all these events (but you can extend the A4Reporter to display the event for the user)
			A4Reporter rep = new A4Reporter() {
				// For example, here we choose to display each "warning" by printing it to System.out
				@Override public void warning(ErrorWarning msg) {
					System.out.print("Relevance Warning:\n"+(msg.toString().trim())+"\n\n");
					System.out.flush();
				}
			};

			int numFiles = args.length;

			for(int i = 0; i < numFiles; i++) {
				String filename = args[i];
				String csv = "START";


				// Parse+typecheck the model
				System.out.println("=========== Parsing+Typechecking "+filename+" =============");
				Module world = CompUtil.parseEverything_fromFile(rep, null, filename); //originally filname.

				HashMap<String, String> types = new HashMap();
				//Get types
				Scanner typeGetter = new Scanner(new File(filename));
				while(typeGetter.hasNextLine()){
					String nextLine = typeGetter.nextLine();
					Scanner lineParser = new Scanner(nextLine);
					while(lineParser.hasNext()){
						String firstWord = lineParser.next();
						if(firstWord.equals("sig")){
							String sigName = lineParser.next();
							lineParser.next(); //clear the "in"
							String sigType = lineParser.next();
							
							types.put("this/" + sigName, sigType);
						} else {
							break;
						}
					}
				}
				typeGetter.close();
				
				
				SafeList<Sig> userDefinedSigs = world.getAllSigs();
				Sig initialSig = userDefinedSigs.get(0);
				Sig hardSig = userDefinedSigs.get(0);

				boolean needHard = true;
				for(Sig asi:userDefinedSigs){
					if((asi.label.indexOf("__M") == -1) && (asi.label.indexOf("__V") == -1) && (asi.label.indexOf("__S") == -1)  ){
						initialSig = asi;
					}
					if((asi.label.indexOf("__M") < 0) || (asi.label.indexOf("__V") < 0) || (asi.label.indexOf("__S") < 0)  ){
						if (needHard == true){
							if((asi.label.indexOf("__M") >= 0) || (asi.label.indexOf("__V") >= 0) || (asi.label.indexOf("__S") >= 0)  ){
								needHard = false;
									hardSig = asi;
									needHard = false;

							}

						}
					}
				}
				SafeList<Sig> impliedSigs = new SafeList();
				int numImplied = (int) Math.round(constrainedness*(userDefinedSigs.size()));
				System.out.println("Expected number of annotations to add is at least: " + numImplied);
				int sigCounterLoop = 0;
				for(Sig asi:userDefinedSigs){
					if(sigCounterLoop == numImplied){
						break;
					}
					if(!asi.equals(initialSig)){
						if(!asi.label.equals("this/Nodes") && !asi.label.startsWith("this/end") &&  !asi.label.startsWith("this/AEn")  &&  !asi.label.startsWith("this/BEn")  &&  !asi.label.startsWith("this/End")   && !asi.label.equals("this/Edges") && !asi.label.equals("this/Source")  && !asi.label.equals("this/Target")){
							if((asi.label.indexOf("__M") >= 0) || (asi.label.indexOf("__V") >= 0) || (asi.label.indexOf("__S") >= 0)  ){
								impliedSigs.add(asi);
								sigCounterLoop++;
							}
						}
					}

				}
				Expr toAdd = null;
				String toAddStr = "";
				if(impliedSigs.size() == 0){
					toAdd = ExprConstant.TRUE;
					toAddStr = "false";//never actually gets "False", is overriden later
				} else if(impliedSigs.size() == 1){
					//In this case; only the hard sig can be determined.
					toAdd = ExprConstant.TRUE;
					toAddStr = "false"; //never actually gets "False", is overriden later
				} else {
					String firstLabel = impliedSigs.get(1).label;
					Sig firstSig = impliedSigs.get(1);
					if(firstLabel.indexOf("__M") >= 0) {
						//May
						toAdd = impliedSigs.get(1).some().not();
						toAddStr = toAddStr + "(some " + firstLabel + ")"; 
						if(firstLabel.indexOf("__V") >= 0){
							//MV
							String test = "(some x: " + types.get(firstLabel) + " | x in "
									+ firstSig.label + " and x in ("
									+ allButOne(types, firstLabel) + "))";
							Expr hardExprTest = world.parseOneExpressionFromString(test);
							toAdd = toAdd.or(hardExprTest);
							toAddStr = toAddStr + " or " + test; 
							if(firstLabel.indexOf("__S") >= 0){
								//MSV
								toAdd.or(firstSig.cardinality().lte(ExprConstant.ONE).not());
								toAddStr = toAddStr + "or (#" + firstLabel + " <= 1)";
							}
						}
					} else if(firstLabel.indexOf("__S") >= 0){
						//S
						toAdd = firstSig.cardinality().lte(ExprConstant.ONE).not();
						toAddStr = toAddStr + "(#" + firstLabel + " <= 1)";
						if(firstLabel.indexOf("__V") >= 0){
							//SV
							String test = "(some x: " + types.get(firstLabel) + " | x in "
									+ firstSig.label + " and x in ("
									+ allButOne(types, firstLabel) + "))";
							Expr hardExprTest = world.parseOneExpressionFromString(test);
							toAdd = toAdd.or(hardExprTest);
							toAddStr = toAddStr + " or " + test;
						}
					} else if(firstLabel.indexOf("__V") >= 0){
						//V
						String test = "(some x: " + types.get(firstLabel) + " | x in "
								+ firstSig.label + " and x in ("
								+ allButOne(types, firstLabel) + "))";
						Expr hardExprTest = world.parseOneExpressionFromString(test);
						toAdd = hardExprTest;
						toAddStr = toAddStr + test; 
					}

					for(int q = 2; q < impliedSigs.size(); q++){
						Sig nextSig = impliedSigs.get(q);
						String nextLabel = nextSig.label;
						if(nextLabel.indexOf("__M") >= 0) {
							//May
							Expr toAddB = impliedSigs.get(q).some().not();
							toAddStr = toAddStr + "or (some " + nextLabel + ")"; 
							if(nextLabel.indexOf("__V") >= 0){
								//MV
								String test = "(some x: " + types.get(firstLabel) + " | x in "
										+ firstSig.label + " and x in ("
										+ allButOne(types, firstLabel) + "))";
								Expr hardExprTest = world.parseOneExpressionFromString(test);

								toAddB = toAdd.or(hardExprTest); 
								toAddStr = toAddStr + " or " + test; 
								if(nextLabel.indexOf("__S") >= 0){
									//MSV
									toAddB = toAddB.or(nextSig.cardinality().equal(ExprConstant.ONE).not());
									toAddStr = toAddStr + " or (#" + nextLabel + " <= 1)";

								}
							}
							if(toAdd == null) {
								toAdd = toAddB;
							} else {
								toAdd = toAdd.or(toAddB);
							}
						} else if(nextLabel.indexOf("__S") >= 0){
							//S
							Expr toAddB = nextSig.cardinality().lte(ExprConstant.ONE);
							toAddStr = toAddStr + "or (#" + nextLabel + " <= 1)";

							if(nextLabel.indexOf("__V") >= 0){
								//SV
								String test = "(some x: " + types.get(firstLabel) + " | x in "
										+ firstSig.label + " and x in ("
										+ allButOne(types, firstLabel) + "))";
								Expr hardExprTest = world.parseOneExpressionFromString(test);
								toAddB = hardExprTest; 
								toAddStr = toAddStr + " or " + test;
							}
							if(toAdd == null) {
								toAdd = toAddB;
							} else {
								toAdd = toAdd.or(toAddB);
							}
						} else if(nextLabel.indexOf("__V") >= 0){
							//V
							String test = "(some x: " + types.get(firstLabel) + " | x in "
									+ firstSig.label + " and x in ("
									+ allButOne(types, firstLabel) + "))";
							Expr hardExprTest = world.parseOneExpressionFromString(test);

							Expr toAddB = hardExprTest; 
							toAddStr = toAddStr + " or " + test; 
							if(toAdd == null) {
								toAdd = toAddB;
							} else {
								toAdd = toAdd.or(toAddB);
							}
						}
					}
				}


				SafeList<Sig> iffs = new SafeList();
				int sigCounterLoopB = 0;
				for(Sig asi:userDefinedSigs){
					if(sigCounterLoopB == numImplied){
						break;
					}
					if(!asi.equals(initialSig)){
						if(!asi.label.equals("this/Nodes") && !asi.label.equals("this/Edges") && !asi.label.equals("this/Source")  && !asi.label.equals("this/Target") && !asi.label.startsWith("this/end") &&  !asi.label.startsWith("this/AEn")  &&  !asi.label.startsWith("this/BEn")  &&  !asi.label.startsWith("this/End") ) {
							if((asi.label.indexOf("__M") < 0) || (asi.label.indexOf("__V") < 0) || (asi.label.indexOf("__S") < 0)  ){
								if(!asi.label.equals(hardSig.label)){
									iffs.add(asi);
									sigCounterLoopB++;
								}
							}
						}
					}

				}
				int impliedAddCounter = 0;
				HashSet<String> callsForB  = new HashSet();
				SafeList<Func> worldFunctions = world.getAllFunc();
				HashSet<Expr> iffStatementBodies = new HashSet();
				HashSet<String> iffStatementCalls = new HashSet();
				for(Sig iffSig: iffs){

					String ids = iffSig.label.substring(5,iffSig.label.length()) + "[]";
					String id = iffSig.label.substring(5,iffSig.label.length());
					String calls = "";
					Expr exprCall = null;
					if((iffSig.label.indexOf("__M") < 0) && (iffSig.label.indexOf("__V") < 0) && (iffSig.label.indexOf("__S") < 0)  ){
						//None
						if(impliedAddCounter + 3 <= numImplied){
							String call1 = "this/exists_" + id;
							String call2 = "this/unique_" + id;
							String call3 = "this/distinct_" + id;
							callsForB.add(call1);
							callsForB.add(call2);
							callsForB.add(call3);
							Expr body1 = null;
							Expr body2 = null;
							Expr body3 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} else if(fu.label.equals(call2)){
									body2 = fu.getBody();
								} else if(fu.label.equals(call3)){
									body3 = fu.getBody();
								}
							}

							if(body2 == null || body3 == null){
								System.err.println("uh oh");
							}
							exprCall = body1.or(body2).or(body3);

							calls = "exists_" + id + " or unique_" + id + " or distinct_" + id;

							impliedAddCounter = impliedAddCounter + 3;
						} else if (impliedAddCounter + 2 <= numImplied){
							calls = "exists_" + id + " or unique_" + id;

							String call1 = "this/exists_" + id;
							String call2 = "this/unique_" + id;
							callsForB.add(call1);
							callsForB.add(call2);
							Expr body1 = null;
							Expr body2 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} else if(fu.label.equals(call2)){
									body2 = fu.getBody();
								}
							}
							exprCall = body1.or(body2);

							impliedAddCounter = impliedAddCounter + 2;
						} else if (impliedAddCounter + 1 <= numImplied){
							calls = "exists_" + id;
							impliedAddCounter = impliedAddCounter + 1;

							String call1 = "this/exists_" + id;
							callsForB.add(call1);

							Expr body1 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} 
							}
							exprCall = body1;


						} else {
							calls = calls;
						}
					}else if ((iffSig.label.indexOf("__M") < 0) && (iffSig.label.indexOf("__V") < 0) && (iffSig.label.indexOf("__S") >= 0)  ){
						//Set only
						if(impliedAddCounter + 2 <= numImplied){
							calls = "exists_" + id + " or distinct_" + id;

							String call1 = "this/exists_" + id;
							String call2 = "this/distinct_" + id;
							callsForB.add(call1);
							callsForB.add(call2);
							Expr body1 = null;
							Expr body2 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} else if(fu.label.equals(call2)){
									body2 = fu.getBody();
								}
							}
							exprCall = body1.or(body2);

							impliedAddCounter = impliedAddCounter + 2;
						} else if (impliedAddCounter + 1 <= numImplied){
							calls = "exists_" + id;
							impliedAddCounter = impliedAddCounter + 1;

							String call1 = "this/exists_" + id;
							callsForB.add(call1);

							Expr body1 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} 
							}
							exprCall = body1;
						} else { 
							calls = calls;
						}
					}else if ((iffSig.label.indexOf("__M") < 0) && (iffSig.label.indexOf("__V") >= 0) && (iffSig.label.indexOf("__S") < 0)  ){
						//Var only
						if(impliedAddCounter + 2 <= numImplied){
							calls = "exists_" + id + " or unique_" + id;
							impliedAddCounter = impliedAddCounter + 2;

							String call1 = "this/exists_" + id;
							String call2 = "this/unique_" + id;
							callsForB.add(call1);
							callsForB.add(call2);
							Expr body1 = null;
							Expr body2 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} else if(fu.label.equals(call2)){
									body2 = fu.getBody();
								}
							}
							exprCall = body1.or(body2); //post-ICSE: the code prevously from the "or" onward commented out.

						} else if (impliedAddCounter + 1 <= numImplied){
							calls = "exists_" + id;
							impliedAddCounter = impliedAddCounter + 1;

							String call1 = "this/exists_" + id;
							callsForB.add(call1);

							Expr body1 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} 
							}
							exprCall = body1;
						} else {
							calls = calls;
						}
					}else if ((iffSig.label.indexOf("__M") < 0) && (iffSig.label.indexOf("__V") >= 0) && (iffSig.label.indexOf("__S") >= 0)  ){
						//Set and Var
						if (impliedAddCounter + 1 <= numImplied){
							calls = "exists_" + id;
							impliedAddCounter = impliedAddCounter + 1;

							String call1 = "this/exists_" + id;
							callsForB.add(call1);

							Expr body1 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} 
							}
							exprCall = body1;
						} else {
							calls = calls;
						}
					}else if ((iffSig.label.indexOf("__M") >=  0) && (iffSig.label.indexOf("__V") < 0) && (iffSig.label.indexOf("__S") < 0)  ){
						//May Only
						if(impliedAddCounter + 2 <= numImplied){
							calls = "unique_" + id + " or distinct_" + id;
							impliedAddCounter = impliedAddCounter + 2;

							String call1 = "this/unique_" + id;
							String call2 = "this/distinct_" + id;
							callsForB.add(call1);
							callsForB.add(call2);
							Expr body1 = null;
							Expr body2 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} else if(fu.label.equals(call2)){
									body2 = fu.getBody();
								}
							}
							exprCall = body1.or(body2);

						} else if (impliedAddCounter + 1 <= numImplied){
							calls = "unique_" + id;
							impliedAddCounter = impliedAddCounter + 1;


							String call1 = "this/unique_" + id;
							callsForB.add(call1);

							Expr body1 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} 
							}
							exprCall = body1;
						} else {
							calls = calls;
						}
					}else if ((iffSig.label.indexOf("__M") >=  0) && (iffSig.label.indexOf("__V") < 0) && (iffSig.label.indexOf("__S") >=  0)  ){
						//May and Set
						if (impliedAddCounter + 1 <= numImplied){
							calls = "distinct_" + id; 
							impliedAddCounter = impliedAddCounter + 1;

							String call1 = "this/distinct_" + id;
							callsForB.add(call1);

							Expr body1 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} 
							}
							exprCall = body1;
						} else {
							calls = calls;
						}
					}else if ((iffSig.label.indexOf("__M") >=  0) && (iffSig.label.indexOf("__V") >=  0) && (iffSig.label.indexOf("__S") < 0)  ){
						//May and Var
						if (impliedAddCounter + 1 <= numImplied){
							calls = "unique_" + id;
							impliedAddCounter = impliedAddCounter + 1;

							String call1 = "this/unique_" + id;
							callsForB.add(call1);

							Expr body1 = null;
							for(Func fu: worldFunctions){
								if(fu.label.equals(call1)){
									body1 = fu.getBody();
								} 
							}
							exprCall = body1;
						} else {
							calls = calls;
						}
					}else if ((iffSig.label.indexOf("__M") >=  0) && (iffSig.label.indexOf("__V") >=  0) && (iffSig.label.indexOf("__S") >=  0)  ){
						//May, Set, and Var
						//Should never happen.
						calls = calls;
						System.err.println("Error - bad code executed in generating WFF");
					}
					iffStatementCalls.add(calls);
					iffStatementBodies.add(exprCall);

				}

				String FinalIFFList = "";
				boolean firstInList = true;
				for(String iffCall: iffStatementCalls){
					if(firstInList){
						if (!iffCall.equals("")){
							FinalIFFList = iffCall;
							firstInList = false;
						}
					} else {
						if (!iffCall.equals("")){
							FinalIFFList = FinalIFFList + " or " + iffCall;
						}
					}
				}

				Expr finalIFFExpr = null;
				boolean firstInListE = true;
				for(Expr iffCallE: iffStatementBodies){
					if(firstInListE){
						if (iffCallE != null){
							finalIFFExpr = iffCallE;
							firstInListE = false;
						}
					} else {
						if (iffCallE != null){
							finalIFFExpr = finalIFFExpr.or(iffCallE);
						}
					}
				}
				if (finalIFFExpr != null){
				}



				String hardSigName = hardSig.label.substring(5, hardSig.label.length()); 
				String hardSigAnnotation = "";
				Expr hardExpr = ExprConstant.TRUE;
				String hardStrToAdd = "";
				if (hardSigName.indexOf("__M") >= 0){
					hardSigAnnotation = "M";
					hardExpr = hardSig.some();
					hardStrToAdd = " (some " + hardSig.label + ")";
				} else if (hardSigName.indexOf("__S") >= 0){
					hardSigAnnotation = "S";
					hardStrToAdd = " (#" + hardSig.label + " <= 1)";
					hardExpr = hardSig.cardinality().lte(ExprConstant.ONE);
				} else if (hardSigName.indexOf("__V") >= 0){
					hardSigAnnotation = "V";
					String test = "(some x: " + types.get(hardSig.label) + " | x in "
							+ hardSig.label + " and x in ("
							+ allButOne(types, hardSig.label) + "))";
					Expr hardExprTest = world.parseOneExpressionFromString(test);
					hardStrToAdd = test;
					hardExpr = hardExprTest;
				}
				String finalIFF = "((" + FinalIFFList + ") implies " + hardStrToAdd + ")"; 


				if (toAdd == null) {
					System.err.println("Error generating WFF constraints...terminating,");
					return (long) -1;

				} else {
					toAddStr = finalIFF; 


					if(impliedSigs.size() == 0){
						toAdd =  (hardExpr).implies(hardExpr);
						toAddStr = hardStrToAdd + " implies ( " + hardStrToAdd + ")";
					} else if(impliedSigs.size() == 1){
						toAdd =  (hardExpr).implies(hardExpr);
						toAddStr = hardStrToAdd + " implies ( " + hardStrToAdd + ")";
					} else {
						toAdd = finalIFFExpr.implies(hardExpr);
					}

				}

				//get list of other annotations
				int maxNumAnnotations = 1; 
				String[] elements = new String[maxNumAnnotations];
				String[] annotations = new String[maxNumAnnotations];
				
				
				elements[0] = hardSigName;
				annotations[0] = hardSigAnnotation;
				
				Scanner sc = new Scanner(new File(filename));
				int scanCounter = 1;
				int arrayPosCounter = 1;

				HashMap<Integer,String> positionsInFile = new HashMap();
				HashMap<Integer,String> originalPositionsInFile = new HashMap();
				HashMap<String,Integer> inverseOriginalMap = new HashMap();
				int lineNumber = 0;
				boolean inFinal = false;
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					if (line.equals ("fact final {")){
						inFinal = true;
					}
					if (inFinal && line.equals("}")){
						inFinal = false;
					}
					if (inFinal){
						positionsInFile.put(new Integer(lineNumber), line);
						originalPositionsInFile.put(new Integer(lineNumber), line);
						inverseOriginalMap.put(line, new Integer(lineNumber));


					}
					lineNumber++;
				}
				sc.close();


				A4Options options = new A4Options();
				options.solver = A4Options.SatSolver.MiniSatProverJNI; //Solver can be changed, e.g. for UNSAT core computation.
				options.coreMinimization = 0;
				SafeList<Sig> allSigsInitial = world.getAllSigs();
				ArrayList<Sig> allSigs = (ArrayList)(world.getAllSigs()).makeCopy(); //This is annotations(P) (and more, which will be skipped)

				for(int j = 0; j < arrayPosCounter; j++){
					//main loop
					System.out.println("============ Testing base + " + elements[j] + "'s \"" + annotations[j] + "\": ============");
					//main if statement:
					Expr finalExpr = null;
					Command command = new Command(false, scope, -1, -1, finalExpr); //this is the test command.
					Sig s = null;
					for (Sig sigs: world.getAllReachableSigs()){
						if(sigs.label.equals("this/"+elements[j])){
							s = sigs;
						}
					}

					if (s == null){
						System.out.println("element in list was not found in model...terminating -- rebuild list and try again");
						return (long) -1;
						//This should never happen.
					}
					if (annotations[j].equals("M")){
						Expr expr1 = s.some().not();
						Expr expr1f = expr1.and(world.getAllReachableFacts()).and(toAdd);
						command = new Command(false, scope, -1, -1, expr1f);
					} else if (annotations[j].equals("S")){
						Expr expr2 = s.cardinality().lte(ExprConstant.ONE).not();  //cardinality is one
						Expr expr2f = expr2.and(world.getAllReachableFacts()).and(toAdd);
						System.out.println("First check: " + expr2f.toString() + " and " + toAdd.toString());
						command = new Command(false, scope, -1, -1, expr2f); //this is the test command.
					} else if (annotations[j].equals("V")){ //"V"
						String test = "not (no x: Nodes | x in " + s.label + " and x not in (univ-" + s.label + "))";
						Expr hardExprTest = world.parseOneExpressionFromString(test);
						Expr expr2V = hardExprTest; 
						Expr expr2Vf = expr2V.and(world.getAllReachableFacts()).and(toAdd);

						command = new Command(false, scope, -1, -1, expr2Vf); //this is the test command.
					} else {
						System.out.print("No annotations!");
						return System.nanoTime();
					}


					SafeList<CommandScope> scopes = new SafeList();
					SafeList<Sig> scopeSigs = world.getAllSigs();
					for(Sig scopeSig: scopeSigs){
						if(!scopeSig.label.equals("this/Nodes") &&  !scopeSig.label.startsWith("this/AEn")  &&  !scopeSig.label.startsWith("this/BEn")  &&  !scopeSig.label.startsWith("this/End") && !scopeSig.label.equals("this/Edges") && !scopeSig.label.startsWith("this/end") && 
								!scopeSig.label.equals("this/Source")  && !scopeSig.label.equals("this/Target")){
							CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSig, false, 0, 5, 1);
							scopes.add(ts);
						} else if (scopeSig.label.equals("this/Nodes") ){ //|| scopeSig.label.equals("this/Edges")
							CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSig, true, 26, 26, 1);
							scopes.add(ts);
						}
					}
				    command.change(scopes.makeConstList());
				    
					A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);

					if(ans.satisfiable()){
						System.out.println("No propogation for this annotation.");
					} else {
						//Main else

						HashSet<String> S = new HashSet();
						int globalSigCounter = 0;
						int bigLoopCounter = 0;
						Module oldWorld = world;
						long to = (new Long("30000000000")).longValue();
						while(!(ans.satisfiable())){
							if(System.nanoTime() >= (startTime + to)){
								System.out.println("timed out");
								return (long) -2;
							}
							//Main while

							Set<Pos> uc = ans.lowLevelCore();


							//               * New plan: rewrite the file with appropriate slack, causing reparsing, and then check again.
							//               * So:
							//               * 1. a. Check original. Get UNSAT core.
							//               *    b. Get list of functions (in reality, predicates).
							//               *    c. See if the UNSAT core lines are within a predicate.
							//               *    d. Record any such predicate.
							//               * 2. Weaken calls to UNSAT core predicates.
							//               * 3. Rewrite file with weakened calls.
							//               * 4. Use that file to check again.

							int testCounter = 0;
							System.out.print("Analysing positions in new core... ");
							HashSet<String> relaxable = new HashSet(); //This is effectively "c" in the pseudo-code.
							HashSet<Integer> distinctRelaxable = new HashSet();
							for(Pos p: uc){

								//UNSAT core = uc
								SafeList<Func> preds = oldWorld.getAllFunc();
								for(Func f: preds){
									Pos fSpan = f.span();

									if (fSpan.y2 >= p.y && p.y >= fSpan.y){ 
										//The uc sentence is in this predicate.
										String formatted = f.label.substring(5, f.label.length());// + "[]";
										if(formatted.startsWith("exists_") || formatted.startsWith("unique_")){
											relaxable.add(formatted);
										}
										if(formatted.startsWith("distinct_")){
											distinctRelaxable.add(new Integer(p.y));
										}
									}
								}
							}                  
							System.out.println("Done analysing core...");
							if (relaxable.size() == 0 && distinctRelaxable.size() == 0){ //"if S' = \emptyset then return error
								System.out.println("UNSOLVABLE --- Cannot propagate using solely additional annotations");
								return (long) -1;
							}

							for(String stri: relaxable){
								S.add(stri);
							}
							//for (Integer li: distinctRelaxable){
								//S.add("Line: " + li.toString());
							//}



							Scanner modelReader = null;
							if(loopCounter == 0){
								modelReader = new Scanner(new File(filename));

							} else {
								String tempFileName = filename.substring(0, filename.indexOf(".")) + "/temp" + (loopCounter-1) + filename.substring(filename.indexOf("."), filename.length());
								modelReader = new Scanner(new File(tempFileName));

							}



							int sigCounter = 0;
							String filenameB = filename+loopCounter; 
							String filenameC = filename.substring(0, filename.indexOf(".")) + "/temp" + loopCounter + filename.substring(filename.indexOf("."), filename.length());

							filenameB = filenameC;
							boolean success = (new File(filename.substring(0, filename.indexOf(".")))).mkdirs();



							FileWriter fstream = new FileWriter(filenameB);
							loopCounter++;
							HashMap<String, Integer> relaxedBy = new HashMap();
							int lineSafetyCounter = 0;
							BufferedWriter out = new BufferedWriter(fstream);
							try {
								int oldGlobalSigCounter = globalSigCounter;
								int newLineCounter = 0;
								while (modelReader.hasNextLine()) {
									lineSafetyCounter++;
									String line = modelReader.nextLine();
									String nameOfElement = "";
									boolean weaken = false;
									boolean distinctWeaken = false;
									for(String str: relaxable){


										if(line.trim().startsWith(str) || (line.trim().startsWith("((") )){

											weaken = true;
											break;
										}
										if(distinctRelaxable.contains(new Integer(newLineCounter))) {
											if(!line.trim().startsWith("//")){
												if(!line.trim().startsWith("}")){
													if(!line.contains("temp")){
														nameOfElement = line.substring(line.indexOf(" implies ") + 19, line.length()-2);
														distinctWeaken = true;
														if(!relaxedBy.containsKey(nameOfElement)){
															relaxedBy.put(nameOfElement, new Integer(globalSigCounter));
															globalSigCounter++;
															sigCounter++;
														}
														break;
													}
												}
											}
										}
									}
									if (weaken) {

										//Using strictly "or"
										String toWrite = "((" + line + ") or #temp" +(globalSigCounter) + "= 1 ) \n"; 
										if(positionsInFile.containsKey(new Integer(newLineCounter))){
											positionsInFile.put(new Integer(newLineCounter), toWrite);
										}

										globalSigCounter++;
										sigCounter++;
										out.write(toWrite);
									} else if (distinctWeaken) {
										String toWrite = "( " + line + ") or #temp" + relaxedBy.get(nameOfElement).intValue() + " = 1 \n";
										S.add("distinct_" + nameOfElement);
										out.write(toWrite);
									} else {
										out.write(line + "\n"); 
									}
									newLineCounter++;
								}
								if (lineSafetyCounter  <= loopCounter){
									System.out.println("(Likely) Scope Error - infinite loop achieved (worse, every line in the model has been weakened by now. \n Terminating.");
									return (long) -1.0;
								}
								for (int l = oldGlobalSigCounter; l < globalSigCounter; l++){
									out.write("sig temp" + l + " {} \n");
								}
								globalSigCounter = oldGlobalSigCounter + sigCounter;

								if(!(oldGlobalSigCounter == globalSigCounter) && sigCounter > 1){
									boolean firstHotLine = true;
									String oneHot = "";
									for(int r =oldGlobalSigCounter; r < globalSigCounter; r++){
										String oneHotLine = "#temp" + r + " = 1";
										for(int t = oldGlobalSigCounter; t < globalSigCounter; t++){
											if(t != r){
												oneHotLine = oneHotLine + " and #temp"  + t + " not= 1 ";
											}
										}
										if(firstHotLine){
											oneHot = "(" +  oneHotLine + ") \n";
											firstHotLine = false;
										} else {
											oneHot = oneHot + "or (" +  oneHotLine + ")  \n";
										}
									}
									oneHot = "fact { \n (" + oneHot + ") \n } \n";
									out.write(oneHot);
								}
								modelReader.close();
								out.close();
								fstream.close();

							} catch (Exception e) {
								System.err.println("Error writing temp file: " + e.getMessage());
							}

							Sig sB = null;

							Module worldB = CompUtil.parseEverything_fromFile(rep, null, filenameB); //should be filenameB
							for (Sig sigsB: worldB.getAllSigs()){
								if(sigsB.label.equals("this/"+elements[j])){
									sB = sigsB;
								}
							}

							Command commandB = null;
							Expr eQ = null;

							Expr toAddP = null;
							SafeList<Func> worldFunctionsB = worldB.getAllFunc();
							for(String ca: callsForB){
								for(Func fu: worldFunctionsB){
									Expr body = null;
									if(fu.label.equals(ca)){
										body = fu.getBody();
										if(toAddP == null){
											toAddP = body;
										} else {
											toAddP = toAddP.or(body);
										}
									} 
								}
							}

							String checkCommand = "";

							if (toAddP == null) {
								if(constrainedness == 0.0) {
									
								} else {
									System.err.println("toAddP failed; constrainedness: " + constrainedness);
								}
							} else {
								Expr hard =  worldB.parseOneExpressionFromString(hardStrToAdd);

								String newHard = "";
								Scanner iffSC = new Scanner(FinalIFFList);
								while(iffSC.hasNext()){
									String next= iffSC.next(); //This will also serve as the name of pred being called.
									if(next.equals("or")){
										newHard = newHard + " " + next + " ";
									} else {
										Integer location  = inverseOriginalMap.get(next);
										String newLine = positionsInFile.get(location);
										Scanner newLineScanner = new Scanner(newLine);
										String notsToAdd = "";
										while(newLineScanner.hasNext()){
											String nextInLine = newLineScanner.next();
											if(nextInLine.startsWith("#temp")){
												String tempid = nextInLine.substring(1,nextInLine.length() - 1);
												notsToAdd = notsToAdd + " and #" + tempid + " not= 1 ";
											}
										}
										newLineScanner.close();
										newLine = "(" + next + notsToAdd + ")";
										newHard = newHard + newLine;
									}
								}
								iffSC.close();


								checkCommand = "((" + newHard + ") implies " + hardStrToAdd + ")";

								toAddP = worldB.parseOneExpressionFromString(checkCommand); 
							}


							if (annotations[j].equals("M")){
								
								eQ =  (sB.some().not()).and(toAddP).and(worldB.getAllReachableFacts());
								commandB = new Command(false, scope, -1, -1, eQ);
							} else if (annotations[j].equals("S")){

								String check = "not ( #" + s.label + " <= 1)";
								Expr expr2 = worldB.parseOneExpressionFromString(check);
								expr2 =  sB.cardinality().lte(ExprConstant.ONE).not();
								Expr expr2f = expr2.and(worldB.getAllReachableFacts().and(toAddP));

								commandB = new Command(false, scope, -1, -1, expr2f); //this is the test command.
							} else if (annotations[j].equals("V")){ //"V"
								String test = "(some x: " + types.get(sB.label) + " | x in "
										+ sB.label + " and x in ("
										+ allButOne(types, sB.label) + "))";
								Expr hardExprTest = worldB.parseOneExpressionFromString(test);

								Expr expr2Vf = hardExprTest.and(worldB.getAllReachableFacts()).and(toAddP); 
								commandB = new Command(false, scope, -1, -1, expr2Vf); //this is the test command.
							}

							A4Options optionsB = new A4Options();
							optionsB.solver = A4Options.SatSolver.MiniSatProverJNI;
							optionsB.coreMinimization = 0;

							ConstList<Sig> worldBSigs = worldB.getAllReachableSigs();

							SafeList<CommandScope> scopesB = new SafeList();
							SafeList<Sig> scopeSigsB = worldB.getAllSigs();
							for(Sig scopeSigB: scopeSigsB){
								if(!scopeSigB.label.equals("this/Nodes") && !scopeSigB.label.equals("this/Edges") && 
										!scopeSigB.label.equals("this/Source")  &&  !scopeSigB.label.startsWith("this/AEn")  &&  !scopeSigB.label.startsWith("this/BEn")  &&  !scopeSigB.label.startsWith("this/End") && !scopeSigB.label.equals("this/Target") && !scopeSigB.label.startsWith("this/end")){
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false, 0, 5, 1);
									scopesB.add(ts);
								} else if (scopeSigB.label.equals("this/Nodes") || scopeSigB.label.equals("this/Edges") ){ //
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, true, scope, scope, 1);
									scopesB.add(ts);
								} else if (scopeSigB.label.startsWith("temp")){
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false, 0, 1, 1);
									scopesB.add(ts);
								}
							}
							oldWorld = worldB;
							if(commandB == null) { System.err.println("NULL COMMAND - ERROR"); }

							commandB.change(scopesB.makeConstList());
							
							ans = TranslateAlloyToKodkod.execute_command(rep, worldBSigs, commandB, optionsB);

							
							

						}
						System.out.println(S.size() + " annotations to add:");
						for(String stuff: S){
							System.out.println("Remove constraint \"" + stuff + "\" and add the appropriate annotation.");
							if (stuff.indexOf("exists_") >= 0){
								csv = csv + ",M";
							} else if (stuff.indexOf("unique_") >= 0) {
								csv = csv + ",S";
							} else if (stuff.indexOf("distinct_") >=0) {
								csv = csv + ",V"; 
							}

						}
					}

				}
				try {
					FileWriter fstreamB = new FileWriter(filename+".ar");


					BufferedWriter outwriter = new BufferedWriter(fstreamB);
					outwriter.write(csv);
					outwriter.close();
					fstreamB.close();
				} catch (Exception e){
					System.err.println("Error writing annotation results file.");
				}
			}

			System.out.println("Done.");
		} catch (Exception e){
			System.err.println("Something went very wrong: ");
			e.printStackTrace();
			return (long) -2;
		}

		return System.nanoTime();
	}

	private static ArrayList<Sig> getAdditionalRemovedSigs(
			Iterable<ExprVar> in, SafeList<Sig> sigs) {
		// TODO: this can probably be optimized.
		ArrayList<Sig> out = new ArrayList<Sig>();
		for (Sig s : sigs) {
			if (s.label.indexOf("__M") >= 0) {
				boolean oneExists = false;
				for (ExprVar ev : in) {
					if (ev.label.indexOf(s.label) >= 0) {
						oneExists = true;
					}
				}
				if (oneExists) {
					out.add(s);
				}
			}

			if (s.label.indexOf("__S") >= 0) {
				int count = 0;
				for (ExprVar ev : in) {
					if (ev.label.indexOf(s.label) >= 0) {
						count++;
					}
				}
				if (count > 1) {
					out.add(s);
				}
			}

			if (s.label.indexOf("__V") >= 0) {
				boolean isMerged = false;
				for (ExprVar ev : in) {
					if (ev.label.equals(s.label)) { // TODO: check that atom
													// names are only ever sig
													// names (probably are, with
													// "this/").
						isMerged = true;
					}
				}
				if (isMerged) {
					out.add(s);
				}
			}
		}

		return out;
	}

	private static void makeRNF(String[] args) throws Err {

		try {
			System.out.println("Constrainedness: " + constrainedness);
			String csv = "START";
			

			// The visualizer (We will initialize it to nonnull when we
			// visualize an Alloy solution)
			VizGUI viz = null;

			// Alloy4 sends diagnostic messages and progress reports to the
			// A4Reporter.
			// By default, the A4Reporter ignores all these events (but you can
			// extend the A4Reporter to display the event for the user)
			A4Reporter rep = new A4Reporter() {
				// For example, here we choose to display each "warning" by
				// printing it to System.out
				@Override
				public void warning(ErrorWarning msg) {
					System.out.print("Relevance Warning:\n"
							+ (msg.toString().trim()) + "\n\n");
					System.out.flush();
				}
			};

			for (String filename : args) {
				// Parse+typecheck the model
				System.out.println("=========== Parsing+Typechecking "
						+ filename + " =============");
				Module world = CompUtil.parseEverything_fromFile(rep, null,
						filename);

				
				HashMap<String, String> types = new HashMap();
				//Get types
				Scanner typeGetter = new Scanner(new File(filename));
				while(typeGetter.hasNextLine()){
					String nextLine = typeGetter.nextLine();
					Scanner lineParser = new Scanner(nextLine);
					while(lineParser.hasNext()){
						String firstWord = lineParser.next();
						if(firstWord.equals("sig")){
							String sigName = lineParser.next();
							lineParser.next(); //clear the "in"
							String sigType = lineParser.next();
							
							types.put("this/" + sigName, sigType);
						} else {
							break;
						}
					}
				}
				typeGetter.close();
				
				A4Options options = new A4Options();
				options.solver = A4Options.SatSolver.SAT4J; // Solver can be
															// changed, e.g. for
															// UNSAT core
															// computation.

				SafeList<Sig> allSigsInitial = world.getAllSigs();
				ArrayList<Sig> allSigs = (ArrayList) (world.getAllSigs())
						.makeCopy(); // This is annotations(P) (and more, which
										// will be skipped)
				boolean needHard = true;
				SafeList<Sig> userDefinedSigs = world.getAllSigs();
				Sig initialSig = userDefinedSigs.get(0);
				Sig hardSig = userDefinedSigs.get(0);

				for (Sig asi : userDefinedSigs) {
					if ((asi.label.indexOf("__M") == -1)
							&& (asi.label.indexOf("__V") == -1)
							&& (asi.label.indexOf("__S") == -1)) {
						initialSig = asi;
					}
					if ((asi.label.indexOf("__M") >= 0)
							|| (asi.label.indexOf("__V") >= 0)
							|| (asi.label.indexOf("__S") >= 0)) {
						if (needHard == true) {
							needHard = false;
							hardSig = asi;
						}
					}
				
					
				}
				SafeList<Sig> impliedSigs = new SafeList();
				int numImplied = (int) Math.round(constrainedness
						* (userDefinedSigs.size()));
				int sigCounter = 0;
				for (Sig asi : userDefinedSigs) {
					if (sigCounter == numImplied) {
						break;
					}
					if (!asi.label.equals("this/Nodes")
							&& !asi.label.equals("this/Edges")
							&& !asi.label.equals("this/Source")
							&& !asi.label.equals("this/Target")) {
						if ((asi.label.indexOf("__M") >= 0)
								|| (asi.label.indexOf("__V") >= 0)
								|| (asi.label.indexOf("__S") >= 0)) {
							impliedSigs.add(asi);
						}
					}
					sigCounter++;
				}
				Expr toAdd = null;
				Expr nextExpr = null;
				if (impliedSigs.size() == 0) {
					toAdd = ExprConstant.TRUE;
				} else {
					String firstLabel = impliedSigs.get(0).label;
					Sig firstSig = impliedSigs.get(0);
					toAdd = initialSig.some();
					nextExpr = toAdd;
					if (firstLabel.indexOf("__M") >= 0) {
						// May
						Expr nextAdd = firstSig.some();
						toAdd = toAdd.implies(nextAdd);
						nextExpr = nextAdd;
						if (firstLabel.indexOf("__V") >= 0) {
							// MV
							String test = "(some x: " + types.get(firstLabel) + " | x in "
									+ firstSig.label + " and x in ("
									+ allButOne(types, firstLabel) + "))";
							
							Expr hardExprTest = world
									.parseOneExpressionFromString(test);

							Expr nextNextAdd = hardExprTest;
							toAdd = toAdd.and(nextAdd.implies(nextNextAdd));
							nextExpr = nextNextAdd;
							if (firstLabel.indexOf("__S") >= 0) {
								// MSV
								Expr nextNextNextAdd = firstSig.cardinality()
										.equal(ExprConstant.ONE);
								toAdd = toAdd.and(nextNextAdd
										.implies(nextNextNextAdd));
								nextExpr = nextNextNextAdd;

							}
						}
					} else if (firstLabel.indexOf("__S") >= 0) {
						// S
						Expr nextAdd = firstSig.cardinality().equal(
								ExprConstant.ONE);
						toAdd = toAdd.implies(nextAdd);
						nextExpr = nextAdd;
						if (firstLabel.indexOf("__V") >= 0) {
							// SV
							String test = "(some x: " + types.get(firstLabel) + " | x in "
									+ firstSig.label + " and x in ("
									+ allButOne(types, firstLabel) + "))";
							Expr hardExprTest = world
									.parseOneExpressionFromString(test);

							Expr nextNextAdd = hardExprTest; 
							toAdd = toAdd.and(nextAdd.implies(nextNextAdd));
							nextExpr = nextNextAdd;

						}
					} else if (firstLabel.indexOf("__V") >= 0) {
						// V
						String test = "(some x: " + types.get(firstLabel) + " | x in "
								+ firstSig.label + " and x in ("
								+ allButOne(types, firstLabel) + "))";
						Expr hardExprTest = world
								.parseOneExpressionFromString(test);
						Expr nextAdd = hardExprTest; 
						toAdd = toAdd.implies(nextAdd);
						nextExpr = nextAdd;
					}

					for (int i = 1; i < impliedSigs.size(); i++) {
						Sig nextSig = impliedSigs.get(i);
						String nextLabel = nextSig.label;
						if (nextLabel.indexOf("__M") >= 0) {
							// May
							Expr toAddB = nextExpr.implies(impliedSigs.get(i)
									.some());
							if (toAdd == null) {
								toAdd = toAddB;
							} else {
								toAdd = toAdd.and(toAddB);
							}
							if (nextLabel.indexOf("__V") >= 0) {
								// MV
								String test = "(some x: " + types.get(nextSig.label) + " | x in "
										+ nextSig.label + " and x in ("
										+ allButOne(types, nextSig.label) + "))";
								Expr hardExprTest = world
										.parseOneExpressionFromString(test);
								toAddB = impliedSigs.get(i).some()
										.implies(hardExprTest);
								

								if (toAdd == null) {
									toAdd = toAddB;
								} else {
									toAdd = toAdd.and(toAddB);
								}
								if (nextLabel.indexOf("__S") >= 0) {
									// MSV
									toAddB = nextSig
											.in(nextSig)
											.and(nextSig.in((PrimSig.UNIV)
													.minus(nextSig)))
											.not()
											.implies(
													nextSig.cardinality()
															.equal(ExprConstant.ONE));
									if (toAdd == null) {
										toAdd = toAddB;
									} else {
										toAdd = toAdd.and(toAddB);
									}
								}
							}

						} else if (nextLabel.indexOf("__S") >= 0) {
							// S
							Expr toAddB = nextExpr.implies(nextSig
									.cardinality().equal(ExprConstant.ONE));
							if (toAdd == null) {
								toAdd = toAddB;
							} else {
								toAdd = toAdd.and(toAddB);
							}
							if (nextLabel.indexOf("__V") >= 0) {
								// SV
								String test = "(some x: " + types.get(firstLabel) + " | x in "
										+ firstSig.label + " and x in ("
										+ allButOne(types, firstLabel) + "))";
								Expr hardExprTest = world
										.parseOneExpressionFromString(test);
								toAddB = nextSig.cardinality()
										.equal(ExprConstant.ONE)
										.implies(hardExprTest);
								
								if (toAdd == null) {
									toAdd = toAddB;
								} else {
									toAdd = toAdd.and(toAddB);
								}
							}
						} else if (nextLabel.indexOf("__V") >= 0) {
							// V
							String test = "(some x: " + types.get(firstLabel) + " | x in "
									+ firstSig.label + " and x in ("
									+ allButOne(types, firstLabel) + "))";
							Expr hardExprTest = world
									.parseOneExpressionFromString(test);
							Expr toAddB = nextExpr.implies(hardExprTest);
							if (toAdd == null) {
								toAdd = toAddB;
							} else {
								toAdd = toAdd.and(toAddB);
							}
						}
					}
				}

				String hardSigName = hardSig.label.substring(5,
						hardSig.label.length());
				String hardSigAnnotation = "";
				Expr hardExpr = ExprConstant.TRUE;
				if (hardSigName.indexOf("__M") >= 0) {
					hardSigAnnotation = "M";
					hardExpr = initialSig.some();
				} else if (hardSigName.indexOf("__S") >= 0) {
					hardSigAnnotation = "S";
					hardExpr = initialSig.some();
					
				} else if (hardSigName.indexOf("__V") >= 0) {
					hardSigAnnotation = "V";
					hardExpr = initialSig.some();
					
				}

				if (toAdd == null) {
					System.err
							.println("Error generating WFF constraints...terminating,");
					return;
				} else {
					toAdd = toAdd; 
					
				}

				while (allSigs.iterator().hasNext()) { // Main loop
					Sig s = allSigs.iterator().next();

					// Execute the command
					System.out.println("============ Testing base + " + s
							+ ": ============");



					Expr finalExpr = null;

					// Default variable assignments; the if statement will
					// replace the value for "command" using these.
					Command command = new Command(false, scope, -1, -1, finalExpr); // this
																					// is
																					// the
																					// test
																					// command.
					if ((s.label).indexOf("__M") >= 0) { // May
						// Make the expression to check (note: does not require
						// an actual predicate/function to be created)
						Expr expr1 = s.some().not();

						Expr expr1f = expr1.and(world.getAllReachableFacts())
								.and(toAdd);
						command = new Command(false, scope, -1, -1, expr1f); // this
																			// is
																			// the
																			// test
																			// command.
						// "false" because it's a run, not a check
						// -1, -1, -1 for default scope, bitwidth, and sequence
						// length, respectively.
						// expr is the expr to check

						SafeList<CommandScope> scopes = new SafeList();
						SafeList<Sig> scopeSigsB = world.getAllSigs();
						for (Sig scopeSigB : scopeSigsB) {
							if (!scopeSigB.label.equals("this/Nodes")
									&& !scopeSigB.label.equals("this/Edges")
									&& !scopeSigB.label.equals("this/Source")
									&& !scopeSigB.label.startsWith("this/AEn")
									&& !scopeSigB.label.startsWith("this/BEn")
									&& !scopeSigB.label.startsWith("this/End")
									&& !scopeSigB.label.equals("this/Target")
									&& !scopeSigB.label.startsWith("this/end")) {
								CommandScope ts = new CommandScope(Pos.UNKNOWN,	scopeSigB, false, 0, 5, 1);
								scopes.add(ts);
							} else if (scopeSigB.label.equals("this/Nodes")
									|| scopeSigB.label.equals("this/Edges")) { //
								CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, true, scope, scope, 1);
								scopes.add(ts);
							} else if (scopeSigB.label.startsWith("temp")) {
								CommandScope ts = new CommandScope(Pos.UNKNOWN,	scopeSigB, false, 0, 1, 1);
								scopes.add(ts);
							}
						}
						command.change(scopes.makeConstList());

						A4Solution ans = TranslateAlloyToKodkod
								.execute_command(rep,
										world.getAllReachableSigs(), command,
										options);

						// Print the outcome
						System.out.println(ans);

						if (!(ans.satisfiable())) {
							// Change the sig name
							System.out.println("Need to change " + s.label
									+ "'s M");
							csv = csv + "," + s.label + "," + "M";
							// TODO: this currently only reports what should
							// change, but it should actually change it
							// It will add the constraint, effectively removing
							// the annotation, but the name changing would be
							// far more intuitive
							// Can be done with a find/replace on the final
							// model.

							// Change the set of planned tests
							// allSigs.remove(s);

							// Add the sentence
							// Need to locate the interesting (MAVO) predicate.
							SafeList<Func> allFuncsSafe = world.getAllFunc();
							for (Func f : allFuncsSafe) {
								if (f.label.equals("MAVO")) {
									Expr body = f.getBody();
									body = body.and(finalExpr);
									f.setBody(body);
								}
							}

						} else {
							// Go to next annotation after checking
							// concretization
							Iterable<ExprVar> conc = ans.getAllAtoms();
							ArrayList<Sig> toRemove = (ArrayList) getAdditionalRemovedSigs(
									conc, allSigsInitial);
							for (Sig sigRemove : toRemove) {
								allSigs.remove(sigRemove);
							}
							// allSigs.remove(s);
						}

						if ((s.label).indexOf("__S") >= 0) { // It is at least
																// "MS"

							Expr expr1S = s.cardinality()
									.equal(ExprConstant.ONE).not();// not in all
																	// the
																	// others
							Expr expr1Sf = expr1S.and(
									world.getAllReachableFacts()).and(toAdd);
							command = new Command(false, scope, -1, -1, expr1Sf); // this
																				// is
																				// the
																				// test
																				// command.
							SafeList<CommandScope> scopes1 = new SafeList();
							SafeList<Sig> scopeSigsB1 = world.getAllSigs();
							for (Sig scopeSigB : scopeSigsB1) {
								if (!scopeSigB.label.equals("this/Nodes")
										&& !scopeSigB.label
												.equals("this/Edges")
										&& !scopeSigB.label
												.equals("this/Source")
										&& !scopeSigB.label
												.startsWith("this/AEn")
										&& !scopeSigB.label
												.startsWith("this/BEn")
										&& !scopeSigB.label
												.startsWith("this/End")
										&& !scopeSigB.label
												.equals("this/Target")
										&& !scopeSigB.label
												.startsWith("this/end")) {
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false, 0, 5, 1);
									scopes.add(ts);
								} else if (scopeSigB.label.equals("this/Nodes")
										|| scopeSigB.label.equals("this/Edges")) {
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, true, scope, scope, 1);
									scopes1.add(ts);
								} else if (scopeSigB.label.startsWith("temp")) {
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false, 0, 1, 1);
									scopes.add(ts);
								}
							}
							command.change(scopes1.makeConstList());
							A4Solution ansS = TranslateAlloyToKodkod
									.execute_command(rep,
											world.getAllReachableSigs(),
											command, options);
							// Print the outcome
							System.out.println(ans);

							if (!(ansS.satisfiable())) {
								// Change the sig name
								System.out.println("Need to change " + s.label
										+ "'s S");
								csv = csv + "," + s.label + "," + "S";

								// Add the sentence
								// Need to locate the interesting (MAVO)
								// predicate.
								SafeList<Func> allFuncsSafeS = world
										.getAllFunc();
								for (Func f : allFuncsSafeS) {
									if (f.label.equals("MAVO")) {
										Expr body = f.getBody();
										body = body.and(finalExpr);
										f.setBody(body);
									}
								}

							} else {
								// Go to next annotation after checking
								// concretization
								Iterable<ExprVar> concS = ansS.getAllAtoms();
								ArrayList<Sig> toRemoveS = (ArrayList) getAdditionalRemovedSigs(
										concS, allSigsInitial);
								for (Sig sigRemove : toRemoveS) {
									allSigs.remove(sigRemove);
								}

							}

							if ((s.label).indexOf("__V") >= 0) { // It is "MSV"

								String test = "(some x: " + types.get(s.label) + " | x in "
										+ s.label + " and x in ("
										+ allButOne(types, s.label) + "))";
								Expr hardExprTest = world
										.parseOneExpressionFromString(test);
								Expr expr1V = hardExprTest; // s.in(s).and(s.in((PrimSig.UNIV).minus(s)).not());//
															// not in all the
															// others
								Expr expr1Vf = expr1V.and(
										world.getAllReachableFacts())
										.and(toAdd);
								command = new Command(false, scope, -1, -1,
										expr1Vf); // this is the test command.
								SafeList<CommandScope> scopes11 = new SafeList();
								SafeList<Sig> scopeSigsB11 = world.getAllSigs();
								for (Sig scopeSigB : scopeSigsB11) {
									if (!scopeSigB.label.equals("this/Nodes")
											&& !scopeSigB.label
													.equals("this/Edges")
											&& !scopeSigB.label
													.equals("this/Source")
											&& !scopeSigB.label
													.startsWith("this/AEn")
											&& !scopeSigB.label
													.startsWith("this/BEn")
											&& !scopeSigB.label
													.startsWith("this/End")
											&& !scopeSigB.label
													.equals("this/Target")
											&& !scopeSigB.label
													.startsWith("this/end")) {
										CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false,0, 5, 1);
										scopes11.add(ts);
									} else if (scopeSigB.label
											.equals("this/Nodes")
											|| scopeSigB.label
													.equals("this/Edges")) { 
										CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, true, scope, scope, 1);
										scopes11.add(ts);
									} else if (scopeSigB.label
											.startsWith("temp")) {
										CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false,0, 1, 1);
										scopes11.add(ts);
									}
								}
								command.change(scopes11.makeConstList());
								A4Solution ansV = TranslateAlloyToKodkod
										.execute_command(rep,
												world.getAllReachableSigs(),
												command, options);
								// Print the outcome
								System.out.println(ans);

								if (!(ansV.satisfiable())) {
									// Change the sig name
									System.out.println("Need to change "
											+ s.label + "'s V");
									csv = csv + "," + s.label + "," + "V";
									// TODO: this currently only reports what
									// should change, but it should actually
									// change it
									// It will add the constraint, effectively
									// removing the annotation, but the name
									// changing would be far more intuitive
									// Can be done with a find/replace on the
									// final model.

									// Add the sentence
									// Need to locate the interesting (MAVO)
									// predicate.
									SafeList<Func> allFuncsSafeV = world
											.getAllFunc();
									for (Func f : allFuncsSafeV) {
										if (f.label.equals("MAVO")) {
											Expr body = f.getBody();
											body = body.and(finalExpr);
											f.setBody(body);
										}
									}

								} else {
									// Go to next annotation after checking
									// concretization
									Iterable<ExprVar> concV = ansV
											.getAllAtoms();
									ArrayList<Sig> toRemoveV = (ArrayList) getAdditionalRemovedSigs(
											concV, allSigsInitial);
									for (Sig sigRemove : toRemoveV) {
										allSigs.remove(sigRemove);
									}

								}

							}
						}

						if ((s.label).indexOf("__V") >= 0) { // It is least "MV"

							String test = "(some x: " + types.get(s.label) + " | x in "
									+ s.label + " and x in ("
									+ allButOne(types, s.label) + "))";
							Expr hardExprTest = world
									.parseOneExpressionFromString(test);
							Expr expr1Vb = hardExprTest; 
															// not in all the
															// others
							Expr expr1Vbf = expr1Vb.and(
									world.getAllReachableFacts()).and(toAdd);
							command = new Command(false, scope, -1, -1, expr1Vbf); // this
																				// is
																				// the
																				// test
																				// command.
							SafeList<CommandScope> scopes1 = new SafeList();
							SafeList<Sig> scopeSigsB1 = world.getAllSigs();
							for (Sig scopeSigB : scopeSigsB1) {
								if (!scopeSigB.label.equals("this/Nodes")
										&& !scopeSigB.label
												.equals("this/Edges")
										&& !scopeSigB.label
												.equals("this/Source")
										&& !scopeSigB.label
												.startsWith("this/AEn")
										&& !scopeSigB.label
												.startsWith("this/BEn")
										&& !scopeSigB.label
												.startsWith("this/End")
										&& !scopeSigB.label
												.equals("this/Target")
										&& !scopeSigB.label
												.startsWith("this/end")) {
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false, 0,5, 1);
									scopes1.add(ts);
								} else if (scopeSigB.label.equals("this/Nodes")
										|| scopeSigB.label.equals("this/Edges")) { 
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, true,scope, scope, 1);
									scopes1.add(ts);
								} else if (scopeSigB.label.startsWith("temp")) {
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false, 0, 1, 1);
									scopes1.add(ts);
								}
							}
							command.change(scopes1.makeConstList());
							A4Solution ansVb = TranslateAlloyToKodkod
									.execute_command(rep,
											world.getAllReachableSigs(),
											command, options);
							// Print the outcome
							System.out.println(ans);

							if (!(ansVb.satisfiable())) {
								// Change the sig name
								System.out.println("Need to change " + s.label
										+ "'s V");
								csv = csv + "," + s.label + "," + "V";
								// TODO: this currently only reports what should
								// change, but it should actually change it
								// It will add the constraint, effectively
								// removing the annotation, but the name
								// changing would be far more intuitive
								// Can be done with a find/replace on the final
								// model.

								// Add the sentence
								// Need to locate the interesting (MAVO)
								// predicate.
								SafeList<Func> allFuncsSafeVb = world
										.getAllFunc();
								for (Func f : allFuncsSafeVb) {
									if (f.label.equals("MAVO")) {
										Expr body = f.getBody();
										body = body.and(finalExpr);
										f.setBody(body);
									}
								}

							} else {
								// Go to next annotation after checking
								// concretization
								Iterable<ExprVar> concVb = ansVb.getAllAtoms();
								ArrayList<Sig> toRemoveVb = (ArrayList) getAdditionalRemovedSigs(
										concVb, allSigsInitial);
								for (Sig sigRemove : toRemoveVb) {
									allSigs.remove(sigRemove);
								}


							}

						}
						allSigs.remove(s);
					} else if ((s.label).indexOf("__S") >= 0) { // Set
						Expr expr2 = s.cardinality().equal(ExprConstant.ONE)
								.not(); // cardinality is one
						Expr expr2f = expr2.and(world.getAllReachableFacts())
								.and(toAdd);
						command = new Command(false, scope, -1, -1, expr2f); // this
																			// is
																			// the
																			// test
																			// command.

						SafeList<CommandScope> scopes = new SafeList();
						SafeList<Sig> scopeSigsB = world.getAllSigs();
						for (Sig scopeSigB : scopeSigsB) {
							if (!scopeSigB.label.equals("this/Nodes")
									&& !scopeSigB.label.equals("this/Edges")
									&& !scopeSigB.label.equals("this/Source")
									&& !scopeSigB.label.startsWith("this/AEn")
									&& !scopeSigB.label.startsWith("this/BEn")
									&& !scopeSigB.label.startsWith("this/End")
									&& !scopeSigB.label.equals("this/Target")
									&& !scopeSigB.label.startsWith("this/end")) {
								CommandScope ts = new CommandScope(Pos.UNKNOWN,	scopeSigB, false, 0, 5, 1);
								scopes.add(ts);
							} else if (scopeSigB.label.equals("this/Nodes")
									|| scopeSigB.label.equals("this/Edges")) { 
								CommandScope ts = new CommandScope(Pos.UNKNOWN,	scopeSigB, true, scope, scope, 1);
								scopes.add(ts);
							} else if (scopeSigB.label.startsWith("temp")) {
								CommandScope ts = new CommandScope(Pos.UNKNOWN,	scopeSigB, false, 0, 1, 1);
								scopes.add(ts);
							}
						}
						command.change(scopes.makeConstList());

						A4Solution ans = TranslateAlloyToKodkod
								.execute_command(rep,
										world.getAllReachableSigs(), command,
										options);
						// Print the outcome
						System.out.println(ans);

						if (!(ans.satisfiable())) {
							// Change the sig name
							System.out.println("Need to change " + s.label
									+ "'s S");
							csv = csv + "," + s.label + "," + "S";
							// TODO: this currently only reports what should
							// change, but it should actually change it
							// It will add the constraint, effectively removing
							// the annotation, but the name changing would be
							// far more intuitive
							// Can be done with a find/replace on the final
							// model.

							// Add the sentence
							// Need to locate the interesting (MAVO) predicate.
							SafeList<Func> allFuncsSafe = world.getAllFunc();
							for (Func f : allFuncsSafe) {
								if (f.label.equals("MAVO")) {
									Expr body = f.getBody();
									body = body.and(finalExpr);
									f.setBody(body);
								}
							}

						} else {
							// Go to next annotation after checking
							// concretization
							Iterable<ExprVar> conc = ans.getAllAtoms();
							ArrayList<Sig> toRemove = (ArrayList) getAdditionalRemovedSigs(
									conc, allSigsInitial);
							for (Sig sigRemove : toRemove) {
								allSigs.remove(sigRemove);
							}

						}

						if ((s.label).indexOf("__V") >= 0) { // It is "VS"
							String test = "(some x: " + types.get(s.label) + " | x in "
									+ s.label + " and x in ("
									+ allButOne(types, s.label) + "))";
							Expr hardExprTest = world
									.parseOneExpressionFromString(test);
							Expr expr2V = hardExprTest; 
														// not in all the others
							Expr expr2Vf = expr2V.and(
									world.getAllReachableFacts()).and(toAdd);
							command = new Command(false, scope, -1, -1, expr2Vf); // this
																				// is
																				// the
																				// test
																				// command.

							SafeList<CommandScope> scopes1 = new SafeList();
							SafeList<Sig> scopeSigsB1 = world.getAllSigs();
							for (Sig scopeSigB : scopeSigsB1) {
								if (!scopeSigB.label.equals("this/Nodes")
										&& !scopeSigB.label
												.equals("this/Edges")
										&& !scopeSigB.label
												.equals("this/Source")
										&& !scopeSigB.label
												.startsWith("this/AEn")
										&& !scopeSigB.label
												.startsWith("this/BEn")
										&& !scopeSigB.label
												.startsWith("this/End")
										&& !scopeSigB.label
												.equals("this/Target")
										&& !scopeSigB.label
												.startsWith("this/end")) {
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, false, 0,5, 1);
									scopes1.add(ts);
								} else if (scopeSigB.label.equals("this/Nodes")
										|| scopeSigB.label.equals("this/Edges")) { 
									CommandScope ts = new CommandScope(Pos.UNKNOWN, scopeSigB, true, scope, scope, 1);
									scopes1.add(ts);
								} else if (scopeSigB.label.startsWith("temp")) {
									CommandScope ts = new CommandScope(	Pos.UNKNOWN, scopeSigB, false, 0,1, 1);
									scopes1.add(ts);
								}
							}
							command.change(scopes1.makeConstList());

							A4Solution ansV = TranslateAlloyToKodkod
									.execute_command(rep,
											world.getAllReachableSigs(),
											command, options);
							// Print the outcome
							System.out.println(ans);

							if (!(ansV.satisfiable())) {
								// Change the sig name
								System.out.println("Need to change " + s.label
										+ "'s V");
								csv = csv + "," + s.label + "," + "V";
								// TODO: this currently only reports what should
								// change, but it should actually change it
								// It will add the constraint, effectively
								// removing the annotation, but the name
								// changing would be far more intuitive
								// Can be done with a find/replace on the final
								// model.

								// Add the sentence
								// Need to locate the interesting (MAVO)
								// predicate.
								SafeList<Func> allFuncsSafeV = world
										.getAllFunc();
								for (Func f : allFuncsSafeV) {
									if (f.label.equals("MAVO")) {
										Expr body = f.getBody();
										body = body.and(finalExpr);
										f.setBody(body);
									}
								}

							} else {
								// Go to next annotation after checking
								// concretization
								Iterable<ExprVar> concV = ansV.getAllAtoms();
								ArrayList<Sig> toRemoveV = (ArrayList) getAdditionalRemovedSigs(
										concV, allSigsInitial);
								for (Sig sigRemove : toRemoveV) {
									allSigs.remove(sigRemove);
								}

							}
						}

						// Change the set of planned tests
						allSigs.remove(s);

					} else if ((s.label).indexOf("__V") >= 0) { // Var
						String test = "(some x: " + types.get(s.label) + " | x in "
								+ s.label + " and x in ("
								+ allButOne(types, s.label) + "))";
						Expr hardExprTest = world
								.parseOneExpressionFromString(test);
						Expr expr3 = hardExprTest; 
													// not in all the others
						Expr expr3f = expr3.and(world.getAllReachableFacts())
								.and(toAdd);
						command = new Command(false, scope, -1, -1, expr3f); // this
																			// is
																			// the
																			// test
																			// command.

						SafeList<CommandScope> scopes = new SafeList();
						SafeList<Sig> scopeSigsB = world.getAllSigs();
						for (Sig scopeSigB : scopeSigsB) {
							if (!scopeSigB.label.equals("this/Nodes")
									&& !scopeSigB.label.equals("this/Edges")
									&& !scopeSigB.label.equals("this/Source")
									&& !scopeSigB.label.startsWith("this/AEn")
									&& !scopeSigB.label.startsWith("this/BEn")
									&& !scopeSigB.label.startsWith("this/End")
									&& !scopeSigB.label.equals("this/Target")
									&& !scopeSigB.label.startsWith("this/end")) {
								CommandScope ts = new CommandScope(Pos.UNKNOWN,	scopeSigB, false, 0, 5, 1);
								scopes.add(ts);
							} else if (scopeSigB.label.equals("this/Nodes")
									|| scopeSigB.label.equals("this/Edges")) { 
								CommandScope ts = new CommandScope(Pos.UNKNOWN,	scopeSigB, true, scope, scope, 1);
								scopes.add(ts);
							} else if (scopeSigB.label.startsWith("temp")) {
								CommandScope ts = new CommandScope(Pos.UNKNOWN,	scopeSigB, false, 0, 1, 1);
								scopes.add(ts);
							}
						}
						command.change(scopes.makeConstList());

						A4Solution ans = TranslateAlloyToKodkod
								.execute_command(rep,
										world.getAllReachableSigs(), command,
										options);
						// Print the outcome
						System.out.println(ans);

						if (!(ans.satisfiable())) {
							// Change the sig name
							System.out.println("Need to change " + s.label
									+ "'s V");
							csv = csv + "," + s.label + "," + "V";
							// TODO: this currently only reports what should
							// change, but it should actually change it
							// It will add the constraint, effectively removing
							// the annotation, but the name changing would be
							// far more intuitive
							// Can be done with a strfind/replace on the final
							// model.

							// Add the sentence
							// Need to locate the interesting (MAVO) predicate.
							SafeList<Func> allFuncsSafe = world.getAllFunc();
							for (Func f : allFuncsSafe) {
								if (f.label.equals("MAVO")) {
									Expr body = f.getBody();
									body = body.and(finalExpr);
									f.setBody(body);
								}
							}

						} else {
							// Go to next annotation after checking
							// concretization
							Iterable<ExprVar> conc = ans.getAllAtoms();
							ArrayList<Sig> toRemove = (ArrayList) getAdditionalRemovedSigs(
									conc, allSigsInitial);
							for (Sig sigRemove : toRemove) {
								allSigs.remove(sigRemove);
							}

						}
						// Change the set of planned tests
						allSigs.remove(s);
					} else {
						allSigs.remove(s);
						continue; // Not annotated, not interesting.
					}


				}
				try {
					FileWriter fstream = new FileWriter(filename + ".ar");

					BufferedWriter outwriter = new BufferedWriter(fstream);
					outwriter.write(csv);
					outwriter.close();
					fstream.close();
				} catch (Exception e) {
					System.err
							.println("(Probable) error writing annotation results file.");
				}

			}
		} catch (Exception e) {
			System.err.println("Oh no: ");
			e.printStackTrace();
			try {
				FileWriter fstream = new FileWriter("error.log");

				BufferedWriter outwriter = new BufferedWriter(fstream);
				outwriter.write("Error! " + e.getMessage());
				outwriter.close();
				fstream.close();
			} catch (Exception eee) {
				System.err.println("Error writing error log...."
						+ e.getMessage());
			}
		}
		System.out.println("Done.");
	}

	private void readProperties(Properties properties) throws Exception {

		algorithm = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_ALGORITHM);
		constrainedness = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_CONSTRAINEDNESS);
		scope = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_SCOPE);
	}

	private void writeProperties(Properties properties, long time) {

		properties.setProperty(PROPERTY_OUT_TIME, String.valueOf(time));
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			model,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);

		// run alloy algorithm
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		String[] inputFiles = new String[] {
			workspaceUri + model.getUri() + ALLOY_FILEEXTENSION
		};
		long startTime = System.nanoTime();
		switch (algorithm) {
			case "ANF":
				makeANF(inputFiles);
			case "RNF":
			default:
				makeRNF(inputFiles);
		}
		long endTime = System.nanoTime();

		// save execution time
		long time = endTime - startTime;
		Properties outputProperties = new Properties();
		writeProperties(outputProperties, time);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			model,
			MultiModelOperatorUtils.getSubdir(inputProperties),
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return actualParameters;
	}

}