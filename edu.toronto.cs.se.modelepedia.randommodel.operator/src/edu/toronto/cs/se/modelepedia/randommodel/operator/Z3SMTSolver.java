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

import edu.toronto.cs.se.mmtf.MMTFException;
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
	private static final String PROPERTY_OUT_TIMEMAVOALLSAT = "timeMAVOAllsat";
	private static final String PROPERTY_OUT_FLAGS = "flags";
	private static final String PROPERTY_OUT_SPEEDUPMAVOSTANDARDMAYBE = "speedupMAVOStandardMaybe";
	private static final String PROPERTY_OUT_SPEEDUPMAVOBACKBONESTANDARDALL = "speedupMAVOBackboneStandardAll";
	private static final String PROPERTY_OUT_SPEEDUPMAVOALLSATSTANDARDALL = "speedupMAVOAllsatStandardAll";

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
	private long timeMAVOAllsat;
	private StringBuilder flags;
	private double speedupMAVOStandardMaybe;
	private double speedupMAVOBackboneStandardAll;
	private double speedupMAVOAllsatStandardAll;
	private boolean doMAVOBackbone;
	private boolean doMAVOAllsat;

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
		void checkSatAndGetModelIncremental(Z3IncResult incResult, String smtEncoding, int removeLastAssertion);
		void freeResultIncremental(Z3IncResult incResult);
	}

	private void readProperties(Properties properties) throws Exception {

	}

	private void initOutput(HashSet<String> smtlibConcretizations) {

		timeMAVO = -1;
		timeStandardMaybe = -1;
		timeStandardAll = -1;
		timeMAVOBackbone = -1;
		timeMAVOAllsat = -1;
		flags = new StringBuilder((smtlibConcretizations.size() + 2) * 3);
		speedupMAVOStandardMaybe = -1;
		speedupMAVOBackboneStandardAll = -1;
		speedupMAVOAllsatStandardAll = -1;
		doMAVOBackbone = true;
		doMAVOAllsat = true;
	}

	private void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMEMAVO, String.valueOf(timeMAVO));
		properties.setProperty(PROPERTY_OUT_TIMESTANDARDMAYBE, String.valueOf(timeStandardMaybe));
		properties.setProperty(PROPERTY_OUT_TIMESTANDARDALL, String.valueOf(timeStandardAll));
		properties.setProperty(PROPERTY_OUT_TIMEMAVOBACKBONE, String.valueOf(timeMAVOBackbone));
		properties.setProperty(PROPERTY_OUT_TIMEMAVOALLSAT, String.valueOf(timeMAVOAllsat));
		properties.setProperty(PROPERTY_OUT_FLAGS, flags.toString());
		properties.setProperty(PROPERTY_OUT_SPEEDUPMAVOSTANDARDMAYBE, String.valueOf(speedupMAVOStandardMaybe));
		properties.setProperty(PROPERTY_OUT_SPEEDUPMAVOBACKBONESTANDARDALL, String.valueOf(speedupMAVOBackboneStandardAll));
		properties.setProperty(PROPERTY_OUT_SPEEDUPMAVOALLSATSTANDARDALL, String.valueOf(speedupMAVOAllsatStandardAll));
	}

	private void doMAVOPropertyCheck(String smtlibMavoEncoding, String property) {

		int z3Result;
		String encoding;

		long startTime = System.nanoTime();
		encoding = smtlibMavoEncoding + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END;
		z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(encoding);
		if (z3Result != 1) {
			doMAVOBackbone = false;
			doMAVOAllsat = false;
		}
		flags.append(z3Result);
		flags.append(',');
		encoding = smtlibMavoEncoding + SMTLIB_ASSERT + SMTLIB_NOT + property + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END;
		z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(encoding);
		if (z3Result != 1) {
			doMAVOBackbone = false;
		}
		flags.append(z3Result);
		flags.append(',');
		long endTime = System.nanoTime();

		timeMAVO = endTime - startTime;
	}

	private void doNonMAVOPropertyCheck(String smtlibEncoding, String property, HashSet<String> smtlibConcretizations) {

		int z3Result, firstZ3Result = 0;
		String encoding;
		long endTimeMaybe = 0;

		long startTime = System.nanoTime();
		Iterator<String> iter = smtlibConcretizations.iterator();
		while (iter.hasNext()) {
			String concretization = iter.next();
			encoding = smtlibEncoding + SMTLIB_ASSERT + concretization + SMTLIB_PREDICATE_END + '\n' + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END;
			z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(encoding);
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

	private void parseZ3Elements(String z3Model, String z3ElemType, int z3MaxElems, Map<String, Boolean> z3ModelElems, Set<String> z3MayModelElems) {

		int z3ElemsIndex = z3Model.indexOf(Z3_ELEMFUNC_NEWLINE + z3ElemType + Z3_ELEMFUNC_PLACEHOLDER);
		if (z3ElemsIndex != -1) {
			int begin = z3Model.indexOf(Z3_ELEMFUNC_BEGIN, z3ElemsIndex) + 1;
			int end = z3Model.indexOf(Z3_ELEMFUNC_END, z3ElemsIndex);
			String z3ElemsString = z3Model.substring(begin, end).trim();
			int newLine = z3ElemsString.indexOf(Z3_ELEMFUNC_NEWLINE);
			int z3ElemArg;
			boolean z3ModelElemValue;
			while (!z3ElemsString.isEmpty()) {
				String[] z3ElemFunc = z3ElemsString.substring(0, newLine).split(Z3_ELEMFUNC_SEPARATOR);
				z3ElemsString = z3ElemsString.substring(newLine).trim();
				newLine = z3ElemsString.indexOf(Z3_ELEMFUNC_NEWLINE);
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
						if (!z3MayModelElem.startsWith(SMTLIB_PREDICATE_START + z3ElemType) || z3ModelElems.containsKey(z3MayModelElem)) {
							continue;
						}
						z3ModelElems.put(z3MayModelElem, new Boolean(z3ModelElemValue));
					}
					break;
				}
				if (z3ElemArg == 0 || z3ElemArg > z3MaxElems) {
					continue;
				}
				String z3ModelElemName = SMTLIB_PREDICATE_START + z3ElemType + ' ' + z3ElemArg + SMTLIB_PREDICATE_END;
				if (!z3MayModelElems.contains(z3ModelElemName)) {
					continue;
				}
				z3ModelElems.put(z3ModelElemName, new Boolean(z3ModelElemValue));
			}
		}
	}

	private Map<String, Boolean> parseZ3Model(String z3Model, Set<String> z3MayModelElems) {

		// nodes
		Map<String, Boolean> z3ModelElems = new HashMap<String, Boolean>();
		String z3ElemType = RandomModelPackage.eINSTANCE.getNode().getName();
		String z3ElemString = "numberOf" + z3ElemType + 's' + Z3_ELEMFUNC_SEPARATOR;
		int begin = z3Model.indexOf(z3ElemString) + z3ElemString.length();
		int end = z3Model.indexOf(Z3_ELEMFUNC_NEWLINE, begin);
		int z3MaxElems = Integer.parseInt(z3Model.substring(begin, end));
		parseZ3Elements(z3Model, z3ElemType.toLowerCase(), z3MaxElems, z3ModelElems, z3MayModelElems);

		// edges
		z3ElemType = RandomModelPackage.eINSTANCE.getEdge().getName();
		z3ElemString = "numberOf" + z3ElemType + 's' + Z3_ELEMFUNC_SEPARATOR;
		begin = z3Model.indexOf(z3ElemString) + z3ElemString.length();
		end = z3Model.indexOf(Z3_ELEMFUNC_NEWLINE, begin);
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

	private void doMAVOBackbonePropertyCheck(String smtlibMavoEncoding, String property, Set<String> z3MayModelElems) throws MMTFException {

		Z3IncResult z3IncResult;
		String encoding;
		Set<String> outOfBackboneZ3ModelElems = new HashSet<String>();

		long startTime = System.nanoTime();
		encoding = smtlibMavoEncoding + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END;
		z3IncResult = CLibrary.OPERATOR_INSTANCE.firstCheckSatAndGetModelIncremental(encoding);
		flags.append(z3IncResult.flag);
		flags.append(',');
		if (z3IncResult.flag != 1) {
			throw new MMTFException("Property checking for MAVO model was SAT-SAT but the incremental baseline now is UNSAT.");
		}
		Map<String, Boolean> initialZ3ModelElems = parseZ3Model(z3IncResult.model, z3MayModelElems);
		Map<String, Boolean> currentZ3ModelElems;
		Iterator<String> z3MayModelElemsIter = z3MayModelElems.iterator();
		while (z3MayModelElemsIter.hasNext()) {
			String z3MayModelElem = z3MayModelElemsIter.next();
			if (outOfBackboneZ3ModelElems.contains(z3MayModelElem)) { // optimization
				continue;
			}
			encoding = SMTLIB_ASSERT + z3MayModelElem + SMTLIB_PREDICATE_END;
			CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, encoding, 1);
			flags.append(z3IncResult.flag);
			flags.append(',');
			if (z3IncResult.flag != 1) { // UNSAT (here z3MayModelElem value should be == to its value in the initial model)
				continue;
			}
			currentZ3ModelElems = parseZ3Model(z3IncResult.model, z3MayModelElems);
			optimizeBackboneElements(initialZ3ModelElems, currentZ3ModelElems, outOfBackboneZ3ModelElems);
			initialZ3ModelElems.get(z3MayModelElem);
			if (optimizeBackboneElement(initialZ3ModelElems, z3MayModelElem, currentZ3ModelElems.get(z3MayModelElem), outOfBackboneZ3ModelElems)) { // z3MayModelElem value has already changed
				continue;
			}
			encoding = SMTLIB_ASSERT + SMTLIB_NOT + z3MayModelElem + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END;
			CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, encoding, 1);
			flags.append(z3IncResult.flag);
			flags.append(',');
			if (z3IncResult.flag != 1) { // UNSAT
				continue;
			}
			currentZ3ModelElems = parseZ3Model(z3IncResult.model, z3MayModelElems);
			optimizeBackboneElements(initialZ3ModelElems, currentZ3ModelElems, outOfBackboneZ3ModelElems);
		}
		CLibrary.OPERATOR_INSTANCE.freeResultIncremental(z3IncResult);
		long endTime = System.nanoTime();

		timeMAVOBackbone = endTime - startTime;
	}

	private void doMAVOAllsatPropertyCheck(String smtlibMavoEncoding, String property, Set<String> z3MayModelElems) {

		Z3IncResult z3IncResult;
		String encoding;

		long startTime = System.nanoTime();
		encoding = smtlibMavoEncoding + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END;
		z3IncResult = CLibrary.OPERATOR_INSTANCE.firstCheckSatAndGetModelIncremental(encoding);
		flags.append(z3IncResult.flag);
		flags.append(',');
		while (z3IncResult.flag == 1) {
			Map<String, Boolean> z3ModelElems = parseZ3Model(z3IncResult.model, z3MayModelElems);
			StringBuilder encodingBuilder = new StringBuilder();
			encodingBuilder.append(SMTLIB_ASSERT);
			encodingBuilder.append(SMTLIB_OR);
			for (Map.Entry<String, Boolean> z3ModelElem : z3ModelElems.entrySet()) {
				String z3ModelElemName = z3ModelElem.getKey();
				boolean z3ModelElemValue = z3ModelElem.getValue();
				if (z3ModelElemValue) {
					encodingBuilder.append(SMTLIB_NOT);
					encodingBuilder.append(z3ModelElemName);
					encodingBuilder.append(SMTLIB_PREDICATE_END);
				}
				else {
					encodingBuilder.append(z3ModelElemName);
				}
			}
			encodingBuilder.append(SMTLIB_PREDICATE_END);
			encodingBuilder.append(SMTLIB_PREDICATE_END);
			CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3IncResult, encodingBuilder.toString(), 0);
			flags.append(z3IncResult.flag);
			flags.append(',');
		}
		CLibrary.OPERATOR_INSTANCE.freeResultIncremental(z3IncResult);
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

		// get output from previous operator
		RandomModelToSMTLIB previousOperator = (previousExecutable == null) ?
			(RandomModelToSMTLIB) MultiModelTypeRegistry.getOperatorType(PREVIOUS_OPERATOR_URI).getExecutable() :
			(RandomModelToSMTLIB) previousExecutable;
		final String smtlibEncoding = previousOperator.getSMTLIBEncoding();
		final String smtlibMavoEncoding = previousOperator.getSMTLIBMAVOEncoding();
		HashSet<String> smtlibConcretizations = previousOperator.getSMTLIBConcretizations();
		final String property = previousOperator.getGroundedProperty();
		Set<String> z3MayModelElems = new HashSet<String>();
		for (MAVOElement mayModelObj : previousOperator.getMayModelObjects()) {
			z3MayModelElems.add(previousOperator.getNamedElementSMTLIBEncoding((NamedElement) mayModelObj));
		}

		// run solver
		initOutput(smtlibConcretizations);
		System.setProperty("jna.library.path", LIBRARY_PATH);
		doMAVOPropertyCheck(smtlibMavoEncoding, property);
		doNonMAVOPropertyCheck(smtlibEncoding, property, smtlibConcretizations);
		if (doMAVOBackbone) {
			doMAVOBackbonePropertyCheck(smtlibMavoEncoding, property, z3MayModelElems);
			speedupMAVOBackboneStandardAll = ((double) timeStandardAll) / timeMAVOBackbone;
		}
		if (doMAVOAllsat) {
			doMAVOAllsatPropertyCheck(smtlibMavoEncoding, property, z3MayModelElems);
			speedupMAVOAllsatStandardAll = ((double) timeStandardAll) / timeMAVOAllsat;
		}
		speedupMAVOStandardMaybe = ((double) timeStandardMaybe) / timeMAVO;

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
