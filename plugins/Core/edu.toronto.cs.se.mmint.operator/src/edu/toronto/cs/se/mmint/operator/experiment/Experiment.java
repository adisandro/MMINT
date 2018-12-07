/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.experiment;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.operator.experiment.ExperimentSamples.DistributionType;

public class Experiment extends OperatorImpl {

  private Input input;
  private Output output;

  private static class Input {
    private final static @NonNull String IN_MODELS = "inputs";
    private final static @NonNull String GENERIC_OPERATORTYPE1 = "SETUP";
    private final static @NonNull String GENERIC_OPERATORTYPE2 = "SAMPLES";
    private List<Model> inputs;
    private WorkflowOperator setupWorkflow;
    private WorkflowOperator samplesWorkflow;

    public Input(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, GenericElement> genericsByName) {
      this.inputs = MIDOperatorIOUtils.getVarargs(inputsByName, IN_MODELS);
      this.setupWorkflow = (WorkflowOperator) genericsByName.get(GENERIC_OPERATORTYPE1);
      this.samplesWorkflow = (WorkflowOperator) genericsByName.get(GENERIC_OPERATORTYPE2);
    }
  }

  private static class Output {
    public Output(@NonNull Map<String, MID> outputMIDsByName) {}

    public @NonNull Map<String, Model> packed() {
      return new HashMap<>();
    }
  }

