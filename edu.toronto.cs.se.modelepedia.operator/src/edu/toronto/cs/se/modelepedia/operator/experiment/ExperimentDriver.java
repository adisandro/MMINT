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
package edu.toronto.cs.se.modelepedia.operator.experiment;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.operator.impl.RandomOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.modelepedia.operator.experiment.ExperimentSamples.DistributionType;

public class ExperimentDriver extends OperatorExecutableImpl {

	protected class ExperimentWatchdog implements Runnable {

		private int experimentIndex;
		private int statisticsIndex;
		private EList<Model> parameters;

		public ExperimentWatchdog(int i, int j, EList<Model> parameters) {

			experimentIndex = i;
			statisticsIndex = j;
			this.parameters = parameters;
		}

		@Override
		public void run() {

			for (int op = 0; op < statisticsOperators.length; op++) {
				try {
					parameters = executeOperator(experimentIndex, statisticsIndex, op, statisticsOperators[op], parameters);
				}
				catch (Exception e) {
					MMTFException.print(Type.WARNING, "Experiment " + experimentIndex + " out of " + (numExperiments-1) + ", sample " + statisticsIndex + " failed", e);
					return;
				}
			}
		}

	}

	/** The variables to variate the experiment setup. */
	private static final String PROPERTY_IN_VARIABLES = "variables";
	/** The variable values property suffix. */
	private static final String PROPERTY_IN_VARIABLEVALUES_SUFFIX = ".values";
	/** The initial seed for the pseudorandom generator. */
	private static final String PROPERTY_IN_SEED = "seed";
	/** Min number of iterations (i.e. samples to generate). */
	private static final String PROPERTY_IN_MINSAMPLES = "minSamples";
	/** Max number of iterations (i.e. samples to generate). */
	private static final String PROPERTY_IN_MAXSAMPLES = "maxSamples";
	/** Min value a sample can take. */
	private static final String PROPERTY_IN_MINSAMPLEVALUE = "minSampleValue";
	/** Max value a sample can take, -1 for unlimited. */
	private static final String PROPERTY_IN_MAXSAMPLEVALUE = "maxSampleValue";
	/** The distribution type to be used when evaluating the confidence. */
	private static final String PROPERTY_IN_DISTRIBUTIONTYPE = "distributionType";
	/** The requested range of confidence interval (% with respect to average value), after which the experiment can be stopped. */
	private static final String PROPERTY_IN_REQUESTEDCONFIDENCE = "requestedConfidence";
	/** The operators to be launched in the outer experiment setup cycle. */
	private static final String PROPERTY_IN_EXPERIMENTOPERATORS = "experimentOperators";
	private static final String[] PROPERTY_IN_EXPERIMENTOPERATORS_DEFAULT = new String[] {};
	/** The operators to be launched in the inner statistics cycle. */
	private static final String PROPERTY_IN_STATISTICSOPERATORS = "statisticsOperators";
	/** The variable operators property suffix. */
	private static final String PROPERTY_IN_ALLOPERATORS_SUFFIX = ".operator";
	/** The outputs of the experiment. */
	private static final String PROPERTY_IN_OUTPUTS = "outputs";
	/** The output default result property suffix. */
	private static final String PROPERTY_IN_OUTPUTDEFAULT_SUFFIX = ".defaultResult";
	/** Max processing time to generate the outputs. */
	private static final String PROPERTY_IN_MAXPROCESSINGTIME = "maxProcessingTime";
	private static final String PROPERTY_OUT_RESULTLOW_SUFFIX = ".resultLow";
	private static final String PROPERTY_OUT_RESULTAVG_SUFFIX = ".resultAvg";
	private static final String PROPERTY_OUT_RESULTUP_SUFFIX = ".resultUp";
	private static final String PROPERTY_OUT_NUMSAMPLES = "numSamples";
	private static final String PROPERTY_OUT_VARIABLEINSTANCE_SUFFIX = ".instance";
	private static final String EXPERIMENT_SUBDIR = "experiment";
	private static final String SAMPLE_SUBDIR = "sample";

	// experiment setup parameters
	private String[] vars;
	private String[][] varValues;
	private int numExperiments;
	private String[][] experimentSetups;
	// experiment randomness parameters
	private long seed;
	private Random state;
	private int minSamples;
	private int maxSamples;
	private double min;
	private double max;
	private DistributionType distribution;
	private double requestedConfidence;
	// experiment operators
	private String[] experimentOperators;
	private String[] statisticsOperators;
	private String[][] varOperators;
	// experiment outputs
	private String[] outputs;
	private String[] outputOperators;
	private double[] outputDefaults;
	private int maxProcessingTime;

	private void readProperties(Properties properties) throws Exception {

		// outer cycle parameters: vary experiment setup
		vars = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_IN_VARIABLES);
		varValues = new String[vars.length][];
		numExperiments = 1;
		for (int i = 0; i < vars.length; i++) {
			varValues[i] = MultiModelOperatorUtils.getStringProperties(properties, vars[i]+PROPERTY_IN_VARIABLEVALUES_SUFFIX);
			numExperiments *= varValues[i].length;
		}

