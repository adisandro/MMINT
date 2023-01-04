/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
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
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class Reduce extends NestingOperatorImpl {

  // input-output
  private final static @NonNull String IN_MID = "mid";
  private final static @NonNull String OUT_MID = "reducedMid";
  private final static @NonNull String GENERIC_OPERATORTYPE = "ACCUMULATOR";
  private final static @NonNull String PROP_OUT_TIMEOVERHEAD = "timeOverhead";
  private boolean timeOverheadEnabled;
  private long timeOverhead;
  private long timeCheckpoint;
  // constants
  private final static @NonNull String REDUCED_MID_NAME = "reduced";
  private final static @NonNull String MODELRELCOMPOSITION_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelComposition";
  private final static @NonNull String MODELRELMERGE_OPERATORTYPE_URI = "http://se.cs.toronto.edu/mmint/Operator_ModelRelMerge";

  public static class OperatorConstraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkGeneric(@NonNull GenericEndpoint genericTypeEndpoint, @NonNull GenericElement genericType, @NonNull List<OperatorInput> inputs) {
      final var FILTER_URI = "http://se.cs.toronto.edu/mmint/Operator_Filter";
      final var FILTERNOT_URI = "http://se.cs.toronto.edu/mmint/Operator_FilterNot";
      final var MAP_URI = "http://se.cs.toronto.edu/mmint/Operator_Map";
      final var REDUCE_URI = "http://se.cs.toronto.edu/mmint/Operator_Reduce";
      if (
        genericType.getUri().equals(FILTER_URI) || genericType.getUri().equals(FILTERNOT_URI) ||
        genericType.getUri().equals(MAP_URI) || genericType.getUri().equals(REDUCE_URI)
      ) {
        return false;
      }
      return true;
    }

    @Override
    public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                        Map<String, Model> inputsByName,
                                                                        Map<String, Model> outputsByName) {
      final var MODELREL_ID = "http://se.cs.toronto.edu/mmint/ModelRel";
      final var MIDREL_ID = "http://se.cs.toronto.edu/mmint/MIDRel";
      var inputMIDModel = inputsByName.get(Reduce.IN_MID);
      var accumulatorOperatorType = (Operator) genericsByName.get(Reduce.GENERIC_OPERATORTYPE);
      // if input is a MIDRel and accumulator creates model rels only, then output is a MIDRel too
      if (MIDTypeHierarchy.instanceOf(inputMIDModel, MIDREL_ID, false) &&
          accumulatorOperatorType.getOutputs().stream()
            .map(ModelEndpoint::getTargetUri)
            .allMatch(id -> id.equals(MODELREL_ID) || MIDTypeHierarchy.isSubtypeOf(id, MODELREL_ID))) {
        var reducedMIDModel = outputsByName.get(Reduce.OUT_MID);
        reducedMIDModel.setMetatypeUri(MIDREL_ID);
      }
      return Map.of();
    }
  }

  @Override
  public void readInputProperties(Properties inputProps) throws MMINTException {
    this.timeOverheadEnabled = MIDOperatorIOUtils.getOptionalBoolProperty(
                                 inputProps, Reduce.PROP_OUT_TIMEOVERHEAD+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX, false);
  }

  public void writeOutputProperties() throws Exception {
    var outProps = new Properties();
    outProps.setProperty(Reduce.PROP_OUT_TIMEOVERHEAD, String.valueOf(this.timeOverhead));
    MIDOperatorIOUtils.writeOutputProperties(this, outProps);
  }

  private @NonNull Set<ModelRel> getConnectedModelRels(@NonNull MID instanceMID, @NonNull Set<Model> models, @NonNull Set<ModelRel> modelRelBlacklist) {

    //TODO MMINT[OO] This is expensive, need a direct way to reach model rels from models
    var connectedModelRels = instanceMID.getModelRels().stream()
      .filter(modelRel -> !modelRelBlacklist.contains(modelRel))
      .filter(modelRel -> modelRel.getModelEndpoints().stream()
        .anyMatch(modelEndpoint -> models.contains(modelEndpoint.getTarget())))
      .collect(Collectors.toSet());

    return connectedModelRels;
  }

  private @NonNull MID reduce(@NonNull Model inputMIDModel, @NonNull Operator accumulatorOperatorType)
      throws Exception {

    var reducedMID = (MID) inputMIDModel.getEMFInstanceRoot();
    var initialModels = new ArrayList<>(reducedMID.getModels());
    var nestedMIDPath = super.getNestedMIDPath();
    var composeOperatorType = MIDTypeRegistry.<Operator>getType(Reduce.MODELRELCOMPOSITION_OPERATORTYPE_URI);
    var mergeOperatorType = MIDTypeRegistry.<Operator>getType(Reduce.MODELRELMERGE_OPERATORTYPE_URI);
    // reduce loop
    EList<OperatorInput> accumulatorInputs = null;
    Map<String, Model> accumulatorOutputsByName = null;
    var accumulatorOutputModels = new LinkedHashSet<Model>(); // reproducible order
    var intermediateModelsAndRels = new LinkedHashSet<Model>(); // reproducible order
    var polyAccumulators = ECollections.newBasicEList(accumulatorOperatorType);
    if (Boolean.parseBoolean(MMINT.getPreference(
                               MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_MULTIPLEDISPATCH_ENABLED))) {
      polyAccumulators.addAll(MIDTypeHierarchy.getSubtypes(accumulatorOperatorType));
    }
    var i = 0;
    while (true) {
      var inputMIDs = ECollections.newBasicEList(reducedMID);
      var inputModelBlacklists = ECollections.<Set<Model>>newBasicEList(intermediateModelsAndRels);
      var accumulator = accumulatorOperatorType;
      accumulatorInputs = accumulator.findFirstAllowedInput(inputMIDs, inputModelBlacklists);
      if (accumulatorInputs == null) { // no more inputs to reduce
        break;
      }
      if (polyAccumulators.size() > 1) { // polymorphic multiple dispatch
        var accumulatorInputModels = ECollections.toEList(accumulatorInputs.stream()
          .map(OperatorInput::getModel)
          .collect(Collectors.toList()));
        var polyIter = MIDTypeHierarchy.getInverseTypeHierarchyIterator(polyAccumulators);
        while (polyIter.hasNext()) { // start from the most specialized operator backwards
          var polyAccumulator = polyIter.next();
          accumulatorInputs = polyAccumulator.checkAllowedInputs(accumulatorInputModels);
          if (accumulatorInputs != null) {
            accumulator = polyAccumulator;
            break;
          }
        }
      }
      var accumulatorInputModels = new HashSet<Model>();
      var accumulatorInputModelRels = new HashSet<ModelRel>();
      try {
        // get all model inputs, including the ones attached to model rel inputs
        for (OperatorInput accumulatorInput : accumulatorInputs) {
          var accumulatorInputModel = accumulatorInput.getModel();
          if (accumulatorInputModel instanceof ModelRel) {
            accumulatorInputModels.addAll(((ModelRel) accumulatorInputModel).getModelEndpoints().stream()
              .map(ModelEndpoint::getTarget)
              .collect(Collectors.toSet()));
            accumulatorInputModelRels.add((ModelRel) accumulatorInputModel);
          }
          else {
            accumulatorInputModels.add(accumulatorInputModel);
          }
        }
        // get all model rels attached to input models that are not inputs themselves or intermediate artifacts
        var modelRelBlacklist = Stream.concat(
          accumulatorInputModelRels.stream(),
          intermediateModelsAndRels.stream()
            .filter(modelRel -> modelRel instanceof ModelRel)
            .map(modelRel -> (ModelRel) modelRel))
            .collect(Collectors.toSet());
        var connectedModelRels = this.getConnectedModelRels(reducedMID, accumulatorInputModels, modelRelBlacklist);

        // pass 1: run the ACCUMULATOR operator
        var accumulatorOutputMIDsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(accumulator, reducedMID);
        var accumulatorGenerics = accumulator.selectAllowedGenerics(accumulatorInputs);
        var workingPath = getWorkingPath();
        if (workingPath != null) {
          accumulator.setWorkingPath(workingPath);
        }
        if (this.timeOverheadEnabled) {
          this.timeOverhead += System.nanoTime() - this.timeCheckpoint;
        }
        var accumulatorOperator = accumulator.startInstance(accumulatorInputs, null, accumulatorGenerics,
                                                            accumulatorOutputMIDsByName,
                                                            (nestedMIDPath != null) ? reducedMID : null);
        if (this.timeOverheadEnabled) {
          this.timeCheckpoint = System.nanoTime();
        }
        accumulatorOperator.setName(accumulatorOperator.getName() + i);
        accumulatorOutputsByName = accumulatorOperator.getOutputsByName();
        accumulatorOutputModels.addAll(accumulatorOutputsByName.values());

        // pass 2: compose each model rel in the output that is connected with the input models
        var composeOutputMIDsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(composeOperatorType,
                                                                                        reducedMID);
        var composedModelRels = new HashSet<ModelRel>();
        var compositeModelRels = new ArrayList<ModelRel>();
        for (var connectedModelRel : connectedModelRels) {
          for (var accumulatorOutputModelRel : accumulatorOutputsByName.values()) {
            if (!(accumulatorOutputModelRel instanceof ModelRel)) {
              continue;
            }
            try {
              var composeInputs = composeOperatorType.checkAllowedInputs(
                ECollections.newBasicEList(connectedModelRel, accumulatorOutputModelRel));
              if (composeInputs == null) {
                continue;
              }
              var composeOperator = composeOperatorType.startInstance(composeInputs, null, ECollections.emptyEList(),
                                                                      composeOutputMIDsByName,
                                                                      (nestedMIDPath != null) ? reducedMID : null);
              if (nestedMIDPath != null) {
                composeOperator.setName(composeOperator.getName() + i);
              }
              composedModelRels.add(connectedModelRel);
              var composeOutputsByName = composeOperator.getOutputsByName();
              compositeModelRels.add((ModelRel) composeOutputsByName.get(
                composeOperatorType.getOutputs().get(0).getName()));
            }
            catch (Exception e) {
              MMINTException.print(IStatus.WARNING, "Operator " + composeOperatorType + " execution error, skipping it",
                                   e);
            }
          }
        }
        // exclude connected model rels that were composed
        if (nestedMIDPath != null) {
          intermediateModelsAndRels.addAll(composedModelRels);
        }
        else {
          for (var composedModelRel : composedModelRels) {
            try {
              composedModelRel.deleteInstance();
            }
            catch (MMINTException e) {}
          }
        }

        // pass 3: merge model rels that have been composed and share the same model endpoints
        var mergeOutputMIDsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(mergeOperatorType, reducedMID);
        var mergedModelRels = new HashSet<ModelRel>();
        for (var j = 0; j < compositeModelRels.size(); j++) {
          var compositeModelRel1 = compositeModelRels.get(j);
          for (var k = j+1; k < compositeModelRels.size(); k++) {
            var compositeModelRel2 = compositeModelRels.get(k);
            try {
              var mergeInputs = mergeOperatorType.checkAllowedInputs(
                ECollections.newBasicEList(compositeModelRel1, compositeModelRel2));
              if (mergeInputs == null) {
                continue;
              }
              var mergeOperator = mergeOperatorType.startInstance(mergeInputs, null, ECollections.emptyEList(),
                                                                  mergeOutputMIDsByName,
                                                                  (nestedMIDPath != null) ? reducedMID : null);
              if (nestedMIDPath != null) {
                mergeOperator.setName(mergeOperator.getName() + i);
              }
              mergedModelRels.add(compositeModelRel1);
              mergedModelRels.add(compositeModelRel2);
            }
            catch (Exception e) {
              MMINTException.print(IStatus.WARNING, "Operator " + mergeOperatorType + " execution error, skipping it",
                                   e);
            }
          }
        }
        // exclude composed model rels that were merged
        if (nestedMIDPath != null) {
          intermediateModelsAndRels.addAll(mergedModelRels);
        }
        else {
          for (var mergedModelRel : mergedModelRels) {
            try {
              mergedModelRel.deleteInstance();
            }
            catch (MMINTException e) {}
          }
        }
      }

      // pass 4: clean up to prevent endless loops, even in case of failure
      catch (Exception e) {
        MMINTException.print(IStatus.WARNING, "Operator " + accumulator + " execution error, skipping it", e);
      }
      //TODO MMINT[REDUCE] This code does not work well with MIDRels, which have shortcuts to models in other MIDs
      finally {
        if (nestedMIDPath != null) {
          // exclude accumulator inputs
          intermediateModelsAndRels.addAll(accumulatorInputModels);
          intermediateModelsAndRels.addAll(accumulatorInputModelRels);
        }
        else {
          // delete accumulator input models
          // (connected binary model rels are deleted as a side effect, composed included)
          for (var accumulatorInputModel : accumulatorInputModels) {
            try {
              if (accumulatorOutputModels.contains(accumulatorInputModel)) { // intermediate artifact
                accumulatorInputModel.deleteInstanceAndFile();
                accumulatorOutputModels.remove(accumulatorInputModel);
              }
              else { // initial input
                accumulatorInputModel.deleteInstance();
              }
            }
            catch (MMINTException e) {}
          }
          // delete accumulator input nary model rels
          for (var accumulatorInputModelRel : accumulatorInputModelRels) {
            if (accumulatorInputModelRel instanceof BinaryModelRel) {
              continue;
            }
            accumulatorInputModelRel.deleteInstance();
          }
        }
        i++;
      }
    }
    if (nestedMIDPath != null) {
      super.inMemoryNestedMID = reducedMID;
      //TODO MMINT[NESTED] Transform input/output into shortcuts before serializing it
      super.writeNestedInstanceMID();
      var reducedModels = accumulatorOutputModels.stream()
        .filter(outputModel -> !intermediateModelsAndRels.contains(outputModel))
        .collect(Collectors.toCollection(LinkedHashSet::new)); // reproducible order
      var intermediateModelRels = intermediateModelsAndRels.stream()
        .filter(modelRel -> modelRel instanceof ModelRel)
        .map(modelRel -> (ModelRel) modelRel)
        .collect(Collectors.toCollection(LinkedHashSet::new)); // reproducible order
      reducedModels.addAll(this.getConnectedModelRels(reducedMID, reducedModels, intermediateModelRels));
      reducedMID = MIDFactory.eINSTANCE.createMID();
      reducedMID.setLevel(MIDLevel.INSTANCES);
      //TODO MMINT[REDUCE] How to handle initial rels that are composed/merged? 1) need to be tracked 2) may need to become unary if endpoints are reduced
      for (var initialModel : initialModels) {
        if (initialModel instanceof ModelRel || intermediateModelsAndRels.contains(initialModel)) {
          continue;
        }
        initialModel.getMetatype().importInstanceAndEditor(initialModel.getUri(), reducedMID);
      }
      for (var initialModelRel : initialModels) {
        if (!(initialModelRel instanceof ModelRel) || intermediateModelsAndRels.contains(initialModelRel)) {
          continue;
        }
        ((ModelRel) initialModelRel).getMetatype().copyInstance(initialModelRel, initialModelRel.getName(), reducedMID);
      }
      for (var reducedModel : reducedModels) {
        if (reducedModel instanceof ModelRel) {
          continue;
        }
        reducedModel.getMetatype().importInstanceAndEditor(reducedModel.getUri(), reducedMID);
      }
      for (var reducedModelRel : reducedModels) {
        if (!(reducedModelRel instanceof ModelRel)) {
          continue;
        }
        ((ModelRel) reducedModelRel).getMetatype().copyInstance(reducedModelRel, reducedModelRel.getName(), reducedMID);
      }
    }
    // reset input mid's cached EMF fields, or they will point to the reduced ones
    inputMIDModel.setEMFInstanceResource(null);
    inputMIDModel.setEMFInstanceRoot(null);

    return reducedMID;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
      Map<String, MID> outputMIDsByName) throws Exception {

    if (this.timeOverheadEnabled) {
      this.timeOverhead = 0;
      this.timeCheckpoint = System.nanoTime();
    }
    // input
    var inputMIDModel = inputsByName.get(Reduce.IN_MID);
    var accumulatorOperatorType = (Operator) genericsByName.get(Reduce.GENERIC_OPERATORTYPE);
    var instanceMID = outputMIDsByName.get(Reduce.OUT_MID);

    // loop until reduction is no longer possible, reducing one input at a time
    var prevPreference = MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED, "false");
    var reducedMID = this.reduce(inputMIDModel, accumulatorOperatorType);
    MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED, prevPreference);

    // output
    var reducedMIDModelPath = FileUtils.getUniquePath(
      FileUtils.replaceFileNameInPath(inputMIDModel.getUri(), Reduce.REDUCED_MID_NAME), true, false);
    var reducedMIDModel = MIDTypeRegistry.getMIDModelType().createInstanceAndEditor(
      reducedMID, reducedMIDModelPath, instanceMID);
    var outputsByName = new HashMap<String, Model>();
    outputsByName.put(Reduce.OUT_MID, reducedMIDModel);
    if (this.timeOverheadEnabled) {
      this.timeOverhead += System.nanoTime() - this.timeCheckpoint;
      writeOutputProperties();
    }

    return outputsByName;
  }

}
