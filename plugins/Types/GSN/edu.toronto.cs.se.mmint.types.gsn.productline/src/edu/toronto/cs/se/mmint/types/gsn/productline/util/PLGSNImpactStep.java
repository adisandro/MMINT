/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ImpactStep;

public class PLGSNImpactStep extends ImpactStep<Class> {

  public PLGSNImpactStep(Class impacted) {
    super(impacted);
  }

  public PLGSNImpactStep(Class impacted, List<EObject> trace) {
    super(impacted, trace);
  }

  private List<Class> getPreviousImpacts(Object change) {
    return this.trace.stream()
      .filter(o -> o instanceof PLGSNArgumentElement)
      .map(o -> ((PLGSNArgumentElement) o).getStreamOfReference(GSNPackage.eINSTANCE.getArgumentElement_Status())
                                          .collect(Collectors.toList()))
      .findFirst()
      .orElseGet(() -> {
        var c = PLFactory.eINSTANCE.createClass();
        c.setType(GSNPackage.eINSTANCE.getImpactAnnotation());
        c.addAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type(), ImpactType.RECHECK.toString()); //TODO: derive from change
        return List.of(c);
      });
  }

  @Override
  public List<PLGSNImpactStep> nextSteps(Object change) {
    var currImpacts = this.impacted.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status());
    var prevImpacts = getPreviousImpacts(change);
    // impact rules
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    switch (this.impacted) {
      default -> {
        currImpacts.forEach(i -> i.setAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type(), null));
      }
    }

    return nextSteps;
  }

  @Override
  public void impact(Object change) throws Exception {
    var currImpacts = this.impacted.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status());
    var prevImpacts = getPreviousImpacts(change);
    // stop condition: already impacted with equal or more priority
    if (!currImpacts.isEmpty()) {
      var stop = true;
      for (var currImpact : currImpacts) {
        //TODO MMINT[PL-GSN] Use presence conditions to decide which previous impact should be compared with
        var prevImpact = prevImpacts.get(0).getAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type()).get(0);
        var currentType = currImpact.getAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type()).get(0);
        if (ImpactType.valueOf(currentType).compareTo(ImpactType.valueOf(prevImpact)) < 0) {
          stop = false;
          break;
        }
      }
      if (stop) {
        return;
      }
    }
    if (currImpacts.isEmpty()) {
      var clazz = PLFactory.eINSTANCE.createClass();
      clazz.setType(GSNPackage.eINSTANCE.getImpactAnnotation());
      this.impacted.addReference(GSNPackage.eINSTANCE.getArgumentElement_Status(), clazz);
      currImpacts = ECollections.asEList(clazz);
    }
    // separate syntactic vs semantic (template) behavior
    for (var currImpact : currImpacts) {
      var templates = this.impacted.getReference(GSNPackage.eINSTANCE.getArgumentElement_Templates());
      var nextSteps = (templates.isEmpty()) ? nextSteps(change) : ((PLGSNTemplate) templates.get(0)).impact(this, change);
      for (var nextStep : nextSteps) {
        nextStep.impact(change);
      }
    }
  }
}
