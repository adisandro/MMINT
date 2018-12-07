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

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;

class ExperimentRunner implements Runnable {

  private final static @NonNull String EXPERIMENT_SUBDIR = "experiment";

  private Experiment exp;
  private int expIndex;

  ExperimentRunner(@NonNull Experiment experiment, int experimentIndex) {
    this.exp = experiment;
    this.expIndex = experimentIndex;
  }

  @Override
  public void run() {
    try {
      // create experiment folder
      MMINT.getActiveInstanceMIDFile().getParent().getFullPath();
      IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(
        new Path(MMINT.getActiveInstanceMIDFile().getParent().getFullPath() + EXPERIMENT_SUBDIR + this.expIndex));
      if (!folder.exists(null)) {
          folder.create(true, true, null);
      }
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, MessageFormat.format("Experiment {0} out of {1} failed", this.expIndex,
                                                                 this.exp.numExperiments-1), e);
    }
  }
}
