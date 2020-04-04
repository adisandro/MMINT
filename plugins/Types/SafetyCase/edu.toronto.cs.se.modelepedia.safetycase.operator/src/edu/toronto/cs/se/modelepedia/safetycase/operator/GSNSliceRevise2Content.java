/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.Assumption;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;

public class GSNSliceRevise2Content extends Slice {

  private Set<CoreElement> getChildCoreElements(DecomposableCoreElement inputElem, Set<EObject> alreadySliced) {
    //TODO Integrate SupportConnector with the dual algorithm sliced/visited?
    var children = new HashSet<CoreElement>();
    var supportablesCur = new HashSet<Supportable>();
    var alreadyVisited = new HashSet<Supportable>(); // prevents loops
    supportablesCur.add(inputElem);

    while (!supportablesCur.isEmpty()) {
      var supportablesNext = new HashSet<Supportable>();
      for (var supBy : inputElem.getSupportedBy()) {
        var supporter = supBy.getTarget();
        if (supporter instanceof CoreElement && !alreadySliced.contains(supporter)) {
          children.add((CoreElement) supporter);
        }
        else if (supporter instanceof SupportConnector && !alreadyVisited.contains(supporter)) {
          supportablesNext.add((Supportable) supporter);
          alreadyVisited.add((Supportable) supporter);
        }
      }
      supportablesCur = supportablesNext;
    }

    return children;
  }

  // Returns all the descendant argument elements (core and contextual
  // elements) of the input decomposable core element.
  public Set<ArgumentElement> getContextInheritors(DecomposableCoreElement elem, Set<EObject> alreadySliced) {
    var descendantsAll = new HashSet<ArgumentElement>();
    var descendantsCur = new HashSet<ArgumentElement>();
    var descendantsNext = new HashSet<ArgumentElement>();

    // Iterate through the current set of newly added descendants
    // to identify the next generation of descendants.
    descendantsAll.add(elem);
    descendantsCur.add(elem);
    while (!descendantsCur.isEmpty()) {
      for (var curElem : descendantsCur) {
        if (curElem instanceof DecomposableCoreElement) {
          var d = (DecomposableCoreElement) curElem;
          if (d.getSupportedBy() != null) {
            descendantsNext.addAll(getChildCoreElements(d, alreadySliced));
          }
          if (d.getInContextOf() != null) {
            for (var rel : d.getInContextOf()) {
              descendantsNext.add(rel.getContext());
            }
          }
        }
      }
      descendantsCur.clear();
      for (var newElem : descendantsNext) {
        if (!descendantsAll.contains(newElem)) {
          descendantsAll.add(newElem);
          descendantsCur.add(newElem);
        }
      }
      descendantsNext.clear();
    }

    return descendantsAll;
  }

  @Override
  protected Set<EObject> getDirectlySlicedElements(EObject modelObj, Set<EObject> alreadySliced) {
    var sliced = new HashSet<EObject>();

    if (modelObj instanceof DecomposableCoreElement) {
      // slice child core elements
      sliced.addAll(getChildCoreElements((DecomposableCoreElement) modelObj, alreadySliced));
    }
    if (modelObj instanceof Goal || modelObj instanceof Solution) {
      // slice parent supportables (including support connectors)
      sliced.addAll(
        ((Supporter) modelObj).getSupports().stream()
          .map(SupportedBy::getSource)
          .filter(s -> !alreadySliced.contains(s))
          .collect(Collectors.toSet()));
    }
    if (modelObj instanceof Strategy) {
      // slice any contexts and justifications connected to it
      sliced.addAll(
        ((Strategy) modelObj).getInContextOf().stream()
          .map(InContextOf::getContext)
          .filter(c -> !alreadySliced.contains(c))
          .collect(Collectors.toSet()));
    }
    if (modelObj instanceof Context || modelObj instanceof Assumption) {
      // slice all argument elements that use or inherit it
      ((ContextualElement) modelObj).getContextOf().stream()
        .map(InContextOf::getContextOf)
        .forEach(c -> sliced.addAll(getContextInheritors(c, alreadySliced)));
    }

    return sliced;
  }

  @Override
  protected Map<EObject, EObject> getAllSlicedElements(EObject critModelObj, Set<EObject> alreadySliced) {
    //TODO Does this function mean that there is no slicing recursion, e.g. for goals
    var sliced = new HashMap<EObject, EObject>();
    sliced.put(critModelObj, null);
    alreadySliced.add(critModelObj);
    // Identify all elements (including supported-by connectors) that are
    // dependent on the revised element.
    var impactedModelObjs = getDirectlySlicedElements(critModelObj, alreadySliced);
    alreadySliced.addAll(impactedModelObjs);
    // Iterate through newly impacted supported-by connectors and check
    // whether their sources are impacted as well. Repeat the process
    // until a fixed point is reached.
    var connectors = new HashSet<SupportConnector>();
    for (var elem : alreadySliced) {
      if (elem instanceof SupportConnector) {
        connectors.add((SupportConnector) elem);
      }
    }
    var connectorDependants = new HashSet<Supportable>();
    for (var dependant : GSNUtils.getConnectorDependants(connectors, alreadySliced)) {
      if (dependant instanceof CoreElement) {
        connectorDependants.add(dependant);
      }
    }
    impactedModelObjs.addAll(connectorDependants);
    // Remove supported-by connectors from the impacted elements.
    impactedModelObjs.removeIf(elem -> elem instanceof SupportConnector);
    // Return the impacted elements (excluding supported-by connectors).
    impactedModelObjs.stream().forEach(i -> sliced.put(i, critModelObj));

    return sliced;
  }
}
