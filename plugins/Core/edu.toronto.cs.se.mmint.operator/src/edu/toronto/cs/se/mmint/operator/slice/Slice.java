/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 *  Nick Fung - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.slice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * Performs a slice on a model instance starting from a slicing criterion, which is a unary model relation containing
 * the initial model elements to slice, and propagating to other model elements following a set of rules.
 */
public class Slice extends OperatorImpl {

  private Input input;
  private Output output;
  private Mapping addType;
  private Mapping delType;
  private Mapping modType;
  private Mapping reviseType;
  private Mapping recheckContentType;
  private Mapping recheckStateType;

  private static class Input {
    private final static String IN_MODELREL = "criterion";
    private ModelRel critRel;
    private Model model;

    public Input(Map<String, Model> inputsByName) {
      this.critRel = (ModelRel) inputsByName.get(Input.IN_MODELREL);
      if (this.critRel.getModelEndpoints().size() > 1) { // critRel must be unary
        throw new IllegalArgumentException();
      }
      this.model = this.critRel.getModelEndpoints().get(0).getTarget();
    }
  }

  private static class Output {
    private final static String OUT_MODELREL = "slice";
    private ModelRel sliceRel;
    private MID mid;

    public Output(Map<String, MID> outputMIDsByName) {
      this.mid = outputMIDsByName.get(Output.OUT_MODELREL);
    }

    public Map<String, Model> packed() {
      var outputsByName = new HashMap<String, Model>();
      outputsByName.put(Output.OUT_MODELREL, this.sliceRel);
      return outputsByName;
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean isAllowedInput(Map<String, Model> inputsByName) {
      try {
        new Input(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }

    @Override
    public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, Model> inputsByName,
                                                                        Map<String, Model> outputsByName) {
      var input = new Input(inputsByName);
      var sliceRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL);
      return Map.of(sliceRel, List.of(input.model));
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
    this.addType = MIDTypeRegistry.getType("http://se.cs.toronto.edu/mmint/SliceRel/Add");
    this.delType = MIDTypeRegistry.getType("http://se.cs.toronto.edu/mmint/SliceRel/Del");
    this.modType = MIDTypeRegistry.getType("http://se.cs.toronto.edu/mmint/SliceRel/Mod");
    this.reviseType = MIDTypeRegistry.getType("http://se.cs.toronto.edu/mmint/SliceRel/Revise");
    this.recheckContentType = MIDTypeRegistry.getType("http://se.cs.toronto.edu/mmint/SliceRel/RecheckContent");
    this.recheckStateType = MIDTypeRegistry.getType("http://se.cs.toronto.edu/mmint/SliceRel/RecheckState");
    if (this.addType == null || this.delType == null || this.modType == null || this.reviseType == null ||
        this.recheckContentType == null || this.recheckStateType == null) {
      throw new MMINTException("The SliceRel mapping types are missing");
    }
  }

  /**
   * Gets model objects sliced by applying the rules to a single model object.
   *
   * @param modelObj
   *          The model object to apply the slicing rules to.
   * @param alreadySliced
   *          A set of model objects that are already part of the slice.
   * @return The set of sliced model objects.
   */
  protected Set<EObject> getDirectlySlicedElements(EObject modelObj, Set<EObject> alreadySliced) {
    // only rule: contained model objects are sliced
    return modelObj.eContents().stream()
      .filter(modelObj2 -> !alreadySliced.contains(modelObj2))
      .collect(Collectors.toSet());
  }

  /**
   * Gets all sliced model objects recursively, starting from a model object that is part of the input slice criterion
   * and following the slicing rules.
   *
   * @param critModelObj
   *          The starting model object, part of the slice criterion.
   * @param alreadySliced
   *          A set of model objects that are already part of the slice.
   * @return The sliced model objects as keys, and the model object that caused them to be sliced as values.
   */
  protected Map<EObject, EObject> getAllSlicedElements(EObject critModelObj, Set<EObject> alreadySliced) {
    var sliced = new HashMap<EObject, EObject>();
    var slicedCur = new HashSet<EObject>();
    sliced.put(critModelObj, null);
    alreadySliced.add(critModelObj);
    slicedCur.add(critModelObj);

    // iterate through the current set of newly sliced model elements
    // to identify the next ones that are going to be sliced
    while (!slicedCur.isEmpty()) {
      var slicedNext = new HashSet<EObject>();
      for (var modelObj : slicedCur) {
        // get all model elements directly sliced by the current one without adding duplicates
        var slicedModelObjs = getDirectlySlicedElements(modelObj, alreadySliced);
        slicedModelObjs.stream().forEach(s -> sliced.put(s, modelObj));
        slicedNext.addAll(slicedModelObjs);
        alreadySliced.addAll(slicedModelObjs);
      }
      // prepare for next iteration
      slicedCur = slicedNext;
    }

    return sliced;
  }

  protected void slice() throws MMINTException {
    this.output.sliceRel = this.input.critRel.getMetatype()
      .createInstanceAndEndpoints(null, Output.OUT_MODELREL, ECollections.asEList(this.input.model), this.output.mid);
    var sliceModelEndpointRef = this.output.sliceRel.getModelEndpointRefs().get(0);

    // retrieve resource corresponding to the model instance
    var critModelEndpointRef = this.input.critRel.getModelEndpointRefs().get(0);
    var rUri = FileUtils.createEMFUri(critModelEndpointRef.getTargetUri(), true);
    var rs = new ResourceSetImpl();
    var r = rs.getResource(rUri, true);

    // loop through the model objects in the input criterion
    var sliced = new HashSet<EObject>();
    for (var critModelElemRef : critModelEndpointRef.getModelElemRefs()) {
      try {
        var critModelObj = critModelElemRef.getObject().getEMFInstanceObject(r);
        String prevSlicerName = null;
        if (critModelElemRef.getModelElemEndpointRefs().size() == 1) { // criterion with info about previous slice steps
          prevSlicerName = ((MappingReference) critModelElemRef.getModelElemEndpointRefs().get(0).eContainer())
                                                               .getObject().getName();
        }
        // add sliced elements to the output model relation
        var slicedFromCrit = getAllSlicedElements(critModelObj, sliced);
        for (var slicedFromCritEntry : slicedFromCrit.entrySet()) {
          var slicee = slicedFromCritEntry.getKey();
          var slicer = slicedFromCritEntry.getValue();
          try {
            var sliceModelElemRef = sliceModelEndpointRef.createModelElementInstanceAndReference(slicee, null);
            var sliceMappingRef = this.reviseType.createInstanceAndReferenceAndEndpointsAndReferences(
                                                    false, ECollections.asEList(sliceModelElemRef));
            String slicerName = null;
            if (slicer == null) { // slicee == critModelObj
              slicerName = (prevSlicerName == null) ?
                this.input.model.getName() + "." + critModelElemRef.getObject().getName() :
                prevSlicerName;
            }
            else {
              var slicerEInfo = MIDRegistry.getModelElementEMFInfo(slicer, MIDLevel.INSTANCES);
              slicerName = this.input.model.getName() + "." +
                           MIDRegistry.getModelElementName(slicerEInfo, slicer, MIDLevel.INSTANCES);
            }
            sliceMappingRef.getObject().setName(slicerName);
          }
          catch (MMINTException e) {
            MMINTException.print(IStatus.WARNING, "Skipping sliced model element " + slicee, e);
          }
        }
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.WARNING,
                             "Skipping criterion model element " + critModelElemRef.getObject().getName(), e);
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    slice();
    return this.output.packed();
  }
}