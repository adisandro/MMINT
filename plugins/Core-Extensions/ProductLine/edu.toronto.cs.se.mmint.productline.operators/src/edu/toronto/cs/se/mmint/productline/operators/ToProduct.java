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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeatureConstraintTrait;

public class ToProduct extends OperatorImpl {
  private In in;
  private Out out;
  private IProductLineFeatureConstraintTrait featureReasoner;
  private Map<String, Boolean> allFeatureValues;
  private Map<String, Boolean> presenceConditionCache;

  private static class In {
    public final static String MODEL = "productLine";
    public Model plModel;
    public ProductLine pl;

    public In(Map<String, Model> inputsByName) {
      this.plModel = inputsByName.get(In.MODEL);
      this.pl = (ProductLine) this.plModel.getEMFInstanceRoot();
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                 Map<String, Model> inputsByName,
                                                                 Map<String, Model> outputsByName) {
      var plModel = inputsByName.get(In.MODEL);
      var productModel = outputsByName.get(Out.MODEL);
      var traceRel = (ModelRel) outputsByName.get(Out.MODELREL);

      return Map.of(traceRel, List.of(plModel, productModel));
    }
  }

  private static class Out {
    public final static String MODEL = "product";
    public final static String MODELREL = "trace";
    public In in;
    public Model productModelType;
    public String productPath;
    public MID productMID;
    public MID traceMID;
    public EObject product;
    public Map<Class, EObject> traceLinks;

    public Out(Map<String, MID> outputMIDsByName, String workingPath, In in) {
      this.in = in;
      this.productModelType = MIDTypeRegistry.<Model>getType(in.pl.getMetamodel().getNsURI());
      this.productPath = workingPath + IPath.SEPARATOR + in.plModel.getName() + "." +
                         this.productModelType.getFileExtension();
      this.productPath = FileUtils.getUniquePath(this.productPath, true, false);
      this.productMID = outputMIDsByName.get(Out.MODEL);
      this.traceMID = outputMIDsByName.get(Out.MODELREL);
      this.traceLinks = new LinkedHashMap<>();
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var productModel = this.productModelType.createInstanceAndEditor(this.product, this.productPath, this.productMID);
      var traceRel = MIDTypeHierarchy.getRootModelRelType()
        .createBinaryInstanceAndEndpoints(null, Out.MODELREL, this.in.plModel, productModel, this.traceMID);
      var tracePl = traceRel.getModelEndpointRefs().get(0);
      var traceProduct = traceRel.getModelEndpointRefs().get(1);
      var mappingType = MIDTypeHierarchy.getRootMappingType();
      for (var traceLink : this.traceLinks.entrySet()) {
        mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, ECollections.asEList(
          tracePl.createModelElementInstanceAndReference(traceLink.getKey(), null),
          traceProduct.createModelElementInstanceAndReference(traceLink.getValue(), null)));
      }

      return Map.of(Out.MODEL, productModel, Out.MODELREL, traceRel);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new In(inputsByName);
    this.out = new Out(outputMIDsByName, getWorkingPath(), this.in);
    this.featureReasoner = this.in.pl.getReasoner();
    this.allFeatureValues = new HashMap<>();
    this.presenceConditionCache = new HashMap<>();
  }

  private boolean canInstantiateFeatures(String plFormula) {
    var features = this.featureReasoner.getFeatures(plFormula);
    if (features.isEmpty()) {
      return true;
    }

    var featureValues = new HashMap<String, Boolean>();
    features.forEach(feature -> {
      var value = this.allFeatureValues.computeIfAbsent(
        feature, k -> MIDDialogs.getBooleanInput("Feature '" + k + "'", "Enable feature '" + k + "'?"));
      featureValues.put(feature, value);
    });

    return this.presenceConditionCache.computeIfAbsent(
      plFormula, k -> this.featureReasoner.checkConsistency(k, featureValues));
  }

  private boolean isInProduct(PLElement plElement) {
    var presenceCondition = plElement.getPresenceCondition();
    if (presenceCondition == null) {
      return true;
    }
    return canInstantiateFeatures(presenceCondition);
  }

  private void toProduct() throws MMINTException {
    if (!canInstantiateFeatures(this.in.pl.getFeaturesConstraint())) {
      throw new MMINTException("The constraint on features is not satisfiable");
    }
    var productFactory = this.in.pl.getMetamodel().getEFactoryInstance();
    for (var plClass : this.in.pl.getClasses()) {
      if (!isInProduct(plClass)) {
        continue;
      }
      var productModelObj = productFactory.create(plClass.getType());
      this.out.traceLinks.put(plClass, productModelObj);
      if (this.out.product == null) {
        this.out.product = productModelObj;
      }
      for (var plAttribute : plClass.getAttributes()) {
        if (!isInProduct(plAttribute)) {
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
    for (var plReference : this.in.pl.getReferences()) {
      if (!isInProduct(plReference)) {
        continue;
      }
      var srcProductModelObj = this.out.traceLinks.get(plReference.getSource());
      if (srcProductModelObj == null) {
        continue;
      }
      for (var target : plReference.getTargets()) {
        var tgtProductModelObj = this.out.traceLinks.get(target);
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

    return this.out.packed();
  }

}
