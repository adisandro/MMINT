/*******************************************************************************
 * Copyright (c) 2012, 2022 Alessio Di Sandro.
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
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
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
  private static final String MERGE_SEPARATOR = "_";
  private static final String TRACE_COPIED_NAME = "copied";
  private static final String TRACE_MERGED_NAME = "merged";
  private Input input;
  private Output output;

  private static class Input {
    private final static String MODELREL = "overlap";
    private ModelRel overlap;
    private Model model1;
    private Model model2;

    public Input(Map<String, Model> inputsByName) {
      this.overlap = (ModelRel) inputsByName.get(Input.MODELREL);
      if (this.overlap.getModelEndpoints().size() != 2) {
        throw new IllegalArgumentException();
      }
      this.model1 = this.overlap.getModelEndpoints().get(0).getTarget();
      this.model2 = this.overlap.getModelEndpoints().get(1).getTarget();
      if (this.model1.getMetatype() != this.model2.getMetatype()) {
        throw new IllegalArgumentException();
      }
    }
  }

  private static class Output {
    private final static String MODEL = "merged";
    private final static String MODELREL1 = "trace1";
    private final static String MODELREL2 = "trace2";
    private final static String MODELREL3 = "mergeTrace";
    private Model merged;
    private ModelRel trace1;
    private ModelRel trace2;
    private ModelRel mergeTrace;
    private String mergedModelPath;

    public Output(Input input, Map<String, MID> outputMIDsByName) throws Exception {
      var mergedModelMID = outputMIDsByName.get(Output.MODEL);
      var mergedModelName = input.model1.getName() + Merge.MERGE_SEPARATOR + input.model2.getName() +
                            MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + input.model1.getFileExtension();
      this.mergedModelPath = FileUtils.replaceLastSegmentInPath(MIDRegistry.getModelUri(mergedModelMID),
                                                                mergedModelName);
      this.merged = input.model1.getMetatype().createInstance(null, this.mergedModelPath, mergedModelMID);
      var modelRelType = MIDTypeHierarchy.getRootModelRelType();
      this.trace1 = modelRelType.createBinaryInstanceAndEndpoints(null, Output.MODELREL1, input.model1, this.merged,
                                                                  outputMIDsByName.get(Output.MODELREL1));
      this.trace2 = modelRelType.createBinaryInstanceAndEndpoints(null, Output.MODELREL2, input.model2, this.merged,
                                                                  outputMIDsByName.get(Output.MODELREL2));
      this.mergeTrace = modelRelType.createBinaryInstanceAndEndpoints(null, Output.MODELREL3, input.overlap,
                                                                      this.merged,
                                                                      outputMIDsByName.get(Output.MODELREL3));
    }

    public Map<String, Model> packed() throws Exception {
      this.merged.createInstanceEditor(true); // opens the new model editor as side effect

      return Map.of(Output.MODEL, this.merged,
                    Output.MODELREL1, this.trace1,
                    Output.MODELREL2, this.trace2,
                    Output.MODELREL3, this.mergeTrace);
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
      var mergedModel = outputsByName.get(Output.MODEL);
      var traceRel1 = (ModelRel) outputsByName.get(Output.MODELREL1);
      var traceRel2 = (ModelRel) outputsByName.get(Output.MODELREL2);
      var mergeRel = (ModelRel) outputsByName.get(Output.MODELREL3);

      return Map.of(traceRel1, List.of(input.model1, mergedModel),
                    traceRel2, List.of(input.model2, mergedModel),
                    mergeRel, List.of(input.overlap, mergedModel));
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

  protected void rule() {

  }

  private void merge() throws Exception {
    var modelElemType = MIDTypeHierarchy.getRootModelElementType();
    var mappingType = MIDTypeHierarchy.getRootMappingType();

    // create merged root
    var rootModelObj1 = this.input.model1.getEMFInstanceRoot();
    var modelFactory = rootModelObj1.eClass().getEPackage().getEFactoryInstance();
    var rootMergedModelObj = modelFactory.create(rootModelObj1.eClass());
    var overlapModelElems1 = new HashMap<String, String>(); // uri1 to uri2
    for (var modelElemRef1 : this.input.overlap.getModelEndpointRefs().get(0).getModelElemRefs()) {
      var modelElemRef2 = this.getConnected(modelElemRef1).stream().findFirst().get();
      overlapModelElems1.put(MIDRegistry.getModelObjectUri(modelElemRef1.getObject()),
                             MIDRegistry.getModelObjectUri(modelElemRef2.getObject()));
    }
    var mergedModelObjs = new HashMap<String, EObject>(); // uri2 to mergedObj
    var allModelObjs = new LinkedHashMap<EObject, EObject>(); // obj1/obj2 to mergedObj (+ we track insertion order)

    // copy elements from model1
    allModelObjs.put(rootModelObj1, rootMergedModelObj);
    for (var iter1 = rootModelObj1.eAllContents(); iter1.hasNext(); ) {
      var modelObj1 = iter1.next();
      var mergedModelObj = modelFactory.create(modelObj1.eClass());
      allModelObjs.put(modelObj1, mergedModelObj);
      var modelElemUri1 = MIDRegistry.getModelElementUri(modelObj1);
      var isMerged = overlapModelElems1.containsKey(modelElemUri1);
      if (isMerged) {
        var modelElemUri2 = overlapModelElems1.get(modelElemUri1);
        mergedModelObjs.put(modelElemUri2, mergedModelObj);
      }
      // containment (pre-requisite for proper creation of trace rel)
      var containerObj1 = modelObj1.eContainer();
      if (containerObj1 != null) { // non-root
        var mergedContainerObj = allModelObjs.get(containerObj1);
        FileUtils.setModelObjectFeature(mergedContainerObj, modelObj1.eContainingFeature().getName(), mergedModelObj);
      }
      // trace1 rel
      var traceName = (isMerged) ? Merge.TRACE_MERGED_NAME : Merge.TRACE_COPIED_NAME;
      var traceModelElemRefs1 = new BasicEList<ModelElementReference>();
      traceModelElemRefs1.add(
        this.output.trace1.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(modelObj1, null));
      var newModelElemUri = this.output.merged.getUri() + MIDRegistry.getModelElementUri(mergedModelObj);
      var eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
      var newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
      traceModelElemRefs1.add( // merged model element is not serialized yet
        modelElemType.createInstanceAndReference(newModelElemUri, newModelElemName, eInfo,
                                                 this.output.trace1.getModelEndpointRefs().get(1)));
      var newMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, traceModelElemRefs1);
      newMappingRef.getObject().setName(traceName);
    }

    // copy elements from model2
    var rootModelObj2 = this.input.model2.getEMFInstanceRoot();
    allModelObjs.put(rootModelObj2, rootMergedModelObj);
    for (var iter2 = rootModelObj2.eAllContents(); iter2.hasNext(); ) {
      var modelObj2 = iter2.next();
      var modelElemUri2 = MIDRegistry.getModelElementUri(modelObj2);
      var isMerged = mergedModelObjs.containsKey(modelElemUri2);
      var mergedModelObj = (isMerged) ? mergedModelObjs.get(modelElemUri2) : modelFactory.create(modelObj2.eClass());
      allModelObjs.put(modelObj2, mergedModelObj);
      // containment (pre-requisite for proper creation of trace rel)
      var containerObj2 = modelObj2.eContainer();
      if (containerObj2 != null && // non-root
          !mergedModelObjs.containsKey(MIDRegistry.getModelElementUri(modelObj2))) { // non-merged
        var mergedContainerObj = allModelObjs.get(containerObj2);
        FileUtils.setModelObjectFeature(mergedContainerObj, modelObj2.eContainingFeature().getName(), mergedModelObj);
      }
      // trace2 rel
      var traceName = (isMerged) ? Merge.TRACE_MERGED_NAME : Merge.TRACE_COPIED_NAME;
      var traceModelElemRefs2 = new BasicEList<ModelElementReference>();
      traceModelElemRefs2.add(
        this.output.trace2.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(modelObj2, null));
      var newModelElemUri = this.output.merged.getUri() + MIDRegistry.getModelElementUri(mergedModelObj);
      var eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
      var newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
      traceModelElemRefs2.add( // merged model element is not serialized yet
        modelElemType.createInstanceAndReference(newModelElemUri, newModelElemName, eInfo,
                                                 this.output.trace2.getModelEndpointRefs().get(1)));
      var newMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, traceModelElemRefs2);
      newMappingRef.getObject().setName(traceName);
    }

    // populate structural features
    for (var entry : allModelObjs.entrySet()) {
      var modelObj = entry.getKey();
      var mergedModelObj = entry.getValue();
      // references (runs twice for merged objects, merging non-containment references of both sides)
      for (var reference : modelObj.eClass().getEAllReferences()) {
        if (reference.isContainment() || !reference.isChangeable() || reference.isDerived()) {
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
      // attributes (runs twice for merged objects, merging string attributes)
      for (var attribute : modelObj.eClass().getEAllAttributes()) {
        if (!attribute.isChangeable() || attribute.isDerived()) {
          continue;
        }
        var attributeName = attribute.getName();
        var attributeValue = FileUtils.getModelObjectFeature(modelObj, attributeName);
        if (attributeValue instanceof String) {
          var mergedAttributeValue = FileUtils.getModelObjectFeature(mergedModelObj, attributeName);
          if (mergedAttributeValue != null && !mergedAttributeValue.equals(attributeValue)) {
            attributeValue = mergedAttributeValue + Merge.MERGE_SEPARATOR + attributeValue;
          }
        }
        FileUtils.setModelObjectFeature(mergedModelObj, attributeName, attributeValue);
      }
    }

    // store merged model
    FileUtils.writeModelFile(rootMergedModelObj, this.output.merged.getUri(), null, true);

    // merge rel
    for (var overlapMapping : this.input.overlap.getMappings()) {
      var mergeModelElemRefs = new BasicEList<ModelElementReference>();
      mergeModelElemRefs.add(this.output.mergeTrace.getModelEndpointRefs().get(0)
        .createModelElementInstanceAndReference(overlapMapping, null));
      var modelElemUri2 = overlapMapping.getModelElemEndpoints().stream()
        .map(mee -> MIDRegistry.getModelObjectUri(mee.getTarget()))
        .filter(u -> this.input.model2.getUri().equals(MIDRegistry.getModelUri(u)))
        .findFirst().get();
      var mergedModelObj = mergedModelObjs.get(modelElemUri2);
      mergeModelElemRefs.add(this.output.mergeTrace.getModelEndpointRefs().get(1)
        .createModelElementInstanceAndReference(mergedModelObj, null));
      var mergeMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, mergeModelElemRefs);
      mergeMappingRef.getObject().setName(Merge.TRACE_MERGED_NAME);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.input = new Input(inputsByName);
    this.output = new Output(this.input, outputMIDsByName);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    merge();

    return this.output.packed();
  }
}
