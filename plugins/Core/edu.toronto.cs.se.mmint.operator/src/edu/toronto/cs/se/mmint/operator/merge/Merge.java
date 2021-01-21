/*******************************************************************************
 * Copyright (c) 2012, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.operator.merge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

//TODO MMINT[OPERATOR] Review this whole operator to find examples on how to make apis easier to use
// e.g. direct access through ext table is useful, but there's that _AS_ thing to be fixed first
// e.g. there is no direct link from a model to all its connected model rels
public class Merge extends OperatorImpl {

  // input-output
  private final static String IN_MODELREL = "overlap";
  private final static String OUT_MODEL = "merged";
  private final static String OUT_MODELREL1 = "trace1";
  private final static String OUT_MODELREL2 = "trace2";
  // constants
  private static final String MERGED_MODELOBJECT_ATTRIBUTE = "name";
  private static final String MERGE_SEPARATOR = "_";

  private static class Input {
    private ModelRel overlapRel;
    private Model model1;
    private Model model2;

    public Input(Map<String, Model> inputsByName) {
      this.overlapRel = (ModelRel) inputsByName.get(Merge.IN_MODELREL);
      if (this.overlapRel.getModelEndpoints().size() != 2) {
        throw new IllegalArgumentException();
      }
      this.model1 = this.overlapRel.getModelEndpoints().get(0).getTarget();
      this.model2 = this.overlapRel.getModelEndpoints().get(1).getTarget();
      if (this.model1.getMetatype() != this.model2.getMetatype()) {
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

    @Override
    public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                 Map<String, Model> inputsByName,
                                                                 Map<String, Model> outputsByName) {
      var input = new Input(inputsByName);
      var mergedModel = outputsByName.get(Merge.OUT_MODEL);
      var traceRel1 = (ModelRel) outputsByName.get(Merge.OUT_MODELREL1);
      var traceRel2 = (ModelRel) outputsByName.get(Merge.OUT_MODELREL2);
      var validOutputs = new HashMap<ModelRel, List<Model>>();
      var endpointModels1 = new ArrayList<Model>();
      endpointModels1.add(input.model1);
      endpointModels1.add(mergedModel);
      validOutputs.put(traceRel1, endpointModels1);
      var endpointModels2 = new ArrayList<Model>();
      endpointModels2.add(input.model2);
      endpointModels2.add(mergedModel);
      validOutputs.put(traceRel2, endpointModels2);

      return validOutputs;
    }
  }

  // TODO MMINT[OPERATOR] Make this an api
  private Set<ModelElementReference> getConnected(ModelElementReference modelElemRef) {
    var connModelElemRefs = new HashSet<ModelElementReference>();
    for (var modelElemEndpointRef : modelElemRef.getModelElemEndpointRefs()) {
      for (var connModelElemEndpointRef : ((MappingReference) modelElemEndpointRef.eContainer())
             .getModelElemEndpointRefs()) {
        if (connModelElemEndpointRef == modelElemEndpointRef) {
          continue;
        }
        connModelElemRefs.add(connModelElemEndpointRef.getModelElemRef());
      }
    }

    return connModelElemRefs;
  }

  private EObject merge(Model model1, Model model2, ModelRel overlapRel, Model mergedModel, ModelRel traceRel1,
                        ModelRel traceRel2) throws MMINTException {
    var modelElemType = MIDTypeHierarchy.getRootModelElementType();
    var mappingType = MIDTypeHierarchy.getRootMappingType();

    // create merged root
    var rootModelObj1 = model1.getEMFInstanceRoot();
    var modelFactory = rootModelObj1.eClass().getEPackage().getEFactoryInstance();
    var rootMergedModelObj = modelFactory.create(rootModelObj1.eClass());
    var overlapModelElems1 = new HashMap<String, ModelElement>();
    for (var modelElemRef1 : overlapRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
      var modelElemRef2 = this.getConnected(modelElemRef1).stream().findFirst().get();
      overlapModelElems1.put(MIDRegistry.getModelObjectUri(modelElemRef1.getObject()), modelElemRef2.getObject());
    }
    var mergedModelObjs = new HashMap<String, EObject>();
    var allModelObjs = new LinkedHashMap<EObject, EObject>(); // need to track insertion order
    allModelObjs.put(rootModelObj1, rootMergedModelObj);

    // copy elements from model1
    var iter1 = rootModelObj1.eAllContents();
    for (var modelObj1 = iter1.next(); iter1.hasNext(); ) {
      var mergedModelObj = modelFactory.create(modelObj1.eClass());
      allModelObjs.put(modelObj1, mergedModelObj);
      var modelElemUri1 = MIDRegistry.getModelElementUri(modelObj1);
      if (overlapModelElems1.containsKey(modelElemUri1)) {
        var modelElem2 = overlapModelElems1.get(modelElemUri1);
        var modelObj2 = modelElem2.getEMFInstanceObject();
        mergedModelObjs.put(MIDRegistry.getModelObjectUri(modelElem2), mergedModelObj);
        try { // change merged attribute
          var modelObjAttr1 = FileUtils.getModelObjectFeature(modelObj1, Merge.MERGED_MODELOBJECT_ATTRIBUTE);
          var modelObjAttr2 = FileUtils.getModelObjectFeature(modelObj2, Merge.MERGED_MODELOBJECT_ATTRIBUTE);
          if (!modelObjAttr1.equals(modelObjAttr2)) {
            FileUtils.setModelObjectFeature(mergedModelObj, Merge.MERGED_MODELOBJECT_ATTRIBUTE,
                                            modelObjAttr1 + Merge.MERGE_SEPARATOR + modelObjAttr2);
          }
        }
        catch (MMINTException e) {
          // no attribute to merge
        }
      }
      var traceModelElemRefs1 = new BasicEList<ModelElementReference>();
      traceModelElemRefs1.add(traceRel1.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(
                                modelObj1, null));
      var newModelElemUri = mergedModel.getUri() + MIDRegistry.getModelElementUri(mergedModelObj);
      var eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
      var newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
      traceModelElemRefs1.add( // merged model element is not serialized yet
        modelElemType.createInstanceAndReference(newModelElemUri, newModelElemName, eInfo,
                                                 traceRel1.getModelEndpointRefs().get(1)));
      var newMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, traceModelElemRefs1);
      try {
        newMappingRef.getObject().setName(
          FileUtils.getModelObjectFeature(mergedModelObj, Merge.MERGED_MODELOBJECT_ATTRIBUTE).toString());
      }
      catch (MMINTException e) {
        // no name to set
      }
    }

    // copy elements from model2
    var rootModelObj2 = model2.getEMFInstanceRoot();
    var iter2 = rootModelObj2.eAllContents();
    for (var modelObj2 = iter2.next(); iter2.hasNext(); ) {
      var modelElemUri2 = MIDRegistry.getModelElementUri(modelObj2);
      var mergedModelObj = (mergedModelObjs.containsKey(modelElemUri2)) ?
        mergedModelObjs.get(modelElemUri2) :
        modelFactory.create(modelObj2.eClass());
      allModelObjs.put(modelObj2, mergedModelObj);
      var traceModelElemRefs2 = new BasicEList<ModelElementReference>();
      traceModelElemRefs2.add(traceRel2.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(
                                modelObj2, null));
      var newModelElemUri = mergedModel.getUri() + MIDRegistry.getModelElementUri(mergedModelObj);
      var eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
      var newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
      traceModelElemRefs2.add( // merged model element is not serialized yet
        modelElemType.createInstanceAndReference(newModelElemUri, newModelElemName, eInfo,
                                                 traceRel2.getModelEndpointRefs().get(1)));
      var newMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, traceModelElemRefs2);
      try {
        newMappingRef.getObject().setName(
          FileUtils.getModelObjectFeature(mergedModelObj, Merge.MERGED_MODELOBJECT_ATTRIBUTE).toString());
      }
      catch (MMINTException e) {
        // no name to set
      }
    }

    // populate structural features
    for (var entry : allModelObjs.entrySet()) {
      var modelObj = entry.getKey();
      var mergedModelObj = entry.getValue();
      var containerObj = modelObj.eContainer();
      // containment
      if (containerObj != null && // non-root
          !mergedModelObjs.containsKey(MIDRegistry.getModelElementUri(modelObj))) { // non-merged
        var mergedContainerObj = allModelObjs.get(containerObj);
        FileUtils.setModelObjectFeature(mergedContainerObj, modelObj.eContainingFeature().getName(), mergedModelObj);
      }
      // references (runs twice for merged objects, merging non-containment references too)
      for (var reference : modelObj.eClass().getEAllReferences()) {
        if (reference.isContainment()) {
          continue;
        }
        var referenceValue = FileUtils.getModelObjectFeature(modelObj, reference.getName());
        if (referenceValue == null || referenceValue instanceof EObjectWithInverseResolvingEList<?>) {
          continue;
        }
        EList<EObject> referencedModelObjs;
        if (referenceValue instanceof EList<?>) {
          referencedModelObjs = (EList<EObject>) referenceValue;
        }
        else {
          referencedModelObjs = new BasicEList<>();
          referencedModelObjs.add((EObject) referenceValue);
        }
        for (var referencedModelObj : referencedModelObjs) {
          FileUtils.setModelObjectFeature(mergedModelObj, reference.getName(), allModelObjs.get(referencedModelObj));
        }
      }
      // attributes
      for (var attribute : modelObj.eClass().getEAllAttributes()) {
        // TODO MERGED_MODELOBJECT_ATTRIBUTE should be handled here + review if running twice is correct
        var attributeName = attribute.getName();
        if (attributeName.equals(Merge.MERGED_MODELOBJECT_ATTRIBUTE)) {
          continue;
        }
        var attributeValue = FileUtils.getModelObjectFeature(modelObj, attributeName);
        FileUtils.setModelObjectFeature(mergedModelObj, attributeName, attributeValue);
      }
    }

    return rootMergedModelObj;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    // input
    var input = new Input(inputsByName);
    // create merged model and trace relationships as placeholders
    var mergedModelMID = outputMIDsByName.get(Merge.OUT_MODEL);
    var mergedModelName = input.model1.getName() + Merge.MERGE_SEPARATOR + input.model2.getName() +
                          MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + input.model1.getFileExtension();
    String mergedModelPath = FileUtils.replaceLastSegmentInPath(MIDRegistry.getModelUri(mergedModelMID),
                                                                mergedModelName);
    var mergedModel = input.model1.getMetatype().createInstance(null, mergedModelPath, mergedModelMID);
    var modelRelType = MIDTypeHierarchy.getRootModelRelType();
    var traceRel1 = modelRelType.createBinaryInstanceAndEndpoints(null, Merge.OUT_MODELREL1, input.model1, mergedModel,
                                                                  outputMIDsByName.get(Merge.OUT_MODELREL1));
    var traceRel2 = modelRelType.createBinaryInstanceAndEndpoints(null, Merge.OUT_MODELREL2, input.model2, mergedModel,
                                                                  outputMIDsByName.get(Merge.OUT_MODELREL2));
    // merge the models
    var rootMergedModelObj = this.merge(input.model1, input.model2, input.overlapRel, mergedModel, traceRel1,
                                        traceRel2);
    FileUtils.writeModelFile(rootMergedModelObj, mergedModelPath, true);
    mergedModel.createInstanceEditor(true); // opens the new model editor as side effect
    // output
    Map<String, Model> outputsByName = new HashMap<>();
    outputsByName.put(Merge.OUT_MODEL, mergedModel);
    outputsByName.put(Merge.OUT_MODELREL1, traceRel1);
    outputsByName.put(Merge.OUT_MODELREL2, traceRel2);

    return outputsByName;
  }
}
