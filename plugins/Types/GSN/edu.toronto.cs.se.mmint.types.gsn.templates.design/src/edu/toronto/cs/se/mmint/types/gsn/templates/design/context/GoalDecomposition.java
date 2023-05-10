/*******************************************************************************
 * Copyright (c) 2020, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.design.context;

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
import edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

public abstract class GoalDecomposition extends AbstractExternalJavaAction {

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

  protected abstract GSNBuilder createGSNBuilder(Goal goal);

  protected abstract DecompositionStrategy decompose(Goal decomposed, GSNBuilder builder) throws Exception;

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var goal = (Goal) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var builder = createGSNBuilder(goal);
    try {
      var strategy = decompose(goal, builder);
      var sSession = SessionManager.INSTANCE.getSession(goal);
      var sDomain = sSession.getTransactionalEditingDomain();
      sDomain.getCommandStack().execute(new GoalDecompositionCommand(sDomain, strategy, builder));
    }
    catch (MIDDialogCancellation e) {
      // do nothing
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "Goal decomposition error", e);
    }
  }

  protected class GoalDecompositionCommand extends RecordingCommand {
    protected DecompositionStrategy strategy;
    protected GSNBuilder builder;

    public GoalDecompositionCommand(TransactionalEditingDomain domain, DecompositionStrategy strategy,
                                    GSNBuilder builder) {
      super(domain);
      this.strategy = strategy;
      this.builder = builder;
    }

    @Override
    protected void doExecute() {
      this.builder.commitChanges();
      try {
        this.strategy.validate();
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "The goal decomposition is not valid", e);
      }
    }
  }
}
