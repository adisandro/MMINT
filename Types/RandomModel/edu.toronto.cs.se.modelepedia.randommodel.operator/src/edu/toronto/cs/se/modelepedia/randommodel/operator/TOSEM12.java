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
package edu.toronto.cs.se.modelepedia.randommodel.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.z3.Z3SMTIncrementalSolver;
import edu.toronto.cs.se.mmint.z3.Z3SMTIncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.mmint.z3.Z3SMTSolver;
import edu.toronto.cs.se.mmint.z3.Z3SMTUtils;
import edu.toronto.cs.se.mmint.z3.Z3SMTUtils.Z3BoolResult;
import edu.toronto.cs.se.mmint.z3.Z3SMTUtils.Z3ModelResult;
import edu.toronto.cs.se.modelepedia.randommodel.NamedElement;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

public class TOSEM12 extends OperatorImpl {

	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_RandomModelToSMTLIB";
	private static final String PROPERTY_OUT_TIMEMAVO = "timeMAVO";
	private static final String PROPERTY_OUT_TIMECLASSICAL = "timeClassical";
	private static final String PROPERTY_OUT_TIMEMAVOBACKBONE = "timeMAVOBackbone";
	private static final String PROPERTY_OUT_TIMEMAVOALLSAT = "timeMAVOAllsat";
	private static final String PROPERTY_OUT_FLAGS = "flags";
	private static final String PROPERTY_OUT_SPEEDUPCLASSICALMAVO = "speedupClassicalMAVO";
	private static final String PROPERTY_OUT_SPEEDUPMAVOALLSATMAVOBACKBONE = "speedupMAVOAllsatMAVOBackbone";

	private boolean timeClassicalEnabled;
	private boolean timeMAVOBackboneEnabled;
	private boolean timeMAVOAllsatEnabled;
	private long timeMAVO;
	private long timeClassical;
	private long timeMAVOBackbone;
	private long timeMAVOAllsat;
	private StringBuilder flags;
	private double speedupClassicalMAVO;
	private double speedupMAVOAllsatMAVOBackbone;
	private boolean isMAVOMaybe;

