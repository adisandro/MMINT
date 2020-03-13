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

import java.util.ArrayList;
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
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * Performs a slice on a model instance starting from a slicing criterion, which is a unary model relation containing the
 * initial model elements to slice, and propagating to other impacted model elements following a set of rules.
 */
public class Slice extends OperatorImpl {

  private Input input;
  private Output output;

  private static class Input {

    private final static @NonNull String IN_MODELREL = "criterion";
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

    private final static @NonNull String OUT_MODELREL = "slice";
    private ModelRel sliceRel;
    private MID mid;

    public Output(@NonNull Map<String, MID> outputMIDsByName) {
      this.mid = outputMIDsByName.get(Output.OUT_MODELREL);
    }

    public @NonNull Map<String, Model> packed() {
      var outputsByName = new HashMap<String, Model>();
      outputsByName.put(Output.OUT_MODELREL, this.sliceRel);
      return outputsByName;
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {

    @Override
    public boolean isAllowedInput(@NonNull Map<String, Model> inputsByName) {
      try {
        new Input(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }

    @Override
    public @NonNull Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(
                                                 @NonNull Map<String, Model> inputsByName,
                                                 @NonNull Map<String, Model> outputsByName) {
      var input = new Input(inputsByName);
      var sliceRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL);
      var validOutputs = new HashMap<ModelRel, List<Model>>();
      var endpointModels = new ArrayList<Model>();
      endpointModels.add(input.model);
      validOutputs.put(sliceRel, endpointModels);
      return validOutputs;
    }
  }

  private void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, MID> outputMIDsByName) {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
  }

  /**
   * Gets the sliced model objects by applying the impact rules once, starting from a model object.
   *
   * @param modelObj
   *          The initial model object.
   * @param alreadyImpacted
   *          A set of model objects that are already part of the slice.
   * @return The set of sliced model objects.
   */
  protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {
    // only rule: contained model objects are impacted
    return modelObj.eContents().stream()
      .filter(modelObj2 -> !alreadyImpacted.contains(modelObj2))
      .collect(Collectors.toSet());
  }

  /**
   * Gets all sliced model objects recursively, starting from a model object that is part of the input slice criterion
   * and following the impact rules.
   *
   * @param critModelObj
   *          The initial model object, part of the slice criterion.
   * @param alreadyImpacted
   *          A set of model objects that are already part of the slice.
   * @return The sliced model objects, grouped in subsets by the model object that triggered a slice rule.
   */
  protected Map<EObject, Set<EObject>> getAllImpactedElements(EObject critModelObj, Set<EObject> alreadyImpacted) {
    var impacted = new HashMap<EObject, Set<EObject>>();
    var impactedCur = new HashSet<EObject>();
    impactedCur.add(critModelObj);
    alreadyImpacted.add(critModelObj);

    // Iterate through the current set of newly added model elements
    // to identify all others that may be potentially impacted.
    while (!impactedCur.isEmpty()) {
      var impactedNext = new HashSet<EObject>();
      for (var modelObj : impactedCur) {
        // Get all model elements directly impacted by the current
        // one without adding duplicates.
        var impactedModelObjs = getDirectlyImpactedElements(modelObj, alreadyImpacted);
        impactedNext.addAll(impactedModelObjs);
        alreadyImpacted.addAll(impactedModelObjs);
        impacted.put(modelObj, impactedModelObjs);
      }
      // Prepare for next iteration.
      impactedCur = impactedNext;
    }
    // add criterion element to final results
    impacted.get(critModelObj).add(critModelObj);

    return impacted;
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
    var impacted = new HashSet<EObject>();
    for (var critModelElemRef : critModelEndpointRef.getModelElemRefs()) {
      try {
        var critModelObj = critModelElemRef.getObject().getEMFInstanceObject(r);
        String prevImpacterName = null;
        if (critModelElemRef.getModelElemEndpointRefs().size() == 1) { // criterion with info about previous slice steps
          prevImpacterName = ((MappingReference) critModelElemRef.getModelElemEndpointRefs().get(0).eContainer())
                               .getObject().getName();
        }
        // add impacted elements to the output model relation
        var impactedFromCrit = getAllImpactedElements(critModelObj, impacted);
        for (var impactedFromCritEntry : impactedFromCrit.entrySet()) {
          var impacter = impactedFromCritEntry.getKey();
          var impacterEInfo = MIDRegistry.getModelElementEMFInfo(impacter, MIDLevel.INSTANCES);
          var impacterName = MIDRegistry.getModelElementName(impacterEInfo, impacter, MIDLevel.INSTANCES);
          for (var impactee : impactedFromCritEntry.getValue()) {
            try {
              var impModelElemRef = sliceModelEndpointRef.createModelElementInstanceAndReference(impactee, null);
              var impMappingRef = MIDTypeHierarchy.getRootMappingType()
                                                  .createInstanceAndReferenceAndEndpointsAndReferences(
                                                    false, ECollections.asEList(impModelElemRef));
              if (impactee == critModelObj && prevImpacterName != null) {
                impMappingRef.getObject().setName(prevImpacterName);
              }
              else {
                impMappingRef.getObject().setName(this.input.model.getName() + "." + impacterName);
              }

            }
            catch (MMINTException e) {
              MMINTException.print(IStatus.WARNING, "Skipping slice model element " + impactee, e);
            }
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