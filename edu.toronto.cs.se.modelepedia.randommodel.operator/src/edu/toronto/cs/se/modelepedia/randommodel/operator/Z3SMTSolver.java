/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.randommodel.operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.modelepedia.randommodel.NamedElement;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;
import edu.toronto.cs.se.modelepedia.randommodel.operator.Z3SMTSolver.CLibrary.Z3IncResult;

public class Z3SMTSolver extends OperatorExecutableImpl {

	private static final String Z3_LIBRARY_NAME = "z3";
	private static final String OPERATOR_LIBRARY_NAME = "Z3SMTSolver";
	private static final String LIBRARY_PATH = "/usr/lib";
	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_RandomModelToSMTLIB";
	private static final String PROPERTY_OUT_TIMEMAVO = "timeMAVO";
	private static final String PROPERTY_OUT_TIMESTANDARDMAYBE = "timeStandardMaybe";
	private static final String PROPERTY_OUT_TIMESTANDARDALL = "timeStandardAll";
	private static final String PROPERTY_OUT_TIMEMAVOBACKBONE = "timeMAVOBackbone";
	private static final String PROPERTY_OUT_FLAGS = "flags";
	private static final String PROPERTY_OUT_SPEEDUPMAVOSTANDARD = "speedupMAVOStandard";

	public static final String SMTLIB_PREDICATE_START = "(";
	public static final String SMTLIB_PREDICATE_END = ")";
	public static final String SMTLIB_TRUE = " true ";
	public static final String SMTLIB_FALSE = " false ";
	public static final String SMTLIB_ASSERT = SMTLIB_PREDICATE_START + "assert";
	public static final String SMTLIB_AND = SMTLIB_PREDICATE_START + "and";
	public static final String SMTLIB_OR = SMTLIB_PREDICATE_START + "or";
	public static final String SMTLIB_NOT = SMTLIB_PREDICATE_START + "not";

	private static final char Z3_ELEMFUNC_PLACEHOLDER = '!';
	private static final char Z3_ELEMFUNC_BEGIN = '{';
	private static final char Z3_ELEMFUNC_END = '}';
	private static final char Z3_ELEMFUNC_NEWLINE = '\n';
	private static final String Z3_ELEMFUNC_SEPARATOR = " -> ";

	private long timeMAVO;
	private long timeStandardMaybe;
	private long timeStandardAll;
	private long timeMAVOBackbone;
	private StringBuilder flags;
	private double speedupMAVOStandard;

	public interface CLibrary extends Library {

		CLibrary Z3_INSTANCE = (CLibrary) Native.loadLibrary(Z3_LIBRARY_NAME, CLibrary.class);
		CLibrary OPERATOR_INSTANCE = (CLibrary) Native.loadLibrary(OPERATOR_LIBRARY_NAME, CLibrary.class);

		public class Z3Result extends Structure {

			public int flag;
			public String model;

			@Override
			@SuppressWarnings("rawtypes")
			protected List getFieldOrder() {
				List<String> fields = new ArrayList<String>();
				fields.add("flag");
				fields.add("model");
				return fields;
			}
		}

		public class Z3IncResult extends Structure {

			public int flag;
			public String model;
			public Pointer contextPointer;
			public Pointer solverPointer;
			public Pointer modelPointer;

			@Override
			@SuppressWarnings("rawtypes")
			protected List getFieldOrder() {
				List<String> fields = new ArrayList<String>();
				fields.add("flag");
				fields.add("model");
				fields.add("contextPointer");
				fields.add("solverPointer");
				fields.add("modelPointer");
				return fields;
			}
		}

		int checkSat(String smtEncoding);
		Z3Result checkSatAndGetModel(String smtEncoding);
		void freeResult(Z3Result result);
		Z3IncResult firstCheckSatAndGetModelIncremental(String smtEncoding);
		void checkSatAndGetModelIncremental(Z3IncResult incResult, String smtEncoding);
		void freeResultIncremental(Z3IncResult incResult);
	}

	private void readProperties(Properties properties) throws Exception {

	}

	private void initOutput(HashSet<String> smtlibConcretizations) {

		timeMAVO = 0;
		timeStandardMaybe = 0;
		timeStandardAll = 0;
		timeMAVOBackbone = 0;
		flags = new StringBuilder((smtlibConcretizations.size() + 2) * 3);
		speedupMAVOStandard = 0;
	}

