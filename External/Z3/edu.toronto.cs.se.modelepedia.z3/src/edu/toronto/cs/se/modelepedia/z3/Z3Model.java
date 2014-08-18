/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.z3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.FuncInterp;
import com.microsoft.z3.Model;
import com.microsoft.z3.Status;
import com.microsoft.z3.Z3Exception;
import com.microsoft.z3.FuncInterp.Entry;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;

public class Z3Model {

	public enum Z3Bool {
	
		SAT, UNSAT, UNKNOWN;
	
		public static Z3Bool toZ3Bool(Status z3Status) {
	
			switch (z3Status) {
				case UNSATISFIABLE:
					return UNSAT;
				case SATISFIABLE:
					return SAT;
				default:
					return UNKNOWN;
			}
		}
	
	}

	private Z3Bool z3Bool;
	private Model z3InternalModel;

	public Z3Model(Z3Bool z3Bool, Model z3InternalModel) {

		this.z3Bool = z3Bool;
		this.z3InternalModel = z3InternalModel;
	}

	public Z3Model(Status z3Status, Model z3InternalModel) {

		this.z3Bool = Z3Bool.toZ3Bool(z3Status);
		this.z3InternalModel = z3InternalModel;
	}

	public Z3Bool getZ3Bool() {

		return z3Bool;
	}

	public Model getZ3InternalModel() {

		return z3InternalModel;
	}

	private Map<String, Integer> getZ3MAVOModelElements(Map<Integer, String> smtEncodingElems, String functionName) {

		Map<String, Integer> z3ModelElems = new HashMap<String, Integer>();
		try {
			for (FuncDecl decl : z3InternalModel.getFuncDecls()) {
				// filter function
				String declName = decl.getName().toString();
				int subfuncIndex = declName.indexOf(Z3Utils.Z3_MODEL_SEPARATOR);
				if (subfuncIndex != -1) {
					declName = declName.substring(0, subfuncIndex);
				}
				if (!functionName.equals(declName)) {
					continue;
				}
				FuncInterp interp = z3InternalModel.getFuncInterp(decl);
				if (interp.getEntries().length == 0) {// function that calls another function
					continue;
				}
				// parse entries
				boolean mayOnly = (interp.getEntries()[0].getNumArgs() == 1); // may-only encoding
				boolean elseValue = Boolean.parseBoolean(interp.getElse().toString());
				if (elseValue) { // entries are false
					if (mayOnly) {
						Set<Integer> smtElems = smtEncodingElems.keySet();
						Map<String, Integer> funcZ3ModelElems = new HashMap<String, Integer>();
						for (Integer smtElem : smtElems) { // add all
							funcZ3ModelElems.put(smtElem.toString(), new Integer(smtElem));
						}
						for (Entry entry : interp.getEntries()) { // remove false entries
							funcZ3ModelElems.remove(entry.getArgs()[0].toString());
						}
						z3ModelElems.putAll(funcZ3ModelElems);
					}
					else {
						//TODO MMINT[TOSEM] is this branch ever going to be a use case?
//						for (Expr concretization : z3InternalModel.getSortUniverse(entriesSort)) {
//							
//						}
					}
				}
				else { // entries are true
					for (Entry entry : interp.getEntries()) {
						if (mayOnly) {
							z3ModelElems.put(entry.getArgs()[0].toString(), new Integer(entry.getArgs()[0].toString()));
						}
						else {
							z3ModelElems.put(entry.getArgs()[1].toString(), new Integer(entry.getArgs()[0].toString()));
						}
					}
				}
			}
		}
		catch (Z3Exception e) {
			MMINTException.print(Type.WARNING, "Can't parse Z3 model elements, returning elements so far (possibly none)", e);
		}

		return z3ModelElems;
	}

	public Map<String, Integer> getZ3MAVOModelNodes(Map<Integer, String> smtEncodingNodes) {

		return getZ3MAVOModelElements(smtEncodingNodes, Z3Utils.SMTLIB_NODE);
	}

	public Map<String, Integer> getZ3MAVOModelEdges(Map<Integer, String> smtEncodingEdges) {

		return getZ3MAVOModelElements(smtEncodingEdges, Z3Utils.SMTLIB_EDGE);
	}

}
