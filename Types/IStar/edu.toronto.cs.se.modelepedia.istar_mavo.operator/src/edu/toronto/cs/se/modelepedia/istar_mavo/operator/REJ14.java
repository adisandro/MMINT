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
package edu.toronto.cs.se.modelepedia.istar_mavo.operator;

import java.util.Properties;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils.Z3BoolResult;

public class REJ14 extends FASE14 {

	private enum AnalysisDirection {FORWARD, BACKWARD};

	private static final String PROPERTY_IN_ANALYSISDIRECTION = "analysisDirection";

	private AnalysisDirection analysisDirection;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		analysisDirection = AnalysisDirection.valueOf(MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_ANALYSISDIRECTION));
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model istarModel = actualParameters.get(0);

		// run solver
		//TODO MMINT[ISTAR] change encoding based on analysisDirection
		collectAnalysisModelObjs(istarModel);
		Z3SMTIncrementalSolver z3IncSolver = new Z3SMTIncrementalSolver();
		doAnalysis(z3IncSolver);
		if (timeTargetsEnabled) {
			doTargets(z3IncSolver);
			if (targets == Z3BoolResult.SAT) {
				doRNF(z3IncSolver);
			}
		}

		// save output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			istarModel,
			null,
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);
		if (timeRNF != -1) {
			writeRNF(istarModel);
		}

		return actualParameters;
	}

}
