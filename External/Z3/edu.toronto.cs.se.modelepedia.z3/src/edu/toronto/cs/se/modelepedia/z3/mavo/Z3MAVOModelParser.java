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
package edu.toronto.cs.se.modelepedia.z3.mavo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.FuncInterp;
import com.microsoft.z3.Model;
import com.microsoft.z3.Z3Exception;
import com.microsoft.z3.FuncInterp.Entry;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

public class Z3MAVOModelParser {

	private String smtEncoding;
	private String smtEncodingUri;
	private Map<Integer, String> smtEncodingNodes;
	private Map<Integer, String> smtEncodingEdges;
	private Map<Integer, String> smtEncodingElems;

	public Z3MAVOModelParser(String smtEncoding, String smtEncodingUri, Map<Integer, String> smtEncodingNodes, Map<Integer, String> smtEncodingEdges) {

		this.smtEncoding = smtEncoding;
		this.smtEncodingUri = smtEncodingUri;
		this.smtEncodingNodes = smtEncodingNodes;
		this.smtEncodingEdges = smtEncodingEdges;
		smtEncodingElems = new HashMap<Integer, String>();
		smtEncodingElems.putAll(smtEncodingNodes);
		smtEncodingElems.putAll(smtEncodingEdges);
	}

	public String getSMTLIBEncoding() {

		return smtEncoding;
	}

	public String getSMTLIBEncodingUri() {

		return smtEncodingUri;
	}

	private Map<String, Integer> getZ3MAVOModelConcretizations(Model z3InternalModel, Set<String> functionNames, Map<Integer, String> smtEncodingCurrentElems) {

		Map<String, Integer> z3ModelElems = new HashMap<String, Integer>();
		try {
			for (FuncDecl decl : z3InternalModel.getFuncDecls()) {
				// filter function
				String declName = decl.getName().toString();
				int subfuncIndex = declName.indexOf(Z3Utils.Z3_MODEL_SEPARATOR);
				if (subfuncIndex != -1) {
					declName = declName.substring(0, subfuncIndex);
				}
				if (!functionNames.contains(declName)) {
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
						Set<Integer> smtElems = smtEncodingCurrentElems.keySet();
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

	public Map<String, Integer> getZ3MAVOModelNodeConcretizations(Z3Model z3Model) {

		Set<String> nodeFunction = new HashSet<String>();
		nodeFunction.add(Z3Utils.SMTLIB_NODE);

		return getZ3MAVOModelConcretizations(z3Model.getZ3InternalModel(), nodeFunction, smtEncodingNodes);
	}

	public Map<String, Integer> getZ3MAVOModelEdgeConcretizations(Z3Model z3Model) {

		Set<String> edgeFunction = new HashSet<String>();
		edgeFunction.add(Z3Utils.SMTLIB_EDGE);

		return getZ3MAVOModelConcretizations(z3Model.getZ3InternalModel(), edgeFunction, smtEncodingEdges);
	}

	public Map<String, Integer> getZ3MAVOModelNodeEdgeConcretizations(Z3Model z3Model) {

		Set<String> functions = new HashSet<String>();
		functions.add(Z3Utils.SMTLIB_NODE);
		functions.add(Z3Utils.SMTLIB_EDGE);

		return getZ3MAVOModelConcretizations(z3Model.getZ3InternalModel(), functions, smtEncodingElems);
	}

	public String getZ3MAVOElementFormulaVar(Integer z3ModelElementId) {

		return smtEncodingElems.get(z3ModelElementId);
	}

	//TODO create other parser apis (i.e. all the things that directly access the three levels of the encoding/model)
	//TODO migrate from Z3Model to this
}
