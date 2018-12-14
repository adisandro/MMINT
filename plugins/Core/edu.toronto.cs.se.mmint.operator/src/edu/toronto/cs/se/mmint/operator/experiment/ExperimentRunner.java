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
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

class ExperimentRunner implements Runnable {

  final static @NonNull String EXPERIMENT_SUBDIR = "experiment";
  private final static @NonNull String PROPERTY_OUT_LOWER_SUFFIX = ".lower";
  private final static @NonNull String PROPERTY_OUT_AVG_SUFFIX = ".avg";
  private final static @NonNull String PROPERTY_OUT_UPPER_SUFFIX = ".upper";
  private final static @NonNull String PROPERTY_OUT_NUMSAMPLES_SUFFIX = ".numSamples";

  Experiment exp;
  int expIndex;
  IPath path;
  private Map<String, ExperimentSamples> samples;

  ExperimentRunner(@NonNull Experiment experiment, int experimentIndex) {
    this.exp = experiment;
    this.expIndex = experimentIndex;
    this.path = this.exp.path.append(EXPERIMENT_SUBDIR + this.expIndex);
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

      // run setup workflow
      var inputs = this.exp.input.setupWorkflow.checkAllowedInputs(ECollections.asEList(this.exp.input.models));
      var setup = this.exp.input.setupWorkflow.startInstance(inputs, new Properties(), ECollections.emptyEList(),
                                                             new HashMap<>(), null);
      // run samples
      for (var s = 0; s < this.exp.maxSamples + this.exp.skipWarmupSamples; s++) {
        // run one sample with timeout
        var executor = Executors.newSingleThreadExecutor();
        var sampleRunner = new SampleRunner(this, s);
        var timedOut = false;
        try {
          executor.submit(sampleRunner).get(this.exp.maxProcessingTime, TimeUnit.SECONDS);
          executor.shutdown();
        }
        catch (Exception e) {
          MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1}, sample {2} timed out",
                                                                     this.expIndex, this.exp.numExperiments-1, s), e);
          timedOut = true;
          executor.shutdownNow();
        }
        // skip warmup
        if (s < this.exp.skipWarmupSamples) {
          MMINTException.print(IStatus.WARNING,
                               MessageFormat.format("Experiment {0} out of {1}, sample {2} used to warm up",
                                                    this.expIndex, this.exp.numExperiments-1, s), null);
          continue;
        }
        // update sample statistics
        var allConfident = true;
        for (var outputEntry : this.exp.outputs.entrySet()) {
          var output = outputEntry.getKey();
          var outputSpecs = outputEntry.getValue();
          var outputSamples = this.samples.get(output);
          double sample;
          if (timedOut) {
            sample = outputSpecs.timeoutValue;
          }
          else {
            Operator operatorType = MIDTypeRegistry.getType(outputSpecs.operatorUri);
            var samplePropertiesPath = FileUtils.prependWorkspacePath(
                                         sampleRunner.path.append(operatorType.getName() +
                                                                  MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX +
                                                                  MIDOperatorIOUtils.PROPERTIES_SUFFIX)
                                                          .toOSString());
            var sampleProperties = new Properties();
            sampleProperties.load(new FileInputStream(samplePropertiesPath));
            sample = MIDOperatorIOUtils.getDoubleProperty(sampleProperties, output);
          }
          if (sample == Double.MAX_VALUE) {
            MMINTException.print(IStatus.WARNING,
                                 MessageFormat.format("Experiment {0} out of {1}, sample {2} output {3} skipped",
                                                      this.expIndex, this.exp.numExperiments-1, s, output), null);
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

      // save outputs
      var expProperties = new Properties();
      for (var sampleEntry : this.samples.entrySet()) {
        var output = sampleEntry.getKey();
        var outputSamples = sampleEntry.getValue();
        expProperties.setProperty(output + PROPERTY_OUT_AVG_SUFFIX, String.valueOf(outputSamples.getAverage()));
        if (outputSamples.doConfidence()) {
          expProperties.setProperty(output + PROPERTY_OUT_UPPER_SUFFIX,
                                 String.valueOf(outputSamples.getUpperConfidence()));
          expProperties.setProperty(output + PROPERTY_OUT_LOWER_SUFFIX,
                                 String.valueOf(outputSamples.getLowerConfidence()));
        }
        expProperties.setProperty(output + PROPERTY_OUT_NUMSAMPLES_SUFFIX,
                                  String.valueOf(outputSamples.getNumSamples()));
      }
      var expPropertiesPath = FileUtils.prependWorkspacePath(
                                this.path.append(this.exp.getName() + MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX +
                                                 MIDOperatorIOUtils.PROPERTIES_SUFFIX)
                                         .toOSString());
      expProperties.store(new FileOutputStream(expPropertiesPath), null);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1} failed", this.expIndex,
                                                                 this.exp.numExperiments-1), e);
    }
  }
}
