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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.merge.Merge;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait;
import edu.toronto.cs.se.mmint.productline.reasoning.PLPipeline;

public class PLMerge extends Merge {
  private IProductLineFeaturesTrait reasoner;
  private String orSyntax;

  @Override
  @PLPipeline.Modify
  protected void mergeAttribute(String attributeName, EObject modelObj, EObject mergedModelObj, String syntax)
                               throws MMINTException {
    switch (attributeName) {
      case "featuresConstraint", "reasonerName" ->
        FileUtils.setModelObjectFeature(mergedModelObj, attributeName,
                                        FileUtils.getModelObjectFeature(modelObj, attributeName));
      case "presenceCondition" -> super.mergeAttribute(attributeName, modelObj, mergedModelObj, this.orSyntax);
      default -> super.mergeAttribute(attributeName, modelObj, mergedModelObj, Merge.MERGE_SEPARATOR);
    }
    //TODO Add checks for compatible types and refs or rely on match correctness?
    //TODO (in original Merge based on eclasses, here based on type ref)
    //TODO Attributes and References should not be duplicated: add more match entries vs make PLMerge more intelligent
    //TODO (Is it possible? What about a legit duplicate?)
    //TODO Handle returning external references from Kotlin
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    this.reasoner = ((ProductLine) this.in.model1.getEMFInstanceRoot()).getReasoner();
    this.orSyntax = this.reasoner.getORSyntax();
  }
}
