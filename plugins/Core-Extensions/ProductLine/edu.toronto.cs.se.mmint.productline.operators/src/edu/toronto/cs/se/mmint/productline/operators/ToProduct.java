/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.viatra.reasoning.ProductLineViatraReasoner;
import edu.toronto.cs.se.modelepedia.z3.Z3Solver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

public class ToProduct extends OperatorImpl {
  private Input input;
  private Output output;
  private Z3Solver solver;
  private Map<String, Boolean> solverCache;

  private static class Input {
    public final static String MODEL = "productLine";
    public Model plModel;
    public ProductLine pl;

    public Input(Map<String, Model> inputsByName) {
      this.plModel = inputsByName.get(Input.MODEL);
      this.pl = (ProductLine) this.plModel.getEMFInstanceRoot();
    }
  }

  private static class Output {
    public final static String MODEL = "product";
    public Model productModelType;
    public EObject product;
    public String productPath;
    public MID mid;

    public Output(Map<String, MID> outputMIDsByName, String workingPath, Input input) {
      this.productModelType = MIDTypeRegistry.<Model>getType(input.pl.getMetamodel().getNsURI());
      this.productPath = workingPath + IPath.SEPARATOR + input.plModel.getName() + "." +
                         this.productModelType.getFileExtension();
      this.productPath = FileUtils.getUniquePath(this.productPath, true, false);
      this.mid = outputMIDsByName.get(Output.MODEL);
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var plModel = this.productModelType.createInstanceAndEditor(this.product, this.productPath, this.mid);

      return Map.of(Output.MODEL, plModel);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName, getWorkingPath(), this.input);
    this.solver = new Z3Solver();
    this.solverCache = new HashMap<>();
  }

  private boolean isInProduct(PLElement plElement, Map<String, Boolean> varsValues) {
    var presenceCondition = plElement.getPresenceCondition();
    if (presenceCondition == null) {
      return true;
    }
    return isInProduct(presenceCondition, varsValues);
  }

  private boolean isInProduct(String presenceCondition, Map<String, Boolean> varsValues) {
    var variables = ProductLineViatraReasoner.getVariables(presenceCondition);
    if (variables.isEmpty()) {
      return true;
    }
    for (var variable : variables) {
      var value = varsValues.get(variable);
      if (value == null) {
        value = MIDDialogs.getBooleanInput("Variable '" + variable + "'",
                                           "Assign true to variable '" + variable + "'?");
        varsValues.put(variable, value);
      }
      presenceCondition = presenceCondition.replaceAll("\\b" + variable + "\\b", value.toString());
    }
    var result = this.solverCache.computeIfAbsent(presenceCondition,
                                                  k -> this.solver.checkSat(Z3Utils.assertion(k)).isSAT());

    return result;
  }

  private void toProduct() throws MMINTException {
    var varsValues = new HashMap<String, Boolean>();
    if (!isInProduct(this.input.pl.getFeatures(), varsValues)) {
      throw new MMINTException("The boolean formula for features is not satisfiable");
    }
    var productModelObjs = new HashMap<Class, EObject>();
    var productFactory = this.input.pl.getMetamodel().getEFactoryInstance();
    for (var plClass : this.input.pl.getClasses()) {
      if (!isInProduct(plClass, varsValues)) {
        continue;
      }
      var productModelObj = productFactory.create(plClass.getType());
      productModelObjs.put(plClass, productModelObj);
      if (this.output.product == null) {
        this.output.product = productModelObj;
      }
      for (var plAttribute : plClass.getAttributes()) {
        if (!isInProduct(plAttribute, varsValues)) {
          continue;
        }
        var emfType = plAttribute.getType().getEAttributeType();
        Object value;
        if (emfType instanceof EEnum) {
          value = emfType.getEPackage().getEFactoryInstance().createFromString(emfType, plAttribute.getValue());
        }
        else {
          value = switch(emfType.getName()) {
            case "EInt"    -> Integer.parseInt(plAttribute.getValue());
            case "EFloat"  -> Float.parseFloat(plAttribute.getValue());
            case "EDouble" -> Double.parseDouble(plAttribute.getValue());
            case "EString" -> plAttribute.getValue();
            default        -> plAttribute.getValue();
          };
        }
        FileUtils.setModelObjectFeature(productModelObj, plAttribute.getType().getName(), value);
      }
    }
    for (var plReference : this.input.pl.getReferences()) {
      if (!isInProduct(plReference, varsValues)) {
        continue;
      }
      var srcProductModelObj = productModelObjs.get(plReference.getSource());
      if (srcProductModelObj == null) {
        continue;
      }
      for (var target : plReference.getTargets()) {
        var tgtProductModelObj = productModelObjs.get(target);
        if (tgtProductModelObj == null) {
          continue;
        }
        FileUtils.setModelObjectFeature(srcProductModelObj, plReference.getType().getName(), tgtProductModelObj);
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProduct();

    return this.output.packed();
  }

}
