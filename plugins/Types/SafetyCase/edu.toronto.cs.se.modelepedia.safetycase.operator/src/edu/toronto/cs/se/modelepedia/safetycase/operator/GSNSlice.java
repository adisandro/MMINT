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

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.AndSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.OrSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.XorSupporter;

// Contains useful functions for slicing safety cases.
public class GSNSlice extends Slice {

  // Returns all child core elements of the input decomposable core element.
  public Set<CoreElement> getChildCoreElements(DecomposableCoreElement inputElem) {
    var children = new HashSet<CoreElement>();
    var supportablesCur = new HashSet<Supportable>();
    var supportablesAll = new HashSet<Supportable>();
    var supportablesNext = new HashSet<Supportable>();

    supportablesCur.add(inputElem);
    while (!supportablesCur.isEmpty()) {
      for (var elem : supportablesCur) {
        for (var rel : elem.getSupportedBy()) {
          var s = rel.getTarget();
          if (s instanceof CoreElement) {
            children.add((CoreElement) s);
          }
          else if (s instanceof SupportConnector) {
            supportablesNext.add((SupportConnector) s);
          }
        }
      }
      supportablesCur.clear();
      for (var s : supportablesNext) {
        if (!supportablesAll.contains(s)) {
          supportablesAll.add(s);
          supportablesCur.add(s);
        }
      }
      supportablesNext.clear();
    }

    return children;
  }

  // Returns all parents of support connectors that are impacted.
  public Set<Supportable> getConnectorDependants(Set<SupportConnector> connectors, Set<EObject> alreadyImpacted) {
    var supportablesCur = new HashSet<Supportable>();
    var supportablesNext = new HashSet<Supportable>();
    var supportablesAll = new HashSet<Supportable>();

    supportablesCur.addAll(connectors);
    supportablesAll.addAll(connectors);
    while (!supportablesCur.isEmpty()) {
    var impactedAll = new HashSet<EObject>();
    impactedAll.addAll(alreadyImpacted);
    impactedAll.addAll(supportablesAll);
      for (var elem : supportablesCur) {
        // Add parents to impacted set if necessary.
        if (isImpactPropagatedUp(elem, impactedAll)) {
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
  public Set<Goal> getAncestorGoals(CoreElement elem, Set<EObject> alreadyImpacted) {
    var ancestorsCur = new HashSet<Supportable>();
    var ancestorsNext = new HashSet<Supportable>();
    var ancestorsAll = new HashSet<Supportable>();
    var goalAncestors = new HashSet<Goal>();

//    for (var rel : elem.getSupports()) {
//      var source = rel.getSource();
//      if (source instanceof Goal) {
//        goalAncestors.add((Goal) source);
//      }
//      if (isImpactPropagatedUp(source, alreadyImpacted)) {
//
//      }
//    }

    // Iterate through the current set of newly added ancestors
    // to identify the next generation of ancestors.
    for (var rel : elem.getSupports()) {
      ancestorsNext.add(rel.getSource());
      if (rel.getSource() instanceof Goal) {
        goalAncestors.add((Goal) rel.getSource());
      }
    }
    ancestorsCur.addAll(ancestorsNext);
    ancestorsAll.addAll(ancestorsNext);
    ancestorsNext.clear();
    while (!ancestorsCur.isEmpty()) {
      var impactedAll = new HashSet<EObject>();
      impactedAll.addAll(alreadyImpacted);
      impactedAll.addAll(ancestorsAll);
      for (var curElem : ancestorsCur) {
        if (isImpactPropagatedUp(curElem, impactedAll)) {
          for (var rel : curElem.getSupports()) {
            ancestorsNext.add(rel.getSource());
          }
        }
      }
      ancestorsCur.clear();
      for (var newElem : ancestorsNext) {
        if (!ancestorsAll.contains(newElem)) {
          ancestorsAll.add(newElem);
          ancestorsCur.add(newElem);
        }
        if (newElem instanceof Goal) {
          goalAncestors.add((Goal) newElem);
        }
      }
      ancestorsNext.clear();
    }

    return goalAncestors;
  }

  // Determines whether a change impact is propagated up or not given the
  // source impacted element and a set of other impacted elements.
  public boolean isImpactPropagatedUp(Supportable elem, Set<EObject> alreadyImpacted) {

    // If a core element is impacted, then its parents are also impacted.
    if (elem instanceof CoreElement) {
      return true;
    }
    // Count the number of children impacted.
    boolean isImpactPropagated = false;
    int impactCount = 0;
    int totalCount = 0;
    for (var rel : elem.getSupportedBy()) {
      totalCount += 1;
      var target = rel.getTarget();
      if (alreadyImpacted.contains(target)) {
        impactCount += 1;
      }
      else if (target instanceof SupportConnector) {
        if (isImpactPropagatedUp((SupportConnector) target, alreadyImpacted)) {
          impactCount += 1;
        }
      }
    }
    // If an AND-connector or an XOR-connector is impacted, then its parents are
    // impacted if any of its children are impacted.
    if ((elem instanceof AndSupporter) || (elem instanceof XorSupporter)) {
      if (impactCount >= 1) {
        isImpactPropagated = true;
      }
    }
    // If an OR-connector is impacted, then its parents are
    // impacted if all its children are impacted.
    else if (elem instanceof OrSupporter) {
      if (impactCount == totalCount) {
        isImpactPropagated = true;
      }
    }
    // If an M-of-N connector is impacted, then its parents are
    // impacted if more than (N-M) children are impacted.
    else if (elem instanceof MofNSupporter) {
      var target = ((MofNSupporter) elem).getTarget();
      if (impactCount > totalCount - target) {
        isImpactPropagated = true;
      }
    }

    return isImpactPropagated;
  }
}
