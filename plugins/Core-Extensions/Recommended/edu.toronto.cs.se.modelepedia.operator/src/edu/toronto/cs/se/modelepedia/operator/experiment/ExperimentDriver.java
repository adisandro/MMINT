/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.experiment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.operator.experiment.ExperimentSamples.DistributionType;

//TODO MMINT[OPERATOR] Create a separate feature for these generic megamodel operators
public class ExperimentDriver extends OperatorImpl {

    protected class ExperimentWatchdog implements Runnable {

        private ExperimentDriver driver;
        private Model initialModel;
        private int experimentIndex;
        private boolean[] outputConfidences;

        public ExperimentWatchdog(ExperimentDriver driver, Model initialModel, int experimentIndex) {

            this.driver = driver;
            this.initialModel = initialModel;
            this.experimentIndex = experimentIndex;
            this.outputConfidences = new boolean[this.driver.outputs.length];
            for (int out = 0; out < this.driver.outputs.length; out++) {
                this.outputConfidences[out] = (this.driver.outputDoConfidences[out]) ? false : true;
            }
        }

        @Override
        public void run() {

            try {
                // create experiment folder
                IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(FileUtils.replaceLastSegmentInPath(this.initialModel.getUri(), EXPERIMENT_SUBDIR + this.experimentIndex)));
                if (!folder.exists(null)) {
                    folder.create(true, true, null);
                }
                List<Operator> outerOperatorWorkflow = new ArrayList<>();
                EList<Model> outerInputModels = new BasicEList<>();
                outerInputModels.add(this.initialModel);
                for (int op = 0; op < this.driver.experimentOperators.length; op++) {
                    try {
                        outerInputModels = executeOperator(this.experimentIndex, -1, op, this.driver.experimentOperators[op], outerInputModels, outerOperatorWorkflow, this.outputConfidences);
                    }
                    catch (Exception e) {
                        MMINTException.print(IStatus.WARNING, "Experiment " + this.experimentIndex + " out of " + (this.driver.numExperiments-1) + " failed", e);
                        MIDOperatorIOUtils.writePropertiesFile(
                            writeProperties(null, this.experimentIndex),
                            this.driver,
                            this.initialModel,
                            EXPERIMENT_SUBDIR + this.experimentIndex,
                            MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX
                        );
                        return;
                    }
                }

                ExperimentSamples[] experiment = new ExperimentSamples[this.driver.outputs.length];
                for (int out = 0; out < this.driver.outputs.length; out++) {
                    experiment[out] = new ExperimentSamples(this.driver.minSamples, this.driver.maxSamples - this.driver.skipWarmupSamples, this.driver.distribution, this.driver.outputMins[out], this.driver.outputMaxs[out], this.driver.requestedConfidence, this.driver.outputDoConfidences[out]);
                }

                // inner cycle: experiment setup is fixed, vary randomness and statistics
                int j;
                for (j = 0; j < this.driver.maxSamples; j++) {
                    // create sample folder
                    folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(FileUtils.replaceLastSegmentInPath(this.initialModel.getUri(), EXPERIMENT_SUBDIR + this.experimentIndex + MMINT.URI_SEPARATOR + SAMPLE_SUBDIR + j)));
                    if (!folder.exists(null)) {
                        folder.create(true, true, null);
                    }
                    List<Operator> innerOperatorWorkflow = new ArrayList<>(outerOperatorWorkflow);
                    EList<Model> innerInputModels = outerInputModels;
                    boolean timedOut = false;
                    // run time-bounded chain of operators
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    try {
                        executor.submit(
                            new SampleWatchdog(this.driver, this.experimentIndex, j, innerInputModels, innerOperatorWorkflow, this.outputConfidences)
                        ).get(this.driver.maxProcessingTime, TimeUnit.SECONDS);
                        executor.shutdown();
                    }
                    catch (Exception e) {
                        executor.shutdownNow();
                        timedOut = true;
                        MMINTException.print(IStatus.WARNING, "Experiment " + this.experimentIndex + " out of " + (this.driver.numExperiments-1) + ", sample " + j + " ran over time limit", e);
                    }
                    // skip warmup phase
                    if (j < this.driver.skipWarmupSamples) {
                        continue;
                    }
                    // get results
                    for (int out = 0; out < this.driver.outputs.length; out++) {
                        try {
                            double sample = (timedOut) ?
                                this.driver.outputDefaults[out] :
                                getOutput(innerOperatorWorkflow, this.initialModel, out, this.experimentIndex, j);
                            if (sample == Double.MAX_VALUE) {
                                MMINTException.print(IStatus.WARNING, "Experiment " + this.experimentIndex + " out of " + (this.driver.numExperiments-1) + ", sample " + j + ", output " + this.driver.outputs[out] + " skipped", null);
                                continue;
                            }
                            this.outputConfidences[out] = experiment[out].addSample(sample);
                        }
                        catch (Exception e) {
                            MMINTException.print(IStatus.WARNING, "Experiment " + this.experimentIndex + " out of " + (this.driver.numExperiments-1) + ", sample " + j + ", output " + this.driver.outputs[out] + " not available", e);
                        }
                    }
                    // evaluate confidence intervals
                    boolean allConfident = true;
                    for (int out = 0; out < this.driver.outputs.length; out++) {
                        allConfident = this.outputConfidences[out] && allConfident;
                    }
                    if (allConfident) {
                        break;
                    }
                }

