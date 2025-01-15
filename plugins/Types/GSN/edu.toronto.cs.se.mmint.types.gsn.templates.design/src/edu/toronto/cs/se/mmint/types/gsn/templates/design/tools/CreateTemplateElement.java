/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
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

public abstract class CreateTemplateElement extends AbstractExternalJavaAction {

  protected abstract CreateTemplateElementCommand createCommand(TransactionalEditingDomain domain,
                                                                SafetyCase safetyCase);

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var safetyCase = (SafetyCase) arg0.iterator().next();
    var sSession = SessionManager.INSTANCE.getSession(safetyCase);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(createCommand(sDomain, safetyCase));
  }

  protected abstract class CreateTemplateElementCommand extends RecordingCommand {
    protected GSNBuilder builder;

    public CreateTemplateElementCommand(TransactionalEditingDomain domain, GSNBuilder builder) {
      super(domain);
      this.builder = builder;
    }

    protected abstract void create() throws Exception;

    @Override
    protected void doExecute() {
      try {
        create();
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error creating template element", e);
      }
    }
  }
}
