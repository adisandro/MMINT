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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.operator.merge.Merge;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait;
import edu.toronto.cs.se.mmint.productline.reasoning.PLPipeline;

public class PLMerge extends Merge {
  private IProductLineFeaturesTrait reasoner;
  private String pcMergeSyntax;

  @Override
  @PLPipeline.Modify
  protected Map<String, String> getOverlapModelElementUris() {
    var overlapUris = super.getOverlapModelElementUris();
    // explicitly add product roots (assuming they're the first class created in the PL)
    var pRootClass1 = ((ProductLine) this.in.model1.getEMFInstanceRoot()).getClasses().get(0);
    var pRootClass2 = ((ProductLine) this.in.model2.getEMFInstanceRoot()).getClasses().get(0);
    if (pRootClass1.getType() == pRootClass2.getType()) {
      overlapUris.put(MIDRegistry.getModelElementUri(pRootClass1), MIDRegistry.getModelElementUri(pRootClass2));
    }
    // for each PL class, automatically merge its attributes and incoming references
    // that allows the input overlap rel to be structurally identical to a product merge
    for (var overlapEntry : Set.copyOf(overlapUris.entrySet())) {
      EObject modelObj1, modelObj2;
      try {
        modelObj1 = FileUtils.readModelObject(overlapEntry.getKey(), this.in.model1.getEMFInstanceResource());
        modelObj2 = FileUtils.readModelObject(overlapEntry.getValue(), this.in.model2.getEMFInstanceResource());
      }
      catch (Exception e) {
        continue;
      }
      if (modelObj1 instanceof Class plClass1 && modelObj2 instanceof Class plClass2) {
        for (var plAttr1 : plClass1.getAttributes()) {
          for (var plAttr2 : plClass2.getAttributes()) {
            if (plAttr1.getType() != plAttr2.getType()) {
              continue;
            }
            overlapUris.put(MIDRegistry.getModelElementUri(plAttr1), MIDRegistry.getModelElementUri(plAttr2));
          }
        }
        for (var plRef1 : plClass1.getReferencesAsTarget()) {
          for (var plRef2 : plClass2.getReferencesAsTarget()) {
            if (plRef1.getType() != plRef2.getType()) {
              continue;
            }
            overlapUris.put(MIDRegistry.getModelElementUri(plRef1), MIDRegistry.getModelElementUri(plRef2));
          }
        }
      }
    }

    return overlapUris;
  }

  private @Nullable String mergePresenceConditions(@Nullable String pc1, @Nullable String pc2) {
    String mergedPc;
    if (pc1 == null || pc1.equals("true")) {
      mergedPc = pc2;
    }
    else if (pc2 == null || pc1.equals(pc2) || pc2.equals("true")) {
      mergedPc = pc1;
    }
    else {
      mergedPc = this.pcMergeSyntax.replace("$1", pc2).replace("$2", pc1);
    }

    return mergedPc;
  }

  @Override
  @PLPipeline.Modify
  protected void mergeAttribute(String attributeName, EObject modelObj, EObject mergedModelObj, String syntax)
                               throws MMINTException {
    switch (attributeName) {
      case "featuresConstraint", "reasonerName" ->
        FileUtils.setModelObjectFeature(mergedModelObj, attributeName,
                                        FileUtils.getModelObjectFeature(modelObj, attributeName));
      case "presenceCondition" -> {
        var pc1 = (String) FileUtils.getModelObjectFeature(modelObj, attributeName);
        var pc2 = (String) FileUtils.getModelObjectFeature(mergedModelObj, attributeName);
        FileUtils.setModelObjectFeature(mergedModelObj, attributeName, mergePresenceConditions(pc1, pc2));
      }
      default -> super.mergeAttribute(attributeName, modelObj, mergedModelObj, Merge.ATTR_MERGE_SYNTAX);
    }
    //TODO Add checks for compatible types and refs or rely on match correctness?
    //TODO (in original Merge based on eclasses, here based on type ref)
    //TODO Handle returning external references from Kotlin
  }

  @Override
  @PLPipeline.Intercept
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    this.reasoner = ((ProductLine) this.in.model1.getEMFInstanceRoot()).getReasoner();
    this.pcMergeSyntax = this.reasoner.getORSyntax();
  }
}
