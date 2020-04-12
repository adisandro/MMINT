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

import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;

public class GSNSliceState extends Slice {

  /**
   * Assure18 rules: C1, C2, V2.1
   * Visit supported (parent) elements, slice goals only.
   */
  private SliceStep ruleSupports(Supporter modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(SliceType.RECHECK_STATE, modelObj, "supports");

    var supportedStream = modelObj.getSupports().stream()
      .map(SupportedBy::getSource)
      .filter(v -> !this.allVisited.containsKey(v))
      .filter(v -> GSNSlice.isSupported(v, this.allSliced.keySet()));
    var visited = supportedStream
      .collect(Collectors.toMap(v -> (EObject) v, v -> newInfo, SliceInfo.ORDER_DUPLICATES));
    var sliced = supportedStream
      .filter(s -> s instanceof Goal)
      .collect(Collectors.toMap(s -> (EObject) s, s -> newInfo, SliceInfo.ORDER_DUPLICATES));

    return new SliceStep(sliced, visited);
  }

  /**
   * This slicer follows a rule-based approach, rather than element-based.
   * (and it has a filter on initial allowed types from the criterion)
   */
  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    SliceStep sliceStep;

    if (info.prevObj == null) {
      // criterion object
      if (modelObj instanceof Goal) {
        sliceStep = ruleSupports((Goal) modelObj, info);
      }
      else if (modelObj instanceof Solution) {
        sliceStep = ruleSupports((Solution) modelObj, info);
      }
      else if (modelObj instanceof Strategy && (info.type == SliceType.DEL || info.type == SliceType.REVISE)) {
        sliceStep = ruleSupports((Strategy) modelObj, info);
      }
      else {
        sliceStep = new SliceStep();
      }
    }
    else {
      // recursive slice from this operator
      sliceStep = switch (info.rule) {
        case "supports" -> ruleSupports((Supportable) modelObj, info);
        default -> new SliceStep();
      };
    }

    return sliceStep;
  }
}
