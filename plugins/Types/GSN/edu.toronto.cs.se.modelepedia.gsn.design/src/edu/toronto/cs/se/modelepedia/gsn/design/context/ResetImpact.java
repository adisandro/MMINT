/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;

public class ResetImpact extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return
      !arg0.isEmpty() &&
      arg0.stream()
        .map(DSemanticDecorator.class::cast)
        .map(DSemanticDecorator::getTarget)
        .anyMatch(o -> o instanceof ArgumentElement e && e.getStatus() != null);
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var modelObj = arg0.stream()
      .map(DSemanticDecorator.class::cast)
      .map(DSemanticDecorator::getTarget)
      .filter(o -> o instanceof ArgumentElement)
      .findFirst().get();
    var safetyCase = (SafetyCase) modelObj.eContainer();
    var sSession = SessionManager.INSTANCE.getSession(safetyCase);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new ResetImpactCommand(sDomain, safetyCase));
  }

  private class ResetImpactCommand extends RecordingCommand {
    SafetyCase safetyCase;

    public ResetImpactCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
      super(domain);
      this.safetyCase = safetyCase;
    }

    @Override
    protected void doExecute() {
      for (var iter = this.safetyCase.eAllContents(); iter.hasNext();) {
        if (!(iter.next() instanceof ArgumentElement elem)) {
          continue;
        }
        elem.setStatus(null);
      }
      ChangeStep.resetData();
    }
  }
}
