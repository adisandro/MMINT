/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Map extends NestingOperatorImpl {

  // input-output
  private final static @NonNull String IN_MIDS = "mids";
  private final static @NonNull String OUT_MIDS = "mappedMids";
  private final static @NonNull String GENERIC_OPERATORTYPE = "MAPPER";
  private final static @NonNull String PROP_OUT_TIMEOVERHEAD = "timeOverhead";
  private boolean timeOverheadEnabled;
  private long timeOverhead;
  private long timeCheckpoint;
  // constants
  private final static @NonNull String MIDREL_MODELTYPE_URI_SUFFIX = "Rel";

  public static class OperatorConstraint implements IJavaOperatorConstraint {

    @Override
    public boolean isAllowedGeneric(@NonNull GenericEndpoint genericTypeEndpoint, @NonNull GenericElement genericType, @NonNull List<OperatorInput> inputs) {

      final String FILTER_URI = "http://se.cs.toronto.edu/mmint/Operator_Filter";
      final String FILTERNOT_URI = "http://se.cs.toronto.edu/mmint/Operator_FilterNot";
      final String MAP_URI = "http://se.cs.toronto.edu/mmint/Operator_Map";
      final String REDUCE_URI = "http://se.cs.toronto.edu/mmint/Operator_Reduce";
      if (genericType.getUri().equals(FILTER_URI) || genericType.getUri().equals(FILTERNOT_URI) ||
          genericType.getUri().equals(MAP_URI) || genericType.getUri().equals(REDUCE_URI)) {
        return false;
      }
      return true;
    }
  }

  @Override
  public void readInputProperties(Properties inputProps) throws MMINTException {
    this.timeOverheadEnabled = MIDOperatorIOUtils.getOptionalBoolProperty(
                                 inputProps, Map.PROP_OUT_TIMEOVERHEAD+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX,
                                 false);
  }

  public void writeOutputProperties() throws Exception {
    var outProps = new Properties();
    outProps.setProperty(Map.PROP_OUT_TIMEOVERHEAD, String.valueOf(this.timeOverhead));
    MIDOperatorIOUtils.writeOutputProperties(this, outProps);
  }

  @Override
  public void createWorkflowInstanceOutputs(Operator newOperator, java.util.Map<String, Model> inputsByName,
                                            MID workflowMID) throws MMINTException {

    // create the vararg mapped mids
    var mapperOperatorType = (Operator) newOperator.getGenerics().get(0).getTarget();
    var midModelType = MIDTypeRegistry.getMIDModelType();
    var midrelModelType = MIDTypeRegistry.<Model>getType(MIDPackage.eNS_URI + Map.MIDREL_MODELTYPE_URI_SUFFIX);
    for (var i = 0; i < mapperOperatorType.getOutputs().size(); i++) {
      var outputModelType = (mapperOperatorType.getOutputs().get(i).getTarget() instanceof ModelRel) ?
        midrelModelType :
        midModelType;
      var outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
      var outputModel = outputModelType.createWorkflowInstance(outputModelId, workflowMID);
      var outputModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
        outputModel, newOperator, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
      outputModelEndpoint.setName(outputModelEndpoint.getName() + i);
    }
  }

  private void createOutputMIDRelShortcuts(Model outputMIDModel, Model midModelType, String midDiagramPluginId,
                                           Set<Model> midrelEndpointModels) throws Exception {

    var outputMIDModelDiagram = MIDRegistry.getModelDiagram(outputMIDModel);
    var gmfDiagram = (Diagram) FileUtils.readModelFile(outputMIDModelDiagram.getUri(), null, true);
    for (var midrelEndpointModel : midrelEndpointModels) {
      GMFUtils.createGMFNodeShortcut(midrelEndpointModel, gmfDiagram, midDiagramPluginId, midModelType.getName(),
                                     MIDTypeRegistry.getCachedMIDViewProvider());
    }
    FileUtils.writeModelFile(gmfDiagram, outputMIDModelDiagram.getUri(), true);
  }

  private java.util.@NonNull Map<String, Model> map(@NonNull List<Model> inputMIDModels, @NonNull EList<MID> inputMIDs,
                                                    Operator mapperOperatorType, java.util.@NonNull Map<Operator,
                                                    Set<EList<OperatorInput>>> mapperSpecs,
                                                    java.util.@NonNull Map<String, MID> instanceMIDsByMapperOutput)
                                                    throws Exception {

    // create output MIDs and pre-serialize them:
    // it is necessary if the mapper is a nesting operator, does not hurt for other mappers
    var mapperOutputMIDsByName = new HashMap<String, MID>();
    var mapperOutputMIDPathsByName = new HashMap<String, String>();
    for (var mapperOutputEndpoint : mapperOperatorType.getOutputs()) {
      var outputName = mapperOutputEndpoint.getName();
      var outputMID = MIDFactory.eINSTANCE.createMID();
      mapperOutputMIDsByName.put(outputName, outputMID);
      var instanceMID = instanceMIDsByMapperOutput.get(outputName);
      var baseOutputPath = (instanceMID == null) ?
        MMINT.getActiveInstanceMIDFile().getFullPath().toOSString() :
        MIDRegistry.getModelUri(instanceMID);
      var outputMIDPath = FileUtils.getUniquePath(FileUtils.replaceFileNameInPath(baseOutputPath, outputName), true,
                                                  false);
      mapperOutputMIDPathsByName.put(outputName, outputMIDPath);
      if (instanceMID != null) {
        FileUtils.writeModelFile(outputMID, outputMIDPath, true);
      }
    }

    // start operator types
    var mapperMIDPath = this.getNestedMIDPath();
    var mapperMID = super.getNestedInstanceMID();
    var midrelEndpointModelsByOutputName = new HashMap<String, Set<Model>>();
    var mapperShortcutModels = new HashSet<Model>();
    java.util.Map<String, Model> sameInOut = null;
    for (var mapperSpec : mapperSpecs.entrySet()) {
      var mapper = mapperSpec.getKey();
      for (var mapperInputs : mapperSpec.getValue()) {
        try {
          var mapperGenerics = mapper.selectAllowedGenerics(mapperInputs);
          var workingPath = getWorkingPath();
          if (workingPath != null) {
            mapper.setWorkingPath(workingPath);
          }
          if (this.timeOverheadEnabled) {
            this.timeOverhead += System.nanoTime() - this.timeCheckpoint;
          }
          var mapperOperator = mapper.startInstance(mapperInputs, null, mapperGenerics, mapperOutputMIDsByName,
                                                    mapperMID);
          if (this.timeOverheadEnabled) {
            this.timeCheckpoint = System.nanoTime();
          }
          var mapperOutputsByName = mapperOperator.getOutputsByName();
          if (sameInOut == null) {
            // detect mapper outputs that are identical to inputs, in order to properly handle map output MIDs
            // e.g. it can happen when using the Identity operator
            //TODO MMINT[MAP] This is not correct with polymorphism, the first executed operator may not represent all
            sameInOut = new HashMap<>();
            for (var i = 0; i < mapperInputs.size(); i++) {
              var mapperInput = mapperInputs.get(i);
              var outputNames = mapperOutputsByName.entrySet().stream()
                .filter(e -> e.getValue() == mapperInput.getModel())
                .map(Entry::getKey)
                .collect(Collectors.toSet());
              if (!outputNames.isEmpty()) {
                var j = Math.min(i, inputMIDModels.size()-1); // there may not be a 1-to-1 correspondence
                for (var outputName : outputNames) {
                  sameInOut.put(outputName, inputMIDModels.get(j));
                }
              }
            }
          }
          if (mapperMIDPath != null) {
            mapperShortcutModels.addAll(mapperInputs.stream()
              .map(OperatorInput::getModel)
              .collect(Collectors.toList()));
            mapperShortcutModels.addAll(mapperOutputsByName.values());
          }
          // get model shortcuts to create for output MIDRels (to model endpoints)
          for (var mapperOutput : mapperOutputsByName.entrySet()) {
            var mapperOutputModel = mapperOutput.getValue();
            if (!(mapperOutputModel instanceof ModelRel)) {
              continue;
            }
            var mapperOutputName = mapperOutput.getKey();
            var newMidrelEndpointModels = ((ModelRel) mapperOutputModel).getModelEndpoints().stream()
              .map(ModelEndpoint::getTarget)
              .collect(Collectors.toSet());
            var midrelEndpointModels = midrelEndpointModelsByOutputName.putIfAbsent(mapperOutputName,
                                                                                    newMidrelEndpointModels);
            if (midrelEndpointModels != null) {
              midrelEndpointModels.addAll(newMidrelEndpointModels);
            }
            //TODO MMINT[MAP] Not needed unless we reactivate the fake endpoints
//            Set<MID> newMidrelEndpointMIDs = ((ModelRel) mapperOutputModel).getModelEndpoints().stream()
//              .map(modelEndpoint -> modelEndpoint.getTarget().getMIDContainer())
//              .collect(Collectors.toSet());
//            Set<MID> midrelEndpointMIDs = midrelEndpointMIDsByOutputName.putIfAbsent(
//              mapperOutputName,
//              newMidrelEndpointMIDs);
//            if (midrelEndpointMIDs != null) {
//              midrelEndpointMIDs.addAll(newMidrelEndpointMIDs);
//            }
          }
        }
        catch (Exception e) {
          // other than errors, the operator can fail because of input constraints due to the cartesian product
          MMINTException.print(IStatus.WARNING, "Operator " + mapper + " execution error, skipping it", e);
        }
      }
    }

    // store all involved MIDs
    var outputMIDModels = new ArrayList<Model>();
    // pass 1: output MIDs only
    var midModelType = MIDTypeRegistry.getMIDModelType();
    for (var outputMIDByName : mapperOutputMIDsByName.entrySet()) {
      var outputName = outputMIDByName.getKey();
      if (midrelEndpointModelsByOutputName.containsKey(outputName)) { // is a MIDRel
        continue;
      }
      var outputMID = outputMIDByName.getValue();
      var outputMIDPath = mapperOutputMIDPathsByName.get(outputName);
      var instanceMID = instanceMIDsByMapperOutput.get(outputName);
      if (sameInOut.containsKey(outputName)) { // handle mapper outputs that are identical to inputs, e.g. Identity
        outputMIDModels.add(sameInOut.get(outputName));
        if (instanceMID != null) {
          FileUtils.deleteFile(outputMIDPath, true);
        }
        continue;
      }
      var outputMIDModel = midModelType.createInstanceAndEditor(outputMID, outputMIDPath, instanceMID);
      outputMIDModels.add(outputMIDModel);
    }
    // pass 2: output MIDRels only
    var midrelModelType = MIDTypeRegistry.<Model>getType(MIDPackage.eNS_URI + Map.MIDREL_MODELTYPE_URI_SUFFIX);
    var midDiagramPluginId = MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName();
    for (var outputMIDByName : mapperOutputMIDsByName.entrySet()) {
      var outputName = outputMIDByName.getKey();
      if (!midrelEndpointModelsByOutputName.containsKey(outputName)) { // is not a MIDRel
        continue;
      }
      var outputMID = outputMIDByName.getValue();
      var outputMIDPath = mapperOutputMIDPathsByName.get(outputName);
      var instanceMID = instanceMIDsByMapperOutput.get(outputName);
      if (sameInOut.containsKey(outputName)) { // handle mapper outputs that are identical to inputs, e.g. Identity
        outputMIDModels.add(sameInOut.get(outputName));
        if (instanceMID != null) {
          FileUtils.deleteFile(outputMIDPath, true);
        }
        continue;
      }
      var outputMIDModel = midrelModelType.createInstanceAndEditor(outputMID, outputMIDPath, instanceMID);
      outputMIDModels.add(outputMIDModel);
      if (instanceMID != null) {
        createOutputMIDRelShortcuts(outputMIDModel, midModelType, midDiagramPluginId,
                                    midrelEndpointModelsByOutputName.get(outputName));
        //TODO MMINT[MAP] A MIDRel is just a Model, so this was to fake it to have endpoints (a proper metamodel object and gmf figure would be needed)
//      for (MID midrelEndpointMID : midrelEndpointMIDsByOutputName.get(outputName)) {
//        if (midrelEndpointMID != instanceMID) { // can't create the rel
//          continue;
//        }
//        Model midrelEndpointMIDModel = instanceMID.getExtendibleElement(MIDRegistry.getModelUri(midrelEndpointMID));
//        MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
//          null,
//          midrelEndpointMIDModel.getName(),
//          outputMIDModel,
//          midrelEndpointMIDModel,
//          instanceMID);
//      }
      }
    }
    // pass 3: mapper MID, after output MIDs and MIDRels are serialized
    if (mapperMIDPath != null) {
      createNestedInstanceMIDModelShortcuts(mapperShortcutModels);
      writeNestedInstanceMID();
    }
    // pass 4: input MIDs and endpoint MIDs of input MIDRels, since model elements can be created there
    var inputMIDsToSerialize = new HashMap<String, MID>();
    var inputMIDRels = new HashSet<MID>();
    for (int i = 0; i < inputMIDModels.size(); i++) {
      var inputMID = inputMIDs.get(i);
      if (MIDTypeHierarchy.instanceOf(inputMIDModels.get(i), midrelModelType.getUri(), false)) {
        inputMIDRels.add(inputMID);
        continue;
      }
      inputMIDsToSerialize.put(inputMIDModels.get(i).getUri(), inputMID);
    }
    for (var inputMIDRel : inputMIDRels) {
      var endpointMIDs = inputMIDRel.getModelRels().stream()
        .flatMap(modelRel -> modelRel.getModelEndpoints().stream()
        .map(modelEndpoint -> modelEndpoint.getTarget()))
        .map(model -> model.getMIDContainer())
        .collect(Collectors.toMap(mid -> MIDRegistry.getModelUri(mid), mid -> mid, (mid1, mid2) -> mid1)); // duplicates should simply be used once
      inputMIDsToSerialize.putAll(endpointMIDs);
    }
    for (var inputMIDToSerialize : inputMIDsToSerialize.entrySet()) {
      FileUtils.writeModelFile(inputMIDToSerialize.getValue(), inputMIDToSerialize.getKey(), true);
    }

    return MIDOperatorIOUtils.setVarargs(outputMIDModels, Map.OUT_MIDS);
  }

  private java.util.@NonNull Map<String, EList<OperatorInput>> diffMultipleDispatchInputs(java.util.@NonNull Map<String, EList<OperatorInput>> assignedInputs, @NonNull Set<EList<OperatorInput>> mapperInputs) {

    var newInputs = new LinkedHashMap<String, EList<OperatorInput>>(); // reproducible order
    for (var mapperInput : mapperInputs) {
      var key = mapperInput.stream()
        .map(input -> MIDRegistry.getModelElementUri(input.getModel()))
        .collect(Collectors.joining(";"));
      if (!assignedInputs.containsKey(key)) {
        newInputs.put(key, mapperInput);
      }
    }

    return newInputs;
  }

  @Override
  public java.util.Map<String, Model> run(
      java.util.Map<String, Model> inputsByName, java.util.Map<String, GenericElement> genericsByName,
      java.util.Map<String, MID> outputMIDsByName) throws Exception {

    if (this.timeOverheadEnabled) {
      this.timeOverhead = 0;
      this.timeCheckpoint = System.nanoTime();
    }
    // input
    List<Model> inputMIDModels = MIDOperatorIOUtils.getVarargs(inputsByName, Map.IN_MIDS);
    EList<MID> inputMIDs = ECollections.newBasicEList();
    EList<Set<Model>> modelBlacklists = ECollections.newBasicEList();
    for (Model inputMIDModel : inputMIDModels) {
      inputMIDs.add((MID) inputMIDModel.getEMFInstanceRoot());
      modelBlacklists.add(new HashSet<>());
    }
    Operator mapperOperatorType = (Operator) genericsByName.get(Map.GENERIC_OPERATORTYPE);
    java.util.Map<String, MID> instanceMIDsByMapperOutput = MIDOperatorIOUtils.getVarargOutputMIDsByOtherName(outputMIDsByName, Map.OUT_MIDS, mapperOperatorType.getOutputs());

    // find all possible combinations of inputs and execute them
    var mapperSpecs = new LinkedHashMap<Operator, Set<EList<OperatorInput>>>(); // reproducible order
    var polyMappers = ECollections.newBasicEList(mapperOperatorType);
    if (Boolean.parseBoolean(MMINT.getPreference(
                               MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_MULTIPLEDISPATCH_ENABLED))) {
      polyMappers.addAll(MIDTypeHierarchy.getSubtypes(mapperOperatorType));
    }
    if (polyMappers.size() == 1) { // multiple dispatch disabled, or the mapper is not a multimethod
      mapperSpecs.put(mapperOperatorType, mapperOperatorType.findAllowedInputs(inputMIDs, modelBlacklists));
    }
    else {
      var assignedInputs = new HashMap<String, EList<OperatorInput>>();
      var polyIter = MIDTypeHierarchy.getInverseTypeHierarchyIterator(polyMappers);
      while (polyIter.hasNext()) { // start from the most specialized operator backwards
        var polyMapper = polyIter.next();
        // assign at each step the allowed inputs that have not been already assigned
        var mapperInputs = polyMapper.findAllowedInputs(inputMIDs, modelBlacklists);
        var newInputs = this.diffMultipleDispatchInputs(assignedInputs, mapperInputs);
        mapperSpecs.put(polyMapper, new LinkedHashSet<>(newInputs.values())); // reproducible order
        assignedInputs.putAll(newInputs);
      }
    }
    var outputsByName = map(inputMIDModels, inputMIDs, mapperOperatorType, mapperSpecs, instanceMIDsByMapperOutput);
    if (this.timeOverheadEnabled) {
      this.timeOverhead += System.nanoTime() - this.timeCheckpoint;
      writeOutputProperties();
    }

    return outputsByName;
  }

}
