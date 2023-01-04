/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.design.tools;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

public abstract class CreateDecompositionElement extends AbstractExternalJavaAction {

  protected abstract CreateDecompositionElementCommand createCommand(TransactionalEditingDomain domain,
                                                                     SafetyCase gsnRootModelObj);

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var gsnRootModelObj = (SafetyCase) arg0.iterator().next();
    var sSession = SessionManager.INSTANCE.getSession(gsnRootModelObj);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(createCommand(sDomain, gsnRootModelObj));
  }

  protected abstract class CreateDecompositionElementCommand extends RecordingCommand {
    protected GSNBuilder builder;

    public CreateDecompositionElementCommand(TransactionalEditingDomain domain, GSNBuilder builder) {
      super(domain);
      this.builder = builder;
    }

    protected abstract void create() throws Exception;

    @Override
    protected void doExecute() {
      try {
        create();
        this.builder.commitChanges();
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error creating decomposition element", e);
      }
    }
  }
}
