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
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;

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

    private void impactSupporters(Supportable supportable, List<EObject> trace, Object change) throws Exception {
      for (var supportedBy : supportable.getSupportedBy()) {
        var newTrace = Stream.concat(Stream.of(supportedBy, supportable), trace.stream())
                             .collect(Collectors.toUnmodifiableList());
        impact(supportedBy.getTarget(), newTrace, change);
      }
    }

    private void impactContexts(Contextualizable contextualizable, List<EObject> trace, Object change) throws Exception {
      for (var inContextOf : contextualizable.getInContextOf()) {
        var newTrace = Stream.concat(Stream.of(inContextOf, contextualizable), trace.stream())
                             .collect(Collectors.toUnmodifiableList());
        impact(inContextOf.getContext(), newTrace, change);
      }
    }

    private void impact(ArgumentElement impactedObj, List<EObject> trace, Object change) throws Exception {
      var status = impactedObj.getStatus();
      var lastImpactType = trace.stream()
        .filter(o -> o instanceof ArgumentElement)
        .map(o -> ((ArgumentElement) o).getStatus().getType())
        .findFirst()
        .orElse(ImpactType.REVISE); //TODO: derive from change
      // stop condition: already impacted with equal or more priority
      if (status != null && status.getType().compareTo(lastImpactType) >= 0) {
        return;
      }
      if (status == null) {
        status = GSNFactory.eINSTANCE.createImpactAnnotation();
        impactedObj.setStatus(status);
      }
      // impact rules
      switch (impactedObj) {
        case ArgumentElement elem when elem.getTemplates().stream().anyMatch(t -> t instanceof AnalyticTemplate) -> {
          // TODO this forces each analysis to have an impact method, the default behavior should be a fallback
          for (var template : elem.getTemplates()) {
            if (!(template instanceof AnalyticTemplate analyticTemplate)) {
              continue;
            }
            var nextElems = analyticTemplate.impact(elem, ECollections.asEList(trace), change);
            var newTrace = Stream.concat(Stream.of(analyticTemplate), trace.stream())
                                 .collect(Collectors.toUnmodifiableList());
            for (var nextElem : nextElems) {
              impact(nextElem, newTrace, change);
            }
          }
        }
        case Goal goal -> {
          status.setType(lastImpactType);
          impactSupporters(goal, trace, change);
          impactContexts(goal, trace, change);
        }
        case Strategy strategy -> {
          status.setType(lastImpactType);
          impactSupporters(strategy, trace, change);
          impactContexts(strategy, trace, change);
        }
        case Context context -> {
          status.setType(lastImpactType);
        }
        default -> {
          status.setType(lastImpactType);
        }
      }
    }

    @Override
    protected void doExecute() {
      /**PLAN:
       * 1) Devise mechanism to attach semantics to starting set (basic: change, deletion; template: extra info)
       */
      try {
        //TODO: who resets all impact annotations? add extra command
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
