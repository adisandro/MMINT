/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.types.gsn.templates.design.tools;

import java.util.ArrayList;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

public class CreateFilesContext extends CreateTemplateElement {

  @Override
  protected CreateTemplateElementCommand createCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
    return new CreateFilesContextCommand(domain, safetyCase);
  }

  private class CreateFilesContextCommand extends CreateTemplateElementCommand {

    public CreateFilesContextCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
      super(domain, new GSNTemplatesBuilder(safetyCase));
    }

    @Override
    protected void create() throws Exception {
      var builder = (GSNTemplatesBuilder) this.builder;
      String path;
      var paths = new ArrayList<String>(1);
      try {
        path = GSNBuilder.askForPath("Create Files Context", "Select a file or directory");
        paths.add(FileUtils.prependWorkspacePath(path));
      }
      catch (MIDDialogCancellation e) {
        // create without paths
        path = "PATH MISSING";
      }
      builder.createFilesContext("", path, paths);
    }
  }
}
