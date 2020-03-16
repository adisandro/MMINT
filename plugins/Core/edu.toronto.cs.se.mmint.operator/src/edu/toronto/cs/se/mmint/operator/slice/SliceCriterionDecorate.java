/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.slice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

//TODO MMINT[OPERATOR] Use this operator as a starting point to automate boiler code
public class SliceCriterionDecorate extends OperatorImpl {

  private Input input;
  private Output output;

  private static class Input {

    private final static @NonNull String IN_MODELREL = "criterion";
    private ModelRel critRel;
    private Model model;

    public Input(@NonNull Map<String, Model> inputsByName) {

      this.critRel = (ModelRel) inputsByName.get(Input.IN_MODELREL);
      if (this.critRel.getModelEndpoints().size() > 1) {
        // critRel must be unary
        throw new IllegalArgumentException();
      }
      if (this.critRel.getMappingRefs().size() > 0) {
        // critRel must be unary
        throw new IllegalArgumentException();
      }
      this.model = this.critRel.getModelEndpoints().get(0).getTarget();
    }
  }

  private static class Output {

    private final static @NonNull String OUT_MODELREL = "decorated";
    private final static @NonNull String OUT_SUFFIX = "_dec";
    private ModelRel decRel;
    private MID mid;

    public Output(@NonNull Map<String, MID> outputMIDsByName) {

      this.mid = outputMIDsByName.get(Output.OUT_MODELREL);
    }

    public @NonNull Map<String, Model> packed() {

      Map<String, Model> outputsByName = new HashMap<>();
      outputsByName.put(Output.OUT_MODELREL, this.decRel);

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
      Input input = new Input(inputsByName);
      ModelRel decRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL);
      Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
      List<Model> endpointModels = new ArrayList<>();
      endpointModels.add(input.model);
      validOutputs.put(decRel, endpointModels);

      return validOutputs;
    }
  }

  private void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, MID> outputMIDsByName) {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
  }

  private void decorate() throws MMINTException {
    this.output.decRel = this.input.critRel.getMetatype()
      .createInstanceAndEndpoints(null, this.input.critRel.getName() + Output.OUT_SUFFIX,
                    ECollections.asEList(this.input.model), this.output.mid);
    // get EMF model resource
    URI modelURI = FileUtils.createEMFUri(this.input.model.getUri(), true);
    Resource modelRes = new ResourceSetImpl().getResource(modelURI, true);
    // decorate
    ModelEndpointReference decModelEndpointRef = this.output.decRel.getModelEndpointRefs().get(0);
    for (ModelElementReference critModelElemRef : this.input.critRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
      EObject critModelObj = critModelElemRef.getObject().getEMFInstanceObject(modelRes);
      ModelElementReference decModelElemRef = decModelEndpointRef.createModelElementInstanceAndReference(
                            critModelObj, critModelElemRef.getObject().getName());
      MappingReference decMappingRef = MIDTypeHierarchy.getRootMappingType()
        .createInstanceAndReferenceAndEndpointsAndReferences(false, ECollections.asEList(decModelElemRef));
      decMappingRef.getObject().setName(this.input.model.getName() + "." + critModelElemRef.getObject().getName());
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    decorate();

    return this.output.packed();
  }

}
