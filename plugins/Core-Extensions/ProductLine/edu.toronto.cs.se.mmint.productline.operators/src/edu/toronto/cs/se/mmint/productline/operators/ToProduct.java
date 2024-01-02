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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait;

public class ToProduct extends RandomOperatorImpl {
  protected In in;
  protected Out out;
  protected IProductLineFeaturesTrait featureReasoner;
  protected Map<String, Boolean> allFeatureValues;
  protected Map<String, Boolean> presenceConditionCache;
  protected Boolean userAssigned;

  public static class In {
    public final static String PROP_USERASSIGNED = "userAssigned";
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

  public static class Out {
    public final static String MODEL = "product";
    public final static String MODELREL = "trace";
    public final static String PRODUCT_SUFFIX = "_prod";
    public ToProduct operator;
    public MID productMID;
    public MID traceMID;
    public EObject product;
    public Map<Class, EObject> traceLinks;

    public Out(ToProduct operator, Map<String, MID> outputMIDsByName) {
      this.operator = operator;
      this.productMID = outputMIDsByName.get(Out.MODEL);
      this.traceMID = outputMIDsByName.get(Out.MODELREL);
      this.traceLinks = new LinkedHashMap<>();
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var productModelType = MIDTypeRegistry.<Model>getType(this.operator.in.pl.getMetamodel().getNsURI());
      var productPath = this.operator.getWorkingPath() + IPath.SEPARATOR + this.operator.in.plModel.getName() +
                        Out.PRODUCT_SUFFIX + MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR +
                        productModelType.getFileExtension();
      productPath = FileUtils.getUniquePath(productPath, true, false);
      var productModel = productModelType.createInstanceAndEditor(this.product, productPath, this.productMID);
      var traceRel = MIDTypeHierarchy.getRootModelRelType()
        .createBinaryInstanceAndEndpoints(null, Out.MODELREL, this.operator.in.plModel, productModel, this.traceMID);
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

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.userAssigned = MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, In.PROP_USERASSIGNED, null);
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new In(inputsByName);
    this.out = new Out(this, outputMIDsByName);
    this.featureReasoner = this.in.pl.getReasoner();
    this.allFeatureValues = new HashMap<>();
    this.presenceConditionCache = new HashMap<>();
  }

  private boolean canInstantiateFeatures(@Nullable String plFormula) {
    if (plFormula == null) {
      return true;
    }
    var features = this.featureReasoner.getFeatures(plFormula);
    if (features.isEmpty()) {
      return true;
    }
    if (this.userAssigned == null) {
      this.userAssigned = MIDDialogs.getBooleanInput("Create product", "Do you want to manually assign features?");
    }
    if (this.presenceConditionCache.containsKey(plFormula)) {
      return this.presenceConditionCache.get(plFormula);
    }

    boolean canInstantiate;
    if (this.userAssigned) {
      var featureValues = new HashMap<String, Boolean>();
      features.forEach(feature -> {
        var value = this.allFeatureValues.computeIfAbsent(
          feature, k -> MIDDialogs.getBooleanInput("Create product", "Enable feature '" + k + "'?"));
        featureValues.put(feature, value);
      });
      canInstantiate = this.featureReasoner.checkConsistency(plFormula, featureValues);
    }
    else {
      var featureValues = features.stream()
        .filter(this.allFeatureValues::containsKey)
        .collect(Collectors.toMap(Function.identity(), this.allFeatureValues::get));
      var newFeatureValues = this.featureReasoner.assignFeatures(plFormula, featureValues, getState());
      canInstantiate = (newFeatureValues.isEmpty()) ? false : true;
      newFeatureValues.ifPresent(vv -> this.allFeatureValues.putAll(vv));
    }
    this.presenceConditionCache.put(plFormula, canInstantiate);

    return canInstantiate;
  }

  private boolean canInstantiateFeatures(ProductLine pl) {
    return canInstantiateFeatures(pl.getFeaturesConstraint());
  }

  private boolean canInstantiateFeatures(PLElement plElement) {
    return canInstantiateFeatures(plElement.getPresenceCondition());
  }

  protected EObject toProduct(ProductLine pl, Map<Class, EObject> traceLinks) throws MMINTException {
    if (!canInstantiateFeatures(pl)) {
      throw new MMINTException("The constraint on features is not satisfiable");
    }

    EObject product = null;
    var productFactory = pl.getMetamodel().getEFactoryInstance();
    for (var plClass : pl.getClasses()) {
      if (!canInstantiateFeatures(plClass)) {
        continue;
      }
      var productModelObj = productFactory.create(plClass.getType());
      traceLinks.put(plClass, productModelObj);
      if (product == null) {
        product = productModelObj;
      }
      for (var plAttribute : plClass.getAttributes()) {
        if (!canInstantiateFeatures(plAttribute)) {
          continue;
        }
        var value = FileUtils.convertStringToEType(plAttribute.getType(), plAttribute.getValue());
        FileUtils.setModelObjectFeature(productModelObj, plAttribute.getType(), value);
      }
    }
    for (var plClass : pl.getClasses()) {
      for (var plReference : plClass.getReferences()) {
        if (!canInstantiateFeatures(plReference)) {
          continue;
        }
        var srcProductModelObj = traceLinks.get(plClass);
        if (srcProductModelObj == null) {
          continue;
        }
        var tgtProductModelObj = traceLinks.get(plReference.getTarget());
        if (tgtProductModelObj == null) {
          continue;
        }
        FileUtils.setModelObjectFeature(srcProductModelObj, plReference.getType().getName(), tgtProductModelObj);
      }
    }

    return product;
  }

  protected void toProduct() throws MMINTException {
    this.out.product = toProduct(this.in.pl, this.out.traceLinks);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    toProduct();

    return this.out.packed();
  }
}
