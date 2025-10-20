/*******************************************************************************
 * Copyright (c) 2012, 2025 Alessio Di Sandro.
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
import org.eclipse.jdt.annotation.Nullable;

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
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class UntypedMatch extends RandomOperatorImpl {
  protected final static String ATTR_ECLASS = "eClass";
  protected UntypedIn in;
  protected UntypedOut out;
  protected String matchOn;

  public static class UntypedIn {
    private final static String MODEL1 = "model1";
    private final static String MODEL2 = "model2";
    private final static String PROP_MATCHON = "matchOn";
    private final static String PROP_MATCHON_DEFAULT = "name";
    public Model model1;
    public Model model2;

    public UntypedIn(Map<String, Model> inputsByName) {
      this.model1 = inputsByName.get(UntypedIn.MODEL1);
      this.model2 = inputsByName.get(UntypedIn.MODEL2);
      if (this.model1.getUri().equals(this.model2.getUri())) {
        throw new IllegalArgumentException();
      }
    }
  }

  public static class UntypedOut {
    private static final String MATCH_SEPARATOR = "_";
    private final static String MODELREL = "overlap";
    public ModelRel modelRelType;
    public ModelEndpoint modelTypeEndpoint;
    public Mapping mappingType;
    public ModelElementEndpoint modelElemTypeEndpoint;
    public ModelRel overlap;

    public UntypedOut(UntypedIn in, ModelRel modelRelType, Map<String, MID> outputMIDsByName) throws Exception {
      var overlapName = in.model1.getName() + UntypedOut.MATCH_SEPARATOR + in.model2.getName();
      var overlapMID = outputMIDsByName.get(UntypedOut.MODELREL);
      this.modelRelType = modelRelType;
      this.modelTypeEndpoint = this.modelRelType.getModelEndpoints().get(0);
      this.mappingType = this.modelRelType.getMappings().get(0);
      this.modelElemTypeEndpoint = this.mappingType.getModelElemEndpoints().get(0);
      this.overlap = (ModelRel) this.modelRelType.createInstance(null, overlapName, overlapMID);
    }

    public Map<String, Model> packed() {
      return Map.of(UntypedOut.MODELREL, this.overlap);
    }
  }

  public static class UntypedConstraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new UntypedIn(inputsByName);
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
      var in = new UntypedIn(inputsByName);
      return Map.of((ModelRel) outputsByName.get(UntypedOut.MODELREL), List.of(in.model1, in.model2));
    }
  }

  @Override
  public boolean isCommutative() {
    return true;
  }

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    this.matchOn = MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, UntypedIn.PROP_MATCHON,
                                                                UntypedIn.PROP_MATCHON_DEFAULT);
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new UntypedIn(inputsByName);
    this.out = new UntypedOut(this.in, MIDTypeHierarchy.getRootModelRelType(), outputMIDsByName);
  }

  protected @Nullable Object getMatchAttributeValue(EObject modelObj) {
    try {
      return switch (this.matchOn) {
        case ATTR_ECLASS -> modelObj.eClass().getName();
        default -> FileUtils.getModelObjectFeature(modelObj, this.matchOn);
      };
    }
    catch (MMINTException e) {
      return null;
    }
  }

  protected Map<String, Set<EObject>> matchModelElements(Model model) throws MMINTException {
    var modelObjAttrs = new HashMap<String, Set<EObject>>();
    this.out.modelTypeEndpoint.createInstance(model, this.out.overlap);
    for (var iter = model.getEMFInstanceRoot().eAllContents(); iter.hasNext();) {
      var modelObj = iter.next();
      var attrValue = getMatchAttributeValue(modelObj);
      if (attrValue == null || !(attrValue instanceof String attrStr)) {
        // matchOn attribute not good for matching
        continue;
      }
      modelObjAttrs.computeIfAbsent(attrStr, k -> new HashSet<>()).add(modelObj);
    }

    return modelObjAttrs;
  }

  protected void filterMatches(Map<String, Set<EObject>> modelObjAttrs1, Map<String, Set<EObject>> modelObjAttrs2) {
    // do nothing
  }

  protected void createMatchMapping(Set<EObject> modelObjs1, Set<EObject> modelObjs2, String mappingName)
                                   throws MMINTException {
    // mappings are potentially n-ary, with more than one model element on either side of the overlap
    var matchMappingRef = this.out.mappingType.createInstanceAndReference(false, this.out.overlap);
    matchMappingRef.getObject().setName(mappingName);
    var matchModelEndpointRef = this.out.overlap.getModelEndpointRefs().get(0);
    for (var modelObj1 : modelObjs1) {
      var matchModelElemRef = matchModelEndpointRef.createModelElementInstanceAndReference(modelObj1, null);
      this.out.modelElemTypeEndpoint.createInstanceAndReference(matchModelElemRef, matchMappingRef);
    }
    matchModelEndpointRef = this.out.overlap.getModelEndpointRefs().get(1);
    for (var modelObj2 : modelObjs2) {
      var matchModelElemRef = matchModelEndpointRef.createModelElementInstanceAndReference(modelObj2, null);
      this.out.modelElemTypeEndpoint.createInstanceAndReference(matchModelElemRef, matchMappingRef);
    }
  }

  protected void createMatchMappings(Map<String, Set<EObject>> modelObjAttrs1, Map<String, Set<EObject>> modelObjAttrs2)
                                    throws MMINTException {
    for (var entry1 : modelObjAttrs1.entrySet()) {
      var modelObjs1 = entry1.getValue();
      if (modelObjs1.isEmpty()) {
        continue;
      }
      var attrValue = entry1.getKey();
      var modelObjs2 = modelObjAttrs2.get(attrValue);
      if (modelObjs2 == null || modelObjs2.isEmpty()) {
        continue;
      }
      createMatchMapping(modelObjs1, modelObjs2, attrValue);
    }
  }

  protected void match() throws MMINTException {
    var modelObjAttrs1 = matchModelElements(this.in.model1);
    var modelObjAttrs2 = matchModelElements(this.in.model2);
    filterMatches(modelObjAttrs1, modelObjAttrs2);
    createMatchMappings(modelObjAttrs1, modelObjAttrs2);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    match();

    return this.out.packed();
  }
}
