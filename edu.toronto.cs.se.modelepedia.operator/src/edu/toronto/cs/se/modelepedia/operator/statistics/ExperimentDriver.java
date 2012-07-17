/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.statistics;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.modelepedia.operator.statistics.ExperimentSamples.DistributionType;

public class ExperimentDriver extends OperatorExecutableImpl {

	public boolean requestedInterval() {

		return false;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		//TODO MMTF: properties ->
		//OUTER
		// -annotated, -may, -var, -set
		// min instances in model
		// max instances in model
		// maybe min e max instances in model element
		// initial seed
		// output file/format
		//INNER
		// min number of iterations (samples)
		int minSamples = 0;
		// max number of iterations (samples)
		int maxSamples = 1;
		// min value that has meaning for the sample
		double min = 0;
		// max value that has meaning for the sample
		double max = 1;
		// distribution type
		DistributionType distribution = null;
		// confidence requested (% with respect to average value)
		double requestedConfidence = 0.3;

		//TODO MMTF: outer cycle -> variate experiment setup
		//TODO MMTF: inner cycle-> setup is constant, create sample by running X, evaluate confidence interval
		ExperimentSamples experiment = new ExperimentSamples(maxSamples, distribution, min, max, requestedConfidence);
		for (int i = 0; i < maxSamples; i++) {
			double sample = 0;//TODO MMTF: run right operator
			boolean confidenceOk = experiment.addSample(sample) && i >= minSamples;
			if (confidenceOk) {
				break;
			}
		}

		//TODO MMTF: save results somewhere
		experiment.getLowerConfidence();
		experiment.getAverage();
		experiment.getUpperConfidence();

		return null;
	}

}
