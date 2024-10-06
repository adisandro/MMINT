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
package edu.toronto.cs.se.mmint.productline.operators.bridge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public class DeriveAll extends Derive {
  protected Ins in;
  protected Outs out;

  public static class Ins {
    public final static String MODELS = "productLines";
    public List<Model> plModels;
    public List<ProductLine> pls;

    public Ins(Map<String, Model> inputsByName) {
      this.plModels = MIDOperatorIOUtils.getVarargs(inputsByName, Ins.MODELS);
      this.pls = new ArrayList<>();
      for (var plModel : this.plModels) {
        if (!(plModel instanceof ModelRel)) {
          if (!plModel.getMetatypeUri().equals(PLPackage.eNS_URI)) {
            // all models must be PLs
            //TODO MMINT[POLY] Use instanceOf when it's optimized (automatic caching of runtime types)
            throw new IllegalArgumentException();
          }
          if (plModel.isWorkflowsLevel()) {
            // there are no roots
            continue;
          }
          var pl = (ProductLine) plModel.getEMFInstanceRoot();
          if (!this.pls.isEmpty() && !this.pls.get(0).getFeaturesConstraint().equals(pl.getFeaturesConstraint())) {
            // all PLs must have the same featuresConstraint
            throw new IllegalArgumentException();
          }
          this.pls.add(pl);
        }
      }
    }
  }

  public static class Constraints implements IJavaOperatorConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new Ins(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  public static class Outs {
    public final static String MODELS = "products";
    public DeriveAll operator;
    public MID mid;
    public List<EObject> products;
    public Map<Class, EObject> traceLinks;

    public Outs(DeriveAll operator, Map<String, MID> outputMIDsByName) {
      this.operator = operator;
      this.mid = outputMIDsByName.get(Outs.MODELS);
      this.products = new ArrayList<>();
      this.traceLinks = new LinkedHashMap<>();
    }

    public Map<String, Model> packed() throws MMINTException, IOException {
      var pModels = new ArrayList<Model>(this.operator.in.plModels.size());
      var plModelToPModel = new HashMap<Model, Model>();
      var p = 0;
      // products
      for (var plModel : this.operator.in.plModels) {
        Model pModel = null; // placeholder for rels
        if (!(plModel instanceof ModelRel)) {
          var pModelType = MIDTypeRegistry.<Model>getType(this.operator.in.pls.get(p).getMetamodel().getNsURI());
          var pPath = this.operator.getWorkingPath() + IPath.SEPARATOR + plModel.getName() + Out.PRODUCT_SUFFIX +
                      MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + pModelType.getFileExtension();
          pPath = FileUtils.getUniquePath(pPath, true, false);
          pModel = pModelType.createInstanceAndEditor(this.products.get(p), pPath, this.mid);
          plModelToPModel.put(plModel, pModel);
          p++;
        }
        pModels.add(pModel);
      }
      // rels
      for (var i = 0; i < this.operator.in.plModels.size(); i++) {
        var plModel = this.operator.in.plModels.get(i);
        if (!(plModel instanceof ModelRel plRel)) {
          continue;
        }
        var pRel = this.operator.derive(plRel, plModelToPModel, this.traceLinks, this.mid);
        pModels.add(i, pRel);
      }

      return MIDOperatorIOUtils.setVarargs(pModels, Outs.MODELS);
    }
  }

  @Override
  public void createWorkflowInstanceOutputs(Operator newOperator, Map<String, GenericElement> genericsByName,
                                            Map<String, Model> inputsByName, MID workflowMID) throws MMINTException {
    var plModels = MIDOperatorIOUtils.getVarargs(inputsByName, Ins.MODELS);
    var plModelsToPModels = new HashMap<Model, Model>();
    for (var i = 0; i < plModels.size(); i++) {
      var plModel = plModels.get(i);
      var pModelId = MIDRegistry.getNextWorkflowID(workflowMID);
      var pType = (plModel instanceof ModelRel plRel) ?
        plRel.getMetatype() :
        MIDTypeHierarchy.getRootModelType();
      var pModel = pType.createWorkflowInstance(pModelId, workflowMID);
      var pModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
        pModel, newOperator, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
      pModelEndpoint.setName(pModelEndpoint.getName() + i);
      plModelsToPModels.put(plModel, pModel);
    }
    for (var plModel : plModels) {
      if (!(plModel instanceof ModelRel plRel)) {
        continue;
      }
      var pRel = (ModelRel) plModelsToPModels.get(plRel);
      for (var plModelEndp : plRel.getModelEndpoints()) {
        var pModelEndp = plModelsToPModels.get(plModelEndp.getTarget());
        plModelEndp.getMetatype().createWorkflowInstance(pModelEndp, pRel);
      }
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new Ins(inputsByName);
    this.out = new Outs(this, outputMIDsByName);
    this.featureReasoner = this.in.pls.get(0).getReasoner();
    this.allFeatureValues = new HashMap<>();
    this.presenceConditionCache = new HashMap<>();
  }

  protected ModelRel derive(ModelRel plRel, Map<Model, Model> plModelToPModel, Map<Class, EObject> traceLinks, MID mid) throws MMINTException {
    // TODO MMINT[PL] Handle PLModelRels with presence conditions
    var pEndpoints = plRel.getModelEndpoints().stream()
      .map(me -> plModelToPModel.get(me.getTarget()))
      .collect(Collectors.toList());
    var pRelName = plRel.getName() + Out.PRODUCT_SUFFIX;
    var pRel = (plRel instanceof BinaryModelRel) ?
      plRel.getMetatype().createBinaryInstanceAndEndpoints(null, pRelName, pEndpoints.get(0), pEndpoints.get(1), mid) :
      plRel.getMetatype().createInstanceAndEndpoints(null, pRelName, ECollections.toEList(pEndpoints), mid);
    for (var plMapping : plRel.getMappings()) {
      var pModelObjs = new HashMap<EObject, Model>();
      for (var plModelElemEndpointRef : plMapping.getModelElemEndpointRefs()) {
        var plModelElem = plModelElemEndpointRef.getObject().getTarget();
        var pModelObj = traceLinks.get(plModelElem.getEMFInstanceObject());
        if (pModelObj != null) {
          pModelObjs.put(pModelObj, plModelToPModel.get(plModelElem.eContainer()));
        }
      }
      if (plMapping.getModelElemEndpointRefs().size() != pModelObjs.size()) {
        // drop this mapping
        continue;
      }
      var pModelElemRefs = new ArrayList<ModelElementReference>();
      for (var pModelObjEntry : pModelObjs.entrySet()) {
        var pModelEndpointRef = pRel.getModelEndpointRefs().stream()
          .filter(mer -> mer.getTargetUri().equals(pModelObjEntry.getValue().getUri()))
          .findFirst().get();
        pModelElemRefs.add(pModelEndpointRef.createModelElementInstanceAndReference(pModelObjEntry.getKey(), null));
      }
      var pMapping = plMapping.getMetatype()
        .createInstanceAndReferenceAndEndpointsAndReferences(plMapping instanceof BinaryMapping,
                                                             ECollections.toEList(pModelElemRefs));
      pMapping.getObject().setName(plMapping.getName());
    }

    return pRel;
  }

  @Override
  protected void derive() throws MMINTException {
    for (var pl : this.in.pls) {
      this.out.products.add(derive(pl, this.out.traceLinks));
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    derive();

    return this.out.packed();
  }
}