		// inner cycle parameters: experiment setup is fixed, vary randomness and statistics
		seed = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_SEED);
		minSamples = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MINSAMPLES);
		maxSamples = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MAXSAMPLES);
		min = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_MINSAMPLEVALUE);
		max = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_MAXSAMPLEVALUE);
		distribution = DistributionType.valueOf(MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_DISTRIBUTIONTYPE));
		requestedConfidence = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_REQUESTEDCONFIDENCE);

		// operators
		experimentOperators = MultiModelOperatorUtils.getOptionalStringProperties(properties, PROPERTY_IN_EXPERIMENTOPERATORS, PROPERTY_IN_EXPERIMENTOPERATORS_DEFAULT);
		statisticsOperators = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_IN_STATISTICSOPERATORS);
		varOperators = new String[vars.length][];
		for (int i = 0; i < vars.length; i++) {
			varOperators[i] = MultiModelOperatorUtils.getStringProperties(properties, vars[i]+PROPERTY_IN_ALLOPERATORS_SUFFIX);
		}

		// outputs
		outputs = MultiModelOperatorUtils.getStringProperties(properties, PROPERTY_IN_OUTPUTS);
		outputOperators = new String[outputs.length];
		outputDefaults = new double[outputs.length];
		for (int i = 0; i < outputs.length; i++) {
			outputOperators[i] = MultiModelOperatorUtils.getStringProperty(properties, outputs[i]+PROPERTY_IN_ALLOPERATORS_SUFFIX);
			outputDefaults[i] = MultiModelOperatorUtils.getDoubleProperty(properties, outputs[i]+PROPERTY_IN_OUTPUTDEFAULT_SUFFIX);
		}
		maxProcessingTime = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MAXPROCESSINGTIME);
	}

	private Properties writeProperties(ExperimentSamples[] experiment, int experimentIndex, int statisticsIndex) {

		Properties properties = new Properties();

		if (experiment != null) {
			for (int out = 0; out < outputs.length; out++) {
				properties.setProperty(outputs[out]+PROPERTY_OUT_RESULTLOW_SUFFIX, String.valueOf(experiment[out].getLowerConfidence()));
				properties.setProperty(outputs[out]+PROPERTY_OUT_RESULTAVG_SUFFIX, String.valueOf(experiment[out].getAverage()));
				properties.setProperty(outputs[out]+PROPERTY_OUT_RESULTUP_SUFFIX, String.valueOf(experiment[out].getUpperConfidence()));
			}
		}
		properties.setProperty(PROPERTY_OUT_NUMSAMPLES, String.valueOf(statisticsIndex));
		for (int i = 0; i < vars.length; i++) {
			properties.setProperty(vars[i]+PROPERTY_OUT_VARIABLEINSTANCE_SUFFIX, experimentSetups[experimentIndex][i]);
		}

		return properties;
	}

	private void cartesianProduct(String[][] experimentSetups) {

		for (int i = 0; i < numExperiments; i++) {
			int k = 1;
			for (int j = 0; j < varValues.length; j++) {
				String[] value = varValues[j];
				String choice = value[(i/k) % value.length];
				experimentSetups[i][j] = choice;
				k *= value.length;
			}
		}
	}

	private EList<Model> executeOperator(int experimentIndex, int statisticsIndex, int operatorIndex, String operatorUri, EList<Model> actualParameters) throws Exception {

		// empty operator list
		if (operatorUri.equals("")) {
			return actualParameters;
		}

		// get operator
		Operator operator = MultiModelTypeRegistry.getOperatorType(operatorUri);
		if (operator == null) {
			throw new MMTFException("Operator uri " + operatorUri + " is not registered");
		}
		OperatorExecutable executable = operator.getExecutable();

		// write operator input properties
		Properties operatorProperties = new Properties();
		for (int i = 0; i < varOperators.length; i++) {
			for (int j = 0; j < varOperators[i].length; j++) {
				if (varOperators[i][j].equals(operatorUri)) {
					operatorProperties.setProperty(vars[i], experimentSetups[experimentIndex][i]);
					break;
				}
			}
		}
		// set state if operator needs it
		if (executable instanceof RandomOperatorExecutableImpl) {
			((RandomOperatorExecutableImpl) executable).setState(state);
		}
		// never update the mid, it will explode
		operatorProperties.setProperty(MultiModelOperatorUtils.PROPERTY_IN_UPDATEMID, "false");
		// figure out experiment subdir
		if (operatorIndex == 0) {
			String nextOutputSubdir;
			if (statisticsIndex < 0) {
				nextOutputSubdir = EXPERIMENT_SUBDIR + experimentIndex;
			}
			else {
				nextOutputSubdir = (experimentOperators.length == 0) ?
					EXPERIMENT_SUBDIR + experimentIndex + MMTF.URI_SEPARATOR + SAMPLE_SUBDIR + statisticsIndex:
					SAMPLE_SUBDIR + statisticsIndex;
			}
			operatorProperties.setProperty(MultiModelOperatorUtils.PROPERTY_IN_SUBDIR, nextOutputSubdir);
		}
		// write input properties for the operator
		MultiModelOperatorUtils.writePropertiesFile(
			operatorProperties,
			operator.getExecutable(),
			actualParameters.get(0),
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);

		// execute and get state
		EList<Model> result = executable.execute(actualParameters);
		if (executable instanceof RandomOperatorExecutableImpl) {
			state = ((RandomOperatorExecutableImpl) executable).getState();
		}

		return result;
	}

	private double getOutput(Model initialModel, int outputIndex, int experimentIndex, int statisticsIndex) throws Exception {

		// get output operator
		Operator operator = MultiModelTypeRegistry.getOperatorType(outputOperators[outputIndex]);
		if (operator == null) {
			throw new MMTFException("Operator uri " + outputOperators[outputIndex] + " is not registered");
		}

		String experimentSubdir = EXPERIMENT_SUBDIR + experimentIndex + MMTF.URI_SEPARATOR + SAMPLE_SUBDIR + statisticsIndex;
		Properties resultProperties = MultiModelOperatorUtils.getPropertiesFile(
			operator.getExecutable(),
			initialModel,
			experimentSubdir,
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);
		String result = resultProperties.getProperty(outputs[outputIndex]);

		return Double.parseDouble(result);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// get experiment properties
		Model initialModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			initialModel,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);

		// prepare experiment setup
		state = new Random(seed);
		experimentSetups = new String[numExperiments][vars.length];
		cartesianProduct(experimentSetups);

		// outer cycle: vary experiment setup
