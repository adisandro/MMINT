/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;

import com.microsoft.z3.Expr;
import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.FuncInterp;
import com.microsoft.z3.FuncInterp.Entry;
import com.microsoft.z3.Model;
import com.microsoft.z3.Sort;
import com.microsoft.z3.Z3Exception;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

//TODO MMINT[Z3] Refactor all variable names to be consistent
//TODO MMINT[Z3] Remove mavoModelObjs passed to getZ3MAVOModelElements
public class Z3MAVOModelParser {

	private String smtEncoding;
	private String smtEncodingUri;
	private Map<Integer, String> smtEncodingNodes;
	private Map<Integer, String> smtEncodingEdges;
	private Map<Integer, String> smtEncodingElems;
	private boolean isMayOnly;

	public Z3MAVOModelParser(@NonNull String smtEncoding, @NonNull String smtEncodingUri, @NonNull Map<Integer, String> smtEncodingNodes, @NonNull Map<Integer, String> smtEncodingEdges, boolean isMayOnly) {

		this.smtEncoding = smtEncoding;
		this.smtEncodingUri = smtEncodingUri;
		this.smtEncodingNodes = smtEncodingNodes;
		this.smtEncodingEdges = smtEncodingEdges;
		smtEncodingElems = new HashMap<Integer, String>();
		smtEncodingElems.putAll(smtEncodingNodes);
		smtEncodingElems.putAll(smtEncodingEdges);
		this.isMayOnly = isMayOnly;
	}

	public @NonNull String getSMTLIBEncoding() {

		return smtEncoding;
	}

	public @NonNull String getSMTLIBEncodingUri() {

		return smtEncodingUri;
	}

	private @NonNull Map<String, String> getZ3MAVOModelElems(@NonNull Model z3InternalModel, @NonNull String functionName, @NonNull Map<Integer, String> smtEncodingCurrentElems, Map<String, MAVOElement> mavoModelObjs) {

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
				Boolean elseValue = (interp.getElse().toString().equals("true") || interp.getElse().toString().equals("false")) ?
					Boolean.valueOf(interp.getElse().toString()) :
					null;
				if (elseValue == null) { // function that calls another function
					continue;
				}
				// parse entries
				if (elseValue) { // entries are false, else is true (includes all true function)
					if (isMayOnly) {
						Map<String, String> funcZ3ModelElems = new HashMap<>();
						for (Map.Entry<Integer, String> smtEncodingElemEntry : smtEncodingCurrentElems.entrySet()) {
							funcZ3ModelElems.put(smtEncodingElemEntry.getKey().toString(), smtEncodingElemEntry.getValue());
						}
						// remove false entries
						for (Entry entry : interp.getEntries()) {
							funcZ3ModelElems.remove(entry.getArgs()[0].toString());
						}
						// add remaining
						z3ModelElems.putAll(funcZ3ModelElems);
					}
					else {
						// create cartesian product of universeIds and modelIds
						Sort s = decl.getDomain()[1];
						Set<String> universeIds = new HashSet<>();
						for (Expr e : z3InternalModel.getSortUniverse(s)) {
							universeIds.add(e.toString());
						}
						Set<Integer> modelIds = new HashSet<>();
						for (Map.Entry<Integer, String> xEntry : smtEncodingCurrentElems.entrySet()) {
							MAVOElement mavoModelObj = mavoModelObjs.get(xEntry.getValue());
							if (mavoModelObj == null || !mavoModelObj.eClass().getName().equals(s.toString())) {
								continue;
							}
							modelIds.add(xEntry.getKey());
						}
						Map<String, Set<Integer>> zz = new HashMap<>();
						for (String universeId : universeIds) {
							zz.put(universeId, new HashSet<>(modelIds));
						}
						// remove false entries
						for (Entry entry : interp.getEntries()) {
							zz.get(entry.getArgs()[1].toString()).remove(entry.getArgs()[0].toString());
						}
						// add remaining
						for (Map.Entry<String, Set<Integer>> zzEntry : zz.entrySet()) {
							for (Integer zzi : zzEntry.getValue()) {
								//TODO MMINT[Z3] Wrong, need to return String to Set<String>
								z3ModelElems.put(zzEntry.getKey(), smtEncodingCurrentElems.get(zzi));
							}
						}
					}
				}
				else { // entries are true, else is false (includes all false function)
					for (Entry entry : interp.getEntries()) {
						Integer z3ModelElemId = new Integer(entry.getArgs()[0].toString());
						int universeIndex = (isMayOnly) ? 0 : 1;
						z3ModelElems.put(entry.getArgs()[universeIndex].toString(), smtEncodingCurrentElems.get(z3ModelElemId));
					}
				}
			}
		}
		catch (Z3Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't parse Z3 model elements, returning elements so far (possibly none)", e);
		}

		return z3ModelElems;
	}

	public @NonNull Map<String, String> getZ3MAVOModelNodes(@NonNull Z3Model z3Model, Map<String, MAVOElement> mavoModelObjs) {

		return getZ3MAVOModelElems(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_NODE, smtEncodingNodes, mavoModelObjs);
	}

	public @NonNull Map<String, String> getZ3MAVOModelEdges(@NonNull Z3Model z3Model, Map<String, MAVOElement> mavoModelObjs) {

		return getZ3MAVOModelElems(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_EDGE, smtEncodingEdges, mavoModelObjs);
	}

	/**
	 * Gets a map from Z3 model elements (universe ids) to their formula
	 * variable, for elements of a Z3 model that represents a MAVO model
	 * concretization.
	 * 
	 * @param z3Model
	 *            The Z3 model that represents a MAVO model concretization.
	 * @return The Z3 model element to formula variable map.
	 */
	public @NonNull Map<String, String> getZ3MAVOModelElements(@NonNull Z3Model z3Model, Map<String, MAVOElement> mavoModelObjs) {

		Map<String, String> z3ModelElems = new HashMap<String, String>();
		z3ModelElems.putAll(getZ3MAVOModelElems(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_NODE, smtEncodingNodes, mavoModelObjs));
		z3ModelElems.putAll(getZ3MAVOModelElems(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_EDGE, smtEncodingEdges, mavoModelObjs));

		return z3ModelElems;
	}

	public boolean isMayOnly() {

		return isMayOnly;
	}

}
