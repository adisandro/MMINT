/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.design.context;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class ImportTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.isEmpty()) {
      return false;
    }
    if (!(((DSemanticDecorator) arg0.iterator().next()).getTarget() instanceof SafetyCase)) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var safetyCase = (SafetyCase) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(safetyCase);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new ImportTemplateCommand(sDomain, safetyCase));
  }

  private class ImportTemplateCommand extends RecordingCommand {
    SafetyCase safetyCase;

    public ImportTemplateCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
      super(domain);
      this.safetyCase = safetyCase;
    }

    @Override
    protected void doExecute() {
      try {
        var templatePath = MIDDialogs.selectFile("Import Template", "Select GSN template file",
                                                 "There are no GSN files in the workspace", Set.of(GSNPackage.eNAME));
        var templateSC = (SafetyCase) FileUtils.readModelFile(templatePath, null, true);
        if (templateSC.getTemplates().isEmpty()) {
          throw new MMINTException(templatePath + " does not contain a template");
        }
        templateSC = EcoreUtil.copy(templateSC);
        var template = (templateSC.getTemplates().size() > 1) ?
          MIDDialogs.selectModelObject("Import Template", "Select GSN template", templateSC.getTemplates()) :
          templateSC.getTemplates().get(0);
        template.import_(this.safetyCase);
      }
      catch (MIDDialogCancellation e) {
        // template file selection cancelled
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error importing GSN template", e);
      }
    }
  }
}
