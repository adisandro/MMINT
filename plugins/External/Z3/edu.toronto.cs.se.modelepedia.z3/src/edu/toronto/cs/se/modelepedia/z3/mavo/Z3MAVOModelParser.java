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

public class Z3MAVOModelParser {

	private String smtEncoding;
	private String smtEncodingUri;
	private Map<Integer, String> smtEncodingNodes;
	private Map<Integer, String> smtEncodingEdges;
	private Map<Integer, String> smtEncodingElems;
	private String smtMacros;
	private Map<String, MAVOElement> mavoModelObjs;
	private boolean isMayOnly;

	public Z3MAVOModelParser(@NonNull String smtEncoding, @NonNull String smtEncodingUri, @NonNull Map<Integer, String> smtEncodingNodes, @NonNull Map<Integer, String> smtEncodingEdges, @NonNull String smtMacros, @NonNull Map<String, MAVOElement> mavoModelObjs, boolean isMayOnly) {

		this.smtEncoding = smtEncoding;
		this.smtEncodingUri = smtEncodingUri;
		this.smtEncodingNodes = smtEncodingNodes;
		this.smtEncodingEdges = smtEncodingEdges;
		smtEncodingElems = new HashMap<>();
		smtEncodingElems.putAll(smtEncodingNodes);
		smtEncodingElems.putAll(smtEncodingEdges);
		this.smtMacros = smtMacros;
		this.mavoModelObjs = mavoModelObjs;
		this.isMayOnly = isMayOnly;
	}

	public @NonNull String getSMTLIBEncoding() {

		return smtEncoding;
	}

	public @NonNull String getSMTLIBEncodingUri() {

		return smtEncodingUri;
	}

	public @NonNull String getSMTLIBMacros() {

		return smtMacros;
	}

	private @NonNull Map<String, Set<String>> getZ3MAVOModelObjs(@NonNull Model z3InternalModel, @NonNull String z3FunctionName, @NonNull Map<Integer, String> smtEncodingCurrentElems) {

		Map<String, Set<String>> z3ModelObjs = new HashMap<>();
		try {
			for (FuncDecl decl : z3InternalModel.getFuncDecls()) {
				// filter function
				String declName = decl.getName().toString();
				int subfuncIndex = declName.indexOf(Z3Utils.Z3_MODEL_SEPARATOR);
				if (subfuncIndex != -1) {
					declName = declName.substring(0, subfuncIndex);
				}
				if (!z3FunctionName.equals(declName)) {
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
						Map<String, Set<String>> funcZ3ModelObjs = new HashMap<>();
						for (Map.Entry<Integer, String> smtEncodingElem : smtEncodingCurrentElems.entrySet()) {
							Set<String> formulaVars = new HashSet<>(1);
							formulaVars.add(smtEncodingElem.getValue());
							funcZ3ModelObjs.put(smtEncodingElem.getKey().toString(), formulaVars);
						}
						// remove false entries
						for (Entry entry : interp.getEntries()) {
							funcZ3ModelObjs.remove(entry.getArgs()[0].toString());
						}
						// add remaining
						z3ModelObjs.putAll(funcZ3ModelObjs);
					}
					else {
						// create cartesian product of universeIds and integerIds
						Sort sort = decl.getDomain()[1];
						Set<String> z3UniverseIds = new HashSet<>();
						for (Expr z3UniverseId : z3InternalModel.getSortUniverse(sort)) {
							z3UniverseIds.add(z3UniverseId.toString());
						}
						Set<Integer> z3IntegerIds = new HashSet<>();
						for (Map.Entry<Integer, String> smtEncodingElem : smtEncodingCurrentElems.entrySet()) {
							MAVOElement mavoModelObj = mavoModelObjs.get(smtEncodingElem.getValue());
							if (!mavoModelObj.eClass().getName().equals(sort.toString())) {
								continue;
							}
							z3IntegerIds.add(smtEncodingElem.getKey());
						}
						Map<String, Set<Integer>> funcZ3ModelObjs = new HashMap<>();
						for (String z3UniverseId : z3UniverseIds) {
							funcZ3ModelObjs.put(z3UniverseId, new HashSet<>(z3IntegerIds));
						}
						// remove false entries
						for (Entry entry : interp.getEntries()) {
							funcZ3ModelObjs.get(entry.getArgs()[1].toString()).remove(Integer.valueOf(entry.getArgs()[0].toString()));
						}
						// add remaining
						for (Map.Entry<String, Set<Integer>> funcZ3ModelObj : funcZ3ModelObjs.entrySet()) {
							Set<String> formulaVars = new HashSet<>();
							z3ModelObjs.put(funcZ3ModelObj.getKey(), formulaVars);
							for (Integer z3IntegerId : funcZ3ModelObj.getValue()) {
								formulaVars.add(smtEncodingCurrentElems.get(z3IntegerId));
							}
						}
					}
				}
				else { // entries are true, else is false (includes all false function)
					for (Entry entry : interp.getEntries()) {
						int z3IdIndex = (isMayOnly) ? 0 : 1;
						String z3Id = entry.getArgs()[z3IdIndex].toString();
						Set<String> formulaVars = z3ModelObjs.get(z3Id);
						if (formulaVars == null) {
							formulaVars = new HashSet<>();
							z3ModelObjs.put(z3Id, formulaVars);
						}
						Integer z3IntegerId = new Integer(entry.getArgs()[0].toString());
						formulaVars.add(smtEncodingCurrentElems.get(z3IntegerId));
					}
				}
			}
		}
		catch (Z3Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't parse Z3 model elements, returning elements so far (possibly none)", e);
		}

		return z3ModelObjs;
	}

	public @NonNull Map<String, Set<String>> getZ3MAVOModelNodes(@NonNull Z3Model z3Model) {

		return getZ3MAVOModelObjs(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_NODE, smtEncodingNodes);
	}

	public @NonNull Map<String, Set<String>> getZ3MAVOModelEdges(@NonNull Z3Model z3Model) {

		return getZ3MAVOModelObjs(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_EDGE, smtEncodingEdges);
	}

	/**
	 * Gets a map from Z3 model objects (a simple Z3 integer id for may only, a
	 * Z3 universe id for full mavo) to their formula variable (multiple formula
	 * variables in case of merged Var model objects), for elements of a Z3
	 * model that represents a MAVO model concretization:
	 * M: 1 Z3 integerId/universeId to 1 formula var, or nothing
	 * S: x Z3 universeIds to 1 formula var
	 * V: 1 Z3 universeId to x formula vars
	 * 
	 * @param z3Model
	 *            The Z3 model that represents a MAVO model concretization.
	 * @return The Z3 model objects to formula variables map.
	 */
	public @NonNull Map<String, Set<String>> getZ3MAVOModelObjects(@NonNull Z3Model z3Model) {

		Map<String, Set<String>> z3ModelObjs = new HashMap<>();
		z3ModelObjs.putAll(getZ3MAVOModelObjs(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_NODE, smtEncodingNodes));
		z3ModelObjs.putAll(getZ3MAVOModelObjs(z3Model.getZ3InternalModel(), Z3Utils.SMTLIB_EDGE, smtEncodingEdges));

		return z3ModelObjs;
	}

	public boolean isMayOnly() {

		return isMayOnly;
	}

	public boolean isAnnotated() {

		return mavoModelObjs.values().stream()
			.allMatch(mavoModelObj -> mavoModelObj.isMay() || mavoModelObj.isSet() || mavoModelObj.isVar());
	}

}
