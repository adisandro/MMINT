/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Rick Salay.
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
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class SampleRunner implements Runnable {

  final static @NonNull String OUTPUT_SAMPLESTIME = "samplesTime";
  private final static @NonNull String SAMPLE_SUBDIR = "sample";

  private ExperimentRunner runner;
  private Map<String, Properties> operatorProps;
  private EList<Model> sampleInputs;
  private int sampleIndex;
  IPath path;
  Operator sample;

  public SampleRunner(@NonNull ExperimentRunner experimentRunner, @NonNull Map<String, Properties> operatorProperties,
                      @NonNull EList<Model> sampleInputs, int sampleIndex) {
    this.runner = experimentRunner;
    this.operatorProps = operatorProperties;
    this.sampleInputs = sampleInputs;
    this.sampleIndex = sampleIndex;
    this.path = this.runner.path.append(SAMPLE_SUBDIR + this.sampleIndex);
  }

  @Override
  public void run() {
    try {
      // create sample folder
      var folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(this.path);
      if (!folder.exists(null)) {
        folder.create(true, true, null);
      }
      this.runner.exp.input.samplesWorkflow.setWorkingPath(this.path.toOSString());

      // write operator properties
      for (var samplesEntry : this.runner.samples.entrySet()) {
        var output = samplesEntry.getKey();
        var outputSpecs = this.runner.exp.outputs.get(output);
        if (output.equals(OUTPUT_SAMPLESTIME) || !outputSpecs.doConfidence) {
          continue;
        }
        var outputSamples = samplesEntry.getValue();
        var props = this.operatorProps.merge(outputSpecs.operatorName, new Properties(), (oldP, newP) -> oldP);
        props.setProperty(output + MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX,
                          String.valueOf(!outputSamples.isWithinTargetConfidence()));
      }
      for (var propsEntry : this.operatorProps.entrySet()) {
        var operatorName = propsEntry.getKey();
        var props = propsEntry.getValue();
        var propsPath = FileUtils.prependWorkspacePath(
                          this.path.append(operatorName + MIDOperatorIOUtils.INPUT_PROPERTIES_SUFFIX +
                                           MIDOperatorIOUtils.PROPERTIES_SUFFIX)
                          .toOSString());
        props.store(new FileOutputStream(propsPath), null);
      }

      // run samples workflow
      System.err.println(MessageFormat.format("Running experiment {0} out of {1}, sample {2}", this.runner.expIndex+1,
                                              this.runner.exp.numExperiments, this.sampleIndex+1));
      var inputs = this.runner.exp.input.samplesWorkflow.checkAllowedInputs(this.sampleInputs);
      var outputMIDsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(this.runner.exp.input.samplesWorkflow, null);
      this.runner.exp.input.samplesWorkflow.getNestedWorkflowMID().getOperators().stream() // init seeded random state
        .map(o -> o.getMetatype())
        .filter(o -> o instanceof RandomOperator)
        .findFirst()
        .ifPresent(o -> ((RandomOperator) o).setState(this.runner.state));
      this.sample = this.runner.exp.input.samplesWorkflow.startInstance(inputs, null, ECollections.emptyEList(),
                                                                        outputMIDsByName, null);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1}, sample {2} failed",
                                                                 this.runner.expIndex+1, this.runner.exp.numExperiments,
                                                                 this.sampleIndex+1), e);
    }
  }

}