  /** The variables (degrees of freedom) of the experiment. */
  private final static @NonNull String PROPERTY_IN_VARIABLES = "variables";
  private final static @NonNull String PROPERTY_IN_VARIABLEVALUES_SUFFIX = ".values";
  private final static @NonNull String PROPERTY_IN_VARIABLEX_SUFFIX = ".varX";
  int numExperiments;
  private Map<String, List<String>> variables; // variables and their values
  private String varX; // The variable that represent the X axis of the gnuplot graph.
  /** The statistics parameters. */
  private final static @NonNull String PROPERTY_IN_SEED = "seed";
  private final static @NonNull String PROPERTY_IN_SKIPWARMUPSAMPLES = "skipWarmupSamples";
  private final static @NonNull String PROPERTY_IN_MINSAMPLES = "minSamples";
  private final static @NonNull String PROPERTY_IN_MAXSAMPLES = "maxSamples";
  private final static @NonNull String PROPERTY_IN_DISTRIBUTIONTYPE = "distributionType";
  private final static @NonNull String PROPERTY_IN_TARGETCONFIDENCE = "targetConfidence";
  private long seed; // the seed to initialize the pseudorandom generator
  private int skipWarmupSamples; // how many samples to discard as warmup phase, -1 for none
  private int minSamples; // min number of samples to collect
  private int maxSamples; // max number of samples to collect
  private DistributionType distribution; // the type of distribution to calculate confidence intervals
  private double targetConfidence; // the target confidence (% with respect to average value) to stop the experiment
  /** The processing parameters. */
  private final static @NonNull String PROPERTY_IN_MAXPROCESSINGTIME = "maxProcessingTime";
  private final static @NonNull String PROPERTY_IN_NUMTHREADS = "numThreads";
  private final static @NonNull int PROPERTY_IN_NUMTHREADS_DEFAULT = 1;
  private int maxProcessingTime; // max time before timing out a sample
  private int numThreads; // number of samples to process in parallel
  /** The outputs */
  private final static @NonNull String PROPERTY_IN_OUTPUTS = "outputs";
  private final static @NonNull Set<String> PROPERTY_IN_OUTPUTS_DEFAULT = new HashSet<>();
  private final static @NonNull String PROPERTY_IN_OUTPUTOPERATORURI_SUFFIX = ".operatorUri";
  private final static @NonNull String PROPERTY_IN_OUTPUTTIMEOUTVALUE_SUFFIX = ".timeoutValue";
  private final static @NonNull String PROPERTY_IN_OUTPUTMINVALUE_SUFFIX = ".minValue";
  private final static @NonNull String PROPERTY_IN_OUTPUTMAXVALUE_SUFFIX = ".maxValue";
  private final static @NonNull String PROPERTY_IN_OUTPUTDOCONFIDENCE_SUFFIX = ".doConfidence";
  private static class ExperimentOutput {
    private String operatorUri;
    private double timeoutValue;
    private double minValue;
    private double maxValue;
    private boolean doConfidence;
    public ExperimentOutput(@NonNull String operatorUri, double timeoutValue, double minValue, double maxValue,
                            boolean doConfidence) {
      this.operatorUri = operatorUri; // the operator that generates the output
      this.timeoutValue = timeoutValue; // sample value in case of timeout, -1 to skip it
      this.minValue = minValue; // min sample value that has a meaning
      this.maxValue = maxValue; // max sample value that has a meaning, -1 for no limit
      this.doConfidence = doConfidence; // whether to calculate the confidence interval or not
    }
  }
  private Map<String, ExperimentOutput> outputs;

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    // variables of the experiment
    this.numExperiments = 1;
    this.variables = new HashMap<>();
    for (var variable : MIDOperatorIOUtils.getStringPropertySet(inputProperties, PROPERTY_IN_VARIABLES)) {
      var values = MIDOperatorIOUtils.getStringPropertyList(inputProperties,
                                                            variable + PROPERTY_IN_VARIABLEVALUES_SUFFIX);
      this.variables.put(variable, values);
      this.numExperiments *= values.size();
      if (MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, variable + PROPERTY_IN_VARIABLEX_SUFFIX, false)) {
        this.varX = variable;
      }
    }
    // statistics
    this.seed = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_SEED);
    this.skipWarmupSamples = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_SKIPWARMUPSAMPLES);
    this.minSamples = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MINSAMPLES);
    this.maxSamples = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MAXSAMPLES);
    this.distribution = DistributionType.valueOf(MIDOperatorIOUtils.getStringProperty(inputProperties,
                                                                                      PROPERTY_IN_DISTRIBUTIONTYPE));
    this.targetConfidence = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_TARGETCONFIDENCE);
    // processing
    this.maxProcessingTime = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MAXPROCESSINGTIME);
    this.numThreads = MIDOperatorIOUtils.getOptionalIntProperty(inputProperties, PROPERTY_IN_NUMTHREADS,
                                                                PROPERTY_IN_NUMTHREADS_DEFAULT);
    // outputs
    for (var output : MIDOperatorIOUtils.getOptionalStringPropertySet(inputProperties, PROPERTY_IN_OUTPUTS,
                                                                      PROPERTY_IN_OUTPUTS_DEFAULT)) {
      this.outputs.put(output, new ExperimentOutput(
        MIDOperatorIOUtils.getStringProperty(inputProperties, output + PROPERTY_IN_OUTPUTOPERATORURI_SUFFIX),
        MIDOperatorIOUtils.getDoubleProperty(inputProperties, output + PROPERTY_IN_OUTPUTTIMEOUTVALUE_SUFFIX),
        MIDOperatorIOUtils.getDoubleProperty(inputProperties, output + PROPERTY_IN_OUTPUTMINVALUE_SUFFIX),
        MIDOperatorIOUtils.getDoubleProperty(inputProperties, output + PROPERTY_IN_OUTPUTMAXVALUE_SUFFIX),
        MIDOperatorIOUtils.getBoolProperty(inputProperties, output + PROPERTY_IN_OUTPUTDOCONFIDENCE_SUFFIX)
      ));
    }
  }

  private void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, GenericElement> genericsByName,
                    @NonNull Map<String, MID> outputMIDsByName) throws Exception {
    this.input = new Input(inputsByName, genericsByName);
    this.output = new Output(outputMIDsByName);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
      /* TODO
       * - write all variables as input properties to all operators, in advance
       * - experimentSetups?
       */
    init(inputsByName, genericsByName, outputMIDsByName);
    MIDTypeHierarchy.clearCachedRuntimeTypes();
    ExecutorService executor = Executors.newFixedThreadPool(this.numThreads);
    for (int i = 0; i < this.numExperiments; i++) {
        try {
            executor.submit(new ExperimentRunner(this, i));
        }
        catch (Exception e) {
            MMINTException.print(IStatus.WARNING,
                                 MessageFormat.format("Experiment {0} out of {1} failed", i, this.numExperiments-1), e);
        }
    }
    executor.shutdown();
    executor.awaitTermination(24, TimeUnit.HOURS);
    MIDTypeHierarchy.clearCachedRuntimeTypes();

    return this.output.packed();
  }

}
