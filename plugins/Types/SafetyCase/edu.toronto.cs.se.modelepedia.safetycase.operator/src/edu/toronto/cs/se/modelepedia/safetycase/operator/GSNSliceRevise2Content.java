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

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.Assumption;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.IndependenceGoal;
import edu.toronto.cs.se.modelepedia.safetycase.Justification;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;

public class GSNSliceRevise2Content extends GSNSlice {

  // Get all model elements in a safety case that needs to be re-checked for
  // content validity given the input element that requires revision.
  @Override
  protected Map<EObject, EObject> getAllSlicedElements(EObject critModelObj, Set<EObject> alreadyImpacted) {
    var impacted = new HashMap<EObject, EObject>();
    impacted.put(critModelObj, null);
    alreadyImpacted.add(critModelObj);
    // Identify all elements (including supported-by connectors) that are
    // dependent on the revised element.
    var impactedModelObjs = getDirectlySlicedElements(critModelObj, alreadyImpacted);
    alreadyImpacted.addAll(impactedModelObjs);
    // Iterate through newly impacted supported-by connectors and check
    // whether their sources are impacted as well. Repeat the process
    // until a fixed point is reached.
    var connectors = new HashSet<SupportConnector>();
    for (var elem : alreadyImpacted) {
      if (elem instanceof SupportConnector) {
        connectors.add((SupportConnector) elem);
      }
    }
    var connectorDependants = new HashSet<Supportable>();
    for (var dependant : getConnectorDependants(connectors, alreadyImpacted)) {
      if (dependant instanceof CoreElement) {
        connectorDependants.add(dependant);
      }
    }
    impactedModelObjs.addAll(connectorDependants);
    // If an ASIL decomposition strategy is impacted, then its independence
    // goal is also impacted.
    var independenceGoals = new HashSet<IndependenceGoal>();
    for (var elem : impactedModelObjs) {
      if (elem instanceof ASILDecompositionStrategy) {
        for (var child : getChildCoreElements((ASILDecompositionStrategy) elem)) {
          if (child instanceof IndependenceGoal) {
            independenceGoals.add((IndependenceGoal) child);
          }
        }
      }
    }
    impactedModelObjs.addAll(independenceGoals);
    // Remove supported-by connectors from the impacted elements.
    impactedModelObjs.removeIf(elem -> elem instanceof SupportConnector);
    // Return the impacted elements (excluding supported-by connectors).
    impactedModelObjs.stream().forEach(i -> impacted.put(i, critModelObj));

    return impacted;
  }

  // Get impacted model elements directly reachable from the input element.
  @Override
  protected Set<EObject> getDirectlySlicedElements(EObject modelObj, Set<EObject> alreadyImpacted) {
    var impacted = new HashSet<EObject>();
    // If input is a goal, then the following are potentially impacted:
    // 1) Any parent supportable (including supported-by connectors)
    // 2) Any child core element (i.e. goal, strategy or solution).
    if (modelObj instanceof Goal) {
      var g = (Goal) modelObj;
      var children = getChildCoreElements(g);
      var parents = new HashSet<Supportable>();
      for (var rel : g.getSupports()) {
        parents.add(rel.getSource());
      }
      impacted.addAll(children);
      impacted.addAll(parents);
    }
    // If input is a strategy, then the content validity should be rechecked for:
    // 2) Any child core element.
    // 3) Any contexts and justifications connected to it.
    else if (modelObj instanceof Strategy) {
      var s = (Strategy) modelObj;
      var children = getChildCoreElements(s);
      var contexts = new HashSet<ContextualElement>();
      for (var rel : s.getInContextOf()) {
        contexts.add(rel.getContext());
      }
      impacted.addAll(children);
      impacted.addAll(contexts);
    }
    // If input is a solution, then the content validity should be rechecked for:
    // 1) Any parent supportable.
    else if (modelObj instanceof Solution) {
      var s = (Solution) modelObj;
      var parents = new HashSet<Supportable>();
      for (var rel : s.getSupports()) {
        parents.add(rel.getSource());
      }
      impacted.addAll(parents);
    }
    // If input is a context, then the content validity should be rechecked for:
    // 1) All argument elements that uses or inherits input context.
    else if (modelObj instanceof Context) {
      Context c = (Context) modelObj;
      var inheritors = new HashSet<ArgumentElement>();
      for (var rel : c.getContextOf()) {
        inheritors.addAll(getContextInheritors(rel.getContextOf()));
      }
      impacted.addAll(inheritors);
    }
    // If input is a justification, then nothing else requires rechecking.
    else if (modelObj instanceof Justification) {

    }
    // If input is an assumption, then the following are impacted:
    // 1) All argument elements that uses or inherits input assumption.
    else if (modelObj instanceof Assumption) {
      var a = (Assumption) modelObj;
      var inheritors = new HashSet<ArgumentElement>();
      for (InContextOf rel : a.getContextOf()) {
        inheritors.addAll(getContextInheritors(rel.getContextOf()));
      }
      impacted.addAll(inheritors);
    }
    impacted.removeAll(alreadyImpacted);

    return impacted;
  }

  // Returns all the descendant argument elements (core and contextual
  // elements) of the input decomposable core element.
  public Set<ArgumentElement> getContextInheritors(DecomposableCoreElement elem) {
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
            descendantsNext.addAll(getChildCoreElements(d));
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
