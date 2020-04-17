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
 * - If this becomes a workflow again, it needs to reintroduce the input constraint from Slice, since it'll inherit from WorkflowOperatorImpl instead.
 *   -> Also, how would the poly engine choose this over the two sub-slicers? They all have the same signature.
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
