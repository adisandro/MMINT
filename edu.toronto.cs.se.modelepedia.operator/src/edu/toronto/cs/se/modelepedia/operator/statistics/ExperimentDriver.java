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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.modelepedia.operator.statistics.ExperimentSamples.DistributionType;

public class ExperimentDriver extends OperatorExecutableImpl {

	/** The variables to variate the experiment setup. */
	private static final String PROPERTY_VARIABLES = "variables";
	/** The variable values property suffix. */
	private static final String PROPERTY_VARIABLE_VALUES_SUFFIX = ".values";
	/** The initial seed for the pseudorandom generator. */
	private static final String PROPERTY_SEED = "seed";
	/** The file name for loading/saving the random generator internal state. */
	private static final String PROPERTY_STATE = "state";
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
	/** The operators to be launched in the outer experiment setup cycle. */
	private static final String PROPERTY_EXPERIMENTOPERATORS = "experimentOperators";
	/** The operators to be launched in the inner statistics cycle. */
	private static final String PROPERTY_STATISTICSOPERATORS = "statisticsOperators";
	/** The variable operators property suffix. */
	private static final String PROPERTY_VARIABLE_OPERATORS_SUFFIX = ".operator";

	// experiment setup parameters
	private String[] vars;
	private String[][] values;
	private int cardinality;
	private String[][] experimentSetups;
	// experiment randomness parameters
	private String seed;
	private String state;
	private int minSamples;
	private int maxSamples;
	private double min;
	private double max;
	private DistributionType distribution;
	private double requestedConfidence;
	// experiment operators
	private String[] experimentOperators;
	private String[] statisticsOperators;
	private String[][] varsOperators;

	private void readProperties(Properties properties) throws Exception {

		// outer cycle parameters: vary experiment setup
		vars = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_VARIABLES);
		values = new String[vars.length][];
		cardinality = 1;
		for (int i = 0; i < vars.length; i++) {
			values[i] = MultiModelOperatorUtils.getStringProperties(properties, vars[i]+PROPERTY_VARIABLE_VALUES_SUFFIX);
			cardinality *= values[i].length;
		}

		// inner cycle parameters: experiment setup is fixed, vary randomness and statistics
		seed = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_SEED);
		state = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_STATE);
		minSamples = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_MINSAMPLES);
		maxSamples = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_MAXSAMPLES);
		min = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_MINSAMPLEVALUE);
		max = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_MAXSAMPLEVALUE);
		distribution = DistributionType.valueOf(MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_DISTRIBUTIONTYPE));
		requestedConfidence = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_REQUESTEDCONFIDENCE);

		// operators
		experimentOperators = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_EXPERIMENTOPERATORS);
		statisticsOperators = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_STATISTICSOPERATORS);
		varsOperators = new String[vars.length][];
		for (int i = 0; i < vars.length; i++) {
			varsOperators[i] = MultiModelOperatorUtils.getStringProperties(properties, vars[i]+PROPERTY_VARIABLE_OPERATORS_SUFFIX);
		}
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

	private EList<Model> executeOperator(int experimentIndex, String operatorUri, EList<Model> actualParameters) throws Exception {

		// empty operator list
		if (operatorUri.equals("")) {
			return actualParameters;
		}

		// get operator
		Operator operator = MultiModelTypeRegistry.getOperatorType(operatorUri);
		if (operator == null) {
			throw new MMTFException("Operator uri " + operatorUri + " is not registered");
		}

		// write operator input properties
		Properties operatorProperties = new Properties();
		for (int i = 0; i < varsOperators.length; i++) {
			for (int j = 0; j < varsOperators[i].length; j++) {
				if (varsOperators[i][j].equals(operatorUri)) {
					operatorProperties.setProperty(vars[i], experimentSetups[experimentIndex][i]);
					break;
				}
			}
		}
		// write seed and state everywhere, the operator who needs it will use it
		operatorProperties.setProperty(PROPERTY_SEED, seed);
		operatorProperties.setProperty(PROPERTY_STATE, state);
		//TODO MMTF: write properties in the subdir, as well as redirecting there results of each operator! Yes how?
		//TODO MMTF: use the updateMid=false property to avoid creation of models in the mid, i.e. allow creation of hanging models
		MultiModelOperatorUtils.writePropertiesFile(
			operatorProperties,
			operator.getExecutable(),
			actualParameters.get(0),
			null,
			false,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);

		return operator.getExecutable().execute(actualParameters);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// get experiment properties
		Model model = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getInputPropertiesFile(this, model, null, false);
		readProperties(inputProperties);

		// prepare experiment setup
		experimentSetups = new String[cardinality][vars.length];
		cartesianProduct(experimentSetups);

		// outer cycle: vary experiment setup
		for (int i = 0; i < cardinality; i++) {
			EList<Model> outerParameters = actualParameters;
			for (String operatorUri : experimentOperators) {
				outerParameters = executeOperator(i, operatorUri, outerParameters);
			}
			ExperimentSamples experiment = new ExperimentSamples(maxSamples, distribution, min, max, requestedConfidence);

			// inner cycle: experiment setup is fixed, vary randomness and statistics
			for (int j = 0; j < maxSamples; j++) {
				EList<Model> innerParameters = outerParameters;
				for (String operatorUri : statisticsOperators) {
					innerParameters = executeOperator(i, operatorUri, innerParameters);
				}
				//TODO MMTF: read output from some property file written by the last operator?
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
			MultiModelOperatorUtils.writePropertiesFile(
				outputProperties,
				this,
				model,
				"experiment" + i,
				true,
				MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
			);
		}

		return null;
	}

}
