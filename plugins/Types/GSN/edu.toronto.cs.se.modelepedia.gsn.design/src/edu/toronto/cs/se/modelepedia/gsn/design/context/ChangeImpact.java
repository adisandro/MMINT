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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNChangeStep;

public class ChangeImpact extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return
      !arg0.isEmpty() &&
      arg0.stream()
        .map(DSemanticDecorator.class::cast)
        .map(DSemanticDecorator::getTarget)
        .allMatch(o -> o instanceof ArgumentElement e && e.getStatus() == null);
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var modelObjs = arg0.stream()
      .map(DSemanticDecorator.class::cast)
      .map(DSemanticDecorator::getTarget)
      .map(ArgumentElement.class::cast)
      .collect(Collectors.toList());
    var sSession = SessionManager.INSTANCE.getSession(modelObjs.get(0));
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new ChangeImpactCommand(sDomain, modelObjs));
  }

  public static class ChangeImpactCommand extends RecordingCommand {
    List<ArgumentElement> modelObjs;

    public ChangeImpactCommand(TransactionalEditingDomain domain, List<ArgumentElement> modelObjs) {
      super(domain);
      this.modelObjs = modelObjs;
    }

    @Override
    protected void doExecute() {
      try {
        ChangeStep.initProperties(this.modelObjs.get(0));
        for (var modelObj : this.modelObjs) {
          var startStep = new GSNChangeStep(modelObj);
          startStep.impact();
        }
        //TODO do propagation UP
        //TODO template nextSteps() must already mark something beforehand?
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error running change impact", e);
      }
    }
  }
}
