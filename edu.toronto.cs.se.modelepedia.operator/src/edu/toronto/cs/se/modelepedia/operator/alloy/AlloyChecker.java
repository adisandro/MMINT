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
import java.util.Properties;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;

import edu.mit.csail.sdg.alloy4.A4Reporter;
import edu.mit.csail.sdg.alloy4.Err;
import edu.mit.csail.sdg.alloy4.ErrorWarning;
import edu.mit.csail.sdg.alloy4.Pos;
import edu.mit.csail.sdg.alloy4.SafeList;
import edu.mit.csail.sdg.alloy4compiler.ast.Command;
import edu.mit.csail.sdg.alloy4compiler.ast.Expr;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprConstant;
import edu.mit.csail.sdg.alloy4compiler.ast.ExprVar;
import edu.mit.csail.sdg.alloy4compiler.ast.Func;
import edu.mit.csail.sdg.alloy4compiler.ast.Module;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig;
import edu.mit.csail.sdg.alloy4compiler.ast.Sig.PrimSig;
import edu.mit.csail.sdg.alloy4compiler.parser.CompUtil;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Options;
import edu.mit.csail.sdg.alloy4compiler.translator.A4Solution;
import edu.mit.csail.sdg.alloy4compiler.translator.TranslateAlloyToKodkod;
import edu.mit.csail.sdg.alloy4viz.VizGUI;
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
	private static final String PROPERTY_OUT_TIME = "time";

	private String algorithm;

	private static void makeANF(String[] args) throws Err {

		makeRNF(args);
	}

	private static void makeRNF(String[] args) throws Err {
		    
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
		          Expr expr1f = expr1.and(world.getAllReachableFacts());
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
		            Expr expr1Sf = expr1S.and(world.getAllReachableFacts());
		            command = new Command(false, -1, -1, -1, expr1Sf); //this is the test command.
		            
		            A4Solution ansS = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
		            //System.err.println("checkpoint2");
		            // Print the outcome
		            System.out.println(ans);
		            
		            if (!(ansS.satisfiable())) {
		              //Change the sig name
		              System.out.println("Need to change " + s.label + "'s S");
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
		              Expr expr1Vf = expr1V.and(world.getAllReachableFacts());
		              command = new Command(false, -1, -1, -1, expr1Vf); //this is the test command.
		              
		              A4Solution ansV = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
		              //System.err.println("checkpoint2");
		              // Print the outcome
		              System.out.println(ans);
		              
		              if (!(ansV.satisfiable())) {
		                //Change the sig name
		                System.out.println("Need to change " + s.label + "'s V");
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
		            Expr expr1Vbf = expr1Vb.and(world.getAllReachableFacts());
		            command = new Command(false, -1, -1, -1, expr1Vbf); //this is the test command.
		            
		            A4Solution ansVb = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
		            //System.err.println("checkpoint2");
		            // Print the outcome
		            System.out.println(ans);
		            
		            if (!(ans.satisfiable())) {
		              //Change the sig name
		              System.out.println("Need to change " + s.label + "'s V");
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
		          Expr expr2f = expr2.and(world.getAllReachableFacts());
		          command = new Command(false, -1, -1, -1, expr2f); //this is the test command.
		          
		          A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
		          //System.err.println("checkpoint2");
		          // Print the outcome
		          System.out.println(ans);
		          
		          if (!(ans.satisfiable())) {
		            //Change the sig name
		            System.out.println("Need to change " + s.label + "'s S");
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
		            Expr expr2Vf = expr2V.and(world.getAllReachableFacts());
		            command = new Command(false, -1, -1, -1, expr2Vf); //this is the test command.
		            
		            A4Solution ansV = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
		            //System.err.println("checkpoint2");
		            // Print the outcome
		            System.out.println(ans);
		            
		            if (!(ansV.satisfiable())) {
		              //Change the sig name
		              System.out.println("Need to change " + s.label + "'s V");
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
		          Expr expr3f = expr3.and(world.getAllReachableFacts());
		          command = new Command(false, -1, -1, -1, expr3f); //this is the test command.
		          
		          A4Solution ans = TranslateAlloyToKodkod.execute_command(rep, world.getAllReachableSigs(), command, options);
		          //System.err.println("checkpoint2");
		          // Print the outcome
		          System.out.println(ans);
		          
		          if (!(ans.satisfiable())) {
		            //Change the sig name
		            System.out.println("Need to change " + s.label + "'s V");
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
		    }
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
			false,
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
			null,
			false,
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return actualParameters;
	}

}
