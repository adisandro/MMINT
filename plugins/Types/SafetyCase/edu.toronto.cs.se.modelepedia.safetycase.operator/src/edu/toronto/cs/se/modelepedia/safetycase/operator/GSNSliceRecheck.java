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
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;

public class GSNSliceRecheck extends Slice {

  @Override
  protected Set<EObject> getDirectlySlicedElements(EObject modelObj, Set<EObject> alreadySliced) {
    var sliced = new HashSet<EObject>();

    if (modelObj instanceof Goal || modelObj instanceof Solution) {
      // slice all ancestor goals
      sliced.addAll(GSNUtils.getAncestorGoals((CoreElement) modelObj, alreadySliced));
    }

    sliced.removeAll(alreadySliced);
    return sliced;
  }
}
