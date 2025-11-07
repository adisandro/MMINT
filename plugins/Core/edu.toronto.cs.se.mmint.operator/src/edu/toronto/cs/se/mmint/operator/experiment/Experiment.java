/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Rick Salay.
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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.operator.experiment.ExperimentSamples.DistributionType;

public class Experiment extends OperatorImpl {

  Input input;
  private Output output;

  static class Input {
    private final static @NonNull String IN_MODELS = "inputs";
    private final static @NonNull String GENERIC_OPERATORTYPE1 = "SETUP";
    private final static @NonNull String GENERIC_OPERATORTYPE2 = "SAMPLES";
    List<Model> models;
    WorkflowOperator setupWorkflow;
    WorkflowOperator samplesWorkflow;

    public Input(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, GenericElement> genericsByName) {
      this.models = MIDOperatorIOUtils.getVarargs(inputsByName, Input.IN_MODELS);
      this.setupWorkflow = (WorkflowOperator) genericsByName.get(Input.GENERIC_OPERATORTYPE1);
      this.samplesWorkflow = (WorkflowOperator) genericsByName.get(Input.GENERIC_OPERATORTYPE2);
    }
  }

  private static class Output {
    public Output(@NonNull Map<String, MID> outputMIDsByName) {}

    public @NonNull Map<String, Model> packed() {
      return new HashMap<>();
    }
  }

  /** The variables (degrees of freedom) of the experiment. */
  private final static @NonNull String PROP_IN_VARIABLES = "variables";
  private final static @NonNull String PROP_IN_VARIABLEOPERATORNAME_SUFFIX = ".operatorName";
  private final static @NonNull String PROP_IN_VARIABLEVALUES_SUFFIX = ".values";
  private final static @NonNull String PROP_IN_VARIABLEX_SUFFIX = ".varX";
  static class ExperimentVariable {
    List<String> operatorNames; // the operator that needs the variable as input (possibly with different names for multiple invocations)
    List<String> values; // the list of values the variable has
    public ExperimentVariable(@NonNull List<String> operatorNames, @NonNull List<String> values) {
      this.operatorNames = operatorNames;
      this.values = values;
    }
  }
  Map<String, ExperimentVariable> variables;
  int numExperiments;
  private String varX; // The variable that represent the X axis of the gnuplot graph.
  /** The statistics parameters. */
  private final static @NonNull String PROP_IN_SEED = "seed";
  private final static @NonNull String PROP_IN_SKIPWARMUPSAMPLES = "skipWarmupSamples";
  private final static @NonNull String PROP_IN_MINSAMPLES = "minSamples";
  private final static @NonNull String PROP_IN_MAXSAMPLES = "maxSamples";
  private final static @NonNull String PROP_IN_DISTRIBUTION = "distribution";
  private final static @NonNull String PROP_IN_TARGETCONFIDENCE = "targetConfidence";
  long seed; // the seed to initialize the pseudorandom generator
  int skipWarmupSamples; // how many samples to discard as warmup phase
  int minSamples; // min number of samples to collect
  int maxSamples; // max number of samples to collect
  DistributionType distribution; // the type of distribution to calculate confidence intervals
  double targetConfidence; // the target confidence (% with respect to average value) to stop the experiment
  /** The processing parameters. */
  private final static @NonNull String PROP_IN_MAXPROCESSINGTIME = "maxProcessingTime";
  private final static @NonNull String PROP_IN_NUMTHREADS = "numThreads";
  private final static int PROP_IN_NUMTHREADS_DEFAULT = 1;
  IPath path;
  int maxProcessingTime; // max time before timing out a sample
  private int numThreads; // number of samples to process in parallel
  /** The outputs */
  private final static @NonNull String PROP_IN_OUTPUTS = "outputs";
  private final static @NonNull Set<String> PROP_IN_OUTPUTS_DEFAULT = Set.of();
  private final static @NonNull String PROP_IN_OUTPUTOPERATORNAME_SUFFIX = ".operatorName";
  private final static @NonNull String PROP_IN_OUTPUTTIMEOUTVALUE_SUFFIX = ".timeoutValue";
  private final static @NonNull String PROP_IN_OUTPUTMINVALUE_SUFFIX = ".minValue";
  private final static @NonNull String PROP_IN_OUTPUTMAXVALUE_SUFFIX = ".maxValue";
  private final static @NonNull String PROP_IN_OUTPUTDOCONFIDENCE_SUFFIX = ".doConfidence";
  static class ExperimentOutput {
    String operatorName; // the operator that generates the output
    double timeoutValue; // sample value in case of timeout, -1 to skip it
    double minValue; // min sample value that has a meaning
    double maxValue; // max sample value that has a meaning, -1 for no limit
    boolean doConfidence; // whether to calculate the confidence interval or not
    public ExperimentOutput(@NonNull String operatorName, double timeoutValue, double minValue, double maxValue,
                            boolean doConfidence) {
      this.operatorName = operatorName;
      this.timeoutValue = timeoutValue;
      this.minValue = minValue;
      this.maxValue = maxValue;
      this.doConfidence = doConfidence;
    }
  }
  Map<String, ExperimentOutput> outputs;

