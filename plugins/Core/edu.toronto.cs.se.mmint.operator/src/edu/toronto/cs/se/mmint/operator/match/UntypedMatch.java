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
package edu.toronto.cs.se.mmint.operator.match;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class UntypedMatch extends RandomOperatorImpl {
  protected String matchOn;
  protected In in;
  protected Out out;

  public static class In {
    private final static String MODEL1 = "model1";
    private final static String MODEL2 = "model2";
    private final static String PROP_MATCHON = "matchOn";
    private final static String PROP_MATCHON_DEFAULT = "name";
    public Model model1;
    public Model model2;

    public In(Map<String, Model> inputsByName) {
      this.model1 = inputsByName.get(In.MODEL1);
      this.model2 = inputsByName.get(In.MODEL2);
      if (this.model1.getUri().equals(this.model2.getUri())) {
        throw new IllegalArgumentException();
      }
    }
  }

  public static class Out {
    private static final String MATCH_SEPARATOR = "_";
    private final static String MODELREL = "overlap";
    public ModelRel modelRelType;
    public ModelEndpoint modelTypeEndpoint;
    public Mapping mappingType;
    public ModelElementEndpoint modelElemTypeEndpoint;
    public ModelRel overlap;

    public Out(In in, ModelRel modelRelType, Map<String, MID> outputMIDsByName) throws Exception {
      var overlapName = in.model1.getName() + Out.MATCH_SEPARATOR + in.model2.getName();
      var overlapMID = outputMIDsByName.get(Out.MODELREL);
      this.modelRelType = modelRelType;
      this.modelTypeEndpoint = this.modelRelType.getModelEndpoints().get(0);
      this.mappingType = this.modelRelType.getMappings().get(0);
      this.modelElemTypeEndpoint = this.mappingType.getModelElemEndpoints().get(0);
      this.overlap = (ModelRel) this.modelRelType.createInstance(null, overlapName, overlapMID);
    }

    public Map<String, Model> packed() {
      return Map.of(Out.MODELREL, this.overlap);
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
      var in = new In(inputsByName);
      return Map.of((ModelRel) outputsByName.get(Out.MODELREL), List.of(in.model1, in.model2));
    }
  }

  @Override
  public boolean isCommutative() {
    return true;
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.matchOn = MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, In.PROP_MATCHON,
                                                                In.PROP_MATCHON_DEFAULT);
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new In(inputsByName);
    this.out = new Out(this.in, MIDTypeHierarchy.getRootModelRelType(), outputMIDsByName);
  }

  protected void matchAttributes(Model model, Map<String, Set<EObject>> modelObjAttrs,
                                 Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {
    var newModelEndpointRef = this.out.modelTypeEndpoint.createInstance(model, this.out.overlap);
    var modelRootObj = model.getEMFInstanceRoot();
    for (var iter = modelRootObj.eAllContents(); iter.hasNext();) {
      var modelObj = iter.next();
      Object modelObjAttr = null;
      try {
        modelObjAttr = switch (this.matchOn) {
          case "eClass" -> modelObj.eClass().getName();
          default -> FileUtils.getModelObjectFeature(modelObj, this.matchOn);
        };
      }
      catch (MMINTException e) {
        // modelObjAttr = null
      }
      if (modelObjAttr == null || !(modelObjAttr instanceof String modelObjStr)) {
        // matchOn attribute not good for matching
        continue;
      }
      modelObjAttrs.computeIfAbsent(modelObjStr, k -> new HashSet<>()).add(modelObj);
      modelObjTable.put(modelObj, newModelEndpointRef);
    }
  }

  protected void createMatchMappings(Map<String, Set<EObject>> modelObjAttrs,
                                     Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {
    for (var entry : modelObjAttrs.entrySet()) {
      var modelObjs = entry.getValue();
      if (modelObjs.size() < 2) {
        continue;
      }
      var matchMappingRef = this.out.mappingType.createInstanceAndReference(false, this.out.overlap);
      matchMappingRef.getObject().setName(entry.getKey());
      for (var modelObj : modelObjs) {
        var matchModelElemRef = modelObjTable.get(modelObj).createModelElementInstanceAndReference(modelObj, null);
        this.out.modelElemTypeEndpoint.createInstanceAndReference(matchModelElemRef, matchMappingRef);
      }
    }
  }

  protected void match() throws MMINTException {
    var modelObjAttrs = new HashMap<String, Set<EObject>>();
    var modelObjTable = new HashMap<EObject, ModelEndpointReference>();
    matchAttributes(this.in.model1, modelObjAttrs, modelObjTable);
    matchAttributes(this.in.model2, modelObjAttrs, modelObjTable);
    createMatchMappings(modelObjAttrs, modelObjTable);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    match();

    return this.out.packed();
  }
}
