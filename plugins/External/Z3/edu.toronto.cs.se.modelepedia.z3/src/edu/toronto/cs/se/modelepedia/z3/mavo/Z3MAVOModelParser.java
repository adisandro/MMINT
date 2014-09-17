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
import java.util.Map;
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

	private Map<String, String> getZ3MAVOModelElems(Model z3InternalModel, String functionName, Map<Integer, String> smtEncodingCurrentElems) {

		Map<String, String> z3ModelElems = new HashMap<String, String>();
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
						//TODO MMINT[Z3] fix if mayOnly switches to sorts
						Map<String, String> funcZ3ModelElems = new HashMap<String, String>();
						for (Map.Entry<Integer, String> smtEncodingElemEntry : smtEncodingCurrentElems.entrySet()) {
							funcZ3ModelElems.put(smtEncodingElemEntry.getKey().toString(), smtEncodingElemEntry.getValue());
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
						Integer z3ModelElemId = new Integer(entry.getArgs()[0].toString());
						String z3ModelElemFormulaVar = smtEncodingCurrentElems.get(z3ModelElemId);
						if (mayOnly) {
							z3ModelElems.put(entry.getArgs()[0].toString(), z3ModelElemFormulaVar);
						}
						else {
							z3ModelElems.put(entry.getArgs()[1].toString(), z3ModelElemFormulaVar);
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

	public Map<String, String> getZ3MAVOModelNodes(Z3Model z3Model) {

		return getZ3MAVOModelElems(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_NODE, smtEncodingNodes);
	}

	public Map<String, String> getZ3MAVOModelEdges(Z3Model z3Model) {

		return getZ3MAVOModelElems(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_EDGE, smtEncodingEdges);
	}

	public Map<String, String> getZ3MAVOModelElements(Z3Model z3Model) {

		Map<String, String> z3ModelElems = new HashMap<String, String>();
		z3ModelElems.putAll(getZ3MAVOModelElems(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_NODE, smtEncodingNodes));
		z3ModelElems.putAll(getZ3MAVOModelElems(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_EDGE, smtEncodingEdges));

		return z3ModelElems;
	}

}
