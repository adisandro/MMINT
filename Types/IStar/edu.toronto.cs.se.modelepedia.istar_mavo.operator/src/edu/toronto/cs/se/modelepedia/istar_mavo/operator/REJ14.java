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
import edu.toronto.cs.se.modelepedia.z3.Z3SMTModel.Z3SMTBool;

public class REJ14 extends FASE14 {

	private final static String PROPERTY_IN_GENERATETARGETSCONCRETIZATION = "generateTargetsConcretization";

	private boolean timeAnalysisEnabled;
	private boolean generateTargetsConcretization;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		timeAnalysisEnabled = MultiModelOperatorUtils.getBoolProperty(inputProperties, PROPERTY_OUT_TIMEANALYSIS+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		generateTargetsConcretization = MultiModelOperatorUtils.getBoolProperty(inputProperties, PROPERTY_IN_GENERATETARGETSCONCRETIZATION);
	}

	@Override
	protected void doTargets(Z3SMTIncrementalSolver z3IncSolver) {

		long extraTime = 0;
		if (!timeAnalysisEnabled) {
			long startTime = System.nanoTime();
			z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
			extraTime = System.nanoTime() - startTime;
		}
		super.doTargets(z3IncSolver);
		timeTargets += extraTime;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model istarModel = actualParameters.get(0);

		// run solver
		collectAnalysisModelObjs(istarModel);
		Z3SMTIncrementalSolver z3IncSolver = new Z3SMTIncrementalSolver();
		if (timeAnalysisEnabled) {
			doAnalysis(z3IncSolver);
		}
		if (timeTargetsEnabled) {
			doTargets(z3IncSolver);
			if (targets == Z3SMTBool.SAT) {
				doRNF(z3IncSolver);
				if (generateTargetsConcretization) {
//					boolean nextConcretization = true;
//					Z3SMTBool z3Bool = Z3SMTBool.SAT;
//					Z3SMTModel z3Model;
//					while (nextConcretization && z3Bool == Z3SMTBool.SAT) {
						/*TODO
						 * (first concretization should be the result of doTargets + doRNF)
						 * copy model and diagram
						 * read model nodes/edges, delete M nodes (Naama's work), create S nodes (useless), merge V nodes
						 * doRNF-like algorithm to create the negation of the current concretization
						 * ask the user if they want the next concretization
						 * assert the negation of the current concretization and check sat
						 */
//					}
				}
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
