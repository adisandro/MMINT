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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.modelepedia.randommodel.NamedElement;
import edu.toronto.cs.se.modelepedia.randommodel.operator.Z3SMTSolver.CLibrary.Z3Result;

public class Z3SMTSolver extends OperatorExecutableImpl {

	private static final String PROPERTY_IN_PROPERTY = "property";
	private static final String Z3_LIBRARY_NAME = "z3";
	private static final String OPERATOR_LIBRARY_NAME = "Z3SMTSolver";
	private static final String LIBRARY_PATH = "/usr/lib";
	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_RandomModelToSMTLIB";
	private static final String PROPERTY_OUT_TIMEMAVO = "timeMAVO";
	private static final String PROPERTY_OUT_TIMEBACKBONE = "timeBackbone";
	private static final String PROPERTY_OUT_TIME = "time";
	private static final String PROPERTY_OUT_CHECKS = "checks";

	private final static String SMTLIB_ASSERT = "(assert ";
	private final static String SMTLIB_NOT = "(not ";
	private final static String SMTLIB_PREDICATE_END = ")\n";
	private final static String SMTLIB_ENCODING_POSTAMBLE = "(check-sat)";

	private String property;

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

		Z3Result checkSat(String smtString, int getModel);
	}

	private void readProperties(Properties properties) throws Exception {

		property = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_PROPERTY);
	}

	private void writeProperties(Properties properties, long timeMAVO, long timeBackbone, long time, String checks) {

		properties.setProperty(PROPERTY_OUT_TIMEMAVO, String.valueOf(timeMAVO));
		properties.setProperty(PROPERTY_OUT_TIMEBACKBONE, String.valueOf(timeBackbone));
		properties.setProperty(PROPERTY_OUT_TIME, String.valueOf(time));
		properties.setProperty(PROPERTY_OUT_CHECKS, checks);
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

		// run solver
		System.setProperty("jna.library.path", LIBRARY_PATH);
		StringBuilder checks = new StringBuilder((smtlibConcretizations.size() + 1) * 4);
		Z3Result z3Result;
		// MAVO property check
		long startTimeMAVO = System.nanoTime();
		String finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
		z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding, 0);
		checks.append(z3Result.flag);
		checks.append(',');
		finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + SMTLIB_NOT + property + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
		z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding, 0);
		checks.append(z3Result.flag);
		checks.append(',');
		long endTimeMAVO = System.nanoTime();
		// backbone property check
		long startTimeBackbone = System.nanoTime();
		for (MAVOElement mayModelObj : mayModelObjs) {
			finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + previousOperator.getNamedElementSMTEncoding((NamedElement) mayModelObj) + SMTLIB_PREDICATE_END + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
			z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding, 1);
			checks.append(z3Result.flag);
			checks.append(',');
			if (z3Result.flag == -1) {
				continue;
			}
			finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + SMTLIB_NOT + previousOperator.getNamedElementSMTEncoding((NamedElement) mayModelObj) + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
			z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding, 1);
			checks.append(z3Result.flag);
			checks.append(',');
			//TODO MMTF: do we need to try !property too?
			//TODO MMTF: optimizations if result == 1?
		}
		long endTimeBackbone = System.nanoTime();
		// non-MAVO property check
		long startTime = System.nanoTime();
		Iterator<String> iter = smtlibConcretizations.iterator();
		while (iter.hasNext()) {
			String concretization = iter.next();
			finalEncoding = smtlibEncoding + SMTLIB_ASSERT + concretization + SMTLIB_PREDICATE_END + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
			z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding, 0);
			checks.append(z3Result.flag);
			checks.append(',');
			finalEncoding = smtlibEncoding + SMTLIB_ASSERT + concretization + SMTLIB_PREDICATE_END + SMTLIB_ASSERT + SMTLIB_NOT + property + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
			z3Result = CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding, 0);
			checks.append(z3Result.flag);
			checks.append(',');
		}
		long endTime = System.nanoTime();

		// save execution times
		long timeMAVO = endTimeMAVO - startTimeMAVO;
		long timeBackbone = endTimeBackbone - startTimeBackbone;
		long time = endTime - startTime;
		Properties outputProperties = new Properties();
		writeProperties(outputProperties, timeMAVO, timeBackbone, time, checks.toString());
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
