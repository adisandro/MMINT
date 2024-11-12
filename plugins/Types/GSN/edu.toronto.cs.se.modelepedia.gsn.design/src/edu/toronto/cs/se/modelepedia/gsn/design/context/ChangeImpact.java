/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;

public class ChangeImpact extends AbstractExternalJavaAction {
  /**PLAN:
   * 1) Devise mechanism to attach semantics to starting set (basic: change, deletion; template: extra info)
   * 2) Baseline loop must not be localized to individual elements:
   * 2a) recursive, with trace until that point and priority among annotations
   * 2b) stop condition if already impacted and less priority
   * 2c) invokes template impact if found (how to get in and out of it, what are the boundaries?)
   * 2d) visited and impacted should not be separate, visited is just impacted with reuse (vs not impacted at all)
   */

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return
      !arg0.isEmpty() &&
      arg0.stream()
        .map(DSemanticDecorator.class::cast)
        .map(DSemanticDecorator::getTarget)
        .allMatch(o -> o instanceof ArgumentElement);
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

  private class ChangeImpactCommand extends RecordingCommand {
    List<ArgumentElement> modelObjs;

    public ChangeImpactCommand(TransactionalEditingDomain domain, List<ArgumentElement> modelObjs) {
      super(domain);
      this.modelObjs = modelObjs;
    }

    @Override
    protected void doExecute() {
    }
  }
}
