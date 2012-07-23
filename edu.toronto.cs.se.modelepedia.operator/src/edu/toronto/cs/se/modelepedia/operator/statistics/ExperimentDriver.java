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

import java.util.Properties;
import java.util.Random;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.OperatorUtils;
import edu.toronto.cs.se.modelepedia.operator.statistics.ExperimentSamples.DistributionType;

public class ExperimentDriver extends OperatorExecutableImpl {

	/** The separator for multiple properties with the same key. */
	private static final String PROPERTY_SEPARATOR = ",";
	/** The variables to variate the experiment setup. */
	private static final String PROPERTY_VARIABLES = "variables";
	/** The variable type property suffix. */
	private static final String PROPERTY_VARIABLE_TYPE_SUFFIX = "Type";
	/** The variable values property suffix. */
	private static final String PROPERTY_VARIABLE_VALUES_SUFFIX = "Values";
	/** The initial seed. */
	private static final String PROPERTY_SEED = "seed";
	/** Min number of iterations (i.e. samples to generate). */
	private static final String PROPERTY_MINSAMPLES = "minSamples";
	/** Max number of iterations (i.e. samples to generate). */
	private static final String PROPERTY_MAXSAMPLES = "maxSamples";
	/** Min value a sample can take. */
	private static final String PROPERTY_MINSAMPLEVALUE = "minSampleValue";
	/** Max value a sample can take, -1 for unlimited. */
	private static final String PROPERTY_MAXSAMPLEVALUE = "maxSampleValue";
	/** The distribution type to be used when evaluating the confidence. */
	private static final String PROPERTY_DISTRIBUTIONTYPE = "distributionType";
	/** The requested range of confidence interval (% with respect to average value), after which the experiment can be stopped. */
	private static final String PROPERTY_REQUESTEDCONFIDENCE = "requestedConfidence";

	public enum VariableType {INT, DOUBLE};

	// experiment setup parameters
	private String[] vars;
	private VariableType[] types;
	private String[][] values;
	private int cardinality;
	private String[][] experimentSetups;
	// experiment randomness parameters
	int seed;
	int minSamples;
	int maxSamples;
	double min;
	double max;
	DistributionType distribution;
	double requestedConfidence;

	private void readProperties(Properties properties) throws Exception {

		// outer cycle parameters: vary experiment setup
		vars = OperatorUtils.getStringProperty(properties, PROPERTY_VARIABLES).split(PROPERTY_SEPARATOR);
		types = new VariableType[vars.length];
		values = new String[vars.length][];
		cardinality = 1;
		for (int i = 0; i < vars.length; i++) {
			types[i] = VariableType.valueOf(OperatorUtils.getStringProperty(properties, vars[i]+PROPERTY_VARIABLE_TYPE_SUFFIX));
			values[i] = OperatorUtils.getStringProperty(properties, vars[i]+PROPERTY_VARIABLE_VALUES_SUFFIX).split(PROPERTY_SEPARATOR);
			cardinality *= values[i].length;
		}

		// inner cycle parameters: experiment setup is fixed, vary randomness and statistics
		seed = OperatorUtils.getIntProperty(properties, PROPERTY_SEED);
		minSamples = OperatorUtils.getIntProperty(properties, PROPERTY_MINSAMPLES);
		maxSamples = OperatorUtils.getIntProperty(properties, PROPERTY_MAXSAMPLES);
		min = OperatorUtils.getDoubleProperty(properties, PROPERTY_MINSAMPLEVALUE);
		max = OperatorUtils.getDoubleProperty(properties, PROPERTY_MAXSAMPLEVALUE);
		distribution = DistributionType.valueOf(OperatorUtils.getStringProperty(properties, PROPERTY_DISTRIBUTIONTYPE));
		requestedConfidence = OperatorUtils.getDoubleProperty(properties, PROPERTY_REQUESTEDCONFIDENCE);
	}

	private void writeProperties(Properties properties, ExperimentSamples experiment, int experimentIndex) {

		properties.setProperty("resultLow", String.valueOf(experiment.getLowerConfidence()));
		properties.setProperty("resultAvg", String.valueOf(experiment.getAverage()));
		properties.setProperty("resultUp", String.valueOf(experiment.getUpperConfidence()));
		for (int i = 0; i < vars.length; i++) {
			properties.setProperty(vars[i], experimentSetups[experimentIndex][i]);
		}
	}

	private void cartesianProduct(String[][] experimentSetups) {

		for (int i = 0; i < cardinality; i++) {
			int k = 1;
			for (int j = 0; j < values.length; j++) {
				String[] value = values[j];
				String choice = value[(i/k) % value.length];
				experimentSetups[i][j] = choice;
				k *= value.length;
			}
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// get experiment properties
		Model model = actualParameters.get(0);
		Properties inputProperties = OperatorUtils.getInputPropertiesFile(this, model, null, false);
		readProperties(inputProperties);

		//TODO MMTF: concatenare properties per ogni operatore

		// prepare experiment setup
		experimentSetups = new String[cardinality][vars.length];
		cartesianProduct(experimentSetups);
		for (int i = 0; i < cardinality; i++) { // outer cycle: vary experiment setup
			ExperimentSamples experiment = new ExperimentSamples(maxSamples, distribution, min, max, requestedConfidence);
			for (int j = 0; j < maxSamples; j++) { // inner cycle: experiment setup is fixed, vary randomness and statistics
				//TODO MMTF: runOperator(experimentSetups[i], types, seed);
				//TODO MMTF: chain operators
				double sample = new Random().nextDouble();
				boolean confidenceOk = experiment.addSample(sample);
				if (confidenceOk && j >= minSamples) {
					break;
				}
			}
			// save output
			// TODO MMTF: output file/format?
			Properties outputProperties = new Properties();
			writeProperties(outputProperties, experiment, i);
			OperatorUtils.writeOutputPropertiesFile(outputProperties, this, model, "experiment" + i, true);
		}

		return null;
	}

}
