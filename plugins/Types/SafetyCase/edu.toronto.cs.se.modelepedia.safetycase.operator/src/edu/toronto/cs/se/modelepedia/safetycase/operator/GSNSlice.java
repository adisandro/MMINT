/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.AndSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.OrSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.XorSupporter;

/*
 * Algorithm (from Assure18 paper):
 * REVISE:
 * 1) Trace deleted elements to gsn
 * RECHECK CONTENT:
 * 1) Trace deleted elements to gsn
 * 2) Apply V1, V2, V3, V4 once (not recursively)
 * 3) Add traced sysmega slice
 * RECHECK STATE:
 * 1) Trace deleted elements to gsn
 * 2) Apply V2 once (not recursively)
 * 3) Add traced sysmega slice
 * 4) Apply C1, C2 recursively
 * RECHECK:
 * 1) Trace deleted elements to gsn
 * 2) Apply V1, V2, V3, V4 once (not recursively)
 * 3) Add traced sysmega slice
 * 4) Apply C1, C2 recursively (excluding newly generated RECHECK_CONTENT)
 *
 * Questions:
 * - Remap traced sysmega slice to MOD, or keep them as R_C? (works only because system slicers mark them as R_C)
 * - ModelRelMerge merges mappings with different type, it should be fixed. (Implications for slicing?)
 *   -> There can be multiple mappings to the same model element, i.e. Annotate must use ordering to pick only one
 * - Some slice rules are dependent on the crit element being of a certain type. (Need to carry that info)
 * - If this becomes a workflow again, it needs to reintroduce the input constraint from Slice, since it'll inherit from WorkflowOperatorImpl instead.
 * - The 3 subslicers are peculiar in that they don't pass all the crit inputs in the outputs. (Do they? Should they?)
 * - We should check for alreadySliced/Visited for the input of getDirectlySlicedElements, isn't it?
 *   -> It would prevent dual mappings, notably on criteria elements. But it's already prevented on normal elements, why are criteria special?
 *   -> Ok, we should check those too, but all checks should consider the existing SliceType too, and proceed with a dual mapping if necessary!
 *   -> Maybe add an api to do it within the main method, without having to overload it? Could be called "preconditions" and serve the initial type purpose too.
 *
 *   IDEA to make rule-based slicing easier: let each rules execute on a fresh alreadySliced
 *   -> we may slice an element more than once (so for multiple reasons, but it's ok, annotate handles it)
 */
public class GSNSlice extends Slice {

  // Determines whether a change impact is propagated up or not given the
  // source impacted element and a set of other impacted elements.
  public static boolean isSupported(Supportable elem, Set<EObject> alreadySliced) {
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
        if (isSupported((SupportConnector) target, alreadySliced)) {
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
}
