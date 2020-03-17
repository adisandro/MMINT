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

import edu.toronto.cs.se.modelepedia.safetycase.Strategy;

public class GSNSliceRevise2State extends GSNSlice {

  @Override
  protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {
    var impacted = new HashSet<EObject>();

    // If input is a strategy, then the state validity should be rechecked for all ancestor goals.
    if (modelObj instanceof Strategy) {
      var s = (Strategy) modelObj;
      impacted.addAll(getAncestorGoals(s, alreadyImpacted));
    }

    impacted.removeAll(alreadyImpacted);
    return impacted;
  }
}
