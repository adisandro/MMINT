/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.operators.lift;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.kotlin.operators.merge.EntryKt;
import edu.toronto.cs.se.mmint.kotlin.structs.Object;
import edu.toronto.cs.se.mmint.kotlin.structs.Tree;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.operator.merge.Merge;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.kotlin.PLKotlinConverter;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;
import edu.toronto.cs.se.mmint.productline.reasoning.PLPipeline;

@PLPipeline.Intercept
public class PLMerge extends Merge {
  private IPLFeaturesTrait reasoner;
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

  @Override
  @PLPipeline.Modify
  protected void mergeAttribute(String attributeName, EObject modelObj, EObject mergedModelObj)
                               throws MMINTException {
    switch (attributeName) {
      case "featuresConstraint", "reasonerName" -> {}
      case "presenceCondition" -> {
        var pc1 = (String) FileUtils.getModelObjectFeature(modelObj, attributeName);
        var pc2 = (String) FileUtils.getModelObjectFeature(mergedModelObj, attributeName);
        var mergedPc = this.reasoner.simplify(this.pcMergeSyntax.replace("$1", pc1).replace("$2", pc2));
        FileUtils.setModelObjectFeature(mergedModelObj, attributeName, mergedPc);
      }
      default -> super.mergeAttribute(attributeName, modelObj, mergedModelObj);
    }
    /**TODO MMINT[PL]
     *  1) input constraint check for compatible overlap types (merge based on eclasses, pl based on type ref)
     *  2) modify ToProductLine to ask for presence condition to be applied to all elements
     *  3) modify PLMerge to ask for feature being merged
     *  4) check compatibility of changes with SPLC
     */
  }

  @Override
  @PLPipeline.Modify
  protected void copyAttribute(String attributeName, EObject modelObj, EObject mergedModelObj)
                               throws MMINTException {
    switch (attributeName) {
      case "presenceCondition" -> {
        var copiedPc = (String) FileUtils.getModelObjectFeature(modelObj, attributeName);
        FileUtils.setModelObjectFeature(mergedModelObj, attributeName, copiedPc);
      }
      default -> super.copyAttribute(attributeName, modelObj, mergedModelObj);
    }
  }

  @Override
  protected String kMergeDebugCall() {
    return "  val reasoner = object: ISATReasoner {\n" +
           "    override fun getName(): String { return \"\" }\n" +
           "    override fun getTrueLiteral(): String { return \"\" }\n" +
           "    override fun getFalseLiteral(): String { return \"\" }\n" +
           "    override fun getANDSyntax(): String { return \"\" }\n" +
           "    override fun getORSyntax(): String {return \"($1) | ($2)\"}\n" +
           "  }\n" +
           "  val merged = mergePL(create" + this.in.model1.getName() + "(), create" + this.in.model2.getName() +
              "(), overlap, reasoner)\n" +
           "}\n";
  }

  @Override
  @PLPipeline.Modify
  protected Tree<? extends Object> kMerge(Tree<Object> kModel1, Tree<Object> kModel2, Map<String, String> overlap) {
    return EntryKt.mergePL(kModel1, kModel2, overlap, this.reasoner);
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    if (this.engine.equals("kotlin")) {
      this.kConverter = new PLKotlinConverter();
    }
    this.reasoner = ((ProductLine) this.in.model1.getEMFInstanceRoot()).getReasoner();
    this.pcMergeSyntax = this.reasoner.getORSyntax();
  }
}
