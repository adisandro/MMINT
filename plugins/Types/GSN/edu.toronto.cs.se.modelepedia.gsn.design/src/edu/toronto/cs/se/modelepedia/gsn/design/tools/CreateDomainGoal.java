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
package edu.toronto.cs.se.modelepedia.gsn.design.tools;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.util.DomainBuilder;

public class CreateDomainGoal extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var gsnRootModelObj = (SafetyCase) arg0.iterator().next();
    var sSession = SessionManager.INSTANCE.getSession(gsnRootModelObj);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new CreateDomainGoalCommand(sDomain, gsnRootModelObj));
  }

  private class CreateDomainGoalCommand extends RecordingCommand {
    private DomainBuilder builder;

    public CreateDomainGoalCommand(TransactionalEditingDomain domain, SafetyCase gsnRootModelObj) {
      super(domain);
      this.builder = new DomainBuilder(gsnRootModelObj);
    }

    @Override
    protected void doExecute() {
      try {
        var domain = this.builder.createDomain("Create Domain Goal", "Insert the domain",
                                               Set.of(GSNPackage.INT_DOMAIN, GSNPackage.REAL_DOMAIN,
                                                      GSNPackage.ENUM_DOMAIN, GSNPackage.VALUE_DOMAIN));
        this.builder.createDomainGoal("", "", domain);
        this.builder.commitChanges();
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Create domain goal error", e);
      }
    }
  }
}
