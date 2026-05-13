/*******************************************************************************
 * Copyright (c) 2021, 2026 Alessio Di Sandro.
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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
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
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;

public class Derive extends RandomOperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("productLine", PLPackage.eNS_URI);
  public ProductLine productLine;
  public final static OperatorParameter OUT0 = new OperatorParameter("product", MMINTConstants.ROOT_MODEL_URI, null,
                                                                     "_prod");
  public EObject product;
  public final static OperatorParameter OUT1 = new OperatorParameter("trace", MMINTConstants.ROOT_MODELREL_URI);
  public ModelRel trace;
  public final static IJavaOperatorConstraint CONSTRAINT = new IJavaOperatorConstraint() {
    @Override
    public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                 Map<String, Model> inputsByName,
                                                                 Map<String, Model> outputsByName) {
      var plModel = inputsByName.get(Derive.IN0.name());
      var prodModel = outputsByName.get(Derive.OUT0.name());
      var traceRel = (ModelRel) outputsByName.get(Derive.OUT1.name());

      return Map.of(traceRel, List.of(plModel, prodModel));
    }
  };

  public final static String PROP_USERASSIGNED = "userAssigned";
  protected Optional<Boolean> userAssigned;
  protected IPLFeaturesTrait featureReasoner;
  protected Map<String, Boolean> allFeatureValues;
  protected Map<String, Boolean> presenceConditionCache;
  protected Map<Class, EObject> traceLinks;

  protected void init2(Properties inputProperties, ProductLine pl) throws MMINTException {
    this.userAssigned = MIDOperatorIOUtils.getOptBoolProp(inputProperties, Derive.PROP_USERASSIGNED);
    this.featureReasoner = pl.getReasoner();
    this.allFeatureValues = new HashMap<>();
    this.presenceConditionCache = new HashMap<>();
    this.traceLinks = new LinkedHashMap<>();
  }

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    this.productLine = (ProductLine) inputsByName.get(Derive.IN0.name()).getEMFInstanceRoot();
    this.product = null;
    init2(inputProperties, this.productLine);
  }

  private boolean canInstantiateFeatures(@Nullable String plFormula) {
    if (plFormula == null) {
      return true;
    }
    var features = this.featureReasoner.getFeatures(plFormula);
    if (features.isEmpty()) {
      return true;
    }
    if (this.userAssigned.isEmpty()) {
      this.userAssigned = Optional.of(
        MIDDialogs.getBooleanInput("Create product", "Do you want to manually assign features?"));
    }
    if (this.presenceConditionCache.containsKey(plFormula)) {
      return this.presenceConditionCache.get(plFormula);
    }

    boolean canInstantiate;
    if (this.userAssigned.get()) {
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

  protected void derive() throws MMINTException {
    if (!canInstantiateFeatures(this.productLine.getFeaturesConstraint())) {
      throw new MMINTException("The constraint on features is not satisfiable");
    }

    for (var plClass : this.productLine.getClasses()) {
      if (!canInstantiateFeatures(plClass.getPresenceCondition())) {
        continue;
      }
      var prodModelObj = plClass.getType().getEPackage().getEFactoryInstance().create(plClass.getType());
      this.traceLinks.put(plClass, prodModelObj);
      if (this.product == null) {
        this.product = prodModelObj;
      }
      for (var plAttribute : plClass.getAttributes()) {
        if (!canInstantiateFeatures(plAttribute.getPresenceCondition())) {
          continue;
        }
        var value = FileUtils.convertStringToEType(plAttribute.getType(), plAttribute.getValue());
        FileUtils.setModelObjectFeature(prodModelObj, plAttribute.getType(), value);
      }
    }
    for (var plClass : this.productLine.getClasses()) {
      for (var plReference : plClass.getReferences()) {
        if (!canInstantiateFeatures(plReference.getPresenceCondition())) {
          continue;
        }
        var srcProdModelObj = this.traceLinks.get(plClass);
        if (srcProdModelObj == null) {
          continue;
        }
        var tgtProdModelObj = this.traceLinks.get(plReference.getTarget());
        if (tgtProdModelObj == null) {
          continue;
        }
        FileUtils.setModelObjectFeature(srcProdModelObj, plReference.getType().getName(), tgtProdModelObj);
      }
    }
  }

  protected void trace() throws MMINTException {
    var tracePL = this.trace.getModelEndpointRefs().get(0);
    var traceProd = this.trace.getModelEndpointRefs().get(1);
    var mappingType = MIDTypeHierarchy.getRootMappingType();
    for (var traceLink : this.traceLinks.entrySet()) {
      mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, ECollections.asEList(
        tracePL.createModelElementInstanceAndReference(traceLink.getKey(), null),
        traceProd.createModelElementInstanceAndReference(traceLink.getValue(), null)));
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    var outputsByName = new HashMap<String, Model>();
    derive();
    outputsByName.putAll(outputFromInput(Derive.IN0, Derive.OUT0.specialize(this.productLine.getMetamodel().getNsURI()),
                                         inputsByName, outputMIDsByName));

    this.trace = MIDTypeRegistry.<ModelRel>getType(Derive.OUT1.type())
      .createBinaryInstanceAndEndpoints(null, Derive.OUT1.name(), inputsByName.get(Derive.IN0.name()),
                                        outputsByName.get(Derive.OUT0.name()),
                                        outputMIDsByName.get(Derive.OUT1.name()));
    outputsByName.put(Derive.OUT1.name(), this.trace);
    trace();

    return outputsByName;
  }
}