                // save output
                MIDOperatorIOUtils.writePropertiesFile(
                    writeProperties(experiment, this.experimentIndex),
                    this.driver,
                    this.initialModel,
                    EXPERIMENT_SUBDIR + this.experimentIndex,
                    MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX
                );
                writeGnuplotFile(this.driver, this.initialModel, experiment, this.experimentIndex, this.driver.varX);
            }
            catch (Exception e) {
                MMINTException.print(IStatus.WARNING, "Experiment " + this.experimentIndex + " out of " + (this.driver.numExperiments-1) + " failed", e);
            }
        }
    }

    protected class SampleWatchdog implements Runnable {

        private ExperimentDriver driver;
        private int experimentIndex;
        private int statisticsIndex;
        private EList<Model> inputModels;
        private List<Operator> operatorWorkflow;
        private boolean[] outputConfidences;

        public SampleWatchdog(ExperimentDriver driver, int experimentIndex, int statisticsIndex, EList<Model> inputModels, List<Operator> operatorWorkflow, boolean[] outputConfidences) {

            this.driver = driver;
            this.experimentIndex = experimentIndex;
            this.statisticsIndex = statisticsIndex;
            this.inputModels = inputModels;
            this.operatorWorkflow = operatorWorkflow;
            this.outputConfidences = outputConfidences;
        }

        @Override
        public void run() {

            System.err.println("Running experiment " + this.experimentIndex + " out of " + (this.driver.numExperiments-1) + ", sample " + this.statisticsIndex);
            for (int op = 0; op < this.driver.statisticsOperators.length; op++) {
                try {
                    this.inputModels = executeOperator(this.experimentIndex, this.statisticsIndex, op, this.driver.statisticsOperators[op], this.inputModels, this.operatorWorkflow, this.outputConfidences);
                }
                catch (Exception e) {
                    MMINTException.print(IStatus.WARNING, "Experiment " + this.experimentIndex + " out of " + (this.driver.numExperiments-1) + ", sample " + this.statisticsIndex + " failed", e);
                    return;
                }
            }
        }

    }

    // input-output
    private final static @NonNull String IN_MODEL = "initial";
    /** The variables to variate the experiment setup. */
    private static final String PROPERTY_IN_VARIABLES = "variables";
    /** The variable values property suffix. */
    private static final String PROPERTY_IN_VARIABLEVALUES_SUFFIX = ".values";
    private static final String PROPERTY_IN_VARIABLEX_SUFFIX = ".varX";
    /** The initial seed for the pseudorandom generator. */
    private static final String PROPERTY_IN_SEED = "seed";
    /** Number of samples to discard at the beginning of each experiment (warmup phase). */
    private static final String PROPERTY_IN_SKIPWARMUPSAMPLES = "skipWarmupSamples";
    /** Min number of iterations (i.e. samples to generate). */
    private static final String PROPERTY_IN_MINSAMPLES = "minSamples";
    /** Max number of iterations (i.e. samples to generate). */
    private static final String PROPERTY_IN_MAXSAMPLES = "maxSamples";
    /** The distribution type to be used when evaluating the confidence. */
    private static final String PROPERTY_IN_DISTRIBUTIONTYPE = "distributionType";
    /** The requested range of confidence interval (% with respect to average value), after which the experiment can be stopped. */
    private static final String PROPERTY_IN_REQUESTEDCONFIDENCE = "requestedConfidence";
    private static final String PROPERTY_IN_NUMTHREADS = "numThreads";
    private static final int PROPERTY_IN_NUMTHREADS_DEFAULT = 1;
    /** The operators to be launched in the outer experiment setup cycle. */
    private static final String PROPERTY_IN_EXPERIMENTOPERATORS = "experimentOperators";
    private static final String[] PROPERTY_IN_EXPERIMENTOPERATORS_DEFAULT = new String[] {};
    /** The operators to be launched in the inner statistics cycle. */
    private static final String PROPERTY_IN_STATISTICSOPERATORS = "statisticsOperators";
    /** The variable operators property suffix. */
    private static final String PROPERTY_IN_ALLOPERATORS_SUFFIX = ".operator";
    /** The outputs of the experiment. */
    private static final String PROPERTY_IN_OUTPUTS = "outputs";
    private static final String[] PROPERTY_IN_OUTPUTS_DEFAULT = new String[0];
    /** The output default result property suffix. */
    private static final String PROPERTY_IN_OUTPUTDEFAULT_SUFFIX = ".defaultResult";
    /** Min value a sample can take. */
    private static final String PROPERTY_IN_OUTPUTMINSAMPLEVALUE_SUFFIX = ".minSampleValue";
    /** Max value a sample can take, -1 for unlimited. */
    private static final String PROPERTY_IN_OUTPUTMAXSAMPLEVALUE_SUFFIX = ".maxSampleValue";
    private static final String PROPERTY_IN_OUTPUTDOCONFIDENCE_SUFFIX = ".doConfidence";
    /** Max processing time to generate the outputs. */
    private static final String PROPERTY_IN_MAXPROCESSINGTIME = "maxProcessingTime";
    public static final String PROPERTY_OUT_RESULTLOW_SUFFIX = ".resultLow";
    public static final String PROPERTY_OUT_RESULTAVG_SUFFIX = ".resultAvg";
    public static final String PROPERTY_OUT_RESULTUP_SUFFIX = ".resultUp";
    private static final String PROPERTY_OUT_NUMSAMPLES_SUFFIX = ".numSamples";
    public static final String PROPERTY_OUT_VARIABLEINSTANCE_SUFFIX = ".instance";
    private static final String EXPERIMENT_SUBDIR = "experiment";
    private static final String SAMPLE_SUBDIR = "sample";
    private static final String GNUPLOT_SUFFIX = MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX + ".dat";
    private static final String OUTPUT_EXECUTIONTIME = "executionTime";

    // experiment setup parameters
    private String[] vars;
    private String[][] varValues;
    private int varX;
    private int numExperiments;
    private String[][] experimentSetups;
    // experiment randomness parameters
    private long seed;
    private Random[] state;
    private int skipWarmupSamples;
    private int minSamples;
    private int maxSamples;
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
    private double[] outputMins;
    private double[] outputMaxs;
    private boolean[] outputDoConfidences;
    // experiment efficiency
    private int maxProcessingTime;
    private int numThreads;

    private @NonNull String[] getArrayStringProperties(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

        String property = MIDOperatorIOUtils.getStringProperty(properties, propertyName);
        if (property.startsWith("[") && property.endsWith("]")) {
            return property.substring(1, property.length()-1).split("\\],\\[");
        }
        else {
            return MIDOperatorIOUtils.getStringProperties(properties, propertyName);
        }
    }

    @Override
    public void readInputProperties(Properties inputProperties) throws MMINTException {

        // outer cycle parameters: vary experiment setup
        this.vars = MIDOperatorIOUtils.getStringProperties(inputProperties, PROPERTY_IN_VARIABLES);
        this.varValues = new String[this.vars.length][];
        this.numExperiments = 1;
        for (int i = 0; i < this.vars.length; i++) {
            this.varValues[i] = getArrayStringProperties(inputProperties, this.vars[i]+PROPERTY_IN_VARIABLEVALUES_SUFFIX);
            this.numExperiments *= this.varValues[i].length;
            if (MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, this.vars[i]+PROPERTY_IN_VARIABLEX_SUFFIX, false)) {
                this.varX = i;
            }
        }

        // inner cycle parameters: experiment setup is fixed, vary randomness and statistics
        this.seed = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_SEED);
        this.skipWarmupSamples = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_SKIPWARMUPSAMPLES);
        this.minSamples = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MINSAMPLES);
        this.maxSamples = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MAXSAMPLES);
        this.distribution = DistributionType.valueOf(MIDOperatorIOUtils.getStringProperty(inputProperties, PROPERTY_IN_DISTRIBUTIONTYPE));
        this.requestedConfidence = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_REQUESTEDCONFIDENCE);

        // operators
        this.experimentOperators = MIDOperatorIOUtils.getOptionalStringProperties(inputProperties, PROPERTY_IN_EXPERIMENTOPERATORS, PROPERTY_IN_EXPERIMENTOPERATORS_DEFAULT);
        this.statisticsOperators = MIDOperatorIOUtils.getStringProperties(inputProperties, PROPERTY_IN_STATISTICSOPERATORS);
        this.varOperators = new String[this.vars.length][];
        for (int i = 0; i < this.vars.length; i++) {
            this.varOperators[i] = MIDOperatorIOUtils.getStringProperties(inputProperties, this.vars[i]+PROPERTY_IN_ALLOPERATORS_SUFFIX);
        }

        // outputs
        this.outputs = MIDOperatorIOUtils.getOptionalStringProperties(inputProperties, PROPERTY_IN_OUTPUTS, PROPERTY_IN_OUTPUTS_DEFAULT);
        this.outputOperators = new String[this.outputs.length];
        this.outputDefaults = new double[this.outputs.length];
        this.outputMins = new double[this.outputs.length];
        this.outputMaxs = new double[this.outputs.length];
        this.outputDoConfidences = new boolean[this.outputs.length];
        for (int i = 0; i < this.outputs.length; i++) {
            this.outputOperators[i] = MIDOperatorIOUtils.getStringProperty(inputProperties, this.outputs[i]+PROPERTY_IN_ALLOPERATORS_SUFFIX);
            this.outputDefaults[i] = MIDOperatorIOUtils.getDoubleProperty(inputProperties, this.outputs[i]+PROPERTY_IN_OUTPUTDEFAULT_SUFFIX);
            this.outputMins[i] = MIDOperatorIOUtils.getDoubleProperty(inputProperties, this.outputs[i]+PROPERTY_IN_OUTPUTMINSAMPLEVALUE_SUFFIX);
            this.outputMaxs[i] = MIDOperatorIOUtils.getDoubleProperty(inputProperties, this.outputs[i]+PROPERTY_IN_OUTPUTMAXSAMPLEVALUE_SUFFIX);
            this.outputDoConfidences[i] = MIDOperatorIOUtils.getBoolProperty(inputProperties, this.outputs[i]+PROPERTY_IN_OUTPUTDOCONFIDENCE_SUFFIX);
        }

        // efficiency
        this.maxProcessingTime = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MAXPROCESSINGTIME);
        this.numThreads = MIDOperatorIOUtils.getOptionalIntProperty(inputProperties, PROPERTY_IN_NUMTHREADS, PROPERTY_IN_NUMTHREADS_DEFAULT);
    }

    private Properties writeProperties(ExperimentSamples[] experiment, int experimentIndex) {

        Properties properties = new Properties();

        if (experiment != null) { // only with outputs
            for (int out = 0; out < this.outputs.length; out++) {
                properties.setProperty(this.outputs[out]+PROPERTY_OUT_RESULTAVG_SUFFIX, String.valueOf(experiment[out].getAverage()));
                if (this.outputDoConfidences[out]) {
                    properties.setProperty(this.outputs[out]+PROPERTY_OUT_RESULTUP_SUFFIX, String.valueOf(experiment[out].getUpperConfidence()));
                    properties.setProperty(this.outputs[out]+PROPERTY_OUT_RESULTLOW_SUFFIX, String.valueOf(experiment[out].getLowerConfidence()));
                }
                properties.setProperty(this.outputs[out]+PROPERTY_OUT_NUMSAMPLES_SUFFIX, String.valueOf(experiment[out].getNumSamples()));
            }
        }
        for (int i = 0; i < this.vars.length; i++) {
            properties.setProperty(this.vars[i]+PROPERTY_OUT_VARIABLEINSTANCE_SUFFIX, this.experimentSetups[experimentIndex][i]);
        }

        return properties;
    }

    private void writeGnuplotFile(Operator driver, Model initialModel, ExperimentSamples[] experiment, int experimentIndex, int varX) {

        if (experiment == null) { // no outputs
            return;
        }

        // append outputs
        StringBuilder gnuplotBuilder = new StringBuilder(this.experimentSetups[experimentIndex][varX]);
        for (int out = 0; out < this.outputs.length; out++) {
            gnuplotBuilder.append(' ');
            gnuplotBuilder.append(experiment[out].getAverage());
            if (this.outputDoConfidences[out]) {
                gnuplotBuilder.append(' ');
                gnuplotBuilder.append(experiment[out].getUpperConfidence());
                gnuplotBuilder.append(' ');
                gnuplotBuilder.append(experiment[out].getLowerConfidence());
            }
        }

        // write output
        try {
            MIDOperatorIOUtils.writeTextFile(driver, initialModel, EXPERIMENT_SUBDIR + experimentIndex, GNUPLOT_SUFFIX, gnuplotBuilder);
        }
        catch (IOException e) {
            MMINTException.print(IStatus.WARNING, "Experiment " + experimentIndex + " out of " + (this.numExperiments-1) + ", gnuplot output failed", e);
        }
    }

    private void cartesianProduct(String[][] experimentSetups) {

        for (int i = 0; i < this.numExperiments; i++) {
            int k = 1;
            for (int j = 0; j < this.varValues.length; j++) {
                String[] value = this.varValues[j];
                String choice = value[(i/k) % value.length];
                experimentSetups[i][j] = choice;
                k *= value.length;
            }
        }
    }

    private EList<Model> executeOperator(int experimentIndex, int statisticsIndex, int operatorIndex, String operatorUri, EList<Model> inputModels, List<Operator> operatorWorkflow, boolean[] outputConfidences) throws Exception {

        // empty operator list
        if (operatorUri.equals("")) {
            return inputModels;
        }

        // generic operator X<Y>
        //TODO MMINT[GENERICS] Add support for more than one generic
        String genericsUri = null;
        int genericsIndex = operatorUri.indexOf('<');
        if (genericsIndex > 0) {
            genericsUri = operatorUri.substring(genericsIndex+1, operatorUri.length()-1);
            operatorUri = operatorUri.substring(0, genericsIndex);
        }

        // get operator
        Operator operatorType = MIDTypeRegistry.getType(operatorUri);
        if (operatorType == null) {
            throw new MMINTException("Operator uri " + operatorUri + " is not registered");
        }
        if (operatorType.getInputs().size() == 0) { // fix operator with no model input at the beginning of the experiment
            inputModels = new BasicEList<>();
        }

        // write operator input properties
        Properties inputProperties = new Properties();
        for (int i = 0; i < this.varOperators.length; i++) {
            for (int j = 0; j < this.varOperators[i].length; j++) {
                if (this.varOperators[i][j].equals(operatorUri)) {
                    inputProperties.setProperty(this.vars[i], this.experimentSetups[experimentIndex][i]);
                    break;
                }
            }
        }
        for (int out = 0; out < this.outputs.length; out++) {
            if (this.outputDoConfidences[out] && operatorUri.equals(this.outputOperators[out])) {
                if (!outputConfidences[out]) {
                    inputProperties.setProperty(this.outputs[out]+MIDOperatorIOUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX, "true");
                }
                else {
                    inputProperties.setProperty(this.outputs[out]+MIDOperatorIOUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX, "false");
                }
            }
        }
        if (operatorIndex == 0) {
            String nextSubdir;
            if (statisticsIndex < 0) {
                nextSubdir = EXPERIMENT_SUBDIR + experimentIndex;
            }
            else {
                nextSubdir = (this.experimentOperators.length == 0) ?
                    EXPERIMENT_SUBDIR + experimentIndex + MMINT.URI_SEPARATOR + SAMPLE_SUBDIR + statisticsIndex:
                    SAMPLE_SUBDIR + statisticsIndex;
            }
            inputProperties.setProperty(MIDOperatorIOUtils.PROPERTY_IN_SUBDIR, nextSubdir);
        }
        inputProperties.setProperty(MIDOperatorIOUtils.PROPERTY_IN_UPDATEMID, "false");

        // execute, get state and add to workflow
        EList<OperatorInput> inputs = operatorType.checkAllowedInputs(inputModels);
        EList<OperatorGeneric> generics = new BasicEList<>();
        if (genericsUri != null) {
            GenericElement genericType = MIDTypeRegistry.getType(genericsUri);
            if (genericType == null) {
                throw new MMINTException("Generic type uri " + genericsUri + " is not registered");
            }
            OperatorGeneric generic = OperatorFactory.eINSTANCE.createOperatorGeneric();
            generic.setGenericSuperTypeEndpoint(operatorType.getGenerics().get(0));
            generic.setGeneric(genericType);
            generics.add(generic);
        }
        Map<String, MID> outputMIDsByName = new HashMap<>();
        if (operatorType instanceof RandomOperator) { // random state passing
            ((RandomOperator) operatorType).setState(this.state[experimentIndex]);
        }
        if (!operatorWorkflow.isEmpty()) { // operator workflow passing
            operatorType.setPreviousOperator(operatorWorkflow.get(operatorWorkflow.size()-1));
        }
        Operator operator = operatorType.startInstance(inputs, inputProperties, generics, outputMIDsByName, null);
        if (operatorType instanceof RandomOperator) { // random state passing
            this.state[experimentIndex] = ((RandomOperator) operator).getState();
            ((RandomOperator) operatorType).setState(null);
        }
        if (!operatorWorkflow.isEmpty()) { // operator workflow passing
            operatorType.setPreviousOperator(null);
        }
        operatorWorkflow.add(operator);
        EList<Model> outputModels = operator.getOutputModels();

        return outputModels;
    }

    private double getOutput(List<Operator> operatorWorkflow, Model initialModel, int outputIndex, int experimentIndex, int statisticsIndex) throws Exception {

        // get output operator
        Operator operatorType = MIDTypeRegistry.getType(this.outputOperators[outputIndex]);
        if (operatorType == null) {
            throw new MMINTException("Operator uri " + this.outputOperators[outputIndex] + " is not registered");
        }

        if (this.outputs[outputIndex].startsWith(OUTPUT_EXECUTIONTIME)) {
            for (Operator operator : operatorWorkflow) {
                if (operator.getName().equals(operatorType.getName())) {
                    return operator.getExecutionTime();
                }
            }
        }
        String experimentSubdir = EXPERIMENT_SUBDIR + experimentIndex + MMINT.URI_SEPARATOR + SAMPLE_SUBDIR + statisticsIndex;
        Properties resultProperties = MIDOperatorIOUtils.getPropertiesFile(
            operatorType,
            initialModel,
            experimentSubdir,
            MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX
        );
        return MIDOperatorIOUtils.getDoubleProperty(resultProperties, this.outputs[outputIndex]);
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        // prepare experiment setup
        Model initialModel = inputsByName.get(IN_MODEL);
        this.state = new Random[this.numExperiments];
        for (int i = 0; i < this.numExperiments; i++) {
            this.state[i] = new Random(this.seed + i);
        }
        this.experimentSetups = new String[this.numExperiments][this.vars.length];
        cartesianProduct(this.experimentSetups);

        MIDTypeHierarchy.clearCachedRuntimeTypes();
        ExecutorService executor = Executors.newFixedThreadPool(this.numThreads);
        // outer cycle: vary experiment setup
        for (int i = 0; i < this.numExperiments; i++) {
            // run time-bounded chain of experiments
            try {
                executor.submit(new ExperimentWatchdog(this, initialModel, i));
            }
            catch (Exception e) {
                MMINTException.print(IStatus.WARNING, "Experiment " + i + " out of " + (this.numExperiments-1) + " failed", e);
            }
        }
        executor.shutdown();
        executor.awaitTermination(24, TimeUnit.HOURS);
        MIDTypeHierarchy.clearCachedRuntimeTypes();

        return new HashMap<>();
    }

}
