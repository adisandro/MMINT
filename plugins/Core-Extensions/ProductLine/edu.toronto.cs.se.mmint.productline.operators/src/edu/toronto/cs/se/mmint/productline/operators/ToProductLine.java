/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;

public class ToProductLine extends OperatorImpl {
  private Input input;
  private Output output;

  private static class Input {
    public final static String MODEL = "product";
    public Model productModel;

    public Input(Map<String, Model> inputsByName) {
      this.productModel = inputsByName.get(Input.MODEL);
      if (MIDTypeHierarchy.instanceOf(this.productModel, Output.MODEL_TYPE_ID, false)) {
        throw new IllegalArgumentException();
      }
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new Input(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  private static class Output {
    public static final String MODEL_TYPE_ID = "model://edu.toronto.cs.se.mmint.productline";
    public final static String MODEL = "productLine";
    public Model plModelType;
    public ProductLine productLine;
    public String plPath;
    public MID mid;

    public Output(Map<String, MID> outputMIDsByName, String workingPath, Input input) {
      this.plModelType = MIDTypeRegistry.<Model>getType(Output.MODEL_TYPE_ID);
      this.productLine = ProductLineFactory.eINSTANCE.createProductLine();
      this.plPath = workingPath + IPath.SEPARATOR + input.productModel.getName() + "." +
                    this.plModelType.getFileExtension();
      this.mid = outputMIDsByName.get(Output.MODEL);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var plModel = this.plModelType.createInstanceAndEditor(this.productLine, this.plPath, this.mid);

      return Map.of(Output.MODEL, plModel);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName, getWorkingPath(), this.input);
  }

  private void toProductLine() {
    var product = this.input.productModel.getEMFInstanceRoot();
    var plClasses = new HashMap<String, Class>();
    // pass 1: classes and attributes
    for (var iter = product.eAllContents(); iter.hasNext();) {
      var pModelObj = iter.next();
      var pType = pModelObj.eClass();
      var plClass = ProductLineFactory.eINSTANCE.createClass();
      plClass.setPresenceCondition("true");
      plClass.setType(pType);
      this.output.productLine.getClasses().add(plClass);
      plClasses.put(MIDRegistry.getModelElementUri(pModelObj), plClass);
      for (var pAttribute : pType.getEAllAttributes()) {
        var plValue = pModelObj.eGet(pAttribute);
        if (plValue == null) {
          continue;
        }
        var plAttribute = ProductLineFactory.eINSTANCE.createAttribute();
        plAttribute.setPresenceCondition("true");
        plAttribute.setType(pAttribute);
        plAttribute.setValue(plValue.toString());
        plClass.getAttributes().add(plAttribute);
      }
    }
    // pass 2: references
    var pOpposites = new HashSet<EReference>();
    for (var iter = product.eAllContents(); iter.hasNext();) {
      var pModelObj = iter.next();
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
          var plReference = ProductLineFactory.eINSTANCE.createReference();
          plReference.setPresenceCondition("true");
          plReference.setType(pReference);
          plReference.setSource(plSource);
          plReference.getTargets().add(plTarget);
          this.output.productLine.getReferences().add(plReference);
        }
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProductLine();

    return this.output.packed();
  }

}