	private void readProperties(Properties properties) throws Exception {

		timeClassicalEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMECLASSICAL+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		timeMAVOBackboneEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMEMAVOBACKBONE+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		timeMAVOAllsatEnabled = MultiModelOperatorUtils.getBoolProperty(properties, PROPERTY_OUT_TIMEMAVOALLSAT+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
	}

	private void initOutput() {

		timeMAVO = -1;
		timeClassical = -1;
		timeMAVOBackbone = -1;
		timeMAVOAllsat = -1;
		flags = new StringBuilder();
		speedupClassicalMAVO = -1;
		speedupMAVOAllsatMAVOBackbone = -1;
		isMAVOMaybe = true;
	}

	private void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMEMAVO, String.valueOf(timeMAVO));
		properties.setProperty(PROPERTY_OUT_TIMECLASSICAL, String.valueOf(timeClassical));
		properties.setProperty(PROPERTY_OUT_TIMEMAVOBACKBONE, String.valueOf(timeMAVOBackbone));
		properties.setProperty(PROPERTY_OUT_TIMEMAVOALLSAT, String.valueOf(timeMAVOAllsat));
		properties.setProperty(PROPERTY_OUT_FLAGS, flags.toString());
		properties.setProperty(PROPERTY_OUT_SPEEDUPCLASSICALMAVO, String.valueOf(speedupClassicalMAVO));
		properties.setProperty(PROPERTY_OUT_SPEEDUPMAVOALLSATMAVOBACKBONE, String.valueOf(speedupMAVOAllsatMAVOBackbone));
	}

	private void doMAVOPropertyCheck(String smtlibMavoEncoding, String property) {

		String smtEncoding;

		long startTime = System.nanoTime();
		Z3SMTSolver z3Solver = new Z3SMTSolver();
		smtEncoding = smtlibMavoEncoding + Z3SMTUtils.SMTLIB_ASSERT + property + Z3SMTUtils.SMTLIB_PREDICATE_END;
		Z3BoolResult z3BoolResult = z3Solver.checkSat(smtEncoding);
		if (z3BoolResult != Z3BoolResult.SAT) {
			isMAVOMaybe = false;
		}
		flags.append(z3BoolResult);
		flags.append(',');
		smtEncoding = smtlibMavoEncoding + Z3SMTUtils.SMTLIB_ASSERT + Z3SMTUtils.SMTLIB_NOT + property + Z3SMTUtils.SMTLIB_PREDICATE_END + Z3SMTUtils.SMTLIB_PREDICATE_END;
		z3BoolResult = z3Solver.checkSat(smtEncoding);
		if (z3BoolResult != Z3BoolResult.SAT) {
			isMAVOMaybe = false;
		}
		flags.append(z3BoolResult);
		flags.append(',');
		long endTime = System.nanoTime();

		timeMAVO = endTime - startTime;
	}

	private void doClassicalPropertyCheck(String smtlibEncoding, String property, Set<String> smtlibConcretizations) {

		Z3BoolResult z3BoolResult, firstZ3BoolResult = Z3BoolResult.UNKNOWN;
		String smtEncoding;
		long endTime = 0;

		long startTime = System.nanoTime();
		Z3SMTSolver z3Solver = new Z3SMTSolver();
		Iterator<String> iter = smtlibConcretizations.iterator();
		while (iter.hasNext()) {
			String concretization = iter.next();
			smtEncoding = smtlibEncoding + Z3SMTUtils.SMTLIB_ASSERT + concretization + Z3SMTUtils.SMTLIB_PREDICATE_END + '\n' + Z3SMTUtils.SMTLIB_ASSERT + property + Z3SMTUtils.SMTLIB_PREDICATE_END;
			z3BoolResult = z3Solver.checkSat(smtEncoding);
			flags.append(z3BoolResult);
			flags.append(',');
			if (firstZ3BoolResult == Z3BoolResult.UNKNOWN) {
				firstZ3BoolResult = z3BoolResult;
			}
			if (z3BoolResult == Z3BoolResult.UNKNOWN || (z3BoolResult != firstZ3BoolResult)) {
				endTime = System.nanoTime();
				break;
			}
		}
		if (endTime == 0) {
			endTime = System.nanoTime();
		}

		timeClassical = endTime - startTime;
	}

	private void parseZ3Elements(String z3Model, String z3ElemType, int z3MaxElems, Map<String, Boolean> z3ModelElems, Set<String> z3MayModelElems) {

		int z3ElemsIndex = z3Model.indexOf(Z3SMTUtils.Z3_MODEL_NEWLINE + z3ElemType + Z3SMTUtils.Z3_MODEL_SEPARATOR);
		if (z3ElemsIndex != -1) {
			int begin = z3Model.indexOf(Z3SMTUtils.Z3_MODEL_FUNCTION_START, z3ElemsIndex) + 1;
			int end = z3Model.indexOf(Z3SMTUtils.Z3_MODEL_FUNCTION_END, z3ElemsIndex);
			String z3ElemsString = z3Model.substring(begin, end).trim();
			int newLine = z3ElemsString.indexOf(Z3SMTUtils.Z3_MODEL_NEWLINE);
			int z3ElemArg;
			boolean z3ModelElemValue;
			while (!z3ElemsString.isEmpty()) {
				String[] z3ElemFunc = z3ElemsString.substring(0, newLine).split(Z3SMTUtils.Z3_MODEL_DEFINITION);
				z3ElemsString = z3ElemsString.substring(newLine).trim();
				newLine = z3ElemsString.indexOf(Z3SMTUtils.Z3_MODEL_NEWLINE);
				if (newLine == -1) {
					newLine = z3ElemsString.length();
				}
				z3ModelElemValue = Boolean.parseBoolean(z3ElemFunc[1]);
				try {
					z3ElemArg = Integer.parseInt(z3ElemFunc[0]);
				}
				catch(NumberFormatException e) {
					Iterator<String> z3MayModelElemsIter = z3MayModelElems.iterator();
					while (z3MayModelElemsIter.hasNext()) {
						String z3MayModelElem = z3MayModelElemsIter.next();
						if (!z3MayModelElem.startsWith(Z3SMTUtils.SMTLIB_PREDICATE_START + z3ElemType) || z3ModelElems.containsKey(z3MayModelElem)) {
							continue;
						}
						z3ModelElems.put(z3MayModelElem, new Boolean(z3ModelElemValue));
					}
					break;
				}
				if (z3ElemArg == 0 || z3ElemArg > z3MaxElems) {
					continue;
				}
				String z3ModelElemName = Z3SMTUtils.SMTLIB_PREDICATE_START + z3ElemType + ' ' + z3ElemArg + Z3SMTUtils.SMTLIB_PREDICATE_END;
				if (!z3MayModelElems.contains(z3ModelElemName)) {
					continue;
				}
				z3ModelElems.put(z3ModelElemName, new Boolean(z3ModelElemValue));
			}
		}
	}

	private Map<String, Boolean> parseZ3Model(String z3Model, Set<String> z3MayModelElems) {

		//TODO MMINT[Z3] broken since the switch to z3java api
		// nodes
		Map<String, Boolean> z3ModelElems = new HashMap<String, Boolean>();
		String z3ElemType = RandomModelPackage.eINSTANCE.getNode().getName();
		String z3ElemString = "numberOf" + z3ElemType + 's' + Z3SMTUtils.Z3_MODEL_DEFINITION;
		int begin = z3Model.indexOf(z3ElemString) + z3ElemString.length();
		int end = z3Model.indexOf(Z3SMTUtils.Z3_MODEL_NEWLINE, begin);
		int z3MaxElems = Integer.parseInt(z3Model.substring(begin, end));
		parseZ3Elements(z3Model, z3ElemType.toLowerCase(), z3MaxElems, z3ModelElems, z3MayModelElems);

		// edges
		z3ElemType = RandomModelPackage.eINSTANCE.getEdge().getName();
		z3ElemString = "numberOf" + z3ElemType + 's' + Z3SMTUtils.Z3_MODEL_DEFINITION;
		begin = z3Model.indexOf(z3ElemString) + z3ElemString.length();
		end = z3Model.indexOf(Z3SMTUtils.Z3_MODEL_NEWLINE, begin);
		z3MaxElems = Integer.parseInt(z3Model.substring(begin, end));
		parseZ3Elements(z3Model, z3ElemType.toLowerCase(), z3MaxElems, z3ModelElems, z3MayModelElems);

		return z3ModelElems;
	}

	private boolean optimizeBackboneElement(Map<String, Boolean> initialZ3ModelElems, String currentZ3ModelElem, Boolean currentZ3ModelElemValue, Set<String> outOfBackboneZ3ModelElems) {

		Boolean initialZ3ModelElemValue = initialZ3ModelElems.get(currentZ3ModelElem);
		if (initialZ3ModelElemValue == null || (currentZ3ModelElemValue.booleanValue() == initialZ3ModelElemValue.booleanValue())) {
			return false;
		}
		outOfBackboneZ3ModelElems.add(currentZ3ModelElem);

		return true;
	}

	private void optimizeBackboneElements(Map<String, Boolean> initialZ3ModelElems, Map<String, Boolean> currentZ3ModelElems, Set<String> outOfBackboneZ3ModelElems) {

		for (Map.Entry<String, Boolean> currentZ3ModelElemEntry : currentZ3ModelElems.entrySet()) {
			String currentZ3ModelElem = currentZ3ModelElemEntry.getKey();
			Boolean currentZ3ModelElemValue = currentZ3ModelElemEntry.getValue();
			optimizeBackboneElement(initialZ3ModelElems, currentZ3ModelElem, currentZ3ModelElemValue, outOfBackboneZ3ModelElems);
		}
	}

	private void doMAVOBackbonePropertyCheck(String smtlibMavoEncoding, String property, Set<String> z3MayModelElems) throws MMINTException {

		String smtEncoding;
		Set<String> outOfBackboneZ3ModelElems = new HashSet<String>();

		long startTime = System.nanoTime();
		Z3SMTIncrementalSolver z3IncSolver = new Z3SMTIncrementalSolver();
		smtEncoding = smtlibMavoEncoding + Z3SMTUtils.SMTLIB_ASSERT + property + Z3SMTUtils.SMTLIB_PREDICATE_END;
		Z3ModelResult z3ModelResult = z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		flags.append(z3ModelResult.getZ3BoolResult());
		flags.append(',');
		if (z3ModelResult.getZ3BoolResult() != Z3BoolResult.SAT) {
			throw new MMINTException("Property checking for MAVO model was SAT-SAT but the incremental baseline now is UNSAT.");
		}
		Map<String, Boolean> initialZ3ModelElems = parseZ3Model(z3ModelResult.getZ3Model().toString(), z3MayModelElems);
		Map<String, Boolean> currentZ3ModelElems;
		Iterator<String> z3MayModelElemsIter = z3MayModelElems.iterator();
		while (z3MayModelElemsIter.hasNext()) {
			String z3MayModelElem = z3MayModelElemsIter.next();
			if (outOfBackboneZ3ModelElems.contains(z3MayModelElem)) { // optimization
				continue;
			}
			smtEncoding = Z3SMTUtils.SMTLIB_ASSERT + z3MayModelElem + Z3SMTUtils.SMTLIB_PREDICATE_END;
			z3ModelResult = z3IncSolver.checkSatAndGetModel(smtEncoding, Z3IncrementalBehavior.POP);
			flags.append(z3ModelResult.getZ3BoolResult());
			flags.append(',');
			if (z3ModelResult.getZ3BoolResult() != Z3BoolResult.SAT) { // UNSAT (here z3MayModelElem value should be == to its value in the initial model)
				continue;
			}
			currentZ3ModelElems = parseZ3Model(z3ModelResult.getZ3Model().toString(), z3MayModelElems);
			optimizeBackboneElements(initialZ3ModelElems, currentZ3ModelElems, outOfBackboneZ3ModelElems);
			initialZ3ModelElems.get(z3MayModelElem);
			if (optimizeBackboneElement(initialZ3ModelElems, z3MayModelElem, currentZ3ModelElems.get(z3MayModelElem), outOfBackboneZ3ModelElems)) { // z3MayModelElem value has already changed
				continue;
			}
			smtEncoding = Z3SMTUtils.SMTLIB_ASSERT + Z3SMTUtils.SMTLIB_NOT + z3MayModelElem + Z3SMTUtils.SMTLIB_PREDICATE_END + Z3SMTUtils.SMTLIB_PREDICATE_END;
			z3ModelResult = z3IncSolver.checkSatAndGetModel(smtEncoding, Z3IncrementalBehavior.POP);
			flags.append(z3ModelResult.getZ3BoolResult());
			flags.append(',');
			if (z3ModelResult.getZ3BoolResult() != Z3BoolResult.SAT) { // UNSAT
				continue;
			}
			currentZ3ModelElems = parseZ3Model(z3ModelResult.getZ3Model().toString(), z3MayModelElems);
			optimizeBackboneElements(initialZ3ModelElems, currentZ3ModelElems, outOfBackboneZ3ModelElems);
		}
		long endTime = System.nanoTime();

		timeMAVOBackbone = endTime - startTime;
	}

	private void doMAVOAllsatPropertyCheck(String smtlibMavoEncoding, String property, Set<String> z3MayModelElems) {

		String smtEncoding;

		long startTime = System.nanoTime();
		Z3SMTIncrementalSolver z3IncSolver = new Z3SMTIncrementalSolver();
		smtEncoding = smtlibMavoEncoding + Z3SMTUtils.SMTLIB_ASSERT + property + Z3SMTUtils.SMTLIB_PREDICATE_END;
		Z3ModelResult z3ModelResult = z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		flags.append(z3ModelResult.getZ3BoolResult());
		flags.append(',');
		while (z3ModelResult.getZ3BoolResult() == Z3BoolResult.SAT) {
			Map<String, Boolean> z3ModelElems = parseZ3Model(z3ModelResult.getZ3Model().toString(), z3MayModelElems);
			StringBuilder encodingBuilder = new StringBuilder();
			encodingBuilder.append(Z3SMTUtils.SMTLIB_ASSERT);
			encodingBuilder.append(Z3SMTUtils.SMTLIB_OR);
			for (Map.Entry<String, Boolean> z3ModelElem : z3ModelElems.entrySet()) {
				String z3ModelElemName = z3ModelElem.getKey();
				boolean z3ModelElemValue = z3ModelElem.getValue();
				if (z3ModelElemValue) {
					encodingBuilder.append(Z3SMTUtils.SMTLIB_NOT);
					encodingBuilder.append(z3ModelElemName);
					encodingBuilder.append(Z3SMTUtils.SMTLIB_PREDICATE_END);
				}
				else {
					encodingBuilder.append(z3ModelElemName);
				}
			}
			encodingBuilder.append(Z3SMTUtils.SMTLIB_PREDICATE_END);
			encodingBuilder.append(Z3SMTUtils.SMTLIB_PREDICATE_END);
			z3ModelResult = z3IncSolver.checkSatAndGetModel(encodingBuilder.toString(), Z3IncrementalBehavior.NORMAL);
			flags.append(z3ModelResult.getZ3BoolResult());
			flags.append(',');
		}
		long endTime = System.nanoTime();

		timeMAVOAllsat = endTime - startTime;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model randommodelModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			randommodelModel,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);
		initOutput();

		// get output from previous operator
		RandomModelToSMTLIB previousOperator = (getPreviousOperator() == null) ?
			(RandomModelToSMTLIB) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI) :
			(RandomModelToSMTLIB) getPreviousOperator();
		final String smtlibEncoding = previousOperator.getSMTLIBEncoding();
		final String smtlibMavoEncoding = previousOperator.getSMTLIBMAVOEncoding();
		Set<String> smtlibConcretizations = previousOperator.getSMTLIBConcretizations();
		final String property = previousOperator.getGroundedProperty();
		Set<String> z3MayModelElems = new HashSet<String>();
		for (MAVOElement mayModelObj : previousOperator.getMayModelObjects()) {
			z3MayModelElems.add(previousOperator.getNamedElementSMTLIBEncoding((NamedElement) mayModelObj));
		}

		// run solver
		doMAVOPropertyCheck(smtlibMavoEncoding, property);
		if (timeClassicalEnabled) {
			doClassicalPropertyCheck(smtlibEncoding, property, smtlibConcretizations);
			speedupClassicalMAVO = ((double) timeClassical) / timeMAVO;
		}
		if (isMAVOMaybe) {
			if (timeMAVOBackboneEnabled) {
				doMAVOBackbonePropertyCheck(smtlibMavoEncoding, property, z3MayModelElems);
			}
			if (timeMAVOAllsatEnabled) {
				doMAVOAllsatPropertyCheck(smtlibMavoEncoding, property, z3MayModelElems);
			}
			if (timeMAVOBackboneEnabled && timeMAVOAllsatEnabled) {
				speedupMAVOAllsatMAVOBackbone = ((double) timeMAVOAllsat) / timeMAVOBackbone;
			}
		}

		// save output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			randommodelModel,
			MultiModelOperatorUtils.getSubdir(inputProperties),
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return actualParameters;
	}

}
