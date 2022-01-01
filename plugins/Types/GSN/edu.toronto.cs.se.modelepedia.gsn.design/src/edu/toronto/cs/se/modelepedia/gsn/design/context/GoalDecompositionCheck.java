/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy;

public class GoalDecompositionCheck extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (modelObj instanceof DecompositionStrategy) {
      return true;
    }
    return false;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var strategy = (DecompositionStrategy) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(strategy);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new GoalDecompositionCheckCommand(sDomain, strategy));
  }

  private class GoalDecompositionCheckCommand extends RecordingCommand {
    private DecompositionStrategy strategy;

    public GoalDecompositionCheckCommand(TransactionalEditingDomain domain, DecompositionStrategy strategy) {
      super(domain);
      this.strategy = strategy;
    }

    @Override
    protected void doExecute() {
      var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
      var title = "Goal Decomposition Check";
      try {
        this.strategy.validate();
        MessageDialog.openInformation(shell, title, "The goal decomposition is valid");
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "The goal decomposition is not valid", e);
      }
    }
  }
}
