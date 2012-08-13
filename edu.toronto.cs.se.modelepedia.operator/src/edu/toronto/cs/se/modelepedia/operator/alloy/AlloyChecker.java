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
package edu.toronto.cs.se.modelepedia.operator.alloy;

import java.util.ArrayList;
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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
	private static final String PROPERTY_OUT_TIME = "time";

	private String algorithm;
	private static double constrainedness;

	private static void makeANF(String[] args) throws Err {
		  try {
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
			    /*
			    if (numFiles % 2 == 1){
			      return; //ERROR
			    }
			    */
			    for(int i = 0; i < numFiles; i++) {
			      String filename = args[i];
			      String csv = "START";
			      

			      // Parse+typecheck the model
			      System.out.println("=========== Parsing+Typechecking "+filename+" =============");
			      Module world = CompUtil.parseEverything_fromFile(rep, null, filename); //originally filname.
			      
			      SafeList<Sig> userDefinedSigs = world.getAllSigs();
			      Sig initialSig = userDefinedSigs.get(0);
			      Sig hardSig = userDefinedSigs.get(0);

			      boolean needHard = true;
			      for(Sig asi:userDefinedSigs){
			    	  if((asi.label.indexOf("__M") == -1) && (asi.label.indexOf("__V") == -1) && (asi.label.indexOf("__S") == -1)  ){
			    		  initialSig = asi;
			    	  }
			    	  if((asi.label.indexOf("__M") >= 0) || (asi.label.indexOf("__V") >= 0) || (asi.label.indexOf("__S") >= 0)  ){
			    		  if (needHard == true){
			    			  needHard = false;
			    			  hardSig = asi;
			    		  }
			    	  }
			      }
			      SafeList<Sig> impliedSigs = new SafeList();
			      int numImplied = (int) Math.round(constrainedness*(userDefinedSigs.size()));
			      int sigCounterLoop = 0;
			      for(Sig asi:userDefinedSigs){
			    	  if(sigCounterLoop == numImplied){
			    		  break;
			    	  }
			    	  if(!asi.equals(initialSig)){
			    		  impliedSigs.add(asi);
			    	  }
			    	  sigCounterLoop++;
			      }
			      Expr toAdd = null;
			      if(impliedSigs.size() == 0){
			    	  toAdd = ExprConstant.TRUE;
			      } else {
			    	  String firstLabel = impliedSigs.get(0).label;
			    	  Sig firstSig = impliedSigs.get(0);
			    	  if(firstLabel.indexOf("__M") >= 0) {
			    		  //May
			    		  toAdd = impliedSigs.get(0).some();
			    		  if(firstLabel.indexOf("__V") >= 0){
			    			  //MV
			    			  toAdd = toAdd.or(firstSig.in(firstSig).and(firstSig.in((PrimSig.UNIV).minus(firstSig))).not());
			    			  if(firstLabel.indexOf("__S") >= 0){
			    				  //MSV
			    				  toAdd.or(firstSig.cardinality().equal(ExprConstant.ONE).not());
			    			  }
			    		  }
			    	  } else if(firstLabel.indexOf("__S") >= 0){
						  //S
			    		  toAdd = firstSig.cardinality().equal(ExprConstant.ONE).not();
						  if(firstLabel.indexOf("__V") >= 0){
							  //SV
							  toAdd = toAdd.or(firstSig.in(firstSig).and(firstSig.in((PrimSig.UNIV).minus(firstSig))).not());
						  }
					  } else if(firstLabel.indexOf("__V") >= 0){
						  //V
						  toAdd = firstSig.in(firstSig).and(firstSig.in((PrimSig.UNIV).minus(firstSig)).not());
					  }
			    	  
			    	  for(int q = 1; q < impliedSigs.size(); q++){
			    		  Sig nextSig = impliedSigs.get(q);
			    		  String nextLabel = nextSig.label;
			    		  if(nextLabel.indexOf("__M") >= 0) {
			        		  //May
			        		  Expr toAddB = impliedSigs.get(q).some().not();
			        		  if(nextLabel.indexOf("__V") >= 0){
			        			  //MV
			        			  toAddB = toAddB.or(nextSig.in(nextSig).and(nextSig.in((PrimSig.UNIV).minus(nextSig))).not());
			        			  if(nextLabel.indexOf("__S") >= 0){
			        				  //MSV
			        				  toAddB = toAddB.or(nextSig.cardinality().equal(ExprConstant.ONE).not());
			        			  }
			        		  }
			    			  if(toAdd == null) {
			    				  toAdd = toAddB;
			    			  } else {
			    				  toAdd = toAdd.or(toAddB);
			    			  }
			        	  } else if(nextLabel.indexOf("__S") >= 0){
			    			  //S
			        		  Expr toAddB = nextSig.cardinality().equal(ExprConstant.ONE);
			    			  if(nextLabel.indexOf("__V") >= 0){
			    				  //SV
			    				  toAddB = toAddB.or(nextSig.in(nextSig).and(nextSig.in((PrimSig.UNIV).minus(nextSig))));
			    			  }
			    			  if(toAdd == null) {
			    				  toAdd = toAddB;
			    			  } else {
			    				  toAdd = toAdd.or(toAddB);
			    			  }
			    		  } else if(nextLabel.indexOf("__V") >= 0){
			    			  //V
			    			  Expr toAddB = firstSig.in(nextSig).and(nextSig.in((PrimSig.UNIV).minus(nextSig)));
			    			  if(toAdd == null) {
			    				  toAdd = toAddB;
			    			  } else {
			    				  toAdd = toAdd.or(toAddB);
			    			  }
			    		  }
			    	  }
			      }
			      
			      String hardSigName = hardSig.label.substring(5, hardSig.label.length()); 
			      String hardSigAnnotation = "";
			      Expr hardExpr = ExprConstant.TRUE;
			      if (hardSigName.indexOf("__M") >= 0){
			    	  hardSigAnnotation = "M";
			    	  hardExpr = hardSig.some().not();
			      } else if (hardSigName.indexOf("__S") >= 0){
			    	  hardSigAnnotation = "S";
			    	  hardExpr = hardSig.cardinality().equal(ExprConstant.ONE).not();
			      } else if (hardSigName.indexOf("__V") >= 0){
			    	  hardSigAnnotation = "V";
			    	  hardExpr = hardSig.in(hardSig).and(hardSig.in((PrimSig.UNIV).minus(hardSig)).not());
			      }
			      
			      if (toAdd == null) {
			    	  System.err.println("Error generating WFF constraints...terminating,");
			    	  return;
			      } else {
			    	  toAdd = toAdd.implies(hardExpr);
			      }
			      
			      //get list of other annotations
			      int maxNumAnnotations = 1; //3 * world.getAllSigs().size();
			      String[] elements = new String[maxNumAnnotations];
			      String[] annotations = new String[maxNumAnnotations];
			      
			      
			      elements[0] = hardSigName;
			      annotations[0] = hardSigAnnotation;
			      
			      //Scanner sc = new Scanner(new File(args[i+1]));
			      int scanCounter = 1;
			      int arrayPosCounter = 1;
			      
			      /*
			      while (sc.hasNext()) {
			        if (scanCounter % 2 == 0){
			          String element = sc.next();
			          elements[arrayPosCounter] = element;
			        } else {
			          String annotation = sc.next();
			          annotations[arrayPosCounter] = annotation;
			          arrayPosCounter++;
			        }
			        scanCounter++;
			      }
			      sc.close();
			      */
			      //System.err.println("Checkpoint: scanned");
			      
			      A4Options options = new A4Options();
			      options.solver = A4Options.SatSolver.MiniSatProverJNI; //Solver can be changed, e.g. for UNSAT core computation.
			      
			      SafeList<Sig> allSigsInitial = world.getAllSigs();
			      ArrayList<Sig> allSigs = (ArrayList)(world.getAllSigs()).makeCopy(); //This is annotations(P) (and more, which will be skipped)
			      
			      for(int j = 0; j < arrayPosCounter; j++){
			        //main loop
			        System.out.println("============ Testing base + " + elements[j] + "'s \"" + annotations[j] + "\": ============");
			        //main if statement:
			        Expr finalExpr = null;
			        Command command = new Command(false, -1, -1, -1, finalExpr); //this is the test command.
			        //System.out.println("First command built.");
			        //  Sig.PrimSig s = new Sig.PrimSig(elements[j]);
			        Sig s = null;
			        for (Sig sigs: world.getAllReachableSigs()){
			          //System.err.println(sigs.label);
			          if(sigs.label.equals("this/"+elements[j])){
			            s = sigs;
			          }
			        }
			        
			        if (s == null){
			          System.out.println("element in list was not found in model...terminating -- rebuild list and try again");
			          return;
			          //TODO: handle the case when s is still null better?
			        }
			        //System.err.println(elements[j] + " --> " + annotations[j]);
			        if (annotations[j].equals("M")){
			          Expr expr1 = s.some().not();
			          Expr expr1f = expr1.and(world.getAllReachableFacts());
			          command = new Command(false, -1, -1, -1, expr1f);
			        } else if (annotations[j].equals("S")){
			          Expr expr2 = s.cardinality().equal(ExprConstant.ONE);  //cardinality is one
			          Expr expr2f = expr2.and(world.getAllReachableFacts());
			          command = new Command(false, -1, -1, -1, expr2f); //this is the test command.
			        } else { //"V"
			          Expr expr2V = s.in(s).and(s.in((PrimSig.UNIV).minus(s)).not());// not in all the others
			          Expr expr2Vf = expr2V.and(world.getAllReachableFacts());
			          command = new Command(false, -1, -1, -1, expr2Vf); //this is the test command.
			        }
			        //System.err.println("Checkpoint: before first solve; " + command.toString() + "; " + command.formula.toString());
			        A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
			        
			        //System.err.println("Checkpoint: after first solve");
			        if(ans.satisfiable()){
			          System.out.println("No propogation for this annotation.");
			        } else {
			          //Main else
			          
			          HashSet<String> S = new HashSet();
			          
			          while(!(ans.satisfiable())){
			            
			            //Main while
			            
			            //Pair<Set<Pos>,Set<Pos>> uc = ans.highLevelCore();
			            //System.err.println(uc.toString());
			            //System.err.println("Main loop---");
			            Set<Pos> uc = ans.lowLevelCore();
			            System.out.println("UNSAT Core: " + uc.toString());
			            
//			               * New plan: rewrite the file with appropriate slack, causing reparsing, and then check again.
//			               * So:
//			               * 1. a. Check original. Get UNSAT core.
//			               *    b. Get list of functions (in reality, predicates).
//			               *    c. See if the UNSAT core lines are within a predicate.
//			               *    d. Record any such predicate.
//			               * 2. Weaken calls to UNSAT core predicates.
//			               * 3. Rewrite file with weakened calls.
//			               * 4. Use that file to check again.
//			               */
			            
			            HashSet<String> relaxable = new HashSet(); //This is effectively "c" in the pseudo-code.
			            for(Pos p: uc){
			              
			              //UNSAT core = uc
			              
			              SafeList<Func> preds = world.getAllFunc();
			              for(Func f: preds){
			                Pos fSpan = f.span();
			                //System.err.println(fSpan.y + " " + fSpan.y2 + "<-- function spans.  positions in unsat core -->" + p.y + " " + p.y2);
			                if (fSpan.y <= p.y && p.y2 <= fSpan.y2){
			                  //The uc sentence is in this predicate.
			                  String formatted = f.label.substring(5, f.label.length()) + "[]";
			                  //System.out.println(formatted);
			                  if(formatted.startsWith("exists_") || formatted.startsWith("unique_") || formatted.startsWith("distinct_")){
			                    //Now we check to see if it must be hard.
//			                    for(int q = 0; q < arrayPosCounter; q++){
//			                      if(formatted.startsWith("distinct_")){
//			                        String elementName = formatted.substring(0,9);
//			                        if(elements[q].equals(elementName)){
//			                          if(annotations[q].equals("V")){
//			                          } else {
//			                            relaxable.add(formatted);
//			                          }
//			                        }
//			                      } else if (formatted.startsWith("unique_")){
//			                        String elementName = formatted.substring(0,7);
//			                        if(elements[q].equals(elementName)){
//			                          if(annotations[q].equals("S")){
//			                          } else {
//			                            relaxable.add(formatted);
//			                          }
//			                        }                        
//			                      } else if (formatted.startsWith("exists_")){
//			                        String elementName = formatted.substring(0,7);
//			                        if(elements[q].equals(elementName)){
//			                          if(annotations[q].equals("M")){
//			                          } else {
//			                            relaxable.add(formatted);
//			                          }
//			                        }
//			                      }
//			                         }
			                	  relaxable.add(formatted);
			                  }
			                  //System.out.println(f.toString() + "        " + f.label + "        " + formatted);
			                }
			              }
			            }                  
			            
			            if (relaxable.size() == 0){ //"if S' = \emptyset then return error
			              System.out.println("UNSOLVABLE --- Cannot propagate using solely additional annotations");
			              return;
			            }
			            
			            for(String stri: relaxable){
			              S.add(stri);
			            }
			            
			            
			            // Scanner modelReader = new Scanner(new File(filename));
			            
			            Scanner modelReader = null;
			            if(loopCounter == 0){
			              modelReader = new Scanner(new File(filename));
			            } else {
			              modelReader = new Scanner(new File(filename+(loopCounter-1)));
			            }
			            
			            
			            
			            int lineCounter = 0;
			            int sigCounter = 0;
			            String filenameB = filename+loopCounter; //TODO: this was "0TestANFb.als" when it was "working"
			            
			            
			            FileWriter fstream = new FileWriter(filenameB);
			            loopCounter++;
			            //rofl();
			            BufferedWriter out = new BufferedWriter(fstream);
			            try {
			              while (modelReader.hasNextLine()) {
			                // if (lineCounter == p.y) {
			                String line = modelReader.nextLine();
			                //System.err.println(line);
			                boolean weaken = false;
			                for(String str: relaxable){
			                  //System.out.println(str);
			                  if(str.equals(line.trim())){
			                    //System.out.println(line);
			                    

			                    
			                    //Need to weaken this call.
			                    weaken = true;
			                    break;
			                  }
			                }
			                
			                if (weaken) {
			                  String toWrite = "(" + line + "and #temp" +(sigCounter) + "= 1 ) or (not " + line + " and #temp" +(sigCounter) + " not = 1) \n";
			                  out.write(toWrite);
			                  sigCounter++;
			                } else {
			                  out.write(line + "\n"); 
			                }
			              }
			              for (int l = 0; l < sigCounter; l++){
			                out.write("sig temp" + l + " {} \n");
			              }
			              
			              
			              modelReader.close();
			              out.close();
			              fstream.close();
			              
			            } catch (Exception e) {
			              System.err.println("Error writing temp file: " + e.getMessage());
			            }
			            
			            Sig sB = null;

			            //System.err.println(filename);
			            Module worldB = CompUtil.parseEverything_fromFile(rep, null, filenameB); //should be filenameB
			            for (Sig sigsB: worldB.getAllSigs()){
			              //System.err.println(sigsB.label + "-->" + sigsB.toString() ); // +"-->" + sigsB.getDescription()
			              if(sigsB.label.equals("this/"+elements[j])){
			                //System.err.println(sigsB.label );
			                sB = sigsB;
			              }
			            }
			            
			            Sig temp = sB;
			            //System.err.println(sB.label + "<-- final label");
			            Command commandB = null;
			            Expr eQ = null;

			            //A4Solution ansi = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
			            if (annotations[j].equals("M")){
			              //System.err.println("M...");

			              eQ =  worldB.getAllReachableFacts().and(sB.some().not());

			              commandB = new Command(false, -1, -1, -1, eQ);
			              //System.out.println(commandB.toString() + "   " + commandB.formula.toString());
			            } else if (annotations[j].equals("S")){
			              //System.err.println("S...");
			              Expr expr2 = s.cardinality().equal(ExprConstant.ONE);  //cardinality is one
			              Expr expr2f = expr2.and(worldB.getAllReachableFacts());
			              command = new Command(false, -1, -1, -1, expr2f); //this is the test command.
			            } else { //"V"
			              //System.err.println("V...");
			              Expr expr2V = s.in(s).and(s.in((PrimSig.UNIV).minus(s)).not());// not in all the others
			              Expr expr2Vf = expr2V.and(worldB.getAllReachableFacts());
			              command = new Command(false, -1, -1, -1, expr2Vf); //this is the test command.
			            }
			            


			            //System.err.println("Checkingpointing...A; " + commandB.toString() +" " + commandB.formula.toString());
			            //A4Options optionsB = new A4Options();
			            //optionsB.solver = A4Options.SatSolver.MiniSatProverJNI;


			            //System.err.println("Checkingpointing...B");
			            ConstList<Sig> worldBSigs = worldB.getAllReachableSigs();
			            //System.err.println("Checkingpointing...B2");
			            //System.out.println(worldBSigs.toString());
			            ans = TranslateAlloyToKodkod.execute_command(rep, worldBSigs, commandB, options);
			            //System.err.println("Checkingpointing...C");
			          }
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
			  }
	}

	private static void makeRNF(String[] args) throws Err {
	    System.out.println("Constrainedness: " + constrainedness);
		String csv = "START";
		  
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
	    
	    for(String filename:args) {
	      // Parse+typecheck the model
	      System.out.println("=========== Parsing+Typechecking "+filename+" =============");
	      Module world = CompUtil.parseEverything_fromFile(rep, null, filename);
	      
	      A4Options options = new A4Options();
	      options.solver = A4Options.SatSolver.SAT4J; //Solver can be changed, e.g. for UNSAT core computation.
	      
	      SafeList<Sig> allSigsInitial = world.getAllSigs();
	      ArrayList<Sig> allSigs = (ArrayList)(world.getAllSigs()).makeCopy(); //This is annotations(P) (and more, which will be skipped)
	      boolean needHard = true;
	      SafeList<Sig> userDefinedSigs = world.getAllSigs();
	      Sig initialSig = userDefinedSigs.get(0);
	      Sig hardSig = userDefinedSigs.get(0);

	      for(Sig asi:userDefinedSigs){
	    	  if((asi.label.indexOf("__M") == -1) && (asi.label.indexOf("__V") == -1) && (asi.label.indexOf("__S") == -1)  ){
	    		  initialSig = asi;
	    	  } if((asi.label.indexOf("__M") >= 0) || (asi.label.indexOf("__V") >= 0) || (asi.label.indexOf("__S") >= 0)  ){
	    		  if (needHard == true){
	    			  needHard = false;
	    			  hardSig = asi;
	    		  }
	    	  }
	      }
	      SafeList<Sig> impliedSigs = new SafeList();
	      int numImplied = (int) Math.round(constrainedness*(userDefinedSigs.size()));
	      int sigCounter = 0;
	      for(Sig asi:userDefinedSigs){
	    	  if(sigCounter == numImplied){
	    		  break;
	    	  }
	    	  if(!asi.equals(initialSig)){
	    		  impliedSigs.add(asi);
	    	  }
	    	  sigCounter++;
	      }
	      Expr toAdd = null;
	      if(impliedSigs.size() == 0){
	    	  toAdd = ExprConstant.TRUE;
	      } else {
	    	  String firstLabel = impliedSigs.get(0).label;
	    	  Sig firstSig = impliedSigs.get(0);
	    	  if(firstLabel.indexOf("__M") >= 0) {
	    		  //May
	    		  toAdd = impliedSigs.get(0).some();
	    		  if(firstLabel.indexOf("__V") >= 0){
	    			  //MV
	    			  toAdd = toAdd.or(firstSig.in(firstSig).and(firstSig.in((PrimSig.UNIV).minus(firstSig))).not());
	    			  if(firstLabel.indexOf("__S") >= 0){
	    				  //MSV
	    				  toAdd.or(firstSig.cardinality().equal(ExprConstant.ONE).not());
	    			  }
	    		  }
	    	  } else if(firstLabel.indexOf("__S") >= 0){
				  //S
	    		  toAdd = firstSig.cardinality().equal(ExprConstant.ONE).not();
				  if(firstLabel.indexOf("__V") >= 0){
					  //SV
					  toAdd = toAdd.or(firstSig.in(firstSig).and(firstSig.in((PrimSig.UNIV).minus(firstSig))).not());
				  }
			  } else if(firstLabel.indexOf("__V") >= 0){
				  //V
				  toAdd = firstSig.in(firstSig).and(firstSig.in((PrimSig.UNIV).minus(firstSig)).not());
			  }
	    	  
	    	  for(int i = 1; i < impliedSigs.size(); i++){
	    		  Sig nextSig = impliedSigs.get(i);
	    		  String nextLabel = nextSig.label;
	    		  if(nextLabel.indexOf("__M") >= 0) {
	        		  //May
	        		  Expr toAddB = impliedSigs.get(i).some().not();
	        		  if(nextLabel.indexOf("__V") >= 0){
	        			  //MV
	        			  toAddB = toAddB.or(nextSig.in(nextSig).and(nextSig.in((PrimSig.UNIV).minus(nextSig))).not());
	        			  if(nextLabel.indexOf("__S") >= 0){
	        				  //MSV
	        				  toAddB = toAddB.or(nextSig.cardinality().equal(ExprConstant.ONE).not());
	        			  }
	        		  }
	    			  if(toAdd == null) {
	    				  toAdd = toAddB;
	    			  } else {
	    				  toAdd = toAdd.or(toAddB);
	    			  }
	        	  } else if(nextLabel.indexOf("__S") >= 0){
	    			  //S
	        		  Expr toAddB = nextSig.cardinality().equal(ExprConstant.ONE);
	    			  if(nextLabel.indexOf("__V") >= 0){
	    				  //SV
	    				  toAddB = toAddB.or(nextSig.in(nextSig).and(nextSig.in((PrimSig.UNIV).minus(nextSig))));
	    			  }
	    			  if(toAdd == null) {
	    				  toAdd = toAddB;
	    			  } else {
	    				  toAdd = toAdd.or(toAddB);
	    			  }
	    		  } else if(nextLabel.indexOf("__V") >= 0){
	    			  //V
	    			  Expr toAddB = firstSig.in(nextSig).and(nextSig.in((PrimSig.UNIV).minus(nextSig)));
	    			  if(toAdd == null) {
	    				  toAdd = toAddB;
	    			  } else {
	    				  toAdd = toAdd.or(toAddB);
	    			  }
	    		  }
	    	  }
	      }
	      
	      
	      String hardSigName = hardSig.label.substring(5, hardSig.label.length()); 
	      String hardSigAnnotation = "";
	      Expr hardExpr = ExprConstant.TRUE;
	      if (hardSigName.indexOf("__M") >= 0){
	    	  hardSigAnnotation = "M";
	    	  hardExpr = hardSig.some().not();
	      } else if (hardSigName.indexOf("__S") >= 0){
	    	  hardSigAnnotation = "S";
	    	  hardExpr = hardSig.cardinality().equal(ExprConstant.ONE).not();
	      } else if (hardSigName.indexOf("__V") >= 0){
	    	  hardSigAnnotation = "V";
	    	  hardExpr = hardSig.in(hardSig).and(hardSig.in((PrimSig.UNIV).minus(hardSig)).not());
	      }

	      if (toAdd == null) {
	    	  System.err.println("Error generating WFF constraints...terminating,");
	    	  return;
	      } else {
	    	  toAdd = toAdd.implies(hardExpr);
	      }
	      
	      while (allSigs.iterator().hasNext()) { //Main loop
	        Sig s = allSigs.iterator().next();
	        
	        // Execute the command
	        System.out.println("============ Testing base + " + s + ": ============");
	        
	        Pos insPos = new Pos(filename, 1,1); //Puts predicate in the beginning of the file; TODO: may need to change.
	        
	        Expr finalExpr = null;
	        
	        //Default variable assignments; the if statement will replace the value for "command" using these.
	        Command command = new Command(false, -1, -1, -1, finalExpr); //this is the test command.
	        //System.err.println("checkpoint0 " + s.label);
	        if ((s.label).indexOf("__M") >= 0){ //May
	          //Make the expression to check (note: does not require an actual predicate/function to be created)
	          Expr expr1 = s.some().not();
	          
	          //System.err.println("" + world.getAllReachableFacts().toString());
	          Expr expr1f = expr1.and(world.getAllReachableFacts()).and(toAdd);
	          command = new Command(false, -1, -1, -1, expr1f); //this is the test command.
	          //System.err.println("checkpoint0b " + expr1.toString() + " " + command.toString());
	          //"false" because it's a run, not a check
	          // -1, -1, -1 for default scope, bitwidth, and sequence length, respectively.
	          //expr is the expr to check 
	          
	          A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
	          //System.err.println("checkpoint2");
	          // Print the outcome
	          System.out.println(ans);
	          
	          if (!(ans.satisfiable())) {
	            //Change the sig name
	            System.out.println("Need to change " + s.label + "'s M");
	            csv = csv + "," + s.label + "," + "M";
	            //TODO: this currently only reports what should change, but it should actually change it
	            //It will add the constraint, effectively removing the annotation, but the name changing would be far more intuitive
	            //Can be done with a find/replace on the final model.
	            
	            //Change the set of planned tests
	            //allSigs.remove(s);
	            
	            //Add the sentence
	            //Need to locate the interesting (MAVO) predicate.
	            SafeList<Func> allFuncsSafe = world.getAllFunc();
	            for (Func f: allFuncsSafe) {
	              if(f.label.equals("MAVO")){
	                Expr body = f.getBody();
	                body = body.and(finalExpr);
	                f.setBody(body);
	              }
	            }
	            //System.err.println("checkpoint3a");
	            //world.addGlobal("MAVO", f); //TODO: f is not an EXPR, so this method fails. find better/correct way to do this.
	          } else {
	            //Go to next annotation after checking concretization
	            Iterable<ExprVar> conc = ans.getAllAtoms();
	            ArrayList<Sig> toRemove = (ArrayList) getAdditionalRemovedSigs(conc, allSigsInitial);
	            for(Sig sigRemove: toRemove){
	              allSigs.remove(sigRemove);
	            }
	            //allSigs.remove(s);
	            //System.err.println("checkpoint3b " + s.label );
	          }
	          
	          if ((s.label).indexOf("__S") >= 0) { //It is at least "MS"
	            
	            Expr expr1S = s.cardinality().equal(ExprConstant.ONE);// not in all the others
	            Expr expr1Sf = expr1S.and(world.getAllReachableFacts()).and(toAdd);
	            command = new Command(false, -1, -1, -1, expr1Sf); //this is the test command.
	            
	            A4Solution ansS = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
	            //System.err.println("checkpoint2");
	            // Print the outcome
	            System.out.println(ans);
	            
	            if (!(ansS.satisfiable())) {
	              //Change the sig name
	              System.out.println("Need to change " + s.label + "'s S");
	              csv = csv + "," + s.label + "," + "S";
	              //TODO: this currently only reports what should change, but it should actually change it
	              //It will add the constraint, effectively removing the annotation, but the name changing would be far more intuitive
	              //Can be done with a find/replace on the final model.
	              
	              
	              
	              //Add the sentence
	              //Need to locate the interesting (MAVO) predicate.
	              SafeList<Func> allFuncsSafeS = world.getAllFunc();
	              for (Func f: allFuncsSafeS) {
	                if(f.label.equals("MAVO")){
	                  Expr body = f.getBody();
	                  body = body.and(finalExpr);
	                  f.setBody(body);
	                }
	              }
	              //System.err.println("checkpoint3a");
	              //world.addGlobal("MAVO", f); //TODO: f is not an EXPR, so this method fails. find better/correct way to do this.
	            } else {
	              //Go to next annotation after checking concretization
	              Iterable<ExprVar> concS = ansS.getAllAtoms();
	              ArrayList<Sig> toRemoveS = (ArrayList) getAdditionalRemovedSigs(concS, allSigsInitial);
	              for(Sig sigRemove: toRemoveS){
	                allSigs.remove(sigRemove);
	              }
	              //System.err.println("checkpoint3b " + s.label );
	            }
	            
	            
	            
	            if ((s.label).indexOf("__V") >= 0) { //It is "MSV"
	              
	              Expr expr1V = s.in(s).and(s.in((PrimSig.UNIV).minus(s)).not());// not in all the others
	              Expr expr1Vf = expr1V.and(world.getAllReachableFacts()).and(toAdd);
	              command = new Command(false, -1, -1, -1, expr1Vf); //this is the test command.
	              
	              A4Solution ansV = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
	              //System.err.println("checkpoint2");
	              // Print the outcome
	              System.out.println(ans);
	              
	              if (!(ansV.satisfiable())) {
	                //Change the sig name
	                System.out.println("Need to change " + s.label + "'s V");
	                csv = csv + "," + s.label + "," + "V";
	                //TODO: this currently only reports what should change, but it should actually change it
	                //It will add the constraint, effectively removing the annotation, but the name changing would be far more intuitive
	                //Can be done with a find/replace on the final model.
	                
	                
	                //Add the sentence
	                //Need to locate the interesting (MAVO) predicate.
	                SafeList<Func> allFuncsSafeV = world.getAllFunc();
	                for (Func f: allFuncsSafeV) {
	                  if(f.label.equals("MAVO")){
	                    Expr body = f.getBody();
	                    body = body.and(finalExpr);
	                    f.setBody(body);
	                  }
	                }
	                //System.err.println("checkpoint3a");
	                //world.addGlobal("MAVO", f); //TODO: f is not an EXPR, so this method fails. find better/correct way to do this.
	              } else {
	                //Go to next annotation after checking concretization
	                Iterable<ExprVar> concV = ansV.getAllAtoms();
	                ArrayList<Sig> toRemoveV = (ArrayList) getAdditionalRemovedSigs(concV, allSigsInitial);
	                for(Sig sigRemove: toRemoveV){
	                  allSigs.remove(sigRemove);
	                }
	                //System.err.println("checkpoint3b " + s.label );
	              }
	              
	            }
	          }
	          
	          if ((s.label).indexOf("__V") >= 0) { //It is least "MV"
	            
	            Expr expr1Vb = s.in(s).and(s.in((PrimSig.UNIV).minus(s)).not());// not in all the others
	            Expr expr1Vbf = expr1Vb.and(world.getAllReachableFacts()).and(toAdd);
	            command = new Command(false, -1, -1, -1, expr1Vbf); //this is the test command.
	            
	            A4Solution ansVb = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
	            //System.err.println("checkpoint2");
	            // Print the outcome
	            System.out.println(ans);
	            
	            if (!(ans.satisfiable())) {
	              //Change the sig name
	              System.out.println("Need to change " + s.label + "'s V");
	              csv = csv + "," + s.label + "," + "V";
	              //TODO: this currently only reports what should change, but it should actually change it
	              //It will add the constraint, effectively removing the annotation, but the name changing would be far more intuitive
	              //Can be done with a find/replace on the final model.
	              
	              
	              
	              //Add the sentence
	              //Need to locate the interesting (MAVO) predicate.
	              SafeList<Func> allFuncsSafeVb = world.getAllFunc();
	              for (Func f: allFuncsSafeVb) {
	                if(f.label.equals("MAVO")){
	                  Expr body = f.getBody();
	                  body = body.and(finalExpr);
	                  f.setBody(body);
	                }
	              }
	              //System.err.println("checkpoint3a");
	              //world.addGlobal("MAVO", f); //TODO: f is not an EXPR, so this method fails. find better/correct way to do this.
	            } else {
	              //Go to next annotation after checking concretization
	              Iterable<ExprVar> concVb = ansVb.getAllAtoms();
	              ArrayList<Sig> toRemoveVb = (ArrayList) getAdditionalRemovedSigs(concVb, allSigsInitial);
	              for(Sig sigRemove: toRemoveVb){
	                allSigs.remove(sigRemove);
	              }
	              
	              //System.err.println("checkpoint3b " + s.label );
	            }
	            
	          }
	          allSigs.remove(s);
	        } else if ((s.label).indexOf("__S") >= 0) { //Set
	          Expr expr2 = s.cardinality().equal(ExprConstant.ONE);  //cardinality is one
	          Expr expr2f = expr2.and(world.getAllReachableFacts()).and(toAdd);
	          command = new Command(false, -1, -1, -1, expr2f); //this is the test command.
	          
	          A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
	          //System.err.println("checkpoint2");
	          // Print the outcome
	          System.out.println(ans);
	          
	          if (!(ans.satisfiable())) {
	            //Change the sig name
	            System.out.println("Need to change " + s.label + "'s S");
	            csv = csv + "," + s.label + "," + "S";
	            //TODO: this currently only reports what should change, but it should actually change it
	            //It will add the constraint, effectively removing the annotation, but the name changing would be far more intuitive
	            //Can be done with a find/replace on the final model.
	            
	            
	            //Add the sentence
	            //Need to locate the interesting (MAVO) predicate.
	            SafeList<Func> allFuncsSafe = world.getAllFunc();
	            for (Func f: allFuncsSafe) {
	              if(f.label.equals("MAVO")){
	                Expr body = f.getBody();
	                body = body.and(finalExpr);
	                f.setBody(body);
	              }
	            }
	            //System.err.println("checkpoint3a");
	            //world.addGlobal("MAVO", f); //TODO: f is not an EXPR, so this method fails. find better/correct way to do this.
	          } else {
	            //Go to next annotation after checking concretization
	            Iterable<ExprVar> conc = ans.getAllAtoms();
	            ArrayList<Sig> toRemove = (ArrayList) getAdditionalRemovedSigs(conc, allSigsInitial);
	            for(Sig sigRemove: toRemove){
	              allSigs.remove(sigRemove);
	            }
	            
	            //System.err.println("checkpoint3b " + s.label );
	          }
	          
	          if ((s.label).indexOf("__V") >= 0) { //It is "VS"
	            Expr expr2V = s.in(s).and(s.in((PrimSig.UNIV).minus(s)).not());// not in all the others
	            Expr expr2Vf = expr2V.and(world.getAllReachableFacts()).and(toAdd);
	            command = new Command(false, -1, -1, -1, expr2Vf); //this is the test command.
	            
	            A4Solution ansV = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
	            //System.err.println("checkpoint2");
	            // Print the outcome
	            System.out.println(ans);
	            
	            if (!(ansV.satisfiable())) {
	              //Change the sig name
	              System.out.println("Need to change " + s.label + "'s V");
	              csv = csv + "," + s.label + "," + "V";
	              //TODO: this currently only reports what should change, but it should actually change it
	              //It will add the constraint, effectively removing the annotation, but the name changing would be far more intuitive
	              //Can be done with a find/replace on the final model.
	              
	              
	              
	              //Add the sentence
	              //Need to locate the interesting (MAVO) predicate.
	              SafeList<Func> allFuncsSafeV = world.getAllFunc();
	              for (Func f: allFuncsSafeV) {
	                if(f.label.equals("MAVO")){
	                  Expr body = f.getBody();
	                  body = body.and(finalExpr);
	                  f.setBody(body);
	                }
	              }
	              //System.err.println("checkpoint3a");
	              //world.addGlobal("MAVO", f); //TODO: f is not an EXPR, so this method fails. find better/correct way to do this.
	            } else {
	              //Go to next annotation after checking concretization
	              Iterable<ExprVar> concV = ansV.getAllAtoms();
	              ArrayList<Sig> toRemoveV = (ArrayList) getAdditionalRemovedSigs(concV, allSigsInitial);
	              for(Sig sigRemove: toRemoveV){
	                allSigs.remove(sigRemove);
	              }
	              
	              
	            }
	          }
	          
	          
	          //Change the set of planned tests
	          allSigs.remove(s);
	          
	        } else if ((s.label).indexOf("__V") >= 0) { //Var
	          
	          Expr expr3 = s.in(s).and(s.in((PrimSig.UNIV).minus(s)).not());// not in all the others
	          Expr expr3f = expr3.and(world.getAllReachableFacts()).and(toAdd);
	          command = new Command(false, -1, -1, -1, expr3f); //this is the test command.
	          
	          A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
	          //System.err.println("checkpoint2");
	          // Print the outcome
	          System.out.println(ans);
	          
	          if (!(ans.satisfiable())) {
	            //Change the sig name
	            System.out.println("Need to change " + s.label + "'s V");
	            csv = csv + "," + s.label + "," + "V";
	            //TODO: this currently only reports what should change, but it should actually change it
	            //It will add the constraint, effectively removing the annotation, but the name changing would be far more intuitive
	            //Can be done with a strfind/replace on the final model.
	            
	            
	            
	            //Add the sentence
	            //Need to locate the interesting (MAVO) predicate.
	            SafeList<Func> allFuncsSafe = world.getAllFunc();
	            for (Func f: allFuncsSafe) {
	              if(f.label.equals("MAVO")){
	                Expr body = f.getBody();
	                body = body.and(finalExpr);
	                f.setBody(body);
	              }
	            }
	            //System.err.println("checkpoint3a");
	            //world.addGlobal("MAVO", f); //TODO: f is not an EXPR, so this method fails. find better/correct way to do this.
	          } else {
	            //Go to next annotation after checking concretization
	            Iterable<ExprVar> conc = ans.getAllAtoms();
	            ArrayList<Sig> toRemove = (ArrayList) getAdditionalRemovedSigs(conc, allSigsInitial);
	            for(Sig sigRemove: toRemove){
	              allSigs.remove(sigRemove);
	            }
	            
	            
	          }
	          //Change the set of planned tests
	          allSigs.remove(s);
	        } else {          //TODO:these for all combinations (or a somewhat smarter method)
	          allSigs.remove(s);
	          continue; //Not annotated, not interesting.
	        }
	        //System.err.println("checkpoint1");
	        //System.err.println(world.getAllReachableSigs().size() + "" );
	        //System.err.println(command.toString() );
	        /*for (Sig ss: world.getAllReachableSigs()){
	         System.err.println("" + ss.label);
	         }*/
	        
	      }
	      try {
	      FileWriter fstream = new FileWriter(filename+".ar");
	      
	      
	      BufferedWriter outwriter = new BufferedWriter(fstream);
	      outwriter.write(csv);
	      outwriter.close();
	      fstream.close();
	      } catch (Exception e){
	    	  System.err.println("Error writing annotation results file.");
	      }
	      
	    }

	    System.out.println("Done.");
	}

	private static ArrayList<Sig> getAdditionalRemovedSigs(Iterable<ExprVar> in, SafeList<Sig> sigs){
		 //TODO: this can probably be optimized.
	    ArrayList<Sig> out = new ArrayList<Sig>();
	    for(Sig s: sigs){
	      if(s.label.indexOf("__M") >= 0){
	        boolean oneExists = false;
	        for(ExprVar ev: in){
	          if (ev.label.indexOf(s.label) >= 0) {
	            oneExists = true;
	          }
	        }
	        if (oneExists){
	          out.add(s);
	        }
	      }
	      
	      if(s.label.indexOf("__S") >= 0){
	        int count = 0;
	        for(ExprVar ev: in){
	          if (ev.label.indexOf(s.label) >= 0) {
	            count++;
	          }
	        }
	        if (count > 1){
	          out.add(s);
	        }
	      }
	      
	      if(s.label.indexOf("__V") >= 0){
	        boolean isMerged = false;
	        for(ExprVar ev: in){
	          if (ev.label.equals(s.label)) { //TODO: check that atom names are only ever sig names (probably are, with "this/").
	            isMerged = true;
	          }
	        }
	        if (isMerged){
	          out.add(s);
	        }
	      }
	    }

	    return out;
	}

	private void readProperties(Properties properties) throws Exception {

		algorithm = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_ALGORITHM);
		constrainedness = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_CONSTRAINEDNESS);
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