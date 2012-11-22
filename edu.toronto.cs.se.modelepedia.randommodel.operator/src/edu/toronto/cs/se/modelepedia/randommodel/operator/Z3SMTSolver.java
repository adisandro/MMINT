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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;

import com.sun.jna.Library;
import com.sun.jna.Native;

import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;

public class Z3SMTSolver extends OperatorExecutableImpl {

	private static final String PROPERTY_IN_PROPERTY = "property";
	private static final String Z3_LIBRARY_NAME = "z3";
	private static final String OPERATOR_LIBRARY_NAME = "Z3SMTSolver";
	private static final String LIBRARY_PATH = "/usr/lib";
	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_RandomModelToSMTLIB";
	private static final String PROPERTY_OUT_TIMEMAVO = "timeMAVO";
	private static final String PROPERTY_OUT_TIME = "time";
	private static final String PROPERTY_OUT_CHECKS = "checks";

	private final static String SMTLIB_ASSERT = "(assert ";
	private final static String SMTLIB_NOT = "(not ";
	private final static String SMTLIB_PREDICATE_END = ")";
	private final static String SMTLIB_ENCODING_POSTAMBLE = "(check-sat)";

	private String property;

	public interface CLibrary extends Library {

		CLibrary Z3_INSTANCE = (CLibrary) Native.loadLibrary(Z3_LIBRARY_NAME, CLibrary.class);
		CLibrary OPERATOR_INSTANCE = (CLibrary) Native.loadLibrary(OPERATOR_LIBRARY_NAME, CLibrary.class);

		int checkSat(String smtString);
	}

	private void readProperties(Properties properties) throws Exception {

		property = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_PROPERTY);
	}

	private void writeProperties(Properties properties, long timeMAVO, long time, String checks) {

		properties.setProperty(PROPERTY_OUT_TIMEMAVO, String.valueOf(timeMAVO));
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
		final String smtlibEncoding = previousOperator.getSMTLIBEncoding();
		final String smtlibMavoEncoding = previousOperator.getSMTLIBMAVOEncoding();
		HashSet<String> smtlibConcretizations = previousOperator.getSMTLIBConcretizations();

		// run solver
		System.setProperty("jna.library.path", LIBRARY_PATH);
		StringBuilder checks = new StringBuilder((smtlibConcretizations.size() + 1) * 4);
		// MAVO property check
		long startTimeMAVO = System.nanoTime();
		String finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
		checks.append(CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding));
		checks.append(',');
		finalEncoding = smtlibMavoEncoding + SMTLIB_ASSERT + SMTLIB_NOT + property + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
		checks.append(CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding));
		checks.append(',');
		long endTimeMAVO = System.nanoTime();
		// non-MAVO property check
		long startTime = System.nanoTime();
		Iterator<String> iter = smtlibConcretizations.iterator();
		while (iter.hasNext()) {
			String concretization = iter.next();
			finalEncoding = smtlibEncoding + SMTLIB_ASSERT + concretization + SMTLIB_PREDICATE_END + SMTLIB_ASSERT + property + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
			checks.append(CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding));
			checks.append(',');
			finalEncoding = smtlibEncoding + SMTLIB_ASSERT + concretization + SMTLIB_PREDICATE_END + SMTLIB_ASSERT + SMTLIB_NOT + property + SMTLIB_PREDICATE_END + SMTLIB_PREDICATE_END + SMTLIB_ENCODING_POSTAMBLE;
			checks.append(CLibrary.OPERATOR_INSTANCE.checkSat(finalEncoding));
			checks.append(',');
		}
		long endTime = System.nanoTime();

		// save execution times
		long timeMAVO = endTimeMAVO - startTimeMAVO;
		long time = endTime - startTime;
		Properties outputProperties = new Properties();
		writeProperties(outputProperties, timeMAVO, time, checks.toString());
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
