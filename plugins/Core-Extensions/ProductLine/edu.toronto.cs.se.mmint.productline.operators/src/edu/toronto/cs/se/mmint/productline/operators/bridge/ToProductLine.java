/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.operators.bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;

public class ToProductLine extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter();
  public final static OperatorParameter OUT0 = new OperatorParameter();
  static {
    ToProductLine.IN0.name = "product";
    ToProductLine.IN0.type = MMINTConstants.ROOT_MODEL_URI;
    ToProductLine.OUT0.name = "productLine";
    ToProductLine.OUT0.type = PLPackage.eNS_URI;
  }
  public final static IJavaOperatorConstraint CONSTRAINT = new IJavaOperatorConstraint() {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      if (MIDTypeHierarchy.instanceOf(inputsByName.get(ToProductLine.IN0.name), ToProductLine.OUT0.type, false)) {
        return false;
      }
      return true;
    }
  };

  public final static String PROP_REASONERNAME = "reasonerName";
  protected IPLFeaturesTrait reasoner;
  public final static String PROP_PRESENCECONDITION = "presenceCondition";
  protected String presenceCondition;

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    var reasonerName =
      MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, ToProductLine.PROP_REASONERNAME, null);
    this.reasoner = (reasonerName == null) ?
      MIDDialogs.selectReasoner(IPLFeaturesTrait.class, "Product Line features", null) :
      (IPLFeaturesTrait) MMINT.getReasoner(reasonerName);
    this.presenceCondition =
      MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, ToProductLine.PROP_PRESENCECONDITION, null);
    if (this.presenceCondition == null) {
      this.presenceCondition =
        MIDDialogs.getStringInput("Convert to Product Line",
                                  "Insert the presence condition to annotate all model elements with",
                                  this.reasoner.getTrueLiteral());
    }
  }

  protected void addPLClass(Class plClass, String plClassesKey, String presenceCondition, EClass plType,
                            Map<String, Class> plClasses) {
    plClass.setPresenceCondition(presenceCondition);
    plClass.setType(plType);
    ((ProductLine) ToProductLine.OUT0.root).getClasses().add(plClass);
    plClasses.put(plClassesKey, plClass);
  }

  protected void addPLClass(Class plClass, EObject modelObj, EClass plType, Map<String, Class> plClasses) {
    addPLClass(plClass, MIDRegistry.getModelElementUri(modelObj), this.presenceCondition, plType, plClasses);
  }

  protected Class createPLClass(EObject modelObj, EClass plType, Map<String, Class> plClasses) {
    var plClass = PLFactory.eINSTANCE.createClass();
    addPLClass(plClass, modelObj, plType, plClasses);

    return plClass;
  }

  private void createPLClassAndAttributes(EObject pModelObj, Map<String, Class> plClasses) {
    var plType = pModelObj.eClass();
    var plClass = createPLClass(pModelObj, plType, plClasses);
    for (var pAttribute : plType.getEAllAttributes()) {
      if (pAttribute.isDerived() || pAttribute.isTransient()) {
        continue;
      }
      var plValue = pModelObj.eGet(pAttribute);
      if (plValue == null) {
        continue;
      }
      plClass.addAttribute(pAttribute, plValue.toString());
    }
  }

  private void createPLReferences(EObject pModelObj, Map<String, Class> plClasses, Set<EReference> pOpposites) {
    for (var pReference : pModelObj.eClass().getEAllReferences()) {
      if (pReference.isDerived() || pReference.isTransient() || pOpposites.contains(pReference)) {
        continue;
      }
      var pOpposite = pReference.getEOpposite();
      if (pOpposite != null) {
        pOpposites.add(pOpposite);
      }
      var pTarget = pModelObj.eGet(pReference);
      var plTargets = new ArrayList<Class>();
      if (pTarget instanceof EList pTargetList) {
        if (pTargetList.isEmpty()) {
          continue;
        }
        pTargetList.forEach(t -> plTargets.add(plClasses.get(MIDRegistry.getModelElementUri((EObject) t))));
      }
      else {
        if (pTarget == null) {
          continue;
        }
        plTargets.add(plClasses.get(MIDRegistry.getModelElementUri((EObject) pTarget)));
      }
      var plSource = plClasses.get(MIDRegistry.getModelElementUri(pModelObj));
      for (var plTarget : plTargets) {
        plSource.addReference(pReference, plTarget, this.presenceCondition);
      }
    }
  }

  protected void toProductLine(Map<String, Model> inputsByName) throws Exception {
    var productModel = inputsByName.get(ToProductLine.IN0.name);
    ToProductLine.IN0.root = productModel.getEMFInstanceRoot();
    var productLine = PLFactory.eINSTANCE.createProductLine();
    productLine.setMetamodel(productModel.getMetatype().getEMFTypeRoot());
    productLine.setReasonerName(this.reasoner.getName());
    ToProductLine.OUT0.root = productLine;

    var plClasses = new HashMap<String, Class>();
    createPLClassAndAttributes(ToProductLine.IN0.root, plClasses);
    // pass 1: classes and attributes
    for (var iter = ToProductLine.IN0.root.eAllContents(); iter.hasNext();) {
      createPLClassAndAttributes(iter.next(), plClasses);
    }
    // pass 2: references
    var pOpposites = new HashSet<EReference>();
    createPLReferences(ToProductLine.IN0.root, plClasses, pOpposites);
    for (var iter = ToProductLine.IN0.root.eAllContents(); iter.hasNext();) {
      createPLReferences(iter.next(), plClasses, pOpposites);
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    toProductLine(inputsByName);
    var out0 = OperatorParameter.outFromIn(this, "OUT0", "IN0", inputsByName, outputMIDsByName);

    return Map.of(ToProductLine.OUT0.name, out0);
  }
}
