/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.productline.operators;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.merge.Merge;

public class PLMerge extends Merge {

  @Override
  protected void mergeAttribute(String attributeName, EObject modelObj, EObject mergedModelObj, String separator)
                               throws MMINTException {
    switch (attributeName) {
      case "featuresConstraint", "reasonerName" ->
        FileUtils.setModelObjectFeature(mergedModelObj, attributeName,
                                        FileUtils.getModelObjectFeature(modelObj, attributeName));
      //TODO get reasoner name and then ask for the OR syntax
      case "presenceCondition" -> super.mergeAttribute(attributeName, modelObj, mergedModelObj, " || ");
      default -> super.mergeAttribute(attributeName, modelObj, mergedModelObj, Merge.MERGE_SEPARATOR);
    };
    //TODO add checks for compatible types: in original Merge based on eclasses, here based on type ref
  }
}
