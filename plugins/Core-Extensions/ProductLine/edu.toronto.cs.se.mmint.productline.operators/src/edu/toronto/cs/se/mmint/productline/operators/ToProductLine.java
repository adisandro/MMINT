/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.Reference;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;

public class ToProductLine extends OperatorImpl {
  protected In in;
  protected Out out;
  protected @Nullable String reasonerName;

  public static class In {
    public final static String PROP_REASONERNAME = "reasonerName";
    public final static String MODEL = "product";
    public IPLFeaturesTrait reasoner;
    public Model productModel;

    public In(Map<String, Model> inputsByName) {
      this.productModel = inputsByName.get(In.MODEL);
      if (MIDTypeHierarchy.instanceOf(this.productModel, Out.MODEL_TYPE_ID, false)) {
        throw new IllegalArgumentException();
      }
    }

    public In(Map<String, Model> inputsByName, @Nullable String reasonerName) {
      this(inputsByName);
      try {
        this.reasoner = (reasonerName == null) ?
          MIDDialogs.selectReasoner(IPLFeaturesTrait.class, "Product Line features", null) :
          (IPLFeaturesTrait) MMINT.getReasoner(reasonerName);
      }
      catch (Exception e) {
        throw new IllegalArgumentException();
      }
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new In(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  protected static class Out {
    public static final String MODEL_TYPE_ID = "model://edu.toronto.cs.se.mmint.productline";
    public final static String MODEL = "productLine";
    public Model plModelType;
    public ProductLine productLine;
    public String trueLiteral;
    public String plPath;
    public MID mid;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      this.plModelType = MIDTypeRegistry.<Model>getType(Out.MODEL_TYPE_ID);
      this.trueLiteral = in.reasoner.getTrueLiteral();
      this.productLine = PLFactory.eINSTANCE.createProductLine();
      this.productLine.setMetamodel(in.productModel.getMetatype().getEMFTypeRoot());
      this.productLine.setReasonerName(in.reasoner.getName());
      this.plPath = workingPath + IPath.SEPARATOR + in.productModel.getName() + "." +
                    this.plModelType.getFileExtension();
      this.mid = outputMIDsByName.get(Out.MODEL);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var plModel = this.plModelType.createInstanceAndEditor(this.productLine, this.plPath, this.mid);

      return Map.of(Out.MODEL, plModel);
    }
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.reasonerName = MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, In.PROP_REASONERNAME, null);
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.in = new In(inputsByName, this.reasonerName);
    this.out = new Out(outputMIDsByName, getWorkingPath(), this.in);
  }

  protected void addPLClass(Class plClass, EObject modelObj, EClass plType, Map<String, Class> plClasses) {
    plClass.setPresenceCondition(this.out.trueLiteral);
    plClass.setType(plType);
    this.out.productLine.getClasses().add(plClass);
    plClasses.put(MIDRegistry.getModelElementUri(modelObj), plClass);
  }

  protected Class createPLClass(EObject modelObj, EClass plType, Map<String, Class> plClasses) {
    var plClass = PLFactory.eINSTANCE.createClass();
    addPLClass(plClass, modelObj, plType, plClasses);

    return plClass;
  }

  protected Attribute createPLAttribute(EAttribute plType, String plValue, Class plClass) {
    var plAttribute = PLFactory.eINSTANCE.createAttribute();
    plAttribute.setPresenceCondition(this.out.trueLiteral);
    plAttribute.setType(plType);
    plAttribute.setValue(plValue);
    plClass.getAttributes().add(plAttribute);

    return plAttribute;
  }

  protected Reference createPLReference(EReference plType, Class plSrc, Class plTgt) {
    var plReference = PLFactory.eINSTANCE.createReference();
    plReference.setPresenceCondition(this.out.trueLiteral);
    plReference.setType(plType);
    plReference.setTarget(plTgt);
    plSrc.getReferences().add(plReference);

    return plReference;
  }

  private void createPLClassAndAttributes(EObject pModelObj, Map<String, Class> plClasses) {
    var plType = pModelObj.eClass();
    var plClass = createPLClass(pModelObj, plType, plClasses);
    for (var pAttribute : plType.getEAllAttributes()) {
      var plValue = pModelObj.eGet(pAttribute);
      if (plValue == null) {
        continue;
      }
      createPLAttribute(pAttribute, plValue.toString(), plClass);
    }
  }

  private void createPLReferences(EObject pModelObj, Map<String, Class> plClasses, Set<EReference> pOpposites) {
    for (var pReference : pModelObj.eClass().getEAllReferences()) {
      if (pOpposites.contains(pReference)) {
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
        createPLReference(pReference, plSource, plTarget);
      }
    }
  }

  protected void toProductLine() {
    var product = this.in.productModel.getEMFInstanceRoot();
    var plClasses = new HashMap<String, Class>();
    createPLClassAndAttributes(product, plClasses);
    // pass 1: classes and attributes
    for (var iter = product.eAllContents(); iter.hasNext();) {
      createPLClassAndAttributes(iter.next(), plClasses);
    }
    // pass 2: references
    var pOpposites = new HashSet<EReference>();
    createPLReferences(product, plClasses, pOpposites);
    for (var iter = product.eAllContents(); iter.hasNext();) {
      createPLReferences(iter.next(), plClasses, pOpposites);
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProductLine();

    return this.out.packed();
  }
}
