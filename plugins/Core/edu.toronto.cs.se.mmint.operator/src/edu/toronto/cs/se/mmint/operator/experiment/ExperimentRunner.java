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
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.operator.experiment.Experiment.ExperimentOutput;

class ExperimentRunner implements Runnable {

  final static @NonNull String EXPERIMENT_SUBDIR = "experiment";

  Experiment exp;
  int expIndex;
  private Map<String, ExperimentSamples> samples;

  ExperimentRunner(@NonNull Experiment experiment, int experimentIndex) {
    this.exp = experiment;
    this.expIndex = experimentIndex;
    this.samples = new HashMap<>(this.exp.outputs.size());
    for (var outputEntry : this.exp.outputs.entrySet()) {
      ExperimentOutput output = outputEntry.getValue();
      this.samples.put(outputEntry.getKey(),
                       new ExperimentSamples(this.exp.minSamples, this.exp.maxSamples, this.exp.distribution,
                                             output.minValue, output.maxValue, this.exp.targetConfidence,
                                             output.doConfidence));
    }
  }

  @Override
  public void run() {
    try {
      // create experiment folder
      var folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
        MMINT.getActiveInstanceMIDFile().getParent().getFullPath().append(EXPERIMENT_SUBDIR + this.expIndex));
      if (!folder.exists(null)) {
        folder.create(true, true, null);
      }
      // run setup workflow
      var inputs = this.exp.input.setupWorkflow.checkAllowedInputs(ECollections.asEList(this.exp.input.models));
      var setup = this.exp.input.setupWorkflow.startInstance(inputs, new Properties(), ECollections.emptyEList(),
                                                             new HashMap<>(), null);
      // run samples
      for (var i = 0; i < this.exp.maxSamples + this.exp.skipWarmupSamples; i++) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
          executor.submit(new SampleRunner(this, i)).get(this.exp.maxProcessingTime, TimeUnit.SECONDS);
          executor.shutdown();
        }
        catch (Exception e) {
          executor.shutdownNow();
        }
      }
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1} failed", this.expIndex,
                                                                 this.exp.numExperiments-1), e);
    }
  }
}
