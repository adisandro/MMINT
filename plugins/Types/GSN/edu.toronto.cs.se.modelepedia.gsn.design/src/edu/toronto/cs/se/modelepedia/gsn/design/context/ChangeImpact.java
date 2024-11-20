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
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;

public class ChangeImpact extends AbstractExternalJavaAction {

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

    private void impact(ArgumentElement impactedObj, List<EObject> trace, Object change) {
      var status = impactedObj.getStatus();
      var lastImpactType = trace.stream()
        .filter(o -> o instanceof ArgumentElement)
        .map(o -> ((ArgumentElement) o).getStatus().getType())
        .findFirst()
        .orElse(ImpactType.RECHECK); //TODO: derive from change
      // stop condition: already impacted with equal or more priority
      if (status != null && status.getType().compareTo(lastImpactType) >= 0) {
        return;
      }
      if (status == null) {
        status = GSNFactory.eINSTANCE.createImpactAnnotation();
        impactedObj.setStatus(status);
      }
      // impact rules
      status.setType(lastImpactType); //TODO: customize for each impactedObj type
      switch (impactedObj) {
        case Goal goal -> {
          for (var supportedBy : goal.getSupportedBy()) {
            var newTrace = Stream.concat(Stream.of(supportedBy, goal), trace.stream())
                                 .collect(Collectors.toUnmodifiableList());
            impact(supportedBy.getTarget(), newTrace, change);
          }
        }
        //TODO: add all types and abstract behavior if repeated
        default -> {}
      }
    }

    @Override
    protected void doExecute() {
      /**PLAN:
       * 1) Devise mechanism to attach semantics to starting set (basic: change, deletion; template: extra info)
       * 2) Invoke template impact if found (how to get in and out of it, what are the boundaries?)
       */
      try {
        //TODO: who resets all impact annotations?
        for (var modelObj : this.modelObjs) {
          impact(modelObj, List.of(), "change");
        }
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error running change impact", e);
      }
    }
  }
}
