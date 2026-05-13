/*******************************************************************************
 * Copyright (c) 2023, 2026 Alessio Di Sandro.
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
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public class DeriveAll extends Derive { // inherits the code, but does not override the operator
  public final static OperatorParameter IN0 = new OperatorParameter("productLines", PLPackage.eNS_URI, 1, -1);
  public List<ProductLine> productLines;
  public final static OperatorParameter OUT0 = new OperatorParameter("products", MMINTConstants.ROOT_MODEL_URI, 1, -1,
                                                                     null, "_prod");
  public List<EObject> products;
  public final static IJavaOperatorConstraint CONSTRAINT = new IJavaOperatorConstraint() {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      String featuresConstraint = null;
      for (var plModel : MIDOperatorIOUtils.getVarargs(inputsByName, DeriveAll.IN0.name())) {
        if (plModel.isWorkflowsLevel()) {
          // there are no roots
          continue;
        }
        var pl = (ProductLine) plModel.getEMFInstanceRoot();
        // all PLs must have the same featuresConstraint
        if (featuresConstraint == null) {
          featuresConstraint = pl.getFeaturesConstraint();
          continue;
        }
        if (!featuresConstraint.equals(pl.getFeaturesConstraint())) {
          return false;
        }
      }
      return true;
    }
  };

  protected List<Model> plModels;

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    this.plModels = MIDOperatorIOUtils.getVarargs(inputsByName, DeriveAll.IN0.name());
    this.productLines = this.plModels.stream()
      .map(m -> (ProductLine) m.getEMFInstanceRoot())
      .toList();
    this.products = new ArrayList<>();
    init2(inputProperties, this.productLines.get(0));
  }

  @Override
  public void createWorkflowInstanceOutputs(Operator newOperator, Map<String, GenericElement> genericsByName,
                                            Map<String, Model> inputsByName, MID workflowMID) throws MMINTException {
    var plModels = MIDOperatorIOUtils.getVarargs(inputsByName, DeriveAll.IN0.name());
    var plModelsToProdModels = new HashMap<Model, Model>();
    for (var i = 0; i < plModels.size(); i++) {
      var plModel = plModels.get(i);
      var prodModelId = MIDRegistry.getNextWorkflowID(workflowMID);
      var prodType = (plModel instanceof ModelRel plRel) ?
        plRel.getMetatype() :
        MIDTypeHierarchy.getRootModelType();
      var prodModel = prodType.createWorkflowInstance(prodModelId, workflowMID);
      var prodModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
        prodModel, newOperator, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
      prodModelEndpoint.setName(prodModelEndpoint.getName() + i);
      plModelsToProdModels.put(plModel, prodModel);
    }
    for (var plModel : plModels) {
      if (!(plModel instanceof ModelRel plRel)) {
        continue;
      }
      var prodRel = (ModelRel) plModelsToProdModels.get(plRel);
      for (var plModelEndp : plRel.getModelEndpoints()) {
        var prodModelEndp = plModelsToProdModels.get(plModelEndp.getTarget());
        plModelEndp.getMetatype().createWorkflowInstance(prodModelEndp, prodRel);
      }
    }
  }

  protected ModelRel derive(ModelRel plRel, Map<Model, Model> plModelsToProdModels, MID mid) throws MMINTException {
    // TODO MMINT[PL] Handle PLModelRels with presence conditions
    var prodEndpoints = plRel.getModelEndpoints().stream()
      .map(me -> plModelsToProdModels.get(me.getTarget()))
      .collect(Collectors.toList());
    var prodRelName = plRel.getName() + DeriveAll.OUT0.suffix();
    var prodRel = (plRel instanceof BinaryModelRel) ?
      plRel.getMetatype().createBinaryInstanceAndEndpoints(null, prodRelName, prodEndpoints.get(0), prodEndpoints.get(1), mid) :
      plRel.getMetatype().createInstanceAndEndpoints(null, prodRelName, ECollections.toEList(prodEndpoints), mid);
    for (var plMapping : plRel.getMappings()) {
      var prodModelObjs = new HashMap<EObject, Model>();
      for (var plModelElemEndpointRef : plMapping.getModelElemEndpointRefs()) {
        var plModelElem = plModelElemEndpointRef.getObject().getTarget();
        var prodModelObj = this.traceLinks.get(plModelElem.getEMFInstanceObject());
        if (prodModelObj != null) {
          prodModelObjs.put(prodModelObj, plModelsToProdModels.get(plModelElem.eContainer()));
        }
      }
      if (plMapping.getModelElemEndpointRefs().size() != prodModelObjs.size()) {
        // drop this mapping
        continue;
      }
      var prodModelElemRefs = new ArrayList<ModelElementReference>();
      for (var prodModelObjEntry : prodModelObjs.entrySet()) {
        var prodModelEndpointRef = prodRel.getModelEndpointRefs().stream()
          .filter(mer -> mer.getTargetUri().equals(prodModelObjEntry.getValue().getUri()))
          .findFirst().get();
        prodModelElemRefs.add(prodModelEndpointRef.createModelElementInstanceAndReference(prodModelObjEntry.getKey(), null));
      }
      var prodMapping = plMapping.getMetatype()
        .createInstanceAndReferenceAndEndpointsAndReferences(plMapping instanceof BinaryMapping,
                                                             ECollections.toEList(prodModelElemRefs));
      prodMapping.getObject().setName(plMapping.getName());
    }

    return prodRel;
  }

  protected List<Model> deriveAll(Map<String, Model> inputsByName, MID outMID) throws Exception {
    var plModelsToProdModels = new HashMap<Model, Model>();
    var prodModels = new ArrayList<Model>();
    var prodOutputMIDsByName = Map.of(Derive.OUT0.name(), outMID);

    // products: the trick is to run a single derive at a time, collecting the output one by one
    for (var i = 0; i < this.productLines.size(); i++) {
      this.productLine = this.productLines.get(i);
      this.product = null;
      derive();
      this.products.add(this.product);
      // deriveAll vararg name for inputsByName access
      var plParam = new OperatorParameter(DeriveAll.IN0.name() + i, DeriveAll.IN0.type());
      // single derive name for out root access (requires custom outputMIDsByName)
      var prodParam = Derive.OUT0.specialize(this.productLine.getMetamodel().getNsURI());
      var prodModel = outputFromInput(plParam, prodParam, inputsByName, prodOutputMIDsByName).get(Derive.OUT0.name());
      plModelsToProdModels.put(this.plModels.get(i), prodModel);
      prodModels.add(prodModel);
    }

    // rels
    var alreadyDerived = new HashSet<ModelRel>();
    for (var plModel : this.plModels) {
      for (var plRel : MIDRegistry.getConnectedModelRels(plModel, plModel.getMIDContainer())) {
        if (alreadyDerived.contains(plRel)) {
          continue;
        }
        if (plRel.getModelEndpoints().stream()
                 .map(ModelEndpoint::getTarget)
                 .anyMatch(m -> !this.plModels.contains(m))) {
          continue;
        }
        var prodRel = derive(plRel, plModelsToProdModels, outMID);
        alreadyDerived.add(plRel);
        prodModels.add(prodRel);
      }
    }

    return prodModels;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    var prodModels = deriveAll(inputsByName, outputMIDsByName.get(DeriveAll.OUT0.name()));
    var outputsByName = MIDOperatorIOUtils.setVarargs(prodModels, DeriveAll.OUT0.name());

    return outputsByName;
  }
}