  @Override
  public void init(Properties inProps, Map<String, Model> inputsByName) throws MMINTException {
    // variables of the experiment
    this.numExperiments = 1;
    this.variables = new HashMap<>();
    for (var variable : MIDOperatorIOUtils.getStringPropSet(inProps, Experiment.PROP_IN_VARIABLES, Optional.empty())) {
      var values = MIDOperatorIOUtils.getStringPropList(inProps, variable + Experiment.PROP_IN_VARIABLEVALUES_SUFFIX, Optional.empty());
      this.variables.put(variable, new ExperimentVariable(
        MIDOperatorIOUtils.getStringPropList(inProps, variable + Experiment.PROP_IN_VARIABLEOPERATORNAME_SUFFIX, Optional.empty()),
        values
      ));
      if (MIDOperatorIOUtils.getBoolProp(inProps, variable + Experiment.PROP_IN_VARIABLEX_SUFFIX, Optional.of(false))) {
        this.varX = variable;
      }
      this.numExperiments *= values.size();
    }
    // statistics
    this.seed = MIDOperatorIOUtils.getIntProp(inProps, Experiment.PROP_IN_SEED, Optional.empty());
    this.skipWarmupSamples = MIDOperatorIOUtils.getIntProp(inProps, Experiment.PROP_IN_SKIPWARMUPSAMPLES, Optional.empty());
    this.minSamples = MIDOperatorIOUtils.getIntProp(inProps, Experiment.PROP_IN_MINSAMPLES, Optional.empty());
    this.maxSamples = MIDOperatorIOUtils.getIntProp(inProps, Experiment.PROP_IN_MAXSAMPLES, Optional.empty());
    this.distribution = MIDOperatorIOUtils.getEnumProp(inProps, Experiment.PROP_IN_DISTRIBUTION, Optional.empty(), DistributionType.class);
    this.targetConfidence = MIDOperatorIOUtils.getDoubleProp(inProps, Experiment.PROP_IN_TARGETCONFIDENCE, Optional.empty());
    // processing
    this.path = MMINT.getActiveInstanceMIDFile().getParent().getFullPath();
    this.maxProcessingTime = MIDOperatorIOUtils.getIntProp(inProps, Experiment.PROP_IN_MAXPROCESSINGTIME, Optional.empty());
    this.numThreads = MIDOperatorIOUtils.getIntProp(inProps, Experiment.PROP_IN_NUMTHREADS,
                                                    Optional.of(Experiment.PROP_IN_NUMTHREADS_DEFAULT));
    // outputs
    this.outputs = new HashMap<>();
    for (var output : MIDOperatorIOUtils.getStringPropSet(inProps, Experiment.PROP_IN_OUTPUTS,
                                                          Optional.of(Experiment.PROP_IN_OUTPUTS_DEFAULT))) {
      // there can be multiple invocations of the same operator, with different names but same output specs
      var operatorNames = MIDOperatorIOUtils.getStringPropList(inProps, output + Experiment.PROP_IN_OUTPUTOPERATORNAME_SUFFIX, Optional.empty());
      var timeoutValue = MIDOperatorIOUtils.getDoubleProp(inProps, output + Experiment.PROP_IN_OUTPUTTIMEOUTVALUE_SUFFIX, Optional.empty());
      var minValue = MIDOperatorIOUtils.getDoubleProp(inProps, output + Experiment.PROP_IN_OUTPUTMINVALUE_SUFFIX, Optional.empty());
      var maxValue = MIDOperatorIOUtils.getDoubleProp(inProps, output + Experiment.PROP_IN_OUTPUTMAXVALUE_SUFFIX, Optional.empty());
      var doConfidence = MIDOperatorIOUtils.getBoolProp(inProps, output + Experiment.PROP_IN_OUTPUTDOCONFIDENCE_SUFFIX, Optional.empty());
      for (var operatorName : operatorNames) {
        this.outputs.put(operatorName + "." + output,
                         new ExperimentOutput(operatorName, timeoutValue, minValue, maxValue, doConfidence));
      }
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
       * - better mechanism for fetching execution times of operators
       */
    init(inputsByName, genericsByName, outputMIDsByName);
    MIDTypeHierarchy.clearCachedRuntimeTypes();
    var executor = Executors.newFixedThreadPool(this.numThreads);
    for (var i = 0; i < this.numExperiments; i++) {
      var j = 1;
      var expVariables = new HashMap<String, String>();
      // cartesian product
      for (var variableEntry : this.variables.entrySet()) {
        var variable = variableEntry.getKey();
        var variableSpecs = variableEntry.getValue();
        var value = variableSpecs.values.get((i / j) % variableSpecs.values.size());
        expVariables.put(variable, value);
        j *= variableSpecs.values.size();
      }
      try {
        executor.submit(new ExperimentRunner(this, expVariables, i));
      }
      catch (Exception e) {
        MMINTException.print(IStatus.INFO,
                             MessageFormat.format("Experiment {0} out of {1} failed", i+1, this.numExperiments), e);
      }
    }
    executor.shutdown();
    executor.awaitTermination(24, TimeUnit.HOURS);
    MIDTypeHierarchy.clearCachedRuntimeTypes();

    return this.output.packed();
  }

}
