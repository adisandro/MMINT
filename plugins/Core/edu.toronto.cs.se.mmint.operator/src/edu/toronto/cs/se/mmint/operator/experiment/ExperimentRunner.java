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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class ExperimentRunner implements Runnable {

  final static @NonNull String EXPERIMENT_SUBDIR = "experiment";
  private final static @NonNull String PROP_OUT_LOWER_SUFFIX = ".lower";
  public final static @NonNull String PROP_OUT_AVG_SUFFIX = ".avg";
  private final static @NonNull String PROP_OUT_UPPER_SUFFIX = ".upper";
  private final static @NonNull String PROP_OUT_NUMSAMPLES_SUFFIX = ".numSamples";

  Experiment exp;
  Map<String, String> expVariables;
  int expIndex;
  IPath path;
  Random state;
  Map<String, ExperimentSamples> samples;

  ExperimentRunner(@NonNull Experiment experiment, @NonNull Map<String, String> experimentVariables,
                   int experimentIndex) {
    this.exp = experiment;
    this.expVariables = experimentVariables;
    this.expIndex = experimentIndex;
    this.path = this.exp.path.append(EXPERIMENT_SUBDIR + this.expIndex);
    this.state = new Random(this.exp.seed + this.expIndex);
    this.samples = new HashMap<>(this.exp.outputs.size());
    for (var outputEntry : this.exp.outputs.entrySet()) {
      var output = outputEntry.getKey();
      var outputSpecs = outputEntry.getValue();
      this.samples.put(output, new ExperimentSamples(this.exp.minSamples, this.exp.maxSamples, this.exp.distribution,
                                                     outputSpecs.minValue, outputSpecs.maxValue,
                                                     this.exp.targetConfidence, outputSpecs.doConfidence));
    }
  }

  @Override
  public void run() {
    try {
      // create experiment folder
      var folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(this.path);
      if (!folder.exists(null)) {
        folder.create(true, true, null);
      }
      this.exp.input.setupWorkflow.setWorkingPath(this.path.toOSString());

      // write operator properties
      var operatorProps = new HashMap<String, Properties>();
      for (var expVariable : this.expVariables.entrySet()) {
        var variable = expVariable.getKey();
        var value = expVariable.getValue();
        var variableSpecs = this.exp.variables.get(variable);
        var props = operatorProps.merge(variableSpecs.operatorName, new Properties(), (oldP, newP) -> oldP);
        props.setProperty(variable, value);
      }
      for (var propsEntry : operatorProps.entrySet()) {
        var operatorName = propsEntry.getKey();
        var props = propsEntry.getValue();
        var propsPath = FileUtils.prependWorkspacePath(
                          this.path.append(operatorName + MIDOperatorIOUtils.INPUT_PROPERTIES_SUFFIX +
                                           MIDOperatorIOUtils.PROPERTIES_SUFFIX)
                        .toOSString());
        props.store(new FileOutputStream(propsPath), null);
      }

      // run setup workflow
      var inputs = this.exp.input.setupWorkflow.checkAllowedInputs(ECollections.asEList(this.exp.input.models));
      var outputMIDsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(this.exp.input.setupWorkflow, null);
      this.exp.input.setupWorkflow.getNestedWorkflowMID().getOperators().stream() // init seeded random state
        .map(o -> o.getMetatype())
        .filter(o -> o instanceof RandomOperator)
        .findFirst()
        .ifPresent(o -> ((RandomOperator) o).setState(this.state));
      var setup = this.exp.input.setupWorkflow.startInstance(inputs, null, ECollections.emptyEList(), outputMIDsByName,
                                                             null);
      var sampleInputs = setup.getOutputModels();

      // run samples
      for (var s = 0; s < this.exp.maxSamples + this.exp.skipWarmupSamples; s++) {
        // run one sample with timeout
        var executor = Executors.newSingleThreadExecutor();
        var sampleRunner = new SampleRunner(this, operatorProps, sampleInputs, s);
        var timedOut = false;
        try {
          executor.submit(sampleRunner).get(this.exp.maxProcessingTime, TimeUnit.SECONDS);
          executor.shutdown();
        }
        catch (Exception e) {
          MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1}, sample {2} timed out",
                                                                     this.expIndex+1, this.exp.numExperiments, s), e);
          timedOut = true;
          executor.shutdownNow();
        }
        // skip warmup
        if (s < this.exp.skipWarmupSamples) {
          MMINTException.print(IStatus.WARNING,
                               MessageFormat.format("Experiment {0} out of {1}, sample {2} used to warm up",
                                                    this.expIndex+1, this.exp.numExperiments, s), null);
          continue;
        }
        // update sample statistics
        var allConfident = true;
        for (var outputEntry : this.exp.outputs.entrySet()) {
          var output = outputEntry.getKey();
          var outputSpecs = outputEntry.getValue();
          var outputSamples = this.samples.get(output);
          double sample;
          sample = outputSpecs.timeoutValue;
          if (!timedOut) {
            if (output.equals(SampleRunner.OUTPUT_SAMPLESTIME)) {
              sample = sampleRunner.sample.getExecutionTime();
            }
            else {
              var samplePropsPath = FileUtils.prependWorkspacePath(
                                      sampleRunner.path.append(outputSpecs.operatorName +
                                                               MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX +
                                                               MIDOperatorIOUtils.PROPERTIES_SUFFIX)
                                      .toOSString());
              var sampleProps = new Properties();
              sampleProps.load(new FileInputStream(samplePropsPath));
              sample = MIDOperatorIOUtils.getDoubleProperty(sampleProps, output);
            }
          }
          if (sample == Double.MAX_VALUE) {
            MMINTException.print(IStatus.WARNING,
                                 MessageFormat.format("Experiment {0} out of {1}, sample {2} output {3} skipped",
                                                      this.expIndex+1, this.exp.numExperiments, s, output), null);
            allConfident = outputSamples.isWithinTargetConfidence() && allConfident;
            continue;
          }
          outputSamples.addSample(sample);
          allConfident = outputSamples.isWithinTargetConfidence() && allConfident;
        }
        if (allConfident) {
          break;
        }
      }

      // save outputs and variables
      var expProps = new Properties();
      for (var sampleEntry : this.samples.entrySet()) {
        var output = sampleEntry.getKey();
        var outputSamples = sampleEntry.getValue();
        expProps.setProperty(output + PROP_OUT_AVG_SUFFIX, String.valueOf(outputSamples.getAverage()));
        if (outputSamples.doConfidence()) {
          expProps.setProperty(output + PROP_OUT_UPPER_SUFFIX, String.valueOf(outputSamples.getUpperConfidence()));
          expProps.setProperty(output + PROP_OUT_LOWER_SUFFIX, String.valueOf(outputSamples.getLowerConfidence()));
        }
        expProps.setProperty(output + PROP_OUT_NUMSAMPLES_SUFFIX, String.valueOf(outputSamples.getNumSamples()));
      }
      for (var expVariable : this.expVariables.entrySet()) {
        var variable = expVariable.getKey();
        var value = expVariable.getValue();
        expProps.setProperty(variable, value);
      }
      var expPropsPath = FileUtils.prependWorkspacePath(
                           this.path.append(this.exp.getName() + MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX +
                                            MIDOperatorIOUtils.PROPERTIES_SUFFIX)
                           .toOSString());
      expProps.store(new FileOutputStream(expPropsPath), null);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1} failed", this.expIndex+1,
                                                                 this.exp.numExperiments), e);
      //TODO Write output properties on failure too?
    }
  }
}
