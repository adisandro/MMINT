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

import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;

public class GSNSliceRecheck extends GSNSlice {

  @Override
  protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {
    var impacted = new HashSet<EObject>();

    // If input is a goal, then the state validity of all ancestor goals should be rechecked.
    if (modelObj instanceof Goal) {
      var g = (Goal) modelObj;
      impacted.addAll(getAncestorGoals(g, alreadyImpacted));
    }

    // If input is a solution, then the state validity of all ancestor goals should be rechecked.
    if (modelObj instanceof Solution) {
      var s = (Solution) modelObj;
      impacted.addAll(getAncestorGoals(s, alreadyImpacted));
    }

    impacted.removeAll(alreadyImpacted);
    return impacted;
  }
}