	private void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMEMAVO, String.valueOf(timeMAVO));
		properties.setProperty(PROPERTY_OUT_TIMESTANDARDMAYBE, String.valueOf(timeStandardMaybe));
		properties.setProperty(PROPERTY_OUT_TIMESTANDARDALL, String.valueOf(timeStandardAll));
		properties.setProperty(PROPERTY_OUT_TIMEMAVOBACKBONE, String.valueOf(timeMAVOBackbone));
		properties.setProperty(PROPERTY_OUT_FLAGS, flags.toString());
		properties.setProperty(PROPERTY_OUT_SPEEDUPMAVOSTANDARD, String.valueOf(speedupMAVOStandard));
	}

	private void doMAVOPropertyCheck(String smtlibMavoEncoding, String property) {

		int z3Result;
		String finalEncoding;

		long startTime = System.nanoTime();
		finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END;
		z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding);
		flags.append(z3Result);
		flags.append(',');
		finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + SMTLIB_NOT + property + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END;
		z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding);
		flags.append(z3Result);
		flags.append(',');
		long endTime = System.nanoTime();

		timeMAVO = endTime - startTime;
	}

	private void doNonMAVOPropertyCheck(String smtlibEncoding, String property, HashSet<String> smtlibConcretizations) {

		int z3Result, firstZ3Result = 0;
		String finalEncoding;
		long endTimeMaybe = 0;

		long startTime = System.nanoTime();
		Iterator<String> iter = smtlibConcretizations.iterator();
		while (iter.hasNext()) {
			String concretization = iter.next();
			finalEncoding = smtlibEncoding + SMTLIB_ASSERT + concretization + SMTLIB_PREDICATE_END + '\n' + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END;
			z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding);
			if (endTimeMaybe == 0) {
				if (firstZ3Result == 0) {
					firstZ3Result = z3Result;
				}
				if (z3Result == 0 || (z3Result != firstZ3Result)) {
					endTimeMaybe = System.nanoTime();
				}
			}
			flags.append(z3Result);
			flags.append(',');
		}
		long endTime = System.nanoTime();

		timeStandardAll = endTime - startTime;
		timeStandardMaybe = (endTimeMaybe == 0) ? timeStandardAll : (endTimeMaybe - startTime);
	}

	private void parseZ3Elements(String z3Model, String z3ElemType, int z3MaxElems, Map<String, Boolean> z3Elems, List<MAVOElement> mayModelObjs, RandomModelToSMTLIB previousOperator) {

		int z3ElemsIndex = z3Model.indexOf(Z3_ELEMFUNC_NEWLINE + z3ElemType + Z3_ELEMFUNC_PLACEHOLDER);
		if (z3ElemsIndex != -1) {
			int begin = z3Model.indexOf(Z3_ELEMFUNC_BEGIN, z3ElemsIndex) + 1;
			int end = z3Model.indexOf(Z3_ELEMFUNC_END, z3ElemsIndex);
			String z3ElemsString = z3Model.substring(begin, end).trim();
			int newLine = z3ElemsString.indexOf(Z3_ELEMFUNC_NEWLINE);
			int z3ElemArg;
			boolean z3ElemValue;
			while (!z3ElemsString.isEmpty()) {
				String[] z3ElemFunc = z3ElemsString.substring(0, newLine).split(Z3_ELEMFUNC_SEPARATOR);
				z3ElemsString = z3ElemsString.substring(newLine).trim();
				newLine = z3ElemsString.indexOf(Z3_ELEMFUNC_NEWLINE);
				if (newLine == -1) {
					newLine = z3ElemsString.length();
				}
				z3ElemValue = Boolean.parseBoolean(z3ElemFunc[1]);
				try {
					z3ElemArg = Integer.parseInt(z3ElemFunc[0]);
				}
				catch(NumberFormatException e) {
					for (MAVOElement mayModelObj : mayModelObjs) {
						String smtEncodingMayModelObj = previousOperator.getNamedElementSMTLIBEncoding((NamedElement) mayModelObj);
						if (!smtEncodingMayModelObj.startsWith(SMTLIB_PREDICATE_START + z3ElemType) || z3Elems.containsKey(smtEncodingMayModelObj)) {
							continue;
						}
						z3Elems.put(smtEncodingMayModelObj, new Boolean(z3ElemValue));
					}
					break;
				}
				if (z3ElemArg == 0 || z3ElemArg >= z3MaxElems) {
					continue;
				}
				z3Elems.put(SMTLIB_PREDICATE_START + z3ElemType + ' ' + z3ElemArg + SMTLIB_PREDICATE_END, new Boolean(z3ElemValue));
			}
		}
	}

	private Map<String, Boolean> parseZ3Model(String z3Model, List<MAVOElement> mayModelObjs, RandomModelToSMTLIB previousOperator) {

		// nodes
		Map<String, Boolean> z3Elems = new HashMap<String, Boolean>();
		String z3ElemType = RandomModelPackage.eINSTANCE.getNode().getName();
		String z3ElemString = "numberOf" + z3ElemType + 's' + Z3_ELEMFUNC_SEPARATOR;
		int begin = z3Model.indexOf(z3ElemString) + z3ElemString.length();
		int end = z3Model.indexOf(Z3_ELEMFUNC_NEWLINE, begin);
		int z3MaxElems = Integer.parseInt(z3Model.substring(begin, end));
		parseZ3Elements(z3Model, z3ElemType.toLowerCase(), z3MaxElems, z3Elems, mayModelObjs, previousOperator);

		// edges
		z3ElemType = RandomModelPackage.eINSTANCE.getEdge().getName();
		z3ElemString = "numberOf" + z3ElemType + 's' + Z3_ELEMFUNC_SEPARATOR;
		begin = z3Model.indexOf(z3ElemString) + z3ElemString.length();
		end = z3Model.indexOf(Z3_ELEMFUNC_NEWLINE, begin);
		z3MaxElems = Integer.parseInt(z3Model.substring(begin, end));
		parseZ3Elements(z3Model, z3ElemType.toLowerCase(), z3MaxElems, z3Elems, mayModelObjs, previousOperator);

		return z3Elems;
	}

	private void optimizeBackboneElements(Map<String, Boolean> initialZ3Elems, Map<String, Boolean> currentZ3Elems, Set<String> outOfBackboneZ3Elems) {

		for (Map.Entry<String, Boolean> currentZ3Elem : currentZ3Elems.entrySet()) {
			String currentZ3ElemName = currentZ3Elem.getKey();
			boolean currentZ3ElemValue = currentZ3Elem.getValue();
			boolean initialZ3ElemValue = initialZ3Elems.get(currentZ3ElemName);
			if (currentZ3ElemValue != initialZ3ElemValue) {
				outOfBackboneZ3Elems.add(currentZ3ElemName);
			}
		}
	}

	private void doMAVOBackbonePropertyCheck(String smtlibMavoEncoding, String property, List<MAVOElement> mayModelObjs, RandomModelToSMTLIB previousOperator) {

		Z3IncResult z3IncResult;
		String finalEncoding;
		Set<String> outOfBackboneZ3Elems = new HashSet<String>();

		long startTime = System.nanoTime();
		finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END;
		z3IncResult = CLibrary.OPERATOR_INSTANCE.firstCheckSatAndGetModelIncremental(finalEncoding);
		flags.append(z3IncResult.flag);
		flags.append(',');
		if (z3IncResult.flag == 1) {
			Map<String, Boolean> initialZ3Elems = parseZ3Model(z3IncResult.model, mayModelObjs, previousOperator);
			for (MAVOElement mayModelObj : mayModelObjs) {
				String smtEncodingMayModelObj = previousOperator.getNamedElementSMTLIBEncoding((NamedElement) mayModelObj);
				if (outOfBackboneZ3Elems.contains(smtEncodingMayModelObj)) { // optimization
					continue;
				}
				finalEncoding = SMTLIB_ASSERT + smtEncodingMayModelObj + SMTLIB_PREDICATE_END;
				CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, finalEncoding);
				flags.append(z3IncResult.flag);
				flags.append(',');
				if (z3IncResult.flag == -1) {
					continue;
				}
				finalEncoding = SMTLIB_ASSERT + SMTLIB_NOT + smtEncodingMayModelObj + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END;
				CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, finalEncoding);
				flags.append(z3IncResult.flag);
				flags.append(',');
				if (z3IncResult.flag == -1) {
					continue;
				}
				Map<String, Boolean> currentZ3Elems = parseZ3Model(z3IncResult.model, mayModelObjs, previousOperator);
				optimizeBackboneElements(initialZ3Elems, currentZ3Elems, outOfBackboneZ3Elems);
			}
		}
		CLibrary.OPERATOR_INSTANCE.freeResultIncremental(z3IncResult);
		long endTime = System.nanoTime();

		timeMAVOBackbone = endTime - startTime;
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

		// get output from previous operator
		RandomModelToSMTLIB previousOperator = (RandomModelToSMTLIB) MultiModelTypeRegistry.getOperatorType(PREVIOUS_OPERATOR_URI).getExecutable();
		List<MAVOElement> mayModelObjs = previousOperator.getMayModelObjects();
		final String smtlibEncoding = previousOperator.getSMTLIBEncoding();
		final String smtlibMavoEncoding = previousOperator.getSMTLIBMAVOEncoding();
		HashSet<String> smtlibConcretizations = previousOperator.getSMTLIBConcretizations();
		final String property = previousOperator.getGroundedProperty();

		// run solver
		initOutput(smtlibConcretizations);
		System.setProperty("jna.library.path", LIBRARY_PATH);
		doMAVOPropertyCheck(smtlibMavoEncoding, property);
		doMAVOBackbonePropertyCheck(smtlibMavoEncoding, property, mayModelObjs, previousOperator);
		doNonMAVOPropertyCheck(smtlibEncoding, property, smtlibConcretizations);
		speedupMAVOStandard = ((double) timeStandardMaybe) / timeMAVO;

		// save execution times
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
