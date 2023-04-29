/*******************************************************************************
 * Copyright (c) 2012, 2023 Alessio Di Sandro.
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

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.kotlin.operators.merge.EntryKt;
import edu.toronto.cs.se.mmint.kotlin.structs.Object;
import edu.toronto.cs.se.mmint.kotlin.structs.Tree;
import edu.toronto.cs.se.mmint.kotlin.utils.KotlinConverter;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Merge extends OperatorImpl {
  protected static final String MERGE_SEPARATOR = "_";
  protected static final String ATTR_MERGE_SYNTAX = "$1" + Merge.MERGE_SEPARATOR + "$2";
  private static final String TRACE_COPIED_NAME = "copied";
  private static final String TRACE_MERGED_NAME = "merged";
  protected In in;
  protected Out out;
  protected String engine;
  protected KotlinConverter kConverter;

  protected static class In {
    private final static String PROP_ENGINE = "engine";
    private final static String PROP_ENGINE_DEFAULT = "java";
    private final static String MODELREL = "overlap";
    public ModelRel overlap;
    public Model model1;
    public Model model2;

    public In(Map<String, Model> inputsByName) {
      this.overlap = (ModelRel) inputsByName.get(In.MODELREL);
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

  protected static class Out {
    private final static String PROP_TIMEMERGE = "timeMerge";
    private final static String MODEL = "merged";
    private final static String MODELREL1 = "trace1";
    private final static String MODELREL2 = "trace2";
    private final static String MODELREL3 = "mergeTrace";
    public Merge operator;
    public Properties props;
    public long timeMerge;
    public Model merged;
    public ModelRel trace1;
    public ModelRel trace2;
    public ModelRel mergeTrace;
    public MID mergedMID;

    public Out(Merge operator, Map<String, MID> outputMIDsByName) throws Exception {
      this.operator = operator;
      this.props = new Properties();
      this.timeMerge = 0;
      this.mergedMID = outputMIDsByName.get(Out.MODEL);
      var mergedModelName = operator.in.model1.getName() + Merge.MERGE_SEPARATOR + operator.in.model2.getName() +
                            MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + operator.in.model1.getFileExtension();
      var mergedModelPath = FileUtils.getUniquePath(operator.getWorkingPath() + File.separator + mergedModelName, true,
                                                    false);
      this.merged = operator.in.model1.getMetatype().createInstance(null, mergedModelPath, this.mergedMID);
      var modelRelType = MIDTypeHierarchy.getRootModelRelType();
      this.trace1 = modelRelType.createBinaryInstanceAndEndpoints(null, Out.MODELREL1, operator.in.model1, this.merged,
                                                                  outputMIDsByName.get(Out.MODELREL1));
      this.trace2 = modelRelType.createBinaryInstanceAndEndpoints(null, Out.MODELREL2, operator.in.model2, this.merged,
                                                                  outputMIDsByName.get(Out.MODELREL2));
      this.mergeTrace = modelRelType.createBinaryInstanceAndEndpoints(null, Out.MODELREL3, operator.in.overlap,
                                                                      this.merged, outputMIDsByName.get(Out.MODELREL3));
    }

    public Map<String, Model> packed() throws Exception {
      if (this.mergedMID != null) { // can happen when running in an experiment
        this.merged.createInstanceEditor(true);
      }
      this.props.setProperty(Out.PROP_TIMEMERGE, String.valueOf(this.timeMerge));
      MIDOperatorIOUtils.writeOutputProperties(this.operator, this.props);

      return Map.of(Out.MODEL, this.merged,
                    Out.MODELREL1, this.trace1,
                    Out.MODELREL2, this.trace2,
                    Out.MODELREL3, this.mergeTrace);
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

    @Override
    public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                 Map<String, Model> inputsByName,
                                                                 Map<String, Model> outputsByName) {
      var input = new In(inputsByName);
      var mergedModel = outputsByName.get(Out.MODEL);
      var traceRel1 = (ModelRel) outputsByName.get(Out.MODELREL1);
      var traceRel2 = (ModelRel) outputsByName.get(Out.MODELREL2);
      var mergeRel = (ModelRel) outputsByName.get(Out.MODELREL3);

      return Map.of(traceRel1, List.of(input.model1, mergedModel),
                    traceRel2, List.of(input.model2, mergedModel),
                    mergeRel, List.of(input.overlap, mergedModel));
    }
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.engine = MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, In.PROP_ENGINE, In.PROP_ENGINE_DEFAULT);
  }

  protected Map<String, String> getOverlapModelElementUris() {
    var overlapUris = new HashMap<String, String>();
    for (var modelElemRef1 : this.in.overlap.getModelEndpointRefs().get(0).getModelElemRefs()) { // index 0 == model1
      var modelElemRef2 = MIDRegistry.getConnectedModelElementReferences(modelElemRef1).stream().findFirst().get();
      overlapUris.put(MIDRegistry.getModelObjectUri(modelElemRef1.getObject()),
                      MIDRegistry.getModelObjectUri(modelElemRef2.getObject()));
    }

    return overlapUris;
  }

  protected void mergeAttribute(String attributeName, EObject modelObj, EObject mergedModelObj) throws MMINTException {
    var attributeValue = FileUtils.getModelObjectFeature(modelObj, attributeName);
    if (!(attributeValue instanceof String attributeStr)) {
      return;
    }
    var mergedAttributeStr = (String) FileUtils.getModelObjectFeature(mergedModelObj, attributeName);
    if (mergedAttributeStr != null && !mergedAttributeStr.equals(attributeStr)) {
      attributeValue = Merge.ATTR_MERGE_SYNTAX.replace("$1", mergedAttributeStr).replace("$2", attributeStr);
    }
    FileUtils.setModelObjectFeature(mergedModelObj, attributeName, attributeValue);
  }

  private void copyAttributes(EObject origModelObj, EObject newModelObj, boolean isMerged) throws MMINTException {
    for (var attribute : origModelObj.eClass().getEAllAttributes()) {
      if (!attribute.isChangeable() || attribute.isDerived()) {
        continue;
      }
      var attributeName = attribute.getName();
      if (isMerged) {
        mergeAttribute(attributeName, origModelObj, newModelObj);
      }
      else {
        FileUtils.setModelObjectFeature(newModelObj, attributeName,
                                        FileUtils.getModelObjectFeature(origModelObj, attributeName));
      }
    }
  }

  private void merge() throws Exception {
    var modelElemType = MIDTypeHierarchy.getRootModelElementType();
    var mappingType = MIDTypeHierarchy.getRootMappingType();

    // create merged root
    var rootModelObj1 = this.in.model1.getEMFInstanceRoot();
    var modelFactory = rootModelObj1.eClass().getEPackage().getEFactoryInstance();
    var rootMergedModelObj = modelFactory.create(rootModelObj1.eClass());
    var overlapModelElemUris = getOverlapModelElementUris(); // uri1 to uri2
    var mergedModelObjs = new HashMap<String, EObject>(); // uri2 to mergedObj
    var allModelObjs = new LinkedHashMap<EObject, EObject>(); // obj1/obj2 to mergedObj (+ we track insertion order)

    // copy elements from model1
    allModelObjs.put(rootModelObj1, rootMergedModelObj);
    copyAttributes(rootModelObj1, rootMergedModelObj, false);
    for (var iter1 = rootModelObj1.eAllContents(); iter1.hasNext(); ) {
      var modelObj1 = iter1.next();
      var mergedModelObj = modelFactory.create(modelObj1.eClass());
      allModelObjs.put(modelObj1, mergedModelObj);
      var modelElemUri1 = MIDRegistry.getModelElementUri(modelObj1);
      var isMerged = overlapModelElemUris.containsKey(modelElemUri1);
      if (isMerged) {
        var modelElemUri2 = overlapModelElemUris.get(modelElemUri1);
        mergedModelObjs.put(modelElemUri2, mergedModelObj);
      }
      // attributes
      copyAttributes(modelObj1, mergedModelObj, false);
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
        this.out.trace1.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(modelObj1, null));
      var newModelElemUri = this.out.merged.getUri() + MIDRegistry.getModelElementUri(mergedModelObj);
      var eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
      var newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
      traceModelElemRefs1.add( // merged model element is not serialized yet
        modelElemType.createInstanceAndReference(newModelElemUri, newModelElemName, eInfo,
                                                 this.out.trace1.getModelEndpointRefs().get(1)));
      var newMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, traceModelElemRefs1);
      newMappingRef.getObject().setName(traceName);
    }

    // copy elements from model2
    var rootModelObj2 = this.in.model2.getEMFInstanceRoot();
    allModelObjs.put(rootModelObj2, rootMergedModelObj);
    copyAttributes(rootModelObj2, rootMergedModelObj, true);
    for (var iter2 = rootModelObj2.eAllContents(); iter2.hasNext(); ) {
      var modelObj2 = iter2.next();
      var modelElemUri2 = MIDRegistry.getModelElementUri(modelObj2);
      var isMerged = mergedModelObjs.containsKey(modelElemUri2);
      var mergedModelObj = (isMerged) ? mergedModelObjs.get(modelElemUri2) : modelFactory.create(modelObj2.eClass());
      allModelObjs.put(modelObj2, mergedModelObj);
      // attributes
      copyAttributes(modelObj2, mergedModelObj, isMerged);
      // containment (pre-requisite for proper creation of trace rel)
      var containerObj2 = modelObj2.eContainer();
      if (containerObj2 != null && // non-root
          !mergedModelObjs.containsKey(modelElemUri2)) { // non-merged
        var mergedContainerObj = allModelObjs.get(containerObj2);
        FileUtils.setModelObjectFeature(mergedContainerObj, modelObj2.eContainingFeature().getName(), mergedModelObj);
      }
      // trace2 rel
      var traceName = (isMerged) ? Merge.TRACE_MERGED_NAME : Merge.TRACE_COPIED_NAME;
      var traceModelElemRefs2 = new BasicEList<ModelElementReference>();
      traceModelElemRefs2.add(
        this.out.trace2.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(modelObj2, null));
      var newModelElemUri = this.out.merged.getUri() + MIDRegistry.getModelElementUri(mergedModelObj);
      var eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
      var newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
      traceModelElemRefs2.add( // merged model element is not serialized yet
        modelElemType.createInstanceAndReference(newModelElemUri, newModelElemName, eInfo,
                                                 this.out.trace2.getModelEndpointRefs().get(1)));
      var newMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, traceModelElemRefs2);
      newMappingRef.getObject().setName(traceName);
    }

    // populate references (runs twice for merged objects, merging non-containment references of both sides)
    for (var entry : allModelObjs.entrySet()) {
      var modelObj = entry.getKey();
      var mergedModelObj = entry.getValue();
      for (var reference : modelObj.eClass().getEAllReferences()) {
        if (reference.isContainment() || !reference.isChangeable() || reference.isDerived()) {
          continue;
        }
        var referenceValue = FileUtils.getModelObjectFeature(modelObj, reference.getName());
        if (referenceValue == null || referenceValue instanceof EObjectWithInverseResolvingEList<?>) {
          continue;
        }
        var referenceModelObjs = (referenceValue instanceof EList<?>) ?
          (EList<EObject>) referenceValue :
          ECollections.asEList((EObject) referenceValue);
        for (var referenceModelObj : referenceModelObjs) {
          // the default part handles reference to external element
          var referenceMergedModelObj = allModelObjs.getOrDefault(referenceModelObj, referenceModelObj);
          FileUtils.setModelObjectFeature(mergedModelObj, reference.getName(), referenceMergedModelObj);
        }
      }
    }

    // store merged model
    FileUtils.writeModelFile(rootMergedModelObj, this.out.merged.getUri(), null, true);

    // merge rel
    for (var overlapMapping : this.in.overlap.getMappings()) {
      var mergeModelElemRefs = new BasicEList<ModelElementReference>();
      mergeModelElemRefs.add(this.out.mergeTrace.getModelEndpointRefs().get(0)
        .createModelElementInstanceAndReference(overlapMapping, null));
      var modelElemUri2 = overlapMapping.getModelElemEndpointRefs().stream()
        .map(mee -> MIDRegistry.getModelObjectUri(mee.getObject().getTarget()))
        .filter(u -> this.in.model2.getUri().equals(MIDRegistry.getModelUri(u)))
        .findFirst().get();
      var mergedModelObj = mergedModelObjs.get(modelElemUri2);
      mergeModelElemRefs.add(this.out.mergeTrace.getModelEndpointRefs().get(1)
        .createModelElementInstanceAndReference(mergedModelObj, null));
      var mergeMappingRef = mappingType.createInstanceAndReferenceAndEndpointsAndReferences(true, mergeModelElemRefs);
      mergeMappingRef.getObject().setName(Merge.TRACE_MERGED_NAME);
    }
  }

  protected String kMergeDebugCall() {
    return "  val merged = merge(create" + this.in.model1.getName() + "(), create" + this.in.model2.getName() +
             "(), overlap)\n" +
           "}\n";
  }

  private void kMergeDebug() throws Exception {
    this.kConverter.modelToKFile(this.in.model1, FileUtils.replaceFileExtensionInPath(this.in.model1.getUri(), "kt"),
                                 true);
    this.kConverter.modelToKFile(this.in.model2, FileUtils.replaceFileExtensionInPath(this.in.model2.getUri(), "kt"),
                                 true);
    var overlapKVal = "package edu.toronto.cs.se.mmint.kotlin.operators.examples\n" +
                      "import edu.toronto.cs.se.mmint.kotlin.structs.*\n\n" +
                      "import edu.toronto.cs.se.mmint.kotlin.operators.merge.*\n\n" +
                      "import edu.toronto.cs.se.mmint.mid.reasoning.ISATReasoner\n\n" +
                      "fun main() {\n" +
                      "  val overlap = mapOf(\n";
    overlapKVal += getOverlapModelElementUris().entrySet().stream()
      .map(e -> "    \"" + e.getKey() + "\" to \"" + e.getValue() + "\"")
      .collect(Collectors.joining(",\n"));
    overlapKVal += ")\n" + kMergeDebugCall();
    FileUtils.createTextFile(FileUtils.replaceLastSegmentInPath(this.in.model1.getUri(), "debug.kt"), overlapKVal, true);
  }

  protected Tree<? extends Object> kMerge(Tree<Object> kModel1, Tree<Object> kModel2, Map<String, String> overlap) {
    return EntryKt.merge(kModel1, kModel2, overlap);
  }

  private void kMerge() throws Exception {
    var kModel1 = this.kConverter.modelToKTree(this.in.model1);
    var kModel2 = this.kConverter.modelToKTree(this.in.model2);
    var kMergedModel = kMerge(kModel1, kModel2, getOverlapModelElementUris());
    var modelPackage = this.in.model1.getEMFInstanceRoot().eClass().getEPackage();
    var rootMergedModelObj = this.kConverter.kTreeToModel(kMergedModel, modelPackage);
    FileUtils.writeModelFile(rootMergedModelObj, this.out.merged.getUri(), null, true);
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new In(inputsByName);
    this.out = new Out(this, outputMIDsByName);
    if (this.engine.equals("kotlin")) {
      this.kConverter = new KotlinConverter();
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    var startTime = System.nanoTime();
    switch(this.engine) {
      case "kotlin" -> kMerge();
      case "java" -> merge();
      default -> merge();
    }
    this.out.timeMerge = System.nanoTime() - startTime;

    return this.out.packed();
  }
}
