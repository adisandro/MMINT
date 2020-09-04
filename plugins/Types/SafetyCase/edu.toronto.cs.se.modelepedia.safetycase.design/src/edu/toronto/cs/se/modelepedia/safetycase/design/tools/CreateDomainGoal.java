/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.modelepedia.safetycase.design.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.GSNFactory;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;

public class CreateDomainGoal extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var gsnRootModelObj = (SafetyCase) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(gsnRootModelObj);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new CreateDomainGoalCommand(sDomain, gsnRootModelObj));
  }

  private class CreateDomainGoalCommand extends RecordingCommand {
    private SafetyCase gsnRootModelObj;
    private GSNFactory factory;
    private List<ArgumentElement> gsnElements;

    public CreateDomainGoalCommand(TransactionalEditingDomain domain, SafetyCase gsnRootModelObj) {
      super(domain);
      this.gsnRootModelObj = gsnRootModelObj;
      this.factory = GSNFactory.eINSTANCE;
      this.gsnElements = new ArrayList<>();
    }

    @Override
    protected void doExecute() {
    }
  }
}
