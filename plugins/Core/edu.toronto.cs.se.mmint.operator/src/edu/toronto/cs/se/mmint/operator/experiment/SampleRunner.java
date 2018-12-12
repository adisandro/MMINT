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

import java.util.HashMap;
import java.util.Properties;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;

public class SampleRunner implements Runnable {

  private final static @NonNull String SAMPLE_SUBDIR = "sample";

  private ExperimentRunner expRunner;
  private int sampleIndex;

  public SampleRunner(@NonNull ExperimentRunner experimentRunner, int sampleIndex) {
    this.expRunner = experimentRunner;
    this.sampleIndex = sampleIndex;
  }

  @Override
  public void run() {
    try {
      // create sample folder
      var folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
        MMINT.getActiveInstanceMIDFile().getParent().getFullPath()
          .append(ExperimentRunner.EXPERIMENT_SUBDIR + this.expRunner.expIndex)
          .append(SAMPLE_SUBDIR + this.sampleIndex));
      if (!folder.exists(null)) {
        folder.create(true, true, null);
      }
      // run samples workflow
      var inputs = this.expRunner.exp.input.samplesWorkflow.checkAllowedInputs(ECollections.asEList(this.expRunner.exp.input.models));
      var samples = this.expRunner.exp.input.samplesWorkflow.startInstance(inputs, new Properties(), ECollections.emptyEList(),
                                                                           new HashMap<>(), null);
    }
    catch (Exception e) {

    }
  }

}
