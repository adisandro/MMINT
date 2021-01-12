/*******************************************************************************
 * Copyright (c) 2020, 2021 Alessio Di Sandro.
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
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

public abstract class GoalDecomposition extends AbstractExternalJavaAction {

  protected abstract GoalDecompositionCommand createCommand(TransactionalEditingDomain domain, Goal goal);

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (modelObj instanceof Goal) {
      return true;
    }
    return false;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var goal = (Goal) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(goal);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(createCommand(sDomain, goal));
  }

  protected abstract class GoalDecompositionCommand extends RecordingCommand {
    protected Goal decomposed;
    protected GSNBuilder builder;

    public GoalDecompositionCommand(TransactionalEditingDomain domain, Goal decomposed, GSNBuilder builder) {
      super(domain);
      this.decomposed = decomposed;
      this.builder = builder;
    }

    protected abstract DecompositionStrategy decompose() throws Exception;

    @Override
    protected void doExecute() {
      try {
        var strategy = decompose();
        this.builder.commitChanges();
        try {
          strategy.validate();
        }
        catch (Exception e) {
          MMINTException.print(IStatus.ERROR, "The goal decomposition is not valid", e);
        }
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Goal decomposition error", e);
      }
    }
  }
}
