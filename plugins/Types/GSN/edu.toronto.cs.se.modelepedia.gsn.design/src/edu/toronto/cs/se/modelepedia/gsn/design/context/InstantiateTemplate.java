/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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

public class InstantiateTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(modelObj);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new InstantiateTemplateCommand(sDomain, (SafetyCase) modelObj.eContainer()));
  }

  private class InstantiateTemplateCommand extends RecordingCommand {
    SafetyCase safetyCase;

    public InstantiateTemplateCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
      super(domain);
      this.safetyCase = safetyCase;
    }

    @Override
    protected void doExecute() {
      try {
        var templatePath = MIDDialogs.selectFiles("Instantiate Template", "Select GSN template file",
                                                  "There are no GSN files in the workspace", Set.of(GSNPackage.eNAME));
        var templateSafetyCase = (SafetyCase) FileUtils.readModelFile(templatePath, null, true);
        for (var templateGoal : templateSafetyCase.getGoals()) {
          this.safetyCase.getGoals().add(EcoreUtil.copy(templateGoal));
        }
      }
      catch (MIDDialogCancellation e) {
        // template file selection cancelled
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error instantiating GSN template", e);
      }
    }
  }
}
