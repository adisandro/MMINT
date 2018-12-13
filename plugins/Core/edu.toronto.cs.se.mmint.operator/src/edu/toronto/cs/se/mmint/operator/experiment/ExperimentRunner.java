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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

class ExperimentRunner implements Runnable {

  final static @NonNull String EXPERIMENT_SUBDIR = "experiment";

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
      for (var i = 0; i < this.exp.maxSamples + this.exp.skipWarmupSamples; i++) {
        // run one sample
        var executor = Executors.newSingleThreadExecutor();
        var timedOut = false;
        try {
          executor.submit(new SampleRunner(this, i)).get(this.exp.maxProcessingTime, TimeUnit.SECONDS);
          executor.shutdown();
        }
        catch (Exception e) {
          MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1}, sample {2} timed out",
                                                                     this.expIndex, this.exp.numExperiments-1, i), e);
          timedOut = true;
          executor.shutdownNow();
        }
        // skip warmup
        if (i < this.exp.skipWarmupSamples) {
          MMINTException.print(IStatus.WARNING,
                               MessageFormat.format("Experiment {0} out of {1}, sample {2} used to warm up",
                                                    this.expIndex, this.exp.numExperiments-1, i), null);
          continue;
        }
        // update sample statistics
        var allConfident = true;
        for (var outputEntry : this.exp.outputs.entrySet()) {
          var output = outputEntry.getKey();
          var outputSpecs = outputEntry.getValue();
          var outputSamples = this.samples.get(output);
          var sample = (timedOut) ? outputSpecs.timeoutValue : 666.666;//TODO
          if (sample == Double.MAX_VALUE) {
            MMINTException.print(IStatus.WARNING,
                                 MessageFormat.format("Experiment {0} out of {1}, sample {2} output {3} skipped",
                                                      this.expIndex, this.exp.numExperiments-1, i, output), null);
            allConfident = outputSamples.isConfident() && allConfident;
            continue;
          }
          outputSamples.addSample(sample);
          allConfident = outputSamples.isConfident() && allConfident;
        }
        if (allConfident) {
          break;
        }
      }

      // save outputs
      var properties = new Properties();//TODO
      var propertiesPath = FileUtils.prependWorkspacePath(
                             this.path.append(this.exp.getName() + MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX)
                                      .toOSString());
      properties.store(new FileOutputStream(propertiesPath), null);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1} failed", this.expIndex,
                                                                 this.exp.numExperiments-1), e);
    }
  }
}
