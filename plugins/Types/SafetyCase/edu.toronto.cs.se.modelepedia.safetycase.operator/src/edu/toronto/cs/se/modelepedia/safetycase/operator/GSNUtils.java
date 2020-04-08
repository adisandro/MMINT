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

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.AndSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.OrSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.XorSupporter;

public class GSNUtils extends Slice {

  // Returns all parents of support connectors that are impacted.
  public static Set<Supportable> getConnectorDependants(Set<SupportConnector> connectors, Set<EObject> alreadySliced) {
    var supportablesCur = new HashSet<Supportable>();
    var supportablesNext = new HashSet<Supportable>();
    var supportablesAll = new HashSet<Supportable>();

    supportablesCur.addAll(connectors);
    supportablesAll.addAll(connectors);
    while (!supportablesCur.isEmpty()) {
    var impactedAll = new HashSet<EObject>();
    impactedAll.addAll(alreadySliced);
    impactedAll.addAll(supportablesAll);
      for (var elem : supportablesCur) {
        // Add parents to impacted set if necessary.
        if (isPropagatedUp(elem, impactedAll)) {
          for (var rel : elem.getSupports()) {
            supportablesNext.add(rel.getSource());
          }
        }
      }
      // Iterate through impacted elements, adding:
      // 1) New support connectors to the next iteration.
      supportablesCur.clear();
      for (var elem : supportablesNext) {
        if (!supportablesAll.contains(elem)) {
          supportablesAll.add(elem);

          if (elem instanceof SupportConnector) {
            supportablesCur.add(elem);
          }
        }
      }
      supportablesNext.clear();
    }

    return supportablesAll;
  }

  // Returns all ancestor goals of the input core element, stopping when one is already impacted.
  public static Set<Goal> getAncestorGoals(CoreElement elem, Set<EObject> alreadySliced) {
    var ancestors = new HashSet<Goal>();
    var ancestorsCur = elem.getSupports().stream()
                           .map(SupportedBy::getSource)
                           .collect(Collectors.toSet());
    var alreadyImpacted2 = new HashSet<>(alreadySliced);
    while (!ancestorsCur.isEmpty()) {
      var ancestorsNext = new HashSet<Supportable>();
      alreadyImpacted2.addAll(ancestorsCur);
      for (var ancestor : ancestorsCur) {
        if (ancestor instanceof Goal) {
          ancestors.add((Goal) ancestor);
        }
        if (isPropagatedUp(ancestor, alreadyImpacted2)) {
          ancestorsNext.addAll(ancestor.getSupports().stream()
                                       .map(SupportedBy::getSource)
                                       .filter(a -> !alreadyImpacted2.contains(a))
                                       .collect(Collectors.toSet()));
        }
      }
      ancestorsCur = ancestorsNext;
    }

    return ancestors;
  }

  // Determines whether a change impact is propagated up or not given the
  // source impacted element and a set of other impacted elements.
  public static boolean isPropagatedUp(Supportable elem, Set<EObject> alreadySliced) {

    // If a core element is impacted, then its parents are also impacted.
    if (elem instanceof CoreElement) {
      return true;
    }
    // Count the number of children impacted.
    var isPropagated = false;
    var impactCount = 0;
    var totalCount = 0;
    for (var rel : elem.getSupportedBy()) {
      totalCount += 1;
      var target = rel.getTarget();
      if (alreadySliced.contains(target)) {
        impactCount += 1;
      }
      else if (target instanceof SupportConnector) {
        if (isPropagatedUp((SupportConnector) target, alreadySliced)) {
          impactCount += 1;
        }
      }
    }
    // If an AND-connector or an XOR-connector is impacted, then its parents are
    // impacted if any of its children are impacted.
    if ((elem instanceof AndSupporter) || (elem instanceof XorSupporter)) {
      if (impactCount >= 1) {
        isPropagated = true;
      }
    }
    // If an OR-connector is impacted, then its parents are
    // impacted if all its children are impacted.
    else if (elem instanceof OrSupporter) {
      if (impactCount == totalCount) {
        isPropagated = true;
      }
    }
    // If an M-of-N connector is impacted, then its parents are
    // impacted if more than (N-M) children are impacted.
    else if (elem instanceof MofNSupporter) {
      var target = ((MofNSupporter) elem).getTarget();
      if (impactCount > totalCount - target) {
        isPropagated = true;
      }
    }

    return isPropagated;
  }

  public static Set<CoreElement> getChildCoreElements(DecomposableCoreElement inputElem, Set<EObject> alreadySliced) {
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
  public static Set<ArgumentElement> getContextInheritors(DecomposableCoreElement elem, Set<EObject> alreadySliced) {
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
}