experimentCycle:
		for (int i = 0; i < numExperiments; i++) {
			// create experiment folder
			IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(MultiModelRegistry.replaceLastSegmentInUri(initialModel.getUri(), EXPERIMENT_SUBDIR + i)));
			if (!folder.exists(null)) {
				folder.create(true, true, null);
			}
			EList<Model> outerParameters = actualParameters;
			for (int op = 0; op < experimentOperators.length; op++) {
				try {
					outerParameters = executeOperator(i, -1, op, experimentOperators[op], outerParameters);
				}
				catch (Exception e) {
					MMTFException.print(MMTFException.Type.WARNING, "Experiment " + i + " out of " + (numExperiments-1) + " failed", e);
					MultiModelOperatorUtils.writePropertiesFile(
						writeProperties(null, i, 0),
						this,
						initialModel,
						EXPERIMENT_SUBDIR + i,
						MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
					);
					continue experimentCycle;
				}
			}

			ExperimentSamples[] experiment = new ExperimentSamples[outputs.length];
			for (int out = 0; out < outputs.length; out++) {
				experiment[out] = new ExperimentSamples(maxSamples, distribution, min, max, requestedConfidence);
			}

			// inner cycle: experiment setup is fixed, vary randomness and statistics
			int j;
			for (j = 0; j < maxSamples; j++) {
				// create sample folder
				folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(MultiModelRegistry.replaceLastSegmentInUri(initialModel.getUri(), EXPERIMENT_SUBDIR + i + MMTF.URI_SEPARATOR + SAMPLE_SUBDIR + j)));
				if (!folder.exists(null)) {
					folder.create(true, true, null);
				}
				EList<Model> innerParameters = outerParameters;
				boolean timedOut = false;
				boolean confidenceOk = true;
				// run time-bounded chain of operators
				ExecutorService executor = Executors.newSingleThreadExecutor();
				try {
					executor.submit(
						new ExperimentWatchdog(i, j, innerParameters)
					).get(maxProcessingTime, TimeUnit.SECONDS);
					executor.shutdown();
				}
				catch (Exception e) {
					executor.shutdownNow();
					timedOut = true;
					MMTFException.print(Type.WARNING, "Experiment " + i + " out of " + (numExperiments-1) + ", sample " + j + " ran over time limit", e);
				}
				// get results
				for (int out = 0; out < outputs.length; out++) {
					try {
						double sample = (timedOut) ?
							outputDefaults[out] :
							getOutput(initialModel, out, i, j);
						if (sample == Double.MAX_VALUE) {
							confidenceOk = false;
							continue;
						}
						confidenceOk = experiment[out].addSample(sample) && confidenceOk;
					}
					catch (Exception e) {
						MMTFException.print(MMTFException.Type.WARNING, "Experiment " + i + " out of " + (numExperiments-1) + ", sample " + j + ", output " + out + " unreadable", e);
						confidenceOk = false;
					}
				}
				// evaluate confidence interval
				if (confidenceOk && j >= minSamples) {
					break;
				}
			}

			// save output
			MultiModelOperatorUtils.writePropertiesFile(
				writeProperties(experiment, i, j),
				this,
				initialModel,
				EXPERIMENT_SUBDIR + i,
				MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
			);
		}

		return null;
	}

}
